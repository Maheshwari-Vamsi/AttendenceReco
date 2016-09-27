package com.purplebrain.adbuddiz.sdk.i;

import android.util.Log;
import com.purplebrain.adbuddiz.sdk.AdBuddizLogLevel;

public final class o
{
  private static AdBuddizLogLevel a = AdBuddizLogLevel.Info;
  
  public static void a(AdBuddizLogLevel paramAdBuddizLogLevel)
  {
    a = paramAdBuddizLogLevel;
  }
  
  public static void a(String paramString)
  {
    if (AdBuddizLogLevel.Info.equals(a)) {
      Log.i("AdBuddiz", paramString);
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    if (!AdBuddizLogLevel.Silent.equals(a)) {
      Log.e("AdBuddiz", paramString, paramThrowable);
    }
  }
  
  public static void b(String paramString)
  {
    if (!AdBuddizLogLevel.Silent.equals(a)) {
      Log.e("AdBuddiz", paramString);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */