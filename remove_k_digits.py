'''
===================================== Remove K digits ==============================
In the provided problem statement we are given with a string of numbers on which we
are required to remove "K" elements so as to obtain the minimum numerical value 
possible. 

Here I have adopted a recursive approach which is eventhough quite computationally
complex (time complexity is very high) but easy to understand and comprehend.

====================================================================================

Authored By : TensorNd
'''


import math

def remove_k_digits(number,k):
    if len(number)==1:
        return(int(number))
    if k==0 or len(number)<k:
        return int(number)
    else:
        num=remove_k_digits(number[1:],k-1)
        for i in range(1,len(number)):
            num1=remove_k_digits(number[0:i]+number[i+1:],k-1)
            if num1<num:
                num=num1
        return(num)

# Test cases.
print(remove_k_digits("10200",1))  # -> 200
print(remove_k_digits("1432219",3)) # -> 1219
