package des;

public class Test_de {
	public static void main(String[] args) {
		//System.out.println(newLine);
		De de1=new De("D1");
		De de2=new De("D2",8);
		De de3=new De();
		De_pip� de4=new De_pip�("D2",8,2);
		System.out.println(de1.getNbFaces());
		System.out.println(de2.getNbFaces());
		System.out.println(de3.getNbFaces());
		
		System.out.println(de1.Lancer(10));
		System.out.println(de2.Lancer(10));
		System.out.println(de3.Lancer(10));
		
		System.out.println("pip�"+de4.Lancer());
		
		
		
	}
}
