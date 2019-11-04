package br.edu.fei.sortingalgorithmvisualization;

import java.awt.EventQueue;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import br.edu.fei.sortingalgorithmvisualization.frames.MainFrame;
import br.edu.fei.sortingalgorithmvisualization.presenters.MainPresenter;
import br.edu.fei.sortingalgorithmvisualization.utils.Strings;

@SuppressWarnings(Strings.SUPPRESS_WARNINGS_UNUSED)
public final class Main
{
	public static final void main(final String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					final MainPresenter mainPresenter = new MainPresenter(new MainFrame());
				}
				catch (final Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}