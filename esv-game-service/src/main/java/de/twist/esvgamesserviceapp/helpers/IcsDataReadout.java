package de.twist.esvgamesserviceapp.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IcsDataReadout {
	
	public static String getMappedIcsData(File file) {
		FileReader fileReader;
		
		try {
			fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			String currentLine = getReadoutDataFromFile(br);
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "oli";
	}
	
	private static String getReadoutDataFromFile(BufferedReader bufferedReader) throws IOException {
		String currentLine = "";
		boolean newEventSwitch = false;

		for (int i = 0; (currentLine = bufferedReader.readLine()) != null; i++) {
			if(currentLine.equals("BEGIN:VEVENT")) {
				newEventSwitch=true;
				System.out.println("***********************************************\n");
			} else if(currentLine.equals("END:VEVENT")){
				newEventSwitch=false;
			}
			
			if (newEventSwitch && !currentLine.equals("BEGIN:VEVENT")) {
				//TODO: read out data datamapping to objects
				System.out.println(currentLine);
			}
		}

		return currentLine;
	}

}
