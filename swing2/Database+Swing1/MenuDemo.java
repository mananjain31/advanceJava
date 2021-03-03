import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class MenuDemo extends JPanel
{
	JButton b1;
	JTabbedPane tab1;
	InsertDemo ins;
	SearchDemo src;
	DeleteDemo del;
	UpdateDemo upd;
	ShowAll shw;
	MenuDemo(JFDemo f)
	{
		setLayout(new BorderLayout());
		tab1 = new JTabbedPane();

		ins = new InsertDemo();
		tab1.add("Insert",ins);

		src = new SearchDemo();
		tab1.add("Search",src);

		del = new DeleteDemo();
		tab1.add("Delete",del);

		upd = new UpdateDemo();
		tab1.add("Update",upd);

		shw = new ShowAll();
		tab1.add("Show All",shw);

		add(tab1);
	}

}

class InsertDemo extends JPanel implements ActionListener
{
	JLabel u1, u2, u3, u4, u5;
	JTextField t1, t2, t3, t4, t5;
	JButton b1;
	InsertDemo()
	{
		setLayout(null);
		u1 = new JLabel("Enter Roll No.");
		u1.setBounds(100, 50, 100, 50);
		add(u1);

		u2 = new JLabel("Enter Name");
		u2.setBounds(100, 50+50, 100, 50);
		add(u2);		

		u3 = new JLabel("Physics Marks");
		u3.setBounds(100, 50+100, 100, 50);
		add(u3);

		u4 = new JLabel("Chemistry Marks");
		u4.setBounds(100, 50+150, 100, 50);
		add(u4);

		u5 = new JLabel("Maths Marks");
		u5.setBounds(100, 50+200, 100, 50);
		add(u5);

		t1 = new JTextField();
		t1.setBounds(250, 60, 300, 30);
		add(t1);
		t2 = new JTextField();
		t2.setBounds(250, 60+50, 300, 30);
		add(t2);
		t3 = new JTextField();
		t3.setBounds(250, 60+100, 300, 30);
		add(t3);
		t4 = new JTextField();
		t4.setBounds(250, 60+150, 300, 30);
		add(t4);
		t5 = new JTextField();
		t5.setBounds(250, 60+200, 300, 30);
		add(t5);

		b1 = new JButton("Insert");
		b1.setBounds(200, 60+250, 100, 50);
		add(b1);
		b1.addActionListener(this);
	}
	public void paintComponent(Graphics g)
	{
		 g.drawImage(new ImageIcon("yellow.png").getImage(), 0, 0, null);
	}
	public void actionPerformed(ActionEvent e)
	{
		String s1 = t1.getText();
		String s2 = t2.getText();
		int s3 = Integer.parseInt(t3.getText());
		int s4 = Integer.parseInt(t4.getText());
		int s5 = Integer.parseInt(t5.getText());
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String db_url = "jdbc:mysql://localhost:3306/manandb?useSSL=false";
			String db_uname = "manan";
			String db_upass = "Manan+31";
			Connection con = DriverManager.getConnection(db_url, db_uname, db_upass);

			Statement st = con.createStatement();
			String s = 
			"INSERT INTO STUDENT VALUES('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')";
			st.executeUpdate(s);
			t1.setText("");
			t2.setText("");
			System.out.println("Data inserted..");	
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
}

class UpdateDemo extends JPanel
{
	JLabel u1, u2, u3, u4, u5;
	JTextField t1, t2, t3, t4, t5;
	JButton b1;
	UpdateDemo()
	{
		setLayout(null);
		u1 = new JLabel("Enter Roll No.");
		u1.setBounds(100, 50, 100, 50);
		add(u1);

		u2 = new JLabel("Enter Name");
		u2.setBounds(100, 50+50, 100, 50);
		add(u2);		

		u3 = new JLabel("Physics Marks");
		u3.setBounds(100, 50+100, 100, 50);
		add(u3);

		u4 = new JLabel("Chemistry Marks");
		u4.setBounds(100, 50+150, 100, 50);
		add(u4);

		u5 = new JLabel("Maths Marks");
		u5.setBounds(100, 50+200, 100, 50);
		add(u5);

		t1 = new JTextField();
		t1.setBounds(250, 60, 300, 30);
		add(t1);
		t2 = new JTextField();
		t2.setBounds(250, 60+50, 300, 30);
		add(t2);
		t3 = new JTextField();
		t3.setBounds(250, 60+100, 300, 30);
		add(t3);
		t4 = new JTextField();
		t4.setBounds(250, 60+150, 300, 30);
		add(t4);
		t5 = new JTextField();
		t5.setBounds(250, 60+200, 300, 30);
		add(t5);

		b1 = new JButton("Update");
		b1.setBounds(200, 60+250, 100, 50);
		add(b1);
	}
	public void paintComponent(Graphics g)
	{
		 g.drawImage(new ImageIcon("yellow.png").getImage(), 0, 0, null);
	}
}

class SearchDemo extends JPanel
{
	JLabel u1;
	JTextField t1;
	JButton b1;
	SearchDemo()
	{
		setLayout(null);
		u1 = new JLabel("Enter Roll No.");
		u1.setBounds(100, 50, 100, 50);
		add(u1);

		t1 = new JTextField();
		t1.setBounds(250, 60, 300, 30);
		add(t1);

		b1 = new JButton("Search");
		b1.setBounds(200, 60+50, 100, 50);
		add(b1);
	}	
	public void paintComponent(Graphics g)
	{
		 g.drawImage(new ImageIcon("yellow.png").getImage(), 0, 0, null);
	}
}

class DeleteDemo extends JPanel
{
	JLabel u1;
	JTextField t1;
	JButton b1;
	DeleteDemo()
	{
		setLayout(null);
		u1 = new JLabel("Enter Roll No.");
		u1.setBounds(100, 50, 100, 50);
		add(u1);

		t1 = new JTextField();
		t1.setBounds(250, 60, 300, 30);
		add(t1);

		b1 = new JButton("Delete");
		b1.setBounds(200, 60+50, 100, 50);
		add(b1);
	}	
	public void paintComponent(Graphics g)
	{
		 g.drawImage(new ImageIcon("yellow.png").getImage(), 0, 0, null);
	}
}

class ShowAll extends JPanel
{
	JLabel u1;
	ShowAll()
	{
		setLayout(null);
		u1 = new JLabel(
		"<html><body style='font-size:40px'>All Data<br>Will Be shown<br>here<body></html>"
		);
		u1.setBounds(100,10,500,200);
		add(u1);
	}
	public void paintComponent(Graphics g)
	{
		 g.drawImage(new ImageIcon("yellow.png").getImage(), 0, 0, null);
	}	
}

// 
