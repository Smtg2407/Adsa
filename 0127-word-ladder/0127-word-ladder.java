class Solution {
    class Pair {
        String word;
        int dist;

        Pair(String word, int dist){
            this.word = word;
            this.dist = dist;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair> q = new LinkedList<>();

        HashSet<String> set = new HashSet<>(wordList);

        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);
        if(!set.contains(endWord)) return 0;

        while(!q.isEmpty()){
            Pair curr = q.poll();

            String currWord = curr.word;
            int dist = curr.dist;

            char wordArr[] = currWord.toCharArray();

            for(int i = 0; i< wordArr.length;i++){
                char original = wordArr[i];

                for(char j = 'a';j <='z';j++){

                    wordArr[i] = j;

                    String newWord = new String(wordArr);

                    if(newWord.equals(endWord)) return dist + 1;

                    if(set.contains(newWord)){
                        q.add(new Pair(newWord, dist + 1));

                        set.remove(newWord);
                    }
                }
                wordArr[i] = original;
            }


        }
        return 0;

        
    }
}