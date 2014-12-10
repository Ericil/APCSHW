import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class GUICtoF extends JFrame implements ActionListener{
    private Container pane;
    private JButton a, b;
    private JLabel l;
    private JTextField t;
    private JCheckBox c;
    /*
      imports java.awt.event.*;
      implements ActionListener -->
      public void ActionPerformed(ActionEvent)
        - looks at the action command and decide what to do
      button.addActionListener(this);
      button.setActionCommand("ID");
    */
    public GUICtoF(){
	this.setTitle("GUICtoF");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	a = new JButton("Button One");
	l = new JLabel("Text:");
	t = new JTextField(10);
	a.addActionListener(this);
	a.setActionCommand("ID");
	pane.add(l);
	pane.add(t);
	pane.add(a);
    }
    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	System.out.println(action);
	//if statements here
	//<variable>.isSelected() (for text boxes)
    }
    public static void main(String[]args){
	GUICtoF test = new GUICtoF();
	test.setVisible(true);
    }
    
}
