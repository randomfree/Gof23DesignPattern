package ChainOfResponsibility.simple;

public class ExecuterImpl2 extends ExecuterInter<RequestInter> {

    @Override
    public void handleRequest(RequestInter requestInter) {
        if (requestInter.num >= 10) {
            execute(requestInter);
        }
    }

    @Override
    public void execute(RequestInter requestInter) {
        System.out.println(this.getClass().getSimpleName()+" get this request");
    }
}
