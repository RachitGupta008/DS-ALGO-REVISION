// It works based on the fact of skipping middle values between start and the location where our total gas becomes zero
Lerning is in order to reach a solution you have to first make a n^2 solution and then move from that.

public static int gasStationJourney(int[] gas, int[] cost) {
        if (Arrays.stream(cost).sum() > Arrays.stream(gas).sum()) // If the sum of the costs is greater than the gas
            return -1; // available to us, then we can't ever reach the same point again.
        // Setting the indexes that we will start our analysis from
        int totalGas = 0;
        int startingIndex = 0; // Setting the indexes that we will start our analysis from
        for (int i = 0; i < gas.length; i++) { // Traversing the array from start to finish
            // Checking how much gas we have left in the tank after going to the next station
            totalGas = totalGas + (gas[i] - cost[i]);
            if (totalGas < 0) {
                totalGas = 0;
                startingIndex = i + 1;
            }

        }
        return startingIndex;
    }
// Other solution is this in this we don't check if the solution is possible or not
// we just move and see if at any point the gas req becomes negative we add it to need balance
// so in moving forward if the solution is there we are guranteed to have a +ive totalGas balance and this will balance out the need balance
// if in any case the totalGas balance becomes -ive at end then the solution might not be there or it doesn't balance out the needs balance

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //if (Arrays.stream(cost).sum() > Arrays.stream(gas).sum()) // If the sum of the costs is greater than the gas
           // return -1; // available to us, then we can't ever reach the same point again.
        // Setting the indexes that we will start our analysis from
        int totalGas = 0;
        int need = 0;
        int startingIndex = 0; // Setting the indexes that we will start our analysis from
        for (int i = 0; i < gas.length; i++) { // Traversing the array from start to finish
            // Checking how much gas we have left in the tank after going to the next station
            totalGas = totalGas + (gas[i] - cost[i]);
            if (totalGas < 0) {
                need = need + totalGas;
                totalGas = 0;
                
                startingIndex = i + 1;
            }

        }
        //System.out.println(need);
        if(need+totalGas>=0){
            return startingIndex;
        }
        return -1;
    }
}
