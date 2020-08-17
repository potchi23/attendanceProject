package view.notifications;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ValueMsgError extends MessageWindow{

	public ValueMsgError(String val, String msg) {
		super(val);
		
		valuelbl.setFont(new Font("Arial", Font.BOLD, 12));
		JLabel textlbl = new JLabel(msg);
		textlbl.setFont(new Font("Arial", Font.PLAIN, 12));
		textPanel.add(textlbl);
		
		Dimension d = new Dimension();
		d.width = 50;
		setBounds(100, 100, 450, 112);
		setResizable(false);
	}
}
