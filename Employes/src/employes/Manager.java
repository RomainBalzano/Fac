package employes;


import java.util.GregorianCalendar;
import java.util.*; 

public class Manager extends Employes {
	
	List<Object> listSecretaire= new ArrayList<>();
	private Secretaire secretaire;

	protected Manager(String leNom, String lePrenom, GregorianCalendar laDate, Adresse lAdresse) {
		super(leNom, lePrenom, laDate, lAdresse);
		// TODO Auto-generated constructor stub
	}

	public void setSalaire(double salaire) {
		this.salaire=salaire;
		augmenterLeSalaire((0.5*calculAnnuite()));
	}
	
	public void ajoutSecretaire(Secretaire secretaire) {
		
		secretaire.ajoutManager(this);
		this.secretaire=secretaire;
		
	}
	public void enleverSecretaire(Secretaire secretaire) {
		this.secretaire=null;
	}
	
	

}
