package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzha;

@zzha
public class zze
  extends zzg<zzt>
{
  public zze()
  {
    super("com.google.android.gms.ads.AdManagerCreatorImpl");
  }
  
  private zzs zza(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzev paramzzev, int paramInt)
  {
    try
    {
      com.google.android.gms.dynamic.zzd localzzd = com.google.android.gms.dynamic.zze.zzB(paramContext);
      zzs localzzs = zzs.zza.zzk(((zzt)zzaA(paramContext)).zza(localzzd, paramAdSizeParcel, paramString, paramzzev, 8298000, paramInt));
      return localzzs;
    }
    catch (zzg.zza localzza)
    {
      zzb.zza("Could not create remote AdManager.", localzza);
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  public zzs zza(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzev paramzzev)
  {
    Object localObject;
    if (zzl.zzcN().zzT(paramContext))
    {
      localObject = zza(paramContext, paramAdSizeParcel, paramString, paramzzev, 1);
      if (localObject != null) {}
    }
    else
    {
      zzb.zzaF("Using BannerAdManager from the client jar.");
      localObject = new zzf(paramContext, paramAdSizeParcel, paramString, paramzzev, new VersionInfoParcel(8298000, 8298000, true), com.google.android.gms.ads.internal.zzd.zzbf());
    }
    return (zzs)localObject;
  }
  
  public zzs zzb(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzev paramzzev)
  {
    Object localObject;
    VersionInfoParcel localVersionInfoParcel;
    if (zzl.zzcN().zzT(paramContext))
    {
      localObject = zza(paramContext, paramAdSizeParcel, paramString, paramzzev, 2);
      if (localObject != null) {}
    }
    else
    {
      zzb.zzaH("Using InterstitialAdManager from the client jar.");
      localVersionInfoParcel = new VersionInfoParcel(8298000, 8298000, true);
      if (!((Boolean)zzbz.zzwj.get()).booleanValue()) {
        break label82;
      }
      localObject = new zzeg(paramContext, paramString, paramzzev, localVersionInfoParcel, com.google.android.gms.ads.internal.zzd.zzbf());
    }
    return (zzs)localObject;
    label82:
    return new zzk(paramContext, paramAdSizeParcel, paramString, paramzzev, localVersionInfoParcel, com.google.android.gms.ads.internal.zzd.zzbf());
  }
  
  protected zzt zze(IBinder paramIBinder)
  {
    return zzt.zza.zzl(paramIBinder);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\client\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */