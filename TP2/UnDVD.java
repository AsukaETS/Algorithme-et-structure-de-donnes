package TD2.TP2;



public class UnDVD
{
   private String Titre;
   private String NomPhoto;
   private String Texte;
   private int NbExemplaires;
   private int NbEmprunts;


   public UnDVD(String Titre, String photo, String texte, int NbEx)
   {
      this.Titre = Titre ;
      this.NomPhoto = photo ;
      this.Texte = texte ;
      this.NbExemplaires = NbEx ;
      this.NbEmprunts = 0 ;
   }

//----Accesseurs----------------------------------------------
//-------Recuperation-------------------------
   public String Titre(){ 
      return Titre; }

   public String NomPhoto(){ 
      return NomPhoto; }

   public String Texte() { 
      return Texte; }

   public int NbExemplaires(){ 
      return NbExemplaires; }

   public int NbEmprunts(){ 
      return NbEmprunts; }


//-------Mofifications-------------------------
   public void setTitre(String Titre){ this.Titre = Titre; }

   public void setPhoto( String photo ){ this.NomPhoto = photo; }

   public void setTexte( String texte ){ this.Texte = texte; }

   public void setNbExemplaires ( int NbEx ) { this.NbExemplaires= NbEx; }

   public void setEmprunt () {
      if (this.NbEmprunts < this.NbExemplaires) {
         this.NbEmprunts ++ ; 
      }
      else {
         System.out.println("Plus d'exemplaires disponibles.");
      }
   }

   public void setRetour () {
      if (this.NbEmprunts > 0) {
         this.NbEmprunts = this.NbEmprunts - 1;
      }
      else {
         System.out.println("Tous les exemplaires ont �t� rendus.");
      }
   }



//------ Affichage texte ----------------------

   public void Afficher()
   {
      System.out.println("Titre : "+ this.Titre);
      System.out.println("Photo : "+ this.NomPhoto);
      System.out.println("Texte : "+ this.Texte);
      System.out.println("Nombre d'exemplaires : "+ this.NbExemplaires);
      System.out.println("Nombre d'emprunts : "+ this.NbEmprunts +"\n");
   }

}