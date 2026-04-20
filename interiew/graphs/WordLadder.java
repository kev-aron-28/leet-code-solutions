package graphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);
        int level = 1;

        Queue<String> queue = new ArrayDeque<>();

        queue.offer(beginWord);

        while (!queue.isEmpty()) { 
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String word = queue.poll();

                if(word.equals(endWord)) return level;

                char [] arr = word.toCharArray();

                for(int j = 0; j < arr.length; j++) {
                    char original = arr[j];

                    for(char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String next = new String(arr);

                        if(set.contains(next)) {
                            queue.offer(next);
                            set.remove(next);
                        }
                    }

                    arr[j] = original;
                }
            }

            level++;
        }


        return 0;
    }
}
