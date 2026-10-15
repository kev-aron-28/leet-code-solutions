package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> solution(int nums1[], int nums2[], int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a,b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
        );

        for(int i = 0; i < nums1.length; i++) {
            heap.offer(new int[] { i, 0 });
        }

        while(k > 0 && !heap.isEmpty()) {
            int pair[] = heap.poll();

            int i = pair[0];
            int j = pair[1];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            k--;

            if(j + 1 < nums2.length) {
                heap.offer(new int[] { i, j + 1 });
            }
        }

        return result;
    }
}
