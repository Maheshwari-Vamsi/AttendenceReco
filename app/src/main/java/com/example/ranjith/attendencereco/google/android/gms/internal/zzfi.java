package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@zzha
public final class zzfi<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  extends zzex.zza
{
  private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzBO;
  private final NETWORK_EXTRAS zzBP;
  
  public zzfi(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> paramMediationAdapter, NETWORK_EXTRAS paramNETWORK_EXTRAS)
  {
    this.zzBO = paramMediationAdapter;
    this.zzBP = paramNETWORK_EXTRAS;
  }
  
  private SERVER_PARAMETERS zzb(String paramString1, int paramInt, String paramString2)
    throws RemoteException
  {
    HashMap localHashMap;
    if (paramString1 != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString1);
        localHashMap = new HashMap(localJSONObject.length());
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, localJSONObject.getString(str));
          continue;
          localHashMap = new HashMap(0);
        }
      }
      catch (Throwable localThrowable)
      {
        zzb.zzd("Could not get MediationServerParameters.", localThrowable);
        throw new RemoteException();
      }
    }
    Class localClass = this.zzBO.getServerParametersType();
    MediationServerParameters localMediationServerParameters = null;
    if (localClass != null)
    {
      localMediationServerParameters = (MediationServerParameters)localClass.newInstance();
      localMediationServerParameters.load(localHashMap);
    }
    return localMediationServerParameters;
  }
  
  public void destroy()
    throws RemoteException
  {
    try
    {
      this.zzBO.destroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzd("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public Bundle getInterstitialAdapterInfo()
  {
    return new Bundle();
  }
  
  public zzd getView()
    throws RemoteException
  {
    if (!(this.zzBO instanceof MediationBannerAdapter))
    {
      zzb.zzaH("MediationAdapter is not a MediationBannerAdapter: " + this.zzBO.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      zzd localzzd = zze.zzB(((MediationBannerAdapter)this.zzBO).getBannerView());
      return localzzd;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzd("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public boolean isInitialized()
  {
    return true;
  }
  
  public void pause()
    throws RemoteException
  {
    throw new RemoteException();
  }
  
  public void resume()
    throws RemoteException
  {
    throw new RemoteException();
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (!(this.zzBO instanceof MediationInterstitialAdapter))
    {
      zzb.zzaH("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzBO.getClass().getCanonicalName());
      throw new RemoteException();
    }
    zzb.zzaF("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.zzBO).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzd("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showVideo() {}
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, zza paramzza, String paramString2)
    throws RemoteException
  {}
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString, zzey paramzzey)
    throws RemoteException
  {
    zza(paramzzd, paramAdRequestParcel, paramString, null, paramzzey);
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzey paramzzey)
    throws RemoteException
  {
    if (!(this.zzBO instanceof MediationInterstitialAdapter))
    {
      zzb.zzaH("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzBO.getClass().getCanonicalName());
      throw new RemoteException();
    }
    zzb.zzaF("Requesting interstitial ad from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.zzBO).requestInterstitialAd(new zzfj(paramzzey), (Activity)zze.zzp(paramzzd), zzb(paramString1, paramAdRequestParcel.zztu, paramString2), zzfk.zzi(paramAdRequestParcel), this.zzBP);
      return;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzd("Could not request interstitial ad from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzey paramzzey, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList) {}
  
  public void zza(zzd paramzzd, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString, zzey paramzzey)
    throws RemoteException
  {
    zza(paramzzd, paramAdSizeParcel, paramAdRequestParcel, paramString, null, paramzzey);
  }
  
  public void zza(zzd paramzzd, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzey paramzzey)
    throws RemoteException
  {
    if (!(this.zzBO instanceof MediationBannerAdapter))
    {
      zzb.zzaH("MediationAdapter is not a MediationBannerAdapter: " + this.zzBO.getClass().getCanonicalName());
      throw new RemoteException();
    }
    zzb.zzaF("Requesting banner ad from adapter.");
    try
    {
      ((MediationBannerAdapter)this.zzBO).requestBannerAd(new zzfj(paramzzey), (Activity)zze.zzp(paramzzd), zzb(paramString1, paramAdRequestParcel.zztu, paramString2), zzfk.zzb(paramAdSizeParcel), zzfk.zzi(paramAdRequestParcel), this.zzBP);
      return;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzd("Could not request banner ad from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void zzc(AdRequestParcel paramAdRequestParcel, String paramString) {}
  
  public zzfa zzeu()
  {
    return null;
  }
  
  public zzfb zzev()
  {
    return null;
  }
  
  public Bundle zzew()
  {
    return new Bundle();
  }
  
  public Bundle zzex()
  {
    return new Bundle();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzfi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */