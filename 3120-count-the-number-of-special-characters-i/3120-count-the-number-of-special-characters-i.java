class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();

        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for(int i = 0; i< n; i++){
            set.add(word.charAt(i));
        }

        for(char ch = 'a'; ch <= 'z'; ch++){
            if(set.contains(ch) && set.contains(Character.toUpperCase(ch))){
                count++;
            }
        } 
        return count;
        
    }
}