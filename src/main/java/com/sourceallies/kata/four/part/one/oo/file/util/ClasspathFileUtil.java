package com.sourceallies.kata.four.part.one.oo.file.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ClasspathFileUtil {

	@SuppressWarnings("unchecked")
	public List<String> extractLines(String filename) {
		URL resource = this.getClass().getClassLoader().getResource(filename);
		File file = FileUtils.toFile(resource);
		try {
			return FileUtils.readLines(file);
		} catch (IOException e) {
			return new ArrayList<String>();
		}
	}

}
