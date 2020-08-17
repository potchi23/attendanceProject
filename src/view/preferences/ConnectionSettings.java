package view.preferences;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import utils.JSONManager;
import view.mainFrame.MainWindow;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ConnectionSettings extends JFrame {

	private JPanel contentPane;
	private JTextField hostTF;
	private JTextField portTF;
	private JTextField sidTF;
	private JTextField usernameTF;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 * @throws NoSuchAlgorithmException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConnectionSettings(MainWindow sup) throws NoSuchAlgorithmException {
		JSONManager json = new JSONManager();
		String[] info = json.getFile();
		
		setTitle("Connection Settings");
		setResizable(false);
		setBounds(100, 100, 522, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{42, 0, 176, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{21, 40, 38, 38, 27, 14, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Client: ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox clientCB = new JComboBox();
		clientCB.setModel(new DefaultComboBoxModel(new String[] {"Oracle", "MySQL"}));
		clientCB.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_clientCB = new GridBagConstraints();
		gbc_clientCB.anchor = GridBagConstraints.WEST;
		gbc_clientCB.insets = new Insets(0, 0, 5, 5);
		gbc_clientCB.gridx = 2;
		gbc_clientCB.gridy = 1;
		panel.add(clientCB, gbc_clientCB);
		//clientCB.setEnabled(false); //this will be enabled soon
		
		if(info[0].equals("oracle"))
			clientCB.setSelectedIndex(0);
		else
			clientCB.setSelectedIndex(1);
		
		
		JLabel lblNewLabel_1 = new JLabel("Host: ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
	
		
		hostTF = new JTextField();
		hostTF.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_hostTF = new GridBagConstraints();
		gbc_hostTF.anchor = GridBagConstraints.WEST;
		gbc_hostTF.insets = new Insets(0, 0, 5, 5);
		gbc_hostTF.gridx = 2;
		gbc_hostTF.gridy = 2;
		panel.add(hostTF, gbc_hostTF);
		hostTF.setColumns(10);
		hostTF.setText(info[1]);
		
		JLabel lblNewLabel_4 = new JLabel("Username: ");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 2;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		usernameTF = new JTextField();
		usernameTF.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_usernameTF = new GridBagConstraints();
		gbc_usernameTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameTF.insets = new Insets(0, 0, 5, 0);
		gbc_usernameTF.gridx = 5;
		gbc_usernameTF.gridy = 2;
		panel.add(usernameTF, gbc_usernameTF);
		usernameTF.setColumns(10);
		usernameTF.setText(info[4]);
		
		JLabel lblNewLabel_2 = new JLabel("Port: ");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		portTF = new JTextField();
		portTF.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_portTF = new GridBagConstraints();
		gbc_portTF.anchor = GridBagConstraints.WEST;
		gbc_portTF.insets = new Insets(0, 0, 5, 5);
		gbc_portTF.gridx = 2;
		gbc_portTF.gridy = 3;
		panel.add(portTF, gbc_portTF);
		portTF.setColumns(10);
		portTF.setText(info[2]);
		
		JLabel lblNewLabel_5 = new JLabel("Password: ");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 3;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 5;
		gbc_passwordField.gridy = 3;
		panel.add(passwordField, gbc_passwordField);
		passwordField.setText(info[5]);
		
		JLabel lblNewLabel_3 = new JLabel("SID: ");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		sidTF = new JTextField();
		sidTF.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_sidTF = new GridBagConstraints();
		gbc_sidTF.anchor = GridBagConstraints.WEST;
		gbc_sidTF.insets = new Insets(0, 0, 5, 5);
		gbc_sidTF.gridx = 2;
		gbc_sidTF.gridy = 4;
		panel.add(sidTF, gbc_sidTF);
		sidTF.setColumns(10);
		sidTF.setText(info[3]);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JButton btnNewButton = new JButton("Apply");
		btnNewButton.addActionListener(new ActionListener() {
//			MessageDigest digest = MessageDigest.getInstance("SHA-256");
//			String pass = passwordField.getPassword().toString();
//			byte[] encodedhash = digest.digest(
//					pass.getBytes()
//			);
//			
//			String key = bytesToHex(encodedhash);
//			
			public void actionPerformed(ActionEvent arg0) {
				sup.setConnectionURL(clientCB.getSelectedItem().toString().toLowerCase(), hostTF.getText(), 
						portTF.getText(), sidTF.getText(), usernameTF.getText(), new String(passwordField.getPassword()));
				json.createFile(clientCB.getSelectedItem().toString().toLowerCase(), hostTF.getText(), 
						portTF.getText(), sidTF.getText(), usernameTF.getText(), new String(passwordField.getPassword()));
				
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_4.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
	}
}
