# Spring Boot 学习

### 1. 环境搭建

- 本次学习环境：
  1. jdk 1.8
  2. maven 3.3.9
  3. 编辑器 Intellij IDEA 
  4. Spring boot 1.5.9

1. 设置Maven

   给Maven的setting.xml配置文件的profiles标签添加：

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

   ### 2. HelloWord Spring测试

   - 功能：浏览器发送Hello请求，服务器接收请求并处理，响应HelloWorld字符串

   1. 创建一个Maven工程(jar工程) 步骤略

      记得勾选自动导入包

      ![TIM截图20191201145046](D:\GitHub\Java_study\Spring_boot\mdPicture\TIM截图20191201145046.png)

   2. 导入Spring boot相关依赖（从官网获取）

      ```java
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

      在pom.xml中添加上述代码，会**自动导入jar包**

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

      ```java
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

   ### 3.HelloWorld探究

   1. POM解析

      ```xml
      <parent><!-- 父项目 -->
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-parent</artifactId><!-- 父项目路径 -->
              <version>1.5.9.RELEASE</version>
      </parent>

      父项目的父项目是
      由它来真正管理各个版本的依赖。
      <parent>
      		<groupId>org.springframework.boot</groupId>
      		<artifactId>spring-boot-dependencies</artifactId>
      		<version>1.5.9.RELEASE</version>
      		<relativePath>../../spring-boot-dependencies</relativePath>
      </parent>
      ```

      Spring Boot的版本仲裁管理中心；

      以后我们导入依赖默认是不需要写版本；（没有在dependencies里面管理的依赖自然需要声明版本号

   ​