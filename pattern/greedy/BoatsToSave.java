//Since it involve only two people on boat we will take lightest and heaviest togethor


public static int rescueBoats(int[] people, int limit) {
      
       Arrays.sort(people);
        int wtn = 0;
        int cnt=0;
        int i=0;
        int j=people.length-1;
        while(i<j){

            if(people[i]+people[j]<=limit){
                cnt++;
                i++;
                j--;
            }else{
                cnt++;
                j--;
            }

        }

        if(i==j){
            cnt++;
        }
        return cnt;
   }
