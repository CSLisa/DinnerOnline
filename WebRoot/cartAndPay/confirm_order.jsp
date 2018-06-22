<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();

String basePath2 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/E0301PayOff";

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>确认订单</title>
<link href="../style/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/public.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jqpublic.js"></script>
<script type="text/javascript">
	<%-- (function ($) {
                $.getUrlParam = function (name) {
	                    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	                    var r = window.location.search.substr(1).match(reg);
	                    if (r != null) return decodeURI(r[2]);return null;
	                }
        		})(jQuery);
    
	$(function(){
		var id=$.getUrlParam('p2_Order');
		$.getJSON("<%=basePath%>/cart/findAll.do?id="+id, function(data){
			 $.each(data, function(i,item){
			 	var="<tr>"
			 	+"<td>"+item.name+"</td>"
			 	+"<td>"+item.quantity+"</td>"
			 	+"<td>"+item.price+"</td>"
			 	+"<td>"+item.subtotal+"</td>"
	     		+"</tr>";	
	     		$("table.tbody").append(div);
			 })
		})
		$.getJSON("<%=basePath%>/cart/findAll.do?id="+id, function(data){
			 $.each(data, function(i,item){
			 	var=
			 })
		})
	}) --%>
</script>
</head>
<body>
<header>
 <section class="Topmenubg">
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
  </div>
  <div class="Search"> 
   <form method="get" id="main_a_serach" onsubmit="return check_search(this)">
   <div class="Search_nav" id="selectsearch">
    <a href="javascript:;" onClick="selectsearch(this,'restaurant_name')" class="choose">餐厅</a>
    <a href="javascript:;" onClick="selectsearch(this,'food_name')">食物名</a>
   </div>
   <div class="Search_area"> 
   <input type="search" id="fkeyword" name="keyword" placeholder="请输入您所需查找的餐厅名称或食物名称..." class="searchbox" />
   <input type="submit" class="searchbutton" value="搜 索" />
   </div>
   </form>
   <p class="hotkeywords"><a href="#" title="酸辣土豆丝">酸辣土豆丝</a><a href="#" title="这里是产品名称">螃蟹炒年糕</a><a href="#" title="这里是产品名称">牛奶炖蛋</a><a href="#" title="这里是产品名称">芝麻酱凉面</a><a href="#" title="这里是产品名称">滑蛋虾仁</a><a href="#" title="这里是产品名称">蒜汁茄子</a></p>
  </div>
 </div>
 <nav class="menu_bg">
  <ul class="menu">
   	<li><a href="<%=basePath%>/index.jsp">首页</a></li>
	<li><a href="<%=basePath%>/dishes/list.jsp">订餐</a></li>
	<li><a href="<%=basePath%>/dishes/category.jsp">积分商城</a></li>
	<li><a href="<%=basePath%>/sysMsg/article_read.jsp">关于我们</a></li>
  </ul>
 </nav>
</header>
<!--Start content-->
<section class="Psection MT20" id="Cflow">
<!--配送方式及支付，则显示如下-->
<!--check order or add other information-->
<form action="<%=basePath2%>/pay/toAdd.st" method="post">
 <div class="pay_delivery">
  <span class="flow_title">在线支付方式：</span>
   <input type="hidden" name ="p2_Order" value="${orders.id}"/>
    <ul>
    <li><input type="radio" name="pd_FrpId" id="CCB" value="CCB-NET-B2C" /><label for="CCB"><i class="CCB"></i></label></li>
    <li><input type="radio" name="pd_FrpId" id="ICBC" value="ICBC-NET-B2C" /><label for="ICBC"><i class="ICBC"></i></label></li>
    <li><input type="radio" name="pd_FrpId" id="ABC" value="ABC-NET-B2C" /><label for="ABC"><i class="ABC"></i></label></li>
    </ul>
   
  </div>
  
  <div class="inforlist">
   <span class="flow_title">商品清单</span>
   <table>
    <th>名称</th>
    <th>数量</th>
    <th>价格</th>
    <th>小计</th>
    <tbody>
     <c:forEach items="${lists}" var="each" varStatus="status">
	    <tr>
	     <td>${each.name}</td>
	     <td>${each.quantity}</td>
	     <td>${each.price}</td>
	     <td>${each.subtotal}</td>
	    </tr>
    </c:forEach> 
    </tbody>
   </table>

    <div class="Sum_infor">
    <input type="hidden" name ="p3_Amt" value="${orders.amount}"/>
    <p class="p1">商品费用：￥${orders.amount}</p>
    <p class="p2">合计：<span>￥${orders.amount}</span></p>
    <input type="submit" value="立即付款" class="p3button"/>
    </div>
   </div>
   </form>
</section>
<!--End content-->
<footer>
 <section class="Otherlink">
  <aside>
   <div class="ewm-left">
    <p>手机扫描二维码：</p>
    <img src="../images/Android_ico_d.gif">
    <img src="../images/iphone_ico_d.gif">
   </div>
   <div class="tips">
    <p>客服热线</p>
    <p><i>1830927**73</i></p>
    <p>配送时间</p>
    <p><time>09：00</time>~<time>22:00</time></p>
    <p>网站公告</p>
   </div>
  </aside>
  <section>
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
  </section>
 </section>
	<div class="copyright">© 版权所有 2018 HS 技术支持：<a href="#" title="版权所有">HS</a></div>
</footer>
</body>
</html>

