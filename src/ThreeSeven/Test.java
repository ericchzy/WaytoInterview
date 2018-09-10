package ThreeSeven;

public class Test {
    public static void mySqrt(int a)throws MyException {
        if(a<0) throw new MyException();
        System.out.println(Math.sqrt(a));
    }

    static class MyException extends Exception{
        public String toString(){
            return "negative";
        }
    }

    public static void main(String[] args){
        try {
            mySqrt(25);
            mySqrt(-5);
        }catch (MyException e) {
            System.out.println(" Caught " + e);
        }
    }
}

/* Output:
5.0
 Caught negative
*///:~