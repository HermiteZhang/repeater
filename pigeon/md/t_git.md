# Git Basic Operation
>2016年10月14日11:22:42 hermite-zhang hunan-yueyang

## 一些符号表述

<pre>
    .   当前目录      
    ..  上级目录    
    *   所有
</pre>

## Linux基本文件操作 

1. cd 跳转命令 
<pre>
    cd (or) cd ~    跳转到根目录
    cd home         跳转到home目录
    cd .            当前目录
    cd ..           上级目录
    cd ../..        上两级目录
    cd -            返回上次目录
</pre>
1. pwd 显示当前工作路径
1. ls 查看
<pre>
    ls              查看目录中的文件
    ls -f           查看目录中的文件（含隐藏）
    ls -l           查看文件和目录的详细资料
    ls -a           显示隐藏文件
    ls \*[0-9]\*    显示包含数字的文件名和目录名
</pre>
1. mkdir 创建目录
<pre>
    mkdir <目录名> <目录名>   可同时创建多个目录
    mkdir A/B/C               创建一个目录树
</pre>
1. echo 输出
<pre>
    echo "string"           标准输出
    echo "string"><文件名>  可以使用重定向符来输出到一个文件而不是标准输出
</pre>
1. cat
<pre>
cat <文件名>                           一次显示整个文件。
cat > <文件名>                         从键盘创建一个文件。只能创建新文件,不能编辑已有文件.
cat <文件名>  <文件名>  > <文件名>     将几个文件合并为一个文件：
参数：
-n 或 --number 由 1 开始对所有输出的行数编号
-b 或 --number-nonblank 和 -n 相似，只不过对于空白行不编号
-s 或 --squeeze-blank 当遇到有连续两行以上的空白行，就代换为一行的空白行
-v 或 --show-nonprinting
</pre>
1. touch
1. rm  删除
<pre>
    rm -f <文件名>                删除文件
    rm -rf <目录名> <目录名>      删除目录并同时删除其内容 
</pre>

1. rmdir <目录名>  删除目录
1. mv 移动重命名
<pre>
    mv <旧的文件或目录名> <新的文件或目录名>      mv可执行重命名和移动功能，可同时进行移动和重命名操作
    mv <目录名> <目录名>                          更改目录名
    mv <目录或文件名> <目录名+‘/’>                移动目标
    mv <文件名> <文件名>                          更改文件名
 </pre>

1. cp 复制
<pre>
    cp <文件或目录> <目标文件或目录>
    cp <文件名> <文件名>              复制一个文件 
    cp dir/* .                        复制某目录下的所有文件到当前目录 
    cp -a /tmp/dir1 .                 复制一个目录到当前工作目录 
    cp -a <目录名> <目录名>           复制一个目录
</pre>
1. date 显示当前日期
1. vim  进入vim界面
1. find 搜索文件
>
>文件搜索详细指令 <br>
>find / -name file1 从 '/' 开始进入根文件系统搜索文件和目录 <br>
>find / -user user1 搜索属于用户 'user1' 的文件和目录<br> 
>find /home/user1 -name \*.bin 在目录 '/ home/user1' 中搜索带有'.bin' 结尾的文件 <br>
>find /usr/bin -type f -atime +100 搜索在过去100天内未被使用过的执行文件 <br>
>find /usr/bin -type f -mtime -10 搜索在10天内被创建或者修改过的文件 <br>
>find / -name \*.rpm -exec chmod 755 '{}' \; 搜索以 '.rpm' 结尾的文件并定义其权限 <br>
>find / -xdev -name \*.rpm 搜索以 '.rpm' 结尾的文件，忽略光驱、捷盘等可移动设备 <br>
>locate \*.ps 寻找以 '.ps' 结尾的文件 - 先运行 'updatedb' 命令 <br>
>whereis halt 显示一个二进制文件、源码或man的位置 <br>
>which halt 显示一个二进制文件或可执行文件的完整路径 <br>

## Git的几个概念

1. 远程仓库        即保存我们代码的服务器，本文以公共版本控制系统：github为例，登录github账号后可直观显示；
1. 本地仓库        只能在git shell 窗口显示，连接本地代码跟远程代码的枢纽，不能联网时本地代码可先提交至该处；
1. 缓存区          只能通过git GUI或git shell 窗口显示，提交代码、解决冲突的中转站；
1. 工作区间        即我们创建的工程文件， 在编辑器可直观显示；

## Git的基本操作

1. $ git init       构建本地仓库
1. $ git add        工作区间文件添加到缓存区
1. $ git diff
1. $ git commit     提交，从将缓存区提交到本地仓库并保存信息，
<pre>
git commit --amend修改提交信息。
git commit -m "提交版本信息"      提交一行提交信息
git commit                        即可进入vim编辑长信息文本。
git commit -a/git commit --all    提交前自动暂存所有未暂存和未追踪的文件变化，包括从工作副本中删除的已追踪文件。
</pre>
1. $ git status     查看仓库状态
1. $ git log        查看日志，git log --graph 日志图
1. $ git reflog     查看简略日志信息
1. $ git diff       查看改动
1. $ git reset      版本回退 
1. $ git rm         从索引和工作目录中删除文件，git rm --cached仅删除索引。
1. $ git mv         移动，重命名文件

## 分支   

1. $ git branch "分支名"              创建分支
1. $ git branch/git show-branch       查看所有分支,当前分支用*标注
1. $ git checkout -"分支名"           切换分支，git checkout - 跳转到上一次切换的分支。
1. $ git merge --no-ff "分支名"       合并分支