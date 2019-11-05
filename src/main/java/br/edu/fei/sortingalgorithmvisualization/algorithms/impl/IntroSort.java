package br.edu.fei.sortingalgorithmvisualization.algorithms.impl;

import org.jfree.chart.ChartPanel;

import br.edu.fei.sortingalgorithmvisualization.algorithms.Algorithm;
import br.edu.fei.sortingalgorithmvisualization.utils.ChartUtils;

public class IntroSort implements Algorithm
{
	int i = 0;
	
	public void sort(int[] array, ChartPanel chartPanel) throws Exception
	{		
		int prof = ((int) Math.log(array.length))*2; 
		sort(array, prof, 0, array.length-1, chartPanel);
	}
	
	private void sort(int[] array, int prof, int comeco, int fim, final ChartPanel chartPanel) throws Exception
	{
		int length = array.length;
		
		if(length <= 1){
			return;
		}else if(prof == 0){
			this.heapSort(array, comeco, fim, chartPanel);
		}else{
			if(comeco >= fim)
				return;
			int pivo = array[(comeco + fim)/2];
			int index =  partition(array, comeco, fim, pivo);
			
	        ChartUtils.updateDataSet(array, chartPanel);
	        Thread.sleep(50);
			sort(array, prof-1, comeco, index-1, chartPanel);
			sort(array, prof-1, index, fim, chartPanel);
		}
	}
	
	private void heapSort(int[] array, int comeco, int fim, ChartPanel chartPanel) throws Exception
	{
		final int size = array.length;

        for(int i = size / 2 - 1; i >= 0; i--)
        {
        	heapify(array, size, i, chartPanel);
        }

        for(int i = size - 1; i >= 0; i--)
        {
            final int x = array[0];
            array[0] = array[i];
            array[i] = x;
            
            heapify(array, i, 0, chartPanel);
        }
	}
	
	private void heapify(final int array[], final int heapSize, int i, final ChartPanel chartPanel) throws Exception
    {
    	int largest = i;
        final int leftChildIdx = 2 * i + 1;
        final int rightChildIdx = 2 * i + 2;
        
        if (leftChildIdx  < heapSize && array[leftChildIdx ] > array[largest])
        {
        	largest = leftChildIdx ;
        }
        
        if (rightChildIdx  < heapSize && array[rightChildIdx ] > array[largest])
        {
        	largest = rightChildIdx ;
        }

        if (largest != i)
        {
            final int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, heapSize, largest, chartPanel);
        }
    }

	private int partition(int[] array, int comeco, int fim, int pivot)
	{
		while(comeco <= fim){
			while(array[comeco] < pivot){
				comeco++;
			}
			while(array[fim] > pivot){
				fim--;
			}
			if(comeco <= fim){
				int temp = array[comeco];
				array[comeco] = array[fim];
				array[fim] = temp;
				comeco++;
				fim--;
			}
		}
		return comeco;
	}
}