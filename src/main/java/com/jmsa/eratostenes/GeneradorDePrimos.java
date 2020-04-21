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
    
    private static boolean esPrimo[];
    private static int primos[];
    
    
    private static void inicializarCandidatos(int max)
    {
        int i;
       // Tamaño del array max +1
        esPrimo = new boolean[max + 1];
        
        // Eliminar el 0 y el 1, que no son primos
        esPrimo[0] = esPrimo[1] = false;
        // Inicializar resto del array
        for (i = 2; i < esPrimo.length; i++)
        {
            esPrimo[i] = true;
        }
        
        
    }
    
    private static void eliminarMultiplos()
    {
        int i, j;
        for (i = 2; i < maxFactor(); i++)
        {
            if (esPrimo[i])
            {
                // Eliminar los múltiplos de i
                for (j = 2 * i; j < esPrimo.length; j += i)
                {
                    esPrimo[j] = false;
                }
            }
        }
    }

    private static int maxFactor()
    {
        return (int) Math.sqrt(esPrimo.length) + 1;
    }
    
    private static void obtenerCandidatosNoEliminados()
    {
        int i, j, cuenta = 0;
        for (i = 0; i < esPrimo.length; i++)
        {
            if (esPrimo[i])
            {
                cuenta++;
            }
        }
        // Rellenar el vector de números primos
        primos = new int[cuenta];
        for (i = 0, j = 0; i < esPrimo.length; i++)
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
            inicializarCandidatos(max);
            eliminarMultiplos();
            obtenerCandidatosNoEliminados();
            return primos;
        }
    }
}
