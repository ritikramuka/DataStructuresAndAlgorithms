# Maximum value of difference of a pair of elements and their Index
## Medium
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an array <strong>arr[]</strong> of <strong>N</strong> positive integers. Find maximum value of |arr[i] – arr[j]| + |i – j|, (0 &lt;= i, j &lt;= N – 1)</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong></span>
<span style="font-size:18px"><strong>N = </strong>4</span><strong> </strong>
<span style="font-size:18px"><strong>arr[] = </strong>{1, 2, 3, 1}</span>
<span style="font-size:18px"><strong>Output:</strong></span>
<span style="font-size:18px">4</span>
<span style="font-size:18px"><strong>Explanation:</strong></span>
<span style="font-size:18px">Choosing i=0 and j=2, will result in
|1-3|+|0-2| = 4, which is the maximum
possible value.</span>
</pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong></span>
<span style="font-size:18px"><strong>N = </strong>3</span><strong> </strong>
<span style="font-size:18px"><strong>A[] = </strong>{1, 1, 1}</span>
<span style="font-size:18px"><strong>Output:</strong></span>
<span style="font-size:18px">2</span>
<span style="font-size:18px"><strong>Explanation:</strong></span>
<span style="font-size:18px">Choosing i=0 and j=2, will result in
|1-1|+|0-2| = 2, which is the maximum
possible value.</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>maxValue()</strong> which takes an Integer N and an array arr of size N as input and returns the maximum possoble value of |arr[i] – arr[j]| + |i – j|.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N)<br>
<strong>Expected Auxiliary Space:</strong> O(N)</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong></span><br>
<span style="font-size:18px">1 &lt;= N &lt;= 10<sup>5</sup><br>
0 &lt;= arr[i] &lt;= 10<sup>5</sup></span></p>
</div>