/*
 * Teng Liu
 * w00678070
 * CS211S
 * April 8, 2013
 * 
 * Assignment 01
 * ColorFactory
 * 
 * Creating colors in java, combine red/green/blue values from 0-255
 * 
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorFactory extends JFrame
{
   
   private static ControlsPanel cp;
   private static DisplayPanel dp;
   
   public ColorFactory(){
      //layout
      setLayout(new BorderLayout());
      
      JLabel titleLabel = new JLabel("Color Factory", SwingConstants.CENTER);
      titleLabel.setFont(new Font("Sans_Serif", Font.PLAIN, 24));
      //add label at the top
      this.add(titleLabel, BorderLayout.NORTH);
      
      //panels
      dp = new DisplayPanel();      
      cp = new ControlsPanel();
        
      this.getContentPane(); 
        
      //layout for panels
      //this.setLayout(new GridLayout(1, 2));
        
      //adding panels
      this.add(dp, BorderLayout.WEST);
      this.add(cp, BorderLayout.EAST);
       
      //setBounds
      this.setBounds(100, 100, 600, 400);
       
      this.setTitle("Color Factory");
      this.setResizable(false);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      this.setVisible(true);
        
      //slider listeners
      RedSliderListener rsl = new RedSliderListener();
      cp.redSlider.addChangeListener(rsl);
      GreenSliderListener gsl = new GreenSliderListener();
      cp.greenSlider.addChangeListener(gsl);
      BlueSliderListener bsl = new BlueSliderListener();
      cp.blueSlider.addChangeListener(bsl);
        
      //radio button listeners
      cp.decimalButton.addActionListener(new DecimalListener());
      cp.octalButton.addActionListener(new OctalListener());
      cp.binaryButton.addActionListener(new BinaryListener());
      cp.hexButton.addActionListener(new HexListener());

   }
   
   public static void main(String[] args) 
   {
      //creates non-static instance of ColorFactory
      new ColorFactory();
   }
   
   //set value string methods
   private void setRedValString()
   {
      if (deciSliderOn)
      {
         dp.redValString = String.valueOf(cp.redSlider.getValue());
      } else if (octSliderOn){
         dp.redValString = String.valueOf(Integer.toOctalString(cp.redSlider.getValue()));
      } else if (binSliderOn){
         dp.redValString = String.valueOf(Integer.toBinaryString(cp.redSlider.getValue()));
      } else if (hexSliderOn){
         dp.redValString = String.valueOf(Integer.toHexString(cp.redSlider.getValue()));
      }
   }
   private void setGreenValString()
   {
      if(deciSliderOn)
      {
         dp.greenValString = String.valueOf(cp.greenSlider.getValue());
      } else if (octSliderOn){
         dp.greenValString = String.valueOf(Integer.toOctalString(cp.greenSlider.getValue()));
      } else if (binSliderOn){
         dp.greenValString = String.valueOf(Integer.toBinaryString(cp.greenSlider.getValue()));
      } else if (hexSliderOn){
         dp.greenValString = String.valueOf(Integer.toHexString(cp.greenSlider.getValue()));
      }
   }
   private void setBlueValString()
   {
      if(deciSliderOn)
      {
         dp.blueValString = String.valueOf(cp.blueSlider.getValue());
      } else if (octSliderOn){
         dp.blueValString = String.valueOf(Integer.toOctalString(cp.blueSlider.getValue()));
      } else if (binSliderOn){
         dp.blueValString = String.valueOf(Integer.toBinaryString(cp.blueSlider.getValue()));
      } else if (hexSliderOn){
         dp.blueValString = String.valueOf(Integer.toHexString(cp.blueSlider.getValue()));
      }
   }
   
   //Button Listeners
   private boolean deciSliderOn = true;
   private boolean octSliderOn = false;
   private boolean binSliderOn = false;
   private boolean hexSliderOn = false;
   
   private class DecimalListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {         
         deciSliderOn = true;
         octSliderOn = false;
         binSliderOn = false;
         hexSliderOn = false;
         
         //dynamically change text values after radiobutton select
         setRedValString();
         setGreenValString();
         setBlueValString();
         dp.repaint();
      }

   }
   private class OctalListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {         
         deciSliderOn = false;
         octSliderOn = true;
         binSliderOn = false;
         hexSliderOn = false;
         setRedValString();
         setGreenValString();
         setBlueValString();
         dp.repaint();
      }
   }
   private class BinaryListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         deciSliderOn = false;
         octSliderOn = false;
         binSliderOn = true;
         hexSliderOn = false;
         setRedValString();
         setGreenValString();
         setBlueValString();
         dp.repaint();
      }
   }
   private class HexListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         deciSliderOn = false;
         octSliderOn = false;
         binSliderOn = false;
         hexSliderOn = true;
         setRedValString();
         setGreenValString();
         setBlueValString();
         dp.repaint();
      }
   }
   
   
   //Slider Listeners
   private class RedSliderListener implements ChangeListener
   {
      
      public void stateChanged(ChangeEvent e)
      {
         //text changes depending on radio selection
         setRedValString();
         //paints circle
         dp.redint = cp.redSlider.getValue();
         //changes rect height
         dp.redHeight = (cp.redSlider.getValue())/3;
         dp.repaint();
      }   
   }
   private class GreenSliderListener implements ChangeListener
   {
      
      public void stateChanged(ChangeEvent e)
      {
         setGreenValString();
         dp.greenint = cp.greenSlider.getValue();
         dp.greenHeight = (cp.greenSlider.getValue())/3;
         dp.repaint();
      }   
   }
   private class BlueSliderListener implements ChangeListener
   {
      
      public void stateChanged(ChangeEvent e)
      {
         setBlueValString();
         dp.blueint = cp.blueSlider.getValue();
         dp.blueHeight = (cp.blueSlider.getValue())/3;
         dp.repaint();
      }   
   }
}