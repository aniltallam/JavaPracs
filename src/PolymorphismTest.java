/**
 * Created by well on 4/17/2016.
 */
public class PolymorphismTest {
    static void run(){
        C c =new C();
        c.show();
        B b =c;
        b.show();
        A a = b;
        ((A)a).show();
        Class a1 = A.class;
    }
}

class A{

    void show(){
        System.out.println("In A");
    }
}

class  B extends A{
    void show(){
        System.out.println("In B");
    }
}

class  C extends  B{
    void show(){
        //super.show();
        System.out.println("In C");
    }
}

abstract class abclass{
    void show(){
        System.out.println("In abclass");
    }
    abstract void show1();
}