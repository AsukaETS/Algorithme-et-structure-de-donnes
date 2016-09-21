abstract class Liste {
   public abstract Liste inferieurs (int s) ;
   public abstract Liste superieurs (int s) ;
   public abstract Liste QS();
   public abstract void listeEnTab(ArrayList T) ;
}
class ListeVide extends Liste {
   public Liste inferieurs (int s) {
      return new ListeVide() ;
   }
   public Liste superieurs (int s) {
      return new ListeVide() ;
   }
   public Liste QS () {
      return new ListeVide() ;
   }
   public void listeEnTab (ArrayList T) {
   
   }

}

class ListeCons extends Liste {

   ListeCons(int s, Liste l) {
      this.valeur = s ;
      this.suiv = l ;
   }
   
   ListeCons(int nb) {
      this.valeur = alea(1,200) ;
      if (nb > 0) {
         this.suiv = new ListeCons(nb-1) ;
      }
      else {
         this.suiv = new ListeVide() ;
      }
   }
   
   public Liste inferieurs (int s) {
      if (this.getPremier() < s) {
         return new ListeCons(this.getPremier(),this.getReste().inferieurs(s)) ;
      }
      else {
         return this.getReste().inferieurs(s) ;
      }
   }
   public Liste superieurs (int s) {
      if (this.getPremier() >= s) {
         return new ListeCons(this.getPremier(),this.getReste().inferieurs(s)) ;
      }
      else {
         return this.getReste().inferieurs(s) ;
      }
   }
   public Liste QS () {
      int pivot = this.getPremier() ;
      Liste inf = this.getReste().inferieurs(pivot).QS() ;
      Liste sup = this.getReste().superieurs(pivot).QS() ;
      return inf.concat(new ListeCons(pivot,sup)) ;
   }
   
   public void listeEnTab(ArrayList T) {
      T.add(this.getPremier()) ;
      this.getReste().ListeEnTab(T) ;
   }
}