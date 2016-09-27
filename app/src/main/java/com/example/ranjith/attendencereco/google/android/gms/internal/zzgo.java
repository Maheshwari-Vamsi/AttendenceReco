package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzha
public class zzgo
  extends zzgm
{
  private zzgn zzFr;
  
  zzgo(Context paramContext, zzie.zza paramzza, zzjn paramzzjn, zzgq.zza paramzza1)
  {
    super(paramContext, paramzza, paramzzjn, paramzza1);
  }
  
  protected void zzfP()
  {
    AdSizeParcel localAdSizeParcel = this.zzps.zzaP();
    DisplayMetrics localDisplayMetrics;
    int i;
    if (localAdSizeParcel.zztW)
    {
      localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      i = localDisplayMetrics.widthPixels;
    }
    for (int j = localDisplayMetrics.heightPixels;; j = localAdSizeParcel.heightPixels)
    {
      this.zzFr = new zzgn(this, this.zzps, i, j);
      this.zzps.zzhC().zza(this);
      this.zzFr.zza(this.zzFd);
      return;
      i = localAdSizeParcel.widthPixels;
    }
  }
  
  protected int zzfQ()
  {
    if (this.zzFr.zzfU())
    {
      zzb.zzaF("Ad-Network indicated no fill with passback URL.");
      return 3;
    }
    if (!this.zzFr.zzfV()) {
      return 2;
    }
    return -2;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzgo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */