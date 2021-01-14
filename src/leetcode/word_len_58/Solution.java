package leetcode.word_len_58;

class Solution {
    public static int lengthOfLastWord(String s) {
        int len = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ' && s.charAt(i+1)!=' '){
                len = -1;
            }
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "";
        int len = Solution.lengthOfLastWord(s);
        System.out.println(len);
    }
}

