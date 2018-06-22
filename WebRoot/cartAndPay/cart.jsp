<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<!DOCTYPE HTML >
<html>
<head>

<title>我的购物车</title>
<link href="../style/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/public.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jqpublic.js"></script>
    
    <script type="text/javascript">
        $(function () {
            
            $.getJSON("<%=basePath%>/cart/findAll.do", function(data){
                $.each(data, function(i,item){
                   var count=i+1;
                    var table="<table cellpadding=\"0\" cellspacing=\"0\" class=\"gwc_tb2\" id=\"tab\">\n" +
                        "\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t    <input type=\"hidden\" name =\"orderID_"+count+"\" value=\""+item.id+"\" id=\"orderID_"+count+"\"/>\n" +
                        "\t\t\t\t\t\t<td class=\"tb2_td1\"><input type=\"checkbox\" name=\"newslist\" id=\"newslist_"+count+"\"  value=\""+item.id+"\"/></td>\n" +
                        "\t\t\t\t\t\t<td class=\"tb2_td2\"><a href=\"detailsp.jsp\" target=\"_blank\"><img src=\"<%=basePath%>/upload/0"+count+".jpg\" /></a></td>\n" +
                        "\t\t\t\t\t\t<td class=\"tb2_td3\"><a href=\"detailsp.jsp\" target=\"_blank\">"+item.name+"</a></td>\n" +
                        "\t\t\t\t\t\t<td class=\"tb1_td4\"><s>￥"+item.originalPrice+"</s></td>\n" +
                        "\t\t\t\t\t\t<td class=\"tb1_td5\">\n" +
                        "\t\t\t\t\t\t\t<input class=\"min\" style=\"width:30px; height:30px; border:1px solid #ccc;\" type=\"button\" value=\"-\" />\n" +
                        "\t\t\t\t\t\t\t<input class=\"text_box_"+count+"\" name=\"\" type=\"text\" value=\""+item.quantity+"\" style=\" width:40px;height:28px; text-align:center; border:1px solid #ccc;\" />\n" +
                        "\t\t\t\t\t\t\t<input class=\"add\" style=\"width:30px; height:30px;border:1px solid #ccc;\"  type=\"button\" value=\"+\" /></td>\n" +
                        "\t\t\t\t\t\t<td class=\"tb1_td6\"><span  class=\"price_"+count+"\" >"+item.price+"</span></td>\t\t\t\n" +
                        "\t\t\t\t\t\t<td class=\"tb1_td7\"><a href=\"<%=basePath%>/shoppingCart/delete.do?id="+item.id+"\" id=\"delcart1\" onClick=\"return confirm('确定删除此信息吗？')\">删除</a></td>\n" +
                        "\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t</table>"
                    $(".gwc_tb1").after(table)
                    $("#size").val(count);
                });
            });
            
        })
    </script>
<script type="text/javascript" src="<%=basePath%>/js/cart.js"></script>
</head>
<body>
    <input type="hidden" value="<%=basePath%>" id="path"/>
	<header> <section class="Topmenubg">
	<div class="Topnav">
		<div class="LeftNav">
			<a href="<%=basePath%>/users/register.jsp">注册</a>/<a href="../users/login.jsp">登录</a><a href="#">QQ客服</a><a
				href="#">微信客服</a><a href="<%=basePath%>/index.jsp">首页</a>
		</div>
		<div class="RightNav">
			<a href="<%=basePath%>/users/user_center.jsp">用户中心</a> <a href="<%=basePath%>/users/user_orderlist.jsp"
				target="_blank" title="我的订单">我的订单</a> <a href="<%=basePath%>/cartAndPay/cart.jsp">购物车（0）</a>
			<a href="../users/user_favorites.jsp" target="_blank" title="我的收藏">我的收藏</a> <a
				href="#">商家入驻</a>
		</div>
	</div>
	</section>
	<div class="Logo_search">
		<div class="Logo">
			<a href="../index.jsp"><img src="<%=basePath%>/images/logo.jpg" title="logo" alt="商标"></a> <i></i>
			<span>西安市 [ <a href="#">莲湖区</a> ]
			</span>
		</div>
		<div class="Search">
			<form method="get" id="main_a_serach"
				onsubmit="return check_search(this)">
				<div class="Search_nav" id="selectsearch">
					<a href="javascript:;"
						onClick="selectsearch(this,'restaurant_name')" class="choose">餐厅</a>
					<a href="javascript:;" onClick="selectsearch(this,'food_name')">食物名</a>
				</div>
				<div class="Search_area">
					<input type="search" id="fkeyword" name="keyword"
						placeholder="请输入您所需查找的餐厅名称或食物名称..." class="searchbox" /> <input
						type="submit" class="searchbutton" value="搜 索" />
				</div>
			</form>
			<p class="hotkeywords">
				<a href="#" title="酸辣土豆丝">酸辣土豆丝</a><a href="#" title="这里是产品名称">螃蟹炒年糕</a><a
					href="#" title="这里是产品名称">牛奶炖蛋</a><a href="#" title="这里是产品名称">芝麻酱凉面</a><a
					href="#" title="这里是产品名称">滑蛋虾仁</a><a href="#" title="这里是产品名称">蒜汁茄子</a>
			</p>
		</div>
	</div>
	<nav class="menu_bg">
	<ul class="menu">
		<li><a href="<%=basePath%>/index.jsp">首页</a></li>
		<li><a href="<%=basePath%>/dishes/list.jsp">订餐</a></li>
		<li><a href="<%=basePath%>/dishes/category.jsp">积分商城</a></li>
		<li><a href="<%=basePath%>/sysMsg/article_read.jsp">关于我们</a></li>
	</ul>
	</nav> </header>
	<!--Start content-->
	<form action="<%=basePath%>/orders/toAdd.do" id="subform" method="post">
		<div class="gwc" style=" margin:auto;" id="lists">
			<table cellpadding="0" cellspacing="0" class="gwc_tb1">
				<tr>
					
					<td class="tb1_td3">商品</td>
					<td class="tb1_td4">原价</td>
					<td class="tb1_td5">数量</td>
					<td class="tb1_td6">单价</td>
					<td class="tb1_td7">操作</td>
				</tr>
			</table>

			<%-- <c:forEach items="${shoppingCartList }" var="each" varStatus="status">
				<table cellpadding="0" cellspacing="0" class="gwc_tb2" id="tab">
					<tr>
					    <input type="hidden" name ="orderID_${status.count}" value="${each.id}" id="orderID_${status.count}"/>
						<td class="tb2_td1"><input type="checkbox" name="newslist" id="newslist_${status.count }" onclick="checkok()" value="${each.id }"/></td>
						<td class="tb2_td2"><a href="detailsp.jsp" target="_blank"><img src="<%=basePath%>/upload/0${status.count }.jpg" /></a></td>
						<td class="tb2_td3"><a href="detailsp.jsp" target="_blank">${each.name }</a></td>
						<td class="tb1_td4"><s>￥${each.originalPrice }</s></td>
						<td class="tb1_td5">
							<input class="min" style="width:30px; height:30px; border:1px solid #ccc;" type="button" value="-" />
							<input class="text_box_${status.count }" name="" type="text" value="${each.quantity }" style=" width:40px;height:28px; text-align:center; border:1px solid #ccc;" />
							<input class="add" style="width:30px; height:30px;border:1px solid #ccc;"  type="button" value="+" /></td>
						<td class="tb1_td6"><span  class="price_${status.count }" >${each.price}</span></td>			
						<td class="tb1_td7"><a href="<%=basePath%>/shoppingCart/delete.do?id=${each.id }" id="delcart1" onClick="return confirm('确定删除此信息吗？')">删除</a></td>
					</tr>
				</table>
			</c:forEach> --%>
			<input type="hidden"  id="size" value="2">
			<table cellpadding="0" cellspacing="0" class="gwc_tb3">
				<tr>
					<td class="tb1_td1">
					    <input id="checkAll" class="allselect" type="radio" name="radio"/></td>
					<td class="tb1_td1">全选</td>
					<td class="tb3_td1"><input id="invert" type="radio" name="radio"/> 反选
						<input id="cancel" type="radio" name="radio"/> 取消</td>
					<td class="tb3_td2 GoBack_Buy Font14"><a href="<%=basePath%>/index.jsp"
						target="_blank">继续购物</a></td>
					<td class="tb3_td2">已选商品 <label id="shuliang"
						style="color:#ff5500;font-size:14px; font-weight:bold;">0</label>
						件
					</td>
					<td class="tb3_td3">合计(不含运费):<span>￥</span><span
						style=" color:#ff5500;"> <label id="zong1"
							style="color:#ff5500;font-size:14px; font-weight:bold;">0.00</label>
					</span></td>
					<td class="tb3_td4"><a href="javascript:;"  onclick="document.getElementById('subform').submit();return false;"  class="jz2" id="jz2">结算</a></td>
				</tr>
			</table>
		</div>
	</form>
	<!--End content-->
	
	<footer> <section class="Otherlink"> <aside>
	<div class="ewm-left">
		<p>手机扫描二维码：</p>
		<img src="../images/Android_ico_d.gif"> <img
			src="../images/iphone_ico_d.gif">
	</div>
	<div class="tips">
		<p>客服热线</p>
		<p>
			<i>1830927**73</i>
		</p>
		<p>配送时间</p>
		<p>
			<time>09：00</time>
			~
			<time>22:00</time>
		</p>
		<p>网站公告</p>
	</div>
	</aside> <section>
	<div>
		<span><i class="i1"></i>配送支付</span>
		<ul>
			<li><a href="article_read.html" target="_blank" title="标题">支付方式</a></li>
			<li><a href="article_read.html" target="_blank" title="标题">配送方式</a></li>
			<li><a href="article_read.html" target="_blank" title="标题">配送效率</a></li>
			<li><a href="article_read.html" target="_blank" title="标题">服务费用</a></li>
		</ul>
	</div>
	<div>
		<span><i class="i2"></i>关于我们</span>
		<ul>
			<li><a href="article_read.html" target="_blank" title="标题">招贤纳士</a></li>
			<li><a href="article_read.html" target="_blank" title="标题">网站介绍</a></li>
			<li><a href="article_read.html" target="_blank" title="标题">配送效率</a></li>
			<li><a href="article_read.html" target="_blank" title="标题">商家加盟</a></li>
		</ul>
	</div>
	<div>
		<span><i class="i3"></i>帮助中心</span>
		<ul>
			<li><a href="article_read.html" target="_blank" title="标题">服务内容</a></li>
			<li><a href="article_read.html" target="_blank" title="标题">服务介绍</a></li>
			<li><a href="article_read.html" target="_blank" title="标题">常见问题</a></li>
			<li><a href="article_read.html" target="_blank" title="标题">网站地图</a></li>
		</ul>
	</div>
	</section> </section>
	<div class="copyright">© 版权所有 2018 HS 技术支持：<a href="#" title="版权所有">HS</a>
	</div>
	</footer>
</body>
</html>
