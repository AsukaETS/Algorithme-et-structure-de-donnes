package TD2.TP2;

import java.util.* ;

class TD2 {
   public static void main (String[] args) {
   //Cr�ation d'ArrlayList
      ArrayList<Integer> tab = new ArrayList() ;
   //Ajouter 23 et 45 
      tab.add(23) ;
      tab.add(45) ;
   //Ajouter 55 et 8 en d�but de tableau
      tab.add(0,55) ;
      tab.add(0,8) ;
  //Afficher la deuxi�me case du tableau
      System.out.println(tab.get(1)+"\n") ;
  //Enlever 23
      tab.remove(new Integer(23)) ;
  //Afficher tout le tableau
      for (int i = 0; i<tab.size(); i++) {
         System.out.println(tab.get(i)) ;
      }
  //Conna�tre si oui ou non 8 est pr�sent
      System.out.println("\n"+tab.contains(8)) ;
      
      System.out.println("----------------------------------------------") ;
      
      Diapo d1 = new Diapo() ;
      d1.ajouter("Photo 1") ;
      d1.ajouter("Photo 2") ;
      d1.ajouter("Photo 3") ;
      d1.getPhoto() ;
      
      /*
      ArraList fusion (ArrayList al1, ArrayList al2) {
      ArrayList al3 = new ArrayList() ;
      al3.addAll(al1) ;
      + m�thode ins�rer croissant
      
      return al3 ;
      */
   
   }
}