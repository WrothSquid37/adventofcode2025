from math import prod

unparsedlines = []
chunks = []
total = 0;

createdNums = []

with open("input2.txt") as f:
    for line in f:
        unparsedlines.append(line.replace("\n",""))
    
ind = 0

line1 = unparsedlines[0]
line2 = unparsedlines[1]
line3 = unparsedlines[2]
line4 = unparsedlines[3]
line5 = unparsedlines[4]

foundOp = ''

while ind < len(unparsedlines[0]):
        
    unStrNum = line1[ind] + line2[ind] + line3[ind] + line4[ind]
    
    if line5[ind] != ' ':
        foundOp = line5[ind]
    
    if not all(x.isspace() for x in unStrNum):
        chunks.append(int(unStrNum))
    else:
        match foundOp:
            case '+':
                total += sum(chunks)
                chunks = []               
            case '*':
                total += prod(chunks)
                chunks = []
            case _:
                raise Exception("First Check")
    
    ind += 1
    
    print (unStrNum, foundOp, chunks, ind)
    
print(foundOp)
match foundOp:
            case '+':
                total += sum(chunks)
                chunks = []               
            case '*':
                total += prod(chunks)
                chunks = []
            case _:
                raise Exception("Last check")

print (total)
    