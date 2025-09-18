class MyStack {
    int top;
    int arr[]=new int[100];
    
    MyStack(){
        top=-1;
    }

    public void push(int x) {
        // code here
        if(top<99){
            top=top+1;
            arr[top]=x;
        }
    }

    public int pop() {
        
        // code here
        if(top==-1){
            return -1;
        }
        return arr[top--];
    }
}
