public class Fiche 
{
private String Nom;
private String Prenom;
private String Statut;

Fiche( String Nom, String Prenom, String Statut )
{ 	
	this.Nom = Nom; 	
	this.Prenom = Prenom;	
	this.Statut = Statut;
}

public String getNom()
{ return this.Nom;
}

public String getPrenom()
{ return this.Prenom; }

public String getStatut()
{ return this.Statut; }


// egalite d'une fiche
public boolean equals( Fiche f )
{
	if (   f.getNom().equals(this.Nom) && f.getPrenom().equals(this.Prenom)	 )
   		return true;
		else
			return false;
		
	
}
// comparaison de fiche
public int compareTo(Fiche f)
{
		if (this.Nom.compareTo(f.getNom() )<0 )
			return -1;
		else
			if (this.Nom.compareTo(f.getNom() )>0 )
				return 1;
			else
				return 0;
}
			

// on precise le code de l'objet pour l'affichage !!     hashCode()
public String toString()
{
	return " Nom : "+this.getNom()+" Prenom : "+this.getPrenom()+" Statut :"+this.getStatut()+" Code objet : "+this.hashCode();
}



}