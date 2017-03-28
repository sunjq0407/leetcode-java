public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] nb = new List[numCourses];
        int[] courses = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
            nb[i] = new ArrayList<Integer>();
        for(int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][0]] ++;
            nb[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            if(courses[i] == 0) q.offer(i);
        int cnt = 0;
        while(!q.isEmpty()) {
            int i = q.poll();
            cnt ++;
            for(Object j : nb[i])
                if(--courses[(int)j] == 0) q.offer((int)j);
        }
        return cnt == numCourses;
    }
}