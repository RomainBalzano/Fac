package des;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class De_pip� extends De {
	private int borne_minimal;
	
	public De_pip�(String de_nom, int nb_faces,int borne_minimal) {
		super(de_nom, nb_faces);
		this.de_nom=de_nom;
		this.borne_minimal=borne_minimal;
		if (borne_minimal>=this.nb_faces || borne_minimal<0) {
			System.err.println("Erreur la borne ne peut pas depass� le nombre de face ou etre negatif");
		}
		
	}
	
	public int Lancer() {
		Random r = new Random();
		
		int face_aleatoire= r.nextInt(this.nb_faces) ;
		int meilleur_lancer=0;

		if (face_aleatoire+borne_minimal<this.nb_faces) {
			face_aleatoire=face_aleatoire+borne_minimal;
			}
		else
			{
				face_aleatoire=this.nb_faces;
			}
		
		return face_aleatoire;
	}

}
