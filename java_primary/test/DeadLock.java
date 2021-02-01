/**
 * @Author cheng
 * @Date 2021/2/1
 * 死锁
 */
public class DeadLock {

    private final Object a = new Object();
    private final Object b = new Object();

    public void test() {
        Thread t1 = new Thread(() -> {
            synchronized (a) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("线程1");
                }
            }
        }, "线程1");

        Thread t2 = new Thread(() -> {
            synchronized (b) {
                synchronized (a) {
                    System.out.println("线程2");
                }
            }
        }, "线程2");

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

    public static void main(String[] args) {
        new DeadLock().test();
    }

}
