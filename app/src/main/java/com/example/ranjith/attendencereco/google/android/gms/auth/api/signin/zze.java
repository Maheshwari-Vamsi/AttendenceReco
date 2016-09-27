package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.R.string;

public enum zze
{
  private final String zzUB;
  private final String zzVL;
  private final int zzVM;
  
  static
  {
    zze[] arrayOfzze = new zze[2];
    arrayOfzze[0] = zzVJ;
    arrayOfzze[1] = zzVK;
    zzVN = arrayOfzze;
  }
  
  private zze(String paramString1, int paramInt, String paramString2)
  {
    this.zzVL = paramString1;
    this.zzVM = paramInt;
    this.zzUB = paramString2;
  }
  
  public static zze zzbI(String paramString)
  {
    if (paramString != null)
    {
      for (zze localzze : values()) {
        if (localzze.zzmC().equals(paramString)) {
          return localzze;
        }
      }
      Log.w("IdProvider", "Unrecognized providerId: " + paramString);
    }
    return null;
  }
  
  public String toString()
  {
    return this.zzVL;
  }
  
  public CharSequence zzad(Context paramContext)
  {
    return paramContext.getResources().getString(this.zzVM);
  }
  
  public String zzmC()
  {
    return this.zzVL;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\auth\api\signin\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */