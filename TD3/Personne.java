public class Personne {
   private String nom;
   private int prio; 
   
   Personne (String nom, int p) {
      this.nom = nom; 
      this.prio = p;
   }
   
   public int getPrio() {
      return this.prio;
   }
   public String getNom() {
      return this.nom;
   }
   public void setPrio (int p) {
      this.prio = p;
   }
}