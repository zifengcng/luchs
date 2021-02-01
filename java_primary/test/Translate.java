import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author cheng
 * @Date 2021/2/1
 */
public class Translate {

    private AtomicInteger atomicInteger;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Translate t = new Translate();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 10; i++) {
            t.atomicInteger = new AtomicInteger(0);
            System.out.println(t.test("123", threadPoolExecutor));
        }

    }

    public String test(String content, ThreadPoolExecutor threadPoolExecutor) throws ExecutionException, InterruptedException {
        try {
            Random random = new Random();
            int r1 = random.nextInt(5000);
            int r2 = random.nextInt(5000);
            int r3 = random.nextInt(5000);
            FutureTask<String> f1 = new FutureTask<>(() -> {
                sleep(r1);
                String baidu = baidu(content);
                update(1);
                return baidu;
            });
            FutureTask<String> f2 = new FutureTask<>(() -> {
                sleep(r2);
                String youdao = youdao(content);
                update(2);
                return youdao;
            });
            FutureTask<String> f3 = new FutureTask<>(() -> {
                sleep(r3);
                String google = google(content);
                update(3);
                return google;
            });
            threadPoolExecutor.execute(f1);
            threadPoolExecutor.execute(f2);
            threadPoolExecutor.execute(f3);

            while (atomicInteger.get() == 0) {

            }
            int num = atomicInteger.get();
            System.out.println(r1 + "-" + r2 + "-" + r3);
            if (num == 1) {
                f2.cancel(true);
                f3.cancel(true);
                return f1.get();
            } else if (num == 2) {
                f1.cancel(true);
                f3.cancel(true);
                return f2.get();
            } else {
                f1.cancel(true);
                f2.cancel(true);
                return f3.get();
            }
        } catch (InterruptedException e) {

        } catch (Exception e) {

        }
        return "123";
    }

    private void update(int i) {
        atomicInteger.compareAndSet(0, i);
    }

    public String baidu(String content) {
        return "baidu";
    }

    public String youdao(String content) {
        return "youdao";
    }

    public String google(String content) {
        return "google";
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {

        }
    }

}
