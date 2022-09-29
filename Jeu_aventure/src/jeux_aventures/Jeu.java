package jeux_aventures;
import java.lang.Math;

import java.util.ArrayList;

public class Jeu {
    private String titre;
    private final static int NB_JOUEUR_MAX=6;
    private final static int NB_CASES=50;
    private  static ArrayList<Joueur> liste_joueur = new ArrayList();
    private  static ArrayList<Case> liste_case = new ArrayList<>();
    private int nbEtapes;
    private int nbObstacles;
    private static int scoreMax=0;

    public Jeu( String titre , int nbEtapes,int nbObstacles ){
        this.titre=titre;
        this.nbEtapes=nbEtapes;
        this.nbObstacles=nbObstacles;

    }
    public void ajouterJoueur(Joueur joueur){
        liste_joueur.add(joueur);

    }
    public ArrayList<Personnage>  tousLesPersos(){
        ArrayList<Personnage> liste_personnage=new ArrayList<>();
        for (int i = 0; i < liste_joueur.size(); i++){
            liste_personnage.addAll(liste_joueur.get(i).list_personnage);

        }
        if (liste_personnage.size()>NB_JOUEUR_MAX){
            liste_personnage=null;
            System.out.println("Erreur TROP DE PERSONNAGE");

        }
        return liste_personnage;
    }
    public void initialiserCases(){
        int nbObstacle_placer=0;
        for (int i = 0; i < NB_CASES; i++){
            int random_gain=(int) (Math.round(Math.random()*(NB_CASES-1)))+1;
            if (random_gain%5!=0 && (i!=NB_CASES-1) || nbObstacle_placer==this.nbObstacles){
                liste_case.add(new Case(random_gain));
            }
            else{
                liste_case.add(new Case(random_gain));
                Obstacle obstacle=new Obstacle(random_gain/2);
                liste_case.get(i).placerObstacle(obstacle);
            }
        }

    }
    public void lancerJeu(){
        if (tousLesPersos()!=null){
            initialiserCases();
            for (int i = 0; i < tousLesPersos().size(); i++){
                int compteur=0;
                boolean verification=true;
                while(verification){
                    if(liste_case.get(compteur).estLibre()){
                        verification=false;
                    }
                    else{
                        compteur++;
                    }

                }
                liste_case.get(compteur).placerPersonnage(tousLesPersos().get(i));
                tousLesPersos().get(i).deplacer(compteur, liste_case.get(compteur).getGain());
            }//Met les joueurs sur les cases
            for (int j =0; j<nbEtapes; j++){
                for (int i = 0; i < tousLesPersos().size(); i++){
                    Personnage personnage_traite=tousLesPersos().get(i);
                    if(personnage_traite.getPosition()==(NB_CASES-1)){
                        liste_case.get(NB_CASES-1).enleverPersonnage();
                    } //si perso atterie a la fin
                    else {
                        //System.out.println("tentative")
                        int position_deplacer=personnage_traite.positionSouhaitee();

                        int position_actuelle=personnage_traite.getPosition();

                        int position_souhaite=position_deplacer+ position_actuelle;
                        //Verification dans le cas ou ça depasser les case max
                        if (position_actuelle+position_deplacer>(NB_CASES-1)){
                            position_souhaite=NB_CASES-1;

                        }
                        Case case_souhaite=liste_case.get(position_souhaite);
                        //System.out.println("bien la pos"+position_souhaite);
                        if( case_souhaite.estLibre()){

                            liste_case.get(position_actuelle).enleverPersonnage();
                            personnage_traite.deplacer(position_souhaite, case_souhaite.getGain());
                            liste_case.get(position_souhaite).placerPersonnage(personnage_traite);

                        }
                        else if(!case_souhaite.sansPerso()){

                            personnage_traite.penaliser(case_souhaite.getGain());
                        }
                        else if(!case_souhaite.sansObstacle()){


                            personnage_traite.penaliser(case_souhaite.getPenalite());
                        }
                        //condition de deplacement

                    }

                }
                afficherCases();
                System.out.println("/////////////////////////////////////////////");
            }

        }


    }
    public void afficherCases(){
        for (int i = 0; i < NB_CASES; i++){
            System.out.println(liste_case.get(i));
        }
    }
    public void afficherParticipants(){
        System.out.println("LISTE DES JOUEURS");

        for (int i = 0; i < liste_joueur.size(); i++){
            System.out.println("-----------------------------------");
            System.out.println(liste_joueur.get(i));

        }

    }
    public void afficherResultats(){
        System.out.println("JEU "+this.titre);
        System.out.println("**********************************");
        afficherParticipants();
        System.out.println("RESULTATS");
        Joueur joueur_gagnant = liste_joueur.get(0);
        int max_points=liste_joueur.get(0).getNbPoints();
        for (int i = 0; i < liste_joueur.size(); i++){
            if (max_points < liste_joueur.get(i).getNbPoints()){
                max_points=liste_joueur.get(i).getNbPoints();
                joueur_gagnant=liste_joueur.get(i);
            }

        }
        System.out.println("Le gagnant est "+joueur_gagnant.nom+" avec "+joueur_gagnant.getNbPoints());
        if(joueur_gagnant.getNbPoints()>scoreMax){
            System.out.println("Record battu: Ancien score max "+scoreMax);
            scoreMax=joueur_gagnant.getNbPoints();
        }

    }
}
