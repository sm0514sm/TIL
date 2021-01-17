ans=0
def solution(k):
    answer=0
    stick =[6,2,5,5,4,5,6,3,7,6]
    dfs(k, stick, 0, [])
    global ans
    return ans

def dfs(k, stick, cnt, can):
    if cnt>k: return 0
    global ans
    if cnt==k:
        if len(can)==1 and can[0]==0:
            ans+=1
            return
        if len(can)==0 or can[0]==0:return
        ans+=1
        return
    for i in range(len(stick)):
        can.append(i)
        dfs(k, stick, cnt+stick[i], can)
        can.pop()


for i in range(1, 50):
    print(i, solution(i))