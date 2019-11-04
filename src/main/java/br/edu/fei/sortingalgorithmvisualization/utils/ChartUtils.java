package br.edu.fei.sortingalgorithmvisualization.utils;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public final class ChartUtils
{
	private ChartUtils() {}
	
	public static JFreeChart getDefaultChart()
	{
		final DefaultCategoryDataset dataSet = State.DATA_SET;
		dataSet.clear();
		
		for(int i = 0; i < 10; i++)
		{
			dataSet.setValue(i + 1, String.valueOf(i + 1), String.valueOf(i + 1));
		}
		
		final JFreeChart chart = org.jfree.chart.ChartFactory.createBarChart(Strings.BLANK, Strings.BLANK, Strings.BLANK, dataSet, PlotOrientation.VERTICAL, false, false, false);
		
		final CategoryPlot categoryPlot = chart.getCategoryPlot();
		
		final ValueAxis valueAxis = categoryPlot.getRangeAxis();
		valueAxis.setVisible(false);
		
		return chart;
	}
	
	public static void updateDataSet(final int[] array, final ChartPanel chartPanel)
	{
		final DefaultCategoryDataset dataSet = State.DATA_SET;
		dataSet.clear();
		
		for(int i = 0; i < array.length; i++)
		{
			dataSet.setValue(array[i], String.valueOf(array[i]), String.valueOf(array[i]));
		}
		
		final JFreeChart chart = chartPanel.getChart();
		chart.getCategoryPlot().setDataset(dataSet);
		chartPanel.updateUI();
	}
}