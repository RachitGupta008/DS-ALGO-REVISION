class MergeSortList {
	// helper function
	public static LinkedListNode merge2Lists(LinkedListNode head1, LinkedListNode head2) {
		LinkedListNode dummy = new LinkedListNode(-1);
		LinkedListNode prev = dummy; // set prev pointer to dummy node
		// traverse over the lists until both or one of them becomes null
		while (head1 != null && head2 != null) {
			// if l1 value is<=  l2 value, add l1 node to the list
			if (head1.data<= head2.data) {
				prev.next = head1;
				head1 = head1.next;
			} else {
				// if l1 value is greater than l2 value, add l2 node to the list
				prev.next = head2;
				head2 = head2.next;
			}
			prev = prev.next;
		}

		if (head1 == null)
			prev.next = head2;
		else
			prev.next = head1;

		return dummy.next;
	}

	// Main function
	public static LinkedListNode mergeKLists(List<LinkedList> lists) {
        int temp = 0;
		if (lists.size() > 0) {
            int step = 1;
            while(step < lists.size())
            {
                //temp = step;
                for(int i = 0; i < lists.size() - step;  i += step * 2)
                {
                    lists.get(i).head =  merge2Lists(lists.get(i).head, lists.get(i + step).head);
                }
                step *= 2;
            }
			return lists.get(0).head;
        }
		else
		    return null;
		
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		List<List<List<Integer>>> inputLists = Arrays.asList(
			Arrays.asList(Arrays.asList(21, 23, 42), Arrays.asList(1, 2, 4)),
			Arrays.asList(Arrays.asList(11, 41, 51), Arrays.asList(21, 23, 42)),
			Arrays.asList(Arrays.asList(2), Arrays.asList(1, 2, 4), Arrays.asList(25, 56, 66, 72)),
			Arrays.asList(Arrays.asList(11, 41, 51), Arrays.asList(2), Arrays.asList(2), Arrays.asList(2), Arrays.asList(1, 2, 4)),
			Arrays.asList(Arrays.asList(10, 30), Arrays.asList(15, 25), Arrays.asList(1, 7), Arrays.asList(3, 9), Arrays.asList(100, 300), Arrays.asList(115, 125), Arrays.asList(10, 70), Arrays.asList(30, 90))
		);
		for (int i = 0; i<inputLists.size(); i++) {
			System.out.println((i + 1) + ".\tInput lists:");
			List<LinkedList> llList = new ArrayList<>();
			for (List x: inputLists.get(i)) {
				LinkedList a = new LinkedList();
				a.createLinkedList(x);
				llList.add(a);
				System.out.print("\t");
				PrintList.printListWithForwardArrow(a.head);
				System.out.println();
			}
			System.out.print("\tMerged list: \n\t");
			PrintList.printListWithForwardArrow(mergeKLists(llList));
			System.out.println("\n" + PrintHyphens.repeat("-", 100));
		}
	}
}
