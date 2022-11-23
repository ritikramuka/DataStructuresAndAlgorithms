# Nuts and Bolts Problem
## Medium
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a set of <strong>N</strong>&nbsp;nuts of different sizes and <strong>N</strong>&nbsp;bolts of different sizes. There is a one-one mapping between nuts and bolts. Match nuts and bolts efficiently.</span></p>

<p><span style="font-size:18px">Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.<br>
The elements should follow&nbsp;the following order&nbsp;! # $ % &amp; * @ ^ ~ .</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: 
</strong>N = 5
nuts[] = {@, %, $, #, ^}
bolts[] = {%, @, #, $ ^}
<strong>Output:</strong> 
# $ % @ ^
# $ % @ ^
</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong> 
N = 9
nuts[] = {^, &amp;, %, @, #, *, $, ~, !}
bolts[] = {~, #, @, %, &amp;, *, $ ,^, !}
<strong>Output:</strong> 
! # $ % &amp; * @ ^ ~
! # $ % &amp; * @ ^ ~
</span></pre>

<p><span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>matchPairs()</strong>&nbsp;which takes an array of characters&nbsp;<strong>nuts[]</strong>, <strong>bolts[] </strong>and&nbsp;<strong>n</strong><strong>&nbsp;</strong>as parameters and returns void. You need to change the array itself.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(NlogN)<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(1)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= N &lt;= 9<br>
Array of Nuts/Bolts can only consist of the following elements:{'@', '#', '$', '%', '^', '&amp;', '~', '*', '!'}.</span><br>
&nbsp;</p>
</div>