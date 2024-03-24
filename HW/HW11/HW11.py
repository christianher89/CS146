class HW11:
    def floodFill(self, image, sr, sc, color):
        originalColor = image[sr][sc]

        if originalColor == color:
            return image
        self.dfs(image, sr, sc, originalColor, color)
        return image

    def dfs(self, image, row, col, originalColor, newColor):
        if row < 0 or row >= len(image) or col < 0 or col >= len(image[0]) or image[row][col] != originalColor:
            return
        image[row][col] = newColor

        self.dfs(image, row + 1, col, originalColor, newColor)
        self.dfs(image, row - 1, col, originalColor, newColor)
        self.dfs(image, row, col + 1, originalColor, newColor)
        self.dfs(image, row, col - 1, originalColor, newColor)

    def printImage(self, image):
        for row in image:
            print(row)
        print()

solution = HW11()

image1 = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
sr1, sc1, newColor1 = 1, 1, 2
solution.printImage(solution.floodFill(image1, sr1, sc1, newColor1))

image2 = [[0, 0, 0], [0, 0, 0]]
sr2, sc2, newColor2 = 0, 0, 0
solution.printImage(solution.floodFill(image2, sr2, sc2, newColor2))
