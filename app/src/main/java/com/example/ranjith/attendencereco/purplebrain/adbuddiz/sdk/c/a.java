package com.purplebrain.adbuddiz.sdk.c;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.AdBuddizActivity;
import com.purplebrain.adbuddiz.sdk.AdBuddizDelegate;
import com.purplebrain.adbuddiz.sdk.AdBuddizError;
import com.purplebrain.adbuddiz.sdk.b.r;
import com.purplebrain.adbuddiz.sdk.b.t;
import com.purplebrain.adbuddiz.sdk.b.u;
import com.purplebrain.adbuddiz.sdk.b.v;
import com.purplebrain.adbuddiz.sdk.f.d.a;
import com.purplebrain.adbuddiz.sdk.h.g;
import com.purplebrain.adbuddiz.sdk.i.b.c;
import com.purplebrain.adbuddiz.sdk.i.i.5;
import com.purplebrain.adbuddiz.sdk.i.l;
import com.purplebrain.adbuddiz.sdk.i.o;
import com.purplebrain.adbuddiz.sdk.i.p;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private static a d = null;
  private static Boolean e = Boolean.valueOf(true);
  public Context a = null;
  public AdBuddizDelegate b = null;
  private Long c = null;
  
  public static a a()
  {
    synchronized (e)
    {
      if (d == null) {
        d = new a();
      }
      a locala = d;
      return locala;
    }
  }
  
  private static void a(AdBuddizError paramAdBuddizError, String paramString)
  {
    o.b("Can't show Ad: " + paramAdBuddizError.getName() + ". " + paramString);
  }
  
  private static void a(com.purplebrain.adbuddiz.sdk.f.d paramd, AdBuddizError paramAdBuddizError, boolean paramBoolean1, boolean paramBoolean2)
  {
    switch (4.a[paramAdBuddizError.ordinal()])
    {
    }
    for (;;)
    {
      if (paramBoolean1)
      {
        new StringBuilder("didFailToShowAd ").append(paramAdBuddizError.name());
        com.purplebrain.adbuddiz.sdk.i.i.a(new i.5(paramAdBuddizError));
      }
      if ((paramBoolean2) && (AdBuddiz.getContext() != null)) {}
      try
      {
        com.purplebrain.adbuddiz.sdk.e.b.a().c();
        ArrayList localArrayList = new ArrayList();
        com.purplebrain.adbuddiz.sdk.f.b localb1 = com.purplebrain.adbuddiz.sdk.e.b.a().b();
        d.a locala = paramd.c;
        if (locala != null) {
          switch (4.b[locala.ordinal()])
          {
          }
        }
        for (;;)
        {
          if (localArrayList.contains(paramAdBuddizError))
          {
            g localg = new g();
            localg.a(paramAdBuddizError);
            localg.i = paramd;
            localg.f();
          }
          return;
          a(paramAdBuddizError, "AdBuddiz only shows ads for Android SDK >= 2.1 - Eclair.");
          break;
          a(paramAdBuddizError, "showAd() activity parameter is null.");
          break;
          a(paramAdBuddizError, "Add <uses-permission android:name=\"android.permission.INTERNET\" /> in AndroidManifest.xml.");
          break;
          a(paramAdBuddizError, "Add AdBuddiz.setPublisherKey(); call before calling cacheAds();");
          break;
          a(paramAdBuddizError, "");
          o.b(" ---------------------------------------------------------------------- ");
          o.b(" Missing AdBuddizActivity in Manifest, add this :                       ");
          o.b(" <activity android:name=\"com.purplebrain.adbuddiz.sdk.AdBuddizActivity\" ");
          o.b("           android:theme=\"@android:style/Theme.Translucent\" />          ");
          o.b(" ---------------------------------------------------------------------- ");
          break;
          a(paramAdBuddizError, "AdBuddiz Config isn't ready yet. Did you call cacheAds ? Please wait for cache initialization...");
          break;
          a(paramAdBuddizError, "AdBuddiz Config is expired. Currently updating...");
          break;
          a(paramAdBuddizError, "Check Publisher Key value in AdBuddiz.setPublisherKey(); call.");
          break;
          a(paramAdBuddizError, "Check Publisher Key value in AdBuddiz.setPublisherKey(); call. That key can only work with an iOS application.");
          break;
          a(paramAdBuddizError, "This placement is blocked, no Ad will be shown.");
          break;
          a(paramAdBuddizError, "Connect device to Internet.");
          break;
          a(paramAdBuddizError, "");
          o.b("Server request responded HTTP '403 Forbidden'.");
          o.b("You may be behind a proxy blocking all communications from the SDK.");
          o.b("Try to open to www.adbuddiz.com on the browser of your device to check if our service is reachable.");
          break;
          a(paramAdBuddizError, "Currently caching ads...");
          break;
          a(paramAdBuddizError, "No ad inventory is currently available for your parameters (Country, Device, OS...).");
          break;
          StringBuilder localStringBuilder = new StringBuilder("Ad was already shown less than ");
          p.a(false);
          a(paramAdBuddizError, p.a() + "ms ago. Please wait between calls.");
          break;
          a(paramAdBuddizError, "Ad is already displayed on screen.");
          break;
          a(paramAdBuddizError, "");
          break;
          localArrayList.addAll(localb1.B);
          continue;
          localArrayList.addAll(localb1.A);
        }
        return;
      }
      catch (com.purplebrain.adbuddiz.sdk.b.b localb) {}
    }
  }
  
  private static boolean b(AdBuddizError paramAdBuddizError)
  {
    if (paramAdBuddizError != null)
    {
      boolean bool;
      if ((AdBuddizError.CONFIG_NOT_READY != paramAdBuddizError) && (AdBuddizError.CONFIG_EXPIRED != paramAdBuddizError))
      {
        AdBuddizError localAdBuddizError = AdBuddizError.NO_MORE_AVAILABLE_CACHED_ADS;
        bool = false;
        if (localAdBuddizError != paramAdBuddizError) {}
      }
      else
      {
        bool = true;
      }
      return bool;
    }
    try
    {
      com.purplebrain.adbuddiz.sdk.e.a.a().a(false);
      return false;
    }
    catch (com.purplebrain.adbuddiz.sdk.b.q localq)
    {
      return true;
    }
    catch (com.purplebrain.adbuddiz.sdk.b.b localb) {}
    return false;
  }
  
  private static void d(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new com.purplebrain.adbuddiz.sdk.b.a();
    }
    if (!com.purplebrain.adbuddiz.sdk.i.a.b.a()) {
      throw new v();
    }
    if (AdBuddizActivity.isAdOnScreen()) {
      throw new com.purplebrain.adbuddiz.sdk.b.d();
    }
    if (!com.purplebrain.adbuddiz.sdk.i.a.i.a(paramContext)) {
      throw new r();
    }
    try
    {
      com.purplebrain.adbuddiz.sdk.e.b.a().c();
      p localp = p.a(false);
      if ((localp.g()) || (localp.h())) {
        throw new u();
      }
    }
    catch (r localr)
    {
      com.purplebrain.adbuddiz.sdk.e.b.a().e();
      throw localr;
    }
    catch (com.purplebrain.adbuddiz.sdk.b.j localj)
    {
      com.purplebrain.adbuddiz.sdk.e.b.a().e();
      throw localj;
    }
    if (com.purplebrain.adbuddiz.sdk.e.b.a().a(paramString)) {
      throw new t();
    }
  }
  
  private static AdBuddizError e(Context paramContext, String paramString)
  {
    try
    {
      d(paramContext, paramString);
      return null;
    }
    catch (com.purplebrain.adbuddiz.sdk.b.b localb)
    {
      return localb.a;
    }
  }
  
  public final void a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        o.a("cacheAds");
        if (paramContext != null) {
          continue;
        }
        o.b("Can't cache ads: cacheAds() context parameter is null.");
      }
      catch (Throwable localThrowable)
      {
        l.a(d.a.a, localThrowable);
        o.a("AdBuddiz.cacheAds() Exception : ", localThrowable);
        continue;
      }
      finally {}
      return;
      this.a = paramContext;
      this.c = Long.valueOf(System.currentTimeMillis());
      com.purplebrain.adbuddiz.sdk.i.j.a(paramContext);
      if (com.purplebrain.adbuddiz.sdk.i.q.b(paramContext) == null)
      {
        o.b("Can't cache ads: no Publisher Key set. Call AdBuddiz.setPublisherKey(); before calling cacheAds();");
      }
      else if (com.purplebrain.adbuddiz.sdk.i.a.b.a())
      {
        com.purplebrain.adbuddiz.sdk.i.a.e.f(paramContext);
        boolean bool1 = com.purplebrain.adbuddiz.sdk.i.b.b.a();
        boolean bool2 = com.purplebrain.adbuddiz.sdk.i.b.b.b();
        if ((bool1) || (bool2))
        {
          o.a("Configuration changed.");
          c.a(paramContext);
          if (bool2)
          {
            com.purplebrain.adbuddiz.sdk.e.a.a().b();
            com.purplebrain.adbuddiz.sdk.e.b.a().f();
            com.purplebrain.adbuddiz.sdk.i.q.a(paramContext);
            com.purplebrain.adbuddiz.sdk.i.b.b.c();
          }
        }
        com.purplebrain.adbuddiz.sdk.e.b.a().d();
        com.purplebrain.adbuddiz.sdk.i.e.a(paramContext);
        com.purplebrain.adbuddiz.sdk.i.d.a(paramContext);
        com.purplebrain.adbuddiz.sdk.e.a locala = com.purplebrain.adbuddiz.sdk.e.a.a();
        locala.a(paramContext);
        locala.a(paramContext, locala.a);
        if ((bool1) || (bool2)) {
          com.purplebrain.adbuddiz.sdk.e.a.a().b(false);
        }
      }
    }
  }
  
  /* Error */
  public final boolean a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: aload_0
    //   6: monitorenter
    //   7: new 113	com/purplebrain/adbuddiz/sdk/f/d
    //   10: dup
    //   11: getstatic 370	com/purplebrain/adbuddiz/sdk/f/d$a:c	Lcom/purplebrain/adbuddiz/sdk/f/d$a;
    //   14: aload_2
    //   15: invokespecial 373	com/purplebrain/adbuddiz/sdk/f/d:<init>	(Lcom/purplebrain/adbuddiz/sdk/f/d$a;Ljava/lang/String;)V
    //   18: astore 5
    //   20: iconst_0
    //   21: invokestatic 188	com/purplebrain/adbuddiz/sdk/i/p:a	(Z)Lcom/purplebrain/adbuddiz/sdk/i/p;
    //   24: astore 7
    //   26: aload_0
    //   27: getfield 31	com/purplebrain/adbuddiz/sdk/c/a:a	Landroid/content/Context;
    //   30: ifnonnull +38 -> 68
    //   33: ldc_w 375
    //   36: invokestatic 65	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   39: ldc_w 377
    //   42: invokestatic 65	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   45: ldc_w 379
    //   48: invokestatic 65	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   51: ldc_w 381
    //   54: invokestatic 65	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   57: ldc_w 375
    //   60: invokestatic 65	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   63: aload_0
    //   64: monitorexit
    //   65: iload 4
    //   67: ireturn
    //   68: aload_0
    //   69: aload_1
    //   70: putfield 31	com/purplebrain/adbuddiz/sdk/c/a:a	Landroid/content/Context;
    //   73: aload_1
    //   74: invokestatic 312	com/purplebrain/adbuddiz/sdk/i/j:a	(Landroid/content/Context;)V
    //   77: aload 7
    //   79: invokevirtual 383	com/purplebrain/adbuddiz/sdk/i/p:i	()Z
    //   82: istore 10
    //   84: iload 10
    //   86: ifeq +103 -> 189
    //   89: iconst_0
    //   90: istore 11
    //   92: ldc_w 385
    //   95: invokestatic 296	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;)V
    //   98: aload_1
    //   99: aload_2
    //   100: invokestatic 287	com/purplebrain/adbuddiz/sdk/c/a:d	(Landroid/content/Context;Ljava/lang/String;)V
    //   103: invokestatic 232	com/purplebrain/adbuddiz/sdk/e/a:a	()Lcom/purplebrain/adbuddiz/sdk/e/a;
    //   106: iconst_0
    //   107: invokevirtual 235	com/purplebrain/adbuddiz/sdk/e/a:a	(Z)Lcom/purplebrain/adbuddiz/sdk/f/a/a;
    //   110: pop
    //   111: iload_3
    //   112: istore 4
    //   114: aload 7
    //   116: invokevirtual 386	com/purplebrain/adbuddiz/sdk/i/p:e	()V
    //   119: goto -56 -> 63
    //   122: astore 6
    //   124: aload_0
    //   125: monitorexit
    //   126: aload 6
    //   128: athrow
    //   129: astore 9
    //   131: aload 5
    //   133: aload 9
    //   135: getfield 289	com/purplebrain/adbuddiz/sdk/b/b:a	Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;
    //   138: iconst_0
    //   139: iload_3
    //   140: invokestatic 388	com/purplebrain/adbuddiz/sdk/c/a:a	(Lcom/purplebrain/adbuddiz/sdk/f/d;Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;ZZ)V
    //   143: iconst_0
    //   144: istore 4
    //   146: goto -32 -> 114
    //   149: aload 5
    //   151: getstatic 391	com/purplebrain/adbuddiz/sdk/AdBuddizError:UNKNOWN_EXCEPTION_RAISED	Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;
    //   154: iconst_0
    //   155: iload_3
    //   156: invokestatic 388	com/purplebrain/adbuddiz/sdk/c/a:a	(Lcom/purplebrain/adbuddiz/sdk/f/d;Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;ZZ)V
    //   159: ldc_w 393
    //   162: aload 8
    //   164: invokestatic 331	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   167: iconst_0
    //   168: istore 4
    //   170: goto -56 -> 114
    //   173: astore 8
    //   175: iload 11
    //   177: istore_3
    //   178: goto -29 -> 149
    //   181: astore 9
    //   183: iload 11
    //   185: istore_3
    //   186: goto -55 -> 131
    //   189: iload_3
    //   190: istore 11
    //   192: goto -100 -> 92
    //   195: astore 8
    //   197: goto -48 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	a
    //   0	200	1	paramContext	Context
    //   0	200	2	paramString	String
    //   1	189	3	bool1	boolean
    //   3	166	4	bool2	boolean
    //   18	132	5	locald	com.purplebrain.adbuddiz.sdk.f.d
    //   122	5	6	localObject	Object
    //   24	91	7	localp	p
    //   162	1	8	localThrowable1	Throwable
    //   173	1	8	localThrowable2	Throwable
    //   195	1	8	localThrowable3	Throwable
    //   129	5	9	localb1	com.purplebrain.adbuddiz.sdk.b.b
    //   181	1	9	localb2	com.purplebrain.adbuddiz.sdk.b.b
    //   82	3	10	bool3	boolean
    //   90	101	11	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   7	26	122	finally
    //   26	63	122	finally
    //   68	84	122	finally
    //   92	111	122	finally
    //   114	119	122	finally
    //   131	143	122	finally
    //   149	167	122	finally
    //   26	63	129	com/purplebrain/adbuddiz/sdk/b/b
    //   68	84	129	com/purplebrain/adbuddiz/sdk/b/b
    //   92	111	173	java/lang/Throwable
    //   92	111	181	com/purplebrain/adbuddiz/sdk/b/b
    //   26	63	195	java/lang/Throwable
    //   68	84	195	java/lang/Throwable
  }
  
  /* Error */
  public final void b(final Context paramContext, final String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: new 113	com/purplebrain/adbuddiz/sdk/f/d
    //   7: dup
    //   8: getstatic 399	com/purplebrain/adbuddiz/sdk/f/d$a:b	Lcom/purplebrain/adbuddiz/sdk/f/d$a;
    //   11: aload_2
    //   12: invokespecial 373	com/purplebrain/adbuddiz/sdk/f/d:<init>	(Lcom/purplebrain/adbuddiz/sdk/f/d$a;Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload_0
    //   18: getfield 31	com/purplebrain/adbuddiz/sdk/c/a:a	Landroid/content/Context;
    //   21: ifnonnull +55 -> 76
    //   24: aload_1
    //   25: ifnonnull +16 -> 41
    //   28: aload 4
    //   30: getstatic 402	com/purplebrain/adbuddiz/sdk/AdBuddizError:ACTIVITY_PARAMETER_IS_NULL	Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;
    //   33: iconst_1
    //   34: iconst_1
    //   35: invokestatic 388	com/purplebrain/adbuddiz/sdk/c/a:a	(Lcom/purplebrain/adbuddiz/sdk/f/d;Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;ZZ)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: ldc_w 375
    //   44: invokestatic 65	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   47: ldc_w 377
    //   50: invokestatic 65	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   53: ldc_w 404
    //   56: invokestatic 65	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   59: ldc_w 406
    //   62: invokestatic 65	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   65: ldc_w 375
    //   68: invokestatic 65	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   71: aload_0
    //   72: aload_1
    //   73: invokevirtual 407	com/purplebrain/adbuddiz/sdk/c/a:a	(Landroid/content/Context;)V
    //   76: invokestatic 413	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   79: invokestatic 416	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   82: invokevirtual 419	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   85: ifne +66 -> 151
    //   88: aload_1
    //   89: ifnonnull +13 -> 102
    //   92: aload 4
    //   94: getstatic 402	com/purplebrain/adbuddiz/sdk/AdBuddizError:ACTIVITY_PARAMETER_IS_NULL	Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;
    //   97: iconst_1
    //   98: iconst_1
    //   99: invokestatic 388	com/purplebrain/adbuddiz/sdk/c/a:a	(Lcom/purplebrain/adbuddiz/sdk/f/d;Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;ZZ)V
    //   102: new 421	android/os/Handler
    //   105: dup
    //   106: invokestatic 413	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   109: invokespecial 424	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   112: new 426	com/purplebrain/adbuddiz/sdk/c/a$1
    //   115: dup
    //   116: aload_0
    //   117: aload_1
    //   118: aload_2
    //   119: invokespecial 429	com/purplebrain/adbuddiz/sdk/c/a$1:<init>	(Lcom/purplebrain/adbuddiz/sdk/c/a;Landroid/content/Context;Ljava/lang/String;)V
    //   122: invokevirtual 433	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   125: pop
    //   126: goto -88 -> 38
    //   129: astore 7
    //   131: aload 4
    //   133: getstatic 436	com/purplebrain/adbuddiz/sdk/AdBuddizError:MISSING_ADBUDDIZ_ACTIVITY_IN_MANIFEST	Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;
    //   136: iconst_1
    //   137: iconst_1
    //   138: invokestatic 388	com/purplebrain/adbuddiz/sdk/c/a:a	(Lcom/purplebrain/adbuddiz/sdk/f/d;Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;ZZ)V
    //   141: goto -103 -> 38
    //   144: astore 6
    //   146: aload_0
    //   147: monitorexit
    //   148: aload 6
    //   150: athrow
    //   151: ldc_w 438
    //   154: invokestatic 296	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;)V
    //   157: aconst_null
    //   158: astore 9
    //   160: aload_1
    //   161: aload_2
    //   162: invokestatic 287	com/purplebrain/adbuddiz/sdk/c/a:d	(Landroid/content/Context;Ljava/lang/String;)V
    //   165: aload_0
    //   166: aload_1
    //   167: putfield 31	com/purplebrain/adbuddiz/sdk/c/a:a	Landroid/content/Context;
    //   170: aload_1
    //   171: invokestatic 312	com/purplebrain/adbuddiz/sdk/i/j:a	(Landroid/content/Context;)V
    //   174: invokestatic 232	com/purplebrain/adbuddiz/sdk/e/a:a	()Lcom/purplebrain/adbuddiz/sdk/e/a;
    //   177: aload_1
    //   178: iconst_0
    //   179: invokevirtual 441	com/purplebrain/adbuddiz/sdk/e/a:a	(Landroid/content/Context;Z)Lcom/purplebrain/adbuddiz/sdk/f/a/a;
    //   182: astore 13
    //   184: iconst_0
    //   185: invokestatic 188	com/purplebrain/adbuddiz/sdk/i/p:a	(Z)Lcom/purplebrain/adbuddiz/sdk/i/p;
    //   188: invokevirtual 442	com/purplebrain/adbuddiz/sdk/i/p:c	()V
    //   191: new 444	com/purplebrain/adbuddiz/sdk/i/a
    //   194: dup
    //   195: aload_0
    //   196: getfield 31	com/purplebrain/adbuddiz/sdk/c/a:a	Landroid/content/Context;
    //   199: invokespecial 446	com/purplebrain/adbuddiz/sdk/i/a:<init>	(Landroid/content/Context;)V
    //   202: astore 14
    //   204: aload 14
    //   206: aload 13
    //   208: putfield 449	com/purplebrain/adbuddiz/sdk/i/a:a	Lcom/purplebrain/adbuddiz/sdk/f/a/a;
    //   211: aload 14
    //   213: aload_2
    //   214: putfield 452	com/purplebrain/adbuddiz/sdk/i/a:b	Ljava/lang/String;
    //   217: aload 14
    //   219: invokevirtual 455	com/purplebrain/adbuddiz/sdk/i/a:a	()Landroid/content/Intent;
    //   222: astore 15
    //   224: aload_0
    //   225: getfield 31	com/purplebrain/adbuddiz/sdk/c/a:a	Landroid/content/Context;
    //   228: aload 15
    //   230: invokevirtual 461	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   233: new 463	com/purplebrain/adbuddiz/sdk/i/i$3
    //   236: dup
    //   237: invokespecial 464	com/purplebrain/adbuddiz/sdk/i/i$3:<init>	()V
    //   240: invokestatic 92	com/purplebrain/adbuddiz/sdk/i/i:a	(Ljava/lang/Runnable;)V
    //   243: new 466	java/lang/Thread
    //   246: dup
    //   247: new 468	com/purplebrain/adbuddiz/sdk/c/a$3
    //   250: dup
    //   251: aload_0
    //   252: aload 13
    //   254: invokespecial 471	com/purplebrain/adbuddiz/sdk/c/a$3:<init>	(Lcom/purplebrain/adbuddiz/sdk/c/a;Lcom/purplebrain/adbuddiz/sdk/f/a/a;)V
    //   257: invokespecial 473	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   260: invokevirtual 476	java/lang/Thread:start	()V
    //   263: iload_3
    //   264: istore 11
    //   266: iload 11
    //   268: ifne -230 -> 38
    //   271: aload_0
    //   272: getfield 33	com/purplebrain/adbuddiz/sdk/c/a:c	Ljava/lang/Long;
    //   275: ifnull +130 -> 405
    //   278: aload_0
    //   279: getfield 33	com/purplebrain/adbuddiz/sdk/c/a:c	Ljava/lang/Long;
    //   282: sipush 500
    //   285: invokestatic 481	com/purplebrain/adbuddiz/sdk/i/h:a	(Ljava/lang/Long;I)Z
    //   288: ifeq +117 -> 405
    //   291: iload_3
    //   292: ifeq -254 -> 38
    //   295: aload 9
    //   297: invokestatic 214	com/purplebrain/adbuddiz/sdk/c/a:b	(Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;)Z
    //   300: ifeq -262 -> 38
    //   303: new 466	java/lang/Thread
    //   306: dup
    //   307: new 483	com/purplebrain/adbuddiz/sdk/c/a$2
    //   310: dup
    //   311: aload_0
    //   312: aload_1
    //   313: aload_2
    //   314: invokespecial 484	com/purplebrain/adbuddiz/sdk/c/a$2:<init>	(Lcom/purplebrain/adbuddiz/sdk/c/a;Landroid/content/Context;Ljava/lang/String;)V
    //   317: invokespecial 473	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   320: invokevirtual 476	java/lang/Thread:start	()V
    //   323: goto -285 -> 38
    //   326: astore 5
    //   328: aload 4
    //   330: getstatic 391	com/purplebrain/adbuddiz/sdk/AdBuddizError:UNKNOWN_EXCEPTION_RAISED	Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;
    //   333: iconst_1
    //   334: iconst_1
    //   335: invokestatic 388	com/purplebrain/adbuddiz/sdk/c/a:a	(Lcom/purplebrain/adbuddiz/sdk/f/d;Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;ZZ)V
    //   338: ldc_w 486
    //   341: aload 5
    //   343: invokestatic 331	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   346: goto -308 -> 38
    //   349: astore 12
    //   351: iconst_0
    //   352: istore 11
    //   354: invokestatic 232	com/purplebrain/adbuddiz/sdk/e/a:a	()Lcom/purplebrain/adbuddiz/sdk/e/a;
    //   357: iconst_0
    //   358: invokevirtual 368	com/purplebrain/adbuddiz/sdk/e/a:b	(Z)V
    //   361: aload 4
    //   363: aload 12
    //   365: getfield 289	com/purplebrain/adbuddiz/sdk/b/b:a	Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;
    //   368: iconst_1
    //   369: iconst_1
    //   370: invokestatic 388	com/purplebrain/adbuddiz/sdk/c/a:a	(Lcom/purplebrain/adbuddiz/sdk/f/d;Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;ZZ)V
    //   373: aload 12
    //   375: getfield 289	com/purplebrain/adbuddiz/sdk/b/b:a	Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;
    //   378: astore 9
    //   380: goto -114 -> 266
    //   383: aload 4
    //   385: aload 10
    //   387: getfield 289	com/purplebrain/adbuddiz/sdk/b/b:a	Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;
    //   390: iconst_1
    //   391: iconst_1
    //   392: invokestatic 388	com/purplebrain/adbuddiz/sdk/c/a:a	(Lcom/purplebrain/adbuddiz/sdk/f/d;Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;ZZ)V
    //   395: aload 10
    //   397: getfield 289	com/purplebrain/adbuddiz/sdk/b/b:a	Lcom/purplebrain/adbuddiz/sdk/AdBuddizError;
    //   400: astore 9
    //   402: goto -136 -> 266
    //   405: iconst_0
    //   406: istore_3
    //   407: goto -116 -> 291
    //   410: astore 10
    //   412: iload_3
    //   413: istore 11
    //   415: goto -32 -> 383
    //   418: astore 12
    //   420: iload_3
    //   421: istore 11
    //   423: goto -69 -> 354
    //   426: astore 10
    //   428: iconst_0
    //   429: istore 11
    //   431: goto -48 -> 383
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	a
    //   0	434	1	paramContext	Context
    //   0	434	2	paramString	String
    //   1	420	3	i	int
    //   15	369	4	locald	com.purplebrain.adbuddiz.sdk.f.d
    //   326	16	5	localThrowable	Throwable
    //   144	5	6	localObject1	Object
    //   129	1	7	localActivityNotFoundException	android.content.ActivityNotFoundException
    //   158	243	9	localAdBuddizError	AdBuddizError
    //   385	11	10	localObject2	Object
    //   410	1	10	localb1	com.purplebrain.adbuddiz.sdk.b.b
    //   426	1	10	localb2	com.purplebrain.adbuddiz.sdk.b.b
    //   264	166	11	j	int
    //   349	25	12	localp1	com.purplebrain.adbuddiz.sdk.b.p
    //   418	1	12	localp2	com.purplebrain.adbuddiz.sdk.b.p
    //   182	71	13	locala	com.purplebrain.adbuddiz.sdk.f.a.a
    //   202	16	14	locala1	com.purplebrain.adbuddiz.sdk.i.a
    //   222	7	15	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   17	24	129	android/content/ActivityNotFoundException
    //   28	38	129	android/content/ActivityNotFoundException
    //   41	76	129	android/content/ActivityNotFoundException
    //   76	88	129	android/content/ActivityNotFoundException
    //   92	102	129	android/content/ActivityNotFoundException
    //   102	126	129	android/content/ActivityNotFoundException
    //   151	157	129	android/content/ActivityNotFoundException
    //   160	233	129	android/content/ActivityNotFoundException
    //   233	263	129	android/content/ActivityNotFoundException
    //   271	291	129	android/content/ActivityNotFoundException
    //   295	323	129	android/content/ActivityNotFoundException
    //   354	380	129	android/content/ActivityNotFoundException
    //   383	402	129	android/content/ActivityNotFoundException
    //   4	17	144	finally
    //   17	24	144	finally
    //   28	38	144	finally
    //   41	76	144	finally
    //   76	88	144	finally
    //   92	102	144	finally
    //   102	126	144	finally
    //   131	141	144	finally
    //   151	157	144	finally
    //   160	233	144	finally
    //   233	263	144	finally
    //   271	291	144	finally
    //   295	323	144	finally
    //   328	346	144	finally
    //   354	380	144	finally
    //   383	402	144	finally
    //   17	24	326	java/lang/Throwable
    //   28	38	326	java/lang/Throwable
    //   41	76	326	java/lang/Throwable
    //   76	88	326	java/lang/Throwable
    //   92	102	326	java/lang/Throwable
    //   102	126	326	java/lang/Throwable
    //   151	157	326	java/lang/Throwable
    //   160	233	326	java/lang/Throwable
    //   233	263	326	java/lang/Throwable
    //   271	291	326	java/lang/Throwable
    //   295	323	326	java/lang/Throwable
    //   354	380	326	java/lang/Throwable
    //   383	402	326	java/lang/Throwable
    //   160	233	349	com/purplebrain/adbuddiz/sdk/b/p
    //   233	263	410	com/purplebrain/adbuddiz/sdk/b/b
    //   233	263	418	com/purplebrain/adbuddiz/sdk/b/p
    //   160	233	426	com/purplebrain/adbuddiz/sdk/b/b
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */