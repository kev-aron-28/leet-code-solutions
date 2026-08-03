package daily;

import java.util.List;

public class KeysAndRooms {
    public boolean solution(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];

        visit(0, visited, rooms);

        for(boolean room : visited) {
            if(!room) return false;
        }


        return true;
    }

    private void visit(int room, boolean[] visited, List<List<Integer>> rooms) {
        if(visited[room]) return;

        visited[room] = true;

        for(int key : rooms.get(room)) {
            visit(key, visited, rooms);
        }
    }
}
