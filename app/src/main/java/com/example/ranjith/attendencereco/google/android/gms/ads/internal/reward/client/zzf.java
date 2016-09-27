package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhr;

@zzha
public class zzf
  extends zzg<zzc>
{
  public zzf()
  {
    super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
  }
  
  private zzb zzb(Context paramContext, zzev paramzzev)
  {
    try
    {
      zzd localzzd = zze.zzB(paramContext);
      zzb localzzb = zzb.zza.zzaa(((zzc)zzaA(paramContext)).zza(localzzd, paramzzev, 8298000));
      return localzzb;
    }
    catch (zzg.zza localzza)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get remote RewardedVideoAd.", localzza);
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  public zzb zza(Context paramContext, zzev paramzzev)
  {
    Object localObject;
    if (zzl.zzcN().zzT(paramContext))
    {
      localObject = zzb(paramContext, paramzzev);
      if (localObject != null) {}
    }
    else
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaF("Using RewardedVideoAd from the client jar.");
      localObject = new zzhr(paramContext, paramzzev, new VersionInfoParcel(8298000, 8298000, true));
    }
    return (zzb)localObject;
  }
  
  protected zzc zzad(IBinder paramIBinder)
  {
    return zzc.zza.zzab(paramIBinder);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\reward\client\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */