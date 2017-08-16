/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista1teoria;

import java.util.Scanner;

/**
 *
 * @author Analista
 */
public class PrimExercicio 
{
    
    public static boolean eClique (int matrizAdj[][], int subgrafo[])
    {
        boolean clique = true;
        int i = 0;
        while (i < subgrafo.length && clique != false)
        {
            int v1;
            int v2;
            v1 = subgrafo[i];
            for (int j = i + 1; j < subgrafo.length; j++)
            {
                v2 = subgrafo[j];
                if (v1 >= matrizAdj.length || v2 >= matrizAdj.length)
                {
                    clique = false;
                    break;
                }
                
                if (matrizAdj[v1][v2] == 0)
                {
                    clique = false;
                    break;
                }
            }
            i++;
        }
        return clique;
    }

    public static void main (String[] args)
    {
        int matrizAdj[][] = {{0,1,1,1},{0,0,1,1}, {0,0,0,0}, {0,0,0,0}};
       // int nvertices;
        int subgrafo[] = null;
        int nsub;
        String linha;
        String conjv[];
        Scanner leitor;
        leitor = new Scanner(System.in);
        
        System.out.println("Matriz de adjacencia");
        for (int j = 0; j < matrizAdj.length; j++)
        {
            for (int k = 0; k < matrizAdj[0].length; k++)
                System.out.print(" " + matrizAdj[j][k]);
            System.out.println("");
        }
        
        
        System.out.println("Digite a quantidade de vertices do subgrafo:");
        System.out.print("Quantidade de vertíces: ");
        nsub = leitor.nextInt();
        
        if (nsub <= 4)
        {
            System.out.println("Digite o subgrafo a ser analisado:");
            linha = leitor.next();
            conjv = linha.split("-");

            subgrafo = new int[conjv.length];

            System.out.println(conjv.length);
            
            for (int i = 0; i < conjv.length; i++)
                subgrafo[i] = Integer.parseInt(conjv[i]);

            
            
            if (eClique(matrizAdj, subgrafo) == true)
                System.out.println("O subgrafo é clique");
            else 
                System.out.println("O subgrafo não é clique");
        }
        
        else 
        {
            System.out.println("Tamanho escolhido incompatível com o tamanho do grafo");
        }
    }
    
}
