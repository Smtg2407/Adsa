class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int index = 0;

        while(i < chars.length){
            char current = chars[i];
            int count = 0;

            while(i < chars.length && chars[i] == current) {
                i++;
                count++;
            }
            chars[index++] = current;

            if(count > 1) {
                String cnt = String.valueOf(count);

                for(int j = 0; j < cnt.length(); j++){
                    chars[index++] = cnt.charAt(j);
                }
            }
        }
        return index;
    }
}