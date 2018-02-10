package redisson;

import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;

import java.util.List;

public class RunSentine {

    public static void main(String[] args) {
        RedissonClient cli = RedisFactory.getSenRedis();
        List<Integer> list= cli.getList("list");
        System.out.println(list.add(1));
        System.out.println(cli.getList("list").size());
    }
}
