# 2021-01-26
# 리트코드 49. Group Anagrams

# Q: 애너그램 단위로 그룹핑하라  You can return the answer in any order.
import collections


def my_solution(strs: list[str]) -> list[list[str]]:
    word_dict = collections.defaultdict(list)
    for word in strs:
        word_dict[''.join(sorted(word))].append(word)
    return list(word_dict.values())


print(my_solution(["eat", "tea", "tan", "ate", "nat", "bat"]))  # [["bat"],["nat","tan"],["ate","eat","tea"]]
