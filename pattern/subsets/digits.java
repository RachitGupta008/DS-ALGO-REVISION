class LetterCombinations {
    public void backtrack(int index, StringBuilder path, String digits, Hashtable<Integer, String> digitsMapping, List<String> combinations) {
        // If the length of path and digits is same,
        // we have a complete combination
        String s="";
        if (path.length() == digits.length()) {
            s= s.concat(path.toString());
            combinations.add(s);
            return; // Backtrack
        }
        
        // Get the letters that the current digit maps to, and loop through them
        String possibleLetters = digitsMapping.get(Integer.parseInt(String.valueOf(digits.charAt(index))));
        
        for (char letter: possibleLetters.toCharArray()) {
            // Add the letter to our current path
            path.append(letter);
            // Move on to the next digit
            backtrack(index + 1, path, digits, digitsMapping, combinations);
            // Backtrack by removing the letter before moving onto the next
            path.deleteCharAt(path.length() - 1);
        }
    }


    public List<String> letterCombinations(String digits) {
        
        List<String> combinations = new ArrayList<>();
        combinations.clear();
        
        // If the input is empty, immediately return an empty answer array
        if (digits.length() == 0) {
            return combinations;
        }
        //  Mapping the digits to their corresponding letters
        Hashtable<Integer, String> digitsMapping = new Hashtable<>();
        digitsMapping.put(1, "");
        digitsMapping.put(2, "abc");
        digitsMapping.put(3, "def");
        digitsMapping.put(4, "ghi");
        digitsMapping.put(5, "jkl");
        digitsMapping.put(6, "mno");
        digitsMapping.put(7, "pqrs");
        digitsMapping.put(8, "tuv");
        digitsMapping.put(9, "wxyz");
        // Initiate backtracking with an empty path and starting index of 0
        backtrack(0, new StringBuilder(), digits, digitsMapping, combinations);
        return combinations;
    }
    
    
    public static void main(String[] args){
       LetterCombinations sol = new LetterCombinations();
       String[] digitsArray = {"2", "73", "426", "78", "925", "2345"};
       for(int i=0; i< digitsArray.length; i++){
          System.out.println("All letter combinations for  "+digitsArray[i]+ " "+ sol.letterCombinations(digitsArray[i]));
          System.out.println(PrintHyphens.repeat("-", 100));
       }
    }
}
