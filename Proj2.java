// File: Proj2.java
// CS 360 - Fall 2019 - Watts
// Shape Sorter Game App
// Novmber 2019
// Originally created by Dr. Watts
// http://watts.cs.sonoma.edu
/*
This file contains the implementation of a small
GUI application that uses the Shape class hierarchy
and animates the shapes.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Proj2
{
	Proj2 ()
	{
		System.out.println ("In Proj2 constructor");
		JFrame frame = new JFrame ("ShapeYaks");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setSize (1000,800);
		frame.setResizable (true);
		frame.setLocation (100, 100);
		Data data = new Data (frame);
		Container pane = frame.getContentPane();
		GameBoard gameboard = new GameBoard (data);
		Palette palette = new Palette (data);

//		IntroPage intro = new IntroPage();

		data.board = gameboard;
		//data.initLevel(0);
		pane.setLayout (new BorderLayout());
		pane.add (gameboard, BorderLayout.CENTER);
		pane.add(palette, BorderLayout.WEST);
		//pane.add (intro, BorderLayout.CENTER);



		frame.setVisible (true);
	}

	public static void main (String[] args)
	{
		Proj2 proj2 = new Proj2 ();
	}
}
// class SplashDemo extends Frame implements ActionListener {
// 	static void renderSplashFrame(Graphics2D g, int frame) {
// 		final String[] comps = {"foo", "bar", "baz"};
// 		g.setComposite(AlphaComposite.Clear);
// 		g.fillRect(120, 140, 200, 40);
// 		g.setPaintMode();
// 		g.setColor(Color.BLACK);
// 		g.drawString("Loading " + comps[(frame / 5) % 3] + "...", 120, 150);
// 	}
//
// 	@Override
// 	public void actionPerformed(ActionEvent e) {
// 		System.exit(1);
// 	}
// }
