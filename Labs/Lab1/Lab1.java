import java.util.ArrayList;
import java.util.Scanner;

public class Lab1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> nums = new ArrayList<Integer>();
		System.out.println("Target Number?: ");
		int target = in.nextInt();
		System.out.println("How many integers in array?: ");
		int amt = in.nextInt();
		for (int i = 0; i < amt; i ++) {
			nums.add(i);
		}
		for (int i = 0; i < nums.size(); i++) {
			for (int j = i + 1; j < nums.size(); j++) {
				if (nums.get(i) + nums.get(j) == target) {
					System.out.println(nums.get(i) + " + " + nums.get(j) + " = " + target);
					return;
				}
			}
		}
		System.out.println("Target is too big for these integers!");
	}
}
