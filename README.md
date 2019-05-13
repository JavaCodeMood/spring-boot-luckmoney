## springboot
启动命令：java -jar spring-boot-luckmoney-0.0.1-SNAPSHOT.jar        
切换环境启动命令： java -jar -Dspring.profiles.active=prod spring-boot-luckmoney-0.0.1-SNAPSHOT.jar      

注解：    
@ResponseBody + @Controller = @RestController    

传递参数：    
(1)@PathVariable("id") Integer id : 获取url中的数据, 对应的传值方式: http://localhost:8081/luckmoney/hello/100    
(2)@RequestParam("id") Integer id : 获取请求参数的值, 对应的传值方式: http://localhost:8081/luckmoney/hello?id=1000    
@RequestParam(value = "id", required = false, defaultValue = "0") Integer id  : 非必传，设置默认值为0




