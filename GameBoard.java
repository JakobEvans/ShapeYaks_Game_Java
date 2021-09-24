// File: GameBoard.java
// CS 360 -  Fall 2019 - Watts
// Frames and Animation Example
// November 2019
// Originally created by Dr. Watts
// http://watts.cs.sonoma.edu
/*
This file contains the definition and implementation of
a background Panel class for a small GUI application that
uses the Block class hierarchy.
*/

import static java.lang.Math.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;


public class GameBoard extends JPanel implements MouseMotionListener, MouseListener, KeyListener, Runnable {
    Data data;

    private Block prevBlock = null;
    private JFrame outside;
    private boolean inFrame = true;
    private int currentX, currentY;
    private Block selected = null;
    private Random generator = new Random();
    private String scoreStr = "Score: ";
    private IntroPage intro;

    public GameBoard(Data D) {
        data = D;
        data.board = this;
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addMouseMotionListener(this);
        addMouseListener(this);
        setFocusable(true);
        grabFocus();
        addKeyListener(this);
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < data.holes.size(); i++)
            data.holes.get(i).paintComponent(g2);
        for (int i = 0; i < data.blocks.size(); i++)
            data.blocks.get(i).paintComponent(g2);
        if (data.currentBlock != null)
            data.currentBlock.paintComponent(g2);
        data.tWidth = getWidth();
        data.tHeight = getHeight();

        g2.setPaint(Color.WHITE);
        Font font = new Font("Arial", 0, 22);
        g2.setFont(font);
        scoreStr = "Score: " + String.valueOf(data.score);
        Rectangle2D stringBounds = font.getStringBounds(scoreStr, g2.getFontRenderContext());
        int n = (int) stringBounds.getWidth();
        int n2 = (int) stringBounds.getHeight();
        g2.drawString(scoreStr, getWidth() / 8 - n / 2, data.tHeight / 20 - n2 / 2 + 4 * n2 / 5);

        grabFocus();

    }

    public void mouseDragged(MouseEvent e) {

        int mouseX = e.getX();
        int mouseY = e.getY();

        if (selected != null) {
            if (data.level == 0 || data.level == 1) {
                selected.shape.move(mouseX - currentX, mouseY - currentY);
                if (data.checkIfBlockInHole(selected))
                    selected = null;
            } else {
                if (!selected.isDropped) {
                    selected.shape.move(mouseX - currentX, 0);
                }
            }
        }

        repaint();

        currentX = mouseX;
        currentY = mouseY;
    }

    public void mouseMoved(MouseEvent e) {

        //System.out.println ("Mouse moved event: " + e);
    }

    public void mousePressed(MouseEvent e) {

        inFrame = true;
        currentX = e.getX();
        currentY = e.getY();
        if (selected != null)
            selected.isSelected = false;
        selected = null;
        if (e.getButton() == e.BUTTON1) // Left mouse button
        {
            for (int i = data.blocks.size() - 1; i >= 0; i--)
                if (data.blocks.get(i).isIn(currentX, currentY))
                    selected = data.blocks.get(i);
        }

        if (selected != null)
            selected.isSelected = true;
        repaint();

    }


    public void mouseReleased(MouseEvent e) {
        //System.out.println ("Mouse released event: " + e);
				if(selected != null)
					selected.isDropped = true;
    }

    public void mouseEntered(MouseEvent e) {
        //System.out.println ("Mouse entered event: " + e);
        inFrame = true;
    }

    public void mouseExited(MouseEvent e) {
        //System.out.println ("Mouse exited event: " + e);
        inFrame = false;
    }

    public void mouseClicked(MouseEvent e) {
        //System.out.println ("Mouse clicked event: " + e);
    }

    public void keyTyped(KeyEvent e) {
        // System.out.println ("Key Listener event: " + e);
    }


    public void keyPressed(KeyEvent e) {
        //System.out.println ("Key Listener event: " + e);
    }

    public void keyReleased(KeyEvent e) {
        // System.out.println ("Key Listener event: " + e);
    }

    public void run() {

        if (data.level == 1) {
            try {
                while (data.running) {
                    if (data.level != 1) data.running = false;
                    for (int i = 0; i < data.blocks.size(); i++) {
                        if (!data.blocks.get(i).placed)
                            data.blocks.get(i).rotate(50);
                    }
                    repaint();
                    Thread.sleep(50);
                }
                repaint();
            } catch (InterruptedException ie) {
            }
        } else if (data.level == 2) {
			try {
				while (data.running) {
					if (data.level != 2) data.running = false;
					for (int i = 0; i < data.blocks.size(); i++) {
						if (data.blocks.get(i).isDropped && !data.blocks.get(i).placed){
							data.blocks.get(i).move(0, 1);
							data.checkIfBlockInHole(data.blocks.get(i));
						}
					}
					repaint();
					Thread.sleep(5);
				}
				repaint();
			} catch (InterruptedException ie) {
			}
        } else {
            data.running = false;
        }
    }
}
