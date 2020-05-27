package ly.learn.ChainOfResponsibility.protolRouter;

import android.content.Context;

public class CustemProtolRouterManager {

    public static final String TAG = CustemProtolRouterManager.class.getSimpleName();

    private RouterExecuterInter first;
    private RouterExecuterInter current;

    public CustemProtolRouterManager(RouterExecuterInter first) {
        this.first = first;
        this.current = first;
    }

    public CustemProtolRouterManager addImpl(RouterExecuterInter impl) {
        this.current.setNext(impl);
        this.current = impl;
        return this;
    }


    public void start(String protol) {
        this.first.route(protol);
    }

}
