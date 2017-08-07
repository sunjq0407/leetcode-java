public class SnakeGame {
    
    LinkedList<Integer> snakes;
    Set<Integer> snakeSet;
    int len;
    int w;
    int h;
    int[][] food;
    int foodIdx;
    int pos;
    
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        snakes = new LinkedList<>();
        snakes.add(0);
        snakeSet = new HashSet<>();
        snakeSet.add(0);
        len = 0;
        w = width;
        h = height;
        this.food = food;
        foodIdx = 0;
        pos = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int x = pos / w;
        int y = pos % w;
        if(direction.equals("U")) {
            x --;
        } else if(direction.equals("L")) {
            y --;
        } else if(direction.equals("R")) {
            y ++;
        } else if(direction.equals("D")) {
            x ++;
        }
        if(x < 0 || y < 0 || x >= h || y >= w) {
            return -1;
        }
        pos = x * w + y;
        if(foodIdx < food.length && pos == food[foodIdx][0] * w + food[foodIdx][1]) {
            snakes.add(pos);
            snakeSet.add(pos);
            foodIdx++;
            return ++len;
        }
        snakeSet.remove(snakes.pollFirst());
        if(snakeSet.contains(pos)) return -1;
        snakes.add(pos);
        snakeSet.add(pos);
        return len;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */