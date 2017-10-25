package TD6;



public abstract class Liste  
{	
   public abstract boolean estVide();
   
   public abstract String getPremier();
   
   public abstract Liste getReste();
		
   public abstract void afficher();
	
   public abstract int  size();

   public abstract String somme();
	
   public abstract Liste placerFin(String val);
	
   public abstract Liste copie();
	
   public abstract boolean trouver(String val);
	
   public abstract Liste concat( Liste L1 );
	
   public abstract Liste inverser();

   public abstract Liste inserer(String s , int rang );
	
   public abstract Liste intersection( Liste L );
	
//	public abstract Liste union( Liste L );
	
//	public abstract boolean inclus( Liste L );

	
}

//************************************************************************************************************
class ListeVide extends Liste   // permet d'avoir une sentinelle permettant d'idenfier une liste vide
{
   ListeVide ()
   {
   }
	
   public boolean estVide()
   {
      return true;
   }
	
   public String getPremier(){
      return null;}
	
   public Liste getReste(){
      return null;}

	
   public void afficher()
   {
      System.out.println();
   }	
	
	
   public String somme()
   {
      return "";
   }
	
   public int size()
   {
      return 0;
   }
   
   public Liste placerFin (String val) {
      return new ListeCons(val, new ListeVide()) ;
   }
	
   public Liste copie()
   {
      return new ListeVide();
   }
   
   public boolean trouver (String val) {
      return false ;
   }
   
   public Liste concat (Liste L1) {
      if (!L1.estVide()) {
         return new ListeCons(L1.getPremier(), concat(L1.getReste()));
      }
      else {
         return new ListeVide();
      }
   }
   
   public Liste inverser() {
      return new ListeVide();
   }
   
   public Liste inserer(String s , int rang ) {
      return new ListeVide() ;
   }
   
   public Liste intersection (Liste L) {
       return new ListeVide() ;
   }
   
   public Liste union (Liste L) {
       return new ListeVide() ;
   }
   
   public boolean inclus (Liste L) {
       return false ;
   }

}


/**********************************************************************************************************/

class ListeCons extends Liste
{
   private String valeur;
   private Liste suiv;

   ListeCons(String val, Liste L)
   {
      this.valeur = val; this.suiv = L;
   }
	
   public boolean estVide()
   {
      return false;
   }

   public String getPremier() { 
      return this.valeur; 
   }
	
   public Liste getReste() { 
      return this.suiv; 
   }
		
	
   public void afficher()
   {
      System.out.print( this.getPremier()+" " );
      this.getReste().afficher();
   }
	
   public int size()
   {
      return 1 + this.getReste().size()  ;
   }
   
   public Liste placerFin (String val) {
      return new ListeCons(this.getPremier(), this.getReste().placerFin(val)) ;
   }
	
   public String somme()
   {
      return this.getPremier()+this.getReste().somme() ;
   }
		
   public Liste copie()
   {
      return new ListeCons(this.getPremier(), this.getReste().copie()) ;
   }
   
   public boolean trouver(String val) {
      Liste L1 = this ;
      if (!L1.estVide() && L1.getPremier() == val) {
         return true ;
      }
      else {
         return this.getReste().trouver(val) ;
      }
      
   }
   
   public Liste concat (Liste L1) {
      return new ListeCons(this.getPremier(), this.getReste().concat(L1)) ; 
   }
   
   public Liste inverser () {
      return getReste().inverser().placerFin(getPremier()) ;
   }
   
   public Liste inserer(String S, int rang) {
      if (rang == 1) {
         return new ListeCons(S, getReste().copie());
      }
      else {
         return new ListeCons(getPremier(), getReste().inserer(S,rang-1));
      }
   }
   
   public Liste intersection (Liste L) {
        if (L.trouver(this.getPremier()))
            return new ListeCons(this.getPremier(), this.getReste().intersection(L.getReste()));
         return this.getReste().intersection(L);
   }
   
   /*public Liste union (Liste L) {
       
   }*/
}