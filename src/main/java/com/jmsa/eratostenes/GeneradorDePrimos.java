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
public class GeneradorDePrimos
{
    /**
     * Generar números primos de 1 a max
     *
     * @param max es el valor máximo
     * @return Vector de números primos
     */
    private static int dim;
    private static boolean esPrimo[];
    private static int primos[];
    
    
    private static void inicializarCriba(int max)
    {
        int i;
        dim = max + 1; // Tamaño del array
        esPrimo = new boolean[dim];
        // Inicializar el array
        for (i = 0; i < dim; i++)
        {
            esPrimo[i] = true;
        }
        // Eliminar el 0 y el 1, que no son primos
        esPrimo[0] = esPrimo[1] = false;
    }
    
    private static void cribar()
    {
        int i, j;
        for (i = 2; i < Math.sqrt(dim) + 1; i++)
        {
            if (esPrimo[i])
            {
                // Eliminar los múltiplos de i
                for (j = 2 * i; j < dim; j += i)
                {
                    esPrimo[j] = false;
                }
            }
        }
    }
    private static void rellenarPrimos()
    {
        int i, j, cuenta = 0;
        for (i = 0; i < dim; i++)
        {
            if (esPrimo[i])
            {
                cuenta++;
            }
        }
        // Rellenar el vector de números primos
        primos = new int[cuenta];
        for (i = 0, j = 0; i < dim; i++)
        {
            if (esPrimo[i])
            {
                primos[j++] = i;
            }
        }
    }
    public static int[] generarPrimos(int max)
    {
        int i, j;
        if (max < 2)
        { // max < 2
            return new int[0]; // Vector vacío
        }
        else
        {
            inicializarCriba(max);
            cribar();
            rellenarPrimos();
            return primos;
        }
    }
}
