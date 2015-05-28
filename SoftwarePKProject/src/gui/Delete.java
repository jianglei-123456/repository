
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
import java.util.List;


public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				Delete frame = new Delete();
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
	public Delete() {
		this.setResizable(false);
		setTitle("\u5220\u9664\u8054\u7CFB\u4EBA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 574, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setFont(new Font("ËÎÌו", Font.PLAIN, 22));
		label.setBounds(65, 106, 72, 26);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(131, 106, 362, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4\u5220\u9664");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = textField.getText();
				Operation op = new Operation();
				dao.MaillistDAO mlDAO = new dao.MaillistDAO();
				dao.Maillist ml = new dao.Maillist();
				List list = mlDAO.findByName(name);
				int j = 0;
				for(Object o: list){
					op.deleteRecord(((dao.Maillist)(list.get(j))).getId());
					j++;
					}
				dispose();
			}
		});
		button.setBounds(74, 202, 140, 42);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		button_1.setBounds(297, 202, 140, 42);
		contentPane.add(button_1);
	}
	public void dispose(){
		 this.setVisible(false);
	}

}
