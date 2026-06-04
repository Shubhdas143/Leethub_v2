class Solution {

    public int romanToInt(String s) {

        int sm = 0;

        for(int i = 0;i<s.length();i++){

            int cur = val(s.charAt(i));

            if(i<s.length()-1&&cur<val(s.charAt(i+1))) sm-= cur;
            else sm += cur;

        }

        return sm;
    }

    private int val(char c){

        switch(c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            default : return 1000;

        }
    }
}