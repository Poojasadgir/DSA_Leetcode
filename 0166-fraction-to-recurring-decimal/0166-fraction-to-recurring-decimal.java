class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0"; 
        
        StringBuilder sb = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        sb.append(num / den);
        long remainder = num % den;

        if (remainder == 0) {
            return sb.toString();
        }

        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int pos = map.get(remainder);
                sb.insert(pos, "(");
                sb.append(")");
                break;
            }
            
          
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / den);
            remainder %= den;
        }

        return sb.toString();
    }
}