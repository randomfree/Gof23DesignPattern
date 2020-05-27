package ly.learn.ChainOfResponsibility.protolRouter;

import android.util.Log;

import java.util.logging.Logger;

public abstract class RouterExecuterInter {
    private RouterExecuterInter next;

    protected abstract boolean handleRequest(String protol);

    public void route(String protol) {
        if (!handleRequest(protol)) {
            goNext(protol);
        }
    }

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
            next.route(protol);
        } else {
            Log.i(CustemProtolRouterManager.TAG, "protol " + protol + " not match");
        }
    }
}
