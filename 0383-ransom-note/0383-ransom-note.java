class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] count= new int[26];

        for(int i = 0; i < magazine.length();i++){
            char ch = magazine.charAt(i);
            count[ch -'a']++;
        }
        for(int i = 0; i < ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            count[ch- 'a']--;

            if(count[ch -'a'] < 0) return false;
        }
        return true;

    }
}