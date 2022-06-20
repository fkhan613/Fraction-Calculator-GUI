import java.awt.*; 
import java.awt.event.*;  
import javax.swing.*;    

public class FractionGUI extends JFrame {

    //define the components
    public JPanel screen;
    public JButton addBtn;
    public JButton subBtn;
    public JButton multiBtn;
    public JButton divBtn;
    public JTextField num1;
    public JTextField den1;
    public JTextField num2;
    public JTextField den2;
    public Label num1Lbl;
    public Label num2Lbl;
    public Label den1Lbl;
    public Label den2Lbl;
    public Label newFractionLbl;

    //constructor
    FractionGUI(){
        createComponents();
        addComponents();
        setDimensions();
        addActionListeners();
    }

    private void setDimensions(){
        // Exit program if close-window button clicked
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        // "super" Frame sets its title
        this.setTitle("Fraction Calculator");
        // "super" Frame sets its initial window size
        this.setSize(500, 200);
        this.setPreferredSize(new Dimension(500,200));
        // "super" Frame shows 
        this.setVisible(true); 

        //set the dimensions of the components
        num1.setPreferredSize(new Dimension(25,20));
        num2.setPreferredSize(new Dimension(25,20));
        den1.setPreferredSize(new Dimension(25,20));
        den2.setPreferredSize(new Dimension(25,20));
        addBtn.setPreferredSize(new Dimension(45,40));
        subBtn.setPreferredSize(new Dimension(45,40));
        multiBtn.setPreferredSize(new Dimension(45,40));
        divBtn.setPreferredSize(new Dimension(45,40));
        newFractionLbl.setPreferredSize(new Dimension(400,40));
    }

    private void addActionListeners(){
        BtnListener listener = new BtnListener();
        addBtn.addActionListener(listener);
        subBtn.addActionListener(listener);
        multiBtn.addActionListener(listener);
        divBtn.addActionListener(listener);
    }

    private void createComponents(){
        //create the screen & buttons
        screen = new JPanel();
        screen.setLayout(new FlowLayout());
        addBtn = new JButton("+");
        subBtn = new JButton("-");
        multiBtn = new JButton("×");
        divBtn = new JButton("÷");
        num1 = new JTextField("");
        den1 = new JTextField("");
        num2 = new JTextField("");
        den2 = new JTextField("");
        num1Lbl = new Label("Numerator 1");
        num2Lbl = new Label("Numerator 2");
        den1Lbl = new Label("Denominator 1");
        den2Lbl = new Label("Denominator 2");
        newFractionLbl = new Label("");
    }

    //this method adds the compnents to the screen
    private void addComponents(){
        //add buttons to screen
        screen.add(num1Lbl);
        screen.add(num1);
        screen.add(den1Lbl);
        screen.add(den1);
        screen.add(new Label("                                                      "));
        screen.add(num2Lbl);
        screen.add(num2);
        screen.add(den2Lbl);
        screen.add(den2);
        screen.add(new Label("                                                      "));
        screen.add(new Label("                                 "));
        screen.add(addBtn);
        screen.add(subBtn);
        screen.add(multiBtn);
        screen.add(divBtn);
        screen.add(new Label("                                   "));
        screen.add(newFractionLbl);
        this.add(screen);
    }

    private void clearBox(){
        num1.setText("");
        num2.setText("");
        den1.setText("");
        den2.setText("");
    }
    
    
    // Define an inner class to handle the button-clicks
    private class BtnListener implements ActionListener {
        int numerator1, numerator2, denominator1, denenominator2;
        // ActionEvent handler - Called back upon button-click.
        public void actionPerformed(ActionEvent evt) {
            //try to parse the string to a int
            try{
                numerator1 = Integer.parseInt(num1.getText());
                numerator2 = Integer.parseInt(num2.getText());
                denominator1 = Integer.parseInt(den1.getText());
                denenominator2 = Integer.parseInt(den2.getText());
                
            }catch(Exception e){
                newFractionLbl.setText("ONLY ENTER WHOLE NUMBERS");
            }
            
            Fraction f1 = new Fraction(numerator1,denominator1);

            if(evt.getSource() == addBtn){
                Fraction addedFrac = f1.add(new Fraction(numerator2,denenominator2));
                addedFrac.reduce();
                newFractionLbl.setText("New Reduced Fraction: " + addedFrac.toString());
                clearBox();
            }
            if(evt.getSource() == subBtn){
                Fraction subbedFrac = f1.subtract(new Fraction(numerator2,denenominator2));
                subbedFrac.reduce();
                newFractionLbl.setText("New Reduced Fraction: " + subbedFrac.toString());
                clearBox();
            }
            if(evt.getSource() == multiBtn){
                Fraction multiFrac = f1.times(new Fraction(numerator2,denenominator2));
                multiFrac.reduce();
                newFractionLbl.setText("New Reduced Fraction: " + multiFrac.toString());
                clearBox();
            } 
            if(evt.getSource() == divBtn){
                Fraction divFrac = f1.divide(new Fraction(numerator2,denenominator2));
                divFrac.reduce();
                newFractionLbl.setText("New Reduced Fraction: " + divFrac.toString());
                clearBox();
            }
        }
    }
}
