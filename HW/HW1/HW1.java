import java.util.*;

public class HW1 {
	public static String removeNonAlphanumeric(String str) {
		str = str.replaceAll("[^a-zA-Z0-9]", "");
		return str;
	}
	public static boolean pali(String str) {
		ArrayList<Character> charArray = new ArrayList<Character>();
		ArrayList<Character> charArray2 = new ArrayList<Character>();
		int count = 0;
		str = str.toLowerCase();
		str = removeNonAlphanumeric(str);
		for (int i = 0; i < str.length(); i++) {
			charArray.add(str.charAt(i));
		}
		for (int i = charArray.size()-1; i >= 0; i--) {
			charArray2.add(charArray.get(i));
		}
		int correct = charArray.size();
		for (int i = 0; i < charArray.size(); i++) {
			if (charArray.get(i) == charArray2.get(i)) {
				count++;
			}
		}
		if (count == correct) {
			System.out.println("TRUE!");
			return true;
		}
		System.out.println("false...");
		return false;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Your phrase: ");
		String s = in.nextLine();
		pali(s);
	}
}
