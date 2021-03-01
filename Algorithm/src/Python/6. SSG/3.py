import re
import psutil
import timeit
import os
from datetime import datetime
from collections import defaultdict
from shutil import rmtree
from ast import literal_eval

MAXIMUM_MEMORY = 500 * 1024 * 1024


def parse_date(date: str) -> str:
    """ Convert unstructured date into structured date.
    Args:
        date (str): unstructured date.
    Returns:
        str: String in YYYYMMDD format.
    """
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
        date_list[1], date_list[2] = date_list[1].zfill(2), date_list[2].zfill(2)
        return ''.join(date_list)


def write_publish_info(info_index: dict) -> None:
    """ Make a file with the key of the dictionary and save the data.
    Args:
        info_index (dict): Dictionary to save as a csv file.
    """
    for key, word in info_index.items():
        filename = f'publish_info/word_{key}.csv'
        with open(filename, 'a', encoding='utf-8') as file:
            file.write(str(word)[1:-1] + ',')
    info_index = defaultdict(list)


def processing(unstructed_file: str = './bookItem.csv') -> None:
    """ Pre-processing for Search.
    Reads the file line by line, process the data, and save it as a reverse index file.
    Args:
        unstructed_file (str): Csv file to process. Consists of fields _id, publish_date, publish_info.
    """
    start = timeit.default_timer()
    rmtree('publish_info/', ignore_errors=True)
    os.makedirs('publish_info/', exist_ok=True)
    with open(unstructed_file, 'r', encoding='utf-8') as f_read:
        info_index = defaultdict(list)
        cnt = 0
        for i, read_line in enumerate(f_read):
            read_line = read_line.split(',')
            cnt += 1
            date = parse_date(read_line[1])
            tokens = set(re.sub("[^a-zA-Z0-9가-힣]", ' ', ' '.join(read_line[2:])).lower().split())
            for token in tokens:
                info_index[token].append((read_line[0], date))
            if cnt > 1 << 12:
                cnt = 0
                if psutil.Process(os.getpid()).memory_info().rss > MAXIMUM_MEMORY:
                    write_publish_info(info_index)
        write_publish_info(info_index)
    print(timeit.default_timer() - start, "초")


def search(search_query: str) -> list:
    """ Search by user's query.
    Args:
        search_query (str): User's query.
    Returns:
        list: The latest 5 results.
    """
    start = timeit.default_timer()
    tokens = set(re.sub("[^a-zA-Z0-9가-힣]", ' ', search_query.lower()).split())
    sub_query_results = []
    for token in tokens:
        try:
            with open(f'./publish_info/word_{token}.csv', 'r', encoding='utf-8') as file:
                sub_query_results.append(literal_eval(f'[{file.read()}]'))
        except FileNotFoundError:
            return []
    if not sub_query_results:
        return []
    query_result: set = set(sub_query_results[0])
    for sub_query_result in sub_query_results[1:]:
        query_result.intersection_update(sub_query_result)
    result = sorted(list(query_result), key=lambda x: int(x[1]) if x[1] else 0, reverse=True)
    print(timeit.default_timer() - start, "초")
    return [result[i][0] for i in range(min(5, len(result)))]


if __name__ == "__main__":
    while True:
        menu = input("* Data Processing: 1, Query: 2, Exit: else\n>> ")
        if menu == '1':
            processing()
        elif menu == '2':
            if not os.path.exists('./publish_info'):
                print("Data should be processed for the first time.")
            else:
                print(search(input("Input query: ")))
        else:
            break
