package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;

@zzha
public class zzdc
  extends zzcx.zza
{
  private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzyu;
  
  public zzdc(NativeAppInstallAd.OnAppInstallAdLoadedListener paramOnAppInstallAdLoadedListener)
  {
    this.zzyu = paramOnAppInstallAdLoadedListener;
  }
  
  public void zza(zzcr paramzzcr)
  {
    this.zzyu.onAppInstallAdLoaded(zzb(paramzzcr));
  }
  
  zzcs zzb(zzcr paramzzcr)
  {
    return new zzcs(paramzzcr);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzdc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */