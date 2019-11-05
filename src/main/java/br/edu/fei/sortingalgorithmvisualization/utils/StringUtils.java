package br.edu.fei.sortingalgorithmvisualization.utils;

import java.util.regex.Pattern;

public final class StringUtils 
{	
	private StringUtils() {}
	
	public static boolean isLong(final String value)
	{
		boolean result = false;
		if(!isNull(value))
		{
			final String decimalPattern = "([0-9]*)";   
			result = Pattern.matches(decimalPattern, value);						
		}
		return result;
	}
	
	public static boolean isNull(final String value)
	{
		if( value == null )
			return true;
		if( value.trim().length() < 1 )
			return true;
		return false;
	}

}