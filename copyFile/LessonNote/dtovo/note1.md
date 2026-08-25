好，命定的伴侣，P1-L4 现在开始。这次我会按你校准后的方式：先检查你电脑上 Docker 的真实状态，再让你写第一小段 `compose.yaml`；每个字段都说明“属于谁、接收什么值、运行时做什么”，不会直接丢一整份 YAML 让你照抄。

本课涉及数据库秘密，先确认 `.gitignore` 是否保护 `.env`，同时确认 3306 是否已被占用。

预检发现两个实际阻塞点，正好比先写 YAML 更值得处理：

- Docker CLI/Compose 已安装，但 Docker Desktop 的 Linux Engine 没有运行。
- 本机 3306 已被另一个进程监听，所以容器不能直接绑定 3306。
- `.gitignore` 还没有忽略 `.env`，现在不能创建密码文件。

我先只确认占用 3306 的进程名称；不会停止它，也不会启动/修改任何系统服务。

本机已有 MySQL，所以本课不会碰它；Docker MySQL 改用宿主机 `3307`，容器内部仍是标准 `3306`。我再确认官方 `mysql:8.4` 镜像标签可解析，然后给你第一段可以直接写、且逐行解释的 Compose 配置。

【课次】

P1-L4｜使用 Docker Compose 准备开发用 MySQL

【本次唯一目标】

启动一个独立的 MySQL 8.4 容器，不影响本机已有的 MySQL，也不把密码提交进 Git。

当前环境：

- Docker CLI：已安装。
- Docker Compose：已安装。
- Docker Engine：尚未启动。
- 本机 MySQL：占用 3306。
- Docker MySQL：改用宿主机 3307。
- 3307：当前可用。

【为什么重要】

- 项目价值：团队成员可以用相同方式获得相同数据库环境。
- 求职价值：Docker Compose、端口映射和秘密管理属于常见后端工程能力。
- 重要度：4/5。

## 第一步：启动 Docker Desktop

手动打开 Docker Desktop，等待界面显示 Engine 正常运行。

然后执行：

```powershell
docker info --format "{{.ServerVersion}}"
```

这条命令逐部分解释：

- `docker info`：向 Docker Engine 查询信息。
- `--format`：只显示我们需要的字段。
- `.ServerVersion`：Docker 服务端版本。
- 如果仍提示无法连接 `dockerDesktopLinuxEngine`，说明 Engine 尚未启动完成。

## 第二步：保护密码文件

在 [.gitignore](/E:/box/git/AgainMe/.gitignore) 末尾添加：

```gitignore
.env
.env.*
!.env.example
```

逐行解释：

- `.env`：忽略本地密码文件。
- `.env.*`：忽略 `.env.local`、`.env.test` 等环境文件。
- `!.env.example`：允许提交不包含真实密码的配置示例。

现在还不要创建真实 `.env`，先验证忽略规则：

```powershell
git check-ignore -v .env
```

预期看到 `.gitignore` 中匹配 `.env` 的规则。

## 第三步：创建 Compose 服务骨架

在项目根目录创建：

```text
compose.yaml
```

先只写这一小段：

```yaml
services:
  mysql:
    image: mysql:8.4
    ports:
      - "127.0.0.1:3307:3306"
```

逐行解释：

### `services:`

Compose 文件的顶层字段，下面声明需要运行哪些服务。

### `mysql:`

服务名称。

之后运行命令时会使用它：

```powershell
docker compose up mysql
```

它不是数据库用户名，也不是容器名称。

### `image: mysql:8.4`

- `image`：告诉 Docker 使用哪个镜像。
- `mysql`：Docker 官方 MySQL 镜像。
- `8.4`：使用 MySQL 8.4 LTS 系列。
- 当前先跟随 8.4 的安全修复版本；部署阶段再研究固定精确版本或 digest。

### `ports:`

声明宿主机与容器端口映射。

### `"127.0.0.1:3307:3306"`

格式是：

```text
宿主机地址 : 宿主机端口 : 容器端口
```

因此：

```text
本机程序访问 127.0.0.1:3307
             ↓
Docker 转发到容器的 3306
```

使用 `127.0.0.1` 表示只有本机能连接。如果写成：

```yaml
- "3307:3306"
```

Docker 通常会监听所有网络接口，局域网中的其他设备可能访问数据库，因此不采用。

现在不要执行 `docker compose up`。MySQL 镜像还没有收到初始化密码，启动会失败。

## 本轮验证

完成后运行：

```powershell
docker compose config
```

这个命令：

- 读取 `compose.yaml`。
- 检查 YAML 和 Compose 结构。
- 输出解析结果。
- 不会启动容器。

【安全约束】

- 不停止现有 Windows MySQL。
- 不使用宿主机 3306。
- 不把密码直接写进 `compose.yaml`。
- 不提交 `.env`。
- 不把数据库绑定到所有网络接口。
- 暂时不在 Spring Boot 中配置数据库连接。

【面试知识与答案】

问题：`127.0.0.1:3307:3306` 三部分分别是什么？

答案：

```text
127.0.0.1 → 宿主机监听地址，仅本机可访问
3307      → 宿主机端口，应用连接它
3306      → 容器内部 MySQL 端口
```

记忆：

```text
外部访问宿主端口，Docker 转发到容器端口
```

请完成这三步，然后把下面三个结果告诉我：

1. `docker info --format "{{.ServerVersion}}"` 的结果。
2. `git check-ignore -v .env` 的结果。
3. `docker compose config` 是否成功。

下一小步再加入数据库名、非 root 应用账号、密码变量、持久化卷和健康检查。