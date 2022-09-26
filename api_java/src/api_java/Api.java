package api_java;
import java.text.DecimalFormat;
import java.util.Random;

public class Api {
	 public static void main(String args[]) 
	    {
		 //1
		 System.out.println(Math.PI);
		//2
		 DecimalFormat df=new DecimalFormat("#0.00");
		 System.out.println(df.format(Math.random()));
		 
		 //3
		 Random rand = new Random();
		 int random =rand.nextInt(3);
		 System.out.println(random);
		 //4
		 int x1= 5;
		 int x2= 6;
		 int max=Math.max(x1, x2);
		 System.out.println(max);
		 //5
		 String s1="b";
		 String s2="a";
		 
		 if (s1==s2){
			 System.out.println("Ce sont les meme lettres");
		 }
		 else {
			 int a =s2.compareTo(s1);
			 	if (a<0) {
			 		System.out.println(s2+" est avant "+s1);
			 	}
			 	else if (a>0) {
			 		System.out.println(s2+" est apres "+s1);
			 	}
		 }
		 	
		 
		
		 
		 
	    }

}
//MATH
// 1  : 2 attribut
//2 : Ce sont des methodes et des attributs mathematiques
//3 : La methode est random() et c'est une methode d'instance qui a pour signature un double
//4 :Il y en a 4, la difference est le type qu'elle recoit et le type qu'elle renvoie
//5 la premiere est inccorecte car la methode necessite 2 attributs minimum, la seconde est correcte et renvoie 6.
//6
//STRING
//	1: C'est une methode d'instance
// 2: le type n'est pas bon vu que la methode renvoie un int et non un string, et deuxiement il faut faire nom_de_variable.methode() et non type.methode()
//3: Sa signature est de type int  et il s'agit d'une methode de classe
//4Vu que c'est une methode de classe il suffit de faire lenght(st) 
