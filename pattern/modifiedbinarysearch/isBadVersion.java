static int[] firstBadVersion(int n) {
        int[] result = new int[2];
        int first = 1;
        int last = n;
        int calls = 0;
        while (first<last)
        {
          int mid = first + (last - first) / 2;
          // This is the binary search condition
          if (isBadVersion(mid)) {
            last = mid;
          } else {
            first = mid + 1;
          }
          calls += 1;
        }
        result[0] = first;
        result[1] = calls;
        return result;
    }
