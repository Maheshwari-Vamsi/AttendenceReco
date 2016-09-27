package com.google.ads.mediation.customevent;

@Deprecated
public abstract interface CustomEventListener
{
  public abstract void onDismissScreen();
  
  public abstract void onFailedToReceiveAd();
  
  public abstract void onLeaveApplication();
  
  public abstract void onPresentScreen();
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\ads\mediation\customevent\CustomEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */