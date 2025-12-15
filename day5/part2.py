numRanges = []
newMergedRanges = []
freshNumCount = 0

with open("input.txt") as f:
    lines = f.readlines()
    
    
    for line in lines:
        if '-' in line:
            a, b = line.strip().split('-')
            numRanges.append([int(a), int(b)])
    
    numRanges.sort()
    
    start, end = numRanges[0]
    for nums in numRanges:
        if nums[0] > end:
            newMergedRanges.append([start, end]);
            start = nums[0]
        if nums[1] > end:
            end = nums[1]
    newMergedRanges.append([start, end]);
    
    for ra in newMergedRanges:
        freshNumCount += ra[1] - ra[0] + 1
            
    
            
print(freshNumCount)
            
        
    
    
    
                

print (freshNumCount)
        
            