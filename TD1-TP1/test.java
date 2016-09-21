package TD1.TP1;

import java.io.IOException;
import java.util.ArrayList;


public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Point p1 = new Point(46.056425, -1.083614, 0, 12);
        Point p2 = new Point(46.056455, -1.08347, 5, 12);
        Point p3 = new Point(46.056377, -1.83457, 4, 11.9);
        Point p4 = new Point(46.056393, -1.083334, 4, 11.8);
        Point p5 = new Point(46.056356, -1.083223, 5, 11.7);
        System.out.println(p1);
        System.out.println(p2.getAlt());
        System.out.println(p1.getLat());
        
        System.out.println(p1.distance(p2));
       
       Parcours par1 = new Parcours ("Petite balade champetre") ;
       par1.chargement() ;
       /*par1.afficher() ;*/
       
       System.out.println ("Altitude Max : "+par1.altitudeMax()) ;
       System.out.println ("Distance du parcours : "+par1.distance()) ;
       System.out.println ("Temps : "+par1.temps()) ;
       par1.afficherVitesses() ;
       if (par1.vitesseMoyenne() == 0) {
           System.out.println("Erreur dans la division.") ;
       }
       else {
           System.out.println("Vitesse moyenne : "+par1.vitesseMoyenne()+" km/h.") ;
       }
       
    } 
    
}
