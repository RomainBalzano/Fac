package entier;

import java.util.Random;

public class Entier_fou extends Entier {
	protected int niveau_folie;
	protected static Random r = new Random();
	
	public Entier_fou(int borne_min, int borne_max, int entier, int niveau_folie) {
		super(borne_min, borne_max, entier);
		if (niveau_folie >0) {
			this.niveau_folie=niveau_folie;
		}
		else {
			System.err.println("Erreur le niveau de folie doit etre positif");
		}
	}


	public void incrementer() {
		int pas_fou= r.nextInt(this.niveau_folie) ;
		super.incrementer(pas_fou);
		
		
		
	}



}
