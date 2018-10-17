package DesignPattern;

import java.util.ArrayList;

public class ProAndCus {

    public static void main(String[] args) {
        final box bigbox = new box();
        for (int i = 0; i < 500; ++i) {
            new Thread(new Runnable() {
                public void run() {
                    produ pro = new produ(bigbox);
                    pro.put();
                }
            }).start();
        }
        for (int i = 0; i < 500; ++i) {
            new Thread(new Runnable() {
                public void run() {
                    cust cus = new cust(bigbox);
                    cus.get();
                }
            }).start();
        }
    }
}

class box {
    static ArrayList<apple> boxlist = new ArrayList<apple>();
    static int capacity = 50;

    public void put(apple app) {
        synchronized (this) {
            try {
                while (boxlist.size() >= capacity)
                    wait();
                boxlist.add(app);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            notifyAll();
            System.out.println("put finished! Now the box has "
                    + boxlist.size() + " apples!");
        }
    }

    public apple get() {
        apple res = null;
        synchronized (this) {
            try {
                while (boxlist.size() <= 0)
                    wait();
                res = boxlist.remove(boxlist.size() - 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyAll();
            System.out.println("get finished! Now the box has "
                    + boxlist.size() + " apples!");
        }
        return res;
    }
}

class apple {
    private String name = "我是可爱的小苹果";
}

class produ {
    private box mybox;

    produ(box b) {
        this.mybox = b;
    }

    public void put() {
        apple app = new apple();
        mybox.put(app);
    }
}

class cust {
    private box mybox;

    cust(box b) {
        this.mybox = b;
    }

    public apple get() {
        return mybox.get();
    }
}
