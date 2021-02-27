import json

info_index= dict()
info_index["가나"] = "ㅂㅈㄼㄹㅈ"
with open('./publish_info.json', 'w', encoding='utf-8') as file:
    json.dump(info_index, file, indent="\t")
    file.write("dltk이상민")