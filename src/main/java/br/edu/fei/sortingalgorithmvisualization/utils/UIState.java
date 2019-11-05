package br.edu.fei.sortingalgorithmvisualization.utils;

public final class UIState
{
	private final Components clickedButton;
	private final Components selectedOption;
	private final String arraySizeTextFieldValue;
	
	public UIState(final UIStateBuilder builder)
	{
		this.clickedButton = builder.clickedButton;
		this.selectedOption = builder.selectedOption;
		this.arraySizeTextFieldValue = builder.arraySizeTextFieldValue;
	}
	
	public Components getClickedButton()
	{
		return this.clickedButton;
	}
	
	public final Components getSelectedOption()
	{
		return this.selectedOption;
	}
	
	public final String getArraySizeTextFieldValue()
	{
		return arraySizeTextFieldValue;
	}
	
	public static final class UIStateBuilder
	{
		private Components clickedButton;
		private Components selectedOption;
		private String arraySizeTextFieldValue;
		
		private UIStateBuilder() {}
		
		public static UIStateBuilder newBuilder()
		{
			return new UIStateBuilder();
		}
		
		public UIStateBuilder setClickedButton(final Components clickedButton)
		{
			this.clickedButton = clickedButton;
			return this;
		}
		
		public UIStateBuilder setSelectedOption(final Components selectedOption)
		{
			this.selectedOption = selectedOption;
			return this;
		}
		
		public UIStateBuilder setArraySizeTextFieldValue(final String arraySizeTextFieldValue)
		{
			this.arraySizeTextFieldValue = arraySizeTextFieldValue;
			return this;
		}
		
		public UIState build()
		{
			return new UIState(this);
		}
	}
}