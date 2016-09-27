package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zznx;

public abstract class zzj
{
  public abstract zzi zza(Context paramContext, zzjn paramzzjn, int paramInt, zzch paramzzch, zzcf paramzzcf);
  
  protected boolean zzx(Context paramContext)
  {
    ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
    return (zznx.zzrQ()) && ((localApplicationInfo == null) || (localApplicationInfo.targetSdkVersion >= 11));
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\overlay\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */