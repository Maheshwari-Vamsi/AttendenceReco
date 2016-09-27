package com.purplebrain.adbuddiz.sdk.h;

import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.f.a.a.c;
import com.purplebrain.adbuddiz.sdk.i.m;
import java.net.HttpURLConnection;

public final class e
  extends b
{
  public c e = null;
  public a f = null;
  
  protected final void c()
  {
    HttpURLConnection localHttpURLConnection = null;
    try
    {
      localHttpURLConnection = b.a(this.e.d(), "GET");
      int i = localHttpURLConnection.getResponseCode();
      if (i == 200)
      {
        m.a(AdBuddiz.getContext(), a(localHttpURLConnection), this.e);
        this.f.a(this.e);
      }
      while (i < 500) {
        return;
      }
      throw new k("Server Error : " + i);
    }
    finally
    {
      if (localHttpURLConnection != null) {
        localHttpURLConnection.disconnect();
      }
    }
  }
  
  protected final boolean d()
  {
    return true;
  }
  
  protected final String e()
  {
    return "DownloadAdResource";
  }
  
  public static abstract interface a
  {
    public abstract void a(c paramc);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\h\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */