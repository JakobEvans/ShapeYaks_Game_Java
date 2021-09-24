



// File: ShapePanel.java
// Author: Dr. Watts
// Contents: This file contains the implementation of a small
// GUI application that uses the Shape class hierarchy.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;

public class ShapePanel extends JPanel
{
    Data data;
    Block currentBlock;
    Block prevBlock;

    public ShapePanel (Data D)
    {
        data = D;
        setLayout (new GridLayout(3,2));
        setBorder (BorderFactory.createRaisedBevelBorder());
        OneShape circle = new OneShape (new Circle (45, 0, 0, Color.white));
        add (circle);
        OneShape square = new OneShape (new Square (45, 0, 0, Color.white, 0.0));
        add (square);
        OneShape rectangle = new OneShape (new Rectangle (45, 30, 0, 0, Color.white, 0.0));
        add (rectangle);
        OneShape equitri = new OneShape (new Equilateral (45, 0, 0, Color.white, 0.0));
        add (equitri);
        OneShape righttri = new OneShape (new Right(45.0, 60.0, 0, 0, Color.white, 0.0));
        add (righttri);
        OneShape scaleneTri = new OneShape (new Scalene(40.0, 50.0, 70.0, 0, 0, Color.white, 0.0));
        add (scaleneTri);
    }

    class OneShape extends JPanel implements MouseListener
    {
        private GShape shape;

        public OneShape (GShape S)
        {
            setBackground (Color.black);
            Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);
            setBorder (BorderFactory.createRaisedBevelBorder());
            setBorder (whiteLine);
          //  setBorder (BorderFactory.createRaisedBevelBorder());

            ;
            shape = S;
            addMouseListener(this);
            repaint();
        }

        public void paintComponent (Graphics g)
        {
            super.paintComponent (g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            shape.moveTo (getWidth()/2, getHeight()/2);
            shape.paintComponent (g2);
        }

        public void mousePressed (MouseEvent e)
        {
            //System.out.println ("Mouse pressed at " + e.getX() + ", " + e.getY());
            if (e.getButton() == e.BUTTON1) // Left mouse button
            {
                data.currentShape = shape;
                //System.out.println ("The shape is now " + image);
                if (data.currentShape != null)
                {
                    if(currentBlock != prevBlock) {
                        System.out.println("TESTING " + shape.getName());
                        currentBlock = new Block(data.currentShape, 5);
                        currentBlock.
                                shape.move(500, 700);
                        data.blocks.add(currentBlock);

                        data.selected.repaint();
                    }

                }
            }
        }
        public void mouseReleased (MouseEvent e) { }
        public void mouseEntered (MouseEvent e) { }
        public void mouseExited (MouseEvent e) { }
        public void mouseClicked (MouseEvent e) {


        }
    }
}
