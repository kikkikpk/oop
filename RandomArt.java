// Student information for assignemnt.
// Student 1 Name:
// Student 1 UTEID:
// Student 1 email: 

// Student 2 Name:
// Student 2 UTEID:
// Student 2 email: 

// Slip days used:

// replace <Student1> and <Student2> with your names
// stating this is your own work.
// On our (my) honor <Student1> and <Student2> this
// assignmentis our (my) own work.

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class RandomArt {
  
  public static void main(String[] args) {
    
    ArtFrame f = new ArtFrame();
    f.start();
  }
} // end of RandomArt class

class ArtFrame extends JFrame {
  
  private ArtPanel thePanel;
  private JLabel theCurrentExpression;
  
  private static final int EQUATION_FONT_SIZE = 16;
  private static final int UPPER_LEFT_CORNER = 100;
  
  public ArtFrame(){
    setTitle("Assignment 4 - Random Art");
    setLocation(UPPER_LEFT_CORNER, UPPER_LEFT_CORNER);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // add the menu for Colored Art options
    setJMenuBar(createMenu());
    
    // create panel with buttons
    thePanel = new ArtPanel();
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(getButton("New Gray", false));
    buttonPanel.add(getButton("New Color", true));
    
    // create the label with the current random expression
    theCurrentExpression = new JLabel(thePanel.getExpressionAsString());
    theCurrentExpression.setFont(new Font("Serif", Font.PLAIN, EQUATION_FONT_SIZE));
    
    
    // add components to frame
    add(thePanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);
    add(theCurrentExpression, BorderLayout.NORTH);
    pack();
    
  }
  
  // create menu options for which method is used
  // to create colored random art. Students must implemement
  // at least two different ways of generating a random
  // art image with color.
  private JMenuBar createMenu() {
    final int NUM_OPTIONS = ArtPanel.NUM_COLOR_OPTIONS;
    JMenuBar menu = new JMenuBar();
    final String label = "Color Option";
    JMenu colorOptions = new JMenu(label);
    menu.add(colorOptions);
    // add the options. Must connect listeners for when these
    // options are selected. When activated the menu option
    // will update the panel with the new color option.
    for(int i = 0; i < NUM_OPTIONS; i++) {
      JMenuItem temp = colorOptions.add(label + " " + (i + 1));
      
      // CS324e students: add and change as necessary
    }
    return menu;
  }
  
  
  
  
  public JButton getButton(String label, final boolean makeColor){
    JButton result = new JButton(label);
    
    // CS324e students: add and change as necessary
    
    return result;
  }
  
  public void start(){
    setVisible(true);
  }
} // end of ArtFrame class

class ArtPanel extends JPanel   {
  
  // CS324e students. 
  // Add class constants and instance variables here
  
  public static final int SIZE = 400;
  public static final int NUM_COLOR_OPTIONS = 2;
  private static final double pi = Math.PI;
  
  private RandomExpression exp;
  
  
  
  public ArtPanel(){ 
    setPreferredSize(new Dimension(SIZE, SIZE));
    
    // samples of interesting grayscale formulas
    // xCySM
    // yCCSxxMSSAS, interesting 4 deep formula
    // yxMSSCS, another interesting 4 deep formula
    // yCSSSxxACySyyAAACM, yet another interesting 4 deep
    // xxMCxyMSASS one more good 4 deep
    // xCxSAxCSMSSSQSCyCSSSCMS
    
    // default expression
    //exp = new RandomExpression("CCCSAxxACSSxCAyCyxASASCAyCCAyyyAAxMSxCxCAxSySMMCMCSMSCS");
    exp = new RandomExpression("A");
    // CS324e students: add and change as necessary
  }
  
  
  
  public String getExpressionAsString() {
    String result =  "Gray Scale Equation: " + exp.toString();
    
    // CS324e students: add and change as necessary
    
    return result;
  }
  
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    
    
    // CS324e students: add and change as necessary
    g2.setColor(Color.GREEN);
    g2.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
    
    for(int i=0 ; i<getWidth() ; i++) {
      for(int j=0 ; j<getHeight() ; j++) {
        
        double x = ((((double) i) / getWidth()) * 2.0) - 1.0;
        double y = ((((double) j) / getHeight()) * 2.0) - 1.0;
        
        int red   = exprToInt(exprRed(x,y));
        int green = exprToInt(exprGreen(x,y));
        int blue  = exprToInt(exprBlue(x,y));
        int shade = (int)((double)x/(double)getWidth()*255);
        //System.out.println(blue);
        
        //Color color = new Color(red,green,blue);
        Color color = new Color(shade,shade,blue);
        g2.setColor(color);
        g2.fillRect(i,j,i,j);
      }
    }
    
  }
  
  // CS324e students: add methods as necessary
  
  public double exprRed(double num1, double num2) {
    double x = (double)num1;
    double y = (double)num2;
    return sin(pi * avg((((cos(pi * (sin(pi * cos(pi * x)) * avg(avg(x,y), sin(pi * y)))) * avg(sin(pi * (sin(pi * x) * (y * x))), cos(pi * cos(pi * (y * y))))) * sin(pi * (sin(pi * (sin(pi * y) * sin(pi * y))) * cos(pi * ((y * y) * sin(pi * y)))))) * sin(pi * avg(cos(pi * avg(((y * x) * (x * x)), sin(pi * (y * x)))), sin(pi * avg(avg(sin(pi * x), avg(x, x)), sin(pi * avg(x, y))))))), cos(pi * cos(pi * avg(sin(pi * sin(pi * avg((x * x), (x * x)))), sin(pi * sin(pi * sin(pi * sin(pi * y)))))))));
  }
  
  public double exprGreen(double num1, double num2) {
    double x = (double)num1;
    double y = (double)num2;
    return sin(pi * ((avg(avg(cos(pi * (cos(pi * cos(pi * y)) * (cos(pi * y) * avg(y, x)))), ((cos(pi * cos(pi *x)) * (cos(pi * x) * (x * y))) * sin(pi * sin(pi * avg(y, y))))), cos(pi * (avg(sin(pi * sin(pi * x)), sin(pi * sin(pi * x))) * sin(pi * sin(pi * (x * y)))))) * avg((avg(cos(pi * sin(pi * cos(pi * x))), avg((sin(pi * x) * cos(pi * y)), avg(cos(pi * x), cos(pi * x)))) * avg(avg(sin(pi * cos(pi * x)), sin(pi * sin(pi * x))), (avg(cos(pi * x), avg(y, x)) * avg(sin(pi * y), sin(pi * x))))), (cos(pi * cos(pi * (avg(y, y) * (y * x)))) * cos(pi * cos(pi * sin(pi * avg(x, x))))))) * sin(pi * avg(avg(sin(pi * cos(pi * sin(pi * cos(pi * x)))), avg(sin(pi * cos(pi * cos(pi * y))), ((sin(pi * y) * (x * y)) * cos(pi * (y * y))))), cos(pi * avg(((cos(pi * y) * (y * y)) * avg(sin(pi * y), cos(pi * y))), (((x * x) * avg(y, x)) * cos(pi * sin(pi * x)))))))));
    
  }
  
  public double exprBlue(double num1, double num2) {
    double x = (double)num1;
    double y = (double)num2;
    return avg(sin(pi * (avg(cos(pi * avg((cos(pi * (y * x)) * cos(pi * (x * y))), avg(avg((y * x), avg(x, y)), avg(cos(pi * y), cos(pi * x))))), avg(avg(avg((sin(pi * y) * (x * y)), sin(pi * (x * x))), avg(((x * x) * sin(pi * y)), (avg(x, x) * sin(pi * y)))), avg((cos(pi * sin(pi * y)) * cos(pi * avg(x, x))), sin(pi * avg(sin(pi * y), sin(pi * y)))))) * cos(pi * avg(avg(avg(sin(pi * (x * x)), avg(sin(pi * y), sin(pi * x))), cos(pi * avg(cos(pi * y), avg(y, x)))), (((avg(x, y) * cos(pi * x)) * cos(pi * avg(y, x))) * avg(cos(pi * (y * x)), ((x * x) * (y * x)))))))), avg(((((sin(pi * sin(pi * avg(x, x))) * avg(avg(sin(pi * y), sin(pi * y)), avg(avg(x, x), cos(pi * y)))) * sin(pi * sin(pi * sin(pi * (y * y))))) * avg(cos(pi * avg(avg(avg(x, y), (y * x)), cos(pi * sin(pi * x)))), (sin(pi * sin(pi * sin(pi * x))) * cos(pi * ((y * y) * cos(pi * x)))))) * avg(cos(pi * cos(pi * sin(pi * cos(pi * avg(x, y))))), (sin(pi * (cos(pi * avg(y, x)) * sin(pi * cos(pi * x)))) * ((sin(pi * cos(pi * y)) * avg(avg(x, x), cos(pi * x))) * avg((sin(pi * x) * avg(y, x)), sin(pi * sin(pi * x))))))), ((cos(pi * cos(pi * (sin(pi * (y * y)) * cos(pi * cos(pi * x))))) * avg(sin(pi * avg(cos(pi * sin(pi * y)), (cos(pi * x) * avg(x, x)))), cos(pi * cos(pi * cos(pi * avg(x, y)))))) * sin(pi * (avg((cos(pi * (y * y)) * cos(pi * sin(pi * y))), avg(((x * x) * sin(pi * x)), cos(pi * sin(pi * y)))) * avg(sin(pi * (avg(y, x) * avg(x, x))), cos(pi * avg((y * y), avg(y, y)))))))));
  }
  
  public int exprToInt(double num){
    return (int)((num +1) * 255/2);
  }
  
  public double avg(double... num) {
    double sum = 0;
    for(int i=0 ; i<num.length ; i++) {
      sum = sum + num[i];
    }
    return sum / num.length;
  }
  
  public double cos(double num) {
    return Math.cos(num);
  }
  
  public double sin(double num) {
    return Math.sin(num);
  }
  
} // end of ArtPanel class

class RandomExpression {
  // TODO FOR MIKE. Really need to implement operators as a
  // seperate class. As is, adding operators is a pain.
  // multiway if else structure in getResult()
  // is a dead give away that
  // operators should represented as objects.
  // The multiway else if is an antipattern!
  
  
  // CS324E students add you operator here.
  // each char represents a possible operator;
  // S = sin, C = cos, A = average, M = multiply
  // operators with a single operand come first
  // operators with two operands come after all the
  // single operand operators
  // NOTE!! If single operand operator is added must update
  // SINGLE_OPERAND_OPERATORS constant!
  // Must update getResult method as well.
  
  private static final String OPERATORS = "SCAM";
  
  // functions that take a single operand
  private static final String SINGLE_OPERAND_OPERATORS = "SC";
  
  private static final String OPERANDS = "xy";
  
  // probability that operand will be another expression
  // instead of a primitive
  private final double PROBABILITY_OPERAND_IS_EXPRESSION;
  
  
  // String representation of expression. Shown is postfix
  // notation to make for easier evaluation
  private String randExpression;
  
  // higher number means more complex
  // lowest allowed value = 0
  private final int EXPRESSION_COMPLEXITY_LIMIT; 
  
  private static final int DEFAULT_MAX_COMPLEXITY = 10;;
  private static final double DEFAULT_PROBABILITY_USE_OPERATOR_FOR_OPERAND = 0.85;
  
  // create a new Random Expression
  // with probabilityDeeper = 0.8
  // and expressionComplexity = 10
  public RandomExpression(){
    this(DEFAULT_MAX_COMPLEXITY, DEFAULT_PROBABILITY_USE_OPERATOR_FOR_OPERAND);
  }
  
  // pre: complexity >= 0, 0 <= deeper <= 1.0
  // higher values for complexity and deeper lead to
  // more complex expresions
  public RandomExpression(int complexity, double deeper){
    EXPRESSION_COMPLEXITY_LIMIT = complexity;
    PROBABILITY_OPERAND_IS_EXPRESSION = deeper;
    do {
      randExpression = createExpression(0);
    } while(!randExpression.contains("x") 
              || !randExpression.contains("y"));
  }
  
  // a way to create a hard coded expression
  public RandomExpression(String s){
    EXPRESSION_COMPLEXITY_LIMIT = -1;
    PROBABILITY_OPERAND_IS_EXPRESSION = -1;        
    randExpression = s;
  }
  
  
  // - used to create a random expression
  // - chooses operator and operands at random
  // - opearand may be simple x and / or y, or it may
  // move deeper so the operand is another equation
  private String createExpression(int currentLevel){
    int op = (int)(Math.random() * OPERATORS.length());
    int oper1 = (int)(Math.random() * 2);
    int oper2 = (int)(Math.random() * 2);
    String result = OPERATORS.substring(op, op + 1);
    boolean deeperFirstOperand = Math.random() < PROBABILITY_OPERAND_IS_EXPRESSION;
    boolean deeperSecondOperand = Math.random() < PROBABILITY_OPERAND_IS_EXPRESSION;
    
    // single operand operators such as sin or cosine
    if(isSingleOperandOperator(result)){
      // base case, operands are simple values, x or y
      if(!deeperFirstOperand || currentLevel == EXPRESSION_COMPLEXITY_LIMIT) {
        result = OPERANDS.charAt(oper1) +  result;
      }
      // recursive case, operand is another expression
      else{
        result = createExpression(currentLevel + 1) +  result;
      }
    }
    else{
      // two operands operators such as multiple or average
      // base case, operands are simple values, x or y
      if(currentLevel == EXPRESSION_COMPLEXITY_LIMIT || (!deeperFirstOperand && !deeperSecondOperand)){
        result = OPERANDS.charAt(oper1) + "" + OPERANDS.charAt(oper2) + result;
      }
      // first opearnd is simple value, second is another expression
      else if(!deeperFirstOperand){
        result = OPERANDS.charAt(oper1) +  createExpression(currentLevel + 1) + result;
      }
      // second opearnd is simple value, first is another expression
      else if(!deeperSecondOperand){
        result = createExpression(currentLevel + 1) + OPERANDS.charAt(oper2) + result;
      }
      // both operands are complex expressions
      else{
        result = createExpression(currentLevel + 1) + createExpression(currentLevel + 1) + result;
      }
    }
    return result;
  }
  
  private boolean isSingleOperandOperator(String operator) {
    return SINGLE_OPERAND_OPERATORS.contains(operator);
  }
  
  // called to get result of expression at a given
  // value of x and y.
  // pre: -1.0 <= x <= 1.0, -1.0 <= y <= 1.0, 
  // post: return a value between -1.0 and 1.0, inclusive
  public double getResult(double x, double y){
    Stack<Double> operands = new Stack<Double>();
    for(int i = 0; i < randExpression.length(); i++){
      char ch = randExpression.charAt(i);
      if(ch == 'x')
        operands.push(x);
      else if(ch == 'y')
        operands.push(y);
      else{
        // operator
        double op1 = operands.pop();
        if(ch == 'S')
          operands.push(Math.sin(Math.PI * op1));
        else if(ch == 'C')
          operands.push(Math.cos(Math.PI * op1));
        else if(ch == 'M')
          operands.push(op1 * operands.pop());
        else if (ch == 'A')
          operands.push(ave(op1, operands.pop()));
        // CS324E students
        // add else if branch for new operator(s) here
      }
    }
    assert operands.size() == 1 : operands.size();
    double result = operands.pop();
    result = (result < -1.0) ? -1.0 : (result > 1.0) ? 1.0 : result;
    assert -1.0 <= result && result <= 1.0 : result;
    return result;
  }
  
  private static double ave(double x, double y){
    return (x + y) / 2.0;
  }
  
  public String toString(){
    return randExpression;
  }
  
  // from random art, test method
  public static double getValExp(double x, double y){
    return Math.sin(Math.PI * Math.sin(Math.PI * Math.sin(Math.PI * (Math.sin(Math.PI * Math.sin(Math.PI * Math.sin(Math.PI * Math.sin(Math.PI * Math.cos(Math.PI * y))))) * Math.cos(Math.PI * Math.sin(Math.PI * Math.cos(Math.PI * ave(Math.sin(Math.PI * y), (x * x)))))))));
  }
  
  // simple by hand test
  public static double getValueHardCoded(double x, double y){
    double pi = Math.PI;
    return Math.sin(pi * Math.cos(pi * Math.cos(pi * Math.sin(pi * ave(Math.cos(pi * y),y) * Math.sin(pi * x * y )))));
  } 
}

// Interesting Equations:
//yCCSxxMSSAS, interesting 4 deep formula
//yxMSSCS, another interesting 4 deep formula
//yCSSSxxACySyyAAACM, yet another interesting 4 deep
//xxMCxyMSASS one more good 4 deep
//yCxCCASxQSySACxSCMSSCASC
// samples of interesting grayscale formulas
// exp = new RandomExpression("xCySM");
// yCCSxxMSSAS, interesting 4 deep formula
// yxMSSCS, another interesting 4 deep formula
// initial hard coded xxACSSxCAyCyxASASCAyCCAyyyAAxMSxCxCAxSySMMCMCSMSCS
// exp = new RandomExpression("xxACSSxCAyCyxASASCAyCCAyyyAAxMSxCxCAxSySMMCMCSMSCS");
// exp = new RandomExpression("xSSySCAQSC");
// exp = new RandomExpression("yyAxxMAxMCyCxASSACSSxxSAxSSMxyAyxMAyCSAASSCASS");
