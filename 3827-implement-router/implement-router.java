class Packet {
    int source, destination, timestamp;
    Packet(int s, int d, int t) {
        source = s; destination = d; timestamp = t;
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Packet)) return false;
        Packet p = (Packet) o;
        return source == p.source && destination == p.destination && timestamp == p.timestamp;
    }
    @Override
    public int hashCode() {
        return Objects.hash(source, destination, timestamp);
    }
}

class Router {
    private int memoryLimit;
    private Queue<Packet> queue;
    private Set<Packet> unique;
    private Map<Integer, List<Integer>> destTimes;
    private Map<Integer, Integer> startIdx;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        queue = new LinkedList<>();
        unique = new HashSet<>();
        destTimes = new HashMap<>();
        startIdx = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet p = new Packet(source, destination, timestamp);
        if (unique.contains(p)) return false;
        if (queue.size() == memoryLimit) {
            forwardPacket();
        }
        queue.offer(p);
        unique.add(p);
        destTimes.computeIfAbsent(destination, x -> new ArrayList<>()).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        Packet p = queue.poll();
        if (p == null) return new int[0];
        unique.remove(p);
        startIdx.put(p.destination, startIdx.getOrDefault(p.destination, 0) + 1);
        return new int[]{p.source, p.destination, p.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> times = destTimes.getOrDefault(destination, new ArrayList<>());
        int start = startIdx.getOrDefault(destination, 0);
        int l = lowerBound(times, start, startTime);
        int r = upperBound(times, start, endTime);
        return r - l;
    }

    private int lowerBound(List<Integer> times, int start, int target) {
        int lo = start, hi = times.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (times.get(mid) >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private int upperBound(List<Integer> times, int start, int target) {
        int lo = start, hi = times.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (times.get(mid) > target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
