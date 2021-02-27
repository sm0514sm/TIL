import json
import csv
import re
import time
from datetime import datetime
from collections import defaultdict


def parse_date(date: str) -> str:
    only_digit_date = re.sub(r"[^0-9]", ' ', re.sub(r"\d\d:\d\d:\d\d", '', date)).strip()
    if only_digit_date.isdigit() and len(only_digit_date) == 8:
        return only_digit_date
    else:
        date_list: list = only_digit_date.split()
        if not date_list or len(date_list[0]) == 5:
            return ''
        if len(date_list) > 3:
            for i in range(3, 1, -1):
                if len(date_list) % i == 0:
                    date_list = date_list[-i:]
        if len(date_list[0]) == 2:
            if datetime.now().year - 2000 > int(date_list[0]):
                date_list[0] = '20' + date_list[0]
            else:
                date_list[0] = '19' + date_list[0]
        while len(date_list) < 3:
            date_list.append("01")
        if len(date_list) != 3:
            print(date_list)
        date_list[1], date_list[2] = date_list[1].zfill(2), date_list[2].zfill(2)

        return ''.join(date_list)


def processing():
    info_index = defaultdict(list)
    with open('./bookItem.csv', 'r', buffering=1, encoding='utf-8') as f_read:
        while True:
            line = f_read.readline().split(',')
            # print(line)
            if not line or len(line) == 1:
                break
            # print(line)
            date = parse_date(line[1])
            tokens = set(re.sub("[^a-zA-Z0-9가-힣]", ' ', ''.join(line[2:])).split())
            for token in tokens:
                info_index[token].append([line[0], date])
        time.sleep(5)

    with open('./publish_info.json', 'w', encoding='utf-8') as file:
        print(len(json.dumps(info_index, ensure_ascii=False).encode('utf-8')))
        json.dump(info_index, file, ensure_ascii=False)
        time.sleep(5)


def search(search_query):
    tokens = set(re.sub("[^a-zA-Z0-9가-힣]", ' ', search_query).split())
    with open('./publish_info.json', 'r', encoding='utf-8') as file:
        json_data = json.load(file)
    sub_query_results = []
    for token in tokens:
        if json_data.get(token):
            token_tuple = [tuple(data) for data in json_data.get(token)]
            sub_query_results.append(set(token_tuple))
    if not sub_query_results:
        return []
    query_result: set = sub_query_results[0]
    for sub_query_result in sub_query_results:
        query_result.intersection_update(sub_query_result)
    result = sorted(list(query_result), key=lambda x: int(x[1]) if x[1] else 0, reverse=True)
    return [result[i][0] for i in range(min(5, len(result)))]


if __name__ == "__main__":

    while True:
        menu = input("* Data Processing: 1, Query: 2, Exit: else\n>> ")
        if menu == '1':
            processing()
        elif menu == '2':
            print(search(input("Input query: ")))
        else:
            break
