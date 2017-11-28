package in.vamsoft.threads;

import java.util.Scanner;

class Producer extends Thread {
  Consumer consumer;
  private int number;

  public void setConsumer(Consumer consumer) {
    this.consumer = consumer;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public Producer(String name) {
    super(name);

  }

  public void run() {
    try {
      Scanner sc = new Scanner(System.in);
      int num = 0;
      System.out.println("Enter the number...");
      while ((num = sc.nextInt()) > 0) {
        System.out.println("number in producer : " + num);
        this.number = num;
        synchronized (consumer) {
          consumer.notify();

        }
        synchronized (this) {

          wait();

        }

      }
      sc.close();
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }

}

class Consumer extends Thread {

  Producer producer;

  public Consumer(String name) {
    super(name);
  }

  public void setProducer(Producer producer) {
    this.producer = producer;
  }

  public void run() {
    for (int i = 0; i <= 5; i++) {
      try {
        synchronized (this) {
          wait();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      int fact = factorial(producer.getNumber());
      System.out.println(fact);

      synchronized (producer) {
        producer.notify();

      }
    }
  }

  int factorial(int a) {
    int f = 1;
    while (a > 0) {
      f = f * a;
      a--;
    }
    return f;
  }

}

public class WaitNotifyDemo {

  public static void main(String[] args) {

    Producer producer = new Producer("producer");
    Consumer consumer = new Consumer("consumer");
    producer.setConsumer(consumer);
    consumer.setProducer(producer);
    consumer.start();
    producer.start();
  }

}
