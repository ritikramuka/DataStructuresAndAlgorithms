<h2><a href="https://leetcode.com/problems/web-crawler/">1236. Web Crawler</a></h2><h3>Medium</h3><hr><div><p>Given a url <code>startUrl</code> and an interface <code>HtmlParser</code>, implement a web&nbsp;crawler to crawl all links that are under the&nbsp;<strong>same hostname</strong> as&nbsp;<code>startUrl</code>.&nbsp;</p>

<p>Return&nbsp;all urls obtained by your web crawler in <strong>any</strong> order.</p>

<p>Your crawler should:</p>

<ul>
	<li>Start from the page: <code>startUrl</code></li>
	<li>Call <code>HtmlParser.getUrls(url)</code> to get all urls from a webpage of given url.</li>
	<li>Do not crawl the same link twice.</li>
	<li>Explore only the links that are under the <strong>same hostname</strong> as <code>startUrl</code>.</li>
</ul>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/08/13/urlhostname.png" style="width: 600px; height: 164px;"></p>

<p>As shown in the example url above, the hostname is <code>example.org</code>. For simplicity sake, you may assume all&nbsp;urls use <strong>http protocol</strong> without any&nbsp;<strong>port</strong> specified. For example, the urls&nbsp;<code>http://leetcode.com/problems</code> and&nbsp;<code>http://leetcode.com/contest</code> are under the same hostname, while urls <code>http://example.org/test</code> and <code>http://example.com/abc</code> are not under the same hostname.</p>

<p>The <code>HtmlParser</code> interface is defined as such:&nbsp;</p>

<pre>interface HtmlParser {
  // Return a list of all urls from a webpage of given <em>url</em>.
  public List&lt;String&gt; getUrls(String url);
}</pre>

<p>Below&nbsp;are two examples explaining the functionality of the problem, for custom testing purposes you'll have three&nbsp;variables&nbsp;<code data-stringify-type="code">urls</code>,&nbsp;<code data-stringify-type="code">edges</code>&nbsp;and&nbsp;<code data-stringify-type="code">startUrl</code>. Notice that you will only have access to&nbsp;<code data-stringify-type="code">startUrl</code>&nbsp;in your code, while&nbsp;<code data-stringify-type="code">urls</code>&nbsp;and&nbsp;<code data-stringify-type="code">edges</code>&nbsp;are not directly accessible to you in code.</p>

<p>Note: Consider the same URL with the trailing slash "/" as a different URL. For example, "http://news.yahoo.com", and "http://news.yahoo.com/" are different urls.</p>

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
	<li>Hostname label must be from 1 to 63 characters long, including the dots, may contain only the ASCII letters from 'a' to&nbsp;'z', digits&nbsp; from '0' to '9' and the&nbsp;hyphen-minus&nbsp;character ('-').</li>
	<li>The hostname may not start or end with&nbsp;the hyphen-minus character ('-').&nbsp;</li>
	<li>See:&nbsp;&nbsp;<a href="https://en.wikipedia.org/wiki/Hostname#Restrictions_on_valid_hostnames">https://en.wikipedia.org/wiki/Hostname#Restrictions_on_valid_hostnames</a></li>
	<li>You may assume there're&nbsp;no duplicates in url library.</li>
</ul>
</div>