package br.edu.fei.sortingalgorithmvisualization.presenters;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import br.edu.fei.sortingalgorithmvisualization.algorithms.Algorithm;
import br.edu.fei.sortingalgorithmvisualization.algorithms.impl.BubbleSort;
import br.edu.fei.sortingalgorithmvisualization.algorithms.impl.CountingSort;
import br.edu.fei.sortingalgorithmvisualization.algorithms.impl.HeapSort;
import br.edu.fei.sortingalgorithmvisualization.algorithms.impl.InsertionSort;
import br.edu.fei.sortingalgorithmvisualization.algorithms.impl.IntroSort;
import br.edu.fei.sortingalgorithmvisualization.algorithms.impl.MergeSort;
import br.edu.fei.sortingalgorithmvisualization.algorithms.impl.QuickSort;
import br.edu.fei.sortingalgorithmvisualization.algorithms.impl.RadixSort;
import br.edu.fei.sortingalgorithmvisualization.algorithms.impl.SelectionSort;
import br.edu.fei.sortingalgorithmvisualization.algorithms.impl.ShellSort;
import br.edu.fei.sortingalgorithmvisualization.frames.MainFrame;
import br.edu.fei.sortingalgorithmvisualization.listeners.ViewListener;
import br.edu.fei.sortingalgorithmvisualization.utils.ArrayUtils;
import br.edu.fei.sortingalgorithmvisualization.utils.ChartUtils;
import br.edu.fei.sortingalgorithmvisualization.utils.State;
import br.edu.fei.sortingalgorithmvisualization.utils.StringUtils;
import br.edu.fei.sortingalgorithmvisualization.utils.Strings;
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
		final String value = uiState.getArraySizeTextFieldValue();
		if(!StringUtils.isLong(value))
		{
			JOptionPane.showMessageDialog(null, Strings.VALOR_INVALIDO_MESSAGE, Strings.ERRO_VALIDACAO_MESSAGE_BOX_TITLE, JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if(Integer.valueOf(value) > 30)
		{
			JOptionPane.showMessageDialog(null, Strings.VALOR_MAXIMO_MESSAGE, Strings.ERRO_VALIDACAO_MESSAGE_BOX_TITLE, JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		State.setGlobalArray(ArrayUtils.generateRandomArray(Integer.valueOf(value)));
		
		ChartUtils.updateDataSet(State.getGlobalArray(), mainFrame.getChartPanel());
		this.mainFrame.enableArraySortButton();
	}
	
	private void sortArrayButtonEvent(final UIState uiState)
	{
		Algorithm algorithm = null;
		switch (uiState.getSelectedOption())
		{
		case BUBBLE_SORT_OPTION:
			algorithm = new BubbleSort();
			break;
		case QUICK_SORT_OPTION:
			algorithm = new QuickSort();
			break;
		case INSERTION_SORT_OPTION:
			algorithm = new InsertionSort();
			break;
		case HEAP_SORT_OPTION:
			algorithm = new HeapSort();
			break;
		case SELECTION_SORT_OPTION:
			algorithm = new SelectionSort();
			break;
		case COUNTING_SORT_OPTION:
			algorithm = new CountingSort();
			break;
		case MERGE_SORT_OPTION:
			algorithm = new MergeSort();
			break;
		case RADIX_SORT_OPTION:
			algorithm = new RadixSort();
			break;
		case INTRO_SORT_OPTION:
			algorithm = new IntroSort();
			break;
		case SHELL_SORT_OPTION:
			algorithm = new ShellSort();
			break;
		default:
			break;
		}
		
		this.sortArray(algorithm);
	}
	
	private void sortArray(final Algorithm algorithm)
	{
		final SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>()
		{
			@Override
			protected Void doInBackground() throws Exception
			{
				mainFrame.disableComponents();
				mainFrame.disableArraySortButton();
				algorithm.sort(State.getGlobalArray(), mainFrame.getChartPanel());
				mainFrame.enableComponents();
				
				return null;
			}
		};
		worker.execute();
	}
}