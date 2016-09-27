package com.purplebrain.adbuddiz.sdk.i.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.purplebrain.adbuddiz.sdk.f.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
{
  public static List a(Context paramContext)
  {
    localArrayList = new ArrayList();
    if (!com.purplebrain.adbuddiz.sdk.e.b.a().b().a(a.e)) {
      return localArrayList;
    }
    try
    {
      Iterator localIterator = paramContext.getPackageManager().getInstalledPackages(0).iterator();
      while (localIterator.hasNext())
      {
        PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
        if ((0x1 & localPackageInfo.applicationInfo.flags) == 0) {
          localArrayList.add(localPackageInfo.packageName);
        }
      }
      return localArrayList;
    }
    catch (RuntimeException localRuntimeException) {}
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 0);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */