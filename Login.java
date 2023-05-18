import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;

class Login extends JFrame{
	
	ImageIcon icon;
	JLabel lbl1,lbl2;
	static JTextField txt1;
	static JPasswordField pf;
	JButton btn;
	Font f,f1;
	Cursor cursor;
	
	private static final String username ="Admin";
	private static final String password = "admin123";
	public static String entredUName ;
	public static String entredPass ;
	public static String l_password;
	private ImageIcon img;
	
	
	Login(){
		this.setTitle("Library Management System");
		this.setSize(400,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		Color c = new Color(210,210,210);
		Color cc = new Color(133,22,34);
		img = new ImageIcon(getClass().getResource("login.jpg"));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,400,500);
		f = new Font("Arial",Font.BOLD,14);
		f1 =new Font("Edwardian Script ITC",Font.BOLD,30);
		
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		lbl1 = new JLabel("UserName :");
		lbl1.setBounds(100,140,80,30);
		lbl1.setFont(f);
		lbl1.setForeground(c);
		
		lbl2 = new JLabel("Password :");
		lbl2.setBounds(100,200,80,30);
		lbl2.setFont(f);
		lbl2.setForeground(c);
		
		txt1 = new JTextField();
		txt1.setBounds(200,140,100,30);
		
		pf = new JPasswordField();
		pf.setBounds(200,200,100,30);
		
		btn = new JButton(img);
		btn.setBounds(130,260,116,36);
		btn.setCursor(cursor);
		
		icon =new ImageIcon(getClass().getResource("book.png"));
		this.setIconImage(icon.getImage());
		
		ImageIcon icon1 = new ImageIcon(getClass().getResource("image2.jpg"));
		JLabel lebel = new JLabel(icon1);
		
		JLabel lbl3 = new JLabel("Library Management System");
		lbl3.setBounds(30,10,360,80);
		lbl3.setFont(f1);
		lbl3.setForeground(Color.white);
		
		
		panel.add(lbl1);
		panel.add(lbl2);
		panel.add(lbl3);
		panel.add(txt1);
		panel.add(pf);
		panel.add(btn);
		lebel.setBounds(0,0,400,500);
		panel.add(lebel);
		this.add(panel);
		
		this.entredUName = txt1.getText();
		this.entredPass = String.valueOf(pf.getPassword());
		
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(txt1.getText().isEmpty() || pf.getPassword().length == 0)
				{
					JOptionPane.showMessageDialog(null,"Username or password field is empty");
				}
				else
				{
					Librarian li =new Librarian();
					li.usernamecheck(txt1.getText());
					l_password=li.password;
					
					Clark cl = new Clark();
					cl.usernamecheck(txt1.getText());
					String c_password=cl.password;
					
					Member m =new Member();
					m.usernamecheck(txt1.getText());
					String me_password=m.eepassword;
					
					Admin a = new Admin();
					a.usernamecheck(txt1.getText());
					String a_password=a.Apassword;
					
					if(String.valueOf(pf.getPassword()).equals(l_password))
					{
						LPanel l = new LPanel();
						l.setVisible(true);
					}
					else if(String.valueOf(pf.getPassword()).equals(cl.password))
					{
						CPanel cp = new CPanel();
						cp.setVisible(true);
					}
					else if(txt1.getText().equals("Admin")&&String.valueOf(pf.getPassword()).equals("admin123"))
					{
						APanel p = new APanel();
						p.setVisible(true);
					}
					else if(String.valueOf(pf.getPassword()).equals(me_password))
					{
						MPanel mp = new MPanel();
						mp.setVisible(true);
					}
					else if(String.valueOf(pf.getPassword()).equals(a_password))
					{
						NAPanel n = new NAPanel();
						n.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"UserName or Password is Wrong","Warning Message",-1);
					}
				}
			}
			
		});
		pf.addKeyListener(new KeyListener(){
			public void keyPressed( KeyEvent e ) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					if(txt1.getText().isEmpty() || pf.getPassword().length == 0)
					{
						JOptionPane.showMessageDialog(null,"Username or password field is empty");
					}
					else
					{
						Librarian li =new Librarian();
						li.usernamecheck(txt1.getText());
						l_password=li.password;
						
						Clark cl = new Clark();
						cl.usernamecheck(txt1.getText());
						String c_password=cl.password;
						
						Member m =new Member();
						m.usernamecheck(txt1.getText());
						String me_password=m.eepassword;
						
						Admin a = new Admin();
						a.usernamecheck(txt1.getText());
						String a_password=a.Apassword;
						
						if(String.valueOf(pf.getPassword()).equals(l_password))
						{
							LPanel l = new LPanel();
							l.setVisible(true);
						}
						else if(String.valueOf(pf.getPassword()).equals(cl.password))
						{
							CPanel cp = new CPanel();
							cp.setVisible(true);
						}
						else if(txt1.getText().equals("Admin")&&String.valueOf(pf.getPassword()).equals("admin123"))
						{
							APanel p = new APanel();
							p.setVisible(true);
						}
						else if(String.valueOf(pf.getPassword()).equals(me_password))
						{
							MPanel mp = new MPanel();
							mp.setVisible(true);
						}
						else if(String.valueOf(pf.getPassword()).equals(a_password))
						{
							NAPanel n = new NAPanel();
							n.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"UserName or Password is Wrong","Warning Message",-1);
							pf.setText("");
							txt1.setText("");
						}
					}
					
				}
			}
			
			public void keyReleased( KeyEvent evt ) {
			}
			
			public void keyTyped( KeyEvent evt ) {
			}
			
		});
		
		txt1.addKeyListener(new KeyListener(){
			public void keyPressed( KeyEvent e ) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					if(txt1.getText().isEmpty() || pf.getPassword().length == 0)
					{
						JOptionPane.showMessageDialog(null,"Username or password field is empty");
					}
					else
					{
						Librarian li =new Librarian();
						li.usernamecheck(txt1.getText());
						l_password=li.password;
						
						Clark cl = new Clark();
						cl.usernamecheck(txt1.getText());
						String c_password=cl.password;
						
						Member m =new Member();
						m.usernamecheck(txt1.getText());
						String me_password=m.eepassword;
						
						Admin a = new Admin();
						a.usernamecheck(txt1.getText());
						String a_password=a.Apassword;
						
						if(String.valueOf(pf.getPassword()).equals(l_password))
						{
							LPanel l = new LPanel();
							l.setVisible(true);
						}
						else if(String.valueOf(pf.getPassword()).equals(cl.password))
						{
							CPanel cp = new CPanel();
							cp.setVisible(true);
						}
						else if(txt1.getText().equals("Admin")&&String.valueOf(pf.getPassword()).equals("admin123"))
						{
							APanel p = new APanel();
							p.setVisible(true);
						}
						else if(String.valueOf(pf.getPassword()).equals(me_password))
						{
							MPanel mp = new MPanel();
							mp.setVisible(true);
						}
						else if(String.valueOf(pf.getPassword()).equals(a_password))
						{
							NAPanel n = new NAPanel();
							n.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"UserName or Password is Wrong","Warning Message",-1);
							pf.setText("");
							txt1.setText("");
						}
					}
					
				}
			}
			
			public void keyReleased( KeyEvent evt ) {
			}
			
			public void keyTyped( KeyEvent evt ) {
			}
			
		});
		
		
	}
}