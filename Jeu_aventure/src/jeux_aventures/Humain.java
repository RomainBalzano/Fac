package jeux_aventures;



public class Humain extends Personnage{
    private int nbDeplacements;
    private int niveaux;
    private  static final int PREMIER_PASSAGE_NIVEAU = 4;
    private  static final int SECOND_PASSAGE_NIVEAU = 6;


    public Humain(String nom, int age) {
        super(nom, age);
        this.nbDeplacements=1;
        this.niveaux=1;
    }
    @Override
    public void deplacer(int destination,int gain){
        this.nbDeplacements++;
        if(this.nbDeplacements==PREMIER_PASSAGE_NIVEAU){
            this.niveaux=2;
        }else if(this.nbDeplacements==SECOND_PASSAGE_NIVEAU){
            this.niveaux=3;
        }

        super.deplacer(destination,gain);
    }

    @Override
    public int positionSouhaitee() {

        if (this.position==0){
            position=1;
        }
        return position+(nbDeplacements* this.niveaux);
    }
    @Override
    public String toString() {
        return "Humain "+this.nom;
    }
}
