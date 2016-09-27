package com.purplebrain.adbuddiz.sdk.f.a;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.i.b.c;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class b
  extends a
{
  public long f;
  public long g;
  public boolean h;
  public String i;
  public String j;
  public com.purplebrain.adbuddiz.sdk.f.e k;
  
  public final void a(Context paramContext, JSONObject paramJSONObject)
  {
    super.a(paramContext, paramJSONObject);
    paramJSONObject.put("ia", this.f);
    paramJSONObject.put("ai", c.a(paramContext, this, false));
    if (this.b) {
      paramJSONObject.put("aii", c.a(paramContext, this, true));
    }
  }
  
  public final String b()
  {
    return Long.toString(this.f);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    this.f = paramJSONObject.getLong("i");
    this.g = paramJSONObject.getLong("c");
    this.h = paramJSONObject.getBoolean("t");
    this.i = paramJSONObject.getString("p");
    this.j = paramJSONObject.getString("l");
    this.k = com.purplebrain.adbuddiz.sdk.f.e.a(paramJSONObject.getString("o"));
  }
  
  public final com.purplebrain.adbuddiz.sdk.f.e c()
  {
    return this.k;
  }
  
  public void c(JSONObject paramJSONObject)
  {
    paramJSONObject.put("i", this.f);
    paramJSONObject.put("c", this.g);
    paramJSONObject.put("t", this.h);
    paramJSONObject.put("p", this.i);
    paramJSONObject.put("l", this.j);
    paramJSONObject.put("o", this.k.d);
  }
  
  public Collection d()
  {
    try
    {
      if (this.k == com.purplebrain.adbuddiz.sdk.f.e.c)
      {
        com.purplebrain.adbuddiz.sdk.f.a.a.a[] arrayOfa2 = new com.purplebrain.adbuddiz.sdk.f.a.a.a[2];
        arrayOfa2[0] = new com.purplebrain.adbuddiz.sdk.f.a.a.a(this, com.purplebrain.adbuddiz.sdk.f.e.b);
        arrayOfa2[1] = new com.purplebrain.adbuddiz.sdk.f.a.a.a(this, com.purplebrain.adbuddiz.sdk.f.e.a);
        return Arrays.asList(arrayOfa2);
      }
      com.purplebrain.adbuddiz.sdk.f.a.a.a[] arrayOfa1 = new com.purplebrain.adbuddiz.sdk.f.a.a.a[1];
      arrayOfa1[0] = new com.purplebrain.adbuddiz.sdk.f.a.a.a(this, this.k);
      List localList = Arrays.asList(arrayOfa1);
      return localList;
    }
    catch (MalformedURLException localMalformedURLException) {}
    return Collections.emptyList();
  }
  
  public e e()
  {
    return e.a;
  }
  
  public d f()
  {
    return d.a;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\f\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */