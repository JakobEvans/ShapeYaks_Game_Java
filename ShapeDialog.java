//// file: ShapeDialog.java
//// CS 360 - Fall 2006 - Watts
//// Project 1
//// September 2006
//// Written by Dr. Watts
//// http://www.cs.sonoma.edu/~tiawatts
///*
//Dialog box for selecting a shape and its color and providing
//a name for the shape
//*/
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//
//
//public class ShapeDialog extends JDialog implements ActionListener {
//	private JPanel myPanel = null;
//	private JButton OKButton = null, cancelButton = null;
//	private ShapePanel shapePanel = null;
//	private ColorPanel colorPanel = null;
//	private JPanel buttonPanel = null;
//	private Color currentColor = Color.red;
//	private Block newShape = null;
//	private boolean answer = false;
//
//
//
//	public Block getNewShape() {
//		return newShape;
//	}
//
//	public boolean getAnswer() {
//		return answer;
//	}
//
//	public ShapeDialog(JFrame frame, boolean modal, int x, int y)
//	//public ShapeDialog(JPanel frame, boolean modal, int x, int y)
//	{
//		super(frame, modal);
//		myPanel = new JPanel();
//		getContentPane().add(myPanel);
//		myPanel.setLayout(new GridLayout(3, 1));
//		myPanel.setLayout(new FlowLayout());
//		shapePanel = new ShapePanel(data);
//		myPanel.add(shapePanel);
////		myPanel.addCheckBoxes ();
////		colorPanel = new ColorPanel (Color.RED);
////		myPanel.add (colorPanel);
////		addRadioButtons ();
//		addTextAndButtons();
//		setTitle("New Shape Dialog");
//		setLocation(x, y);
//		setSize(300, 250);
//		setVisible(true);
//	}
//
//	private void addTextAndButtons() {
//		buttonPanel = new JPanel();
//		OKButton = new JButton("    OK    ");
//		OKButton.addActionListener(this);
//		buttonPanel.add(OKButton);
//		cancelButton = new JButton("Cancel");
//		cancelButton.addActionListener(this);
//		buttonPanel.add(cancelButton);
//		myPanel.add(buttonPanel);
//	}
//
//	public void actionPerformed(ActionEvent e) {
//		if (OKButton == e.getSource()) {
//			GShape.GShapeType currentShape = shapePanel.getNewShape();
//			switch (currentShape) {
//				case CIRCLE:
//					newShape = new Block(new Circle(), 50);
//					break;
//				case SQUARE:
//					newShape = new Block(new Square(), 50);
//					break;
//				case RECTANGLE:
//					newShape = new Block(new Rectangle(), 50);
//					break;
//				case EQUILATERAL:
//					newShape = new Block(new Equilateral(), 50);
//					break;
//				case RIGHT:
//					newShape = new Block(new Right(), 50);
//					break;
//				case SCALENE:
//					newShape = new Block(new Scalene(), 50);
//					break;
//				default:
//					newShape = new Block(new Circle(), 50);
//					break;
//			}
//			answer = true;
//			setVisible(false);
//			getContentPane().remove(myPanel);
//		} else if (cancelButton == e.getSource()) {
//			answer = false;
//			setVisible(false);
//		}
//	}
//}
//
