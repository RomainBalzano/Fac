package robot;

public class robot {
	private String ref_robot;
	private String nom_robot;
	
	private  int coordonne_x;
	private  int coordonne_y;
	private  int orientation;
	
	private static int nb_robot;
	
	private static String[] coordonne_tab  = new String[] { "NORD","EST","SUD","OUEST" };
	
	
	
	public robot(String nom_robot,int coordonne_x,int coordonne_y,int orientation) {
		this.nom_robot=nom_robot;
		this.coordonne_x=coordonne_x;
		this.coordonne_y=coordonne_y;
		this.orientation=orientation;
		this.nb_robot++;
		String ref_robot=("ROB"+(nb_robot));
		this.ref_robot=ref_robot;
		
	}
	
	public robot(String nom_robot) {
		/**
		 * @param nom_robot
		 */
		
		this.nom_robot=nom_robot;
		this.coordonne_x=0;
		this.coordonne_y=0;
		
		this.orientation=0;
		this.nb_robot++;
		String ref_robot=("ROB"+(nb_robot));
		this.ref_robot=ref_robot;
	}
	public void Deplacer(){
	
		if (this.orientation==1) {
			this.coordonne_y++;
			
		}
		else if (this.orientation==2) {
			this.coordonne_x++;
			
		}
		else if (this.orientation==3) {
			if (this.coordonne_y != 0) {
				this.coordonne_y--;
			
				}
			
		}	
		
		else if (this.orientation==4) {
			if (this.coordonne_x != 0) {
				this.coordonne_x--;
		
			}
		}
	}
	public void Orientation(int orientation) {
		this.orientation=orientation;
	}
	public void afficheToi() {
		System.out.print("Nom du robot :"+ nom_robot);
		System.out.print(" Coordonnées des abs:"+this.coordonne_x);
		System.out.print(" Coordonnées des ord:" + this.coordonne_y);
		
		System.out.print(" Orientation: "+coordonne_tab[this.orientation-1]);
		System.out.print(" Ref du robot: "+this.ref_robot);
	
		
		}
	

	
		

	
	public String toString(){
		
		String robot_string=("Nom du robot :"+ nom_robot+" Coordonnées des abs:"+Integer.toString(this.coordonne_x)+" Coordonnées des ord:" +Integer.toString(this.coordonne_y));
		String[] coordonne_tab = new String[] { "NORD","EST","SUD","OUEST" };	
		robot_string=robot_string+" Orientation: "+coordonne_tab[this.orientation-1]+" Ref du robot: "+this.ref_robot;
			
		
		
		
		return robot_string;
		
	}
	
}
