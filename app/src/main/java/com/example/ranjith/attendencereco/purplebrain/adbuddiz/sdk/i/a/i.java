package com.purplebrain.adbuddiz.sdk.i.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class i
{
  public static boolean a(Context paramContext)
  {
    if (!h.a(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {}
    while (d(paramContext) != null) {
      return true;
    }
    return false;
  }
  
  public static Integer b(Context paramContext)
  {
    NetworkInfo localNetworkInfo = d(paramContext);
    if (localNetworkInfo == null) {
      return null;
    }
    return Integer.valueOf(localNetworkInfo.getType());
  }
  
  @SuppressLint({"NewApi"})
  public static Integer c(Context paramContext)
  {
    NetworkInfo localNetworkInfo = d(paramContext);
    if (localNetworkInfo == null) {
      return null;
    }
    return Integer.valueOf(localNetworkInfo.getSubtype());
  }
  
  private static NetworkInfo d(Context paramContext)
  {
    NetworkInfo localNetworkInfo;
    if (!h.a(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
      localNetworkInfo = null;
    }
    do
    {
      return localNetworkInfo;
      localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    } while ((localNetworkInfo != null) && (localNetworkInfo.isConnected()));
    return null;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */