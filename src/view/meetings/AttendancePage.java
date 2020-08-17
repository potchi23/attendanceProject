package view.meetings;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Controller;
import view.closeWindow.CloseMeeting;
import view.notifications.ValueMsgError;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AttendancePage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private AttendancePage _this = this;
	private DefaultTableModel def;
	private Controller ctrl;
	private JTextField QRTextField;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AttendancePage(Controller ctrl, String name, String date) {
		this.ctrl = ctrl;
		setTitle("Attendance page");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AttendancePage.class.getResource("/resources/icons/weekly-calendar.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 887, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblMeeting = new JLabel("Meeting: ");
		lblMeeting.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblMeeting = new GridBagConstraints();
		gbc_lblMeeting.anchor = GridBagConstraints.EAST;
		gbc_lblMeeting.insets = new Insets(0, 0, 5, 5);
		gbc_lblMeeting.gridx = 0;
		gbc_lblMeeting.gridy = 0;
		contentPane.add(lblMeeting, gbc_lblMeeting);
		
		JLabel meetNamelbl = new JLabel(name);
		meetNamelbl.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(meetNamelbl, gbc_lblNewLabel);
		
		JButton closePageButton = new JButton("CLOSE PAGE");
		closePageButton.setFont(new Font("Arial", Font.PLAIN, 12));
		closePageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CloseMeeting frame = new CloseMeeting(ctrl, _this, name, date);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		GridBagConstraints gbc_closePageButton = new GridBagConstraints();
		gbc_closePageButton.anchor = GridBagConstraints.EAST;
		gbc_closePageButton.insets = new Insets(0, 0, 5, 0);
		gbc_closePageButton.gridx = 11;
		gbc_closePageButton.gridy = 0;
		contentPane.add(closePageButton, gbc_closePageButton);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.anchor = GridBagConstraints.EAST;
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 1;
		contentPane.add(lblDate, gbc_lblDate);
		
		JLabel datelbl = new JLabel(date);
		datelbl.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(datelbl, gbc_lblNewLabel_1);
		
		JLabel lblCurrentAttendance = new JLabel("Current Attendance");
		GridBagConstraints gbc_lblCurrentAttendance = new GridBagConstraints();
		gbc_lblCurrentAttendance.anchor = GridBagConstraints.WEST;
		gbc_lblCurrentAttendance.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurrentAttendance.gridx = 10;
		gbc_lblCurrentAttendance.gridy = 1;
		contentPane.add(lblCurrentAttendance, gbc_lblCurrentAttendance);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 9;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		contentPane.add(panel_1, gbc_panel_1);
		panel_1.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 152, 143, 0, 0, 0, 0, 0, 28, 0};
		gbl_panel_1.rowHeights = new int[]{22, 28, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridheight = 2;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_1.add(panel_3, gbc_panel_3);
		
		JLabel lblInsertMemberIn = new JLabel("Insert member in attendance:");
		lblInsertMemberIn.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblInsertMemberIn = new GridBagConstraints();
		gbc_lblInsertMemberIn.anchor = GridBagConstraints.EAST;
		gbc_lblInsertMemberIn.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsertMemberIn.gridx = 1;
		gbc_lblInsertMemberIn.gridy = 0;
		panel_1.add(lblInsertMemberIn, gbc_lblInsertMemberIn);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JComboBox comboBox = new JComboBox();
		panel_2.add(comboBox);
		
		comboBox.setModel(new DefaultComboBoxModel(ctrl.getMembers()));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox.setMaximumRowCount(10);
		
		JButton insertButton = new JButton("Insert");
		insertButton.setFont(new Font("Arial", Font.PLAIN, 11));
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					String in;
					public void run() {
						in = comboBox.getSelectedItem().toString();
						try {
							ctrl.insertInMeeting(in.split("  ")[4], meetNamelbl.getText(), new SimpleDateFormat("yyyy-MM-dd").format(new Date()), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							InsertInAttendanceConfirm frame = new InsertInAttendanceConfirm(in, meetNamelbl.getText(), date, _this);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										ValueMsgError frame = new ValueMsgError(ctrl.getMemberByID(in.split("  ")[4]), "is already in the list.");
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
		
		panel_2.add(insertButton);
		
		JLabel lblInsertQR = new JLabel("Insert member by code/QR: ");
		lblInsertQR.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblInsettMemberBy = new GridBagConstraints();
		gbc_lblInsettMemberBy.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblInsettMemberBy.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsettMemberBy.gridx = 1;
		gbc_lblInsettMemberBy.gridy = 1;
		panel_1.add(lblInsertQR, gbc_lblInsettMemberBy);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.WEST;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.VERTICAL;
		gbc_panel_4.gridx = 2;
		gbc_panel_4.gridy = 1;
		panel_1.add(panel_4, gbc_panel_4);
		
		QRTextField = new JTextField();
		QRTextField.requestFocus();
		panel_4.add(QRTextField);
		QRTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = QRTextField.getText();
				try {
					ctrl.insertInMeeting(id, meetNamelbl.getText(), new SimpleDateFormat("yyyy-MM-dd").format(new Date()), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					updateTable(meetNamelbl.getText(), date);
				} catch (Exception e1) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								ValueMsgError frame = new ValueMsgError(ctrl.getMemberByID(id), "is already in the list.");
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							} 	
						}
					});
				} finally {
					QRTextField.setText("");
				}
			}
		});
		QRTextField.setColumns(10);
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				QRTextField.requestFocus();
			}
		});

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 10;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
		
		table = new JTable();
		def = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"#", "Name", "Middle name", "Surname", "Group", "Arrival time"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		
		table.setModel(def);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		JScrollPane sp = new JScrollPane(table);
		panel.add(sp);
		
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setBackground(Color.LIGHT_GRAY);
	}
	
	public void updateTable(String meetName, String date) {
		def.addRow(new String[0]);
		for(int i = 0; i < ctrl.numberOfAtendees(meetName, date); i++) {
			for(int j = 0; j < def.getColumnCount(); j++) {
				def.setValueAt(ctrl.getAtt(meetName, date)[i].split("  ")[j], i, j);
			}
		}
	}
}
