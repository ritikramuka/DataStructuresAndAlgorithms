# Equilibrium Point
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an array A of n&nbsp;positive numbers. The task is to find the first Equilibrium Point in an array.&nbsp;<br>
Equilibrium Point in an array is a position such that the sum of elements before it is equal to the sum of elements after it.</span></p>

<p><strong><span style="font-size:18px">Note: Retun the index of Equilibrium point. (1-based index)</span></strong></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: 
</strong>n = 5 
A[] = {1,3,5,2,2} 
<strong>Output: </strong>3<strong> 
Explanation: </strong> 
equilibrium point is at position 3 
as elements before it (1+3) = 
elements after it (2+2).<strong> </strong></span>
</pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><strong>Input:
</strong><span style="font-size:18px">n = 1
A[] = {1}
<strong>Output: </strong>1<strong>
Explanation:
</strong>Since its the only element hence
its the only equilibrium point.</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your&nbsp;Task:</strong><br>
The task is to complete the function <strong>equilibriumPoint()</strong> which takes the array and n&nbsp;as input parameters and returns the point of equilibrium. Return -1 if no such point exists. </span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity: </strong>O(n)<br>
<strong>Expected Auxiliary Space:</strong> O(1)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= n&nbsp;&lt;= 10<sup>6</sup><br>
1 &lt;= A[i]&nbsp;&lt;= 10<sup>8</sup></span></p>
</div>