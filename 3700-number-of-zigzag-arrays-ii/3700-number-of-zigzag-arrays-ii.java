class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int range=r-l+1;
        if(n==1) return range;
        if(n==2) return(range*(range-1)) %1000000007;
        int size=2*range;
        long[][]arr=new long[size][size];
        for(int v=0; v<range; v++){
            for(int p=0; p<v; p++){
                arr[v][range+p]=1;
            }
            for(int p=v+1; p<range; p++){
                arr[range+v][p]=1;
            }
        }
        long arr2[][]=matrixPower(arr,n-2,size);
        long[]initial=new long[size];
        for(int p=0; p<range; p++){
            for(int v=0; v<range; v++){
                if(p<v){
                    initial[v]++;
                }else if(v<p){
                    initial[v+range]++;
                }
            }
        }
        long totalArrays=0;
        for(int i=0; i<size; i++){
            long ways=0;
            for(int j=0; j<size; j++){
                ways=(ways+arr2[i][j]*initial[j])%1000000007;
            }
            totalArrays=(totalArrays+ways)%1000000007;
        }
        return (int)totalArrays;
    }
    private long[][]multiply(long[][]a,long[][]b,int size){
        long[][]c=new long[size][size];
        for(int i=0; i<size; i++){
            for(int k=0; k<size; k++){
                if(a[i][k]==0){
                    continue;
                }
                for(int j=0; j<size; j++){
                    c[i][j]=(c[i][j]+a[i][k] *b[k][j]) % 1000000007;
                }
            }
        }
        return c;
    }
    private long[][]matrixPower(long[][]base,int exp,int size){
        long[][]res=new long[size][size];
        for(int i=0; i<size; i++){
            res[i][i]=1;
        }
        while(exp>0){
            if((exp & 1)==1){
                res=multiply(res,base,size);
            }
            base=multiply(base,base,size);
            exp>>=1;
        }
        return res;
    }
}