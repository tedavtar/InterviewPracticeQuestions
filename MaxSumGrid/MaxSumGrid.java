import java.util.*;

public class MaxSumGrid {
    
    
    
    public static int maxPath(int[][] maze){
        if(maze==null){return -1;}
        int n = maze.length;
        int m = maze[0].length;
        if (n==0||m==0){return -1;}
        //maxTokens[x][y] will return sum max path from there till goal
        int[][] maxTokens = new int[n+1][m+1];//extra padding to avoid edge cases
        
        
        int numIters = Math.min(m,n);
        /*
         int currX = n;
         int currY = m;*/
        
        for(int i=1; i<=numIters; i++){
            int currY = m - i;
            int currX = n - i;
            for(int iy=currY; iy>=0;iy--){//do horizontal sweep
                maxTokens[currX][iy] = maze[currX][iy] + Math.max(maxTokens[currX+1][iy],maxTokens[currX][iy+1]);
            }
            for(int ix=currX; ix>=0;ix--){//do vertical sweep
                maxTokens[ix][currY] = maze[ix][currY] + Math.max(maxTokens[ix+1][currY],maxTokens[ix][currY+1]);
            }
        }
        
        
        return maxTokens[0][0];
    }
    
    
    
    public static void main(String[] args) {
        int[][] input = new int[][]{
            {1,0,7},{5,0,2},{2,1,1}
        };
        int res = maxPath(input);
        System.out.println(res);
        
    }
}

