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

public final class MainFrame extends JFrame
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
		
		this.container = this.getContentPane();
		this.container.setLayout(null);
		
		this.radioButtonGroup = new ButtonGroup();
		
		this.bubbleSortRadioButton = new JRadioButton();
		this.bubbleSortRadioButton.setText(Strings.BUBBLE_SORT_RADIO_BUTTON_TEXT);
		this.bubbleSortRadioButton.setBounds(20, 564, 85, 23);
		this.container.add(this.bubbleSortRadioButton);
		
		this.insertionSortRadioButton = new JRadioButton();
		this.insertionSortRadioButton.setText(Strings.INSERTION_SORT_RADIO_BUTTON_TEXT);
		this.insertionSortRadioButton.setBounds(20, 590, 95, 23);
		this.container.add(this.insertionSortRadioButton);
		
		this.selectionSortRadioButton = new JRadioButton();
		this.selectionSortRadioButton.setText(Strings.SELECTION_SORT_RADIO_BUTTON_TEXT);
		this.selectionSortRadioButton.setBounds(20, 616, 95, 23);
		this.container.add(this.selectionSortRadioButton);
		
		this.mergeSortRadioButton = new JRadioButton();
		this.mergeSortRadioButton.setText(Strings.MERGE_SORT_RADIO_BUTTON_TEXT);
		this.mergeSortRadioButton.setBounds(20, 642, 95, 23);
		this.container.add(this.mergeSortRadioButton);
		
		this.quickSortRadioButton = new JRadioButton();
		this.quickSortRadioButton.setText(Strings.QUICK_SORT_RADIO_BUTTON_TEXT);
		this.quickSortRadioButton.setBounds(130, 564, 85, 23);
		this.container.add(this.quickSortRadioButton);
		
		this.heapSortRadioButton = new JRadioButton();
		this.heapSortRadioButton.setText(Strings.HEAP_SORT_RADIO_BUTTON_TEXT);
		this.heapSortRadioButton.setBounds(130, 590, 85, 23);
		this.container.add(this.heapSortRadioButton);
		
		this.countingSortRadioButton = new JRadioButton();
		this.countingSortRadioButton.setText(Strings.COUNTING_SORT_RADIO_BUTTON_TEXT);
		this.countingSortRadioButton.setBounds(130, 616, 95, 23);
		this.container.add(this.countingSortRadioButton);
		
		this.radixSortRadioButton = new JRadioButton();
		this.radixSortRadioButton.setText(Strings.RADIX_SORT_RADIO_BUTTON_TEXT);
		this.radixSortRadioButton.setBounds(130, 642, 85, 23);
		this.container.add(this.radixSortRadioButton);
		
		this.shellSortRadioButton = new JRadioButton();
		this.shellSortRadioButton.setText(Strings.SHELL_SORT_RADIO_BUTTON_TEXT);
		this.shellSortRadioButton.setBounds(130, 668, 85, 23);
		this.container.add(this.shellSortRadioButton);
		
		this.introSortRadioButton = new JRadioButton();
		this.introSortRadioButton.setText(Strings.INTRO_SORT_RADIO_BUTTON_TEXT);
		this.introSortRadioButton.setBounds(20, 668, 85, 23);
		this.container.add(this.introSortRadioButton);
		
		this.radioButtonGroup.add(this.bubbleSortRadioButton);
		this.radioButtonGroup.add(this.insertionSortRadioButton);
		this.radioButtonGroup.add(this.selectionSortRadioButton);
		this.radioButtonGroup.add(this.mergeSortRadioButton);
		this.radioButtonGroup.add(this.quickSortRadioButton);
		this.radioButtonGroup.add(this.heapSortRadioButton);
		this.radioButtonGroup.add(this.countingSortRadioButton);
		this.radioButtonGroup.add(this.radixSortRadioButton);
		this.radioButtonGroup.add(this.shellSortRadioButton);
		this.radioButtonGroup.add(this.introSortRadioButton);
		this.radioButtonGroup.setSelected(this.bubbleSortRadioButton.getModel(), true);
		
		this.arrayGeneratorSizeLabel = new JLabel();
		this.arrayGeneratorSizeLabel.setText(Strings.ARRAY_GENERATOR_SIZE_LABEL_TEXT);
		this.arrayGeneratorSizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.arrayGeneratorSizeLabel.setBounds(833, 594, 175, 14);
		this.container.add(this.arrayGeneratorSizeLabel);
		
		this.arrayGeneratorSizeTextField = new JFormattedTextField();
		this.arrayGeneratorSizeTextField.setColumns(3);
		this.arrayGeneratorSizeTextField.setHorizontalAlignment(JTextField.CENTER);
		this.arrayGeneratorSizeTextField.setBounds(833, 616, 175, 23);
		this.container.add(this.arrayGeneratorSizeTextField);
		
		this.arrayGeneratorButton = new JButton();
		this.arrayGeneratorButton.setText(Strings.ARRAY_GENERATOR_SIZE_BUTTON_TEXT);
		this.arrayGeneratorButton.setBounds(833, 642, 175, 23);
		this.arrayGeneratorButton.addActionListener((ActionEvent ev) ->
		{
			final UIState uiState = UIState.UIStateBuilder
					.newBuilder()
					.setClickedButton(Components.GENERATE_ARRAY_BUTTON)
					.setArraySizeTextFieldValue(arrayGeneratorSizeTextField.getText())
					.build();
			
			this.notifyViewListeners(uiState);
		});
		this.container.add(this.arrayGeneratorButton);
		
		this.arraySortButton = new JButton();
		this.arraySortButton.setText(Strings.ARRAY_SORT_BUTTON_TEXT);
		this.arraySortButton.setBounds(833, 668, 175, 23);
		this.arraySortButton.addActionListener((ActionEvent ev) ->
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
					case Strings.SELECTION_SORT_RADIO_BUTTON_TEXT:
						uiStateBuilder.setSelectedOption(Components.SELECTION_SORT_OPTION);
						break;
					case Strings.COUNTING_SORT_RADIO_BUTTON_TEXT:
						uiStateBuilder.setSelectedOption(Components.COUNTING_SORT_OPTION);
						break;
					case Strings.MERGE_SORT_RADIO_BUTTON_TEXT:
						uiStateBuilder.setSelectedOption(Components.MERGE_SORT_OPTION);
					case Strings.RADIX_SORT_RADIO_BUTTON_TEXT:
						uiStateBuilder.setSelectedOption(Components.RADIX_SORT_OPTION);
						break;
					case Strings.INTRO_SORT_RADIO_BUTTON_TEXT:
						uiStateBuilder.setSelectedOption(Components.INTRO_SORT_OPTION);
						break;
					case Strings.SHELL_SORT_RADIO_BUTTON_TEXT:
						uiStateBuilder.setSelectedOption(Components.SHELL_SORT_OPTION);
					default:
						break;
					}
				}
			}
			
			final UIState uiState = uiStateBuilder.build();
			this.notifyViewListeners(uiState);
		});
		this.arraySortButton.setEnabled(false);
		this.container.add(this.arraySortButton);
		
		this.chartPanel = new ChartPanel(null);
		this.chartPanel.setChart(ChartUtils.getDefaultChart());
		this.chartPanel.setBounds(10, 11, 998, 472);
		this.container.add(this.chartPanel);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1024, 768);
	}
	
	public ChartPanel getChartPanel()
	{
		return this.chartPanel;
	}
	
	public void disableComponents()
	{
		this.bubbleSortRadioButton.setEnabled(false);
		this.insertionSortRadioButton.setEnabled(false);
		this.selectionSortRadioButton.setEnabled(false);
		this.mergeSortRadioButton.setEnabled(false);
		this.quickSortRadioButton.setEnabled(false);
		this.heapSortRadioButton.setEnabled(false);
		this.countingSortRadioButton.setEnabled(false);
		this.radixSortRadioButton.setEnabled(false);
		this.shellSortRadioButton.setEnabled(false);
		this.introSortRadioButton.setEnabled(false);
		this.arrayGeneratorSizeTextField.setEnabled(false);
		this.arrayGeneratorButton.setEnabled(false);
	}
	
	public void enableComponents()
	{
		this.bubbleSortRadioButton.setEnabled(true);
		this.insertionSortRadioButton.setEnabled(true);
		this.selectionSortRadioButton.setEnabled(true);
		this.mergeSortRadioButton.setEnabled(true);
		this.quickSortRadioButton.setEnabled(true);
		this.heapSortRadioButton.setEnabled(true);
		this.countingSortRadioButton.setEnabled(true);
		this.radixSortRadioButton.setEnabled(true);
		this.shellSortRadioButton.setEnabled(true);
		this.introSortRadioButton.setEnabled(true);
		this.arrayGeneratorSizeTextField.setEnabled(true);
		this.arrayGeneratorButton.setEnabled(true);
	}
	
	public void enableArraySortButton()
	{
		this.arraySortButton.setEnabled(true);
	}
	
	public void disableArraySortButton()
	{
		this.arraySortButton.setEnabled(false);
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