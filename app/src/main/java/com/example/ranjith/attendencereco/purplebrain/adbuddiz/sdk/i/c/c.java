package com.purplebrain.adbuddiz.sdk.i.c;

import android.os.CountDownTimer;
import com.purplebrain.adbuddiz.sdk.a.c.d;
import com.purplebrain.adbuddiz.sdk.i.l;
import com.purplebrain.adbuddiz.sdk.i.o;
import com.purplebrain.adbuddiz.sdk.j.b.b.d;

public final class c
{
  public String a;
  public long b;
  public int c;
  public e d = null;
  public a e = null;
  public e.a f = new e.a()
  {
    public final void a()
    {
      c.this.d();
    }
  };
  private com.purplebrain.adbuddiz.sdk.f.a.a g;
  private String h;
  private Boolean i;
  private Boolean j;
  private c.d k;
  
  public c(com.purplebrain.adbuddiz.sdk.f.a.a parama, String paramString1, String paramString2, long paramLong, int paramInt, e parame, c.d paramd)
  {
    this.g = parama;
    this.h = paramString1;
    this.a = paramString2;
    this.b = paramLong;
    this.c = paramInt;
    this.d = parame;
    this.k = paramd;
  }
  
  public final void a(d paramd)
  {
    if ((c()) && (paramd.w.equals(this.a))) {
      d();
    }
  }
  
  public final boolean a()
  {
    if (this.i == null) {
      this.i = Boolean.valueOf("impression".equals(this.a));
    }
    return this.i.booleanValue();
  }
  
  public final boolean b()
  {
    if (this.j == null) {
      if (a.a(this.a, this.b) == null) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      this.j = Boolean.valueOf(bool);
      return this.j.booleanValue();
    }
  }
  
  public final boolean c()
  {
    return (!a()) && (!b());
  }
  
  public final void d()
  {
    this.k.a(this.g, this.h, Boolean.valueOf(true));
  }
  
  private final class a
    extends CountDownTimer
  {
    public a(long paramLong)
    {
      super(250L);
    }
    
    public final void onFinish()
    {
      try
      {
        c.this.d();
        return;
      }
      catch (Throwable localThrowable)
      {
        l.a("ABVASTImpressionHelper#ABVASTImpressionTimer.onFinish", null, localThrowable);
        o.a("ABVASTImpressionHelper#ABVASTImpressionTimer.onFinish()", localThrowable);
      }
    }
    
    public final void onTick(long paramLong) {}
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */