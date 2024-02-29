from typing import List

class HW6:
    def three_sum(self, nums: List[int]) -> List[List[int]]:
        result = []

        nums.sort()

        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            target = -nums[i]
            left, right = i + 1, len(nums) - 1

            while left < right:
                s = nums[left] + nums[right]

                if s == target:
                    result.append([nums[i], nums[left], nums[right]])
                    
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1

                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1

                    left += 1
                    right -= 1
                elif s < target:
                    left += 1
                else:
                    right -= 1

        return result
        
if __name__ == "__main__":
    hw6 = HW6()
    nums = [-1, 0, 1, 2, -1, -4]
    result = hw6.three_sum(nums)

    for triplet in result:
        print(triplet)
