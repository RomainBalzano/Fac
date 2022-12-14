package des;
import java.util.*;


public class De {
	protected String de_nom;
	protected int nb_faces;
	
	protected static int nb_de=0;
	final protected int  faces_default=6;

	
	public int getNbFaces() {
		if (this.nb_faces<3 || this.nb_faces>120) {
			System.err.println("Erreur le nombre de face doit etre compris entre 3 et 120");
		}
		return this.nb_faces;
	}
	public int getNbdes(){
		return nb_de;
	}
	public void setNbFaces(int nbfaces) {
		this.nb_faces=nbfaces;
	}
	public De() {
		this("De numero "+nb_de);
	}
	public De(String de_nom) {
		this.nb_faces=faces_default;
		this.de_nom=de_nom;
		nb_de++;
	}
	public De(String de_nom, int nb_faces) {
		nb_de++;
		this.nb_faces=nb_faces;
		this.de_nom=de_nom;
		
	}
	public int Lancer() {
		Random r = new Random();
		int face_aleatoire= r.nextInt(this.nb_faces) ;
		return face_aleatoire;

		}
	public int Lancer(int nb_lancer) {
		Random r = new Random();
		
		List <Integer> tableau_lancer = new ArrayList();
		int meilleur_lancer=0;
		for (int i = 0; i<nb_lancer ; i++) {
			int face_aleatoire= r.nextInt(this.nb_faces) ;
			tableau_lancer.add(face_aleatoire);
		}
		for (int j = 0; j < tableau_lancer.size(); j++) {
			if 	(tableau_lancer.get(j) > meilleur_lancer) {
				meilleur_lancer=tableau_lancer.get(j);
			}
			
		}
		return meilleur_lancer;
	}
	public String toString() {
		String de_string = null;
		de_string="Nom : "+this.de_nom+" Nombre de face "+this.nb_faces;
		
		return de_string;
	}
	public boolean equals(De de) {
		
		return this.de_nom==de.de_nom &&  this.nb_faces==de.nb_faces;
		
	}
		
}
