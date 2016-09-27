package com.purplebrain.adbuddiz.sdk.j.c;

import com.purplebrain.adbuddiz.sdk.h.b;
import com.purplebrain.adbuddiz.sdk.h.k;
import java.net.HttpURLConnection;
import java.net.URL;

public final class a
  extends b
{
  private String e;
  private URL f;
  
  public a(String paramString, URL paramURL)
  {
    this.e = paramString;
    this.f = paramURL;
  }
  
  protected final void c()
  {
    HttpURLConnection localHttpURLConnection = null;
    try
    {
      localHttpURLConnection = b.a(this.f, "GET");
      int i = localHttpURLConnection.getResponseCode();
      if ((i != 404) && (i >= 500)) {
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
    if (this.e != null) {
      return "ABVASTTrackingRequest-" + this.e;
    }
    return "ABVASTTrackingRequest";
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\j\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */