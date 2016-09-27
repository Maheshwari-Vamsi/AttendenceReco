package com.purplebrain.adbuddiz.sdk.e.a.b;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.f.a.a;
import com.purplebrain.adbuddiz.sdk.h.b;
import com.purplebrain.adbuddiz.sdk.h.b.a;
import com.purplebrain.adbuddiz.sdk.h.e.a;
import com.purplebrain.adbuddiz.sdk.i.m;
import java.io.File;
import java.util.Collection;

public abstract class c
{
  protected a a = null;
  private Boolean b = null;
  private e.a c = new e.a()
  {
    public final void a(com.purplebrain.adbuddiz.sdk.f.a.a.c paramAnonymousc)
    {
      c.this.a(paramAnonymousc);
    }
  };
  private b.a d = new b.a()
  {
    public final void a(b paramAnonymousb) {}
  };
  
  protected c() {}
  
  protected c(byte paramByte)
  {
    this.b = Boolean.valueOf(true);
  }
  
  public static boolean c(com.purplebrain.adbuddiz.sdk.f.a.a.c paramc)
  {
    if (paramc.c()) {
      return AdBuddiz.getContext().getFileStreamPath(m.a(paramc)).exists();
    }
    return true;
  }
  
  protected static void d(com.purplebrain.adbuddiz.sdk.f.a.a.c paramc)
  {
    if (paramc.c())
    {
      new Object[1][0] = paramc.b();
      AdBuddiz.getContext().deleteFile(m.a(paramc));
    }
  }
  
  public final void a(a parama)
  {
    this.a = parama;
  }
  
  public abstract void a(com.purplebrain.adbuddiz.sdk.f.a.a.c paramc);
  
  public abstract void a(a parama);
  
  public abstract void a(a parama, Collection paramCollection);
  
  public abstract boolean a(a parama, com.purplebrain.adbuddiz.sdk.f.e parame);
  
  public boolean b(com.purplebrain.adbuddiz.sdk.f.a.a.c paramc)
  {
    new Object[1][0] = paramc.b();
    if (paramc.c())
    {
      if (c(paramc))
      {
        new Object[1][0] = paramc.b();
        m.b(AdBuddiz.getContext(), paramc);
        return false;
      }
      com.purplebrain.adbuddiz.sdk.h.e locale = new com.purplebrain.adbuddiz.sdk.h.e();
      locale.e = paramc;
      if (this.b != null) {
        locale.c = this.b.booleanValue();
      }
      locale.f = this.c;
      locale.a(this.d);
      locale.f();
      return true;
    }
    new Object[1][0] = paramc.b();
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void a(a parama, Exception paramException);
    
    public abstract void b(a parama);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\e\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */