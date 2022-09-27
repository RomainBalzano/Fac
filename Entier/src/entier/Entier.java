package entier;

import java.util.ArrayList;
import java.util.List;

public class Entier {
	
	protected int entier;
	protected int borne_min;
	protected int borne_max;
	
	
	
	/**
	 * @param borne_min(int):borne minimum de l'entier
	 * @param borne_max(int):borne maximum de l'entier
	 * @param entier(int):entier qui est definie entre les deux borne
	 */
	public Entier(final int borne_min,final int borne_max,int entier) {
		
		if (borne_min>borne_max) {
			System.err.println("Erreur la borne maximum est inferieur a la minimum");
		}//On verifie que la borne maximum n'est pas inferieur a la borne minimum
		
		if (entier >= borne_min && entier<= borne_max) {
			
			this.entier=entier;
			this.borne_min= borne_min;
			this.borne_max=borne_max;
		}
		else {
			System.err.println("Erreur le nombre doit etre compris entre " +borne_min+" et "+ borne_max);
			//Erreur si le nombre n'est pas entre les bornes
		}
	}
	public Entier(int borne_min,int borne_max) {
		this.entier=borne_min;
		this.borne_min=borne_min;
		this.borne_max=borne_max;
		
		
	}
	public void set_Entier(int entier) {
		
		if (entier >= this.borne_min && entier<= this.borne_max) {
			this.entier=entier;
		}
	
	}
	public void incrementer() {
		if (this.entier< this.borne_max) {
			this.entier++;
		}
	}
	public void incrementer(int pas) {
		if (this.entier+pas >= this.borne_min && this.entier+pas<= this.borne_max) {
			this.entier=this.entier+pas;
		}
	}
	public String toString() {
		return "L'entier est de "+Integer.toString(this.entier)+" compris entre la valeur "+ Integer.toString(this.borne_min) +" et "+Integer.toString(this.borne_max);
	}
	public Boolean equals(Entier entier_compare) {
		return (this.entier==entier_compare.entier && this.borne_min==entier_compare.borne_min && this.borne_max==entier_compare.borne_max);
		
	}

}
