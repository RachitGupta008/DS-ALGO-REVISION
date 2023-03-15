import java.util.*;

public class MeetingRooms{
    public static int minMeetingRooms(List <Interval> meetingTimes) {

        // Your code will replace this placeholder return statement
      // Here we used priority queue because we are already using the soreted input on start 
      // But because any new addition will cause the old to remove, and old can only be removed if its less than new start
      // the priority queue takes into account the end time so always lowest end point in on peek and therefore we can remove the lowest one.

        Collections.sort(meetingTimes, (a, b)-> a.getStart()-b.getStart());
        Queue<Interval> q = new PriorityQueue<>((a, b)-> a.getEnd()-b.getEnd());
        q.add(meetingTimes.get(0));
        int ans = 1;
        int i=1;
        while(i<meetingTimes.size()){

            Interval t = meetingTimes.get(i);

            while(!q.isEmpty() && q.peek().getEnd()<=t.getStart()){
                q.remove();
            }
            q.add(t);

            ans = Math.max(ans, q.size());

        i++;
        }

        return ans;

    }
}
