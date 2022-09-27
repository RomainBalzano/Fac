package des;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class De_face_autres extends De {
	
	private List <String> tableau_faces = new ArrayList();
	
	public De_face_autres(String de_nom, List <String> faces) {
		super(de_nom);
		this.nb_faces=faces.size();
		this.tableau_faces=faces;
	}
	public String Lancer_string() {
		Random r = new Random();
		int indice_aleatoire= r.nextInt(this.nb_faces) ;
		String face_aleatoire=this.tableau_faces.get(indice_aleatoire);
		return face_aleatoire;
	}
	

}
