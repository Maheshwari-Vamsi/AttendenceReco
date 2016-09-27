package com.purplebrain.adbuddiz.sdk.i;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class p
{
  private static Map f = new ConcurrentHashMap();
  public Long a = null;
  public Long b = null;
  public Long c = null;
  private Long d = null;
  private Long e = null;
  
  public static long a()
  {
    com.purplebrain.adbuddiz.sdk.f.b localb = com.purplebrain.adbuddiz.sdk.e.b.a().b();
    if (localb != null) {
      return localb.r;
    }
    return 500L;
  }
  
  public static p a(boolean paramBoolean)
  {
    p localp1 = (p)f.get(Boolean.valueOf(paramBoolean));
    if (localp1 == null) {
      try
      {
        p localp2 = (p)f.get(Boolean.valueOf(paramBoolean));
        if (localp2 == null)
        {
          localp2 = new p();
          f.put(Boolean.valueOf(paramBoolean), localp2);
        }
        return localp2;
      }
      finally {}
    }
    return localp1;
  }
  
  public static long b()
  {
    com.purplebrain.adbuddiz.sdk.f.b localb = com.purplebrain.adbuddiz.sdk.e.b.a().b();
    if (localb != null) {
      return localb.t;
    }
    return 60000L;
  }
  
  private static long j()
  {
    return com.purplebrain.adbuddiz.sdk.e.b.a().b().r;
  }
  
  public final void c()
  {
    this.d = Long.valueOf(System.currentTimeMillis());
  }
  
  public final void d()
  {
    this.b = Long.valueOf(System.currentTimeMillis());
  }
  
  public final void e()
  {
    this.e = Long.valueOf(System.currentTimeMillis());
  }
  
  public final boolean f()
  {
    return this.b != null;
  }
  
  public final boolean g()
  {
    return (this.d != null) && (System.currentTimeMillis() - this.d.longValue() < j()) && (this.d.longValue() <= System.currentTimeMillis());
  }
  
  public final boolean h()
  {
    return (this.a != null) && (System.currentTimeMillis() - this.a.longValue() < j()) && (this.a.longValue() <= System.currentTimeMillis());
  }
  
  public final boolean i()
  {
    if (this.e != null)
    {
      long l1 = System.currentTimeMillis() - this.e.longValue();
      com.purplebrain.adbuddiz.sdk.f.b localb = com.purplebrain.adbuddiz.sdk.e.b.a().b();
      if (localb != null) {}
      for (long l2 = localb.s; l1 < l2; l2 = 60000L) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */