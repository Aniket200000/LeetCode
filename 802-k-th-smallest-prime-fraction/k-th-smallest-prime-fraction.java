import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        
        // Min-heap to store fractions (as a/b, numerator index, denominator index)
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] a, double[] b) {
                return Double.compare(a[0], b[0]);
            }
        });

        // Initialize the priority queue with the first fractions
        for (int i = 0; i < n - 1; i++) {
            double fraction = (double) arr[i] / arr[n - 1];
            pq.offer(new double[]{fraction, i, n - 1});
        }

        // Extract elements from the priority queue
        while (k > 1) {
            double[] current = pq.poll();
            int numIndex = (int) current[1];
            int denIndex = (int) current[2];
            
            // If there's a smaller denominator available, add it to the queue
            if (numIndex < denIndex - 1) {
                pq.offer(new double[]{(double) arr[numIndex] / arr[denIndex - 1], numIndex, denIndex - 1});
            }

            k--; // Reduce k by 1
        }

        // The k-th fraction is now at the top of the priority queue
        double[] result = pq.poll();
        int numerator = (int) result[1];
        int denominator = (int) result[2];
        
        return new int[]{arr[numerator], arr[denominator]};
    }
}
