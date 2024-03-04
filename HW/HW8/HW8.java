import java.util.HashMap;
import java.util.Scanner;

public class HW8 {
	HashMap<Character, Integer> frequency;
	
	public int longestPalindrome(String s) {
		if(s.length() < 1 || s.length() > 2000) {
			return 0;
		}
		frequency = new HashMap<>();
		int count = 0;
		int odd = 0;
		frequency.put(s.charAt(0), 1);
		for(int i = 1; i < s.length(); i++) {
			if(frequency.containsKey(s.charAt(i))) {
				frequency.replace(s.charAt(i), frequency.get(s.charAt(i))+1);
			}
			else {
				frequency.put(s.charAt(i), 1);
			}
		}
		for(Character c: frequency.keySet()) {
			if(frequency.get(c) % 2 == 0) {
				count += frequency.get(c);
			}
			else if(odd == 0 && frequency.get(c) % 2 == 1) {
				count += frequency.get(c);
				odd++;
			}
			else {
				count += frequency.get(c) - 1;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		HW8 run = new HW8();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a phrase: ");
		String str = in.nextLine();
		System.out.println(run.longestPalindrome(str));
	}
}
