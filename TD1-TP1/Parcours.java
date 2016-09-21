package TD1.TP1;

import java.util.ArrayList;
import java.io.*;


public class Parcours
{
   //-STRUCTURE DE DONNEES----------------------------------------------------------------------------
    private ArrayList<Point> points ; 
    private String titre ; 
    private Fenetre maFenetre;
   
   //-CONSTRUCTEUR------------------------------------------------------------------------------------
    Parcours (String titre) {
        this.points = new ArrayList() ;
        this.titre = titre ;
        Fenetre maFenetre = new Fenetre("Altitude course", 1500, 500) ;
    }

   //-METHODES----------------------------------------------------------------------------------------

   public void chargement()throws IOException
   {
   
      double lat, lon, alt, temps;
                  
      FileReader fic = new FileReader("DonneesGPS.csv");
	   StreamTokenizer entree=new StreamTokenizer(fic) ;
      
      entree.quoteChar('"');
   	entree.nextToken();
   	int i =0;
   	while (entree.ttype!=StreamTokenizer.TT_EOF)
   	{
   		lat=entree.nval ;                            // lecture 4 par 4 des donn�es lat , lon, alt et temps
         
         entree.nextToken();
         lon=entree.nval ;
   		
         entree.nextToken();
         alt=entree.nval ;
         
         entree.nextToken();
         temps=entree.nval ;
         
         Point p = new Point( lat, lon, alt, temps ); // creation du point avec les donn�es
         points.add( p );                            // ajout du point au tableau nomm� "points"
         
         entree.nextToken();                          // et on recommence...
   	}
      
      fic.close();
   }
   
   public void afficher()
   {
       for (int i = 0 ; i < points.size() ; i++) {
           System.out.println(points.get(i).toString());
       }
       
   }

   public double altitudeMax()
   {
      double altMax = points.get(0).getAlt() ;
      for (int i =0 ; i < points.size() ; i++) {
          if (altMax <= points.get(i).getAlt()) {
              altMax = points.get(i).getAlt() ;
          }
      }
      return altMax ;
   }

   public double distance()
   {
      double distance = 0 ;
      for (int i = 0 ; i < points.size() ; i++) {
          if (i+1 < points.size()) {
            distance += points.get(i).distance(points.get(i+1)) ;
          }
      }
      return distance;
    }

   public double temps()
   {
      double temps = 0 ; 
      for (int i = 0 ; i < points.size() ; i++) {
          temps += points.get(i).getTemps();
      }
      return temps;
   }

   public void afficherVitesses()
   {
      for (int i = 0 ; i < points.size() ; i++) {
          if (i+1 < points.size()) {
              if (points.get(i).getTemps() != 0) {
                System.out.println("Vitesse : "+(points.get(i).distance(
                    points.get(i+1)))/(points.get(i).getTemps()));
              }
              else {
                System.out.println("Division par 0 impossible.");
              }
          }
      }
      
   }
 
   public double vitesseMoyenne()
   {
       double vitesseMoyenne = 0;
       if (this.temps() != 0) {
           vitesseMoyenne = this.distance()/(this.temps()/3600); 
       }
       else {
           vitesseMoyenne = 0;
       }
       return vitesseMoyenne;
   }

  //  public ArrayList <Double> split( double intervalleDist )
//    {
//       
//    
//    }

   /*public void tracerAltitude()
   {
      int alt = 0;
      int x = 0;
      
      for (int i = 0 ; i < points.size() ; i++) {
          alt = (int) points.get(i).getAlt();
          maFenetre.tracerPoint(x, alt);
          x++;
      }
   }
   public void tracerVitesse()
   {
      
   }*/



}