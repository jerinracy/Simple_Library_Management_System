import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class ClarkForm extends JFrame{
	JTextField tf1,tf2,tf3,tf4,tf5;
	JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
	JButton btn;
	JPasswordField pf1,pf2;
	int age;
	
	ClarkForm(){
		this.setTitle("Clark Registration Form");
		this.setSize(400,650);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,400,650);
		panel.setBackground(Color.black);
		
		lbl1 = new JLabel("Name :");
		lbl1.setBounds(50,30,100,50);
		lbl1.setForeground(Color.white);
		
		lbl2 =new JLabel("ID");
		lbl2.setBounds(50,100,100,50);
		lbl2.setForeground(Color.white);
		
		lbl3 = new JLabel("Age :");
		lbl3.setBounds(50,170,100,50);
		lbl3.setForeground(Color.white);
		
		lbl4 = new JLabel("Location :");
		lbl4.setBounds(50,240,100,50);
		lbl4.setForeground(Color.white);
		
		lbl5 = new JLabel("Username :");
		lbl5.setBounds(50,310,100,50);
		lbl5.setForeground(Color.white);
		
		lbl6 = new JLabel("Password");
		lbl6.setBounds(50,380,100,50);
		lbl6.setForeground(Color.white);
		
		lbl7 = new JLabel("Retype Password");
		lbl7.setBounds(50,450,100,50);
		lbl7.setForeground(Color.white);
		
		tf1 = new JTextField();
		tf1.setBounds(200,30,150,30);
		
		tf2 = new JTextField();
		tf2.setBounds(200,100,150,30);
		
		tf3 = new JTextField("0");
		this.age = Integer.parseInt(tf3.getText());
		tf3.setBounds(200,170,150,30);
		tf3.setText("");
		
		tf4 = new JTextField();
		tf4.setBounds(200,240,150,30);
		
		tf5 = new JTextField();
		tf5.setBounds(200,310,150,30);
		
		pf1 = new JPasswordField();
		pf1.setBounds(200,380,150,30);
		
		pf2 = new JPasswordField();
		pf2.setBounds(200,450,150,30);
		
		btn = new JButton("Save");
		btn.setBounds(120,520,150,50);
		
		panel.add(tf1);
		panel.add(tf2);
		panel.add(tf3);
		panel.add(tf4);
		panel.add(tf5);
		panel.add(pf1);
		panel.add(pf2);
		panel.add(btn);
		panel.add(lbl1);
		panel.add(lbl2);
		panel.add(lbl3);
		panel.add(lbl4);
		panel.add(lbl5);
		panel.add(lbl6);
		panel.add(lbl7);
		
		this.add(panel);
		CBAction cba = new CBAction();
		btn.addActionListener(cba);
	}
	public class CBAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty() || tf4.getText().isEmpty() || tf5.getText().isEmpty() || pf1.getPassword().length==0||pf2.getPassword().length==0)
			{
				JOptionPane.showMessageDialog(null,"One Of The Text-field is empty");
			}
			else
			{
				if(String.valueOf(pf1.getPassword()).equals(String.valueOf(pf2.getPassword())))
				{
					Admin ad = new Admin();
					ad.AddClark(tf1.getText(),tf2.getText(),age,tf4.getText(),tf5.getText(),String.valueOf(pf1.getPassword()));
					ClarkForm.this.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Password didn't matched");
				}
			}
			
		}
	}
}