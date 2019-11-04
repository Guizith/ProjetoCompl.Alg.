package br.edu.fei.sortingalgorithmvisualization.presenters;

import java.util.Arrays;
import java.util.Random;

import javax.swing.SwingWorker;

import br.edu.fei.sortingalgorithmvisualization.algorithms.Algorithm;
import br.edu.fei.sortingalgorithmvisualization.algorithms.impl.BubbleSort;
import br.edu.fei.sortingalgorithmvisualization.algorithms.impl.HeapSort;
import br.edu.fei.sortingalgorithmvisualization.algorithms.impl.InsertionSort;
import br.edu.fei.sortingalgorithmvisualization.algorithms.impl.QuickSort;
import br.edu.fei.sortingalgorithmvisualization.frames.MainFrame;
import br.edu.fei.sortingalgorithmvisualization.listeners.ViewListener;
import br.edu.fei.sortingalgorithmvisualization.utils.ChartUtils;
import br.edu.fei.sortingalgorithmvisualization.utils.State;
import br.edu.fei.sortingalgorithmvisualization.utils.UIState;

public final class MainPresenter implements ViewListener
{
	private final MainFrame mainFrame;
	
	public MainPresenter(final MainFrame mainFrame)
	{
		this.mainFrame = mainFrame;
		this.mainFrame.addViewListener(this);
		this.mainFrame.setVisible(true);
	}
	
	public void onClick(final UIState uiState)
	{
		switch (uiState.getClickedButton())
		{
		case GENERATE_ARRAY_BUTTON:
			this.generateRandomArrayButtonEvent(uiState);
			break;
			
		case SORT_ARRAY_BUTTON:
			this.sortArrayButtonEvent(uiState);
		default:
			break;
		}
	}
	
	private void generateRandomArrayButtonEvent(final UIState uiState)
	{
		State.GLOBAL_ARRAY = new int[uiState.getArraySizeTextFieldValue()];
		Arrays.fill(State.GLOBAL_ARRAY, 0);
		
		final Random random = new Random();
		
		for(int i = 0; i < State.GLOBAL_ARRAY.length; i++)
		{
			random.setSeed(random.nextLong() * random.nextLong());
			State.GLOBAL_ARRAY[i] = (random.nextInt(999-1) + 1);
		}
		
		ChartUtils.updateDataSet(State.GLOBAL_ARRAY, mainFrame.getChartPanel());
	}
	
	private void sortArrayButtonEvent(final UIState uiState)
	{
		Algorithm algorithm = null;
		switch (uiState.getSelectedOption())
		{
		case BUBBLE_SORT_OPTION:
			algorithm = new BubbleSort();
			this.sortArray(algorithm);
			break;
		case QUICK_SORT_OPTION:
			algorithm = new QuickSort();
			this.sortArray(algorithm);
			break;
		case INSERTION_SORT_OPTION:
			algorithm = new InsertionSort();
			this.sortArray(algorithm);
			break;
		case HEAP_SORT_OPTION:
			algorithm = new HeapSort();
			this.sortArray(algorithm);
			break;
		default:
			break;
		}
	}
	
	private void sortArray(final Algorithm algorithm)
	{
		final SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>()
		{
			@Override
			protected Void doInBackground() throws Exception
			{
				mainFrame.disableComponents();
				algorithm.sort(State.GLOBAL_ARRAY, mainFrame.getChartPanel());
				mainFrame.enableComponents();
				
				return null;
			}
		};
		
		worker.execute();
	}
}