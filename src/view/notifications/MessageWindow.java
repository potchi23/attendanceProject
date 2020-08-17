package view.notifications;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MessageWindow extends JFrame {

	private JPanel contentPane;
	protected JPanel textPanel;
	protected JLabel valuelbl;
	/**
	 * Create the frame.
	 */
	public MessageWindow(String msg) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 254, 112);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		textPanel = new JPanel();
		contentPane.add(textPanel);
		textPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		valuelbl = new JLabel(msg);
		valuelbl.setFont(new Font("Arial", Font.PLAIN, 12));
		textPanel.add(valuelbl);
		
		JPanel buttonsPanel = new JPanel();
		contentPane.add(buttonsPanel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				btnNewButton.requestFocus();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		buttonsPanel.add(btnNewButton);
	}

}
