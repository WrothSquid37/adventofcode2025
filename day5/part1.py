numRanges = []
numsToTest = []
freshNumCount = 0

with open("input.txt") as f:
    lines = f.readlines()
    
    for line in lines:
        if '-' in line:
            a, b = line.strip().split('-')
            numRanges.append([int(a), int(b)])
        elif len(line.strip()) > 0:
            numsToTest.append(int(line.strip()));
    
    for num in numsToTest:
        for tRange in numRanges:
            if tRange[0] <= num <= tRange[1]:
                freshNumCount += 1
                break
                

print (freshNumCount)
        
            