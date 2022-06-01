

import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer> sol = new ArrayList<>();

    public static void solution(int[] people, int nskills, int cp, ArrayList<Integer> onesol, int skills, int idx) {
        // write your code here
        if(skills == ((1<<nskills)-1)){
            if(sol.size() ==0 || cp<=sol.size()){
                sol = new ArrayList<>();
                for(Integer i: onesol){
                    sol.add(i);
                }
            }
            return;

        }

        if(idx==people.length){
            return;
        }

        onesol.add(idx);
        solution(people, nskills, cp+1, onesol, skills|people[idx],idx+1);
        onesol.remove(onesol.size()-1);

        solution(people, nskills, cp, onesol, skills,idx+1);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashMap<String, Integer> smap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            smap.put(scn.next(), i);
        }

        int np = scn.nextInt();
        int[] people = new int[np];
        for (int i = 0; i < np; i++) {
            int personSkills = scn.nextInt();
            for (int j = 0; j < personSkills; j++) {
                String skill = scn.next();
                int snum = smap.get(skill);
                people[i] = people[i] | (1 << snum);

            }
        }


        solution(people, n, 0, new ArrayList<>(), 0, 0);
        System.out.println(sol);

    }
}
