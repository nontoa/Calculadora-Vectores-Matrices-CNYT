# Calculadora-Vectores-Matrices-CNYT


## Empezando

>Para clonar el archivo 

git clone https://github.com/nontoa/Calculadora-Vectores-Matrices-CNYT.git
>
### Prerrequisitos
* Maven
* Java
* Git


## Construido con

* [Maven](https://maven.apache.org/) - Gestión de dependencias

## Números complejos:

Un número complejo, es una entidad matemática que viene dada por un par de números reales, el primero x se denomina la parte real y al segundo y la parte imaginaria. Los números complejos se representa por un par de números entre paréntesis (x, y), como los puntos del plano, o bien, en la forma usual de x+yi, i se denomina la unidad imaginaria, la raíz cuadrada de menos uno.

## Funcionamiento del programa:

### Menu:

Hay un menú para elegir la operacion a realizar con n números complejos.

![Screenshot](images/Menu.PNG)

### Ingresando datos y resultado:

Escogemos una opción del menú y digitamos el número correspondiente y presionamos enter.

Enseguida depende de la operación escogida nos pedira difrentes datos.

En este caso digitaremos la dimension de la matriz y luego digitaremos los números separados por un espacio la parte real y la parte imaginaria.

Por último veremos el resultado en este caso de la multiplicación de las matrices.

![Screenshot](images/Mult.PNG)



## Descripción del programa:

## Código Encargado del menu y recoleccion de datos:

```java

/**
     * En este método se encuentran todas las opciones para las
     * operaciones a realizar en la calculadora.
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


```

## Código encargado para operaciones lógicas.

Cada método esta encargado de una tarea especifica. Hay métodos auxiliares que ayudan al calculo de alguna operacion como multiplicación y suma de números complejos.

```java

/**
     * Este metodo se encarga de la suma de vectores.
     */
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

    /**
     * Este metodo se encarga de calcular la inversa de un vector.
     */
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

    /**
     * Este metodo se encarga de multiplicar un escalar por un vector.
     */
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

    /**
     * Este metodo se encarga de la adicion de dos matrices.
     * @param matA Primera matriz.
     * @param matB Segunda matriz.
     * @param x Numero de filas.
     * @param y Numero de columnas.
     */
    private static void adicionMatrices(Complejo[][] matA, Complejo[][] matB, int x, int y) {
        System.out.println("La suma de las dos matrices da como resultado");
        for (int a = 0; a < x; a++) {
            String res = "";
            for (int b = 0; b < y; b++) {
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

    }

    /**
     * Este metodo se encarga de calcular la inversa de una matriz.
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
     * @param mat1 Primera matriz.
     * @param mat2 Segunda matriz.
     * @param de Dimension de las matrices.
     */
    private static void multiplicacionEscalarMatrices(Complejo[][] mat1, Complejo[][] mat2, int de) {
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
    }

    /**
     * Este metodo se encarga de la multiplicacion de dos complejos.
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
     * @param c1 Primer complejo.
     * @param c2 Segundo comolejo.
     * @return Retorna la suma de los complejos.
     */
    public static Complejo sumarComplejos(Complejo c1, Complejo c2) {
        return new Complejo(c1.getReal() + c2.getReal(), c1.getImag() + c2.getImag());
    }

    /**
     * Este metodo se encarga de calcular la traspuesta de una matriz.
     * @param mat Matriz inicial.
     * @param x Numero de filas.
     * @param y Numero de columnas.
     */
    private static void matrizTraspuesta(Complejo[][] mat, int x, int y) {
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
    }

    /**
     * Este metodo se encarga de calcular la conjugada de una matriz.
     * @param mat Matriz inicial.
     * @param x Numero de filas.
     * @param y Numero de columnas.
     */
    private static void matrizConjugada(Complejo[][] mat, int x, int y) {
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

```


## Autor


* **Juan Nicolas Nontoa Caballero**  Calculadora-Vectores-Matrices-CNYT - [nontoa] (https://github.com/nontoa)

## licencia

Este proyecto está licenciado bajo la Licencia GNU - vea el archivo [LICENSE](LICENSE) para más detalles.

