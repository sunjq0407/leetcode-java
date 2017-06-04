public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0 || rooms[0].length == 0) return;
        for(int i = 0; i < rooms.length; i++)
            for(int j = 0; j < rooms[0].length; j++)
                if(rooms[i][j] == 0) bfs(rooms, 0, i , j);
    }
    
    private void bfs(int[][] rooms, int val, int i, int j) {
        if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length) return;
        if(rooms[i][j] == -1 || (val != 0 && rooms[i][j] <= val)) return;
        rooms[i][j] = val;
        bfs(rooms, val + 1, i - 1, j);
        bfs(rooms, val + 1, i + 1, j);
        bfs(rooms, val + 1, i, j - 1);
        bfs(rooms, val + 1, i, j + 1);
    }
}