package com.purplebrain.adbuddiz.sdk;

import android.app.Activity;
import android.content.Context;
import com.purplebrain.adbuddiz.sdk.c.a;
import com.purplebrain.adbuddiz.sdk.f.d.a;
import com.purplebrain.adbuddiz.sdk.i.l;
import com.purplebrain.adbuddiz.sdk.i.o;
import com.purplebrain.adbuddiz.sdk.i.q;
import com.purplebrain.adbuddiz.sdk.i.u;
import com.purplebrain.adbuddiz.sdk.i.x;

public final class AdBuddiz
{
  static void a(Activity paramActivity)
  {
    a.a().a = paramActivity;
  }
  
  public static void cacheAds(Activity paramActivity)
  {
    try
    {
      a.a().a(paramActivity);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static Context getContext()
  {
    return a.a().a;
  }
  
  public static AdBuddizDelegate getDelegate()
  {
    return a.a().b;
  }
  
  public static String getType()
  {
    return "Java";
  }
  
  public static String getVersion()
  {
    return "3.1.9";
  }
  
  public static boolean isReadyToShowAd(Activity paramActivity)
  {
    try
    {
      boolean bool = a.a().a(paramActivity, "Default");
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static boolean isReadyToShowAd(Activity paramActivity, String paramString)
  {
    try
    {
      boolean bool = a.a().a(paramActivity, paramString);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void onDestroy()
  {
    try
    {
      o.a("onDestroy");
      com.purplebrain.adbuddiz.sdk.h.b.h();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        l.a(d.a.j, localThrowable);
        o.a("AdBuddiz.onDestroy() Exception : ", localThrowable);
      }
    }
    finally {}
  }
  
  public static void setDelegate(AdBuddizDelegate paramAdBuddizDelegate)
  {
    a.a().b = paramAdBuddizDelegate;
  }
  
  public static void setLogLevel(AdBuddizLogLevel paramAdBuddizLogLevel)
  {
    try
    {
      o.a(paramAdBuddizLogLevel);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        l.a(d.a.g, localThrowable);
        o.a("AdBuddiz.setLogLevel() Exception : ", localThrowable);
      }
    }
    finally {}
  }
  
  public static void setPublisherKey(String paramString)
  {
    try
    {
      q.a(paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        l.a(d.a.h, localThrowable);
        o.a("AdBuddiz.setPublisherKey() Exception : ", localThrowable);
      }
    }
    finally {}
  }
  
  public static void setTestModeActive()
  {
    try
    {
      u.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        l.a(d.a.i, localThrowable);
        o.a("AdBuddiz.setTestModeActive() Exception : ", localThrowable);
      }
    }
    finally {}
  }
  
  public static void showAd(Activity paramActivity)
  {
    try
    {
      a.a().b(paramActivity, "Default");
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void showAd(Activity paramActivity, String paramString)
  {
    try
    {
      a.a().b(paramActivity, paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static class RewardedVideo
  {
    /* Error */
    public static void fetch(Activity paramActivity)
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: invokestatic 20	com/purplebrain/adbuddiz/sdk/c/b:a	()Lcom/purplebrain/adbuddiz/sdk/c/b;
      //   6: astore_2
      //   7: new 22	com/purplebrain/adbuddiz/sdk/f/d
      //   10: dup
      //   11: getstatic 28	com/purplebrain/adbuddiz/sdk/f/d$a:d	Lcom/purplebrain/adbuddiz/sdk/f/d$a;
      //   14: ldc 30
      //   16: invokespecial 33	com/purplebrain/adbuddiz/sdk/f/d:<init>	(Lcom/purplebrain/adbuddiz/sdk/f/d$a;Ljava/lang/String;)V
      //   19: astore_3
      //   20: ldc 34
      //   22: invokestatic 39	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;)V
      //   25: aload_0
      //   26: invokestatic 43	com/purplebrain/adbuddiz/sdk/c/b:b	(Landroid/content/Context;)V
      //   29: aload_2
      //   30: aload_0
      //   31: putfield 46	com/purplebrain/adbuddiz/sdk/c/b:a	Landroid/content/Context;
      //   34: aload_2
      //   35: invokestatic 52	java/lang/System:currentTimeMillis	()J
      //   38: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   41: putfield 61	com/purplebrain/adbuddiz/sdk/c/b:b	Ljava/lang/Long;
      //   44: invokestatic 66	com/purplebrain/adbuddiz/sdk/c/a:a	()Lcom/purplebrain/adbuddiz/sdk/c/a;
      //   47: aload_0
      //   48: putfield 67	com/purplebrain/adbuddiz/sdk/c/a:a	Landroid/content/Context;
      //   51: aload_0
      //   52: invokestatic 71	com/purplebrain/adbuddiz/sdk/i/j:a	(Landroid/content/Context;)V
      //   55: aload_0
      //   56: invokestatic 74	com/purplebrain/adbuddiz/sdk/i/x:a	(Landroid/content/Context;)V
      //   59: invokestatic 79	com/purplebrain/adbuddiz/sdk/i/a/b:a	()Z
      //   62: ifeq +113 -> 175
      //   65: aload_0
      //   66: invokestatic 84	com/purplebrain/adbuddiz/sdk/i/a/e:f	(Landroid/content/Context;)V
      //   69: invokestatic 87	com/purplebrain/adbuddiz/sdk/i/b/b:a	()Z
      //   72: istore 6
      //   74: invokestatic 89	com/purplebrain/adbuddiz/sdk/i/b/b:b	()Z
      //   77: istore 7
      //   79: iload 6
      //   81: ifne +8 -> 89
      //   84: iload 7
      //   86: ifeq +36 -> 122
      //   89: ldc 91
      //   91: invokestatic 39	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;)V
      //   94: aload_0
      //   95: invokestatic 94	com/purplebrain/adbuddiz/sdk/i/b/c:a	(Landroid/content/Context;)V
      //   98: iload 7
      //   100: ifeq +22 -> 122
      //   103: invokestatic 99	com/purplebrain/adbuddiz/sdk/e/a:a	()Lcom/purplebrain/adbuddiz/sdk/e/a;
      //   106: invokevirtual 101	com/purplebrain/adbuddiz/sdk/e/a:b	()V
      //   109: invokestatic 106	com/purplebrain/adbuddiz/sdk/e/b:a	()Lcom/purplebrain/adbuddiz/sdk/e/b;
      //   112: invokevirtual 108	com/purplebrain/adbuddiz/sdk/e/b:f	()V
      //   115: aload_0
      //   116: invokestatic 111	com/purplebrain/adbuddiz/sdk/i/q:a	(Landroid/content/Context;)V
      //   119: invokestatic 114	com/purplebrain/adbuddiz/sdk/i/b/b:c	()V
      //   122: invokestatic 106	com/purplebrain/adbuddiz/sdk/e/b:a	()Lcom/purplebrain/adbuddiz/sdk/e/b;
      //   125: invokevirtual 116	com/purplebrain/adbuddiz/sdk/e/b:d	()V
      //   128: aload_0
      //   129: invokestatic 119	com/purplebrain/adbuddiz/sdk/i/e:a	(Landroid/content/Context;)V
      //   132: aload_0
      //   133: invokestatic 122	com/purplebrain/adbuddiz/sdk/i/d:a	(Landroid/content/Context;)V
      //   136: invokestatic 99	com/purplebrain/adbuddiz/sdk/e/a:a	()Lcom/purplebrain/adbuddiz/sdk/e/a;
      //   139: astore 8
      //   141: aload 8
      //   143: aload_0
      //   144: invokevirtual 123	com/purplebrain/adbuddiz/sdk/e/a:a	(Landroid/content/Context;)V
      //   147: aload 8
      //   149: aload_0
      //   150: aload 8
      //   152: getfield 126	com/purplebrain/adbuddiz/sdk/e/a:b	Lcom/purplebrain/adbuddiz/sdk/e/a/a/c;
      //   155: invokevirtual 129	com/purplebrain/adbuddiz/sdk/e/a:a	(Landroid/content/Context;Lcom/purplebrain/adbuddiz/sdk/e/a/a/b;)V
      //   158: iload 6
      //   160: ifne +8 -> 168
      //   163: iload 7
      //   165: ifeq +10 -> 175
      //   168: invokestatic 99	com/purplebrain/adbuddiz/sdk/e/a:a	()Lcom/purplebrain/adbuddiz/sdk/e/a;
      //   171: iconst_1
      //   172: invokevirtual 132	com/purplebrain/adbuddiz/sdk/e/a:b	(Z)V
      //   175: ldc 2
      //   177: monitorexit
      //   178: return
      //   179: astore 5
      //   181: aload_3
      //   182: aload 5
      //   184: getfield 135	com/purplebrain/adbuddiz/sdk/b/b:b	Lcom/purplebrain/adbuddiz/sdk/AdBuddizRewardedVideoError;
      //   187: aload 5
      //   189: getfield 138	com/purplebrain/adbuddiz/sdk/b/b:c	Ljava/lang/String;
      //   192: invokestatic 141	com/purplebrain/adbuddiz/sdk/c/b:a	(Lcom/purplebrain/adbuddiz/sdk/f/d;Lcom/purplebrain/adbuddiz/sdk/AdBuddizRewardedVideoError;Ljava/lang/String;)V
      //   195: goto -20 -> 175
      //   198: astore_1
      //   199: ldc 2
      //   201: monitorexit
      //   202: aload_1
      //   203: athrow
      //   204: astore 4
      //   206: getstatic 28	com/purplebrain/adbuddiz/sdk/f/d$a:d	Lcom/purplebrain/adbuddiz/sdk/f/d$a;
      //   209: aload 4
      //   211: invokestatic 146	com/purplebrain/adbuddiz/sdk/i/l:a	(Lcom/purplebrain/adbuddiz/sdk/f/d$a;Ljava/lang/Throwable;)V
      //   214: ldc -108
      //   216: aload 4
      //   218: invokestatic 151	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   221: goto -46 -> 175
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	224	0	paramActivity	Activity
      //   198	5	1	localObject	Object
      //   6	29	2	localb	com.purplebrain.adbuddiz.sdk.c.b
      //   19	163	3	locald	com.purplebrain.adbuddiz.sdk.f.d
      //   204	13	4	localThrowable	Throwable
      //   179	9	5	localb1	com.purplebrain.adbuddiz.sdk.b.b
      //   72	87	6	bool1	boolean
      //   77	87	7	bool2	boolean
      //   139	12	8	locala	com.purplebrain.adbuddiz.sdk.e.a
      // Exception table:
      //   from	to	target	type
      //   20	79	179	com/purplebrain/adbuddiz/sdk/b/b
      //   89	98	179	com/purplebrain/adbuddiz/sdk/b/b
      //   103	122	179	com/purplebrain/adbuddiz/sdk/b/b
      //   122	158	179	com/purplebrain/adbuddiz/sdk/b/b
      //   168	175	179	com/purplebrain/adbuddiz/sdk/b/b
      //   3	20	198	finally
      //   20	79	198	finally
      //   89	98	198	finally
      //   103	122	198	finally
      //   122	158	198	finally
      //   168	175	198	finally
      //   181	195	198	finally
      //   206	221	198	finally
      //   20	79	204	java/lang/Throwable
      //   89	98	204	java/lang/Throwable
      //   103	122	204	java/lang/Throwable
      //   122	158	204	java/lang/Throwable
      //   168	175	204	java/lang/Throwable
    }
    
    public static AdBuddizRewardedVideoDelegate getDelegate()
    {
      return com.purplebrain.adbuddiz.sdk.c.b.a().c;
    }
    
    public static boolean isReadyToShow(Activity paramActivity)
    {
      try
      {
        boolean bool = com.purplebrain.adbuddiz.sdk.c.b.a().a(paramActivity);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public static void setDelegate(AdBuddizRewardedVideoDelegate paramAdBuddizRewardedVideoDelegate)
    {
      com.purplebrain.adbuddiz.sdk.c.b.a().c = paramAdBuddizRewardedVideoDelegate;
    }
    
    public static void setUserId(String paramString)
    {
      com.purplebrain.adbuddiz.sdk.c.b localb = com.purplebrain.adbuddiz.sdk.c.b.a();
      x.a(paramString);
      if (localb.a != null) {
        x.a(localb.a);
      }
    }
    
    public static void show(Activity paramActivity)
    {
      try
      {
        com.purplebrain.adbuddiz.sdk.c.b.a().c(paramActivity);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\AdBuddiz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */