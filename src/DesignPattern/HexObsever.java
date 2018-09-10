package DesignPattern;

public class HexObsever extends Observer {
    public HexObsever(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex SimilarString: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
