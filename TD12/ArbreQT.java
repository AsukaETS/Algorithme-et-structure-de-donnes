import java.util.ArrayList;


public abstract class ArbreQT {
   public abstract void afficher();
   public abstract boolean equals(ArbreQT a);
}

class AQTVide extends ArbreQT {
   AQTVide() {}
   
   public void afficher() {}
   
   public boolean equals(ArbreQT a) {
      return false;
   }
}

class AQTCons extends ArbreQT {
   private ArbreQT SE;
   private ArbreQT SO;
   private ArbreQT NE;
   private ArbreQT NO;
   
   public ArbreQT getSE() { 
      return this.SE; }
   public ArbreQT getSO() { 
      return this.SO; }
   public ArbreQT getNE() { 
      return this.NE; }
   public ArbreQT getNO() { 
      return this.NO; }
   
   AQTCons(ArbreQT i1,ArbreQT i2,ArbreQT i3,ArbreQT i4) {
      this.NO = i1;
      this.NE = i2;
      this.SO = i3;
      this.SE = i4;
   }
   
   public void afficher() {
      System.out.print("(");
      this.NO.afficher();
      this.NE.afficher();
      this.SO.afficher();
      this.SE.afficher();
      System.out.print(")");
   }
   
   public boolean equals (ArbreQT a) {
      if (a instanceof AQTCons) {
         AQTCons b = (AQTCons) a;
         return (this.NO.equals(b.getNO()) &&
                 this.NE.equals(b.getNE()) &&
                 this.SO.equals(b.getSO()) &&
                 this.SE.equals(b.getSE()));
      }
      else {
         return false;
      }
   }
}

class Blanc extends ArbreQT {
   Blanc() {}
   
   public void afficher() {
      System.out.print("B");
   }
   
   public boolean equals(ArbreQT a) {
      if (a instanceof Blanc) {
         return true;
      }
      else {
         return false;
      }
   }
}

class Noir extends ArbreQT {
   Noir() {}
   
   public void afficher() {
      System.out.print("N");
   }
   
   public boolean equals(ArbreQT a) {
      if (a instanceof Noir) {
         return true;
      }
      else {
         return false;
      }
   }
}

class ReprUnique {
   private ArrayList <ArbreQT> dico;
   
   public ReprUnique() {
      dico = new ArrayList();
   }
   
   public void setDico(ArbreQT a) { dico.add(a); } 
   
   public ArbreQT getRef(ArbreQT a) {
      int i=0;
      while (i < dico.size()) {
         if (dico.get(i).equals(a)) {
            return a;
         }
         else {
            i++;
         }
      }
      dico.add(a);
      return a;
   }
}

class test {
   public static void main (String[] args) {
      ArbreQT a = new AQTCons(new Noir(),
                              new Blanc(),
                              new Blanc(),
                              new Noir());
      ArbreQT n = new AQTCons(a,
                              a,
                              new AQTCons(a,a,a,a),
                              a);
      n.afficher();
      System.out.println(" ");
      System.out.println("----");
      
      ReprUnique dico = new ReprUnique();
      dico.setDico(a);
      dico.setDico(n);
      ArbreQT y = new AQTCons(a,
                              new AQTCons(a,a,a,a),
                              a,
                              new AQTCons(a,a,a,a)); 
      
      ArbreQT res = dico.getRef(y);
      res.afficher();
      
      
   }
}