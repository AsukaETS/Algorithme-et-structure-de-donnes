public abstract class Arbre {
   public abstract String getRacine();
   public abstract Arbre getAg();
   public abstract Arbre getAd();
   public abstract void setRacine(String s);
   public abstract void setAg(Arbre Ag);
   public abstract void setAd(Arbre Ad);
   public abstract boolean estVide();
   public abstract void afficher();
   public abstract void afficherGRD();
   public abstract boolean estFeuille();
   public abstract int nbFeuilles();
   public abstract boolean trouver(String e);
   public abstract String lePlusaGauche();
   public abstract String lePlusaDroite();
   public abstract Arbre supprimer(String e);
   public abstract boolean insererFeuille(String e);
}

class ArbreVide extends Arbre { // sentinelle de structure

   ArbreVide() {
   }
   public String getRacine() { 
      return null; 
   }
   public Arbre getAg() { 
      return this; 
   }
   public Arbre getAd() { 
      return this; 
   }
   public void setRacine(String s) { }
   public void setAg(Arbre Ag) { }
   public void setAd(Arbre Ad) { }
   public boolean estVide() {
      return true;
   }
   public void afficher() {
   // System.out.print(" vide ");
   }
   public boolean estFeuille() {
      return false;
   }
   public void afficherGRD() { }
   
   public int nbFeuilles() {
      return 0;
   }
   
   public boolean trouver(String e) {
      return false;
   }
   
   public String lePlusaGauche() {
      return null;
   }
   
   public String lePlusaDroite() {
      return null;
   }
   
   public Arbre supprimer(String e) {
      return new ArbreVide();
   }
   
   public boolean insererFeuille(String e) {
      return false;
   }
}

class ArbreCons extends Arbre
{
   private String racine;
   private Arbre Ag;
   private Arbre Ad;
   public boolean estVide() {
      return false;
   }
   ArbreCons(String val, Arbre Ag, Arbre Ad) { //constructeur
      this.racine = val; this.Ag = Ag; this.Ad = Ad;
   }
   ArbreCons( String val ){ // constructeur de feuille
      this.racine = val; this.Ag = new ArbreVide(); this.Ad = new ArbreVide();
   }
   ArbreCons (int niveau){
      if (niveau > 0) {
         this.racine = null;
         this.Ag = new ArbreCons(niveau-1);
         this.Ad = new ArbreCons(niveau-1);
      }
      else {
         this.racine = null;
         this.Ag = new ArbreVide();
         this.Ad = new ArbreVide();
      }
   }
   public String getRacine() { 
      return this.racine; 
   }
   public Arbre getAg() { 
      return this.Ag;
   }
   public Arbre getAd() { 
      return this.Ad; 
   }
   public void setRacine(String s) {this.racine = s;}
   public void setAg(Arbre Ag) {this.Ag = Ag;}
   public void setAd(Arbre Ad) {this.Ad = Ad;}
   public boolean estFeuille() { 
      return this.getAg().estVide() && this.getAd().estVide();
   }
   
   public void afficherGRD() {
      this.getAg().afficherGRD();
      System.out.print(this.getRacine()+" ");
      this.getAd().afficherGRD();
   }
   
   public void afficher() {
      System.out.println("pouet");
   }
   
   public int nbFeuilles() {
      int nfg = 0, nfd =0;
      nfg = getAg().nbFeuilles();
      nfd = getAd().nbFeuilles();
      if (estFeuille()) {
         return 1;
      }
      else {
         return (0 + nfg + nfd);
      }
   }
   
   public boolean trouver(String e) {
      if (this.racine.equals(e)) {
         return true;
      }
      else {
         return this.getAg().trouver(e) || this.getAd().trouver(e);
      }
   }
   
   public String lePlusaGauche() {
      if (this.estFeuille()) {
         return this.getRacine();
      }
      else {
         return this.getAg().lePlusaGauche();
      }
   }
   
   public String lePlusaDroite(){
      if(this.getAd().estFeuille()){
         return this.getAd().getRacine();
      } 
      else {
         return this.getAd().lePlusaDroite();
      }
   }
   
   public Arbre supprimer(String e) {
      if (e.equals(this.getRacine())) {
         if (this.getAg().estVide()) {
            return this.getAd(); //cas particulier
         }
         String stock = this.lePlusaGauche();
         return new ArbreCons(stock, this.getAg().supprimer(stock), this.getAd().supprimer(stock));
      }
      else {
         return new ArbreCons(this.getRacine(), this.getAg().supprimer(e), this.getAd().supprimer(e));
      }
   }
   
   public boolean insererFeuille(String e) {
      boolean b = false ;
      if (estFeuille() == true && this.getRacine()==null && !b) {
         this.setRacine(e) ;
         return true ; 
      }
      else {
         return this.getAg().insererFeuille(e) || this.getAd().insererFeuille(e) ;
      }
      
   }
}

class Test {
   public static void main(String[] args) {
      Arbre a = new ArbreCons("A",
                              new ArbreCons("B", new ArbreCons("C"), new ArbreCons("D")),
                              new ArbreCons("E", new ArbreCons("F"), new ArbreCons("G"))
                              );
      a.afficherGRD();
      System.out.println(" ");
      System.out.println("Nombres de feuilles : "+a.nbFeuilles());
      System.out.println(a.trouver("Y"));
      System.out.println(a.lePlusaGauche());
      System.out.println(a.lePlusaDroite());
      Arbre b = a.supprimer("A");
      b.afficherGRD();
   }
}