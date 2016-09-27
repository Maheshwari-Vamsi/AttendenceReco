package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAdOptions;

public abstract interface NativeMediationAdRequest
  extends MediationAdRequest
{
  public abstract NativeAdOptions getNativeAdOptions();
  
  public abstract boolean isAppInstallAdRequested();
  
  public abstract boolean isContentAdRequested();
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\mediation\NativeMediationAdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */