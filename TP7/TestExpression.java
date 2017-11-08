package TP7;

public class TestExpression {
   public static void main(String[] args)
   {
       
       /*******************************************************************************/
       /************************CREATION DES EXPRESSIONS*******************************/
       /*******************************************************************************/
// exp : 1 + 3
      Expression exp = new OperationBinaire('+',
                          new Operande(1),
                          new Operande(3));
      System.out.println("Résultat de l'opération binaire 1+3. Résultat attendu : 4");
      System.out.println(exp.getValeur());
        
        
//exp2 : ~(-6)   
      Expression exp2 = new OperationUnaire('~',
                          new Operande(-6)) ;
      System.out.println("Résultat de l'opération unaire ~(-6). Résultat attendu : 6");
      System.out.println(exp2.getValeur()) ;
        
        
//exp3 : |-6|  
      Expression exp3 = new OperationUnaire('!',
                          new Operande(-6)) ;
      System.out.println("Résultat de l'opération unaire |-6|. Résultat attendu : 6");
      System.out.println(exp3.getValeur()) ;
        
        
//exp4 : 2²   
      Expression exp4 = new OperationBinaire('^',
                          new Operande(2),
                          new Operande(2));
      System.out.println("Résultat de l'opération binaire 2². Résultat attendu : 4");
      System.out.println(exp4.getValeur());
        
       /*******************************************************************************/
       /************************TEST DES DIFFERENTES NOTATIONS*************************/
       /*******************************************************************************/            
   
       System.out.println("Affichaqe de l'opération binaire 1+3 en notation infixée. Résultat attendu 1 + 3");
        System.out.println(exp.inFix());
       System.out.println("Affichage de l'opération binaire 1+3 en notation postfixée. Résultat attendu 1 3 +");
        System.out.println(exp.postFix());
       System.out.println("Affichage de l'opération binaire 1+3 en notation prefixée. Résultat attendu + 1 3");
        System.out.println(exp.preFix());
    
       /*******************************************************************************/
       /************************TEST DE LA CLASSE VARIABLES****************************/
       /*******************************************************************************/
       
       Variables ex10 = new Variables() ;
       ex10.ajouterVariable('A', exp3);
       Expression ex11 = new OperationBinaire('+', ex10.getExpression('A'), ex10.getExpression('A'));
       System.out.println("Affichage de l'opération binaire A+A (|-6|+|-6|). Résultat attendu : 12");
       System.out.println(ex11.getValeur());
       
        /*******************************************************************************/
       /************************TEST DE LA CLASSE SYNTAX********************************/
       /*******************************************************************************/      

       //String s = "+53" ;
       //System.out.println(analyse(s));
   
   }
}