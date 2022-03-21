# Image Multiplication
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">You are given a binary tree. Your task is pretty straightforward. You have to find the sum of the product of each node and its mirror image (The mirror of a node is a node which exists at the mirror position of the node in opposite subtree at the root.). Don’t take into account a pair more than once. The root node is the mirror image of itself.</span></p>

<p>&nbsp;</p>

<p><strong><span style="font-size:18px">Example 1:</span></strong></p>

<pre><strong><span style="font-size:18px">Input:</span></strong>
<span style="font-size:18px">      4         </span>
<span style="font-size:18px">    /    \</span>
<span style="font-size:18px">   5      6</span>
<span style="font-size:18px"><strong>Output:</strong></span>
<span style="font-size:18px">46</span>
<span style="font-size:18px"><strong>Explanation:</strong></span>
<span style="font-size:18px">Sum = (4*4) + (5*6) = 46</span></pre>

<p><strong><span style="font-size:18px">Example 2:</span></strong></p>

<pre><strong><span style="font-size:18px">Input:</span></strong>
<span style="font-size:18px">                       1                 </span>
<span style="font-size:18px">                   /        \</span>
<span style="font-size:18px">                 3            2</span>
        <span style="font-size:18px">          /  \         /  \</span>
<span style="font-size:18px">              7     6       5    4</span>
<span style="font-size:18px">            /   \    \     /  \    \</span>
<span style="font-size:18px">          11    10    15  9    8    12</span>
<strong><span style="font-size:18px">Output:</span></strong>
<span style="font-size:18px">332</span>
<strong><span style="font-size:18px">Explanation:</span></strong>
<span style="font-size:18px">Sum = (1*1) + (3*2) + (7*4) + (6*5) + (11*12) + (15*9) = 332</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You need to&nbsp;<strong>complete&nbsp;</strong>the&nbsp;<strong>function imgMultiply()&nbsp;</strong>that takes&nbsp;<strong>root&nbsp;</strong>as&nbsp;<strong>parameter&nbsp;</strong>and&nbsp;<strong>returns&nbsp;</strong>the&nbsp;<strong>required sum</strong>.The answer may be very large, compute the answer modulo 10<sup>9</sup>&nbsp;+ 7.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(Number of nodes).<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(Height of the Tree).</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span></p>

<p><span style="font-size:18px">1 &lt;= Number of nodes &lt;= 10<sup>5</sup><br>
1 &lt;= Data of a node &lt;= 10<sup>5</sup></span></p>
 <p></p>
            </div>