/**
 * Created by well on 4/17/2016.
 */
public class Box {
    int length;
    int breadth;

    Box(int l, int b){
        this.length = l;
        this.breadth = b;
    }

    public int getBreadth() {
        return breadth;
    }

    public int getLength() {
        return length;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getArea(){
        return length* breadth;
    }

    public void swap(Box b1, Box b2){
        Box temp = b1;
        b1= b2;
        b2 = temp;
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)){
            return true;
        }

        if(obj instanceof Box){
            Box other = (Box)obj;
             return  this.length == other.length && this.breadth == other.breadth;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return ("length = " + length) + (", breadth = " + breadth);
    }
}
