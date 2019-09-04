package edu.escuelaing.CNYT.app;

import java.text.DecimalFormat;
import java.util.ArrayList;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    public DecimalFormat round = new DecimalFormat("#.00");

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Este metodo se encarga de probar la operacion de adicion de verctores.
     */
    public void testAdicionVectores() {
        ArrayList<Complejo> res = new ArrayList<Complejo>();
        App.iniciailizar();
        App.vector1.add(new Complejo(5, -9));
        App.vector1.add(new Complejo(2.36, 56));
        App.vector1.add(new Complejo(15.98, -9.45));
        App.vector1.add(new Complejo(2.2, 3.3));
        App.vector2.add(new Complejo(5.6, 96.3));
        App.vector2.add(new Complejo(14, -6.36));
        App.vector2.add(new Complejo(9, -9));
        App.vector2.add(new Complejo(5, -8));
        res = App.adicionVectores();
        assertEquals("10,60", round.format(res.get(0).getReal()));
        assertEquals("87,30", round.format(res.get(0).getImag()));
        assertEquals("16,36", round.format(res.get(1).getReal()));
        assertEquals("49,64", round.format(res.get(1).getImag()));
        assertEquals("24,98", round.format(res.get(2).getReal()));
        assertEquals("-18,45", round.format(res.get(2).getImag()));
        assertEquals("7,20", round.format(res.get(3).getReal()));
        assertEquals("-4,70", round.format(res.get(3).getImag()));

    }

    /**
     * Este metodo se encarga de probar la operacion de inversa de un vector.
     */
    public void testInversaVector() {
        ArrayList<Complejo> res = new ArrayList<Complejo>();
        App.iniciailizar();
        App.vector1.add(new Complejo(4, -8.3));
        App.vector1.add(new Complejo(-5, 6.47));
        App.vector1.add(new Complejo(8, 1));
        App.vector1.add(new Complejo(12.25, -14.36));
        res = App.inversaVector();
        assertEquals("-4,00", round.format(res.get(0).getReal()));
        assertEquals("8,30", round.format(res.get(0).getImag()));
        assertEquals("5,00", round.format(res.get(1).getReal()));
        assertEquals("-6,47", round.format(res.get(1).getImag()));
        assertEquals("-8,00", round.format(res.get(2).getReal()));
        assertEquals("-1,00", round.format(res.get(2).getImag()));
        assertEquals("-12,25", round.format(res.get(3).getReal()));
        assertEquals("14,36", round.format(res.get(3).getImag()));
    }

    /**
     * Este metodo se encarga de probar la operacion de multiplicacion escalar
     * de vectores.
     */
    public void testMultiplicacionVector() {
        ArrayList<Complejo> res = new ArrayList<Complejo>();
        App.iniciailizar();
        App.escalar = new Complejo(5, -8.2);
        App.vector1.add(new Complejo(45.2, -63.2));
        App.vector1.add(new Complejo(178.3, 52.63));
        App.vector1.add(new Complejo(-235.5, 253));
        App.vector1.add(new Complejo(12.12, 23.23));
        res = App.multiplicacionEscalarVectores();
        assertEquals("-292,24", round.format(res.get(0).getReal()));
        assertEquals("-686,64", round.format(res.get(0).getImag()));
        assertEquals("1323,07", round.format(res.get(1).getReal()));
        assertEquals("-1198,91", round.format(res.get(1).getImag()));
        assertEquals("897,10", round.format(res.get(2).getReal()));
        assertEquals("3196,10", round.format(res.get(2).getImag()));
        assertEquals("251,09", round.format(res.get(3).getReal()));
        assertEquals("16,77", round.format(res.get(3).getImag()));
    }

    /**
     * Este metodo se encarga de probar la operacion de suma de matrices.
     */
    public void testAdicionMatrices() {
        Complejo[][] res = new Complejo[2][2];
        App.iniciailizar();
        Complejo[][] mat1 = new Complejo[2][2];
        Complejo[][] mat2 = new Complejo[2][2];
        mat1[0][0] = new Complejo(-5, 52);
        mat1[0][1] = new Complejo(56, 89);
        mat1[1][0] = new Complejo(12.36, -8.3);
        mat1[1][1] = new Complejo(45, 19.54);
        mat2[0][0] = new Complejo(9, 42);
        mat2[0][1] = new Complejo(-19, 14);
        mat2[1][0] = new Complejo(-25.47, -1.2);
        mat2[1][1] = new Complejo(10, 78);
        res = App.adicionMatrices(mat1, mat2, 2, 2);
        assertEquals("4,00", round.format(res[0][0].getReal()));
        assertEquals("94,00", round.format(res[0][0].getImag()));
        assertEquals("37,00", round.format(res[0][1].getReal()));
        assertEquals("103,00", round.format(res[0][1].getImag()));
        assertEquals("-13,11", round.format(res[1][0].getReal()));
        assertEquals("-9,50", round.format(res[1][0].getImag()));
        assertEquals("55,00", round.format(res[1][1].getReal()));
        assertEquals("97,54", round.format(res[1][1].getImag()));
    }

    /**
     * Este metodo se encarga de probar la operacion de la inversa de una
     * matriz.
     */
    public void testInversaMatrices() {
        double[][] res = new double[2][2];
        App.iniciailizar();
        double[][] mat = new double[2][2];
        mat[0][0] = 2.5;
        mat[0][1] = 10.2;
        mat[1][0] = -89.36;
        mat[1][1] = 123.0;
        res = App.inversaMatrices(mat);        
        assertEquals(",10", round.format(res[0][0]));
        assertEquals("-,01", round.format(res[0][1]));
        assertEquals(",07", round.format(res[1][0]));
        assertEquals(",00", round.format(res[1][1]));
    }
    
    /**
     * Este metodo se encarga de probar la operacion de multiplicacion
     * de matrices.
     */
    public void testMultiplicacionMatrices() {
        Complejo[][] res = new Complejo[2][2];
        App.iniciailizar();
        Complejo[][] mat1 = new Complejo[2][2];
        Complejo[][] mat2 = new Complejo[2][2];
        mat1[0][0] = new Complejo(-78, 15.2);
        mat1[0][1] = new Complejo(96, -29);
        mat1[1][0] = new Complejo(10.25, 15.3);
        mat1[1][1] = new Complejo(74, -52.36);
        mat2[0][0] = new Complejo(5, 26);
        mat2[0][1] = new Complejo(-19.25, 74);
        mat2[1][0] = new Complejo(25, -63.4);
        mat2[1][1] = new Complejo(10.56, 15);
        res = App.multiplicacionEscalarMatrices(mat1, mat2, 2);
        assertEquals("-223,80", round.format(res[0][0].getReal()));
        assertEquals("-8763,40", round.format(res[0][0].getImag()));
        assertEquals("1825,46", round.format(res[0][1].getReal()));
        assertEquals("-4930,84", round.format(res[0][1].getImag()));
        assertEquals("-1816,17", round.format(res[1][0].getReal()));
        assertEquals("-5657,60", round.format(res[1][0].getImag()));
        assertEquals("237,33", round.format(res[1][1].getReal()));
        assertEquals("1021,05", round.format(res[1][1].getImag()));
    }
    
    /**
     * Este metodo se encarga de probar la operacion de la transpuesta
     * de una matriz
     */
    public void testMatrizTranspuesta(){
        Complejo[][] res = new Complejo[2][2];
        App.iniciailizar();
        Complejo[][] mat1 = new Complejo[2][2];        
        mat1[0][0] = new Complejo(78.36, -25);
        mat1[0][1] = new Complejo(66.66, 45.6);
        mat1[1][0] = new Complejo(47.36, -18.73);
        mat1[1][1] = new Complejo(78, 17);        
        res = App.matrizTraspuesta(mat1, 2,2);
        assertEquals("78,36", round.format(res[0][0].getReal()));
        assertEquals("-25,00", round.format(res[0][0].getImag()));
        assertEquals("47,36", round.format(res[0][1].getReal()));
        assertEquals("-18,73", round.format(res[0][1].getImag()));
        assertEquals("66,66", round.format(res[1][0].getReal()));
        assertEquals("45,60", round.format(res[1][0].getImag()));
        assertEquals("78,00", round.format(res[1][1].getReal()));
        assertEquals("17,00", round.format(res[1][1].getImag()));
        
    }
    
    /**
     * Este metodo se encarga de probar la operacion de la conjugada
     * de una matriz
     */
    public void testMatrizConjugada(){
        Complejo[][] res = new Complejo[2][2];
        App.iniciailizar();
        Complejo[][] mat1 = new Complejo[2][2];        
        mat1[0][0] = new Complejo(-88.3, 45.6);
        mat1[0][1] = new Complejo(66.66, 41.23);
        mat1[1][0] = new Complejo(1.36, -54.45);
        mat1[1][1] = new Complejo(8,36);        
        res = App.matrizConjugada(mat1, 2,2);
        assertEquals("-88,30", round.format(res[0][0].getReal()));
        assertEquals("-45,60", round.format(res[0][0].getImag()));
        assertEquals("66,66", round.format(res[0][1].getReal()));
        assertEquals("-41,23", round.format(res[0][1].getImag()));
        assertEquals("1,36", round.format(res[1][0].getReal()));
        assertEquals("54,45", round.format(res[1][0].getImag()));
        assertEquals("8,00", round.format(res[1][1].getReal()));
        assertEquals("-36,00", round.format(res[1][1].getImag()));
        
    }
    
    /**
     * Este metodo se encarga de probar la operacion de la adjunta
     * de una matriz
     */
    public void testMatrizAdjunta(){
        Complejo[][] res = new Complejo[2][2];
        App.iniciailizar();
        Complejo[][] mat1 = new Complejo[2][2];        
        mat1[0][0] = new Complejo(33.14, 45.6);
        mat1[0][1] = new Complejo(14.7, -7.57);
        mat1[1][0] = new Complejo(3.33,13.23);
        mat1[1][1] = new Complejo(-9.69,10);        
        res = App.matrizAdjunta(mat1, 2,2);
        assertEquals("33,14", round.format(res[0][0].getReal()));
        assertEquals("-45,60", round.format(res[0][0].getImag()));
        assertEquals("3,33", round.format(res[0][1].getReal()));
        assertEquals("-13,23", round.format(res[0][1].getImag()));
        assertEquals("14,70", round.format(res[1][0].getReal()));
        assertEquals("7,57", round.format(res[1][0].getImag()));
        assertEquals("-9,69", round.format(res[1][1].getReal()));
        assertEquals("-10,00", round.format(res[1][1].getImag()));
        
    }
    
    /**
     * Este metodo se encarga de probar la operacion de la norma
     * de una matriz
     */
    public void testMatrizNorma(){
        double res = 0.0;
        App.iniciailizar();
        Complejo[][] mat1 = new Complejo[2][2];        
        mat1[0][0] = new Complejo(2,-5);
        mat1[0][1] = new Complejo(-3,6);
        mat1[1][0] = new Complejo(5,5);
        mat1[1][1] = new Complejo(6,-3);
        res = App.normaMatriz(mat1, 2,2);
        assertEquals("13,00", round.format(res));   
        
    }
    
    /**
     * Este metodo se encarga de probar la operacion verificacion unitaria
     * de una matriz
     */
    public void testMatrizUnitaria(){        
        App.iniciailizar();
        Complejo[][] mat1 = new Complejo[3][3];        
        mat1[0][0] = new Complejo(1, 0);
        mat1[0][1] = new Complejo(0, 0);
        mat1[0][2] = new Complejo(0, 0);
        mat1[1][0] = new Complejo(0,0);
        mat1[1][1] = new Complejo(1,0); 
        mat1[1][2] = new Complejo(0, 0);
        mat1[2][0] = new Complejo(0,0);
        mat1[2][1] = new Complejo(0,0); 
        mat1[2][2] = new Complejo(1, 0);        
        assertTrue(App.matrizUnitaria(mat1, 3, 3));        
        
    }
    
    /**
     * Este metodo se encarga de probar la operacion de la accion de una matriz
     * sobre un vector.
     */
    public void testAccionMatrizVector(){        
        App.iniciailizar();
        Complejo[] res = new Complejo[3];
        Complejo[] vec = new Complejo[3];
        Complejo[][] mat1 = new Complejo[2][3];        
        mat1[0][0] = new Complejo(-3, 5.5);
        mat1[0][1] = new Complejo(5, 18.3);
        mat1[0][2] = new Complejo(-6, 12.6);
        mat1[1][0] = new Complejo(7,17.2);
        mat1[1][1] = new Complejo(10,22); 
        mat1[1][2] = new Complejo(-1, -5);        
        vec[0]= new Complejo(-6,2.6);
        vec[1]= new Complejo(-2,5.6);
        vec[2]= new Complejo(5,12);
        res = App.accionMatrizVector(mat1, vec, 2, 3);
        
        assertEquals("-289,98",round.format(res[0].getReal()));               
        assertEquals("-58,40",round.format(res[0].getImag()));
        assertEquals("-174,92",round.format(res[1].getReal()));               
        assertEquals("-110,00",round.format(res[1].getImag()));
    }
    
    /**
     * Este metodo se encarga de probar la operacion de la distancia entre
     * matrices.
     */
    public void testDistanciaMatrices(){
        double res = 0.0;
        App.iniciailizar();
        Complejo[][] mat1 = new Complejo[2][2];        
        mat1[0][0] = new Complejo(2,-5);
        mat1[0][1] = new Complejo(-3,6);
        mat1[1][0] = new Complejo(5,5);
        mat1[1][1] = new Complejo(6,-3);
        Complejo[][] mat2 = new Complejo[2][2];        
        mat2[0][0] = new Complejo(15,16);
        mat2[0][1] = new Complejo(-35,-66.36);
        mat2[1][0] = new Complejo(18.36,-11);
        mat2[1][1] = new Complejo(6,88.24);
        res = App.distanciaMatrices(mat1,mat2, 2,2);
        assertEquals("125,02", round.format(res));   
        
    }
    
    
    /**
     * Este metodo se encarga de probar la operacion verificacion hermitiana
     * de una matriz
     */
    public void testMatrizHermitiana(){        
        App.iniciailizar();
        Complejo[][] mat1 = new Complejo[2][2];        
        mat1[0][0] = new Complejo(3, 0);
        mat1[0][1] = new Complejo(2, 1);
        mat1[1][0] = new Complejo(2,-1);
        mat1[1][1] = new Complejo(1,0);                  
        assertTrue(App.matrizHermitian(mat1, 2, 2));        
        
    }
    
    /**
     * Este metodo se encarga de probar la operacion del producto tensor
     * de dos matrices.
     */
    public void testProductoTensor(){
        Complejo[][] res = new Complejo[4][4];
        App.iniciailizar();
        Complejo[][] mat1 = new Complejo[2][2];        
        mat1[0][0] = new Complejo(1, -3);
        mat1[0][1] = new Complejo(-3, 4);
        mat1[1][0] = new Complejo(7,-1);
        mat1[1][1] = new Complejo(2,2);  
        
        Complejo[][] mat2 = new Complejo[2][2];        
        mat2[0][0] = new Complejo(2,-4);
        mat2[0][1] = new Complejo(3,8);
        mat2[1][0] = new Complejo(1,-2);
        mat2[1][1] = new Complejo(3,5);     
        
        res = App.productoTensor(mat1,mat2,2);
            
        assertEquals("-10,00", round.format(res[0][0].getReal()));
        assertEquals("-10,00", round.format(res[0][0].getImag()));
        assertEquals("27,00", round.format(res[0][1].getReal()));
        assertEquals("-1,00", round.format(res[0][1].getImag()));
        assertEquals("10,00", round.format(res[0][2].getReal()));
        assertEquals("20,00", round.format(res[0][2].getImag()));
        assertEquals("-41,00", round.format(res[0][3].getReal()));
        assertEquals("-12,00", round.format(res[0][3].getImag()));
        
        assertEquals("-5,00", round.format(res[1][0].getReal()));
        assertEquals("-5,00", round.format(res[1][0].getImag()));
        assertEquals("18,00", round.format(res[1][1].getReal()));
        assertEquals("-4,00", round.format(res[1][1].getImag()));
        assertEquals("5,00", round.format(res[1][2].getReal()));
        assertEquals("10,00", round.format(res[1][2].getImag()));
        assertEquals("-29,00", round.format(res[1][3].getReal()));
        assertEquals("-3,00", round.format(res[1][3].getImag()));
        
        assertEquals("10,00", round.format(res[2][0].getReal()));
        assertEquals("-30,00", round.format(res[2][0].getImag()));
        assertEquals("29,00", round.format(res[2][1].getReal()));
        assertEquals("53,00", round.format(res[2][1].getImag()));
        assertEquals("12,00", round.format(res[2][2].getReal()));
        assertEquals("-4,00", round.format(res[2][2].getImag()));
        assertEquals("-10,00", round.format(res[2][3].getReal()));
        assertEquals("22,00", round.format(res[2][3].getImag()));
        
        assertEquals("5,00", round.format(res[3][0].getReal()));
        assertEquals("-15,00", round.format(res[3][0].getImag()));
        assertEquals("26,00", round.format(res[3][1].getReal()));
        assertEquals("32,00", round.format(res[3][1].getImag()));
        assertEquals("6,00", round.format(res[3][2].getReal()));
        assertEquals("-2,00", round.format(res[3][2].getImag()));
        assertEquals("-4,00", round.format(res[3][3].getReal()));
        assertEquals("16,00", round.format(res[3][3].getImag()));
        
    }
}
