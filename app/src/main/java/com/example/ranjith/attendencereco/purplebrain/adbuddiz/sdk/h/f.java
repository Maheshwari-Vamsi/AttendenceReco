package com.purplebrain.adbuddiz.sdk.h;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.i.m;
import com.purplebrain.adbuddiz.sdk.i.o;
import com.purplebrain.adbuddiz.sdk.i.s;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class f
  extends a
{
  public URL e;
  public String f;
  
  public f()
  {
    this.b = 1;
  }
  
  protected final void c()
  {
    HttpURLConnection localHttpURLConnection = null;
    int i;
    try
    {
      localHttpURLConnection = b.a(this.e, "GET");
      i = localHttpURLConnection.getResponseCode();
      if (i == 200)
      {
        localContext = AdBuddiz.getContext();
        str1 = this.f;
        localInputStream = a(localHttpURLConnection);
        str2 = "ABZ_31_" + str1 + "_tmp.abz";
        str3 = m.a(str1);
      }
      while (i < 500) {
        try
        {
          String str1;
          InputStream localInputStream;
          FileOutputStream localFileOutputStream = localContext.openFileOutput(str2, 0);
          s.a(localInputStream, localFileOutputStream);
          localFileOutputStream.flush();
          localFileOutputStream.close();
          localContext.getFileStreamPath(str2).renameTo(localContext.getFileStreamPath(str3));
          return;
        }
        catch (IOException localIOException)
        {
          Context localContext;
          String str2;
          String str3;
          o.a("writeAsset() IOException", localIOException);
          localContext.getFileStreamPath(str2).delete();
          localContext.getFileStreamPath(str3).delete();
          throw localIOException;
        }
      }
    }
    finally
    {
      if (localHttpURLConnection != null) {
        localHttpURLConnection.disconnect();
      }
    }
    throw new k("Server Error : " + i);
  }
  
  protected final boolean d()
  {
    return true;
  }
  
  protected final String e()
  {
    return "DownloadAsset";
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\h\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */