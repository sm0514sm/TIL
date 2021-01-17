public class Solution_1번문제3 {
   
   static int[] prices = {1,10,5,11,7};
   static boolean[] buy;
   static int answer=0;
   public static void main(String[] args) {
      buy = new boolean[prices.length];
      dfs(0,0);
      System.out.println(answer);
   }
   
   //index: 구매하거나 판 주식 index   cnt: 거래한 횟수
   private static void dfs(int index, int cnt) {
      //총 2회의 거래가 가능, 넘어가면 return
      if(cnt>4) return;
      
      if(index==prices.length) {
         
         //홀수번의 거래 불가능
         if(cnt%2==1) return;
         
         int money=0; //이익
         int[] deal;  //거래 항목
         int idx=0;   //거래 항목 index
         
         //거래 1회인 경우
         if(cnt==2) {
            deal = new int[2];
            
            //거래 할목 담기
            for (int i = 0; i < buy.length; i++) {
               if(buy[i]) {
                  deal[idx++]=prices[i];
               }
            }
            //사고-팔고
            money=deal[1]-deal[0];
         }
         
         //사고 팔고 2회인 경우
         else if (cnt==4) {
            deal = new int[4];
            
            //거래 할목 담기
            for (int i = 0; i < buy.length; i++) {
               if(buy[i]) {
                  deal[idx++]=prices[i];
               }
            }
            //사고-사고-팔고-팔고
            int money1=(deal[2]+deal[3])-(deal[1]+deal[0]);
            //사고-팔고-사고-팔고
            int money2=(deal[1]+deal[3])-(deal[2]+deal[0]);
            //최대값
            money=Math.max(money1, money2);
         }
         
         
         if(money<0) return;
         if(money>answer) answer=money;
         return;
      };
      
      buy[index]=true;
      dfs(index+1, cnt+1);
      buy[index]=false;
      dfs(index+1, cnt);
   }
}