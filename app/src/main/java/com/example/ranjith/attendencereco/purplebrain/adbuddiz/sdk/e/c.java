package com.purplebrain.adbuddiz.sdk.e;

import android.annotation.SuppressLint;
import android.content.Context;
import com.purplebrain.adbuddiz.sdk.f.a.a;
import com.purplebrain.adbuddiz.sdk.f.a.d;
import com.purplebrain.adbuddiz.sdk.i.l;
import com.purplebrain.adbuddiz.sdk.i.m;
import com.purplebrain.adbuddiz.sdk.i.o;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

public final class c
{
  b a = null;
  a b = null;
  private com.purplebrain.adbuddiz.sdk.e.a.b.c.a c = new com.purplebrain.adbuddiz.sdk.e.a.b.c.a()
  {
    public final void a(a paramAnonymousa)
    {
      c.this.a.a(paramAnonymousa);
    }
    
    public final void a(a paramAnonymousa, Exception paramAnonymousException)
    {
      c.this.b.a(paramAnonymousa, paramAnonymousException);
    }
    
    public final void b(a paramAnonymousa)
    {
      c.this.b.a(paramAnonymousa);
    }
  };
  
  public static InputStream a(Context paramContext, com.purplebrain.adbuddiz.sdk.f.a.a.c paramc)
  {
    if (paramc.c()) {
      return m.c(paramContext, paramc);
    }
    try
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramc.f().getBytes("UTF-8"));
      return localByteArrayInputStream;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return null;
  }
  
  @SuppressLint({"NewApi"})
  public final void a(final a parama)
  {
    if (parama == null) {
      return;
    }
    if (b.a().b() == null)
    {
      this.b.a(parama, new Exception("Cannot cache an ad without config."));
      return;
    }
    if (parama.d().isEmpty())
    {
      this.b.a(parama, new Exception("Cannot cache an ad without resource."));
      return;
    }
    parama.f().e.a(this.c);
    try
    {
      new Thread(new Runnable()
      {
        public final void run()
        {
          try
          {
            parama.f().e.a(parama);
            return;
          }
          catch (Throwable localThrowable)
          {
            l.a("ABResourceManager.cacheAd", parama, localThrowable);
            o.a("ABResourceManager.cacheAd()", localThrowable);
          }
        }
      }).start();
      return;
    }
    catch (InternalError localInternalError) {}
  }
  
  @SuppressLint({"NewApi"})
  public final void a(final a parama, final Collection paramCollection)
  {
    if ((parama == null) || (paramCollection.contains(parama))) {
      return;
    }
    new Thread(new Runnable()
    {
      public final void run()
      {
        try
        {
          parama.f().e.a(parama, paramCollection);
          return;
        }
        catch (Throwable localThrowable)
        {
          l.a("ABResourceManager.clean", null, localThrowable);
          o.a("ABResourceManager.clean()", localThrowable);
        }
      }
    }).start();
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void a(a parama, Exception paramException);
  }
  
  public static abstract interface b
  {
    public abstract void a(a parama);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */