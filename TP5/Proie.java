package TP5;

public class Proie
{
// variable de classe partag�e par tous les objets
   private static int NourritureProies = 10000;
// variables d'instances
   private int x, y, pasX, pasY;

   private int duréeVie;
   private int gaugeFaim;

// constantes --------------------------------------

   public static final int ESPACEVITALX = 100;
   public static final int ESPACEVITALY = 100;
   public static final int DUREEVIE = 500;


   Proie (int xx, int yy )
   {
      this.x = xx;
      this.y = yy;
   
      this.duréeVie = DUREEVIE;
      this.gaugeFaim = Aleatoire(3,8);
      this.pasX = Aleatoire( -2, 2 );
      this.pasY = Aleatoire( -2, 2 );
   
   
   }
// accesseurs
   public int getX() { 
      return this.x; }
   public int getY() { 
      return this.y; }
   public int getVie() { 
      return this.duréeVie; }
   public void setVie(int i) {
   this.duréeVie = i ; }

// methode de classe
   public static void regenererNourritureProies( int val )
   {
      Proie.NourritureProies+=val;
   }
// methodes d'instances


   public void deplacement()
   {
    //pasX=Aleatoire(-2,2);
    //pasY=Aleatoire(-2,2);
      this.x=this.x+pasX;     // on fait avancer la proie
      this.y=this.y+pasY;
      if (this.x <0) {  this.x=0; this.pasX= -this.pasX; }  // limites des deplacements
      if (this.y <0) {  this.y=0; this.pasY = -this.pasY; }
      if (this.x >ESPACEVITALX) { this.x =ESPACEVITALX; this.pasX= -this.pasX;}
      if (this.y >ESPACEVITALY) { this.y =ESPACEVITALY; this.pasY= -this.pasY;}
   
      this.duréeVie--;  							 // il viellit
      this.gaugeFaim--;  							 // il depense de l'energie 
   
      if (this.gaugeFaim <=0) 					 // faim ?
      {
         if (Proie.NourritureProies>0)
         { Proie.NourritureProies--;  			 //il mange
            this.gaugeFaim = Aleatoire(8,20);
         }
         else 
         {
            this.duréeVie=0;							 //il meurt	
            System.out.println("RIP PROIE OMG RT SI T TRIST");
         } 
      }
   	
   }

   private int Aleatoire( int min, int max )
   {
      int val=0;
      while (val ==0)
      {
         val = (int) ((Math.random()*(max-min+1))+ min);
      }
      return val;
   }
}