

def stringmatch(T, P):
    for i in range(0, len(T)-len(P)+1):
        j = 0
        while j < len(P) and P[j] == T[i+j]:
            j += 1
        if j == len(P):
            return True
    return False


print(stringmatch("my name is superman", "super"))