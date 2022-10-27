# Minimum Cost of ropes
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">There are given&nbsp;<strong>N</strong> ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost. Given&nbsp;<strong>N</strong> size array <strong>arr[]</strong> contains the lengths of the ropes.&nbsp;</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>n = 4
arr[] = {4, 3, 2, 6}
<strong>Output: 
</strong>29<strong>
Explanation:
</strong>We can connect the ropes in following ways.
1) First connect ropes of lengths 2 and 3.
Which makes the array {4, 5, 6}. Cost of
this operation 2+3 = 5. 
2) Now connect ropes of lengths 4 and 5.
Which makes the array {9, 6}. Cost of
this operation 4+5 = 9.
3) Finally connect the two ropes and all
ropes have connected. Cost of this 
operation 9+6 =15
Total cost for connecting all ropes is 5
+ 9 + 15 = 29. This is the optimized cost
for connecting ropes. 
Other ways of connecting ropes would always 
have same or more cost. For example, if we 
connect 4 and 6 first (we get three rope of 3,
2 and 10), then connect 10 and 3 (we get
two rope of 13 and 2). Finally we
connect 13 and 2. Total cost in this way
is 10 + 13 + 15 = 38.</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>n = 5
arr[] = {4, 2, 7, 6, 9}
<strong>Output: 
</strong>62 
<strong>Explanation:</strong>
First, connect ropes 4 and 2, which makes
the array {6,7,6,9}. Cost of
this operation 4+2 = 6. Next, add ropes 
6 and 6, which results in {12,7,9}. 
Cost of this operation 6+6 = 12.
Then, add 7 and 9, which makes the array {12,16}. 
Cost of this operation 7+9 = 16. And
finally, add these two which gives {28}.
Hence, the total cost is 6 + 12 + 16 + 
28 = 62.</span>
</pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task isto complete the&nbsp;function&nbsp;<strong>minCost()</strong> which takes an integer array arr[] and an integer n as&nbsp;arguments and returns the minimum cost.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity</strong> : O(nlogn)<br>
<strong>Expected Auxilliary Space</strong> : O(n)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong></span><br>
<span style="font-size:18px">1 ≤ N ≤ 200000<br>
1 ≤ arr[i] ≤ 10<sup>6</sup></span></p>
</div>