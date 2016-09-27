package com.google.android.gms.ads.reward;

public abstract interface RewardedVideoAdListener
{
  public abstract void onRewarded(RewardItem paramRewardItem);
  
  public abstract void onRewardedVideoAdClosed();
  
  public abstract void onRewardedVideoAdFailedToLoad(int paramInt);
  
  public abstract void onRewardedVideoAdLeftApplication();
  
  public abstract void onRewardedVideoAdLoaded();
  
  public abstract void onRewardedVideoAdOpened();
  
  public abstract void onRewardedVideoStarted();
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\reward\RewardedVideoAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */