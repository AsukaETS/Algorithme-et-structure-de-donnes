class Ville extends Commune {

   private String monument ;

   Ville (int nbH, double S, String m) {
      super (nbH, S) ;
      this.monument = m ;
   }
   
   public double ratio () {
      System.out.println ("Le ratio via la classe Ville") ;
      return super.ratio() ;
   }
}