package src.ru.geekbrains;

import java.util.concurrent.CountDownLatch;

public class MainClass {
    public static final int CARS_COUNT = 4;

     public static void main(String[] args){
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cdl);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread( cars[i] ).start();
        }
         try {
             cdl.await();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
         boolean isAllCarsFinish = false;
         while (!isAllCarsFinish){
             isAllCarsFinish = true;
             for (int i = 0; i < cars.length ; i++) {
                 if (!cars[i].isFinished()) isAllCarsFinish = false;
             }
         }
         System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
         System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Победитель:"+race.getWinner().getName());
    }
}
