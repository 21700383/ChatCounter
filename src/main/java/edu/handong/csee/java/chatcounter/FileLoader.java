package edu.handong.csee.java.chatcounter;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileLoader {
	private ArrayList<String> messages;
	
	public void readDirectory(String path){
		
		ArrayList<File> fileNames = getFileNames(path); // get files from the path
        BufferedReader br = null;
        
		for(File fileName:fileNames) { // for each file name in fileNames
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
				String line;
				while ((line = br.readLine()) != null) { // while loop begins here
					//System.out.println(thisLine);
					messages.add(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
