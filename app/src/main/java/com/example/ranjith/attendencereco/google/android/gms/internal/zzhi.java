package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Locale;

@zzha
public final class zzhi
{
  public final int zzGA;
  public final int zzGB;
  public final float zzGC;
  public final int zzIA;
  public final boolean zzIB;
  public final boolean zzIC;
  public final String zzID;
  public final String zzIE;
  public final boolean zzIF;
  public final boolean zzIG;
  public final boolean zzIH;
  public final boolean zzII;
  public final String zzIJ;
  public final String zzIK;
  public final int zzIL;
  public final int zzIM;
  public final int zzIN;
  public final int zzIO;
  public final int zzIP;
  public final int zzIQ;
  public final double zzIR;
  public final boolean zzIS;
  public final boolean zzIT;
  public final int zzIU;
  public final String zzIV;
  
  zzhi(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat, int paramInt8, int paramInt9, double paramDouble, boolean paramBoolean7, boolean paramBoolean8, int paramInt10, String paramString5)
  {
    this.zzIA = paramInt1;
    this.zzIB = paramBoolean1;
    this.zzIC = paramBoolean2;
    this.zzID = paramString1;
    this.zzIE = paramString2;
    this.zzIF = paramBoolean3;
    this.zzIG = paramBoolean4;
    this.zzIH = paramBoolean5;
    this.zzII = paramBoolean6;
    this.zzIJ = paramString3;
    this.zzIK = paramString4;
    this.zzIL = paramInt2;
    this.zzIM = paramInt3;
    this.zzIN = paramInt4;
    this.zzIO = paramInt5;
    this.zzIP = paramInt6;
    this.zzIQ = paramInt7;
    this.zzGC = paramFloat;
    this.zzGA = paramInt8;
    this.zzGB = paramInt9;
    this.zzIR = paramDouble;
    this.zzIS = paramBoolean7;
    this.zzIT = paramBoolean8;
    this.zzIU = paramInt10;
    this.zzIV = paramString5;
  }
  
  public static final class zza
  {
    private int zzGA;
    private int zzGB;
    private float zzGC;
    private int zzIA;
    private boolean zzIB;
    private boolean zzIC;
    private String zzID;
    private String zzIE;
    private boolean zzIF;
    private boolean zzIG;
    private boolean zzIH;
    private boolean zzII;
    private String zzIJ;
    private String zzIK;
    private int zzIL;
    private int zzIM;
    private int zzIN;
    private int zzIO;
    private int zzIP;
    private int zzIQ;
    private double zzIR;
    private boolean zzIS;
    private boolean zzIT;
    private int zzIU;
    private String zzIV;
    
    public zza(Context paramContext)
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      zzB(paramContext);
      zza(paramContext, localPackageManager);
      zzC(paramContext);
      Locale localLocale = Locale.getDefault();
      boolean bool2;
      label59:
      Resources localResources;
      if (zza(localPackageManager, "geo:0,0?q=donuts") != null)
      {
        bool2 = bool1;
        this.zzIB = bool2;
        if (zza(localPackageManager, "http://www.google.com") == null) {
          break label126;
        }
        this.zzIC = bool1;
        this.zzIE = localLocale.getCountry();
        this.zzIF = zzl.zzcN().zzhq();
        this.zzIG = GooglePlayServicesUtil.zzao(paramContext);
        this.zzIJ = localLocale.getLanguage();
        this.zzIK = zza(localPackageManager);
        localResources = paramContext.getResources();
        if (localResources != null) {
          break label131;
        }
      }
      label126:
      label131:
      DisplayMetrics localDisplayMetrics;
      do
      {
        return;
        bool2 = false;
        break;
        bool1 = false;
        break label59;
        localDisplayMetrics = localResources.getDisplayMetrics();
      } while (localDisplayMetrics == null);
      this.zzGC = localDisplayMetrics.density;
      this.zzGA = localDisplayMetrics.widthPixels;
      this.zzGB = localDisplayMetrics.heightPixels;
    }
    
    public zza(Context paramContext, zzhi paramzzhi)
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      zzB(paramContext);
      zza(paramContext, localPackageManager);
      zzC(paramContext);
      zzD(paramContext);
      this.zzIB = paramzzhi.zzIB;
      this.zzIC = paramzzhi.zzIC;
      this.zzIE = paramzzhi.zzIE;
      this.zzIF = paramzzhi.zzIF;
      this.zzIG = paramzzhi.zzIG;
      this.zzIJ = paramzzhi.zzIJ;
      this.zzIK = paramzzhi.zzIK;
      this.zzGC = paramzzhi.zzGC;
      this.zzGA = paramzzhi.zzGA;
      this.zzGB = paramzzhi.zzGB;
    }
    
    private void zzB(Context paramContext)
    {
      AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
      this.zzIA = localAudioManager.getMode();
      this.zzIH = localAudioManager.isMusicActive();
      this.zzII = localAudioManager.isSpeakerphoneOn();
      this.zzIL = localAudioManager.getStreamVolume(3);
      this.zzIP = localAudioManager.getRingerMode();
      this.zzIQ = localAudioManager.getStreamVolume(2);
    }
    
    private void zzC(Context paramContext)
    {
      Intent localIntent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (localIntent != null)
      {
        int i = localIntent.getIntExtra("status", -1);
        int j = localIntent.getIntExtra("level", -1);
        int k = localIntent.getIntExtra("scale", -1);
        this.zzIR = (j / k);
        boolean bool;
        if (i != 2)
        {
          bool = false;
          if (i != 5) {}
        }
        else
        {
          bool = true;
        }
        this.zzIS = bool;
        return;
      }
      this.zzIR = -1.0D;
      this.zzIS = false;
    }
    
    private void zzD(Context paramContext)
    {
      this.zzIV = Build.FINGERPRINT;
    }
    
    private static ResolveInfo zza(PackageManager paramPackageManager, String paramString)
    {
      return paramPackageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)), 65536);
    }
    
    private static String zza(PackageManager paramPackageManager)
    {
      ResolveInfo localResolveInfo = zza(paramPackageManager, "market://details?id=com.google.android.gms.ads");
      if (localResolveInfo == null) {}
      for (;;)
      {
        return null;
        ActivityInfo localActivityInfo = localResolveInfo.activityInfo;
        if (localActivityInfo != null) {
          try
          {
            PackageInfo localPackageInfo = paramPackageManager.getPackageInfo(localActivityInfo.packageName, 0);
            if (localPackageInfo != null)
            {
              String str = localPackageInfo.versionCode + "." + localActivityInfo.packageName;
              return str;
            }
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
        }
      }
      return null;
    }
    
    private void zza(Context paramContext, PackageManager paramPackageManager)
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      this.zzID = localTelephonyManager.getNetworkOperator();
      this.zzIN = localTelephonyManager.getNetworkType();
      this.zzIO = localTelephonyManager.getPhoneType();
      this.zzIM = -2;
      this.zzIT = false;
      this.zzIU = -1;
      if (zzp.zzbx().zza(paramPackageManager, paramContext.getPackageName(), "android.permission.ACCESS_NETWORK_STATE"))
      {
        NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
        if (localNetworkInfo == null) {
          break label131;
        }
        this.zzIM = localNetworkInfo.getType();
        this.zzIU = localNetworkInfo.getDetailedState().ordinal();
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT >= 16) {
          this.zzIT = localConnectivityManager.isActiveNetworkMetered();
        }
        return;
        label131:
        this.zzIM = -1;
      }
    }
    
    public zzhi zzgv()
    {
      return new zzhi(this.zzIA, this.zzIB, this.zzIC, this.zzID, this.zzIE, this.zzIF, this.zzIG, this.zzIH, this.zzII, this.zzIJ, this.zzIK, this.zzIL, this.zzIM, this.zzIN, this.zzIO, this.zzIP, this.zzIQ, this.zzGC, this.zzGA, this.zzGB, this.zzIR, this.zzIS, this.zzIT, this.zzIU, this.zzIV);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzhi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */