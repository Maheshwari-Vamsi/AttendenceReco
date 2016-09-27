package com.purplebrain.adbuddiz.sdk;

public abstract interface AdBuddizRewardedVideoDelegate
{
  public abstract void didComplete();
  
  public abstract void didFail(AdBuddizRewardedVideoError paramAdBuddizRewardedVideoError);
  
  public abstract void didFetch();
  
  public abstract void didNotComplete();
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\AdBuddizRewardedVideoDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */