package _ELSE;

import java.util.Arrays;
import java.util.PriorityQueue;

class PAGE implements Comparable<PAGE>{
    int num, startT, cnt;
    boolean inQ = false;
    public PAGE(int num, int startT, int cnt){
        this.num = num;
        this.startT = startT;
        this.cnt =cnt;
    }

    public int compareTo(PAGE o){
        int ans = 0;
        if(!inQ){
            ans =this.startT - o.startT; 
            if(ans == 0)
                ans = this.cnt - o.cnt;
        }
        else{
            ans =this.cnt - o.cnt;
            if(ans == 0)
                ans = this.startT - o.startT; 
        }
        return ans;
    }
}

class Solution3 {
    public int[] solution(int[][] data) {
        int pageCnt = data.length;
        int[] answer = new int[pageCnt];
        boolean[] check = new boolean[pageCnt];
        PAGE[] pages = new PAGE[pageCnt];
        for(int i = 0; i < pageCnt; i++){
            pages[i] = new PAGE(data[i][0], data[i][1], data[i][2]);
        }

        Arrays.sort(pages);
        int time = pages[0].startT;
        int index = 0;
        PriorityQueue<PAGE> Q = new PriorityQueue<>();
        while(index != pageCnt){
            pages[index].inQ = true;
            Q.offer(pages[index]);
            while(!Q.isEmpty()){
                PAGE temp = Q.poll();
                answer[index++] = temp.num;
                time += temp.cnt;
                for(int i = index; i < pageCnt; i++){  
                     if(check[i]) continue;
                     if(pages[i].startT <= time){
                        pages[i].inQ = true;
                        check[i] = true;
                        Q.offer(pages[i]);
                     }
                    else{
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}