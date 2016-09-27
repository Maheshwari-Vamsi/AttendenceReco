package com.purplebrain.adbuddiz.sdk.i.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.purplebrain.adbuddiz.sdk.i.o;

public final class h
{
  public static String a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        Bundle localBundle = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
        if (localBundle != null)
        {
          str = localBundle.getString("ADBUDDIZ_PUBLISHER_KEY");
          if (str != null)
          {
            int i = str.length();
            if (i > 0) {
              return str;
            }
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        o.b("Failed to load ApplicationInfo");
        return null;
      }
      catch (RuntimeException localRuntimeException)
      {
        o.b("Failed to load ApplicationInfo");
        return null;
      }
      String str = null;
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.checkCallingOrSelfPermission(paramString) == 0;
  }
  
  public static int b(Context paramContext)
  {
    try
    {
      Bundle localBundle = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (localBundle == null) {
        return 150;
      }
      int i = localBundle.getInt("ADBUDDIZ_BACKGROUND_ALPHA", 150);
      return i;
    }
    catch (RuntimeException localRuntimeException)
    {
      return 150;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return 150;
  }
  
  public static boolean c(Context paramContext)
  {
    try
    {
      Bundle localBundle = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      boolean bool1 = false;
      if (localBundle != null)
      {
        boolean bool2 = localBundle.getBoolean("ADBUDDIZ_TEST_MODE", false);
        bool1 = false;
        if (bool2) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      o.b("Failed to load meta-data, ADBUDDIZ_TEST_MODE not found in AndroidManifest.xml");
      return false;
    }
    catch (RuntimeException localRuntimeException)
    {
      o.b("Failed to load meta-data, ADBUDDIZ_TEST_MODE not found in AndroidManifest.xml");
    }
    return false;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */