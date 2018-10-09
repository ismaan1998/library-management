import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;

class Admin extends JFrame implements ActionListener
{
	JLabel background;
	JLabel heading_text;
	JPanel heading;
	JPanel login;
	ImageIcon background_img;
	JPanel sidepanel;
	JPanel add_librarian;
	JPanel view_librarian;
	JPanel del_librarian;
	JPanel change_password;
	JButton add_lib, del_lib, view_lib, change_pass;
	JTextField input_name, input_password, input_userid;
	JButton add_lib_button;
	JTextField input_userid_2;
	JButton delete;
	JTextField input_userid_3, input_confirm_password, input_password_2;
	JButton change_pass_button;
	JButton logout;
	JLabel user_info;
	
	
	Admin()
	{
		
		//fonts
		Font head = new Font("TimesRoman", Font.BOLD, 50);
		Font text = new Font("Verdana", Font.BOLD, 16);
		Font panel_heading = new Font("Verdana", Font.CENTER_BASELINE ,20);
		
		//frame
		setSize(800,600);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//background 
		
		background = new JLabel("");
		background_img = new ImageIcon("background.png");
		Image img = background_img.getImage();
		Image temp_img = img.getScaledInstance(800,600,Image.SCALE_SMOOTH);
		background_img = new ImageIcon(temp_img);
		background.setIcon(background_img);
		background.setBounds(0,0,800,600);
		add(background);

		
		//heading
		heading  = new JPanel();
		heading.setLayout(null);
		heading.setBounds(0,0,800,120);
		heading_text = new JLabel("Book Shelf", SwingConstants.CENTER);
		heading_text.setBounds(230,0,400,150);
		heading_text.setForeground(Color.WHITE);
		heading.setBackground(new Color(0,0,0,80));
		heading_text.setFont(head);
		heading.add(heading_text);	
		background.add(heading);

		
		//side panel
		sidepanel = new JPanel();
		sidepanel.setLayout(null);
		sidepanel.setBackground(new Color(0,0,0, 90));
		sidepanel.setBounds(0,120,200,480);
		background.add(sidepanel);
		
		add_lib = new JButton("Add Librarian");
		add_lib.setBounds(0,0,200,40);
		add_lib.setBackground(new Color(51,153,255));
		add_lib.setFont(text);
		add_lib.setForeground(Color.WHITE);
		add_lib.addActionListener(this);
		sidepanel.add(add_lib);
		
			view_lib = new JButton("View Librarians");
		view_lib.setBounds(0,45,200,40);
		view_lib.setBackground(new Color(51,153,255));
		view_lib.setFont(text);
		view_lib.setForeground(Color.WHITE);
		view_lib.addActionListener(this);
		sidepanel.add(view_lib);
		
		del_lib = new JButton("Delete Librarian");
		del_lib.setBounds(0,90,200,40);
		del_lib.setBackground(new Color(51,153,255));
		del_lib.setFont(text);
		del_lib.setForeground(Color.WHITE);
		del_lib.addActionListener(this);
		sidepanel.add(del_lib);
		
		
		change_pass = new JButton("Change Password");
		change_pass.setBounds(0,135,200,40);
		change_pass.setBackground(new Color(51,153,255));
		change_pass.setFont(text);
		change_pass.setForeground(Color.WHITE);
		change_pass.addActionListener(this);
		sidepanel.add(change_pass);
		
		logout= new JButton("Log out");
		logout.setBounds(0,180,200,40);
		logout.setBackground(new Color(51,153,255));
		logout.setFont(text);
		logout.setForeground(Color.WHITE);
		sidepanel.add(logout);
		logout.addActionListener(this);
		
		//add Librarian
		add_librarian = new JPanel();
		background.add(add_librarian);
		add_librarian.setBackground(new Color(0,0,0,0));
		add_librarian.setBounds(201,130,600,450);
		add_librarian.setLayout(null);
		
		
		
		JLabel heading_1 = new JLabel("Add Librarian");
		heading_1.setForeground(Color.WHITE);
		heading_1.setFont(panel_heading);
		heading_1.setBounds(170,0,300,50);
		add_librarian.add(heading_1);
		
		JLabel enter_name = new JLabel("Enter name");
		add_librarian.add(enter_name);
		enter_name.setBounds(100,100,150,50);
		enter_name.setFont(text);
		enter_name.setForeground(Color.WHITE);
		
		JLabel enter_userid = new JLabel("Enter userid");
		add_librarian.add(enter_userid);
		enter_userid.setBounds(100,150,150,50);
		enter_userid.setFont(text);
		enter_userid.setForeground(Color.WHITE);
		
		JLabel enter_password = new JLabel("Enter Password");
		add_librarian.add(enter_password);
		enter_password.setBounds(100,200,150,50);
		enter_password.setFont(text);
		enter_password.setForeground(Color.WHITE);
		
		input_name = new JTextField();
		input_name.setBounds(250,110,200,30);
		input_name.setBackground(new Color(51,153,255));
		input_name.setForeground(Color.WHITE);
		add_librarian.add(input_name);
		
		
		input_userid = new JTextField();
		input_userid.setBounds(250,160,200,30);
		input_userid.setBackground(new Color(51,153,255));
		input_userid.setForeground(Color.WHITE);
		add_librarian.add(input_userid);
		
		input_password = new JTextField();
		input_password.setBounds(250,210,200,30);
		input_password.setBackground(new Color(51,153,255));
		input_password.setForeground(Color.WHITE);
		add_librarian.add(input_password);
		
		
		add_lib_button = new JButton("Add Librarian");
		add_lib_button.setBounds(200,300,150,40);
		add_librarian.add(add_lib_button);
		add_lib_button.setBackground(new Color(51,153,255));
		add_lib_button.setForeground(Color.WHITE);
		add_lib_button.addActionListener(this);
		
		
		//view librarian
		view_librarian = new JPanel();
		background.add(view_librarian);
		view_librarian.setBackground(new Color(0,0,0,0));
		view_librarian.setBounds(201,130,600,450);
		view_librarian.setLayout(null);
		view_librarian.setVisible(false);
		
		JLabel heading_2 = new JLabel("View Librarian");
		heading_2.setForeground(Color.WHITE);
		heading_2.setFont(panel_heading);
		heading_2.setBounds(170,0,300,50);
		view_librarian.add(heading_2);
		
		
		
		
		
		
		
		//delete librarian
		del_librarian = new JPanel();
		background.add(del_librarian);
		del_librarian.setBackground(new Color(0,0,0,0));
		del_librarian.setBounds(201,130,600,450);
		del_librarian.setLayout(null);
		del_librarian.setVisible(false);
		
		JLabel heading_3 = new JLabel("Delete Librarian");
		heading_3.setForeground(Color.WHITE);
		heading_3.setFont(panel_heading);
		heading_3.setBounds(170,0,300,50);
		del_librarian.add(heading_3);
		
		JLabel enter_userid_2 = new JLabel("Enter user-id");
		del_librarian.add(enter_userid_2);
		enter_userid_2.setBounds(100,100,150,50);
		enter_userid_2.setFont(text);
		enter_userid_2.setForeground(Color.WHITE);
		
		input_userid_2 = new JTextField();
		input_userid_2.setBounds(230,110,200,30);
		input_userid_2.setBackground(new Color(51,153,255));
		input_userid_2.setForeground(Color.WHITE);
		del_librarian.add(input_userid_2);
		
		delete = new JButton("Delete");
		delete.setBounds(200,250,150,40);
		del_librarian.add(delete);
		delete.setBackground(new Color(51,153,255));
		delete.setForeground(Color.WHITE);
		delete.addActionListener(this);
		
		
		
		//change password
		change_password = new JPanel();
		background.add(change_password);
		change_password.setBackground(new Color(0,0,0,0));
		change_password.setBounds(201,130,600,450);
		change_password.setLayout(null);
		change_password.setVisible(false);
		
		JLabel heading_4 = new JLabel("Change Password");
		heading_4.setForeground(Color.WHITE);
		heading_4.setFont(panel_heading);
		heading_4.setBounds(150,0,300,50);
		change_password.add(heading_4);
		
		
		
			
		JLabel enter_userid_3 = new JLabel("Enter user-Id");
		change_password.add(enter_userid_3);
		enter_userid_3.setBounds(80,100,200,50);
		enter_userid_3.setFont(text);
		enter_userid_3.setForeground(Color.WHITE);
		
		JLabel enter_new_password = new JLabel("Enter new password");
		change_password.add(enter_new_password);
		enter_new_password.setBounds(80,150,200,50);
		enter_new_password.setFont(text);
		enter_new_password.setForeground(Color.WHITE);
		
		JLabel confirm_password = new JLabel("Confirm new Password");
		change_password.add(confirm_password);
		confirm_password.setBounds(80,200,250,50);
		confirm_password.setFont(text);
		confirm_password.setForeground(Color.WHITE);
		
		
		input_userid_3 = new JTextField();
		input_userid_3.setBounds(300,110,200,30);
		input_userid_3.setBackground(new Color(51,153,255));
		input_userid_3.setForeground(Color.WHITE);
		change_password.add(input_userid_3);
		
		input_password_2 = new JTextField();
		input_password_2.setBounds(300,160,200,30);
		input_password_2.setBackground(new Color(51,153,255));
		input_password_2.setForeground(Color.WHITE);
		change_password.add(input_password_2);
		
		input_confirm_password = new JTextField();
		input_confirm_password.setBounds(300,210,200,30);
		input_confirm_password.setBackground(new Color(51,153,255));
		input_confirm_password.setForeground(Color.WHITE);
		change_password.add(input_confirm_password);
		
		
		change_pass_button = new JButton("Change password");
		change_pass_button.setBounds(200,300,150,40);
		change_password.add(change_pass_button);
		change_pass_button.setBackground(new Color(51,153,255));
		change_pass_button.setForeground(Color.WHITE);
		change_pass_button.addActionListener(this);
		
	
		
		
		setVisible(true);
	
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{


		//side panel button
		if(ae.getSource() == add_lib)
		{
			add_librarian.setVisible(true);
			view_librarian.setVisible(false);
			del_librarian.setVisible(false);
			change_password.setVisible(false);
		}
		
		//side panel button
		else if(ae.getSource() == view_lib)
		{
			add_librarian.setVisible(false);
			view_librarian.setVisible(true);
			del_librarian.setVisible(false);
			change_password.setVisible(false);		
		
			JTable table = new JTable(0,0);
			table.setEnabled(false);
			DefaultTableModel model = new DefaultTableModel(0,0);
		
			String header[] = new String[] {"User ID", "Name","Password", "type"};
			model.setColumnIdentifiers(header);
			table.setModel(model);
		
		
		
	
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshelf", "root", "inderjit");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select *from login where type='user';");
				while(rs.next())
				{	
					model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
				}
			}
			catch(Exception e)
			{
			
			}
		
		JScrollPane table_pane = new JScrollPane(table); 
		table_pane.setBounds(50,50,500,380);
		table.setBackground(new Color(30,144,255));
		table.setForeground(Color.WHITE);
		view_librarian.add(table_pane);	
		
		}
		
		
		//side panel button
		else if(ae.getSource() == del_lib)
		{
			add_librarian.setVisible(false);
			view_librarian.setVisible(false);
			del_librarian.setVisible(true);
			change_password.setVisible(false);			
		}
		

		//side panel button
		else if(ae.getSource() == change_pass)
		{
			add_librarian.setVisible(false);
			view_librarian.setVisible(false);
			del_librarian.setVisible(false);
			change_password.setVisible(true);			
		}

		//side panel button
		else if(ae.getSource() == logout)
		{
			setVisible(false);

		}

		//add librarian button 
		else if(ae.getSource() == add_lib_button)
		{
			
			if(input_userid.getText().equals("") || input_name.getText().equals("") || input_password.getText().equals(""))
		
			{
					JOptionPane.showMessageDialog(null, "please fill each field");
					return;
			}
			
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshelf","root","inderjit");	
			String query_to_execute = "insert into login values('"+ input_userid.getText() +"', '" + input_name.getText() + "', '" + input_password.getText() +  "', 'user');";
			Statement st = con.createStatement();
			st.executeUpdate(query_to_execute);
			JOptionPane.showMessageDialog(null, "new account added");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "user already exist");
			return;
		}
		}

		
		//delete librarian button
		else if(ae.getSource() == delete)
		{
			
			
			if(input_userid_2.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "please enter an User Id");
				return;
			}
			
			
				try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshelf","root","inderjit");
			Statement st = con.createStatement();
			
			String query_to_execute = "delete from login where user_id = '"+ input_userid_2.getText() + "';";
			int status = st.executeUpdate(query_to_execute);
			if(status == 1)
			{
				JOptionPane.showMessageDialog(null, "Account Removed!!");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"No account found");
			}
			
			
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		

		//change password button
		else if(ae.getSource() == change_pass_button)
		{
			if(input_userid_3.getText().equals("") || input_password_2.getText().equals("") || input_confirm_password.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "please fill all the fields");
				return;
			}
			
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshelf","root","inderjit");	
			String query_to_execute = "update login set password ='" + input_password_2.getText() + "'where user_id = '" + input_userid_3.getText()+"';";
			Statement st = con.createStatement();
			int status = st.executeUpdate(query_to_execute);
			if(status == 1)
			{
				JOptionPane.showMessageDialog(null, "Password changed");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "user not found");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e+"");
			return;
		}
		}


		
	}


	
	
}
