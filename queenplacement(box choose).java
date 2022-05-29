import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        // write your code here
        if((row==tq) && (col==0)){
            if(qpsf == tq){
            System.out.println(asf);
            return;
        }
        }
        
        if(row>=tq || col>=tq){
            return;
        }

        boolean cond = (col == tq-1);
        queensCombinations(qpsf+1, tq, cond?row+1:row, cond?0:col+1, cond?asf+"q"+"\n"
        :asf+"q");
        queensCombinations(qpsf, tq, cond?row+1:row, cond?0:col+1, cond?asf+"-"+"\n"
        :asf+"-");

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}
