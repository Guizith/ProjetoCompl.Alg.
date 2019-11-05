package br.edu.fei.sortingalgorithmvisualization.algorithms.impl;

import org.jfree.chart.ChartPanel;

import br.edu.fei.sortingalgorithmvisualization.algorithms.Algorithm;
import br.edu.fei.sortingalgorithmvisualization.utils.ChartUtils;

public final class MergeSort implements Algorithm
{
	@Override
	public void sort(final int[] array, final ChartPanel chartPanel) throws Exception
	{
		this.mergeSort(array, 0, array.length - 1, chartPanel);
	}
	
	private void merge(final int array[], final int l, final int m, final int r) 
    { 
        final int n1 = m - l + 1; 
        final int n2 = r - m; 
  
        final int L[] = new int [n1]; 
        final int R[] = new int [n2]; 
  
        for (int i=0; i<n1; ++i)
        {
        	L[i] = array[l + i];
        } 
        
        for (int j=0; j<n2; ++j)
        {
        	R[j] = array[m + 1+ j];
        }
        
        int i = 0, j = 0; 
  
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                array[k] = L[i]; 
                i++; 
            } 
            else
            { 
                array[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) 
        { 
            array[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) 
        { 
            array[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    private void mergeSort(final int array[], final int l, final int r, final ChartPanel chartPanel) throws Exception 
    { 
        if (l < r) 
        { 
            final int m = (l+r)/2; 
  
            mergeSort(array, l, m, null); 
            mergeSort(array , m+1, r, null); 
  
            merge(array, l, m, r);
            
            ChartUtils.updateDataSet(array, chartPanel);
            Thread.sleep(200);
        } 
    }	
}