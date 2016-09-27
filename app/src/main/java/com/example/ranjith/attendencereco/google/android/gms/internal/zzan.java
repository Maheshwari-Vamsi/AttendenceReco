package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.MotionEvent;

public class zzan
{
  private static final String[] zzoh = { "/aclk", "/pcs/click" };
  private String zzod = "googleads.g.doubleclick.net";
  private String zzoe = "/pagead/ads";
  private String zzof = "ad.doubleclick.net";
  private String[] zzog = { ".doubleclick.net", ".googleadservices.com", ".googlesyndication.com" };
  private zzaj zzoi;
  
  public zzan(zzaj paramzzaj)
  {
    this.zzoi = paramzzaj;
  }
  
  private Uri zza(Uri paramUri, Context paramContext, String paramString, boolean paramBoolean)
    throws zzao
  {
    boolean bool;
    try
    {
      bool = zza(paramUri);
      if (bool)
      {
        if (!paramUri.toString().contains("dc_ms=")) {
          break label65;
        }
        throw new zzao("Parameter already exists: dc_ms");
      }
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      throw new zzao("Provided Uri is not in a valid state");
    }
    if (paramUri.getQueryParameter("ms") != null) {
      throw new zzao("Query parameter already exists: ms");
    }
    label65:
    if (paramBoolean) {}
    for (String str = this.zzoi.zzb(paramContext, paramString); bool; str = this.zzoi.zzb(paramContext)) {
      return zzb(paramUri, "dc_ms", str);
    }
    Uri localUri = zza(paramUri, "ms", str);
    return localUri;
  }
  
  private Uri zza(Uri paramUri, String paramString1, String paramString2)
    throws UnsupportedOperationException
  {
    String str = paramUri.toString();
    int i = str.indexOf("&adurl");
    if (i == -1) {
      i = str.indexOf("?adurl");
    }
    if (i != -1) {
      return Uri.parse(str.substring(0, i + 1) + paramString1 + "=" + paramString2 + "&" + str.substring(i + 1));
    }
    return paramUri.buildUpon().appendQueryParameter(paramString1, paramString2).build();
  }
  
  private Uri zzb(Uri paramUri, String paramString1, String paramString2)
  {
    String str1 = paramUri.toString();
    int i = str1.indexOf(";adurl");
    if (i != -1) {
      return Uri.parse(str1.substring(0, i + 1) + paramString1 + "=" + paramString2 + ";" + str1.substring(i + 1));
    }
    String str2 = paramUri.getEncodedPath();
    int j = str1.indexOf(str2);
    return Uri.parse(str1.substring(0, j + str2.length()) + ";" + paramString1 + "=" + paramString2 + ";" + str1.substring(j + str2.length()));
  }
  
  public Uri zza(Uri paramUri, Context paramContext)
    throws zzao
  {
    try
    {
      Uri localUri = zza(paramUri, paramContext, paramUri.getQueryParameter("ai"), true);
      return localUri;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      throw new zzao("Provided Uri is not in a valid state");
    }
  }
  
  public void zza(MotionEvent paramMotionEvent)
  {
    this.zzoi.zza(paramMotionEvent);
  }
  
  public boolean zza(Uri paramUri)
  {
    if (paramUri == null) {
      throw new NullPointerException();
    }
    try
    {
      boolean bool = paramUri.getHost().equals(this.zzof);
      return bool;
    }
    catch (NullPointerException localNullPointerException) {}
    return false;
  }
  
  public zzaj zzac()
  {
    return this.zzoi;
  }
  
  public boolean zzb(Uri paramUri)
  {
    if (paramUri == null) {
      throw new NullPointerException();
    }
    try
    {
      String str = paramUri.getHost();
      String[] arrayOfString = this.zzog;
      int i = arrayOfString.length;
      for (int j = 0;; j++)
      {
        boolean bool1 = false;
        if (j < i)
        {
          boolean bool2 = str.endsWith(arrayOfString[j]);
          if (bool2) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
      }
      return false;
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  public boolean zzc(Uri paramUri)
  {
    boolean bool1 = zzb(paramUri);
    boolean bool2 = false;
    String[] arrayOfString;
    int i;
    if (bool1)
    {
      arrayOfString = zzoh;
      i = arrayOfString.length;
    }
    for (int j = 0;; j++)
    {
      bool2 = false;
      if (j < i)
      {
        String str = arrayOfString[j];
        if (paramUri.getPath().endsWith(str)) {
          bool2 = true;
        }
      }
      else
      {
        return bool2;
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */