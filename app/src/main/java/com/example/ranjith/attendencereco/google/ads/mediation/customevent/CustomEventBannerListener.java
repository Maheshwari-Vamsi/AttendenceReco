package com.google.ads.mediation.customevent;

import android.view.View;

@Deprecated
public abstract interface CustomEventBannerListener
  extends CustomEventListener
{
  public abstract void onClick();
  
  public abstract void onReceivedAd(View paramView);
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\ads\mediation\customevent\CustomEventBannerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */