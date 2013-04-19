/*
 * Left Display Panel for ColorFactory
 */
import java.awt.*;
import javax.swing.*;

public class DisplayPanel extends JPanel{
    
    //text R/G/B display
    public String redValString = "0";
    public String greenValString = "0";
    public String blueValString = "0";
    
    //separate displayed value from rgb value
    //for rect resizing and oval color display
    protected int redint = 0;
    protected int greenint = 0;
    protected int blueint = 0;
    
    //RGB rectangle height
    public int redHeight = 0;
    public int greenHeight = 0;
    public int blueHeight = 0;
    
    public DisplayPanel()
    {
        //components drawn in paintComponent
        setPreferredSize(new Dimension(300,200));
        setBackground(Color.white);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        //red polygon coordinates
        int[] xPointsRed = {
                20,90,90,20
        };
        int[] yPointsRed = {
                120,120,120-redHeight,120-redHeight
        };
        g.setColor(Color.red);
        g.fillPolygon(xPointsRed, yPointsRed, 4);
        g.setColor(Color.black);
        //red polygon label
        g.drawString(redValString, 25, 155);
        
        //green polygon
        int[] xPointsGreen = {
                110,180,180,110
        };
        int[] yPointsGreen = {
                120,120,120-greenHeight,120-greenHeight
        };
        g.setColor(Color.green);
        g.fillPolygon(xPointsGreen, yPointsGreen, 4);
        g.setColor(Color.black);
        g.drawString(greenValString, 115, 155);
        
        //blue polygon
        int[] xPointsBlue = {
                200,270,270,200
        };
        int[] yPointsBlue = {
                120,120,120-blueHeight,120-blueHeight
        };
        g.setColor(Color.blue);
        g.fillPolygon(xPointsBlue, yPointsBlue, 4);
        g.setColor(Color.black);
        g.drawString(blueValString, 205, 155);
        
        //Oval to display color
        Color ovalColor = new Color(redint,greenint,blueint);
        g.setColor(ovalColor);
        g.fillOval(100, 200, 90, 90);
        
    }
}
