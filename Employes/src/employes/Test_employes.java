package employes;

import java.util.GregorianCalendar;

public class Test_employes {
	

	public static void main(String[] args) {
		Adresse adresse=new Adresse(9, "rue","code_postal", "ville");
		Employes employes1 = Employes.createEmploye("nom", "Prenom" ,new GregorianCalendar(2018, 6, 27, 16, 16, 47),adresse );
		employes1.augmenterLeSalaire(10);
		
		
		
	}
}
