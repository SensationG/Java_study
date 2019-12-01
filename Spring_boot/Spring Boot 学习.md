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

3. ​