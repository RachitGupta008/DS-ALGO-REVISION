class Solution {
    public int bitwiseComplement(int n) {
        int num=1;
        int i=1;

        if(n==0){
            return 1;
        }
        int bitCount = (int) Math.floor((int)(Math.log(n) / Math.log(2))) + 1;
        num = (int)Math.pow(2, bitCount)-1;
       // System.out.println(num);

        return ~n & (num);
    }
}
