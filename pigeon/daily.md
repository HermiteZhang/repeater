# 鸽子张的奇幻之旅-bolg系统的日记

## day 19-09-27

* demo编写与第一阶段总结
* 在编写demo时发现由Lombok插件引起的一个错误https://blog.csdn.net/as849167276/article/details/84260658----不是这个原因，，是因为没有写getter/setter方法



## day 19-09-26

* 24、25号进行了base基类的预研，目前来说没有办法下手，所以再保留base的基础上，依照原来的架构构建数据库、实体类和服务方法、再深入调研并总结运用，进行测试的类是element类，此类将会是所有用户/机构/部门的父类

* 类的初步设计

  * 所有元素以pd开头，组织架构以org开头

* 去除idea中xml黄色背景https://blog.csdn.net/u010318957/article/details/72459183

* mysql链接驱动最新版需要加时区配置  **serverTimezone=GMT**

* JavaBean的属性变量名前两个字母大小写问题
>Java属性命名规范！ 
一般情况下。Java的属性变量名都已小写字母开头，如：userName,showMessage等，但也存在着特殊情况，考虑到一些特定的有意思的英文缩略词如(USA,XML等),JavaBean也允许大写字母起头的属性变量名，不过必须满足**“变量的前两个字母要么全部大写，要么全部小写”**的要求,如:IDCode、ICCard、idCode等属性变量名是合法的，而iC、iCcard、iDCode等属性变量名是非法的。正是由于这个原因造成了下面这种情况： 

* 工具：typora-markdown编辑器、apidebug-postman的阿里版本
```markdown
  typora 常用快捷键
  - 加粗： `Ctrl/Cmd + B`
  - 标题： `Ctrl/Cmd + H`
  - 插入链接： `Ctrl/Cmd + K`
  - 插入代码： `Ctrl/Cmd + Shift + C`
  - 行内代码： `Ctrl/Cmd + Shift + K`
  - 插入图片： `Ctrl/Cmd + Shift + I`
  - 无序列表： `Ctrl/Cmd + Shift + L`
  - 撤销： `Ctrl/Cmd + Z`
  - 一级标题：快捷键为Crtl + 1，以此类推
```

> 总结 

## day 19-09-24

* 咕咕咕~

* 预研两个内容:

    * 实体类采用lombok，值得注意的是idea需要加入插件才可以用。不然在编码阶段会报错的。

    * 生成base基类覆盖简单的增删改查功能 url:https://blog.csdn.net/a286352250/article/details/53156676 ，这一步的预研完成后想整合xml+jpa的混合模式 ，https://blog.csdn.net/qq_25907831/article/details/86621112

* 知识点1、tk.mybatis.mapper-https://baijiahao.baidu.com/s?id=1634366904707283647&wfr=spider&for=pc

* 补充文件头注释，idea设置：file-setting-editor-file and code templates -includes -file header
```java
/**
* MIT License Copyright (c) 2019 HermiteZhang
* @Author HermiteZhang
* @Email zhangw9409@gmail.com
* @Date create in ${TIME} ${DATE}
* @Desc: 
*/
```

> 汇总知识点：lombok、tkMybatisMapper

##  day  19-09-04

* 搭建工程
* 确定初步技术路线  springboot+thymeleaf+mybatis+mysql
* pigeon 意为鸽子，是纪念一直在放鸽子的个人博客系统，这次重开项目，由小开始，没有架构没有灵活，先做起来，快速迭代就是这样
* 关于父项目 repeater -人类的本质是复读机，
* 第一版：使用spring boot + mysql 为基础，只有文章系统，文章名、文章内容以及创建时间 
