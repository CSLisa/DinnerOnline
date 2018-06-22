# DinnerOnline
基于SSM的订餐平台，只有订餐流程功能部分，不是整个工程代码。支付项目包含一些私人信息。。。需要可以相互学习。

1.只供学习用，页面使用的是通用模板；

2.数据库的链接方式是，通过mybatis配置文件：applicationContext_Mybatis.xml获取数据库配置信息文件：jdbc.properties。配置自己的信息就ok了。

3.数据库文件在：/D0301DinnerOnline/src/common/$doc/sql.txt。

4.系统首页直接访问：http://localhost:8080/D0301DinnerOnline/index.jsp

5.系统解析：

	抽取出基本的工具类，如分页、跳转、编码、基本的增删改查
	
	dao层和service层的findAll、findById、findByName、getRows、findByPaging、add等，都是通过泛型进行参数配置

	如果出现跳转失败的问题，可能是不存在，本身系统不全，再者就是页面路径的配置，在action层的实现类中。
	
	
	
Spring中配置Mybatis--用Spring向导或复制创建applicationContext05-$10Mybatis.xml
    
      <1>导入jdbc.properties
      
      <2>创建 dataSource
      
      <3>Mapper文件扫描
      
      <4>配置SqlSessionTemplate
      
      <5>DAO接口所在包名(exmvc.dao)，Spring会自动查找其下的类
      
      <6>(事务管理)transaction manager, use JtaTransactionManager for global tx
      
 配置generatorConfig.xml
          
            <1>数据库驱动,目录不能有汉字空格等
	    
            <2>数据库链接URL，用户名、密码
	    
            <3>生成Entity模型的包名和位置
	    
            <4>生成映射文件的包名和位置
	    
            <5>生成DAO接口的包名和位置
	    
            <6>要生成哪些表
	    
  

