package com.purplebrain.adbuddiz.sdk.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.purplebrain.adbuddiz.sdk.f.e;
import com.purplebrain.adbuddiz.sdk.i.l;
import com.purplebrain.adbuddiz.sdk.i.m;
import com.purplebrain.adbuddiz.sdk.i.o;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private static boolean k = false;
  private static boolean l = false;
  private static boolean m = false;
  public Context a;
  public com.purplebrain.adbuddiz.sdk.f.a.f b;
  public WebView c = null;
  public a d = null;
  public f e = null;
  public boolean f = false;
  public boolean g = false;
  public Point h = new Point(0, 0);
  public c i = null;
  public d j = null;
  private List n = null;
  private boolean o = true;
  private String p = "none";
  private boolean q = false;
  
  public c(Context paramContext, com.purplebrain.adbuddiz.sdk.f.a.f paramf)
  {
    this.b = paramf;
    this.a = paramContext;
    this.n = Arrays.asList(new String[] { "none", "portrait", "landscape" });
  }
  
  @SuppressLint({"NewApi"})
  public static void a()
  {
    if ((k) && (Build.VERSION.SDK_INT >= 19)) {
      WebView.setWebContentsDebuggingEnabled(true);
    }
  }
  
  @SuppressLint({"SetJavaScriptEnabled", "NewApi"})
  public static void a(WebView paramWebView)
  {
    paramWebView.setVerticalScrollBarEnabled(false);
    paramWebView.setHorizontalScrollBarEnabled(false);
    WebSettings localWebSettings = paramWebView.getSettings();
    if (Build.VERSION.SDK_INT >= 17) {
      localWebSettings.setMediaPlaybackRequiresUserGesture(false);
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      localWebSettings.setAllowFileAccessFromFileURLs(false);
      localWebSettings.setAllowUniversalAccessFromFileURLs(false);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      localWebSettings.setAllowContentAccess(false);
    }
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setAllowFileAccess(true);
    if (l)
    {
      paramWebView.clearCache(true);
      localWebSettings.setCacheMode(2);
    }
  }
  
  public final void a(f paramf)
  {
    if (this.e != paramf)
    {
      this.e = paramf;
      this.d.a("_setState", new Object[] { paramf });
      this.d.a(d.c, new Object[] { paramf });
    }
  }
  
  public final DisplayMetrics b()
  {
    return this.c.getContext().getResources().getDisplayMetrics();
  }
  
  private final class a
    extends WebChromeClient
  {
    private a() {}
    
    @SuppressLint({"NewApi"})
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      return !c.c();
    }
  }
  
  private final class b
    extends WebViewClient
  {
    private b() {}
    
    private com.purplebrain.adbuddiz.sdk.f.a.a.c a(URL paramURL)
    {
      e locale = com.purplebrain.adbuddiz.sdk.i.a.d.a();
      Iterator localIterator = com.purplebrain.adbuddiz.sdk.i.c.a(c.d(c.this), com.purplebrain.adbuddiz.sdk.f.a.a.d.b, false, locale).iterator();
      while (localIterator.hasNext())
      {
        com.purplebrain.adbuddiz.sdk.f.a.a.c localc = (com.purplebrain.adbuddiz.sdk.f.a.a.c)localIterator.next();
        if (paramURL.equals(localc.d())) {
          return localc;
        }
      }
      return null;
    }
    
    public final void onLoadResource(WebView paramWebView, String paramString)
    {
      try
      {
        Uri localUri = Uri.parse(paramString);
        if ("mraid".equals(localUri.getScheme())) {
          c.a(c.this, localUri);
        }
        if ("adbuddiz".equals(localUri.getScheme()))
        {
          String str1 = localUri.getLastPathSegment();
          String str2 = localUri.getQueryParameter("url");
          c.a(c.this).a(str1, str2);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        l.a("ABMRAIDController#ABWebViewClient.onLoadResource()", null, localThrowable);
        o.a("ABMRAIDController#ABWebViewClient.onLoadResource()", localThrowable);
      }
    }
    
    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      try
      {
        c.a(c.this, paramWebView);
        return;
      }
      catch (Throwable localThrowable)
      {
        l.a("ABMRAIDController#ABWebViewClient.onPageFinished", null, localThrowable);
        o.a("ABMRAIDController#ABWebViewClient.onPageFinished()", localThrowable);
      }
    }
    
    @SuppressLint({"NewApi"})
    public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
    {
      if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {}
      for (;;)
      {
        return null;
        c.a(c.this, paramWebView);
        try
        {
          com.purplebrain.adbuddiz.sdk.f.a.a.c localc = a(new URL(paramString));
          if (localc != null)
          {
            new Object[] { paramString };
            WebResourceResponse localWebResourceResponse = new WebResourceResponse("application/octet-stream", null, m.c(c.c(c.this), localc));
            return localWebResourceResponse;
          }
        }
        catch (IOException localIOException)
        {
          l.a("ABMRAIDController#ABWebViewClient.shouldInterceptRequest", null, localIOException);
          o.a("ABMRAIDController#ABWebViewClient.shouldInterceptRequest", localIOException);
        }
      }
      return null;
    }
    
    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      try
      {
        if ((!paramString.startsWith("data:")) && (!paramString.startsWith("adbuddiz:")) && (!paramString.startsWith("mraid:")))
        {
          c.b(c.this).a(Uri.parse(paramString));
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        l.a("ABMRAIDController#ABWebViewClient.shouldOverrideUrlLoading", null, localThrowable);
        o.a("ABMRAIDController#ABWebViewClient.shouldOverrideUrlLoading()", localThrowable);
      }
      return false;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
    
    public abstract void a(Uri paramUri);
    
    public abstract void b(Uri paramUri);
  }
  
  public static abstract interface d
  {
    public abstract void a(String paramString1, String paramString2);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */