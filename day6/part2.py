unparsedlines = []
nums = []
total = 0;

createdNums = []

with open("input.txt") as f:
    for line in f:
        unparsedlines.append(line.strip().split())
        
    for i in range(len(unparsedlines[0])):
        a = unparsedlines[0][i]
        b = unparsedlines[1][i]
        c = unparsedlines[2][i]
        d = unparsedlines[3][i]
        
        str = ""
        
        for ax in range(0, len(a)):
            str = str + a[ax]

        for bx in range(0, len(b)):
            str = str + b[bx]
            
        for cx in range(0, len(c)):
            str = str + c[cx]
            
        for dx in range(0, len(d)):
            str = str + d[dx]
        
        print (str)
        #print(a, b, c, d)
        
        
        
        op = unparsedlines[4][i];
        
        # match op:
        #     case '*':
        #         total += a * b * c * d
        #     case '+':
        #         total += a + b + c + d
    
    print(total)
        
        

    
    
        
    
        