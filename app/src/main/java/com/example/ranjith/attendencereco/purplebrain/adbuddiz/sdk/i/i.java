package com.purplebrain.adbuddiz.sdk.i;

import android.os.Handler;
import android.os.Looper;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.AdBuddizDelegate;
import com.purplebrain.adbuddiz.sdk.AdBuddizError;

public final class i
{
  public static void a()
  {
    a(new Runnable()
    {
      public final void run()
      {
        AdBuddiz.getDelegate().didHideAd();
      }
    });
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (AdBuddiz.getDelegate() == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        if (AdBuddiz.getDelegate() != null) {
          this.a.run();
        }
      }
    });
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */