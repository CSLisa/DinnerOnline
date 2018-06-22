<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>DeathGhost-用户中心</title>
<link href="../style/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/public.js"></script>
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
    <a href="user_center.jsp">用户中心</a> <a href="user_orderlist.jsp" target="_blank" title="我的订单">我的订单</a> <a href="cart.jsp">购物车（0）</a> <a href="user_favorites.jsp" target="_blank" title="我的收藏">我的收藏</a> <a href="#">商家入驻</a>
   </div>
  </div>
 </section>
 <div class="Logo_search">
  <div class="Logo">
   <a href="../index.jsp"><img src="../images/logo.jpg" title="logo" alt="商标"></a>
   <i></i>
   <span>西安市 [ <a href="#">莲湖区</a> ]</span>
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
   <li><a href="../index.jsp">首页</a></li>
   <li><a href="../dishes/list.jsp">订餐</a></li>
   <li><a href="../dishes/category.jsp">积分商城</a></li>
   <li><a href="../sysMsg/article_read.jsp">关于我们</a></li>
  </ul>
 </nav>
</header>
<!--Start content-->
<section class="Psection MT20">
<nav class="U-nav Font14 FontW">
  <ul>
   <li><i></i><a href="user_center.jsp">用户中心首页</a></li>
   <li><i></i><a href="user_orderlist.jsp">我的订单</a></li>
   <li><i></i><a href="user_address.jsp">收货地址</a></li>
   <li><i></i><a href="user_message.jsp">我的留言</a></li>
   <li><i></i><a href="user_coupon.jsp">我的优惠券</a></li>
   <li><i></i><a href="user_favorites.jsp">我的收藏</a></li>
   <li><i></i><a href="user_account.jsp">账户管理</a></li>
   <li><i></i><a href="#">安全退出</a></li>
  </ul>
 </nav>
 <article class="U-article Overflow">
  <!--user Address-->
  <section class="Myaddress Overflow">
   <span class="MDtitle Font14 FontW Block Lineheight35">收货人信息</span>
   <form action="#">
   <table>
    <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right">选择所在地：</td>
     <td>
     <select name="" class="select_ssq">
      <option>陕西省</option>
     </select>
     <select name="" class="select_ssq">
     <option>西安市</option>
     </select>
     <select name="" class="select_ssq">
     <option>莲湖区</option>
     </select>
     </td>
    </tr>
    <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right">收件人姓名：</td>
     <td><input type="text" name="" required value="hs" class="input_name"></td>
    </tr>
    <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right">街道地址：</td>
     <td><input type="text" required size="50" value="金鸡路1号" class="input_addr"></td>
    </tr>
    <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right">邮政编码：</td>
     <td><input type="text" required size="10" pattern="[0-9]{6}" value="727444" class="input_zipcode"></td>
    </tr>
    <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right">手机号码：</td>
     <td><input type="text" name="" required pattern="[0-9]{11}" value="18309275673" class="input_tel"></td>
    </tr>
    <tr>
     <td align="right"  width="30%" class="Font14 FontW Lineheight35"></td>
     <td class="Lineheight35"><input name="" type="submit" value="确认修改" class="Submit"><input name="" type="submit" value="删除" class="Submit"></td>
    </tr>
   </table>
   </form>
   <!--add new address-->
   <form action="#">
    <table style="margin-top:10px;">
    <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right">选择所在地：</td>
     <td>
     <select name="" class="select_ssq">
      <option>陕西省</option>
     </select>
     <select name="" class="select_ssq">
     <option>西安市</option>
     </select>
     <select name="" class="select_ssq">
     <option>莲湖区</option>
     </select>
     </td>
    </tr>
    <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right">收件人姓名：</td>
     <td><input type="text" name="" required  class="input_name"></td>
    </tr>
    <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right">街道地址：</td>
     <td><input type="text" required  class="input_addr"></td>
    </tr>
    <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right">邮政编码：</td>
     <td><input type="text" required pattern="[0-9]{6}"  class="input_zipcode"></td>
    </tr>
    <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right">手机号码：</td>
     <td><input type="text" name="" required pattern="[0-9]{11}" class="input_tel"></td>
    </tr>
    <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right"></td>
     <td class="Font14 Font Lineheight35"><input name="" type="submit" value="新增收货地址"  class="Submit"></td>
    </tr>
   </table>
   </form>
  </section>
 </article>
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
     <li><a href="article_read.jsp" target="_blank" title="标题">支付方式</a></li>
     <li><a href="article_read.jsp" target="_blank" title="标题">配送方式</a></li>
     <li><a href="article_read.jsp" target="_blank" title="标题">配送效率</a></li>
     <li><a href="article_read.jsp" target="_blank" title="标题">服务费用</a></li>
    </ul>
    </div>
    <div>
    <span><i class="i2"></i>关于我们</span>
    <ul>
     <li><a href="article_read.jsp" target="_blank" title="标题">招贤纳士</a></li>
     <li><a href="article_read.jsp" target="_blank" title="标题">网站介绍</a></li>
     <li><a href="article_read.jsp" target="_blank" title="标题">配送效率</a></li>
     <li><a href="article_read.jsp" target="_blank" title="标题">商家加盟</a></li>
    </ul>
    </div>
    <div>
    <span><i class="i3"></i>帮助中心</span>
    <ul>
     <li><a href="article_read.jsp" target="_blank" title="标题">服务内容</a></li>
     <li><a href="article_read.jsp" target="_blank" title="标题">服务介绍</a></li>
     <li><a href="article_read.jsp" target="_blank" title="标题">常见问题</a></li>
     <li><a href="article_read.html" target="_blank" title="标题">网站地图</a></li>
    </ul>
    </div>
  </section>
 </section>
<div class="copyright">© 版权所有 2018 HS 技术支持：<a href="#" title="版权所有">HS</a></div>
</footer>
</body>
</html>
