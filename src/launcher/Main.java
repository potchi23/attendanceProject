package launcher;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import controller.Controller;
import model.ManagerModel;
import view.mainFrame.MainWindow;

public class Main {

	public static void main(String[] args) {
		
		//SQL instance
		ManagerModel mgr = new ManagerModel(); 
		Controller ctrl = new Controller(mgr);
	
		try {
			EventQueue.invokeAndWait(new Runnable() {
				public void run() {
					try {
						MainWindow window = new MainWindow(ctrl);
						window.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
