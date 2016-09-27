package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender.SendIntentException;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;

public abstract class ResolvingResultCallbacks<R extends Result>
  extends ResultCallbacks<R>
{
  private final Activity mActivity;
  private final int zzaeU;
  
  protected ResolvingResultCallbacks(Activity paramActivity, int paramInt)
  {
    this.mActivity = ((Activity)zzx.zzb(paramActivity, "Activity must not be null"));
    this.zzaeU = paramInt;
  }
  
  public final void onFailure(Status paramStatus)
  {
    if (paramStatus.hasResolution()) {
      try
      {
        paramStatus.startResolutionForResult(this.mActivity, this.zzaeU);
        return;
      }
      catch (IntentSender.SendIntentException localSendIntentException)
      {
        Log.e("ResolvingResultCallback", "Failed to start resolution", localSendIntentException);
        onUnresolvableFailure(new Status(8));
        return;
      }
    }
    onUnresolvableFailure(paramStatus);
  }
  
  public abstract void onSuccess(R paramR);
  
  public abstract void onUnresolvableFailure(Status paramStatus);
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\api\ResolvingResultCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */