import java.util.ArrayList;


class TD3 {
   public static void main (String[] args) {
   
      Personne p1= new Personne ("Jean", 5) ;
      Personne p2 = new Personne ("Michel", 3) ;
      Personne p3 = new Personne ("François", 1) ;
      
      FilePrio f1 = new FilePrio() ;
      f1.add(p1) ;
      f1.add(p2) ;
      f1.add(p3) ;
      f1.afficher() ;
   
   
   }

}