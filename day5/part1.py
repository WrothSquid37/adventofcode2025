numRanges = []

with open("input.txt") as f:
    lines = f.readlines()
    
    for line in lines:
        line = line.strip()
        if '-' in line:
            temp = line.split('-')
            temp[0] = int(temp[0]);
            temp[1] = int(temp[1]);
            numRanges.append(temp)
        elif len(line) > 0:
            for num in numRanges:
                for n in range(num[0],num[1]+1):
                    if n == int(line):
                        print (n)
                        break
             
        
            
print (numRanges)
            