package br.edu.fei.sortingalgorithmvisualization.algorithms.impl;

import org.jfree.chart.ChartPanel;

import br.edu.fei.sortingalgorithmvisualization.algorithms.Algorithm;
import br.edu.fei.sortingalgorithmvisualization.utils.ChartUtils;

public final class SelectionSort implements Algorithm
{
	@Override
	public void sort(int[] array, ChartPanel chartPanel) throws Exception
	{
		for (int valorFixo = 0; valorFixo < array.length - 1; valorFixo++)
		{
			int min = valorFixo;
			
			for (int i = min + 1; i < array.length; i++)
			{
				if (array[i] < array[min])
				{
				min = i;
				}
			}
			if (min != valorFixo)
			{
				int t = array[valorFixo];
				array[valorFixo] = array[min];
				array[min] = t;
			}
			
			ChartUtils.updateDataSet(array, chartPanel);
			Thread.sleep(200);
		}
	}
}