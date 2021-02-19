# 2021-02-14
# https://leetcode.com/problems/two-sum/
# 리스트에서 타겟을 만들 수 있는 두 숫자 인덱스 리턴
def solution(nums: list, target: int):
    for i in range(len(nums)):
        try:
            return [i, nums.index(target - nums[i], i + 1)]
        except ValueError:
            continue


def solution2(nums, target):
    nums_map = {}
    for i, num in enumerate(nums):
        if target - num in nums_map:
            return [nums_map[target - num], i]
        nums_map[num] = i


print(solution([2, 7, 11, 15], 9))
print(solution2([0, 4, 3, 0], 0))
