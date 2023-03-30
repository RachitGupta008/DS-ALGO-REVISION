// The trick is to create a partition in smaller array in such a way that due to this partition we can select other elements from larger array
// Move the partition using binary search as the, partition means how many element to select from array1, array2 to get to the middle --  we can start from 0 - (lo+hi)/2
// so we move the partition in the search space until we get the right partition that satisfy our condition

//  Striver video explains this easily
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;

        int mp = (m+n+1)/2;

        int lo = 0;
        int hi = m;

        while(lo<=hi){
            int mid = (lo+hi)/2;
            int m2 = mp - mid;

            int l1 = mid==0?Integer.MIN_VALUE:nums1[mid-1];
            int l2 = m2==0?Integer.MIN_VALUE:nums2[m2-1];
            int r1 = mid==m?Integer.MAX_VALUE:nums1[mid];
            int r2 = m2==n?Integer.MAX_VALUE:nums2[m2];
            //System.out.println(mid);
            //System.out.println(l1+" "+l2+" "+r1+" "+r2);

            if(l1<=r2 && l2<=r1){
                if((m+n)%2==0){
                    return (Math.max(l1, l2)+Math.min(r1, r2))/2.0;
                }else{
                    return Math.max(l1, l2);
                }
            }else if(l1>r2){
                hi = mid-1;
            }else{
                lo = mid+1;
            }

        }
        return -1;

    }
}
