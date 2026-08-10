# Git GitHub 实操学习笔记
> 日期：2026-07-14
> 适用：Windows Git Bash（MINGW64）HTTPS / SSH 双模式、PAT令牌全套流程

## 目录
1. [了解与选择两种连接模式](#1-了解与选择两种连接模式)
2. [SSH公钥的创建与配置](#2-ssh公钥的创建与配置)
3. [初次从github克隆仓库](#3-初次从github克隆仓库)
4. [增删改操作与常用指令](#4-增删改操作与常用指令)
5. [Git提交用户名与邮箱配置](#5-git提交用户名与邮箱配置)
6. [常见报错与一键修复命令](#6-常见报错与一键修复命令)

---

# 1. 了解与选择两种连接模式
### 对比总表（后文先说SSH）
| 对比项 | HTTPS（当前在用） | SSH |
|--------|------------------|-----|
| 认证凭证 | 用户名 + PAT令牌 | 本地SSH密钥对，**完全不需要令牌** |
| 仓库地址 | `https://github.com/xxx.git` | `git@github.com:xxx.git` |
| 端口 | 443（全网通用，极少封禁） | 22（校园/家用宽带经常拦截） |
| 配置难度 | 开箱即用，仅需PAT | 初次需生成密钥、网页粘贴公钥 |
| 免密机制 | 系统缓存PAT | 本机密钥永久免密 |
>**注意，在github仓库里点击绿色的"<> Code按键"即可看到自己的克隆链接**

### 互相切换远程地址（可以先看完后面的章节再来看这里）
```bash
# SSH 切换 HTTPS
git remote set-url origin # 替换为自己的https克隆链接

# HTTPS 切换 SSH
git remote set-url origin # 替换为自己的SSH克隆链接
```
# 确认切换是否生效
```bash
git remote -v
```

### SSH常见报错：port 22 Connection refused
网络封禁22端口，两种解决办法：
1. 最简方案：切回HTTPS，使用PAT令牌推拉代码
2. 端口绕过方案（SSH走443）
```bash
# 测试443端口连通性
ssh -T -p 443 git@ssh.github.com
# 写入SSH配置强制走443端口
echo -e "Host github.com\n  Hostname ssh.github.com\n  Port 443\n  User git" > ~/.ssh/config
# 重新测试连接
ssh -T git@github.com
```

### SSH完整配置步骤（网络允许22端口时）
```bash
# 1. 生成密钥对
ssh-keygen -t ed25519 -C "你的绑定邮箱"
# 2. 读取并复制公钥
cat ~/.ssh/id_ed25519.pub
# 3. GitHub网页粘贴公钥：Settings → SSH and GPG keys
# 4. 测试连
ssh -T git@github.com
```
---

# 2. SSH公钥的创建与配置
### 于PowerShell或git bash中输入以下指令
```bash
ssh-keygen -t ed25519 -C "SSH Key" # 自定义名字
# 注：以下操作在未设置路径的情况下默认均在C盘用户文件夹里进行
```
### 经过三次回车确认之后如若显示如以下输出则成功：
```bash
Generating public/private ed25519 key pair.
Enter file in which to save the key (/home/git/.ssh/id_ed25519):
Enter passphrase (empty for no passphrase):
Enter same passphrase again:
Your identification has been saved in /home/git/.ssh/id_ed25519
Your public key has been saved in /home/git/.ssh/id_ed25519.pub
The key fingerprint is:
SHA256:ohDd0OK5WG2dx4gST/j35HjvlJlGHvihyY+Msl6IC8I Gitee SSH Key
The key's randomart image is:
+--[ED25519 256]--+
|    .o           |
|   .+oo          |
|  ...O.o +       |
|   .= * = +.     |
|  .o +..S*. +    |
|. ...o o..+* *   |
|.E. o . ..+.O    |
| . . ... o =.    |
|    ..oo. o.o    |
+----[SHA256]-----+
```
### 此后输入以下指令查看SSH公钥和私钥
```bash
ls ~/.ssh/
# 输出以下信息
id_ed25519  id_ed25519.pub
```
### 获取SSH公钥
```bash
cat ~/.ssh/id_ed25519.pub
# 输入如下则为本地SSH公钥，复制保存以便之后使用：
# ssh-ed25519 AAAA***5B Gitee SSH Key
```

### 之后按照以下步骤开始导入到github里：
>**点击github个人头像->点击Settings->进入SSH and GPG Keys选项卡->点击New SSH Key按钮->输入刚刚复制的公钥即可**

---

# 3. 初次从github克隆仓库
>**打开Git Bash，默认打开的路径是C/Users/用户名。有以下两种方式切换到路径**

首先需要确定一个工作路径，以我的项目举例，我的一个项目放在E:\box\git\rocomassistant\ROCOMAssistant
|直接在工作目录打开|使用命令打开|
| --------   | -----:  |
|在工作目录右键，选择Git Bash Here 选项|使用cd指令切换到工作目录，比如说我的就是cd /e/box/git/rocomassistant/ROCOMAssistant|

# 配套目录查看指令
```bash
pwd # 查看当前所在路径
ls  # 查看当前文件夹内文件
```

### 此后输入指令：
```bash
git clone # 替换为自己的SSH克隆链接（需要先配置好SSH公钥）
# 或
git clone # 替换为自己的HTTPS克隆链接
```
### 若输出如以下信息，则代表克隆成功，此时本地工作目录就会出现github对应仓库里的内容
```bash
l@Laffey MINGW64 /e/box/git/rocomassistant/ROCOMAssistant (main)
$ git clone # 这里替换为自己的克隆链接
Cloning into 'ROCOMAssistant'...
remote: Enumerating objects: 97, done.
remote: Counting objects: 100% (97/97), done.
remote: Compressing objects: 100% (91/91), done.
remote: Total 97 (delta 17), reused 14 (delta 5), pack-reused 0 (from 0)
Unpacking objects: 100% (97/97), done.
```

---

# 4. 增删改操作与常用指令
### 于Git Bash中：
```bash
# 1. 将变更加入暂存区
git add .
# 2. 生成本地快照，必须写清晰备注
git commit -m "操作说明，例如：新增测试文件"
# 3. 上传到远程GitHub仓库
git push origin main
```

### SSH和HTTPS两种方式的登录方式有所不同
HTTPS：推送会唤起凭据管理器，弹出GitHub网页授权界面登录账号，或手动填写用户名+PAT令牌，网页登录密码无法直接使用，授权一次后系统缓存免重复登录。
SSH：标准流程依靠本地公私钥自动鉴权，正常无需网页账号登录；若电脑残留旧HTTPS凭据缓存，切换SSH推送时可能异常弹出GitHub授权网页，清理缓存后即可恢复正常免登。生成密钥时如果设置了passphrase私钥解锁密码，只会弹出本地输入框，该密码仅解锁本机私钥，和GitHub账号无关。公钥上传GitHub属于一次性权限绑定操作。

**HTTPS详细PAT登录操作，具体见本章节最下方说明**

### 拉取远程代码
```bash
# 同步云端最新代码到本地
git pull origin main
```
运行指令后显示的输出以及相关含义
- `Already up to date.`：本地与远程完全同步，无更新
- `Fast-forward`：无冲突，直接同步远程变更

### 命令细节说明
1. `git add .`：提交**所有**变更（新增/修改/删除）到暂存
2. `git commit -m "xxx"`：仅生成本地记录，**不会自动上传GitHub**
3. `git push`：仅上传本地已经 `commit` 过的快照

---

## 文件删除与本地恢复操作
### 方式1：Git命令删除（同步云端）
```bash
# 删除本地文件 + 自动加入暂存
git rm "git测试.json"
git commit -m "删除测试文件"
git push origin main
```

### 方式2：鼠标手动删除（需手动add）
本地文件夹直接删掉文件后执行：
```bash
git add .
git commit -m "删除测试文件"
git push origin main
# 其原理是将所有本地文件的更新都保存到暂存区，此时push就会把删除了文件之后的版本上传
```

### 恢复远程已删除文件（仅本地找回，不上传）
```bash
# 从历史提交 f851ee0 单独恢复指定文件，不切换分支
git checkout f851ee0 -- "git测试.json"
```
- 仅本地文件夹复原文件，不会同步GitHub
- 想同步到云端，必须补 `add → commit → push`

### 关键逻辑：pull 会不会删掉本地文件？
1. 文件**已被Git追踪**，远程有删除记录：
   - 本地无恢复文件：`git pull` 会同步删除本地文件
   - 本地手动恢复出文件：产生冲突，不会自动删除本地文件
2. 文件从未执行 `git add`（未被Git追踪）：
   - 无论远程怎么变更，`pull` 永远不会动该文件

### 只想本地保留、不上传GitHub
取消Git追踪，不受pull/push影响：
```bash
git rm --cached "git测试.json"
```

### 登录说明 
**PAT ≠ GitHub网页登录密码**
   - 网页登录：用账号密码
   - Git Bash推拉代码（HTTPS）：只能用PAT令牌替代密码
2. 生成路径：头像 → Settings → Developer settings → Personal access tokens → Tokens(classic)
3. 必须勾选权限：`repo`（仓库读写权限）

### 状态标识说明
- `Never used`：从未在git push弹窗输入过该串令牌，未生效
- 黄色警告 `This token has no expiration date`：永久有效，存在安全风险，不用建议删除；创建令牌推荐设置有效期

### 缓存免密原理
Windows凭据管理器会自动保存第一次输入的有效PAT，后续push/pull**无需重复输入密码**
清除缓存失效令牌（弹窗认证失败时必用）：
```bash
cmdkey /delete:git:https://github.com
```

### 切换新令牌完整流程
1. 删除旧缓存 `cmdkey /delete:git:https://github.com`
2. `git push origin main` 触发登录弹窗
3. Username：GitHub用户名
4. Password：粘贴页面生成的完整PAT长字符串

---

# 5. Git提交用户名与邮箱配置
提交代码后GitHub页面展示的作者信息，仅由本地Git配置的 `user.name` 和 `user.email` 决定，和推送鉴权用的账号、PAT令牌、SSH密钥完全无关。只有配置的邮箱与GitHub账号已验证邮箱一致，提交记录才会归到自己账号，贡献面板才会正常统计。

配置分为全局与仓库局部两层，局部配置优先级高于全局，仅当前项目生效，全局配置为本机所有仓库统一共用。

查看当前配置信息
```bash
git config user.name
git config user.email
git config --list
```

全局统一设置（所有仓库通用）
```bash
git config --global user.name "自定义昵称"
git config --global user.email "GitHub绑定验证邮箱"
```

仅当前项目单独设置（进入项目目录执行）
```bash
git config user.name "项目专属昵称"
git config user.email "对应项目邮箱"
```

清除错误配置信息
```bash
# 清除全局配置
git config --global --unset user.name
git config --global --unset user.email
# 清除当前仓库局部配置
git config --unset user.name
git config --unset user.email
```

注意事项
user.name仅为页面展示昵称，可随意填写；user.email是匹配账号的核心，必须与GitHub绑定邮箱保持一致。修改配置仅对后续新提交生效，无法更改历史已存在的commit记录。代码推送登录身份与提交作者身份是两套独立体系，互不影响。

---

# 6. 常见报错与一键修复命令
### 报错1：Authentication failed 认证失败（HTTPS令牌失效）
全套修复命令，一次性复制执行
```bash
# 屏蔽SourceTree冲突弹窗工具
git config --global core.askpass ""
# 删除系统缓存失效令牌
cmdkey /delete:git:https://github.com
# 启用Windows官方凭据管理器自动缓存
git config --global credential.helper manager-core
# 重新推送登录
git push origin main
```

### 报错2：ssh: connect to host github.com port 22: Connection refused
网络封禁SSH22端口，直接切回HTTPS模式：
```bash
git remote set-url origin # 接自己的HTTPS克隆链接
```

写入SSH配置强制走443端口
```bash
echo -e "Host github.com\n  Hostname ssh.github.com\n  Port 443\n  User git" > ~/.ssh/config
# 测试连通是否正常
ssh -T git@github.com
```


### 报错3：error: unable to read askpass.exe
SourceTree弹窗工具冲突，执行：
```bash
git config --global core.askpass ""
```

### 无关警告：libpng warning: iCCP
图片色彩配置提示，**完全不影响代码推拉，直接忽略**

