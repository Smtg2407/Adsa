class Solution {
    private void solve(String digits, StringBuilder output, int index, List<String> ans,String[] map){
        if(index>= digits.length()){
            ans.add(output.toString());
            return;
        }
        int num = digits.charAt(index)-'0';
        String val = map[num];
      for(int i=0; i<val.length(); i++){
        output.append(val.charAt(i));
      solve(digits,output,index+1,ans,map);
      output.deleteCharAt(output.length()-1);  
     }
    }
    public List<String> letterCombinations(String digits) {
       List<String> ans = new ArrayList<>();
       if(digits.length() == 0) return ans;
       String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
       StringBuilder output = new StringBuilder();
       int index = 0;
       solve(digits, output, index, ans, map);
       return ans;
    }
}