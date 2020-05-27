package ChainOfResponsibility.protolRouter;

public abstract class RouterExecuterInter {
    private RouterExecuterInter next;

    public abstract void handleRequest(String protol);

    public abstract void jump(String protol);

    public RouterExecuterInter getNext() {
        return next;
    }

    public void setNext(RouterExecuterInter next) {
        this.next = next;
    }

    public boolean checkProtol(String protol) {
        return protol != null && !protol.isEmpty();
    }

    protected void goNext(String protol) {
        if (next != null) {
            next.handleRequest(protol);
        }
    }
}
