# Ways To Tile A Floor
## Easy
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a floor of dimensions 2 x W and tiles of dimensions 2 x 1, the task is to find the number of ways the floor can be tiled.&nbsp;A tile can either be placed horizontally i.e&nbsp;as a 1 x 2 tile or vertically i.e&nbsp;as 2 x 1 tile. Print the answer modulo 10<sup>9</sup>+7.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong></span>
<span style="font-size:18px"><strong>W = </strong>3</span>
<span style="font-size:18px"><strong>Output:</strong></span>
<span style="font-size:18px">3</span>
<span style="font-size:18px"><strong>Explanation:</strong></span>
<span style="font-size:18px">We need 3 tiles to tile the board
of size  2 x 3. 
We can tile in following ways:
1) Place all 3 tiles vertically. 
2) Place first tile vertically.
and remaining 2 tiles horizontally.
3) Place first 2 tiles horizontally
and remaining tiles vertically.</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong></span>
<span style="font-size:18px"><strong>W = </strong>4</span>
<span style="font-size:18px"><strong>Output:</strong></span>
<span style="font-size:18px">5</span>
<span style="font-size:18px"><strong>Explanation:</strong></span>
<span style="font-size:18px">For a 2 x 4 board, there are 5 ways
1) All 4 vertical
2) All 4 horizontal
3) First 2 vertical, remaining
2 horizontal.
4) First 2 horizontal, remaining
2 vertical.
5) Corner 2 vertical, middle
2 horizontal.</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>numberOfWays()</strong> which takes an Integer N as input and returns the answer.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N)<br>
<strong>Expected Auxiliary Space:</strong> O(1)</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong></span><br>
<span style="font-size:18px">1 &lt;= N &lt;= 10<sup>5</sup></span></p>
 <p></p>
            </div>