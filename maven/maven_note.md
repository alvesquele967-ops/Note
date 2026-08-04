Maven 常用构建命令
Maven 命令以mvn开头，多个命令空格分隔，执行有固定生命周期顺序。
markdown
## Maven项目构建基础命令
- `mvn compile`      # 编译Java源代码，生成class文件
- `mvn clean`         # 清理，删除上次编译生成的target目录
- `mvn test`          # 执行单元测试(JUnit)
- `mvn package`       # 打包，生成jar/war压缩包
- `mvn install`       # 打包后安装至本地Maven仓库，可供本地其他项目依赖引用

## 二、常用参数
1. `-U`：强制刷新SNAPSHOT快照依赖
2. `-Dmaven.test.skip=true`：打包时跳过单元测试

## 三、依赖核心配置
### 1.scope依赖范围对照表
| scope | 主代码(main) | 测试代码(test) | 参与打包 | 常用范例 |
| ---- | ---- | ---- | ---- | ---- |
| compile(默认) | Y | Y | Y | log4j |
| test |  | Y |  | junit |
| provided | Y | Y |  | servlet-api |
| runtime |  |  | Y | jdbc |

### 传递控制
1. `<optional>true</optional>`：阻断该依赖向下传递
2. `<exclusions>`：主动排除不需要的传递依赖

## 四、打包格式
- jar：普通Java项目，默认格式
- war：Web项目，用于Tomcat部署

## 五、版本区分
1. SNAPSHOT快照版本：自带缓存，修改代码后需重新install、强制刷新才能同步
2. Release正式版本：无缓存，一次安装长期有效