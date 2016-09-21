import java.util.ArrayList;

public class Planning
{
private FilePrio F;
private String [] [] Année;


public Planning()
{
	Personne Pompier1 = new Personne("DURAND", 0);
	Personne Pompier2 = new Personne("TYPON", 0);
	Personne Pompier3 = new Personne("SANNIO",0);
	Personne Pompier4 = new Personne("HENRI",0);
	Personne Pompier5 = new Personne("DUFAUR",0);
	



}

public void repartition()
{	

	
}
	
public void affichePlanning()
{	
	System.out.println("Planning :");
	for(int j=0; j<52; j++)  //on affiche le planning
	{
		System.out.print( (j)+"  "+Année[j][0]+"  "+Année[j][1]  );
		System.out.println();
	
	}
	
}


}



