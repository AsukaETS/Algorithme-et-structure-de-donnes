package TP7;

import java.util.*;

abstract class Expression {
   public abstract boolean estOperande();
   public abstract boolean estOperation();
   public abstract boolean estOperationUnaire();
   public abstract boolean estOperationBinaire();
   public abstract int getValeur();
   public abstract char getOperateur();
   public String toString () {
      return inFix();
   }
   public abstract String inFix();
   public abstract String postFix();
   public abstract String preFix();
}

class Operande extends Expression {
   private int val;
   
   Operande (int v) {
      this.val = v;
   }
   
   public boolean estOperande() { 
      return true;
   }
   
   public int getValeur() {
      return val;
   }
   
   public boolean estOperation() {
      return false;
   }
   
   public boolean estOperationUnaire() {
      return false;
   }
   
   public boolean estOperationBinaire() {
      return false;
   }
   
   public char getOperateur() {
      return ' ';
   }
   
   public String inFix() {
      return "";
   }
   
   public String preFix() {
      return "";
   }
   
   public String postFix() {
      return "";
   }
}

class OperationUnaire extends Expression {
   private char op;
   private Expression exp;
   
   OperationUnaire (char op, Expression exp) {
      this.op = op;
      this.exp = exp;
   }
   
   public int getValeur() {
      int val = 0;
      switch(op) {
         case '~' :
            val = - (this.exp.getValeur());
            break;
         case '!' :
            val = Math.abs(this.exp.getValeur()) ;
            break ;
      }
      return val;
   }
   
   public boolean estOperande() {
      return false;
   }
   
   public boolean estOperation() {
      return false;
   }
   
   public boolean estOperationUnaire() {
      return false;
   }
   
   public boolean estOperationBinaire() {
      return false;
   }
   
   public char getOperateur() {
      return op;
   }
   
   public String inFix() {
      return ""+this.op+"("+this.exp+")";
   }
   
   public String preFix() {
      return ""+this.op+" "+this.exp.preFix()+"";
   }
   
   public String postFix() {
      return ""+this.exp.postFix()+" "+this.op+"";
   }
}

class OperationBinaire extends Expression {
   private char op;
   private Expression expG;
   private Expression expD;
   
   OperationBinaire (char op, Expression G, Expression D) {
      this.op = op;
      this.expG = G;
      this.expD = D;
   }
   
   public boolean estOperande() {
      return false;
   }
   
   public boolean estOperation() {
      return false;
   }
   
   public boolean estOperationUnaire() {
      return false;
   }
   
   public boolean estOperationBinaire() {
      return false;
   }
   
   public char getOperateur() {
      return op;
   }
      
   public int getValeur() {
      int val = 0;
      switch(op) {
         case '+' :
            val = this.expG.getValeur() + this.expD.getValeur();
            break;
         case '*' :
            val = this.expG.getValeur() * this.expD.getValeur();
            break;
         case '-' :
            val = this.expG.getValeur() - this.expD.getValeur();
            break;
         case '/' :
            val = this.expG.getValeur() / this.expD.getValeur();
            break;
         case '^' : 
            val = (int)Math.pow(this.expG.getValeur(),this.expD.getValeur());
            break;
      }
      return val;
   }
   
   public String inFix() {
      return ""+this.expG.getValeur()+" "+this.op+" "+this.expD.getValeur()+"";
   }
   
   public String preFix() {
      return ""+this.op+" "+this.expG.getValeur()+" "+this.expD.getValeur()+"";
   }
   
   public String postFix() {
      return ""+this.expG.getValeur()+" "+this.expD.getValeur()+" "+this.op+"";
   }
}