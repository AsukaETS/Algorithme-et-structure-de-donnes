package TD2.TP2;
 

public class TestDVD{
   
     
//--------- programme principal à partir duquel tout demarre ... ----------------------
   public static void main(String[]	args)
   {
      UnDVD d1 = new UnDVD("SAW", "affiche1", "En fait le méchant c'est le cadavre au millieu de la pièce", 3) ;
      UnDVD d2 = new UnDVD ("La planète des singes", "affiche2", "En fait à la fin il était revenu sur Terre depuis le début", 10) ;
      UnDVD d3 = new UnDVD ("Psychose","affiche3", "En fait à la fin, Norman Bates, le gérant du motel et sa mère sont la même personne", 6) ;
      UnDVD d4 = new UnDVD ("Sixième sens", "affiche4", "En fait à la fin on se rend compte qu'il est mort depuis le début", 2) ;
      
      d1.setEmprunt() ;
      d1.setEmprunt() ;
      d1.setEmprunt() ;
      d1.setEmprunt() ;
   
      d1.Afficher() ;
      d2.Afficher() ;
      d3.Afficher() ;
      d4.Afficher() ;
      
      d1.setRetour() ;
      
      d1.Afficher() ;
   
   }
    
      	
      
}
