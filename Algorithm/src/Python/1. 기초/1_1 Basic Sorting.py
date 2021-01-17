import os
import shutil


dongin_dir = "A:\\상민\\Super Block\\종합\\01 동인지 모음\\"
hitomi_dir = "A:\\상민\\Super Block\\히토미\\hitomi_downloaded\\"


def set_all_donginlist():
    for dongin_folder in dongin_folder_list:
        dongin_list = os.listdir(dongin_dir + dongin_folder)
        for dongin_name in dongin_list:
            all_dongin_list.append(dongin_name)


def insert_hitomi_dir():
    global access_count
    global make_count
    for dongin_folder in dongin_folder_list:
        dongin_list = os.listdir(dongin_dir + dongin_folder)
        for dongin_name in dongin_list:
            all_dongin_list.append(dongin_name)
            access_count += 1
            print(dongin_name)
            if dongin_name not in hitomi_list:
                if not os.access(hitomi_dir + dongin_name, os.F_OK):  # 해당 디렉토리가 이미 존재하는지 확인
                    os.mkdir(hitomi_dir + dongin_name)
                    make_count += 1


def delete_hitomi_list_if_not_in_all_dongin_list():
    for hitomi in hitomi_list:
        if hitomi not in all_dongin_list:
            print(hitomi)
            hitomi_list.remove(hitomi)
            shutil.rmtree(hitomi_dir + hitomi)
            global delete_count
            delete_count += 1


def clear_blank_folder():
    global access_count
    for dongin_folder in dongin_folder_list:
        dongin_list = os.listdir(dongin_dir + dongin_folder)
        for dongin_name in dongin_list:
            content_list = os.listdir(dongin_dir + dongin_folder + "\\" + dongin_name)
            print(len(content_list))
            if len(content_list) == 0:
                print(dongin_dir + dongin_folder + "\\" + dongin_name + "삭제")
            access_count += 1
    print("------------------------------")
    print("access count = ", access_count)


if __name__ == "__main__":
    all_dongin_list = []

    dongin_folder_list = os.listdir(dongin_dir)
    hitomi_list = os.listdir(hitomi_dir)

    access_count = 0
    delete_count = 0
    menu = int(input("1. 빈폴더 지우기\n2. 폴더 동기화\n3. 중복 리스트 출력\n>> "))
    if menu == 1:
        clear_blank_folder()
        pass
    elif menu == 2:
        make_count = 0
        DeleteOn = input("\n강제삭제 옵션 0 = 하지 않음, 1 = 강제 삭제\n >> ")
        insert_hitomi_dir()
        if DeleteOn == "1":
            delete_hitomi_list_if_not_in_all_dongin_list()

        print("------------------------------")
        print("access count = ", access_count)
        print("make   count = ", make_count)
        print("delete count = ", delete_count)
    elif menu == 3:
        count = 0
        set_all_donginlist()
        for i in all_dongin_list:
            if i not in hitomi_list:
                count += 1
                print(i)
        for i in hitomi_list:
            if i not in all_dongin_list:
                count += 1
                print(i)
        print("Redundancy count = ", count)
    input("finish")
