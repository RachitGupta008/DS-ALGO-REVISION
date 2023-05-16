class Solution {
    class Pair {
	int first;
	char second;

	public Pair(int first, char second) {
		this.first = first;
		this.second = second;
	}
}

    public String minRemoveToMakeValid(String s) {
        Stack<Pair> delimiters = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (delimiters.size() > 0 && delimiters.peek().second == '(' && s.charAt(i) == ')')
				// closing parenthesis found while top of stack
				// is an opening parenthesis, so pop the
				// opening parenthesis as it's part of a pair
				delimiters.pop();
			else if (s.charAt(i) == '(' || s.charAt(i) == ')') {
				// parenthesis found, push to stack for checking
				// against the rest of the string
				Pair p = new Pair(i, s.charAt(i));
				delimiters.push(p);
			}
		}

		// At this point, the stack stores the indices
		// that need to be removed from the input string

		StringBuilder builder = new StringBuilder();

		int count = 0;
		int c = delimiters.size();
		for (int x = s.length() - 1; x >= 0; x--) {
			if (count < c && delimiters.peek().first == x) {
				// compile the result string, skipping the
				// indices that need to be removed from the input
				delimiters.pop();
				count++;
			} else
				builder.append(s.charAt(x));
		}

		return builder.reverse().toString();
    }
}
