package employes;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Secretaire extends Employes {
	
	private List<Object> listManager= new ArrayList<>();

	protected Secretaire(String leNom, String lePrenom, GregorianCalendar laDate, Adresse lAdresse) {
		super(leNom, lePrenom, laDate, lAdresse);
		// TODO Auto-generated constructor stub
	}
	public void ajoutSecretaire(Manager manager) {
		if (listManager.size()<5){
			listManager.add(manager);
		}
		
	}
	public void enleverSecretaire(Manager manager) {
		listManager.remove(manager);
	}
	public void setSalaire(double salaire) {
		this.salaire=salaire;
		augmenterLeSalaire((0.1*listManager.size()));
	}

	
	
}