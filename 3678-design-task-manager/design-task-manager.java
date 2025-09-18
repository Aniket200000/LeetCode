class TaskManager {
    Map<Integer, int[]> info = new HashMap<>();
    PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> {
        if (a[1] != b[1]) return b[1]-a[1]; 
        return b[0]-a[0]; 
    });

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> t : tasks)
            add(t.get(0), t.get(1), t.get(2));
    }

    public void add(int userId, int taskId, int priority) {
        info.put(taskId, new int[]{userId, priority});
        heap.offer(new int[]{taskId, priority});
    }

    public void edit(int taskId, int newPriority) {
        int[] arr = info.get(taskId);
        if (arr != null) {
            info.put(taskId, new int[]{arr[0], newPriority});
            heap.offer(new int[]{taskId, newPriority});
        }
    }

    public void rmv(int taskId) {
        info.remove(taskId);
    }

    public int execTop() {
        while (!heap.isEmpty()) {
            int[] top = heap.poll();
            int taskId = top[0], priority = top[1];
            int[] val = info.get(taskId);
            if (val != null && val[1]==priority) {
                info.remove(taskId);
                return val[0];
            }
        }
        return -1;
    }
}
