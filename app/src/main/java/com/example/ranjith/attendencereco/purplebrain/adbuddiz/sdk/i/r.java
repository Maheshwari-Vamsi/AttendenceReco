package com.purplebrain.adbuddiz.sdk.i;

import android.os.Handler;
import android.os.Looper;
import com.purplebrain.adbuddiz.sdk.AdBuddiz.RewardedVideo;
import com.purplebrain.adbuddiz.sdk.AdBuddizRewardedVideoDelegate;
import com.purplebrain.adbuddiz.sdk.AdBuddizRewardedVideoError;

public final class r
{
  public static void a()
  {
    a(new Runnable()
    {
      public final void run()
      {
        AdBuddiz.RewardedVideo.getDelegate().didComplete();
      }
    });
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (AdBuddiz.RewardedVideo.getDelegate() == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        if (AdBuddiz.RewardedVideo.getDelegate() != null) {
          this.a.run();
        }
      }
    });
  }
  
  public static void b()
  {
    a(new Runnable()
    {
      public final void run()
      {
        AdBuddiz.RewardedVideo.getDelegate().didNotComplete();
      }
    });
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */