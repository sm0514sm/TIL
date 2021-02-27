# open(f'123.txt', 'w', encoding='utf-8').close()
with open(f'123.txt', 'a', encoding='utf-8') as f_write:
    f_write.write(str([123, 123]) + '\n')