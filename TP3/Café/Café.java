import java.util.*;

public class Café
{
	//Declaration des constantes
   public static final int NbPersGroup=6;		// les parametres de simulation
   public static final int DelaiArrivees = 15;
   public static final int DelaiComMini = 2; 
   public static final int DelaiComMaxi = 5;
   public static final int DelaiServMini = 5 ;
   public static final int DelaiServMaxi = 10;
   public static final int DelaiDepMini = 10;
   public static final int DelaiDepMaxi = 30 ;
	 
   public static final int STAT_ARRIVEE = 0 ;	// les statuts
   public static final int STAT_COMMANDE = 1 ;
   public static final int STAT_SERVICE = 2 ;
   public static final int STAT_DEPART = 3 ;

	// variable d'instance	

   private int nbPlaces;
   private String nom;
   private FilePrio FP; 
	

	//Constructeurs
   Café(String n, int nbPlaces)
   {
      this.nom=n;
      this.nbPlaces=nbPlaces;
   }
	
	//Methodes
   public int getNombrePlaces(){ 
      return this.nbPlaces;}
	
   public void ouverture(int nbreGroupe) //Ouverture du café
   {
      FP = new FilePrio();
      for (int i=0; i<nbreGroupe; i++) {
         Groupe Gi = new Groupe((i+1), aleatoire(1,6), 0, aleatoire(1,90)); //Création des groupes
         FP.add(Gi); //Ajout des groupes dans la file 
      }
      FP.Afficher() ;
   }
	
	
   public void gestion()	// programmation de l'automate
   {
      while (FP.size() != 0) {
         Groupe g = FP.get() ;
         switch (g.getStatut()) {
            case 0: //Cas 0 : Le groupe arrive et s'installe
               System.out.println("Arrivée du groupe n°"+g.getNumero()) ;
               if(nbPlaces > g.getNbPers()) { //Si il reste de la place
                  System.out.println("On installe le groupe") ;
                  nbPlaces = nbPlaces - g.getNbPers() ; //Les places prises sont retirées
                  System.out.println("Il reste "+nbPlaces+" places de libre") ; 
                  g.setStatut(1) ; //Incrémentation pour rentrer dans le cas 2
                  int Prio2 = g.getPrio() + aleatoire(2,5) ;
                  g.setPrio(Prio2) ; //Augmentation de la priorité
                  FP.add(g) ; //On remet le groupe dans la file à chaque fin de cas
               }
               else { //Sinon il s'en va 
                  System.out.println("Le groupe s'en va") ;
               }
               break ;
               
            case 1: //Cas 1 le groupe commande
               System.out.println("Commande du groupe n°"+g.getNumero()+" pour "+g.getNbPers()+" personne/s") ;
               g.setStatut(2) ; //Incrémentation 
               int Prio3 = g.getPrio() + aleatoire(5,10) ; //Augmentation
               FP.add(g) ;
               break ;
               
            case 2: //Cas 2 : Le groupe est servi
               System.out.println("Service du groupe n°"+g.getNumero()+" pour "+g.getNbPers()+" personnes/s") ;
               g.setStatut(3) ;
               int Prio4 = g.getPrio() + aleatoire(10,30) ;
               FP.add(g) ;
               break ;
               
            case 3: //Cas 3 : Le groupe s'en va 
               System.out.println("Départ du groupe n°"+g.getNumero()+" libérant "+g.getNbPers()+" place/s" );
               g.setStatut(4) ; //Incrémentation pour qu'il ne retourne pas dans le switch
               nbPlaces = nbPlaces + g.getNbPers() ;
               break ;
         }
         
         
      }
   		
   }	

   public void afficherEvts()
   {
      FP.Afficher();
   }
	
   public void fermeture() {
      int t=0;
      while (t <= 360) { //Tant que le magasin n'est pas fermé, le temps passe 
         t++;
      }
      
      System.out.println("Fermeture du magasin") ;
      if (t == 360) {
         while (FP.size() > 0) { //On vérifie qu'il ne reste personne, si il en reste on les sort
         System.out.println ("On met dehors les retardataires") ;
            FP.get();
         }
      }      
   }
	
		
   private int aleatoire(int min, int max)
   {
      return  min +(int)(Math.random()*(max - min + 1));
   }


}

