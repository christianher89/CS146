import itertools

# No need to create a class in Python for this simple script
def main():
    target = int(input("Target Number?: "))
    amt = int(input("How many integers in array?: "))
    nums = list(range(amt))
    
    for i, j in itertools.combinations(nums, 2):
        if i + j == target:
            print(f"{i} + {j} = {target}")
            return
    
    print("Target is too big for these integers!")

if __name__ == "__main__":
    main()

