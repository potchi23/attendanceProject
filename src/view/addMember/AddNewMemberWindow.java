package view.addMember;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import exceptions.ViewException;
import view.notifications.WarningWindow;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

@SuppressWarnings("serial")
public class AddNewMemberWindow extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField midName;
	private JTextField surname;
	private JTextField telNumber;
	private JTextField address;
	private int tel;
	private Controller _ctrl;
	private JFrame _this = this;
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AddNewMemberWindow(Controller ctrl) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddNewMemberWindow.class.getResource("/resources/icons/boss-1.png")));
		_ctrl = ctrl;
		
		setTitle("New members");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 379, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		Panel panel_2 = new Panel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 3;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		
		Panel panel_1 = new Panel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		
		Panel panel_3 = new Panel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 1;
		panel.add(panel_3, gbc_panel_3);
		
		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		name = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 1;
		panel.add(name, gbc_textField);
		name.setColumns(10);
		name.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		JLabel lblMiddleName = new JLabel("Middle name: ");
		lblMiddleName.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblMiddleName = new GridBagConstraints();
		gbc_lblMiddleName.anchor = GridBagConstraints.WEST;
		gbc_lblMiddleName.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddleName.gridx = 3;
		gbc_lblMiddleName.gridy = 2;
		panel.add(lblMiddleName, gbc_lblMiddleName);
		midName = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 2;
		panel.add(midName, gbc_textField_1);
		midName.setColumns(10);
		midName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		JLabel lblSurname = new JLabel("Surname: ");
		lblSurname.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblSurename = new GridBagConstraints();
		gbc_lblSurename.anchor = GridBagConstraints.WEST;
		gbc_lblSurename.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurename.gridx = 3;
		gbc_lblSurename.gridy = 3;
		panel.add(lblSurname, gbc_lblSurename);
		
		surname = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 3;
		panel.add(surname, gbc_textField_2);
		surname.setColumns(10);
		surname.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		JLabel lblTelephoneNumber = new JLabel("Telephone number: ");
		lblTelephoneNumber.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblTelephoneNumber = new GridBagConstraints();
		gbc_lblTelephoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelephoneNumber.anchor = GridBagConstraints.WEST;
		gbc_lblTelephoneNumber.gridx = 3;
		gbc_lblTelephoneNumber.gridy = 4;
		panel.add(lblTelephoneNumber, gbc_lblTelephoneNumber);
		
		telNumber = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 4;
		gbc_textField_3.gridy = 4;
		panel.add(telNumber, gbc_textField_3);
		telNumber.setColumns(10);
		telNumber.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		JLabel lblAddress = new JLabel("Address: ");
		lblAddress.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.gridx = 3;
		gbc_lblAddress.gridy = 5;
		panel.add(lblAddress, gbc_lblAddress);
		
		address = new JTextField();
		address.setBackground(Color.WHITE);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.WEST;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 4;
		gbc_textField_4.gridy = 5;
		panel.add(address, gbc_textField_4);
		address.setColumns(10);
		address.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		JLabel lblGroup = new JLabel("Group: ");
		lblGroup.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblGroup = new GridBagConstraints();
		gbc_lblGroup.insets = new Insets(0, 0, 5, 5);
		gbc_lblGroup.anchor = GridBagConstraints.WEST;
		gbc_lblGroup.gridx = 3;
		gbc_lblGroup.gridy = 6;
		panel.add(lblGroup, gbc_lblGroup);
		
		JComboBox group = new JComboBox();
		group.setFont(new Font("Arial", Font.PLAIN, 11));
		group.setModel(new DefaultComboBoxModel(_ctrl.getGroups()));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 6;
		panel.add(group, gbc_comboBox);
		
		JLabel lblStatus = new JLabel("Status: ");
		lblStatus.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.anchor = GridBagConstraints.WEST;
		gbc_lblStatus.gridx = 3;
		gbc_lblStatus.gridy = 7;
		panel.add(lblStatus, gbc_lblStatus);
		
		JComboBox status = new JComboBox();
		status.setFont(new Font("Arial", Font.PLAIN, 11));
		status.setModel(new DefaultComboBoxModel(ctrl.getStatus()));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.anchor = GridBagConstraints.WEST;
		gbc_comboBox_1.gridx = 4;
		gbc_comboBox_1.gridy = 7;
		panel.add(status, gbc_comboBox_1);
		
		Panel panel_6 = new Panel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.gridx = 3;
		gbc_panel_6.gridy = 8;
		panel.add(panel_6, gbc_panel_6);
		
		Panel panel_7 = new Panel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.gridx = 3;
		gbc_panel_7.gridy = 9;
		panel.add(panel_7, gbc_panel_7);
		
		Panel panel_8 = new Panel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.gridx = 3;
		gbc_panel_8.gridy = 10;
		panel.add(panel_8, gbc_panel_8);
		
		Panel panel_9 = new Panel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 5, 5);
		gbc_panel_9.gridx = 3;
		gbc_panel_9.gridy = 11;
		panel.add(panel_9, gbc_panel_9);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 5;
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 12;
		panel.add(panel_4, gbc_panel_4);
		
		Panel panel_5 = new Panel();
		panel_4.add(panel_5);
		
		JButton btnNewButton = new JButton("Submit");
		panel_5.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						boolean nameIsNull = name.getText().isEmpty();
						boolean midnameIsNull = midName.getText().isEmpty();
						boolean surnameIsNull = surname.getText().isEmpty();
						boolean addressIsNull = address.getText().isEmpty();
						boolean telNumberIsNull = telNumber.getText().isEmpty();
						boolean telIsValid;
						Color RED_ERROR =  new Color(255, 118, 118);
						
						setVisible(true);
						try {
							tel = Integer.parseInt(telNumber.getText());
							telIsValid = true;
							
						} catch(NumberFormatException e){
							telIsValid = false;
						}
						
						try {
							String msg;
							msg = ViewException.NO_VALID_VALUES;
							if(nameIsNull || midnameIsNull|| surnameIsNull || addressIsNull || telNumberIsNull || !telIsValid) {
								if(nameIsNull) {name.setBackground(RED_ERROR); name.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));}
									else { name.setBackground(Color.WHITE); name.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));}
								if(midnameIsNull) { midName.setBackground(RED_ERROR); midName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));}
									else { midName.setBackground(Color.WHITE); midName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));}
								if(surnameIsNull) {surname.setBackground(RED_ERROR); surname.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));}
									else {surname.setBackground(Color.WHITE); surname.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));}
								if(addressIsNull) { address.setBackground(RED_ERROR); address.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));}
									else {address.setBackground(Color.WHITE); address.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));}
								if(telNumberIsNull) {telNumber.setBackground(RED_ERROR); telNumber.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));} 
									else {telNumber.setBackground(Color.WHITE); telNumber.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));}
								if(!telIsValid) {telNumber.setBackground(RED_ERROR); telNumber.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));}
									else {telNumber.setBackground(Color.WHITE); telNumber.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY)); telIsValid = true;}
									
								throw new ViewException(msg);
							}
							
							whiteBoxes();
							AddConfirm frame = new AddConfirm(ctrl, name.getText().toUpperCase(), midName.getText().toUpperCase(), surname.getText().toUpperCase(), address.getText().toUpperCase(), tel, status.getSelectedItem().toString().toUpperCase(), group.getSelectedItem().toString().toUpperCase(), _this);
							frame.setVisible(true);
							setVisible(false);
							
						} catch (Exception e) {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										setVisible(false);
										WarningWindow frame = new WarningWindow(e.getMessage(), _this);
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
		
		this.setResizable(false);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
	}
	
	private void whiteBoxes() {
		name.setBackground(Color.WHITE); telNumber.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		midName.setBackground(Color.WHITE); telNumber.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		surname.setBackground(Color.WHITE); telNumber.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		address.setBackground(Color.WHITE); telNumber.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		telNumber.setBackground(Color.WHITE); telNumber.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	}
}
