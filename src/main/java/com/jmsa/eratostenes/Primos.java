/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmsa.eratostenes;

/**
 *
 * @author jmsa
 */
public class Primos
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        int[] caja = Criba.generarPrimos(100);
        for(int i = 0; i < caja.length; i++)
        {
            // Imprimimos los elementos del array en pantalla.
            System.out.println(""+caja[i]);
        } 
    }
    
}
