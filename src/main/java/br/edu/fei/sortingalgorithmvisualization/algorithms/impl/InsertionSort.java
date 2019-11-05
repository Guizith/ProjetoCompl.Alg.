package br.edu.fei.sortingalgorithmvisualization.algorithms.impl;

import org.jfree.chart.ChartPanel;

import br.edu.fei.sortingalgorithmvisualization.algorithms.Algorithm;
import br.edu.fei.sortingalgorithmvisualization.utils.ChartUtils;

public final class InsertionSort implements Algorithm
{
	@Override
	public void sort(final int[] array, final ChartPanel chartPanel) throws Exception
	{
		int j;
	    int k;
	    int i;
	    
	    for (j = 1; j < array.length; j++)
	    {
	      k = array[j];
	      for (i = j - 1; (i >= 0) && (array[i] > k); i--)
	      {
	    	  array[i + 1] = array[i];
	      }
	      array[i + 1] = k;
	      
	      ChartUtils.updateDataSet(array, chartPanel);
	      Thread.sleep(150);
	    }
	}
}