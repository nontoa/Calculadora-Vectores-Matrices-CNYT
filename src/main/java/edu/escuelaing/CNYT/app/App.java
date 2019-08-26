package edu.escuelaing.CNYT.app;

import java.util.ArrayList;
import java.util.Scanner;
import edu.escuelaing.CNYT.app.Complejo;
import java.text.DecimalFormat;

/**
 * Hello world!
 *
 */
public class App {

    public static int operacion;
    public static ArrayList<Complejo> vector1;
    public static ArrayList<Complejo> vector2;
    public static Complejo escalar;
    public static DecimalFormat round = new DecimalFormat("#.00");

    public static void main(String[] args) {
        operacion = 0;
        vector1 = new ArrayList<Complejo>();
        vector2 = new ArrayList<Complejo>();
        escalar = new Complejo(0, 0);
        menu();
    }

    public static void menu() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Digite el número de la operación a realizar");
        System.out.println("1. Adición de vectores complejos.\n"
                + "2. Inversa de vectores complejos.\n"
                + "3. Multiplicación escalar de vectores complejos.\n"
                + "4. Adición de matrices complejas.\n"
                + "5. Inversa de matrices complejas.\n"
                + "6. Multiplicación escalar de matrices complejas.\n"
                + "7. Matriz transpuesta\n"
                + "8. Matriz conjugada\n"
                + "9. Matriz adjunta\n"
                + "10. Función para calcular la \"acción\" de una matriz sobre un vector.\n"
                + "11. Norma de matrices\n"
                + "12. Distancia entre matrices\n"
                + "13. Revisar si es unitaria\n"
                + "14. Revisar si es Hermitian\n"
                + "15. Producto tensor.");
        operacion = reader.nextInt();
        Scanner reader2 = new Scanner(System.in);
        String numero = "";
        switch (operacion) {
            case (1):
                System.out.println("Ingrese los cuatro números complejos del primer vector separado por un espacio la parte real de la imaginaria");
                for (int x = 0; x < 4; x++) {
                    numero = reader2.nextLine();
                    String[] parts = numero.split(" ");
                    vector1.add(new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1])));
                }
                System.out.println("Ingrese los cuatro números complejos del vector separado por un espacio la parte real de la imaginaria");
                for (int x = 0; x < 4; x++) {
                    numero = reader2.nextLine();
                    String[] parts = numero.split(" ");
                    vector1.add(new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1])));
                }
                adicionVectores();
                break;
            case (2):
                System.out.println("Ingrese los cuatro números complejos del primer vector separado por un espacio la parte real de la imaginaria");
                for (int x = 0; x < 4; x++) {
                    numero = reader2.nextLine();
                    String[] parts = numero.split(" ");
                    vector1.add(new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1])));
                }
                inversaVector();
                break;
            case (3):
                System.out.println("Ingrese el escalar a multiplicar separado por un espacio la parte real de la imaginaria");
                numero = reader2.nextLine();
                String[] parts2 = numero.split(" ");
                escalar.setReal(Double.parseDouble(parts2[0]));
                escalar.setImag(Double.parseDouble(parts2[1]));
                System.out.println("Ingrese los cuatro números complejos del primer vector separado por un espacio la parte real de la imaginaria");
                for (int x = 0; x < 4; x++) {
                    numero = reader2.nextLine();
                    String[] parts = numero.split(" ");
                    vector1.add(new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1])));
                }
                multiplicacionEscalarVectores();
                break;
            case (4):
                Scanner reader3 = new Scanner(System.in);
                int x,
                 y;
                System.out.println("Ingrese el numero de filas");
                x = reader2.nextInt();
                System.out.println("Ingrese el numero de columas");
                y = reader2.nextInt();
                Complejo[][] matA = new Complejo[x][y];
                Complejo[][] matB = new Complejo[x][y];
                System.out.println("Ingrese los datos para la matriz A separado por un espacio la parte real de la imaginaria");
                for (int f = 0; f < x; f++) {
                    System.out.println("Ingrese los datos de la fila " + f);
                    for (int t = 0; t < y; t++) {
                        numero = reader3.nextLine();
                        String[] parts = numero.split(" ");
                        matA[f][t] = new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                    }
                }
                System.out.println("Ingrese los datos para la matriz B separado por un espacio la parte real de la imaginaria");
                for (int f = 0; f < x; f++) {
                    System.out.println("Ingrese los datos de la fila " + f);                    
                    for (int t = 0; t < y; t++) {
                        numero = reader3.nextLine();
                        String[] parts = numero.split(" ");
                        matB[f][t] = new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                    }
                }
                adicionMatrices(matA, matB, x, y);
                break;
            case (5):
                inversaMatrices();
                break;
            case (6):
                multiplicacionEscalarMatrices();
                break;
            case (7):
                matrizTraspuesta();
                break;
            case (8):
                matrizConjugada();
                break;
            case (9):
                matrizAdjunta();
                break;
            case (10):
                accionMatrizVector();
                break;
            case (11):
                normaMatriz();
                break;
            case (12):
                distanciaMatrices();
                break;
            case (13):
                matrizUnitaria();
                break;
            case (14):
                matrizHermitian();
                break;
            case (15):
                productoTensor();
                break;
        }
    }

    private static void adicionVectores() {
        ArrayList<Complejo> respuesta = new ArrayList<Complejo>();
        Complejo num;
        for (int x = 0; x < 4; x++) {
            num = new Complejo((vector1.get(x).getReal() + vector2.get(x).getReal()), (vector1.get(x).getImag() + vector2.get(x).getImag()));
            respuesta.add(num);
        }
        System.out.println("La suma de los vectores da como resultado");
        for (Complejo comp : respuesta) {
            if (comp.getImag() > 0) {
                System.out.println(round.format(comp.getReal()) + "+" + round.format(comp.getImag()) + "i");
            } else {
                System.out.println(round.format(comp.getReal()) + "" + round.format(comp.getImag()) + "i");
            }
        }
    }

    private static void inversaVector() {
        System.out.println("La inversa del vector da como resultado");
        for (Complejo comp : vector1) {
            if (comp.getImag() * -1 > 0) {
                System.out.println(round.format(comp.getReal() * -1) + "+" + round.format(comp.getImag() * -1) + "i");
            } else {
                System.out.println(round.format(comp.getReal() * -1) + "" + round.format(comp.getImag() * -1) + "i");
            }
        }
    }

    private static void multiplicacionEscalarVectores() {
        ArrayList<Complejo> respuesta = new ArrayList<Complejo>();
        for (Complejo com : vector1) {
            respuesta.add(multiplicacionComplejos(escalar, com));
        }
        System.out.println("La multiplicación del vector por el escalar da como resultado");
        for (Complejo comp : respuesta) {
            if (comp.getImag() > 0) {
                System.out.println(round.format(comp.getReal()) + "+" + round.format(comp.getImag()) + "i");
            } else {
                System.out.println(round.format(comp.getReal()) + "" + round.format(comp.getImag()) + "i");
            }
        }

    }

    private static void adicionMatrices(Complejo[][] matA, Complejo[][] matB, int x, int y) {
        System.out.println("La suma de las dos matrices da como resultado");
        for (int a = 0; a < x; a++) {
            String res="";
            for (int b = 0; b < y; b++) {
                if (matA[a][b].getImag() + matB[a][b].getImag() > 0) {
                    res+=round.format(matA[a][b].getReal()+matB[a][b].getReal())+"+"+ round.format(matA[a][b].getImag()+matB[a][b].getImag())+"i  ";
                    //System.out.println(round.format(matA[a][b].getReal()+matB[a][b].getReal())+"+"+ round.format(matA[a][b].getImag()+matB[a][b].getImag())+"i");
                } else {
                    res+=round.format(matA[a][b].getReal()+matB[a][b].getReal())+""+ round.format(matA[a][b].getImag()+matB[a][b].getImag())+"i  ";
                    //System.out.println(round.format(matA[a][b].getReal()+matB[a][b].getReal())+""+ round.format(matA[a][b].getImag()+matB[a][b].getImag())+"i");                    
                }                
            }
                System.out.println(res);
        }

    }

    private static void inversaMatrices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void multiplicacionEscalarMatrices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void matrizTraspuesta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void matrizConjugada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void matrizAdjunta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void accionMatrizVector() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void normaMatriz() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void distanciaMatrices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void matrizUnitaria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void matrizHermitian() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void productoTensor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static Complejo multiplicacionComplejos(Complejo c1, Complejo c2) {
        double x = c1.real * c2.real - c1.imag * c2.imag;
        double y = c1.real * c2.imag + c1.imag * c2.real;
        return (new Complejo(x, y));

    }

}
