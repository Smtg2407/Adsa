class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;

        int[] ans = new int[n];

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i < n; i++){
            q.add(i);
        }
        for(int i = 0;i < n; i++){
            int idx = q.poll();
            ans[idx] = deck[i];

            if(!q.isEmpty()){
                q.add(q.poll());
            }
        }
        return ans;
    }
}