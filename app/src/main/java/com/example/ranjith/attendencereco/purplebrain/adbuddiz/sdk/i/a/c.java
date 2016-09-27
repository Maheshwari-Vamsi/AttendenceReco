package com.purplebrain.adbuddiz.sdk.i.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public final class c
{
  public static int a(Context paramContext)
  {
    try
    {
      int i = c(paramContext).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return 0;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      String str = c(paramContext).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return null;
  }
  
  private static PackageInfo c(Context paramContext)
  {
    return paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */