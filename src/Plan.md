# 1.需求分析

> 题目：3、飞机订票管理系统
飞机订票可以方便航空公司管理和乘客订票。本系统实现机票的预定、机票的管理。
系统功能:
（1）信息录入：首先需录入航班信息,每个班次一个航班号.一次可录入1个或多个航班信息,航班信息需保存在文件中。

（2）信息显示。打印输出航班信息。

（3）查询航班信息。可按至少3种查询方式，如空座信息、起飞时间、起飞地、目的地等。

（4）订票预约。输入订票人信息，所订航班号，座位号。当订票成功后，航班信息表中座位信息要更新。

（5）退票。输入订票信息，对应航班信息表中的座位信息要更新。

## 1.1类和对象的抽取：

根据用户需求，分析得出：
- 客户

```java
    private String id;
    private String name;
    private String phone;
    private String cardid;//身份证号码
    private Date birthDate;//出生日期
    private String customer;//客户类型
```

- 航班信息

```java
    private String id;
    private String FilghtID;//航班编号
    private String planeType;//机型
    private String currentSeatsNum;//剩余座位号
    private String departureAirPort;//离开机场
    private String destinationAirPort;//目的机场
    private String departureTime;//离开时间
```

航班的ID（没有业务意义），使用Java的UUID生成32位的主键即可。

- 订单信息

```java
    private String id;//
    private String jpjg;//机票价格
    private String airPortTax;//机场税
    private String ryf;//燃油费
    private String hkzhx;//航空综合险
    private String jptgx;//机票退改险
    private String yhq;//优惠券
    private String hszj;//含税总价
```

# 2.创建数据库

- 创建数据库时，主键，及id一般使用没有业务意义的属性

> sqlplus / as sysdba

链接数据库

> create user opts identified by opts1234;

创建用户

> grant connect,resource to opts;

数据库授权用户

> exit

退出登录

> sqlplus opts/opts1234@orcl <[将本地数据库文件拖入命令框中]

添加、更新数据库

- 第一次更新可能会失败，可进行第二次更新


# 3.确立分层结构

- UI:用户界面层面
- BLL：服务层面

> 一般是对Dao层面的调用

- DAO:操作层面
- DB：数据库层面

> 层面与层面之间用接口实现链接

# 4.确立连接方式

- is a
- like a
- has a:关联关系

> 接口和实现类是has a 关联关系

# 5.根据连接方式来编写代码，按类编写

- 一个实体类对应一个数据库表
- 一个对象对应某个表的一条记录

# 6.idea链接数据库

```java
        String url = "jdbc:oracle:thin:@localhost:1521:orclhc";
        String username = "opts";
        String password = "opts1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "SELECT * FROM flight";
        PreparedStatement pstmt = conn.prepareStatement(sql);
```