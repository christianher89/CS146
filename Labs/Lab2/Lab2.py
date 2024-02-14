import re

def remove_non_alphanumeric(str):
    str = re.sub(r'[^a-zA-Z0-9]', '', str)
    return str

def pali(str):
    char_list = []
    str = str.lower()
    str = remove_non_alphanumeric(str)
    for char in str:
        char_list.append(char)
    char_list_reversed = list(reversed(char_list))
    count = sum(1 for i, j in zip(char_list, char_list_reversed) if i == j)
    correct = len(char_list)
    if count == correct:
        print("TRUE!")
        return True
    print("false...")
    return False

if __name__ == "__main__":
    s = input("Your phrase: ")
    pali(s)

