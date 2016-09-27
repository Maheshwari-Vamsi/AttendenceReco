package com.purplebrain.adbuddiz.sdk.i;

import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.f.a.c;
import com.purplebrain.adbuddiz.sdk.f.e;
import com.purplebrain.adbuddiz.sdk.i.a.l.a;
import java.net.URL;

public final class w
{
  private static boolean a = true;
  
  public static URL a(com.purplebrain.adbuddiz.sdk.f.a.b paramb, e parame)
  {
    String str1 = t.a(com.purplebrain.adbuddiz.sdk.e.b.a().b().g, "{ai}", Long.toString(paramb.g));
    l.a locala1 = l.a.b;
    AdBuddiz.getContext();
    l.a locala2;
    if (com.purplebrain.adbuddiz.sdk.e.b.a().b().e)
    {
      locala2 = l.a.b;
      if ((!locala1.equals(locala2)) || (!paramb.h)) {
        break label104;
      }
    }
    label104:
    for (String str2 = t.a(str1, "{at}", l.a.b.c);; str2 = t.a(str1, "{at}", l.a.a.c))
    {
      return new URL(t.a(str2, "{o}", parame.d));
      locala2 = l.a.a;
      break;
    }
  }
  
  public static URL a(c paramc)
  {
    return new URL(t.a(com.purplebrain.adbuddiz.sdk.e.b.a().b().h, "{avi}", Long.toString(paramc.g)));
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static void b()
  {
    a = false;
  }
  
  public static URL c()
  {
    return new URL(j() + "updateConf");
  }
  
  public static URL d()
  {
    long l = com.purplebrain.adbuddiz.sdk.e.b.a().b().f;
    return new URL(j() + "nextAd/" + l);
  }
  
  public static URL e()
  {
    long l = com.purplebrain.adbuddiz.sdk.e.b.a().b().f;
    return new URL(j() + "adImpression/" + l);
  }
  
  public static URL f()
  {
    long l = com.purplebrain.adbuddiz.sdk.e.b.a().b().f;
    return new URL(j() + "eventReport/" + l);
  }
  
  public static URL g()
  {
    long l = com.purplebrain.adbuddiz.sdk.e.b.a().b().f;
    return new URL(j() + "adClick/" + l);
  }
  
  public static URL h()
  {
    return new URL("http://data.adbuddiz.com/sdk/v1/downloadAsset/close_button.png");
  }
  
  public static URL i()
  {
    return new URL("http://data.adbuddiz.com/sdk/v1/downloadAsset/by_adbuddiz.png");
  }
  
  private static String j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (a) {}
    for (String str = "https://";; str = "http://") {
      return str + "sdk.adbuddiz.com/sdk/android/v3/";
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */