# Assign Mice Holes
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given, <strong>N</strong> Mice and N holes are placed in a straight line. Each hole can accommodate only 1 mouse. A mouse can stay at his position, move one step right from <strong>x to x + 1</strong>, or move one step left from <strong>x to x -1</strong>. Any of these moves consumes <strong>1</strong> minute. Write a program to assign mice to holes so that the time when the last mouse gets inside a hole is minimized.</span><br>
<span style="font-size:18px"><strong>Note: </strong>Arrays M and H are the positions of the N mice and holes.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong></span>
<span style="font-size:18px"><strong>N = </strong>3
<strong>M = </strong>{4, -4, 2}
<strong>H = </strong>{4, 0, 5</span><span style="font-size:18px">}</span>
<span style="font-size:18px"><strong>Output:</strong></span>
<span style="font-size:18px">4</span>
<span style="font-size:18px"><strong>Explanation:</strong></span>
<span style="font-size:18px">If we assign mouse at 1st index to
the hole at 1st, mouse at 2nd index
to the hole at 2nd and the third to
the hole at third. Then, the maximum
time taken will be by the 2nd mouse,
i.e. 4-0 = 4 minutes.</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong></span>
<span style="font-size:18px"><strong>N = </strong>2
<strong>M = </strong>{4, 2}
<strong>H = </strong>{1, 7</span><span style="font-size:18px">}</span>
<span style="font-size:18px"><strong>Output:</strong></span>
<span style="font-size:18px">3</span>
<span style="font-size:18px"><strong>Explanation:</strong></span>
<span style="font-size:18px">If we assign mouse at 1st index to
the hole at 2nd, and mouse at 2nd index
to the hole at 1st, the maximum
time taken will be by the 2nd mouse,
i.e. 7-4 = 3 minutes.</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>assignMiceHoles()</strong> which takes an Integer N&nbsp; and arrays M and H as input and returns the answer.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N*log(N))<br>
<strong>Expected Auxiliary Space:</strong> O(1)</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong></span><br>
<span style="font-size:18px">1 &lt;= N &lt;= 10<sup>5</sup></span><br>
<span style="font-size:18px">-10<sup>5 </sup>&lt;= M[i] , H[i] &lt;= 10<sup>5</sup></span></p>
</div>