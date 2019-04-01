package com.github.huyunxiu.seed.script;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.*;

/**
 * 代码生成器，可以生成Controller,Service,Mapper,Entity
 *
 * @author huyunxiu01@gmail.com
 * @since 2019-03-29
 */
public class CodeGenerator {

	private static String scanner(String tip) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入" + tip + "：");
		if (scanner.hasNext()) {
			String ipt = scanner.next();
			if (StringUtils.isNotEmpty(ipt)) {
				return ipt;
			}
		}
		throw new MybatisPlusException("请输入正确的" + tip + "！");
	}

	public static void main(String[] args) {
		String author = scanner("请输入开发人员名称");
		String[] tableList = scanner("表名，多个英文逗号分割").split(",");
		String parentPackage = scanner("父包名，例如com.github.huyunxiu.seed");
		String dbUrl = scanner("数据库URL，例如jdbc:mysql://localhost:3306/test");
		String dbUserName = scanner("数据库用户名");
		String dbPassword = scanner("数据库密码");

		String projectPath = System.getProperty("user.dir");

		// 代码生成器
		AutoGenerator generator = new AutoGenerator();

		// 全局配置
		GlobalConfig config = new GlobalConfig();
		// 生成文件的输出目录
		config.setOutputDir(projectPath + "/src/main/java");
		// 开发人员
		config.setAuthor(author);
		// 不打开输出目录
		config.setOpen(false);
		// 开启 swagger2 模式
		config.setSwagger2(true);
		// 在mapper中生成BaseResultMap
		config.setBaseColumnList(true);
		// 在mapper中生成BaseColumnList
		config.setBaseResultMap(true);
		generator.setGlobalConfig(config);

		// 数据源配置
		DataSourceConfig datasource = new DataSourceConfig();
		datasource.setUrl(dbUrl);
		datasource.setDriverName("com.mysql.cj.jdbc.Driver");
		datasource.setUsername(dbUserName);
		datasource.setPassword(dbPassword);
		generator.setDataSource(datasource);

		// 包配置
		PackageConfig packageConfig = new PackageConfig();
		packageConfig.setParent(parentPackage);
		generator.setPackageInfo(packageConfig);

		// 自定义配置
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<>(8);
				map.put("parentPackage", parentPackage);
				this.setMap(map);
			}
		};

		// 自定义输出文件
		List<FileOutConfig> fileOutConfigs = new ArrayList<>();
		fileOutConfigs.add(new FileOutConfig("/templates/mapper.xml.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
				return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
			}
		});

		cfg.setFileOutConfigList(fileOutConfigs);
		generator.setCfg(cfg);

		TemplateConfig templateConfig = new TemplateConfig();
		// 不mapper包中生成xml包
		templateConfig.setXml(null);
		// 指定Controller生成模板
		templateConfig.setController("templates/controller.java");
		generator.setTemplate(templateConfig);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		// 数据库表映射到实体的命名策略：使用驼峰
		strategy.setNaming(NamingStrategy.underline_to_camel);
		// 数据库表字段映射到实体的命名策略：使用驼峰
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		// 是否为lombok模型
		strategy.setEntityLombokModel(true);
		// 生成 @RestController 控制器
		strategy.setRestControllerStyle(true);
		// 需要包含的表名，允许正则表达式（与exclude二选一配置）
		strategy.setInclude(tableList);
		// RequestMapping的value驼峰转连字符
		strategy.setControllerMappingHyphenStyle(true);
		generator.setTemplateEngine(new FreemarkerTemplateEngine());
		generator.setStrategy(strategy);
		generator.execute();
	}
}
