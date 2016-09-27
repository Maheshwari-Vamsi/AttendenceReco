package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzha
public final class zzds
  implements zzdl
{
  private final zze zzzb;
  private final zzfm zzzc;
  private final zzdn zzze;
  
  public zzds(zzdn paramzzdn, zze paramzze, zzfm paramzzfm)
  {
    this.zzze = paramzzdn;
    this.zzzb = paramzze;
    this.zzzc = paramzzfm;
  }
  
  private static void zza(Context paramContext, Map<String, String> paramMap)
  {
    if (TextUtils.isEmpty((String)paramMap.get("u")))
    {
      zzb.zzaH("Destination url cannot be empty.");
      return;
    }
    Intent localIntent = new zzb().zzb(paramContext, paramMap);
    try
    {
      zzp.zzbx().zzb(paramContext, localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      zzb.zzaH(localActivityNotFoundException.getMessage());
    }
  }
  
  private static boolean zzc(Map<String, String> paramMap)
  {
    return "1".equals(paramMap.get("custom_close"));
  }
  
  private static int zzd(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("o");
    if (str != null)
    {
      if ("p".equalsIgnoreCase(str)) {
        return zzp.zzbz().zzhe();
      }
      if ("l".equalsIgnoreCase(str)) {
        return zzp.zzbz().zzhd();
      }
      if ("c".equalsIgnoreCase(str)) {
        return zzp.zzbz().zzhf();
      }
    }
    return -1;
  }
  
  private static void zze(zzjn paramzzjn, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("u");
    if (TextUtils.isEmpty(str))
    {
      zzb.zzaH("Destination url cannot be empty.");
      return;
    }
    new zza(paramzzjn, str).zzgX();
  }
  
  private void zzo(boolean paramBoolean)
  {
    if (this.zzzc != null) {
      this.zzzc.zzp(paramBoolean);
    }
  }
  
  public void zza(zzjn paramzzjn, Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("a");
    if (str1 == null) {
      zzb.zzaH("Action missing from an open GMSG.");
    }
    zzjo localzzjo;
    String str4;
    String str5;
    do
    {
      return;
      if ((this.zzzb != null) && (!this.zzzb.zzbg()))
      {
        this.zzzb.zzp((String)paramMap.get("u"));
        return;
      }
      localzzjo = paramzzjn.zzhC();
      if ("expand".equalsIgnoreCase(str1))
      {
        if (paramzzjn.zzhG())
        {
          zzb.zzaH("Cannot expand WebView that is already expanded.");
          return;
        }
        zzo(false);
        localzzjo.zza(zzc(paramMap), zzd(paramMap));
        return;
      }
      if ("webapp".equalsIgnoreCase(str1))
      {
        String str6 = (String)paramMap.get("u");
        zzo(false);
        if (str6 != null)
        {
          localzzjo.zza(zzc(paramMap), zzd(paramMap), str6);
          return;
        }
        localzzjo.zza(zzc(paramMap), zzd(paramMap), (String)paramMap.get("html"), (String)paramMap.get("baseurl"));
        return;
      }
      if (!"in_app_purchase".equalsIgnoreCase(str1)) {
        break;
      }
      str4 = (String)paramMap.get("product_id");
      str5 = (String)paramMap.get("report_urls");
    } while (this.zzze == null);
    if ((str5 != null) && (!str5.isEmpty()))
    {
      String[] arrayOfString = str5.split(" ");
      this.zzze.zza(str4, new ArrayList(Arrays.asList(arrayOfString)));
      return;
    }
    this.zzze.zza(str4, new ArrayList());
    return;
    if (("app".equalsIgnoreCase(str1)) && ("true".equalsIgnoreCase((String)paramMap.get("play_store"))))
    {
      zze(paramzzjn, paramMap);
      return;
    }
    if (("app".equalsIgnoreCase(str1)) && ("true".equalsIgnoreCase((String)paramMap.get("system_browser"))))
    {
      zza(paramzzjn.getContext(), paramMap);
      return;
    }
    zzo(true);
    paramzzjn.zzhE();
    String str2 = (String)paramMap.get("u");
    if (!TextUtils.isEmpty(str2)) {}
    for (String str3 = zzp.zzbx().zza(paramzzjn, str2);; str3 = str2)
    {
      localzzjo.zza(new AdLauncherIntentInfoParcel((String)paramMap.get("i"), str3, (String)paramMap.get("m"), (String)paramMap.get("p"), (String)paramMap.get("c"), (String)paramMap.get("f"), (String)paramMap.get("e")));
      return;
    }
  }
  
  public static class zza
    extends zzil
  {
    private final String zzF;
    private final zzjn zzps;
    private final String zzzf = "play.google.com";
    private final String zzzg = "market";
    private final int zzzh = 10;
    
    public zza(zzjn paramzzjn, String paramString)
    {
      this.zzps = paramzzjn;
      this.zzF = paramString;
    }
    
    public void onStop() {}
    
    public Intent zzY(String paramString)
    {
      Uri localUri = Uri.parse(paramString);
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      localIntent.setData(localUri);
      return localIntent;
    }
    
    /* Error */
    public void zzbp()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: getfield 31	com/google/android/gms/internal/zzds$zza:zzF	Ljava/lang/String;
      //   6: astore_2
      //   7: iload_1
      //   8: bipush 10
      //   10: if_icmpge +435 -> 445
      //   13: iload_1
      //   14: iconst_1
      //   15: iadd
      //   16: istore 5
      //   18: new 65	java/net/URL
      //   21: dup
      //   22: aload_2
      //   23: invokespecial 66	java/net/URL:<init>	(Ljava/lang/String;)V
      //   26: astore 6
      //   28: ldc 19
      //   30: aload 6
      //   32: invokevirtual 70	java/net/URL:getHost	()Ljava/lang/String;
      //   35: invokevirtual 76	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   38: istore 13
      //   40: iload 13
      //   42: ifeq +30 -> 72
      //   45: aload_2
      //   46: astore_3
      //   47: aload_0
      //   48: aload_3
      //   49: invokevirtual 78	com/google/android/gms/internal/zzds$zza:zzY	(Ljava/lang/String;)Landroid/content/Intent;
      //   52: astore 4
      //   54: invokestatic 84	com/google/android/gms/ads/internal/zzp:zzbx	()Lcom/google/android/gms/internal/zzip;
      //   57: aload_0
      //   58: getfield 29	com/google/android/gms/internal/zzds$zza:zzps	Lcom/google/android/gms/internal/zzjn;
      //   61: invokeinterface 90 1 0
      //   66: aload 4
      //   68: invokevirtual 96	com/google/android/gms/internal/zzip:zzb	(Landroid/content/Context;Landroid/content/Intent;)V
      //   71: return
      //   72: ldc 23
      //   74: aload 6
      //   76: invokevirtual 99	java/net/URL:getProtocol	()Ljava/lang/String;
      //   79: invokevirtual 76	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   82: ifeq +8 -> 90
      //   85: aload_2
      //   86: astore_3
      //   87: goto -40 -> 47
      //   90: aload 6
      //   92: invokevirtual 103	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   95: checkcast 105	java/net/HttpURLConnection
      //   98: astore 14
      //   100: invokestatic 84	com/google/android/gms/ads/internal/zzp:zzbx	()Lcom/google/android/gms/internal/zzip;
      //   103: aload_0
      //   104: getfield 29	com/google/android/gms/internal/zzds$zza:zzps	Lcom/google/android/gms/internal/zzjn;
      //   107: invokeinterface 90 1 0
      //   112: aload_0
      //   113: getfield 29	com/google/android/gms/internal/zzds$zza:zzps	Lcom/google/android/gms/internal/zzjn;
      //   116: invokeinterface 109 1 0
      //   121: getfield 114	com/google/android/gms/ads/internal/util/client/VersionInfoParcel:afmaVersion	Ljava/lang/String;
      //   124: iconst_0
      //   125: aload 14
      //   127: invokevirtual 118	com/google/android/gms/internal/zzip:zza	(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;)V
      //   130: aload 14
      //   132: invokevirtual 122	java/net/HttpURLConnection:getResponseCode	()I
      //   135: istore 16
      //   137: aload 14
      //   139: invokevirtual 126	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
      //   142: astore 17
      //   144: iload 16
      //   146: sipush 300
      //   149: if_icmplt +289 -> 438
      //   152: iload 16
      //   154: sipush 399
      //   157: if_icmpgt +281 -> 438
      //   160: aload 17
      //   162: ldc -128
      //   164: invokeinterface 134 2 0
      //   169: ifeq +68 -> 237
      //   172: aload 17
      //   174: ldc -128
      //   176: invokeinterface 138 2 0
      //   181: checkcast 140	java/util/List
      //   184: astore 23
      //   186: aload 23
      //   188: ifnull +250 -> 438
      //   191: aload 23
      //   193: invokeinterface 143 1 0
      //   198: ifle +240 -> 438
      //   201: aload 23
      //   203: iconst_0
      //   204: invokeinterface 146 2 0
      //   209: checkcast 72	java/lang/String
      //   212: astore 18
      //   214: aload 18
      //   216: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   219: ifeq +54 -> 273
      //   222: ldc -102
      //   224: invokestatic 159	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
      //   227: aload 14
      //   229: invokevirtual 162	java/net/HttpURLConnection:disconnect	()V
      //   232: aload_2
      //   233: astore_3
      //   234: goto -187 -> 47
      //   237: aload 17
      //   239: ldc -92
      //   241: invokeinterface 134 2 0
      //   246: istore 22
      //   248: aconst_null
      //   249: astore 23
      //   251: iload 22
      //   253: ifeq -67 -> 186
      //   256: aload 17
      //   258: ldc -92
      //   260: invokeinterface 138 2 0
      //   265: checkcast 140	java/util/List
      //   268: astore 23
      //   270: goto -84 -> 186
      //   273: aload 14
      //   275: invokevirtual 162	java/net/HttpURLConnection:disconnect	()V
      //   278: iload 5
      //   280: istore_1
      //   281: aload 18
      //   283: astore_2
      //   284: goto -277 -> 7
      //   287: astore 15
      //   289: aload 14
      //   291: invokevirtual 162	java/net/HttpURLConnection:disconnect	()V
      //   294: aload 15
      //   296: athrow
      //   297: astore 11
      //   299: aload 11
      //   301: astore 12
      //   303: aload_2
      //   304: astore_3
      //   305: new 166	java/lang/StringBuilder
      //   308: dup
      //   309: invokespecial 167	java/lang/StringBuilder:<init>	()V
      //   312: ldc -87
      //   314: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   317: aload_3
      //   318: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   321: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   324: aload 12
      //   326: invokestatic 180	com/google/android/gms/ads/internal/util/client/zzb:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   329: goto -282 -> 47
      //   332: astore 9
      //   334: aload 9
      //   336: astore 10
      //   338: aload_2
      //   339: astore_3
      //   340: new 166	java/lang/StringBuilder
      //   343: dup
      //   344: invokespecial 167	java/lang/StringBuilder:<init>	()V
      //   347: ldc -74
      //   349: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   352: aload_3
      //   353: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   356: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   359: aload 10
      //   361: invokestatic 180	com/google/android/gms/ads/internal/util/client/zzb:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   364: goto -317 -> 47
      //   367: astore 7
      //   369: aload 7
      //   371: astore 8
      //   373: aload_2
      //   374: astore_3
      //   375: new 166	java/lang/StringBuilder
      //   378: dup
      //   379: invokespecial 167	java/lang/StringBuilder:<init>	()V
      //   382: ldc -74
      //   384: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   387: aload_3
      //   388: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   391: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   394: aload 8
      //   396: invokestatic 180	com/google/android/gms/ads/internal/util/client/zzb:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   399: goto -352 -> 47
      //   402: astore 21
      //   404: aload 18
      //   406: astore_3
      //   407: aload 21
      //   409: astore 8
      //   411: goto -36 -> 375
      //   414: astore 20
      //   416: aload 18
      //   418: astore_3
      //   419: aload 20
      //   421: astore 10
      //   423: goto -83 -> 340
      //   426: astore 19
      //   428: aload 18
      //   430: astore_3
      //   431: aload 19
      //   433: astore 12
      //   435: goto -130 -> 305
      //   438: ldc -72
      //   440: astore 18
      //   442: goto -228 -> 214
      //   445: aload_2
      //   446: astore_3
      //   447: goto -400 -> 47
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	450	0	this	zza
      //   1	280	1	i	int
      //   6	440	2	localObject1	Object
      //   46	401	3	localObject2	Object
      //   52	15	4	localIntent	Intent
      //   16	263	5	j	int
      //   26	65	6	localURL	java.net.URL
      //   367	3	7	localRuntimeException1	RuntimeException
      //   371	39	8	localObject3	Object
      //   332	3	9	localIOException1	java.io.IOException
      //   336	86	10	localObject4	Object
      //   297	3	11	localIndexOutOfBoundsException1	IndexOutOfBoundsException
      //   301	133	12	localObject5	Object
      //   38	3	13	bool1	boolean
      //   98	192	14	localHttpURLConnection	java.net.HttpURLConnection
      //   287	8	15	localObject6	Object
      //   135	23	16	k	int
      //   142	115	17	localMap	Map
      //   212	229	18	str	String
      //   426	6	19	localIndexOutOfBoundsException2	IndexOutOfBoundsException
      //   414	6	20	localIOException2	java.io.IOException
      //   402	6	21	localRuntimeException2	RuntimeException
      //   246	6	22	bool2	boolean
      //   184	85	23	localList	List
      // Exception table:
      //   from	to	target	type
      //   100	144	287	finally
      //   160	186	287	finally
      //   191	214	287	finally
      //   214	227	287	finally
      //   237	248	287	finally
      //   256	270	287	finally
      //   18	40	297	java/lang/IndexOutOfBoundsException
      //   72	85	297	java/lang/IndexOutOfBoundsException
      //   90	100	297	java/lang/IndexOutOfBoundsException
      //   227	232	297	java/lang/IndexOutOfBoundsException
      //   289	297	297	java/lang/IndexOutOfBoundsException
      //   18	40	332	java/io/IOException
      //   72	85	332	java/io/IOException
      //   90	100	332	java/io/IOException
      //   227	232	332	java/io/IOException
      //   289	297	332	java/io/IOException
      //   18	40	367	java/lang/RuntimeException
      //   72	85	367	java/lang/RuntimeException
      //   90	100	367	java/lang/RuntimeException
      //   227	232	367	java/lang/RuntimeException
      //   289	297	367	java/lang/RuntimeException
      //   273	278	402	java/lang/RuntimeException
      //   273	278	414	java/io/IOException
      //   273	278	426	java/lang/IndexOutOfBoundsException
    }
  }
  
  public static class zzb
  {
    public Intent zza(Intent paramIntent, ResolveInfo paramResolveInfo)
    {
      Intent localIntent = new Intent(paramIntent);
      localIntent.setClassName(paramResolveInfo.activityInfo.packageName, paramResolveInfo.activityInfo.name);
      return localIntent;
    }
    
    public ResolveInfo zza(Context paramContext, Intent paramIntent)
    {
      return zza(paramContext, paramIntent, new ArrayList());
    }
    
    public ResolveInfo zza(Context paramContext, Intent paramIntent, ArrayList<ResolveInfo> paramArrayList)
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null) {
        return null;
      }
      List localList = localPackageManager.queryIntentActivities(paramIntent, 65536);
      ResolveInfo localResolveInfo1 = localPackageManager.resolveActivity(paramIntent, 65536);
      int i;
      if ((localList != null) && (localResolveInfo1 != null))
      {
        i = 0;
        if (i < localList.size())
        {
          ResolveInfo localResolveInfo3 = (ResolveInfo)localList.get(i);
          if ((localResolveInfo1 == null) || (!localResolveInfo1.activityInfo.name.equals(localResolveInfo3.activityInfo.name))) {}
        }
      }
      for (ResolveInfo localResolveInfo2 = localResolveInfo1;; localResolveInfo2 = null)
      {
        paramArrayList.addAll(localList);
        return localResolveInfo2;
        i++;
        break;
      }
    }
    
    public Intent zzb(Context paramContext, Map<String, String> paramMap)
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      String str = (String)paramMap.get("u");
      boolean bool1 = TextUtils.isEmpty(str);
      Intent localIntent1 = null;
      if (bool1) {
        return localIntent1;
      }
      Uri localUri1 = Uri.parse(str);
      boolean bool2 = Boolean.parseBoolean((String)paramMap.get("use_first_package"));
      boolean bool3 = Boolean.parseBoolean((String)paramMap.get("use_running_process"));
      Uri localUri2;
      if ("http".equalsIgnoreCase(localUri1.getScheme())) {
        localUri2 = localUri1.buildUpon().scheme("https").build();
      }
      for (;;)
      {
        ArrayList localArrayList = new ArrayList();
        Intent localIntent2 = zzd(localUri1);
        Intent localIntent3 = zzd(localUri2);
        ResolveInfo localResolveInfo1 = zza(paramContext, localIntent2, localArrayList);
        if (localResolveInfo1 != null)
        {
          return zza(localIntent2, localResolveInfo1);
          if ("https".equalsIgnoreCase(localUri1.getScheme())) {
            localUri2 = localUri1.buildUpon().scheme("http").build();
          }
        }
        else
        {
          if (localIntent3 != null)
          {
            ResolveInfo localResolveInfo3 = zza(paramContext, localIntent3);
            if (localResolveInfo3 != null)
            {
              localIntent1 = zza(localIntent2, localResolveInfo3);
              if (zza(paramContext, localIntent1) != null) {
                break;
              }
            }
          }
          if (localArrayList.size() == 0) {
            return localIntent2;
          }
          if ((bool3) && (localActivityManager != null))
          {
            List localList = localActivityManager.getRunningAppProcesses();
            if (localList != null)
            {
              Iterator localIterator1 = localArrayList.iterator();
              ResolveInfo localResolveInfo2;
              Iterator localIterator2;
              do
              {
                while (!localIterator2.hasNext())
                {
                  if (!localIterator1.hasNext()) {
                    break;
                  }
                  localResolveInfo2 = (ResolveInfo)localIterator1.next();
                  localIterator2 = localList.iterator();
                }
              } while (!((ActivityManager.RunningAppProcessInfo)localIterator2.next()).processName.equals(localResolveInfo2.activityInfo.packageName));
              return zza(localIntent2, localResolveInfo2);
            }
          }
          if (bool2) {
            return zza(localIntent2, (ResolveInfo)localArrayList.get(0));
          }
          return localIntent2;
        }
        localUri2 = null;
      }
    }
    
    public Intent zzd(Uri paramUri)
    {
      if (paramUri == null) {
        return null;
      }
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      localIntent.setData(paramUri);
      localIntent.setAction("android.intent.action.VIEW");
      return localIntent;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */