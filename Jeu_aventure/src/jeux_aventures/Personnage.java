package jeux_aventures;

public abstract class Personnage {
    protected String nom;
    protected int age;
    protected int position=0;
    public Joueur proprietaire;

    public Personnage(String nom,int age){
        this.nom=nom;
        this.age=age;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public int getPosition() {

        return this.position;
    }

    public void deplacer(int destination, int gain){
        this.position=destination;
        proprietaire.modifierPoints(proprietaire.getNbPoints()+gain);


    }
    public void penaliser(int penalite){
        if ((proprietaire.getNbPoints()-penalite)>0)
            proprietaire.modifierPoints(proprietaire.getNbPoints()-penalite);
        else {
            proprietaire.modifierPoints(0);
        }

    }
    public String toString(){
        return this.nom;
    }
    public abstract int positionSouhaitee();

}
