//
// <Expression>       ::= <Operande> | <OperationUnaire> | <OperationBinaire>
// <Operande>         ::= <entierRelatif>
// <entierRelatif>    ::= ['-'] '1'..'9' ['0'..'9']*
// <OperationUnaire>  ::= <OperateurUnaire> <Exp>
// <Exp>              ::= <Expression>
// <OperateurUnaire>  ::= '-'
// <OperationBinaire> ::= <ExpGauche> <OperateurBinaire> <ExpDroite>
// <ExpGauche>        ::= <Expression>
// <ExpDroite>        ::= <Expression>
// <OperateurBinaire> ::= '+' | '-' | '*' | '/'


abstract class Expression {
   public abstract boolean estOperande();
   public abstract boolean estOperation();
   public abstract boolean estOperationUnaire();
   public abstract boolean estOperationBinaire();
   public abstract int getValeur();
   public abstract char getOperateur();
   public abstract String inFix();
   public abstract String postFix();
   public abstract String preFix();
   
   public String toString () {
      return inFix();
   }
}

class Operande extends Expression {
   private int val;
   
   Operande (int val) {
      this.val = val;
   }
   
   public boolean estOperande() {
      return true ; 
   }
   public int getValeur() {
      return val ;
   } 
   public boolean estOperation() {
      return false ;
   }
   public boolean estOperationUnaire() {
      return false ;
   }
   public boolean estOperationBinaire() {
      return false ;
   }
   public char getOperateur() {
      return ' ';   
   }
   public String inFix() {
      return "" ;
   }
   public String postFix() {
      return "" ;
   }
   public String preFix() {
      return "" ;
   }
}

class OperationUnaire extends Expression {
   private char op;
   private Expression exp;
   int val = 0 ;
   
   OperationUnaire (char op, Expression exp) {
      this.op = op ;
      this.exp =exp ;
   }
   
   public boolean estOperande() {
      return false ; 
   }
   public boolean estOperation() {
      return true ;
   } 
   public boolean estOperationUnaire() {
      return true ;
   }
   public boolean estOperationBinaire() {
      return false ;
   }
   public char getOperateur() {
      return op;   
   }
   public int getValeur() {
      switch(op) {
         case '~' :
            val = this.exp.getValeur()*(-1) ;
            break ;
         case '!' :
            val = Math.abs(this.exp.getValeur()) ;
            break ;
      }
      return val ;
   }
   public String inFix() {
      return ""+this.op+" "+this.exp.getValeur()+"" ;
   }
   
   public String postFix() {
      return ""+this.exp.getValeur()+" "+this.op+"" ;
   }
   
   public String preFix() {
      return ""+this.op+" "+this.exp.getValeur()+"" ;
   }
}

class OperationBinaire extends Expression {
   
   private char op;
   private Expression expG;
   private Expression expD;
   
   OperationBinaire (char op, Expression expG, Expression expD) {
      this.op = op ;
      this.expG =expG ;
      this.expD = expD ;
   }
   
   public boolean estOperande() {
      return false ; 
   }
   public boolean estOperation() {
      return true ;
   }
   public boolean estOperationUnaire() {
      return false ;
   }
   public boolean estOperationBinaire() {
      return true ;
   }
   public char getOperateur() {
      return op;   
   }
   
   public int getValeur() {
      int val = 0;
      switch(op) {
         case '+' :
            val = this.expG.getValeur() + this.expD.getValeur() ;
            break ;
         case '*' :
            val = this.expG.getValeur() * this.expD.getValeur() ;
            break ;
         case '-' : 
            val = this.expG.getValeur() - this.expD.getValeur() ;
            break ;
         case '/' :
            val = this.expG.getValeur() / this.expD.getValeur() ;
            break ;
         case '^' :
            val = (int)Math.pow(this.expG.getValeur(),this.expD.getValeur()) ;
            break ;
      }
      return val ;
   }
   
   public String inFix() {
      return ""+this.expG.getValeur()+" "+this.op+" "+this.expD.getValeur()+"" ;
   }
   
   public String postFix() {
      return ""+this.expG.getValeur()+" "+this.expD.getValeur()+" "+this.op+"" ;
   }
     
   public String preFix() {
      return ""+this.op+" "+this.expG.getValeur()+" "+this.expD.getValeur()+"" ;
   }
}
   
class Syntax
{
   private String chaine;
   private int index;
	
   Syntax()
   {
      this.index = 0;
   }
	
   public Expression analyse( String s )
   {
      this.chaine = s;
      return exp();
   }
	
   private Expression exp()
   {
      // analyse et construction d'une expression
      return null ;
   }
}


/******************************************************************************/
/******************************TEST********************************************/
/******************************************************************************/

class TestExpression {
   public static void main(String[] args)
   {
   	// exp : 1 + 3
      Expression exp = new OperationBinaire('+',
                          new Operande(1),
                          new Operande(3));
      System.out.println(exp.getValeur());
        
        
     //exp2 : ~(-6)   
      Expression exp2 = new OperationUnaire('~',
                          new Operande(-6)) ;
      System.out.println(exp2.getValeur()) ;
        
        
     //exp3 : |-6|  
      Expression exp3 = new OperationUnaire('!',
                          new Operande(-6)) ;
      System.out.println(exp3.getValeur()) ;
        
        
     //exp4 : 2²   
      Expression exp4 = new OperationBinaire('^',
                          new Operande(2),
                          new Operande(2));
      System.out.println(exp4.getValeur());
        
   /*********************************************************************/             
   
      System.out.println(exp.inFix());
      System.out.println(exp.postFix());
      System.out.println(exp.preFix());
   
   }
}