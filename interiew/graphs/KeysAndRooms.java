package graphs;

import java.util.List;

public class KeysAndRooms {
    public boolean solution(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()]; 

        for(boolean room : visited) {
            if(!room) return false;
        }

        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean visited[]) {

        if(visited[room]) {
            return;
        }

        visited[room] = true;

        for(int key : rooms.get(room)) {
            dfs(key, rooms,visited);
        }
    }
}
