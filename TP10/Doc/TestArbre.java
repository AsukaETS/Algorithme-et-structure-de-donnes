

public class TestArbre
{
	public static void main( String [] args)
	{
	
		Doc T2 = new Titre( 2, "Introduction" );
		Doc T3 = new Titre( 3, "Explications" );
			Doc T4 = new Titre( 1, "Le figuratif" );
			Doc T5 = new Titre( 2, "Du figuratif à l'abstration" );
			Doc T6 = new Titre( 3, "Peintres du 19ieme siecle" );
		Doc T7 = new Titre( 5, "Conclusion" );
		
		Doc img1 = new Img("D:/monet.jpg");
		Doc img2 = new Img("D:/renoir.jpg");
		
		Doc T1Peintre = new Texte("Pierre-Auguste Renoir dit Auguste Renoir, né à Limoges le 25 février 1841 et mort au domaine des Collettes à Cagnes-sur-Mer le 3 décembre 1919");
		Doc T2Peintre = new Texte("Claude Monet est né à Paris le 14 novembre 1840 au 45, rue Laffitte dans le 9e arrondissement");
			
		
			
		Arbre detail1 = new ArbreCons(T4, 
								new ArbreVide(),
								new ArbreCons( T6,					
										new ArbreVide(),
										new ArbreCons( T5)
								)			
						);
		
		
		Arbre docGlobal = new ArbreCons(T2, 
								new ArbreVide(), 
								new ArbreCons( T3,
										detail1,
										new ArbreCons( T7)
								)			
						);
							
		docGlobal.afficher(0);
		
				
		}
}