package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.GoogleApiAvailability;

abstract class zzmk
  extends BroadcastReceiver
{
  protected Context mContext;
  
  public static <T extends zzmk> T zza(Context paramContext, T paramT)
  {
    return zza(paramContext, paramT, GoogleApiAvailability.getInstance());
  }
  
  public static <T extends zzmk> T zza(Context paramContext, T paramT, GoogleApiAvailability paramGoogleApiAvailability)
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addDataScheme("package");
    paramContext.registerReceiver(paramT, localIntentFilter);
    paramT.mContext = paramContext;
    if (!paramGoogleApiAvailability.zzh(paramContext, "com.google.android.gms"))
    {
      paramT.zzpv();
      paramT.unregister();
      paramT = null;
    }
    return paramT;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Uri localUri = paramIntent.getData();
    String str = null;
    if (localUri != null) {
      str = localUri.getSchemeSpecificPart();
    }
    if ("com.google.android.gms".equals(str))
    {
      zzpv();
      unregister();
    }
  }
  
  public void unregister()
  {
    try
    {
      if (this.mContext != null) {
        this.mContext.unregisterReceiver(this);
      }
      this.mContext = null;
      return;
    }
    finally {}
  }
  
  protected abstract void zzpv();
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzmk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */