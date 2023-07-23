# Preorder traversal (Iterative)
## Medium
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a binary tree. Find the preorder traversal of the tree <strong>without using recursion</strong>.</span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
<strong>           </strong>1
<strong>         /   \</strong>
        2     3
      /  \
     4    5
<strong>Output: </strong>1 2 4 5 3
<strong>Explanation:</strong>
Preorder traversal (Root-&gt;Left-&gt;Right) of 
the tree is 1 2 4 5 3.
</span></pre>

<p><span style="font-size:18px"><strong>Example 2</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
            8
          /   \
         1      5
          \    /  \
           7  10   6
            \  /
&nbsp;           10 6
<strong>Output: </strong>8 1 7 10 5 10 6 6&nbsp;
<strong>Explanation:</strong>
Preorder traversal (Root-&gt;Left-&gt;Right) 
of the tree is 8 1 7 10 5 10 6 6.</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your task:</strong></span></p>

<p><span style="font-size:18px">You don't need to read input or print anything. Your task is to complete the function pre<strong>Order() </strong>which takes the root of the tree as input and returns a list containing the preorder traversal of the tree, calculated<strong> without using recursion.</strong></span></p>

<p><br>
<span style="font-size:18px"><strong>Expected time complexity: </strong>O(N)</span><br>
<span style="font-size:18px"><strong>Expected auxiliary space: </strong>O(N)</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong></span><br>
<span style="font-size:18px">1 ≤ Number of nodes ≤ 10<sup>5</sup></span><br>
<span style="font-size:18px">1 ≤ Data of a node ≤ 10<sup>5</sup></span></p>
</div>