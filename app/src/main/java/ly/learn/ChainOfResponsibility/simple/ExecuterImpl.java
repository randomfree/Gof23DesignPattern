package ly.learn.ChainOfResponsibility.simple;

public class ExecuterImpl extends ExecuterInter<RequestInter> {

    @Override
    public void handleRequest(RequestInter requestInter) {
        if (requestInter.num < 10) {
            execute(requestInter);
        } else {
            ExecuterInter<RequestInter> next = getNext();
            if (next != null) {
                next.handleRequest(requestInter);
            }
        }
    }

    @Override
    public void execute(RequestInter requestInter) {
        System.out.println(this.getClass().getSimpleName() + " get this request");
    }
}
