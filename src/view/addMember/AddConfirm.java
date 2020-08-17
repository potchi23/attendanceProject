package view.addMember;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Controller;
import exceptions.ViewException;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class AddConfirm extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private String midname;
	@SuppressWarnings("unused")
	private String surname;
	@SuppressWarnings("unused")
	private String address;
	@SuppressWarnings("unused")
	private int telNumber;
	@SuppressWarnings("unused")
	private String status;
	@SuppressWarnings("unused")
	private String group;
	private Controller _ctrl;
	private JFrame sup;
	/**
	 * Create the frame.
	 */
	public AddConfirm(Controller ctrl, String name, String midname, String surname, String address, int telNumber, String status, String group, JFrame frame) throws SQLException, ViewException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddConfirm.class.getResource("/resources/icons/boss-1.png")));
		this.name = name;
		this.midname = midname;
		this.surname = surname;
		this.address = address;
		this.telNumber = telNumber;
		this.status = status;
		this.group = group;
		_ctrl = ctrl;
		sup = frame;
		
		setTitle("Confirm member");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 399, 483);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n");
		sb.append("Check the information below before submitting: ").append("\r\n").append("\r\n").append("\r\n");
		sb.append("Name: ").append(name).append("\r\n").append("\r\n");
		sb.append("Middle name: ").append(midname).append("\r\n").append("\r\n");
		sb.append("Surname: ").append(surname).append("\r\n").append("\r\n");
		sb.append("Phone number: ").append(telNumber).append("\r\n").append("\r\n");
		sb.append("Address: ").append(address).append("\r\n").append("\r\n");
		sb.append("Group: ").append(group).append("\r\n").append("\r\n");
		sb.append("Status: ").append(status).append("\r\n");
		sb.append("\r\n").append("\r\n");
		sb.append("Is the information above correct?").append("\r\n");
		
		JTextPane lblAddTo = new JTextPane();
		lblAddTo.setText(sb.toString());
		lblAddTo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAddTo.setEditable(false);
		lblAddTo.setBackground(SystemColor.menu);
		panel.add(lblAddTo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Yes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				_ctrl.insertNewMember(name, midname, surname, address, telNumber, status, group);
			
				dispose();
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SuccessWindow frame = new SuccessWindow();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	 
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("No");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sup.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_1.add(btnNewButton_1);
		
		this.setResizable(false);
	}

}
