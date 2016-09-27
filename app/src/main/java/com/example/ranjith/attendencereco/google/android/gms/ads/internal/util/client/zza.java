package com.google.android.gms.ads.internal.util.client;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zznx;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@zzha
public class zza
{
  public static final Handler zzLE = new Handler(Looper.getMainLooper());
  
  private void zza(ViewGroup paramViewGroup, AdSizeParcel paramAdSizeParcel, String paramString, int paramInt1, int paramInt2)
  {
    if (paramViewGroup.getChildCount() != 0) {
      return;
    }
    Context localContext = paramViewGroup.getContext();
    TextView localTextView = new TextView(localContext);
    localTextView.setGravity(17);
    localTextView.setText(paramString);
    localTextView.setTextColor(paramInt1);
    localTextView.setBackgroundColor(paramInt2);
    FrameLayout localFrameLayout = new FrameLayout(localContext);
    localFrameLayout.setBackgroundColor(paramInt1);
    int i = zzb(localContext, 3);
    localFrameLayout.addView(localTextView, new FrameLayout.LayoutParams(paramAdSizeParcel.widthPixels - i, paramAdSizeParcel.heightPixels - i, 17));
    paramViewGroup.addView(localFrameLayout, paramAdSizeParcel.widthPixels, paramAdSizeParcel.heightPixels);
  }
  
  public String zzS(Context paramContext)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    if (localContentResolver == null) {}
    for (String str = null;; str = Settings.Secure.getString(localContentResolver, "android_id"))
    {
      if ((str == null) || (zzhq())) {
        str = "emulator";
      }
      return zzaE(str);
    }
  }
  
  public boolean zzT(Context paramContext)
  {
    return GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) == 0;
  }
  
  public boolean zzU(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().orientation != 2) {}
    DisplayMetrics localDisplayMetrics;
    do
    {
      return false;
      localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    } while ((int)(localDisplayMetrics.heightPixels / localDisplayMetrics.density) >= 600);
    return true;
  }
  
  public boolean zzV(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    int i;
    int k;
    if (zznx.zzrS())
    {
      localDisplay.getRealMetrics(localDisplayMetrics);
      i = localDisplayMetrics.heightPixels;
      k = localDisplayMetrics.widthPixels;
      localDisplay.getMetrics(localDisplayMetrics);
      int m = localDisplayMetrics.heightPixels;
      int n = localDisplayMetrics.widthPixels;
      if ((m != i) || (n != k)) {
        break label144;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      label144:
      try
      {
        i = ((Integer)Display.class.getMethod("getRawHeight", new Class[0]).invoke(localDisplay, new Object[0])).intValue();
        int j = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(localDisplay, new Object[0])).intValue();
        k = j;
      }
      catch (Exception localException) {}
    }
    return false;
  }
  
  public int zzW(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
    if (i > 0) {
      return paramContext.getResources().getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public int zza(DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramDisplayMetrics);
  }
  
  public void zza(ViewGroup paramViewGroup, AdSizeParcel paramAdSizeParcel, String paramString)
  {
    zza(paramViewGroup, paramAdSizeParcel, paramString, -16777216, -1);
  }
  
  public void zza(ViewGroup paramViewGroup, AdSizeParcel paramAdSizeParcel, String paramString1, String paramString2)
  {
    zzb.zzaH(paramString2);
    zza(paramViewGroup, paramAdSizeParcel, paramString1, -65536, -16777216);
  }
  
  public String zzaE(String paramString)
  {
    int i = 0;
    while (i < 2) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(paramString.getBytes());
        Locale localLocale = Locale.US;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = new BigInteger(1, localMessageDigest.digest());
        String str = String.format(localLocale, "%032X", arrayOfObject);
        return str;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        i++;
      }
    }
    return null;
  }
  
  public int zzb(Context paramContext, int paramInt)
  {
    return zza(paramContext.getResources().getDisplayMetrics(), paramInt);
  }
  
  public int zzb(DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    return Math.round(paramInt / paramDisplayMetrics.density);
  }
  
  public int zzc(Context paramContext, int paramInt)
  {
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    return zzb(localDisplayMetrics, paramInt);
  }
  
  public boolean zzhq()
  {
    return Build.DEVICE.startsWith("generic");
  }
  
  public boolean zzhr()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\util\client\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */