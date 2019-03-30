<p align="center">
  <a href="http://ant.design">
    <img width="200" src="https://spring.io/img/homepage/icon-spring-boot.svg">
  </a>
</p>

<h1 align="center">Spring Boot Aurora Seed</h1>

<div align="center">
:seedling:一个基于SpringBoot的RestfulApi项目的种子模板

[![LICENSE](https://img.shields.io/github/license/Huyunxiu/spring-boot-aurora-seed.svg)](/LICENSE)

</div>

## :sparkles:  特性

## :page_facing_up:  技术选型

- [Spring Boot](https://spring.io/projects/spring-boot):基础开发框架
- [Mybatis](http://www.mybatis.org/mybatis-3/zh/index.html)：数据库ORM框架
- [Mybatis Plus](https://mybatis.plus/)：Mybatis扩展，简化Mybatis的开发
- [Druid连接池](https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter/)：数据库连接池
- [Swagger](https://swagger.io/)：最好的API文档工具，基于OpenApi规范
- [Commons Lang3](https://commons.apache.org/proper/commons-lang/)：必备工具包之commons-lang3，可以看情况和guava混用
- [Guava](https://github.com/google/guava)：必备工具包之guava，可以看情况和commons-lang3混用

## :memo:  项目结构
```bash
.
├── LICENSE                         # 许可证
├── README.md                       # README文档
├── pom.xml                         # Maven依赖
├── src         
│   ├── main
│   │   ├── java
│   │   │   └── com.github.huyunxiu.seed            # 项目源码目录
│   │   │       ├── Application.java                # SpringBoot应用入口
│   │   │       ├── aop                             # AOP文件夹
│   │   │       ├── config                          # 配置文件夹
│   │   │       ├── core                            # 核心功能文件夹
│   │   │       ├── exception                       # 异常文件夹
│   │   │       ├── model                           # DTO文件夹
│   │   │       └── script                          # 脚本文件夹
│   │   └── resources                               # 项目资源文件夹
│   │       ├── application-dev.properties          # 项目开发环境配置文件（只在本地有，不会被提交到Git）
│   │       ├── application-prod.properties         # 项目正式环境配置文件
│   │       ├── application-test.properties         # 项目测试基本配置文件
│   │       ├── application.properties              # 项目基本配置文件
│   │       ├── mapper                              # Mybatis的XML-Mapper文件夹
│   │       └── templates                           # 模板文件夹，目前用来放置代码生成模板
│   └── test                        # 测试目录
```
