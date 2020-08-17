package view.toolBar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Info extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Info() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 217, 110);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThisIsJust = new JLabel("This is just a test.");
		lblThisIsJust.setBounds(-77, 11, 356, 15);
		lblThisIsJust.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisIsJust.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblThisIsJust);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Arial", Font.PLAIN, 11));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOk.setBounds(74, 37, 54, 23);
		contentPane.add(btnOk);
		this.setResizable(false);
	}
}
