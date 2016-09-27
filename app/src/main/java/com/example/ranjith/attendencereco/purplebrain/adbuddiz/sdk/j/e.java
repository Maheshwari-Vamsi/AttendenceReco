package com.purplebrain.adbuddiz.sdk.j;

import android.media.MediaPlayer;
import android.net.Uri;
import com.purplebrain.adbuddiz.sdk.f.a.a.c;
import com.purplebrain.adbuddiz.sdk.j.b.b.d;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public final class e
{
  public static void a(c paramc, MediaPlayer paramMediaPlayer, com.purplebrain.adbuddiz.sdk.j.a.a parama)
  {
    new Object[1][0] = Integer.valueOf(parama.j);
    List localList = paramc.c("e");
    if (paramMediaPlayer != null) {}
    for (Integer localInteger = Integer.valueOf(paramMediaPlayer.getCurrentPosition());; localInteger = null)
    {
      a("Error-" + parama.j, localList, paramc, localInteger);
      return;
    }
  }
  
  public static void a(c paramc, MediaPlayer paramMediaPlayer, d paramd)
  {
    new Object[1][0] = paramd.w;
    List localList = com.purplebrain.adbuddiz.sdk.j.d.a.a(paramc, paramd);
    if (paramMediaPlayer != null) {}
    for (Integer localInteger = Integer.valueOf(paramMediaPlayer.getCurrentPosition());; localInteger = null)
    {
      a("Event-" + paramd.w, localList, paramc, localInteger);
      return;
    }
  }
  
  public static void a(String paramString, List paramList, c paramc, Integer paramInteger)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramc != null) {}
      try
      {
        str = str.replace("[ASSETURI]", Uri.encode(paramc.b("u")));
        if (paramInteger != null)
        {
          int i = paramInteger.intValue() / 3600000;
          int j = paramInteger.intValue() / 60000 % 60;
          int k = paramInteger.intValue() / 1000 % 60;
          int m = paramInteger.intValue() % 100;
          Locale localLocale1 = Locale.US;
          Object[] arrayOfObject1 = new Object[4];
          arrayOfObject1[0] = Integer.valueOf(i);
          arrayOfObject1[1] = Integer.valueOf(j);
          arrayOfObject1[2] = Integer.valueOf(k);
          arrayOfObject1[3] = Integer.valueOf(m);
          str = str.replace("[CONTENTPLAYHEAD]", String.format(localLocale1, "%02d:%02d:%02d.%03d", arrayOfObject1));
        }
        int n = new Random(System.currentTimeMillis()).nextInt();
        Locale localLocale2 = Locale.US;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(n);
        new com.purplebrain.adbuddiz.sdk.j.c.a(paramString, new URL(str.replace("[CACHEBUSTING]", String.format(localLocale2, "%08d", arrayOfObject2).substring(0, 8)))).f();
      }
      catch (MalformedURLException localMalformedURLException) {}
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\j\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */