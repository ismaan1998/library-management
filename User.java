import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;

class User extends JFrame implements ActionListener
{
	JLabel background;
	JLabel heading_text;
	JPanel heading;
	JPanel login;
	ImageIcon background_img;
	JPanel sidepanel, add_del_panel, borrow_panel, view_borrow_panel, return_panel, available_panel;
	JButton add_del_button, borrow_button, view_borrow_button, return_button, available_button;
	JTextField input_book_id_1, input_name_1, input_book_id_2;
	JButton add_button, del_button;
	JTextField input_student_name, input_roll_no, input_semeseter, input_book_id_3;
	JButton issue_button;
	JTextField input_book_id_4, input_roll_no_2;
	JButton return_book;
	JButton logout;
	
	User()
	{
		
		//fonts
		Font head = new Font("TimesRoman", Font.BOLD, 50);
		Font text = new Font("Verdana", Font.BOLD, 15);
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
		
		
		add_del_button = new JButton("Add/Delete books");
		add_del_button.setBounds(0,0,200,40);
		add_del_button.setBackground(new Color(51,153,255));
		add_del_button.setFont(text);
		add_del_button.setForeground(Color.WHITE);
		sidepanel.add(add_del_button);
		add_del_button.addActionListener(this);
		
		borrow_button = new JButton("Borrow Book");
		borrow_button.setBounds(0,45,200,40);
		borrow_button.setBackground(new Color(51,153,255));
		borrow_button.setFont(text);
		borrow_button.setForeground(Color.WHITE);
		sidepanel.add(borrow_button);
		borrow_button.addActionListener(this);
		
		view_borrow_button = new JButton("View borrowed");
		view_borrow_button.setBounds(0,90,200,40);
		view_borrow_button.setBackground(new Color(51,153,255));
		view_borrow_button.setFont(text);
		view_borrow_button.setForeground(Color.WHITE);
		sidepanel.add(view_borrow_button);
		view_borrow_button.addActionListener(this);
		
		
		return_button = new JButton("Return Book");
		return_button.setBounds(0,135,200,40);
		return_button.setBackground(new Color(51,153,255));
		return_button.setFont(text);
		return_button.setForeground(Color.WHITE);
		sidepanel.add(return_button);
		return_button.addActionListener(this);
		
		
		available_button= new JButton("Available Books");
		available_button.setBounds(0,180,200,40);
		available_button.setBackground(new Color(51,153,255));
		available_button.setFont(text);
		available_button.setForeground(Color.WHITE);
		sidepanel.add(available_button);
		available_button.addActionListener(this);
		
				
		logout= new JButton("Log out");
		logout.setBounds(0,225,200,40);
		logout.setBackground(new Color(51,153,255));
		logout.setFont(text);
		logout.setForeground(Color.WHITE);
		sidepanel.add(logout);
		logout.addActionListener(this);
		
		
		//add_del_panel
		
		add_del_panel = new JPanel();
		add_del_panel.setLayout(null);
		background.add(add_del_panel);
		add_del_panel.setBounds(201,130,600,450);
		add_del_panel.setBackground(new Color(0,0,0,0));
		
		JLabel heading1 = new JLabel("Add & Delete Book");
		heading1.setForeground(Color.WHITE);
		heading1.setFont(panel_heading);
		heading1.setBounds(170,0,300,50);
		add_del_panel.add(heading1);
		
		JPanel add_panel = new JPanel();
		add_panel.setLayout(null);
		add_panel.setBackground(new Color(0,0,0,90));
		add_panel.setBounds(10,50,280,350);
		add_del_panel.add(add_panel);
		
		
		
		JPanel del_panel = new JPanel();
		del_panel.setLayout(null);
		del_panel.setBackground(new Color(0,0,0,90));
		del_panel.setBounds(300,50,280,350);
		add_del_panel.add(del_panel);
		
		JLabel enter_bookid1 = new JLabel("enter Book ID");
		enter_bookid1.setBounds(60,30,250,30);
		add_panel.add(enter_bookid1);
		enter_bookid1.setFont(text);
		enter_bookid1.setForeground(Color.WHITE);
		
		input_book_id_1 = new JTextField();
		input_book_id_1.setBounds(50,70,150,30);
		add_panel.add(input_book_id_1);
		input_book_id_1.setBackground(new Color(51,153,255));
		input_book_id_1.setForeground(Color.WHITE);
		
		
		JLabel enter_name1 = new JLabel("enter Book name");
		enter_name1.setBounds(60,130,250,30);
		add_panel.add(enter_name1);
		enter_name1.setFont(text);
		enter_name1.setForeground(Color.WHITE);
		
		
		input_name_1 = new JTextField();
		input_name_1.setBounds(25,170,230,30);
		add_panel.add(input_name_1);
		input_name_1.setBackground(new Color(51,153,255));
		input_name_1.setForeground(Color.WHITE);
		
		add_button = new JButton("Add Book");
		add_button.setBounds(50,250,150,30);
		add_button.setBackground(new Color(51,153,255));
		add_button.setForeground(Color.WHITE);
		add_panel.add(add_button);
		add_button.addActionListener(this);
		
		JLabel enter_bookid2 = new JLabel("enter Book ID");
		enter_bookid2.setBounds(60,80,250,30);
		del_panel.add(enter_bookid2);
		enter_bookid2.setFont(text);
		enter_bookid2.setForeground(Color.WHITE);
		
		
		input_book_id_2 = new JTextField();
		input_book_id_2.setBounds(25,120,230,30);
		del_panel.add(input_book_id_2);
		input_book_id_2.setBackground(new Color(51,153,255));
		input_book_id_2.setForeground(Color.WHITE);
		
		del_button = new JButton("Delete Book");
		del_button.setBounds(50,250,150,30);
		del_button.setBackground(new Color(51,153,255));
		del_button.setForeground(Color.WHITE);
		del_panel.add(del_button);
		del_button.addActionListener(this);
		
		
		//Borrow book panel
		borrow_panel = new JPanel();
		borrow_panel.setLayout(null);
		background.add(borrow_panel);
		borrow_panel.setBounds(201,130,600,450);
		borrow_panel.setBackground(new Color(0,0,0,0));
		borrow_panel.setVisible(false);
		
		JLabel heading2 = new JLabel("Borrow Book");
		heading2.setForeground(Color.WHITE);
		heading2.setFont(panel_heading);
		heading2.setBounds(170,0,300,50);
		borrow_panel.add(heading2);
		
		
		JLabel enter_student_name = new JLabel("enter Student name");
		enter_student_name.setBounds(60,80,250,30);
		borrow_panel.add(enter_student_name);
		enter_student_name.setFont(text);
		enter_student_name.setForeground(Color.WHITE);
		
		JLabel enter_roll_no = new JLabel("enter Roll No.");
		enter_roll_no.setBounds(60,120,250,30);
		borrow_panel.add(enter_roll_no);
		enter_roll_no.setFont(text);
		enter_roll_no.setForeground(Color.WHITE);
		
		JLabel enter_semester = new JLabel("enter Semester");
		enter_semester.setBounds(60,160,250,30);
		borrow_panel.add(enter_semester);
		enter_semester.setFont(text);
		enter_semester.setForeground(Color.WHITE);
		
		JLabel enter_bookid3 = new JLabel("Enter Book ID");
		enter_bookid3.setBounds(60,200,250,30);
		borrow_panel.add(enter_bookid3);
		enter_bookid3.setFont(text);
		enter_bookid3.setForeground(Color.WHITE);
		
		input_student_name = new JTextField();
		input_student_name.setBounds(250,80,230,30);
		borrow_panel.add(input_student_name);
		input_student_name.setBackground(new Color(51,153,255));
		input_student_name.setForeground(Color.WHITE);
		
		input_roll_no = new JTextField();
		input_roll_no.setBounds(250,120,230,30);
		borrow_panel.add(input_roll_no);
		input_roll_no.setBackground(new Color(51,153,255));
		input_roll_no.setForeground(Color.WHITE);
		
		
		input_semeseter = new JTextField();
		input_semeseter.setBounds(250,160,230,30);
		borrow_panel.add(input_semeseter);
		input_semeseter.setBackground(new Color(51,153,255));
		input_semeseter.setForeground(Color.WHITE);
		
		input_book_id_3 = new JTextField();
		input_book_id_3.setBounds(250,200,230,30);
		borrow_panel.add(input_book_id_3);
		input_book_id_3.setBackground(new Color(51,153,255));
		input_book_id_3.setForeground(Color.WHITE);
		
			
		issue_button = new JButton("Issue Book");
		issue_button.setBounds(160,300,150,30);
		issue_button.setBackground(new Color(51,153,255));
		issue_button.setForeground(Color.WHITE);
		borrow_panel.add(issue_button);
		issue_button.addActionListener(this);
		
		//view_borrow_panel 
		view_borrow_panel = new JPanel();
		view_borrow_panel.setLayout(null);
		background.add(view_borrow_panel);
		view_borrow_panel.setBounds(201,130,600,450);
		view_borrow_panel.setBackground(new Color(0,0,0,0));
		view_borrow_panel.setVisible(false);
		
		JLabel heading3 = new JLabel("View borrowed books");
		heading3.setForeground(Color.WHITE);
		heading3.setFont(panel_heading);
		heading3.setBounds(170,0,300,50);
		view_borrow_panel.add(heading3);
		
		
		 
		 //Return Book Panel
		return_panel = new JPanel();
		return_panel.setLayout(null);
		background.add(return_panel);
		return_panel.setBounds(201,130,600,450);
		return_panel.setBackground(new Color(0,0,0,0));
		return_panel.setVisible(false);
		JLabel heading4 = new JLabel("Return Book");
		heading4.setForeground(Color.WHITE);
		heading4.setFont(panel_heading);
		heading4.setBounds(170,0,300,50);
		return_panel.add(heading4);
		
			
			
		JLabel enter_bookid4 = new JLabel("Enter Book ID");
		enter_bookid4.setBounds(60,100,250,30);
		return_panel.add(enter_bookid4);
		enter_bookid4.setFont(text);
		enter_bookid4.setForeground(Color.WHITE);
		
		
		JLabel enter_roll_no_2 = new JLabel("Enter Roll No.");
		enter_roll_no_2.setBounds(60,150,250,30);
		return_panel.add(enter_roll_no_2);
		enter_roll_no_2.setFont(text);
		enter_roll_no_2.setForeground(Color.WHITE);		
		
		input_book_id_4 = new JTextField();
		input_book_id_4.setBounds(250,100,230,30);
		return_panel.add(input_book_id_4);
		input_book_id_4.setBackground(new Color(51,153,255));
		input_book_id_4.setForeground(Color.WHITE);
	
		input_roll_no_2 = new JTextField();
		input_roll_no_2.setBounds(250,150,230,30);
		return_panel.add(input_roll_no_2);
		input_roll_no_2.setBackground(new Color(51,153,255));
		input_roll_no_2.setForeground(Color.WHITE);	
		
		return_book = new JButton("Return Book");
		return_book.setBounds(150,250,150,30);
		return_book.setBackground(new Color(51,153,255));
		return_book.setForeground(Color.WHITE);
		return_panel.add(return_book);
		return_book.addActionListener(this);
		
		
		
		
		//available books
		available_panel = new JPanel();
		available_panel.setLayout(null);
		background.add(available_panel);
		available_panel.setBounds(201,130,600,450);
		available_panel.setBackground(new Color(0,0,0,0));
		available_panel.setVisible(false);
		
		JLabel heading5 = new JLabel("Available Books");
		heading5.setForeground(Color.WHITE);
		heading5.setFont(panel_heading);
		heading5.setBounds(170,0,300,50);
		available_panel.add(heading5);
		
		

		
		
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == add_del_button)
		{
			add_del_panel.setVisible(true);
			borrow_panel.setVisible(false);
			view_borrow_panel.setVisible(false);
			return_panel.setVisible(false);
			available_panel.setVisible(false);
		}
		
		else if(ae.getSource() == borrow_button)
		{
			add_del_panel.setVisible(false);
			borrow_panel.setVisible(true);
			view_borrow_panel.setVisible(false);
			return_panel.setVisible(false);
			available_panel.setVisible(false);
		}
		
		else if(ae.getSource() == view_borrow_button)
		{
			add_del_panel.setVisible(false);
			borrow_panel.setVisible(false);
			view_borrow_panel.setVisible(true);
			return_panel.setVisible(false);
			available_panel.setVisible(false);
			
			JTable table = new JTable(0,0);
			table.setEnabled(false);
			DefaultTableModel model = new DefaultTableModel(0,0);
		
			String header[] = new String[] {"Book ID", "Book Name","Roll no.", "std name","Sem.", "Date"};
			model.setColumnIdentifiers(header);
			table.setModel(model);		
	
			try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshelf", "root", "inderjit");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from issued_books;");
					while(rs.next())
					{	
						model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6) });
					}
				}
			catch(Exception e)
				{
			
				}
		
		JScrollPane table_pane = new JScrollPane(table); 
		table_pane.setBounds(50,50,500,380);
		table.setBackground(new Color(30,144,255));
		table.setForeground(Color.WHITE);
		view_borrow_panel.add(table_pane);

			
		}

		else if(ae.getSource() == return_button)
		{
			add_del_panel.setVisible(false);
			borrow_panel.setVisible(false);
			view_borrow_panel.setVisible(false);
			return_panel.setVisible(true);
			available_panel.setVisible(false);
		}
		
		
		else if(ae.getSource() == available_button)
		{
			add_del_panel.setVisible(false);
			borrow_panel.setVisible(false);
			view_borrow_panel.setVisible(false);
			return_panel.setVisible(false);
			available_panel.setVisible(true);
					
			JTable table = new JTable(0,0);
			table.setEnabled(false);
			DefaultTableModel model = new DefaultTableModel(0,0);
		
			String header[] = new String[] {"Book ID", "Book Name"};
			model.setColumnIdentifiers(header);
			table.setModel(model);
		
		
		
	
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshelf", "root", "inderjit");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select book_id,book_name from book_details where status='available';");
				while(rs.next())
				{	
					model.addRow(new Object[] {rs.getString(1),rs.getString(2)});
				}
			}
			catch(Exception e)
			{
			
			}
		
		JScrollPane table_pane = new JScrollPane(table); 
		table_pane.setBounds(50,50,500,380);
		table.setBackground(new Color(30,144,255));
		table.setForeground(Color.WHITE);
		available_panel.add(table_pane);
			
		}
		
		else if(ae.getSource() == logout)
		{
			setVisible(false);
		}
		
		else if(ae.getSource() == add_button)
		{
			if(input_book_id_1.getText().equals("") || input_name_1.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "please fill all the fields first");
			}
			
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshelf","root","inderjit");	
			String query_to_execute = "insert into book_details values('"+ input_book_id_1.getText() +"', '" + input_name_1.getText() + "','available');";
			Statement st = con.createStatement();
			int status = st.executeUpdate(query_to_execute);
			if(status == 1)
			{
				JOptionPane.showMessageDialog(null,"new book added");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "bookid already  exist");
			}
			
			}
			catch(Exception e){	
				JOptionPane.showMessageDialog(null, "Book already exist");
				}
		}
		
	
	
	
	
	
	
		else if(ae.getSource() == del_button)
		{
			if(input_book_id_2.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "please enter book id");
				return;
			}
			
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshelf","root","inderjit");	
			String query_to_execute = "delete from book_details where book_id = '"+ input_book_id_2.getText() +"';";
			Statement st = con.createStatement();
			int status = st.executeUpdate(query_to_execute);
			if(status == 1)
			{
				JOptionPane.showMessageDialog(null, "book deleted");
			}
			else
				JOptionPane.showMessageDialog(null, "book id not exist");
				
			}catch(Exception e){}
		}
		
		
		
		
		else if(ae.getSource() ==  issue_button)
		{
			
			if(input_student_name.getText().equals("")|| input_roll_no.getText().equals("")|| input_semeseter.getText().equals("")|| input_book_id_3.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "please fill all the fields");
				return;
			}
			
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshelf","root","inderjit");	
			//checking book is availble or not
			Statement st = con.createStatement();
			String check_query = "select book_name from book_details where book_id = '"+ input_book_id_3.getText() +"' and status = 'available';";
			ResultSet rs = st.executeQuery(check_query);
			String check = "";
			while(rs.next())
			{
				check =  rs.getString(1);
				System.out.println(check);
				
			}
			if(check=="")
			{
				JOptionPane.showMessageDialog(null, "not available");
				return;
			}
			
			String query_to_execute = "insert into issued_books values('"+ input_book_id_3.getText() +"','"+ check +"', '"+ input_roll_no.getText()+"', '"+input_student_name.getText() +"', '"+input_semeseter.getText()+"', CURDATE());";
			int status = st.executeUpdate(query_to_execute);
			if(status == 1)
			{
				JOptionPane.showMessageDialog(null, "book issued");
				String update_book_detail = "update book_details set status = 'taken' where book_id = '"+input_book_id_3.getText()+"';";
				st.executeUpdate(update_book_detail);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Can't issue currently");
			}	
			}catch(Exception e){ System.out.println(e+"");}
		}
		
		
		
		else if(ae.getSource() == return_book)
		{
			if(input_book_id_4.getText().equals("")|| input_roll_no_2.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please fill all the fields");
					return;
			}
			
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshelf","root","inderjit");	
			Statement st = con.createStatement();
			String update_query = "update book_details set status = 'available' where book_id = '"+ input_book_id_4.getText()+"' and status = 'taken';";
			int status = st.executeUpdate(update_query);
			if(status == 1)
			{
				//to do code
			}
			else
			{
				//to do code
			}
			
			String query_to_execute  = "delete from issued_books where book_id = '"+input_book_id_4.getText()+"' and student_roll ='"+input_roll_no_2.getText()+"';";
			int status2 = st.executeUpdate(query_to_execute);
			if(status2 == 1)
			{
				JOptionPane.showMessageDialog(null,"Book returned");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"return failed");
			}
			}catch(Exception e){System.out.println("error" + e);}
				
			

		}

	}
	


	
}
