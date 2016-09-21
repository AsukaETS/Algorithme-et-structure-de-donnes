

public abstract class Arbre 
{
	public abstract Doc getRacine(); 
	public abstract Arbre getAg(); 
	public abstract Arbre getAd(); 
	
	public abstract void setRacine(Doc s);
	public abstract void setAg(Arbre Ag);
	public abstract void setAd(Arbre Ad);
	
	
	public abstract boolean estVide();
		
	public abstract void afficher(int degre);
	
	public abstract Doc lePlusAGauche();
	
	public abstract Arbre supprimer( Doc val );
	
	public abstract boolean trouver( Doc val );
	
	public abstract boolean estFeuille();
	
	
}

class ArbreVide extends Arbre   
{
	ArbreVide ()
	{
	}
	
	public Doc getRacine() { return null; }
	public Arbre getAg() { return this; }
	public Arbre getAd() { return this; }
	
	public void setRacine(Doc s) {  }
	public void setAg(Arbre Ag) {  }
	public void setAd(Arbre Ad) {  }

	public boolean estVide()
	{
		return true;
	}

	
	public void afficher(int degre)
	{
		// System.out.print(" vide ");
	}
	
	
	public Doc lePlusAGauche()
	{
	  return null;
	}
	
	public Arbre supprimer( Doc val )
	{
		return this;
	}
	
	public boolean trouver( Doc val )
	{
		return false;
	}

	public boolean estFeuille()
	{
		return false;
	}
	

	
}

class ArbreCons extends Arbre
{
	private Doc racine;
	private Arbre Ag;
	private Arbre Ad;
	
	public boolean estVide()
	{
		return false;
	}

	ArbreCons(Doc val, Arbre Ag, Arbre Ad)
	{
		this.racine = val; this.Ag = Ag; this.Ad = Ad;
	}
	
	ArbreCons( Doc val)
	{
		this.racine = val; this.Ag = new ArbreVide(); this.Ad = new ArbreVide();
	}
	
	
	public Doc getRacine() { return this.racine; }
	public Arbre getAg() { return this.Ag; }
	public Arbre getAd() { return this.Ad; }
	
	public void setRacine(Doc s) { this.racine = s; }
	public void setAg(Arbre Ag) { this.Ag = Ag; }
	public void setAd(Arbre Ad) { this.Ad = Ad; }

	
		
	public boolean estFeuille()
	{
		return this.getAg().estVide() && this.getAd().estVide();
	}
	
	public void afficher(int degre)
	{
			for(int i=0;i<degre;i++)  { System.out.print("\t"); }
			System.out.println( this.getRacine());
			this.getAg().afficher(degre+1);
			this.getAd().afficher(degre);
	}
	
	
	public Doc lePlusAGauche()
	{
		if (this.getAg().estVide()) return this.getRacine();
		else return this.getAg().lePlusAGauche();	
	}

	public Arbre supprimer( Doc val )
	{
		if (val.equals(this.getRacine()) )
		{
			if (this.getAg().estVide()) return this.getAd();  //cas particulier
			Doc valeur = this.lePlusAGauche();
			return new ArbreCons( valeur , this.getAg().supprimer(valeur) , this.getAd().supprimer(valeur)); 
		}	
		else
			return new ArbreCons( this.getRacine(),this.getAg().supprimer(val) , this.getAd().supprimer(val));
	}

	public boolean trouver( Doc val )
	{
		if (val.equals( this.getRacine()) )
					return true;
		else
			return this.getAg().trouver(val) || this.getAd().trouver(val);	
	
	}


	
}

