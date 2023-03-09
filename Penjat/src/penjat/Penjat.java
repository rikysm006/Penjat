

package penjat;
import java.util.Scanner;
/**
 *
 * @author ricar
 */
public class Penjat {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String[] llistaParaules = {"patata", "escola", "poma", "taula", "internet",
                "llapis", "pantalla", "altaveu", "ordinador", "ratolí"};
        String paraulaEndevinar;

        paraulaEndevinar = triaParaula(llistaParaules);
        System.out.println(paraulaEndevinar);
        if (jugar(paraulaEndevinar) == true) {
            System.out.println("Enhorabona!!! Has encertat la paraula " + paraulaEndevinar);
        } else {
            System.out.println("OOOOOoooohhhh! Has perdut!!\n\n"
                    + "La paraula secreta era: " + paraulaEndevinar);
        }
    }

    public static String triaParaula(String[] llista) {
        int index = (int) (Math.random() * (llista.length));
        return llista[index];
    }


    public static boolean jugar(String paraula) {
        String paraulaParcial = "", lletresDites = "", lletra;
        Scanner in = new Scanner(System.in);
        int posicion, encerts = 0, errors = 0;

        for (int i = 0; i < paraula.length(); i++) {
            paraulaParcial += "*";
        }

        for (int i = 0; i < 8 && encerts < paraula.length(); i++) {
            pintarForca(errors);
            System.out.printf("Paraula: %s%n", paraulaParcial);
            System.out.printf("Lletres: %s%n", lletresDites);
            System.out.print("Introdueix lletra: ");
            lletra = in.nextLine();
            if (paraula.contains(lletra)) {
                lletresDites += lletra;
                posicion = -1;
                do {
                    posicion = paraula.indexOf(lletra, posicion+1);
                    if (posicion >= 0) {
                        paraulaParcial = paraulaParcial.substring(0, posicion)
                                + lletra + paraulaParcial.substring(posicion + 1);
                        encerts++;
                    }
                } while (posicion != -1 && posicion < paraula.length()-1);
            }else{
                errors++;
            }
        }
        return (encerts == paraula.length());
    }

    public static void pintarForca(int nombreErrors){
        String[] forcaZero = {
                "   __",
                "  |    ",
                "  |",
                "  |",
                "  |",
                "  |",
                " |",
                "|   |__",
                "|          |",
                "|____|"
        };

        String[][] forcaErrors = {
                {"","","","",""},
                {"|","","","",""},
                {"|","O","","",""},
                {"|","O","|","",""},
                {"|","O","/|","",""},
                {"|","O","/|\\","",""},
                {"|","O","/|\\","|",""},
                {"|","O","/|\\","|","/"},
                {"|","O","/|\\","|","\\"}
        };

        System.out.println(forcaZero[0]);

        for (int i = 1; i < 5; i++) {
            System.out.print(forcaZero[i]);
            System.out.println(forcaErrors[nombreErrors][i]);
        }

        for (int i = 5; i < forcaZero.length; i++) {
            System.out.println(forcaZero[i]);
        }
    }

}
    
    
    public static void mostrarEstatPenjat(char[][] estat) {
        for (char[] fila : estat) {
            for (char valor : fila) {
                System.out.print(valor);
            }
            System.out.println("");
        }
    }
    
    static void inicialitzarEstatPenjat(char[][] estatPenjatIni, char[][] estat) {
        for (int fila = 0; fila < estatPenjatIni.length; fila++) {
            for (int columna = 0; columna < estatPenjatIni[0].length; columna++) {
                estat[fila][columna] = estatPenjatIni[fila][columna];
            }
        }
    }
    
    static void mostrarParaula(String paraula, boolean[] encertades) {
        
    }
    
    static void mostrarLletresIntroduides(String lletres) {
        System.out.println("Introdueix una lletra.");
        
    }
    
    static String demanarLletra(String lletres) {
        
    return lletres;
    }
    
    static boolean existeixLletra(String lletres, char lletra) {
    
        return x;
    }
    
    static void actualitzarEstatPenjat(char[][] penjat,int errors) {
        
    }
    
    static void netejaPantalla() {
    
    }
    
    
    
}
