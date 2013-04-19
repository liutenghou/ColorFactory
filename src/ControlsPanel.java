/*
 * Right Controls Panel for ColorFactory
 * 
 */
import java.awt.*;
import javax.swing.*;

public class ControlsPanel extends JPanel
{
    static final int RGB_MIN = 0;
    static final int RGB_MAX = 255;
    static final int RGB_INIT = 0;

    protected int greenValue;
    protected int redValue;
    protected int blueValue;
    
    //sliders
    protected JSlider redSlider;
    protected JSlider blueSlider;
    protected JSlider greenSlider;
    
    //radio buttons
    protected JRadioButton decimalButton;
    protected JRadioButton octalButton;
    protected JRadioButton binaryButton;
    protected JRadioButton hexButton;
    
    public ControlsPanel()
    {
        //layout
        setLayout(new FlowLayout());
        
        //radio buttons
        decimalButton = new JRadioButton("Decimal", true);
        decimalButton.setBackground(Color.white);
        octalButton = new JRadioButton("Octal");
        octalButton.setBackground(Color.white);
        binaryButton = new JRadioButton("Binary");
        binaryButton.setBackground(Color.white);
        hexButton = new JRadioButton("Hex");
        hexButton.setBackground(Color.white);
        
        //group radio buttons
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(decimalButton);
        radioGroup.add(octalButton);
        radioGroup.add(binaryButton);
        radioGroup.add(hexButton);
        
        redSlider = new JSlider(JSlider.HORIZONTAL,
                RGB_MIN, RGB_MAX, RGB_INIT);
        redSlider.setMajorTickSpacing(51);
        redSlider.setBackground(Color.white);
        //redSlider.setPaintTicks(true);
        //redSlider.setPaintLabels(true);
        JLabel redLabel = new JLabel("Red    ");    
        
        greenSlider = new JSlider(JSlider.HORIZONTAL,
                RGB_MIN, RGB_MAX, RGB_INIT);
        greenSlider.setMajorTickSpacing(51);
        greenSlider.setBackground(Color.white);
        //greenSlider.setPaintTicks(true);
        //greenSlider.setPaintLabels(true);
        JLabel greenLabel = new JLabel("Green");
        
        blueSlider = new JSlider(JSlider.HORIZONTAL,
                RGB_MIN, RGB_MAX, RGB_INIT);
        blueSlider.setMajorTickSpacing(51);
        blueSlider.setBackground(Color.white);
        //blueSlider.setPaintTicks(true);
        //blueSlider.setPaintLabels(true);
        JLabel blueLabel = new JLabel("Blue   ");
        
        //add buttons
        add(decimalButton);
        add(octalButton);
        add(binaryButton);
        add(hexButton);
        
        //add sliders and associated labels
        add(redSlider);
        add(redLabel);
        add(greenSlider);
        add(greenLabel);
        add(blueSlider);
        add(blueLabel);
        
        setPreferredSize(new Dimension(300,200));
        setBackground(Color.white);
    }
}
