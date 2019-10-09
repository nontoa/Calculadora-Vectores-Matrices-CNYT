# Calculadora-Vectores-Matrices-CNYT


## Empezando

>Para clonar el archivo 

>git clone https://github.com/nontoa/Calculadora-Vectores-Matrices-CNYT.git

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

## Código encargado para operaciones lógicas.

Cada método esta encargado de una tarea especifica. Hay métodos auxiliares que ayudan al calculo de alguna operación.

### Adición de vectores complejos:

```java

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
```

### Inversa de vectores complejos:

```java

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
```

### Multiplicación escalar de vectores complejos:

```java

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
```

### Adición de matrices complejas:

```java

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
```

### Inversa de matrices complejas:

```java

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

```

### Multiplicación escalar de matrices complejas:
```java

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

```

### Matriz Transpuesta:
```java

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
```

### Matriz Conjugada:
```java

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
```

### Matriz Adjunta:
```java
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
```

### Función para calcular la "acción" de una matriz sobre un vector:
```java
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
```
### Norma de matrices:
```java

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
```

### Distancia entre matrices:
```java
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

```

### Matriz Unitaria:
```java
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
```

### Matriz Hermitiana:
```java
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
```

### Producto Tensor:
```java
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
```


## Autor


* **Juan Nicolas Nontoa Caballero**  Calculadora-Vectores-Matrices-CNYT - [nontoa] (https://github.com/nontoa)

## licencia

Este proyecto está licenciado bajo la Licencia GNU - vea el archivo [LICENSE](LICENSE) para más detalles.

