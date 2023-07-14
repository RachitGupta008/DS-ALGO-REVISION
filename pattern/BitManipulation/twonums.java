public static int[] twoSingleNumbers(int[] arr) {
        int bitwise = 0;
        for (int i: arr) {
            bitwise ^= i;
        }
        // the least significant bit can be found with number ^ (-number)
        int bitmask = bitwise & (-bitwise);
        // divide into two groups of numbers, here we want the group with bit set
        // which results in one of the numbers we want due to the property X ^ X = 0
        int results = 0;
        for (int i: arr) {
            if ((bitmask & i) != 0) {
                results = results ^ i;
            }

        }
        int[] res = new int[2];
        res[0] = results;
        res[1] = bitwise ^ results;
        return res;
    }
