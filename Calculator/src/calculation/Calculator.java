package calculation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.function.DoublePredicate;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField displayField;
	double firstNum;
	double secondNum;
	double result;
	String operations;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 248, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		displayField = new JTextField();
		displayField.setBounds(10, 11, 210, 39);
		contentPane.add(displayField);
		displayField.setColumns(10);
		
		JButton btnCancel = new JButton("C");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayField.setText("");
			}
		});
		btnCancel.setBounds(10, 61, 45, 33);
		contentPane.add(btnCancel);
		
		JButton btnMultiply = new JButton("*");
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(displayField.getText());
				displayField.setText("");
				operations="*";
			}
		});
		btnMultiply.setBounds(175, 61, 45, 33);
		contentPane.add(btnMultiply);
		
		JButton btnDel = new JButton("D");
		btnDel.setBounds(65, 61, 45, 33);
		contentPane.add(btnDel);
		
		JButton btnDivision = new JButton("/");
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(displayField.getText());
				displayField.setText("");
				operations="/";
			}
		});
		btnDivision.setBounds(120, 61, 45, 33);
		contentPane.add(btnDivision);
		
		JButton btnSeven = new JButton("7");
		btnSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNum = displayField.getText() + btnSeven.getText();
				displayField.setText(enterNum);
			}
		});
		btnSeven.setBounds(10, 106, 45, 33);
		contentPane.add(btnSeven);
		
		JButton btnEight = new JButton("8");
		btnEight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String enterNum = displayField.getText() + btnEight.getText();
				displayField.setText(enterNum);
			}
		});
		btnEight.setBounds(65, 106, 45, 33);
		contentPane.add(btnEight);
		
		JButton btnNine = new JButton("9");
		btnNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String enterNum = displayField.getText() + btnNine.getText();
				displayField.setText(enterNum);
			}
		});
		btnNine.setBounds(120, 106, 45, 33);
		contentPane.add(btnNine);
		
		JButton btnSubstract = new JButton("-");
		btnSubstract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(displayField.getText());
				displayField.setText("");
				operations="-";
			}
		});
		btnSubstract.setBounds(175, 106, 45, 33);
		contentPane.add(btnSubstract);
		
		JButton btnFour = new JButton("4");
		btnFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNum = displayField.getText() + btnFour.getText();
				displayField.setText(enterNum);
			}
		});
		btnFour.setBounds(10, 150, 45, 33);
		contentPane.add(btnFour);
		
		JButton btnFive = new JButton("5");
		btnFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNum = displayField.getText() + btnFive.getText();
				displayField.setText(enterNum);
			}
		});
		btnFive.setBounds(65, 150, 45, 33);
		contentPane.add(btnFive);
		
		JButton btnSix = new JButton("6");
		btnSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNum = displayField.getText() + btnSix.getText();
				displayField.setText(enterNum);
			}
		});
		btnSix.setBounds(120, 150, 45, 33);
		contentPane.add(btnSix);
		
		JButton btnSum = new JButton("+");
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(displayField.getText());
				displayField.setText("");
				operations="+";
			}
		});
		btnSum.setBounds(175, 150, 45, 33);
		contentPane.add(btnSum);
		
		JButton btnOne = new JButton("1");
		btnOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNum = displayField.getText() + btnOne.getText();
				displayField.setText(enterNum);
			}
		});
		btnOne.setBounds(10, 195, 45, 33);
		contentPane.add(btnOne);
		
		JButton btnTwo = new JButton("2");
		btnTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNum = displayField.getText() + btnTwo.getText();
				displayField.setText(enterNum);
			}
		});
		btnTwo.setBounds(65, 195, 45, 33);
		contentPane.add(btnTwo);
		
		JButton btnThree = new JButton("3");
		btnThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNum = displayField.getText() + btnThree.getText();
				displayField.setText(enterNum);
			}
		});
		btnThree.setBounds(120, 195, 45, 33);
		contentPane.add(btnThree);
		
		JButton btnPercent = new JButton("%");
		btnPercent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(displayField.getText());
				displayField.setText("");
				operations="%";
			}
		});
		btnPercent.setBounds(10, 239, 45, 33);
		contentPane.add(btnPercent);
		
		JButton btnZero = new JButton("0");
		btnZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNum = displayField.getText() + btnZero.getText();
				displayField.setText(enterNum);
			}
		});
		btnZero.setBounds(65, 239, 45, 33);
		contentPane.add(btnZero);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNum = displayField.getText() + btnDot.getText();
				displayField.setText(enterNum);
			}
		});
		btnDot.setBounds(120, 239, 45, 33);
		contentPane.add(btnDot);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answer;
				secondNum = Double.parseDouble(displayField.getText());
				if (operations == "+"){
					result = firstNum + secondNum;
					answer = String.format("%.3f", result);
					displayField.setText(answer);
				}
				
				else if  (operations == "-"){
					result = firstNum - secondNum;
					answer = String.format("%.3f", result);
					displayField.setText(answer);
				}
				
				else if  (operations == "*"){
					result = firstNum * secondNum;
					answer = String.format("%.3f", result);
					displayField.setText(answer);
				}
				
				else if  (operations == "/"){
					result = firstNum / secondNum;
					answer = String.format("%.3f", result);
					displayField.setText(answer);
				}
				
				else if  (operations == "%"){
					result = firstNum % secondNum;
					answer = String.format("%.3f", result);
					displayField.setText(answer);
				}
			}
		});
		btnEqual.setBounds(175, 197, 45, 75);
		contentPane.add(btnEqual);
	}
}
