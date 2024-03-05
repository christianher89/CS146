class HW8:
    def __init__(self):
        self.frequency = {}

    def longestPalindrome(self, s):
        if len(s) < 1 or len(s) > 2000:
            return 0
        self.frequency = {}
        count = 0
        odd = 0
        self.frequency[s[0]] = 1
        for i in range(1, len(s)):
            if s[i] in self.frequency:
                self.frequency[s[i]] += 1
            else:
                self.frequency[s[i]] = 1
        for c in self.frequency:
            if self.frequency[c] % 2 == 0:
                count += self.frequency[c]
            elif odd == 0 and self.frequency[c] % 2 == 1:
                count += self.frequency[c]
                odd += 1
            else:
                count += self.frequency[c] - 1
        return count

run = HW8()
str = input("Enter a phrase: ")
print(run.longestPalindrome(str))

