/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmsa.eratostenes;

/* Se ha modificado la clase, eliminando los métodos static, para poner crear 
más de un objeto de la clase, cada uno con su tabla de primos. ¿Te parece mejor 
la solución? La llamada en la función main se ha adecuado a al nueva definición
de la clase. Ahora hace falta crear un objeto. Esto es aplicable a los test.¿Ves
algo mejorable en los test? (algún código reduntante o algo)
*/


/**
 *
 * @author jmsa
 */
public class GeneradorDePrimos
{
    
    private static boolean esPrimo[];
    private static int primos[];
    /**
     * Generar números primos de 1 a max
     *
     * @param max es el valor máximo
     * @return Vector de números primos
     */
    //convertido en constructor, por tanto no devuelve nada y necesitamos un 
    //método para obtener esos primos ->getPrimos
    public GeneradorDePrimos(int max)
    {
        int i, j;
        if (max < 2)
        { 
            primos = new int[0]; // Vector vacío
        }
        else
        {
            inicializarCandidatos(max);
            eliminarMultiplos();
            obtenerCandidatosNoEliminados();
        }
    }
    // obtenido mediante encapsulate field
    public int[] getPrimos()
    {
        return primos;
    }
        
    private void inicializarCandidatos(int max)
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
    
    private void eliminarMultiplos()
    {
        int i;
        for (i = 2; i < maxFactorPrimo(); i++)
        {
            if (esPrimo[i])
            {
                eliminarMultiplosDe(i);
            }
        }
    }
    //cambiado nombre
    private int maxFactorPrimo()
    {
        return (int) Math.sqrt(esPrimo.length) + 1;
    }
    
    //extraída de eliminarMultiplos mediante Introduce Method en Netbeans, 
    //extract function en Intellij
    private void eliminarMultiplosDe( int i)
    {
        // Eliminar los múltiplos de i
        int multiplo;//podríamos haberlo dejado como j 
        for (multiplo = 2 * i; multiplo < esPrimo.length; multiplo += i)
        {
            esPrimo[multiplo] = false;
        }
    }

    private void obtenerCandidatosNoEliminados()
    {
        int i, j;
        // Rellenar el vector de números primos
        primos = new int[numPrimos()];
        for (i = 0, j = 0; i < esPrimo.length; i++)
        {
            if (esPrimo[i])
            {
                primos[j++] = i;
            }
        }
    }

    private int numPrimos() //extraída mediante refactor->introduce->method
    {
        int i, cuenta = 0;
        for (i = 0; i < esPrimo.length; i++)
        {
            if (esPrimo[i])
            {
                cuenta++;
            }
        }
        return cuenta;
    }

    /**
     * @return the primos
     */
}
