package in.vamsoft.day6;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InbuildInterfaces {
  
  
  public static void main(String[] args) {
    Predicate<Integer> oddOrEven = (x) -> x%2==0 ? true :false;
    System.out.println("10 is even or odd: "+(oddOrEven.test(10)?"10 is even":"10 is odd "));
    
    Consumer<String> display = str->System.out.println(str.length());
    display.accept("hai");
    
    Function<String, Integer> findLength = (str)->str.length();
    System.out.println("length of data"+findLength.apply("string"));
    
    Supplier<String> getDate = ()->LocalDate.now().getDayOfWeek().name();
    System.out.println("Today is: "+getDate.get());
    
  }

}
