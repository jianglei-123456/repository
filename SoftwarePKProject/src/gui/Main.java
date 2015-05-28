package gui;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import dao.MaillistDAO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import dao.*;
import java.awt.Font;


public class Main extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String[][] data;
	private String name;
	private int Id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 103, 563, 393);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("宋体", Font.PLAIN, 18));
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					int row=table.getSelectedRow();    
					name=table.getValueAt(row,0).toString();
					dao.MaillistDAO mlDAO = new dao.MaillistDAO();
					dao.Maillist ml = new dao.Maillist();
					List list = mlDAO.findByName(name);
					Id = ((dao.Maillist)(list.get(0))).getId();
					
			}
		});
		scrollPane.setViewportView(table);

		data = new String[20][3];
		int j = 0;
				
		dao.MaillistDAO mlDAO1 = new dao.MaillistDAO();
		List list1 = mlDAO1.findAll();
				
				
		for(Object o: list1){
			data[j][0] = ((dao.Maillist)(list1.get(j))).getName();
			data[j][1] = ((dao.Maillist)(list1.get(j))).getNumber().toString();
			data[j][2] = ((dao.Maillist)(list1.get(j))).getEmail();
			j++;
			}
		table.setModel(new DefaultTableModel(
			data,
			new String[] {
				"\u59D3\u540D", "\u7535\u8BDD", "\u90AE\u4EF6\u5730\u5740"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("\u6DFB\u52A0\u8054\u7CFB\u4EBA");
		button.setFont(new Font("宋体", Font.PLAIN, 22));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Add frame = new Add();
				frame.setVisible(true);
			}
		});
		button.setBounds(59, 37, 157, 36);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u4FEE\u6539\u8054\u7CFB\u4EBA");
		button_1.setFont(new Font("宋体", Font.PLAIN, 22));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Modify frame = new Modify(Id);
				frame.setVisible(true);
			}
		});
		button_1.setBounds(248, 37, 157, 36);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u5220\u9664\u8054\u7CFB\u4EBA");
		button_2.setFont(new Font("宋体", Font.PLAIN, 22));
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Delete frame = new Delete();
				frame.setVisible(true);
			}
		});
		button_2.setBounds(440, 37, 161, 36);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u66F4\u65B0");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				data = new String[20][3];
				int j = 0;
						
				dao.MaillistDAO mlDAO1 = new dao.MaillistDAO();
				List list1 = mlDAO1.findAll();
						
						
				for(Object o: list1){
					data[j][0] = ((dao.Maillist)(list1.get(j))).getName();
					data[j][1] = ((dao.Maillist)(list1.get(j))).getNumber();
					data[j][2] = ((dao.Maillist)(list1.get(j))).getEmail();
					j++;
					}
				table.setModel(new DefaultTableModel(
					data,
					new String[] {
						"\u59D3\u540D", "\u7535\u8BDD", "\u90AE\u4EF6\u5730\u5740"
					}
			));
			}
		});
		button_3.setBounds(48, 519, 113, 27);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\u9000\u51FA");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);			}
		});
		button_4.setBounds(498, 519, 113, 27);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("\u67E5\u8BE2");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Find frame = new Find();
				frame.setVisible(true);
			}
		});
		button_5.setBounds(271, 519, 113, 27);
		contentPane.add(button_5);
	}
}
