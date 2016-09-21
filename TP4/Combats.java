public class Combats {
    Personnage a;
    Personnage b;
    Personnage c;
    Personnage d;
    
    File equipe1;
    File equipe2;
    
        Combats(Personnage a, Personnage b, Personnage c, Personnage d){
        this.a=a; 
        this.b=b; 
        this.c=c; 
        this.d=d; 
    }
    
    public void ouvrirArene(){
        this.equipe1 = new File();
        this.equipe2 = new File();
        equipe1.add(a);
        equipe1.add(b);
        equipe2.add(c);
        equipe2.add(d);
        
        System.out.println("\n\nCr�ation de l'ar�ne:\n---Composition des �quipes:---\n");
        System.out.println("-Equipe A:-\n");
        System.out.println(a+"\n");
        System.out.println(b+"\n");
        System.out.println("-Equipe B:-\n");
        System.out.println(c+"\n");
        System.out.println(d);
        System.out.println("------------------------------");
    }
    
    public char combat(){
        System.out.println("\n\n-D�but du combat !-");
        File arene = new File();
        boolean aEnVie = true;
        boolean bEnVIe = true;
        while((a.getVie()>0||b.getVie()>0)&&(c.getVie()>0||d.getVie()>0)){
            Personnage cbt1 = equipe1.get();
            Personnage cbt2 = equipe2.get();
            int degats1 = cbt1.attaque();
            int degats2 = cbt2.attaque();
            if(degats1 > degats2){
                System.out.println("Combattant �quipe A type "+cbt1.getType()+" attaque combattant �quipe B type "+cbt2.getType());
                cbt2.blesse();
                if(cbt2.getVie()>0){
                    equipe2.add(cbt2);
                    equipe1.add(cbt1);
                } else {
                    System.out.println("Combattant �quipe B type "+cbt2.getType()+" est mort des suites de ses blessures...");
                    equipe1.add(cbt1);
                }
            }else if(degats2 > degats1){
                System.out.println("Combattant �quipe B type "+cbt2.getType()+" attaque combattant �quipe A type "+cbt1.getType());
                cbt1.blesse();
                if(cbt1.getVie()>0){
                    equipe1.add(cbt1);
                    equipe2.add(cbt2);
                } else {
                    System.out.println("Combattant �quipe A type "+cbt1.getType()+" est mort des suites de ses blessures...");
                    equipe2.add(cbt2);
                }
            } else {
                System.out.println("Les d�gats sont annul�s... D:");
                equipe1.add(cbt1);
                equipe2.add(cbt2);
            }
        }
        
        if(a.getVie()<=0&&b.getVie()<=0){
            System.out.println("\n\nL'�quipe A est d�cim�e...");
            System.out.println("- Fin du combat ! -");
            resultTab();
            return 'B';
        } else if(c.getVie()<=0&&d.getVie()<=0) {
            System.out.println("\n\nL'�quipe B est d�cim�e...");
            resultTab();
            
            return 'A';
        } else {
            System.out.println("\n\nErreur inattendue O_o");
            System.out.println("- Fin du combat ! -");
            resultTab();
            return 'E';
        }
    }
    
    public void resultTab(){
        System.out.println("\n\nR�sultats du combat:\n");
        System.out.println("-Equipe A:-\n");
        System.out.println(a+"\n");
        System.out.println(b+"\n");
        System.out.println("-Equipe B:-\n");
        System.out.println(c+"\n");
        System.out.println(d);
        System.out.println("------------------------------");
    }
}