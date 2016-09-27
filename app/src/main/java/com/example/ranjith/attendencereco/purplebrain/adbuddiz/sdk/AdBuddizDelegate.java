package com.purplebrain.adbuddiz.sdk;

public abstract interface AdBuddizDelegate
{
  public abstract void didCacheAd();
  
  public abstract void didClick();
  
  public abstract void didFailToShowAd(AdBuddizError paramAdBuddizError);
  
  public abstract void didHideAd();
  
  public abstract void didShowAd();
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\AdBuddizDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */