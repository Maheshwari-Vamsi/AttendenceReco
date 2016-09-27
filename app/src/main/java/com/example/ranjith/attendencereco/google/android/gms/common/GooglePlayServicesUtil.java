package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.UserManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.R.drawable;
import com.google.android.gms.R.string;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznj;
import com.google.android.gms.internal.zznx;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public final class GooglePlayServicesUtil
{
  public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
  @Deprecated
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = ;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  public static boolean zzaee = false;
  public static boolean zzaef = false;
  private static int zzaeg = -1;
  private static String zzaeh = null;
  private static Integer zzaei = null;
  static final AtomicBoolean zzaej = new AtomicBoolean();
  private static final AtomicBoolean zzaek = new AtomicBoolean();
  private static final Object zzqf = new Object();
  
  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return getErrorDialog(paramInt1, paramActivity, paramInt2, null);
  }
  
  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return zza(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }
  
  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    return GoogleApiAvailability.getInstance().getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  @Deprecated
  public static String getErrorString(int paramInt)
  {
    return ConnectionResult.getStatusString(paramInt);
  }
  
  @Deprecated
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    Uri localUri = new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("oss_notice").build();
    try
    {
      InputStream localInputStream = paramContext.getContentResolver().openInputStream(localUri);
      String str1;
      try
      {
        String str2 = new Scanner(localInputStream).useDelimiter("\\A").next();
        str1 = str2;
        if (localInputStream != null)
        {
          localInputStream.close();
          return str1;
        }
      }
      catch (NoSuchElementException localNoSuchElementException)
      {
        localNoSuchElementException = localNoSuchElementException;
        if (localInputStream == null) {
          break label110;
        }
        localInputStream.close();
        break label110;
      }
      finally
      {
        localObject = finally;
        if (localInputStream != null) {
          localInputStream.close();
        }
        throw ((Throwable)localObject);
      }
      return str1;
    }
    catch (Exception localException)
    {
      str1 = null;
    }
    label110:
    return null;
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      Context localContext = paramContext.createPackageContext("com.google.android.gms", 3);
      return localContext;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return null;
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      Resources localResources = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      return localResources;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return null;
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    if (com.google.android.gms.common.internal.zzd.zzaiU) {
      return 0;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    PackageInfo localPackageInfo;
    zzd localzzd;
    try
    {
      paramContext.getResources().getString(R.string.common_google_play_services_unknown_issue);
      if (!"com.google.android.gms".equals(paramContext.getPackageName())) {
        zzak(paramContext);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          localPackageInfo = localPackageManager.getPackageInfo("com.google.android.gms", 64);
          localzzd = zzd.zzox();
          if (!zznj.zzav(paramContext)) {
            break;
          }
          if (localzzd.zza(localPackageInfo, zzc.zzcg.zzaed) != null) {
            break label188;
          }
          Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
          return 9;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException1)
        {
          Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
          return 1;
        }
        localThrowable = localThrowable;
        Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
      }
    }
    zzc.zza localzza;
    try
    {
      localzza = localzzd.zza(localPackageManager.getPackageInfo("com.android.vending", 8256), zzc.zzcg.zzaed);
      if (localzza == null)
      {
        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
        return 9;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException2)
    {
      Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
      return 9;
    }
    if (localzzd.zza(localPackageInfo, new zzc.zza[] { localzza }) == null)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
      return 9;
    }
    label188:
    int i = zznj.zzcp(GOOGLE_PLAY_SERVICES_VERSION_CODE);
    if (zznj.zzcp(localPackageInfo.versionCode) < i)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + localPackageInfo.versionCode);
      return 2;
    }
    Object localObject = localPackageInfo.applicationInfo;
    if (localObject == null) {}
    try
    {
      ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
      localObject = localApplicationInfo;
      if (!((ApplicationInfo)localObject).enabled) {
        return 3;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException3)
    {
      Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", localNameNotFoundException3);
      return 1;
    }
    return 0;
  }
  
  @Deprecated
  public static boolean isUserRecoverableError(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return false;
    }
    return true;
  }
  
  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, paramInt2, null);
  }
  
  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }
  
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Dialog localDialog = zza(paramInt1, paramActivity, paramFragment, paramInt2, paramOnCancelListener);
    if (localDialog == null) {
      return false;
    }
    zza(paramActivity, paramOnCancelListener, "GooglePlayServicesErrorDialog", localDialog);
    return true;
  }
  
  @Deprecated
  public static void showErrorNotification(int paramInt, Context paramContext)
  {
    if ((zznj.zzav(paramContext)) && (paramInt == 2)) {
      paramInt = 42;
    }
    if ((zzd(paramContext, paramInt)) || (zzf(paramContext, paramInt)))
    {
      zzal(paramContext);
      return;
    }
    zza(paramInt, paramContext);
  }
  
  private static Dialog zza(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (paramInt1 == 0) {
      return null;
    }
    if ((zznj.zzav(paramActivity)) && (paramInt1 == 2)) {
      paramInt1 = 42;
    }
    boolean bool1 = zznx.zzrQ();
    AlertDialog.Builder localBuilder = null;
    if (bool1)
    {
      TypedValue localTypedValue = new TypedValue();
      paramActivity.getTheme().resolveAttribute(16843529, localTypedValue, true);
      boolean bool2 = "Theme.Dialog.Alert".equals(paramActivity.getResources().getResourceEntryName(localTypedValue.resourceId));
      localBuilder = null;
      if (bool2) {
        localBuilder = new AlertDialog.Builder(paramActivity, 5);
      }
    }
    if (localBuilder == null) {
      localBuilder = new AlertDialog.Builder(paramActivity);
    }
    localBuilder.setMessage(zzg.zzc(paramActivity, paramInt1, zzam(paramActivity)));
    if (paramOnCancelListener != null) {
      localBuilder.setOnCancelListener(paramOnCancelListener);
    }
    Intent localIntent = GoogleApiAvailability.getInstance().zza(paramActivity, paramInt1, "d");
    if (paramFragment == null) {}
    for (zzh localzzh = new zzh(paramActivity, localIntent, paramInt2);; localzzh = new zzh(paramFragment, localIntent, paramInt2))
    {
      String str1 = zzg.zzh(paramActivity, paramInt1);
      if (str1 != null) {
        localBuilder.setPositiveButton(str1, localzzh);
      }
      String str2 = zzg.zzg(paramActivity, paramInt1);
      if (str2 != null) {
        localBuilder.setTitle(str2);
      }
      return localBuilder.create();
    }
  }
  
  private static void zza(int paramInt, Context paramContext)
  {
    zza(paramInt, paramContext, null);
  }
  
  private static void zza(int paramInt, Context paramContext, String paramString)
  {
    Resources localResources = paramContext.getResources();
    String str1 = zzam(paramContext);
    String str2 = zzg.zzi(paramContext, paramInt);
    if (str2 == null) {
      str2 = localResources.getString(R.string.common_google_play_services_notification_ticker);
    }
    String str3 = zzg.zzd(paramContext, paramInt, str1);
    PendingIntent localPendingIntent = GoogleApiAvailability.getInstance().zza(paramContext, paramInt, 0, "n");
    Object localObject;
    if (zznj.zzav(paramContext))
    {
      zzx.zzaa(zznx.zzrR());
      localObject = new Notification.Builder(paramContext).setSmallIcon(R.drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new Notification.BigTextStyle().bigText(str2 + " " + str3)).addAction(R.drawable.common_full_open_on_phone, localResources.getString(R.string.common_open_on_phone), localPendingIntent).build();
      if (!zzbw(paramInt)) {
        break label383;
      }
      zzaej.set(false);
    }
    NotificationManager localNotificationManager;
    label383:
    for (int i = 10436;; i = 39789)
    {
      localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
      if (paramString == null) {
        break label391;
      }
      localNotificationManager.notify(paramString, i, (Notification)localObject);
      return;
      String str4 = localResources.getString(R.string.common_google_play_services_notification_ticker);
      if (zznx.zzrN())
      {
        Notification.Builder localBuilder = new Notification.Builder(paramContext).setSmallIcon(17301642).setContentTitle(str2).setContentText(str3).setContentIntent(localPendingIntent).setTicker(str4).setAutoCancel(true);
        if (zznx.zzrV()) {
          localBuilder.setLocalOnly(true);
        }
        if (zznx.zzrR()) {
          localBuilder.setStyle(new Notification.BigTextStyle().bigText(str3));
        }
        for (Notification localNotification = localBuilder.build();; localNotification = localBuilder.getNotification())
        {
          if (Build.VERSION.SDK_INT == 19) {
            localNotification.extras.putBoolean("android.support.localOnly", true);
          }
          localObject = localNotification;
          break;
        }
      }
      localObject = new NotificationCompat.Builder(paramContext).setSmallIcon(17301642).setTicker(str4).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent(localPendingIntent).setContentTitle(str2).setContentText(str3).build();
      break;
    }
    label391:
    localNotificationManager.notify(i, (Notification)localObject);
  }
  
  public static void zza(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener, String paramString, Dialog paramDialog)
  {
    try
    {
      bool = paramActivity instanceof FragmentActivity;
      if (bool)
      {
        android.support.v4.app.FragmentManager localFragmentManager1 = ((FragmentActivity)paramActivity).getSupportFragmentManager();
        SupportErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(localFragmentManager1, paramString);
        return;
      }
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      for (;;)
      {
        boolean bool = false;
      }
      if (zznx.zzrN())
      {
        android.app.FragmentManager localFragmentManager = paramActivity.getFragmentManager();
        ErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(localFragmentManager, paramString);
        return;
      }
      throw new RuntimeException("This Activity does not support Fragments.");
    }
  }
  
  @Deprecated
  public static void zzac(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    int i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(paramContext);
    if (i != 0)
    {
      Intent localIntent = GoogleApiAvailability.getInstance().zza(paramContext, i, "e");
      Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + i);
      if (localIntent == null) {
        throw new GooglePlayServicesNotAvailableException(i);
      }
      throw new GooglePlayServicesRepairableException(i, "Google Play Services not available", localIntent);
    }
  }
  
  @Deprecated
  public static void zzaj(Context paramContext)
  {
    if (zzaej.getAndSet(true)) {
      return;
    }
    try
    {
      ((NotificationManager)paramContext.getSystemService("notification")).cancel(10436);
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  private static void zzak(Context paramContext)
  {
    if (zzaek.get()) {}
    Integer localInteger;
    do
    {
      return;
      for (;;)
      {
        synchronized (zzqf)
        {
          if (zzaeh == null)
          {
            zzaeh = paramContext.getPackageName();
            try
            {
              Bundle localBundle = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
              if (localBundle == null) {
                continue;
              }
              zzaei = Integer.valueOf(localBundle.getInt("com.google.android.gms.version"));
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException)
            {
              Log.wtf("GooglePlayServicesUtil", "This should never happen.", localNameNotFoundException);
              continue;
            }
            localInteger = zzaei;
            if (localInteger != null) {
              break;
            }
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            zzaei = null;
          }
        }
        if (!zzaeh.equals(paramContext.getPackageName())) {
          throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + zzaeh + "' and this call used package '" + paramContext.getPackageName() + "'.");
        }
      }
    } while (localInteger.intValue() == GOOGLE_PLAY_SERVICES_VERSION_CODE);
    throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but" + " found " + localInteger + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
  }
  
  private static void zzal(Context paramContext)
  {
    zza localzza = new zza(paramContext);
    localzza.sendMessageDelayed(localzza.obtainMessage(1), 120000L);
  }
  
  public static String zzam(Context paramContext)
  {
    String str = paramContext.getApplicationInfo().name;
    PackageManager localPackageManager;
    if (TextUtils.isEmpty(str))
    {
      str = paramContext.getPackageName();
      localPackageManager = paramContext.getApplicationContext().getPackageManager();
    }
    try
    {
      ApplicationInfo localApplicationInfo2 = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
      localApplicationInfo1 = localApplicationInfo2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        ApplicationInfo localApplicationInfo1 = null;
      }
    }
    if (localApplicationInfo1 != null) {
      str = localPackageManager.getApplicationLabel(localApplicationInfo1).toString();
    }
    return str;
  }
  
  @Deprecated
  public static int zzan(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      return localPackageInfo.versionCode;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
    }
    return 0;
  }
  
  public static boolean zzao(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    return (zznx.zzrW()) && (localPackageManager.hasSystemFeature("cn.google"));
  }
  
  public static boolean zzap(Context paramContext)
  {
    if (zznx.zzrT())
    {
      Bundle localBundle = ((UserManager)paramContext.getSystemService("user")).getApplicationRestrictions(paramContext.getPackageName());
      if ((localBundle != null) && ("true".equals(localBundle.getString("restricted_profile")))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean zzb(Context paramContext, int paramInt, String paramString)
  {
    AppOpsManager localAppOpsManager;
    if (zznx.zzrU()) {
      localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
    }
    for (;;)
    {
      try
      {
        localAppOpsManager.checkPackage(paramInt, paramString);
        bool = true;
        return bool;
      }
      catch (SecurityException localSecurityException) {}
      String[] arrayOfString = paramContext.getPackageManager().getPackagesForUid(paramInt);
      boolean bool = false;
      if (paramString != null)
      {
        bool = false;
        if (arrayOfString != null) {
          for (int i = 0;; i++)
          {
            int j = arrayOfString.length;
            bool = false;
            if (i >= j) {
              break;
            }
            if (paramString.equals(arrayOfString[i])) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  public static boolean zzb(PackageManager paramPackageManager)
  {
    for (boolean bool = true;; bool = false) {
      synchronized (zzqf)
      {
        int i = zzaeg;
        if (i == -1) {}
        try
        {
          PackageInfo localPackageInfo = paramPackageManager.getPackageInfo("com.google.android.gms", 64);
          zzd localzzd = zzd.zzox();
          zzc.zza[] arrayOfzza = new zzc.zza[1];
          arrayOfzza[0] = zzc.zzadW[1];
          if (localzzd.zza(localPackageInfo, arrayOfzza) != null) {}
          for (zzaeg = 1; zzaeg != 0; zzaeg = 0) {
            return bool;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            zzaeg = 0;
          }
        }
      }
    }
  }
  
  @Deprecated
  public static boolean zzb(PackageManager paramPackageManager, String paramString)
  {
    return zzd.zzox().zzb(paramPackageManager, paramString);
  }
  
  @Deprecated
  public static Intent zzbv(int paramInt)
  {
    return GoogleApiAvailability.getInstance().zza(null, paramInt, null);
  }
  
  private static boolean zzbw(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean zzc(PackageManager paramPackageManager)
  {
    return (zzb(paramPackageManager)) || (!zzow());
  }
  
  @Deprecated
  public static boolean zzd(Context paramContext, int paramInt)
  {
    if (paramInt == 18) {
      return true;
    }
    if (paramInt == 1) {
      return zzh(paramContext, "com.google.android.gms");
    }
    return false;
  }
  
  public static boolean zze(Context paramContext, int paramInt)
  {
    return (zzb(paramContext, paramInt, "com.google.android.gms")) && (zzb(paramContext.getPackageManager(), "com.google.android.gms"));
  }
  
  @Deprecated
  public static boolean zzf(Context paramContext, int paramInt)
  {
    if (paramInt == 9) {
      return zzh(paramContext, "com.android.vending");
    }
    return false;
  }
  
  static boolean zzh(Context paramContext, String paramString)
  {
    if (zznx.zzrW())
    {
      Iterator localIterator = paramContext.getPackageManager().getPackageInstaller().getAllSessions().iterator();
      while (localIterator.hasNext()) {
        if (paramString.equals(((PackageInstaller.SessionInfo)localIterator.next()).getAppPackageName())) {
          return true;
        }
      }
    }
    if (zzap(paramContext)) {
      return false;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      boolean bool = localPackageManager.getApplicationInfo(paramString, 8192).enabled;
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  private static int zzov()
  {
    return 8298000;
  }
  
  public static boolean zzow()
  {
    if (zzaee) {
      return zzaef;
    }
    return "user".equals(Build.TYPE);
  }
  
  private static class zza
    extends Handler
  {
    private final Context zzrI;
    
    zza(Context paramContext) {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.w("GooglePlayServicesUtil", "Don't know how to handle this message: " + paramMessage.what);
      }
      int i;
      do
      {
        return;
        i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzrI);
      } while (!GooglePlayServicesUtil.isUserRecoverableError(i));
      GooglePlayServicesUtil.zzb(i, this.zzrI);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\GooglePlayServicesUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */