package edu.escuelaing.CNYT.app;

import java.util.ArrayList;
import java.util.Scanner;
import edu.escuelaing.CNYT.app.Complejo;
import java.text.DecimalFormat;

/**
 * Clase encargada de la lógica de la calculadora
 *
 */
public class App {

    public static int operacion = 0;
    public static ArrayList<Complejo> vector1 = new ArrayList<Complejo>();
    ;
    public static ArrayList<Complejo> vector2 = new ArrayList<Complejo>();
    ;
    public static Complejo escalar = new Complejo(0, 0);
    public static DecimalFormat round = new DecimalFormat("#.00");

    /**
     * Main de la clase, inicializa variable y llama al mentodo menu.
     *
     * @param args
     */
    public static void main(String[] args) {
        menu();
    }

    /**
     * En este método se encuentran todas las opciones para las operaciones a
     * realizar en la calculadora.
     */
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
                    vector2.add(new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1])));
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
                reader.close();
                reader2.close();
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
                reader2.close();
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
                reader3.close();
                adicionMatrices(matA, matB, x, y);
                break;
            case (5):
                Scanner input = new Scanner(System.in);
                System.out.println("Digite la dimension de la matriz: ");
                int n = input.nextInt();
                double a[][] = new double[n][n];
                System.out.println("Digite los elementos de la matriz: ");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        a[i][j] = input.nextDouble();
                    }
                }
                double d[][] = inversaMatrices(a);

                System.out.println("La inversa es: ");

                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        System.out.print(round.format(d[i][j]) + "  ");
                    }

                    System.out.println();
                }
                input.close();
                break;
            case (6):
                Scanner reader4 = new Scanner(System.in);
                int de;
                System.out.println("Ingrese la dimension de la matriz");
                de = reader2.nextInt();
                Complejo[][] mat1 = new Complejo[de][de];
                Complejo[][] mat2 = new Complejo[de][de];
                System.out.println("Ingrese los datos para la matriz A separado por un espacio la parte real de la imaginaria");
                for (int f = 0; f < de; f++) {
                    System.out.println("Ingrese los datos de la fila " + f);
                    for (int t = 0; t < de; t++) {
                        numero = reader4.nextLine();
                        String[] parts = numero.split(" ");
                        mat1[f][t] = new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                    }
                }
                System.out.println("Ingrese los datos para la matriz B separado por un espacio la parte real de la imaginaria");
                for (int f = 0; f < de; f++) {
                    System.out.println("Ingrese los datos de la fila " + f);
                    for (int t = 0; t < de; t++) {
                        numero = reader4.nextLine();
                        String[] parts = numero.split(" ");
                        mat2[f][t] = new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                    }
                }
                reader4.close();
                multiplicacionEscalarMatrices(mat1, mat2, de);
                break;
            case (7):
                Scanner reader5 = new Scanner(System.in);
                int x1,
                 y1;
                System.out.println("Ingrese el numero de filas");
                x1 = reader2.nextInt();
                System.out.println("Ingrese el numero de columas");
                y1 = reader2.nextInt();
                Complejo[][] matA1 = new Complejo[x1][y1];
                System.out.println("Ingrese los datos para la matriz separado por un espacio la parte real de la imaginaria");
                for (int f = 0; f < x1; f++) {
                    System.out.println("Ingrese los datos de la fila " + f);
                    for (int t = 0; t < y1; t++) {
                        numero = reader5.nextLine();
                        String[] parts = numero.split(" ");
                        matA1[f][t] = new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                    }
                }
                reader5.close();
                matrizTraspuesta(matA1, x1, y1);
                break;
            case (8):
                Scanner reader6 = new Scanner(System.in);
                int x2,
                 y2;
                System.out.println("Ingrese el numero de filas");
                x2 = reader2.nextInt();
                System.out.println("Ingrese el numero de columas");
                y2 = reader2.nextInt();
                Complejo[][] matA2 = new Complejo[x2][y2];
                System.out.println("Ingrese los datos para la matriz separado por un espacio la parte real de la imaginaria");
                for (int f = 0; f < x2; f++) {
                    System.out.println("Ingrese los datos de la fila " + f);
                    for (int t = 0; t < y2; t++) {
                        numero = reader6.nextLine();
                        String[] parts = numero.split(" ");
                        matA2[f][t] = new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                    }
                }
                reader6.close();
                matrizConjugada(matA2, x2, y2);
                break;
            case (9):
                Scanner read1 = new Scanner(System.in);
                int xx,
                 yy;
                System.out.println("Ingrese el numero de filas");
                xx = reader2.nextInt();
                System.out.println("Ingrese el numero de columas");
                yy = reader2.nextInt();
                Complejo[][] matt1 = new Complejo[xx][yy];
                System.out.println("Ingrese los datos para la matriz separado por un espacio la parte real de la imaginaria");
                for (int f = 0; f < xx; f++) {
                    System.out.println("Ingrese los datos de la fila " + f);
                    for (int t = 0; t < yy; t++) {
                        numero = read1.nextLine();
                        String[] parts = numero.split(" ");
                        matt1[f][t] = new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                    }
                }
                read1.close();
                matrizAdjunta(matt1, xx, yy);
                break;
            case (10):
                Scanner read234 = new Scanner(System.in);
                int xxx2,
                 yyy2;
                System.out.println("Ingrese el numero de filas de la matriz");
                xxx2 = reader2.nextInt();
                System.out.println("Ingrese el numero de columas de la matriz");
                yyy2 = reader2.nextInt();
                Complejo[][] matr1 = new Complejo[xxx2][yyy2];
                Complejo[] vect = new Complejo[yyy2];
                System.out.println("Ingrese los datos para la matriz separado por un espacio la parte real de la imaginaria");
                for (int f = 0; f < xxx2; f++) {
                    System.out.println("Ingrese los datos de la fila " + f);
                    for (int t = 0; t < yyy2; t++) {
                        numero = read234.nextLine();
                        String[] parts = numero.split(" ");
                        matr1[f][t] = new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                    }
                }
                System.out.println("Ingrese los datos para el vector separado por un espacio la parte real de la imaginaria");
                for (int i = 0; i < yyy2; i++) {
                    numero = read234.nextLine();
                    String[] parts = numero.split(" ");
                    vect[i] = new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                }
                read234.close();
                accionMatrizVector(matr1, vect, xxx2, yyy2);
                break;
            case (11):
                Scanner r = new Scanner(System.in);
                int x01,
                 y01;
                System.out.println("Ingrese el numero de filas");
                x01 = reader2.nextInt();
                System.out.println("Ingrese el numero de columas");
                y01 = reader2.nextInt();
                Complejo[][] matx = new Complejo[x01][y01];
                System.out.println("Ingrese los datos para el vector separado por un espacio la parte real de la imaginaria");
                for (int f = 0; f < x01; f++) {
                    System.out.println("Ingrese los datos de la fila " + f);
                    for (int t = 0; t < y01; t++) {
                        numero = r.nextLine();                        
                        String[] parts = numero.split(" ");
                        matx[f][t] = new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                    }
                }
                r.close();
                normaMatriz(matx, x01, y01);
                break;
            case (12):
                Scanner reader33 = new Scanner(System.in);
                int x7,
                 y7;
                System.out.println("Ingrese el numero de filas");
                x7 = reader2.nextInt();
                System.out.println("Ingrese el numero de columas");
                y7 = reader2.nextInt();
                Complejo[][] matA7 = new Complejo[x7][y7];
                Complejo[][] matB7 = new Complejo[x7][y7];
                System.out.println("Ingrese los datos para la matriz A separado por un espacio la parte real de la imaginaria");
                for (int f = 0; f < x7; f++) {
                    System.out.println("Ingrese los datos de la fila " + f);
                    for (int t = 0; t < y7; t++) {
                        numero = reader33.nextLine();
                        String[] parts = numero.split(" ");
                        matA7[f][t] = new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                    }
                }
                System.out.println("Ingrese los datos para la matriz B separado por un espacio la parte real de la imaginaria");
                for (int f = 0; f < x7; f++) {
                    System.out.println("Ingrese los datos de la fila " + f);
                    for (int t = 0; t < y7; t++) {
                        numero = reader33.nextLine();
                        String[] parts = numero.split(" ");
                        matB7[f][t] = new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                    }
                }
                reader33.close();
                distanciaMatrices(matA7,matB7,x7,y7);
                break;
            case (13):
                Scanner read23 = new Scanner(System.in);
                int xx2,
                 yy2;
                System.out.println("Ingrese el numero de filas");
                xx2 = reader2.nextInt();
                System.out.println("Ingrese el numero de columas");
                yy2 = reader2.nextInt();
                Complejo[][] matr = new Complejo[xx2][yy2];
                System.out.println("Ingrese los datos para la matriz separado por un espacio la parte real de la imaginaria");
                for (int f = 0; f < xx2; f++) {
                    System.out.println("Ingrese los datos de la fila " + f);
                    for (int t = 0; t < yy2; t++) {
                        numero = read23.nextLine();
                        String[] parts = numero.split(" ");
                        matr[f][t] = new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                    }
                }
                read23.close();
                matrizUnitaria(matr, xx2, yy2);
                break;
            case (14):
                Scanner read22 = new Scanner(System.in);
                int xx1,
                 yy1;
                System.out.println("Ingrese el numero de filas");
                xx1 = reader2.nextInt();
                System.out.println("Ingrese el numero de columas");
                yy1 = reader2.nextInt();
                Complejo[][] matt01 = new Complejo[xx1][yy1];
                System.out.println("Ingrese los datos para la matriz separado por un espacio la parte real de la imaginaria");
                for (int f = 0; f < xx1; f++) {
                    System.out.println("Ingrese los datos de la fila " + f);
                    for (int t = 0; t < yy1; t++) {
                        numero = read22.nextLine();
                        String[] parts = numero.split(" ");
                        matt01[f][t] = new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                    }
                }
                read22.close();
                matrizHermitian(matt01, xx1, yy1);
                break;
            case (15):
                Scanner read = new Scanner(System.in);
                int dim;
                System.out.println("Ingrese la dimension de la matriz");
                dim = reader2.nextInt();
                Complejo[][] mata = new Complejo[dim][dim];
                Complejo[][] matb = new Complejo[dim][dim];
                System.out.println("Ingrese los datos para la matriz A separado por un espacio la parte real de la imaginaria");
                for (int f = 0; f < dim; f++) {
                    System.out.println("Ingrese los datos de la fila " + f);
                    for (int t = 0; t < dim; t++) {
                        numero = read.nextLine();
                        String[] parts = numero.split(" ");
                        mata[f][t] = new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                    }
                }
                System.out.println("Ingrese los datos para la matriz B separado por un espacio la parte real de la imaginaria");
                for (int f = 0; f < dim; f++) {
                    System.out.println("Ingrese los datos de la fila " + f);
                    for (int t = 0; t < dim; t++) {
                        numero = read.nextLine();
                        String[] parts = numero.split(" ");
                        matb[f][t] = new Complejo(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                    }
                }
                read.close();
                productoTensor(mata, matb, dim);
                break;
        }
    }

    /**
     * Este metodo se encarga de la suma de vectores.
     */
    public static ArrayList<Complejo> adicionVectores() {
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

        return respuesta;
    }

    /**
     * Este metodo se encarga de calcular la inversa de un vector.
     */
    public static ArrayList<Complejo> inversaVector() {
        ArrayList<Complejo> respuesta = new ArrayList<Complejo>();
        System.out.println("La inversa del vector da como resultado");
        for (Complejo comp : vector1) {
            respuesta.add(new Complejo(comp.getReal() * -1, comp.getImag() * -1));
            if (comp.getImag() * -1 > 0) {
                System.out.println(round.format(comp.getReal() * -1) + "+" + round.format(comp.getImag() * -1) + "i");
            } else {
                System.out.println(round.format(comp.getReal() * -1) + "" + round.format(comp.getImag() * -1) + "i");
            }
        }
        return respuesta;
    }

    /**
     * Este metodo se encarga de multiplicar un escalar por un vector.
     */
    public static ArrayList<Complejo> multiplicacionEscalarVectores() {
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
        return respuesta;

    }

    /**
     * Este metodo se encarga de la adicion de dos matrices.
     *
     * @param matA Primera matriz.
     * @param matB Segunda matriz.
     * @param x Numero de filas.
     * @param y Numero de columnas.
     */
    public static Complejo[][] adicionMatrices(Complejo[][] matA, Complejo[][] matB, int x, int y) {
        Complejo[][] respuesta = new Complejo[x][y];
        System.out.println("La suma de las dos matrices da como resultado");
        for (int a = 0; a < x; a++) {
            String res = "";
            for (int b = 0; b < y; b++) {
                respuesta[a][b] = new Complejo(matA[a][b].getReal() + matB[a][b].getReal(), matA[a][b].getImag() + matB[a][b].getImag());
                if (matA[a][b].getImag() + matB[a][b].getImag() > 0) {
                    res += round.format(matA[a][b].getReal() + matB[a][b].getReal()) + "+" + round.format(matA[a][b].getImag() + matB[a][b].getImag()) + "i  ";
                    //System.out.println(round.format(matA[a][b].getReal()+matB[a][b].getReal())+"+"+ round.format(matA[a][b].getImag()+matB[a][b].getImag())+"i");
                } else {
                    res += round.format(matA[a][b].getReal() + matB[a][b].getReal()) + "" + round.format(matA[a][b].getImag() + matB[a][b].getImag()) + "i  ";
                    //System.out.println(round.format(matA[a][b].getReal()+matB[a][b].getReal())+""+ round.format(matA[a][b].getImag()+matB[a][b].getImag())+"i");                    
                }
            }
            System.out.println(res);
        }
        return respuesta;

    }

    /**
     * Este metodo se encarga de la resta de dos matrices.
     *
     * @param matA Primera matriz.
     * @param matB Segunda matriz.
     * @param x Numero de filas.
     * @param y Numero de columnas.
     */
    public static Complejo[][] restaMatrices(Complejo[][] matA, Complejo[][] matB, int x, int y) {
        Complejo[][] respuesta = new Complejo[x][y];        
        for (int a = 0; a < x; a++) {            
            for (int b = 0; b < y; b++) {
                respuesta[a][b] = new Complejo(matA[a][b].getReal() - matB[a][b].getReal(), matA[a][b].getImag() - matB[a][b].getImag());                
            }            
        }
        return respuesta;

    }
    
    /**
     * Este metodo se encarga de calcular la inversa de una matriz.
     *
     * @param a Es la matriz inicial.
     * @return Retorna la inversa de la matriz.
     */
    public static double[][] inversaMatrices(double a[][]) {

        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i = 0; i < n; ++i) {
            b[i][i] = 1;
        }
        gaussian(a, index);
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    b[index[j]][k]
                            -= a[index[j]][i] * b[index[i]][k];
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            x[n - 1][i] = b[index[n - 1]][i] / a[index[n - 1]][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    x[j][i] -= a[index[j]][k] * x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

    /**
     * Este metodo ayuda a el calculo de la inversa de una matriz
     *
     * @param a Matriz inicial
     * @param index Indice de la matriz a calcular.
     */
    public static void gaussian(double a[][], int index[]) {

        int n = index.length;
        double c[] = new double[n];
        for (int i = 0; i < n; ++i) {
            index[i] = i;
        }
        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) {
                    c1 = c0;
                }
            }
            c[i] = c1;
        }
        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pi1 = 0;
            for (int i = j; i < n; ++i) {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; ++i) {
                double pj = a[index[i]][j] / a[index[j]][j];
                a[index[i]][j] = pj;
                for (int l = j + 1; l < n; ++l) {
                    a[index[i]][l] -= pj * a[index[j]][l];
                }
            }
        }
    }

    /**
     * Este metodo se encarga de realizar la multiplicacion de dos matrices.
     *
     * @param mat1 Primera matriz.
     * @param mat2 Segunda matriz.
     * @param de Dimension de las matrices.
     */
    public static Complejo[][] multiplicacionEscalarMatrices(Complejo[][] mat1, Complejo[][] mat2, int de) {
        Complejo[][] res = new Complejo[de][de];
        for (int x = 0; x < de; x++) {
            for (int y = 0; y < de; y++) {
                Complejo suma = new Complejo(0, 0);
                for (int z = 0; z < de; z++) {
                    suma = sumarComplejos(suma, multiplicacion(mat1[x][z], mat2[z][y]));
                }
                res[x][y] = suma;
            }
        }
        System.err.println("El resultado de la multiplicacion de las matrices es: ");
        for (int a = 0; a < de; a++) {
            String s = "";
            for (int b = 0; b < de; b++) {
                s += round.format(res[a][b].getReal());
                if (res[a][b].getImag() > 0) {
                    s += "+" + round.format(res[a][b].getImag());
                } else {
                    s += round.format(res[a][b].getImag());
                }
                s += "i ";
            }
            System.out.println(s);
        }
        return res;
    }

    /**
     * Este metodo se encarga de la multiplicacion de dos complejos.
     *
     * @param c1 Primer complejo.
     * @param c2 Segundo complejo.
     * @return Retorna la multiplicacion de los complejos.
     */
    public static Complejo multiplicacion(Complejo c1, Complejo c2) {
        double x = c1.real * c2.real - c1.imag * c2.imag;
        double y = c1.real * c2.imag + c1.imag * c2.real;
        return (new Complejo(x, y));

    }

    /**
     * Este metodo se encarga de la suma de complejos.
     *
     * @param c1 Primer complejo.
     * @param c2 Segundo comolejo.
     * @return Retorna la suma de los complejos.
     */
    public static Complejo sumarComplejos(Complejo c1, Complejo c2) {
        return new Complejo(c1.getReal() + c2.getReal(), c1.getImag() + c2.getImag());
    }

    /**
     * Este metodo se encarga de calcular la traspuesta de una matriz.
     *
     * @param mat Matriz inicial.
     * @param x Numero de filas.
     * @param y Numero de columnas.
     */
    public static Complejo[][] matrizTraspuesta(Complejo[][] mat, int x, int y) {
        Complejo[][] res = new Complejo[y][x];
        for (int a = 0; a < x; a++) {
            for (int b = 0; b < y; b++) {
                res[b][a] = mat[a][b];
            }
        }
        System.err.println("El resultado de la matriz traspuesta es: ");
        for (int a = 0; a < y; a++) {
            String s = "";
            for (int b = 0; b < x; b++) {
                s += round.format(res[a][b].getReal());
                if (res[a][b].getImag() > 0) {
                    s += "+" + round.format(res[a][b].getImag());
                } else {
                    s += round.format(res[a][b].getImag());
                }
                s += "i ";
            }
            System.out.println(s);
        }
        return res;
    }

    /**
     * Este metodo se encarga de calcular la conjugada de una matriz.
     *
     * @param mat Matriz inicial.
     * @param x Numero de filas.
     * @param y Numero de columnas.
     */
    public static Complejo[][] matrizConjugada(Complejo[][] mat, int x, int y) {
        Complejo[][] res = new Complejo[x][y];
        for (int a = 0; a < x; a++) {
            for (int b = 0; b < y; b++) {
                res[a][b] = new Complejo(mat[a][b].getReal(), mat[a][b].getImag() * -1);
            }
        }
        System.err.println("El resultado de la matriz conjugada es: ");
        for (int a = 0; a < y; a++) {
            String s = "";
            for (int b = 0; b < x; b++) {
                s += round.format(res[a][b].getReal());
                if (res[a][b].getImag() > 0) {
                    s += "+" + round.format(res[a][b].getImag());
                } else {
                    s += round.format(res[a][b].getImag());
                }
                s += "i ";
            }
            System.out.println(s);
        }
        return res;

    }

    /**
     * Este metodo se encarga de calcular la matriz adjunta.
     * @param mat Matriz inicial.
     * @param x Numero de filas.
     * @param y Numero de columnas.
     * @return Retorna la matriz adjunta.
     */
    public static Complejo[][] matrizAdjunta(Complejo[][] mat, int x, int y) {
        Complejo[][] Trasp = matrizTraspuesta(mat, x, y);
        Complejo[][] res = matrizConjugada(Trasp, x, y);
        System.out.println("El resultado de la matriz adjunta es: ");
        String s;
        for (int f = 0; f < x; f++) {
            s = "";
            for (int t = 0; t < y; t++) {
                if (res[f][t].getImag() > 0) {
                    s += round.format(res[f][t].getReal()) + "+" + round.format(res[f][t].getImag()) + "i ";
                } else {
                    s += round.format(res[f][t].getReal()) + "" + round.format(res[f][t].getImag()) + "i ";
                }
            }
            System.out.println(s);
        }
        return res;
    }

    /**
     * Este metodo se encarga de la multiplicacion de una matriz por un vector.
     * @param mat Matriz inicial.
     * @param vec Vector inicial.
     * @param x Numero de filas.
     * @param y Numero de columnas.
     * @return Retorna el vector resultante de la multiplicacion.
     */
    public static Complejo[] accionMatrizVector(Complejo[][] mat, Complejo[] vec, int x, int y) {
        Complejo[] res = new Complejo[x];
        Complejo suma;
        for (int i = 0; i < x; i++) {
            suma = new Complejo(0, 0);
            for (int j = 0; j < y; j++) {
                suma = sumarComplejos(suma, multiplicacionComplejos(mat[i][j], vec[j]));
            }
            res[i] = suma;

        }
        System.out.println("El resultado de la accion matriz vector es :");
        for (int i = 0; i < x; i++) {
            if (res[i].getImag() > 0) {
                System.out.println(round.format(res[i].getReal()) + "+" + round.format(res[i].getImag()) + "i ");
            } else {
                System.out.println(round.format(res[i].getReal()) + "" + round.format(res[i].getImag()) + "i ");
            }
        }
        return res;

    }

    /**
     * Este metodo se encarga de calcular la norma de una matriz.
     * @param mat Matriz inicial.
     * @param x Numero de filas.
     * @param y Numero de columnas.
     * @return Retorna la norma de la matriz.
     */
    public static double normaMatriz(Complejo[][] mat, int x, int y) {
        double respuesta = 0.0;
        Complejo[][] adj = new Complejo[x][y];
        Complejo[][] res= new Complejo[x][y];
        adj=matrizAdjunta(mat, x, y);
        res=multiplicacionEscalarMatrices(adj, mat, x);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(i == j) respuesta+=res[i][j].getReal();
            }
        }
        System.out.println("La norma de la matriz es: "+ Math.sqrt(respuesta));
        return Math.sqrt(respuesta);
    }

    /**
     * Este metodo se encarga de calcular la distancia entre dos matrices.
     * @param matA Matriz 1 incial.
     * @param matB Matriz 2 inicial.
     * @param x Numero de filas.
     * @param y Numero de columnas.
     * @return Retorna la distancia entre las dos matrices.
     */
    public static double distanciaMatrices(Complejo[][] matA, Complejo[][] matB, int x, int y) {
        Complejo[][] res = restaMatrices(matA, matB, x, y);
        double respuesta = normaMatriz(res, x, y);
        System.out.println("La distancia entre las matrices es de: " + round.format(respuesta));
        return respuesta;
    }

    /**
     * Este metodo se encarga de verificar si una matriz es unitaria.
     * @param mat Matriz incial.
     * @param x Numero de filas.
     * @param y Numero de columnas.
     * @return Retorna un booleano.
     */
    public static Boolean matrizUnitaria(Complejo[][] mat, int x, int y) {
        Complejo[][] adj = matrizAdjunta(mat, x, y);
        Complejo[][] res = multiplicacionEscalarMatrices(adj, mat, x);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == j) {
                    if (res[i][j].getReal() != 1.0) {
                        System.out.println("La matriz no es Unitaria");
                        return false;
                    }
                }
            }
        }
        System.out.println("La matriz si es Unitaria");
        return true;
    }

    /**
     * Este metodo se encarga de verificar si una matriz es Hermitiana.
     * @param mat Matriz inicial.
     * @param x Numero de filas.
     * @param y Numero de columnas.
     * @return Retorna un booleano.
     */
    public static Boolean matrizHermitian(Complejo[][] mat, int x, int y) {
        Complejo[][] adj = matrizAdjunta(mat, x, y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (adj[i][j].getReal() != mat[i][j].getReal() && adj[i][j].getImag() != mat[i][j].getImag()) {
                    System.out.println("La matriz no es Hermitiana");
                    return false;
                }
            }
        }
        System.out.println("La matriz si es Hermitiana");
        return true;
    }

    /**
     * Este metodo se encarga de calcular el poducto tensor entre dos matrices nxm.
     * @param mat1 Matriz 2 inicial.
     * @param mat2 Matriz 2 inicial.
     * @param d Dimension de las matrices.
     * @return Retorna la matriz resultante al realizar el producto tensor.
     */
    public static Complejo[][] productoTensor(Complejo[][] mat1, Complejo[][] mat2, int d) {
        Complejo[][] res = new Complejo[d * d][d * d];
        Complejo[][] aux = new Complejo[d][d];
        int a = 0;
        int b = 0;
        for (int x = 0; x < d; x++) {
            for (int y = 0; y < d; y++) {
                aux = tensor(mat1[x][y], mat2, d);
                for (int i = 0; i < d; i++) {
                    for (int j = 0; j < d; j++) {
                        if (y > 0 || x > 0) {
                            if (y > 0 && x > 0) {
                                res[i + x + 1][j + y + 1] = aux[i][j];
                            } else if (y > 0) {
                                res[i][j + y + 1] = aux[i][j];
                            } else if (x > 0) {
                                res[i + x + 1][j] = aux[i][j];
                            }
                        } else {
                            res[i][j] = aux[i][j];
                        }
                    }
                }
            }
        }
        System.out.println("El resultado del producto tensor es: ");
        String s;
        for (int f = 0; f < d * d; f++) {
            s = "";
            for (int t = 0; t < d * d; t++) {
                if (res[f][t].getImag() > 0) {
                    s += round.format(res[f][t].getReal()) + "+" + round.format(res[f][t].getImag()) + "i ";
                } else {
                    s += round.format(res[f][t].getReal()) + "" + round.format(res[f][t].getImag()) + "i ";
                }
            }
            System.out.println(s);
        }
        return res;
    }

    /**
     * Este metodo ayuda a calcular el producto tensor. Calcula la multiplicacion
     * de un numero complejo y una matriz.
     * @param num Numero Complejo.
     * @param mat Matriz incial.
     * @param d Dimension de la matriz.
     * @return Retorna la matriz resultante de la multiplicacion.
     */
    public static Complejo[][] tensor(Complejo num, Complejo[][] mat, int d) {
        Complejo[][] ret = new Complejo[d][d];
        for (int x = 0; x < d; x++) {
            for (int y = 0; y < d; y++) {
                ret[x][y] = multiplicacionComplejos(num, mat[x][y]);
            }
        }
        return ret;
    }

    /**
     * Este metodo se encarga de la multiplicacion de dos complejos.
     * @param c1 Complejo 1.
     * @param c2 Complejo 2.
     * @return Retorna un complejo.
     */
    public static Complejo multiplicacionComplejos(Complejo c1, Complejo c2) {
        double x = c1.real * c2.real - c1.imag * c2.imag;
        double y = c1.real * c2.imag + c1.imag * c2.real;
        return (new Complejo(x, y));

    }

    /**
     * Este metodo se encarga de inicializar todas las variables globales.
     */
    public static void iniciailizar() {
        operacion = 0;
        vector1.clear();
        vector2.clear();
        escalar = new Complejo(0, 0);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

}
