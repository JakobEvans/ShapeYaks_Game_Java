import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.*;
import javax.swing.*;
public class IntroPage extends JPanel
{

    String GameTitle;

    public IntroPage(){

        GameTitle = "Shape Yaks";
        setBorder(BorderFactory.createRaisedBevelBorder());

    }

    public void paintComponent(Graphics g) {

            //super.paintComponent (g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setPaint(Color.GREEN);

              g2.setBackground(new Color(0,0,0,255));
            Font font = new Font("Arial", Font.BOLD, 30);
           g2.setFont(font);

//            Rectangle2D size = font.getStringBounds(GameTitle, g2.getFontRenderContext());
//            int w =  (int)size.getWidth();
//            int h = (int)size.getHeight();
            g2.drawString(GameTitle, GameBoard.WIDTH/2, 150);


          //  grabFocus();


    }


}
