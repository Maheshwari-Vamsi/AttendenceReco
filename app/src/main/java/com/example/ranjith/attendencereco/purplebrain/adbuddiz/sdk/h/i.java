package com.purplebrain.adbuddiz.sdk.h;

import android.content.Context;
import android.graphics.Point;
import android.location.Location;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.AdBuddizError;
import com.purplebrain.adbuddiz.sdk.AdBuddizRewardedVideoError;
import com.purplebrain.adbuddiz.sdk.h.a.a.a;
import com.purplebrain.adbuddiz.sdk.h.a.b;
import com.purplebrain.adbuddiz.sdk.h.a.b.a;
import com.purplebrain.adbuddiz.sdk.h.a.c.a;
import com.purplebrain.adbuddiz.sdk.h.a.d.a;
import com.purplebrain.adbuddiz.sdk.i.a.f;
import com.purplebrain.adbuddiz.sdk.i.g;
import com.purplebrain.adbuddiz.sdk.i.p;
import com.purplebrain.adbuddiz.sdk.i.u;
import com.purplebrain.adbuddiz.sdk.i.w;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i
  extends a
{
  public boolean e;
  public com.purplebrain.adbuddiz.sdk.f.a.a f = null;
  public b g = null;
  
  private boolean i()
  {
    p localp = p.a(this.e);
    boolean bool = localp.f();
    if (bool) {}
    try
    {
      Thread.sleep(100L);
      bool = localp.f();
      return bool;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  protected final void c()
  {
    Object localObject1 = null;
    boolean bool1;
    URL localURL;
    Context localContext;
    JSONObject localJSONObject1;
    Location localLocation;
    com.purplebrain.adbuddiz.sdk.h.a.c localc;
    JSONArray localJSONArray;
    try
    {
      bool1 = i();
      localURL = w.d();
      localContext = AdBuddiz.getContext();
      localJSONObject1 = new JSONObject();
      new a.a();
      localJSONObject1.put("a", a.a.a(localContext).a());
      new b.a();
      localJSONObject1.put("d", b.a.a(localContext).a());
      new d.a();
      localJSONObject1.put("s", d.a.a(localContext).a());
      new c.a();
      localLocation = f.a(localContext);
      if (localLocation == null)
      {
        localc = null;
        if (localc != null)
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("a", localc.a);
          localJSONObject2.put("o", localc.b);
          localJSONObject2.put("t", localc.c);
          localJSONObject2.put("p", localc.d);
          localJSONObject1.put("g", g.a(localJSONObject2.toString()));
        }
        List localList = com.purplebrain.adbuddiz.sdk.i.a.j.a(localContext);
        if (localList.isEmpty()) {
          break label346;
        }
        localJSONArray = new JSONArray();
        Iterator localIterator = localList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localJSONArray.put((String)localIterator.next());
            continue;
            if (localObject1 == null) {
              break;
            }
          }
        }
      }
    }
    finally {}
    for (;;)
    {
      ((HttpURLConnection)localObject1).disconnect();
      throw ((Throwable)localObject2);
      localc = new com.purplebrain.adbuddiz.sdk.h.a.c();
      localc.a = localLocation.getLatitude();
      localc.b = localLocation.getLongitude();
      localc.c = localLocation.getTime();
      localc.d = localLocation.getProvider();
      break;
      localJSONObject1.put("p", g.a(localJSONArray.toString()));
      label346:
      localJSONObject1.put("in", this.e);
      localJSONObject1.put("sd", bool1);
      localJSONObject1.put("tm", u.a(localContext));
      Point localPoint = com.purplebrain.adbuddiz.sdk.i.j.h(localContext);
      localJSONObject1.put("mw", localPoint.x);
      localJSONObject1.put("mh", localPoint.y);
      localJSONObject1.put("or", com.purplebrain.adbuddiz.sdk.i.a.d.a().d);
      localJSONObject1.put("ai", com.purplebrain.adbuddiz.sdk.i.b.c.a(localContext, false, this.f));
      localJSONObject1.put("ri", com.purplebrain.adbuddiz.sdk.i.b.c.a(localContext, false));
      if (this.e)
      {
        localJSONObject1.put("aii", com.purplebrain.adbuddiz.sdk.i.b.c.a(localContext, true, this.f));
        localJSONObject1.put("rii", com.purplebrain.adbuddiz.sdk.i.b.c.a(localContext, true));
      }
      localJSONObject1.put("aia", com.purplebrain.adbuddiz.sdk.i.b.a.a(localContext));
      localJSONObject1.put("uc", com.purplebrain.adbuddiz.sdk.i.b.d.b(localContext, "uc"));
      localJSONObject1.put("r", com.purplebrain.adbuddiz.sdk.i.b.e.a(localContext));
      localJSONObject1.put("t", System.currentTimeMillis());
      HttpURLConnection localHttpURLConnection = b(localURL, localJSONObject1.toString());
      try
      {
        int i = localHttpURLConnection.getResponseCode();
        if (i >= 500) {
          throw new k("Server Error : " + i);
        }
        boolean bool2 = b();
        if (bool2) {
          if (localHttpURLConnection != null) {
            localHttpURLConnection.disconnect();
          }
        }
        for (;;)
        {
          return;
          if (i == 204) {
            this.g.a(this);
          }
          while (localHttpURLConnection != null)
          {
            localHttpURLConnection.disconnect();
            return;
            if (i == 200)
            {
              String str1 = b(localHttpURLConnection);
              JSONObject localJSONObject3 = new JSONObject(str1);
              if (localJSONObject3.has("at"))
              {
                com.purplebrain.adbuddiz.sdk.f.a.a locala1 = com.purplebrain.adbuddiz.sdk.f.a.a.a(new JSONObject(str1));
                locala1.b = this.e;
                this.g.a(this, locala1);
              }
              else
              {
                a locala = a.a(localJSONObject3.getString("c"));
                boolean bool3 = localJSONObject3.has("d");
                String str2 = null;
                if (bool3) {
                  str2 = localJSONObject3.getString("d");
                }
                this.g.a(this, locala, str2);
              }
            }
          }
        }
      }
      finally
      {
        localObject1 = localHttpURLConnection;
      }
    }
  }
  
  protected final boolean d()
  {
    return false;
  }
  
  protected final String e()
  {
    return "NextAd";
  }
  
  public static enum a
  {
    public AdBuddizError e;
    public AdBuddizRewardedVideoError f;
    private String g;
    
    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      h = arrayOfa;
    }
    
    private a(String paramString1, AdBuddizError paramAdBuddizError, AdBuddizRewardedVideoError paramAdBuddizRewardedVideoError)
    {
      this.g = paramString1;
      this.e = paramAdBuddizError;
      this.f = paramAdBuddizRewardedVideoError;
    }
    
    public static a a(String paramString)
    {
      for (a locala : (a[])h.clone()) {
        if (locala.g.equals(paramString)) {
          return locala;
        }
      }
      return null;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(i parami);
    
    public abstract void a(i parami, com.purplebrain.adbuddiz.sdk.f.a.a parama);
    
    public abstract void a(i parami, i.a parama, String paramString);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\h\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */