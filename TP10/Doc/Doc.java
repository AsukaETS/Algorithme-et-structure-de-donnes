

public abstract class Doc 
{
	public abstract String toString();
	public abstract boolean equals( Doc d );
}

class Titre extends Doc   
{
	private int num;
	private String label;
	
	public Titre (int num, String l)
	{
		this.num = num;
		this.label = l; 
	}
	
	public void setNum(int n)	{ 		this.num = n;								}
	
	public String getLabel()   { 		return this.label; 						}
	
	public String toString()	{		return this.num+" - "+this.label;	}
	
	public boolean equals( Doc d )
	{
		if (d instanceof Titre)
		{
			Titre t= (Titre) d;
			return this.label.equals( t.getLabel() );
		}
		else
			return false;
	}
	
}

class Img extends Doc
{
	private String src;
	
	public Img (String s)
	{
		this.src = s;
	}

	public String getSrc()  	{ 		return this.src; 						}
	
	public String toString()	{		return " <IMAGE> : "+this.src;	}

	public boolean equals( Doc d )
	{
		if (d instanceof Img)
		{
			Img im= (Img) d;
			return this.src.equals( im.getSrc() );
		}
		else
			return false;
	}

		
}

class Texte extends Doc
{
	private String txt;
	
	public Texte (String t)
	{
		this.txt = t; 
	}

	public String getTxt()   	{ 	return this.txt; }

	public String toString()	{	return this.txt; }
	
	public boolean equals( Doc d )
	{
		if (d instanceof Texte)
		{
			Texte t= (Texte) d;
			return this.txt.equals( t.getTxt() );
		}
		else
			return false;
	}

}