
## JavaEE实验指导书
>------《商品信息管理系统》
#### 一、实验目的

该项目中将使用JSP技术构建B/S结构的商品信息管理系统，使用当前流行的开发工具MyEclipse开发环境，使用Tomcat或JBoss应用服务器和MySQL数据库进行系统开发，实现数据交互。学生独立完成数据库设计、编程直至该系统的成功运行，从而理解JavaEE的开发模式，提高编程能力和分析能力，为开发大中型电子商务网站打下坚实的基础。

#### 二、实验内容

1. 开发平台和工具
* 集成开发环境：MyEclipse10及以上版本
* 应用服务器：Tomcat6或以上版本、JBoss6或以上版本
* 数据库：MySQL5.0及以上版本
* 开发语言及版本：JavaEE 6.0或以上

2. 系统需求
完成一个仅由商品管理员登录的商品信息管理系统，该系统完成商品信息的添加、修改、删除和查询功能，具体需求如下：
1. 只允许在系统注册的商品管理员来添加、修改、删除和查询商品信息
2. 管理员必须先注册，才能登录。实现注册，注册时用户需要输入基本的个人信息。管理员个人信息内容包括昵称、姓名、密码（确认密码，即输入二次密码并进行校验）、性别、邮箱地址、手机等，注册信息的内容不限于此。
3. 登录时使用昵称和密码进行登录，密码必须与注册时设置的密码一致方能登录，否则显示信息错误，重回登录界面。
4. 登录后进入：商品信息管理系统主页面，该页面包含四个模块，分别是“添加商品”，“修改商品”，“删除商品”，“查询商品”：
5. 点击“添加商品”，进入“添加商品信息”页面，该页面应至少包含以下商品信息的内容：商品货号、商品名称、型号规格、商品数量、生产日期、保质期、生产厂家、供货商。这些信息由管理员填写后，通过点击“提交”按钮进入“商品信息确认”页面，该页面显示所录入的商品信息，经检查确认无误后点击“确定”按钮，页面跳转到成功添加商品信息页面。若信息有误，可选择“返回”重新填写。
6. 点击“修改商品”，进入“修改商品信息”页面，该页面通过选择商品货号或者商品名称来确定需要修改信息的商品，确定后转至信息修改的页面，该页面根据选择的商品货号和（或）名称列出该商品所有信息内容，修改部分或全部信息后点击“提交”进入确认页面，确认无误则跳转至修改成功页面，否则返回重新修改。
7. 点击“删除商品”，进入“删除商品信息”页面，该页面通过选择商品货号或者商品名称来确定需要删除信息的商品，确定后转至信息删除的页面，该页面根据选择的商品货号和（或）名称列出该商品所有信息内容，确定删除后则跳转至删除成功页面，否则返回至“删除商品信息”页面。
8. 点击“查询商品”，进入“查询商品信息”页面，该页面通过选择商品货号或者商品名称来确定需要某个商品的全部信息，或者通过选择“全部”列出该系统所有商品的全部信息。
3. 实验要求

1. 要求所有页面均采用JSP设计，页面风格与布局自行设计。
2. 自行进行数据库设计，至少创建二张表，分别用于存放管理员注册和登录信息的表和存放商品信息的表。
3. 所有确认添加、修改和删除成功的页面出现，均必须保证数据已经写入数据库或从数据库删除，查询结果必须是数据库的最终结果。
4. 项目代码必须按其功能建包分层，包名根据功能自行命名，必须实现DAO层和JavaBean层。