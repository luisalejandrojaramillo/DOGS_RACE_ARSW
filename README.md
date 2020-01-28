Realizado por Luis Alejandro Jaramillo y  Carlos Andrés Castañeda

# DOGS_RACE_ARSW

## Part I
### Creation, commissioning and coordination of threads.

1. Review the "concurrent cousins" program (in the folder part1), provided 
in the package edu.eci.arsw.primefinder. This is a program that calculates 
the prime numbers between two intervals, distributing their search among 
independent threads. For now, it has a single thread that seeks cousins ​​
between 0 and 30,000,000. Run it, open the operating system process manager, 
and verify how many cores are used by it.

![](/img/dr_parte1_1.png)

![](/img/dr_parte1_2.png)

2. Modify the program so that, instead of solving the problem with a single
 thread, do it with three, where each of these will make up the first part 
 of the original problem. Check the operation again, and again check the use 
 of the equipment cores.

![](/img/dr_parte1_3.png)

![](/img/dr_parte1_4.png)

3. What you have been asked for is: you must modify the application so that 
when 5 seconds have elapsed since the execution started, all the threads are 
stopped and the number of primes ​​found so far is displayed. Then, you must wait 
for the user to press ENTER to resume their execution.