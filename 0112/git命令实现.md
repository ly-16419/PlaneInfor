# 从github克隆文件

> git clone [文件的http/SSH]

- SSH需要进行SSH认证后才能够实现

# 创建分支并传送到github中

![branch](./git分支创建.png)

> $ git clone [需要创建分支的仓库http/SSH]

> $ cd Order*

进入仓库

> git branch [分支名称]

创建分支

> git checkout [分支名称]

切换分支

- 当进入新建分支后，关闭git窗口，再次进入，依然是在新分支中

- 需要在新分支中做一些事情：新建文件

- 可在clone的仓库中新建一个文件：txt,文件夹等。此时所新建的文件虽然在肉眼上看是在clone的仓库中的主分支中建立的，但是其实是在新分支中建立的,提交到github时，在master中无法看见新建的文件

> $ git status

查看当前所在的分支中存在多少个分支

- 此时会提示有新文件没有上传到github中，会显示红色

> $ git add.

添加新文件

> $ git commit -m "注释信息"

> $ git push

将文件上传到github中

- 如果有提示提示，则按照提示的git语句进行提交

> 需要登陆github账户，登陆后根据提示再次输入用户名和密码

> 重新刷新github后就可以看到新分支

