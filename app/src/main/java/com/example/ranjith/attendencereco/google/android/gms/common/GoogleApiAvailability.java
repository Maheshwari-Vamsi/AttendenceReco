package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.google.android.gms.R.string;
import com.google.android.gms.common.internal.zzn;

public class GoogleApiAvailability
{
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  private static final GoogleApiAvailability zzadU = new GoogleApiAvailability();
  
  public static GoogleApiAvailability getInstance()
  {
    return zzadU;
  }
  
  private String zzi(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gcore_");
    localStringBuilder.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
    localStringBuilder.append("-");
    if (!TextUtils.isEmpty(paramString)) {
      localStringBuilder.append(paramString);
    }
    localStringBuilder.append("-");
    if (paramContext != null) {
      localStringBuilder.append(paramContext.getPackageName());
    }
    localStringBuilder.append("-");
    if (paramContext != null) {}
    try
    {
      localStringBuilder.append(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode);
      return localStringBuilder.toString();
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;) {}
    }
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return GooglePlayServicesUtil.getErrorDialog(paramInt1, paramActivity, paramInt2);
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return GooglePlayServicesUtil.getErrorDialog(paramInt1, paramActivity, paramInt2, paramOnCancelListener);
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    return zza(paramContext, paramInt1, paramInt2, null);
  }
  
  public final String getErrorString(int paramInt)
  {
    return GooglePlayServicesUtil.getErrorString(paramInt);
  }
  
  public String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    return GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(paramContext);
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext)
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext);
    if (GooglePlayServicesUtil.zzd(paramContext, i)) {
      i = 18;
    }
    return i;
  }
  
  public final boolean isUserResolvableError(int paramInt)
  {
    return GooglePlayServicesUtil.isUserRecoverableError(paramInt);
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return GooglePlayServicesUtil.showErrorDialogFragment(paramInt1, paramActivity, paramInt2);
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return GooglePlayServicesUtil.showErrorDialogFragment(paramInt1, paramActivity, paramInt2, paramOnCancelListener);
  }
  
  public void showErrorNotification(Context paramContext, int paramInt)
  {
    GooglePlayServicesUtil.showErrorNotification(paramInt, paramContext);
  }
  
  public Dialog zza(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    ProgressBar localProgressBar = new ProgressBar(paramActivity, null, 16842874);
    localProgressBar.setIndeterminate(true);
    localProgressBar.setVisibility(0);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    localBuilder.setView(localProgressBar);
    String str = GooglePlayServicesUtil.zzam(paramActivity);
    localBuilder.setMessage(paramActivity.getResources().getString(R.string.common_google_play_services_updating_text, new Object[] { str }));
    localBuilder.setTitle(R.string.common_google_play_services_updating_title);
    localBuilder.setPositiveButton("", null);
    AlertDialog localAlertDialog = localBuilder.create();
    GooglePlayServicesUtil.zza(paramActivity, paramOnCancelListener, "GooglePlayServicesUpdatingDialog", localAlertDialog);
    return localAlertDialog;
  }
  
  public PendingIntent zza(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = zza(paramContext, paramInt1, paramString);
    if (localIntent == null) {
      return null;
    }
    return PendingIntent.getActivity(paramContext, paramInt2, localIntent, 268435456);
  }
  
  public Intent zza(Context paramContext, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      return zzn.zzy("com.google.android.gms", zzi(paramContext, paramString));
    case 42: 
      return zzn.zzqE();
    }
    return zzn.zzcD("com.google.android.gms");
  }
  
  public void zzai(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    GooglePlayServicesUtil.zzac(paramContext);
  }
  
  public void zzaj(Context paramContext)
  {
    GooglePlayServicesUtil.zzaj(paramContext);
  }
  
  @Deprecated
  public Intent zzbu(int paramInt)
  {
    return zza(null, paramInt, null);
  }
  
  public boolean zzd(Context paramContext, int paramInt)
  {
    return GooglePlayServicesUtil.zzd(paramContext, paramInt);
  }
  
  public boolean zzh(Context paramContext, String paramString)
  {
    return GooglePlayServicesUtil.zzh(paramContext, paramString);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\GoogleApiAvailability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */