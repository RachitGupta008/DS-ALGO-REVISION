class MinStack {

    class Pair {

        int val;
        int min;

        Pair(int val, int min){
            this.val = val;
            this.min = min;
        }
    }

    Stack<Pair> stack = new Stack<Pair>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Pair(val, val));
        }else{
            stack.push(new Pair(val,Math.min(stack.peek().min, val)));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
