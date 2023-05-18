import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class APanel extends JFrame{
	
	JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	ImageIcon img;
	
	
	public APanel(){
		this.setTitle("Admin Panel");
		this.setSize(400,650);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBackground(null);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,400,650);
		panel.setBackground(Color.lightGray);
		
		img = new ImageIcon(getClass().getResource("icon.png"));
		
		btn1 = new JButton("Add Librarian");
		btn1.setBounds(120,30,150,40);
		
		btn5 = new JButton("Delete Librarian");
		btn5.setBounds(120,100,150,40);
		
		btn2 = new JButton("Add Clark");
		btn2.setBounds(120,170,150,40);
		
		btn6 = new JButton("Delete Clark");
		btn6.setBounds(120,240,150,40);
		
		btn3 = new JButton("Search Book");
		btn3.setBounds(120,310,150,40);
		
		btn4 = new JButton("View Librarian");
		btn4.setBounds(120,380,150,40);
		
		btn7 =new JButton("View Clark");
		btn7.setBounds(120,450,150,40);
		
		btn8 = new JButton(img);
		btn8.setBounds(0,0,30,30);
		
		btn9 = new JButton("Register Admin");
		btn9.setBounds(120,520,150,40);
		
		
		ImageIcon icon1 = new ImageIcon(getClass().getResource("image5.jpg"));
		JLabel lebel = new JLabel(icon1);
		lebel.setBounds(0,0,400,600);
		
		
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(btn7);
		panel.add(btn9);
		
		panel.add(lebel);
		panel.add(btn8);
		this.add(panel);
		LBCAction lbc = new LBCAction();
		btn1.addActionListener(lbc);
		CBAction cbc = new CBAction();
		btn2.addActionListener(cbc);
		BAction ba = new BAction();
		btn4.addActionListener(ba);
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
				
				
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
					Statement stmt=con.createStatement();
					
				    ResultSet rs = stmt.executeQuery("select * from book where name like '%"+name+"%'");
					
					if(rs.next() == false)
					{
						JOptionPane.showMessageDialog(null,"No Book Found");
					}
					else
					{
						rs.beforeFirst();
						int i=0;
						while(rs.next()){
							int j = 0;
							
							data[i][j++]=rs.getString("name");
							data[i][j++]=rs.getString("isbn");
							data[i][j++]=rs.getString("quantity");
							i++;
							
						}
						window.setVisible(true); 
					}
					
				}catch(Exception ee){System.out.println(ee);}
			}
		});
		
		btn5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String bbook = JOptionPane.showInputDialog(null,"Enter Librarian name");
				Admin aa = new Admin();
				aa.DeleteLib(bbook);
				
			}
		});
		btn6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String bbook = JOptionPane.showInputDialog(null,"Enter Clark name");
				Admin ab = new Admin();
				ab.DeleteClrk(bbook);
				
			}
		});
		
		btn7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String [] columns = new String[] {"name", "id", "age","location","Username","Password"};
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
				window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				window.setLocationRelativeTo(null);
				window.setVisible(true); 
				
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
					Statement stmt=con.createStatement();
				    ResultSet rs = stmt.executeQuery("select * from clark");
					
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
		btn8.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			APanel.this.dispose();
			Login.txt1.setText("");
			Login.pf.setText("");
		}
		
		});
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				int confirmed = JOptionPane.showConfirmDialog(null,"Are You Sure You Want to exit ?","Exit Confirmation Message",JOptionPane.YES_NO_OPTION);
				if(confirmed == JOptionPane.YES_OPTION)
				{
					APanel.this.dispose();
					
					Login.pf.setText("");
					Login.txt1.setText("");
				}
				else
				{
					APanel.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		btn9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				int age;
				
				JFrame frm = new JFrame();
				frm.setTitle("Admin Registration Form");
				frm.setSize(400,650);
				frm.setLocationRelativeTo(null);
				frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frm.setLayout(null);
				JTextField tf1,tf2,tf3,tf4,tf5,tf6;
				JLabel lb1,lb2,lb3,lb4,lb5,lb6;
				
				JPanel pnl = new JPanel();
				pnl.setLayout(null);
				pnl.setBounds(0,0,400,650);
				lb1 = new JLabel("Name :");
				lb1.setBounds(50,50,150,50);
				
				lb2 = new JLabel("ID :");
				lb2.setBounds(50,120,150,50);
				
				lb3 = new JLabel("Age :");
				lb3.setBounds(50,190,150,50);
				
				lb4 =new JLabel("Location :");
				lb4.setBounds(50,260,150,50);
				
				lb5 = new JLabel("Username :");
				lb5.setBounds(50,330,150,50);
				
				lb6 = new JLabel("Password :");
				lb6.setBounds(50,400,150,50);
				
				tf1 = new JTextField();
				tf1.setBounds(200,50,150,40);
				
				tf2 = new JTextField();
				tf2.setBounds(200,120,150,40);
				
				tf3 = new JTextField("0");
				age = Integer.parseInt(tf3.getText());
				tf3.setBounds(200,190,150,40);
				tf3.setText("");
				
				tf4 = new JTextField();
				tf4.setBounds(200,260,150,40);
				
				tf5 = new JTextField();
				tf5.setBounds(200,330,150,40);
				
				tf6 = new JTextField();
				tf6.setBounds(200,400,150,40);
				
				JButton bton = new JButton("Save");
				bton.setBounds(140,480,150,50);
				
				pnl.add(lb1);
				pnl.add(lb2);
				pnl.add(lb3);
				pnl.add(lb4);
				pnl.add(lb5);
				pnl.add(lb6);
				pnl.add(tf1);
				pnl.add(tf2);
				pnl.add(tf3);
				pnl.add(tf4);
				pnl.add(tf5);
				pnl.add(tf6);
				pnl.add(bton);
				frm.add(pnl);
				frm.setVisible(true);
				
				bton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(tf1.getText().isEmpty()||tf2.getText().isEmpty()||tf3.getText().isEmpty()||tf4.getText().isEmpty()||tf5.getText().isEmpty()||tf6.getText().isEmpty())
						{
							JOptionPane.showMessageDialog(null,"One of the Text Field is Empty");
						}
						else
						{
							Admin ob = new Admin();
							ob.AddNewAdmin(tf1.getText(),tf2.getText(),age,tf4.getText(),tf5.getText(),tf6.getText());
							frm.dispose();
						}
					}
				});
			}
		});
	}
	public class LBCAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			LibrarianForm lform = new LibrarianForm();
			lform.setVisible(true);
		}
	}
	public class CBAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ClarkForm cform = new ClarkForm();
			cform.setVisible(true);
		}
	}
	
	public class BAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String [] columns = new String[] {"name", "id", "age","location","Username","Password"};
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
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			window.setLocationRelativeTo(null);
			window.setVisible(true); 
			
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
				Statement stmt=con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from librarian");
				
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
		
	}
	
	
	
}
