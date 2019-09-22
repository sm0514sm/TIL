package _ELSE;

class Solution {
    public int solution(String[] emails) {
        int answer = 0;
        int count = emails.length;

        next:
        for(String email: emails){
            if(!email.endsWith(".com") && !email.endsWith(".net") && !email.endsWith(".org") ) continue next;

            int golindex =  email.indexOf('@');
            int golindex2 =  email.lastIndexOf('@');
            int dotindex = email.lastIndexOf('.');
            if(golindex != golindex2 || golindex <= 0 || golindex + 1 == dotindex) continue next;
            for(int i = 0; i < dotindex; i++){
                if(Character.isLetter(email.charAt(i))){
                    if(!Character.isLowerCase(email.charAt(i))) continue next;
                }
            }
            answer++;
        }

        return answer;
    }
}