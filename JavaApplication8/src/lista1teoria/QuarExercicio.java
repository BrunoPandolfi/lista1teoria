/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista1teoria;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Akiro
 */
public class QuarExercicio 
{
    public static ArrayList<Integer> maiorCliqueMaximal(int v, int matrizAdj[][])
    {
        ArrayList<Integer> conjV = new ArrayList<Integer>();
        conjV.add(v);
        System.out.println("Quantidade de vértices: " + matrizAdj.length);
        for (int i = 0; i < matrizAdj.length; i++)
        {
            if (eVizinho(i, conjV, matrizAdj) == true)
            {
                conjV.add(i);
            }
        }
        return conjV;
    }

    public static boolean eVizinho (int v, ArrayList<Integer> conjV, int matrizAdj[][])
    {
        boolean viz = true;
        int v1;
        for (int i = 0; i < conjV.size(); i++)
        {
            System.out.println("Indice metodo vizinho: " + i);
            v1 = conjV.get(i);
            if (v != v1)
            {
                if (matrizAdj[v1][v] == 0 && matrizAdj[v][v1] == 0)
                {
                    viz = false;
                    break;
                }
            }
        }
        return viz;
    }
    
    public static StringBuilder imprimirCliqueMaximal (ArrayList<Integer> conjV)
    {
        StringBuilder cm = new StringBuilder();
        for (int i = 0; i < conjV.size(); i++)
        {
            cm.append(conjV.get(i));
            if (i != conjV.size() - 1)
                cm.append("-");
        }
        return cm;
    }
    
    public static void main (String args[])
    {
        int matrizAdj[][] = {{0,1,1,0,0,0,0,0},{0,0,1,1,0,0,0,0}, 
                             {0,0,0,0,0,0,0,0},{0,0,0,0,1,1,1,1}, 
                             {0,0,0,0,0,1,1,1},{0,0,0,0,0,0,1,1},
                             {0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0}};
        Scanner leitor;
        int v;
        ArrayList<Integer> conjV;
        int sair = 1;
        leitor = new Scanner(System.in);
        
        while (sair != 0)
        {
            System.out.print("Digite o vértice para encontrar o clique maximal:");
            v = leitor.nextInt();
            conjV = maiorCliqueMaximal(v, matrizAdj);
            System.out.print("\nMaior Clique maximal que contém o vértice passado: ");
            System.out.print(imprimirCliqueMaximal (conjV).toString() + "\n");
            System.out.println ("Digite 1 para continuar ou 0 para sair: ");
            sair = leitor.nextInt();
        }
    }

}
