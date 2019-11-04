package br.edu.fei.sortingalgorithmvisualization.algorithms.impl;

import org.jfree.chart.ChartPanel;

import br.edu.fei.sortingalgorithmvisualization.algorithms.Algorithm;
import br.edu.fei.sortingalgorithmvisualization.utils.ChartUtils;

public final class QuickSort implements Algorithm
{
	@Override
	public void sort(final int[] array, final ChartPanel chartPanel) throws Exception
	{
		this.quickSort(array, 0, array.length - 1, chartPanel);
	}
	
	private void quickSort(int[] array, int comeco, int fim, final ChartPanel chartPanel) throws Exception
	{
        if (comeco < fim)
        {
           final int posicaoPivo = split(array, comeco, fim);
           ChartUtils.updateDataSet(array, chartPanel);
           Thread.sleep(200);
           quickSort(array, comeco, posicaoPivo - 1, chartPanel);
           quickSort(array, posicaoPivo + 1, fim, chartPanel);
        }
	}

	private int split(final int[] array, final int comeco, int fim)
	{
        int pivo = array[comeco];
        int i = comeco + 1;
        int f = fim;
        while (i <= f)
        {
            if (array[i] <= pivo)
            {
        	    i++;
            }
            else if (pivo < array[f])
            {
         	   f--;
            }
            else
            {
               int temp = array[i];
               array[i] = array[f];
               array[f] = temp;
               i++;
               f--;
            }
         }
         array[comeco] = array[f];
         array[f] = pivo;
         return f;
	}
}