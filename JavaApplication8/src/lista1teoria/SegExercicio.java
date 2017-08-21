package lista1teoria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SegExercicio {

    /**
     * @param args the command line arguments
     */
    
    
    //DADOS DO PROBLEMA
    /*int [][]matrizAdj = new int[][] { {0, 1, 1, 1, 1, 0, 0}, {1, 0, 1, 1, 1, 0, 0}, {1, 1, 0, 1, 1, 0, 0}, {1, 1, 1, 0, 1, 0, 0},
                                   {1, 1, 1, 1, 0, 0, 0} , {1, 0, 0, 0, 0, 0, 1} , {1, 0, 0, 0, 0, 1, 0}};
    */
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //Matriz de adjacencias
        //int matrizAdj[][] = {{0,0,1,0,0},{0,0,1,1,1}, {1,1,0,1,1}, {0,1,1,0,1}, {0,1,1,1,0}};
        //int matrizAdj[][] = {{0,0,1,0,0},{0,0,1,0,0}, {1,1,0,1,1}, {0,0,1,0,1}, {0,0,1,1,0}};
        int matrizAdj[][] = {{0,1,1,0,0},{1,0,1,0,0}, {1,1,0,1,1}, {0,0,1,0,1}, {0,0,1,1,0}};
        //int matrizAdj[][] = {{0,1,1,1},{1,0,1,1}, {1,1,0,1}, {1,1,1,0}};
        //int matrizAdj[][] = {{0,1,0},{1,0,1}, {0,1,0}};
        // Exercício 1
        //ex1(matrizAdj);
        
        // Exercício 4
        ex4(matrizAdj);
        
        // Exercício 5
        //ex5();        
    }
    
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
    
    public static int[] maiorMaximal (int matrizAdj[][], int dado){
        
        int[] vertices = new int[matrizAdj.length];
        int k = 0;
        vertices[k] = dado;

        int[] verticesAux;
        verticesAux = vertices;
        
        // Verifico todas as arestas deste vértice dado
        for(int j=0; j < matrizAdj[dado].length; j++){            
            
            //Se tiver aresta adiciona no C' e verifica se é clique
            if (1 == matrizAdj[dado][j]){
               verticesAux[k+1] = j;
               
               //Se for clique adiciona no C
               if (eClique(matrizAdj, verticesAux)){
                   k++;
                   vertices[k] = j;
               }
            }
        } 
        
        return vertices;
    }
    
    public static  void ex1 (int matrizAdj[][])
    {
        //int matrizAdj[][] = {{0,1,1,1},{0,0,1,1}, {0,0,0,1}, {0,0,0,0}};
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

    public static ArrayList<ArrayList<Integer>> matrizToList (int matrizAdj[][]){
      
        // cria uma ArrayList que conterá as maximais encontradas        
        ArrayList<ArrayList<Integer>> ligacoes = new ArrayList<ArrayList<Integer>>();
    
        // cria uma lista de para armazenar as ligações de cada vértice
        ArrayList<Integer> vertices = new ArrayList<Integer>();

        // Verifico todas as arestas deste vértice dado
        for(int i=0; i < matrizAdj[0].length; i++){      
            for(int j=0; j < matrizAdj[0].length; j++){      
                if (matrizAdj[i][j] == 1){
                    vertices.add(j);
                }
            }
            if (!vertices.isEmpty()){
                ligacoes.add(vertices);
                vertices= new ArrayList<Integer>();
            }
        }
        
        return ligacoes;

    }
    
    public static ArrayList<Integer> eMaximal(int dado){
        
        // cria uma ArrayList que conterá as maximais encontradas        
        ArrayList<ArrayList<Integer>> ligacoes = new ArrayList<ArrayList<Integer>>();
        
        
        
        
        ArrayList<Integer> vertices = new ArrayList<Integer>();
        vertices.indexOf(dado);
        
        return vertices;
    }
    
    public static ArrayList<Integer> candidato(ArrayList<Integer> candidato, ArrayList<ArrayList<Integer>> ligacoes, int dado){
        int i = 0;
        ArrayList<Integer> conjunto = new ArrayList<Integer>();
        
        for (Integer vertice : candidato) {
            for (ArrayList<Integer> ligacao : ligacoes) {
                if ((candidato.contains(i)) && (ligacao.contains(vertice)) && (!conjunto.contains(i)) && (i != dado)){
                    conjunto.add(i);
                }
                i++;
            }
            i=0;
        }
        if (!conjunto.isEmpty())
            conjunto.add(dado);
        
        return conjunto;
        
    }
    
    public static void ex4 (int matrizAdj[][]){
        
        ArrayList<ArrayList<Integer>> ligacoes = new ArrayList<ArrayList<Integer>>();
        ligacoes = matrizToList(matrizAdj);
      
        int dado = 0;        
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite o vértice que deseja que contenha na maior maximal:");
        System.out.print("Vértice: ");
        dado = leitor.nextInt();       
        
        ArrayList<Integer> verLigacoes = ligacoes.get(dado);
        System.out.print("Maximal: ");
        System.out.print(candidato(verLigacoes,ligacoes,dado).toString());
        
        //System.out.println("Maior maximal:");
        //System.out.print(Arrays.toString(maiorMaximal(matrizAdj, dado)));
    }    
    
    public static  void ex5 (){
        
        int matrizAdj[][] = {{0,1,1,1,1},{0,0,1,1,1}, {0,0,0,0,1}, {0,0,0,0,1}, {0,0,0,0,1}};
        
        // cria uma ArrayList que conterá as maximais encontradas
        ArrayList<int[]> maximais = new ArrayList<int[]>();
        
        System.out.println("Maxmais: ");
        // Verifico todas as arestas deste vértice dado
        for(int j=0; j < matrizAdj[0].length; j++){   
            maximais.add(maiorMaximal(matrizAdj, j));
            
            //Imprime a maior maximal do vértice J
            System.out.println("Vértice: " + j);
            System.out.print(Arrays.toString(maximais.get(j)));
        }
    }        
    
    public static boolean contemTodos (ArrayList<Integer> candidato, ArrayList<ArrayList<Integer>> ligacoes){
        
        
        return true;
    }
}
