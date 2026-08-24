```
<?xml version="1.0" encoding="UTF-8" ?>

<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
<!--属性-->
    <properties resource="jdbcConfig.properties"/>
<!--    设置别名-->
    <typeAliases>
<!--        <typeAlias type="chiku.liu.entity.NetworkDevice" alias="Device"/>-->
<!--        也可以直接使用包，后面要用就直接用包下的类名就行了-->
        <package name="chiku.liu.entity"/>
    </typeAliases>

<!--运行环境-->
    <environments default="development">
<!--        定义一个叫development的环境，代表这是当前开发时使用的数据库配置-->
        <environment id="development">
<!--            表示MB使用JDBC来管理事务-->
            <transactionManager type="JDBC"/>
<!--            数据源，POOLED表示连接池-->
            <dataSource type="POOLED">
<!--                告诉MB使用MySQL JDBC驱动-->
                <property
                        name="driver"
                        value="${jdbc.drive}"/>
                <!-- 使用MySQL JDBC，MySQL在本机，默认端口3306，之前创建的数据库-->
                <property
                        name="url"
                        value="${jdbc.url}"/>

                <property
                        name="username"
                        value="${jdbc.username}"/>

                <property
                        name="password"
                        value="${jdbc.password}"/>
            </dataSource>
        </environment>
        <environment id="test">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property
                        name="driver"
                        value="${jdbc.drive}"/>
                <property
                        name="url"
                        value="${jdbc.url}"/>
                <property
                        name="username"
                        value="${jdbc.username}"/>
                <property
                        name="password"
                        value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>
<!--    映射器登录，告诉MB，我有一个写SQL的Mapper文件，启动的时候把他加载进来-->
    <mappers>
<!--        <mapper resource="mapper/NetworkDeviceMapper.xml"/>-->
    <package name="chiku.liu.mapper"/>
    </mappers>
    
</configuration>
```