import math

unparsedlines = []
nums = []
total = 0;

createdNums = []

with open("input2.txt") as f:
    for line in f:
        unparsedlines.append(line.replace("\n",""))
    
ind = 0

str1 = unparsedlines[0]
str2 = unparsedlines[1]
str3 = unparsedlines[2]
str4 = unparsedlines[3]
str5 = unparsedlines[4]

while ind < len(unparsedlines[0]):
        
    unStrNum = str1[ind] + str2[ind] + str3[ind] + str4[ind]
    
    createdNums.append(unStrNum);
        
    ind += 1
    
print (total)
