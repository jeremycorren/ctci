/**
 * Compress a string using counts of repeated chars.
 */

public class Compression {

	/**
	 * Compare neighbors and construct new compressed string
	 * Time: O(len(s))
	 */
	public static String compress(String s) {
		int count = 0;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) { //O(len(s))
			count++;

			// If at end of string or char is about to stop repeating,
			// Append current char and number of occurrences
			if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
				sb.append(s.charAt(i));
				sb.append(count);
				count = 0;
			}
		}
		return sb.toString();
	}

	

	public static void main(String[] args) {
		System.out.println(compress("aabcccccaaa"));
	}
}