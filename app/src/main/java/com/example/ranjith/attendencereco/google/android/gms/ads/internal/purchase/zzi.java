package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzip;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzi
{
  public void zza(Context paramContext, boolean paramBoolean, GInAppPurchaseManagerInfoParcel paramGInAppPurchaseManagerInfoParcel)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", paramBoolean);
    GInAppPurchaseManagerInfoParcel.zza(localIntent, paramGInAppPurchaseManagerInfoParcel);
    zzp.zzbx().zzb(paramContext, localIntent);
  }
  
  public String zzap(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      String str = new JSONObject(paramString).getString("developerPayload");
      return str;
    }
    catch (JSONException localJSONException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to parse purchase data");
    }
    return null;
  }
  
  public String zzaq(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      String str = new JSONObject(paramString).getString("purchaseToken");
      return str;
    }
    catch (JSONException localJSONException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to parse purchase data");
    }
    return null;
  }
  
  public int zzd(Intent paramIntent)
  {
    if (paramIntent == null) {
      return 5;
    }
    Object localObject = paramIntent.getExtras().get("RESPONSE_CODE");
    if (localObject == null)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Intent with no response code, assuming OK (known issue)");
      return 0;
    }
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    if ((localObject instanceof Long)) {
      return (int)((Long)localObject).longValue();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaH("Unexpected type for intent response code. " + localObject.getClass().getName());
    return 5;
  }
  
  public int zzd(Bundle paramBundle)
  {
    Object localObject = paramBundle.get("RESPONSE_CODE");
    if (localObject == null)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Bundle with null response code, assuming OK (known issue)");
      return 0;
    }
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    if ((localObject instanceof Long)) {
      return (int)((Long)localObject).longValue();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaH("Unexpected type for intent response code. " + localObject.getClass().getName());
    return 5;
  }
  
  public String zze(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
  }
  
  public String zzf(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
  }
  
  public void zzz(final Context paramContext)
  {
    ServiceConnection local1 = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        zzb localzzb = new zzb(paramContext.getApplicationContext(), false);
        localzzb.zzN(paramAnonymousIBinder);
        int i = localzzb.zzb(3, paramContext.getPackageName(), "inapp");
        zzig localzzig = zzp.zzbA();
        boolean bool = false;
        if (i == 0) {
          bool = true;
        }
        localzzig.zzC(bool);
        paramContext.unbindService(this);
        localzzb.destroy();
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {}
    };
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    paramContext.bindService(localIntent, local1, 1);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\purchase\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */