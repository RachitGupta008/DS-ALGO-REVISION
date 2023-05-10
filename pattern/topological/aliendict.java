public class Solution {
  // Logic is intuition based
  // first build a map from the set of words
  // use prev and curr word to build a map
  // Apply topological sort
  
  Build a graph from the given words and keep track of the in-degrees of alphabets in a dictionary.
Add the sources to a result list.
Remove the sources and update the in-degrees of their children. If the in-degree of a child becomes  it’s the next source.
Repeat until all alphabets are covered.
  
  
  
  public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";

        Map<Character, List<Character>> map = new HashMap<>();

        Set<Character> letters = new HashSet<>();
        for(String s : words){
            for(char c : s.toCharArray()){
                letters.add(c);
            }
        }

        int[] indg = new int[26];

        for(int i=1; i< words.length; i++){
            String prev = words[i-1];
            String cur = words[i];
            for(int k=0; k< prev.length() && k < cur.length(); k++){
                Character c1 = prev.charAt(k) ;
                Character c2 = cur.charAt(k);

                if(c1 != c2){
                    if(!map.containsKey(c1)){
                        List<Character> list = new ArrayList<>();
                        map.put(c1, list);
                    }
                    map.get(c1).add(c2);
                    indg[c2-'a']++;
                    break;
                }
            }
        }
        PriorityQueue<Character> pq = new PriorityQueue<>();

        for(Character c : letters){
            if(indg[c-'a'] == 0) pq.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Character c = pq.poll();
            sb.append(c);
            List<Character> list = map.get(c);
            if(list == null) continue;
            for(Character ch : list){
                if(--indg[ch-'a'] == 0) pq.offer(ch);
            }
        }

        return sb.length() == letters.size() ? sb.toString(): "";


    }
}
