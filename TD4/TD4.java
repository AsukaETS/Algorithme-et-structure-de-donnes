class TD4 {
   public static void main (String[] args) {
      Commune c = new Commune (1000, 20000) ;
      System.out.println("Ratio "+c.ratio()) ;
   
      Ville lr = new Ville (80000, 50000, "Les Tours") ;
      System.out.println("Nombre d'habitants "+lr.getNbH()) ;
      System.out.println ("Ratio "+lr.ratio() ) ;
   }
}