package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzbe;
import com.google.android.gms.internal.zzbs;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzdl;
import com.google.android.gms.internal.zzdm;
import com.google.android.gms.internal.zzdq;
import com.google.android.gms.internal.zzei;
import com.google.android.gms.internal.zzei.zzb;
import com.google.android.gms.internal.zzei.zzd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhd;
import com.google.android.gms.internal.zzhj;
import com.google.android.gms.internal.zzie.zza;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzjg.zza;
import com.google.android.gms.internal.zzjg.zzc;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zznl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzm
  extends zzil
{
  static final long zzHl = TimeUnit.SECONDS.toMillis(10L);
  private static boolean zzHm = false;
  private static zzei zzHn = null;
  private static zzdm zzHo = null;
  private static zzdq zzHp = null;
  private static zzdl zzHq = null;
  private static final Object zzqf = new Object();
  private final Context mContext;
  private final Object zzFf = new Object();
  private final zza.zza zzGd;
  private final AdRequestInfoParcel.zza zzGe;
  private zzei.zzd zzHr;
  
  public zzm(Context paramContext, AdRequestInfoParcel.zza paramzza, zza.zza paramzza1)
  {
    super(true);
    this.zzGd = paramzza1;
    this.mContext = paramContext;
    this.zzGe = paramzza;
    synchronized (zzqf)
    {
      if (!zzHm)
      {
        zzHp = new zzdq();
        zzHo = new zzdm(paramContext.getApplicationContext(), paramzza.zzqR);
        zzHq = new zzc();
        zzHn = new zzei(this.mContext.getApplicationContext(), this.zzGe.zzqR, (String)zzbz.zzvg.get(), new zzb(), new zza());
        zzHm = true;
      }
      return;
    }
  }
  
  private JSONObject zza(AdRequestInfoParcel paramAdRequestInfoParcel, String paramString)
  {
    Bundle localBundle = paramAdRequestInfoParcel.zzGq.extras.getBundle("sdk_less_server_data");
    String str = paramAdRequestInfoParcel.zzGq.extras.getString("sdk_less_network_id");
    if (localBundle == null) {}
    JSONObject localJSONObject1;
    do
    {
      return null;
      localJSONObject1 = zzhd.zza(this.mContext, paramAdRequestInfoParcel, zzp.zzbD().zzE(this.mContext), null, null, new zzbs((String)zzbz.zzvg.get()), null, null, new ArrayList(), null);
    } while (localJSONObject1 == null);
    try
    {
      AdvertisingIdClient.Info localInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
      localInfo1 = localInfo2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          HashMap localHashMap;
          JSONObject localJSONObject2 = zzp.zzbx().zzz(localHashMap);
          return localJSONObject2;
        }
        catch (JSONException localJSONException)
        {
          AdvertisingIdClient.Info localInfo1;
          int i;
          return null;
        }
        localIOException = localIOException;
        zzb.zzd("Cannot get advertising id info", localIOException);
        localInfo1 = null;
        continue;
        i = 0;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      for (;;) {}
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      for (;;) {}
    }
    localHashMap = new HashMap();
    localHashMap.put("request_id", paramString);
    localHashMap.put("network_id", str);
    localHashMap.put("request_param", localJSONObject1);
    localHashMap.put("data", localBundle);
    if (localInfo1 != null)
    {
      localHashMap.put("adid", localInfo1.getId());
      if (!localInfo1.isLimitAdTrackingEnabled()) {
        break label216;
      }
      i = 1;
      localHashMap.put("lat", Integer.valueOf(i));
    }
  }
  
  protected static void zzc(zzbb paramzzbb)
  {
    paramzzbb.zza("/loadAd", zzHp);
    paramzzbb.zza("/fetchHttpRequest", zzHo);
    paramzzbb.zza("/invalidRequest", zzHq);
  }
  
  protected static void zzd(zzbb paramzzbb)
  {
    paramzzbb.zzb("/loadAd", zzHp);
    paramzzbb.zzb("/fetchHttpRequest", zzHo);
    paramzzbb.zzb("/invalidRequest", zzHq);
  }
  
  private AdResponseParcel zze(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    final String str = UUID.randomUUID().toString();
    final JSONObject localJSONObject1 = zza(paramAdRequestInfoParcel, str);
    AdResponseParcel localAdResponseParcel;
    if (localJSONObject1 == null) {
      localAdResponseParcel = new AdResponseParcel(0);
    }
    for (;;)
    {
      return localAdResponseParcel;
      long l1 = zzp.zzbB().elapsedRealtime();
      Future localFuture = zzHp.zzW(str);
      zza.zzLE.post(new Runnable()
      {
        public void run()
        {
          zzm.zza(zzm.this, zzm.zzgl().zzei());
          zzm.zzb(zzm.this).zza(new zzjg.zzc()new zzjg.zza
          {
            public void zzb(zzbe paramAnonymous2zzbe)
            {
              try
              {
                paramAnonymous2zzbe.zza("AFMA_getAdapterLessMediationAd", zzm.2.this.zzHt);
                return;
              }
              catch (Exception localException)
              {
                zzb.zzb("Error requesting an ad url", localException);
                zzm.zzgk().zzX(zzm.2.this.zzHu);
              }
            }
          }, new zzjg.zza()
          {
            public void run()
            {
              zzm.zzgk().zzX(zzm.2.this.zzHu);
            }
          });
        }
      });
      long l2 = zzHl - (zzp.zzbB().elapsedRealtime() - l1);
      try
      {
        localJSONObject2 = (JSONObject)localFuture.get(l2, TimeUnit.MILLISECONDS);
        if (localJSONObject2 == null) {
          return new AdResponseParcel(-1);
        }
      }
      catch (CancellationException localCancellationException)
      {
        return new AdResponseParcel(-1);
      }
      catch (TimeoutException localTimeoutException)
      {
        return new AdResponseParcel(2);
      }
      catch (ExecutionException localExecutionException)
      {
        JSONObject localJSONObject2;
        return new AdResponseParcel(0);
        localAdResponseParcel = zzhd.zza(this.mContext, paramAdRequestInfoParcel, localJSONObject2.toString());
        if ((localAdResponseParcel.errorCode == -3) || (!TextUtils.isEmpty(localAdResponseParcel.body))) {
          continue;
        }
        return new AdResponseParcel(3);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  }
  
  public void onStop()
  {
    synchronized (this.zzFf)
    {
      zza.zzLE.post(new Runnable()
      {
        public void run()
        {
          if (zzm.zzb(zzm.this) != null)
          {
            zzm.zzb(zzm.this).release();
            zzm.zza(zzm.this, null);
          }
        }
      });
      return;
    }
  }
  
  public void zzbp()
  {
    zzb.zzaF("SdkLessAdLoaderBackgroundTask started.");
    AdRequestInfoParcel localAdRequestInfoParcel = new AdRequestInfoParcel(this.zzGe, null, -1L);
    AdResponseParcel localAdResponseParcel = zze(localAdRequestInfoParcel);
    long l = zzp.zzbB().elapsedRealtime();
    final zzie.zza localzza = new zzie.zza(localAdRequestInfoParcel, localAdResponseParcel, null, null, localAdResponseParcel.errorCode, l, localAdResponseParcel.zzGR, null);
    zza.zzLE.post(new Runnable()
    {
      public void run()
      {
        zzm.zza(zzm.this).zza(localzza);
        if (zzm.zzb(zzm.this) != null)
        {
          zzm.zzb(zzm.this).release();
          zzm.zza(zzm.this, null);
        }
      }
    });
  }
  
  public static class zza
    implements zzei.zzb<zzbb>
  {
    public void zza(zzbb paramzzbb)
    {
      zzm.zzd(paramzzbb);
    }
  }
  
  public static class zzb
    implements zzei.zzb<zzbb>
  {
    public void zza(zzbb paramzzbb)
    {
      zzm.zzc(paramzzbb);
    }
  }
  
  public static class zzc
    implements zzdl
  {
    public void zza(zzjn paramzzjn, Map<String, String> paramMap)
    {
      String str1 = (String)paramMap.get("request_id");
      String str2 = (String)paramMap.get("errors");
      zzb.zzaH("Invalid request: " + str2);
      zzm.zzgk().zzX(str1);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\request\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */