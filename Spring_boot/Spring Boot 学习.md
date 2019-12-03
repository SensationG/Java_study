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
    -  templates：保存所有的模板页面；（Spring Boot默认jar包使用嵌入式的Tomcat，默认不支持JSP页 面）；可以使用模板引擎（freemarker、thymeleaf）； 
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

    - 方式2: 使用命令行方式激活

      Program arguments(项目设置中)中输入：

      ```xml
      --spring.profiles.active=dev
      ```

      



​			





   ​