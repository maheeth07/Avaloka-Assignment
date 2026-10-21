import java.util.*;

class ES {
    static boolean canAttend(int[][] e) {
        int[][] a=e.clone();
        Arrays.sort(a,(x,y)->Integer.compare(x[0],y[0]));

        for(int i=1;i<a.length;i++) {
            if(a[i][0]<a[i-1][1]) return false;
        }
        return true;
    }

    static int minRooms(int[][] e) {
        if(e.length==0) return 0;

        int[][] a=e.clone();
        Arrays.sort(a,(x,y)->Integer.compare(x[0],y[0]));

        PriorityQueue<Integer> q=new PriorityQueue<>();

        for(int[] x:a) {
            if(!q.isEmpty()&&q.peek()<=x[0]) q.poll();
            q.offer(x[1]);
        }
        return q.size();
    }}

