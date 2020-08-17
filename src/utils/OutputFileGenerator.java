package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFileGenerator {
	//RECOVERY FILE GENERATORS
	
	//1. Insert members
	public void generateMembersRecoveryFile(String values) {
		try {
			File dir = new File("files/recovery");
			if(!dir.exists())
				dir.mkdirs();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("files/recovery/1-insert_members.sql", true));
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ATT_MEMBERS(MEMBER_ID, MEMBERNAME, MEMBERMIDDLENAME, MEMBERSURNAME, MEMBER_ADDRESS, MEMBER_TELEPHONE, MEMBER_STATUS, MEMBER_GROUP)\r\n" + 
					  "VALUES(").append(values).append(");\r\n");
			
			bw.write(sb.toString());
			bw.flush();
			bw.close();
				
		} catch (IOException e) {
			System.out.println("Output file generation failed!");
		}
	}
	
	//2. Insert meetings
	public void generateMeetingsRecoveryFile(String values) {
		
		try {
			File dir = new File("files/recovery");
			if(!dir.exists())
				dir.mkdirs();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("files/recovery/2-insert_meetings.sql", true));
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ATT_MEETINGS(MEETING_NAME, MEETING_DATE)\r\n");
			sb.append("VALUES(" + values + ");\r\n");
			
			bw.write(sb.toString());
			bw.flush();
			bw.close();
				
		} catch (IOException e) {
			System.out.println("Output file generation failed!");
		}
	}
	
	//3. Insert attendance
	public void generateAttendanceRecoveryFile(String values) {	
		try {
			File dir = new File("files/recovery");
			if(!dir.exists())
				dir.mkdirs();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("files/recovery/3-insert_attendance.sql", true));
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ATT_ATTENDANCE(MEMBER_ID, MEETING_NAME, MEETING_DATE, MEETING_TIME)\r\n");
			sb.append("VALUES(" + values + ");\r\n");
			
			bw.write(sb.toString());
			bw.flush();
			bw.close();
				
		} catch (IOException e) {
			System.out.println("Output file generation failed!");
		}
	}
	
	//CREATION OF OUTPUT TABLES
	public void createAttendanceTables(String meetName, String date) {
		String mn = meetName.replaceAll(" ", "-");
		String d = date.replaceAll("/", "-");
		
		BufferedWriter bw = null;
		try {
			File dir = new File("files/attendanceTables/" + meetName);
			if(!dir.exists())
				dir.mkdirs();
			
			bw = new BufferedWriter(new FileWriter("files/attendanceTables/" + meetName + "/" + mn + "_" + d + ".sql"));
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("CREATE TABLE ").append(mn).append("$").append(d.replaceAll("-","_")).append(" AS(").append("\r\n");
			sb.append("SELECT ATT_MEMBERS.MEMBER_ID, MEMBERNAME, MEMBERMIDDLENAME, MEMBERSURNAME, MEMBER_GROUP, MEETING_TIME").append("\r\n");
			sb.append("FROM ATT_MEMBERS JOIN ATT_ATTENDANCE").append("\r\n");
			sb.append("ON MEETING_NAME = '").append(meetName).append("' AND MEETING_DATE = '").append(date).append("' AND ATT_MEMBERS.MEMBER_ID = ATT_ATTENDANCE.MEMBER_ID);\r\n");
			
			bw.write(sb.toString());
			bw.flush();
			bw.close();
				
		} catch (IOException e) {
			System.out.println("Output file generation failed!");
		}
	}
}
