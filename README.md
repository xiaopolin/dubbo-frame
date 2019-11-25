## 项目结构
- dubbo-consumer: 服务消费者
- dubbo-provider: 服务生产者
- dubbo-admin.zip: 由apache撰写最新的dubboAdmin客户端
- dubbo-admin-server-0.1.jar: 客户端编译后的jar包
 
  - 可通过修改\BOOT-INF\classes\application.properties文件以配置参数
  - 可直接通过java -jar命令直接运行客户端

## Zookeeper

- zookeeper拥有3个暴露端口：

  - 2181：客户端连接zookeeper端口号
  - 2888：Follower与Leader连接并传输数据的接口
  - 3888：Follower之间传输选举信息的接口

- shell操作Zookeeper

  ```properties
  ls 路径 : 查看路径下节点
  ls2 路径 : 查看路径下节点详细信息
  create 路径 值 : 创建节点
  #-e : 节点不持久化，即重启后会消失
  #-s : 为节点加入序列值以防冲突
  get 路径 : 获取节点的值及其详细信息
  #watch : 监控该节点下一次变化
  set 路径 值 : 修改节点信息
  delete 路径 : 删除单个节点
  rmr 路径 : 递归删除节点
  ```

- 节点详细信息

  ```properties
  czxid : 节点ID（创建的事务ID）
  ctime : 创建时间
  mzxid : 最后更新的事务ID
  mtime : 最后更新的时间
  pZxid : 最后更新的子节点ID
  cversion : 子节点修改次数
  dataversion : 节点版本号
  ephemeralOwner : 若为临时节点则是缓存ID，若不是则为0
  ```

- 操作zk客户端

  ```properties
  cd zookeeper/bin
  ./zkcli.sh
  ```

- 操作zk服务

  ```properties
  cd zookeeper/bin
  ./zkServer.sh start/stop/status
  ```

- 配置文件zoo.cfg

  ```properties
  # The number of milliseconds of each tick
  tickTime=2000
  # The number of ticks that the initial 
  # synchronization phase can take
  initLimit=10
  # The number of ticks that can pass between 
  # sending a request and getting an acknowledgement
  syncLimit=5
  # 数据存放位置
  dataDir=/tmp/zookeeper
  # 客户端连接端口
  clientPort=2181
  ```



## Dubbo

### dubbo.xml官方配置文档

http://dubbo.apache.org/zh-cn/docs/user/references/xml/introduction.html

xml基础信息模板：

```xml
<!-- 当前服务名称，不要和别的服务重名 -->
<dubbo:application name="dubbo-provider-or-consumer"/>
<!-- 注册中心地址，此处使用的是zookeeper -->
<dubbo:registry protocol="zookeeper" address="192.168.0.192:2181"/>
<!-- 通信规则，通过什么端口互相调用服务 -->
<dubbo:protocol name="dubbo" port="20880"/>
```



### 多版本

生产者配置版本

```xml
<bean id="dubboProvider1" class="com.dubbo.dubboImpl.DubboProvider1"/>
<dubbo:service interface="com.dubbo.DubboProvider" ref="dubboProvider1" version="1.0.0"/>

<bean id="dubboProvider2" class="com.xpl.dubbo.dubboImpl.DubboProvider2"/>
<dubbo:service interface="com.dubbo.DubboProvider" ref="dubboProvider2" version="2.0.0"/>

<!-- 此时暴露出去的生产者接口名称都是DubboProvider -->
<!-- 但是通过version参数的不同，暴露的实际实现方法也不同 -->
```

消费者配置

```xml
<dubbo:reference id="userInfoDubbo" interface="com.xpl.dubbo.UserInfoDubbo" version="?"/>

<!-- 通过配置消费者的version即可调用相应版本的生产者实现类 -->
<!-- 注意：只会调用相同version的生产者实现类 -->
```



### 服务直连

即使zookeeper全部宕机，调过一次实现类的消费者是可以通过本地缓存再次调用方法成功的

也可以通过直连消费者的方式调用服务

```xml
<dubbo:reference id="userInfoDubbo" interface="com.xpl.dubbo.UserInfoDubbo" url="dubbo://IP:端口" />
<!-- IP为dubboAdmin中可以查询到的IP，端口为生产者暴露的端口 -->
```

