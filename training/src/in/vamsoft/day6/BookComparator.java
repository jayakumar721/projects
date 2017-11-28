package in.vamsoft.day6;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Books{
  int bId;
  String bTitle;
  String bAuthor;
  @Override
  public String toString() {
    return "Books [bId=" + bId + ", bTitle=" + bTitle + ", bAuthor=" + bAuthor + ", bPrice=" + bPrice + "]\n";
  }
  public Books(int bId, String bTitle, String bAuthor, int bPrice) {
    super();
    this.bId = bId;
    this.bTitle = bTitle;
    this.bAuthor = bAuthor;
    this.bPrice = bPrice;
  }
  public int getbId() {
    return bId;
  }
  public void setbId(int bId) {
    this.bId = bId;
  }
  public String getbTitle() {
    return bTitle;
  }
  public void setbTitle(String bTitle) {
    this.bTitle = bTitle;
  }
  public String getbAuthor() {
    return bAuthor;
  }
  public void setbAuthor(String bAuthor) {
    this.bAuthor = bAuthor;
  }
  public int getbPrice() {
    return bPrice;
  }
  public void setbPrice(int bPrice) {
    this.bPrice = bPrice;
  }
  int bPrice;
}


public class BookComparator {

  
  public static void main(String[] args) {
    Books book1 = new Books(1, "A", "BB", 254);
    Books book2 = new Books(2, "D", "AA", 546);
    Books book3 = new Books(3, "B", "WD", 622);
    Books book4 = new Books(4, "E", "CD", 322);
    Books book5 = new Books(5, "C", "EED", 254);
    
    List<Books> books = Arrays.asList(book1,book2,book3,book4,book5);
    
    Collections.sort(books,(Books obj1,Books obj2) -> {
      return obj1.getbTitle().compareTo(obj2.getbTitle());
    });
    
    System.out.println(books);
    
    Collections.sort(books,(obj1,obj2) -> obj1.getbAuthor().compareTo(obj2.getbAuthor()));
    System.out.println(books);
    Collections.sort(books,(obj1,obj2) -> ((Integer)obj2.getbId()).compareTo((Integer)obj1.getbId()));
    System.out.println(books);
    
    Stream<Books> book = books.stream();
    Stream<Books> gb = book.filter(s->s.getbPrice()>300);
    gb.forEach(b->System.out.println(b.toString()));
    books.stream().map(b->(b.getbTitle()).toLowerCase()).forEach(t->System.out.println(t));
  }
  
  
}
