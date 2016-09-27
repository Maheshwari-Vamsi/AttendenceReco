package com.google.android.gms.ads.internal.overlay;

import android.os.Handler;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;

@zzha
class zzq
  implements Runnable
{
  private boolean mCancelled = false;
  private zzk zzEn;
  
  zzq(zzk paramzzk)
  {
    this.zzEn = paramzzk;
  }
  
  public void cancel()
  {
    this.mCancelled = true;
    zzip.zzKO.removeCallbacks(this);
  }
  
  public void run()
  {
    if (!this.mCancelled)
    {
      this.zzEn.zzfu();
      zzfD();
    }
  }
  
  public void zzfD()
  {
    zzip.zzKO.postDelayed(this, 250L);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\overlay\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */