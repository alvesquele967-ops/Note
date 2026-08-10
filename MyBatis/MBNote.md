## 在没有MB的时代，使用的是JDBC，大概流程如下
> **Java代码**->**JDBC**->**MySQL**->**返回结果**->**Java对象**
### 例如查询设备：
```SQL
SELECT * FROM device;
```
### JDBC需要自己写

```Java
import java.sql.PreparedStatement;

Connetion conn = DrierManager.getConnection(
        url,
        username,
        password
);

PreparedStatement ps =
    conn.prepareStatement(
            "SELECT * FROM device"
    );
ResultSet rs = ps.executeQuery();
```
### 然后再
```Java
While(rs.next()){
    String name = 
            rs.getString("device_name");
        }
```
十分之繁琐

# MyBatis是什么?
> 帮助管理Java对象和SQL之间的映射  
> **Java**->**MB**->**SQL**->**MySQL**
### 三个优点
* 简化JDBC
* SQL不会散落在Java代码里
* 自动对象映射

