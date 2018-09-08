# La Lotería

This is my solution to the challenge _**La Lotería**_

## Description
La Lotería is a game in which you choose _**C**_ different numbers
in a range from _**1**_ to _**K**_

The usual lottery has _**C=6**_ and _**K=49**_.
in a random, is chosen _**C**_ a set of numbers that are between the range _**1-K**_.
So the winner is the person who hit the more quantity of numbers
compared with the random set.

For use of the probabilistics is required to get the number or numbers that is
less repeated in a set of betting cases. 

## Entry
The entry have several test cases.  
The First line of every test case have `3` numbers.  
we will name them:  
**N** = _The amount of bets (a set of numbers)._  
**C** = _The quantity of numbers that make a bet._  
**K** = _The maximum Range that is permitted in every number that conforms a bet_  

There are some rules for this numbers:  
+ The amount of bets have to be greater than `0` and less or equals to `1000`.  
`1<=N<=10000`  
+ The quantity of numbers that make a bet has to be greater than `0` and less or equals to `10`.  
`1<=C<=10`
+ The Maximun value that the numbers can take are `100`, and the minimum are `C+1`.  
`C<K<100`
>This is because another rule said that the numbers that you choose in a bet it cannot be  
repeated.
So if you have `C = 3` in a bet you have to choose a range _K_ greater than _C_,   
here for example we have `N = 4` four bets with `C = 3` quantity of numbers and a range of `1 to 4` `K=4`:
```
3 2 1
4 2 3
3 2 1
2 1 4
```
>if you had _K_ range less than _C_ you will not be able to put all the numbers.
for example `C=5` and `K=3`:x: : 
```
1 2 3 ? ?
3 2 1 ? ?
``` 
---

After the first line that i like to call it _the info Line_, there are  
_**N**_ lines that are the bets and every bet contains _**C**_ different numbers.
As in the example above it will look like this but now with _the info line_.
```Java
//N C K 
  4 3 20 //info line
  8 9 1  // bet 1
  4 8 5  // bet 2
  7 2 20 // bet 3
  2 8 13 // bet 4
```

## Output
