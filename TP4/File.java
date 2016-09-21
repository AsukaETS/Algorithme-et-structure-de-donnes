import java.util.ArrayList;
import java.util.Iterator;

/** Cette classe gère des listes de String, elle peut être adaptée pour n'importe quel objet **/

public class File  						
{


private ArrayList <Personnage> F;


File()
{
	F= new ArrayList();
}

/** Est ce que la file est vide ? **/
public boolean estVide() 
{	return F.isEmpty();	
}

public int size()
{
	return F.size();
}

public void add(Personnage e)
{
	F.add(e);
}

/** demontage destructeur **/
public Personnage get()	 
{
	if (!estVide())
	{
		return F.remove(0);						
	}
return null;
}


/** retourne un iterateur voir TestFile.java **/
public Iterator iterator() 
{
	return F.iterator();
}

}