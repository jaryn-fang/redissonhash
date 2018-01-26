package redissonhash;

import java.util.ArrayList;
import java.util.List;

public class RunThis {

    public static void main(String[] args) {
        //假设的server
        List<String> nodes = new ArrayList<String>() {};
        nodes.add("0001");
        nodes.add("0002");
        nodes.add("0003");
        App k = new App(160, nodes);
        String str = "";
        for (int i = 0; i < 10; i++)
        {
            String Key="user_" + i;
            str += String.format("Key:%s分配到的Server为：%s\n\n", Key, k.getNodeByKey(Key));

        }
        System.out.println(str);

    }
}
