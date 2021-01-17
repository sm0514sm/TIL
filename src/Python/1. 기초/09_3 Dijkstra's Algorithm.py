def SimpleDijkstra(W, s):
    D = [0, 0, 0, 0, 0, 0]
    treeflag = [False, False, False, False, False, False]   # 방문하면 true가 됨
    for i in range(0, len(W)):
        D[i] = 999
        treeflag[i] = False
    D[s] = 0
    jmin = 0
    for i in range(0, len(W)):
        dmin = 999
        # 방문하지 않은 곳 중 가장 작은 vertex 선정
        for j in range(0, len(W)):
            if not treeflag[j] and D[j] < dmin:
                jmin = j
                dmin = D[jmin]
        treeflag[jmin] = True
        for j in range(0, len(W)):
            # 방문하지 않은 j가는데, dmin거쳐가는게 더 빠를 경우
            if not treeflag[j] and D[jmin] + W[jmin][j] < D[j]:
                D[j] = dmin+W[jmin][j]
    return D


W = [[  0,  10,  30,  15, 999, 999],
     [999, 999, 999, 999,  20, 999],
     [999, 999, 999, 999, 999,   5],
     [999, 999, 999, 999, 999,  20],
     [999, 999, 999, 999,  20, 999],
     [999, 999, 999,  20, 999, 999]]

D = SimpleDijkstra(W, 0)
print(D)
