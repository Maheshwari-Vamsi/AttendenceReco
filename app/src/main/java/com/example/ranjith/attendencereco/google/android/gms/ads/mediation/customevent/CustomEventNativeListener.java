package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.mediation.NativeAdMapper;

public abstract interface CustomEventNativeListener
  extends CustomEventListener
{
  public abstract void onAdLoaded(NativeAdMapper paramNativeAdMapper);
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\mediation\customevent\CustomEventNativeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */