/**
 * Given two strings, determine whether one is a rotation of the other.
 */

public class Rotation {

	/**
	 * If we split s such that s = xy,
	 * 	t is a rotation of s if t = yx
	 * 	We know that xy is a substring of yxyx, or y(xy)x
	 * Time: O(max(len(s), len(t))
	 */
	public static boolean isRotation(String s, String t) {
		String conc = t.concat(t); // O(len(t))
		return conc.contains(s); // avg case O(len(s))
	}

	public static void main(String[] args) {
		System.out.println(isRotation("waterbottle", "erbottlewat"));
		System.out.println(isRotation("waterbottle", "erbottlewav"));
	}
}