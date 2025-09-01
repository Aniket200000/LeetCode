class Solution {
    class ClassInfo {
        int passed, total, index;
        double gain;
        ClassInfo(int p, int t, int i) {
            passed = p; total = t; index = i;
            gain = computeGain();
        }
        double computeGain() {
            return ((double)(passed + 1) / (total + 1)) - ((double)passed / total);
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        double[] ratios = new double[n];
        PriorityQueue<ClassInfo> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.gain, a.gain));
        for (int i = 0; i < n; i++) {
            ratios[i] = (double) classes[i][0] / classes[i][1];
            maxHeap.offer(new ClassInfo(classes[i][0], classes[i][1], i));
        }
        while (extraStudents > 0) {
            ClassInfo top = maxHeap.poll();
            top.passed++;
            top.total++;
            top.gain = top.computeGain();
            ratios[top.index] = (double) top.passed / top.total;
            maxHeap.offer(top);
            extraStudents--;
        }
        double sum = 0;
        for (double r : ratios) sum += r;
        return sum / n;
    }
}
