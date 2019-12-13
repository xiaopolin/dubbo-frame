编辑于2019/12/13

# Dubbo框架模板

使用SpringBoot，以xml的方式整合Dubbo

## SpringBoot版本为2.1.6.RELEASE

## Dubbo版本为2.7.3



## 项目结构
- dubbo-consumer

  服务消费者

- dubbo-provider

  服务生产者

- dubbo-server：

  * dubbo-admin.zip

    ~~~properties
    因为阿里维护dubbo-admin仅支持至dubbo2.6以下
    所以这边使用由apache撰写的最新的dubboAdmin客户端
    ~~~

  * dubbo-admin-server-0.1.jar

    ~~~properties
    dubboAdmin客户端编译后的jar包
    
    修改\BOOT-INF\classes\application.properties文件以配置参数
    ~~~

  * dubbo-monitor.zip

    ~~~properties
    因为阿里维护dubbo-monitor仅支持至dubbo2.6以下
    所以从大神处偷来个魔改版的
    可直接解压dubbo-monitor-server.tar.gz后使用
    理论上代码打包后还有个jar包，但运行不起来，找时间解决掉
    ~~~

  * dubbo-monitor-server.tar.gz

    ~~~properties
    魔改版dubbo-monitor
    解压后，修改配置文件，通过tomcat启动即可访问
    ~~~

    

  

  

