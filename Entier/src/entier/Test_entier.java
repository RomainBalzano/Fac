package entier;

public class Test_entier {
	public static void main(String[] args) {
		Entier entier=new Entier(1,8,3);
		Entier entier_sans_entier=new Entier(5,8);
		Entier entier_borne_depasse=new Entier(5,8,9);
		Entier_fou entier_fou=new Entier_fou(2,7,3,2);
		Entier_fou entier_fou_borne_depasse=new Entier_fou(2,7,8,2);
		Entier_fou entier_fou_negatif=new Entier_fou(2,7,9,-1);
		
		System.out.println(entier);
		entier.incrementer();
		System.out.println(entier);
		entier.incrementer(3);
		System.out.println(entier);
		
		System.out.println(entier_fou);
		entier_fou.incrementer();
		System.out.println(entier_fou);
		entier_fou.incrementer();
		System.out.println(entier_fou);
		
		
		
	}

}
