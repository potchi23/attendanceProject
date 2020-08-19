package utils;

import java.sql.*;
import java.util.TimeZone;

public class SQLUtils {
	private Statement _stmt;
	private Connection _con;
	
	public static enum ATTENDANCE_COLUMNS {NULL, NAME, MIDDLENAME, SURNAME, GROUP, TS};
	
	public SQLUtils() {
		
	}
	
	public void connect(String client, String host, String port, String sid, String username, String password) throws SQLException, ClassNotFoundException{
		StringBuilder url = new StringBuilder();
		
		//load drivers
		if(client.equals("mysql")) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			url.append("jdbc:mysql://").append(host).append(":").append(port).append("/").append(sid).append("?serverTimezone=").append(TimeZone.getDefault().getID());
		}
		
		else if(client.equals("oracle")) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url.append("jdbc:oracle:thin:@").append(host).append(":").append(port).append(":").append(sid);
		}
		
		//connection object
		_con = DriverManager.getConnection(url.toString(), username, password);
		_stmt = _con.createStatement();
		
		//TESTING INPUTS
		//_con = DriverManager.getConnection("jdbc:mysql://192.168.2.105:3306/ATT", "root", "root");
		//"oracle.jdbc.driver.OracleDriver"
		//"com.mysql.jdbc.Driver"
		//"jdbc:mysql://localhost:3306/management", "root", "richard"
		//"jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "richard"
	}
	
	public void disconnect() throws SQLException, NullPointerException {
		_con.close();
	};
	
	public int numberOfMembers() {
		int num = 0;
		
		try {
			ResultSet rs = _stmt.executeQuery("SELECT COUNT(MEMBER_ID) FROM ATT_Members");
			while(rs.next()) {
				num = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return num;
	}
	
	public int numberOfAtendees(String meetName, String date) {
		int num = 0;
		
		try {
			ResultSet rs = _stmt.executeQuery("SELECT COUNT(MEMBER_ID) FROM ATT_Attendance " + 
											  "WHERE ATT_Attendance.MEETING_NAME = " + meetName + " AND " + "ATT_Attendance.MEETING_DATE = " + date);
			System.out.println();
			while(rs.next()) {
				num = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return num;
	}
	
	public void insertNewMember(String values){
			//execute query
			try {
				@SuppressWarnings("unused")
				int i = _stmt.executeUpdate(
						"INSERT INTO ATT_Members(MEMBER_ID, MEMBERNAME, MEMBERMIDDLENAME, MEMBERSURNAME, MEMBER_ADDRESS, MEMBER_TELEPHONE, MEMBER_STATUS, MEMBER_GROUP)" +
					    "VALUES(" + values + ")");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void createMeeting(String values) throws SQLException{
			//execute query
			@SuppressWarnings("unused")
			int i = _stmt.executeUpdate(
					"INSERT INTO ATT_Meetings(MEETING_NAME, MEETING_DATE)" +
				    "VALUES(" + values + ")");
	}
	
	public void insertInMeeting(String values) throws SQLException{
			//execute query
			@SuppressWarnings("unused")
			int i = _stmt.executeUpdate(
					"INSERT INTO ATT_Attendance(MEMBER_ID, MEETING_NAME, MEETING_DATE, MEETING_TIME) " +
				    "VALUES(" + values + ")");
	}
	
	//String[row]
	public String[] getAtt(String meetName, String date) {
		
		String[] info = new String[numberOfAtendees(meetName, date)];
		try {
			//execute query
			ResultSet rs = _stmt.executeQuery(
					"SELECT MEMBERNAME, MEMBERMIDDLENAME, MEMBERSURNAME, MEMBER_GROUP, MEETING_TIME FROM " +
				    "ATT_Members JOIN ATT_Attendance ON ATT_Members.MEMBER_ID = ATT_Attendance.MEMBER_ID " +
					"WHERE ATT_Attendance.MEETING_NAME = " + meetName + " AND " + "ATT_Attendance.MEETING_DATE = " + date +
					"ORDER BY MEETING_TIME");
			
				int row = 0;
				while(rs.next()) {
					info[row] = row + 1 + "  " + rs.getString(ATTENDANCE_COLUMNS.NAME.ordinal()) + "  " + rs.getString(ATTENDANCE_COLUMNS.MIDDLENAME.ordinal()) 
					+ "  " + rs.getString(ATTENDANCE_COLUMNS.SURNAME.ordinal()) + "  " + rs.getString(ATTENDANCE_COLUMNS.GROUP.ordinal()) + "  "
					+ rs.getString(ATTENDANCE_COLUMNS.TS.ordinal()).split(" ")[1];
					row++;
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return info;
	}
	
	public String[] getGroups() throws SQLException {
		
		String[] groups = null;
			//execute query
			ResultSet aux = _stmt.executeQuery("SELECT COUNT(GROUP_NAME) FROM ATT_Groups");
			while(aux.next()) {
				groups = new String[aux.getInt(1)];  
			}
			
			ResultSet rs = _stmt.executeQuery("SELECT GROUP_NAME FROM ATT_Groups");
			int row = 0;
			while(rs.next()) {
				groups[row] = rs.getString(1);
				row++;
			}

		return groups;
	}
	
	public String[] getStatus() throws SQLException {
		
		String[] groups = null;
			//execute query
			ResultSet aux = _stmt.executeQuery("SELECT COUNT(MEMBER_STATUS) FROM ATT_Status");
			while(aux.next()) {
				groups = new String[aux.getInt(1)];  
			}
			
			ResultSet rs = _stmt.executeQuery("SELECT MEMBER_STATUS FROM ATT_Status");
			int row = 0;
			while(rs.next()) {
				groups[row] = rs.getString(1);
				row++;
			}

		return groups;
	}
	
	public String[] getMembers(){
		String[] members = new String[numberOfMembers()];
		
		try {
			ResultSet rs = _stmt.executeQuery("SELECT MEMBERNAME, MEMBERMIDDLENAME, MEMBERSURNAME, MEMBER_ID FROM ATT_Members ORDER BY MEMBERNAME");
			int row = 0;
			while(rs.next()) {
					members[row] = rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  -  " + rs.getString(4);
				row++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return members;
	}
	
	public void executeQueryFromFile(String query) throws SQLException {
			@SuppressWarnings("unused")
			int i = _stmt.executeUpdate(query);
	}
	
	public String getMemberByID(String id) {
		String memberName = "";
		
		try {
			ResultSet rs = _stmt.executeQuery("SELECT MEMBERNAME, MEMBERMIDDLENAME, MEMBERSURNAME FROM ATT_Members WHERE MEMBER_ID = " + id);
			while(rs.next()) {
				memberName = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memberName;
	}
}
