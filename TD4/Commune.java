public class Commune {
   private int NbHabitants ;
   private double Superficie ;

   Commune (int NBH, double S) {
      this.NbHabitants = NBH ;
      this.Superficie = S ;
   }
   public int getNbH() {
      return this.NbHabitants ;
   }
   public double getSuperficie() {
      return this.Superficie ;
   }
   public double ratio() {
      return this.NbHabitants/this.Superficie ;
   }
}
