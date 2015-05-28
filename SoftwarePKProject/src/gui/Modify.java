package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import SoftwarePk.Operation;


public class Modify extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private  int Id;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				Modify frame = new Modify();
	//				frame.setVisible(true);
	///			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	//}

	/**
	 * Create the frame.
	 */
	public Modify(int Id) {
		this.Id = Id;
		this.setResizable(false);
		setTitle("\u4FEE\u6539\u8054\u7CFB\u4EBA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 602, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = textField.getText();
				String num = textField_1.getText();
				String email = textField_2.getText();
				Operation op = new Operation();
				op.modifyRecord(getId(),name,num,email);
				dispose();
			}
		});
		btnNewButton.setBounds(118, 233, 125, 47);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(317, 233, 125, 47);
		contentPane.add(btnNewButton_1);
		
		
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 22));
		lblNewLabel.setBounds(47, 31, 72, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("ËÎÌו", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(47, 81, 113, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u90AE\u4EF6\u5730\u5740\uFF1A");
		lblNewLabel_2.setFont(new Font("ËÎÌו", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(47, 131, 113, 37);
		contentPane.add(lblNewLabel_2);
		
		dao.MaillistDAO mlDAO = new dao.MaillistDAO();
		dao.Maillist ml = new dao.Maillist();
		ml = mlDAO.findById(Id);
		
		textField = new JTextField();
		textField.setBounds(151, 36, 379, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(ml.getName());
		
		textField_1 = new JTextField();
		textField_1.setBounds(151, 81, 379, 33);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(ml.getNumber().toString());
		
		textField_2 = new JTextField();
		textField_2.setBounds(153, 131, 377, 33);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(ml.getEmail());
	}
	public void dispose(){
		 this.setVisible(false);
	}
	public int getId(){
		return this.Id;
	}

}
