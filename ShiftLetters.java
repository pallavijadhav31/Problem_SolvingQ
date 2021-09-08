/*
You are given a string s of lowercase English letters and an integer array shifts of the same length.

Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').

For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.

Return the final string after all such shifts to s are applied.
*/
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] sc=s.toCharArray();
        for(int i=shifts.length-2;i>=0;i--){
            shifts[i]+=shifts[i+1];
            shifts[i]%=26;
        }
        for(int itr=0;itr<shifts.length;itr++){
            sc[itr]=(char)((sc[itr]-'a'+shifts[itr])%26+'a');
        }
        return String.valueOf(sc);
    }
}
