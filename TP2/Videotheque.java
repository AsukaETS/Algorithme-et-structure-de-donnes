package TD2.TP2;

import java.util.ArrayList;
import java.io.*;


public class Videotheque
{
// Le nom de la variable supportant la videotheque sera :  desDVD

   private ArrayList<UnDVD> desDVD ;
   private int vueCourante = 0 ;


   Videotheque()
   {
      this.desDVD = new ArrayList<UnDVD>() ;
      this.vueCourante = 0 ;
   }

   public void Ajouter ( UnDVD e )
   {
      this.desDVD.add(e) ;
   }

   public void Supprimer()
   {
      this.desDVD.remove(this.vueCourante) ;
   }


   public int NbFilms()
   {
      return this.desDVD.size() ;
   }

   public void Reset()
   {
      this.desDVD.clear() ;
   }

   public UnDVD getDVD()			// renvoie un DVD en position courante sinon : new UnDVD("VIDEOTHEQUE VIDE","vide.jpg","",0)
   {
      if (this.desDVD.size() == 0) {
         UnDVD d1 = new UnDVD ("VIDEOTHEQUE VIDE","vide.jpg","",0) ;
         this.desDVD.add(d1) ; }
      return this.desDVD.get(this.vueCourante) ;
   }

   public void Suivant ()
   {
      this.vueCourante ++ ;
   }

   public void Precedent()
   {
      this.vueCourante -- ;
   }

   public void Emprunter()
   {
         this.desDVD.get(this.vueCourante).setEmprunt(); 
   }

   public void Rendre()
   {
      this.desDVD.get(this.vueCourante).setRetour();
   }

   public void Afficherv()  // afficher la videotheque en texte
   {
      for (int i=0 ; i < this.desDVD.size() ; i++) {
         this.desDVD.get(i).Afficher();
      } 
   
   }

   public void chargement( String NomFichier )throws IOException
   {
      String LeTitre="",NomPhoto="", Texte=""; int NbEx=-1;  // recuperation temporaire de ces infos
      UnDVD unFilm;
   
      FileReader fic = new FileReader(NomFichier);  		//ouverture du fichier
      StreamTokenizer entree = new StreamTokenizer(fic);	// intermediaire avec FileReader
      entree.quoteChar('"');
   	
   // lecture des donn�es dans le fichier connaissant le format-----------------------------------------------------
      int i =0;
      entree.nextToken() ;							// on passe � l'element suivant
      while ( entree.ttype != entree.TT_EOF ) // c'est la fin du fichier ou pb ?
      {  	  
         LeTitre = entree.sval; 
         entree.nextToken() ;
         NomPhoto = entree.sval;
         entree.nextToken() ;
         Texte = entree.sval;
         entree.nextToken() ;
         NbEx = (int) entree.nval;
               
         unFilm = new UnDVD( LeTitre, NomPhoto, Texte, NbEx ); // nouveau dvd
         desDVD.add(unFilm);												// on ajoute � la videotheque
      						
      
         i++;
      		
         entree.nextToken() ;	
      }  // fin while
   		
   	
      fic.close();
   }

}