package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.client.zzf;
import com.google.android.gms.ads.internal.reward.client.zzi;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzha;

@zzha
public class zzab
{
  private static final Object zzqf = new Object();
  private static zzab zzuF;
  private zzw zzuG;
  private RewardedVideoAd zzuH;
  
  public static zzab zzdc()
  {
    synchronized (zzqf)
    {
      if (zzuF == null) {
        zzuF = new zzab();
      }
      zzab localzzab = zzuF;
      return localzzab;
    }
  }
  
  public RewardedVideoAd getRewardedVideoAdInstance(Context paramContext)
  {
    synchronized (zzqf)
    {
      if (this.zzuH != null)
      {
        RewardedVideoAd localRewardedVideoAd2 = this.zzuH;
        return localRewardedVideoAd2;
      }
      zzev localzzev = new zzev();
      this.zzuH = new zzi(paramContext, zzl.zzcR().zza(paramContext, localzzev));
      RewardedVideoAd localRewardedVideoAd1 = this.zzuH;
      return localRewardedVideoAd1;
    }
  }
  
  public void initialize(Context paramContext)
  {
    synchronized (zzqf)
    {
      if (this.zzuG != null) {
        return;
      }
      if (paramContext == null) {
        throw new IllegalArgumentException("Context cannot be null.");
      }
    }
    try
    {
      this.zzuG = zzl.zzcP().zzu(paramContext);
      this.zzuG.zza();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzb.zzaH("Fail to initialize mobile ads setting manager");
      }
    }
  }
  
  public void zza(Context paramContext, String paramString, zzac paramzzac)
  {
    initialize(paramContext);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\client\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */