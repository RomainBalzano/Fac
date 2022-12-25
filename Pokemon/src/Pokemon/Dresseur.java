package Pokemon;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Dresseur {
    private String nomDresseur;
    private  ArrayList<Pokemon> equipe;
    private int bonbon;
    private int niveau;


    public Dresseur(String nomDresseur,ArrayList<Pokemon> equipe) {
        this.nomDresseur=nomDresseur;
        this.equipe=equipe;
        this.bonbon=0;
    }

    public void setEquipe(ArrayList<Pokemon> equipe) {
        this.equipe = equipe;
    }
    public void setNom(String nomDresseur) {
        this.nomDresseur = nomDresseur;
    }
    public void setBonbon(int bonbon){
        this.bonbon=bonbon;
    }
    public void setNiveau(int niveau){
        this.niveau=niveau;
    }
    public int getNiveau(){
        return this.niveau;
    }

    public ArrayList<Pokemon> getEquipe(){
        return this.equipe;
    }
    public int getbonbon(){
        return this.bonbon;
    }
    public String getnomDresseur(){
        return this.nomDresseur;
    }
    public void ConnectionServeur(String nomEquipe) throws Exception{
        System.out.println("a");


    }

    public static ArrayList<Pokemon>  ConvertionTxtEnEquipe(String nomEquipe) throws IOException {
        String nomFichier=nomEquipe+".txt";
        File f = new File(nomFichier);
        ArrayList<Pokemon> equipe = new ArrayList<>();

        // Créer un nouveau fichier
        // Vérifier s'il n'existe pas
        if (f.createNewFile()) {
            System.out.println("Equipe qui n'existe pas,creation d'un ficher avec ce nom");
            AjouterAleatoirePokemonEquipe(equipe);
            AddDoc(nomFichier,equipe);

        }
        else {

            String contenue = VoirEquipe(nomEquipe);
            String[] contenueSepare = contenue.split(",");
            int longueur = contenueSepare.length;


            for (int i = 0; i < longueur; i++) {
                String[] element = contenueSepare[i].split(";");
                if (Integer.parseInt(element[10]) == 1) {
                    element[0] = element[1];
                } else if (Integer.parseInt(element[10]) == 2) {
                    element[0] = element[2];
                }
                Pokemon pokemon = new Pokemon(element[0], element[1], element[2], Integer.parseInt(element[3]),
                        Integer.parseInt(element[4]), Integer.parseInt(element[5]), Integer.parseInt(element[6]),
                        element[7], element[8], Integer.parseInt(element[9]), Integer.parseInt(element[10]));
                equipe.add(pokemon);


            }
        }
        return equipe;

    }
    public static void DonnerBonBon(Pokemon pokemon, int nbbonbon){
        int random_pv=1 + (int)(Math.random() * ((10 - 5) + 1));
        int pc=1 + (int)(Math.random() * ((10 - 5) + 1));
        int random_vit=1 + (int)(Math.random() * (( 5- 3) + 1));
        int ancienBonbon= pokemon.getBonbon();
        int gainEvolution=10;
        pokemon.setBonbon(pokemon.getBonbon()+nbbonbon);
        pokemon.setPv(pokemon.getPv()+nbbonbon*random_pv);
        pokemon.setPc_physique(pokemon.getPc_physique()+nbbonbon*pc);
        pokemon.setPc_special(pokemon.getPc_special()+nbbonbon*pc);
        pokemon.setVitesse(pokemon.getPc_special()+nbbonbon*random_vit);
        if(ancienBonbon<5 && pokemon.getBonbon()>=5 && 10>pokemon.getBonbon() && !Objects.equals(pokemon.getEvolution1(), "NULL"))
        {
            System.out.println("Oh votre "+pokemon.getNom()+" evolue !");
            pokemon.setPv(pokemon.getPv()+gainEvolution);
            pokemon.setPc_physique(pokemon.getPc_physique()+gainEvolution);
            pokemon.setPc_special(pokemon.getPc_special()+gainEvolution);
            pokemon.setVitesse(pokemon.getPc_special()+gainEvolution);
            pokemon.setNom(pokemon.getEvolution1());
            System.out.println("Felicitation il a evoluer en "+pokemon.getNom());

            pokemon.setStadeEvolution(1);

        }else if (ancienBonbon>5 && pokemon.getStadeEvolution()!=2   && 10<pokemon.getBonbon() && !Objects.equals(pokemon.getEvolution2(), "NULL")){
            System.out.println("Oh votre "+pokemon.getNom()+" evolue !");
            pokemon.setPv(pokemon.getPv()+gainEvolution);
            pokemon.setPc_physique(pokemon.getPc_physique()+gainEvolution);
            pokemon.setPc_special(pokemon.getPc_special()+gainEvolution);
            pokemon.setVitesse(pokemon.getPc_special()+gainEvolution);
            pokemon.setNom(pokemon.getEvolution2());
            System.out.println("Felicitation il a evoluer en "+pokemon.getNom());
            pokemon.setStadeEvolution(2);
        }
    }

    public static String ConvertionPokemon(Pokemon pokemon){
        String pokemonChaine="";
        pokemonChaine=pokemon.getNom()+";"+pokemon.getEvolution1()+";"+pokemon.getEvolution2()+";"+pokemon.getPv()+";"
                +pokemon.getPc_physique()+";"+pokemon.getPc_special()+";"+ pokemon.getBonbon()+";"+pokemon.getType1()+
                ";"+pokemon.getType2()+";"+pokemon.getVitesse()+";"+pokemon.getStadeEvolution();

        return pokemonChaine;
    }

    public static void AjouterAleatoirePokemonEquipe(ArrayList<Pokemon> Equipe) throws IOException {
        Pokemon pokemon=new Pokemon();
        if (Equipe.size()>=6){
            System.out.println("Equipe pleine");
        }
        else{
            Equipe.add(pokemon);
            System.out.println("Pokemon "+pokemon.getNom()+" ajouté");
        }

    }
    public static void AjouterPokemonEquipe(ArrayList<Pokemon> Equipe,String nom) throws IOException {
        Pokemon pokemon=new Pokemon(nom);
        if (Equipe.size()>=6){
            System.out.println("Equipe pleine");
        }
        else{
            Equipe.add(pokemon);
            System.out.println("Pokemon "+pokemon.getNom()+" ajouté");
        }

    }
    public static void SupprimerPokemonEquipe(ArrayList<Pokemon> Equipe,int index) throws IOException {

        if (Equipe.size()==1){
            System.out.println("C'est votre dernier pokemon vous ne pouvez pas le supprimer");
        }
        else{
            Equipe.remove(index);
            System.out.println("Pokemon supprimé");
        }

    }

    public static Pokemon SelectionnerPokemon(ArrayList<Pokemon> Equipe,int index){
        return Equipe.get(index);
    }




    public static void AddDoc(String nomEquipe,ArrayList<Pokemon> equipe){
        try {
            String content="";
            for(int i=0; i< equipe.size()-1;i++){
                content=(ConvertionPokemon(equipe.get(i)))+","+content;
            }
            content=content+(ConvertionPokemon(equipe.get(equipe.size()-1)));
            String nomFichier=nomEquipe+".txt";
            File file = new File(nomFichier);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String VoirEquipe(String nomEquipe) {
        String strng ="";
        String contenu="";
        try {
            String nomFichier=nomEquipe+".txt";
            File doc = new File(nomFichier);
            BufferedReader obj = new BufferedReader(new FileReader(doc));
            while ((strng = obj.readLine()) != null)
                contenu=contenu+strng;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return contenu;

    }


    public static String AffichageEquipe(ArrayList<Pokemon> equipe) {
        String affichage="";
        for (int i = 0; i < equipe.size(); i++) {
            affichage=affichage+"\n"+i+" Nom:"+equipe.get(i).getNom()+" ,Pv:"+equipe.get(i).getPv()+
                    " ,Atk:"+equipe.get(i).getPc_physique() +",Atk_Special:"+equipe.get(i).getPc_special()+" ,Vit:"
                    +equipe.get(i).getVitesse()+" ,Type 1:"+equipe.get(i).getType1()+" ,Type 2:"+equipe.get(i).getType2()+
                    " ,Bonbon:"+equipe.get(i).getBonbon();

        }
        return affichage;
    }

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        boolean recommencer = true;
        int choice;
        int nbBonbon;
        String choix;
        int index;
        int ancien_pv=0;
        do {


            System.out.println("Choisisez un nom:");
            String nom = in.next();
            System.out.println("Choisisez une equipe selon son nom de fichier :");
            String nomEquipe = in.next();

            Dresseur dresseur = new Dresseur(nom, ConvertionTxtEnEquipe(nomEquipe));


            do {
                System.out.println("Please enter your choice:");
                System.out.println("1\t Changer l'equipe ");
                System.out.println("2\t Sauvegarder une equipe ");
                System.out.println("3\t Visualiser l'equipe ");
                System.out.println("4\t Donner Bonbon a un pokemon ");
                System.out.println("5\t Supprimer un pokemon ");
                System.out.println("6\t Ajouter un pokemon aléatoire ");
                System.out.println("7\t Ajouter un pokemon selon son nom  ");
                System.out.println("8\t Se connecter a une arene ");
                System.out.println("9\t Passer la main a l'autre joueur ");
                System.out.println("Enter your choice :");

                choice = in.nextInt();


                switch (choice) {
                    case 1:
                        //choix
                        System.out.println("Choisisez une equipe selon son nom de fichier :");
                        choix = in.next();
                        dresseur.equipe = ConvertionTxtEnEquipe(choix);
                        break;
                    case 2:
                        //choix
                        AddDoc("Equipe1", dresseur.equipe);
                        System.out.println("Sauvegarde effectuer :");
                        break;
                    case 3:
                        System.out.println(AffichageEquipe(dresseur.equipe));
                        break;
                    case 4:
                        System.out.println("Nombre de bonbon" + dresseur.getbonbon());
                        if (dresseur.getbonbon() > 1) {
                            AffichageEquipe(dresseur.getEquipe());
                            System.out.println("Donner le nombre de bonbon, puis le numero du pokemon a l'attribuer");
                            nbBonbon = in.nextInt();
                            index = in.nextInt();
                            if (nbBonbon <= dresseur.getbonbon()) {
                                DonnerBonBon(dresseur.equipe.get(index), nbBonbon);
                            } else {
                                System.out.println("Erreur vous n'avez pas tout ces bonbon ou le numero de pokemon n'existe pas");
                            }

                        } else {
                            System.out.println("Vous n'avez pas de bonbon");
                        }
                        break;
                    case 5:
                        AffichageEquipe(dresseur.getEquipe());
                        System.out.println("Donner le numero du pokemon a supprimer");
                        index = in.nextInt();

                        SupprimerPokemonEquipe(dresseur.getEquipe(), index);

                        break;
                    case 6:
                        AjouterAleatoirePokemonEquipe(dresseur.equipe);

                        break;
                    case 7:
                        System.out.println("Donner le nom de pokemon (seulement premiere evolution) a ajouter");
                        choix = in.next();
                        AjouterPokemonEquipe(dresseur.equipe, choix);
                        break;
                    case 8:
                        dresseur.ConnectionServeur("Equipe1");

                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("Invalid choice");
                }//end of switch

            } while (choice != 9);
            System.out.println("Choisisez un nom:");
            nom = in.next();
            System.out.println("Choisisez une equipe selon son nom de fichier :");
            nomEquipe = in.next();

            Dresseur dresseur2 = new Dresseur(nom, ConvertionTxtEnEquipe(nomEquipe));


            do {
                System.out.println("Please enter your choice:");
                System.out.println("1\t Changer l'equipe ");
                System.out.println("2\t Sauvegarder une equipe ");
                System.out.println("3\t Visualiser l'equipe ");
                System.out.println("4\t Donner Bonbon a un pokemon ");
                System.out.println("5\t Supprimer un pokemon ");
                System.out.println("6\t Ajouter un pokemon aléatoire ");
                System.out.println("7\t Ajouter un pokemon selon son nom  ");
                System.out.println("8\t Se connecter a une arene ");
                System.out.println("9\t Passer la main a l'autre joueur ");
                System.out.println("Enter your choice :");

                choice = in.nextInt();


                switch (choice) {
                    case 1:
                        //choix
                        System.out.println("Choisisez une equipe selon son nom de fichier :");
                        choix = in.next();
                        dresseur2.equipe = ConvertionTxtEnEquipe(choix);
                        break;
                    case 2:
                        //choix
                        AddDoc("Equipe1", dresseur2.equipe);
                        System.out.println("Sauvegarde effectuer :");
                        break;
                    case 3:
                        System.out.println(AffichageEquipe(dresseur2.equipe));
                        break;
                    case 4:
                        System.out.println("Nombre de bonbon" + dresseur2.getbonbon());
                        if (dresseur2.getbonbon() > 1) {
                            AffichageEquipe(dresseur2.getEquipe());
                            System.out.println("Donner le nombre de bonbon, puis le numero du pokemon a l'attribuer");
                            nbBonbon = in.nextInt();
                            index = in.nextInt();
                            if (nbBonbon <= dresseur2.getbonbon()) {
                                DonnerBonBon(dresseur2.equipe.get(index), nbBonbon);
                            } else {
                                System.out.println("Erreur vous n'avez pas tout ces bonbon ou le numero de pokemon n'existe pas");
                            }

                        } else {
                            System.out.println("Vous n'avez pas de bonbon");
                        }
                        break;
                    case 5:
                        AffichageEquipe(dresseur2.getEquipe());
                        System.out.println("Donner le numero du pokemon a supprimer");
                        index = in.nextInt();

                        SupprimerPokemonEquipe(dresseur2.getEquipe(), index);

                        break;
                    case 6:
                        AjouterAleatoirePokemonEquipe(dresseur2.equipe);

                        break;
                    case 7:
                        System.out.println("Donner le nom de pokemon (seulement premiere evolution) a ajouter");
                        choix = in.next();
                        AjouterPokemonEquipe(dresseur2.equipe, choix);
                        break;
                    case 8:
                        dresseur.ConnectionServeur("Equipe1");

                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("Invalid choice");
                }//end of switch

            } while (choice != 9);
            boolean condition = true;
            System.out.println(AffichageEquipe(dresseur.getEquipe()));
            System.out.println("J1 Choissisez votre pokemon selon le numero ");
            index = in.nextInt();
            Pokemon pokemon = SelectionnerPokemon(dresseur.getEquipe(), index);
            System.out.println(AffichageEquipe(dresseur2.getEquipe()));
            System.out.println("J2 Choissisez votre prochain pokemon selon le numero ");
            index = in.nextInt();
            Pokemon pokemon2 = SelectionnerPokemon(dresseur.getEquipe(), index);
            dresseur.setBonbon(dresseur.getbonbon() + 1);
            dresseur2.setBonbon(dresseur2.getbonbon() + 1);
            while (condition) {
                if (pokemon.getVitesse() >= pokemon2.getVitesse()) {
                    System.out.println("J1 choissisez votre numero d'attaque (1:premier type,2:Second type si il en a) ");
                    index = in.nextInt();
                    if (Objects.equals(pokemon.getType2(), "NULL") && index == 2) {
                        index = 1;
                    }
                    ancien_pv=pokemon2.getPv();
                    pokemon.Attaque(pokemon2, index);
                    System.out.println("L'attaque de "+pokemon.getNom()+" a infliger "+(ancien_pv-pokemon2.getPv())+" pv a "+pokemon2.getNom());
                    System.out.println(pokemon2.getNom()+" a "+pokemon2.getPv()+" pv suite a cette attaque");
                    if (pokemon2.getPv() > 1) {
                        System.out.println("J2 choissisez votre numero d'attaque (1:premier type,2:Second type si il en a) ");
                        index = in.nextInt();
                        if (Objects.equals(pokemon2.getType2(), "NULL") && index == 2) {
                            index = 1;
                        }
                        ancien_pv=pokemon.getPv();
                        pokemon2.Attaque(pokemon, index);
                        System.out.println("L'attaque de "+pokemon2.getNom()+" a infliger "+(ancien_pv-pokemon.getPv())+"pv a "+pokemon.getNom());
                        System.out.println(pokemon.getNom()+" a "+pokemon.getPv()+" pv suite a cette attaque");
                    }
                } else if (pokemon2.getVitesse() > pokemon.getVitesse()) {
                    System.out.println("J2 choissisez votre numero d'attaque (1:premier type,2:Second type si il en a) ");
                    index = in.nextInt();
                    if (Objects.equals(pokemon2.getType2(), "NULL") && index == 2) {
                        index = 1;
                    }
                    ancien_pv=pokemon.getPv();
                    pokemon2.Attaque(pokemon, index);
                    System.out.println("L'attaque de "+pokemon2.getNom()+" a infliger "+(ancien_pv-pokemon.getPv())+" pv a "+pokemon.getNom());
                    System.out.println(pokemon.getNom()+" a "+pokemon.getPv()+" pv suite a cette attaque");
                    if (pokemon.getPv() > 1) {
                        System.out.println("J1 choissisez votre numero d'attaque (1:premier type,2:Second type si il en a) ");
                        index = in.nextInt();
                        if (Objects.equals(pokemon.getType2(), "NULL") && index == 2) {
                            index = 1;
                        }
                        ancien_pv=pokemon2.getPv();
                        pokemon.Attaque(pokemon2, index);
                        System.out.println("L'attaque de "+pokemon.getNom()+" a infliger "+(ancien_pv-pokemon2.getPv())+" pv a "+pokemon2.getNom());
                        System.out.println(pokemon2.getNom()+" a "+pokemon2.getPv()+" pv suite a cette attaque");
                    }
                }
                if (pokemon.getPv() < 1) {
                    if (dresseur.getEquipe().size() == 1) {
                        System.out.println("J1 a perdu");
                        dresseur2.setNiveau(dresseur2.getNiveau() + 1);
                        System.out.println("Le J2 a gagné un niveau");
                        System.out.println("Voulez vous continuer ? (Y/N)");
                        nom = in.next();
                        if (Objects.equals(nom, "N")){
                            recommencer=false;
                        }
                        condition = false;
                    } else {
                        dresseur.getEquipe().remove(pokemon);
                        System.out.println(AffichageEquipe(dresseur.getEquipe()));
                        System.out.println("J1 Choissisez votre pokemon selon le numero ");
                        index = in.nextInt();
                        pokemon = SelectionnerPokemon(dresseur.getEquipe(), index);
                        dresseur.setBonbon(dresseur.getbonbon() + 1);
                    }
                } else if (pokemon2.getPv() < 1) {

                    if (dresseur2.getEquipe().size() == 1) {
                        System.out.println("J2 a perdu");
                        dresseur.setNiveau(dresseur.getNiveau() + 1);
                        System.out.println("Le J1 a gagné un niveau");
                        System.out.println("Voulez vous continuer ? (Y/N)");
                        nom = in.next();
                        if (Objects.equals(nom, "N")){
                            recommencer=false;
                        }
                        condition = false;
                    } else {

                        dresseur2.getEquipe().remove(pokemon2);
                        System.out.println(AffichageEquipe(dresseur2.getEquipe()));
                        System.out.println("J2 Choissisez votre prochain pokemon selon le numero ");
                        index = in.nextInt();
                        pokemon2 = SelectionnerPokemon(dresseur.getEquipe(), index);
                        dresseur2.setBonbon(dresseur2.getbonbon() + 1);
                    }
                }

            }

        } while (!recommencer);
    }

}
