class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i< edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            if(curr == destination) return true;

            for(int i = 0; i< adjList.get(curr).size() ;i++){
                int neighbour = adjList.get(curr).get(i);

                if(visited[neighbour]== false){
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
        return false;
    }
}