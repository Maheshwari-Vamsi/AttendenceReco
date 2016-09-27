package com.purplebrain.adbuddiz.sdk.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.OrientationEventListener;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.AdBuddizError;
import com.purplebrain.adbuddiz.sdk.b.j;
import com.purplebrain.adbuddiz.sdk.b.k;
import com.purplebrain.adbuddiz.sdk.b.s;
import com.purplebrain.adbuddiz.sdk.f.d.a;
import com.purplebrain.adbuddiz.sdk.h.i.a;
import com.purplebrain.adbuddiz.sdk.h.i.b;
import com.purplebrain.adbuddiz.sdk.i.b.c.a.1;
import com.purplebrain.adbuddiz.sdk.i.i.2;
import com.purplebrain.adbuddiz.sdk.i.m;
import com.purplebrain.adbuddiz.sdk.i.o;
import com.purplebrain.adbuddiz.sdk.i.r;
import com.purplebrain.adbuddiz.sdk.i.r.2;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static a h = null;
  public com.purplebrain.adbuddiz.sdk.e.a.a.a a = null;
  public com.purplebrain.adbuddiz.sdk.e.a.a.c b = null;
  private c c = null;
  private boolean d = false;
  private com.purplebrain.adbuddiz.sdk.f.a.a e = null;
  private List f = null;
  private OrientationEventListener g = null;
  private com.purplebrain.adbuddiz.sdk.h.b.a i = new com.purplebrain.adbuddiz.sdk.h.b.a()
  {
    public final void a(com.purplebrain.adbuddiz.sdk.h.b paramAnonymousb)
    {
      com.purplebrain.adbuddiz.sdk.e.a.a.b localb = a.a(a.this, ((com.purplebrain.adbuddiz.sdk.h.i)paramAnonymousb).e);
      synchronized (localb.f)
      {
        if (localb.f == paramAnonymousb) {
          localb.f = null;
        }
        return;
      }
    }
  };
  private i.b j = new i.b()
  {
    public final void a(com.purplebrain.adbuddiz.sdk.h.i paramAnonymousi)
    {
      a.a(a.this, paramAnonymousi.e).a(paramAnonymousi);
    }
    
    public final void a(com.purplebrain.adbuddiz.sdk.h.i paramAnonymousi, com.purplebrain.adbuddiz.sdk.f.a.a paramAnonymousa)
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = paramAnonymousa.b();
      arrayOfObject1[1] = Boolean.valueOf(paramAnonymousi.e);
      com.purplebrain.adbuddiz.sdk.e.a.a.b localb = a.a(a.this, paramAnonymousi.e);
      localb.b = false;
      localb.c = null;
      localb.d = null;
      synchronized (localb.e)
      {
        if ((localb.f != null) && (localb.f != paramAnonymousi)) {
          localb.f.g();
        }
        localb.f = null;
        if (paramAnonymousa.e() == com.purplebrain.adbuddiz.sdk.f.a.e.c)
        {
          com.purplebrain.adbuddiz.sdk.f.a.f localf = (com.purplebrain.adbuddiz.sdk.f.a.f)paramAnonymousa;
          com.purplebrain.adbuddiz.sdk.f.b localb2 = b.a().b();
          if (localf.g.length() > localb2.l)
          {
            Object[] arrayOfObject2 = new Object[2];
            arrayOfObject2[0] = Integer.valueOf(localf.g.length());
            arrayOfObject2[1] = Integer.valueOf(localb2.l);
            com.purplebrain.adbuddiz.sdk.h.g localg = new com.purplebrain.adbuddiz.sdk.h.g();
            localg.g = paramAnonymousa;
            localg.a(AdBuddizError.INVALID_AD);
            localg.i = new com.purplebrain.adbuddiz.sdk.f.d(d.a.a, null);
            Object[] arrayOfObject3 = new Object[2];
            arrayOfObject3[0] = Integer.valueOf(localf.g.length());
            arrayOfObject3[1] = Integer.valueOf(localb2.l);
            localg.h = String.format("RTB ad content size is over the limit fixed in the configuration. %d > %d", arrayOfObject3);
            localg.f();
            a.a(a.this, localb);
            return;
          }
        }
      }
      if (a.b(paramAnonymousa))
      {
        Context localContext = AdBuddiz.getContext();
        com.purplebrain.adbuddiz.sdk.f.a.b localb1 = (com.purplebrain.adbuddiz.sdk.f.a.b)paramAnonymousa;
        new JSONArray();
        try
        {
          JSONArray localJSONArray = com.purplebrain.adbuddiz.sdk.i.b.d.b(localContext, "aia");
          localJSONArray.put(localb1.f);
          com.purplebrain.adbuddiz.sdk.i.b.d.a(localContext, "aia", localJSONArray);
          a.a(a.this, localb);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            o.a("ABAlreadyInstalledApps.appendAlreadyInstalledApp()", localJSONException);
          }
        }
      }
      localb.a(paramAnonymousa);
      a.b(a.this).a(paramAnonymousa);
    }
    
    public final void a(com.purplebrain.adbuddiz.sdk.h.i paramAnonymousi, i.a paramAnonymousa, String paramAnonymousString)
    {
      new Object[] { paramAnonymousa, paramAnonymousString };
      a.a(a.this, paramAnonymousi.e).a(paramAnonymousi, paramAnonymousa, paramAnonymousString);
    }
  };
  private b.a k = new b.a()
  {
    public final void a()
    {
      b.a().a(null);
      Iterator localIterator = a.c(a.this).iterator();
      while (localIterator.hasNext())
      {
        com.purplebrain.adbuddiz.sdk.e.a.a.b localb = (com.purplebrain.adbuddiz.sdk.e.a.a.b)localIterator.next();
        com.purplebrain.adbuddiz.sdk.f.a.a locala = localb.a;
        if ((localb.g) && (locala == null)) {
          a.a(a.this, localb);
        }
        if ((localb.h) && (locala != null)) {
          a.b(a.this).a(locala);
        }
        localb.g = false;
        localb.h = false;
      }
    }
  };
  private c.b l = new c.b()
  {
    public final void a(com.purplebrain.adbuddiz.sdk.f.a.a paramAnonymousa)
    {
      com.purplebrain.adbuddiz.sdk.e.a.a.b localb = a.a(a.this, paramAnonymousa.b);
      if (paramAnonymousa == localb.a) {}
      try
      {
        localb.a(AdBuddiz.getContext(), paramAnonymousa);
        return;
      }
      catch (JSONException localJSONException)
      {
        o.a("ABAdManager.onNextAdModificationListener onResourceChanged()", localJSONException);
      }
    }
  };
  private c.a m = new c.a()
  {
    public final void a(com.purplebrain.adbuddiz.sdk.f.a.a paramAnonymousa)
    {
      if (!paramAnonymousa.b)
      {
        com.purplebrain.adbuddiz.sdk.i.i.a(new i.2());
        return;
      }
      r.a(new r.2());
    }
    
    public final void a(com.purplebrain.adbuddiz.sdk.f.a.a paramAnonymousa, Exception paramAnonymousException)
    {
      com.purplebrain.adbuddiz.sdk.f.b localb = b.a().b();
      if ((localb != null) && (localb.A.contains(AdBuddizError.INVALID_AD)))
      {
        com.purplebrain.adbuddiz.sdk.f.d locald = new com.purplebrain.adbuddiz.sdk.f.d(d.a.a, null);
        com.purplebrain.adbuddiz.sdk.h.g localg = new com.purplebrain.adbuddiz.sdk.h.g();
        localg.g = paramAnonymousa;
        localg.a(AdBuddizError.INVALID_AD);
        localg.i = locald;
        localg.a(paramAnonymousException);
        localg.f();
      }
      a.this.b(paramAnonymousa.b);
    }
  };
  
  public a()
  {
    this.c.a = this.l;
    this.c.b = this.m;
    this.a = new com.purplebrain.adbuddiz.sdk.e.a.a.a(this.c);
    this.b = new com.purplebrain.adbuddiz.sdk.e.a.a.c(this.c);
    this.f = new ArrayList();
    this.f.add(this.a);
    this.f.add(this.b);
  }
  
  public static a a()
  {
    if (h == null) {}
    try
    {
      if (h == null) {
        h = new a();
      }
      return h;
    }
    finally {}
  }
  
  private com.purplebrain.adbuddiz.sdk.f.a.a a(com.purplebrain.adbuddiz.sdk.e.a.a.b paramb)
  {
    com.purplebrain.adbuddiz.sdk.f.a.a locala = b(paramb);
    com.purplebrain.adbuddiz.sdk.f.e locale = com.purplebrain.adbuddiz.sdk.i.a.d.a();
    if (!locala.f().e.a(locala, locale)) {
      throw new com.purplebrain.adbuddiz.sdk.b.e();
    }
    return locala;
  }
  
  private void a(com.purplebrain.adbuddiz.sdk.e.a.a.b paramb, com.purplebrain.adbuddiz.sdk.f.a.a parama)
  {
    int n = 1;
    com.purplebrain.adbuddiz.sdk.i.p localp = paramb.e();
    if (paramb.b)
    {
      if ((localp.c != null) && (System.currentTimeMillis() - localp.c.longValue() < com.purplebrain.adbuddiz.sdk.i.p.b())) {}
      while (n != 0)
      {
        paramb.g();
        return;
        n = 0;
      }
    }
    com.purplebrain.adbuddiz.sdk.h.i locali1;
    synchronized (paramb.e)
    {
      paramb.g = false;
      locali1 = paramb.f;
      if ((locali1 != null) && (!locali1.b()) && (locali1.a() < 4)) {
        return;
      }
    }
    try
    {
      b.a().c();
      if (paramb.a != null) {
        paramb.a(this.f);
      }
      localp.c = Long.valueOf(System.currentTimeMillis());
      if (locali1 != null) {
        locali1.g();
      }
      com.purplebrain.adbuddiz.sdk.h.i locali2 = paramb.f();
      locali2.f = parama;
      locali2.g = this.j;
      locali2.a(this.i);
      locali2.f();
      paramb.f = locali2;
    }
    catch (k localk)
    {
      for (;;)
      {
        paramb.g = true;
        b.a().a(this.k);
      }
    }
    catch (j localj)
    {
      for (;;)
      {
        paramb.g = true;
        b.a().a(this.k);
      }
    }
    catch (com.purplebrain.adbuddiz.sdk.b.i locali)
    {
      for (;;) {}
    }
  }
  
  public static boolean a(com.purplebrain.adbuddiz.sdk.f.a.a parama)
  {
    if (parama == null) {}
    long l1;
    do
    {
      return true;
      l1 = com.purplebrain.adbuddiz.sdk.i.h.a().getTime();
    } while ((parama.i() > l1) || (parama.i() + parama.j() < l1));
    return false;
  }
  
  private static com.purplebrain.adbuddiz.sdk.f.a.a b(Context paramContext)
  {
    String str = m.c(paramContext, "prev");
    if (str == null) {
      return null;
    }
    try
    {
      com.purplebrain.adbuddiz.sdk.f.a.a locala = com.purplebrain.adbuddiz.sdk.f.a.a.a(new JSONObject(com.purplebrain.adbuddiz.sdk.i.f.b(str)));
      return locala;
    }
    catch (com.purplebrain.adbuddiz.sdk.b.h localh) {}
    return null;
  }
  
  private com.purplebrain.adbuddiz.sdk.f.a.a b(com.purplebrain.adbuddiz.sdk.e.a.a.b paramb)
  {
    if (!this.d) {
      throw new k();
    }
    com.purplebrain.adbuddiz.sdk.f.a.a locala;
    com.purplebrain.adbuddiz.sdk.h.i locali;
    try
    {
      locala = paramb.a;
      locali = paramb.f;
      if (paramb.c != null) {
        throw new com.purplebrain.adbuddiz.sdk.b.c(paramb.c, paramb.d);
      }
    }
    catch (com.purplebrain.adbuddiz.sdk.b.b localb)
    {
      if (paramb.d()) {
        a(paramb, null);
      }
      throw localb;
    }
    if (paramb.b) {
      throw new com.purplebrain.adbuddiz.sdk.b.p();
    }
    if ((locala != null) && (a(locala))) {
      throw new com.purplebrain.adbuddiz.sdk.b.f();
    }
    if ((locala == null) && (locali == null)) {
      throw new s();
    }
    if ((locala == null) && (locali != null)) {
      throw new com.purplebrain.adbuddiz.sdk.b.g();
    }
    return locala;
  }
  
  private com.purplebrain.adbuddiz.sdk.e.a.a.b c(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.b;
    }
    return this.a;
  }
  
  private void c(com.purplebrain.adbuddiz.sdk.e.a.a.b paramb)
  {
    paramb.a(this.f);
    a(paramb, null);
  }
  
  private void c(com.purplebrain.adbuddiz.sdk.f.a.a parama)
  {
    try
    {
      this.e = parama;
      if (parama != null)
      {
        m.a(AdBuddiz.getContext(), "prev", com.purplebrain.adbuddiz.sdk.i.f.c(parama.a().toString()));
        return;
      }
      m.d(AdBuddiz.getContext(), "prev");
      return;
    }
    catch (JSONException localJSONException)
    {
      this.e = null;
      m.d(AdBuddiz.getContext(), "prev");
      o.a("ABAdManager.setLastDismissedAdAndSaveOnDisk() Exception :", localJSONException);
    }
  }
  
  public final com.purplebrain.adbuddiz.sdk.f.a.a a(Context paramContext, boolean paramBoolean)
  {
    com.purplebrain.adbuddiz.sdk.e.a.a.b localb = c(paramBoolean);
    com.purplebrain.adbuddiz.sdk.f.a.a locala = a(localb);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((com.purplebrain.adbuddiz.sdk.e.a.a.b)localIterator.next()).a);
    }
    this.c.a(this.e, localArrayList);
    c(locala);
    localb.a(null);
    if (localb.b()) {
      a(localb, locala);
    }
    com.purplebrain.adbuddiz.sdk.f.b localb1 = b.a().b();
    new Thread(new c.a.1(new com.purplebrain.adbuddiz.sdk.i.b.c.a(paramContext, localb1.m, localb1.n))).start();
    return locala;
  }
  
  public final com.purplebrain.adbuddiz.sdk.f.a.a a(boolean paramBoolean)
  {
    return a(c(paramBoolean));
  }
  
  public final void a(final Context paramContext)
  {
    if (!this.d)
    {
      if (Build.VERSION.SDK_INT > 9) {
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          /* Error */
          public final void run()
          {
            // Byte code:
            //   0: aload_0
            //   1: getfield 16	com/purplebrain/adbuddiz/sdk/e/a$1:b	Lcom/purplebrain/adbuddiz/sdk/e/a;
            //   4: invokestatic 29	com/purplebrain/adbuddiz/sdk/e/a:a	(Lcom/purplebrain/adbuddiz/sdk/e/a;)Landroid/view/OrientationEventListener;
            //   7: astore_2
            //   8: aload_2
            //   9: ifnull +13 -> 22
            //   12: aload_0
            //   13: getfield 16	com/purplebrain/adbuddiz/sdk/e/a$1:b	Lcom/purplebrain/adbuddiz/sdk/e/a;
            //   16: invokestatic 29	com/purplebrain/adbuddiz/sdk/e/a:a	(Lcom/purplebrain/adbuddiz/sdk/e/a;)Landroid/view/OrientationEventListener;
            //   19: invokevirtual 34	android/view/OrientationEventListener:disable	()V
            //   22: aload_0
            //   23: getfield 16	com/purplebrain/adbuddiz/sdk/e/a$1:b	Lcom/purplebrain/adbuddiz/sdk/e/a;
            //   26: new 36	com/purplebrain/adbuddiz/sdk/e/a$a
            //   29: dup
            //   30: aload_0
            //   31: getfield 16	com/purplebrain/adbuddiz/sdk/e/a$1:b	Lcom/purplebrain/adbuddiz/sdk/e/a;
            //   34: aload_0
            //   35: getfield 18	com/purplebrain/adbuddiz/sdk/e/a$1:a	Landroid/content/Context;
            //   38: invokespecial 38	com/purplebrain/adbuddiz/sdk/e/a$a:<init>	(Lcom/purplebrain/adbuddiz/sdk/e/a;Landroid/content/Context;)V
            //   41: invokestatic 41	com/purplebrain/adbuddiz/sdk/e/a:a	(Lcom/purplebrain/adbuddiz/sdk/e/a;Landroid/view/OrientationEventListener;)Landroid/view/OrientationEventListener;
            //   44: pop
            //   45: aload_0
            //   46: getfield 16	com/purplebrain/adbuddiz/sdk/e/a$1:b	Lcom/purplebrain/adbuddiz/sdk/e/a;
            //   49: invokestatic 29	com/purplebrain/adbuddiz/sdk/e/a:a	(Lcom/purplebrain/adbuddiz/sdk/e/a;)Landroid/view/OrientationEventListener;
            //   52: invokevirtual 44	android/view/OrientationEventListener:enable	()V
            //   55: return
            //   56: astore_1
            //   57: ldc 46
            //   59: aconst_null
            //   60: aload_1
            //   61: invokestatic 51	com/purplebrain/adbuddiz/sdk/i/l:a	(Ljava/lang/String;Lcom/purplebrain/adbuddiz/sdk/f/a/a;Ljava/lang/Throwable;)V
            //   64: ldc 53
            //   66: aload_1
            //   67: invokestatic 58	com/purplebrain/adbuddiz/sdk/i/o:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
            //   70: return
            //   71: astore 4
            //   73: goto -51 -> 22
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	76	0	this	1
            //   56	11	1	localThrowable	Throwable
            //   7	2	2	localOrientationEventListener	OrientationEventListener
            //   71	1	4	localIllegalArgumentException	IllegalArgumentException
            // Exception table:
            //   from	to	target	type
            //   0	8	56	java/lang/Throwable
            //   12	22	56	java/lang/Throwable
            //   22	55	56	java/lang/Throwable
            //   12	22	71	java/lang/IllegalArgumentException
          }
        });
      }
      this.d = true;
    }
  }
  
  public final void a(Context paramContext, com.purplebrain.adbuddiz.sdk.e.a.a.b paramb)
  {
    localObject = null;
    locala1 = paramb.a(paramContext);
    if (this.e == null) {}
    try
    {
      com.purplebrain.adbuddiz.sdk.f.a.a locala3 = b(paramContext);
      locala2 = locala3;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        m.d(paramContext, "prev");
        com.purplebrain.adbuddiz.sdk.f.a.a locala2 = null;
        continue;
        if (a(locala1))
        {
          c(paramb);
          localObject = null;
        }
        else
        {
          if (paramb.c())
          {
            com.purplebrain.adbuddiz.sdk.f.e locale = com.purplebrain.adbuddiz.sdk.i.a.d.a();
            boolean bool;
            if (locala1 == null) {
              bool = false;
            }
            for (;;)
            {
              if (!bool)
              {
                c(paramb);
                localObject = null;
                break;
                bool = locala1.c().a(locale);
                continue;
                this.c.a((com.purplebrain.adbuddiz.sdk.f.a.a)localObject);
                return;
              }
            }
          }
          localObject = locala1;
        }
      }
    }
    this.e = locala2;
    if (locala1 == null)
    {
      c(paramb);
      if (localObject != null)
      {
        if (b.a().b() != null) {
          break label153;
        }
        paramb.h = true;
        b.a().a(this.k);
      }
    }
  }
  
  public final void b()
  {
    Iterator localIterator1 = this.f.iterator();
    while (localIterator1.hasNext()) {
      ((com.purplebrain.adbuddiz.sdk.e.a.a.b)localIterator1.next()).a(null);
    }
    c(null);
    for (com.purplebrain.adbuddiz.sdk.f.a.e locale : com.purplebrain.adbuddiz.sdk.f.a.e.a())
    {
      Iterator localIterator2 = m.a(AdBuddiz.getContext(), locale, true).iterator();
      while (localIterator2.hasNext()) {
        ((File)localIterator2.next()).delete();
      }
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    c(c(paramBoolean));
  }
  
  @SuppressLint({"NewApi"})
  private final class a
    extends OrientationEventListener
  {
    private com.purplebrain.adbuddiz.sdk.f.e b = com.purplebrain.adbuddiz.sdk.i.a.d.a();
    private int c = 0;
    
    public a(Context paramContext)
    {
      super(3);
    }
    
    public final void onOrientationChanged(int paramInt)
    {
      if (this.c % 20 == 0)
      {
        com.purplebrain.adbuddiz.sdk.f.e locale = com.purplebrain.adbuddiz.sdk.i.a.d.a();
        if (this.b != locale)
        {
          Iterator localIterator = a.c(a.this).iterator();
          while (localIterator.hasNext())
          {
            com.purplebrain.adbuddiz.sdk.e.a.a.b localb = (com.purplebrain.adbuddiz.sdk.e.a.a.b)localIterator.next();
            if (localb.c())
            {
              com.purplebrain.adbuddiz.sdk.f.a.a locala = localb.a;
              if ((locala != null) && (!locala.c().a(locale)))
              {
                localb.a(a.c(a.this));
                a.a(a.this, localb);
              }
            }
          }
          this.b = locale;
        }
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */