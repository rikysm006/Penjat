package penjat;
import java.util.Scanner;
import java.io.IOException;
 //  @author Ricard

public class Penjat {
   static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        final char[][] estatPenjatInicial ={
            {' ',' ',' ',' ','_','_','_','_',' ',' ',' ',' '},                                      
            {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ','_','_','|','_',' ',' ',' ',' ',' ',' ',' '},                                      
            {'|',' ',' ',' ',' ','|','_','_','_','_','_',' '},
            {'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
            {'|','_','_','_','_','_','_','_','_','_','_','|'}};
        final String[] paraules = {"patata", "armari", "bicicleta", "advocat", "ascensor", "astronauta",
            "autopista", "avinguda", "bigoti", "carretera", "castanya", "cervell", "civada", "cultura", "dentista",
            "esquena", "estrella", "formatge", "gendre", "genoll", "infermera", "internet", "maduixa",
            "malaltia", "maluc", "mandarina", "maquinista", "motocicleta", "nebot", "pastanaga", "patinet",
            "perruqueria", "pissarra", "professor", "quadrat", "taronja", "tramvia", "trapezi", "tricicle", "violeta"};
        String paraula = paraules[(int)(Math.random () * paraules.length)];
        int totalEncerts = 0, errorsTotals = 0;
        boolean[] encertsLletres = new boolean[paraula.length()];
        String lletres = "";
        char[][] estatPenjat = new char[estatPenjatInicial.length][estatPenjatInicial[0].length];
        inicialitzarPenjat(estatPenjatInicial, estatPenjat);
        do {
            mostrarEstatPenjat(estatPenjat);
            mostrarParaula(paraula, encertsLletres);
            char lletra = demanarLletra(lletres);
            if (comprovacioEncerts(paraula, lletra, encertsLletres)) {
                totalEncerts += comptaEncerts(paraula, lletra);
            } else {
                errorsTotals++;
                estatPenjat_errors(estatPenjat, errorsTotals);
            }
            lletres += lletra;
            System.out.println("Lletres: " + lletres);
            esborarPantalla();
        } while (totalEncerts < paraula.length() && errorsTotals <= 7);
        mostrarEstatPenjat(estatPenjat);
        mostrarParaula(paraula, encertsLletres);
        System.out.println("Lletres: " + lletres);
        if (errorsTotals >= 7) {
            System.out.println("OOOOOoooohhhh! Has perdut!!\nLa paraula secreta era " + paraula);
        } else {
            System.out.println("Felicitats! Has encertat la paraula secreta!!");
        }
    }
    
    static void mostrarEstatPenjat(char[][] estat) {
        for (char[] fila : estat) {
            for (char valor : fila) {
                System.out.print(valor);
            }
            
            System.out.println("");
        }
    }
    
    static void inicialitzarPenjat(char[][] estatPenjatInicial, char[][] estat) {
        for (int fila = 0; fila < estatPenjatInicial.length; fila++) {
            for (int columna = 0; columna < estatPenjatInicial[0].length; columna++) {
                estat[fila][columna] = estatPenjatInicial[fila][columna];
            }
        }
    }
    
    static void mostrarParaula(String paraula, boolean[] encertades) {
        System.out.print("Paraula: ");
        for (int i = 0; i < paraula.length(); i++) {
            if (encertades[i]) {
                System.out.print(paraula.charAt(i));
            } else {
                System.out.print("*");
            }
        }
        
        System.out.println("");
    }
    
    static boolean comprovacioEncerts(String paraula, char lletra, boolean[] encerts) {
        boolean resultat = false;
        for (int i = 0; i < paraula.length(); i++) {
            if (paraula.charAt(i) == lletra) {
                encerts[i] = true;
                resultat = true;
            }
        }
        
        return resultat;
    }

    static int comptaEncerts(String paraula, char lletra) {
        int encerts = 0;
        for (int i = 0; i < paraula.length(); i++) {
            if (paraula.charAt(i) == lletra) {
                encerts++;
            }
        }
        
        return encerts;
    }
    
    static char demanarLletra(String lletres) {
        char lletra;
        do {
            System.out.print("Introdueix lletra: ");
            lletra = sc.nextLine().toLowerCase().charAt(0);
        } while (!lletraValida(lletra, lletres));
        
        return lletra;
    }
    
    static boolean lletraRepetida(char lletra, String lletres) {
        for (int i = 0; i < lletres.length(); i++) {
            if (lletres.charAt(i) == lletra) {
                return true;
            }
        }
        
        return false;
    }
    
    static boolean lletraValida(char lletra, String lletres) {
        if (Character.isLetter(lletra) && !lletraRepetida(lletra, lletres)) {
            return true;
        } else if (!Character.isLetter(lletra)) {
            System.out.println("Lletra no vàlida");
        }
        
        return false;
    }
    
    static void estatPenjat_errors(char[][] penjat, int errors) {
        if(errors == 1){
            penjat[1][8] = '|';
        }else if(errors == 2){
            penjat[2][8] = 'O';
        }else if(errors == 3){
            penjat[3][8] = '|';
        }else if(errors == 4){
            penjat[3][7] = '/';
        }else if(errors == 5){
            penjat[3][9] = '\\';
        }else if(errors == 6){
            penjat[4][8] = '|';
        }else if(errors == 7){
            penjat[5][7] = '/';
        }else if(errors == 8){
            penjat[5][9] = '\\';
        }
    }
    static void esborarPantalla() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {}
    }
}