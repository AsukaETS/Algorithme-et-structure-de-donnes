package TP7;

public class TestExpressions {
    
    public static void main(String[]args){
	 
	 	// ~(3+2)*(-1+4)
		
        Expression exp1 = new OperationBinaire('*', 
		  	new OperationUnaire('~', 
		 		 new OperationBinaire('+', 
		  			new Operande(3), 
		  			new Operande(2))), 
					
		  	new OperationBinaire('+', 
		  		new Operande(4), 
		  		new Operande(-1)));
				
		System.out.println(exp1.getValeur());
		System.out.println(exp1.inFix());
		System.out.println(exp1.postFix());
		System.out.println(exp1.preFix());
		System.out.println(exp1);
        
    }
    
}