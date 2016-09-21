import java.util.ArrayList;
 
public abstract class ArbreBR {
   public abstract ArbreBR insereTo (Integer val);
   public abstract Integer getRacine();
   public abstract ArbreBR getAg();
   public abstract ArbreBR getAd();
   
   public abstract void setRacine (Integer val);
   public abstract void setAg (ArbreBR Ag);
   public abstract void setAd (ArbreBR Ad);
   
   public abstract boolean estVide();
   public abstract void afficherGRD();
   public abstract boolean rechercherABR (Integer val);
   public abstract ArbreBR supprimer (Integer val);
   public abstract void arbreBREnTab (ArrayList t);
   public abstract Integer lePlusAGauche();
   public abstract boolean estFeuille();
   public abstract int nbFeuilles();
   public abstract int nbNoeuds();
   public abstract int hauteur();
   public abstract boolean insereFeuille (Integer val);
   
}
 
class ArbreBRVide extends ArbreBR {
   ArbreBRVide() {}
   
   public Integer getRacine() {
      return 0;
   }
   
   public ArbreBR getAg() {
      return this;
   }
   
   public ArbreBR getAd() {
      return this;
   }
   
   public void setRacine (Integer val) {}
   public void setAg (ArbreBR Ag) {}
   public void setAd (ArbreBR Ad) {}
   
   public boolean estVide() {
      return true;
   }
   
   public void afficherGRD() {}
   public ArbreBR insereTo (Integer val) {
      return this;
   }
   
   public boolean rechercherABR (Integer val) {
      return false;
   }
   public ArbreBR supprimer (Integer val) {
      return this;
   }
   
   public void arbreBREnTab (ArrayList t) {}
   
   public Integer lePlusAGauche() {
      return 0;
   }
   
   public int nbNoeuds() {
      return 0;
   }
   
   public int hauteur() {
      return 0;
   }
   
   public boolean insereFeuille (Integer val) {
      return false;
   }
   
   public boolean estFeuille() {
      return false;
   }
   
   public int nbFeuilles() {
      return 0;
   }
}
 
class ArbreBRCons extends ArbreBR {
   private Integer racine;
   private ArbreBR Ag;
   private ArbreBR Ad;
   
   public boolean estVide() {
      return false;
   }
   
   ArbreBRCons (Integer val, ArbreBR Ag, ArbreBR Ad) {
      this.racine = val;
      this.Ag = Ag;
      this.Ad = Ad;
   }
   
   ArbreBRCons (Integer val) {
      this.racine = val;
      this.Ag = new ArbreBRVide();
      this.Ad = new ArbreBRVide();
   }
   
   ArbreBRCons (ArrayList t, int début, int fin)
   {
      int milieu=(fin+début)/2;
      if(début==fin)
      {
         this.racine = (Integer) t.get(début);
         this.Ag = new ArbreBRVide();
         this.Ad = new ArbreBRVide() ;
      }
      else if(début==fin-1)
      {
         this.racine = (Integer) t.get(début);
         this.Ag = new ArbreBRVide();
         this.Ad = new ArbreBRCons((Integer)t.get(fin));
      }
      else 
      {
         this.racine =(Integer) t.get(milieu);
         this.Ag = new ArbreBRCons(t, début, milieu-1);
         this.Ad = new ArbreBRCons(t, milieu+1, fin);
      } 
   }        
   public Integer getRacine() {
      return this.racine;
   }
   
   public ArbreBR getAg() {
      return this.Ag;
   }
   
   public ArbreBR getAd() {
      return this.Ad;
   }
   
   public void setRacine (Integer val) {
      this.racine = val;
   }
   
   public void setAg (ArbreBR Ag) {
      this.Ag = Ag;
   }
   
   public void setAd (ArbreBR Ad) {
      this.Ad = Ad;
   }
   
   public void afficherGRD() {
      getAg().afficherGRD();
      System.out.print(getRacine() + " ");
      getAd().afficherGRD();
   }
   
   public ArbreBR insereTo (Integer val) {
      if (val.equals(this.getRacine())) {
         return this;
      }
      else if (val.compareTo(this.getRacine()) < 0) {
         return new ArbreBRCons(getRacine(), getAg().insereTo(val), getAd());
      }
      else if (this.getRacine() > val) {
         return new ArbreBRCons(getRacine(), getAg(), getAd().insereTo(val));
      }
      return null;
   }
   
   public boolean rechercherABR(Integer val) {
      if (val.equals(this.getRacine())) {
         return true;
      }
      else if (val.compareTo(getRacine()) < 0) {
         return this.getAg().rechercherABR(val);
      }
      else {
         return this.getAd().rechercherABR(val);
      }
   }
   
   public ArbreBR supprimer(Integer val){
      if(!this.getRacine().equals(val)){
         return new ArbreBRCons(this.getRacine(), this.getAg().supprimer(val),this.getAd().supprimer(val));
      }
      else{
         if(!this.getAd().estVide()){
            return new ArbreBRCons(this.getAd().lePlusAGauche(),this.getAg(),this.getAd().supprimer(this.getAd().lePlusAGauche()));
         }
         else{
            return this.getAg();
         }        
      }
             
   }
 
   public void arbreBREnTab (ArrayList t) {
      this.getAg().arbreBREnTab(t);
      t.add(getRacine());
      this.getAd().arbreBREnTab(t);
   }
   
   public Integer lePlusAGauche() {
      if (this.getAg().estVide()) {
         return getRacine();
      }
      else {
         return getAg().lePlusAGauche();
      }
   }
   
   public int nbNoeuds() {
      int nfg = 0, nfd =0;
      nfg = getAg().nbNoeuds();
      nfd = getAd().nbNoeuds();
      return (1 + nfg + nfd);
   }
   
   public int hauteur() {
      int nfg = 0, nfd = 0;
      nfg = 1 + getAg().hauteur();
      nfd = 1 + getAd().hauteur();
      return Math.max(nfg, nfd);
   }
   
   public boolean insereFeuille (Integer val) {
      if (this.estFeuille() == true && this.getRacine() == null) {
         this.setRacine(val);
         return true;
      }
      else {
         return this.getAg().insereFeuille(val) || this.getAd().insereFeuille(val);
      }
   }
   
   public boolean estFeuille() {
      return this.getAg().estVide() && this.getAd().estVide();
   }
   
   public int nbFeuilles() {
      if (estFeuille()) {
         return 1;
      }
      else {
         return getAg().nbFeuilles() + getAd().nbFeuilles();
      }
   }
}

class test {
   public static void main (String[] agrs) {
      ArbreBR tree1 = new ArbreBRCons(8,
                         new ArbreBRCons(3,
                           new ArbreBRCons(2),
                           new ArbreBRCons(5)),
                         new ArbreBRCons(10,
                           new ArbreBRCons(6),
                           new ArbreBRCons(14))
                         );
      tree1.afficherGRD();
      System.out.println();
      ArbreBR tree2 = tree1.supprimer(3);
      tree2.afficherGRD();
      
      System.out.println("") ;
      
      ArrayList<Integer> L = new ArrayList();
      L.add(2);
      L.add(5);
      L.add(9);
      L.add(14);
      L.add(15);
      L.add(19);
      ArbreBR arbre = new ArbreBRCons(L,0,L.size()-1);
      arbre.afficherGRD();
      
   }
}