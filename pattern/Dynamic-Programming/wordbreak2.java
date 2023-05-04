Here's a breakdown of the time complexity:

The for-loop iterates through the dictionary, taking O(m) time for each iteration.
The helper function is called recursively for each prefix of the input string 's', which can be at most n prefixes.
Due to memoization, each unique substring of 's' is computed only once and then cached in the 'result' map. However, the worst-case scenario involves trying all possible combinations of breaking the string 's', which is 2^n possibilities.
So, the total time complexity is O(n * m + n^2 + 2^n).

To clarify, O(n * m) comes from iterating through the dictionary for each recursive call, O(n^2) comes from the memoization map for caching each unique substring, and O(2^n) accounts for the worst-case scenario of trying all possible combinations of breaking the string 's'.
class WordBreak {

  public static List<String> wordBreak(String s, List<String> wordDict) {
      //Calling the helper function
      return helper(s, wordDict, new HashMap<String, List<String>>());
  }
  //Helper Function that breaks down the string into words from subs
  public static List<String> helper(String s, List<String> dictionary, Map<String, List<String>> result) {
      //If s is empty string
      if (s.isEmpty()) {
        return new ArrayList<String>();
      }
      if (result.containsKey(s)) {
        return result.get(s);
      }
      List<String> res = new ArrayList<String>();
      //Verifying if s can be broken down further
      for (String word : dictionary) {
        if (!s.startsWith(word)) {
          continue;
        }
        if (word.length() == s.length()) {
          res.add(s);
        } else {
          List<String> resultOfTheRest = helper(s.substring(word.length()), dictionary, result);
          for (String item : resultOfTheRest) {
            item = word + " " + item;
            res.add(item);
          }
        }
      }
      result.put(s, res);
      return res;
  }
  
  public static void main(String args[]) {
    List<String> subs = Arrays.asList("an", "book", "car", "cat", "cook", "cookbook", "crash",
        "cream", "high", "highway", "i", "ice", "icecream", "low", "scream",
        "veg", "vegan", "way", "hello", "from", "what", "cats", "and", "dog",
        "sand", "pineapple", "pine", "apple", "pen", "applepen");

    String[] s = {"vegancookbook", "catsanddog", "highwaycrash",
        "pineapplepenapple", "screamicecream"};

    System.out.println(
        "The list of words we can use to break down the strings are");
    System.out.println(subs + "\n");
    for (int i = 0; i < s.length; i++) {
      System.out.print((i + 1) + ".\tThe possible strings from the string: "
          + s[i] + " are the following combinations ");
      System.out.println("\n\t" + wordBreak(s[i], subs));
      System.out.println(PrintHyphens.repeat("-", 100));
    }
  }
}
