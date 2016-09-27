package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.zzri;

public final class zzo
{
  public static final int zzaku = 23 - " PII_LOG".length();
  private static final String zzakv = null;
  private final String zzakw;
  private final String zzakx;
  
  public zzo(String paramString)
  {
    this(paramString, zzakv);
  }
  
  public zzo(String paramString1, String paramString2)
  {
    zzx.zzb(paramString1, "log tag cannot be null");
    if (paramString1.length() <= 23) {}
    for (boolean bool = true;; bool = false)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString1;
      arrayOfObject[1] = Integer.valueOf(23);
      zzx.zzb(bool, "tag \"%s\" is longer than the %d character maximum", arrayOfObject);
      this.zzakw = paramString1;
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        break;
      }
      this.zzakx = zzakv;
      return;
    }
    this.zzakx = paramString2;
  }
  
  private String zzcE(String paramString)
  {
    if (this.zzakx == null) {
      return paramString;
    }
    return this.zzakx.concat(paramString);
  }
  
  public void zzA(String paramString1, String paramString2)
  {
    if (zzbW(5)) {
      Log.w(paramString1, zzcE(paramString2));
    }
  }
  
  public void zzB(String paramString1, String paramString2)
  {
    if (zzbW(6)) {
      Log.e(paramString1, zzcE(paramString2));
    }
  }
  
  public void zza(Context paramContext, String paramString1, String paramString2, Throwable paramThrowable)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; (i < arrayOfStackTraceElement.length) && (i < 2); i++)
    {
      localStringBuilder.append(arrayOfStackTraceElement[i].toString());
      localStringBuilder.append("\n");
    }
    zzri localzzri = new zzri(paramContext, 10);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "GMS_WTF";
    arrayOfString[1] = localStringBuilder.toString();
    localzzri.zza("GMS_WTF", null, arrayOfString);
    localzzri.send();
    if (zzbW(7))
    {
      Log.e(paramString1, zzcE(paramString2), paramThrowable);
      Log.wtf(paramString1, zzcE(paramString2), paramThrowable);
    }
  }
  
  public void zza(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzbW(4)) {
      Log.i(paramString1, zzcE(paramString2), paramThrowable);
    }
  }
  
  public void zzb(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzbW(5)) {
      Log.w(paramString1, zzcE(paramString2), paramThrowable);
    }
  }
  
  public boolean zzbW(int paramInt)
  {
    return Log.isLoggable(this.zzakw, paramInt);
  }
  
  public void zzc(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzbW(6)) {
      Log.e(paramString1, zzcE(paramString2), paramThrowable);
    }
  }
  
  public void zzz(String paramString1, String paramString2)
  {
    if (zzbW(3)) {
      Log.d(paramString1, zzcE(paramString2));
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */