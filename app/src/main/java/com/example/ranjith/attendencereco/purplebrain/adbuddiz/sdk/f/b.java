package com.purplebrain.adbuddiz.sdk.f;

import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.AdBuddizError;
import com.purplebrain.adbuddiz.sdk.b.h;
import com.purplebrain.adbuddiz.sdk.i.m;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public List A = new ArrayList();
  public List B = new ArrayList();
  public String C;
  public boolean D;
  public double E;
  public f F;
  public long a;
  public long b;
  public String c;
  public long d;
  public boolean e;
  public long f;
  public String g;
  public String h;
  public String i;
  public List j = new ArrayList();
  public int k;
  public int l;
  public int m;
  public int n;
  public long o;
  public int p = 0;
  public boolean q;
  public long r;
  public long s;
  public long t;
  public long u;
  public Long v;
  public long w;
  public Long x;
  public Long y;
  public long z;
  
  public static b a()
  {
    try
    {
      String str = m.e(AdBuddiz.getContext(), "ABZ_31_cfg.abz");
      if (str != null)
      {
        b localb = c.a(new JSONObject(com.purplebrain.adbuddiz.sdk.i.f.b(str)));
        return localb;
      }
    }
    catch (h localh)
    {
      return null;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  public final void a(String paramString)
  {
    int i1 = 0;
    this.a = System.currentTimeMillis();
    JSONObject localJSONObject = new JSONObject(paramString);
    this.b = localJSONObject.getLong("uf");
    this.d = localJSONObject.getLong("ce");
    this.c = localJSONObject.getString("a");
    this.e = localJSONObject.getBoolean("t");
    this.f = localJSONObject.getLong("pi");
    this.g = localJSONObject.getString("bu");
    this.h = localJSONObject.getString("vbu");
    this.i = localJSONObject.getString("ba");
    this.j.clear();
    JSONArray localJSONArray1 = localJSONObject.getJSONArray("ip");
    for (int i2 = 0; i2 < localJSONArray1.length(); i2++)
    {
      String str = localJSONArray1.getString(i2);
      this.j.add(str);
    }
    this.k = localJSONObject.getInt("aac");
    this.l = localJSONObject.getInt("rac");
    this.m = localJSONObject.getInt("naits");
    this.n = localJSONObject.getInt("nrits");
    this.o = localJSONObject.getInt("mkri");
    this.p = localJSONObject.getInt("ai");
    this.q = localJSONObject.getBoolean("ah");
    this.r = localJSONObject.getLong("msa");
    this.s = localJSONObject.getLong("mir");
    this.t = localJSONObject.getLong("mna");
    this.u = localJSONObject.getLong("mc");
    Long localLong1;
    if (localJSONObject.has("mcei")) {
      localLong1 = Long.valueOf(localJSONObject.getLong("mcei"));
    }
    for (;;)
    {
      this.v = localLong1;
      this.w = localJSONObject.getLong("mcfl");
      Long localLong2;
      label322:
      JSONArray localJSONArray2;
      int i3;
      if (localJSONObject.has("mcm"))
      {
        localLong2 = Long.valueOf(localJSONObject.getLong("mcm"));
        this.x = localLong2;
        boolean bool = localJSONObject.has("mcmfl");
        Long localLong3 = null;
        if (bool) {
          localLong3 = Long.valueOf(localJSONObject.getLong("mcmfl"));
        }
        this.y = localLong3;
        this.z = localJSONObject.getLong("mcms");
        this.A.clear();
        localJSONArray2 = localJSONObject.getJSONArray("sae");
        i3 = 0;
        label391:
        if (i3 >= localJSONArray2.length()) {
          break label439;
        }
      }
      try
      {
        this.A.add(AdBuddizError.valueOf(localJSONArray2.getString(i3)));
        i3++;
        break label391;
        localLong1 = null;
        continue;
        localLong2 = null;
        break label322;
        label439:
        this.B.clear();
        JSONArray localJSONArray3 = localJSONObject.getJSONArray("ire");
        for (;;)
        {
          if (i1 < localJSONArray3.length()) {}
          try
          {
            this.B.add(AdBuddizError.valueOf(localJSONArray3.getString(i1)));
            i1++;
            continue;
            if (localJSONObject.has("afs")) {
              this.C = localJSONObject.getString("afs");
            }
            this.D = localJSONObject.getBoolean("mpm");
            this.E = localJSONObject.getDouble("pbnr");
            this.F = f.a(localJSONObject.getJSONObject("mfsp"));
            return;
          }
          catch (IllegalArgumentException localIllegalArgumentException1)
          {
            for (;;) {}
          }
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        for (;;) {}
      }
    }
  }
  
  public final boolean a(a parama)
  {
    return (parama.f & this.p) != 0;
  }
  
  public final boolean b()
  {
    return (this.a + this.d < System.currentTimeMillis()) || (this.a > System.currentTimeMillis());
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */