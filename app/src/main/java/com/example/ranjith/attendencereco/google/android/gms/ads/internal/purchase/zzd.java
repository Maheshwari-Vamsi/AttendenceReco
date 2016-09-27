package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzgb.zza;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzih;
import com.google.android.gms.internal.zzip;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

@zzha
public class zzd
  extends zzgb.zza
{
  private Context mContext;
  private String zzEH;
  private ArrayList<String> zzEI;
  private String zzrD;
  
  public zzd(String paramString1, ArrayList<String> paramArrayList, Context paramContext, String paramString2)
  {
    this.zzEH = paramString1;
    this.zzEI = paramArrayList;
    this.zzrD = paramString2;
    this.mContext = paramContext;
  }
  
  public String getProductId()
  {
    return this.zzEH;
  }
  
  public void recordPlayBillingResolution(int paramInt)
  {
    if (paramInt == 0) {
      zzfK();
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("google_play_status", String.valueOf(paramInt));
    localHashMap.put("sku", this.zzEH);
    localHashMap.put("status", String.valueOf(zzB(paramInt)));
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.zzEI.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(zza((String)localIterator.next(), localHashMap));
    }
    zzp.zzbx().zza(this.mContext, this.zzrD, localLinkedList);
  }
  
  public void recordResolution(int paramInt)
  {
    if (paramInt == 1) {
      zzfK();
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", String.valueOf(paramInt));
    localHashMap.put("sku", this.zzEH);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.zzEI.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(zza((String)localIterator.next(), localHashMap));
    }
    zzp.zzbx().zza(this.mContext, this.zzrD, localLinkedList);
  }
  
  protected int zzB(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 4) {
      return 3;
    }
    return 0;
  }
  
  protected String zza(String paramString, HashMap<String, String> paramHashMap)
  {
    str1 = this.mContext.getPackageName();
    try
    {
      String str12 = this.mContext.getPackageManager().getPackageInfo(str1, 0).versionName;
      str2 = str12;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      String str2;
      long l2;
      for (;;)
      {
        long l1;
        Iterator localIterator;
        zzb.zzd("Error to retrieve app version", localNameNotFoundException);
        str2 = "";
      }
      String str3 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { "sessionid" });
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = zzp.zzbA().getSessionId();
      String str4 = paramString.replaceAll(str3, String.format("$1%s$2", arrayOfObject1)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { "appid" }), String.format("$1%s$2", new Object[] { str1 }));
      String str5 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { "osversion" });
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = String.valueOf(Build.VERSION.SDK_INT);
      String str6 = str4.replaceAll(str5, String.format("$1%s$2", arrayOfObject2));
      String str7 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { "sdkversion" });
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = this.zzrD;
      String str8 = str6.replaceAll(str7, String.format("$1%s$2", arrayOfObject3)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { "appversion" }), String.format("$1%s$2", new Object[] { str2 }));
      String str9 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { "timestamp" });
      Object[] arrayOfObject4 = new Object[1];
      arrayOfObject4[0] = String.valueOf(l2);
      return str8.replaceAll(str9, String.format("$1%s$2", arrayOfObject4)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { "[^@]+" }), String.format("$1%s$2", new Object[] { "" })).replaceAll("@@", "@");
    }
    l1 = zzp.zzbA().zzgL().zzgV();
    l2 = SystemClock.elapsedRealtime() - l1;
    localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str10 = (String)localIterator.next();
      String str11 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { str10 });
      Object[] arrayOfObject5 = new Object[1];
      arrayOfObject5[0] = paramHashMap.get(str10);
      paramString = paramString.replaceAll(str11, String.format("$1%s$2", arrayOfObject5));
    }
  }
  
  void zzfK()
  {
    try
    {
      Class localClass = this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter");
      Class[] arrayOfClass = new Class[4];
      arrayOfClass[0] = Context.class;
      arrayOfClass[1] = String.class;
      arrayOfClass[2] = String.class;
      arrayOfClass[3] = Boolean.TYPE;
      Method localMethod = localClass.getDeclaredMethod("reportWithProductId", arrayOfClass);
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = this.mContext;
      arrayOfObject[1] = this.zzEH;
      arrayOfObject[2] = "";
      arrayOfObject[3] = Boolean.valueOf(true);
      localMethod.invoke(null, arrayOfObject);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      zzb.zzaH("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      zzb.zzaH("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
      return;
    }
    catch (Exception localException)
    {
      zzb.zzd("Fail to report a conversion.", localException);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\purchase\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */