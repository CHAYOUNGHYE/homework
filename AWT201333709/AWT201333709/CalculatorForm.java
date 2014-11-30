package calculator;

import java.awt.BorderLayout;

import java.awt.Component;
 import java.awt.Container;
 import java.awt.GridBagConstraints;
 import java.awt.GridBagLayout;
 import java.awt.GridLayout;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;

import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.JTextField;

public class CalculatorForm extends JFrame implements ActionListener {
  
  private static final long serialVersionUID = 1L;
  
  private Container ct;
  private GridLayout gl1, gl2;
  private GridBagLayout gb;
  private GridBagConstraints cc;
  
  private JPanel jp1, jp2, jp3;
  private JTextField jf;
  private JButton backspace, cls;
  private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
  private JButton bna, bgob, bmi, bpl, bper, bresult;
  
  private String operand, oprator = null;
  
  public CalculatorForm(String title){
   super(title);
   init();
  }
  private void init(){
   gl1 = new GridLayout(1, 1, 5, 5);
   jp1 = new JPanel(gl1);
   jf = new JTextField();
   jf.setHorizontalAlignment(JTextField.RIGHT);//오른쪽에서부터 글순  
   jf.setEditable(false);//수정불가
  jp1.add(jf);
   
   gl2 = new GridLayout(1, 2, 5, 5);
   jp2 = new JPanel(gl2);
   backspace = new JButton("backspace");
   cls = new JButton("C");
   jp2.add(backspace);
   jp2.add(cls);

  gb = new GridBagLayout();
   cc = new GridBagConstraints();
   cc.fill = GridBagConstraints.BOTH;
   jp3 = new JPanel(gb);
   b1 = new JButton("1");
   b2 = new JButton("2");
   b3 = new JButton("3");
   b4 = new JButton("4");
   b5 = new JButton("5");
   b6 = new JButton("6");
   b7 = new JButton("7");
   b8 = new JButton("8");
   b9 = new JButton("9");
   b0 = new JButton("0");  
   bna = new JButton("/");
   bgob = new JButton("*");
   bmi = new JButton("-");
   bpl = new JButton("+");
   bresult = new JButton("=");
 
 
   

  layout(b7, 0, 0, 1, 1);
   layout(b8, 1, 0, 1, 1);
   layout(b9, 2, 0, 1, 1);
   layout(bna, 3, 0, 1, 1);
  
  layout(b4, 0, 1, 1, 1);
   layout(b5, 1, 1, 1, 1);
   layout(b6, 2, 1, 1, 1);
   layout(bgob, 3, 1, 1, 1);
   
   layout(b1, 0, 2, 1, 1);
   layout(b2, 1, 2, 1, 1);
   layout(b3, 2, 2, 1, 1);
   layout(bmi, 3, 2, 1, 1);
   layout(bresult, 4, 2, 1, 2);
   
   layout(b0, 1, 3, 1, 1);
   layout(bpl, 3, 3, 1, 1);
     
   ct = this.getContentPane();
   ct.setLayout(new BorderLayout(5, 5));
   ct.add(jp1, BorderLayout.NORTH);
   ct.add(jp2, BorderLayout.CENTER);
   ct.add(jp3, BorderLayout.SOUTH);
   

  backspace.addActionListener(this);
   cls.addActionListener(this);
   b1.addActionListener(this);
   b2.addActionListener(this);
   b3.addActionListener(this);
   b4.addActionListener(this);
   b5.addActionListener(this);
   b6.addActionListener(this);
   b7.addActionListener(this);
   b8.addActionListener(this);
   b9.addActionListener(this);
   b0.addActionListener(this);
   bna.addActionListener(this);
   bgob.addActionListener(this);
   bmi.addActionListener(this);
   bpl.addActionListener(this);
   bresult.addActionListener(this);
 
   this.pack();//자동크기
  this.setResizable(false);//사이즈변경불가
  this.setVisible(true);
   
   this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  @Override
  public void actionPerformed(ActionEvent ae) {

  Object obj = ae.getSource();
   String text = jf.getText();
   if(obj == backspace){
    if(text.length() != 0){
     text = text.substring(0, text.length()-1);
     jf.setText(text);
    }
    
   }else if(obj == cls){
    operand = null;
    oprator = null;
    jf.setText("");
    
   }else if(obj == b1 || obj == b2 || obj == b3 || obj == b4 || obj == b5 || obj == b6 || obj == b7 || obj == b8 || obj == b9 || obj == b0){
    JButton btn = (JButton)obj;
    text += btn.getText();
    jf.setText(text);
    
   }else if(obj == bna || obj == bgob || obj == bmi || obj == bpl){
    operand = text;
    jf.setText("");
    System.out.println(operand);
    JButton btn = (JButton)obj;
    oprator = btn.getText();
    
   }else if(obj == bresult){
    if(oprator != null){
     char c = oprator.charAt(0);
     System.out.println(c);
     Double one = Double.parseDouble(operand);
     Double two = Double.parseDouble(text);
     Double re = 0D;
     switch(c){
     case '/' : re = one / two; break;
     case '*' : re = one * two; break;
     case '-' : re = one - two; break;
     case '+' : re = one + two; break;
      default :
       break;
     }

    String result = re + "";
     jf.setText(result);
    }
 
   }  
  }
  private void layout(Component comp, int x, int y, int width, int height){
   cc.gridx = x;//컴포넌트 x좌표(위치)
   cc.gridy = y;//컴포넌트 y좌표(위치)
   cc.gridwidth = width;//컴포넌트 넓이
  cc.gridheight = height;//컴포넌트 높이
  jp3.add(comp, cc);
  }
  
  public static void main (String [] arg){
   new CalculatorForm("Calculator66666666666666666666666666666666666");
  }
 }
