class Solution {
    public String reorganizeString(String s) {
        int n=s.length();
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Character>pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        pq.addAll(map.keySet());

        StringBuilder  sb=new StringBuilder();
        while(pq.size()>1){
            char curr=pq.poll();
            char next=pq.poll();

            map.put(curr,map.get(curr)-1);
            map.put(next,map.get(next)-1);

            sb.append(curr);
            sb.append(next);

            if(map.get(curr)>0){
                pq.add(curr);
            }

            if(map.get(next)>0){
                pq.add(next);
            }
        }

        if(!pq.isEmpty()){
            char l=pq.poll();
            if(map.get(l)>1){
                return "";
            }
            sb.append(l);
        }
        return sb.toString();  
    }
}