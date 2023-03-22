// Logic is simple split two halved in left and right
/*
Median of a stream
Time complexity
The time complexity of the Insert Num method will change depending on how many numbers have already been received from the stream. So, the time complexity is amortized over the number of insert operations.
Each insert operation will trigger a heapify process that runs in  (log? )O(logn) times, where  n is the count of numbers received so far from the stream. Because of this, the cumulative complexity of a sequence of  n insert operations is described by the expression log?1+log?2+log?3+…+log? log1+log2+log3+…+logn.
This expression simplifies to log? !logn!, which, as per Stirling’s approximation, is  ( log? )O(nlogn). As we have performed  n insert operations, the amortized time complexity of one insert operation is  ( log?  )O(nnlogn?), that is,  (log? )O(logn).
The time complexity of the Find Median method will be  (1)O(1) since retrieving the top element of a heap is a constant-time operation, and we need to do at most two such retrievals.
Space complexity
The space complexity will be  (1)O(1) since no additional space is used other than that which is required to store the numbers received from the data stream.

*/

class MedianOfAStream {

  PriorityQueue<Integer> maxHeapForSmallNum; //containing first half of numbers
  PriorityQueue<Integer> minHeapForLargeNum; //containing second half of numbers

  public MedianOfAStream() {
    maxHeapForSmallNum = new PriorityQueue<>((a, b) -> b - a);
    minHeapForLargeNum = new PriorityQueue<>((a, b) -> a - b);
  }

  public void insertNum(int num) {
    if (maxHeapForSmallNum.isEmpty() || maxHeapForSmallNum.peek() >= num)
      maxHeapForSmallNum.add(num);
    else
      minHeapForLargeNum.add(num);

    // either both the heaps will have equal number of elements or max-heap will have one 
    // more element than the min-heap
    if (maxHeapForSmallNum.size() > minHeapForLargeNum.size() + 1)
      minHeapForLargeNum.add(maxHeapForSmallNum.poll());
    else if (maxHeapForSmallNum.size() < minHeapForLargeNum.size())
      maxHeapForSmallNum.add(minHeapForLargeNum.poll());
  }

  public double findMedian() {
    if (maxHeapForSmallNum.size() == minHeapForLargeNum.size()) {
      // we have even number of elements, take the average of middle two elements
      return maxHeapForSmallNum.peek() / 2.0 + minHeapForLargeNum.peek() / 2.0;
    }
    // because max-heap will have one more element than the min-heap
    return maxHeapForSmallNum.peek();
  }
  

  public static void main(String[] args) {
    // Driver code
    int[] nums = {35, 22, 30, 25, 1};
    MedianOfAStream medianOfAges = null;
    for(int i=0; i< nums.length; i++){
      System.out.print(i+1);
      System.out.print(".\tData stream: [");
      medianOfAges = new MedianOfAStream();
      for(int j=0; j<=i; j++){
        System.out.print(nums[j]);
        if(j != i)
            System.out.print(", ");
        medianOfAges.insertNum(nums[j]);
      }
      System.out.println("]");
      System.out.println("\t\tThe median for the given numbers is: " + medianOfAges.findMedian());
      System.out.println(PrintHyphens.repeat("-", 100));
    }
    
  }
}
