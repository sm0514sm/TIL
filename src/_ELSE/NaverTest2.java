package _ELSE;

class Solution2 {
    public int solution(String[] drum) {
        int[][] DIR = {{1, 0}, {0, 1}, {0, -1}}; // 아래 우 좌

        int answer = 0;
        int rowCnt = drum.length;
        int colCnt = drum[0].length();
        char[][] arr = new char[rowCnt][];
        for(int i = 0; i <rowCnt; i++){
            arr[i] = drum[i].toCharArray();
        }
        next:
        for(int i = 0; i < colCnt; i++){
            int r = 0;
            int c = i;
            int nr,nc;
            int dir = 0;
            int starCnt = 0;
            while(r < rowCnt){
                switch(arr[r][c]){
                case '#':
                        dir = 0;
                        r = r + DIR[dir][0];
                        c = c + DIR[dir][1];
                    break;
               case '>':
                        dir =1 ;
                        r = r + DIR[dir][0];
                        c = c + DIR[dir][1];
                    break; 
                case '<':
                        dir = 2;
                        r = r + DIR[dir][0];
                        c = c + DIR[dir][1];
                    break;
                case '*':
                        dir = 0;
                        starCnt++;
                        if(starCnt >= 2) continue next;
                        r = r + DIR[dir][0];
                        c = c + DIR[dir][1];
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}