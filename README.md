# JVMParam
使用jvm参数配置项目参数，以免改配置需要改项目里面的配置文件

配置文件在classpath:config/test.properties，启动jetty的时候我使用了jvm参数：-DCONFIG_PATH=classpath:config

```xml
<bean id="propertyPlaceholder" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
	<!-- 使用JVM参数覆盖配置文件的参数 -->
	<property name="systemPropertiesMode" value="2" />
	<property name="locations">
		<list>
			<value>${CONFIG_PATH}/test.properties</value>
		</list>
	</property>
</bean>
```
这样${CONFIG_PATH}实际上就为classpath:config

实际运行的java代码，通过value注解去读取配置文件
```java
public class TestService{
	
	@Value("${test.param}")
	private String teString;
	
	public String test(){
		System.out.println("this is test servcie");
//		Random random = new Random();
//		return "this is test service=" + random.nextFloat() * random.nextFloat();
		System.out.println(teString);
		return teString;
	}
	
}
```
如果在tomcat上部署的话，文件又放在tomcat服务器外面<br/>
如tomcat的路径为/home/mrc/soft/tomcat8<br/>
配置文件的路径为/home/mrc/soft/properties<br/>
则需要在tomcat的bin下的catalina.sh中配置，配置在文件开头<br/>
JAVA_OPTS="$JAVA_OPTS -DCONFIG_PATH=file:/home/mrc/soft/properties"<br/>
然后将配置文件放在上面配置的目录，再启动tomcat<br/>
这样的好处是，不用对应不同的部署方案再重新打包，只需要改tomcat外部的配置文件。

## 总结
本身项目在jetty中运行成功，但放在tomcat中测试就不可以，最后折腾了很久，发现是jar包冲突了，在pom中排除冲突的jar就可以了。

