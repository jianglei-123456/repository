package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import SoftwarePk.Operation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				Add frame = new Add();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	//}

	/**
	 * Create the frame.
	 */
	public Add() {
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 628, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u59D3    \u540D\uFF1A");
		label.setFont(new Font("ËÎÌו", Font.PLAIN, 22));
		label.setBounds(74, 51, 110, 31);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
		label_1.setFont(new Font("ËÎÌו", Font.PLAIN, 22));
		label_1.setBounds(74, 90, 110, 31);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u90AE\u4EF6\u5730\u5740\uFF1A");
		label_2.setFont(new Font("ËÎÌו", Font.PLAIN, 22));
		label_2.setBounds(74, 134, 110, 31);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(186, 54, 365, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 93, 365, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(186, 137, 365, 31);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = textField.getText();
				String num = textField_1.getText();
				String email = textField_2.getText();
				Operation op = new Operation();
				op.addRecord(name,num,email);
				dispose();
			}
		});
		button.setBounds(110, 286, 128, 47);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		button_1.setBounds(369, 286, 128, 47);
		contentPane.add(button_1);
	}
	public void dispose(){
		 this.setVisible(false);
	}
}
