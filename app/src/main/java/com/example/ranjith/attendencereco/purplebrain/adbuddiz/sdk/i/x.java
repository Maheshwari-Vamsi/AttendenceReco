package com.purplebrain.adbuddiz.sdk.i;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.i.b.d;
import org.json.JSONObject;

public final class x
{
  private static String a = null;
  private static boolean b = false;
  private static boolean c = false;
  
  public static void a(Context paramContext)
  {
    if (c)
    {
      if (a == null) {
        break label26;
      }
      d.a(paramContext, "uid", a);
    }
    for (;;)
    {
      b = true;
      return;
      label26:
      d.c(paramContext, "uid");
    }
  }
  
  public static void a(Context paramContext, JSONObject paramJSONObject)
  {
    if (c) {
      a(paramContext);
    }
    if (!b)
    {
      a = d.a(paramContext, "uid");
      b = true;
    }
    String str = a;
    if (str != null) {
      paramJSONObject.put("uid", str);
    }
  }
  
  public static void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 64)) {
      o.b("User Id must not be longer than 64 characters.");
    }
    while ((a == paramString) || ((a != null) && (a.equals(paramString)))) {
      return;
    }
    a = paramString;
    c = true;
    b = false;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */