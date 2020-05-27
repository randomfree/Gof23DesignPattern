package ly.learn.designpattern.ChainOfResponsibility.simple;

public class Controler {
    public static void main(String[] args) {
        ExecuterImpl executer = new ExecuterImpl();
        ExecuterImpl2 executerImpl2 = new ExecuterImpl2();
        executer.setNext(executerImpl2);
        executer.handleRequest(new RequestInter(1));
        executer.handleRequest(new RequestInter(11));
    }
}
