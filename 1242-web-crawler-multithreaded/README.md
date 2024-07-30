<h2><a href="https://leetcode.com/problems/web-crawler-multithreaded/">1242. Web Crawler Multithreaded</a></h2><h3>Medium</h3><hr><div><p>Given a URL <code>startUrl</code> and an interface <code>HtmlParser</code>, implement <strong>a Multi-threaded web crawler</strong> to crawl all links that are under the <strong>same hostname</strong> as <code>startUrl</code>.</p>

<p>Return all URLs obtained by your web crawler in <strong>any</strong> order.</p>

<p>Your crawler should:</p>

<ul>
	<li>Start from the page: <code>startUrl</code></li>
	<li>Call <code>HtmlParser.getUrls(url)</code> to get all URLs from a webpage of a given URL.</li>
	<li>Do not crawl the same link twice.</li>
	<li>Explore only the links that are under the <strong>same hostname</strong> as <code>startUrl</code>.</li>
</ul>
<img alt="" src="https://assets.leetcode.com/uploads/2019/08/13/urlhostname.png" style="width: 500px; height: 136px;">
<p>As shown in the example URL above, the hostname is <code>example.org</code>. For simplicity's sake, you may assume all URLs use <strong>HTTP protocol</strong> without any <strong>port</strong> specified. For example, the URLs <code>http://leetcode.com/problems</code> and <code>http://leetcode.com/contest</code> are under the same hostname, while URLs <code>http://example.org/test</code> and <code>http://example.com/abc</code> are not under the same hostname.</p>

<p>The <code>HtmlParser</code> interface is defined as such:</p>

<pre>interface HtmlParser {
  // Return a list of all urls from a webpage of given <em>url</em>.
  // This is a blocking call, that means it will do HTTP request and return when this request is finished.
  public List&lt;String&gt; getUrls(String url);
}
</pre>

<p>Note that <code>getUrls(String url)</code> simulates performing an HTTP request. You can treat it as a blocking function call that waits for an HTTP request to finish. It is guaranteed that <code>getUrls(String url)</code> will return the URLs within <strong>15ms. </strong> Single-threaded solutions will exceed the time limit so, can your multi-threaded web crawler do better?</p>

<p>Below are two examples explaining the functionality of the problem. For custom testing purposes, you'll have three variables <code>urls</code>, <code>edges</code> and <code>startUrl</code>. Notice that you will only have access to <code>startUrl</code> in your code, while <code>urls</code> and <code>edges</code> are not directly accessible to you in code.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/10/23/sample_2_1497.png" style="width: 610px; height: 300px;"></p>

<pre><strong>Input:
</strong>urls = [
&nbsp; "http://news.yahoo.com",
&nbsp; "http://news.yahoo.com/news",
&nbsp; "http://news.yahoo.com/news/topics/",
&nbsp; "http://news.google.com",
&nbsp; "http://news.yahoo.com/us"
]
edges = [[2,0],[2,1],[3,2],[3,1],[0,4]]
startUrl = "http://news.yahoo.com/news/topics/"
<strong>Output:</strong> [
&nbsp; "http://news.yahoo.com",
&nbsp; "http://news.yahoo.com/news",
&nbsp; "http://news.yahoo.com/news/topics/",
&nbsp; "http://news.yahoo.com/us"
]
</pre>

<p><strong class="example">Example 2:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/10/23/sample_3_1497.png" style="width: 540px; height: 270px;"></strong></p>

<pre><strong>Input:</strong> 
urls = [
&nbsp; "http://news.yahoo.com",
&nbsp; "http://news.yahoo.com/news",
&nbsp; "http://news.yahoo.com/news/topics/",
&nbsp; "http://news.google.com"
]
edges = [[0,2],[2,1],[3,2],[3,1],[3,0]]
startUrl = "http://news.google.com"
<strong>Output:</strong> ["http://news.google.com"]
<strong>Explanation: </strong>The startUrl links to all other pages that do not share the same hostname.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= urls.length &lt;= 1000</code></li>
	<li><code>1 &lt;= urls[i].length &lt;= 300</code></li>
	<li><code>startUrl</code>&nbsp;is one of the <code>urls</code>.</li>
	<li>Hostname label must be from <code>1</code> to <code>63</code> characters long, including the dots, may contain only the ASCII letters from <code>'a'</code> to&nbsp;<code>'z'</code>, digits from <code>'0'</code> to <code>'9'</code> and the&nbsp;hyphen-minus&nbsp;character (<code>'-'</code>).</li>
	<li>The hostname may not start or end with&nbsp;the hyphen-minus character ('-').&nbsp;</li>
	<li>See:&nbsp;&nbsp;<a href="https://en.wikipedia.org/wiki/Hostname#Restrictions_on_valid_hostnames" target="_blank">https://en.wikipedia.org/wiki/Hostname#Restrictions_on_valid_hostnames</a></li>
	<li>You may assume there're&nbsp;no duplicates in the URL library.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong></p>

<ol>
	<li>Assume we have 10,000 nodes and 1 billion URLs to crawl. We will deploy the same software onto each node. The software can know about all the nodes. We have to minimize communication between machines and make sure each node does equal amount of work. How would your web crawler design change?</li>
	<li>What if one node fails or does not work?</li>
	<li>How do you know when the crawler is done?</li>
</ol>
</div>