package jeux_aventures;





public class Case {
    protected int gain;


    public Obstacle obs;

    protected Personnage perso;


    public Case( Obstacle obstacle,int gain){

        this.obs=obstacle;
        this.gain=gain;
    }
    public Case(int gain){

        this.gain=gain;

    }

    public int getGain() {
        return gain;
    }

    public int getPenalite(){

        int panalite;
        if (this.obs!=null){
            panalite=obs.getPenalite();
            return panalite;
        }
         return 0;
    }
    public void placerPersonnage(Personnage perso){
        this.perso=perso;

    }
    public void  placerObstacle(Obstacle obs){
        this.obs=obs;

    }
    public void enleverPersonnage(){

        this.perso=null;
    }
    public boolean sansObstacle(){
        boolean verification= getPenalite() == 0;
        return verification;
    }
    public boolean sansPerso(){
        boolean verification= perso == null;
        return verification;
    }
    public boolean estLibre(){
        boolean verification= sansObstacle() && sansPerso();
        return verification;
    }
    @Override
    public String toString() {
        String affichage = null;
        if(estLibre()){
            affichage="Libre (gain="+this.gain+")";
        }
        else if (!sansObstacle()){
            affichage="Obstacle (penalité="+getPenalite()+")";
        }
        else if(!sansPerso()){
            affichage=perso+"(penalité="+getGain()+")";
        }
        return affichage;
    }


}
