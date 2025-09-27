class Solution{
    public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) return "0";

    StringBuilder sb = new StringBuilder();

    if ((numerator < 0) ^ (denominator < 0)) sb.append("-");
    long num = Math.abs((long) numerator);
    long denom = Math.abs((long) denominator);

    sb.append(num / denom);
    num %= denom;
    if (num == 0) return sb.toString();

    sb.append(".");
    Map<Long, Integer> map = new HashMap<>();
    while (num != 0) {
        if (map.containsKey(num)) {
            sb.insert(map.get(num), "(");
            sb.append(")");
            break;
        }
        map.put(num, sb.length());
        num *= 10;
        sb.append(num / denom);
        num %= denom;
    }
    return sb.toString();
    }
}
