class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<10){
            return new ArrayList<>();
        }
        long hash = 0;
        Map<Long, Integer> map = new HashMap<>();
        long hs = 0, pow = (long) Math.pow(5, 9);
        int base=5;

    
        long h=1;
        long MOD=Long.MAX_VALUE;
        long hd= 1;
        long q = Long.MAX_VALUE;
        int d=base;
        long p=0;

        for(int i=0;i<9;i++){
            hd = (hd*base)%MOD;
            h = (h * d) % q;
        }
        System.out.println(hd);
        System.out.println(h);

       
        for(int i=0;i<10;i++){

            hash = (hash*base +(s.charAt(i)))%MOD;
             p = (d * p + s.charAt(i)) % q;
             hs += s.charAt(i)*( Math.pow(5, 9-i)); 
             hs %= Long.MAX_VALUE;

        }
        System.out.println(hash);
        System.out.println(hs);
        map.put(hash, 1);
        int j=0;
        List<String> list = new ArrayList<>();
         

        for(int i=10;i<s.length();i++){
            int cj = s.charAt(j);
            int ci = s.charAt(i);
            
            System.out.println(hash+"-"+cj+"*"+hd);
            System.out.println(hash+"-"+cj*hd);
            System.out.println(hs+ "-" +(int)s.charAt(i-10)+"*"+pow);
            
            hash = ((base*(hash - (cj*hd)))+(ci))%MOD;
            p = (d * (p - s.charAt(j) * h)
                     + s.charAt(i))
                    % q;

            hs = s.charAt(i) + (hs - s.charAt(i-10)*pow)*5;
            hs %= Long.MAX_VALUE;
            if(p<0){
                p = p+q;
            }
            if(hash<0){
                hash = hash + MOD;
            }
            if(map.containsKey(hash)){
                if(map.get(hash)==1){
                    list.add(s.substring(j+1, i+1));
                    map.put(hash, 2);
                }
                
            }else{
                map.put(hash, 1);
            }
            System.out.println(s.substring(j, i+1));
            System.out.println(hash);
            System.out.println(p);
            System.out.println(hs);
            j++;

        }

        return list;

    }

    

}
