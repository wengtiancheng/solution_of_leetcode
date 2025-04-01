/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// class Solution {
//     //先使用广度优先搜索
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         //邻接表存储课程依赖关系，因为课程号是有序递增的，所以也不一定要用哈希表存储
//         List<List<Integer>> tmp = new ArrayList<>();
//         //初始化每个课程的后续课程为空数组
//         for(int i = 0; i < numCourses; i++){
//             tmp.add(new ArrayList<>());
//         }
//         //记录每门课程的入度
//         int[] numOfCoursesToLearn = new int[numCourses];
//         for(int[] prerequisite : prerequisites){
//             int before = prerequisite[1];
//             int after = prerequisite[0];
//             numOfCoursesToLearn[after]++;
//             tmp.get(before).add(after);
//         }
//         Queue<Integer> coursesCanLearn = new LinkedList<>();
//         for(int i = 0; i < numCourses; i++){
//             if(numOfCoursesToLearn[i] == 0){
//                 coursesCanLearn.offer(i);
//             }
//         }
//         int learned = 0;
//         while(!coursesCanLearn.isEmpty()){
//                 //学一个已经可以学的课程
//                 int num = coursesCanLearn.poll();
//                 learned++;
//                 //获取当前课程的后续课程列表
//                 List<Integer> nextCourses = tmp.get(num);
//                 for(int nextCourse : nextCourses){
//                     numOfCoursesToLearn[nextCourse]--;
//                     if(numOfCoursesToLearn[nextCourse] == 0){
//                         coursesCanLearn.offer(nextCourse);
//                     }
//                 }
            
//         }
//         if(learned < numCourses){
//             return false;
//         }
//         return true;
//     }
// }
class Solution{
    //还是要用邻接表存储课程依赖关系,存储的是这个课程所有的后继课程
    List<List<Integer>> tmp;
    //记录每个课程的状态，0表示未搜索，1表示搜索中，2表示已完成
    int[] visited;
    boolean valid = true;
    //使用深度优先搜索
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        tmp =  new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++){
            tmp.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for(int[] info : prerequisites){
            tmp.get(info[1]).add(info[0]);
        }
        for(int i = 0; i < numCourses && valid; i++){
            if(visited[i] == 0){
                dfs(i);
            }
        }
        return valid;
        
        
     
    }
    public void dfs(int u){
        visited[u] = 1;
        for(int v : tmp.get(u)){
            if(visited[v] == 0){
                dfs(v);
                if(!valid){
                    return;
                }
            }else if(visited[v] == 1){
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}
// @lc code=end

