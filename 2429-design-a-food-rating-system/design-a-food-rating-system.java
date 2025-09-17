class Food implements Comparable<Food> {
    int r; String n;
    Food(int r, String n) { this.r = r; this.n = n; }
    public int compareTo(Food o) { return r == o.r ? n.compareTo(o.n) : o.r - r; }
}

class FoodRatings {
    Map<String, Integer> fr = new HashMap<>();
    Map<String, String> fc = new HashMap<>();
    Map<String, PriorityQueue<Food>> cf = new HashMap<>();
    public FoodRatings(String[] f, String[] c, int[] r) {
        for (int i = 0; i < f.length; i++) {
            fr.put(f[i], r[i]); fc.put(f[i], c[i]);
            cf.computeIfAbsent(c[i], k -> new PriorityQueue<>()).add(new Food(r[i], f[i]));
        }
    }
    public void changeRating(String f, int nr) {
        fr.put(f, nr);
        cf.get(fc.get(f)).add(new Food(nr, f));
    }
    public String highestRated(String c) {
        PriorityQueue<Food> pq = cf.get(c);
        while (fr.get(pq.peek().n) != pq.peek().r) pq.poll();
        return pq.peek().n;
    }
}
