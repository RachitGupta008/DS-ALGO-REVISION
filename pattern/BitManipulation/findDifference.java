class Solution {
    public char findTheDifference(String s, String t) {
        
        int xor = s.chars().reduce(0, (a, b) -> a ^ b); // XOR for string s
        int xor2 = t.chars().reduce(0, (a, b) -> a ^ b); // XOR for string t
        int res = xor2 ^ xor;

       return (char) res;
    }
}
