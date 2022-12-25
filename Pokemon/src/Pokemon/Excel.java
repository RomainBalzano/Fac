package Pokemon;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class Excel {
    public static ArrayList<String> getType(String type) throws IOException{
        FileInputStream fichier = new FileInputStream(new File("Type.xlsx"));
        //créer une instance workbook qui fait référence au fichier xlsx
        XSSFWorkbook wb = new XSSFWorkbook(fichier);
        XSSFSheet sheet = wb.getSheetAt(0);
        ArrayList<String> tabType = new ArrayList<String>();
        int compteurLigne=0;
        int compteurColonne=0;
        String valeur="";
        FormulaEvaluator formulaEvaluator =
                wb.getCreationHelper().createFormulaEvaluator();
        for (Row ligne : sheet) {//parcourir les lignes
            for (Cell cell : ligne) {
                if(cell.getStringCellValue().equals(type) && compteurColonne==0){
                    for(int i=0;i<7;i++){
                        valeur=cell.getSheet().getRow(compteurLigne).getCell(i).getRichStringCellValue().toString();
                        tabType.add(valeur);
                    }
                    break;

                }
                compteurColonne++;
            }compteurColonne=0;
            compteurLigne++;

        }


    return tabType;
    }
    public static ArrayList<String> getRandPokemon() throws IOException{
        FileInputStream fichier = new FileInputStream(new File("Liste Pokemon.xlsx"));
        //créer une instance workbook qui fait référence au fichier xlsx
        XSSFWorkbook wb = new XSSFWorkbook(fichier);
        XSSFSheet sheet = wb.getSheetAt(0);
        ArrayList<String> tabRandPokemon = new ArrayList<String>();
        int compteurLigne=0;
        String valeur="";
        int nombreAleatoire = 0;
        FormulaEvaluator formulaEvaluator =
                wb.getCreationHelper().createFormulaEvaluator();
        for (Row ligne : sheet) {//parcourir les lignes
            compteurLigne++;
        }
        nombreAleatoire=1 + (int)(Math.random() * (((compteurLigne-1) - 1) + 1));
        for (Row ligne : sheet) {//parcourir les lignes

            for (Cell cell : ligne) {
                for(int i=0;i<5;i++){

                    valeur=cell.getSheet().getRow(nombreAleatoire).getCell(i).getRichStringCellValue().toString();
                    tabRandPokemon.add(valeur);
                }
                break;
            }
            break;
        }


        return tabRandPokemon;
    }
    public static ArrayList<String> getPokemon(String type) throws IOException{
        FileInputStream fichier = new FileInputStream(new File("Liste Pokemon.xlsx"));
        //créer une instance workbook qui fait référence au fichier xlsx
        XSSFWorkbook wb = new XSSFWorkbook(fichier);
        XSSFSheet sheet = wb.getSheetAt(0);
        ArrayList<String> tabPokemon = new ArrayList<String>();
        int compteurLigne=0;
        int compteurColonne=0;
        String valeur="";
        FormulaEvaluator formulaEvaluator =
                wb.getCreationHelper().createFormulaEvaluator();
        for (Row ligne : sheet) {//parcourir les lignes
            for (Cell cell : ligne) {
                if(cell.getStringCellValue().equals(type) && compteurColonne==0){
                    for(int i=0;i<5;i++){
                        valeur=cell.getSheet().getRow(compteurLigne).getCell(i).getRichStringCellValue().toString();
                        tabPokemon.add(valeur);
                    }
                    break;

                }
                compteurColonne++;
            }compteurColonne=0;
            compteurLigne++;

        }


        return tabPokemon;
    }


    public static void main(String[] args) throws IOException {

        ArrayList<String> tabTypeFeu=getType("Eau");
        System.out.println(tabTypeFeu);
        ArrayList<String> pokemon=getRandPokemon();
        System.out.println(pokemon);










    }

}