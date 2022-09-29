package jeux_aventures;

import java.util.*;


public class Joueur {

    public String nom;
    public String code;
    public static int nbJoeurs=0;
    public int nbPoints;
    public ArrayList<Personnage> list_personnage = new ArrayList();

    public Joueur(String nom){
        nbJoeurs++;
        this.nom=nom;
        this.code="J"+nbJoeurs;
        this.nbPoints=0;

    }
    public void ajouterPersonnage(Personnage personnage) {
        if ((personnage==null) && list_personnage.contains(personnage)) {
            System.out.println("erreur");
        }
        else {
            personnage.setProprietaire(this);
            list_personnage.add(personnage);
        }
    }
    public void modifierPoints( int point){
        this.nbPoints=point;
    }

    public int getNbPoints() {
        return this.nbPoints;
    }

    public boolean peutJoueur(){
        return !list_personnage.isEmpty();
    }
    public String toString(){
        String affichage;
        if (list_personnage.isEmpty()){
            affichage=this.code+" "+this.nom+"("+this.nbPoints+")"+" avec aucun personnages";
        }
        else {
            affichage=this.code+" "+this.nom+"("+this.nbPoints+")"+" avec "+list_personnage.size()+" personnages";
        }
        return affichage;
    }

}
