public class Solution {
    
    class Coordinates
    {
        int x;
        int y;
        public Coordinates(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public int knight(int A, int B, int C, int D, int E, int F) {
        
        int dir[][] = {
                          {-1, -2},//all possible moves of knight
                          {-1, 2},
                          {1, -2},
                          {1, 2},
                          {-2, -1}, 
                          {2, -1},
                          {-2, 1},
                          {2, 1}        };
        
        boolean visited[][] = new boolean[A + 1][B + 1];
        Queue<Coordinates> qu = new LinkedList<Coordinates>();
        qu.add(new Coordinates(C,D));
        visited[C][D] = true;
        int count = 0;
        while(!qu.isEmpty())
        {
            int size=qu.size();
            for(int i=0;i<size;i++)
            {
                Coordinates obj=qu.poll();
                if(obj.x==E && obj.y==F)
                return count;
                for(int j=0;j<8;j++)
                {
                    int newx=obj.x+dir[j][0];
                    int newy=obj.y+dir[j][1];
                    if(newx>=1 && newx <=A && newy>=1 && newy<=B && visited[newx][newy]==false)
                    {
                    qu.add(new Coordinates(newx,newy));
                    visited[newx][newy]=true;
                    }
                }
            }
            count++;
        }
        return -1;
        
    }
}
