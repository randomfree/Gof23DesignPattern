package ly.learn.designpattern.ChainOfResponsibility.protolRouter;

import android.content.Context;
import android.util.Log;

public class ActivityImpl extends RouterExecuterInter {

    private Context context;

    public ActivityImpl(Context context) {
        this.context = context;
    }

    @Override
    public boolean handleRequest(String protol) {
        Log.i(CustemProtolRouterManager.TAG,"activity impl get this protol:" + protol);
        if (checkProtol(protol) && protol.startsWith("activity")) {
            goActivity(protol, context);
            return true;
        }
        return false;
    }


    public void goActivity(String protol, Context context) {
        Log.i(CustemProtolRouterManager.TAG,"activity impl consume this protol:" + protol);
    }
}
