class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[n];

        q.add(0);
        isVisited[0] = true;

        while(!q.isEmpty()){

            int curr = q.poll();

            for(int i = 0; i < rooms.get(curr).size(); i++){
                int neigh = rooms.get(curr).get(i);

                if(!isVisited[neigh]){
                    isVisited[neigh] = true;
                    q.add(neigh);
                }
            }
        }
        for(int i = 0; i< n; i++){
            if(!isVisited[i]) return false;
        }
        return true;

    }
}