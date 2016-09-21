import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.io.*; // Pour pouvoir utiliser les fichiers
   

public class Fenetre extends JFrame implements ActionListener
{
   private static final int DIMLETTRE =28;

    // 3 panneaux constituant la fenêtre    
   private JPanel zoneDessin;            // zone de dessin central ou on va dessiner
   private JPanel p1;                    // zone boutons hauts
   private JPanel p2;                    // zone boutons bas  
    
    // variables de l'application
   private JTextField saisie;            // variable du champs de saisie
   private ArbreBR Dico;     // dictionnaire de tout les mots possibles
   private int  NbMots;
   private HashMap Points;		// correspondance entre lettre et points
   private LinkedList Sac;		// ensemble des lettres du jeux
   private String LettresJoueur= new String();	// lettres du joueur

	//IMPORTANT-------------------------------------
   private ArrayList <Mot> Possibilités;	// resultats de la recherche de l'ordinateur
	//----------------------------------------------
   
   private boolean MotPossible;
   private boolean PossibleAvecTirage=true;
   private String proposition="";  // proposition du joueur
   private int score = 0;
   private int result;	
   private boolean Probleme;
	 
 
// CONSTRUCTEUR 
    
   public Fenetre(String titre, int largeur, int hauteur) 
   {
      super(titre);
         // placer ici l'initialisation de vos structures de données ------------------------------        
      NbMots =0;
      Probleme = false;
      Points = new HashMap();
      Sac = new LinkedList();
      Possibilités = new ArrayList();
      MotPossible = false;
   		
   		
      ChargementPoints();
      ChargementDico();
      ChargementSac();
   		
      TirageAleaLettres();
         
   		//Equilibrage ici ?
   		
         	  
         //----------------------------------------------------------------------------------------
         // Construction de la fenêtre
      getContentPane().setLayout(new BorderLayout());
      setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
                                 
      mise_en_page( largeur, hauteur );   // on place les boutons et la zone de dessin ...
    
      repaint();                           // on dessine l'ensemble     
   }
    

// ASSEMBLAGE PARTIES FENETRE : la fenetre est constituée de trois parties Panel Nord : boutons ; Sud : boutons; Centre: zone de zoneDessin
   public void mise_en_page(int maxX, int maxY) 
   {
        //--------------------------------------------------------------------
        // insertion boutons du haut
      this.p1 = new JPanel(new GridLayout());
        
      saisie = new JTextField(25); 
      p1.add(new JLabel("Saisir un mot : ") );
      p1.add(saisie); 
      ajouteBouton("Proposition", p1);
      ajouteBouton("Mot existe Dico", p1);
      ajouteBouton("Nouveau Tirage", p1);
      ajouteBouton("Solutions Scrabble", p1);
        
      getContentPane().add(p1,"North");  // on ajoute le panel en haut de la fenetre frame
        
        //--------------------------------------------------------------------
        // insertion boutons du bas
      this.p2 = new JPanel(new GridLayout());
      ajouteBouton("Quitter", p2);
   	  
      getContentPane().add(p2,"South");  // on ajoute le panel en bas
        
        //--------------------------------------------------------------------
        // zone de dessin
      this.zoneDessin = new JPanel();
      this.zoneDessin.setSize(maxX,maxY);
      this.zoneDessin.setPreferredSize(new Dimension(maxX,maxY));
      getContentPane().add(this.zoneDessin,"Center");  // panel pour zoneDessiner au milieu
        
        //--------------------------------------------------------------------
   
      pack();
      setVisible(true);
   }

// AFFICHAGE A L ECRAN : tout ce qui est dans le paint() sera à l'ecran   
   public void paint(Graphics g)  // dessin de la fenêtre générale
   {
      this.p1.repaint();  // on redessine les boutons hauts
      this.p2.repaint();  // on redessine les boutons bas
            
      g= this.zoneDessin.getGraphics(); // on redessine dans le panel de dessin
      effacer();
         
      if (Probleme ==true)
      {
         g.drawString("Probleme de chargement...",20,40);
      }
      else
      {
         Font StyleLesTitres = new Font("TimesRoman",Font.BOLD,18); // trois styles d'ecriture
         Font StyleMoyen = new Font("TimesRoman", Font.ITALIC,14);
         Font StyleNormal = new Font("TimesRoman", Font.PLAIN,12);
      
      	//g.drawImage(im, 0, 0, 150,235, this);  // l'affiche
         g.setFont(StyleLesTitres);
         AffichePions("Jeu du scrabble",300,70,g);
         g.drawString("Nb mots dans dico :"+NbMots,1000,70);		// le titre
         g.drawString("Nb lettres dans le sac : "+Sac.size(),1000,90);
      	//AffichePoints(1000,130,g);
         g.drawString("Le score du joueur est : "+score,150,150);
         g.drawString("Lettres du joueur :",150,190);
         AffichePions(LettresJoueur,300,170,g);
         g.setColor(Color.red);
         if (ScrabblePossible(LettresJoueur, Dico))
            g.drawString("Scrabble possible", 530,200);
         else
            g.drawString("Scrabble impossible", 530,200);
         g.setColor(Color.black);
      
         for( int i=0 ; i< Possibilités.size(); i++ )   // affiche les possibiltés
         {
            AffichePions(Possibilités.get(i).getMot() ,200,290+i*40,g);
            g.drawString(CalculScore(((Mot)Possibilités.get(i)).getMot())+" pts",150,310+i*40);
         }	
      
      	// affiche si le mot proposé existe
         if (MotPossible) g.drawString("Ce mot est dans le dictionnaire", 700,270);
         if (!PossibleAvecTirage) g.drawString("Ce mot ne peut pas être construit avec le tirage",700, 320);
      	
      }
   }

       
   public void elagueParScore (){
   	
   		
   }
	
   public void elagueParLongueur ()
   {
      if(!Possibilités.isEmpty()) {
         int maxi = this.Possibilités.get(0).getMot().length();
         ArrayList Terminal = new ArrayList();
         for (int i = 0; i < this.Possibilités.size(); i++) {
            if (this.Possibilités.get(i).getMot().length() < 8 && this.Possibilités.get(i).getMot().length() > maxi) {
               maxi = this.Possibilités.get(i).getMot().length();
            }
         }
         for (int i = 0; i < this.Possibilités.size(); i++) {
            if (this.Possibilités.get(i).getMot().length() == maxi) {
               Terminal.add(this.Possibilités.get(i));
               System.out.println(this.Possibilités.get(i));
            }
         }
         Possibilités = Terminal;
      }
   }

   public void RechercheSolutions(String St, ArbreBR A)
   {
      if (!St.equals("")) {
         if ((A.getRacine().getMot().length() <= 7)  && (A.getRacine().MotOK(St))) {
            Possibilités.add(A.getRacine());
         }
         if (!A.getAg().estVide()) {
            RechercheSolutions(St, A.getAg());
         }
         if (!A.getAd().estVide()) {
            RechercheSolutions(St, A.getAd());
         }
      }
   }
   
  /* public void RechercheSolutions (char c, ArbreBR dic) {
   
      if (c == dic.getRacine().getMot().charAt(0)) {
         Possibilités.add(dic.getRacine());
         System.out.println(dic.getRacine().getMot());
      }
      if (!dic.getAg().estVide() && c<dic.getRacine().getMot().charAt(0)){
         RechercheSolutions(c,dic.getAg());
      }
      if (!dic.getAd().estVide() && c>=dic.getRacine().getMot().charAt(0)){
         RechercheSolutions(c,dic.getAd());
      }
   }*/
 
   public boolean ScrabblePossible(String rech, ArbreBR A)
   {
      if (!rech.equals(""))
      {
      	
         return false;
      }
      else 
         return false;	
   }
   public boolean estDans ( char a ){
      for (int i = 0; i<proposition.length();i++){
         if (proposition.charAt(i) == a )
            return true;
      } 
      return false;
   }
	 
	
   public void TirageAleaLettres()
   {  
   
      LettresJoueur ="";				
      int i = 0;
      while (Sac.size()>0 && i< 7 )
      {
         int nbLettreSac = Sac.size();
         char l = (Character) Sac.remove( Aleatoire(0, nbLettreSac-1) );
         LettresJoueur = LettresJoueur+l;
         i++;
      }		
   }


// QUELQUES OUTILS
   
    // Procédure d'arrêt
   void quitter() {
      System.exit(0);
   }
    
    // Effacer le plan de dessin
   void effacer() {
      Graphics g = this.zoneDessin.getGraphics(); 
      g.setColor(Color.white);
      g.fillRect(0,0,this.getWidth(),this.getHeight() );
   }
    
    // Permet d'ajouter un nouveau bouton dans le panel p
   private void ajouteBouton(String label, JPanel p) {
        // Ajoute un bouton, avec le texte label, au panneau p
      JButton b = new JButton(label);
      p.add(b);
      b.addActionListener(this);
   } 
    
       
       
// GESTION DES ACTIONS SUITE A UN APPUIS SUR BOUTON : cette methode est declenchée si Un bouton quelconque est appuyé
   public void actionPerformed(ActionEvent e)  // on associe l'evenement souris sur bouton avec l'execution d'un sous prg
   {
      String arg = e.getActionCommand();     // on capte l'evenement : nom du bouton !
      
      if (arg.equals("Quitter") )
         quitter();
        
      if (arg.equals("Nouveau Tirage") ) 
      {
         Possibilités.clear();
         if (Sac.size() >= 7 ) TirageAleaLettres();	
         MotPossible = false;PossibleAvecTirage =true;
      
      	
      }
      if (arg.equals("Solutions Scrabble") )
      {
         MotPossible = false;PossibleAvecTirage =true;
         Possibilités.clear();			
         RechercheSolutions(LettresJoueur, Dico);
         elagueParLongueur();
      
      }
   
   
      if (arg.equals("Proposition")) {
         proposition =saisie.getText();
         proposition=proposition.toUpperCase();
      	
      
      }
         
      if (arg.equals("Mot existe Dico") )
      {
         Possibilités.clear();PossibleAvecTirage =true;
         String s =saisie.getText();
         s=s.toUpperCase();
         MotPossible =(Dico.rechercherABR(new Mot(s)));
      }
   
      repaint();    
   } 

   public void AffichePions( String s, int x, int y, Graphics g )
   {
      String NomImg="";
      Image im;
      s = s.toUpperCase();
      for( int i=0 ; i<s.length() ; i++)
      {
         if(s.charAt(i)>='A' && s.charAt(i)<='Z')
         {
            NomImg = s.charAt(i)+".jpg";
            try{
               im = ImageIO.read(new File(NomImg));      // on charge une image du disque dur
               g.drawImage(im, x+i*DIMLETTRE+1, y, DIMLETTRE,DIMLETTRE, this);
            }
            catch( IOException e ) {e.printStackTrace();}
           	
         }					
      }	
   }
	
   public void AffichePoints( int x, int y, Graphics g )
   {
      char c='A';
      for( int i=0 ; i<Points.size(); i++)
      {
         if (Points.containsKey( c )){
            int p = (Integer) Points.get(c );
            g.drawString( c+" : "+p , x, y+i*15);
         }
         c++;						
      }	
   
   }
	
   public int CalculScore( String s)
   {
      s = s.toUpperCase();
      int somme = 0;
      for( int i=0 ; i<s.length() ; i++)
      {
         somme = somme + (Integer) Points.get( s.charAt(i));				
      }
   
      if (s.length()==7 ) 
         somme = somme + 20;
   		
      return somme;		
   }
	
	
   private int Aleatoire(int min, int max)
   {
      return  min +(int)(Math.random()*(max - min + 1));
   }

   public void ChargementPoints()
   {
      char Lettre;
      int p;
      try{	  
         FileReader fic = new FileReader("points.txt");  		
      																			
         StreamTokenizer entree = new StreamTokenizer(fic); // on ouvre un stream 	
         entree.quoteChar('"');
         int i =0;
         entree.nextToken() ;
         while ( entree.ttype != entree.TT_EOF ) 			
         {  	  
            Lettre =entree.sval.charAt(0);
            entree.nextToken() ;	
            p = (int)entree.nval;
            Points.put((Character)Lettre, p );
            entree.nextToken() ;					
         }
      }
      catch(Exception e)
      {
         Probleme = true;
      }
   }
	
   public void ChargementSac()
   {
      char Lettre;
      int p;
      Sac.clear();
      try{	  
         FileReader fic = new FileReader("sac.txt");  		
      																			
         StreamTokenizer entree = new StreamTokenizer(fic); // on ouvre un stream 	
         entree.quoteChar('"');
         int i =0;
         entree.nextToken() ;
         while ( entree.ttype != entree.TT_EOF ) 			
         {  	  
            Lettre =entree.sval.charAt(0);
            Sac.add(Lettre);
            entree.nextToken() ;								
         }
      }
      catch(Exception e)
      {
         Probleme = true;
      }
   }

	
	
	
	
   public void ChargementDico()
   {
      String Mot;
      try{	  
         FileReader fic = new FileReader("scrabble.txt");  		
      																			
         StreamTokenizer entree = new StreamTokenizer(fic); 	
         entree.quoteChar('"');
      	
         // lecture des données dans le fichier connaissant le format------------
         int i =0;
         Dico = new ArbreBRVide(); 		
         entree.nextToken() ;
         
         while ( entree.ttype != entree.TT_EOF ) 			
         {  	  
            Dico = Dico.insereTo(new Mot(entree.sval)); 
            NbMots++;					
            entree.nextToken() ;	
         }  // fin while
      }
      catch(Exception e)
      {
         Probleme=true;
      }
   
   }
   
     
}

