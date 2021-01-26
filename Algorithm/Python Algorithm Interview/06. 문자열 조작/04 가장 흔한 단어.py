# 2021-01-26
# 리트코드 819. Most Common Word

# Q: 대소문자 구분X, 구두점 무시
import collections
import re


def my_solution(paragraph: str, banned: list[str]):
    paragraph = paragraph.lower()
    paragraph2 = ''.join(c if c.isalnum() else " " for c in paragraph)
    paragraph2 = paragraph2.split()
    word_cnt_dict = collections.defaultdict(int)
    for word in paragraph2:
        if word in banned:
            continue
        word_cnt_dict[word] += 1
    return max(word_cnt_dict, key=lambda key: word_cnt_dict[key])


def solution(paragraph: str, banned: list[str]):
    words = [word for word in re.sub(r'[^\w]', ' ', paragraph).lower().split() if word not in banned]
    counts = collections.Counter(words)
    return counts.most_common(1)[0][0]


print(my_solution("Bob hit a ball, the hit BALL flew far after it was hit.", ["hit"]))
print(solution("Bob hit a ball, the hit BALL flew far after it was hit.", ["hit"]))
