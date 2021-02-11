// Java program to implement
// a Simple Feedback Form
// using Java Swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame
	extends JFrame
	implements ActionListener {

	// Components of the Form
	private Container c;
	private JLabel title;
	private JLabel name;
	private JTextField tname;
	private JLabel mno;
	private JTextField tmno;
	private JLabel gender;
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup gengp;
	private JLabel Section;
	private JComboBox sec;
	private JLabel Rating;
	private JComboBox rate;
	private JLabel add;
	private JTextArea tadd;
	private JCheckBox term;
	private JButton sub;
	private JButton reset;
	private JTextArea tout;
	private JLabel res;
	private JTextArea resadd;

	private String secs[]
		= { "Section A1", "Section A2", "Section A3" };
	private String rates[]
		= { "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "10"};

	// constructor, to initialize the components
	// with default values.
	public MyFrame()
	{
		setTitle("Feedback Form");
		setBounds(300, 90, 900, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);

		title = new JLabel("Feedback Form");
		title.setSize(300, 30);
		title.setLocation(300, 30);
		c.add(title);

		name = new JLabel("Name");
		name.setSize(100, 30);
		name.setLocation(100, 100);
		c.add(name);

		tname = new JTextField();
		tname.setSize(190, 30);
		tname.setLocation(200, 100);
		c.add(tname);

		mno = new JLabel("Mobile");
		mno.setSize(100, 30);
		mno.setLocation(100, 150);
		c.add(mno);

		tmno = new JTextField();
		tmno.setSize(150, 30);
		tmno.setLocation(200, 150);
		c.add(tmno);

		gender = new JLabel("Gender");
		gender.setSize(100, 30);
		gender.setLocation(100, 200);
		c.add(gender);

		male = new JRadioButton("Male");
		male.setSelected(true);
		male.setSize(75, 30);
		male.setLocation(200, 200);
		c.add(male);

		female = new JRadioButton("Female");
		female.setSelected(false);
		female.setSize(80, 30);
		female.setLocation(275, 200);
		c.add(female);

		gengp = new ButtonGroup();
		gengp.add(male);
		gengp.add(female);

		Section = new JLabel("Section");
		Section.setSize(100, 30);
		Section.setLocation(100, 250);
		c.add(Section);

		sec = new JComboBox(secs);
		sec.setSize(100, 30);
		sec.setLocation(200, 250);
		c.add(sec);

		Rating = new JLabel("Rating");
		Rating.setSize(100, 20);
		Rating.setLocation(100, 300);
		c.add(Rating);

		rate = new JComboBox(rates);
		rate.setSize(50, 30);
		rate.setLocation(200, 300);
		c.add(rate);

		add = new JLabel("Comments");
		add.setSize(100, 30);
		add.setLocation(100, 350);
		c.add(add);

		tadd = new JTextArea();
		tadd.setSize(200, 75);
		tadd.setLocation(200, 350);
		tadd.setLineWrap(true);
		c.add(tadd);

		term = new JCheckBox("Accept Terms And Conditions.");
		term.setSize(250, 30);
		term.setLocation(150, 450);
		c.add(term);

		sub = new JButton("Submit");
		sub.setSize(100, 30);
		sub.setLocation(150, 500);
		sub.addActionListener(this);
		c.add(sub);

		reset = new JButton("Reset");
		reset.setSize(100, 30);
		reset.setLocation(270, 500);
		reset.addActionListener(this);
		c.add(reset);

		tout = new JTextArea();
		tout.setSize(300, 400);
		tout.setLocation(500, 100);
		tout.setLineWrap(true);
		tout.setEditable(false);
		c.add(tout);

		res = new JLabel("");
		res.setSize(500, 25);
		res.setLocation(100, 550);
		c.add(res);

		resadd = new JTextArea();
		resadd.setSize(200, 75);
		resadd.setLocation(580, 175);
		resadd.setLineWrap(true);
		c.add(resadd);

		setVisible(true);
	}

	// method actionPerformed()
	// to get the action performed
	// by the user and act accordingly
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == sub) {
			if (term.isSelected()) {
				String data1;
				String data
					= "Name : "
					+ tname.getText() + "\n"
					+ "Mobile : "
					+ tmno.getText() + "\n";
				if (male.isSelected())
					data1 = "Gender : Male"
							+ "\n";
				else
					data1 = "Gender : Female"
							+ "\n";
				String data2
					= "Section : "
					+ (String)sec.getSelectedItem()
					+ "\n";
				String data3
					= "Rating : "
					+ (String)rate.getSelectedItem()
					+ " / 10" 
					+ "\n";

				String data4 = "Comments : " + tadd.getText();
				tout.setText(data + data1 + data2 + data3+ data4);
				tout.setEditable(false);
				res.setText("Feedback Successfully taken..");
			}
			else {
				tout.setText("");
				resadd.setText("");
				res.setText("Please accept the"
							+ " terms & conditions..");
			}
		}

		else if (e.getSource() == reset) {
			String def = "";
			tname.setText(def);
			tadd.setText(def);
			tmno.setText(def);
			res.setText(def);
			tout.setText(def);
			term.setSelected(false);
			sec.setSelectedIndex(0);
			resadd.setText(def);
		}
	}
}

// Driver Code
class Feedback {

	public static void main(String[] args) throws Exception
	{
		MyFrame f = new MyFrame();
	}
}
