package user.interactions;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import task4.OperationsFinder;

public class Task4Panel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 8170973890927195809L;

	private JTextField[] startingDataFields = new JTextField[3];
	private JButton execute;
	private JScrollPane solutions;
	private JTextArea textSolutions;

	Task4Panel() {
		this.setBackground(Color.white);
		this.setLayout(null);
		createTaskText();
		createInputFields();
		createExecuteButton();
		createSolutionsField();
	}

	private void createSolutionsField() {
		textSolutions = new JTextArea();
		textSolutions.setEditable(false);
		textSolutions.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
		solutions = new JScrollPane(textSolutions);
		solutions.setBounds(50, 320, 880, 300);
		this.add(solutions);
	}

	private void createExecuteButton() {
		execute = new JButton("Execute");
		execute.setBounds(570, 210, 260, 50);
		execute.addActionListener(this);
		this.add(execute);
	}

	private void createTaskText() {
		var taskDescription = new JLabel();
		taskDescription.setText(
				"<html> This task solves equation:<br><center>((n<sub>0</sub>?n<sub>2)</sub>?n<sub>3</sub>)?...)?n<sub>n</sub> = goal</center> <br> whereas: <br> <ul> <li> Each ? can be one of four basic arithmetic operations: +, -, * or / </li> <li> n<sub>i</sub> represent next natural numbers, which means n<sub>i+1</sub> = n<sub>i</sub> + 1 </li> <li> n<sub>0</sub> and n<sub>n</sub> are chosen by the user </li> <li> goal is chosen by the user</li> <li>n<sub>n</sub> cannot be more than 15 numbers bigget than n<sub>0</sub></li> <li>Goal needs to be in range (-1000,1000)</li> </ul></html>");
		taskDescription.setBounds(50, 50, 450, 250);
		taskDescription.setFont(new Font(Font.SERIF, Font.PLAIN, 14));
		taskDescription.setVisible(true);
		this.add(taskDescription);
	}

	private void createInputFields() {
		startingDataFields[0] = new JTextField("0");
		startingDataFields[0].setBounds(570, 100, 60, 60);
		startingDataFields[1] = new JTextField("n");
		startingDataFields[1].setBounds(670, 100, 60, 60);
		startingDataFields[2] = new JTextField("g");
		startingDataFields[2].setBounds(770, 100, 60, 60);
		for (JTextField field : startingDataFields) {
			field.setFont(new Font(Font.SERIF, Font.PLAIN, 26));
			field.setAlignmentY(CENTER_ALIGNMENT);
			this.add(field);
		}
	}
	
	private boolean checkIntArguments(int min, int max, int goal) throws IllegalArgumentException {
		if(goal < -999 || goal > 999) throw new IllegalArgumentException();
		if(min > max || min < max - 15) throw new IllegalArgumentException();
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		int min;
		int max;
		int goal;
		try {
			min = Integer.parseInt(startingDataFields[0].getText());
			max = Integer.parseInt(startingDataFields[1].getText());
			goal = Integer.parseInt(startingDataFields[2].getText());
			checkIntArguments(min, max, goal);
		} catch (Exception e) {
			textSolutions.setText("Wrong input!");
			return;
		}
		
		var solutionFinder = new OperationsFinder(goal, min, max);
		int solutionsAmount = solutionFinder.getAmountOfCalculations();
		if (solutionsAmount == 0) {
			textSolutions.setText("No solution avaliable");
			return;
		}
		String solutionsList = "";
		for(int i = 0; i < solutionsAmount; i++) {
			solutionsList += solutionFinder.toStringAt(i) + "\n";
		}
		textSolutions.setText(solutionsList);
	}
}
