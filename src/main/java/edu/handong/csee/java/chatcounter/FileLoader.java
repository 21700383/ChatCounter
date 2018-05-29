package edu.handong.csee.java.chatcounter;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * FileLoader class containing private array list of string messages
 * and public method readDirectory,getMessages and private method getFileNames
 * @author Admin
 *
 */
public class FileLoader {
	private ArrayList<String> messages = new ArrayList<String>();
	
	/**
	 * method which gets input of file names in file directory path and put the content into messages.
	 * @param path
	 */
	public void readDirectory(String path){
		
		//HaspMap<String.ArrayList<Message>> messages = new HashMap<string.ArrayList<Message>>();
		ArrayList<File> fileNames = getFileNames(path); // get files from the path
        
		for(File fileName:fileNames) { // for each file name in fileNames
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
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
	//if(file.getName().endWith(".csv"))
	private ArrayList<File> getFileNames(String path) {
		
		ArrayList<File> fileNames = new ArrayList<File>();
		
		File myPath = new File(path); // get file names in the directory
		
		for(File fileName: myPath.listFiles()) {
			fileNames.add(fileName); // add file name to array list
		}
		
		return fileNames;
	}
	/**
	 * method to get the messages collected from input file
	 * @return
	 */
	public ArrayList<String> getMessages(){
		return messages;
	}
}
