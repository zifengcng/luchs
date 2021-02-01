import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author cheng
 * @Date 2021/2/1
 * AtomicInteger自增
 */
public class Access {

    private Map<String, AtomicInteger> map = new HashMap<>();

    public void access(String ip) {
        AtomicInteger atomicInteger = map.get(ip);
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(1);
            map.put(ip, atomicInteger);
        } else {
            int i = atomicInteger.incrementAndGet();
            if (i == 10000000) {
                System.out.println(10000000);
            }
        }

        // 可能不会打印？？？
//        map.compute(ip, (k, v) -> {
//            if (v == null) {
//                return new AtomicInteger(1);
//            } else {
//                int i = v.incrementAndGet();
//                if (i == 10000000) {
//                    System.out.println(10000000);
//                }
//                return v;
//            }
//        });
    }


    public static void main(String[] args) {

        Access access = new Access();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 20, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 10000000; i++) {
            threadPoolExecutor.execute(() -> {
                access.access("192.168.10.1");
            });
        }

    }

}
