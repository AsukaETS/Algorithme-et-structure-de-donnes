import java.util.ArrayList ;

abstract class Plante {
   protected String nom ;

   public abstract void Afficher() ;
   
}

class Peuplier extends Plante {
   private int taille ;

   Peuplier (int t, String n) {
      this.taille = t ;
      this.nom = n ;
   }
   public void Afficher() {
      System.out.println("ERMAHGERD CHUI 1 PEUPLIER JMAPEL ") ;
   }
}

class Pin extends Plante {
   private int age ;

   Pin (int a) {
      this.age =a ;
   }
   public void Afficher() {
      System.out.println("ERMAHGERD CHUI 1 P1") ;
   }

}

class Rosier extends Plante {
    public void Afficher() {
      System.out.println("ERMAHGERD CHUI 1 ROZIER") ;
   }


}

class Test {
   public static void main (String[] args) {
      ArrayList<Plante> a = new ArrayList();
      Peuplier p1 = new Peuplier(12, "Tartempion");
      p1.Afficher();
   
   }
}
