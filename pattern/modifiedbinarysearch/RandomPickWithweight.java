class RandomPickWithWeight {
    private int[] cumSums;
    // Constructor
    public RandomPickWithWeight(int[] w) {
        this.cumSums = new int[w.length];
        int cumSum = 0;
        // Calculating the weights running sums list
        for (int i = 0; i < w.length; i++) {
            cumSum += w[i];
            this.cumSums[i] = cumSum;
        }
    }
// The logic is to repsenet the probablity in a stright line so each section in a running sum list will contain the no selected and the first no greater than the selected no becomes our ans
    public int pickIndex() {
        double target = this.cumSums[this.cumSums.length - 1] * Math.random();
        // Assigning low pointer at the start of the array
        int low = 0;
        // Assigning high pointer at the end of the array
        int high = this.cumSums.length;
        // Binary search to find the target
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target > this.cumSums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
