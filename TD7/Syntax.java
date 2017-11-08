package TP7;

public class Syntax
   {
      private String chaine;
      private int index;
      private Variables listeVariables;
   
      Syntax(Variables v)
      {
         this.index = 0;
         this.listeVariables = v;
      }
   
      public Expression analyse( String s )
      {
         this.chaine = s;
         return exp();
      }
   
      private Expression exp()
      {
      // analyse et construction d'une expression
      
         char c = chaine.charAt(index);
         index++;
         if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
            return new OperationBinaire(c,exp(),exp());
         else if (c == '~' || c == '!')
            return new OperationUnaire(c,exp());
         else /*if (c == '0' || c == '1' || c == '2' || 
         			c == '3' || c == '4' || c == '5' || 
         			c == '6' || c == '7' || c == '8' || 
         			c == '9') */
         {
            String s1 = ""+c;
            int v = Integer.parseInt(s1);
            return new Operande(v);
         }
         
      }
   }