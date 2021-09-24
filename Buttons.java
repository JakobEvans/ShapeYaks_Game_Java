// File: Buttons.java
// CS 360 -  Fall 2019 - Watts
// Frames and Animation Example
// November 2019
// Originally created by Dr. Watts
// http://watts.cs.sonoma.edu
/*
This file contains the definition and implementation of
a Buttons Panel class for a small GUI application that
uses the Shape class hierarchy.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;


public class Buttons extends JPanel implements ActionListener
{
	private JButton Level1Button;
	private JButton Level2Button;
	private JButton Level3Button;
	private JButton ResetButton;
	private JButton InstructionsButton;
	private JPanel popUp;
	private JLabel instructions;
	private JLabel instructions2;
	private JButton QuitButton;
	// private JButton ScoreButton;
	ImageIcon icon;
	Data data;

	public Buttons (Data D) {
		data = D;

		icon = new ImageIcon(Buttons.class.getResource("yak.png"));

		popUp = new JPanel();
		instructions = new JLabel("Move the shape blocks into their appropriate hole!");

		popUp.setBorder(BorderFactory.createEtchedBorder());
		popUp.add(instructions);

		//text = "Move the shape blocks into their appropriate hole!";
		//instructions = new JLabel(instructions);
		//popUp.add(instructions);
		//instructions = new JLabel("BLBLABLBLBALBALB");
		//instructions = new JLabel("BLBLABLBLBALBALB");

		Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);
		setBorder(BorderFactory.createRaisedBevelBorder());
		setBorder(whiteLine);

		setLayout(new GridLayout(5, 1));



		Level1Button = new JButton("Level 1");
		Level1Button.setBackground(new Color(50,50,50));
		add(Level1Button);
		Level1Button.addActionListener(this);

		Level2Button = new JButton("Level 2");
		add(Level2Button);
		Level2Button.addActionListener(this);

		Level3Button = new JButton("Level 3");
		add(Level3Button);
		Level3Button.addActionListener(this);



		InstructionsButton = new JButton("Instructions");
		add(InstructionsButton);
		InstructionsButton.addActionListener(this);

		QuitButton = new JButton("Quit");
		add(QuitButton);
		QuitButton.addActionListener(this);

		// ScoreButton = new JButton(Integer.toString(data.score));
		// add(ScoreButton);


	}

	public void actionPerformed (ActionEvent e)
	{
		if (e.getSource() == Level1Button)
		{
				data.initLevel(0);
		}
		if (e.getSource() == Level2Button)
		{
			// data.running = false;
			data.initLevel(1);
		}
		if (e.getSource() == Level3Button)
		{
			// data.S.clear();
			// data.board.revalidate();
			data.initLevel(2);
		}

		if(e.getSource() == ResetButton)
		{
			System.out.println(data.blocks.size());


			//data.board.revalidate();

		}

		if(e.getSource() == InstructionsButton)
		{

			JOptionPane.showMessageDialog(null, instructions,"Instructions", JOptionPane.INFORMATION_MESSAGE,icon);



		}

		if(e.getSource() == QuitButton)
		{
			System.exit(1);

		}
	}
}
