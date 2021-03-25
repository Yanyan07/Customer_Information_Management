package com.atproject1.util;

import java.util.Scanner;

//encapsulate different functions to methods
public class CMUtility {
	private static Scanner scanner = new Scanner(System.in);
	
	//menu selection: read from keyboard, if enter any char between '1'-'5', return
	public static char readMenuSelection() {
		char c;
		for(; ; ) {
			String str = readKeyBoard(1,false);
			c = str.charAt(0);
			if(c!='1' && c!='2' && c!='3' && c!='4' && c!='5') {
				System.out.print("the choice is wrong, please enter again:");
			}else {
				break;
			}
		}
		return c;
	}
	
	//read a character from keyboard and return it
	public static char readChar() {
		String  str = readKeyBoard(1, false);
		return str.charAt(0);
	}
	
	//read a character from keyboard and return it
	//if users don't enter any character but enter key, return defaultValue
	public static char readChar(char defaultValue) {
		String str = readKeyBoard(1, true);
		return (str.length()==0) ? defaultValue : str.charAt(0);
	}
	
	//read an integer whose length<=2 from keyboard, and return it
	public static int readInt() {
		int n;
		for(; ; ) {
			String str = readKeyBoard(2, false);
			try {
				n = Integer.parseInt(str);
				break;
			} catch (NumberFormatException e) {
				System.out.print("it's a wrong number, please enter again: ");
			}
		}
		return n;
	}
	
	//read an integer whose length<=2 from keyboard, and return it
	//if users don't enter any character but enter key, return defaultValue
	public static int readInt(int defaultValue) {
		int n;
		for(; ; ) {
			String str = readKeyBoard(2, true);
			if(str.equals("")) {
				return defaultValue;
			}
			
			try {
				n = Integer.parseInt(str);
				break;
			} catch (NumberFormatException e) {
				System.out.print("it's a wrong number, please enter again: ");
			}
		}
		return n;
	}
	
	//read a string whose length<=limit from keyboard, and return it
	public static String readString(int limit) {
		return readKeyBoard(limit, false);
	}
	
	//read a string whose length<=limit from keyboard, and return it
	//if users don't enter any character but enter key, return defaultValue
	public static String readString(int limit, String defaultValue) {
		String str = readKeyBoard(limit, true);
		return str.equals("") ? defaultValue : str;
	}
	
	//selection confirmation: read 'Y' or 'N' from keyboard as return value
	public static char readConfirmSelection() {
		char c;
		for(; ; ) {
			String str = readKeyBoard(1, false).toUpperCase();
			c = str.charAt(0);
			if(c=='Y' || c=='N') {
				break;
			} else {
				System.out.print("selection is wrong, please enter again: ");
			}
		}
		return c;
	}
	
	private static String readKeyBoard(int limit, boolean blankReturn) {
		String line = "";
		
		while(scanner.hasNextLine()) {
			line = scanner.nextLine();
			if(line.length() == 0) {
				if(blankReturn) return line;
				else continue;
			}
			
			if(line.length()<1 || line.length()>limit) {
				System.out.println("the length should <= "+limit+" please enter again");
				continue;
			}
			break;
		}
		return line;
	}
}
