package com.purplebrain.adbuddiz.sdk.i.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.f.a;
import com.purplebrain.adbuddiz.sdk.i.n;
import java.util.Date;

public final class e
{
  @SuppressLint({"NewApi"})
  public static String a(Context paramContext)
  {
    com.purplebrain.adbuddiz.sdk.f.b localb = com.purplebrain.adbuddiz.sdk.e.b.a().b();
    if ((localb == null) || (!localb.a(a.d))) {
      return null;
    }
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public static String b(Context paramContext)
  {
    String str = c(paramContext);
    if (str == null) {
      return null;
    }
    return n.a("MD5", str);
  }
  
  public static String c(Context paramContext)
  {
    com.purplebrain.adbuddiz.sdk.f.b localb = com.purplebrain.adbuddiz.sdk.e.b.a().b();
    if ((localb == null) || (!localb.a(a.b))) {
      return null;
    }
    if (!h.a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
      return null;
    }
    WifiInfo localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    if (localWifiInfo == null) {
      return null;
    }
    return localWifiInfo.getMacAddress();
  }
  
  public static String d(Context paramContext)
  {
    String str = e(paramContext);
    if (str == null) {
      return null;
    }
    return n.a("MD5", str);
  }
  
  public static String e(Context paramContext)
  {
    com.purplebrain.adbuddiz.sdk.f.b localb = com.purplebrain.adbuddiz.sdk.e.b.a().b();
    if ((localb == null) || (!localb.a(a.a))) {}
    while (!h.a(paramContext, "android.permission.READ_PHONE_STATE")) {
      return null;
    }
    return ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
  }
  
  public static void f(Context paramContext)
  {
    int i = 1;
    Long localLong = Long.valueOf(paramContext.getSharedPreferences("ABZ-prefs", 0).getLong("aif", -1L));
    if (localLong.longValue() == -1L) {}
    for (;;)
    {
      if (i != 0) {
        new Thread(new Runnable()
        {
          public final void run()
          {
            String str1 = null;
            label164:
            for (;;)
            {
              try
              {
                g.a locala = g.a(this.a);
                str1 = locala.a;
                boolean bool3 = locala.b;
                String str2 = str1;
                boolean bool1 = bool3;
                SharedPreferences localSharedPreferences;
                String str3;
                boolean bool2;
                SharedPreferences.Editor localEditor;
                if (bool2 == bool1) {}
              }
              catch (Throwable localThrowable1)
              {
                try
                {
                  localSharedPreferences = AdBuddiz.getContext().getSharedPreferences("ABZ-prefs", 0);
                  str3 = localSharedPreferences.getString("ai", null);
                  bool2 = localSharedPreferences.getBoolean("lat", false);
                  localEditor = localSharedPreferences.edit();
                  if (((str3 != null) || (str2 == null)) && ((str3 == null) || (str3.equals(str2)))) {
                    break label164;
                  }
                  localEditor.putString("ai", str2);
                  localEditor.putBoolean("lat", bool1);
                  localEditor.putLong("aif", new Date().getTime());
                  localEditor.commit();
                  return;
                }
                catch (Throwable localThrowable2)
                {
                  return;
                }
                localThrowable1 = localThrowable1;
                str2 = str1;
                bool1 = false;
              }
            }
          }
        }).start();
      }
      return;
      if ((new Date().getTime() - localLong.longValue() <= 86400000L) && (new Date().getTime() >= localLong.longValue())) {
        i = 0;
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */