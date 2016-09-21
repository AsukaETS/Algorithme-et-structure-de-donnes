package TD2.TP2;

import java.io.*;

 

public class TestVideotheque{
   
     
//--------- programme principal � partir duquel tout demarre ... ----------------------
   public static void main(String[]	args)
   {
   
      Videotheque v1 = new Videotheque() ;
      UnDVD d1 = new UnDVD("SAW", "affiche1", "En fait le m�chant c'est le cadavre au millieu de la pi�ce", 3) ;
      UnDVD d2 = new UnDVD ("La plan�te des singes", "affiche2", "En fait � la fin il �tait revenu sur Terre depuis le d�but", 10) ;
      UnDVD d3 = new UnDVD ("Psychose","affiche3", "En fait � la fin, Norman Bates, le g�rant du motel et sa m�re sont la m�me personne", 6) ;
      UnDVD d4 = new UnDVD ("Sixi�me sens", "affiche4", "En fait � la fin on se rend compte qu'il est mort depuis le d�but", 2) ;
      v1.Ajouter(d1);
      v1.Ajouter(d2);
      v1.Ajouter(d3) ;
      v1.Ajouter(d4) ;
      v1.Supprimer();
      System.out.println("Nombre de films : "+v1.NbFilms()+"\n");
      v1.Reset();
      v1.Ajouter(d1);
      v1.Ajouter(d2);
      v1.Ajouter(d3) ;
      v1.Ajouter(d4) ;
      System.out.println ("Le DVD choisi est : ") ;
      v1.getDVD().Afficher() ;
      v1.Suivant();
      System.out.println("    ");
      v1.getDVD().Afficher();
      v1.Emprunter();
      System.out.println("    ");
      v1.getDVD().Afficher();
      v1.Emprunter();
      System.out.println("    ");
      v1.getDVD().Afficher();
      v1.Emprunter();
      System.out.println("    ");
      v1.getDVD().Afficher();
      v1.Emprunter();
      System.out.println("    ");
      v1.getDVD().Afficher();
      v1.Rendre();
      System.out.println("    ");
      v1.getDVD().Afficher();
   
   
   
   
   
   //       Exemple de chargement dans une videotheque
   
   //       try{
   // 		    maVideo.Chargement("ListeDVD.txt");		
   // 		}
   // 		catch (IOException e)
   // 		{
   // 	  		System.out.println("probl�me de fichier par exception");
   // 	 	}
   	
     
   }
    
      	
      
}
