// File: ColorPanel.java
// Author: Dr. Watts
// Contents: This file contains the implementation of a small
// GUI application that uses the Shape class hierarchy.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class ColorPanel extends JPanel
{
	Color [] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
			   Color.BLUE, new Color (82, 8, 125), Color.WHITE,
			   Color.GRAY, Color.BLACK};
	Data data;

	public ColorPanel (Data D)
	{
//		data = D;
//		setLayout (new GridLayout(3,3));
//		setBorder (BorderFactory.createRaisedBevelBorder());
//		for (int i = 0; i < 8; i++)
//		{
//			OneColor one = new OneColor (colors[i]);
//			add (one);
//		}
//		OneColor one = new OneColor (new Color(255, 10, 255));
//		add (one);
	}

	class OneColor extends JPanel implements MouseListener
	{
		Color color;

		public OneColor (Color C)
		{
			color = C;
			setBackground (color);
			setBorder (BorderFactory.createRaisedBevelBorder());
			addMouseListener(this);
			repaint();
		}

		public void mousePressed (MouseEvent e)
		{
			//System.out.println ("Mouse pressed at " + e.getX() + ", " + e.getY());
			if (e.getButton() == e.BUTTON1) // Left mouse button
			{
				data.currentColor = color;
				System.out.println ("The color is now " + color);
				if (data.currentColor != null)
				{
					data.currentShape.setColor (data.currentColor);
					data.selected.repaint();
				}
			}
		}
		public void mouseReleased (MouseEvent e) { }
		public void mouseEntered (MouseEvent e) { }
		public void mouseExited (MouseEvent e) { }
		public void mouseClicked (MouseEvent e) { }
	}
}
