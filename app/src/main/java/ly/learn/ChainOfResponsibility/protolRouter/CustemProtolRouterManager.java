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

    public CustemProtolRouterManager addActivityImpl(Context context) {
        RouterExecuterInter impl = new ActivityImpl(context);
        this.current.setNext(impl);
        this.current = impl;
        return this;
    }

    public CustemProtolRouterManager addWebImpl(Context context) {
        RouterExecuterInter impl = new WebImpl(context);
        this.current.setNext(impl);
        this.current = impl;
        return this;
    }

    public void start(String protol) {
        this.first.route(protol);
    }

}
