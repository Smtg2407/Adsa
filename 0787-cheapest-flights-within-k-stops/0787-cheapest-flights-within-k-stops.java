class Solution {
    class Pair{
        int node;
        int cost;
        int stops;

        Pair(int node, int cost, int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int price = flights[i][2];

            adj.get(u).add(new int[]{v, price});
        }
        Queue<Pair> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        q.add(new Pair(src, 0, 0));
        dist[src] = 0;

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int node = curr.node;
            int cost = curr.cost;
            int stops = curr.stops;

            if (stops > k) {
                continue;
            }

            for (int i = 0; i < adj.get(node).size(); i++) {

                int nextNode = adj.get(node).get(i)[0];
                int nextCost = adj.get(node).get(i)[1];

                if (cost + nextCost < dist[nextNode]
                        && stops <= k) {

                    dist[nextNode] = cost + nextCost;

                    q.offer(new Pair(
                            nextNode,
                            dist[nextNode],
                            stops + 1
                    ));
                }
            }
        }
        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dst];
        }
    }
}