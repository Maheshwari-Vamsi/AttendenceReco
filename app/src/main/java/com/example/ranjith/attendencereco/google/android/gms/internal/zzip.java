package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzip
{
  private static final String zzKI = AdView.class.getName();
  private static final String zzKJ = InterstitialAd.class.getName();
  private static final String zzKK = PublisherAdView.class.getName();
  private static final String zzKL = PublisherInterstitialAd.class.getName();
  private static final String zzKM = SearchAdView.class.getName();
  private static final String zzKN = AdLoader.class.getName();
  public static final Handler zzKO = new zzim(Looper.getMainLooper());
  private boolean zzKP = true;
  private boolean zzKQ = false;
  private String zzKi;
  private final Object zzpK = new Object();
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramRunnable.run();
      return;
    }
    zzKO.post(paramRunnable);
  }
  
  private JSONArray zza(Collection<?> paramCollection)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext()) {
      zza(localJSONArray, localIterator.next());
    }
    return localJSONArray;
  }
  
  private void zza(JSONArray paramJSONArray, Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONArray.put(zzf((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONArray.put(zzz((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      paramJSONArray.put(zza((Collection)paramObject));
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramJSONArray.put(zza((Object[])paramObject));
      return;
    }
    paramJSONArray.put(paramObject);
  }
  
  private void zza(JSONObject paramJSONObject, String paramString, Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONObject.put(paramString, zzf((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONObject.put(paramString, zzz((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      if (paramString != null) {}
      for (;;)
      {
        paramJSONObject.put(paramString, zza((Collection)paramObject));
        return;
        paramString = "null";
      }
    }
    if ((paramObject instanceof Object[]))
    {
      paramJSONObject.put(paramString, zza(Arrays.asList((Object[])paramObject)));
      return;
    }
    paramJSONObject.put(paramString, paramObject);
  }
  
  static String zzb(String paramString1, String paramString2, int paramInt)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString1, paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramInt - 1;
    if ((paramInt > 0) && (localStringTokenizer.hasMoreElements()))
    {
      localStringBuilder.append(localStringTokenizer.nextToken());
      for (;;)
      {
        int j = i - 1;
        if ((i <= 0) || (!localStringTokenizer.hasMoreElements())) {
          break;
        }
        localStringBuilder.append(".").append(localStringTokenizer.nextToken());
        i = j;
      }
      paramString1 = localStringBuilder.toString();
    }
    return paramString1;
  }
  
  private JSONObject zzf(Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      zza(localJSONObject, str, paramBundle.get(str));
    }
    return localJSONObject;
  }
  
  private boolean zzs(Context paramContext)
  {
    PowerManager localPowerManager = (PowerManager)paramContext.getSystemService("power");
    if (localPowerManager == null) {
      return false;
    }
    return localPowerManager.isScreenOn();
  }
  
  public boolean zzJ(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    ResolveInfo localResolveInfo = paramContext.getPackageManager().resolveActivity(localIntent, 65536);
    if ((localResolveInfo == null) || (localResolveInfo.activityInfo == null))
    {
      zzb.zzaH("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
      return false;
    }
    if ((0x10 & localResolveInfo.activityInfo.configChanges) == 0) {
      zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "keyboard" }));
    }
    for (boolean bool = false;; bool = true)
    {
      if ((0x20 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "keyboardHidden" }));
        bool = false;
      }
      if ((0x80 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "orientation" }));
        bool = false;
      }
      if ((0x100 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "screenLayout" }));
        bool = false;
      }
      if ((0x200 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "uiMode" }));
        bool = false;
      }
      if ((0x400 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "screenSize" }));
        bool = false;
      }
      if ((0x800 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "smallestScreenSize" }));
        return false;
      }
      return bool;
    }
  }
  
  public boolean zzK(Context paramContext)
  {
    if (this.zzKQ) {
      return false;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.getApplicationContext().registerReceiver(new zza(null), localIntentFilter);
    this.zzKQ = true;
    return true;
  }
  
  protected String zzL(Context paramContext)
  {
    return new WebView(paramContext).getSettings().getUserAgentString();
  }
  
  public AlertDialog.Builder zzM(Context paramContext)
  {
    return new AlertDialog.Builder(paramContext);
  }
  
  public zzbr zzN(Context paramContext)
  {
    return new zzbr(paramContext);
  }
  
  public String zzO(Context paramContext)
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      if (localActivityManager == null) {
        return null;
      }
      List localList = localActivityManager.getRunningTasks(1);
      if ((localList != null) && (!localList.isEmpty()))
      {
        ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)localList.get(0);
        if ((localRunningTaskInfo != null) && (localRunningTaskInfo.topActivity != null))
        {
          String str = localRunningTaskInfo.topActivity.getClassName();
          return str;
        }
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public boolean zzP(Context paramContext)
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      KeyguardManager localKeyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
      if ((localActivityManager != null) && (localKeyguardManager != null))
      {
        List localList = localActivityManager.getRunningAppProcesses();
        if (localList == null) {
          return false;
        }
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
          if (Process.myPid() == localRunningAppProcessInfo.pid) {
            if ((localRunningAppProcessInfo.importance == 100) && (!localKeyguardManager.inKeyguardRestrictedInputMode()))
            {
              boolean bool = zzs(paramContext);
              if (bool) {
                return true;
              }
            }
          }
        }
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      return false;
    }
    return false;
  }
  
  public Bitmap zzQ(Context paramContext)
  {
    if (!(paramContext instanceof Activity)) {
      return null;
    }
    try
    {
      View localView = ((Activity)paramContext).getWindow().getDecorView();
      Bitmap localBitmap = Bitmap.createBitmap(localView.getWidth(), localView.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localView.layout(0, 0, localView.getWidth(), localView.getHeight());
      localView.draw(localCanvas);
      return localBitmap;
    }
    catch (RuntimeException localRuntimeException)
    {
      zzb.zzb("Fail to capture screen shot", localRuntimeException);
    }
    return null;
  }
  
  public DisplayMetrics zza(WindowManager paramWindowManager)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public PopupWindow zza(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return new PopupWindow(paramView, paramInt1, paramInt2, paramBoolean);
  }
  
  public String zza(Context paramContext, View paramView, AdSizeParcel paramAdSizeParcel)
  {
    if (!((Boolean)zzbz.zzwe.get()).booleanValue()) {
      return null;
    }
    View localView;
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("width", paramAdSizeParcel.width);
      localJSONObject2.put("height", paramAdSizeParcel.height);
      localJSONObject1.put("size", localJSONObject2);
      localJSONObject1.put("activity", zzO(paramContext));
      if (!paramAdSizeParcel.zztW)
      {
        JSONArray localJSONArray = new JSONArray();
        if (paramView != null)
        {
          ViewParent localViewParent = paramView.getParent();
          if (localViewParent != null)
          {
            int i = -1;
            if ((localViewParent instanceof ViewGroup)) {
              i = ((ViewGroup)localViewParent).indexOfChild(paramView);
            }
            JSONObject localJSONObject3 = new JSONObject();
            localJSONObject3.put("type", localViewParent.getClass().getName());
            localJSONObject3.put("index_of_child", i);
            localJSONArray.put(localJSONObject3);
          }
          if ((localViewParent == null) || (!(localViewParent instanceof View))) {
            break label254;
          }
          localView = (View)localViewParent;
          break label248;
        }
        if (localJSONArray.length() > 0) {
          localJSONObject1.put("parents", localJSONArray);
        }
      }
      String str = localJSONObject1.toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
      zzb.zzd("Fail to get view hierarchy json", localJSONException);
      return null;
    }
    for (;;)
    {
      label248:
      paramView = localView;
      break;
      label254:
      localView = null;
    }
  }
  
  public String zza(Context paramContext, zzan paramzzan, String paramString)
  {
    if (paramzzan == null) {
      return paramString;
    }
    try
    {
      Uri localUri = Uri.parse(paramString);
      if (paramzzan.zzc(localUri)) {
        localUri = paramzzan.zza(localUri, paramContext);
      }
      String str = localUri.toString();
      return str;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public String zza(zzjn paramzzjn, String paramString)
  {
    return zza(paramzzjn.getContext(), paramzzjn.zzhE(), paramString);
  }
  
  public String zza(InputStreamReader paramInputStreamReader)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder(8192);
    char[] arrayOfChar = new char['ࠀ'];
    for (;;)
    {
      int i = paramInputStreamReader.read(arrayOfChar);
      if (i == -1) {
        break;
      }
      localStringBuilder.append(arrayOfChar, 0, i);
    }
    return localStringBuilder.toString();
  }
  
  public String zza(StackTraceElement[] paramArrayOfStackTraceElement, String paramString)
  {
    int i;
    if (((Boolean)zzbz.zzwx.get()).booleanValue())
    {
      i = 0;
      if (i + 1 >= paramArrayOfStackTraceElement.length) {
        break label166;
      }
      StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
      String str3 = localStackTraceElement.getClassName();
      if ((!"loadAd".equalsIgnoreCase(localStackTraceElement.getMethodName())) || ((!zzKI.equalsIgnoreCase(str3)) && (!zzKJ.equalsIgnoreCase(str3)) && (!zzKK.equalsIgnoreCase(str3)) && (!zzKL.equalsIgnoreCase(str3)) && (!zzKM.equalsIgnoreCase(str3)) && (!zzKN.equalsIgnoreCase(str3)))) {}
    }
    label166:
    for (String str1 = paramArrayOfStackTraceElement[(i + 1)].getClassName();; str1 = null)
    {
      if (paramString != null)
      {
        String str2 = zzb(paramString, ".", 3);
        if ((str1 != null) && (!str1.contains(str2)))
        {
          return str1;
          i++;
          break;
        }
      }
      return null;
    }
  }
  
  JSONArray zza(Object[] paramArrayOfObject)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    int i = paramArrayOfObject.length;
    for (int j = 0; j < i; j++) {
      zza(localJSONArray, paramArrayOfObject[j]);
    }
    return localJSONArray;
  }
  
  public void zza(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    Window localWindow = paramActivity.getWindow();
    if ((localWindow != null) && (localWindow.getDecorView() != null) && (localWindow.getDecorView().getViewTreeObserver() != null)) {
      localWindow.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(paramOnGlobalLayoutListener);
    }
  }
  
  public void zza(Activity paramActivity, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    Window localWindow = paramActivity.getWindow();
    if ((localWindow != null) && (localWindow.getDecorView() != null) && (localWindow.getDecorView().getViewTreeObserver() != null)) {
      localWindow.getDecorView().getViewTreeObserver().addOnScrollChangedListener(paramOnScrollChangedListener);
    }
  }
  
  public void zza(Context paramContext, String paramString, WebSettings paramWebSettings)
  {
    paramWebSettings.setUserAgentString(zzd(paramContext, paramString));
  }
  
  public void zza(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Context localContext = paramContext.getApplicationContext();
      if (localContext == null) {
        localContext = paramContext;
      }
      paramBundle.putString("os", Build.VERSION.RELEASE);
      paramBundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
      paramBundle.putString("device", zzp.zzbx().zzhb());
      paramBundle.putString("appid", localContext.getPackageName());
      paramBundle.putString("eids", TextUtils.join(",", zzbz.zzdl()));
      if (paramString1 == null) {
        break label181;
      }
      paramBundle.putString("js", paramString1);
    }
    Uri.Builder localBuilder;
    for (;;)
    {
      localBuilder = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", paramString2);
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localBuilder.appendQueryParameter(str, paramBundle.getString(str));
      }
      label181:
      paramBundle.putString("gmscore_version", Integer.toString(GooglePlayServicesUtil.zzan(paramContext)));
    }
    zzp.zzbx().zzc(paramContext, paramString1, localBuilder.toString());
  }
  
  public void zza(Context paramContext, String paramString, List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      new zziw(paramContext, paramString, (String)localIterator.next()).zzgX();
    }
  }
  
  public void zza(Context paramContext, String paramString1, List<String> paramList, String paramString2)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      new zziw(paramContext, paramString1, (String)localIterator.next(), paramString2).zzgX();
    }
  }
  
  public void zza(Context paramContext, String paramString, boolean paramBoolean, HttpURLConnection paramHttpURLConnection)
  {
    zza(paramContext, paramString, paramBoolean, paramHttpURLConnection, false);
  }
  
  public void zza(Context paramContext, String paramString1, boolean paramBoolean, HttpURLConnection paramHttpURLConnection, String paramString2)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(paramBoolean);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestProperty("User-Agent", paramString2);
    paramHttpURLConnection.setUseCaches(false);
  }
  
  public void zza(Context paramContext, String paramString, boolean paramBoolean1, HttpURLConnection paramHttpURLConnection, boolean paramBoolean2)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(paramBoolean1);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestProperty("User-Agent", zzd(paramContext, paramString));
    paramHttpURLConnection.setUseCaches(paramBoolean2);
  }
  
  public boolean zza(Context paramContext, Bitmap paramBitmap, String paramString)
  {
    zzx.zzcy("saveImageToFile must not be called on the main UI thread.");
    try
    {
      FileOutputStream localFileOutputStream = paramContext.openFileOutput(paramString, 0);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
      localFileOutputStream.close();
      paramBitmap.recycle();
      return true;
    }
    catch (Exception localException)
    {
      zzb.zzb("Fail to save file", localException);
    }
    return false;
  }
  
  public boolean zza(PackageManager paramPackageManager, String paramString1, String paramString2)
  {
    return paramPackageManager.checkPermission(paramString2, paramString1) == 0;
  }
  
  public boolean zza(ClassLoader paramClassLoader, Class<?> paramClass, String paramString)
  {
    try
    {
      boolean bool = paramClass.isAssignableFrom(Class.forName(paramString, false, paramClassLoader));
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public int zzaA(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      zzb.zzaH("Could not parse value:" + localNumberFormatException);
    }
    return 0;
  }
  
  public boolean zzaB(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
  }
  
  public String zzaz(String paramString)
  {
    return Uri.parse(paramString).buildUpon().query(null).build().toString();
  }
  
  public void zzb(Activity paramActivity, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    Window localWindow = paramActivity.getWindow();
    if ((localWindow != null) && (localWindow.getDecorView() != null) && (localWindow.getDecorView().getViewTreeObserver() != null)) {
      localWindow.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(paramOnScrollChangedListener);
    }
  }
  
  public void zzb(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramIntent.addFlags(268435456);
      paramContext.startActivity(paramIntent);
    }
  }
  
  public void zzb(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    if (((Boolean)zzbz.zzws.get()).booleanValue()) {
      zza(paramContext, paramString1, paramString2, paramBundle, paramBoolean);
    }
  }
  
  public void zzc(Context paramContext, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString2);
    zza(paramContext, paramString1, localArrayList);
  }
  
  public String zzd(final Context paramContext, String paramString)
  {
    synchronized (this.zzpK)
    {
      if (this.zzKi != null)
      {
        String str3 = this.zzKi;
        return str3;
      }
    }
    try
    {
      this.zzKi = zzp.zzbz().getDefaultUserAgent(paramContext);
      if (TextUtils.isEmpty(this.zzKi)) {
        if (!zzl.zzcN().zzhr())
        {
          this.zzKi = null;
          zzKO.post(new Runnable()
          {
            public void run()
            {
              synchronized (zzip.zza(zzip.this))
              {
                zzip.zza(zzip.this, zzip.this.zzL(paramContext));
                zzip.zza(zzip.this).notifyAll();
                return;
              }
            }
          });
          for (;;)
          {
            String str2 = this.zzKi;
            if (str2 != null) {
              break;
            }
            try
            {
              this.zzpK.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              this.zzKi = zzgZ();
              zzb.zzaH("Interrupted, use default user agent: " + this.zzKi);
            }
          }
          localObject2 = finally;
          throw ((Throwable)localObject2);
        }
      }
      try
      {
        this.zzKi = zzL(paramContext);
        this.zzKi = (this.zzKi + " (Mobile; " + paramString + ")");
        String str1 = this.zzKi;
        return str1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          this.zzKi = zzgZ();
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;) {}
    }
  }
  
  public Bitmap zze(Context paramContext, String paramString)
  {
    zzx.zzcy("getBackgroundImage must not be called on the main UI thread.");
    try
    {
      FileInputStream localFileInputStream = paramContext.openFileInput(paramString);
      Bitmap localBitmap = BitmapFactory.decodeStream(localFileInputStream);
      localFileInputStream.close();
      return localBitmap;
    }
    catch (Exception localException)
    {
      zzb.e("Fail to get background image");
    }
    return null;
  }
  
  public Map<String, String> zze(Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = zzp.zzbz().zzf(paramUri).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramUri.getQueryParameter(str));
    }
    return localHashMap;
  }
  
  public void zzf(Context paramContext, String paramString)
  {
    zzx.zzcy("deleteFile must not be called on the main UI thread.");
    paramContext.deleteFile(paramString);
  }
  
  public int[] zzg(Activity paramActivity)
  {
    Window localWindow = paramActivity.getWindow();
    if (localWindow != null)
    {
      View localView = localWindow.findViewById(16908290);
      if (localView != null)
      {
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = localView.getWidth();
        arrayOfInt[1] = localView.getHeight();
        return arrayOfInt;
      }
    }
    return zzhc();
  }
  
  public boolean zzgY()
  {
    return this.zzKP;
  }
  
  String zzgZ()
  {
    StringBuffer localStringBuffer = new StringBuffer(256);
    localStringBuffer.append("Mozilla/5.0 (Linux; U; Android");
    if (Build.VERSION.RELEASE != null) {
      localStringBuffer.append(" ").append(Build.VERSION.RELEASE);
    }
    localStringBuffer.append("; ").append(Locale.getDefault());
    if (Build.DEVICE != null)
    {
      localStringBuffer.append("; ").append(Build.DEVICE);
      if (Build.DISPLAY != null) {
        localStringBuffer.append(" Build/").append(Build.DISPLAY);
      }
    }
    localStringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
    return localStringBuffer.toString();
  }
  
  public int[] zzh(Activity paramActivity)
  {
    int[] arrayOfInt1 = zzg(paramActivity);
    int[] arrayOfInt2 = new int[2];
    arrayOfInt2[0] = zzl.zzcN().zzc(paramActivity, arrayOfInt1[0]);
    arrayOfInt2[1] = zzl.zzcN().zzc(paramActivity, arrayOfInt1[1]);
    return arrayOfInt2;
  }
  
  public String zzha()
  {
    UUID localUUID = UUID.randomUUID();
    byte[] arrayOfByte1 = BigInteger.valueOf(localUUID.getLeastSignificantBits()).toByteArray();
    byte[] arrayOfByte2 = BigInteger.valueOf(localUUID.getMostSignificantBits()).toByteArray();
    Object localObject = new BigInteger(1, arrayOfByte1).toString();
    int i = 0;
    while (i < 2) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(arrayOfByte1);
        localMessageDigest.update(arrayOfByte2);
        byte[] arrayOfByte3 = new byte[8];
        System.arraycopy(localMessageDigest.digest(), 0, arrayOfByte3, 0, 8);
        String str = new BigInteger(1, arrayOfByte3).toString();
        localObject = str;
        i++;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
    }
    return (String)localObject;
  }
  
  public String zzhb()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    if (str2.startsWith(str1)) {
      return str2;
    }
    return str1 + " " + str2;
  }
  
  protected int[] zzhc()
  {
    return new int[] { 0, 0 };
  }
  
  public int[] zzi(Activity paramActivity)
  {
    Window localWindow = paramActivity.getWindow();
    if (localWindow != null)
    {
      View localView = localWindow.findViewById(16908290);
      if (localView != null)
      {
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = localView.getTop();
        arrayOfInt[1] = localView.getBottom();
        return arrayOfInt;
      }
    }
    return zzhc();
  }
  
  public int[] zzj(Activity paramActivity)
  {
    int[] arrayOfInt1 = zzi(paramActivity);
    int[] arrayOfInt2 = new int[2];
    arrayOfInt2[0] = zzl.zzcN().zzc(paramActivity, arrayOfInt1[0]);
    arrayOfInt2[1] = zzl.zzcN().zzc(paramActivity, arrayOfInt1[1]);
    return arrayOfInt2;
  }
  
  public Bitmap zzl(View paramView)
  {
    paramView.setDrawingCacheEnabled(true);
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getDrawingCache());
    paramView.setDrawingCacheEnabled(false);
    return localBitmap;
  }
  
  public JSONObject zzz(Map<String, ?> paramMap)
    throws JSONException
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        zza(localJSONObject, str, paramMap.get(str));
      }
      return localJSONObject;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new JSONException("Could not convert map to JSON: " + localClassCastException.getMessage());
    }
  }
  
  private final class zza
    extends BroadcastReceiver
  {
    private zza() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("android.intent.action.USER_PRESENT".equals(paramIntent.getAction())) {
        zzip.zza(zzip.this, true);
      }
      while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) {
        return;
      }
      zzip.zza(zzip.this, false);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */