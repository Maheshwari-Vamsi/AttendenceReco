package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;

@zzha
public class zzgz
  implements Thread.UncaughtExceptionHandler
{
  private Context mContext;
  private VersionInfoParcel zzDY;
  private Thread.UncaughtExceptionHandler zzGb;
  private Thread.UncaughtExceptionHandler zzGc;
  
  public zzgz(Context paramContext, VersionInfoParcel paramVersionInfoParcel, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler1, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler2)
  {
    this.zzGb = paramUncaughtExceptionHandler1;
    this.zzGc = paramUncaughtExceptionHandler2;
    this.mContext = paramContext;
    this.zzDY = paramVersionInfoParcel;
  }
  
  private static boolean zzA(Context paramContext)
  {
    return ((Boolean)zzbz.zzvl.get()).booleanValue();
  }
  
  public static zzgz zza(Context paramContext, Thread paramThread, VersionInfoParcel paramVersionInfoParcel)
  {
    if ((paramContext == null) || (paramThread == null) || (paramVersionInfoParcel == null)) {
      return null;
    }
    if (!zzA(paramContext)) {
      return null;
    }
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = paramThread.getUncaughtExceptionHandler();
    zzgz localzzgz = new zzgz(paramContext, paramVersionInfoParcel, localUncaughtExceptionHandler, Thread.getDefaultUncaughtExceptionHandler());
    if ((localUncaughtExceptionHandler == null) || (!(localUncaughtExceptionHandler instanceof zzgz))) {
      try
      {
        paramThread.setUncaughtExceptionHandler(localzzgz);
        return localzzgz;
      }
      catch (SecurityException localSecurityException)
      {
        zzb.zzc("Fail to set UncaughtExceptionHandler.", localSecurityException);
        return null;
      }
    }
    return (zzgz)localUncaughtExceptionHandler;
  }
  
  private Throwable zzb(Throwable paramThrowable)
  {
    if (((Boolean)zzbz.zzvm.get()).booleanValue()) {
      return paramThrowable;
    }
    LinkedList localLinkedList = new LinkedList();
    while (paramThrowable != null)
    {
      localLinkedList.push(paramThrowable);
      paramThrowable = paramThrowable.getCause();
    }
    Object localObject1 = null;
    Throwable localThrowable;
    Object localObject2;
    if (!localLinkedList.isEmpty())
    {
      localThrowable = (Throwable)localLinkedList.pop();
      StackTraceElement[] arrayOfStackTraceElement = localThrowable.getStackTrace();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new StackTraceElement(localThrowable.getClass().getName(), "<filtered>", "<filtered>", 1));
      int i = arrayOfStackTraceElement.length;
      int j = 0;
      int k = 0;
      if (j < i)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[j];
        if (zzas(localStackTraceElement.getClassName()))
        {
          localArrayList.add(localStackTraceElement);
          k = 1;
        }
        for (;;)
        {
          j++;
          break;
          if (zzat(localStackTraceElement.getClassName())) {
            localArrayList.add(localStackTraceElement);
          } else {
            localArrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
          }
        }
      }
      if (k == 0) {
        break label268;
      }
      if (localObject1 == null)
      {
        localObject2 = new Throwable(localThrowable.getMessage());
        label225:
        ((Throwable)localObject2).setStackTrace((StackTraceElement[])localArrayList.toArray(new StackTraceElement[0]));
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      break;
      localObject2 = new Throwable(localThrowable.getMessage(), (Throwable)localObject1);
      break label225;
      return (Throwable)localObject1;
      label268:
      localObject2 = localObject1;
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (zza(paramThrowable)) {
      if (Looper.getMainLooper().getThread() != paramThread) {
        zza(paramThrowable, true);
      }
    }
    do
    {
      return;
      zza(paramThrowable, false);
      if (this.zzGb != null)
      {
        this.zzGb.uncaughtException(paramThread, paramThrowable);
        return;
      }
    } while (this.zzGc == null);
    this.zzGc.uncaughtException(paramThread, paramThrowable);
  }
  
  String zza(Class paramClass, Throwable paramThrowable, boolean paramBoolean)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("device", zzp.zzbx().zzhb()).appendQueryParameter("js", this.zzDY.afmaVersion).appendQueryParameter("appid", this.mContext.getApplicationContext().getPackageName()).appendQueryParameter("exceptiontype", paramClass.getName()).appendQueryParameter("stacktrace", localStringWriter.toString()).appendQueryParameter("eids", TextUtils.join(",", zzbz.zzdl())).appendQueryParameter("trapped", String.valueOf(paramBoolean)).toString();
  }
  
  public void zza(Throwable paramThrowable, boolean paramBoolean)
  {
    if (!zzA(this.mContext)) {}
    Throwable localThrowable;
    do
    {
      return;
      localThrowable = zzb(paramThrowable);
    } while (localThrowable == null);
    Class localClass = paramThrowable.getClass();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(zza(localClass, localThrowable, paramBoolean));
    zzp.zzbx().zza(this.mContext, this.zzDY.afmaVersion, localArrayList, zzp.zzbA().zzgP());
  }
  
  protected boolean zza(Throwable paramThrowable)
  {
    boolean bool = true;
    if (paramThrowable == null) {
      return false;
    }
    int i = 0;
    int j = 0;
    while (paramThrowable != null)
    {
      for (StackTraceElement localStackTraceElement : paramThrowable.getStackTrace())
      {
        if (zzas(localStackTraceElement.getClassName())) {
          j = bool;
        }
        if (getClass().getName().equals(localStackTraceElement.getClassName())) {
          i = bool;
        }
      }
      paramThrowable = paramThrowable.getCause();
    }
    if ((j != 0) && (i == 0)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  protected boolean zzas(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramString.startsWith("com.google.android.gms.ads")) {
      return true;
    }
    if (paramString.startsWith("com.google.ads")) {
      return true;
    }
    try
    {
      boolean bool = Class.forName(paramString).isAnnotationPresent(zzha.class);
      return bool;
    }
    catch (Exception localException)
    {
      zzb.zza("Fail to check class type for class " + paramString, localException);
    }
    return false;
  }
  
  protected boolean zzat(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("android.")) && (!paramString.startsWith("java."))) {
      return false;
    }
    return true;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzgz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */