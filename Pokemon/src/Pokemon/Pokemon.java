
package Pokemon;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

import static Pokemon.Excel.*;


public class Pokemon {
    private String nom;
    private String evolution1;
    private String evolution2;
    private int pv;
    private int pc_physique;
    private int pc_special;
    private int bonbon;
    private String type1;
    private String type2;
    private int vitesse;

    private int stadeEvolution;



    public Pokemon(String nom, String evolution1, String evolution2, int pv, int pc_physique, int pc_special, int bonbon,
                   String type1, String type2, int vitesse, int stadeEvolution) {
        this.evolution1 = evolution1;
        this.evolution2 = evolution2;
        this.pv = pv;
        this.pc_physique = pc_physique;
        this.pc_special = pc_special;
        this.bonbon = bonbon;
        this.type1 = type1;
        this.type2 = type2;
        this.vitesse = vitesse;
        this.stadeEvolution = stadeEvolution;
        if (stadeEvolution==1){
            this.nom=evolution1;
        } else if (stadeEvolution==2) {
            this.nom=evolution2;
        }
        else{
            this.nom = nom;
        }

    }

    public Pokemon() throws IOException {

            ArrayList<String> pokemon=getRandPokemon();
            this.nom=pokemon.get(0);
            this.evolution1=pokemon.get(1);
            this.evolution2=pokemon.get(2);
            this.type1=pokemon.get(3);
            this.type2=pokemon.get(4);

            this.pv=1 + (int)(Math.random() * ((100 - 50) + 1));
            this.pc_physique=1 + (int)(Math.random() * ((100 - 30) + 1));
            this.pc_special=1 + (int)(Math.random() * ((100 - 30) + 1));
            this.vitesse=this.pc_physique=1 + (int)(Math.random() * ((100 - 20) + 1));

            this.bonbon=0;
            this.stadeEvolution=0;




    }
    public Pokemon(String nom) throws IOException {

        ArrayList<String> pokemon=getPokemon(nom);
        this.nom=pokemon.get(0);
        this.evolution1=pokemon.get(1);
        this.evolution2=pokemon.get(2);
        this.type1=pokemon.get(3);
        this.type2=pokemon.get(4);

        this.pv=1 + (int)(Math.random() * ((100 - 50) + 1));
        this.pc_physique=1 + (int)(Math.random() * ((100 - 30) + 1));
        this.pc_special=1 + (int)(Math.random() * ((100 - 30) + 1));
        this.vitesse=this.pc_physique=1 + (int)(Math.random() * ((100 - 20) + 1));

        this.bonbon=0;
        this.stadeEvolution=0;


    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEvolution1() {
        return evolution1;
    }

    public String getEvolution2() {
        return evolution2;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPc_physique() {
        return pc_physique;
    }

    public void setPc_physique(int pc_physique) {
        this.pc_physique = pc_physique;
    }

    public int getPc_special() {
        return pc_special;
    }

    public void setPc_special(int pc_special) {
        this.pc_special = pc_special;
    }

    public int getBonbon() {
        return bonbon;
    }

    public void setBonbon(int bonbon) {
        this.bonbon = bonbon;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
    public int getStadeEvolution() {

        return stadeEvolution;
    }

    public void setStadeEvolution(int stadeEvolution) {
        this.stadeEvolution = stadeEvolution;
    }



    public  void Attaque(Pokemon pokemon,int choix) throws IOException {
        int puissance=0;

        ArrayList<String> tabType=new ArrayList<>();
        ArrayList<String> tabEnnemie=new ArrayList<>();
        tabEnnemie=getType(pokemon.getType1());
        ArrayList<String> tabEnnemie2=new ArrayList<>();
        double ratio;
        int ancienpc=1;

        if (!Objects.equals(pokemon.getType2(), "NULL")){
            tabEnnemie2=getType(pokemon.getType2());
        }
        int index = 0;

        if (choix==1){
            tabType=getType(this.getType1());

            if (tabType.get(6).equals("Special")){

                puissance=this.pc_special;
                ancienpc=puissance;
                //Super Efficace
                index = tabEnnemie.get(4).indexOf(tabType.get(0));

                if(index!=-1){
                    puissance=puissance*2;

                }
                if (!Objects.equals(pokemon.getType2(), "NULL")){

                    index = tabEnnemie2.get(4).indexOf(tabType.get(0));
                    if(index!=-1){
                        puissance=puissance*2;
                    }
                }
                //Fin SuperEfficace
                //Resistance
                index = tabEnnemie.get(3).indexOf(tabType.get(0));
                System.out.println(index);
                if(index!=-1){
                    puissance=puissance/2;

                }
                if (!Objects.equals(pokemon.getType2(), "NULL")){

                    index = tabEnnemie2.get(3).indexOf(tabType.get(0));
                    if(index!=-1){
                        puissance=puissance/2;
                    }
                }
                //Fin Resistance
                index = tabEnnemie.get(2).indexOf(tabType.get(0));
                if(index!=-1){
                    puissance=0;

                }
                if (!Objects.equals(pokemon.getType2(), "NULL")){

                    index = tabEnnemie2.get(2).indexOf(tabType.get(0));
                    if(index!=-1){
                        puissance=0;
                    }
                }

            } else if ((tabType.get(6).equals("Physique"))) {
                {

                    puissance=this.pc_physique;
                    ancienpc=puissance;
                    //Super Efficace
                    index = tabEnnemie.get(4).indexOf(tabType.get(0));
                    if(index!=-1){
                        puissance=puissance*2;

                    }
                    if (!Objects.equals(pokemon.getType2(), "NULL")){

                        index = tabEnnemie2.get(4).indexOf(tabType.get(0));
                        if(index!=-1){
                            puissance=puissance*2;
                        }
                    }
                    //Fin SuperEfficace
                    //Resistance
                    index = tabEnnemie.get(3).indexOf(tabType.get(0));

                    if(index!=-1){
                        puissance=puissance/2;

                    }
                    if (!Objects.equals(pokemon.getType2(), "NULL")){

                        index = tabEnnemie2.get(3).indexOf(tabType.get(0));
                        if(index!=-1){
                            puissance=puissance/2;
                        }
                    }
                    //Fin Resistance
                    index = tabEnnemie.get(2).indexOf(tabType.get(0));
                    if(index!=-1){
                        puissance=0;

                    }
                    if (!Objects.equals(pokemon.getType2(), "NULL")){

                        index = tabEnnemie2.get(2).indexOf(tabType.get(0));
                        if(index!=-1){
                            puissance=0;
                        }
                    }

                }

            }


        } else if (choix==2 && !Objects.equals(this.getType2(), "NULL")) {



                tabType=getType(this.getType2());
                if (tabType.get(6).equals("Special")){

                    puissance=this.getPc_special();
                    ancienpc=puissance;
                    //Super Efficace
                    index = tabEnnemie.get(4).indexOf(tabType.get(0));

                    if(index!=-1){
                        puissance=puissance*2;

                    }
                    if (!Objects.equals(pokemon.getType2(), "NULL")){

                        index = tabEnnemie2.get(4).indexOf(tabType.get(0));
                        if(index!=-1){
                            puissance=puissance*2;
                        }
                    }
                    //Fin SuperEfficace
                    //Resistance
                    index = tabEnnemie.get(3).indexOf(tabType.get(0));

                    if(index!=-1){
                        puissance=puissance/2;

                    }
                    if (!Objects.equals(pokemon.getType2(), "NULL")){

                        index = tabEnnemie2.get(3).indexOf(tabType.get(0));
                        if(index!=-1){
                            puissance=puissance/2;
                        }
                    }
                    //Fin Resistance
                    index = tabEnnemie.get(2).indexOf(tabType.get(0));
                    if(index!=-1){
                        puissance=0;

                    }
                    if (!Objects.equals(pokemon.getType2(), "NULL")){

                        index = tabEnnemie2.get(2).indexOf(tabType.get(0));
                        if(index!=-1){
                            puissance=0;
                        }
                    }

                } else if ((tabType.get(6).equals("Physique"))) {
                    {

                        puissance=getPc_physique();
                        ancienpc=puissance;
                        //Super Efficace
                        index = tabEnnemie.get(4).indexOf(tabType.get(0));

                        if(index!=-1){
                            puissance=puissance*2;

                        }
                        if (!Objects.equals(pokemon.getType2(), "NULL")){

                            index = tabEnnemie2.get(4).indexOf(tabType.get(0));
                            if(index!=-1){
                                puissance=puissance*2;
                            }
                        }
                        //Fin SuperEfficace
                        //Resistance
                        index = tabEnnemie.get(3).indexOf(tabType.get(0));

                        if(index!=-1){
                            puissance=puissance/2;

                        }
                        if (!Objects.equals(pokemon.getType2(), "NULL")){

                            index = tabEnnemie2.get(3).indexOf(tabType.get(0));
                            if(index!=-1){
                                puissance=puissance/2;
                            }
                        }
                        //Fin Resistance
                        index = tabEnnemie.get(2).indexOf(tabType.get(0));
                        if(index!=-1){
                            puissance=0;

                        }
                        if (!Objects.equals(pokemon.getType2(), "NULL")){

                            index = tabEnnemie2.get(2).indexOf(tabType.get(0));
                            if(index!=-1){
                                puissance=0;
                            }
                        }

                    }




            }

        }else if (choix==3){
            //Pas eu le temps normalement le statue
        }

        if(puissance==0){
            System.out.println("L'attaque ne l'affecte pas");
        } else {
            if(puissance%2!=0){
                ratio=(double)(puissance-1)/(double)(ancienpc);
            }else{
                ratio=(double)(puissance)/(double)(ancienpc);
            }

            if(ratio==2){
                System.out.println("C'est super efficace");
            } else if (ratio==4) {
                System.out.println("C'est ultra efficace");
            } else if (ratio<=1) {
                System.out.println("C'est pas tres efficace");
            }else if (ratio==0.25) {
                System.out.println("C'est vraiment pas tres efficace");
            }


        }
        pokemon.setPv(pokemon.getPv()-puissance);
    }
    public static void main(String[] args) throws IOException {








    }



}
