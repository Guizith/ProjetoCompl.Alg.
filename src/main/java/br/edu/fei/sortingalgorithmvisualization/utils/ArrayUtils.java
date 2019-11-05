package br.edu.fei.sortingalgorithmvisualization.utils;

import java.util.Random;

public final class ArrayUtils
{
	private ArrayUtils() {}
	
	public static int[] generateRandomArray(final int size)
	{
		final int[] result = new int[size];
		
		final Random random = new Random();
		
		for(int i = 0; i < size; i++)
		{
			random.setSeed(random.nextLong() * random.nextLong());
			result[i] = (random.nextInt(999-1) + 1);
		}
		
		return result;
	}
}