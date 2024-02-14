import java.util.*;

public class Lab2 {
	public static String removeNonAlphanumeric(String str) {
		str = str.replaceAll("[^a-zA-Z0-9]", "");
		return str;
	}
	public static boolean compare(String str1, String str2) {
		// Checks if both are same length
		str1 = removeNonAlphanumeric(str1);
		str2 = removeNonAlphanumeric(str2);
		if (str1.length() != str2.length()) {
			return false;
		}
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		ArrayList<Character> strArray = new ArrayList<Character>();
		for (int i = 0; i < str1.length(); i++) {
			strArray.add(str1.charAt(i));
		}
		// Integer to count if each letter can be found in both words
		int count = 0;
		// ArrayList to store str1's letters
		// Compare every letter in str2 with every 
		// letter in str1 (stored in the ArrayList)
		for (int i = 0; i < str2.length(); i++) {
			for (int j = 0; j < strArray.size(); j++) {
				if (str2.charAt(i) == strArray.get(j)) {
					count++;
					strArray.remove(j);
				}
			}
		}
		// If the for loop runs correctly, the count
		// should match with the amount of letters in
		// str1
		if (count == str1.length()) {
			System.out.println("true");
			return true;
		}
		else {
			System.out.println("false");
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("First word?: ");
		String s = in.nextLine();
		System.out.println("Second word?: ");
		String t = in.nextLine();
		compare(s, t);
	}
}