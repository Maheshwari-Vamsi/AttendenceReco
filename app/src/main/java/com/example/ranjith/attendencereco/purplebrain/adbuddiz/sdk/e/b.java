package com.purplebrain.adbuddiz.sdk.e;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.AdBuddizError;
import com.purplebrain.adbuddiz.sdk.b.i;
import com.purplebrain.adbuddiz.sdk.b.l;
import com.purplebrain.adbuddiz.sdk.b.n;
import com.purplebrain.adbuddiz.sdk.b.o;
import com.purplebrain.adbuddiz.sdk.b.r;
import com.purplebrain.adbuddiz.sdk.f.c;
import com.purplebrain.adbuddiz.sdk.h.j.a;
import com.purplebrain.adbuddiz.sdk.i.f;
import com.purplebrain.adbuddiz.sdk.i.q;
import java.util.List;
import org.json.JSONObject;

public final class b
  implements j.a
{
  private static b a;
  private static com.purplebrain.adbuddiz.sdk.f.b b;
  private static Integer c;
  private static String d;
  private Long e;
  private a f = null;
  
  public static b a()
  {
    try
    {
      if (a == null) {
        a = new b();
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  private boolean c(String paramString)
  {
    try
    {
      new com.purplebrain.adbuddiz.sdk.f.b().a(paramString);
      return true;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void d(String paramString)
  {
    try
    {
      if (b() == null) {
        b = new com.purplebrain.adbuddiz.sdk.f.b();
      }
      b.a(paramString);
      String str = f.c(c.a(b).toString());
      com.purplebrain.adbuddiz.sdk.i.m.b(AdBuddiz.getContext(), "ABZ_31_cfg.abz", str);
      if (this.f != null) {
        this.f.a();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  private boolean g()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 38	com/purplebrain/adbuddiz/sdk/e/b:b	()Lcom/purplebrain/adbuddiz/sdk/f/b;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   20: aload_0
    //   21: invokevirtual 38	com/purplebrain/adbuddiz/sdk/e/b:b	()Lcom/purplebrain/adbuddiz/sdk/f/b;
    //   24: getfield 84	com/purplebrain/adbuddiz/sdk/f/b:a	J
    //   27: lsub
    //   28: aload_0
    //   29: invokevirtual 38	com/purplebrain/adbuddiz/sdk/e/b:b	()Lcom/purplebrain/adbuddiz/sdk/f/b;
    //   32: getfield 86	com/purplebrain/adbuddiz/sdk/f/b:b	J
    //   35: lcmp
    //   36: ifgt -23 -> 13
    //   39: aload_0
    //   40: invokevirtual 38	com/purplebrain/adbuddiz/sdk/e/b:b	()Lcom/purplebrain/adbuddiz/sdk/f/b;
    //   43: getfield 84	com/purplebrain/adbuddiz/sdk/f/b:a	J
    //   46: lstore 4
    //   48: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   51: lstore 6
    //   53: lload 4
    //   55: lload 6
    //   57: lcmp
    //   58: ifgt -45 -> 13
    //   61: iconst_0
    //   62: istore_1
    //   63: goto -50 -> 13
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	b
    //   1	62	1	bool	boolean
    //   66	4	2	localObject	Object
    //   8	2	3	localb	com.purplebrain.adbuddiz.sdk.f.b
    //   46	8	4	l1	long
    //   51	5	6	l2	long
    // Exception table:
    //   from	to	target	type
    //   4	9	66	finally
    //   17	53	66	finally
  }
  
  public final void a(int paramInt, String paramString)
  {
    try
    {
      c = Integer.valueOf(paramInt);
      d = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(a parama)
  {
    this.f = parama;
    if ((this.f != null) && (b != null) && (!b.b())) {
      this.f.a();
    }
  }
  
  public final boolean a(String paramString)
  {
    try
    {
      boolean bool = b().j.contains(paramString);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final com.purplebrain.adbuddiz.sdk.f.b b()
  {
    try
    {
      if (b == null) {
        b = com.purplebrain.adbuddiz.sdk.f.b.a();
      }
      com.purplebrain.adbuddiz.sdk.f.b localb = b;
      return localb;
    }
    finally {}
  }
  
  public final void b(String paramString)
  {
    try
    {
      c(paramString);
      d(paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void c()
  {
    try
    {
      if (!com.purplebrain.adbuddiz.sdk.i.a.h.a(AdBuddiz.getContext(), "android.permission.INTERNET")) {
        throw new n();
      }
    }
    finally {}
    if (q.b(AdBuddiz.getContext()) == null) {
      throw new o();
    }
    if ((c != null) && (c.intValue() == -1)) {
      throw new r();
    }
    if ((c != null) && (c.intValue() == 403))
    {
      String str = com.purplebrain.adbuddiz.sdk.i.k.a(d);
      if (str == null) {
        throw new l();
      }
      try
      {
        throw new i(AdBuddizError.valueOf(str));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new com.purplebrain.adbuddiz.sdk.b.m();
      }
    }
    com.purplebrain.adbuddiz.sdk.f.b localb = b();
    if (localb == null) {
      throw new com.purplebrain.adbuddiz.sdk.b.k();
    }
    if (localb.b()) {
      throw new com.purplebrain.adbuddiz.sdk.b.j();
    }
  }
  
  public final void d()
  {
    try
    {
      if (g()) {
        e();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void e()
  {
    try
    {
      if ((this.e == null) || (!com.purplebrain.adbuddiz.sdk.i.h.a(this.e, 5000)))
      {
        com.purplebrain.adbuddiz.sdk.h.j localj = new com.purplebrain.adbuddiz.sdk.h.j();
        localj.e = this;
        localj.f();
        this.e = Long.valueOf(System.currentTimeMillis());
      }
      return;
    }
    finally {}
  }
  
  public final void f()
  {
    if (b() != null)
    {
      AdBuddiz.getContext().deleteFile("ABZ_31_cfg.abz");
      b = null;
    }
    d = null;
    c = null;
    this.e = null;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */