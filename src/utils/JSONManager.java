package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

public class JSONManager {
	
	public String[] getFile() {
		StringBuilder sb = new StringBuilder();
		String[] settings = new String[6];
		String in = "files/settings/connection-preferences.json";
		String line;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(in));
			
			while((line = br.readLine()) != null) {
				sb.append(line).append("\r\n");
			}
			br.close();
			
			JSONObject jsonInput = new JSONObject(sb.toString()) ;
			JSONObject data = jsonInput.getJSONObject("settings");
			
			settings[0] = data.getString("client");
			settings[1] = data.getString("host");
			settings[2] = data.getString("port");
			settings[3] = data.getString("sid");
			settings[4] = data.getString("username");
			settings[5] = data.getString("password");
			
		} catch (IOException e) {
			createFile("oracle", "localhost", "1521", "xe", "SYSTEM", "richard");
		}
		
		return settings;
	}
	
	public void createFile(String client, String host, String port, String sid, String username, String password) {

		StringBuilder sb = new StringBuilder();
		
		sb.append("{").append("\r\n");
		sb.append("\t\"settings\" : {").append("\r\n");
		sb.append("\t\t\"client\" : ").append("\"").append(client).append("\"").append(",\r\n");
		sb.append("\t\t\"host\" : ").append("\"").append(host).append("\"").append(",\r\n");
		sb.append("\t\t\"port\" : ").append("\"").append(port).append("\"").append(",\r\n");
		sb.append("\t\t\"sid\" : ").append("\"").append(sid).append("\"").append(",\r\n");
		sb.append("\t\t\"username\" : ").append("\"").append(username).append("\"").append(",\r\n");
		sb.append("\t\t\"password\" : ").append("\"").append(password).append("\"").append("\r\n");
		sb.append("\t}").append("\r\n");
		sb.append("}").append("\r\n");
		
		try {
			File dir = new File("files/settings");
			if(!dir.exists())
				dir.mkdirs();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("files/settings/connection-preferences.json", false));
			bw.write(sb.toString());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
