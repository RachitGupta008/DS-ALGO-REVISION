import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s=scn.nextLine();
    List<String>ans=restoreIpAddresses(s);
    System.out.println(ans);
  }
  public static List<String> restoreIpAddresses(String s) {
       //write your code here
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
