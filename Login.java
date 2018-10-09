import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Login extends JFrame implements ActionListener
{

	JLabel background;
	JLabel heading_text;
	JPanel heading;
	JPanel login;
	ImageIcon background_img;
	JTextField username;
	JPasswordField password;
	JButton admin_login, user_login;

	Login()
	{
		
		//fonts
		Font head = new Font("TimesRoman", Font.BOLD, 50);
		Font text = new Font("Verdana", Font.BOLD, 20);
		
		
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

		
		
		//Login
		login = new JPanel();
		login.setLayout(null);
		login.setBounds(200,180,400,350);
		login.setBackground(new Color(0,0,0,70));
		background.add(login);
		
		JLabel user = new JLabel("enter username");
		user.setFont(text);
		user.setForeground(Color.WHITE);
		login.add(user);
		user.setBounds(30,40,300,30);
		
		username = new JTextField();
		username.setBounds(40,80,250,30);
		username.setForeground(Color.WHITE);
		username.setBackground(new Color(51,153,255));
		login.add(username);
		
		JLabel pass = new JLabel("enter password");
		pass.setFont(text);
		pass.setForeground(Color.WHITE);
		login.add(pass);
		pass.setBounds(30,125,300,30);
		
		password = new JPasswordField();
		password.setBackground(new Color(51,153,255));
		password.setForeground(Color.WHITE);
		password.setBounds(40,165,250,30);
		login.add(password);
		
		admin_login = new JButton("Admin Login");
		admin_login.setBounds(40,240, 120, 35);
		login.add(admin_login);
		admin_login.setForeground(Color.WHITE);
		admin_login.setBackground(new Color(51,153,255));
		admin_login.addActionListener(this);
		
	
		user_login = new JButton("User Login");
		user_login.setForeground(Color.WHITE);
		user_login.setBounds(170,240, 120, 35);
		login.add(user_login);
		user_login.setBackground(new Color(51,153,255));
		user_login.addActionListener(this);
		
		
		
		
		
		
		setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		String user_name = username.getText();
			if(user_name.equals("")){
				JOptionPane.showMessageDialog(null, "Please enter user name");
				return;
			}
			String pass_word = password.getText();
			if(pass_word.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter password");
				return;
			}
			

			
		//coding for admin login button
		if(ae.getSource() == admin_login)
		{
			
			try{
			//getting database connection
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshelf","root","inderjit");
			Statement st = con.createStatement();
			String query_to_execute = "select password from login where user_id = '" + user_name +  "' and type = 'admin';";
			ResultSet rs = st.executeQuery(query_to_execute);
			String get_user = "",get_password ="";
			while(rs.next())
			{
				get_password = rs.getString(1);
			}
			
			if(pass_word.equals(get_password))
			{
				
				new Admin();
				username.setText("");
				password.setText("");

			}
			
			else{
				JOptionPane.showMessageDialog(null, "user not exist");
			}
		
			}catch(Exception e){System.out.println(e);}
		}
		
		
		//coding for user login button
		else if(ae.getSource() == user_login)
		{
			try{
			//getting database connection
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshelf","root","inderjit");
			Statement st = con.createStatement();
			String query_to_execute = "select password from login where user_id = '" + user_name +  "' and type = 'user';";
			ResultSet rs = st.executeQuery(query_to_execute);
			String get_user = "",get_password ="";
			while(rs.next())
			{
				get_password = rs.getString(1);
			}
			
			if(pass_word.equals(get_password))
			{
				
				new User();
				username.setText("");
				password.setText("");
		
			}
			
			else{
				JOptionPane.showMessageDialog(null, "user not exist");
			}
		
			}catch(Exception e){System.out.println(e);}
		}
	}
	
	
	
	
	
	
	
	public static void main(String args[])
	{
		new Login();
		
	}

	
}
