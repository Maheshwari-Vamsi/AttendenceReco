package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzw;
import java.net.URI;
import java.net.URISyntaxException;

@zzha
public class zzjw
  extends WebViewClient
{
  private final zzgn zzFr;
  private final String zzMR = zzaO(paramString);
  private boolean zzMS = false;
  private final zzjn zzps;
  
  public zzjw(zzgn paramzzgn, zzjn paramzzjn, String paramString)
  {
    this.zzps = paramzzjn;
    this.zzFr = paramzzgn;
  }
  
  private String zzaO(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        if (paramString.endsWith("/"))
        {
          String str = paramString.substring(0, -1 + paramString.length());
          return str;
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        zzb.e(localIndexOutOfBoundsException.getMessage());
      }
    }
    return paramString;
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    zzb.zzaF("JavascriptAdWebViewClient::onLoadResource: " + paramString);
    if (!zzaN(paramString)) {
      this.zzps.zzhC().onLoadResource(this.zzps.getWebView(), paramString);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    zzb.zzaF("JavascriptAdWebViewClient::onPageFinished: " + paramString);
    if (!this.zzMS)
    {
      this.zzFr.zzfS();
      this.zzMS = true;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    zzb.zzaF("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + paramString);
    if (zzaN(paramString))
    {
      zzb.zzaF("shouldOverrideUrlLoading: received passback url");
      return true;
    }
    return this.zzps.zzhC().shouldOverrideUrlLoading(this.zzps.getWebView(), paramString);
  }
  
  protected boolean zzaN(String paramString)
  {
    String str1 = zzaO(paramString);
    if (TextUtils.isEmpty(str1)) {}
    for (;;)
    {
      return false;
      try
      {
        URI localURI1 = new URI(str1);
        if ("passback".equals(localURI1.getScheme()))
        {
          zzb.zzaF("Passback received");
          this.zzFr.zzfT();
          return true;
        }
        if (!TextUtils.isEmpty(this.zzMR))
        {
          URI localURI2 = new URI(this.zzMR);
          String str2 = localURI2.getHost();
          String str3 = localURI1.getHost();
          String str4 = localURI2.getPath();
          String str5 = localURI1.getPath();
          if ((zzw.equal(str2, str3)) && (zzw.equal(str4, str5)))
          {
            zzb.zzaF("Passback received");
            this.zzFr.zzfT();
            return true;
          }
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        zzb.e(localURISyntaxException.getMessage());
      }
    }
    return false;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzjw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */