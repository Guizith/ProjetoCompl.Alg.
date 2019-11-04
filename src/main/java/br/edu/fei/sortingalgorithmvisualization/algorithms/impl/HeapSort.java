package br.edu.fei.sortingalgorithmvisualization.algorithms.impl;

import org.jfree.chart.ChartPanel;

import br.edu.fei.sortingalgorithmvisualization.algorithms.Algorithm;
import br.edu.fei.sortingalgorithmvisualization.utils.ChartUtils;

public final class HeapSort implements Algorithm
{
	@Override
	public void sort(final int[] array, final ChartPanel chartPanel) throws Exception
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

    private void heapify(final int array[], final int tamHeap, int i, final ChartPanel chartPanel) throws Exception
    {
    	ChartUtils.updateDataSet(array, chartPanel);
    	Thread.sleep(200);
    	int largest = i;
        final int leftChildIdx = 2 * i + 1;
        final int rightChildIdx = 2 * i + 2;
        
        if (leftChildIdx  < tamHeap && array[leftChildIdx ] > array[largest])
        {
        	largest = leftChildIdx ;
        }
        
        if (rightChildIdx  < tamHeap && array[rightChildIdx ] > array[largest])
        {
        	largest = rightChildIdx ;
        }

        if (largest != i)
        {
            final int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, tamHeap, largest, chartPanel);
        }
    }
}