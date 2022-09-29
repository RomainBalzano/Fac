

package jeux_aventures;

public class Main {
        public static void main(String[] args) {



            Jeu jeu =new Jeu( "AtelierPOO" ,4,10 );

            Joueur j1=new Joueur("Paul");
            Personnage p1_1=new Tauren("Hector",15,10);
            Personnage p1_2=new Humain("Jean",10);
            j1.ajouterPersonnage(p1_1);
            j1.ajouterPersonnage(p1_2);

            Joueur j2=new Joueur("Lucien");
            Personnage p2_1=new Tauren("Hercule",20,5);
            Personnage p2_2=new Humain("Marie",10);
            j2.ajouterPersonnage(p2_1);
            j2.ajouterPersonnage(p2_2);

            jeu.ajouterJoueur(j1);
            jeu.ajouterJoueur(j2);

            jeu.lancerJeu();
            jeu.afficherResultats();

        }

    }

