package TP5;

public class Predateur
{
private int x, y, pasX, pasY;

private int duréeVie;
private int gaugeFaim;


public static final int ESPACEVITALX = 100;
public static final int ESPACEVITALY = 100;
public static final int DUREEVIE =150;
public static final int RATIONMANGER =50;



Predateur (int xx, int yy)
{
	this.x = xx;
	this.y = yy;

	this.duréeVie = DUREEVIE;
	this.gaugeFaim = Aleatoire(30,60);
	this.pasX = Aleatoire( -2, 2 );
	this.pasY = Aleatoire( -2, 2 );

}

public int getX() { return this.x; }
public int getY() { return this.y; }
public int getVie() { return this.duréeVie; }
public int getFaim() {return this.gaugeFaim ; } 

public void deplacement()
{
	this.x=this.x+pasX;
	this.y=this.y+pasY;
	if (this.x <0) {  this.x=0; this.pasX= -this.pasX; }
	if (this.y <0) {  this.y=0; this.pasY = -this.pasY; }
	if (this.x >ESPACEVITALX) { this.x =ESPACEVITALX; this.pasX= -this.pasX;}
	if (this.y >ESPACEVITALY) { this.y =ESPACEVITALY; this.pasY= -this.pasY;}
	
	this.duréeVie--;
	this.gaugeFaim--;  							 // il depense de l'energie 
	
	if (this.gaugeFaim <=0) 					 // faim ?
	{
		 this.duréeVie=0;							 //il meurt	
		 System.out.println("RIP PREDATEUR OMG RT SI T TRIST");	
	}

}

public void mange()
{
	this.gaugeFaim +=RATIONMANGER;
   System.out.println("OMNOMNOMNOM") ;
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