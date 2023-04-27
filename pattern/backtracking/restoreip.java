
The time complexity of the restoreIpAddresses method is O(3^4), which is the maximum number of recursive calls that can be made in the worst case scenario. This occurs when the given string contains 12 or more characters, and every three characters form a valid IP address component. In this case, the algorithm will make at most 3 recursive calls for each of the 4 IP address components, resulting in a total of 3^4 = 81 recursive calls.

The space complexity of the algorithm is O(1), as the algorithm does not use any extra space other than the input string and the list of output IP addresses. The recursive calls do not consume any additional space on the stack, as the maximum depth of the recursion is limited to 4 levels, which is a constant value. Therefore, the overall space complexity of the algorithm is constant.

class Solution {
    public List<String> restoreIpAddresses(String s) {
         List<String> ans = new ArrayList<>();
    helper(1, s, "", ans);
    return ans;
    }
    
    public static void helper(int pos, String s,String asf, List<String> ans){
      if(pos==5){
        if(s.equals("")){
          ans.add(asf);
        }
        return;
      }

      if(s.equals("")){
        return;
      }


      for(int i=0;i<3;i++){
        if(isPossible(s,i+1)){
          if(pos == 4){
            helper(pos+1, s.substring(i+1), asf+s.substring(0, i+1), ans);
          }else{
            helper(pos+1, s.substring(i+1), asf+s.substring(0, i+1)+".", ans );
          }
        }


      }



    }

    public static boolean isPossible(String s, int i){
      if(i>s.length()){
        return false;
      }else{
        String sb = s.substring(0, i);
        if(Integer.parseInt(sb)>255){
          return false;
        }
        if(sb.charAt(0)=='0' && sb.length()>1){
          return false;
        }

      }
      return true;
    }
}
