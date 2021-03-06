# 	Spring Boot 学习

### 一. 环境搭建/创建项目

- 本次学习环境：
  1. jdk 1.8
  2. maven 3.3.9
  3. 编辑器 Intellij IDEA 
  4. Spring boot 1.5.9

1. 设置Maven

   给Maven的setting.xml配置文件的profiles标签添加：（请勿添加 打包package会报错）

   ```
   <profile>   
   	<id>jdk‐1.8</id>   
   	<activation>     
   		<activeByDefault>true</activeByDefault>     
   		<jdk>1.8</jdk>  
       </activation>   
       <properties>     
       <maven.compiler.source>1.8</maven.compiler.source>     <maven.compiler.target>1.8</maven.compiler.target>     <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>   
       </properties> 
   </profile>
   ```

2. IDEA中配置Maven

   ![TIM截图20191201123316](D:\GitHub\Java_study\Spring_boot\mdPicture\TIM截图20191201123316.png)

### 1. HelloWord Spring测试

- 功能：浏览器发送Hello请求，服务器接收请求并处理，响应HelloWorld字符串
- 项目名称：Springboot001

1. 创建一个Maven工程(jar工程) 步骤略

   记得勾选自动导入包

   ![TIM截图20191201145046](D:\GitHub\Java_study\Spring_boot\mdPicture\TIM截图20191201145046.png)

2. 导入Spring boot相关依赖（从官网获取）

   ```xml
   <parent>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-parent</artifactId>
           <version>1.5.9.RELEASE</version>
   </parent>

   <dependencies>
             <dependency>
                 <groupId>org.springframework.boot</groupId>
                 <artifactId>spring-boot-starter-web</artifactId>
             </dependency>
   </dependencies>
   ```


​		在pom.xml中添加上述代码，会**自动导入jar包**

3. 编写一个主程序；启动SpringBoot应用

   ```java
   /*
       @SpringBootApplication 来标注一个主程序类，说明这是一个springboot应用
    */
   @SpringBootApplication
   public class HelloWorldMainApplication {
   
       public static void main(String[] args) {
   
           //启动spring应用
           SpringApplication.run(HelloWorldMainApplication.class,args);
       }
   
   }
   ```

   在main-java包下的com.athhw包创建一个HelloWorldMainApplication.class作为主程序

4. 编写相关Controller

   ```java
   @Controller
   public class HelloController {
   
       @ResponseBody//  返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用
       @RequestMapping("/hello") //处理一个hello请求
       public String hello(){
           return "Hello World Spring"; //返回字符串
       }
   }
   ```

    在main-java包下的com.athhw-Controller包下创建一个Controller

5. 测试

   在HelloWorldMainApplication.class的main方法左侧控制台点击绿色播放键直接执行，不需要部署Tomcat，测试域名：http://localhost:8080/hello，不需要输入项目名。

6. 简化部署

   在pom.xml中导入插件，就可以直接打包成package，然后使用cmd窗口运行 jar -jar [jar包名]，作为服务器，测试域名同上。所以放入的服务器就无需装Tomcat。

   ```xml
   <!-- 这个插件，可以将应用打包成一个可执行的jar包；无需在服务器部署Tomcat应用-->
       <build>
           <plugins>
               <plugin>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-maven-plugin</artifactId>
               </plugin>
           </plugins>
       </build>
   ```

### 2.Hello World探究（各文件作用解析）

#####  1.POM文件

1. jar包的版本由谁来同一管理？

   ```xml
   <parent><!-- 父项目 -->
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-parent</artifactId><!-- 父项目路径 -->
           <version>1.5.9.RELEASE</version>
   </parent>

   父项目的父项目是：
   由它来真正管理各个版本的依赖。
   <parent>
   		<groupId>org.springframework.boot</groupId>
   		<artifactId>spring-boot-dependencies</artifactId><!-- 父项目路径 -->
   		<version>1.5.9.RELEASE</version>
   		<relativePath>../../spring-boot-dependencies</relativePath>
   </parent>
   ```

   Spring Boot的版本仲裁管理中心；

   以后我们导入依赖默认是不需要写版本；（没有在dependencies里面管理的依赖自然需要声明版本号

2. jar包由谁导进来的？

   ```xml
    <dependencies>
         <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-web</artifactId><!--web启动器-->
         </dependency>
     </dependencies>
   ```

   spring-boot-starter-web: Springboot场景启动器，帮我们导入了web模块运行所需要的各种组件

   根据业务的不同，导入不同的启动器（starter），这里是web模块，所以导入的是web启动器。只需要在项目中引入这些starter，相关的所有依赖包都会自动导入进来，并进行自动版控制。

   **在使用4.Spring Initializer快速创建Spring Boot项目时，根据提示勾选需要的模块，上面的代码会自动生成。**

#####  2.主程序

1. **@SpringBootApplication**

   ```java
   /*
       @SpringBootApplication 来标注一个主程序类，说明这是一个springboot应用
    */
   @SpringBootApplication
   public class HelloWorldMainApplication {

       public static void main(String[] args) {

           //启动spring应用
           SpringApplication.run(HelloWorldMainApplication.class,args);
       }

   }
   ```

   @**SpringBootApplication**:    Spring Boot应用标注在某个类上说明这个类是SpringBoot的主配置类，SpringBoot就应该运行这个类的main方法来启动SpringBoot应用；

2. SpringBootApplication注解是由多个注解组合而成

   在SpringBootApplication.class中

   ```java
   @SpringBootConfiguration //SpringBoot配置类；标注在某个类上，表面这是一个Springboot配置类
   @EnableAutoConfiguration //开启自动配置功能，以前我们需要配置的东西，SpringBoot帮我们自动配置
   ```

### 3.使用Spring Initializer快速创建Spring Boot项目(真正的项目创建从这) 

1. IDE都支持使用Spring的项目创建向导快速创建一个Spring Boot项目；
2. 选择我们需要的模块；向导会联网创建Spring Boot项目；
3. 默认生成的Spring Boot项目：

  - 主程序已经生成好了，我们只需要我们自己的逻辑，pom的启动器也已加载。
  - resources文件夹中目录结构：
    -  static：保存所有的静态资源； js css  images； 
    -  templates：保存所有的模板页面；（Spring Boot默认jar包使用嵌入式的Tomcat，默认不支持JSP页 面）；可以使用**模板引擎**（freemarker、thymeleaf）； 
    -  application.properties：Spring Boot应用的配置文件；可以修改一些默认设置；例如改变端口号： server.port=8081

### 二. SpringBoot的配置文件/配置

 - 包含：配置文件-加载顺序-配置原理
 - 项目名称：springboot003-config

 #####  1.配置文件

 1. SpringBoot使用一个全局的配置文件，配置文件名固定

    - application.properties （默认）或
    - application.yml（手动添加）

    配置文件的作用：修改SpringBoot自动配置的默认值；

    1. 什么是YML文件？

       yml文件使用YAML语言，是一种标记语言。  

       以前的配置文件；大多都使用的是**xxxx.xml**文件；

       YAML：以数据为中心，比json、xml等更适合做配置文件；

    2. YML配置示例

       ```yaml
       server:
         port: 8081
       ```

       对比：XML示例:

       ```xml
       <server>
       	<port>8081</port>
       </server>
       ```

 #####  2.YAML语法

1.  基本语法

      - k:(空格) v ：表示一对键值对 **（k:与v之间的空格必须有）**
      - 以空格的缩进来控制层级关系（类似python）

        ```yaml
        server:
           port: 8081
           path: /hello
        ```

2. 值的写法

   - 字面量：普通的值（数字，字符串，布尔）：

     k: v :字面量直接来写：字符串默认不用加上单引号或双引号；

     ”“：双引号；不会转义字符串里面的特殊字符；特殊字符会作为本身想表示的意思；

     ​	name: "zhangsan \n list"  输出：zhangsan 换行 list （会产生换行）

     ‘’：单引号；会转移特殊字符，特殊字符只是一个普通的字符串

     ​	name: "zhangsan \n list"  输出：zhangsan \n list （不会产生换行）

   - 对象（属性和值，键值对）：

     k: v :对象还是使用k: v方式；在下一行来写对象的属性和值的关系，注意缩进；

     ```yaml
     friends:
         lastName: zhangsan
         age: 20
     ```

     行内写法：

     ```yaml
     friends: {lastName: zhangsan,age: 20} #注意空格
     ```

   - 数组（List,Set）：

     用 - 值表示数组中的一个元素

     ```yaml
     pets:
      - car
      - dog
      - pig
     ```

     行内写法：

     ```yaml
     pets: [cat,dog,pig]
     ```

##### 3. 使用配置文件的值绑定到bean的属性中

1. 使用yml配置文件记录属性的值

   ```yaml
   person: #对象
     lastName: zhangsan
     age: 18
     boss: false
     birth: 2019/12/01
     maps: {k1: v1,k2: 12} #map
     lists: #list
       - lisi
       - zhaoliu
     dog:  #对象
       name: xiaogou
       age: 2
   ```

   或 使用properties配置文件记录属性的值

   ```properties
   #idea properties默认是UTF-8编码的 需要进行编码转换否则中文乱码
   #配置person的值
   person.last-name=张三
   person.age=18
   person.birth=2017/12/14
   person.boss=false
   person.maps.k1=v1
   person.maps.k2=v2
   person.lists=a,b,c
   person.dog.name=dog
   person.dog.age=15
   ```

2. javaBean

    使用注解：@Component @ConfigurationProperties(prefix = "person")

    ```java
    /*
      将配置文件中配置的每一个文件的值映射到这里
      1 @ConfigurationProperties :告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
      prefix = "person" :配置文件中哪个下面的所有属性进行一一映射
    
      2 需要使用注解@Component 将它加入容器中
      只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能
       */
    @Component
    @ConfigurationProperties(prefix = "person")
    public class Person {
    
      private String lastName;
      private Integer age;
      private Boolean boss;
      private Date birth;
    
      private Map<String,Object> maps;
      private List<Object> lists;
      private Dog dog; 
    /*
    下面Get/Set省略
    */
    ```

      或

      可以使用@Value注解 替代 @ConfigurationProperties(prefix = "person")

      @Value是逐个赋值的方式

    ```java
    /*
      将配置文件中配置的每一个文件的值映射到这里
    1 @ConfigurationProperties :告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
     prefix = "person" :配置文件中哪个下面的所有属性进行一一映射
    
    2 需要使用注解@Component 将它加入容器中
     只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能
    
    */
    @Component
    //@ConfigurationProperties(prefix = "person")
    public class Person {
      @Value("${person.last-name}")
      private String lastName;
      @Value("#{11*22}") //运算符
      private Integer age;
      @Value("true")
      private Boolean boss;
      private Date birth;
    
      private Map<String,Object> maps;
      private List<Object> lists;
      private Dog dog; 
    /*
    下面Get/Set省略
    */
    ```

      **@Value获取值和@ConfigurationProperties获取值比较**

    |                          | @ConfigurationProperties |   @Value   |
    | ------------------------ | :----------------------: | :--------: |
    | 功能                     |           支持           | 一个个指定 |
    | 松散绑定（松散语法）     |           支持           |   不支持   |
    | SpEL（EL的运算符等）     |          不支持          |    支持    |
    | JSR303数据校验           |           支持           |   不支持   |
    | 复杂类型封装（map,list） |           支持           |   不支持   |

    配置文件yml还是properties他们都能获取到值；
    如果说，我们只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用@Value； 

    如果说，我们专门编写了一个javaBean来和配置文件进行映射，我们就直接使@ConﬁgurationProperties；

3. 数据校验示例

   ```java
   /*
       将配置文件中配置的每一个文件的值映射到这里
       1 @ConfigurationProperties :告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
        prefix = "person" :配置文件中哪个下面的所有属性进行一一映射
   
       2 需要使用注解@Component 将它加入容器中
        只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能
   
       3 添加数据校验@Validated
         例如 在指定属性上方添加注解@Email表示lastName必须是邮箱
    */
   @Component
   @ConfigurationProperties(prefix = "person")
   @Validated
   public class Person {
   
       @Email
       private String lastName;
       private Integer age;
       private Boolean boss;
       private Date birth;
   
       private Map<String,Object> maps;
       private List<Object> lists;
       private Dog dog;
   ```

4. 导入配置文件处理器

   ```xml
   <!-- 导入配置文件处理器，配置文件绑定bean就会有提示，需要导入 -->
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-configuration-processor</artifactId>
       <optional>true</optional>
   </dependency>
   ```


##### 4. @PropertySource @ImportResource @Bean  手动添加bean

1. @PropertySource 加载指定目录的配置文件

   上面的@ConfigurationProperties 仅仅是从全局的配置文件中获取值

   用法：@PropertySource(value={"classpath:person.properties"})

2. @ImportResource  导入自己定义的spring的配置文件，让配置文件里面的内容生效

    Spring Boot里面没有Spring的配置文件，我们自己编写的配置文件，也不能自动识别；

    想让Spring的配置文件生效，加载进来：

   @ImportResource(location={"classpath:beans.xml"}) 标注在主程序的类名上

   **当然spring不建议使用配置文件编写添加bean的方式，而推荐使用全注解的方式：**

   1. 新增一个class文件作为配置类
   2. 配置类 **@Configuration** -->注明是spring配置文件
   3. 使用**@Bean** 给容器中添加bean

   ```java
   配置类
   /*
     @Configuration 指明当前类是一个配置类，就是用来代替之前spring的配置文件
         在配置文件中使用@Bean的方式来添加组件
    */
   @Configuration
   public class MyAppConfig {
   
     //将方法的返回值添加到容器中，容器中这个bean的id就是方法名
     @Bean
     public HelloService helloService(){
         return new HelloService();
     }
   }
   ```

   ```java
   测试用例 是一个单独的类 IDEA自动生成
   /*
   Spring boot 单元测试:
   可以在测试期间很方便的类似编码一样自动注入等容器的功能
   */
   
   @SpringBootTest
   class Springboot003ConfigApplicationTests {
   
   	@Autowired
   	Person person;
   
   	@Autowired
   	ApplicationContext ioc;
   
       @Test
   	public void testHelloService(){
           //检测容器中是否有id=helloService的bean
   		boolean b = ioc.containsBean("helloService"); 
   		System.out.println(b);
   	}
   	
   	@Test
   	void contextLoads() {
   		System.out.println(person);
   	}
   }
   ```

##### 5.配置文件占位符

  1. 配置文件中可以使用随机数

     ```properties
     ${random.value}、${random.int}、${random.long} ${random.int(10)}、${random.int[1024,65536]} 
     ```

 	2. 属性值占位符

     ```properties
     person.last-name=张三${random.uuid}
     person.age=${random.int}
     person.birth=2017/12/14
     person.boss=false
     person.maps.k1=v1
     person.maps.k2=v2
     person.lists=a,b,c
     person.dog.name=${person.last-name}dog #可以获取上面的值两个拼在一起
     #person.dog.name=${person.hello:hello}dog 
     #可以获取上面的值两个拼在一起，如果person.hello没有，那么使用字面，或者使用冒号后指定默认值
     person.dog.age=15
     ```

     - **要求属性文件中每个属性的值都必须要有，否则报错**
     - 可以使用占位符中写入随机数
     - 可以使用${}获得属性文件中其他的属性值，不分先后
     - **可以使用${}获取属性文件中不存在的属性，显示的是字面值，也可以使用冒号后指定默认值（见上）**


##### 6. Profile 多配置文件下的快速切换/定义

 1. 多Profile（配置）文件

    Profile是Spring对不同环境提供不同配置功能的支持

    我们在主配置文件编写的时候，文件名可以是 application-{proﬁle}.properties/yml
    **默认使用application.properties的配置**

    例如：针对不同环境，定义不同的配置文件 profile的内容自定义

    - application-dev.properties
    - application-prod.properties

 2. properties激活指定配置文件

    在主配置文件中输入：测试失败）		

    ```properties
    spring.profiles.active=dev  #激活指定配置文件dev 激活后此配置文件无效
    ```

3. yaml激活方式（文档块）无需创建多yml文件 （测试可用）

    - 方式1：文档内激活

      ```yaml
      server:
        port: 8085
      spring:    #指定激活文档块
        profiles:
          active: dev
      ---
      server:
        port: 8084
      spring:    #设定文档块环境名称
        profiles: dev
      ---
      server:
        port: 8086
      spring:		 #设定文档块环境名称
        profiles: prod
      ```

      ​	使用 --- 区分文档块

    - 方式2: 使用项目设置的方式激活

      Program arguments(项目设置中)中输入：

      ```xml
      --spring.profiles.active=dev
      ```

    - 方式3：使用cmd运行jar包的方式**传入参数**激活

      ```xml
      java -jar springboot003-config-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
      ```

    - 方式4：虚拟机参数

      VM option（项目设置中）输入：

      ```xml
      -Dspring.profiles.active=dev
      ```

##### 7.配置文件加载位置

 1. springboot 启动会扫描以下位置的application.properties或者application.yml文件作为Spring boot的默认配置文件，同路径下yml优先于properties

    - ﬁle:./conﬁg/  （项目根目录下/config/）config文件自己创建
    - ﬁle:./   （项目根目录下）
    - classpath:/conﬁg/   （项目src-main-resource-config下）
    - classpath:/  （项目src-main-resource，也是配置文件的默认路径）

    **按上面的顺序优先级由高到底，相同的配置高优先级的配置会覆盖低优先级的配置；所有配置文件都会被加载，若高优先级配置文件中没有配置但低优先级中有配置的内容，也会执行**

	2. **项目打包好以后，我们可以使用命令行参数的形式，启动项目的时候来指定配置文件的新位置；指定配置文件和默认加载的这些配置文件共同起作用形成互补配置；（运维时用）**

    cmd命令：在运行jar包时候补充在后面 指定配置文件的位置G:/application.properties

    java -jar spring-boot-02-conﬁg-02-0.0.1-SNAPSHOT.jar --spring.conﬁg.location=G:/application.properties

#####8.配置文件加载顺序

 1. SpringBoot也可以从以下位置加载配置文件，优先级从高到底，配置文件会形成互补配置

    1. 命令行参数
       所有的配置都可以在命令行上进行指定
       java -jar spring-boot-02-conﬁg-02-0.0.1-SNAPSHOT.jar --server.port=8087 --server.context-path=/abc 多个配置用空格分开；---> **--配置项=值  **

    2. 来自java:comp/env的JNDI属性 

    3. Java系统属性（System.getProperties()）

    4. 操作系统环境变量 

    5. RandomValuePropertySource配置的random.*属性值  

       **由jar包外向jar包内进行寻找； 优先加载带proﬁle:**

    6.  jar包外部的application-{proﬁle}.properties或application.yml(带spring.proﬁle)配置文件

    7. jar包内部的application-{proﬁle}.properties或application.yml(带spring.proﬁle)配置文件 

       **再来加载不带proﬁle :**

    8. jar包外部的application.properties或application.yml(不带spring.proﬁle)配置文件

    9. jar包内部的application.properties或application.yml(不带spring.proﬁle)配置文件

    10. @Conﬁguration注解类上的@PropertySource

    11. 通过SpringApplication.setDefaultProperties指定的默认属性
        所有支持的配置加载来源；

 ##### 9. 自动配置原理（精髓 难 暂时略

- 项目位置：springboot004-autoconfig
- 配置文件到底能写什么，怎么写？

1. 自动配置原理
   1. Springboot启动的时候加载主配置类，开启了自动配置功能@EnableAutoConfiguration
   2. @EnableAutoConfiguration作用
 2. 精髓：
   - SpringBoot启动会加载大量的自动配置类
   - 我们看我们需要的功能有没有SpringBoot默认写好的自动配置类；
   - 我们再来看这个自动配置类中到底配置了哪些组件；（只要我们要用的组件有，我们就不需要再来配置		了）
   - 给容器中自动配置类添加组件的时候，会从properties类中获取某些属性。我们就可以在配置文件中指定这些属性的值；
 3. xxxxAutoConﬁgurartion：自动配置类；
 4. 给容器中添加组件
 5. xxxxProperties:封装配置文件中相关属性； 对于这些相关属性就可以在配置文件中指定value

### 三.日志

#####    1. 日志框架

​	 市面上的日志框架：JUL、JCL、Jboss-logging、logback、log4j、log4j2、slf4j....

| 日志门面  （日志的抽象层）                                   | 日志实现                                             |
| ------------------------------------------------------------ | ---------------------------------------------------- |
| ~~JCL（Jakarta  Commons Logging）~~    SLF4j（Simple  Logging Facade for Java）    **~~jboss-logging~~** | Log4j  JUL（java.util.logging）  Log4j2  **Logback** |

左边选一个门面（抽象层）、右边来选一个实现；

日志门面：  SLF4J；

日志实现：Logback；

SpringBoot：底层是Spring框架，Spring框架默认是用JCL；‘

​	**SpringBoot选用 SLF4j和logback；**

##### 2.SLF4j使用

 1. 如何在系统中使用SLF4j？

    以后开发的时候，日志记录方法的调用，不应该来直接调用日志的实现类，而是**调用日志的抽象层**。

    **给系统里面导入SLF4j的jar和logback的实现jar**

    ```java
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    
    public class HelloWorld {
      public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloWorld.class);//LoggerFactory抽象层
        //getLogger(HelloWorld.class) 里面传入要记录哪个类的信息
        logger.info("Hello World");//存入信息
      }
    }
    ```

    图示：SLF4j抽象层的各种实现的方法

    <img src="mdPicture/concrete-bindings.png" alt="concrete-bindings" style="zoom:67%;" />

       每一个日志的实现框架都有自己的配置文件。使用slf4j以后，**配置文件还是做成日志实现框架自己本身的	配置文件；**

	2. 遗留问题

    开发系统时可能使用多个框架，spring，mybatis等，他们的默认日志框架都不相同，如何才能统一使用slf4j进行日志记录？

    1. 将系统中其他日志框架先排除出去
    2. 用中间包（jar包）来替换原有的日志框架（的jar包）
    3. 我们导入slf4j其他的实现

    <img src="mdpicture/legacy.png"  />

##### 3.Springboot日志关系

 1. spring-boot-starter的日志底层依赖关系

    ```xml
    <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-logging</artifactId>
          <version>2.2.2.RELEASE</version>
          <scope>compile</scope>
    </dependency>
    ```

    springboot使用它在做日志功能

    ![](mdpicture/搜狗截图20180131220946.png)

    - springboot底层也是使用slf4j+logback的方式进行日志记录
    - springboot也把其他的日志包都替换成了slf4j转换包（已经帮我们替换且包名没变动，自动）
    - <!--如果我们要引入其他框架，一定要把这个框架的默认日志依赖移除(我们需要手动做)-->

##### 4.日志使用

 1. 默认配置

    springboot已经默认帮我们配好了日志

    ```java
    @SpringBootTest
    class Springboot005Slf4jApplicationTests {
    	//日志记录器 必须是logger4j旗下的 注意选对
    	Logger logger = LoggerFactory.getLogger(getClass());
    	@Test
    	void contextLoads() {
    		//日志级别
    		//由低到高 trace<debug.....
    		//可以调整需要输出的日志级别 这个日志就只会在这个级别以后的高级别生效
    		logger.trace("这是trace日志 跟踪轨迹");
    		logger.debug("这是debug日志");
    		//springboot默认给我们使用得到是info级别的日志 所以默认输出info级别及以后的内容
    		//在配置文件调整基本
    		logger.info("这是info日志");
    		logger.warn("这是warn日志");
    		logger.error("这是error日志");
    	}
    }
    ```

2. 通过配置文件更改日志等级

    ```properties
    #设置这个包下的所有日志级别
    #注释不能写在命令后面否则报错
    #第一种方式
    logging.level.root=trace  
    ```

​		第二种方式

​		logging.level.com.athhw=trace   

​		官方文档https://www.baeldung.com/spring-boot-logging

 1. 修改日志默认配置

    ```properties
    日志输出格式：
    		%d表示日期时间，
    		%thread表示线程名，
    		%-5level：级别从左显示5个字符宽度
    		%logger{50} 表示logger名字最长50个字符，否则按照句点分割。 
    		%msg：日志消息，
    		%n是换行符
        -->
        %d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n
    ```

    ```properties
    #logging.file.name 当前项目下生成日志文件(可选路径 D:/springboot.log）
    logging.file.name=springboot.log
    #在项目路径下的盘根目录生成一个 使用spring.log作为默认文件，与logging.file.name属于冲突配置
    logging.file.path=/spring/log
    
    #控制输出格式
    logging.pattern.console=
    #指定文件中日志输出的格式
    logging.pattern.file=
    ```

 2. 指定自己的日志配置文件（高级功能暂时略过）

    给类路径（同SpringBoot配置文件路径）下放上每个日志框架自己的配置文件即可；SpringBoot就不使用他默认配置的了，详情可以查看SpringBoot官方文档

    | Logging System          | Customization （自定义配置文件要求的命名）                   |
    | ----------------------- | ------------------------------------------------------------ |
    | Logback                 | `logback-spring.xml`, `logback-spring.groovy`, `logback.xml` or `logback.groovy` |
    | Log4j2                  | `log4j2-spring.xml` or `log4j2.xml`                          |
    | JDK (Java Util Logging) | `logging.properties`                                         |

    logback.xml：直接就被日志框架识别了；

    **logback-spring.xml**：日志框架就不直接加载日志的配置项，由SpringBoot解析日志配置，可以使用SpringBoot的高级Profile功能

    ```xml
    <springProfile name="staging">
        <!-- configuration to be enabled when the "staging" profile is active -->
      	可以指定某段配置只在某个环境下生效，例如之前的dev等
    </springProfile>
    
    ```

    如：

    ```xml
    <appender name="stdout" class="ch.qos.logback.core.ConsoleAppender">
            <!--
            日志输出格式：
    			%d表示日期时间，
    			%thread表示线程名，
    			%-5level：级别从左显示5个字符宽度
    			%logger{50} 表示logger名字最长50个字符，否则按照句点分割。 
    			%msg：日志消息，
    			%n是换行符
            -->
            <layout class="ch.qos.logback.classic.PatternLayout">
                <springProfile name="dev">
                    <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} ----> [%thread] ---> %-5level %logger{50} - %msg%n</pattern>
                </springProfile>
                <springProfile name="!dev">
                    <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} ==== [%thread] ==== %-5level %logger{50} - %msg%n</pattern>
                </springProfile>
            </layout>
        </appender>
    ```

    如果使用logback.xml作为日志配置文件，还要使用profile功能，会有以下错误

     `no applicable action for [springProfile]`

##### 5.切换日志框架 略

### 四. WEB开发前期配置

 1. 使用springboot：

    - **创建springboot应用，选择需要的模块**
    - **springboot已经默认帮我们配置好了依赖包，只需要在配置文件中指定少量的配置**
    - **开始编写业务**

2. 自动配置原理？

  1. 这个场景SpringBoot帮我们配置了什么？能不能修改配置，或者扩展？

    xxxxAutoConfiguration ：帮我们给容器中自动配置组件的类，在里面查找能修改的配置属性。

#### 1.SpringBoot对静态资源的映射规则（html css 资源放在哪）

 1. webjars：静态资源打包成jar包，然后以jar包的方式导入 

    参考网站http://www.webjars.org/

 2. 静态资源保存路径

    ```
    "classpath:/META-INF/resources/", 
    "classpath:/resources/",
    "classpath:/static/", 
    "classpath:/public/" 
    "/"：当前项目的根路径
    如图 以图为准
    ```

    ![img](file:///C:\Users\hhw\AppData\Roaming\Tencent\Users\954165983\TIM\WinTemp\RichOle\%_X_$NDA7MU8SZ}~AW84BEW.png)

3. 在浏览器访问静态资源

    访问当前项目的任何路径，没有处理时，都默认去*静态资源文件夹*（上面三个都是静态资源文件夹）里查找。例如：

    查找static下的asserts->js->某个js文件：（不需要输入外部其余路径）

    ```
    http://localhost:8080/asserts/js/Chart.min.js
    ```

4. 设置欢迎页：静态资源（上面三个都是静态资源文件夹）文件夹下的所有index.html页面；被/**映射；访问路径为：

    ```
    http://localhost:8080/
    ```

    默认会找到index.html页面

5. 设置网页的图标

    所有的**/favicon.ico 都是在静态资源文件夹下找

    把要设置的图标命名为favicon.ico 放在静态资源文件夹下

6. 上面的路径也可以通过配置文件来更改存放的位置

#### 2.模板引擎

 1. JSP、Velocity、Freemarker、Thymeleaf

    因为不能直接使用jsp 所以要使用模板引擎作为中间处理

    ![](mdpicture/template-engine.png)

    SpringBoot推荐的Thymeleaf；

    **html页面需保存在templates文件夹下才可使用模板引擎**

    语法更简单，功能更强大；

2. 引入Thymeleaf

    在pom.xml中引入依赖包：

    ```xml
    <!--引入thymeleaf-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    ```

    版本自动适配，可手动更改	

    **只要我们把HTML页面放在classpath:/templates/，thymeleaf就能自动渲染；**

3. 使用Thymeleaf跳转到html网页

    先把success.html放在resources/templates下-->

    在controller下

    ```java
    //Thymeleaf测试
    @RequestMapping("/success")
    public String success(){
        //找到类路径下的
        // classpath:/templates/success.html
        return "success";//网页名
    ```

4. **使用Controller通过Thymeleaf向HTML传值**

    ```java
    //Thymeleaf 传值测试 Controller
        @RequestMapping("/success1")
        public String success1(Map<String,Object> map){
            map.put("hello2","你好");
            return "success1";//网页名
        }
    ```

    ```html
    <!DOCTYPE html>
    <!--要用thymeleaf 需要加头文件-->
    <html lang="en" xmlns:th="http://www.thymeleaf.org"> 
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>
        <h1>传值</h1>
        <!--th:text 将div里面的文本内容设置为 ${hello}是map的key-->
        <!--div中的文字 打开静态网页时才显示 适合前后端分工合作-->
        <div th:text="${hello2}">这是显示欢迎信息</div>
    </body>
    </html>
    ```

    html中，需要加入<html lang="en" xmlns:th="http://www.thymeleaf.org"> 头文件

#### 3.Thymeleaf语法

 1. th:text；改变当前元素里面的文本内容；

    **th：任意html属性；来替换原生属性的值**

    属性一览：

    ![](mdpicture/2018-02-04_123955.png)

2. 表达式？更多参考PDF开发文档

    ```properties
    Simple expressions:（表达式语法）
        Variable Expressions: ${...}：获取变量值；OGNL；
        		1）、获取对象的属性、调用方法
        		2）、使用内置的基本对象：例如：${#ctx}
                #ctx : the context object.
                #vars: the context variables.
                #locale : the context locale.
                #request : (only in Web Contexts) the HttpServletRequest object.
                #response : (only in Web Contexts) the HttpServletResponse object.
                #session : (only in Web Contexts) the HttpSession object.
                #servletContext : (only in Web Contexts) the ServletContext object.
                   
                    ${session.foo}
                3）、内置的一些工具对象：
    #execInfo : information about the template being processed.
    #messages : methods for obtaining externalized messages inside variables expressions, in the same way as they would be obtained using #{…} syntax.
    #uris : methods for escaping parts of URLs/URIs
    #conversions : methods for executing the configured conversion service (if any).
    #dates : methods for java.util.Date objects: formatting, component extraction, etc.
    #calendars : analogous to #dates , but for java.util.Calendar objects.
    #numbers : methods for formatting numeric objects.
    #strings : methods for String objects: contains, startsWith, prepending/appending, etc.
    #objects : methods for objects in general.
    #bools : methods for boolean evaluation.
    #arrays : methods for arrays.
    #lists : methods for lists.
    #sets : methods for sets.
    #maps : methods for maps.
    #aggregates : methods for creating aggregates on arrays or collections.
    #ids : methods for dealing with id attributes that might be repeated (for example, as a result of an iteration).
    
        Selection Variable Expressions: *{...}：选择表达式：和${}在功能上是一样；
        	补充：配合 th:object="${session.user}：
       <div th:object="${session.user}">
        <p>Name: <span th:text="*{firstName}">Sebastian</span>.</p>
        <p>Surname: <span th:text="*{lastName}">Pepper</span>.</p>
        <p>Nationality: <span th:text="*{nationality}">Saturn</span>.</p>
        </div>
        
        Message Expressions: #{...}：获取国际化内容
        Link URL Expressions: @{...}：定义URL；
        		@{/order/process(execId=${execId},execType='FAST')}
        Fragment Expressions: ~{...}：片段引用表达式
        		<div th:insert="~{commons :: main}">...</div>
        		
    Literals（字面量）
          Text literals: 'one text' , 'Another one!' ,…
          Number literals: 0 , 34 , 3.0 , 12.3 ,…
          Boolean literals: true , false
          Null literal: null
          Literal tokens: one , sometext , main ,…
    Text operations:（文本操作）
        String concatenation: +
        Literal substitutions: |The name is ${name}|
    Arithmetic operations:（数学运算）
        Binary operators: + , - , * , / , %
        Minus sign (unary operator): -
    Boolean operations:（布尔运算）
        Binary operators: and , or
        Boolean negation (unary operator): ! , not
    Comparisons and equality:（比较运算）
        Comparators: > , < , >= , <= ( gt , lt , ge , le )
        Equality operators: == , != ( eq , ne )
    Conditional operators:条件运算（三元运算符）
        If-then: (if) ? (then)
        If-then-else: (if) ? (then) : (else)
        Default: (value) ?: (defaultvalue)
    Special tokens:
        No-Operation: _ 
    ```

3. 遍历Map/List

    举例：

    Controller

    ```java
    //Thymeleaf 传值测试
        @RequestMapping("/success1")
        public String success1(Map<String,Object> map){
            map.put("hello2","你好");
            map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
            return "success1";//网页名
        }
    ```

    Html

    ```html
    <!--输出遍历集合数据-->
    <!--th:each 每次遍历都会生成这个标签 这里是3个h4-->
    <h4 th:text="${user}" th:each="user:${users}"></h4>
    
    <!--3个span-->
    <h4>
        <!--同样是遍历写法-->
        <span th:each="user:${users}"> [[${user}]]</span>
    </h4>
    ```

#### 4.SpringMVC自动配置

 1. Springboot自动配置了SpringMVC

 2. 以下是SpringBoot对SpringMVC的默认配置:**==（自动配置在WebMvcAutoConfiguration这个类）==**

    - Inclusion of `ContentNegotiatingViewResolver` and `BeanNameViewResolver` beans.

      - 自动配置了ViewResolver（视图解析器：根据方法的返回值得到视图对象（View），视图对象决定如何渲染（转发？重定向？））
      - ContentNegotiatingViewResolver：组合所有的视图解析器的；
      - ==如何定制：我们可以自己给容器中添加一个视图解析器；自动的将其组合进来；==

    - Support for serving static resources, including support for WebJars (see below).静态资源文件夹路径,webjars

    - Static `index.html` support. 静态首页访问

    - Custom `Favicon` support (see below).  favicon.ico

      

    - 自动注册了 of `Converter`, `GenericConverter`, `Formatter` beans.

      - Converter：转换器；  public String hello(User user)：类型转换使用Converter
      - `Formatter`  格式化器；  2017.12.17===Date；

    ```java
    		@Bean
    		@ConditionalOnProperty(prefix = "spring.mvc", name = "date-format")//在文件中配置日期格式化的规则
    		public Formatter<Date> dateFormatter() {
    			return new DateFormatter(this.mvcProperties.getDateFormat());//日期格式化组件
    		}
    ```

    ​	==自己添加的格式化器转换器，我们只需要放在容器中即可==

    - Support for `HttpMessageConverters` (see below).

      - HttpMessageConverter：SpringMVC用来转换Http请求和响应的；User---Json；

      - `HttpMessageConverters` 是从容器中确定；获取所有的HttpMessageConverter；

        ==自己给容器中添加HttpMessageConverter，只需要将自己的组件注册容器中（@Bean,@Component）==

        

    - Automatic registration of `MessageCodesResolver` (see below).定义错误代码生成规则

    - Automatic use of a `ConfigurableWebBindingInitializer` bean (see below).

      ==我们可以配置一个ConfigurableWebBindingInitializer来替换默认的；（添加到容器）==

      ```
      初始化WebDataBinder；
      请求数据=====JavaBean；
      ```

    **org.springframework.boot.autoconfigure.web：web的所有自动场景；**

    If you want to keep Spring Boot MVC features, and you just want to add additional [MVC configuration](https://docs.spring.io/spring/docs/4.3.14.RELEASE/spring-framework-reference/htmlsingle#mvc) (interceptors, formatters, view controllers etc.) you can add your own `@Configuration` class of type `WebMvcConfigurerAdapter`, but **without** `@EnableWebMvc`. If you wish to provide custom instances of `RequestMappingHandlerMapping`, `RequestMappingHandlerAdapter` or `ExceptionHandlerExceptionResolver` you can declare a `WebMvcRegistrationsAdapter` instance providing such components.

    If you want to take complete control of Spring MVC, you can add your own `@Configuration` annotated with `@EnableWebMvc`.

#### 5.SpringMVC扩展

 1. **编写一个配置类** 使用`@Configuration` 注解，继承`WebMvcConfigurationSupport`不能标注`@EnableWebMvc` #`WebMvcConfigurationSupport`已经淘汰，改用实现WebMvcConfigurer

 2. 例如扩展URL映射

    在纯SpringMVC中 扩展：

    ```xml
    <mvc:view-controller path="/atguigu" view-name="success"/>
    <mvc:interceptors>
        <mvc:interceptor>
            <mvc:mapping path="/atguigu"/>
            <bean></bean>
        </mvc:interceptor>
    </mvc:interceptors>
    ```

    在springboot中扩展：

    使用WebMvcConfigurationSupport类来扩展springmvc功能，查看其中的方法由此得出可扩展的功能。**需要什么功能，在配置类中重写该方法即可**

    ```java
    //使用WebMvcConfigurationSupport来扩展springmvc功能
    @Configuration //步骤1 使用@Configuration注解 2 继承WebMvcConfigurationSupport
    public class MyMvcConfig implements WebMvcConfigurer {
        public void addViewControllers(ViewControllerRegistry registry) {
    
            //将默认主页定向到模板引擎解析的templates下的login.html
            registry.addViewController("/").setViewName("success");
    
        }
    }
    
    ```

#### 6.取消自动配置

	1. 在我们自己的springMVC配置类中（5中的配置类）添加`@EnableWebMvc`注解即可。此时SpringMVC的所有自动配置都失效了

#### 7.如何修改SpringBoot默认配置

	1. SpringBoot在自动配置很多组件的时候，先看容器中有没有用户自己配置的（@Bean、@Component）如果有就用用户配置的，如果没有，才自动配置；如果有些组件可以有多个（ViewResolver）将用户配置的和自己默认的组合起来
 	2. 在SpringBoot中会有非常多的xxxConfigurer帮助我们进行扩展配置
 	3. 在SpringBoot中会有很多的xxxCustomizer帮助我们进行定制配置

### 五.WEB开发

1. 导入开发所需资源包 （dao,实体类导入到工程目录下，html导入到templates下）
2. 项目名称：Springboot006-web

#### 1.访问首页index

 1. 设定输入端口号或者index跳转到模板引擎解析下的templates/login,index

    在config文件下设定

    ```java
    //使用WebMvcConfigurationSupport来扩展springmvc功能
    @Configuration //步骤1 使用@Configuration注解 2 继承WebMvcConfigurationSupport
    public class MyMvcConfig implements WebMvcConfigurer {
        public void addViewControllers(ViewControllerRegistry registry) {
    
            //将默认主页定向到模板引擎解析的templates下的login.html
            registry.addViewController("/").setViewName("login");
    
        }
    }
    ```

#### 2.国际化（多语言环境）

 1. 编写国际化配置文件（根据不同语言显示）

 2. 使用配置文件：resouces目录下新建一个文件夹，在文件夹下新建配置文件：

    ![](mdpicture/搜狗截图20180211130721.png)

    文件夹命名随意，配置文件命名 一般为页面名_ 规范（语言_国家代码）

3. springboot自动配置好了管理国际化文件的组件

    只需在springboot配置文件中添加自己的国际化文件

    ```properties
    spring.messages.basename=i18n.login
    ```

4. 去页面获取国际化的值

    使用thymeleaf的 #{...}获取国际化的值 （查询手册）

    使用th:text重写每个组件的值 例如 th:text="#{login.tip} 直接获取国际化组件的值

    ```html
    <body class="text-center">
    		<form class="form-signin" action="dashboard.html">
    			<img class="mb-4" src="asserts/img/bootstrap-solid.svg" alt="" width="72" height="72">
    			<h1 class="h3 mb-3 font-weight-normal" th:text="#{login.tip}">Please sign in</h1>
    			<label class="sr-only">Username</label>
    			<input type="text" class="form-control" placeholder="Username" th:placeholder="#{login.username}" required="" autofocus="">
    			<label class="sr-only">Password</label>
    			<input type="password" class="form-control" placeholder="Password" th:placeholder="#{login.passwd}" required="">
    			<div class="checkbox mb-3">
    				<label>
                <!-- input写法要使用行内写法[[...]] 里面写表达式 -->   
              <input type="checkbox" value="remember-me" />[[#{login.remember}]]
            </label>
    			</div>
    			<button class="btn btn-lg btn-primary btn-block" type="submit" th:text="#{login.btn}"></button>
    			<p class="mt-5 mb-3 text-muted">© 2017-2018</p>
    			<a class="btn btn-sm">中文</a>
    			<a class="btn btn-sm">English</a>
    		</form>
    
    	</body>
       
    ```

    效果:根据浏览器语言可以自动切换国际化值

    PS： 遇到乱码情况，使用default setting设置语言为UTF-8 并重新输入配置文件信息

 5. 点击按钮切换国际化

     1. 设置切换区域的href

        ```html
        <!--thymeleaf 写法-->
        <a class="btn btn-sm" th:href="@{/index.html(l='zh_CN')}">中文</a>
        <a class="btn btn-sm" th:href="@{/index.html(l='en_US')}">English</a>
        ```

     2. 编写区域信息解析器

        ```java
        //区域信息解析器 接口LocaleResolver 根据url切换地区
        public class MylocaleResolver implements LocaleResolver {
        
        //解析区域信息
        @Override
        public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l= httpServletRequest.getParameter("l"); //解析url中的参数带的值
        Locale locale = Locale.getDefault(); //设定默认值
        if(!StringUtils.isEmpty(l)){ //检测l是否为空
            String[] split=l.split("_"); //以下划线切割l
            locale = new Locale(split[0],split[1]);
        }
        return locale;
            }
        
        @Override
        public void setLocale(HttpServletRequest httpServletRequest, @Nullable HttpServletResponse httpServletResponse, @Nullable Locale locale) {
            }
        }
        ```

     3. 在Config中将手动编写的区域信息解析器注入bean

        ```java
        //使用自定义区域解析器
        @Bean
        public LocaleResolver localeResolver(){
            return new MylocaleResolver();
        }
        ```

#### 3.登陆

 1. 编写Controller （LoginController）

    ```java
    //处理登陆请求
    @Controller
    public class LoginController {
    
        @PostMapping(value="/login")//集成post请求
        //@RequestMapping(value="user/login",method= RequestMethod.POST)
        //@RequestParam(参数) 指定从请求参数(html传来的)获取，若html没有提交，则会报错
        public String login(@RequestParam("username")String username,
                            @RequestParam("password")String passwd){
            if(!StringUtils.isEmpty(username) && "123456".equals(passwd)){
                //登陆成功
                return "dashboard";
            }else{
                return "login";
            }
        }
    }
    ```

    判断登陆条件：用户名不为空，密码=123456

 2. 编写Html 重新提交表单路径

    ```html
    <!--th:action="@{/user/login}" 表单提交地址 method="post"-->
    		<form class="form-signin" action="dashboard.html" th:action="@{/login}" method="post">
    ```

	3. 开发期间，禁用模板引擎缓存，才能让Html页面修改实时生效

    properties:

    ```properties
    #禁用模板引擎缓存 html修改后ctrl+F9 否则修改的html页面不会实时生效
    spring.thymeleaf.cache=false
    ```

	4. 登陆false后登陆页显示错误消息

    改写Controller：使用map记录错误信息

    ```java
    //处理登陆请求
    @Controller
    public class LoginController {
    
        @PostMapping(value="/login")//集成post请求
        //@RequestMapping(value="user/login",method= RequestMethod.POST)
        //@RequestParam(参数) 指定从请求参数(html传来的)获取，若html没有提交，则会报错
        public String login(@RequestParam("username")String username,
                            @RequestParam("password")String passwd, Map<String,Object> map){
            if(!StringUtils.isEmpty(username) && "123456".equals(passwd)){
                //登陆成功
                return "dashboard";
            }else{
                map.put("msg","用户名密码错误"); //使用map或mpdelandview 但这里要求返回String 所以只能用map
                return "login";
            }
        }
    
    ```

    在Html写入从Controller获取的信息：使用thymeleaf语句

    ```html
    <!--登陆错误消息提示 满足th:if条件检查字符串是否为空后才显示该p标签-->
    <p style="color: red;" th:text="${msg}" th:if="${not #strings.isEmpty(msg)}"></p>
    ```

#### 4.使用拦截器进行登陆检查

 1. 在controller中加入登陆成功后添加session

    ```java
    @Controller
    public class LoginController {
    
        @PostMapping(value="/login")//集成post请求
        //@RequestMapping(value="user/login",method= RequestMethod.POST)
        //@RequestParam(参数) 指定从请求参数(html传来的)获取，若html没有提交，则会报错
        public String login(@RequestParam("username")String username,
                            @RequestParam("password")String passwd,
                            Map<String,Object> map,
                            HttpSession session
                            ){
            if(!StringUtils.isEmpty(username) && "123456".equals(passwd)){
                //登陆成功
                session.setAttribute("loginsuccess",username); //添加session
                return "redirect:/main.html"; //配合拦截器
            }else{
                map.put("msg","用户名密码错误"); //使用map或mpdelandview 但这里要求返回String 所以只能用map
                return "login";
            }
        }
    
    ```

 2. 自定义一个拦截器类

    ```java
    //登陆拦截器 实现HandlerInterceptor接口
    /*
        检查登陆状态 利用controller传来的session
        登陆好的用户放在session中
     */
    public class loginInterceptor implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            Object user = request.getSession().getAttribute("loginsuccess");
            if (user == null) {
                //未登录 返回登陆页面并提示信息
                request.setAttribute("msg","没有权限请登陆");
                //跳转回登陆页面
                request.getRequestDispatcher("/index.html").forward(request,response);
                return false;
            } else {
                //已登录 请求放行
                return true;
            }
        }
    }
    ```

	3. 在Configuration中添加自定义的拦截器类

    ```java
    //扩展自定义拦截器
        public void addInterceptors(InterceptorRegistry registry) {
            List<String> noturls = new ArrayList<>(); //不拦截的页面和请求
            noturls.add("/index.html");
            noturls.add("/");
            noturls.add("/login");
            noturls.add("/asserts/**"); //静态资源不能拦截
            registry.addInterceptor(new loginInterceptor()).addPathPatterns("/**") //-》 /**拦截所有请求
                        .excludePathPatterns(noturls);
        }
    ```

    使用` .excludePathPatterns(noturls);`方法排除掉登陆页面的拦截

	4. 在mian html页面获取session 显示登陆用户的用户名

    使用thymeleaf表达式行内写法获取session中的值

    ```html
    [[${session.loginsuccess}]]
    ```

####5.Restful风格简介

 1. 员工的增删查改使用restful风格进行开发

 2. 两种风格比较

    crud：增删查改

    |      | 普通CRUD（uri来区分操作） | RestfulCRUD       |
    | ---- | ------------------------- | ----------------- |
    | 查询 | getEmp                    | emp---GET         |
    | 添加 | addEmp?xxx                | emp---POST        |
    | 修改 | updateEmp?id=xxx&xxx=xx   | emp/{id}---PUT    |
    | 删除 | deleteEmp?id=1            | emp/{id}---DELETE |

3. 本web开发的请求样例

    举例：以id=1 的员工为例

    | 实验功能                             | 请求URI | 请求方式 |
    | ------------------------------------ | ------- | -------- |
    | 查询所有员工                         | emps    | GET      |
    | 查询某个员工(来到修改页面)           | emp/1   | GET      |
    | 来到添加页面                         | emp     | GET      |
    | 添加员工                             | emp     | POST     |
    | 来到修改页面（查出员工进行信息回显） | emp/1   | GET      |
    | 修改员工                             | emp     | PUT      |
    | 删除员工                             | emp/1   | DELETE   |

#### 6.员工列表

 1. 编写Controller 使用Model 将值存入域中 

    *//把数据保存到Model中，SpringMVC会自动把这些数据保存到request域中*
    
    ```java
    @Controller
    public class Employee {
    
        @Autowired
        EmployeeDao employeeDao = new EmployeeDao();
    
        @GetMapping("/emps")
        public String emplist(Model model){
    
            Collection<com.athhw.sprigboot006web.entities.Employee> employee = employeeDao.getAll();
            model.addAttribute("emps",employee);
            return "emp/list";
        }
    }
    ```
    
    或使用modelandview转发数据
    
    ```java
    @Controller
    public class Employee {
    
        @Autowired
        EmployeeDao employeeDao = new EmployeeDao();
    
        @GetMapping("/emps")
        public ModelAndView  emplist(ModelAndView modelAndView){
    
            Collection<com.athhw.sprigboot006web.entities.Employee> employee = employeeDao.getAll();
            //model.addAttribute("emps",employee);
            modelAndView.addObject("emps",employee);
            modelAndView.setViewName("emp/list");
            return modelAndView;
        }
    }
    ```

#### 7.使用thymeleaf复用公用div

 1. ```html
    1、抽取公共片段
    <div th:fragment="copy">
    &copy; 2011 The Good Thymes Virtual Grocery
    </div>
    
    2、引入公共片段
    <div th:insert="~{footer :: copy}"></div>
    ~{templatename::selector}：模板名::选择器
    ~{templatename::fragmentname}:模板名::片段名
    
    3、默认效果：
    insert的公共片段在div标签中
    如果使用th:insert等属性进行引入，可以不用写~{}：
    行内写法可以加上：[[~{}]];[(~{})]；
    ```

 2. 三种引入公共片段的th属性：

    **th:insert**：将公共片段整个插入到声明引入的元素中

    **th:replace**：将声明引入的元素替换为公共片段

    **th:include**：将被引入的片段的内容包含进这个标签中

    ```html
    <footer th:fragment="copy">
    &copy; 2011 The Good Thymes Virtual Grocery
    </footer>
    
    引入方式
    <div th:insert="~{footer :: copy}"></div>
    <div th:replace="footer :: #copy"></div>
    <div th:include="footer :: copy"></div>
    
    效果
    <div>
        <footer>
        &copy; 2011 The Good Thymes Virtual Grocery
        </footer>
    </div>
    
    <footer>
    &copy; 2011 The Good Thymes Virtual Grocery
    </footer>
    
    <div>
    &copy; 2011 The Good Thymes Virtual Grocery
    </div>
    ```

3. 引入示例：

    1. 公用bar部分 抽取

       ```html
       示例1
       <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0" th:fragment="topbar">
       示例2
       <!--侧边栏 设定公共侧边栏-->
       <nav class="col-md-2 d-none d-md-block bg-light sidebar" th:fragment="sidebar">
       ```

    2. 在其他html页面引用公用bar

       引入前删除重复的div

       ```html
       示例1 引入
       <!--引入抽取的bar-->
       <div th:insert="~{dashboard::topbar}"></div>
       示例2 引入
       <!--引入公用侧边栏-->
       <div th:insert="~{dashboard::sidebar}"></div>
       ```

#### 8.在HTML中取出Controller的转发数据（遍历集合，格式化，判断）

 1. 使用遍历的方式取出 thymeleaf语法

    ```html
    <tbody>
        <tr th:each="emp:${emps}">
            <td th:text="${emp.id}"></td>
            <td th:text="${emp.lastName}"></td>
            <td th:text="${emp.email}"></td>
            <td th:text="${emp.gender}==0?'女':'男'"></td> 对数据在前端进行判断
            时间格式化：
            <td th:text="${#dates.format(emp.birth,'dd/MMM/yyyy-HH:mm')}"></td> 
            取出deppartment类中的name：
            <td th:text="${emp.department.departmentName}"></td> 
        </tr>
    </tbody>
    ```

#### 9.添加员工

 1. controller

    ```java
    //员工添加处理 添加完后跳转到其他的Controller处理
        //SpringMVC自动将请求参数和形参对象属性进行一一绑定：要求请求参数的名字和javabean形参对象里面的属性名name相同
        @PostMapping("/addEmp")
        public String addEmp(Employee employee){
    
            System.out.println("保存的员工信息："+employee);
            employeeDao.save(employee);//保存员工
            //添加完返回列表页面 return /emps的Controller处理
            //redirect: 重定向一个地址  /代表当前项目路径
            //foward: 转发到一个地址
            return "redirect:/emps";
        }
    ```

	2. 填写员工信息的form表单

    ```java
    
    				<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
    					<!--设定员工田间form 处理地址-->
    					<!--设定form属性名name和提交对象属性一致-->
    					<form th:action="@{/addEmp}" method="post">
    						<!--姓名 lastName-->
    						<div class="form-group">
    							<label>LastName</label>
    							<input type="text" name="lastName" class="form-control" placeholder="zhangsan">
    						</div>
    						<!--邮箱 email-->
    						<div class="form-group">
    							<label>Email</label>
    							<input type="email" name="email" class="form-control" placeholder="zhangsan@atguigu.com">
    						</div>
    						<!--性别gender -->
    						<div class="form-group">
    							<label>Gender</label><br/>
    							<div class="form-check form-check-inline">
    								<input class="form-check-input" type="radio" name="gender"  value="1">
    								<label class="form-check-label">男</label>
    							</div>
    							<div class="form-check form-check-inline">
    								<input class="form-check-input" type="radio" name="gender"  value="0">
    								<label class="form-check-label">女</label>
    							</div>
    						</div>
    						<!--部门id department.id-->
    						<div class="form-group">
    							<label>department</label>
    							<select class="form-control" name="department.id">
    								<!--查询部门 显示部门名 提交数据 提交部门id-->
    								<option th:value="${dId.id}" th:each="dId:${dIds}">[[${dId.departmentName}]]</option>
    							</select>
    						</div>
    						<!--生日 birth-->
    						<div class="form-group">
    							<label>Birth</label>
    							<input type="text" name="birth" class="form-control" placeholder="2012/12/12">
    						</div>
    						<button type="submit" class="btn btn-primary">添加</button>
    					</form>
    ```

#### 10.员工修改

 1. Controller

    ```java
    //员工数据修改
    @PostMapping("/editEmp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工数据："+employee);
        employeeDao.save(employee);
        //回到emps 的controller处理
        return "redirect:/emps";
    }
    ```

 2. 新建一个与add员工相同的页面

    ```html
    <!--使用input type="hidden"标签传输员工id-->
    <input type="hidden" name="id" th:value="${emps.id}">
    ```

#### 11.员工删除

 1. html页面

    ```html
    <!--删除时delete请求 action路径无需改变 对应controller的delete请求的路径-->
    <form th:action="@{/emp/}+${emp.id}" method="post">
    <!--从input发送delete请求 -->
    <input type="hidden" name="_method" value="delete">
    <button type="submit" class="btn btn-sm btn-danger" >删除</button>
    </form>
    ```

2. controller页面

    ```java
    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
    ```

3. 要实现html传送delete请求，必须配置HiddenHttpMethodFilter过滤器

###六.WEB错误机制处理

#### 1.Springboot的默认错误处理

 1. springboot可以智能地识别是浏览器访问还是客户端访问（根据请求头判断）

    - 浏览器发送的请求头

      ![](mdpicture/搜狗截图20180226180347.png)

     - 客户端发送的请求头

       ![](mdpicture/搜狗截图20180226180504.png)

    	- BasicErrorController 在这（下面有）根据数据类型判断返回的内容

 2. 浏览器访问

    遇到不存在的页面，spring默认返回一个错误页面

    ![](mdpicture/搜狗截图20180226173408.png)

3. 其他客户端访问（安卓app等

    返回一个json数据

    ![](mdpicture/搜狗截图20180226173527.png)

 4. 错误处理原理参照ErrorMvcAutoConfiguration，错误处理地自动配置

    给容器中添加了以下组件

    ​	1、DefaultErrorAttributes：

    ```java
    帮我们在页面共享信息；
    @Override
    	public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes,
    			boolean includeStackTrace) {
    		Map<String, Object> errorAttributes = new LinkedHashMap<String, Object>();
    		errorAttributes.put("timestamp", new Date());
    		addStatus(errorAttributes, requestAttributes);
    		addErrorDetails(errorAttributes, requestAttributes, includeStackTrace);
    		addPath(errorAttributes, requestAttributes);
    		return errorAttributes;
    	}
    ```

    

    ​	2、BasicErrorController：处理默认/error请求

    ```java
    @Controller
    @RequestMapping("${server.error.path:${error.path:/error}}")
    public class BasicErrorController extends AbstractErrorController {
        
        @RequestMapping(produces = "text/html")//产生html类型的数据；浏览器发送的请求来到这个方法处理
    	public ModelAndView errorHtml(HttpServletRequest request,
    			HttpServletResponse response) {
    		HttpStatus status = getStatus(request);
    		Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(
    				request, isIncludeStackTrace(request, MediaType.TEXT_HTML)));
    		response.setStatus(status.value());
            
            //去哪个页面作为错误页面；包含页面地址和页面内容
    		ModelAndView modelAndView = resolveErrorView(request, response, status, model);
    		return (modelAndView == null ? new ModelAndView("error", model) : modelAndView);
    	}
    
    	@RequestMapping
    	@ResponseBody    //产生json数据，其他客户端来到这个方法处理；
    	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
    		Map<String, Object> body = getErrorAttributes(request,
    				isIncludeStackTrace(request, MediaType.ALL));
    		HttpStatus status = getStatus(request);
    		return new ResponseEntity<Map<String, Object>>(body, status);
    	}
    ```

    

    ​	3、ErrorPageCustomizer：

    ```java
    	@Value("${error.path:/error}")
    	private String path = "/error";  系统出现错误以后来到error请求进行处理；（web.xml注册的错误页面规则）
    ```

    

    ​	4、DefaultErrorViewResolver：

    ```java
    @Override
    	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status,
    			Map<String, Object> model) {
    		ModelAndView modelAndView = resolve(String.valueOf(status), model);
    		if (modelAndView == null && SERIES_VIEWS.containsKey(status.series())) {
    			modelAndView = resolve(SERIES_VIEWS.get(status.series()), model);
    		}
    		return modelAndView;
    	}
    
    	private ModelAndView resolve(String viewName, Map<String, Object> model) {
            //默认SpringBoot可以去找到一个页面？  error/404
    		String errorViewName = "error/" + viewName;
            
            //模板引擎可以解析这个页面地址就用模板引擎解析
    		TemplateAvailabilityProvider provider = this.templateAvailabilityProviders
    				.getProvider(errorViewName, this.applicationContext);
    		if (provider != null) {
                //模板引擎可用的情况下返回到errorViewName指定的视图地址
    			return new ModelAndView(errorViewName, model);
    		}
            //模板引擎不可用，就在静态资源文件夹下找errorViewName对应的页面   error/404.html
    		return resolveResource(errorViewName, model);
    	}
    ```

    

    ​	步骤：

    ​		一但系统出现4xx或者5xx之类的错误；ErrorPageCustomizer就会生效（定制错误的响应规则）；就会来到/error请求；就会被**BasicErrorController**处理；

    ​		1）响应页面；去哪个页面是由**DefaultErrorViewResolver**解析得到的；

    ```java
    protected ModelAndView resolveErrorView(HttpServletRequest request,
          HttpServletResponse response, HttpStatus status, Map<String, Object> model) {
        //所有的ErrorViewResolver得到ModelAndView
       for (ErrorViewResolver resolver : this.errorViewResolvers) {
          ModelAndView modelAndView = resolver.resolveErrorView(request, status, model);
          if (modelAndView != null) {
             return modelAndView;
          }
       }
       return null;
    }
    ```


#### 2.如何定制错误响应

 1. 定制浏览器访问地错误页面

    1. **有模板引擎**的情况下：**error/状态码**；
       - 第一种：【将错误页面命名为  错误状态码.html 放在模板引擎文件夹里面的 error文件夹下】，发生此状态码的错误就会来到  对应的页面；
       - 第二种：我们可以使用4xx和5xx作为错误页面（4xx.html）的文件名来匹配这种类型的所有错误，精确优先（优先寻找精确的状态码.html）；	
       - 页面能获取的信息：

    ​				timestamp：时间戳

    ​				status：状态码

    ​				error：错误提示

    ​				exception：异常对象

    ​				message：异常消息

    ​				errors：JSR303数据校验的错误都在这里	

    ​				使用行内表达式在html中获取：

    ```html
    <!--从错误页面获取信息 行内表达式-->
    <h1>status:[[${status}]]</h1>
    <h2>timestamp：[[${timestamp}]]</h2>
    ```

    	2. 没有模板引擎（模板引擎找不到这个错误页面），静态资源文件夹下找；
     	3. 以上都没有错误页面，就是默认来到SpringBoot默认的错误提示页面；

 2. 浏览器自定义异常响应：

    1. controller自定义什么情况抛出异常：

       ```java
       @ResponseBody
           @RequestMapping("/hello")
           //抛出自定义异常类测试 参数直接从url输入
       public String hello(@RequestParam("user") String user){
               //抛出异常
               if("aaa".equals(user)){
                   throw  new UserNotExitException();
               }
               return "hello world";
       }
       ```

    2. 自定义一个异常类

       ```java
       /*
           自定义异常类
        */
       public class UserNotExitException extends RuntimeException {
           //alt+ins 添加构造器
           public UserNotExitException() {
               super("用户不存在");
           }
       }
       ```

    3. 之后会抛出错误代码，spring自动找到错误代码对应的网页（error文件夹下）

 3. 定制错误的json数据响应

    1. 自定义异常处理器&返回json数据（无法自适应浏览器/客户端）

       1. 使用postman模拟客户端

       2. 编写自定义处理器（Controller包） @ControllerAdvice

          与上面的自定义异常类连通，当出现异常时，异常会传到这

          ```java
          @ControllerAdvice
          public class MyExceptionHandler {
          	//与上面的自定义异常类连通
              //只要出现异常，就会调用这个方法获取异常 返回json数据
              //使用@ResponseBody注解，方便的返回json数据
              @ResponseBody
              @ExceptionHandler(UserNotExitException.class)
              public Map<String,Object> HandlerException(Exception e){
          
                  //自定义json数据
                  Map<String,Object> map = new HashMap<>();
                  map.put("code","user.notexist");
                  map.put("message",e.getMessage());
                  return map;
              }
          }
          ```

       3. 缺点：无论是浏览器还是客户端都只会返回json数据

    2. 改编成自适应的

       1. 自定义处理器：

          ```java
          @ExceptionHandler(UserNotExitException.class)
              public String HandlerException(Exception e, HttpServletRequest request){
                  //自定义json数据
                  Map<String,Object> map = new HashMap<>();
                  map.put("code","user.notexist");
                  map.put("message",e.getMessage());
                  //传入我们自己的错误状态码 4xx 5xx 返回到error
                  // error会获取这里设置的状态码 再转到我们自定义的错误页面
                  request.setAttribute("javax.servlet.error.status_code",500);
                  return "forward:/error";
              }
          ```

	4. 将我们定制的数据携带出去

    	1. 出现错误以后，会来到/error请求，会被BasicErrorController处理，响应出去可以获取的数据是由getErrorAttributes得到的（是AbstractErrorController（ErrorController）规定的方法）；

    	2. 第一种：完全来编写一个ErrorController的实现类【或者是编写AbstractErrorController的子类】，放在容器中；

    	3. 第二种：页面上能用的数据，或者是json返回能用的数据都是通过errorAttributes.getErrorAttributes得到；

        容器中DefaultErrorAttributes.getErrorAttributes()；默认进行数据处理的；

        自定义ErrorAttributes

        ```java
        //给容器中加入我们自己定义的ErrorAttributes
        @Component
        public class MyErrorAttributes extends DefaultErrorAttributes {
            @Override
            public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
            Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
            map.put("company","atguigu");
            return map;
            }
        }
        ```

        最终的效果：响应是自适应的，可以通过定制ErrorAttributes改变需要返回的内容

        ![](mdpicture/搜狗截图20180228135513.png)

###七.Docket

		####    1.简介

​		



