<p align="center">
  <a href="http://ant.design">
    <img width="200" src="https://spring.io/img/homepage/icon-spring-boot.svg">
  </a>
</p>

<h1 align="center">Spring Boot Aurora Seed</h1>

<div align="center">
:seedling:一个基于SpringBoot的RestfulApi项目的种子模板
<br />

[![LICENSE](https://img.shields.io/github/license/Huyunxiu/spring-boot-aurora-seed.svg)](/LICENSE)

</div>

## :package: 快速开始
1. `git clone git@github.com:Huyunxiu/spring-boot-aurora-seed.git --depth=1`
2. 将`resources`下的`init.sql`导入数据库
3. 运行`CodeGenerator.main()`方法并且输入对应参数，生成模板代码
    ```bash
    请输入请输入开发人员名称：
    huyunxiu01@gmail.com
    请输入表名，多个英文逗号分割：
    region
    请输入父包名，例如com.github.huyunxiu.seed：
    com.github.huyunxiu.seed
    请输入数据库URL，例如jdbc:mysql://localhost:3306/test：
    jdbc:mysql://localhost:3306/test
    请输入数据库用户名：
    root
    请输入数据库密码：
    password
    ```
4. 在`resources`下新建`application-dev.properties`文件并且写入数据库配置
5. 启动项目，打开`http://localhost:8080/swagger-ui.html`

## :hammer_and_wrench: 使用Docker进行部署
```bash
构建镜像
docker build -t aurora-seed
运行镜像，如果是测试环境SPRING_PROFILES_ACTIVE=test,如果是正式环境SPRING_PROFILES_ACTIVE=prod
docker run -d --name aurora-seed -e SPRING_PROFILES_ACTIVE=prod aurora-seed
```

## :sparkles: 特性

- 快速脚手架，从命令行创建Controller, Service, ServiceImpl, Entity, Mapper, MapperXML等模板，避免重复劳动
- 开箱即用，集成了结果封装，结果生成，分页参数，日志打印，异常处理等日常必备功能
- 集成了MybatisPlus，更方便快捷的实现实现单表业务零SQL
- 集成了SwaggerApi文档，从此开发接口两不误
- 集成了数据库迁移工具Liquibase，将数据库也纳入版本管理，不再混乱
- 集成了Logback日志系统，开箱即用

## :page_facing_up: 技术选型

- [Spring Boot](https://spring.io/projects/spring-boot):基础开发框架
- [Mybatis](http://www.mybatis.org/mybatis-3/zh/index.html)：数据库ORM框架
- [Mybatis Plus](https://mybatis.plus/)：Mybatis扩展，简化Mybatis的开发
- [Druid连接池](https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter/)：数据库连接池
- [Liquibase](http://www.liquibase.org/index.html)：企业级数据库迁移工具
- [Swagger](https://swagger.io/)：最好的API文档工具，基于OpenApi规范
- [Commons Lang3](https://commons.apache.org/proper/commons-lang/)：必备工具包之commons-lang3，可以看情况和guava混用
- [Guava](https://github.com/google/guava)：必备工具包之guava，可以看情况和commons-lang3混用

## :memo: 项目结构

```bash
.
├── LICENSE                         # 许可证
├── README.md                       # README文档
├── pom.xml                         # Maven依赖
└── src         
    ├── main
    │   ├── java
    │   │   └── com.github.huyunxiu.seed            # 项目源码目录
    │   │       ├── Application.java                # SpringBoot应用入口
    │   │       ├── aop                             # AOP文件夹
    │   │       ├── config                          # 配置文件夹
    │   │       ├── core                            # 核心功能文件夹
    │   │       ├── exception                       # 异常文件夹
    │   │       ├── model                           # DTO文件夹
    │   │       └── script                          # 脚本文件夹
    │   └── resources                               # 项目资源文件夹
    │       ├── application-dev.properties          # 项目开发环境配置文件（只在本地有，不会被提交到Git）
    │       ├── application-prod.properties         # 项目正式环境配置文件
    │       ├── application-test.properties         # 项目测试基本配置文件
    │       ├── application.properties              # 项目基本配置文件
    │       ├── mapper                              # Mybatis的XML-Mapper文件夹
    │       └── templates                           # 模板文件夹，目前用来放置代码生成模板
    └── test                        # 测试目录
```

## :copyright: LICENSE
许可证使用`MIT`，Copyright (c) 2019 重重重重重楼(AllenHu)。欢迎大家的Issue和PR！
