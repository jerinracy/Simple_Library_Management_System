import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class MPanel extends JFrame{
	
	JButton btn1,btn2,btn3,btn4,btn5,btn6;
	String name,id,location,username;
	int age;
	
	public MPanel(){
		this.setTitle("Member Panel");
		this.setSize(400,550);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,400,550);
		panel.setBackground(Color.lightGray);
		
		btn1 = new JButton("View Profile");
		btn1.setBounds(120,80,150,50);
		
		btn2 = new JButton("Show All Books");
		btn2.setBounds(120,150,150,50);
		
		btn3 = new JButton("Search Book");
		btn3.setBounds(120,220,150,50);
		
		btn4 = new JButton("Borrow Book");
		btn4.setBounds(120,290,150,50);
		
		btn5 = new JButton("Return Book");
		btn5.setBounds(120,360,150,50);
		
		btn6 = new JButton("Profile");
		btn6.setBounds(120,430,150,50);
		
		ImageIcon icon1 = new ImageIcon(getClass().getResource("image3.jpg"));
		JLabel lebel = new JLabel(icon1);
		lebel.setBounds(0,0,400,600);
		
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(lebel);
		this.add(panel);
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String epassword = JOptionPane.showInputDialog(null,"Enter Your Password");
				String [] columns = new String[] {"name", "id", "age","location","username","password"};
				String [][] data =new String[100][100];
				
				JTable table =new JTable(data,columns);
				
				table.setDragEnabled(true);
				table.setDropMode(DropMode.INSERT_ROWS);
				table.setFillsViewportHeight(true);
				TransferHandler dnd = new TransferHandler() {

				};
				
				table.setTransferHandler(dnd);
				JScrollPane scroll = new JScrollPane(table);

			  
				JFrame window = new JFrame();
				window.getContentPane().add(scroll);
				window.pack();
				window.setLocationRelativeTo(null);
				window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				window.setVisible(true); 
				
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
					Statement stmt=con.createStatement();
				    ResultSet rs = stmt.executeQuery("select * from member where password = '"+epassword+"'");
					
					rs.beforeFirst();
					int i=0;
					while(rs.next()){
						int j = 0;
						
						data[i][j++]=rs.getString("name");
						data[i][j++]=rs.getString("id");
						data[i][j++]=rs.getString("age");
						data[i][j++]=rs.getString("location");
						data[i][j++]=rs.getString("username");
						data[i][j++]=rs.getString("password");
						i++;
						
					}
					
				}catch(Exception ee){System.out.println(ee);}
			}
		});
		
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String [] columns = new String[] {"name","isbn","quantity"};
				String [][] data =new String[100][100];
				
				JTable table =new JTable(data,columns);
				
				table.setDragEnabled(true);
				table.setDropMode(DropMode.INSERT_ROWS);
				table.setFillsViewportHeight(true);
				TransferHandler dnd = new TransferHandler() {

				};
				
				table.setTransferHandler(dnd);
				JScrollPane scroll = new JScrollPane(table);

			  
				JFrame window = new JFrame();
				window.getContentPane().add(scroll);
				window.pack();
				window.setLocationRelativeTo(null);
				window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				window.setVisible(true); 
				
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
					Statement stmt=con.createStatement();
					
				    ResultSet rs = stmt.executeQuery("select * from book");
					
					rs.beforeFirst();
					int i=0;
					while(rs.next()){
						int j = 0;
						
						data[i][j++]=rs.getString("name");
						data[i][j++]=rs.getString("isbn");
						data[i][j++]=rs.getString("quantity");
						i++;
						
					}
					
				}catch(Exception ee){System.out.println(ee);}
			}
		});
		btn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String name = JOptionPane.showInputDialog(null,"Book Name");
				String [] columns = new String[] {"name","isbn","quantity"};
				String [][] data =new String[100][100];
				
				JTable table =new JTable(data,columns);
				
				table.setDragEnabled(true);
				table.setDropMode(DropMode.INSERT_ROWS);
				table.setFillsViewportHeight(true);
				TransferHandler dnd = new TransferHandler() {

				};
				
				table.setTransferHandler(dnd);
				JScrollPane scroll = new JScrollPane(table);

			  
				JFrame window = new JFrame();
				window.getContentPane().add(scroll);
				window.pack();
				window.setLocationRelativeTo(null);
				window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				window.setVisible(true); 
				
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
					Statement stmt=con.createStatement();
					
				    ResultSet rs = stmt.executeQuery("select * from book where name = '"+name+"'");
					
					rs.beforeFirst();
					int i=0;
					while(rs.next()){
						int j = 0;
						
						data[i][j++]=rs.getString("name");
						data[i][j++]=rs.getString("isbn");
						data[i][j++]=rs.getString("quantity");
						i++;
						
					}
					
				}catch(Exception ee){System.out.println(ee);}
			}
		});
		
		btn4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String bbook = JOptionPane.showInputDialog(null,"Enter Book name");
				Books bk = new Books();
				bk.BorrowBook(bbook);
				
			}
		});
		btn5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String rbook = JOptionPane.showInputDialog(null,"Enter Book name");
				Books bk = new Books();
				bk.ReturnBook(rbook);
				
			}
		});
		
		btn6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				JFrame frm = new JFrame();
				frm.setTitle("Member Profile");
				frm.setSize(400,550);
				frm.setLocationRelativeTo(null);
				frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frm.setLayout(null);
				JButton button1,button2;
				JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
				
				ImageIcon img1 = new ImageIcon(getClass().getResource("profile.png"));
				
				
				
				
				String tpass = JOptionPane.showInputDialog(null,"Input Your Password","Password ",-1);
				Member tmp = new Member();
				tmp.getPassword(Login.txt1.getText());
				String tmppass= tmp.ppassword;
				
				
				if(tmppass.isEmpty()||tmppass.equals("")|| !tmppass.equals(tpass))
				{
					JOptionPane.showMessageDialog(null,"Wrong Password");
				}
				else
				{
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("SELECT `name`,`id`,`age`,`location`,`username` FROM `member` WHERE `username` ="+"'"+Login.txt1.getText()+"'");
						rs.next();
						name = rs.getString(1);
						id = rs.getString(2);
						age = rs.getInt(3);
						location = rs.getString(4);
						username = rs.getString(5);
						
						con.close();
						
					}catch(Exception ee){System.out.println(e);}	
					
					JPanel pnl = new JPanel();
					pnl.setBounds(0,0,400,550);
					pnl.setLayout(null);
					
					Font ff = new Font("Arial",Font.BOLD,14);
					
					l1 =new JLabel("Name :");
					l1.setBounds(50,30,100,50);
					l1.setFont(ff);
					
					l2 =new JLabel(name);
					l2.setBounds(220,30,100,50);
					l2.setFont(ff);
					
					l3 = new JLabel("ID :");
					l3.setBounds(50,100,100,50);
					l3.setFont(ff);
					
					l4 = new JLabel(id);
					l4.setBounds(220,100,100,50);
					l4.setFont(ff);
					
					l5 = new JLabel("Age :");
					l5.setBounds(50,170,100,50);
					l5.setFont(ff);
					
					l6 = new JLabel(String.valueOf(age));
					l6.setBounds(220,170,100,50);
					l6.setFont(ff);
					
					l7 = new JLabel("Location :");
					l7.setBounds(50,240,100,50);
					l7.setFont(ff);
					
					l8 = new JLabel(location);
					l8.setBounds(220,240,100,50);
					l8.setFont(ff);
					
					l9 = new JLabel("UserName :");
					l9.setBounds(50,310,100,50);
					l9.setFont(ff);
					
					l10 = new JLabel(username);
					l10.setBounds(220,310,100,50);
					l10.setFont(ff);
					
					button1 = new JButton("Back");
					button1.setBounds(50,430,150,50);
					
					button2 = new JButton(img1);
					button2.setBounds(220,430,150,50);
					
					ImageIcon icon1 = new ImageIcon(getClass().getResource("image5.jpg"));
					JLabel lebel = new JLabel(icon1);
					lebel.setBounds(0,0,400,550);
					
					pnl.add(button1);
					pnl.add(button2);
					pnl.add(l1);
					pnl.add(l2);
					pnl.add(l3);
					pnl.add(l4);
					pnl.add(l5);
					pnl.add(l6);
					pnl.add(l7);
					pnl.add(l8);
					pnl.add(l9);
					pnl.add(l10);
					pnl.add(lebel);
					
					frm.add(pnl);
					frm.setVisible(true);
					
					button1.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							frm.dispose();
						}
						
					});
					button2.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							
							JTextField tf1,tf2,tf3,tf4,tf5;
							JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8;
							JButton btn;
							JPasswordField pf1,pf2;
							JFrame frame = new JFrame();
							frame.setTitle("Member Profile Update Form");
							frame.setSize(400,600);
							frame.setLocationRelativeTo(null);
							frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							frame.setLayout(null);
							
							JPanel panel = new JPanel();
							panel.setLayout(null);
							panel.setBounds(0,0,400,600);
							panel.setBackground(Color.black);
							
							lbl1 = new JLabel("Name :");
							lbl1.setBounds(50,10,100,50);
							lbl1.setForeground(Color.white);
							
							lbl2 =new JLabel("ID");
							lbl2.setBounds(50,80,100,50);
							lbl2.setForeground(Color.white);
							
							lbl3 = new JLabel("Age :");
							lbl3.setBounds(50,150,100,50);
							lbl3.setForeground(Color.white);
							
							lbl4 = new JLabel("Location :");
							lbl4.setBounds(50,220,100,50);
							lbl4.setForeground(Color.white);
							
							lbl5 = new JLabel("UserName :");
							lbl5.setBounds(50,290,100,50);
							lbl5.setForeground(Color.white);
							
							lbl6 = new JLabel("Password");
							lbl6.setBounds(50,360,100,50);
							lbl6.setForeground(Color.white);
							
							lbl7 =new JLabel("Retype Password");
							lbl7.setBounds(50,430,100,50);
							lbl7.setForeground(Color.white);
							
							tf1 = new JTextField(name);
							tf1.setBounds(200,10,150,30);
							
							tf2 = new JTextField(id);
							tf2.setBounds(200,80,150,30);
							
							tf3 = new JTextField(String.valueOf(age));
							tf3.setBounds(200,150,150,30);
							
							tf4 = new JTextField(location);
							tf4.setBounds(200,220,150,30);
							
							lbl8 = new JLabel(username);
							lbl8.setBounds(200,290,150,50);
							lbl8.setForeground(Color.white);
							
							pf1 = new JPasswordField();
							pf1.setBounds(200,360,150,30);
							pf1.setText(String.valueOf(Login.pf.getPassword()));
							
							pf2 = new JPasswordField();
							pf2.setBounds(200,430,150,30);
							pf2.setText(String.valueOf(Login.pf.getPassword()));
							
							btn = new JButton("Update");
							btn.setBounds(120,490,150,50);
							
							panel.add(tf1);
							panel.add(tf2);
							panel.add(tf3);
							panel.add(tf4);
							panel.add(pf1);
							panel.add(btn);
							panel.add(lbl1);
							panel.add(lbl2);
							panel.add(lbl3);
							panel.add(lbl4);
							panel.add(lbl5);
							panel.add(lbl6);
							panel.add(lbl7);
							panel.add(lbl8);
							panel.add(pf2);
							
							frame.add(panel);
							frame.setVisible(true);
							
							btn.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									
									if(tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty() || tf4.getText().isEmpty() || pf1.getPassword().length == 0||pf2.getPassword().length == 0)
									{
										JOptionPane.showMessageDialog(null,"One Of The Text-field is empty");
									}
									else
									{
										if(String.valueOf(pf1.getPassword()).equals(String.valueOf(pf2.getPassword())))
										{
											Member mm = new Member();
											mm.updateInfo(tf1.getText(),tf2.getText(),tf3.getText(),tf4.getText(),String.valueOf(Login.txt1.getText()),String.valueOf(pf1.getPassword()));
											
											try{
												Class.forName("com.mysql.jdbc.Driver");
												Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
												Statement stmt = con.createStatement();
												ResultSet rs = stmt.executeQuery("SELECT `name`,`id`,`age`,`location`,`username` FROM `member` WHERE `username` ="+"'"+Login.txt1.getText()+"'");
												rs.next();
												name = rs.getString(1);
												id = rs.getString(2);
												age = rs.getInt(3);
												location = rs.getString(4);
												username = rs.getString(5);
												
												con.close();
												
											}catch(Exception ee){System.out.println(e);}
											l2.setText(name);
											l4.setText(id);
											l6.setText(String.valueOf(age));
											l8.setText(location);
											frame.dispose();
											
										}
										else
										{
											JOptionPane.showMessageDialog(null,"Password didn't matched");
										}
									}
								}
							});
							
						}
					});
				}
			}
		});
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				int confirmed = JOptionPane.showConfirmDialog(null,"Are You Sure You Want to exit ?","Exit Confirmation Message",JOptionPane.YES_NO_OPTION,-1);
				if(confirmed == JOptionPane.YES_OPTION)
				{
					MPanel.this.dispose();
					Login.txt1.setText("");
					Login.pf.setText("");
				}
				else
				{
					MPanel.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		
	}
	
}