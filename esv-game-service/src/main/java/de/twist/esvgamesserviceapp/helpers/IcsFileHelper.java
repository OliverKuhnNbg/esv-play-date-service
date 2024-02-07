package de.twist.esvgamesserviceapp.helpers;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import de.twist.esvgamesserviceapp.constants.Filepath;

public class IcsFileHelper {

	public IcsFileHelper() {
	}

	public static File getIcsCalendarFile() {
		Resource resource = new ClassPathResource(Filepath.STATIC.value + Filepath.GAME_SHEDULES.value + Filepath.H1_FILENAME.value);
		File file = new File("");

		try {
			file = resource.getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file;
	}
}
