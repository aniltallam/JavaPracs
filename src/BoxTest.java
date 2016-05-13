/**
 * Created by well on 4/17/2016.
 */
public class BoxTest {
    static void run(){
        Box b1 = new Box(2,3);
        System.out.println(b1.getLength()+","+b1.getBreadth());
        b1.setLength(4); b1.setBreadth(6);
        System.out.println(b1.getLength()+","+b1.getBreadth());

        Box b2 = new Box(4,6);
        if(b1.equals(b2)) System.out.println("Working fine");
        if(b1 == b2) System.out.println("Is it so");

        Box b3 = new Box(8,9);
        System.out.println("Before Swap !!");
        System.out.println(b2);
        System.out.println(b3);
        b1.swap(b2,b3);
        System.out.println("After Swap !!");
        System.out.println(b2);
        System.out.println(b3);

//         Box b4 = new (4,9); Compilation Error
    }
}
