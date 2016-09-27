package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzha
public final class zzfj<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  implements MediationBannerListener, MediationInterstitialListener
{
  private final zzey zzBK;
  
  public zzfj(zzey paramzzey)
  {
    this.zzBK = paramzzey;
  }
  
  public void onClick(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    zzb.zzaF("Adapter called onClick.");
    if (!zzl.zzcN().zzhr())
    {
      zzb.zzaH("onClick must be called on the main UI thread.");
      zza.zzLE.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzfj.zza(zzfj.this).onAdClicked();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzb.zzd("Could not call onAdClicked.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onDismissScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    zzb.zzaF("Adapter called onDismissScreen.");
    if (!zzl.zzcN().zzhr())
    {
      zzb.zzaH("onDismissScreen must be called on the main UI thread.");
      zza.zzLE.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzfj.zza(zzfj.this).onAdClosed();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzb.zzd("Could not call onAdClosed.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onDismissScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    zzb.zzaF("Adapter called onDismissScreen.");
    if (!zzl.zzcN().zzhr())
    {
      zzb.zzaH("onDismissScreen must be called on the main UI thread.");
      zza.zzLE.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzfj.zza(zzfj.this).onAdClosed();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzb.zzd("Could not call onAdClosed.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    zzb.zzaF("Adapter called onFailedToReceiveAd with error. " + paramErrorCode);
    if (!zzl.zzcN().zzhr())
    {
      zzb.zzaH("onFailedToReceiveAd must be called on the main UI thread.");
      zza.zzLE.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzfj.zza(zzfj.this).onAdFailedToLoad(zzfk.zza(paramErrorCode));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzb.zzd("Could not call onAdFailedToLoad.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.zzBK.onAdFailedToLoad(zzfk.zza(paramErrorCode));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }
  
  public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    zzb.zzaF("Adapter called onFailedToReceiveAd with error " + paramErrorCode + ".");
    if (!zzl.zzcN().zzhr())
    {
      zzb.zzaH("onFailedToReceiveAd must be called on the main UI thread.");
      zza.zzLE.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzfj.zza(zzfj.this).onAdFailedToLoad(zzfk.zza(paramErrorCode));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzb.zzd("Could not call onAdFailedToLoad.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.zzBK.onAdFailedToLoad(zzfk.zza(paramErrorCode));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }
  
  public void onLeaveApplication(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    zzb.zzaF("Adapter called onLeaveApplication.");
    if (!zzl.zzcN().zzhr())
    {
      zzb.zzaH("onLeaveApplication must be called on the main UI thread.");
      zza.zzLE.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzfj.zza(zzfj.this).onAdLeftApplication();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzb.zzd("Could not call onAdLeftApplication.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onLeaveApplication(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    zzb.zzaF("Adapter called onLeaveApplication.");
    if (!zzl.zzcN().zzhr())
    {
      zzb.zzaH("onLeaveApplication must be called on the main UI thread.");
      zza.zzLE.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzfj.zza(zzfj.this).onAdLeftApplication();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzb.zzd("Could not call onAdLeftApplication.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onPresentScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    zzb.zzaF("Adapter called onPresentScreen.");
    if (!zzl.zzcN().zzhr())
    {
      zzb.zzaH("onPresentScreen must be called on the main UI thread.");
      zza.zzLE.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzfj.zza(zzfj.this).onAdOpened();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzb.zzd("Could not call onAdOpened.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onPresentScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    zzb.zzaF("Adapter called onPresentScreen.");
    if (!zzl.zzcN().zzhr())
    {
      zzb.zzaH("onPresentScreen must be called on the main UI thread.");
      zza.zzLE.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzfj.zza(zzfj.this).onAdOpened();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzb.zzd("Could not call onAdOpened.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onReceivedAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    zzb.zzaF("Adapter called onReceivedAd.");
    if (!zzl.zzcN().zzhr())
    {
      zzb.zzaH("onReceivedAd must be called on the main UI thread.");
      zza.zzLE.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzfj.zza(zzfj.this).onAdLoaded();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzb.zzd("Could not call onAdLoaded.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onReceivedAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    zzb.zzaF("Adapter called onReceivedAd.");
    if (!zzl.zzcN().zzhr())
    {
      zzb.zzaH("onReceivedAd must be called on the main UI thread.");
      zza.zzLE.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzfj.zza(zzfj.this).onAdLoaded();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzb.zzd("Could not call onAdLoaded.", localRemoteException);
          }
        }
      });
      return;
    }
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
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzfj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */