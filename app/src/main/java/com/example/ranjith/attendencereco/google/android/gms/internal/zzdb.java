package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.formats.zzj;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

@zzha
public class zzdb
  extends zzg<zzcq>
{
  public zzdb()
  {
    super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
  }
  
  private zzcp zzb(Context paramContext, FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2)
  {
    try
    {
      zzd localzzd1 = zze.zzB(paramContext);
      zzd localzzd2 = zze.zzB(paramFrameLayout1);
      zzd localzzd3 = zze.zzB(paramFrameLayout2);
      zzcp localzzcp = zzcp.zza.zzu(((zzcq)zzaA(paramContext)).zza(localzzd1, localzzd2, localzzd3, 8298000));
      return localzzcp;
    }
    catch (zzg.zza localzza)
    {
      zzb.zzd("Could not create remote NativeAdViewDelegate.", localzza);
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  protected zzcq zzD(IBinder paramIBinder)
  {
    return zzcq.zza.zzv(paramIBinder);
  }
  
  public zzcp zza(Context paramContext, FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2)
  {
    Object localObject;
    if (zzl.zzcN().zzT(paramContext))
    {
      localObject = zzb(paramContext, paramFrameLayout1, paramFrameLayout2);
      if (localObject != null) {}
    }
    else
    {
      zzb.zzaF("Using NativeAdViewDelegate from the client jar.");
      localObject = new zzj(paramFrameLayout1, paramFrameLayout2);
    }
    return (zzcp)localObject;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzdb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */