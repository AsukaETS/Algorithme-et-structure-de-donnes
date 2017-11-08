package TP7;

import java.util.HashMap;
   
   public class Variables {
   
      private HashMap listeVariables;
   
      Variables () {
      
      	//On met une taille de 26 car il n'y a que 26 variables possibles
         listeVariables = new HashMap(26);
      
      }
   	
      Expression getExpression(char c) {
      
         return (Expression)this.listeVariables.get(c);
      
      }
      
   	void ajouterVariable (char c, Expression e) {
   	
   	this.listeVariables.put(c,e);
   	
   	}
   
   }
