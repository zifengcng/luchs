import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wbc
 * @date 2025/10/23 11:15
 */
public class ProduceConsume {

    public static void main(String[] args) throws Exception {
        new ProduceConsume().test();
    }

    public void test() throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            int i = 0;
            while (i < Integer.MAX_VALUE) {
                try {
                    queue.put(i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        });

        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {

                Integer num = null;
                try {
                    num = queue.take();
                    System.out.println("消费者消费了：" + num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        executorService.shutdown();
    }

}
