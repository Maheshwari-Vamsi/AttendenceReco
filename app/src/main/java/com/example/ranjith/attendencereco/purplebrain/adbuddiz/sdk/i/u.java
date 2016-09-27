package com.purplebrain.adbuddiz.sdk.i;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.i.a.h;

public final class u
{
  private static boolean a = false;
  
  public static void a()
  {
    a = true;
  }
  
  public static boolean a(Context paramContext)
  {
    if (a) {
      return true;
    }
    return h.c(paramContext);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */