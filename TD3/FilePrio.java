import java.util.ArrayList;

public class FilePrio {
   private ArrayList<Personne> F;
   
   FilePrio () {
      F=new ArrayList();
   }
   public Personne get() {
      if (!EstVide()){
         return this.F.remove(0) ;
      }
      return null;
   }
   public void add (Personne e) {
      int i = 0 ;
      while (i<this.F.size() && this.F.get(i).getPrio()<=e.getPrio() ) {
         i++ ;
      }
      this.F.add(i,e) ;
   }
   public boolean EstVide() {
      return F.isEmpty();
   }
   public int getPrioTete() {
      if (!EstVide() ) {
         return this.F.get(0).getPrio() ;
      }
      return -1 ;
   }
   public void afficher() {
      for(int i = 0; i<F.size(); i++) {
         System.out.println("Nom de la personne : "+this.F.get(i).getNom()+"\n Priorité de la personne : "+this.F.get(i).getPrio()) ;
      }
   }
   
   
}