package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzha
public final class zzfd
  extends zzex.zza
{
  private final MediationAdapter zzBI;
  private zzfe zzBJ;
  
  public zzfd(MediationAdapter paramMediationAdapter)
  {
    this.zzBI = paramMediationAdapter;
  }
  
  private Bundle zza(String paramString1, int paramInt, String paramString2)
    throws RemoteException
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaH("Server parameters: " + paramString1);
    Object localObject;
    try
    {
      localObject = new Bundle();
      if (paramString1 != null)
      {
        JSONObject localJSONObject = new JSONObject(paramString1);
        Bundle localBundle = new Bundle();
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localBundle.putString(str, localJSONObject.getString(str));
        }
        localObject = localBundle;
      }
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get Server Parameters Bundle.", localThrowable);
      throw new RemoteException();
    }
    if ((this.zzBI instanceof AdMobAdapter))
    {
      ((Bundle)localObject).putString("adJson", paramString2);
      ((Bundle)localObject).putInt("tagForChildDirectedTreatment", paramInt);
    }
    return (Bundle)localObject;
  }
  
  public void destroy()
    throws RemoteException
  {
    try
    {
      this.zzBI.onDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public Bundle getInterstitialAdapterInfo()
  {
    if (!(this.zzBI instanceof zzjy))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a v2 MediationInterstitialAdapter: " + this.zzBI.getClass().getCanonicalName());
      return new Bundle();
    }
    return ((zzjy)this.zzBI).getInterstitialAdapterInfo();
  }
  
  public zzd getView()
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationBannerAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationBannerAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      zzd localzzd = zze.zzB(((MediationBannerAdapter)this.zzBI).getBannerView());
      return localzzd;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public boolean isInitialized()
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationRewardedVideoAdAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Check if adapter is initialized.");
    try
    {
      boolean bool = ((MediationRewardedVideoAdAdapter)this.zzBI).isInitialized();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not check if adapter is initialized.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void pause()
    throws RemoteException
  {
    try
    {
      this.zzBI.onPause();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not pause adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void resume()
    throws RemoteException
  {
    try
    {
      this.zzBI.onResume();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not resume adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationInterstitialAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.zzBI).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showVideo()
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationRewardedVideoAdAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Show rewarded video ad from adapter.");
    try
    {
      ((MediationRewardedVideoAdAdapter)this.zzBI).showVideo();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show rewarded video ad from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, com.google.android.gms.ads.internal.reward.mediation.client.zza paramzza, String paramString2)
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationRewardedVideoAdAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Initialize rewarded video adapter.");
    for (;;)
    {
      try
      {
        MediationRewardedVideoAdAdapter localMediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter)this.zzBI;
        if (paramAdRequestParcel.zzts == null) {
          break label234;
        }
        localHashSet = new HashSet(paramAdRequestParcel.zzts);
        Date localDate;
        if (paramAdRequestParcel.zztq == -1L)
        {
          localDate = null;
          zzfc localzzfc = new zzfc(localDate, paramAdRequestParcel.zztr, localHashSet, paramAdRequestParcel.zzty, paramAdRequestParcel.zztt, paramAdRequestParcel.zztu, paramAdRequestParcel.zztF);
          if (paramAdRequestParcel.zztA != null)
          {
            localBundle = paramAdRequestParcel.zztA.getBundle(localMediationRewardedVideoAdAdapter.getClass().getName());
            localMediationRewardedVideoAdAdapter.initialize((Context)zze.zzp(paramzzd), localzzfc, paramString1, new com.google.android.gms.ads.internal.reward.mediation.client.zzb(paramzza), zza(paramString2, paramAdRequestParcel.zztu, null), localBundle);
          }
        }
        else
        {
          localDate = new Date(paramAdRequestParcel.zztq);
          continue;
        }
        Bundle localBundle = null;
      }
      catch (Throwable localThrowable)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not initialize rewarded video adapter.", localThrowable);
        throw new RemoteException();
      }
      continue;
      label234:
      HashSet localHashSet = null;
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString, zzey paramzzey)
    throws RemoteException
  {
    zza(paramzzd, paramAdRequestParcel, paramString, null, paramzzey);
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzey paramzzey)
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationInterstitialAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Requesting interstitial ad from adapter.");
    for (;;)
    {
      try
      {
        MediationInterstitialAdapter localMediationInterstitialAdapter = (MediationInterstitialAdapter)this.zzBI;
        if (paramAdRequestParcel.zzts == null) {
          break label234;
        }
        localHashSet = new HashSet(paramAdRequestParcel.zzts);
        Date localDate;
        if (paramAdRequestParcel.zztq == -1L)
        {
          localDate = null;
          zzfc localzzfc = new zzfc(localDate, paramAdRequestParcel.zztr, localHashSet, paramAdRequestParcel.zzty, paramAdRequestParcel.zztt, paramAdRequestParcel.zztu, paramAdRequestParcel.zztF);
          if (paramAdRequestParcel.zztA != null)
          {
            localBundle = paramAdRequestParcel.zztA.getBundle(localMediationInterstitialAdapter.getClass().getName());
            localMediationInterstitialAdapter.requestInterstitialAd((Context)zze.zzp(paramzzd), new zzfe(paramzzey), zza(paramString1, paramAdRequestParcel.zztu, paramString2), localzzfc, localBundle);
          }
        }
        else
        {
          localDate = new Date(paramAdRequestParcel.zztq);
          continue;
        }
        Bundle localBundle = null;
      }
      catch (Throwable localThrowable)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request interstitial ad from adapter.", localThrowable);
        throw new RemoteException();
      }
      continue;
      label234:
      HashSet localHashSet = null;
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzey paramzzey, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList)
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationNativeAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationNativeAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    for (;;)
    {
      try
      {
        MediationNativeAdapter localMediationNativeAdapter = (MediationNativeAdapter)this.zzBI;
        if (paramAdRequestParcel.zzts == null) {
          break label241;
        }
        localHashSet = new HashSet(paramAdRequestParcel.zzts);
        Date localDate;
        if (paramAdRequestParcel.zztq == -1L)
        {
          localDate = null;
          zzfh localzzfh = new zzfh(localDate, paramAdRequestParcel.zztr, localHashSet, paramAdRequestParcel.zzty, paramAdRequestParcel.zztt, paramAdRequestParcel.zztu, paramNativeAdOptionsParcel, paramList, paramAdRequestParcel.zztF);
          if (paramAdRequestParcel.zztA != null)
          {
            localBundle = paramAdRequestParcel.zztA.getBundle(localMediationNativeAdapter.getClass().getName());
            this.zzBJ = new zzfe(paramzzey);
            localMediationNativeAdapter.requestNativeAd((Context)zze.zzp(paramzzd), this.zzBJ, zza(paramString1, paramAdRequestParcel.zztu, paramString2), localzzfh, localBundle);
          }
        }
        else
        {
          localDate = new Date(paramAdRequestParcel.zztq);
          continue;
        }
        Bundle localBundle = null;
      }
      catch (Throwable localThrowable)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request interstitial ad from adapter.", localThrowable);
        throw new RemoteException();
      }
      continue;
      label241:
      HashSet localHashSet = null;
    }
  }
  
  public void zza(zzd paramzzd, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString, zzey paramzzey)
    throws RemoteException
  {
    zza(paramzzd, paramAdSizeParcel, paramAdRequestParcel, paramString, null, paramzzey);
  }
  
  public void zza(zzd paramzzd, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzey paramzzey)
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationBannerAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationBannerAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Requesting banner ad from adapter.");
    for (;;)
    {
      try
      {
        MediationBannerAdapter localMediationBannerAdapter = (MediationBannerAdapter)this.zzBI;
        if (paramAdRequestParcel.zzts == null) {
          break label250;
        }
        localHashSet = new HashSet(paramAdRequestParcel.zzts);
        Date localDate;
        if (paramAdRequestParcel.zztq == -1L)
        {
          localDate = null;
          zzfc localzzfc = new zzfc(localDate, paramAdRequestParcel.zztr, localHashSet, paramAdRequestParcel.zzty, paramAdRequestParcel.zztt, paramAdRequestParcel.zztu, paramAdRequestParcel.zztF);
          if (paramAdRequestParcel.zztA != null)
          {
            localBundle = paramAdRequestParcel.zztA.getBundle(localMediationBannerAdapter.getClass().getName());
            localMediationBannerAdapter.requestBannerAd((Context)zze.zzp(paramzzd), new zzfe(paramzzey), zza(paramString1, paramAdRequestParcel.zztu, paramString2), com.google.android.gms.ads.zza.zza(paramAdSizeParcel.width, paramAdSizeParcel.height, paramAdSizeParcel.zztV), localzzfc, localBundle);
          }
        }
        else
        {
          localDate = new Date(paramAdRequestParcel.zztq);
          continue;
        }
        Bundle localBundle = null;
      }
      catch (Throwable localThrowable)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request banner ad from adapter.", localThrowable);
        throw new RemoteException();
      }
      continue;
      label250:
      HashSet localHashSet = null;
    }
  }
  
  public void zzc(AdRequestParcel paramAdRequestParcel, String paramString)
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationRewardedVideoAdAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Requesting rewarded video ad from adapter.");
    for (;;)
    {
      try
      {
        MediationRewardedVideoAdAdapter localMediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter)this.zzBI;
        if (paramAdRequestParcel.zzts == null) {
          break label215;
        }
        localHashSet = new HashSet(paramAdRequestParcel.zzts);
        Date localDate;
        if (paramAdRequestParcel.zztq == -1L)
        {
          localDate = null;
          zzfc localzzfc = new zzfc(localDate, paramAdRequestParcel.zztr, localHashSet, paramAdRequestParcel.zzty, paramAdRequestParcel.zztt, paramAdRequestParcel.zztu, paramAdRequestParcel.zztF);
          if (paramAdRequestParcel.zztA != null)
          {
            localBundle = paramAdRequestParcel.zztA.getBundle(localMediationRewardedVideoAdAdapter.getClass().getName());
            localMediationRewardedVideoAdAdapter.loadAd(localzzfc, zza(paramString, paramAdRequestParcel.zztu, null), localBundle);
          }
        }
        else
        {
          localDate = new Date(paramAdRequestParcel.zztq);
          continue;
        }
        Bundle localBundle = null;
      }
      catch (Throwable localThrowable)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not load rewarded video ad from adapter.", localThrowable);
        throw new RemoteException();
      }
      continue;
      label215:
      HashSet localHashSet = null;
    }
  }
  
  public zzfa zzeu()
  {
    NativeAdMapper localNativeAdMapper = this.zzBJ.zzey();
    if ((localNativeAdMapper instanceof NativeAppInstallAdMapper)) {
      return new zzff((NativeAppInstallAdMapper)localNativeAdMapper);
    }
    return null;
  }
  
  public zzfb zzev()
  {
    NativeAdMapper localNativeAdMapper = this.zzBJ.zzey();
    if ((localNativeAdMapper instanceof NativeContentAdMapper)) {
      return new zzfg((NativeContentAdMapper)localNativeAdMapper);
    }
    return null;
  }
  
  public Bundle zzew()
  {
    if (!(this.zzBI instanceof zzjx))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a v2 MediationBannerAdapter: " + this.zzBI.getClass().getCanonicalName());
      return new Bundle();
    }
    return ((zzjx)this.zzBI).zzew();
  }
  
  public Bundle zzex()
  {
    return new Bundle();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */