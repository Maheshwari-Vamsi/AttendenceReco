package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzbs;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzhc;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zziv;
import com.google.android.gms.internal.zzjg;
import com.google.android.gms.internal.zzjg.zza;
import com.google.android.gms.internal.zzjg.zzc;

@zzha
public abstract class zzd
  implements zzc.zza, zzir<Void>
{
  private final zzjg<AdRequestInfoParcel> zzGi;
  private final zzc.zza zzGj;
  private final Object zzpK = new Object();
  
  public zzd(zzjg<AdRequestInfoParcel> paramzzjg, zzc.zza paramzza)
  {
    this.zzGi = paramzzjg;
    this.zzGj = paramzza;
  }
  
  public void cancel()
  {
    zzge();
  }
  
  boolean zza(zzj paramzzj, AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    try
    {
      paramzzj.zza(paramAdRequestInfoParcel, new zzg(this));
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not fetch ad response from ad request service.", localRemoteException);
      zzp.zzbA().zzb(localRemoteException, true);
      this.zzGj.zzb(new AdResponseParcel(0));
      return false;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", localNullPointerException);
        zzp.zzbA().zzb(localNullPointerException, true);
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", localSecurityException);
        zzp.zzbA().zzb(localSecurityException, true);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", localThrowable);
        zzp.zzbA().zzb(localThrowable, true);
      }
    }
  }
  
  public void zzb(AdResponseParcel paramAdResponseParcel)
  {
    synchronized (this.zzpK)
    {
      this.zzGj.zzb(paramAdResponseParcel);
      zzge();
      return;
    }
  }
  
  public Void zzfO()
  {
    final zzj localzzj = zzgf();
    if (localzzj == null)
    {
      this.zzGj.zzb(new AdResponseParcel(0));
      zzge();
      return null;
    }
    this.zzGi.zza(new zzjg.zzc()new zzjg.zza
    {
      public void zzc(AdRequestInfoParcel paramAnonymousAdRequestInfoParcel)
      {
        if (!zzd.this.zza(localzzj, paramAnonymousAdRequestInfoParcel)) {
          zzd.this.zzge();
        }
      }
    }, new zzjg.zza()
    {
      public void run()
      {
        zzd.this.zzge();
      }
    });
    return null;
  }
  
  public abstract void zzge();
  
  public abstract zzj zzgf();
  
  @zzha
  public static final class zza
    extends zzd
  {
    private final Context mContext;
    
    public zza(Context paramContext, zzjg<AdRequestInfoParcel> paramzzjg, zzc.zza paramzza)
    {
      super(paramzza);
      this.mContext = paramContext;
    }
    
    public void zzge() {}
    
    public zzj zzgf()
    {
      zzbs localzzbs = new zzbs((String)zzbz.zzvg.get());
      return zzhc.zza(this.mContext, localzzbs, zzhb.zzgn());
    }
  }
  
  @zzha
  public static class zzb
    extends zzd
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private Context mContext;
    private zzjg<AdRequestInfoParcel> zzGi;
    private final zzc.zza zzGj;
    protected zze zzGm;
    private boolean zzGn;
    private VersionInfoParcel zzpI;
    private final Object zzpK = new Object();
    
    public zzb(Context paramContext, VersionInfoParcel paramVersionInfoParcel, zzjg<AdRequestInfoParcel> paramzzjg, zzc.zza paramzza)
    {
      super(paramzza);
      this.mContext = paramContext;
      this.zzpI = paramVersionInfoParcel;
      this.zzGi = paramzzjg;
      this.zzGj = paramzza;
      if (((Boolean)zzbz.zzvF.get()).booleanValue()) {
        this.zzGn = true;
      }
      for (Looper localLooper = zzp.zzbJ().zzhk();; localLooper = paramContext.getMainLooper())
      {
        this.zzGm = new zze(paramContext, localLooper, this, this, this.zzpI.zzLG);
        connect();
        return;
      }
    }
    
    protected void connect()
    {
      this.zzGm.zzqp();
    }
    
    public void onConnected(Bundle paramBundle)
    {
      zzfO();
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      zzb.zzaF("Cannot connect to remote service, fallback to local instance.");
      zzgg().zzfR();
      Bundle localBundle = new Bundle();
      localBundle.putString("action", "gms_connection_failed_fallback_to_local");
      zzp.zzbx().zzb(this.mContext, this.zzpI.afmaVersion, "gmob-apps", localBundle, true);
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      zzb.zzaF("Disconnected from remote ad request service.");
    }
    
    public void zzge()
    {
      synchronized (this.zzpK)
      {
        if ((this.zzGm.isConnected()) || (this.zzGm.isConnecting())) {
          this.zzGm.disconnect();
        }
        Binder.flushPendingCommands();
        if (this.zzGn)
        {
          zzp.zzbJ().zzhl();
          this.zzGn = false;
        }
        return;
      }
    }
    
    /* Error */
    public zzj zzgf()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 36	com/google/android/gms/ads/internal/request/zzd$zzb:zzpK	Ljava/lang/Object;
      //   4: astore_1
      //   5: aload_1
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 89	com/google/android/gms/ads/internal/request/zzd$zzb:zzGm	Lcom/google/android/gms/ads/internal/request/zze;
      //   11: invokevirtual 184	com/google/android/gms/ads/internal/request/zze:zzgj	()Lcom/google/android/gms/ads/internal/request/zzj;
      //   14: astore 5
      //   16: aload_1
      //   17: monitorexit
      //   18: aload 5
      //   20: areturn
      //   21: aload_1
      //   22: monitorexit
      //   23: aconst_null
      //   24: areturn
      //   25: astore_3
      //   26: aload_1
      //   27: monitorexit
      //   28: aload_3
      //   29: athrow
      //   30: astore_2
      //   31: goto -10 -> 21
      //   34: astore 4
      //   36: goto -15 -> 21
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	39	0	this	zzb
      //   30	1	2	localDeadObjectException	android.os.DeadObjectException
      //   25	4	3	localObject2	Object
      //   34	1	4	localIllegalStateException	IllegalStateException
      //   14	5	5	localzzj	zzj
      // Exception table:
      //   from	to	target	type
      //   7	16	25	finally
      //   16	18	25	finally
      //   21	23	25	finally
      //   26	28	25	finally
      //   7	16	30	android/os/DeadObjectException
      //   7	16	34	java/lang/IllegalStateException
    }
    
    zzir zzgg()
    {
      return new zzd.zza(this.mContext, this.zzGi, this.zzGj);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\request\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */