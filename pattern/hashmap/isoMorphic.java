// Since we need to check the two way mapping we need two maps here
public static boolean isIsomorphic(String string1, String string2) {
        // Initliazing the hashmaps
        Map<Character, Character> mapStr1Str2 = new HashMap <Character, Character> ();
        Map<Character, Character> mapStr2Str1 = new HashMap <Character, Character> ();

        int i = 0, j = 0;

        while (i < string1.length()) {
            char char1 = string1.charAt(i++);
            char char2 = string2.charAt(j++);
            // returning false if char1 in string1 exist in hashmap
            // and the char1 has different mapping in hashmap
            if (mapStr1Str2.containsKey(char1) && mapStr1Str2.get(char1) != char2)
                return false;

            // returning false if char2 in string2 exist in hashmap
            // and the char2 has different mapping in hashmap
            if (mapStr2Str1.containsKey(char2) && mapStr2Str1.get(char2) != char1)
                return false;

            // mapping of char of one string to another and vice versa
            mapStr1Str2.put(char1, char2);
            mapStr2Str1.put(char2, char1);

        }

        return true;
    }
