package ly.learn.ChainOfResponsibility.protolRouter;

import android.content.Context;
import android.util.Log;

public class WebImpl extends RouterExecuterInter {

    /**
     * start activity need this
     */
    private Context context;

    public WebImpl(Context context) {
        this.context = context;
    }

    @Override
    public boolean handleRequest(String protol) {
        Log.i(CustemProtolRouterManager.TAG,"web impl get this protol:" + protol);
        if (checkProtol(protol) && protol.startsWith("web")) {
            goWebActivity(protol);
            return true;
        }
        return false;
    }

    public void goWebActivity(String protol) {
        //打开WebView的Activity之类的
        Log.i(CustemProtolRouterManager.TAG,"web impl consume this protol:" + protol);
    }
}
