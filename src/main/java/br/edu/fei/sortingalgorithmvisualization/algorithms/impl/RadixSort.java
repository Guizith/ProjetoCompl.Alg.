package br.edu.fei.sortingalgorithmvisualization.algorithms.impl;

import java.util.Arrays;

import org.jfree.chart.ChartPanel;

import br.edu.fei.sortingalgorithmvisualization.algorithms.Algorithm;
import br.edu.fei.sortingalgorithmvisualization.utils.ChartUtils;

public final class RadixSort implements Algorithm
{
	@Override
	public void sort(final int[] array, final ChartPanel chartPanel) throws Exception
	{
		this.radixsort(array, array.length, chartPanel);
	}
	
	private int getMax(final int[] array, final int n) 
    { 
        int max = array[0];
        for (int i = 1; i < n; i++)
        {
        	if (array[i] > max)
            {
            	max = array[i];
            }
        }
        
        return max; 
    } 
  
    private void countSort(final int[] array, final int n, final int exp, final ChartPanel chartPanel) throws Exception 
    {
        final int output[] = new int[n];
        int i; 
        final int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        for (i = 0; i < n; i++)
        {
        	count[(array[i]/exp)%10]++;
        } 
  
        for (i = 1; i < 10; i++)
        {
        	count[i] += count[i - 1];
        }
        
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[(array[i]/exp)%10] - 1] = array[i]; 
            count[(array[i]/exp)%10]--; 
        }
  
        for (i = 0; i < n; i++) 
        {
        	array[i] = output[i]; 
        }
        
        ChartUtils.updateDataSet(array, chartPanel);
        Thread.sleep(200);
    }
    
    private void radixsort(final int array[], final int n, final ChartPanel chartPanel) throws Exception 
    {
        final int m = this.getMax(array, n); 
  
        for (int exp = 1; m/exp > 0; exp *= 10) 
        {
        	this.countSort(array, n, exp, chartPanel);
        }
    }
}