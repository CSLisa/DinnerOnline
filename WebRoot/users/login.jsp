<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="utf-8" />
<title>登录</title>
<meta name="author" content="hs"/>
<link href="../style/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/public.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jqpublic.js"></script>
</head>
<body>
<header>
 <section class="Topmenubg">
  <div class="Topnav">
   <div class="LeftNav">
    <a href="register.jsp">注册</a>/<a href="login.jsp">登录</a><a href="#">QQ客服</a><a href="#">微信客服</a><a href="#">手机客户端</a>
   </div>
   <div class="RightNav">
    <a href="user_center.jsp">用户中心</a> <a href="user_orderlist.jsp" target="_blank" title="我的订单">我的订单</a> <a href="../cartAndPay/cart.jsp">购物车（0）</a> <a href="user_favorites.html" target="_blank" title="我的收藏">我的收藏</a> <a href="#">商家入驻</a>
   </div>
  </div>
 </section>
 <div class="Logo_search">
  <div class="Logo">
   <a href="../index.jsp"><img src="../images/logo.jpg" title="logo" alt="商标"></a>
   <i></i>
  </div>
  </div>
</header>
<!--Start content-->
<section class="Psection MT20">
 <form action="userAction.action" method="post">
  <table class="login">
  <tr>
  <td width="40%" align="right" class="FontW">账号：</td>
  <td><input type="text" name="name" required autofocus placeholder="账号/电子邮件/手机号码"></td>
  </tr>
  <tr>
  <td width="40%" align="right" class="FontW">密码：</td>
  <td><input type="password" name="pwd" required></td>
  </tr>
  <tr>
  <td width="40%" align="right" class="FontW">验证码：</td>
  <td><input type="text" name="code" value="" />${error }
  <img src="userAction.action?method=getCode" title="看不清请刷新" onclick="this.src='userAction.action?method=getCode&num='+Math.random()" />
  </td>
  </tr>
  <tr>
  <td width="40%" align="right"></td>
  <td><input type="submit" name="" value="登 录" class="Submit_b">( 已经是***会员，<a href="#" class="BlueA">请登录</a> )</td>
  </tr>
  </table>
 </form>
</section>
<!--End content-->

<footer>
 <div class="copyright">
 <p><a href="article_read.jsp">关于我们</a></p>
 © 版权所有 2018 HS 技术支持：<a href="#" title="版权所有">HS</a></div>
</footer>
</body>
</html>
