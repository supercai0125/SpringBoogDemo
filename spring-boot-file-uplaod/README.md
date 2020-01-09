Spring Boot 默认上传文件大小限制是 1MB，默认单次请求大小是 10MB，超出大小会跑出 MaxUploadSizeExceededException 异常。
问题来了，当文件超过 1M 和超过 10M 时异常是有区别的。

而Spring Boot：上传文件大小超限制如何捕获 MaxUploadSizeExceededException 异常是个痛疼的问题
一开始在启动类中先后配置了TomcatServletWebServerFactory和MultipartConfigElement
发现是解除了tomcat的上传文件的大小限制，但是当上传文件超 tomcat 的大小限制后会先于 Controller 触发异常

解决办法：在springboot配置文件添加如下：
server.tomcat.max-swallow-size=100MB

注意上面最重要的是要配置内嵌的 tomcat 的最大吞吐量即 max-swallow-size，可以设置 -1 不限制，也可以设置一下比较大的数字 100M
