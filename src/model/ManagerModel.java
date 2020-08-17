package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import utils.OutputFileGenerator;
import utils.SQLUtils;

public class ManagerModel {
	private SQLUtils _sqldb;
	private OutputFileGenerator ofg = new OutputFileGenerator();
	
	public ManagerModel() {
		_sqldb = new SQLUtils();
	}
	
	public void connect(String client, String host, String port, String sid, String username, String password) throws ClassNotFoundException, SQLException {
		_sqldb.connect(client, host, port, sid, username, password);
	}
	
	public void disconnect() throws SQLException, NullPointerException {
		_sqldb.disconnect();
	}
	
	public void insertNewMember(String name, String middleName, 
		String surename, String address, int telephone, String status, String group) {
		
		StringBuilder sb = new StringBuilder();
		int id_int = _sqldb.numberOfMembers();
		String id = null;
		
		if(id_int < 10)
			id = "000" + id_int;
		else if(id_int < 100)
			id = "00" + id_int;
		else if (id_int < 1000)
			id = "0" + id_int;
		else
			id = Integer.toString(id_int);
		
		sb.append("'").append(id.toUpperCase()).append("'").append(",");
		sb.append("'").append(name.toUpperCase()).append("'").append(",");
		sb.append("'").append(middleName.toUpperCase()).append("'").append(",");
		sb.append("'").append(surename.toUpperCase()).append("'").append(",");
		sb.append("'").append(address.toUpperCase()).append("'").append(",");
		sb.append("'").append(telephone).append("'").append(",");
		sb.append("'").append(status.toUpperCase()).append("'").append(",");
		sb.append("'").append(group.toUpperCase()).append("'");
		
		_sqldb.insertNewMember(sb.toString());
		ofg.generateMembersRecoveryFile(sb.toString());
	}
	
	public void createMeeting(String meetName, String date) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("'").append(meetName.toUpperCase()).append("'").append(",");
		sb.append("'").append(date.toUpperCase()).append("'");
		
		_sqldb.createMeeting(sb.toString());
		ofg.generateMeetingsRecoveryFile(sb.toString());
	}
	
	public String[] getAtt(String name, String date) {
		StringBuilder sbName = new StringBuilder();
		sbName.append("'").append(name).append("'");
		
		StringBuilder sbDate = new StringBuilder();
		sbDate.append("'").append(date).append("'");
		
		return _sqldb.getAtt(sbName.toString(), sbDate.toString());
	}
	
	public void insertInMeeting(String id, String meetName, String date, String time) throws SQLException{
		StringBuilder sb = new StringBuilder();
		sb.append("'").append(id).append("'").append(",");
		sb.append("'").append(meetName).append("'").append(",");
		sb.append("'").append(date).append("'").append(",");
		sb.append("'").append(time).append("'");
		
		_sqldb.insertInMeeting(sb.toString());
		 ofg.generateAttendanceRecoveryFile(sb.toString());
	}
	
	public String[] getGroups() throws SQLException{
		return _sqldb.getGroups();
	}
		
	public String[] getMembers() {
		return _sqldb.getMembers();
	}
	
	public String[] getStatus() throws SQLException {
		return _sqldb.getStatus();
	}
	
	public int numberOfAtendees(String meetName, String date) {
		String mn = "'" + meetName + "'";
		String d = "'" + date + "'";
		
		return _sqldb.numberOfAtendees(mn, d);
	}
	
	public void executeQueryFromFile(String query) throws IOException, SQLException {
		String line, in;
		
		if(query.equalsIgnoreCase("create"))
			in = "resources/createTables.sql";
		else if(query.equalsIgnoreCase("drop"))
			in = "resources/dropTables.sql";
		else
			in = "resources/insertData.sql";
		
		BufferedReader br = new BufferedReader(new FileReader(in));
			
		while((line = br.readLine()) != null) {
			_sqldb.executeQueryFromFile(line);
		}
			
		br.close();
	}
	
	public String getMemberByID(String id) {
		return _sqldb.getMemberByID(id);
	}
}
