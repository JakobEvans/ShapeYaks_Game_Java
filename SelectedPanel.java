// File: SelectedPanel.java
// Author: Dr. Watts
// Contents: This file contains the implementation of a small
// GUI application that uses the Selected class hierarchy.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SelectedPanel extends JPanel
{
	Data data;

	public SelectedPanel (Data D)
	{
		data = D;
		data.selected = this;
		setBorder (BorderFactory.createRaisedBevelBorder());
		setBackground (Color.BLACK);
		repaint();
	}

	public void paintComponent (Graphics g)
	{
		super.paintComponent (g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		data.currentShape.moveTo (getWidth()/2, getHeight()/2);
		data.currentShape.paintComponent (g2);
	}
}
