package ly.learn.ChainOfResponsibility.simple;

public abstract class ExecuterInter<T extends RequestInter>{
    private ExecuterInter next;
    public abstract void handleRequest(T t);
    public abstract void execute(T t);


    public ExecuterInter getNext() {
        return next;
    }

    public void setNext(ExecuterInter next) {
        this.next = next;
    }
}
