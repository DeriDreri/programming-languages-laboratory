package user.interactions;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class GUIFrame extends JFrame {

	private static final long serialVersionUID = -3126664064627053162L;

	JTabbedPane panel;
	JPanel[] panels = new JPanel[4];
	JScrollPane solutions;

	GUIFrame() {
		this.setSize(1000, 700);

		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("List 1");
		this.setResizable(false);

		this.panel = new JTabbedPane();
		panels[0] = new Task1Panel();
		panel.addTab("Task 1", panels[0]);
		panels[1] = new Task2Panel();
		panel.addTab("Task 2", panels[1]);
		panels[2] = new Task3Panel();
		panel.addTab("Task 3", panels[2]);
		panels[3] = new Task4Panel();
		panel.addTab("Task 4", panels[3]);
		panel.setBounds(10, 5, 980, 650);
		panel.setVisible(true);
		this.add(panel);
		this.setVisible(true);
	}

	public static void main(String args[]) {
		new GUIFrame();
	}

}
