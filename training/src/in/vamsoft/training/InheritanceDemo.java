package in.vamsoft.training;

class A {
  void m1() {
    System.out.println("A.m1()");
  }
}

class B extends A {
  void m2() {
    System.out.println("B.m2()");
  }
}


class C extends B {
  @Override
  void m2() {
    System.out.println("C.m2()");
  }

  void m3() {
    System.out.println("C.m3()");
  }
}

public class InheritanceDemo {

  /**
   * @param args
   *          .
   */
  public static void main(String[] args) {
    final A a1 = new A();
    a1.m1();
    final B b1 = new B();
    b1.m1();
    b1.m2();
    final B c1 = new C();
    c1.m1();
    c1.m2();
    ((C) c1).m3();

  }
}
