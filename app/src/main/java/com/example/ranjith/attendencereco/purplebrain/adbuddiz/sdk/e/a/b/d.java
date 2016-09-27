package com.purplebrain.adbuddiz.sdk.e.a.b;

import com.purplebrain.adbuddiz.sdk.f.a.a;
import com.purplebrain.adbuddiz.sdk.f.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class d
  extends c
{
  private void b(a parama)
  {
    try
    {
      com.purplebrain.adbuddiz.sdk.f.a.a.d locald = com.purplebrain.adbuddiz.sdk.f.a.a.d.b;
      if (parama.g()) {}
      for (e locale = parama.a;; locale = com.purplebrain.adbuddiz.sdk.i.a.d.a())
      {
        Iterator localIterator = com.purplebrain.adbuddiz.sdk.i.c.a(parama, locald, false, locale).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!b((com.purplebrain.adbuddiz.sdk.f.a.a.c)localIterator.next()));
        return;
      }
      this.a.b(parama);
      return;
    }
    catch (Exception localException)
    {
      this.a.a(parama, localException);
    }
  }
  
  public final void a(com.purplebrain.adbuddiz.sdk.f.a.a.c paramc)
  {
    b(paramc.a);
  }
  
  public final void a(a parama)
  {
    b(parama);
  }
  
  public final void a(a parama, Collection paramCollection)
  {
    Iterator localIterator = com.purplebrain.adbuddiz.sdk.i.c.a(parama, com.purplebrain.adbuddiz.sdk.f.a.a.d.b, false, e.c).iterator();
    while (localIterator.hasNext()) {
      d((com.purplebrain.adbuddiz.sdk.f.a.a.c)localIterator.next());
    }
  }
  
  public final boolean a(a parama, e parame)
  {
    boolean bool = true;
    Iterator localIterator = com.purplebrain.adbuddiz.sdk.i.c.a(parama, com.purplebrain.adbuddiz.sdk.f.a.a.d.b, false, e.c).iterator();
    while ((bool) && (localIterator.hasNext())) {
      bool = c((com.purplebrain.adbuddiz.sdk.f.a.a.c)localIterator.next());
    }
    return bool;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\e\a\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */