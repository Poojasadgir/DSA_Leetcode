class CustomStack {
    private Stack<Integer>s1;
    private Stack<Integer>s2;
    private int currsize;
    private int maxsize;
    public CustomStack(int maxSize) {
        currsize=0;
        maxsize=maxSize;
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
        if(currsize <maxsize){
            s1.push(x);
            currsize++;
        }
    }
    
    public int pop() {
        if(currsize==0){
            return -1;
        }
        currsize--;
        return s1.pop();
    }
    
    public void increment(int k, int val) {
        while(s1.size()!=0){
            s2.push(s1.pop());
        }
        while((s2.size()!=0) && (k>0)){
            s1.push(s2.pop()+val);
            k--;
        }
        while(s2.size()!=0){
            s1.push(s2.pop());
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */