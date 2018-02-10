package redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;

public class RunConnect {
    public static void main(String[] args) {

        RedissonClient cli = RedisFactory.getSenRedis();

        System.out.println(cli.getNodesGroup().pingAll()+"");


    }
}


