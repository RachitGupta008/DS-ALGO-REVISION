// Logic is same as previous question

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<order.length();i++){

            map.put(order.charAt(i), i);

        }

        for(int i=1;i<words.length;i++){
            String prev = words[i-1];
            String curr = words[i];

            for(int j=0;j<prev.length();j++){
                if(curr.length()==j){
                    return false;
                }
                char cp = prev.charAt(j);
                char cc = curr.charAt(j);

                if(cp!=cc){
                    if(map.get(cp)>map.get(cc)){
                        return false;
                    }

                break;

                }

            }


        }

    return true;
    }
}
