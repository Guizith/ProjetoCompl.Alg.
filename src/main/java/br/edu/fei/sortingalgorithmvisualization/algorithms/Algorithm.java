package br.edu.fei.sortingalgorithmvisualization.algorithms;

import org.jfree.chart.ChartPanel;

public interface Algorithm
{
	void sort(int[] array, ChartPanel chartPanel) throws Exception;
}