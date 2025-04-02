import java.util.*;

class Solution {
	public boolean solution(String[] phone_book) {

		HashSet<String> set = new HashSet<>();
		for (String p : phone_book) {
			set.add(p);
		}

		for (String phone : phone_book) {

			for (int j = 1; j < phone.length(); j++) {
				if (set.contains((phone.substring(0, j)))) {
					return false;
				}
			}
		}
		return true;
	}
}