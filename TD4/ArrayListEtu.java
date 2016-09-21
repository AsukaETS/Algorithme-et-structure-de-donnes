import java.util.ArrayList ;

class ArrayListEtu extends ArrayList {

   ArrayListEtu() {
   super() ;
   }

   public boolean Add (Object e) {
   super.add(0,e) ;
   return true ;  
   }
}