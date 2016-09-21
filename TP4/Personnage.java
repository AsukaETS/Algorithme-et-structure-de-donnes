public abstract class Personnage
{
 //CONSTANTES -----------------------------------------
 //Type de personnages
   public static final int TYPE_CHEVALIER = 0;
   public static final int TYPE_EXCALIBUR = 1;
   public static final int TYPE_ENCHANTEUR = 2;
   public static final int TYPE_TRUQUEUR = 3;
   private final int NB_TYPES = 4;
 
 //Cibles possibles (partie 2 TP)
   public static final int CIBLE_TETE = 0;
   public static final int CIBLE_VENTRE = 1;
   public static final int CIBLE_JAMBES = 2;
   private final int NB_CIBLES = 3;
 //-----------------------------------------------------

   protected int vie;      // parametre commun a tous les personnages
   protected int typePers;     // type du personnage créé selon constantes
 
   public int getVie()
   {
      return this.vie;
   }
 
   protected int Alea(int min, int max)  // tirage au sort entre min et max
   {
      return  min +(int)(Math.random()*(max - min + 1));
   }
 
   public int getType()      // renvoie le type de personnage selon les constantes
   {
      return this.typePers;
   }

   public abstract int attaque();  // renvoie un entier proposionnel à la force de l'attaque
   public abstract void blesse();  // methode diminuant les parametres
   public abstract String toString(); // methode permettant d'afficher un personnage
 
}

abstract class  magicien extends Personnage
{
   protected int magie ;
} 
abstract class guerrier extends Personnage
{
   protected int force ;
}

class enchanteur extends magicien
{
   private int aura ;
   
   enchanteur (int vie, int magie, int aura) {
      super.typePers = TYPE_ENCHANTEUR ;
      super.vie = vie ;
      this.magie = magie ;
      this.aura = aura ;
   }
   
   public int attaque() {
      int A = Alea(0,vie)+Alea(0,magie)+Alea(0,aura) ;
      return A ;
   }
   public void blesse() {
      this.vie = vie-Alea(20,40);
   }
    public String toString() {
        return "Enchanteur ("+this.typePers+")\n   Vie: "+this.vie+"\n   Magie: "+this.magie+"\n   Aura: "+this.aura;
    }
}


class truqueur extends magicien
{
   private int malice ;
   
   truqueur (int vie, int magie, int malice) {
      super.typePers = TYPE_TRUQUEUR ;
      super.vie = vie ;
      this.magie = magie ;
      this.malice = malice ;
   }
   public int attaque() {
      int A = Alea(0,vie)+Alea(0,magie)+Alea(0,malice) ;
      return A ;
   }
   public void blesse() {
      this.vie = vie-Alea(20,40);
   }
    public String toString() {
        return "Truqueur ("+this.typePers+")\n   Vie: "+this.vie+"\n   Magie: "+this.magie+"\n   Malice: "+this.malice;
    }
}

class chevalier extends guerrier 
{
   private int courage ;
   
   chevalier (int vie, int force, int courage) {
      super.typePers = TYPE_CHEVALIER ;
      super.vie = vie ;
      this.force = force ;
      this.courage = courage ;
   }
   public int attaque() {
      int A = Alea(0,vie)+Alea(0,force)+Alea(0,courage) ;
      return A ;
   }
   public void blesse() {
      this.vie = vie-Alea(20,40);
   }
    public String toString() {
        return "Chevalier("+this.typePers+")\n   Vie: "+this.vie+"\n   Force: "+this.force+"\n   Courage: "+this.courage;
    }
}

class excalibur extends guerrier
{
   private int agressivité ;	
   
   excalibur (int vie, int force, int agressivité) {
      super.typePers = TYPE_EXCALIBUR ;
      super.vie = vie ;
      this.force = force ;
      this.agressivité = agressivité ;
   }
   public int attaque() {
      int A = Alea(0,vie)+Alea(0,force)+Alea(0,agressivité) ;
      return A ;
   }
   public void blesse() {
      this.vie = vie-Alea(20,40);
   }
    public String toString() {
        return "Excalibur ("+this.typePers+")\n   Vie: "+this.vie+"\n   Force: "+this.force+"\n   Agressivité: "+this.agressivité;
    }
	
}