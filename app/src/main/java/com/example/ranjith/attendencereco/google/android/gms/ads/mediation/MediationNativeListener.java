package com.google.android.gms.ads.mediation;

public abstract interface MediationNativeListener
{
  public abstract void onAdClicked(MediationNativeAdapter paramMediationNativeAdapter);
  
  public abstract void onAdClosed(MediationNativeAdapter paramMediationNativeAdapter);
  
  public abstract void onAdFailedToLoad(MediationNativeAdapter paramMediationNativeAdapter, int paramInt);
  
  public abstract void onAdLeftApplication(MediationNativeAdapter paramMediationNativeAdapter);
  
  public abstract void onAdLoaded(MediationNativeAdapter paramMediationNativeAdapter, NativeAdMapper paramNativeAdMapper);
  
  public abstract void onAdOpened(MediationNativeAdapter paramMediationNativeAdapter);
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\mediation\MediationNativeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */