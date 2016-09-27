package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzbl
  extends Thread
{
  private boolean mStarted = false;
  private boolean zzam = false;
  private final Object zzpK;
  private final int zzsC;
  private final int zzsE;
  private boolean zzsO = false;
  private final zzbk zzsP;
  private final zzbj zzsQ;
  private final zzgz zzsR;
  private final int zzsS;
  private final int zzsT;
  private final int zzsU;
  
  public zzbl(zzbk paramzzbk, zzbj paramzzbj, zzgz paramzzgz)
  {
    this.zzsP = paramzzbk;
    this.zzsQ = paramzzbj;
    this.zzsR = paramzzgz;
    this.zzpK = new Object();
    this.zzsC = ((Integer)zzbz.zzvP.get()).intValue();
    this.zzsT = ((Integer)zzbz.zzvQ.get()).intValue();
    this.zzsE = ((Integer)zzbz.zzvR.get()).intValue();
    this.zzsU = ((Integer)zzbz.zzvS.get()).intValue();
    this.zzsS = ((Integer)zzbz.zzvT.get()).intValue();
    setName("ContentFetchTask");
  }
  
  public void run()
  {
    while (!this.zzam) {
      try
      {
        if (zzcC())
        {
          localActivity = this.zzsP.getActivity();
          if (localActivity == null) {
            zzb.zzaF("ContentFetchThread: no activity");
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Activity localActivity;
        zzb.zzb("Error in ContentFetchTask", localThrowable);
        this.zzsR.zza(localThrowable, true);
        synchronized (this.zzpK)
        {
          for (;;)
          {
            boolean bool = this.zzsO;
            if (!bool) {
              break;
            }
            try
            {
              zzb.zzaF("ContentFetchTask: waiting");
              this.zzpK.wait();
            }
            catch (InterruptedException localInterruptedException) {}
          }
          zza(localActivity);
          for (;;)
          {
            Thread.sleep(1000 * this.zzsS);
            break;
            zzb.zzaF("ContentFetchTask: sleeping");
            zzcE();
          }
        }
      }
    }
  }
  
  public void wakeup()
  {
    synchronized (this.zzpK)
    {
      this.zzsO = false;
      this.zzpK.notifyAll();
      zzb.zzaF("ContentFetchThread: wakeup");
      return;
    }
  }
  
  zza zza(View paramView, zzbi paramzzbi)
  {
    int i = 0;
    if (paramView == null) {
      return new zza(0, 0);
    }
    if (((paramView instanceof TextView)) && (!(paramView instanceof EditText)))
    {
      CharSequence localCharSequence = ((TextView)paramView).getText();
      if (!TextUtils.isEmpty(localCharSequence))
      {
        paramzzbi.zzw(localCharSequence.toString());
        return new zza(1, 0);
      }
      return new zza(0, 0);
    }
    if (((paramView instanceof WebView)) && (!(paramView instanceof zzjn)))
    {
      paramzzbi.zzcx();
      if (zza((WebView)paramView, paramzzbi)) {
        return new zza(0, 1);
      }
      return new zza(0, 0);
    }
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = 0;
      int k = 0;
      while (i < localViewGroup.getChildCount())
      {
        zza localzza = zza(localViewGroup.getChildAt(i), paramzzbi);
        k += localzza.zztb;
        j += localzza.zztc;
        i++;
      }
      return new zza(k, j);
    }
    return new zza(0, 0);
  }
  
  void zza(Activity paramActivity)
  {
    if (paramActivity == null) {}
    View localView1;
    do
    {
      return;
      Window localWindow = paramActivity.getWindow();
      localView1 = null;
      if (localWindow != null)
      {
        View localView2 = paramActivity.getWindow().getDecorView();
        localView1 = null;
        if (localView2 != null) {
          localView1 = paramActivity.getWindow().getDecorView().findViewById(16908290);
        }
      }
    } while (localView1 == null);
    zzf(localView1);
  }
  
  void zza(zzbi paramzzbi, WebView paramWebView, String paramString)
  {
    paramzzbi.zzcw();
    try
    {
      String str;
      if (!TextUtils.isEmpty(paramString))
      {
        str = new JSONObject(paramString).optString("text");
        if (TextUtils.isEmpty(paramWebView.getTitle())) {
          break label85;
        }
        paramzzbi.zzv(paramWebView.getTitle() + "\n" + str);
      }
      while (paramzzbi.zzct())
      {
        this.zzsQ.zzb(paramzzbi);
        return;
        label85:
        paramzzbi.zzv(str);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      zzb.zzaF("Json string may be malformed.");
      return;
    }
    catch (Throwable localThrowable)
    {
      zzb.zza("Failed to get webview content.", localThrowable);
      this.zzsR.zza(localThrowable, true);
    }
  }
  
  boolean zza(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo)
  {
    return paramRunningAppProcessInfo.importance == 100;
  }
  
  boolean zza(final WebView paramWebView, final zzbi paramzzbi)
  {
    if (!zznx.zzrU()) {
      return false;
    }
    paramzzbi.zzcx();
    paramWebView.post(new Runnable()
    {
      ValueCallback<String> zzsX = new ValueCallback()
      {
        public void zzy(String paramAnonymous2String)
        {
          zzbl.this.zza(zzbl.2.this.zzsY, zzbl.2.this.zzsZ, paramAnonymous2String);
        }
      };
      
      public void run()
      {
        if (paramWebView.getSettings().getJavaScriptEnabled()) {}
        try
        {
          paramWebView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzsX);
          return;
        }
        catch (Throwable localThrowable)
        {
          this.zzsX.onReceiveValue("");
        }
      }
    });
    return true;
  }
  
  public void zzcB()
  {
    synchronized (this.zzpK)
    {
      if (this.mStarted)
      {
        zzb.zzaF("Content hash thread already started, quiting...");
        return;
      }
      this.mStarted = true;
      start();
      return;
    }
  }
  
  boolean zzcC()
  {
    try
    {
      Context localContext = this.zzsP.getContext();
      if (localContext == null) {
        return false;
      }
      ActivityManager localActivityManager = (ActivityManager)localContext.getSystemService("activity");
      KeyguardManager localKeyguardManager = (KeyguardManager)localContext.getSystemService("keyguard");
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
            if ((zza(localRunningAppProcessInfo)) && (!localKeyguardManager.inKeyguardRestrictedInputMode()))
            {
              boolean bool = zzs(localContext);
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
  
  public zzbi zzcD()
  {
    return this.zzsQ.zzcA();
  }
  
  public void zzcE()
  {
    synchronized (this.zzpK)
    {
      this.zzsO = true;
      zzb.zzaF("ContentFetchThread: paused, mPause = " + this.zzsO);
      return;
    }
  }
  
  public boolean zzcF()
  {
    return this.zzsO;
  }
  
  boolean zzf(final View paramView)
  {
    if (paramView == null) {
      return false;
    }
    paramView.post(new Runnable()
    {
      public void run()
      {
        zzbl.this.zzg(paramView);
      }
    });
    return true;
  }
  
  void zzg(View paramView)
  {
    try
    {
      zzbi localzzbi = new zzbi(this.zzsC, this.zzsT, this.zzsE, this.zzsU);
      zza localzza = zza(paramView, localzzbi);
      localzzbi.zzcy();
      if ((localzza.zztb == 0) && (localzza.zztc == 0)) {
        return;
      }
      if (((localzza.zztc != 0) || (localzzbi.zzcz() != 0)) && ((localzza.zztc != 0) || (!this.zzsQ.zza(localzzbi))))
      {
        this.zzsQ.zzc(localzzbi);
        return;
      }
    }
    catch (Exception localException)
    {
      zzb.zzb("Exception in fetchContentOnUIThread", localException);
      this.zzsR.zza(localException, true);
    }
  }
  
  boolean zzs(Context paramContext)
  {
    PowerManager localPowerManager = (PowerManager)paramContext.getSystemService("power");
    if (localPowerManager == null) {
      return false;
    }
    return localPowerManager.isScreenOn();
  }
  
  @zzha
  class zza
  {
    final int zztb;
    final int zztc;
    
    zza(int paramInt1, int paramInt2)
    {
      this.zztb = paramInt1;
      this.zztc = paramInt2;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */