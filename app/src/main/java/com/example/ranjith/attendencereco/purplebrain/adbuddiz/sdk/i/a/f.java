package com.purplebrain.adbuddiz.sdk.i.a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.purplebrain.adbuddiz.sdk.f.a;
import java.util.Iterator;
import java.util.List;

public final class f
{
  public static Location a(Context paramContext)
  {
    com.purplebrain.adbuddiz.sdk.f.b localb = com.purplebrain.adbuddiz.sdk.e.b.a().b();
    Object localObject1 = null;
    if (localb != null)
    {
      boolean bool1 = localb.a(a.c);
      localObject1 = null;
      if (bool1) {
        break label29;
      }
    }
    label29:
    boolean bool3;
    do
    {
      return (Location)localObject1;
      boolean bool2 = h.a(paramContext, "android.permission.ACCESS_COARSE_LOCATION");
      bool3 = h.a(paramContext, "android.permission.ACCESS_FINE_LOCATION");
      if (bool2) {
        break;
      }
      localObject1 = null;
    } while (!bool3);
    LocationManager localLocationManager = (LocationManager)paramContext.getSystemService("location");
    Iterator localIterator = localLocationManager.getAllProviders().iterator();
    label80:
    String str;
    if (localIterator.hasNext()) {
      str = (String)localIterator.next();
    }
    for (;;)
    {
      try
      {
        localObject2 = localLocationManager.getLastKnownLocation(str);
        if (localObject2 == null) {
          break label152;
        }
        if (localObject1 != null)
        {
          long l1 = ((Location)localObject2).getTime();
          long l2 = ((Location)localObject1).getTime();
          if (l1 <= l2) {
            break label152;
          }
        }
        localObject1 = localObject2;
      }
      catch (SecurityException localSecurityException) {}
      break label80;
      break;
      label152:
      Object localObject2 = localObject1;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */