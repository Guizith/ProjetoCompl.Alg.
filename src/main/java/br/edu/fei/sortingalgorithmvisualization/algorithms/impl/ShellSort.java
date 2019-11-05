package br.edu.fei.sortingalgorithmvisualization.algorithms.impl;

import org.jfree.chart.ChartPanel;

import br.edu.fei.sortingalgorithmvisualization.algorithms.Algorithm;
import br.edu.fei.sortingalgorithmvisualization.utils.ChartUtils;

public final class ShellSort implements Algorithm
{
	@Override
	public void sort(final int[] array, final ChartPanel chartPanel) throws Exception
	{
		final int n = array.length;
		  
        for (int g = n/2; g > 0; g /= 2) 
        { 
            for (int i = g; i < n; i += 1) 
            { 
                int temp = array[i]; 
  
                int j; 
                for (j = i; j >= g && array[j - g] > temp; j -= g)
                {
                	array[j] = array[j - g];
                }
                
                array[j] = temp;
                
                ChartUtils.updateDataSet(array, chartPanel);
                Thread.sleep(200);
            }
        }
	}
}