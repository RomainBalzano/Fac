package vecteur;

import java.text.DecimalFormat;

public class Test_Vecteur {
	public static void main(String[] args) {
		DecimalFormat df=new DecimalFormat("#0.00");
		Vecteur vecteur1=new Vecteur(3.0, 2.0, 5.0);
		Vecteur vecteur2=new Vecteur(1.0, 2.0, 3.0);
		
		double norme=vecteur1.Norme();
		
		double produit= vecteur1.Produit_scalaire(vecteur2);
		double produit_dynamique=vecteur1.Produit_scalaire(vecteur1,vecteur2);
		
		Vecteur somme=vecteur1.Somme_scalaire(vecteur2);
		Vecteur somme_statique=Somme_scalaire(vecteur1,vecteur2);
		
		String newLine = System.getProperty("line.separator");
		
		System.out.println("v1=");
		vecteur1.Affichage();
		System.out.println(newLine);
		System.out.println("v2=");
		vecteur2.Affichage();
		System.out.println(newLine);
		System.out.println("Norme v1="+df.format(norme));
		System.out.println("v1+v2=");
		somme.Affichage();
		System.out.println(newLine);
		System.out.println("v1+v2=");
		somme_statique.Affichage();
		System.out.println(newLine);
		System.out.println("v1.v2="+produit);
		System.out.println(newLine);
		System.out.println("v1.v2="+produit_dynamique);
		
		
		
		
	}

	private static Vecteur Somme_scalaire(Vecteur vecteur1, Vecteur vecteur2) {
		// TODO Auto-generated method stub
		return null;
	}





	
		
	

}
