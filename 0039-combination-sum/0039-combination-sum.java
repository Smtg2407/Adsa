class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(0, candidates, target, current, result);
        return result;
    }
    public void solve(int index, int[] candidates, int target,List<Integer> current, List<List<Integer>> result){

        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(index == candidates.length || target < 0){
            return;
        }
        current.add(candidates[index]);
        solve(index, candidates, target - candidates[index], current, result);

        current.remove(current.size() - 1);
        solve(index + 1, candidates, target, current, result);
    }
}