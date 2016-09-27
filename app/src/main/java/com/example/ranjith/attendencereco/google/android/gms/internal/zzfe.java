package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.common.internal.zzx;

@zzha
public final class zzfe
  implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener
{
  private final zzey zzBK;
  private NativeAdMapper zzBL;
  
  public zzfe(zzey paramzzey)
  {
    this.zzBK = paramzzey;
  }
  
  public void onAdClicked(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzx.zzcx("onAdClicked must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClicked.");
    try
    {
      this.zzBK.onAdClicked();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdClicked.", localRemoteException);
    }
  }
  
  public void onAdClicked(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzx.zzcx("onAdClicked must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClicked.");
    try
    {
      this.zzBK.onAdClicked();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdClicked.", localRemoteException);
    }
  }
  
  public void onAdClicked(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzx.zzcx("onAdClicked must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClicked.");
    try
    {
      this.zzBK.onAdClicked();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdClicked.", localRemoteException);
    }
  }
  
  public void onAdClosed(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzx.zzcx("onAdClosed must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClosed.");
    try
    {
      this.zzBK.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdClosed.", localRemoteException);
    }
  }
  
  public void onAdClosed(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzx.zzcx("onAdClosed must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClosed.");
    try
    {
      this.zzBK.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdClosed.", localRemoteException);
    }
  }
  
  public void onAdClosed(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzx.zzcx("onAdClosed must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClosed.");
    try
    {
      this.zzBK.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdClosed.", localRemoteException);
    }
  }
  
  public void onAdFailedToLoad(MediationBannerAdapter paramMediationBannerAdapter, int paramInt)
  {
    zzx.zzcx("onAdFailedToLoad must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdFailedToLoad with error. " + paramInt);
    try
    {
      this.zzBK.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }
  
  public void onAdFailedToLoad(MediationInterstitialAdapter paramMediationInterstitialAdapter, int paramInt)
  {
    zzx.zzcx("onAdFailedToLoad must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      this.zzBK.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }
  
  public void onAdFailedToLoad(MediationNativeAdapter paramMediationNativeAdapter, int paramInt)
  {
    zzx.zzcx("onAdFailedToLoad must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      this.zzBK.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }
  
  public void onAdLeftApplication(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzx.zzcx("onAdLeftApplication must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLeftApplication.");
    try
    {
      this.zzBK.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdLeftApplication.", localRemoteException);
    }
  }
  
  public void onAdLeftApplication(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzx.zzcx("onAdLeftApplication must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLeftApplication.");
    try
    {
      this.zzBK.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdLeftApplication.", localRemoteException);
    }
  }
  
  public void onAdLeftApplication(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzx.zzcx("onAdLeftApplication must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLeftApplication.");
    try
    {
      this.zzBK.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdLeftApplication.", localRemoteException);
    }
  }
  
  public void onAdLoaded(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzx.zzcx("onAdLoaded must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLoaded.");
    try
    {
      this.zzBK.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdLoaded.", localRemoteException);
    }
  }
  
  public void onAdLoaded(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzx.zzcx("onAdLoaded must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLoaded.");
    try
    {
      this.zzBK.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdLoaded.", localRemoteException);
    }
  }
  
  public void onAdLoaded(MediationNativeAdapter paramMediationNativeAdapter, NativeAdMapper paramNativeAdMapper)
  {
    zzx.zzcx("onAdLoaded must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLoaded.");
    this.zzBL = paramNativeAdMapper;
    try
    {
      this.zzBK.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdLoaded.", localRemoteException);
    }
  }
  
  public void onAdOpened(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzx.zzcx("onAdOpened must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdOpened.");
    try
    {
      this.zzBK.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdOpened.", localRemoteException);
    }
  }
  
  public void onAdOpened(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzx.zzcx("onAdOpened must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdOpened.");
    try
    {
      this.zzBK.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdOpened.", localRemoteException);
    }
  }
  
  public void onAdOpened(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzx.zzcx("onAdOpened must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdOpened.");
    try
    {
      this.zzBK.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdOpened.", localRemoteException);
    }
  }
  
  public NativeAdMapper zzey()
  {
    return this.zzBL;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzfe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */