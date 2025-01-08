class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        StringBuilder answer=new StringBuilder();
        for(char ch: s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<Character>list=new ArrayList(map.keySet());
        list.sort((ob1, ob2) -> map.get(ob2)- map.get(ob1));

        for(char ch: list){
            for(int i=0;i<map.get(ch);i++){
                answer.append(ch);
            }
        }
         return answer.toString();
    }
}