package com.purplebrain.adbuddiz.sdk.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.purplebrain.adbuddiz.sdk.i.l;
import com.purplebrain.adbuddiz.sdk.i.m;
import com.purplebrain.adbuddiz.sdk.i.o;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public final class a
{
  private static boolean e = false;
  public Context a;
  public com.purplebrain.adbuddiz.sdk.f.a.c b;
  public WebView c;
  public c d;
  
  public a(Context paramContext, com.purplebrain.adbuddiz.sdk.f.a.c paramc)
  {
    this.a = paramContext;
    this.b = paramc;
  }
  
  @SuppressLint({"NewApi"})
  public static void a()
  {
    if ((e) && (Build.VERSION.SDK_INT >= 19)) {
      WebView.setWebContentsDebuggingEnabled(true);
    }
  }
  
  @SuppressLint({"SetJavaScriptEnabled", "NewApi"})
  public static void a(WebView paramWebView)
  {
    paramWebView.setVerticalScrollBarEnabled(false);
    paramWebView.setHorizontalScrollBarEnabled(false);
    WebSettings localWebSettings = paramWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setAppCacheEnabled(false);
    localWebSettings.setCacheMode(2);
  }
  
  private final class a
    extends WebChromeClient
  {
    private a() {}
    
    @SuppressLint({"NewApi"})
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      return true;
    }
  }
  
  private final class b
    extends WebViewClient
  {
    private b() {}
    
    @SuppressLint({"NewApi"})
    public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
    {
      if (!paramString.startsWith("adbuddiz")) {
        return null;
      }
      new Object[] { paramString };
      com.purplebrain.adbuddiz.sdk.f.a.a.c localc;
      try
      {
        String str = Uri.parse(paramString).getPath();
        if (str.startsWith("/")) {
          str = str.substring(1);
        }
        localc = com.purplebrain.adbuddiz.sdk.i.c.a(a.b(a.this), str);
        if (localc == null) {
          throw new IOException(String.format("Resource '%s' is not in the list of additional resources.", new Object[] { paramString }));
        }
      }
      catch (Throwable localThrowable)
      {
        l.a("ABHTMLEndInterstitialController#ABWebViewClient.shouldInterceptRequest", null, localThrowable);
        o.a("ABHTMLEndInterstitialController#ABWebViewClient.shouldInterceptRequest", localThrowable);
        return new WebResourceResponse("application/octet-stream", "UTF-8", new ByteArrayInputStream(new byte[0]));
      }
      WebResourceResponse localWebResourceResponse = new WebResourceResponse("application/octet-stream", null, m.c(a.c(a.this), localc));
      return localWebResourceResponse;
    }
    
    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      try
      {
        if ("adbuddiz:///click".equals(paramString))
        {
          a.a(a.this).a();
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        l.a("ABHTMLEndInterstitialController#ABWebViewClient.shouldOverrideUrlLoading", null, localThrowable);
        o.a("ABHTMLEndInterstitialController#ABWebViewClient.shouldOverrideUrlLoading()", localThrowable);
      }
      return false;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\k\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */