class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int startA, endA, startB,endB;
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++)
        {
            startA = landStartTime[i];
            endA = startA + landDuration[i];
            for(int j = 0; j < m; j++)
            {
                startB = waterStartTime[j];
                
                if(startB <= endA)
                {
                    endB = waterDuration[j] + endA;
                }
                else {
                    endB = waterDuration[j] + (startB);
                }
                ans = Math.min(ans, endB);
            }
        }
        
        for(int i = 0; i < m; i++)
        {
            startB = waterStartTime[i];
            endB = startB + waterDuration[i];
            for(int j = 0; j < n; j++)
            {
                startA = landStartTime[j];
                
                if(startA <= endB)
                {
                    endA = landDuration[j] + endB;
                }
                else{
                    endA = landDuration[j] + (startA);
                }
                ans = Math.min(ans, endA);
            }
        }
        return ans;
    }
}