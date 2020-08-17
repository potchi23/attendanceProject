package view.meetings;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Controller;
import exceptions.ViewException;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.miginfocom.swing.MigLayout;
import view.notifications.ValueMsgError;
import view.notifications.WarningWindow;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CreatePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JFrame _this = this;
	private String ts;
	/**
	 * Create the frame.
	 */
	public CreatePage(Controller ctrl) throws SQLException{
		ctrl.getGroups(); //THIS METHOD IS USED AS A "CHECKER"
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreatePage.class.getResource("/resources/icons/weekly-calendar.png")));
		setTitle("Create attendance page\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 381, 163);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][][grow][][grow][grow]", "[][grow][][grow][][]"));
		
		JLabel lblServiceName = new JLabel("Service name: ");
		lblServiceName.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblServiceName, "cell 3 1,alignx trailing");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 4 1 3 1,growx");
		textField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblDate, "cell 3 2,alignx trailing");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		contentPane.add(textField_1, "cell 4 2");
		textField_1.setColumns(10);
		ts = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		textField_1.setText(ts);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 4 3,grow");
		
		JButton btnNewButton = new JButton("Create page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							if(textField.getText().isEmpty()) {
								textField.setBackground(new Color(255, 118, 118)); 
								textField.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
								throw new ViewException(ViewException.NULL_VALUES);
							}
							
							try {
								ctrl.createMeeting(textField.getText().toUpperCase(), ts);
								CreatePageConfirm frame = new CreatePageConfirm(ctrl, textField.getText().toUpperCase(), textField_1.getText(), _this);
								frame.setVisible(true);
							} catch (SQLException e) {
								e.printStackTrace();
								EventQueue.invokeLater(new Runnable() {
									public void run() {
										try {
											ValueMsgError frame = new ValueMsgError(textField.getText().toUpperCase(), "page is already created.");
											frame.setVisible(true);
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								});
							}
							
						} catch (ViewException e) {
							e.printStackTrace();
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										WarningWindow frame = new WarningWindow(e.getMessage(), _this);
										setVisible(false);
										frame.setVisible(true);
										
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						}
					}
				});
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		contentPane.add(btnNewButton, "cell 4 4");
	}

}
