package com.kawal.pref;

import java.util.Scanner;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class TestPref {
	private Preferences prefs;
	static TestPref test = new TestPref();
	public void setPreference() {
		Input obj = new Input();
		prefs = Preferences.userNodeForPackage(getClass());
		try {
			prefs.clear();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("before the user selection default value of pref -->  "
				+ prefs.get("ID", "Hello World!!"));
		System.out.println("before the user selection default value of pref for type (wheels) -->  "
				+ prefs.getInt("type", 0));
		System.out.println("before the user selection default value of pref for is worth (true/false) -->  "
				+ prefs.getBoolean("isWorth", true));
		Scanner scan = new Scanner(System.in);
		System.out.println("you want car or bike");
		String input = scan.next();
		if (input.equalsIgnoreCase("car") || input.equalsIgnoreCase("bike")) {
			prefs.put("ID", input);
			System.out.println("after the user selection value of pref is --> "
					+ prefs.get("ID", "Hello World"));
			obj.printOUt();
		} else {
			System.out.println("plz type car or bike only");
			test.setPreference();
		}

	}

	public static void main(String[] args) {
		
		test.setPreference();
	}
}
