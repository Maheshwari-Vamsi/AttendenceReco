package com.purplebrain.adbuddiz.sdk.b;

import com.purplebrain.adbuddiz.sdk.AdBuddizError;
import com.purplebrain.adbuddiz.sdk.AdBuddizRewardedVideoError;

public abstract class b
  extends Exception
{
  public AdBuddizError a = null;
  public AdBuddizRewardedVideoError b = null;
  public String c = null;
  
  protected b(AdBuddizError paramAdBuddizError)
  {
    this(paramAdBuddizError, null);
  }
  
  protected b(AdBuddizError paramAdBuddizError, AdBuddizRewardedVideoError paramAdBuddizRewardedVideoError)
  {
    this(paramAdBuddizError, paramAdBuddizRewardedVideoError, null);
  }
  
  protected b(AdBuddizError paramAdBuddizError, AdBuddizRewardedVideoError paramAdBuddizRewardedVideoError, String paramString)
  {
    this.a = paramAdBuddizError;
    this.b = paramAdBuddizRewardedVideoError;
    this.c = paramString;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */