package employes;

import java.util.GregorianCalendar;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Employes extends Personne {
	protected double salaire=0;
	protected Calendar dateEmplois;
	final protected static int AGE_MAX=65;
	final protected static int AGE_MIN=16;
	
	protected Employes(String leNom, String lePrenom, GregorianCalendar laDate, Adresse lAdresse) {
		super(leNom, lePrenom, laDate, lAdresse);
		
		this.dateEmplois=Calendar.getInstance();
		
		// TODO Auto-generated constructor stub
	}
	
	static public Employes createEmploye(String leNom, String lePrenom, GregorianCalendar laDate, Adresse lAdresse) {
		Calendar date_maintenant = Calendar.getInstance();
		int annee_maintenant=date_maintenant.get(Calendar.YEAR);
		int mois_maintenant=date_maintenant.get(Calendar.MONTH);
		int jour_maintenant=date_maintenant.get(Calendar.DAY_OF_MONTH);
		
		if ((annee_maintenant-laDate.get(Calendar.YEAR))==AGE_MIN) {
			if (mois_maintenant==laDate.get(Calendar.MONTH)) {
				if(jour_maintenant<laDate.get(Calendar.DAY_OF_MONTH)) {
					Employes employes=new Employes(leNom, lePrenom,  laDate,  lAdresse);
					return employes;
				}
			else if (mois_maintenant>laDate.get(Calendar.MONTH)) {
					Employes employes=new Employes(leNom, lePrenom,  laDate,  lAdresse);
					return employes;
				}
			}
			
		}
		else if ((annee_maintenant-laDate.get(Calendar.YEAR))==AGE_MAX) {
			if (mois_maintenant==laDate.get(Calendar.MONTH)) {
				if(jour_maintenant>laDate.get(Calendar.DAY_OF_MONTH)) {
					Employes employes=new Employes(leNom, lePrenom,  laDate,  lAdresse);
					return employes;
				}
			else if (mois_maintenant<laDate.get(Calendar.MONTH)) {
					Employes employes=new Employes(leNom, lePrenom,  laDate,  lAdresse);
					return employes;
				}
			}
			
		}
		return null;
		
	}
	public void setSalaire(double salaire) {
		this.salaire=salaire;
	}
	 public void augmenterLeSalaire(double pourcentage) {
		
		if (pourcentage>0){
			this.salaire=this.salaire+(this.salaire*pourcentage/100);
		}
	}
	public int calculAnnuite() {
		Calendar date_maintenant = Calendar.getInstance();
		int annee_maintenant=date_maintenant.get(Calendar.YEAR);
		return (annee_maintenant-this.dateEmplois.get(Calendar.YEAR))+1;
	}
	

	
	

}
