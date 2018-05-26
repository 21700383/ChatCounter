package edu.handong.csee.java.chatcounter;

import java.util.Scanner;
import java.util.ArrayList;


/**
 * ChatCounter class containing main method 
 * and String Array list variable messages
 */
public class ChatCounter {
	private static ArrayList<String> messages;
	
	/**
	 * main method which gets path of directory and use other classes to read the files and
	 * count total number of messages per person
	 * @param args
	 */
	public static void main(String[] args) {
		
		// loading a file
		//read files from mac, read files from windows
		//parsing messages
		//find numbers
		//export result file
		
		String path;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Input directory:");
		path = keyboard.nextLine();
		
		FileLoader loadFile = new FileLoader();
		loadFile.readDirectory(path);
		messages = loadFile.getMessages();
		
		System.out.println("End of main");
		System.out.println(messages);
		keyboard.close();
	}
}
