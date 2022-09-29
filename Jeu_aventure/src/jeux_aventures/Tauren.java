package jeux_aventures;
import java.lang.Math;

public class Tauren extends Personnage {

    private int taille;
    public Tauren(String nom, int age, int taille) {
        super(nom, age);
        this.taille=taille;
    }

    @Override
    public int positionSouhaitee() {

        return (int) Math.round(Math.random()* this.taille);
    }

    @Override
    public String toString() {
        return "Tauren "+this.nom;
    }
}
