package guiPackage;

import java.awt.CardLayout;

import javax.swing.JPanel;


public class Switcher
{

	public static JPanel cardHolder;
	public static CardLayout cards;
	
	public static void changePanel(String card) 
	{
		cards.show(cardHolder, card);
	}

}
