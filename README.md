<div align="center">  

<img src="https://spring.io/img/homepage/icon-spring-boot.svg" width=""/> 
<br/>
<br>
<br>

![LICENSE](https://img.shields.io/github/license/Huyunxiu/spring-boot-aurora-seed.svg)

</div>
<br>

> `spring-boot-aurora-seed`：:seedling:一个基于SpringBoot的RestfulApi项目的种子模板

## 项目结构
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
