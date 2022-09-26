package vecteur;

public class Vecteur {
	private   double x,y,z;
	
	public Vecteur() {
		
		
		this.x=0;
		this.y=0;
		this.z=0;
	
	}
	public Vecteur( double x, double y, double z) {
		
		
		this.x=x;
		this.y=y;
		this.z=z;
	
	}
	public void Affichage() {
		
		System.out.print(" x "+this.x);
		System.out.print(" y "+this.y);
		System.out.print(" z "+this.z);
	}
	public double Norme() {
		double norme=Math.sqrt((this.x)*(this.x)+(this.y)*(this.y)+(this.z)*(this.z));
		return norme;
	}
	
	public double Produit_scalaire(Vecteur vecteur) {
		double scalaire=this.x*vecteur.x + this.y*vecteur.y + this.z*vecteur.z;
		return scalaire;
		
		
	}
	public static  double Produit_scalaire(Vecteur vecteur, Vecteur vecteur2) {
		double scalaire=vecteur2.x*vecteur.x+vecteur2.y*vecteur.y+vecteur2.z+vecteur.z;
		return scalaire;
		
	}
	
	public Vecteur Somme_scalaire(Vecteur vecteur) {
		Vecteur Somme=new Vecteur(this.x+vecteur.x,this.y+vecteur.y,this.z+vecteur.z);
		return Somme;
	}
	
	 public static Vecteur Somme_scalaire(Vecteur vecteur,Vecteur vecteur2) {
		Vecteur Somme=new Vecteur(vecteur.x+vecteur2.x, vecteur.y+vecteur2.y, vecteur.z+vecteur2.z);
		return Somme;
	}
	

}
