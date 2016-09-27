package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.firstparty.shared.zzd;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzau;
import com.google.android.gms.internal.zzau.zza;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public final class GoogleAuthUtil
{
  public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
  public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
  public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
  public static final String KEY_ANDROID_PACKAGE_NAME;
  public static final String KEY_CALLER_UID;
  public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
  @Deprecated
  public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
  public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
  private static final ComponentName zzTH;
  private static final ComponentName zzTI;
  
  static
  {
    String str1;
    if (Build.VERSION.SDK_INT >= 11)
    {
      str1 = "callerUid";
      KEY_CALLER_UID = str1;
      if (Build.VERSION.SDK_INT < 14) {
        break label65;
      }
    }
    label65:
    for (String str2 = "androidPackageName";; str2 = "androidPackageName")
    {
      KEY_ANDROID_PACKAGE_NAME = str2;
      zzTH = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
      zzTI = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
      return;
      str1 = "callerUid";
      break;
    }
  }
  
  public static void clearToken(Context paramContext, String paramString)
    throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException
  {
    zzx.zzcy("Calling this from your main thread can lead to deadlock");
    zzac(paramContext);
    final Bundle localBundle = new Bundle();
    String str = paramContext.getApplicationInfo().packageName;
    localBundle.putString("clientPackageName", str);
    if (!localBundle.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
      localBundle.putString(KEY_ANDROID_PACKAGE_NAME, str);
    }
    zza local2 = new zza()
    {
      public Void zzao(IBinder paramAnonymousIBinder)
        throws RemoteException, IOException, GoogleAuthException
      {
        Bundle localBundle = (Bundle)GoogleAuthUtil.zzm(zzau.zza.zza(paramAnonymousIBinder).zza(this.zzTM, localBundle));
        String str = localBundle.getString("Error");
        if (!localBundle.getBoolean("booleanResult")) {
          throw new GoogleAuthException(str);
        }
        return null;
      }
    };
    zza(paramContext, zzTH, local2);
  }
  
  public static List<AccountChangeEvent> getAccountChangeEvents(Context paramContext, final int paramInt, String paramString)
    throws GoogleAuthException, IOException
  {
    zzx.zzh(paramString, "accountName must be provided");
    zzx.zzcy("Calling this from your main thread can lead to deadlock");
    zzac(paramContext);
    zza local3 = new zza()
    {
      public List<AccountChangeEvent> zzap(IBinder paramAnonymousIBinder)
        throws RemoteException, IOException, GoogleAuthException
      {
        return ((AccountChangeEventsResponse)GoogleAuthUtil.zzm(zzau.zza.zza(paramAnonymousIBinder).zza(new AccountChangeEventsRequest().setAccountName(this.zzTO).setEventIndex(paramInt)))).getEvents();
      }
    };
    return (List)zza(paramContext, zzTH, local3);
  }
  
  public static String getAccountId(Context paramContext, String paramString)
    throws GoogleAuthException, IOException
  {
    zzx.zzh(paramString, "accountName must be provided");
    zzx.zzcy("Calling this from your main thread can lead to deadlock");
    zzac(paramContext);
    return getToken(paramContext, paramString, "^^_account_id_^^", new Bundle());
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, paramAccount, paramString, new Bundle());
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return zza(paramContext, paramAccount, paramString, paramBundle).getToken();
  }
  
  @Deprecated
  public static String getToken(Context paramContext, String paramString1, String paramString2)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, new Account(paramString1, "com.google"), paramString2);
  }
  
  @Deprecated
  public static String getToken(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle);
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    return zzb(paramContext, paramAccount, paramString, paramBundle).getToken();
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle, Intent paramIntent)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    zzi(paramIntent);
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    paramBundle.putParcelable("callback_intent", paramIntent);
    paramBundle.putBoolean("handle_notification", true);
    return zzc(paramContext, paramAccount, paramString, paramBundle).getToken();
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString1, Bundle paramBundle1, String paramString2, Bundle paramBundle2)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    zzx.zzh(paramString2, "Authority cannot be empty or null.");
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    if (paramBundle2 == null) {
      paramBundle2 = new Bundle();
    }
    ContentResolver.validateSyncExtrasBundle(paramBundle2);
    paramBundle1.putString("authority", paramString2);
    paramBundle1.putBundle("sync_extras", paramBundle2);
    paramBundle1.putBoolean("handle_notification", true);
    return zzc(paramContext, paramAccount, paramString1, paramBundle1).getToken();
  }
  
  @Deprecated
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    return getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle);
  }
  
  @Deprecated
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, Intent paramIntent)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    return getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle, paramIntent);
  }
  
  @Deprecated
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, String paramString3, Bundle paramBundle2)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    return getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle1, paramString3, paramBundle2);
  }
  
  @Deprecated
  public static void invalidateToken(Context paramContext, String paramString)
  {
    AccountManager.get(paramContext).invalidateAuthToken("com.google", paramString);
  }
  
  public static TokenData zza(Context paramContext, Account paramAccount, final String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    zzx.zzcy("Calling this from your main thread can lead to deadlock");
    zzac(paramContext);
    if (paramBundle == null) {}
    for (final Bundle localBundle = new Bundle();; localBundle = new Bundle(paramBundle))
    {
      String str = paramContext.getApplicationInfo().packageName;
      localBundle.putString("clientPackageName", str);
      if (TextUtils.isEmpty(localBundle.getString(KEY_ANDROID_PACKAGE_NAME))) {
        localBundle.putString(KEY_ANDROID_PACKAGE_NAME, str);
      }
      localBundle.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
      zza local1 = new zza()
      {
        public TokenData zzam(IBinder paramAnonymousIBinder)
          throws RemoteException, IOException, GoogleAuthException
        {
          Bundle localBundle = (Bundle)GoogleAuthUtil.zzm(zzau.zza.zza(paramAnonymousIBinder).zza(this.zzTJ, paramString, localBundle));
          TokenData localTokenData = TokenData.zza(localBundle, "tokenDetails");
          if (localTokenData != null) {
            return localTokenData;
          }
          String str = localBundle.getString("Error");
          Intent localIntent = (Intent)localBundle.getParcelable("userRecoveryIntent");
          zzd localzzd = zzd.zzbT(str);
          if (zzd.zza(localzzd)) {
            throw new UserRecoverableAuthException(str, localIntent);
          }
          if (zzd.zzc(localzzd)) {
            throw new IOException(str);
          }
          throw new GoogleAuthException(str);
        }
      };
      return (TokenData)zza(paramContext, zzTH, local1);
    }
  }
  
  /* Error */
  private static <T> T zza(Context paramContext, ComponentName paramComponentName, zza<T> paramzza)
    throws IOException, GoogleAuthException
  {
    // Byte code:
    //   0: new 253	com/google/android/gms/common/zza
    //   3: dup
    //   4: invokespecial 254	com/google/android/gms/common/zza:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokestatic 260	com/google/android/gms/common/internal/zzl:zzat	(Landroid/content/Context;)Lcom/google/android/gms/common/internal/zzl;
    //   12: astore 4
    //   14: aload 4
    //   16: aload_1
    //   17: aload_3
    //   18: ldc_w 262
    //   21: invokevirtual 265	com/google/android/gms/common/internal/zzl:zza	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)Z
    //   24: ifeq +70 -> 94
    //   27: aload_2
    //   28: aload_3
    //   29: invokevirtual 269	com/google/android/gms/common/zza:zzor	()Landroid/os/IBinder;
    //   32: invokeinterface 275 2 0
    //   37: astore 8
    //   39: aload 4
    //   41: aload_1
    //   42: aload_3
    //   43: ldc_w 262
    //   46: invokevirtual 278	com/google/android/gms/common/internal/zzl:zzb	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   49: aload 8
    //   51: areturn
    //   52: astore 5
    //   54: ldc_w 262
    //   57: ldc_w 280
    //   60: aload 5
    //   62: invokestatic 286	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   65: pop
    //   66: new 71	java/io/IOException
    //   69: dup
    //   70: ldc_w 280
    //   73: aload 5
    //   75: invokespecial 289	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   78: athrow
    //   79: astore 6
    //   81: aload 4
    //   83: aload_1
    //   84: aload_3
    //   85: ldc_w 262
    //   88: invokevirtual 278	com/google/android/gms/common/internal/zzl:zzb	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   91: aload 6
    //   93: athrow
    //   94: new 71	java/io/IOException
    //   97: dup
    //   98: ldc_w 291
    //   101: invokespecial 293	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   104: athrow
    //   105: astore 5
    //   107: goto -53 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramContext	Context
    //   0	110	1	paramComponentName	ComponentName
    //   0	110	2	paramzza	zza<T>
    //   7	78	3	localzza	com.google.android.gms.common.zza
    //   12	70	4	localzzl	com.google.android.gms.common.internal.zzl
    //   52	22	5	localInterruptedException	InterruptedException
    //   105	1	5	localRemoteException	RemoteException
    //   79	13	6	localObject1	Object
    //   37	13	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	39	52	java/lang/InterruptedException
    //   27	39	79	finally
    //   54	79	79	finally
    //   27	39	105	android/os/RemoteException
  }
  
  private static void zzac(Context paramContext)
    throws GoogleAuthException
  {
    try
    {
      GooglePlayServicesUtil.zzac(paramContext.getApplicationContext());
      return;
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      throw new GooglePlayServicesAvailabilityException(localGooglePlayServicesRepairableException.getConnectionStatusCode(), localGooglePlayServicesRepairableException.getMessage(), localGooglePlayServicesRepairableException.getIntent());
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      throw new GoogleAuthException(localGooglePlayServicesNotAvailableException.getMessage());
    }
  }
  
  public static TokenData zzb(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    paramBundle.putBoolean("handle_notification", true);
    return zzc(paramContext, paramAccount, paramString, paramBundle);
  }
  
  private static TokenData zzc(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, GoogleAuthException
  {
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    try
    {
      TokenData localTokenData = zza(paramContext, paramAccount, paramString, paramBundle);
      GooglePlayServicesUtil.zzaj(paramContext);
      return localTokenData;
    }
    catch (GooglePlayServicesAvailabilityException localGooglePlayServicesAvailabilityException)
    {
      GooglePlayServicesUtil.showErrorNotification(localGooglePlayServicesAvailabilityException.getConnectionStatusCode(), paramContext);
      throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
    }
    catch (UserRecoverableAuthException localUserRecoverableAuthException)
    {
      GooglePlayServicesUtil.zzaj(paramContext);
      throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
    }
  }
  
  private static void zzi(Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new IllegalArgumentException("Callback cannot be null.");
    }
    String str = paramIntent.toUri(1);
    try
    {
      Intent.parseUri(str, 1);
      return;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
    }
  }
  
  private static <T> T zzl(T paramT)
    throws IOException
  {
    if (paramT == null)
    {
      Log.w("GoogleAuthUtil", "Binder call returned null.");
      throw new IOException("Service unavailable.");
    }
    return paramT;
  }
  
  private static abstract interface zza<T>
  {
    public abstract T zzan(IBinder paramIBinder)
      throws RemoteException, IOException, GoogleAuthException;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\auth\GoogleAuthUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */