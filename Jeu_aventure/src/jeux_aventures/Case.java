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

        int panalite=0;
        if (this.obs!=null){
            panalite=obs.getPenalite();

        }
         return panalite;
    }
    public void placerPersonnage(Personnage perso){
        this.perso=perso;

    }
    public void  placerObstacle(Obstacle obs){
        this.obs=obs;

    }
    public void enleverPersonnages(){

        this.perso=null;
    }
    public boolean sansObstacle(){

        return getPenalite() == 0;
    }
    public boolean sansPerso(){

        return perso == null;
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
