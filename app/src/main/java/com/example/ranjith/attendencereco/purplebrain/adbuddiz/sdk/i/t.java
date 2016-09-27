package com.purplebrain.adbuddiz.sdk.i;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.i.a.e;

public final class t
{
  public static String a(Context paramContext, String paramString)
  {
    if (paramString.contains("{publisherId}")) {
      paramString = a(paramString, "{publisherId}", Long.toString(com.purplebrain.adbuddiz.sdk.e.b.a().b().f));
    }
    if (paramString.contains("{androidId}")) {
      paramString = a(paramString, "{androidId}", e.a(paramContext));
    }
    if (paramString.contains("{androidIdMD5}")) {
      paramString = a(paramString, "{androidIdMD5}", n.a("MD5", e.a(paramContext)));
    }
    if (paramString.contains("{androidIdSHA1}")) {
      paramString = a(paramString, "{androidIdSHA1}", n.a("SHA-1", e.a(paramContext)));
    }
    if (paramString.contains("{googleAid}")) {
      paramString = a(paramString, "{googleAid}", com.purplebrain.adbuddiz.sdk.i.b.b.a(paramContext));
    }
    if (paramString.contains("{googleAidMD5}")) {
      paramString = a(paramString, "{googleAidMD5}", n.a("MD5", com.purplebrain.adbuddiz.sdk.i.b.b.a(paramContext)));
    }
    if (paramString.contains("{googleAidSHA1}")) {
      paramString = a(paramString, "{googleAidSHA1}", n.a("SHA-1", com.purplebrain.adbuddiz.sdk.i.b.b.a(paramContext)));
    }
    return paramString;
  }
  
  static String a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString3 != null) {
      return paramString1.replace(paramString2, paramString3);
    }
    return paramString1.replace(paramString2, "");
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */