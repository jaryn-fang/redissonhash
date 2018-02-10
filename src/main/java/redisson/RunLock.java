package redisson;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RunLock {
    public static void main(String[] args) throws InterruptedException {

        RedissonClient client =  RedisFactory.getRedis();
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        //新建一个公平锁
        RLock rlock =  client.getFairLock("jhcoder_lock001");
        // 等待10s后释放锁
        rlock.tryLock(100, 10, TimeUnit.SECONDS);
        //线程每1s检查锁是否打开
        executor.scheduleAtFixedRate(new TrySout(rlock), 1, 1, TimeUnit.SECONDS);
    }
}

class TrySout implements Runnable {

    RLock rlock = null;

    public TrySout(RLock rlock) {
        this.rlock = rlock;
    }

    public void run() {
        if(rlock.isLocked()) {
            System.out.println("锁了");
        }else {
            System.out.println("没锁");
        }
    }
}


