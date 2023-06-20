// This one is not a memory efficient approach since it copies the map at every snap

class SnapshotArray {
        private int snapid;
    private Map<Integer, Map<Integer, Integer>> nodeValue;
    private int ncount;
    
    // Constructor
    public SnapshotArray(int length) {
        snapid = 0;
        nodeValue = new HashMap<Integer, Map<Integer, Integer>>();
        nodeValue.put(0, new HashMap<Integer, Integer>());
        ncount = length;
    }
    
    // Function setValue sets the value at a given index idx to val.
    public void set(int idx, int val) {
        if (idx < ncount) {
            nodeValue.get(snapid).put(idx, val);
        }
    }
    
    // This function takes no parameters and returns the snapid.
    // snapid is the number of times that the snapshot() function was called minus 1.
    public int snap() {
        nodeValue.put(snapid + 1, new HashMap<Integer, Integer>(nodeValue.get(snapid)));
        snapid++;
        return snapid - 1;
    }
    // Function getValue returns the value at the index idx with the given snapid.
    public int get(int idx, int snapshotId1) {
        if (snapshotId1 < snapid && snapshotId1 >= 0) {
            if (nodeValue.get(snapshotId1).containsKey(idx)) {
                return nodeValue.get(snapshotId1).get(idx);
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }
}

// This one is fine and should be put in interview.

class SnapshotArray {
    int snapId = 0;
    TreeMap<Integer, Integer>[] historyRecords;
    
    public SnapshotArray(int length) {
        historyRecords = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            historyRecords[i] = new TreeMap<Integer, Integer>();
            historyRecords[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        historyRecords[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        return historyRecords[index].floorEntry(snapId).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
