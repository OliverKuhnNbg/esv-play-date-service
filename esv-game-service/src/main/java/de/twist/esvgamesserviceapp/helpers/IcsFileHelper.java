package de.twist.esvgamesserviceapp.helpers;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class IcsFileHelper {

	public IcsFileHelper() {
	}

	public File getIcsCalendarFile() {
		Resource resource = new ClassPathResource("Spielplan_ALT-GS_22-01-2024_bis_28-04-2024.ics");
		File file = new File("");

		try {
			file = resource.getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file;
	}
}
