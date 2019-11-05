package br.edu.fei.sortingalgorithmvisualization.algorithms.impl;

import java.util.Arrays;

import org.jfree.chart.ChartPanel;

import br.edu.fei.sortingalgorithmvisualization.algorithms.Algorithm;
import br.edu.fei.sortingalgorithmvisualization.utils.ChartUtils;

public class CountingSort implements Algorithm
{
	@Override
	public void sort(final int[] array , final ChartPanel chartPanel) throws Exception
	{
		final int max = Arrays.stream(array).max().getAsInt(); 
        final int min = Arrays.stream(array).min().getAsInt(); 
        final int range = max - min + 1; 
        final int count[] = new int[range]; 
        final int output[] = new int[array.length]; 
        for (int i = 0; i < array.length; i++)  
        { 
            count[array[i] - min]++; 
        } 
  
        for (int i = 1; i < count.length; i++)  
        { 
            count[i] += count[i - 1]; 
        } 
  
        for (int i = array.length - 1; i >= 0; i--)  
        { 
            output[count[array[i] - min] - 1] = array[i]; 
            count[array[i] - min]--; 
        } 
  
        for (int i = 0; i < array.length; i++) 
        { 
        	array[i] = output[i];
        	ChartUtils.updateDataSet(array, chartPanel);
        	Thread.sleep(200);
        }
	}
}