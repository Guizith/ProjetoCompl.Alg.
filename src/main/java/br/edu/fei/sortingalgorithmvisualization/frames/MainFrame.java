package br.edu.fei.sortingalgorithmvisualization.frames;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartPanel;

import br.edu.fei.sortingalgorithmvisualization.listeners.ViewListener;
import br.edu.fei.sortingalgorithmvisualization.utils.ChartUtils;
import br.edu.fei.sortingalgorithmvisualization.utils.Components;
import br.edu.fei.sortingalgorithmvisualization.utils.Strings;
import br.edu.fei.sortingalgorithmvisualization.utils.UIState;
import br.edu.fei.sortingalgorithmvisualization.utils.UIState.UIStateBuilder;

public class MainFrame extends JFrame
{	
	private static final long serialVersionUID = -993075444907151235L;
	
	private final List<ViewListener> viewListeners = new ArrayList<ViewListener>();
	
	private final Container container;
	
	private final ButtonGroup radioButtonGroup;
	private final JRadioButton bubbleSortRadioButton;
	private final JRadioButton insertionSortRadioButton;
	private final JRadioButton selectionSortRadioButton;
	private final JRadioButton mergeSortRadioButton;
	private final JRadioButton quickSortRadioButton;
	private final JRadioButton heapSortRadioButton;
	private final JRadioButton countingSortRadioButton;
	private final JRadioButton radixSortRadioButton;
	private final JRadioButton shellSortRadioButton;
	private final JRadioButton introSortRadioButton;
	
	private final JLabel arrayGeneratorSizeLabel;
	private final JFormattedTextField arrayGeneratorSizeTextField;
	private final JButton arrayGeneratorButton;
	private final JButton arraySortButton;
	private final ChartPanel chartPanel;
	
	public MainFrame()
	{
		this.setTitle(Strings.APPLICATION_NAME);
		this.setResizable(false);
		
		container = this.getContentPane();
		container.setLayout(null);
		
		radioButtonGroup = new ButtonGroup();
		
		bubbleSortRadioButton = new JRadioButton();
		bubbleSortRadioButton.setText(Strings.BUBBLE_SORT_RADIO_BUTTON_TEXT);
		bubbleSortRadioButton.setBounds(20, 564, 85, 23);
		container.add(bubbleSortRadioButton);
		
		insertionSortRadioButton = new JRadioButton();
		insertionSortRadioButton.setText(Strings.INSERTION_SORT_RADIO_BUTTON_TEXT);
		insertionSortRadioButton.setBounds(20, 590, 95, 23);
		container.add(insertionSortRadioButton);
		
		selectionSortRadioButton = new JRadioButton();
		selectionSortRadioButton.setText(Strings.SELECTION_SORT_RADIO_BUTTON_TEXT);
		selectionSortRadioButton.setBounds(20, 616, 95, 23);
		container.add(selectionSortRadioButton);
		
		mergeSortRadioButton = new JRadioButton();
		mergeSortRadioButton.setText(Strings.MERGE_SORT_RADIO_BUTTON_TEXT);
		mergeSortRadioButton.setBounds(20, 642, 95, 23);
		container.add(mergeSortRadioButton);
		
		quickSortRadioButton = new JRadioButton();
		quickSortRadioButton.setText(Strings.QUICK_SORT_RADIO_BUTTON_TEXT);
		quickSortRadioButton.setBounds(130, 564, 85, 23);
		container.add(quickSortRadioButton);
		
		heapSortRadioButton = new JRadioButton();
		heapSortRadioButton.setText(Strings.HEAP_SORT_RADIO_BUTTON_TEXT);
		heapSortRadioButton.setBounds(130, 590, 85, 23);
		container.add(heapSortRadioButton);
		
		countingSortRadioButton = new JRadioButton();
		countingSortRadioButton.setText(Strings.COUNTING_SORT_RADIO_BUTTON_TEXT);
		countingSortRadioButton.setBounds(130, 616, 95, 23);
		container.add(countingSortRadioButton);
		
		radixSortRadioButton = new JRadioButton();
		radixSortRadioButton.setText(Strings.RADIX_SORT_RADIO_BUTTON_TEXT);
		radixSortRadioButton.setBounds(130, 642, 85, 23);
		container.add(radixSortRadioButton);
		
		shellSortRadioButton = new JRadioButton();
		shellSortRadioButton.setText(Strings.SHELL_SORT_RADIO_BUTTON_TEXT);
		shellSortRadioButton.setBounds(130, 668, 85, 23);
		container.add(shellSortRadioButton);
		
		introSortRadioButton = new JRadioButton();
		introSortRadioButton.setText(Strings.INTRO_SORT_RADIO_BUTTON_TEXT);
		introSortRadioButton.setBounds(20, 668, 85, 23);
		container.add(introSortRadioButton);
		
		radioButtonGroup.add(bubbleSortRadioButton);
		radioButtonGroup.add(insertionSortRadioButton);
		radioButtonGroup.add(selectionSortRadioButton);
		radioButtonGroup.add(mergeSortRadioButton);
		radioButtonGroup.add(quickSortRadioButton);
		radioButtonGroup.add(heapSortRadioButton);
		radioButtonGroup.add(countingSortRadioButton);
		radioButtonGroup.add(radixSortRadioButton);
		radioButtonGroup.add(shellSortRadioButton);
		radioButtonGroup.add(introSortRadioButton);
		radioButtonGroup.setSelected(bubbleSortRadioButton.getModel(), true);
		
		arrayGeneratorSizeLabel = new JLabel();
		arrayGeneratorSizeLabel.setText(Strings.ARRAY_GENERATOR_SIZE_LABEL_TEXT);
		arrayGeneratorSizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		arrayGeneratorSizeLabel.setBounds(833, 594, 175, 14);
		container.add(arrayGeneratorSizeLabel);
		
		arrayGeneratorSizeTextField = new JFormattedTextField();
		arrayGeneratorSizeTextField.setColumns(3);
		arrayGeneratorSizeTextField.setHorizontalAlignment(JTextField.CENTER);
		arrayGeneratorSizeTextField.setBounds(833, 616, 175, 23);
		container.add(arrayGeneratorSizeTextField);
		
		arrayGeneratorButton = new JButton();
		arrayGeneratorButton.setText(Strings.ARRAY_GENERATOR_SIZE_BUTTON_TEXT);
		arrayGeneratorButton.setBounds(833, 642, 175, 23);
		arrayGeneratorButton.addActionListener((ActionEvent ev) ->
		{
			final UIState uiState = UIState.UIStateBuilder
					.newBuilder()
					.setClickedButton(Components.GENERATE_ARRAY_BUTTON)
					.setArraySizeTextFieldValue(Integer.valueOf(arrayGeneratorSizeTextField.getText()))
					.build();
			
			notifyViewListeners(uiState);
		});
		container.add(arrayGeneratorButton);
		
		arraySortButton = new JButton();
		arraySortButton.setText(Strings.ARRAY_SORT_BUTTON_TEXT);
		arraySortButton.setBounds(833, 668, 175, 23);
		arraySortButton.addActionListener((ActionEvent ev) ->
		{
			final UIStateBuilder uiStateBuilder = UIState.UIStateBuilder
					.newBuilder()
					.setClickedButton(Components.SORT_ARRAY_BUTTON);
			for(final AbstractButton button : Collections.list(this.radioButtonGroup.getElements()))
			{
				if(button.isSelected())
				{
					switch (button.getText())
					{
					case Strings.BUBBLE_SORT_RADIO_BUTTON_TEXT:
						uiStateBuilder.setSelectedOption(Components.BUBBLE_SORT_OPTION);
						break;
					case Strings.QUICK_SORT_RADIO_BUTTON_TEXT:
						uiStateBuilder.setSelectedOption(Components.QUICK_SORT_OPTION);
						break;
					case Strings.INSERTION_SORT_RADIO_BUTTON_TEXT:
						uiStateBuilder.setSelectedOption(Components.INSERTION_SORT_OPTION);
						break;
					case Strings.HEAP_SORT_RADIO_BUTTON_TEXT:
						uiStateBuilder.setSelectedOption(Components.HEAP_SORT_OPTION);
						break;
					default:
						break;
					}
				}
			}
			
			final UIState uiState = uiStateBuilder.build();
			notifyViewListeners(uiState);
		});
		container.add(arraySortButton);
		
		chartPanel = new ChartPanel(null);
		chartPanel.setChart(ChartUtils.getDefaultChart());
		chartPanel.setBounds(10, 11, 998, 472);
		container.add(chartPanel);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1024, 768);
	}
	
	public ChartPanel getChartPanel()
	{
		return this.chartPanel;
	}
	
	public void disableComponents()
	{
		bubbleSortRadioButton.setEnabled(false);
		insertionSortRadioButton.setEnabled(false);
		selectionSortRadioButton.setEnabled(false);
		mergeSortRadioButton.setEnabled(false);
		quickSortRadioButton.setEnabled(false);
		heapSortRadioButton.setEnabled(false);
		countingSortRadioButton.setEnabled(false);
		radixSortRadioButton.setEnabled(false);
		shellSortRadioButton.setEnabled(false);
		introSortRadioButton.setEnabled(false);
		arrayGeneratorSizeTextField.setEnabled(false);
		arrayGeneratorButton.setEnabled(false);
		arraySortButton.setEnabled(false);
	}
	
	public void enableComponents()
	{
		bubbleSortRadioButton.setEnabled(true);
		insertionSortRadioButton.setEnabled(true);
		selectionSortRadioButton.setEnabled(true);
		mergeSortRadioButton.setEnabled(true);
		quickSortRadioButton.setEnabled(true);
		heapSortRadioButton.setEnabled(true);
		countingSortRadioButton.setEnabled(true);
		radixSortRadioButton.setEnabled(true);
		shellSortRadioButton.setEnabled(true);
		introSortRadioButton.setEnabled(true);
		arrayGeneratorSizeTextField.setEnabled(true);
		arrayGeneratorButton.setEnabled(true);
		arraySortButton.setEnabled(true);
	}
	
	public void addViewListener(final ViewListener viewListener)
	{
		this.viewListeners.add(viewListener);
	}
	
	private void notifyViewListeners(final UIState uiState)
	{
		for(final ViewListener viewListener : this.viewListeners)
		{
			viewListener.onClick(uiState);
		}
	}
}