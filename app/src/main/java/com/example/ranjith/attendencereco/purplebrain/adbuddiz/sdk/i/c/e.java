package com.purplebrain.adbuddiz.sdk.i.c;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import com.purplebrain.adbuddiz.sdk.i.l;
import com.purplebrain.adbuddiz.sdk.i.o;

public final class e
  extends CountDownTimer
{
  public a a;
  private com.purplebrain.adbuddiz.sdk.d.a b;
  private MediaPlayer c;
  private long d;
  private boolean e = false;
  private boolean f = false;
  
  private e(com.purplebrain.adbuddiz.sdk.d.a parama, MediaPlayer paramMediaPlayer, long paramLong)
  {
    super(paramLong, 250L);
    this.d = paramLong;
    this.b = parama;
    this.c = paramMediaPlayer;
    a(this.d);
    this.b.a(false);
  }
  
  public static e a(com.purplebrain.adbuddiz.sdk.f.a.a parama, com.purplebrain.adbuddiz.sdk.d.a parama1, MediaPlayer paramMediaPlayer, long paramLong, int paramInt, String... paramVarArgs)
  {
    com.purplebrain.adbuddiz.sdk.f.b localb;
    Long localLong2;
    e locale;
    if (parama.b)
    {
      localb = com.purplebrain.adbuddiz.sdk.e.b.a().b();
      localLong2 = a(paramLong, paramVarArgs);
      locale = null;
      if (localLong2 != null) {}
    }
    Long localLong1;
    boolean bool1;
    do
    {
      do
      {
        do
        {
          boolean bool2;
          do
          {
            return locale;
            bool2 = localLong2.longValue() < paramInt;
            locale = null;
          } while (bool2);
          locale = new e(parama1, paramMediaPlayer, localLong2.longValue());
        } while ((localLong2.longValue() < paramLong) || (localb.v == null));
        locale.f = true;
        return locale;
        localLong1 = a(paramLong, paramVarArgs);
        locale = null;
      } while (localLong1 == null);
      bool1 = localLong1.longValue() < paramInt;
      locale = null;
    } while (bool1);
    return new e(parama1, paramMediaPlayer, localLong1.longValue());
  }
  
  public static Long a(long paramLong, String... paramVarArgs)
  {
    int i = paramVarArgs.length;
    int j = 0;
    Object localObject1 = null;
    Object localObject2;
    if (j < i)
    {
      localObject2 = paramVarArgs[j];
      if (localObject2 == null) {
        break label56;
      }
    }
    for (;;)
    {
      j++;
      localObject1 = localObject2;
      break;
      if (localObject1 != null) {
        return Long.valueOf(a.a((String)localObject1, paramLong).a);
      }
      return null;
      label56:
      localObject2 = localObject1;
    }
  }
  
  private void a(long paramLong)
  {
    this.b.a(Integer.valueOf((int)Math.ceil((float)paramLong / 1000.0F)));
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/purplebrain/adbuddiz/sdk/i/c/e:e	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 24	com/purplebrain/adbuddiz/sdk/i/c/e:e	Z
    //   19: aload_0
    //   20: invokevirtual 105	com/purplebrain/adbuddiz/sdk/i/c/e:cancel	()V
    //   23: new 107	android/os/Handler
    //   26: dup
    //   27: invokestatic 113	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   30: invokespecial 116	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   33: new 118	com/purplebrain/adbuddiz/sdk/i/c/e$1
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 121	com/purplebrain/adbuddiz/sdk/i/c/e$1:<init>	(Lcom/purplebrain/adbuddiz/sdk/i/c/e;)V
    //   41: invokevirtual 125	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   44: pop
    //   45: goto -34 -> 11
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	e
    //   48	4	1	localObject	Object
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	48	finally
    //   14	45	48	finally
  }
  
  public final void onFinish()
  {
    a();
  }
  
  public final void onTick(long paramLong)
  {
    try
    {
      long l = this.d - this.c.getCurrentPosition();
      if (l <= 0L)
      {
        a();
        return;
      }
      a(l);
      return;
    }
    catch (Throwable localThrowable)
    {
      o.a("ABVASTSkippableLinearHelper.onTick()", localThrowable);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */