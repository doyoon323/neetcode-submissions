public class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean hasX = false;
        boolean hasY = false;
        boolean hasZ = false;

        int x = target[0];
        int y = target[1];
        int z = target[2];

        for (int[] t : triplets) {
            if (t[0] > x || t[1] > y || t[2] > z) {
                continue;
            }

            if (t[0] == x) hasX = true;
            if (t[1] == y) hasY = true;
            if (t[2] == z) hasZ = true;

            if (hasX && hasY && hasZ) {
                return true;
            }
        }

        return hasX && hasY && hasZ;
    }
}