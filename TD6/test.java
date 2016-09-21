class test {
   public static void main (String[] args) {
      Liste L = new ListeCons("A", 
          new ListeCons("B", 
          new ListeCons("C",
          new ListeCons("D",new ListeVide() )
          )
          )
          ) ;
      System.out.println("Afficher le contenu du troisième rang de la liste L") ;
      System.out.println(L.getReste().getReste().getPremier()) ;
      System.out.println(" ") ;
      
      
      System.out.println("B est-il présent dans L ? ") ;
      System.out.println(L.trouver("B")) ;
      System.out.println("E est-il présent dans L ? ") ;
      System.out.println(L.trouver("E")) ;
      System.out.println(" ") ;
      
      
      System.out.println("Placer E à la fin de la liste : ") ;
      Liste L2 = L.placerFin("E") ;
      L2.afficher() ;
      System.out.println(" ") ;

      
      System.out.println ("L1 + L2 = ") ;
      (L.concat(L2)).afficher() ;
      System.out.println(" ") ;
      
      
      System.out.println("Inverser la liste L2 : ") ;
      Liste L3 = L2.inverser() ;
      L3.afficher() ;
      System.out.println(" ") ;
      
      
      System.out.println("Insérer F au rang 3 de la liste L : ") ;
      Liste L4 = L.inserer("F", 3) ;
      L4.afficher() ;
      System.out.println(" ") ;
   
   
   }
}
