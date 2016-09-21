import java.util.ArrayList;

public class File {
   private ArrayList<String> F;
   
   File () {
      F=new ArrayList();
   }
   
   public boolean EstVide() {
      return F.isEmpty();
   }
   public int size() {
      return F.size();
   }
   public void add (String e) {
      this.F.add(e) ;
   }
   /** Demontage destructeur **/
   public String get(){
      if (!EstVide()){
         return this.F.remove(0) ;
      }
      return null;
   }
}