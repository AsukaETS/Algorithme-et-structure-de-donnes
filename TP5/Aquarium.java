package TP5;

import java.util.ArrayList;
import java.awt.*;
import java.util.Iterator;

public class Aquarium
{

   public static final int PASMAXPROIES = 4;
   public static final int ESPACEVITALX = 100;
   public static final int ESPACEVITALY = 100;
   public static final int DUREEVIE = 100;

   private ArrayList <Proie> lesProies;
   private ArrayList <Predateur> lesPredateurs;

   private Fenetre maFenetre;  //une vue graphique


   Aquarium (int NbProies, int NbPredateurs)
   {
      lesProies = new ArrayList();
      this.lesPredateurs = new ArrayList();
      for (int i =0; i<NbProies; i++) {
         this.lesProies.add( new Proie( Aleatoire(0, ESPACEVITALX) , Aleatoire(0, ESPACEVITALY) )  ); }
         for (int i =0; i<NbPredateurs; i++) {
         this.lesPredateurs.add( new Predateur( Aleatoire(0, ESPACEVITALX) , Aleatoire(0, ESPACEVITALY) )  ); }
   	   	
      maFenetre = new Fenetre("Proies Predateurs", 500, 500, this.lesProies, this.lesPredateurs, 0, Color.RED, Color.BLACK); // Cr�ation de la fen�tre graphique
   	
   }

   public void simulation(int nb )
   {
      int temps=0;
      while (temps != nb)
      {
      	   		
         deplacements();
      	
         Proie.regenererNourritureProies(5);
         System.out.println("Predateurs :"+this.lesPredateurs.size()+"  Proies :"+this.lesProies.size() );
      	
         mortalité();
         reproPredateurs() ;
         reproProies() ;
         temps++;
         
         // affichage dans la vue
         maFenetre.mise_a_jour(this.lesProies, this.lesPredateurs, temps); // mise en jour des variables modèle
         maFenetre.repaint(); // on redessine la vue
         try {
            Thread.sleep(100);   // on ralentit la simulation 0.1s ici
         } 
         catch(InterruptedException e){ }
      
      }
   }

   private void deplacements()
   {
      for( int j=0; j< this.lesProies.size(); j++)
      {
         (this.lesProies.get(j)).deplacement();
      }
      for( int j=0; j< this.lesPredateurs.size(); j++)
      {
         (this.lesPredateurs.get(j)).deplacement();
      }

   	
   }
   	
   private void mortalité()
   {
     		
         // 1) vieilles proies
       ArrayList <Proie> proiesToRemove = new ArrayList();
       for(int i=0; i<lesProies.size();i++) {
           if (this.lesProies.get(i).getVie() <= 0) {
               proiesToRemove.add(this.lesProies.get(i)) ;
          }
      }
       this.lesProies.removeAll(proiesToRemove);
         
         // 2) vieux predateurs
         ArrayList <Predateur> predsToRemove = new ArrayList();
       for(int i=0; i<lesPredateurs.size();i++) {
           if (this.lesPredateurs.get(i).getVie() <= 0) {
               predsToRemove.add(this.lesPredateurs.get(i)) ;
          }
      }
       this.lesPredateurs.removeAll(predsToRemove);

         
         // 3) predation
         for (int i = 0; i < this.lesProies.size(); i++) {
         for (int j = 0; j < this.lesPredateurs.size(); j++) {
            if (this.lesProies.get(i).getX() == this.lesPredateurs.get(j).getX() && 
               this.lesProies.get(i).getY() == this.lesPredateurs.get(j).getY() &&
               this.lesPredateurs.get(j).getFaim() < 75) {
               this.lesPredateurs.get(j).mange();
               this.lesProies.get(i).setVie(0) ;
            }
         }
      }
   
   		
   }
   	
   private void reproProies()
   {
      ArrayList <Proie> bebe = new ArrayList();
      for (int i = 0; i < this.lesProies.size(); i++) {
         for (int j = 0; j < this.lesProies.size(); j++) {
            if (this.lesProies.get(i).getX() == this.lesProies.get(j).getX() && 
                this.lesProies.get(i).getY() == this.lesProies.get(j).getY() &&
                this.lesProies.get(i).getVie()<= 250 &&
                this.lesProies.get(j).getVie() <= 250 &&
                i != j ) {
               int al = Aleatoire(1,2) ;
               if (al == 1) {
                  bebe.add(new Proie( Aleatoire(0, ESPACEVITALX) , Aleatoire(0, ESPACEVITALY)));
                  System.out.println("OUAI UN BBY PROIE !") ;
               }
               else {
                  bebe.add(new Proie( Aleatoire(0, ESPACEVITALX) , Aleatoire(0, ESPACEVITALY)));
                  bebe.add(new Proie( Aleatoire(0, ESPACEVITALX) , Aleatoire(0, ESPACEVITALY)));
                  System.out.println("OUAI DEUX BBY PROIE !") ;
               }
            }
         }
      }
      for (int x=0 ; x < bebe.size(); x++) {
         lesProies.add(bebe.get(x)) ;
      }
   }
   
   private void reproPredateurs() 
   {
      ArrayList <Predateur> bebe = new ArrayList();
      for (int i = 0; i < this.lesPredateurs.size(); i++) {
         for (int j = 0; j < this.lesPredateurs.size(); j++) {
            if (this.lesPredateurs.get(i).getX() == this.lesPredateurs.get(j).getX() && 
                this.lesPredateurs.get(i).getY() == this.lesPredateurs.get(j).getY() &&
                this.lesPredateurs.get(i).getVie()<= 100 &&
                this.lesPredateurs.get(j).getVie() <= 100 &&
                i != j ) {
               int al = Aleatoire(1,2) ;
               if (al == 1) {
                  bebe.add(new Predateur( Aleatoire(0, ESPACEVITALX) , Aleatoire(0, ESPACEVITALY)));
                  System.out.println("OUAI UN BBY PREDATEUR !") ;
               }
               else {
                  bebe.add(new Predateur( Aleatoire(0, ESPACEVITALX) , Aleatoire(0, ESPACEVITALY)));
                  bebe.add(new Predateur( Aleatoire(0, ESPACEVITALX) , Aleatoire(0, ESPACEVITALY)));
                  System.out.println("OUAI DEUX BBY PREDATEUR !") ;
               }
            }
         }
      }
      for (int x=0 ; x < bebe.size(); x++) {
         lesPredateurs.add(bebe.get(x)) ;
      }
   }

   	
   	
   private int Aleatoire( int min, int max )
   {
      return (int) ((Math.random()*(max-min+1))+ min);
   }
   
   
   private boolean probaRealisation( double pourcentage )
   {
      double val = Math.random();
      if (val<=pourcentage)
         return true;
      else
         return false;
   
   }

}