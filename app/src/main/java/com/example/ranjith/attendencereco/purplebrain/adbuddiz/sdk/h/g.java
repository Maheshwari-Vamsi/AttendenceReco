package com.purplebrain.adbuddiz.sdk.h;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.AdBuddizError;
import com.purplebrain.adbuddiz.sdk.AdBuddizRewardedVideoError;
import com.purplebrain.adbuddiz.sdk.f.e;
import com.purplebrain.adbuddiz.sdk.h.a.a.a;
import com.purplebrain.adbuddiz.sdk.h.a.b;
import com.purplebrain.adbuddiz.sdk.h.a.b.a;
import com.purplebrain.adbuddiz.sdk.h.a.d.a;
import com.purplebrain.adbuddiz.sdk.i.o;
import com.purplebrain.adbuddiz.sdk.i.w;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public final class g
  extends a
{
  public AdBuddizError e;
  public AdBuddizRewardedVideoError f;
  public com.purplebrain.adbuddiz.sdk.f.a.a g;
  public String h;
  public com.purplebrain.adbuddiz.sdk.f.d i;
  
  public final void a(AdBuddizError paramAdBuddizError)
  {
    this.e = paramAdBuddizError;
    this.f = null;
  }
  
  public final void a(Throwable paramThrowable)
  {
    if (paramThrowable == null)
    {
      this.h = null;
      return;
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramThrowable.printStackTrace(new PrintStream(localByteArrayOutputStream));
      this.h = new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
      return;
    }
    catch (Throwable localThrowable)
    {
      o.a("ABRequestEventReport.setReason()", localThrowable);
    }
  }
  
  protected final void c()
  {
    HttpURLConnection localHttpURLConnection = null;
    try
    {
      URL localURL = w.f();
      Context localContext = AdBuddiz.getContext();
      JSONObject localJSONObject = new JSONObject();
      new a.a();
      localJSONObject.put("a", a.a.a(localContext).a());
      new b.a();
      localJSONObject.put("d", b.a.a(localContext).a());
      new d.a();
      localJSONObject.put("s", d.a.a(localContext).a());
      if (this.e != null) {
        localJSONObject.put("e", this.e.getName());
      }
      if (this.f != null) {
        localJSONObject.put("e", this.f.getName());
      }
      if (this.g != null)
      {
        localJSONObject.put("i", this.g.b());
        localJSONObject.put("in", this.g.b);
      }
      String str = this.h;
      localHttpURLConnection = null;
      if ((str != null) && (this.h.length() != 0)) {
        localJSONObject.put("r", this.h);
      }
      localJSONObject.put("erc", this.i.b);
      localJSONObject.put("p", this.i.a);
      localJSONObject.put("or", com.purplebrain.adbuddiz.sdk.i.a.d.a().d);
      localJSONObject.put("t", System.currentTimeMillis());
      localHttpURLConnection = b(localURL, localJSONObject.toString());
      int j = localHttpURLConnection.getResponseCode();
      if (j >= 500) {
        throw new k("Server Error : " + j);
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
    return "EventReport";
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\h\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */