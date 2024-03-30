def canFinish(numCourses, prerequisites):
    adjacencyList = [[] for _ in range(numCourses)]
    for course, prerequisiteCourse in prerequisites:
        adjacencyList[course].append(prerequisiteCourse)
    
    visited = [False] * numCourses
    inStack = [False] * numCourses
    
    def hasCycle(course):
        visited[course] = True
        inStack[course] = True
        
        for neighbor in adjacencyList[course]:
            if not visited[neighbor]:
                if hasCycle(neighbor):
                    return True
            elif inStack[neighbor]:
                return True
        
        inStack[course] = False
        return False
    
    for i in range(numCourses):
        if not visited[i]:
            if hasCycle(i):
                return False
    
    return True


prerequisites1 = [[1,0]]
prerequisites2 = [[1,0],[0,1]]
prerequisites3 = [[1,0],[2,3],[5,4]]

print(canFinish(2, prerequisites1))
print(canFinish(2, prerequisites2))
print(canFinish(6, prerequisites3))
