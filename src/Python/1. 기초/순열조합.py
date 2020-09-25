import itertools

pool = ['A', 'B', 'C', 'D']
# print(list(itertools.permutations(pool)))     # 3개의 원소로 수열 만들기
print(list(itertools.permutations(pool, 2)))  # 2개의 원소로 수열 만들기
# print(list(map(''.join, itertools.permutations(pool)))) # 3개의 원소로 수열 만들기
# print(list(map(''.join, itertools.permutations(pool, 2)))) # 2개의 원소로 수열 만들기

print(list(itertools.combinations(pool, 2)))  # 2개의 원소로 조합 만들기

# print(''.join(list(itertools.permutations(pool))[0]))