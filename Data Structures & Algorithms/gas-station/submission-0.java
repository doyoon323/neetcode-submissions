public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currentTank = 0;
        int startingStation = 0;

        for (int i = 0; i < gas.length; i++) {
            int netGas = gas[i] - cost[i];            
            totalTank += netGas;
            currentTank += netGas;

            if (currentTank < 0) {
                startingStation = i + 1;
                currentTank = 0;
            }
        }
        return totalTank >= 0 ? startingStation : -1;
    }
}