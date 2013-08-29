package calc;


import java.awt.*;
import java.math.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.event.ActionListener;
/**
 * This is the GUI portion of the calculator project
 * 
 * @author (Jacob Miller) 
 * @version (a version number or a date)
 */
class CalcGui extends JFrame implements ActionListener 
{

    private static final long serialVersionUID = 1L;
    //Setting up null values for when you first start the calculator
    String str_number = "";
    String operation = "";
    
    double number1 = 0;
    double number2 = 0;
    String number1_str = "";
    String number2_str = "";
    double savedNumber = 0;
    public static final double EPS = 0.00000001;
    
    double result = 0;
    
    //Definition of buttons, placing textfield at the top of the calculator
    
     TextField txt=new TextField("0",15);
    
    JButton btn7 = new JButton("7");
    JButton btn8 = new JButton("8");
    JButton btn9 = new JButton("9");
    JButton btnAdd = new JButton("+");
    JButton btnLog = new JButton("log");
    JButton btnCos = new JButton("Cos");
    JButton btnPi = new JButton("PI");
    
    JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5");
    JButton btn6 = new JButton("6");
    JButton btnSubtract = new JButton("-");
    JButton btnPower = new JButton("PWR");
    JButton btnRound = new JButton("RND");
    JButton btnNegate = new JButton("+/-");
    JButton btnDecimal = new JButton(".");
    JButton btnSave = new JButton("SAVE");
    JButton btnLoad = new JButton("LOAD");
    
    
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btnMultiply = new JButton("*");
    JButton btnAbsolute = new JButton("abs");
    JButton btnSquareRoot = new JButton("SQRT");
    
    
    JButton btn0 = new JButton("0");
    JButton btnClear = new JButton("CLR");
    JButton btnEquals = new JButton("=");
    JButton btnDelete = new JButton("DEL");
    JButton btnDivide = new JButton("/");
    JButton btnSin = new JButton("Sin");
    JButton btnTangent = new JButton("Tan");
    
    JFrame frame = new JFrame("Calculator");

public CalcGui() 
{
        //setting up the window for the calculator
        
        frame.setSize(550,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        frame.setLayout(new BorderLayout());
        //defining a headpanel to display the calculations, and a Number panel to display the buttons
        JPanel HeadPanel = new JPanel();
        JPanel NumberPanel = new JPanel();
        
        
        
        HeadPanel.setBackground(Color.white);
        
        NumberPanel.setLayout(new GridLayout(5,6));
        
        //Declaring the placement of the buttons, begins at top left of Window right to left
        
        NumberPanel.add(btn7);
        btn7.addActionListener(this);
        NumberPanel.add(btn8);
        btn8.addActionListener(this);
        NumberPanel.add(btn9);
        btn9.addActionListener(this);
        NumberPanel.add(btnAdd);
        btnAdd.addActionListener(this);
        NumberPanel.add(btnLog);
        btnLog.addActionListener(this);
        
   
        NumberPanel.add(btn4);
        btn4.addActionListener(this);
        NumberPanel.add(btn5);
        btn5.addActionListener(this);
        NumberPanel.add(btn6);
        btn6.addActionListener(this);
        NumberPanel.add(btnSubtract);
        btnSubtract.addActionListener(this);
        NumberPanel.add(btnPower);
        btnPower.addActionListener(this);
        
   
         NumberPanel.add(btn1);
        btn1.addActionListener(this);
        NumberPanel.add(btn2);
        btn2.addActionListener(this);
        NumberPanel.add(btn3);
        btn3.addActionListener(this);
        NumberPanel.add(btnMultiply);
        btnMultiply.addActionListener(this);
        NumberPanel.add(btnAbsolute);
        btnAbsolute.addActionListener(this);
       
        
        NumberPanel.add(btnDecimal);
        btnDecimal.addActionListener(this);
        NumberPanel.add(btn0);
        btn0.addActionListener(this);
        NumberPanel.add(btnNegate);
        btnNegate.addActionListener(this);
        NumberPanel.add(btnDivide);
        btnDivide.addActionListener(this);
        NumberPanel.add(btnSin);
        btnSin.addActionListener(this);
       
        NumberPanel.add(btnCos);
        btnCos.addActionListener(this);
        NumberPanel.add(btnPi);
        btnPi.addActionListener(this);
        NumberPanel.add(btnTangent);
        btnTangent.addActionListener(this);
        NumberPanel.add(btnSquareRoot);
        btnSquareRoot.addActionListener(this);
        NumberPanel.add(btnRound);
        btnRound.addActionListener(this);
     

        //setting up the top of the GUI for display of calculations
        HeadPanel.add(new JLabel("NUMBER : "));
        HeadPanel.add(txt);
        HeadPanel.add(btnEquals);
        HeadPanel.add(btnClear);
        HeadPanel.add(btnDelete);
        HeadPanel.add(btnSave);
        HeadPanel.add(btnLoad);
        btnEquals.addActionListener(this);
        btnClear.addActionListener(this);
        btnDelete.addActionListener(this);
        btnSave.addActionListener(this);
        btnLoad.addActionListener(this);

        txt.setEditable(false);
        
        frame.add(HeadPanel,BorderLayout.NORTH);
        frame.add(NumberPanel,BorderLayout.CENTER);
        
    }
    
    public void actionPerformed(ActionEvent b) 
    {
        String command = b.getActionCommand();
        if(Driver.isInteger(command))
        {
    		//int numToAppend= Integer.parseInt(command);
    	    number1_str = number1_str+command;
    	    txt.setText(number1_str);
    	    number1 = Double.parseDouble(txt.getText());
    	    System.out.println(number1);
        }
        else
        {
        	//command is a string
            System.out.println(command);
            if(command == "+")
            {
                if(Math.abs(number2) < EPS)
                {
                    number2 = number1;
                    txt.setText("");
                }
                else
                {
                    number2 += number1;  
                    txt.setText(String.valueOf(number2));
                }
                number1 = 0;
                number1_str = "";
                operation = "+";
            }
            if(command == "-")
            {
                if(Math.abs(number2) < EPS)
                {
                    number2 = number1;
                    txt.setText("");
                }
                else
                {
                    number2 = number2 - number1;
                    txt.setText(String.valueOf(number2));
                }
                number1 = 0;
                number1_str = "";
                operation = "-";
            }
            
            
            if(command == "*")
            {
                if(Math.abs(number2) < EPS)
                {
                    number2 = number1;
                    txt.setText("");
                }
                else
                {
                    if(operation == "+")
                        number2 += number1;
                    else if(operation == "-")
                        number2 -= number1;
                    else if(operation == "*")
                        number2 *= number1;
                    else if(operation == "/")
                    {
                        if(number1 == 0)
                        {
                            number2 /= number1;
                        }
                    }
                    number2 = number2 * number1;
                    txt.setText(String.valueOf(number2));
                }
                number1 = 0;
                number1_str = "";
                operation = "*";
            }
            
            
            if(command == "/")
            {
                if(Math.abs(number2) < EPS)
                {
                    number2 = number1;
                    txt.setText("");
                }
                else
                {
                    if(Math.abs(number1) < EPS)
                    {
                        JOptionPane.showMessageDialog(frame, "Can't Divide by 0.");
                        number1 = 0;
                        number2 = 0;
                        operation = "";
                        number1_str = "";
                        number2_str = "";
                        txt.setText(number1_str);
                    }
                    else
                    {
                        number2 = number2 / number1;
                        txt.setText(String.valueOf(number2));
                    }
                }
                number1 = 0;
                number1_str = "";
                operation = "/";
            }
            if(command == "CLR")
            {
            	clear();

            }
            if(command == "+/-")
            {
                	number1 *= -1;
                    txt.setText(String.valueOf(number1));
            }
            
            if(command == "SAVE")
            {
            		savedNumber = number1;
            }
            
            if(command == "LOAD")
            {
            	number1 = savedNumber;
            	txt.setText(String.valueOf(number1));
            }
            
            if(command == ".")
            {
                    number1_str = number1_str + ".";
                    number1 = Double.parseDouble(number1_str);
                    txt.setText(number1_str);
            }
                      
            if(command == "PI")
            {
                    number1 = Math.PI;
                    txt.setText(String.valueOf(number1)); 
            }
            
            if(command == "DEL")
            {
                if(number1_str.length() >0 && number1_str.substring(0,1) != "0" )
                {
                      
                //Remove last character from the currently displayed number
                //Update actual number
                number1_str = number1_str.substring(0,number1_str.length()-1);
                if(number1_str.equals(""))
                {
                	number1_str = "0";
                }
                number1 = Double.parseDouble(number1_str);
                txt.setText(number1_str);
                }
            }
            
            
            //Jon Hoskins Advanced Math Calculations
            if(command == "Sin")
            {             
                    number1 = Math.sin(number1);
                    txt.setText(String.valueOf(number1));
            }
           
            if(command == "Cos")
            {           
                    number1 = Math.cos(number1);
                    txt.setText(String.valueOf(number1));      
            }
           
            if(command == "Tan")
            {            
                    number1 = Math.tan(number1);
                    txt.setText(String.valueOf(number1));         
            }
           
            if(command == "abs")
            {            
                    number1 = Math.abs(number1);
                    txt.setText(String.valueOf(number1));             
            }
           
            if(command == "log")
            {             
                    number1 = Math.log10(number1);
                    txt.setText(String.valueOf(number1));         
            }
           
            if(command == "RND")
            {             
                    number1 = Math.round(number1);
                    txt.setText(String.valueOf(number1));              
            }
           
            if(command == "SQRT")
            {             
                    number1 = Math.sqrt(number1);
                    txt.setText(String.valueOf(number1));         
            }
           
            if(command == "PWR")
            {
                if(Math.abs(number2) < EPS)
                {
                    number2 = number1;
                    txt.setText("");
                }
                else
                {
                    number2 = Math.pow(number1, number2); 
                    txt.setText(String.valueOf(number2));
                }
                number1 = 0;
                number1_str = "";
                operation = "PWR";
            }
            
            
            
            
            
            
            if(command == "=")
            {
                System.out.println("Number 1:"+number1);
                System.out.println("Number 2:"+number2);
                System.out.println("Operation: "+operation);
                if(operation == "+")
                {
                    number1 = number1 + number2;
                    number1_str = Double.toString(number1);
                }
                if(operation == "-")
                {
                    number2 = number2 - number1;
                    number1_str = Double.toString(number2);
                }
                if(operation == "*")
                {
                    number1 = number1 * number2;
                    number1_str = Double.toString(number1);
                }
                if(operation == "/")
                {
                    //If user is trying to divide by zero, tell 'em no!
                    if(Math.abs(number1) < EPS)
                    {
                        JOptionPane.showMessageDialog(frame, "Can't Divide by 0.");
                        clear();
                    }
                    else
                    {
                        number1 = number2 / number1;
                        number1_str = Double.toString(number1);
                    }
                }
                
                
                
                txt.setText(number1_str);
                number2 = 0;
                number2_str = "";
            }
        }

    }
 
    private void clear()
    {
        number1 = 0;
        number2 = 0;
        operation = "";
        number1_str = "";
        number2_str = "";
        txt.setText("0");
    }

    
    
}
