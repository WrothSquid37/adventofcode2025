unparsedlines = []
nums = []
total = 0;

with open("input.txt") as f:
    for line in f:
        unparsedlines.append(line.strip().split())
        
    for i in range(len(unparsedlines[0])):
        a = int(unparsedlines[0][i])
        b = int(unparsedlines[1][i])
        c = int(unparsedlines[2][i])
        d = int(unparsedlines[3][i])
        
        op = unparsedlines[4][i];
        
        match op:
            case '*':
                total += a * b * c * d
            case '+':
                total += a + b + c + d
    
    print(total)
        
        

    
    
        
    
        