package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

@zzha
public final class zzgi
  extends zzg<zzge>
{
  private static final zzgi zzEZ = new zzgi();
  
  private zzgi()
  {
    super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
  }
  
  private static boolean zzc(Activity paramActivity)
    throws zzgi.zza
  {
    Intent localIntent = paramActivity.getIntent();
    if (!localIntent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
      throw new zza("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }
    return localIntent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
  }
  
  public static zzgd zze(Activity paramActivity)
  {
    try
    {
      if (zzc(paramActivity))
      {
        zzb.zzaF("Using AdOverlay from the client jar.");
        return new com.google.android.gms.ads.internal.purchase.zze(paramActivity);
      }
      zzgd localzzgd = zzEZ.zzf(paramActivity);
      return localzzgd;
    }
    catch (zza localzza)
    {
      zzb.zzaH(localzza.getMessage());
    }
    return null;
  }
  
  private zzgd zzf(Activity paramActivity)
  {
    try
    {
      zzd localzzd = com.google.android.gms.dynamic.zze.zzB(paramActivity);
      zzgd localzzgd = zzgd.zza.zzQ(((zzge)zzaA(paramActivity)).zzf(localzzd));
      return localzzgd;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not create remote InAppPurchaseManager.", localRemoteException);
      return null;
    }
    catch (zzg.zza localzza)
    {
      zzb.zzd("Could not create remote InAppPurchaseManager.", localzza);
    }
    return null;
  }
  
  protected zzge zzU(IBinder paramIBinder)
  {
    return zzge.zza.zzR(paramIBinder);
  }
  
  private static final class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzgi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */