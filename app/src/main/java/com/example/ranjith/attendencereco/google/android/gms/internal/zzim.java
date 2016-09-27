package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzp;

@zzha
public class zzim
  extends Handler
{
  public zzim(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      super.handleMessage(paramMessage);
      return;
    }
    catch (Exception localException)
    {
      zzp.zzbA().zzb(localException, false);
      throw localException;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */