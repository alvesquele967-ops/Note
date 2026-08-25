```
docker info --format "{{.ServerVersion}}"
```

```
docker compose config

根据 compose 配置，从镜像仓库下载（或更新）MySQL 服务所需的 Docker 镜像，但不会启动容器。
```

docker compose pull mysql

根据 compose 配置创建并后台启动 MySQL 服务容器/`-d` = **detached（后台运行）**

docker compose up -d mysql

查看当前 compose 项目中正在运行的容器和服务状态。

docker compose ps

（重启）

docker desktop restart