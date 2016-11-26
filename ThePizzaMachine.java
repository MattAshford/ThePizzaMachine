package ThePizzaMachine;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@SuppressWarnings("InfiniteLoopStatement")
public class PizzaMachine {

    private static BlockingQueue<Integer> garlicQueue = 
                                                new ArrayBlockingQueue<>(6);
    private static BlockingQueue<Integer> olivesQueue = 
                                                new ArrayBlockingQueue<>(8);
    private static BlockingQueue<Integer> mushroomsQueue =
                                                new ArrayBlockingQueue<>(10);
    private static BlockingQueue<Integer> anchoviesQueue = 
                                                new ArrayBlockingQueue<>(6);       
    
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    garlicProducer();
                } catch (InterruptedException ignored) {}
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    olivesProducer();
                } catch (InterruptedException ignored) {}
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                try {
                    mushroomsProducer();
                } catch (InterruptedException ignored) {}
            }
        });

        Thread t4 = new Thread(new Runnable() {
            public void run() {
                try {
                    anchoviesProducer();
                } catch (InterruptedException ignored) {}
            }
        });
        Thread t5 = new Thread(new Runnable() {
            public void run() {
                try {
                    mushroomPizzaConsumer1();
                } catch (InterruptedException ignored) {}
            }
        });

        Thread t6 = new Thread(new Runnable() {
            public void run() {
                try {
                    mushroomPizzaConsumer2();
                } catch (InterruptedException ignored) {}
            }
        });
        Thread t7 = new Thread(new Runnable() {
            public void run() {
                try {
                    anchovyPizzaConsumer1();
                } catch (InterruptedException ignored) {}
            }
        });

        Thread t8 = new Thread(new Runnable() {
            public void run() {
                try {
                    anchovyPizzaConsumer2();
                } catch (InterruptedException ignored) {}
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
    }

    private static void garlicProducer() throws InterruptedException {
        while (true) {
            garlicQueue.put(1);
        }
    }
    private static void olivesProducer() throws InterruptedException {
        while (true) {
            olivesQueue.put(1);
        }
    }
    private static void mushroomsProducer() throws InterruptedException {
        while (true) {
            mushroomsQueue.put(1);
        }
    }
    private static void anchoviesProducer() throws InterruptedException {
        while (true) {
            anchoviesQueue.put(1);
        }
    }
    private static void mushroomPizzaConsumer1() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            if (garlicQueue.size() >= 1 && mushroomsQueue.size() >=4 ) {
                garlicQueue.take();
                for(int i=0; i < 4; i++){ 
                    mushroomsQueue.take(); 
                }                   
                System.out.println("Mushroom pizza1 consumed!   There are "
                                 + garlicQueue.size() + " pieces of garlic & " 
                                 + mushroomsQueue.size() + " mushrooms left");
            }
        }
    }
    private static void mushroomPizzaConsumer2() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            if (garlicQueue.size() >= 1 && mushroomsQueue.size() >=4 ) {
                garlicQueue.take();
                for(int i=0; i < 4; i++){ 
                    mushroomsQueue.take(); 
                }                   
                System.out.println("Mushroom pizza2 consumed!   There are "
                                 + garlicQueue.size() + " pieces of garlic & " 
                                 + mushroomsQueue.size() + " mushrooms left");
            }
        }
    }
    private static void anchovyPizzaConsumer1() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            if (garlicQueue.size() >= 2 && olivesQueue.size() >=2 && 
                                                anchoviesQueue.size() >=3) {
                garlicQueue.take();
                garlicQueue.take();
                olivesQueue.take();
                olivesQueue.take();
                for(int i=0; i < 3; i++){ 
                    anchoviesQueue.take(); 
                }                   
                System.out.println("Anchovy pizza1 consumed!    There are "
                                 + garlicQueue.size() + " pieces of garlic, " 
                                 + olivesQueue.size() + " olives & "
                                 + anchoviesQueue.size() + " anchovies left");
            }
        }
    }
    private static void anchovyPizzaConsumer2() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            if (garlicQueue.size() >= 2 && olivesQueue.size() >=2 && 
                                                anchoviesQueue.size() >=3) {
                garlicQueue.take();
                garlicQueue.take();
                olivesQueue.take();
                olivesQueue.take();
                for(int i=0; i < 3; i++){ 
                    anchoviesQueue.take(); 
                }                   
                System.out.println("Anchovy pizza2 consumed!    There are "
                                 + garlicQueue.size() + " pieces of garlic, " 
                                 + olivesQueue.size() + " olives & "
                                 + anchoviesQueue.size() + " anchovies left");
            }
        }
    }
}
