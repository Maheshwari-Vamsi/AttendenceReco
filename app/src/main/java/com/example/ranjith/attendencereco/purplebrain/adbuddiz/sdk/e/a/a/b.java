package com.purplebrain.adbuddiz.sdk.e.a.a;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.b.h;
import com.purplebrain.adbuddiz.sdk.e.c;
import com.purplebrain.adbuddiz.sdk.f.a.a;
import com.purplebrain.adbuddiz.sdk.h.i;
import com.purplebrain.adbuddiz.sdk.h.i.a;
import com.purplebrain.adbuddiz.sdk.i.f;
import com.purplebrain.adbuddiz.sdk.i.m;
import com.purplebrain.adbuddiz.sdk.i.o;
import com.purplebrain.adbuddiz.sdk.i.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b
{
  public a a = null;
  public boolean b = false;
  public i.a c = null;
  public String d = null;
  public Object e = new Object();
  public i f = null;
  public boolean g = false;
  public boolean h = false;
  private c i = null;
  
  protected b(c paramc)
  {
    this.i = paramc;
  }
  
  private a b(Context paramContext)
  {
    String str = m.c(paramContext, a());
    if (str == null) {
      return null;
    }
    try
    {
      a locala = a.a(new JSONObject(f.b(str)));
      return locala;
    }
    catch (h localh) {}
    return null;
  }
  
  public final a a(Context paramContext)
  {
    if (this.a == null) {}
    try
    {
      a locala2 = b(paramContext);
      locala1 = locala2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        m.d(paramContext, a());
        a locala1 = null;
      }
    }
    this.a = locala1;
    return this.a;
  }
  
  public abstract String a();
  
  public final void a(Context paramContext, a parama)
  {
    String str = f.c(parama.a().toString());
    m.a(paramContext, a(), str);
  }
  
  public final void a(a parama)
  {
    try
    {
      this.a = parama;
      if (parama != null)
      {
        a(AdBuddiz.getContext(), parama);
        return;
      }
      m.d(AdBuddiz.getContext(), a());
      return;
    }
    catch (JSONException localJSONException)
    {
      this.a = null;
      m.d(AdBuddiz.getContext(), a());
      o.a("ABAdManager.setNextAdToShowAndSaveOnDisk() Exception :", localJSONException);
    }
  }
  
  public void a(i parami)
  {
    a(null);
    this.b = true;
    this.c = null;
    this.d = null;
    synchronized (this.e)
    {
      if (this.f == parami) {
        this.f = null;
      }
      return;
    }
  }
  
  public void a(i parami, i.a parama, String paramString)
  {
    a(null);
    this.b = true;
    this.c = parama;
    this.d = paramString;
    synchronized (this.e)
    {
      if ((this.f != null) && (this.f != parami)) {
        this.f.g();
      }
      this.f = null;
      return;
    }
  }
  
  public final void a(Collection paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb != this) && (localb.a != null)) {
        localArrayList.add(localb.a);
      }
    }
    this.i.a(this.a, localArrayList);
    a(null);
  }
  
  public abstract boolean b();
  
  public abstract boolean c();
  
  public abstract boolean d();
  
  public abstract p e();
  
  public abstract i f();
  
  public void g() {}
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\e\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */