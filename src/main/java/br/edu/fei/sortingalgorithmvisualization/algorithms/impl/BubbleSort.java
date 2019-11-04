package br.edu.fei.sortingalgorithmvisualization.algorithms.impl;

import org.jfree.chart.ChartPanel;

import br.edu.fei.sortingalgorithmvisualization.algorithms.Algorithm;
import br.edu.fei.sortingalgorithmvisualization.utils.ChartUtils;

public final class BubbleSort implements Algorithm
{
	@Override
	public void sort(final int[] array, final ChartPanel chartPanel) throws Exception
	{
		int aux = 0;
		
	    for(int i = 0; i < array.length;i++)
	    {
	        for(int j = 0; j < array.length-1; j++)
	        {
	            if(array[j] > array[j + 1])
	            {
	                aux = array[j];
	                array[j] = array[j+1];
	                array[j+1] = aux;
	            }
	        }
	        
            ChartUtils.updateDataSet(array, chartPanel);
            Thread.sleep(200);
	    }
	}
}