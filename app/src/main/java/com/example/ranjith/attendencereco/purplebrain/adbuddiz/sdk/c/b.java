package com.purplebrain.adbuddiz.sdk.c;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.AdBuddizActivity;
import com.purplebrain.adbuddiz.sdk.AdBuddizRewardedVideoDelegate;
import com.purplebrain.adbuddiz.sdk.AdBuddizRewardedVideoError;
import com.purplebrain.adbuddiz.sdk.b.u;
import com.purplebrain.adbuddiz.sdk.b.v;
import com.purplebrain.adbuddiz.sdk.f.d.a;
import com.purplebrain.adbuddiz.sdk.h.g;
import com.purplebrain.adbuddiz.sdk.i.a.i;
import com.purplebrain.adbuddiz.sdk.i.b.c;
import com.purplebrain.adbuddiz.sdk.i.h;
import com.purplebrain.adbuddiz.sdk.i.l;
import com.purplebrain.adbuddiz.sdk.i.r.3;
import com.purplebrain.adbuddiz.sdk.i.x;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static b d = null;
  private static Boolean e = Boolean.valueOf(true);
  public Context a = null;
  public Long b = null;
  public AdBuddizRewardedVideoDelegate c = null;
  
  public static b a()
  {
    synchronized (e)
    {
      if (d == null) {
        d = new b();
      }
      b localb = d;
      return localb;
    }
  }
  
  private static void a(AdBuddizRewardedVideoError paramAdBuddizRewardedVideoError, String paramString)
  {
    com.purplebrain.adbuddiz.sdk.i.o.b("Can't show Ad: " + paramAdBuddizRewardedVideoError.getName() + ". " + paramString);
  }
  
  public static void a(com.purplebrain.adbuddiz.sdk.f.d paramd, AdBuddizRewardedVideoError paramAdBuddizRewardedVideoError, String paramString)
  {
    a(paramd, paramAdBuddizRewardedVideoError, paramString, true, true);
  }
  
  public static void a(com.purplebrain.adbuddiz.sdk.f.d paramd, AdBuddizRewardedVideoError paramAdBuddizRewardedVideoError, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    switch (4.a[paramAdBuddizRewardedVideoError.ordinal()])
    {
    }
    for (;;)
    {
      if (paramBoolean1) {
        com.purplebrain.adbuddiz.sdk.i.r.a(new r.3(paramAdBuddizRewardedVideoError));
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
          if (localArrayList.contains(paramAdBuddizRewardedVideoError))
          {
            g localg = new g();
            localg.e = null;
            localg.f = paramAdBuddizRewardedVideoError;
            localg.i = paramd;
            localg.f();
          }
          return;
          a(paramAdBuddizRewardedVideoError, "AdBuddiz SDK only boot up for Android SDK >= 2.1 - Eclair.");
          break;
          a(paramAdBuddizRewardedVideoError, "show() activity parameter is null.");
          break;
          a(paramAdBuddizRewardedVideoError, "Add <uses-permission android:name=\"android.permission.INTERNET\" /> in AndroidManifest.xml.");
          break;
          a(paramAdBuddizRewardedVideoError, "Add AdBuddiz.setPublisherKey(); call before calling fetch();");
          break;
          a(paramAdBuddizRewardedVideoError, "");
          com.purplebrain.adbuddiz.sdk.i.o.b(" ---------------------------------------------------------------------- ");
          com.purplebrain.adbuddiz.sdk.i.o.b(" Missing AdBuddizActivity in Manifest, add this :                       ");
          com.purplebrain.adbuddiz.sdk.i.o.b(" <activity android:name=\"com.purplebrain.adbuddiz.sdk.AdBuddizActivity\" ");
          com.purplebrain.adbuddiz.sdk.i.o.b("           android:theme=\"@android:style/Theme.Translucent\" />          ");
          com.purplebrain.adbuddiz.sdk.i.o.b(" ---------------------------------------------------------------------- ");
          break;
          a(paramAdBuddizRewardedVideoError, "AdBuddiz Config isn't ready yet. Did you call fetch()? Please wait for cache initialization...");
          break;
          a(paramAdBuddizRewardedVideoError, "AdBuddiz Config is expired. Currently updating...");
          break;
          a(paramAdBuddizRewardedVideoError, "Check Publisher Key value in AdBuddiz.setPublisherKey(); call.");
          break;
          a(paramAdBuddizRewardedVideoError, "Check Publisher Key value in AdBuddiz.setPublisherKey(); call. That key can only work with an iOS application.");
          break;
          a(paramAdBuddizRewardedVideoError, "Connect device to Internet.");
          break;
          a(paramAdBuddizRewardedVideoError, "");
          com.purplebrain.adbuddiz.sdk.i.o.b("Server request responded HTTP '403 Forbidden'.");
          com.purplebrain.adbuddiz.sdk.i.o.b("You may be behind a proxy blocking all communications from the SDK.");
          com.purplebrain.adbuddiz.sdk.i.o.b("Try to open to www.adbuddiz.com on the browser of your device to check if our service is reachable.");
          break;
          a(paramAdBuddizRewardedVideoError, "Current network is too slow.");
          break;
          a(paramAdBuddizRewardedVideoError, "Device is not supported.");
          break;
          a(paramAdBuddizRewardedVideoError, "Rewarded video ads are only available on Android " + paramString + ".");
          break;
          a(paramAdBuddizRewardedVideoError, "You wait too much time before calling show().");
          break;
          a(paramAdBuddizRewardedVideoError, "No video ad is currently being fetched. Did you call AdBuddiz.RewardedVideo.fetch()?");
          break;
          a(paramAdBuddizRewardedVideoError, "Currently fetching video ad...");
          break;
          a(paramAdBuddizRewardedVideoError, "No ad inventory is currently available for your parameters (Country, Device, OS...).");
          break;
          StringBuilder localStringBuilder = new StringBuilder("Ad was already shown less than ");
          com.purplebrain.adbuddiz.sdk.i.p.a(true);
          a(paramAdBuddizRewardedVideoError, com.purplebrain.adbuddiz.sdk.i.p.a() + "ms ago. Please wait between calls.");
          break;
          a(paramAdBuddizRewardedVideoError, "Ad is already displayed on screen.");
          break;
          a(paramAdBuddizRewardedVideoError, "");
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
  
  public static void b(Context paramContext)
  {
    if (paramContext == null) {
      throw new com.purplebrain.adbuddiz.sdk.b.a();
    }
    if (!com.purplebrain.adbuddiz.sdk.i.a.b.a()) {
      throw new v();
    }
    if (!i.a(paramContext)) {
      throw new com.purplebrain.adbuddiz.sdk.b.r();
    }
    if (com.purplebrain.adbuddiz.sdk.i.q.b(paramContext) == null) {
      throw new com.purplebrain.adbuddiz.sdk.b.o();
    }
  }
  
  private static boolean b(AdBuddizRewardedVideoError paramAdBuddizRewardedVideoError)
  {
    if (paramAdBuddizRewardedVideoError != null)
    {
      boolean bool;
      if ((AdBuddizRewardedVideoError.CONFIG_NOT_READY != paramAdBuddizRewardedVideoError) && (AdBuddizRewardedVideoError.CONFIG_EXPIRED != paramAdBuddizRewardedVideoError))
      {
        AdBuddizRewardedVideoError localAdBuddizRewardedVideoError = AdBuddizRewardedVideoError.FETCHING_AD;
        bool = false;
        if (localAdBuddizRewardedVideoError != paramAdBuddizRewardedVideoError) {}
      }
      else
      {
        bool = true;
      }
      return bool;
    }
    try
    {
      com.purplebrain.adbuddiz.sdk.e.a.a().a(true);
      return false;
    }
    catch (com.purplebrain.adbuddiz.sdk.b.q localq)
    {
      return true;
    }
    catch (com.purplebrain.adbuddiz.sdk.b.b localb) {}
    return false;
  }
  
  private static void e(Context paramContext)
  {
    b(paramContext);
    if (AdBuddizActivity.isAdOnScreen()) {
      throw new com.purplebrain.adbuddiz.sdk.b.d();
    }
    try
    {
      com.purplebrain.adbuddiz.sdk.e.b.a().c();
      com.purplebrain.adbuddiz.sdk.i.p localp = com.purplebrain.adbuddiz.sdk.i.p.a(true);
      if ((localp.g()) || (localp.h())) {
        throw new u();
      }
    }
    catch (com.purplebrain.adbuddiz.sdk.b.r localr)
    {
      com.purplebrain.adbuddiz.sdk.e.b.a().e();
      throw localr;
    }
    catch (com.purplebrain.adbuddiz.sdk.b.j localj)
    {
      com.purplebrain.adbuddiz.sdk.e.b.a().e();
      throw localj;
    }
  }
  
  private static AdBuddizRewardedVideoError f(Context paramContext)
  {
    try
    {
      e(paramContext);
      return null;
    }
    catch (com.purplebrain.adbuddiz.sdk.b.b localb)
    {
      return localb.b;
    }
  }
  
  /* Error */
  public final boolean a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_0
    //   5: monitorenter
    //   6: new 111	com/purplebrain/adbuddiz/sdk/f/d
    //   9: dup
    //   10: getstatic 308	com/purplebrain/adbuddiz/sdk/f/d$a:e	Lcom/purplebrain/adbuddiz/sdk/f/d$a;
    //   13: ldc_w 310
    //   16: invokespecial 313	com/purplebrain/adbuddiz/sdk/f/d:<init>	(Lcom/purplebrain/adbuddiz/sdk/f/d$a;Ljava/lang/String;)V
    //   19: astore 4
    //   21: iconst_1
    //   22: invokestatic 200	com/purplebrain/adbuddiz/sdk/i/p:a	(Z)Lcom/purplebrain/adbuddiz/sdk/i/p;
    //   25: astore 6
    //   27: aload_0
    //   28: getfield 31	com/purplebrain/adbuddiz/sdk/c/b:a	Landroid/content/Context;
    //   31: ifnonnull +31 -> 62
    //   34: ldc_w 315
    //   37: invokestatic 65	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   40: ldc_w 317
    //   43: invokestatic 65	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   46: ldc_w 319
    //   49: invokestatic 65	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   52: ldc_w 315
    //   55: invokestatic 65	com/purplebrain/adbuddiz/sdk/i/o:b	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: monitorexit
    //   60: iload_3
    //   61: ireturn
    //   62: aload_0
    //   63: aload_1
    //   64: putfield 31	com/purplebrain/adbuddiz/sdk/c/b:a	Landroid/content/Context;
    //   67: invokestatic 324	com/purplebrain/adbuddiz/sdk/c/a:a	()Lcom/purplebrain/adbuddiz/sdk/c/a;
    //   70: aload_0
    //   71: getfield 31	com/purplebrain/adbuddiz/sdk/c/b:a	Landroid/content/Context;
    //   74: putfield 325	com/purplebrain/adbuddiz/sdk/c/a:a	Landroid/content/Context;
    //   77: aload_1
    //   78: invokestatic 329	com/purplebrain/adbuddiz/sdk/i/j:a	(Landroid/content/Context;)V
    //   81: aload_1
    //   82: invokestatic 332	com/purplebrain/adbuddiz/sdk/i/x:a	(Landroid/content/Context;)V
    //   85: aload 6
    //   87: invokevirtual 334	com/purplebrain/adbuddiz/sdk/i/p:i	()Z
    //   90: istore 9
    //   92: iload 9
    //   94: ifeq +105 -> 199
    //   97: iconst_0
    //   98: istore 10
    //   100: ldc_w 336
    //   103: invokestatic 338	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;)V
    //   106: aload_1
    //   107: invokestatic 302	com/purplebrain/adbuddiz/sdk/c/b:e	(Landroid/content/Context;)V
    //   110: invokestatic 271	com/purplebrain/adbuddiz/sdk/e/a:a	()Lcom/purplebrain/adbuddiz/sdk/e/a;
    //   113: iconst_1
    //   114: invokevirtual 274	com/purplebrain/adbuddiz/sdk/e/a:a	(Z)Lcom/purplebrain/adbuddiz/sdk/f/a/a;
    //   117: pop
    //   118: iload_2
    //   119: istore_3
    //   120: aload 6
    //   122: invokevirtual 339	com/purplebrain/adbuddiz/sdk/i/p:e	()V
    //   125: goto -67 -> 58
    //   128: astore 5
    //   130: aload_0
    //   131: monitorexit
    //   132: aload 5
    //   134: athrow
    //   135: astore 8
    //   137: aload 4
    //   139: aload 8
    //   141: getfield 304	com/purplebrain/adbuddiz/sdk/b/b:b	Lcom/purplebrain/adbuddiz/sdk/AdBuddizRewardedVideoError;
    //   144: aload 8
    //   146: getfield 342	com/purplebrain/adbuddiz/sdk/b/b:c	Ljava/lang/String;
    //   149: iconst_0
    //   150: iload_2
    //   151: invokestatic 69	com/purplebrain/adbuddiz/sdk/c/b:a	(Lcom/purplebrain/adbuddiz/sdk/f/d;Lcom/purplebrain/adbuddiz/sdk/AdBuddizRewardedVideoError;Ljava/lang/String;ZZ)V
    //   154: iconst_0
    //   155: istore_3
    //   156: goto -36 -> 120
    //   159: aload 4
    //   161: getstatic 345	com/purplebrain/adbuddiz/sdk/AdBuddizRewardedVideoError:UNKNOWN_EXCEPTION_RAISED	Lcom/purplebrain/adbuddiz/sdk/AdBuddizRewardedVideoError;
    //   164: aconst_null
    //   165: iconst_0
    //   166: iload_2
    //   167: invokestatic 69	com/purplebrain/adbuddiz/sdk/c/b:a	(Lcom/purplebrain/adbuddiz/sdk/f/d;Lcom/purplebrain/adbuddiz/sdk/AdBuddizRewardedVideoError;Ljava/lang/String;ZZ)V
    //   170: ldc_w 347
    //   173: aload 7
    //   175: invokestatic 350	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   178: iconst_0
    //   179: istore_3
    //   180: goto -60 -> 120
    //   183: astore 7
    //   185: iload 10
    //   187: istore_2
    //   188: goto -29 -> 159
    //   191: astore 8
    //   193: iload 10
    //   195: istore_2
    //   196: goto -59 -> 137
    //   199: iload_2
    //   200: istore 10
    //   202: goto -102 -> 100
    //   205: astore 7
    //   207: goto -48 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	b
    //   0	210	1	paramContext	Context
    //   1	199	2	bool1	boolean
    //   3	177	3	bool2	boolean
    //   19	141	4	locald	com.purplebrain.adbuddiz.sdk.f.d
    //   128	5	5	localObject	Object
    //   25	96	6	localp	com.purplebrain.adbuddiz.sdk.i.p
    //   173	1	7	localThrowable1	Throwable
    //   183	1	7	localThrowable2	Throwable
    //   205	1	7	localThrowable3	Throwable
    //   135	10	8	localb1	com.purplebrain.adbuddiz.sdk.b.b
    //   191	1	8	localb2	com.purplebrain.adbuddiz.sdk.b.b
    //   90	3	9	bool3	boolean
    //   98	103	10	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   6	27	128	finally
    //   27	58	128	finally
    //   62	92	128	finally
    //   100	118	128	finally
    //   120	125	128	finally
    //   137	154	128	finally
    //   159	178	128	finally
    //   27	58	135	com/purplebrain/adbuddiz/sdk/b/b
    //   62	92	135	com/purplebrain/adbuddiz/sdk/b/b
    //   100	118	183	java/lang/Throwable
    //   100	118	191	com/purplebrain/adbuddiz/sdk/b/b
    //   27	58	205	java/lang/Throwable
    //   62	92	205	java/lang/Throwable
  }
  
  public final void c(final Context paramContext)
  {
    int i = 1;
    com.purplebrain.adbuddiz.sdk.f.d locald = new com.purplebrain.adbuddiz.sdk.f.d(d.a.f, "Default");
    if (paramContext == null) {}
    try
    {
      a(locald, AdBuddizRewardedVideoError.ACTIVITY_PARAMETER_IS_NULL, null);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      a(locald, AdBuddizRewardedVideoError.MISSING_ADBUDDIZ_ACTIVITY_IN_MANIFEST, null);
      return;
      x.a(paramContext);
      if (Looper.getMainLooper().equals(Looper.myLooper())) {
        break label127;
      }
      if (paramContext != null) {
        break label84;
      }
      a(locald, AdBuddizRewardedVideoError.ACTIVITY_PARAMETER_IS_NULL, null);
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          b.this.c(paramContext);
        }
      });
      return;
    }
    catch (Throwable localThrowable)
    {
      label84:
      a(locald, AdBuddizRewardedVideoError.UNKNOWN_EXCEPTION_RAISED, null);
      com.purplebrain.adbuddiz.sdk.i.o.a("AdBuddiz.RewardedVideo.show() Exception: ", localThrowable);
      return;
    }
    if (this.a == null)
    {
      a(locald, AdBuddizRewardedVideoError.FETCH_VIDEO_AD_NOT_CALLED, null);
      return;
    }
    label127:
    com.purplebrain.adbuddiz.sdk.i.o.a("show");
    for (;;)
    {
      try
      {
        e(paramContext);
        this.a = paramContext;
        a.a().a = this.a;
        com.purplebrain.adbuddiz.sdk.i.j.a(paramContext);
        locala = com.purplebrain.adbuddiz.sdk.e.a.a().a(paramContext, true);
        com.purplebrain.adbuddiz.sdk.i.p.a(true).c();
        com.purplebrain.adbuddiz.sdk.i.a locala1 = new com.purplebrain.adbuddiz.sdk.i.a(paramContext);
        locala1.a = locala;
        locala1.b = "Default";
        Intent localIntent = locala1.a();
        this.a.startActivity(localIntent);
      }
      catch (com.purplebrain.adbuddiz.sdk.b.p localp2)
      {
        final com.purplebrain.adbuddiz.sdk.f.a.a locala;
        AdBuddizRewardedVideoError localAdBuddizRewardedVideoError;
        Object localObject2;
        Object localObject1;
        j = 0;
        continue;
      }
      catch (com.purplebrain.adbuddiz.sdk.b.b localb2)
      {
        int j = 0;
        continue;
      }
      try
      {
        new Thread(new Runnable()
        {
          public final void run()
          {
            try
            {
              c.a(b.a(b.this), locala);
              com.purplebrain.adbuddiz.sdk.e.b.a().d();
              return;
            }
            catch (Throwable localThrowable)
            {
              l.a("AdBuddiz._saveViewAndUpdateConfigAsync", null, localThrowable);
              com.purplebrain.adbuddiz.sdk.i.o.a("AdBuddiz.RewardedVideo._saveViewAndUpdateConfigAsync() Exception: ", localThrowable);
            }
          }
        }).start();
        localAdBuddizRewardedVideoError = null;
        j = i;
        if (j != 0) {
          continue;
        }
        if ((this.b == null) || (!h.a(this.b, 500))) {
          continue;
        }
        if ((i == 0) || (!b(localAdBuddizRewardedVideoError))) {
          continue;
        }
        new Thread(new Runnable()
        {
          public final void run()
          {
            try
            {
              long l1 = System.currentTimeMillis();
              b.b().d();
              com.purplebrain.adbuddiz.sdk.i.o.a("show() called right after fetch(), waiting for SDK startup.");
              for (;;)
              {
                long l2 = System.currentTimeMillis();
                if (l2 - l1 < 5000L) {}
                try
                {
                  boolean bool = b.a(b.d(paramContext));
                  if (!bool)
                  {
                    b.b().b = null;
                    b.this.c(paramContext);
                    return;
                  }
                  Thread.sleep(100L);
                }
                catch (InterruptedException localInterruptedException) {}
              }
              return;
            }
            catch (Throwable localThrowable)
            {
              l.a("AdBuddiz._dispatchShowDelayed", null, localThrowable);
              com.purplebrain.adbuddiz.sdk.i.o.a("AdBuddiz.RewardedVideo._dispatchShowDelayed() Exception: ", localThrowable);
            }
          }
        }).start();
        return;
      }
      catch (com.purplebrain.adbuddiz.sdk.b.b localb1)
      {
        j = i;
        continue;
      }
      catch (com.purplebrain.adbuddiz.sdk.b.p localp1)
      {
        j = i;
        continue;
      }
      com.purplebrain.adbuddiz.sdk.e.a.a().b(true);
      a(locald, ((com.purplebrain.adbuddiz.sdk.b.b)localObject2).b, ((com.purplebrain.adbuddiz.sdk.b.b)localObject2).c);
      localAdBuddizRewardedVideoError = ((com.purplebrain.adbuddiz.sdk.b.b)localObject2).b;
      continue;
      a(locald, ((com.purplebrain.adbuddiz.sdk.b.b)localObject1).b, ((com.purplebrain.adbuddiz.sdk.b.b)localObject1).c);
      localAdBuddizRewardedVideoError = ((com.purplebrain.adbuddiz.sdk.b.b)localObject1).b;
      continue;
      i = 0;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */