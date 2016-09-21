package TD2.TP2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*; // Pour pouvoir utiliser les fichiers
   


public class Fenetre extends JFrame implements ActionListener 
{
        
    private JPanel zoneDessin;            // zone de dessin central ou on va dessiner
    private JPanel p1;                    // zone boutons hauts
    private JPanel p2;                    // zone boutons bas  
    
    private Image im;
        
                                          // Structure de donn�es ici
	 
    
// CONSTRUCTEUR 
    
    public Fenetre(String titre, int largeur, int hauteur) 
    {
        super(titre);
        
        //Rappel pour charger une image 
        //try{
        //    im = ImageIO.read(new File("toto.jpg");
        // }
        // catch( IOException ex ) {ex.printStackTrace();} 
                
                
        getContentPane().setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
                           
        mise_en_page( largeur, hauteur );    // on place les boutons et la zone de dessin ...
        
        	
              
        repaint();        
    }
    
// la fenetre est constitu�e de trois parties Panel Nord : boutons ; Sud : boutons; Centre: zone de zoneDessin
    public void mise_en_page(int maxX, int maxY) 
    {
        //--------------------------------------------------------------------
        // insertion boutons du haut
        this.p1 = new JPanel(new GridLayout());
        ajouteBouton("Suivant", p1);
           	  
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
   
    // Accesseur au zoneDessin de la fen�tre
    public Graphics getzoneDessin() {
        return this.zoneDessin.getGraphics();
    }
    
    // Proc�dure d'arr�t
    void quitter() {
        System.exit(0);
    }
    
    
    void effacer() {
        Graphics g = this.zoneDessin.getGraphics(); 
        g.setColor( Color.WHITE );
        g.fillRect(0,0,this.getWidth(),this.getHeight() );
    }
    
    private void ajouteBouton(String label, JPanel p) {
        // Ajoute un bouton, avec le texte label, au panneau p
        JButton b = new JButton(label);
        p.add(b);
        b.addActionListener(this);
    } 
    
       
    public void paint(Graphics g)  // dessin de la fen�tre g�n�rale
    {
         this.p1.repaint();  // on redessine les boutons hauts
         this.p2.repaint();  // on redessine les boutons bas
            
         g= this.zoneDessin.getGraphics(); // on redessine dans le panel de dessin
         
         effacer();
         // c'est ici qu'il faut mettre les elements � afficher
                 
         Font StyleLesTitres = new Font("TimesRoman",Font.BOLD,18); // trois styles d'ecriture
			Font StyleMoyen = new Font("TimesRoman", Font.ITALIC,14);
			Font StyleNormal = new Font("TimesRoman", Font.PLAIN,12);

			 // Afficher l'affiche
			g.setFont(StyleLesTitres);
			// Afficher le titre
			g.setFont(StyleMoyen);
			// Afficher le texte
			g.setFont(StyleNormal);
			// Afficher les exemplaires puis les emprunts
					
         
    
    }
    
    // GESTION DES ACTIONS SUITE A UN APPUIS SUR BOUTON : cette methode est declench�e si Un bouton quelconque est appuy�
    public void actionPerformed(ActionEvent e)  // on associe l'evenement souris sur bouton avec l'execution d'un sous prg
	 {
      String c = e.getActionCommand();     // on capte l'evenement : nom du bouton !
      	
      if (c.equals("Quitter")) quitter();		
		  										
	   if (c.equals("Suivant")) 
      {
         
      };
      
      
      repaint();	       
    } 
    
   
}

