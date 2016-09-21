
public class Personne
{
	private String nom;
	private int prio;
	private boolean [] Abs;
	
	Personne( String nom, int p )
	{
		this.nom = nom;
		this.prio = p;
		Abs = new boolean[52];
		for(int i=0; i<52; i++)
			Abs[i] = false;
	}
	
	public String toString()
	{
		return this.nom+"  prio : "+this.prio;
	
	}
	
	public int getPrio()
	{
		return this.prio;
	}
	
	public String getNom()
	{
		return this.nom;
	}

	
	public void setPrio( int p )
	{
		this.prio = p;
	}
	
	public void setAbs( int sem )
	{
		if (sem>=0 && sem<=51)
			this.Abs[sem] = true;
	}
	
	public void removeAbs( int sem)
	{
		if (sem>=0 && sem<=51)
			this.Abs[sem] = false;
	}
	
	public boolean estAbsent(int sem)
	{
		if (sem>=0 && sem<=51)
				return this.Abs[sem];
		else return true;
	}
	
	public void afficheAbs()
	{
	System.out.println("Pompier :"+this.nom);
	for( int i=0; i<52; i++)
	{
		if (this.Abs[i])
			System.out.print("Semaine "+i);
	}
	System.out.println();
	}
}