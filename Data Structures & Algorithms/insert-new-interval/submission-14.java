class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start=0, end=0; //앞,뒤에 몇개 있느냐 
        int min=newInterval[0], max=newInterval[1]; 
        int n = intervals.length+1;

        for(int i=0;i<intervals.length;i++){
            int s = intervals[i][0];
            int e = intervals[i][1];
            System.out.println("start : "+i);

        
            if(e<newInterval[0]){ //같아질 때는? 
                start++;
                System.out.println(e+ " < " + newInterval[0]);
            }
            else if(s>newInterval[1]){
                end++;
                System.out.println(s+ " > " + newInterval[1]);
            }
            //포함되거나 
            else if(newInterval[0]<= s && e <= newInterval[1]){
                n--; 
                System.out.println(s+ " <= " +e + " && "+e+" <= "+ newInterval[1]);
            }
            else if(s<= newInterval[0] && newInterval[1]<=e) return intervals; 
            else if(newInterval[0]<=e){
                n--;
                min = Math.min(min,s);
                max = Math.max(max,e);
                i++; 
                while(i<intervals.length){
                    if(newInterval[1]<intervals[i][0]) {
                        i--;
                        break;
                    }

                    n--;
                    max = Math.max(max,intervals[i][1]);
                    i++; 
                }
                System.out.println("min: " + min);
            }
            else if(s<=newInterval[1]){
                n--;
                max = Math.max(max,e);
                System.out.println("max: "+ max);
                break;
            }
            
        }



        int[][] res = new int[n][2];

        for(int i=0; i<start;i++){
            res[i][0]= intervals[i][0];
            res[i][1]= intervals[i][1];
        }

        res[start][0] = min;
        res[start][1] = max; 
//end = 4 
        for(int i=0;i<end;i++){
            res[start+i+1][0]= intervals[intervals.length-1-(end-1-i)][0];
            res[start+i+1][1]= intervals[intervals.length-1-(end-1-i)][1];
        }

        return res; 
    }
}
