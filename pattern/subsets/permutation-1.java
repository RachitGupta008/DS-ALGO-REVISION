As before, there are a total of n! (factorial) possible permutations for a string of length n. This is because there are n choices for the first character, (n-1) choices for the second character, (n-2) choices for the third character, and so on.

In each recursive call of the perm function, the algorithm appends a character to the StringBuilder object temp, which takes O(1) time. Since there are n! possible permutations, the overall cost of appending characters is O(n!).

However, we also have a cost associated with converting the StringBuilder to a String when adding it to the ans ArrayList. This operation takes O(n) time. Since it happens for each of the n! permutations, the overall cost of converting StringBuilder objects to strings is O(n! * n).

Therefore, the overall time complexity of the algorithm using StringBuilder is O(n! * n). This is an improvement over the original algorithm that used String, which had a time complexity of O(n! * n^2) due to the additional cost of string concatenation.

public static ArrayList<String> permuteWord(String word) {
        ArrayList<String> ans = new ArrayList<>();
        perm(word, new boolean[word.length()], new StringBuilder(), ans);
        return ans;
    }

    static void perm(String word, boolean[] used, StringBuilder temp, ArrayList<String> ans) {
        if (temp.length() == word.length()) {
            ans.add(temp.toString());
        }

        for (int i = 0; i < word.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                temp.append(word.charAt(i));
                perm(word, used, temp, ans);
                temp.deleteCharAt(temp.length() - 1);
                used[i] = false;
            }
        }
    }
