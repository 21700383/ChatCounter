package edu.handong.csee.java.chatcounter;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class FileLoader {
	private ArrayList<String> messages;
	
	public void readDirectory(String path) {
		
		ArrayList<File> fileNames = getFileNames(path); // get files from the path
		Scanner inputStream = null;
		
		for(File fileName:fileNames) { // for each file name in fileNames
			try {
				//System.out.println(fileName);
				inputStream = new Scanner (fileName);
			} catch (FileNotFoundException e) {
				System.out.println ("Error opening the file " + fileName);
				System.exit (0);
			}
			while (inputStream.hasNextLine ()) {
				String line = inputStream.nextLine ();
				System.out.println (line);
				messages.add(line);
			}
		}
		inputStream.close ();
	}

	
	private ArrayList<File> getFileNames(String path) {
		
		ArrayList<File> fileNames = new ArrayList<File>();
		
		File myPath = new File(path); // get file names in the directory
		
		for(File fileName: myPath.listFiles()) {
			fileNames.add(fileName); // add file name to array list
		}
		
		return fileNames;
	}
	
	public ArrayList<String> getMessages(){
		return messages;
	}
}
