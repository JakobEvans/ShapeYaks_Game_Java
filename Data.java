// File: Data.java
// CS 360 -  Fall 2019 - Watts
// Frames and Animation Example
// November 2019
// Originally created by Dr. Watts
// http://watts.cs.sonoma.edu
/*
This file contains the shared data items class.
*/

import static java.lang.Math.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class Data
{
	public JFrame game;
	public GameBoard board;
	public int tWidth, tHeight;
	public ArrayList <Block> blocks = new ArrayList <Block> ();
	public ArrayList <Hole> holes = new ArrayList <Hole> ();
	public ArrayList <GShape> S = new ArrayList <GShape> ();
	public ArrayList <GShape> sPrev = new ArrayList <GShape>();
	public Block currentBlock = null;
	public int level;
	public int score;
	public int blocksToPlace;
	public int highScore;
	public SelectedPanel selected;
	public Color currentColor = Color.WHITE;
	public GShape currentShape = new Circle (45, 0, 0, currentColor);
	public Thread level1thread;
	public Thread level2thread;
	public Thread level3thread;

	public boolean running = false;

	public Data (JFrame G)
	{
		game = G;
	}

	public void initLevel (int L)
	{
		level = L;
		//System.out.println(level + " the level");
		switch (level)
		{
			case 0: initLevel0 (); break;
			case 1: initLevel1 (); break;
			case 2: initLevel2 (); break;
		}
	}


	public void finishLevel ()
	{
		System.out.println ("Level complete! Your score is " + score);
	}

	public void initLevel0 ()
	{

		System.out.println("level 1 loaded");
		currentBlock = null;
		blocks.clear();
		holes.clear();
		running = false;

		board.repaint();
		Block square = new Block(new Square(100, tWidth/2, tHeight/2, Color.blue, 0.0), 50);
		Block rectangle = new Block(new Rectangle(100, 50, tWidth/2, tHeight/2, Color.blue, 0.0), 50);
		Block right = new Block(new Right(100, 150, tWidth/2, tHeight/2, Color.blue, 0.0), 50);
		Block circle = new Block(new Circle(100, tWidth/2, tHeight/2, Color.blue), 50);
		Block equilateral = new Block(new Equilateral(100, tWidth/2, tHeight/2, Color.blue, 0.0), 50);
		Block scalene = new Block(new Scalene(100, 150, 200, tWidth/2, tHeight/2, Color.blue, 0.0), 50);
		blocks.add(square);
		blocks.add(rectangle);
		blocks.add(right);
		blocks.add(circle);
		blocks.add(equilateral);
		blocks.add(scalene);
		Hole squareh = new Hole (new Square (125, tWidth/6, tHeight/6, Color.white, 0.0));
	 	Hole rectangleh = new Hole (new Rectangle (125, 63, tWidth/6, tHeight/2, Color.white, 0.0));
	 	Hole righth = new Hole (new Right (125, 188, tWidth-(tWidth/6), tHeight/6, Color.white, 0.0));
	 	Hole circleh = new Hole (new Circle (125, tWidth-(tWidth/6), tHeight-(tHeight/6), Color.white));
	 	Hole equilateralh = new Hole (new Equilateral (125, tWidth-(tWidth/6), tHeight/2, Color.white, 0.0));
	 	Hole scaleneh = new Hole (new Scalene (125, 188, 250, tWidth/6, tHeight-(tHeight/6), Color.white, 0.0));
		holes.add(squareh);
		holes.add(rectangleh);
		holes.add(righth);
		holes.add(circleh);
		holes.add(equilateralh);
		holes.add(scaleneh);
		score = 0;
		blocksToPlace = 6;
		running = true;
		//level = 2;
		level2thread = new Thread (board);
		level2thread.start();
		board.repaint();
	}

	public void initLevel1 ()
	{
		System.out.println("level 2 loaded");
		currentBlock = null;
		blocks.clear();
		holes.clear();
		running = false;

		board.repaint();
		Block square = new Block(new Square(100, tWidth/2, tHeight/2, Color.green, 0.0), 50);
		Block rectangle = new Block(new Rectangle(100, 50, tWidth/2, tHeight/2, Color.green, 0.0), 50);
		Block right = new Block(new Right(100, 150, tWidth/2, tHeight/2, Color.green, 0.0), 50);
		Block circle = new Block(new Circle(100, tWidth/2, tHeight/2, Color.green), 50);
		Block equilateral = new Block(new Equilateral(100, tWidth/2, tHeight/2, Color.green, 0.0), 50);
		Block scalene = new Block(new Scalene(100, 150, 200, tWidth/2, tHeight/2, Color.green, 0.0), 50);
		blocks.add(square);
		blocks.add(rectangle);
		blocks.add(right);
		blocks.add(circle);
		blocks.add(equilateral);
		blocks.add(scalene);
		Hole squareh = new Hole (new Square (125, tWidth/6, tHeight/6, Color.white, 0.0));
	 	Hole rectangleh = new Hole (new Rectangle (125, 63, tWidth/6, tHeight/2, Color.white, 0.0));
	 	Hole righth = new Hole (new Right (125, 188, tWidth-(tWidth/6), tHeight/6, Color.white, 0.0));
	 	Hole circleh = new Hole (new Circle (125, tWidth-(tWidth/6), tHeight-(tHeight/6), Color.white));
	 	Hole equilateralh = new Hole (new Equilateral (125, tWidth-(tWidth/6), tHeight/2, Color.white, 0.0));
	 	Hole scaleneh = new Hole (new Scalene (125, 188, 250, tWidth/6, tHeight-(tHeight/6), Color.white, 0.0));
		holes.add(squareh);
		holes.add(rectangleh);
		holes.add(righth);
		holes.add(circleh);
		holes.add(equilateralh);
		holes.add(scaleneh);
		score = 0;
		blocksToPlace = 6;
		running = true;
		//level = 2;
		level2thread = new Thread (board);
		level2thread.start();
		board.repaint();



	}

	public void initLevel2 ()
	{
		System.out.println("level 3 loaded");
        currentBlock = null;

        blocks.clear();
        holes.clear();
        running = false;

        board.repaint();


        Block square = new Block(new Square(100, tWidth / 5, tHeight / 5, Color.green, 0.0), 50);
        Block rectangle = new Block(new Rectangle(100, 50, tWidth / 5, tHeight / 5, Color.green, 0.0), 50);
        Block right = new Block(new Right(100, 150, tWidth / 5, tHeight / 5, Color.green, 0.0), 50);
        Block circle = new Block(new Circle(100, tWidth / 5, tHeight / 5, Color.green), 50);
        Block equilateral = new Block(new Equilateral(100, tWidth / 5, tHeight / 5, Color.green, 0.0), 50);
        Block scalene = new Block(new Scalene(100, 150, 200, tWidth / 5, tHeight / 5, Color.green, 0.0), 50);

        blocks.add(square);
        blocks.add(rectangle);
        blocks.add(right);
        blocks.add(circle);
        blocks.add(equilateral);
        blocks.add(scalene);

		Hole squareh = new Hole(new Square(125, tWidth / 6, tHeight / 2, Color.white, 0.0));
		Hole rectangleh = new Hole(new Rectangle(125, 63, tWidth / 2, tHeight - (tHeight / 6), Color.white, 0.0));
		Hole righth = new Hole(new Right(125, 188, tWidth - (tWidth / 2), tHeight / 2, Color.white, 0.0));
		Hole circleh = new Hole(new Circle(125, tWidth - (tWidth / 6), tHeight - (tHeight / 6), Color.white));
		Hole equilateralh = new Hole(new Equilateral(125, tWidth - (tWidth / 6), tHeight / 2, Color.white, 0.0));
		Hole scaleneh = new Hole(new Scalene(125, 188, 250, tWidth / 6, tHeight - (tHeight / 6), Color.white, 0.0));

		holes.add(squareh);
		holes.add(rectangleh);
		holes.add(righth);
		holes.add(circleh);
		holes.add(equilateralh);
		holes.add(scaleneh);



        running = true;

        level3thread = new Thread(board);
        level3thread.start();

        board.repaint();


        score = 0;
        blocksToPlace = 6;
	}

	void placeBlockOnBoard (Block block)
	{
		block.onBoard = true;
		block.shape.isSelected = true;
		currentBlock = block;
		board.repaint ();
	}

	void removeBlockFromBoard (Block block)
	{
		block.onBoard = false;
		block.shape.isSelected = false;
		currentBlock = null;
		board.repaint ();
	}

	boolean checkIfBlockInHole (Block block)
	{

		int X = block.shape.getCenterX();
		int Y = block.shape.getCenterY();
		Hole hole = null;
		for (int i = 0; hole == null && i < holes.size(); i++)
			if (holes.get(i).isIn (X, Y))
				hole = holes.get(i);

		// System.out.println(hole + " THEHOLE");

		if (hole == null || hole.filled)
			return false;
		boolean contained = block.containedInHole (hole);
		if (contained){
			placeBlockInHole (block, hole);
		}

		return contained;
	}

	void placeBlockInHole (Block block, Hole hole)
	{
		block.onBoard = false;
		block.shape.isSelected = false;
		block.placed = true;
		hole.filled = true;
		hole.filledWith = block;
		block.moveTo (hole.shape.getCenterX(), hole.shape.getCenterY());
		score += block.getPoints();
		blocksToPlace--;
		currentBlock = null;
		board.repaint ();
		if (blocksToPlace == 0){
			running = false;
			try{level2thread.join();}catch(InterruptedException e){}
			finishLevel();
		}
	}

	void removeBlockFromHole (Hole hole)
  {
		Block block = hole.filledWith;
		block.placed = false;
		score -= block.getPoints();
		blocksToPlace++;
		hole.filledWith = null;
		hole.filled = false;
		board.repaint ();
  }
	public void reset()
{
	S.clear();
	for (GShape s : sPrev)
			S.add(s.clone());
	//sPrev.clear();
}
}
