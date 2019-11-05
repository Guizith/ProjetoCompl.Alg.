package br.edu.fei.sortingalgorithmvisualization.utils;

public final class State
{
	private static int[] globalArray = new int[10];
	
	public static int[] getGlobalArray()
	{
		return State.globalArray;
	}
	
	public static void setGlobalArray(final int[] globalArray)
	{
		State.globalArray = globalArray;
	}
}