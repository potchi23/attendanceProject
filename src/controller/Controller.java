package controller;
import java.io.IOException;
import java.sql.SQLException;

import model.ManagerModel;

public class Controller {
	private ManagerModel _mgr;

	public Controller(ManagerModel mgr) {
		_mgr = mgr;
	}
	
	public void connect(String client, String host, String port, String sid, String username, String password) throws ClassNotFoundException, SQLException {
		_mgr.connect(client, host, port, sid, username, password);
	}
	
	public void disconnect() throws SQLException, NullPointerException {
		_mgr.disconnect();
	}
	
	public void insertNewMember(String name, String middleName, 
			String surname, String address, int telephone, String status, String group){
		
		_mgr.insertNewMember(name, middleName, surname, address, telephone, status, group);
	}
	
	public void insertInMeeting(String id, String meetName, String date, String time) throws SQLException{
		_mgr.insertInMeeting(id, meetName, date, time);
	}
	
	public void createMeeting(String meetName, String date) throws SQLException {
		_mgr.createMeeting(meetName, date);
	}
	
	public String[] getAtt(String name, String date) {
		return _mgr.getAtt(name, date);
	}
	
	public String[] getGroups() throws SQLException {
		return _mgr.getGroups();
	}	
	
	public String[] getMembers() {
		return _mgr.getMembers();
	}
	
	public String[] getStatus() throws SQLException {
		return _mgr.getStatus();
	}
	
	public int numberOfAtendees(String meetName, String date) {
		return _mgr.numberOfAtendees(meetName, date);
	}
	
	public void executeQueryFromOutputFile(String query) throws IOException, SQLException {
		_mgr.executeQueryFromFile(query);
	}
	
	public String getMemberByID(String id) {
		return _mgr.getMemberByID(id);
	}
}
