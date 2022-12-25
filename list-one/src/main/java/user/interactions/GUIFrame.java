package user.interactions;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class GUIFrame extends JFrame {

	private static final long serialVersionUID = -3126664064627053162L;
	
	JTabbedPane panel;
	JPanel[] panels = new JPanel[4];

	GUIFrame(){
		this.setSize(1000, 700);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("List 1");
		
		this.panel= new JTabbedPane();
		panels[0] = new JPanel();
		panels[0].setBackground(Color.red);
		panel.addTab("Task 1", panels[0]);
		panels[1] = new JPanel();
		panels[1].setBackground(Color.green);
		panel.addTab("Task 2", panels[1]);
		panels[2] = new JPanel();
		panels[2].setBackground(Color.blue);
		panel.addTab("Task 3", panels[2]);
		panels[3] = new JPanel();
		panels[3].setBackground(Color.black);
		panel.addTab("Task 4", panels[3]);
		panel.setBounds(10,5,980,650);
		panel.setVisible(true);
		this.add(panel);
		
		this.setVisible(true);
	}
	
	public static void main(String args[]) {
		new GUIFrame();
	}
	

}
