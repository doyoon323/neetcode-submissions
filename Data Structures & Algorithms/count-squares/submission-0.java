class CountSquares {
    private int[][] counts;
    private List<int[]> points;

    public CountSquares() {
        counts = new int[1001][1001];
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        
        counts[x][y]++;
        points.add(point);
    }
    
    public int count(int[] point) {
        int qx = point[0];
        int qy = point[1];
        int totalSquares = 0;

        for (int[] p : points) {
            int px = p[0];
            int py = p[1];

            if (Math.abs(qx - px) == Math.abs(qy - py) && qx != px) {
                
                int count2 = counts[qx][py];
                int count4 = counts[px][qy];

                totalSquares += count2 * count4;
            }
        }

        return totalSquares;
    }
}