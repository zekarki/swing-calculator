/*
 Filename:   Swing_Calculator.java
Purpose:    Test a basic Swing Calculator application
Author:     Jeetendra Karki
Date:       01/08/024
version:    1.0
Notes:
 */
package swing_calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Swing_Calculator 
{
    // GUI components 
    private JFrame frame;
    // JFrame (4 sub-contrainers that go inside the JFrame)
    //JPanel
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    
    // JLabels
    private JLabel nbr1_JLabel;
    private JLabel nbr2_JLabel;
    private JLabel result_JLabel;
    
    //JTextFields
    private JTextField nbr1_JTextField;
    private JTextField nbr2_JTextField;
    private JTextField result_JTextField;
    
    //JButtons
    private JButton add_JButton;
    private JButton subtract_JButton;
    private JButton multiply_JButton;
    private JButton divide_JButton;
    
    // Layout
    private GridLayout layout;
    
    // Constructor method
    public Swing_Calculator()
    {
        // GUI SETUP
        // JFrame
        frame = new JFrame();
        
        // Grid Layout
        layout =new GridLayout(4, 1);
        
        // JPanels
        
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        
        // JLabel
        nbr1_JLabel = new JLabel("Number 1:");
        nbr2_JLabel = new JLabel("Number 2:");
        result_JLabel = new JLabel("Result");
        
        
        // JTextFields
        nbr1_JTextField = new JTextField();
        nbr2_JTextField = new JTextField();
        result_JTextField = new JTextField();
        
        // JButton
        
        add_JButton = new JButton("Add");
        subtract_JButton = new JButton("Subtract");
        multiply_JButton = new JButton("Multiply");
        divide_JButton = new JButton("Divide");
        
        // add Components to frame using grid layout and 4 JPanels
        frame.getContentPane().add(panel1);
        frame.getContentPane().add(panel2);
        frame.getContentPane().add(panel3);
        frame.getContentPane().add(panel4);
        
        //for some color 
        panel1.setBackground(Color.GRAY);
        panel2.setBackground(Color.WHITE);
        panel3.setBackground(Color.ORANGE);
        panel4.setBackground(Color.GREEN);
     
        //add JLabel and JTextField Object to go into top 3 panels
        panel1.add(nbr1_JLabel);
        panel1.add(nbr1_JTextField);
        panel2.add(nbr2_JLabel);
        panel2.add(nbr2_JTextField);
        panel3.add(result_JLabel);
        panel3.add(result_JTextField);
        
        //add JButton object  to go into 4th bottom panel
        
        panel4.add(add_JButton);
        panel4.add(subtract_JButton);
        panel4.add(multiply_JButton);
        panel4.add(divide_JButton);
        
        //set preferred sizes to text fields
        nbr1_JTextField.setPreferredSize(new Dimension (250, 30));
        nbr2_JTextField.setPreferredSize(new Dimension (250, 30));
        result_JTextField.setPreferredSize(new Dimension (250, 30));
        
        //BUTTON Events
        
        // register action listener to add button
        add_JButton.addActionListener(
                new ActionListener()
        {
            @Override
            //override of ActionListener
            // interface method action Performed()
            public void actionPerformed(ActionEvent e)
            {
                // code to implement when triggered
                makeCalculation("+");
                
            }
            
        });             
        
        // register action listener to subtract button
        subtract_JButton.addActionListener (new ActionListener()
        {
         @Override
         
         // interface method actionPerformed()
         public void actionPerformed (ActionEvent e)
         {
             // code to implement when triggered
             makeCalculation("-");
             
         }
        });
        
        // regiser action listener to multiply button
        multiply_JButton.addActionListener (new ActionListener()
        {
            @Override
            // override of ActionListener
            
            public void actionPerformed(ActionEvent e)
            {
                 makeCalculation("*");
            }
            
        });
        
        // register action listener to divide button
        
        divide_JButton.addActionListener(new ActionListener()
        {
            @Override
            //override of ActionListener
            
            public void actionPerformed(ActionEvent e)
            {
                makeCalculation("/");
                
            }
        });
        
        
        //FORM SETUP
        //Set parameters for frame object
        // (Size, location on screen, window title,
        //layout and visibility
        
        frame.setSize(400, 300);
        frame.setLocation(0,0);
        frame.setTitle("Swing Calculator");
        frame.setLayout(layout);
        
        // arrange
        // frame.pact();
        frame.setVisible(true);
        
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    } // end constructor method
    
    private void makeCalculation (String mathOp)
    {
//        System.out.println(mathOp);
        // 1. get 2 numbers from JTExtField
        double d1 =Double.parseDouble(nbr1_JTextField.getText());
        double d2 =Double.parseDouble(nbr2_JTextField.getText());
        double result = 0;
        // 1. Get math operator 
        if(mathOp.equals("+"))
        {
            // add operation
            result = add(d1, d2);
            
        }
        else if (mathOp.equals("-"))
        {
            result = subtract (d1, d2);
            
        }
        else if (mathOp.equals("*"))
        {
            result = multiply (d1, d2);
            
        }
        else if (mathOp.equals("/"))
        {
            result = divide(d1, d2);
        }
        
        // display result
        result_JTextField.setText(Double.toString(result));
    }
    
    
    public double add (double d1, double d2)
    {
        return d1 + d2;
    }
    public double subtract (double d1, double d2) 
     {
        return d1 - d2;
    }
            
    public double multiply (double d1, double d2)
    {
        return d1 * d2;
    }
            
    public double divide (double d1, double d2)
    {
            if (d2 !=0)
            {
                return d1/d2;
            }
            else
            {
                return 0;
            }
    }
    public static void main(String[] args) 
    {
       SwingUtilities.invokeLater(new Runnable()
       {
           public void run()
           {
               Swing_Calculator sCalc = new Swing_Calculator();
               
           }
       });
    }
    
}
