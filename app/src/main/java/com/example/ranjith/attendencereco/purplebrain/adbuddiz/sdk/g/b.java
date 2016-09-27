package com.purplebrain.adbuddiz.sdk.g;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import com.purplebrain.adbuddiz.sdk.d.a;
import com.purplebrain.adbuddiz.sdk.i.l;
import com.purplebrain.adbuddiz.sdk.i.o;

public final class b
  extends CountDownTimer
{
  e a;
  public boolean b = false;
  private com.purplebrain.adbuddiz.sdk.f.b c;
  private a d;
  
  private b(com.purplebrain.adbuddiz.sdk.f.b paramb, a parama, e parame)
  {
    super(paramb.x.longValue(), 500L);
    this.c = paramb;
    this.d = parama;
    this.a = parame;
  }
  
  public static b a(a parama, e parame)
  {
    return new b(com.purplebrain.adbuddiz.sdk.e.b.a().b(), parama, parame);
  }
  
  private void a()
  {
    if (!this.b)
    {
      this.b = true;
      this.d.a(true);
    }
  }
  
  public final void onFinish()
  {
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      l.a("ABMRAIDCloseTimer.onFinish()", null, localThrowable);
      o.a("ABMRAIDCloseTimer.onFinish()", localThrowable);
    }
  }
  
  public final void onTick(long paramLong)
  {
    try
    {
      if ((this.c.y != null) && (this.c.x.longValue() - paramLong >= this.c.y.longValue()) && (this.a.b()))
      {
        a();
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            try
            {
              b.this.cancel();
              return;
            }
            catch (Throwable localThrowable)
            {
              l.a("ABMRAIDCloseTimer.stopTimer()", null, localThrowable);
              o.a("ABMRAIDCloseTimer.stopTimer()", localThrowable);
            }
          }
        });
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      l.a("ABMRAIDCloseTimer.onTick()", null, localThrowable);
      o.a("ABMRAIDCloseTimer.onFinish()", localThrowable);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */