// File: Palette.java
// CS 360 - Spring 2018 - Watts
// Frames and Images Example
// April 2018
// Originally created by Dr. Watts
// http://watts.cs.sonoma.edu
/*
This file contains the definition and implementation of
a Palette Panel class for a small GUI application that
uses the Shape class hierarchy.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.io.*;
import java.util.*;
import java.net.URL;
import java.awt.Toolkit;

public class Palette extends JPanel
{
	Data data;

	public Palette (Data D)
	{
		data = D;
		Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);

		setBorder (BorderFactory.createRaisedBevelBorder());
		setBorder (whiteLine);

		setLayout (new GridLayout(1,1));
		//SelectedPanel sp = new SelectedPanel (data);

		// add (sp);
		// //ShapePanel shp = new ShapePanel (data);
		// add (shp);
	

		Buttons bp = new Buttons (data);
		bp.setBackground(Color.BLACK);
		add (bp);



	}

}
