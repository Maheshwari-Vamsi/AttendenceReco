package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;

public class zzn
{
  private static final Uri zzaks = Uri.parse("http://plus.google.com/");
  private static final Uri zzakt = zzaks.buildUpon().appendPath("circles").appendPath("find").build();
  
  public static Intent zzcD(String paramString)
  {
    Uri localUri = Uri.fromParts("package", paramString, null);
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(localUri);
    return localIntent;
  }
  
  public static Intent zzqE()
  {
    Intent localIntent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
    localIntent.setPackage("com.google.android.wearable.app");
    return localIntent;
  }
  
  private static Uri zzx(String paramString1, String paramString2)
  {
    Uri.Builder localBuilder = Uri.parse("market://details").buildUpon().appendQueryParameter("id", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localBuilder.appendQueryParameter("pcampaignid", paramString2);
    }
    return localBuilder.build();
  }
  
  public static Intent zzy(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(zzx(paramString1, paramString2));
    localIntent.setPackage("com.android.vending");
    localIntent.addFlags(524288);
    return localIntent;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */