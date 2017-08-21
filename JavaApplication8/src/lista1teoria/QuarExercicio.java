/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista1teoria;

import java.util.ArrayList;

/**
 *
 * @author Akiro
 */
public class QuarExercicio 
{
    public void maiorMaximal(int v, int matrizAdj[][])
    {
        ArrayList<Integer> conjV = new ArrayList<Integer>();
        conjV.add(v);
        for (int i = 0; i < matrizAdj.length; i++)
        {
            if (eVizinho(i, conjV,matrizAdj) == true)
            {
                conjV.add(i);
            }
        }
    }

    public boolean eVizinho (int v, ArrayList<Integer> conjV, int matrizAdj[][])
    {
        boolean viz = true;
        int v1;
        for (int i = 0; i < conjV.size(); i++)
        {
            v1 = conjV.get(i);
            if (v != v1)
            {
                if (matrizAdj[v][v1] != 1 || matrizAdj[v1][v] != 1)
                {
                    viz = false;
                    break;
                }
            }
        }
        return viz;
    }

}
