package des;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class De_memoire extends De {
	
	private List <Integer> tableau_memoire = new ArrayList();
	
	public int Lancer() {
		Random r = new Random();
		int face_aleatoire= r.nextInt(this.nb_faces) ;
		while(tableau_memoire.get(tableau_memoire.size()-1) != null){
			face_aleatoire= r.nextInt(this.nb_faces) ;
		}
			
			tableau_memoire.add(face_aleatoire);
		
		return face_aleatoire;	
		}
	
		
	
	
	

}
