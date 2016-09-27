package com.purplebrain.adbuddiz.sdk.e.a.b;

import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.f.e;
import com.purplebrain.adbuddiz.sdk.i.a.d;
import com.purplebrain.adbuddiz.sdk.i.b;
import com.purplebrain.adbuddiz.sdk.i.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
  extends c
{
  public a()
  {
    super((byte)0);
  }
  
  private void b(com.purplebrain.adbuddiz.sdk.f.a.a parama)
  {
    try
    {
      if (parama.c() == e.c)
      {
        e locale2 = d.a();
        if (b(parama, locale2))
        {
          locale2 = e.b(locale2);
          if (b(parama, locale2))
          {
            if (this.a == null) {
              return;
            }
            this.a.b(parama);
            return;
          }
        }
        c(parama, locale2);
        return;
      }
    }
    catch (Exception localException)
    {
      this.a.a(parama, localException);
      return;
    }
    e locale1 = parama.c();
    if (b(parama, locale1))
    {
      if (this.a != null) {
        this.a.b(parama);
      }
    }
    else {
      c(parama, locale1);
    }
  }
  
  private static boolean b(com.purplebrain.adbuddiz.sdk.f.a.a parama, e parame)
  {
    com.purplebrain.adbuddiz.sdk.f.a.a.c localc = com.purplebrain.adbuddiz.sdk.i.c.b(parama, parame);
    if (c(localc))
    {
      m.b(AdBuddiz.getContext(), localc);
      return true;
    }
    return false;
  }
  
  private boolean c(com.purplebrain.adbuddiz.sdk.f.a.a parama, e parame)
  {
    return b(com.purplebrain.adbuddiz.sdk.i.c.b(parama, parame));
  }
  
  public final void a(com.purplebrain.adbuddiz.sdk.f.a.a.c paramc)
  {
    b(paramc.a);
  }
  
  public final void a(com.purplebrain.adbuddiz.sdk.f.a.a parama)
  {
    b(parama);
  }
  
  public final void a(com.purplebrain.adbuddiz.sdk.f.a.a parama, Collection paramCollection)
  {
    new b();
    b.a(paramCollection);
  }
  
  public final boolean a(com.purplebrain.adbuddiz.sdk.f.a.a parama, e parame)
  {
    Iterator localIterator = com.purplebrain.adbuddiz.sdk.i.c.a(parama, parame).iterator();
    boolean bool = true;
    while ((bool) && (localIterator.hasNext())) {
      bool &= c((com.purplebrain.adbuddiz.sdk.f.a.a.c)localIterator.next());
    }
    return bool;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\e\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */