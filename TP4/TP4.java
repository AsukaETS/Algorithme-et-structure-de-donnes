class TP4 {
   public static void main (String[] args) {
      
      enchanteur Roger = new enchanteur (200,50,75) ;
      truqueur Bernard = new truqueur (150,30,80) ;
      chevalier Patrick = new chevalier (300,100,90) ;
      excalibur Fabrice = new excalibur (250,150,60) ;
      
      System.out.println(Roger.toString() );
      Roger.blesse() ;
      System.out.println(Roger.toString() );
      System.out.println ("Roger ! Attaque lance flamme ! "+Roger.attaque()) ;
      
      Combats Bar = new Combats (Roger, Bernard, Patrick, Fabrice) ;
      Bar.ouvrirArene() ;
   }
}