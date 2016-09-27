package com.purplebrain.adbuddiz.sdk.i.c;

import com.purplebrain.adbuddiz.sdk.f.a.a.c;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static void a(c paramc, int paramInt)
  {
    paramc.a("w", Integer.toString(paramInt));
  }
  
  public static void a(c paramc, long paramLong)
  {
    paramc.a("d", Long.toString(paramLong));
  }
  
  public static boolean a(c paramc)
  {
    Iterator localIterator = Arrays.asList(new String[] { "w", "h", "d" }).iterator();
    while (localIterator.hasNext()) {
      if (paramc.b((String)localIterator.next()) == null) {
        return false;
      }
    }
    return true;
  }
  
  public static long b(c paramc)
  {
    return Long.parseLong(paramc.b("d"));
  }
  
  public static void b(c paramc, int paramInt)
  {
    paramc.a("h", Integer.toString(paramInt));
  }
  
  public static int c(c paramc)
  {
    return Integer.parseInt(paramc.b("w"));
  }
  
  public static int d(c paramc)
  {
    return Integer.parseInt(paramc.b("h"));
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */