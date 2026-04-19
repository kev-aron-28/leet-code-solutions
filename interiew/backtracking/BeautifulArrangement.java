package backtracking;

public class BeautifulArrangement {
    public int solution(int n) {
        boolean used[] = new boolean[n + 1];

        return dfs(n, 1, used);
    }

    public int dfs(int n, int pos, boolean used[]) {
        if(pos > n) return 1;

        int count = 0;

        for(int i = 1; i <= n; i++) {
            if(used[i]) continue;

            if(i % pos == 0 || pos % i == 0) {
                used[i] = true;
                count += dfs(n, pos + 1, used);
                used[i] = false;
            }
        }


        return count;
    } 
}
