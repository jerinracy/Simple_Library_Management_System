import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class BookForm extends JFrame{
	JTextField tf1,tf2,tf3;
	JLabel lbl1,lbl2,lbl3;
	JButton btn;
	
	BookForm(){
		this.setTitle("Book Info Form");
		this.setSize(400,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,400,600);
		panel.setBackground(Color.black);
		
		lbl1 = new JLabel("Name :");
		lbl1.setBounds(50,30,100,50);
		lbl1.setForeground(Color.white);
		
		lbl2 =new JLabel("ISBN :");
		lbl2.setBounds(50,100,100,50);
		lbl2.setForeground(Color.white);
		
		lbl3 = new JLabel("Quantity :");
		lbl3.setBounds(50,170,100,50);
		lbl3.setForeground(Color.white);
		
		tf1 = new JTextField();
		tf1.setBounds(200,30,150,50);
		
		tf2 = new JTextField();
		tf2.setBounds(200,100,150,50);
		
		tf3 = new JTextField();
		tf3.setBounds(200,170,150,50);
		
		
		btn = new JButton("Save");
		btn.setBounds(120,480,150,50);
		
		panel.add(tf1);
		panel.add(tf2);
		panel.add(tf3);
		panel.add(btn);
		panel.add(lbl1);
		panel.add(lbl2);
		panel.add(lbl3);

		
		this.add(panel);
		LBBAction lbba = new LBBAction();
		btn.addActionListener(lbba);
	}
	public class LBBAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"One Of The Text-field is empty");
			}
			else
			{
				Librarian tmp = new Librarian();
				tmp.AddBook(tf1.getText(),tf2.getText(),tf3.getText());
				BookForm.this.dispose();
			}
			
		}
	}
}