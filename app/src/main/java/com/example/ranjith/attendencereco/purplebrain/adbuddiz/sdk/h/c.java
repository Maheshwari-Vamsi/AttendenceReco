package com.purplebrain.adbuddiz.sdk.h;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.f.e;
import com.purplebrain.adbuddiz.sdk.h.a.a.a;
import com.purplebrain.adbuddiz.sdk.h.a.b;
import com.purplebrain.adbuddiz.sdk.h.a.b.a;
import com.purplebrain.adbuddiz.sdk.h.a.d.a;
import com.purplebrain.adbuddiz.sdk.i.w;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public final class c
  extends a
{
  public com.purplebrain.adbuddiz.sdk.f.a.a e;
  public String f;
  
  protected final void c()
  {
    HttpURLConnection localHttpURLConnection = null;
    try
    {
      URL localURL = w.g();
      Context localContext = AdBuddiz.getContext();
      JSONObject localJSONObject = new JSONObject();
      new a.a();
      localJSONObject.put("a", a.a.a(localContext).a());
      new b.a();
      localJSONObject.put("d", b.a.a(localContext).a());
      new d.a();
      localJSONObject.put("s", d.a.a(localContext).a());
      localJSONObject.put("p", this.f);
      localJSONObject.put("or", com.purplebrain.adbuddiz.sdk.i.a.d.a().name());
      localJSONObject.put("t", System.currentTimeMillis());
      this.e.a(localContext, localJSONObject);
      localHttpURLConnection = b(localURL, localJSONObject.toString());
      int i = localHttpURLConnection.getResponseCode();
      if (i >= 500) {
        throw new k("Server Error : " + i);
      }
    }
    finally
    {
      if (localHttpURLConnection != null) {
        localHttpURLConnection.disconnect();
      }
    }
    if (localHttpURLConnection != null) {
      localHttpURLConnection.disconnect();
    }
  }
  
  protected final boolean d()
  {
    return false;
  }
  
  protected final String e()
  {
    return "AdClick";
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\h\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */