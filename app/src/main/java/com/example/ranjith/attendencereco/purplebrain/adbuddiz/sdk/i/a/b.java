package com.purplebrain.adbuddiz.sdk.i.a;

import android.os.Build.VERSION;

public final class b
{
  public static boolean a()
  {
    return b() >= 7;
  }
  
  public static int b()
  {
    if (Build.VERSION.RELEASE.startsWith("1.5")) {
      return 3;
    }
    try
    {
      int i = Build.VERSION.SDK_INT;
      return i;
    }
    catch (VerifyError localVerifyError) {}
    return 3;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */