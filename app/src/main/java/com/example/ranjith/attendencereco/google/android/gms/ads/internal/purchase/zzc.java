package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@zzha
public class zzc
  extends zzil
  implements ServiceConnection
{
  private Context mContext;
  private zzgg zzAe;
  private boolean zzEA = false;
  private zzb zzEB;
  private zzh zzEC;
  private List<zzf> zzED = null;
  private zzk zzEE;
  private final Object zzpK = new Object();
  
  public zzc(Context paramContext, zzgg paramzzgg, zzk paramzzk)
  {
    this(paramContext, paramzzgg, paramzzk, new zzb(paramContext), zzh.zzy(paramContext.getApplicationContext()));
  }
  
  zzc(Context paramContext, zzgg paramzzgg, zzk paramzzk, zzb paramzzb, zzh paramzzh)
  {
    this.mContext = paramContext;
    this.zzAe = paramzzgg;
    this.zzEE = paramzzk;
    this.zzEB = paramzzb;
    this.zzEC = paramzzh;
    this.zzED = this.zzEC.zzg(10L);
  }
  
  private void zze(long paramLong)
  {
    do
    {
      if (!zzf(paramLong)) {
        com.google.android.gms.ads.internal.util.client.zzb.v("Timeout waiting for pending transaction to be processed.");
      }
    } while (!this.zzEA);
  }
  
  private boolean zzf(long paramLong)
  {
    long l = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    if (l <= 0L) {
      return false;
    }
    try
    {
      this.zzpK.wait(l);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("waitWithTimeout_lock interrupted");
      }
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (this.zzpK)
    {
      this.zzEB.zzN(paramIBinder);
      zzfJ();
      this.zzEA = true;
      this.zzpK.notify();
      return;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaG("In-app billing service disconnected.");
    this.zzEB.destroy();
  }
  
  public void onStop()
  {
    synchronized (this.zzpK)
    {
      com.google.android.gms.common.stats.zzb.zzrz().zza(this.mContext, this);
      this.zzEB.destroy();
      return;
    }
  }
  
  protected void zza(final zzf paramzzf, String paramString1, String paramString2)
  {
    final Intent localIntent = new Intent();
    zzp.zzbH();
    localIntent.putExtra("RESPONSE_CODE", 0);
    zzp.zzbH();
    localIntent.putExtra("INAPP_PURCHASE_DATA", paramString1);
    zzp.zzbH();
    localIntent.putExtra("INAPP_DATA_SIGNATURE", paramString2);
    zzip.zzKO.post(new Runnable()
    {
      public void run()
      {
        try
        {
          if (zzc.zza(zzc.this).zza(paramzzf.zzEP, -1, localIntent))
          {
            zzc.zzc(zzc.this).zza(new zzg(zzc.zzb(zzc.this), paramzzf.zzEQ, true, -1, localIntent, paramzzf));
            return;
          }
          zzc.zzc(zzc.this).zza(new zzg(zzc.zzb(zzc.this), paramzzf.zzEQ, false, -1, localIntent, paramzzf));
          return;
        }
        catch (RemoteException localRemoteException)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to verify and dispatch pending transaction");
        }
      }
    });
  }
  
  public void zzbp()
  {
    synchronized (this.zzpK)
    {
      Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      localIntent.setPackage("com.android.vending");
      com.google.android.gms.common.stats.zzb.zzrz().zza(this.mContext, localIntent, this, 1);
      zze(SystemClock.elapsedRealtime());
      com.google.android.gms.common.stats.zzb.zzrz().zza(this.mContext, this);
      this.zzEB.destroy();
      return;
    }
  }
  
  protected void zzfJ()
  {
    if (this.zzED.isEmpty()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.zzED.iterator();
    while (localIterator1.hasNext())
    {
      zzf localzzf2 = (zzf)localIterator1.next();
      localHashMap.put(localzzf2.zzEQ, localzzf2);
    }
    String str1;
    for (Object localObject = null;; localObject = str1)
    {
      Bundle localBundle = this.zzEB.zzi(this.mContext.getPackageName(), (String)localObject);
      if (localBundle == null) {}
      do
      {
        do
        {
          Iterator localIterator2 = localHashMap.keySet().iterator();
          while (localIterator2.hasNext())
          {
            String str2 = (String)localIterator2.next();
            this.zzEC.zza((zzf)localHashMap.get(str2));
          }
          break;
        } while (zzp.zzbH().zzd(localBundle) != 0);
        ArrayList localArrayList1 = localBundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList localArrayList2 = localBundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList localArrayList3 = localBundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        str1 = localBundle.getString("INAPP_CONTINUATION_TOKEN");
        for (int i = 0; i < localArrayList1.size(); i++) {
          if (localHashMap.containsKey(localArrayList1.get(i)))
          {
            String str3 = (String)localArrayList1.get(i);
            String str4 = (String)localArrayList2.get(i);
            String str5 = (String)localArrayList3.get(i);
            zzf localzzf1 = (zzf)localHashMap.get(str3);
            String str6 = zzp.zzbH().zzap(str4);
            if (localzzf1.zzEP.equals(str6))
            {
              zza(localzzf1, str4, str5);
              localHashMap.remove(str3);
            }
          }
        }
      } while ((str1 == null) || (localHashMap.isEmpty()));
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\purchase\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */