import re

def remove_non_alphanumeric(str):
    str = re.sub(r'[^a-zA-Z0-9]', '', str)
    return str

def compare(str1, str2):
    str1 = remove_non_alphanumeric(str1)
    str2 = remove_non_alphanumeric(str2)
    if len(str1) != len(str2):
        return False
    str1 = str1.lower()
    str2 = str2.lower()
    str_list = list(str1)
    
    count = 0
    
    for char in str2:
        if char in str_list:
            count += 1
            str_list.remove(char)
    
    if count == len(str1):
        print("true")
        return True
    else:
        print("false")
        return False

if __name__ == "__main__":
    s = input("First word?: ")
    t = input("Second word?: ")
    compare(s, t)


