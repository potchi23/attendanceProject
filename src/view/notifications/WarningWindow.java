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
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class WarningWindow extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private JFrame sup;
	/**
	 * Create the frame.
	 */
	public WarningWindow(String msg, JFrame sup) {
		this.sup = sup;
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 254, 112);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel textPanel = new JPanel();
		contentPane.add(textPanel);
		textPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel textlbl = new JLabel(msg);
		textlbl.setFont(new Font("Arial", Font.PLAIN, 12));
		textPanel.add(textlbl);
		
		JPanel buttonsPanel = new JPanel();
		contentPane.add(buttonsPanel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sup.setVisible(true);
				dispose();
			}
		});
		
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		buttonsPanel.add(btnNewButton);
	}

}
