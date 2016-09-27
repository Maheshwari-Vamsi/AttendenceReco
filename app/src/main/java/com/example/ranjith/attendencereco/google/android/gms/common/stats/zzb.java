package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zznk;
import com.google.android.gms.internal.zzny;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class zzb
{
  private static final Object zzakg = new Object();
  private static Integer zzalE;
  private static zzb zzaly;
  private final List<String> zzalA;
  private final List<String> zzalB;
  private final List<String> zzalC;
  private zze zzalD;
  private zze zzalF;
  private final List<String> zzalz;
  
  private zzb()
  {
    if (getLogLevel() == zzd.LOG_LEVEL_OFF)
    {
      this.zzalz = Collections.EMPTY_LIST;
      this.zzalA = Collections.EMPTY_LIST;
      this.zzalB = Collections.EMPTY_LIST;
      this.zzalC = Collections.EMPTY_LIST;
      return;
    }
    String str1 = (String)zzc.zza.zzalJ.get();
    List localList1;
    String str2;
    List localList2;
    label84:
    String str3;
    List localList3;
    label111:
    String str4;
    if (str1 == null)
    {
      localList1 = Collections.EMPTY_LIST;
      this.zzalz = localList1;
      str2 = (String)zzc.zza.zzalK.get();
      if (str2 != null) {
        break label210;
      }
      localList2 = Collections.EMPTY_LIST;
      this.zzalA = localList2;
      str3 = (String)zzc.zza.zzalL.get();
      if (str3 != null) {
        break label224;
      }
      localList3 = Collections.EMPTY_LIST;
      this.zzalB = localList3;
      str4 = (String)zzc.zza.zzalM.get();
      if (str4 != null) {
        break label239;
      }
    }
    label210:
    label224:
    label239:
    for (List localList4 = Collections.EMPTY_LIST;; localList4 = Arrays.asList(str4.split(",")))
    {
      this.zzalC = localList4;
      this.zzalD = new zze(1024, ((Long)zzc.zza.zzalN.get()).longValue());
      this.zzalF = new zze(1024, ((Long)zzc.zza.zzalN.get()).longValue());
      return;
      localList1 = Arrays.asList(str1.split(","));
      break;
      localList2 = Arrays.asList(str2.split(","));
      break label84;
      localList3 = Arrays.asList(str3.split(","));
      break label111;
    }
  }
  
  private static int getLogLevel()
  {
    if (zzalE == null) {}
    for (;;)
    {
      try
      {
        if (!zznk.zzka()) {
          continue;
        }
        i = ((Integer)zzc.zza.zzalI.get()).intValue();
        zzalE = Integer.valueOf(i);
      }
      catch (SecurityException localSecurityException)
      {
        int i;
        zzalE = Integer.valueOf(zzd.LOG_LEVEL_OFF);
        continue;
      }
      return zzalE.intValue();
      i = zzd.LOG_LEVEL_OFF;
    }
  }
  
  private void zza(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    long l1 = System.currentTimeMillis();
    int i = getLogLevel() & zzd.zzalS;
    String str = null;
    if (i != 0)
    {
      str = null;
      if (paramInt != 13) {
        str = zzny.zzm(3, 5);
      }
    }
    long l2 = 0L;
    if ((getLogLevel() & zzd.zzalU) != 0) {
      l2 = Debug.getNativeHeapAllocatedSize();
    }
    if ((paramInt == 1) || (paramInt == 4) || (paramInt == 14)) {}
    for (ConnectionEvent localConnectionEvent = new ConnectionEvent(l1, paramInt, null, null, null, null, str, paramString1, SystemClock.elapsedRealtime(), l2);; localConnectionEvent = new ConnectionEvent(l1, paramInt, paramString2, paramString3, paramString4, paramString5, str, paramString1, SystemClock.elapsedRealtime(), l2))
    {
      paramContext.startService(new Intent().setComponent(zzd.zzalO).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", localConnectionEvent));
      return;
    }
  }
  
  private void zza(Context paramContext, String paramString1, String paramString2, Intent paramIntent, int paramInt)
  {
    String str1 = null;
    if ((!zzrA()) || (this.zzalD == null)) {}
    do
    {
      return;
      if ((paramInt != 4) && (paramInt != 1)) {
        break;
      }
    } while (!this.zzalD.zzcN(paramString1));
    String str2 = null;
    String str3 = null;
    for (;;)
    {
      zza(paramContext, paramString1, paramInt, str1, paramString2, str3, str2);
      return;
      ServiceInfo localServiceInfo = zzd(paramContext, paramIntent);
      if (localServiceInfo == null)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramString2;
        arrayOfObject[1] = paramIntent.toUri(0);
        Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", arrayOfObject));
        return;
      }
      str3 = localServiceInfo.processName;
      str2 = localServiceInfo.name;
      str1 = zzny.zzay(paramContext);
      if (!zzb(str1, paramString2, str3, str2)) {
        break;
      }
      this.zzalD.zzcM(paramString1);
    }
  }
  
  private String zzb(ServiceConnection paramServiceConnection)
  {
    return String.valueOf(Process.myPid() << 32 | System.identityHashCode(paramServiceConnection));
  }
  
  private boolean zzb(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i = getLogLevel();
    return (!this.zzalz.contains(paramString1)) && (!this.zzalA.contains(paramString2)) && (!this.zzalB.contains(paramString3)) && (!this.zzalC.contains(paramString4)) && ((!paramString3.equals(paramString1)) || ((i & zzd.zzalT) == 0));
  }
  
  private boolean zzc(Context paramContext, Intent paramIntent)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    if ((localComponentName == null) || ((com.google.android.gms.common.internal.zzd.zzaiU) && ("com.google.android.gms".equals(localComponentName.getPackageName())))) {
      return false;
    }
    return zznk.zzj(paramContext, localComponentName.getPackageName());
  }
  
  private static ServiceInfo zzd(Context paramContext, Intent paramIntent)
  {
    List localList = paramContext.getPackageManager().queryIntentServices(paramIntent, 128);
    if ((localList == null) || (localList.size() == 0))
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = paramIntent.toUri(0);
      arrayOfObject1[1] = zzny.zzm(3, 20);
      Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", arrayOfObject1));
      return null;
    }
    if (localList.size() > 1)
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramIntent.toUri(0);
      arrayOfObject2[1] = zzny.zzm(3, 20);
      Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", arrayOfObject2));
      Iterator localIterator = localList.iterator();
      if (localIterator.hasNext())
      {
        Log.w("ConnectionTracker", ((ResolveInfo)localIterator.next()).serviceInfo.name);
        return null;
      }
    }
    return ((ResolveInfo)localList.get(0)).serviceInfo;
  }
  
  private boolean zzrA()
  {
    if (!com.google.android.gms.common.internal.zzd.zzaiU) {}
    while (getLogLevel() == zzd.LOG_LEVEL_OFF) {
      return false;
    }
    return true;
  }
  
  public static zzb zzrz()
  {
    synchronized (zzakg)
    {
      if (zzaly == null) {
        zzaly = new zzb();
      }
      return zzaly;
    }
  }
  
  public void zza(Context paramContext, ServiceConnection paramServiceConnection)
  {
    paramContext.unbindService(paramServiceConnection);
    zza(paramContext, zzb(paramServiceConnection), null, null, 1);
  }
  
  public void zza(Context paramContext, ServiceConnection paramServiceConnection, String paramString, Intent paramIntent)
  {
    zza(paramContext, zzb(paramServiceConnection), paramString, paramIntent, 3);
  }
  
  public boolean zza(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return zza(paramContext, paramContext.getClass().getName(), paramIntent, paramServiceConnection, paramInt);
  }
  
  public boolean zza(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (zzc(paramContext, paramIntent))
    {
      Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
      return false;
    }
    boolean bool = paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
    if (bool) {
      zza(paramContext, zzb(paramServiceConnection), paramString, paramIntent, 2);
    }
    return bool;
  }
  
  public void zzb(Context paramContext, ServiceConnection paramServiceConnection)
  {
    zza(paramContext, zzb(paramServiceConnection), null, null, 4);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\stats\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */