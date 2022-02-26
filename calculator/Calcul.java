import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.*;  
import javax.swing.*;
//import javax.swing.text.JTextComponent;
public class Calcul implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButton=new JButton[9];
    JButton addButton,subButton,mulButton ,divButton,decButton,clrButton,negButton,
            eqButton,delButton;
    JPanel panel ;
    Font myFont=new Font("Ink Free",Font.BOLD,30);
    double number1=0,number2=0, result=0;
    boolean test=false;
    char operator ;
    Calcul(){
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        textField=new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");

        decButton=new JButton(".");
        eqButton =new JButton("=");
        delButton=new JButton("del");
        clrButton=new JButton("clr");
        negButton=new JButton("(-)");

        functionButton[0]=addButton;
        functionButton[1]=subButton;
        functionButton[2]=mulButton;
        functionButton[3]=divButton;
        functionButton[4]=decButton;
        functionButton[5]=eqButton;
        functionButton[6]=delButton;
        functionButton[7]=clrButton;
        functionButton[8]=negButton;

        for(int i=0 ; i<9 ;i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
            if(i>=6){
                functionButton[i].setBackground(new Color(70,164,182));
            }
            else{
                functionButton[i].setBackground(new Color(0,206,209));
            }
        }

        for(int i=0 ; i<10 ; i++){
            numberButton[i]=new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);;
            numberButton[i].setFocusable(false);
            numberButton[i].setFont(myFont);
        }

        
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);
        negButton.setBounds(50,430,100,50);
        
        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(subButton);
        panel.add(divButton);
        panel.add(numberButton[0]);
        panel.add(eqButton);
        panel.add(decButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(clrButton);
        frame.add(delButton);
        frame.add(textField);
        frame.setVisible(true);

    }
    // Methods 
    public void actionPerformed(ActionEvent e ){
        for(int i=0 ; i<10 ; i++){
            if(e.getSource()==numberButton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource()==addButton){
             number1=Double.parseDouble(textField.getText());
             operator='+';
             textField.setText("");
        }
        
        if(e.getSource()==subButton){
            number1=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }

        if(e.getSource()==mulButton){
            number1=Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }
        if(e.getSource()==divButton){
            number1=Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }
        if(e.getSource()==eqButton){
            number2=Double.parseDouble(textField.getText());
            switch(operator){
                case '+' : result=number1+number2; break;
                case '-' : result=number1-number2; break;
                case '*' : result=number1*number2; break;
                case '/' : if(number2!=0){
                             result=number1/number2;
                           }
                           else{
                               test=true;
                           }
                            
            }

            if(test){
                textField.setText("error");
            }
            else{
                textField.setText(String.valueOf(result));
                 number1=result;
    
            }
        }
        if(e.getSource()==clrButton){
            textField.setText("");
        }

        if(e.getSource()==delButton){
            String string=textField.getText();
            textField.setText("");
            for(int i=0 ; i<string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if(e.getSource()==negButton){
             double temps=Double.parseDouble(textField.getText());
             temps*=-1;
             textField.setText(String.valueOf(temps));

        }
        

 
 
 
    }
     
}
 