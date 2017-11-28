package in.vamsoft.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ExecutorS implements Runnable {
  
  String jobname;

  @Override
  public void run() {
    for(int i = 1;i <= 5;i++) {
      System.out.println(Thread.currentThread().getName()+ i + " " + jobname);
    }
  }

  public ExecutorS(String jobname) {
    super();
    this.jobname = jobname;
  } 
}

class CThread implements Callable<Integer>{

  @Override
  public Integer call() throws Exception {
    int sum = 0;
    for(int i=1;i <= 10;i++) {
      sum +=i;
    }
    return sum;
  }
  
}


public class ExecutorServiceDemo {
  
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService service = Executors.newFixedThreadPool(2);
    service.execute(new ExecutorS("job1"));
    service.execute(new ExecutorS("job2"));
    service.execute(new ExecutorS("job3"));
    service.execute(new ExecutorS("job4"));
    service.execute(new ExecutorS("job5"));
    Future<Integer> result = service.submit(new CThread());
    System.out.println(result.get());
    service.shutdown();
  }
  

}
