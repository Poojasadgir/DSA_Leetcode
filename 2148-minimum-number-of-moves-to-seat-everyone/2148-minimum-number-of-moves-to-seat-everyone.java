class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int n=seats.length;
        int i=0;
        int diff=0;
        //for(int i=0;i<n;i++){
           while(n>i){
             diff+=(Math.abs(seats[i]-students[i]));
              i++;
           }
           return diff;
    }
}