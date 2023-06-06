import java.util.*;

class RequestLogger {
	// initailization of requests hash map
	int tl;
	Map<String, Integer> map;
	Set<String> set;
	public RequestLogger(int timeLimit) {
		// Write your code here
		tl = timeLimit;
		System.out.println(tl);
		map = new HashMap<>();
		set = new HashSet<>();
	}

	// function to accept and deny message requests
	public boolean messageRequestDecision(int timestamp, String request) {
		// checking whether the specific request exists in
		// the hash map or not

		// Your code will replace this placeholder return statement

		if(map.containsKey(request)){
			int tt = map.get(request);
			if((timestamp - tt) >= tl){
				map.put(request, timestamp);
				return true;
			}

		}else{
			map.put(request, timestamp);
			return true;
		}
		
		return false;
	}
}
