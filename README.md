# 一.项目简介
本项目主要使用了JavaWeb技术，包括Jsp，Servlet，JDBC，适合刚学完JavaWeb的新手作为练习项目，巩固知识
项目GitHub地址：https://github.com/JavaStudenttwo/JEEShop
项目展示网址：http://47.106.99.83/JEEShop/jsp/index.jsp
# 二.项目涉及的技术
### 前端：
 - 使用了BootStrap框架，展示页面
 - JSP处理前端数据
 - Ajax异步访问
### 后端：
 - Servlet处理业务
 - JDBC连接数据库
# 三.项目主要功能
## 1.用户注册及用户登录
用户注册页面：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181226215800712.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)
### 用户注册部分实现的功能：
 1.用户名唯一性检测：输入用户名后，查询数据库，查看该用户名是否已经存在数据库中，如果存在，显示提示信息，该功能主要使用了Ajax异步校验技术
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181226220058834.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)
 2.验证码：输入验证码后检查验证码是否正确并给出提示信息，点击验证码图片更换验证码
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181226220459429.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181226220510753.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)
### 用户登录部分实现的功能：
 1.验证码：功能和注册部分相同
 2.登录检测：检查用户名和密码，并给出提示信息
 3.自动登录和记住用户名：使用Cookie和Session来实现
![在这里插入图片描述](https://img-blog.csdnimg.cn/2018122622085610.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)
4.登录成功后修改用户栏部分
 登录成功前：![在这里插入图片描述](https://img-blog.csdnimg.cn/20181226221827165.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)
 登录成功后：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181226221818394.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)

## 2.商品展示
1.特殊商品展示：根据商品信息，筛选出热门商品和最新商品展示在首页
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181226222306947.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181226222315591.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)
2.商品分类展示：根据商品分类信息，将商品分类名称展示到导航栏中，并可根据导航栏中的分类查找对应类别的商品，并对这些商品进行分页展示
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181226222532632.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)
## 3.购物车及订单生成
### 购物车部分实现的功能：
1.将商品加入购物车：任一点击一个商品，进入商品详情页面，可以将商品加入购物车，并设置加入购物车的商品数，点击加入购物车后立即跳转到购物车管理页面
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181226223719638.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)
2.购物车管理：显示已加入购物车中的商品的信息，及商品总额，提供将商品从购物车中删除的功能及清空购物车功能，并可以将购物车提交生成订单
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181226223801513.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)
### 订单生成：
生成订单，显示订单信息，并将订单信息提交至后台
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181226224152923.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)
后台订单管理部分
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181226224443720.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)
## 4.后台管理部分
1.后台管理员登录（较简陋）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181226224757948.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)
2.商品分类：可以添加，删除，修改类别
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181226224954907.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)
3.商品管理：上架下架商品，修改商品信息，分页展示商品信息
![在这里插入图片描述](https://img-blog.csdnimg.cn/2018122622512067.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)
4.订单管理：显示所有订单，并对订单分类
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181226225243215.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2VhZ2xldW5pdmVyc2l0eWV5ZQ==,size_16,color_FFFFFF,t_70)
