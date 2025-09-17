class FoodRatings {
    Map<String, Integer> foodRating = new HashMap<>();
    Map<String, String> foodCuisine = new HashMap<>();
    Map<String, PriorityQueue<Food>> cuisineHeap = new HashMap<>();

    class Food implements Comparable<Food> {
        int rating; String name;
        Food(int r, String n) { rating = r; name = n; }
        public int compareTo(Food o) {
            if (rating != o.rating) return o.rating - rating; 
            return name.compareTo(o.name);
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            foodRating.put(foods[i], ratings[i]);
            foodCuisine.put(foods[i], cuisines[i]);
            cuisineHeap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>())
                .add(new Food(ratings[i], foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisine.get(food);
        foodRating.put(food, newRating);
        cuisineHeap.get(cuisine).add(new Food(newRating, food));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> heap = cuisineHeap.get(cuisine);
        while (!heap.isEmpty()) {
            Food top = heap.peek();
            if (foodRating.get(top.name) == top.rating) return top.name;
            heap.poll(); 
        }
        return ""; 
    }
}
