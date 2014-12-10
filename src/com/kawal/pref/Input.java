package com.kawal.pref;

import java.util.Scanner;
import java.util.prefs.Preferences;

public class Input {
	private static Preferences prefs;
	String choice;
	Scanner scan = new Scanner(System.in);

	void printOUt() {

		prefs = Preferences.userNodeForPackage(getClass());
		String choice = prefs.get("ID", "choice");
		TestPref test = new TestPref();
		// prefs.putBoolean("isWorth", true);
		// prefs.putInt("type", 4);
		switch (choice) {

		case "car":

			if (prefs.getBoolean("isWorth", true)) {
				System.out
						.println(prefs.get("ID", "Hello World")
								+ " is not worth ,plz buy some good bike and for your info car is "
								+ prefs.getInt("type", 4) + " wheeler");

			} else {
				System.out
				.println(prefs.get("ID", "Hello World")
						+ " is not worth ,plz buy some good bike and for your info car is "
						+ prefs.getInt("type", 4) + " wheeler");
				System.out.println("plz select bike only");
				System.out
						.println("after the user selection  value of pref -->  "
								+ prefs.get("ID", "Hello World!!"));
				System.out
						.println("after the user selection  value of pref for type (wheels) -->  "
								+ prefs.getInt("type", 4));
				System.out
						.println("after the user selection  value of pref for is worth (true/false) -->  "
								+ prefs.getBoolean("isWorth", true));
			}
			break;
		case "bike":
			prefs.remove("isWorth");
			prefs.remove("type");
			prefs.putBoolean("isWorth", true);
			prefs.putInt("type", 2);
			if (prefs.getBoolean("isWorth", true)) {
				System.out
						.println("bike is  worth ,your decision is best for your info bike is "
								+ prefs.getInt("type", 4) + " wheeler");
			} else {
				System.out.println("again wrong decision");
			}
			System.out.println("bike" + prefs.getBoolean("isWorth", true));
			break;
		default:
			System.out.println("not getting");
			break;
		}
		System.out.println("do you want to change your decision   (y/n)");
		String decision = scan.next();
		if (decision.equalsIgnoreCase("y")) {
			test.setPreference();
		} else {
			System.out.println("THANK YOU");
		}
	}
}
