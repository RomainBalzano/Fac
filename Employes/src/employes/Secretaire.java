package employes;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Secretaire extends Employes {
	
	private List<Object> listManager= new ArrayList<>();

	protected Secretaire(String leNom, String lePrenom, GregorianCalendar laDate, Adresse lAdresse) {
		super(leNom, lePrenom, laDate, lAdresse);
		// TODO Auto-generated constructor stub
	}
	
	public void enleverManager(Manager manager) {
		listManager.remove(manager);
	}
	public void setSalaire(double salaire) {
		this.salaire=salaire;
		augmenterLeSalaire((0.1*listManager.size()));
	}
	public void ajoutManager(Manager manager) {
		// TODO Auto-generated method stub
		 Scanner input = new Scanner(System.in);
	    	
	     System.out.print("Voulez vous rajoutez le manager "+manager.getNom()+ " ? (oui/non)");
	     String choix = input.toString();	     

	        // closing the scanner object
	    input.close();
	    if (choix=="oui") {
	    	if (listManager.size()<5){
				listManager.add(manager);
			}
	    }
	    
		
		
	}

	
	
}
