package ChainOfResponsibility.protolRouter;

public class WebImple extends RouterExecuterInter {
    @Override
    public void handleRequest(String protol) {
        if (checkProtol(protol) && protol.startsWith("weburl")) {
            jump(protol);
        } else {
            goNext(protol);
        }
    }

    @Override
    public void jump(String protol) {
        //打开WebView的Activity之类的
    }
}
