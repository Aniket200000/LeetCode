public class Spreadsheet {
    Map<String, Integer> map = new HashMap<>();

    public Spreadsheet(int rows) {}

    public void setCell(String cell, int val) {
        map.put(cell, val);
    }

    public void resetCell(String cell) {
        map.remove(cell);
    }

    public int getValue(String formula) {
        String[] parts = formula.substring(1).split("\\+");
        int sum = 0;
        for (String part : parts)
            sum += map.getOrDefault(part, isCell(part) ? 0 : Integer.parseInt(part));
        return sum;
    }

    boolean isCell(String s) {
        return s.length() > 1 && s.charAt(0) >= 'A' && s.charAt(0) <= 'Z' && s.substring(1).chars().allMatch(Character::isDigit);
    }
}
