 class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int li = 0;   // lower index
        int hi = letters.length-1;  // higher index

        while(li<=hi){
            int mid = (li+hi)/2;
            
            if(letters[mid]<=target){ // if target element is greater than or equal to mid element then li would be the next element after the middle one
                li = mid+1;
            }
            else{
                hi = mid-1; // if target element is less than middle one then hi would be one element less than the middle one
            }
        }
        return letters[li % letters.length]; // if there are no characters in letters greater than the target element then return the element at index 0
    }
}