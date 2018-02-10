package redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedisFactory {

    //単节点客户端
    private static RedissonClient rediscli ;

    //哨兵客户端
    private static RedissonClient redisSencli;

    private RedisFactory() {
    }

    /**
     * 单节点单例
     * @return
     */
    public static  RedissonClient getRedis() {
        if (rediscli == null) {
            synchronized(RedisFactory.class) {
                if(rediscli == null) {
                    Config config = new Config();
                    //config.setTransportMode(TransportMode.EPOLL);
                    config.useSingleServer().setAddress("redis://www.jhcoder.top:6379").setPassword("jhcoder");

                    RedissonClient cli = Redisson.create(config);
                    rediscli = cli;
                }
            }
        }
        return rediscli;
    }


    /**
     * 哨兵单例
     * @return
     */
    public static  RedissonClient getSenRedis() {
        if (redisSencli == null) {
            synchronized(RedisFactory.class) {
                if(redisSencli == null) {
                    Config config = new Config();
                    config.useSentinelServers()
                            .setMasterName("mymaster")
                            .addSentinelAddress("redis://www.jhcoder.top:16301","redis://www.jhcoder.top:16302","redis://www.jhcoder.top:16303")
                            .setPassword("jhcoder");
                    RedissonClient cli = Redisson.create(config);
                    redisSencli = cli;
                }
            }
        }
        return redisSencli;
    }
}
