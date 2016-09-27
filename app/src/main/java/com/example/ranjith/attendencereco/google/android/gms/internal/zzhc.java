package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzj.zza;
import com.google.android.gms.ads.internal.request.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

@zzha
public final class zzhc
  extends zzj.zza
{
  private static zzhc zzHF;
  private static final Object zzqf = new Object();
  private final Context mContext;
  private final zzhb zzHG;
  private final zzbs zzHH;
  private final zzei zzrO;
  
  zzhc(Context paramContext, zzbs paramzzbs, zzhb paramzzhb)
  {
    this.mContext = paramContext;
    this.zzHG = paramzzhb;
    this.zzHH = paramzzbs;
    if (paramContext.getApplicationContext() != null) {}
    for (Context localContext = paramContext.getApplicationContext();; localContext = paramContext)
    {
      this.zzrO = new zzei(localContext, new VersionInfoParcel(8298000, 8298000, true), paramzzbs.zzdj(), new zzei.zzb()new zzei.zzc
      {
        public void zza(zzbb paramAnonymouszzbb)
        {
          paramAnonymouszzbb.zza("/log", zzdk.zzyG);
        }
      }, new zzei.zzc());
      return;
    }
  }
  
  /* Error */
  private static AdResponseParcel zza(final Context paramContext, zzei paramzzei, final zzbs paramzzbs, zzhb paramzzhb, final AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    // Byte code:
    //   0: ldc 81
    //   2: invokestatic 87	com/google/android/gms/ads/internal/util/client/zzb:zzaF	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: invokestatic 93	com/google/android/gms/internal/zzbz:initialize	(Landroid/content/Context;)V
    //   9: new 95	com/google/android/gms/internal/zzch
    //   12: dup
    //   13: getstatic 99	com/google/android/gms/internal/zzbz:zzvL	Lcom/google/android/gms/internal/zzbv;
    //   16: invokevirtual 105	com/google/android/gms/internal/zzbv:get	()Ljava/lang/Object;
    //   19: checkcast 107	java/lang/Boolean
    //   22: invokevirtual 111	java/lang/Boolean:booleanValue	()Z
    //   25: ldc 113
    //   27: aload 4
    //   29: getfield 119	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqV	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   32: getfield 125	com/google/android/gms/ads/internal/client/AdSizeParcel:zztV	Ljava/lang/String;
    //   35: invokespecial 128	com/google/android/gms/internal/zzch:<init>	(ZLjava/lang/String;Ljava/lang/String;)V
    //   38: astore 5
    //   40: aload 4
    //   42: getfield 132	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   45: bipush 10
    //   47: if_icmple +40 -> 87
    //   50: aload 4
    //   52: getfield 136	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGI	J
    //   55: ldc2_w 137
    //   58: lcmp
    //   59: ifeq +28 -> 87
    //   62: aload 5
    //   64: aload 5
    //   66: aload 4
    //   68: getfield 136	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGI	J
    //   71: invokevirtual 142	com/google/android/gms/internal/zzch:zzb	(J)Lcom/google/android/gms/internal/zzcf;
    //   74: iconst_1
    //   75: anewarray 144	java/lang/String
    //   78: dup
    //   79: iconst_0
    //   80: ldc -110
    //   82: aastore
    //   83: invokevirtual 149	com/google/android/gms/internal/zzch:zza	(Lcom/google/android/gms/internal/zzcf;[Ljava/lang/String;)Z
    //   86: pop
    //   87: aload 5
    //   89: invokevirtual 153	com/google/android/gms/internal/zzch:zzdu	()Lcom/google/android/gms/internal/zzcf;
    //   92: astore 6
    //   94: aload 4
    //   96: getfield 132	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   99: iconst_4
    //   100: if_icmplt +928 -> 1028
    //   103: aload 4
    //   105: getfield 157	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGx	Landroid/os/Bundle;
    //   108: ifnull +920 -> 1028
    //   111: aload 4
    //   113: getfield 157	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGx	Landroid/os/Bundle;
    //   116: astore 7
    //   118: getstatic 160	com/google/android/gms/internal/zzbz:zzvU	Lcom/google/android/gms/internal/zzbv;
    //   121: invokevirtual 105	com/google/android/gms/internal/zzbv:get	()Ljava/lang/Object;
    //   124: checkcast 107	java/lang/Boolean
    //   127: invokevirtual 111	java/lang/Boolean:booleanValue	()Z
    //   130: ifeq +888 -> 1018
    //   133: aload_3
    //   134: getfield 166	com/google/android/gms/internal/zzhb:zzHE	Lcom/google/android/gms/internal/zzhg;
    //   137: ifnull +881 -> 1018
    //   140: aload 7
    //   142: ifnonnull +32 -> 174
    //   145: getstatic 169	com/google/android/gms/internal/zzbz:zzvV	Lcom/google/android/gms/internal/zzbv;
    //   148: invokevirtual 105	com/google/android/gms/internal/zzbv:get	()Ljava/lang/Object;
    //   151: checkcast 107	java/lang/Boolean
    //   154: invokevirtual 111	java/lang/Boolean:booleanValue	()Z
    //   157: ifeq +17 -> 174
    //   160: ldc -85
    //   162: invokestatic 174	com/google/android/gms/ads/internal/util/client/zzb:v	(Ljava/lang/String;)V
    //   165: new 176	android/os/Bundle
    //   168: dup
    //   169: invokespecial 177	android/os/Bundle:<init>	()V
    //   172: astore 7
    //   174: aload 7
    //   176: ifnull +832 -> 1008
    //   179: new 179	com/google/android/gms/internal/zzhc$1
    //   182: dup
    //   183: aload_3
    //   184: aload_0
    //   185: aload 4
    //   187: aload 7
    //   189: invokespecial 182	com/google/android/gms/internal/zzhc$1:<init>	(Lcom/google/android/gms/internal/zzhb;Landroid/content/Context;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Landroid/os/Bundle;)V
    //   192: invokestatic 187	com/google/android/gms/internal/zzio:zza	(Ljava/util/concurrent/Callable;)Lcom/google/android/gms/internal/zzje;
    //   195: astore 50
    //   197: aload 7
    //   199: astore 8
    //   201: aload 50
    //   203: astore 9
    //   205: aload_3
    //   206: getfield 191	com/google/android/gms/internal/zzhb:zzHz	Lcom/google/android/gms/internal/zzej;
    //   209: invokeinterface 196 1 0
    //   214: invokestatic 202	com/google/android/gms/ads/internal/zzp:zzbD	()Lcom/google/android/gms/internal/zzhj;
    //   217: aload_0
    //   218: invokevirtual 208	com/google/android/gms/internal/zzhj:zzE	(Landroid/content/Context;)Lcom/google/android/gms/internal/zzhi;
    //   221: astore 10
    //   223: aload 10
    //   225: getfield 213	com/google/android/gms/internal/zzhi:zzIM	I
    //   228: iconst_m1
    //   229: if_icmpne +17 -> 246
    //   232: ldc -41
    //   234: invokestatic 87	com/google/android/gms/ads/internal/util/client/zzb:zzaF	(Ljava/lang/String;)V
    //   237: new 217	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   240: dup
    //   241: iconst_2
    //   242: invokespecial 220	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   245: areturn
    //   246: aload 4
    //   248: getfield 132	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   251: bipush 7
    //   253: if_icmplt +73 -> 326
    //   256: aload 4
    //   258: getfield 223	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGF	Ljava/lang/String;
    //   261: astore 11
    //   263: aload 4
    //   265: getfield 227	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   268: getfield 232	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   271: astore 12
    //   273: new 234	com/google/android/gms/internal/zzhe
    //   276: dup
    //   277: aload 11
    //   279: aload 12
    //   281: invokespecial 237	com/google/android/gms/internal/zzhe:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: astore 13
    //   286: aload 4
    //   288: getfield 241	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGq	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   291: getfield 246	com/google/android/gms/ads/internal/client/AdRequestParcel:extras	Landroid/os/Bundle;
    //   294: ifnull +43 -> 337
    //   297: aload 4
    //   299: getfield 241	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGq	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   302: getfield 246	com/google/android/gms/ads/internal/client/AdRequestParcel:extras	Landroid/os/Bundle;
    //   305: ldc -8
    //   307: invokevirtual 252	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   310: astore 49
    //   312: aload 49
    //   314: ifnull +23 -> 337
    //   317: aload_0
    //   318: aload 4
    //   320: aload 49
    //   322: invokestatic 257	com/google/android/gms/internal/zzhd:zza	(Landroid/content/Context;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Ljava/lang/String;)Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   325: areturn
    //   326: invokestatic 263	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   329: invokevirtual 266	java/util/UUID:toString	()Ljava/lang/String;
    //   332: astore 11
    //   334: goto -71 -> 263
    //   337: aload_3
    //   338: getfield 191	com/google/android/gms/internal/zzhb:zzHz	Lcom/google/android/gms/internal/zzej;
    //   341: ldc2_w 267
    //   344: invokeinterface 272 3 0
    //   349: astore 14
    //   351: aload_3
    //   352: getfield 276	com/google/android/gms/internal/zzhb:zzHA	Lcom/google/android/gms/internal/zzfx;
    //   355: aload_0
    //   356: aload 4
    //   358: getfield 279	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqP	Ljava/lang/String;
    //   361: aload 4
    //   363: getfield 283	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGr	Landroid/content/pm/PackageInfo;
    //   366: getfield 286	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   369: invokeinterface 292 4 0
    //   374: astore 15
    //   376: aload_3
    //   377: getfield 296	com/google/android/gms/internal/zzhb:zzHx	Lcom/google/android/gms/internal/zzbu;
    //   380: aload 4
    //   382: invokeinterface 301 2 0
    //   387: astore 16
    //   389: aload_3
    //   390: getfield 305	com/google/android/gms/internal/zzhb:zzHB	Lcom/google/android/gms/internal/zzid;
    //   393: aload 4
    //   395: invokeinterface 311 2 0
    //   400: astore 17
    //   402: aload_3
    //   403: getfield 315	com/google/android/gms/internal/zzhb:zzHC	Lcom/google/android/gms/internal/zzhm;
    //   406: aload_0
    //   407: invokeinterface 321 2 0
    //   412: astore 18
    //   414: aload 9
    //   416: ifnull +38 -> 454
    //   419: ldc_w 323
    //   422: invokestatic 174	com/google/android/gms/ads/internal/util/client/zzb:v	(Ljava/lang/String;)V
    //   425: aload 9
    //   427: getstatic 326	com/google/android/gms/internal/zzbz:zzvW	Lcom/google/android/gms/internal/zzbv;
    //   430: invokevirtual 105	com/google/android/gms/internal/zzbv:get	()Ljava/lang/Object;
    //   433: checkcast 328	java/lang/Long
    //   436: invokevirtual 332	java/lang/Long:longValue	()J
    //   439: getstatic 338	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   442: invokeinterface 343 4 0
    //   447: pop
    //   448: ldc_w 345
    //   451: invokestatic 174	com/google/android/gms/ads/internal/util/client/zzb:v	(Ljava/lang/String;)V
    //   454: aload_0
    //   455: aload 4
    //   457: aload 10
    //   459: aload 18
    //   461: aload 14
    //   463: aload_2
    //   464: aload 15
    //   466: aload 17
    //   468: aload 16
    //   470: aload 8
    //   472: invokestatic 348	com/google/android/gms/internal/zzhd:zza	(Landroid/content/Context;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Lcom/google/android/gms/internal/zzhi;Lcom/google/android/gms/internal/zzhm$zza;Landroid/location/Location;Lcom/google/android/gms/internal/zzbs;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Landroid/os/Bundle;)Lorg/json/JSONObject;
    //   475: astore 19
    //   477: aload 4
    //   479: getfield 132	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   482: bipush 7
    //   484: if_icmpge +14 -> 498
    //   487: aload 19
    //   489: ldc_w 350
    //   492: aload 11
    //   494: invokevirtual 356	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   497: pop
    //   498: aload 19
    //   500: ifnonnull +36 -> 536
    //   503: new 217	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   506: dup
    //   507: iconst_0
    //   508: invokespecial 220	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   511: areturn
    //   512: astore 46
    //   514: ldc_w 358
    //   517: aload 46
    //   519: invokestatic 361	com/google/android/gms/ads/internal/util/client/zzb:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   522: goto -68 -> 454
    //   525: astore 47
    //   527: ldc_w 363
    //   530: invokestatic 87	com/google/android/gms/ads/internal/util/client/zzb:zzaF	(Ljava/lang/String;)V
    //   533: goto -79 -> 454
    //   536: aload 19
    //   538: invokevirtual 364	org/json/JSONObject:toString	()Ljava/lang/String;
    //   541: astore 20
    //   543: aload 5
    //   545: aload 6
    //   547: iconst_1
    //   548: anewarray 144	java/lang/String
    //   551: dup
    //   552: iconst_0
    //   553: ldc_w 366
    //   556: aastore
    //   557: invokevirtual 149	com/google/android/gms/internal/zzch:zza	(Lcom/google/android/gms/internal/zzcf;[Ljava/lang/String;)Z
    //   560: pop
    //   561: aload 5
    //   563: invokevirtual 153	com/google/android/gms/internal/zzch:zzdu	()Lcom/google/android/gms/internal/zzcf;
    //   566: astore 22
    //   568: getstatic 369	com/google/android/gms/internal/zzbz:zzvh	Lcom/google/android/gms/internal/zzbv;
    //   571: invokevirtual 105	com/google/android/gms/internal/zzbv:get	()Ljava/lang/Object;
    //   574: checkcast 107	java/lang/Boolean
    //   577: invokevirtual 111	java/lang/Boolean:booleanValue	()Z
    //   580: ifeq +85 -> 665
    //   583: getstatic 375	com/google/android/gms/internal/zzip:zzKO	Landroid/os/Handler;
    //   586: new 377	com/google/android/gms/internal/zzhc$2
    //   589: dup
    //   590: aload_1
    //   591: aload 13
    //   593: aload 5
    //   595: aload 22
    //   597: aload 20
    //   599: invokespecial 380	com/google/android/gms/internal/zzhc$2:<init>	(Lcom/google/android/gms/internal/zzei;Lcom/google/android/gms/internal/zzhe;Lcom/google/android/gms/internal/zzch;Lcom/google/android/gms/internal/zzcf;Ljava/lang/String;)V
    //   602: invokevirtual 386	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   605: pop
    //   606: aload 13
    //   608: invokevirtual 390	com/google/android/gms/internal/zzhe:zzgp	()Ljava/util/concurrent/Future;
    //   611: ldc2_w 391
    //   614: getstatic 395	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   617: invokeinterface 343 4 0
    //   622: checkcast 397	com/google/android/gms/internal/zzhh
    //   625: astore 29
    //   627: aload 29
    //   629: ifnonnull +100 -> 729
    //   632: new 217	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   635: dup
    //   636: iconst_0
    //   637: invokespecial 220	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   640: astore 41
    //   642: getstatic 375	com/google/android/gms/internal/zzip:zzKO	Landroid/os/Handler;
    //   645: new 399	com/google/android/gms/internal/zzhc$4
    //   648: dup
    //   649: aload_3
    //   650: aload_0
    //   651: aload 13
    //   653: aload 4
    //   655: invokespecial 402	com/google/android/gms/internal/zzhc$4:<init>	(Lcom/google/android/gms/internal/zzhb;Landroid/content/Context;Lcom/google/android/gms/internal/zzhe;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)V
    //   658: invokevirtual 386	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   661: pop
    //   662: aload 41
    //   664: areturn
    //   665: getstatic 375	com/google/android/gms/internal/zzip:zzKO	Landroid/os/Handler;
    //   668: new 404	com/google/android/gms/internal/zzhc$3
    //   671: dup
    //   672: aload_0
    //   673: aload 4
    //   675: aload 13
    //   677: aload 5
    //   679: aload 22
    //   681: aload 20
    //   683: aload_2
    //   684: invokespecial 407	com/google/android/gms/internal/zzhc$3:<init>	(Landroid/content/Context;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Lcom/google/android/gms/internal/zzhe;Lcom/google/android/gms/internal/zzch;Lcom/google/android/gms/internal/zzcf;Ljava/lang/String;Lcom/google/android/gms/internal/zzbs;)V
    //   687: invokevirtual 386	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   690: pop
    //   691: goto -85 -> 606
    //   694: astore 26
    //   696: new 217	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   699: dup
    //   700: iconst_0
    //   701: invokespecial 220	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   704: astore 27
    //   706: getstatic 375	com/google/android/gms/internal/zzip:zzKO	Landroid/os/Handler;
    //   709: new 399	com/google/android/gms/internal/zzhc$4
    //   712: dup
    //   713: aload_3
    //   714: aload_0
    //   715: aload 13
    //   717: aload 4
    //   719: invokespecial 402	com/google/android/gms/internal/zzhc$4:<init>	(Lcom/google/android/gms/internal/zzhb;Landroid/content/Context;Lcom/google/android/gms/internal/zzhe;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)V
    //   722: invokevirtual 386	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   725: pop
    //   726: aload 27
    //   728: areturn
    //   729: aload 29
    //   731: invokevirtual 411	com/google/android/gms/internal/zzhh:getErrorCode	()I
    //   734: bipush -2
    //   736: if_icmpeq +40 -> 776
    //   739: new 217	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   742: dup
    //   743: aload 29
    //   745: invokevirtual 411	com/google/android/gms/internal/zzhh:getErrorCode	()I
    //   748: invokespecial 220	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   751: astore 30
    //   753: getstatic 375	com/google/android/gms/internal/zzip:zzKO	Landroid/os/Handler;
    //   756: new 399	com/google/android/gms/internal/zzhc$4
    //   759: dup
    //   760: aload_3
    //   761: aload_0
    //   762: aload 13
    //   764: aload 4
    //   766: invokespecial 402	com/google/android/gms/internal/zzhc$4:<init>	(Lcom/google/android/gms/internal/zzhb;Landroid/content/Context;Lcom/google/android/gms/internal/zzhe;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)V
    //   769: invokevirtual 386	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   772: pop
    //   773: aload 30
    //   775: areturn
    //   776: aload 5
    //   778: invokevirtual 414	com/google/android/gms/internal/zzch:zzdx	()Lcom/google/android/gms/internal/zzcf;
    //   781: ifnull +24 -> 805
    //   784: aload 5
    //   786: aload 5
    //   788: invokevirtual 414	com/google/android/gms/internal/zzch:zzdx	()Lcom/google/android/gms/internal/zzcf;
    //   791: iconst_1
    //   792: anewarray 144	java/lang/String
    //   795: dup
    //   796: iconst_0
    //   797: ldc_w 416
    //   800: aastore
    //   801: invokevirtual 149	com/google/android/gms/internal/zzch:zza	(Lcom/google/android/gms/internal/zzcf;[Ljava/lang/String;)Z
    //   804: pop
    //   805: aload 29
    //   807: invokevirtual 419	com/google/android/gms/internal/zzhh:zzgt	()Z
    //   810: istore 32
    //   812: aconst_null
    //   813: astore 33
    //   815: iload 32
    //   817: ifeq +22 -> 839
    //   820: aload_3
    //   821: getfield 423	com/google/android/gms/internal/zzhb:zzHw	Lcom/google/android/gms/internal/zzia;
    //   824: aload 4
    //   826: getfield 283	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGr	Landroid/content/pm/PackageInfo;
    //   829: getfield 286	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   832: invokeinterface 428 2 0
    //   837: astore 33
    //   839: aload 4
    //   841: getfield 432	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqR	Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;
    //   844: getfield 435	com/google/android/gms/ads/internal/util/client/VersionInfoParcel:afmaVersion	Ljava/lang/String;
    //   847: astore 34
    //   849: aload 29
    //   851: invokevirtual 438	com/google/android/gms/internal/zzhh:getUrl	()Ljava/lang/String;
    //   854: astore 35
    //   856: aload 29
    //   858: invokevirtual 441	com/google/android/gms/internal/zzhh:zzgu	()Z
    //   861: ifeq +106 -> 967
    //   864: aload 15
    //   866: astore 36
    //   868: aload 4
    //   870: aload_0
    //   871: aload 34
    //   873: aload 35
    //   875: aload 33
    //   877: aload 36
    //   879: aload 29
    //   881: aload 5
    //   883: aload_3
    //   884: invokestatic 444	com/google/android/gms/internal/zzhc:zza	(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/zzhh;Lcom/google/android/gms/internal/zzch;Lcom/google/android/gms/internal/zzhb;)Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   887: astore 37
    //   889: aload 37
    //   891: getfield 447	com/google/android/gms/ads/internal/request/AdResponseParcel:zzGZ	I
    //   894: iconst_1
    //   895: if_icmpne +21 -> 916
    //   898: aload_3
    //   899: getfield 276	com/google/android/gms/internal/zzhb:zzHA	Lcom/google/android/gms/internal/zzfx;
    //   902: aload_0
    //   903: aload 4
    //   905: getfield 283	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGr	Landroid/content/pm/PackageInfo;
    //   908: getfield 286	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   911: invokeinterface 451 3 0
    //   916: aload 5
    //   918: aload 6
    //   920: iconst_1
    //   921: anewarray 144	java/lang/String
    //   924: dup
    //   925: iconst_0
    //   926: ldc_w 453
    //   929: aastore
    //   930: invokevirtual 149	com/google/android/gms/internal/zzch:zza	(Lcom/google/android/gms/internal/zzcf;[Ljava/lang/String;)Z
    //   933: pop
    //   934: aload 37
    //   936: aload 5
    //   938: invokevirtual 456	com/google/android/gms/internal/zzch:zzdw	()Ljava/lang/String;
    //   941: putfield 459	com/google/android/gms/ads/internal/request/AdResponseParcel:zzHb	Ljava/lang/String;
    //   944: getstatic 375	com/google/android/gms/internal/zzip:zzKO	Landroid/os/Handler;
    //   947: new 399	com/google/android/gms/internal/zzhc$4
    //   950: dup
    //   951: aload_3
    //   952: aload_0
    //   953: aload 13
    //   955: aload 4
    //   957: invokespecial 402	com/google/android/gms/internal/zzhc$4:<init>	(Lcom/google/android/gms/internal/zzhb;Landroid/content/Context;Lcom/google/android/gms/internal/zzhe;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)V
    //   960: invokevirtual 386	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   963: pop
    //   964: aload 37
    //   966: areturn
    //   967: aconst_null
    //   968: astore 36
    //   970: goto -102 -> 868
    //   973: astore 24
    //   975: getstatic 375	com/google/android/gms/internal/zzip:zzKO	Landroid/os/Handler;
    //   978: new 399	com/google/android/gms/internal/zzhc$4
    //   981: dup
    //   982: aload_3
    //   983: aload_0
    //   984: aload 13
    //   986: aload 4
    //   988: invokespecial 402	com/google/android/gms/internal/zzhc$4:<init>	(Lcom/google/android/gms/internal/zzhb;Landroid/content/Context;Lcom/google/android/gms/internal/zzhe;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)V
    //   991: invokevirtual 386	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   994: pop
    //   995: aload 24
    //   997: athrow
    //   998: astore 44
    //   1000: goto -502 -> 498
    //   1003: astore 46
    //   1005: goto -491 -> 514
    //   1008: aload 7
    //   1010: astore 8
    //   1012: aconst_null
    //   1013: astore 9
    //   1015: goto -810 -> 205
    //   1018: aload 7
    //   1020: astore 8
    //   1022: aconst_null
    //   1023: astore 9
    //   1025: goto -820 -> 205
    //   1028: aconst_null
    //   1029: astore 7
    //   1031: goto -913 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1034	0	paramContext	Context
    //   0	1034	1	paramzzei	zzei
    //   0	1034	2	paramzzbs	zzbs
    //   0	1034	3	paramzzhb	zzhb
    //   0	1034	4	paramAdRequestInfoParcel	AdRequestInfoParcel
    //   38	899	5	localzzch	zzch
    //   92	827	6	localzzcf1	zzcf
    //   116	914	7	localBundle1	Bundle
    //   199	822	8	localBundle2	Bundle
    //   203	821	9	localzzje1	zzje
    //   221	237	10	localzzhi	zzhi
    //   261	232	11	str1	String
    //   271	9	12	str2	String
    //   284	701	13	localzzhe	zzhe
    //   349	113	14	localLocation	android.location.Location
    //   374	491	15	str3	String
    //   387	82	16	localList	List
    //   400	67	17	str4	String
    //   412	48	18	localzza	zzhm.zza
    //   475	62	19	localJSONObject	org.json.JSONObject
    //   541	141	20	str5	String
    //   566	114	22	localzzcf2	zzcf
    //   973	23	24	localObject	Object
    //   694	1	26	localException	Exception
    //   704	23	27	localAdResponseParcel1	AdResponseParcel
    //   625	255	29	localzzhh	zzhh
    //   751	23	30	localAdResponseParcel2	AdResponseParcel
    //   810	6	32	bool	boolean
    //   813	63	33	str6	String
    //   847	25	34	str7	String
    //   854	20	35	str8	String
    //   866	103	36	str9	String
    //   887	78	37	localAdResponseParcel3	AdResponseParcel
    //   640	23	41	localAdResponseParcel4	AdResponseParcel
    //   998	1	44	localJSONException	org.json.JSONException
    //   512	6	46	localInterruptedException	InterruptedException
    //   1003	1	46	localExecutionException	java.util.concurrent.ExecutionException
    //   525	1	47	localTimeoutException	java.util.concurrent.TimeoutException
    //   310	11	49	str10	String
    //   195	7	50	localzzje2	zzje
    // Exception table:
    //   from	to	target	type
    //   419	454	512	java/lang/InterruptedException
    //   419	454	525	java/util/concurrent/TimeoutException
    //   606	627	694	java/lang/Exception
    //   606	627	973	finally
    //   632	642	973	finally
    //   696	706	973	finally
    //   729	753	973	finally
    //   776	805	973	finally
    //   805	812	973	finally
    //   820	839	973	finally
    //   839	864	973	finally
    //   868	916	973	finally
    //   916	944	973	finally
    //   487	498	998	org/json/JSONException
    //   419	454	1003	java/util/concurrent/ExecutionException
  }
  
  /* Error */
  public static AdResponseParcel zza(AdRequestInfoParcel paramAdRequestInfoParcel, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, zzhh paramzzhh, zzch paramzzch, zzhb paramzzhb)
  {
    // Byte code:
    //   0: aload 7
    //   2: ifnull +370 -> 372
    //   5: aload 7
    //   7: invokevirtual 153	com/google/android/gms/internal/zzch:zzdu	()Lcom/google/android/gms/internal/zzcf;
    //   10: astore 9
    //   12: new 463	com/google/android/gms/internal/zzhf
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 466	com/google/android/gms/internal/zzhf:<init>	(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)V
    //   20: astore 10
    //   22: new 468	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 471
    //   32: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_3
    //   36: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 476	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 87	com/google/android/gms/ads/internal/util/client/zzb:zzaF	(Ljava/lang/String;)V
    //   45: new 478	java/net/URL
    //   48: dup
    //   49: aload_3
    //   50: invokespecial 480	java/net/URL:<init>	(Ljava/lang/String;)V
    //   53: astore 12
    //   55: invokestatic 484	com/google/android/gms/ads/internal/zzp:zzbB	()Lcom/google/android/gms/internal/zznl;
    //   58: invokeinterface 489 1 0
    //   63: lstore 13
    //   65: iconst_0
    //   66: istore 15
    //   68: aload 12
    //   70: astore 16
    //   72: aload 8
    //   74: ifnull +13 -> 87
    //   77: aload 8
    //   79: getfield 493	com/google/android/gms/internal/zzhb:zzHD	Lcom/google/android/gms/internal/zzhl;
    //   82: invokeinterface 498 1 0
    //   87: aload 16
    //   89: invokevirtual 502	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   92: checkcast 504	java/net/HttpURLConnection
    //   95: astore 17
    //   97: invokestatic 508	com/google/android/gms/ads/internal/zzp:zzbx	()Lcom/google/android/gms/internal/zzip;
    //   100: aload_1
    //   101: aload_2
    //   102: iconst_0
    //   103: aload 17
    //   105: invokevirtual 511	com/google/android/gms/internal/zzip:zza	(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;)V
    //   108: aload 4
    //   110: invokestatic 517	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifne +13 -> 126
    //   116: aload 17
    //   118: ldc_w 519
    //   121: aload 4
    //   123: invokevirtual 522	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload 5
    //   128: invokestatic 517	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +32 -> 163
    //   134: aload 17
    //   136: ldc_w 524
    //   139: new 468	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 526
    //   149: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload 5
    //   154: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 476	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokevirtual 522	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload 6
    //   165: ifnull +64 -> 229
    //   168: aload 6
    //   170: invokevirtual 529	com/google/android/gms/internal/zzhh:zzgs	()Ljava/lang/String;
    //   173: invokestatic 517	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne +53 -> 229
    //   179: aload 17
    //   181: iconst_1
    //   182: invokevirtual 533	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   185: aload 6
    //   187: invokevirtual 529	com/google/android/gms/internal/zzhh:zzgs	()Ljava/lang/String;
    //   190: invokevirtual 537	java/lang/String:getBytes	()[B
    //   193: astore 33
    //   195: aload 17
    //   197: aload 33
    //   199: arraylength
    //   200: invokevirtual 540	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   203: new 542	java/io/BufferedOutputStream
    //   206: dup
    //   207: aload 17
    //   209: invokevirtual 546	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   212: invokespecial 549	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   215: astore 34
    //   217: aload 34
    //   219: aload 33
    //   221: invokevirtual 553	java/io/BufferedOutputStream:write	([B)V
    //   224: aload 34
    //   226: invokestatic 558	com/google/android/gms/internal/zznt:zzb	(Ljava/io/Closeable;)V
    //   229: aload 17
    //   231: invokevirtual 561	java/net/HttpURLConnection:getResponseCode	()I
    //   234: istore 19
    //   236: aload 17
    //   238: invokevirtual 565	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   241: astore 20
    //   243: iload 19
    //   245: sipush 200
    //   248: if_icmplt +219 -> 467
    //   251: iload 19
    //   253: sipush 300
    //   256: if_icmpge +211 -> 467
    //   259: aload 16
    //   261: invokevirtual 566	java/net/URL:toString	()Ljava/lang/String;
    //   264: astore 27
    //   266: new 568	java/io/InputStreamReader
    //   269: dup
    //   270: aload 17
    //   272: invokevirtual 572	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   275: invokespecial 575	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   278: astore 28
    //   280: invokestatic 508	com/google/android/gms/ads/internal/zzp:zzbx	()Lcom/google/android/gms/internal/zzip;
    //   283: aload 28
    //   285: invokevirtual 578	com/google/android/gms/internal/zzip:zza	(Ljava/io/InputStreamReader;)Ljava/lang/String;
    //   288: astore 30
    //   290: aload 28
    //   292: invokestatic 558	com/google/android/gms/internal/zznt:zzb	(Ljava/io/Closeable;)V
    //   295: aload 27
    //   297: aload 20
    //   299: aload 30
    //   301: iload 19
    //   303: invokestatic 581	com/google/android/gms/internal/zzhc:zza	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
    //   306: aload 10
    //   308: aload 27
    //   310: aload 20
    //   312: aload 30
    //   314: invokevirtual 584	com/google/android/gms/internal/zzhf:zzb	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V
    //   317: aload 7
    //   319: ifnull +21 -> 340
    //   322: aload 7
    //   324: aload 9
    //   326: iconst_1
    //   327: anewarray 144	java/lang/String
    //   330: dup
    //   331: iconst_0
    //   332: ldc_w 586
    //   335: aastore
    //   336: invokevirtual 149	com/google/android/gms/internal/zzch:zza	(Lcom/google/android/gms/internal/zzcf;[Ljava/lang/String;)Z
    //   339: pop
    //   340: aload 10
    //   342: lload 13
    //   344: invokevirtual 590	com/google/android/gms/internal/zzhf:zzj	(J)Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   347: astore 32
    //   349: aload 17
    //   351: invokevirtual 593	java/net/HttpURLConnection:disconnect	()V
    //   354: aload 8
    //   356: ifnull +13 -> 369
    //   359: aload 8
    //   361: getfield 493	com/google/android/gms/internal/zzhb:zzHD	Lcom/google/android/gms/internal/zzhl;
    //   364: invokeinterface 596 1 0
    //   369: aload 32
    //   371: areturn
    //   372: aconst_null
    //   373: astore 9
    //   375: goto -363 -> 12
    //   378: astore 35
    //   380: aconst_null
    //   381: astore 34
    //   383: aload 34
    //   385: invokestatic 558	com/google/android/gms/internal/zznt:zzb	(Ljava/io/Closeable;)V
    //   388: aload 35
    //   390: athrow
    //   391: astore 18
    //   393: aload 17
    //   395: invokevirtual 593	java/net/HttpURLConnection:disconnect	()V
    //   398: aload 8
    //   400: ifnull +13 -> 413
    //   403: aload 8
    //   405: getfield 493	com/google/android/gms/internal/zzhb:zzHD	Lcom/google/android/gms/internal/zzhl;
    //   408: invokeinterface 596 1 0
    //   413: aload 18
    //   415: athrow
    //   416: astore 11
    //   418: new 468	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   425: ldc_w 598
    //   428: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload 11
    //   433: invokevirtual 601	java/io/IOException:getMessage	()Ljava/lang/String;
    //   436: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 476	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 604	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   445: new 217	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   448: dup
    //   449: iconst_2
    //   450: invokespecial 220	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   453: areturn
    //   454: astore 29
    //   456: aconst_null
    //   457: astore 28
    //   459: aload 28
    //   461: invokestatic 558	com/google/android/gms/internal/zznt:zzb	(Ljava/io/Closeable;)V
    //   464: aload 29
    //   466: athrow
    //   467: aload 16
    //   469: invokevirtual 566	java/net/URL:toString	()Ljava/lang/String;
    //   472: aload 20
    //   474: aconst_null
    //   475: iload 19
    //   477: invokestatic 581	com/google/android/gms/internal/zzhc:zza	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
    //   480: iload 19
    //   482: sipush 300
    //   485: if_icmplt +130 -> 615
    //   488: iload 19
    //   490: sipush 400
    //   493: if_icmpge +122 -> 615
    //   496: aload 17
    //   498: ldc_w 606
    //   501: invokevirtual 609	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   504: astore 22
    //   506: aload 22
    //   508: invokestatic 517	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   511: ifeq +42 -> 553
    //   514: ldc_w 611
    //   517: invokestatic 604	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   520: new 217	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   523: dup
    //   524: iconst_0
    //   525: invokespecial 220	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   528: astore 26
    //   530: aload 17
    //   532: invokevirtual 593	java/net/HttpURLConnection:disconnect	()V
    //   535: aload 8
    //   537: ifnull +13 -> 550
    //   540: aload 8
    //   542: getfield 493	com/google/android/gms/internal/zzhb:zzHD	Lcom/google/android/gms/internal/zzhl;
    //   545: invokeinterface 596 1 0
    //   550: aload 26
    //   552: areturn
    //   553: new 478	java/net/URL
    //   556: dup
    //   557: aload 22
    //   559: invokespecial 480	java/net/URL:<init>	(Ljava/lang/String;)V
    //   562: astore 23
    //   564: iload 15
    //   566: iconst_1
    //   567: iadd
    //   568: istore 24
    //   570: iload 24
    //   572: iconst_5
    //   573: if_icmple +99 -> 672
    //   576: ldc_w 613
    //   579: invokestatic 604	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   582: new 217	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   585: dup
    //   586: iconst_0
    //   587: invokespecial 220	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   590: astore 25
    //   592: aload 17
    //   594: invokevirtual 593	java/net/HttpURLConnection:disconnect	()V
    //   597: aload 8
    //   599: ifnull +13 -> 612
    //   602: aload 8
    //   604: getfield 493	com/google/android/gms/internal/zzhb:zzHD	Lcom/google/android/gms/internal/zzhl;
    //   607: invokeinterface 596 1 0
    //   612: aload 25
    //   614: areturn
    //   615: new 468	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   622: ldc_w 615
    //   625: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: iload 19
    //   630: invokevirtual 618	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   633: invokevirtual 476	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokestatic 604	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   639: new 217	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   642: dup
    //   643: iconst_0
    //   644: invokespecial 220	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   647: astore 21
    //   649: aload 17
    //   651: invokevirtual 593	java/net/HttpURLConnection:disconnect	()V
    //   654: aload 8
    //   656: ifnull +13 -> 669
    //   659: aload 8
    //   661: getfield 493	com/google/android/gms/internal/zzhb:zzHD	Lcom/google/android/gms/internal/zzhl;
    //   664: invokeinterface 596 1 0
    //   669: aload 21
    //   671: areturn
    //   672: aload 10
    //   674: aload 20
    //   676: invokevirtual 622	com/google/android/gms/internal/zzhf:zzh	(Ljava/util/Map;)V
    //   679: aload 17
    //   681: invokevirtual 593	java/net/HttpURLConnection:disconnect	()V
    //   684: aload 8
    //   686: ifnull +13 -> 699
    //   689: aload 8
    //   691: getfield 493	com/google/android/gms/internal/zzhb:zzHD	Lcom/google/android/gms/internal/zzhl;
    //   694: invokeinterface 596 1 0
    //   699: iload 24
    //   701: istore 15
    //   703: aload 23
    //   705: astore 16
    //   707: goto -635 -> 72
    //   710: astore 29
    //   712: goto -253 -> 459
    //   715: astore 35
    //   717: goto -334 -> 383
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	720	0	paramAdRequestInfoParcel	AdRequestInfoParcel
    //   0	720	1	paramContext	Context
    //   0	720	2	paramString1	String
    //   0	720	3	paramString2	String
    //   0	720	4	paramString3	String
    //   0	720	5	paramString4	String
    //   0	720	6	paramzzhh	zzhh
    //   0	720	7	paramzzch	zzch
    //   0	720	8	paramzzhb	zzhb
    //   10	364	9	localzzcf	zzcf
    //   20	653	10	localzzhf	zzhf
    //   416	16	11	localIOException	java.io.IOException
    //   53	16	12	localURL1	java.net.URL
    //   63	280	13	l	long
    //   66	636	15	i	int
    //   70	636	16	localObject1	Object
    //   95	585	17	localHttpURLConnection	java.net.HttpURLConnection
    //   391	23	18	localObject2	Object
    //   234	395	19	j	int
    //   241	434	20	localMap	Map
    //   647	23	21	localAdResponseParcel1	AdResponseParcel
    //   504	54	22	str1	String
    //   562	142	23	localURL2	java.net.URL
    //   568	132	24	k	int
    //   590	23	25	localAdResponseParcel2	AdResponseParcel
    //   528	23	26	localAdResponseParcel3	AdResponseParcel
    //   264	45	27	str2	String
    //   278	182	28	localInputStreamReader	java.io.InputStreamReader
    //   454	11	29	localObject3	Object
    //   710	1	29	localObject4	Object
    //   288	25	30	str3	String
    //   347	23	32	localAdResponseParcel4	AdResponseParcel
    //   193	27	33	arrayOfByte	byte[]
    //   215	169	34	localBufferedOutputStream	java.io.BufferedOutputStream
    //   378	11	35	localObject5	Object
    //   715	1	35	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   203	217	378	finally
    //   97	126	391	finally
    //   126	163	391	finally
    //   168	203	391	finally
    //   224	229	391	finally
    //   229	243	391	finally
    //   259	266	391	finally
    //   290	317	391	finally
    //   322	340	391	finally
    //   340	349	391	finally
    //   383	391	391	finally
    //   459	467	391	finally
    //   467	480	391	finally
    //   496	530	391	finally
    //   553	564	391	finally
    //   576	592	391	finally
    //   615	649	391	finally
    //   672	679	391	finally
    //   12	65	416	java/io/IOException
    //   77	87	416	java/io/IOException
    //   87	97	416	java/io/IOException
    //   349	354	416	java/io/IOException
    //   359	369	416	java/io/IOException
    //   393	398	416	java/io/IOException
    //   403	413	416	java/io/IOException
    //   413	416	416	java/io/IOException
    //   530	535	416	java/io/IOException
    //   540	550	416	java/io/IOException
    //   592	597	416	java/io/IOException
    //   602	612	416	java/io/IOException
    //   649	654	416	java/io/IOException
    //   659	669	416	java/io/IOException
    //   679	684	416	java/io/IOException
    //   689	699	416	java/io/IOException
    //   266	280	454	finally
    //   280	290	710	finally
    //   217	224	715	finally
  }
  
  public static zzhc zza(Context paramContext, zzbs paramzzbs, zzhb paramzzhb)
  {
    synchronized (zzqf)
    {
      if (zzHF == null)
      {
        if (paramContext.getApplicationContext() != null) {
          paramContext = paramContext.getApplicationContext();
        }
        zzHF = new zzhc(paramContext, paramzzbs, paramzzhb);
      }
      zzhc localzzhc = zzHF;
      return localzzhc;
    }
  }
  
  private static zzjo.zza zza(final String paramString, zzch paramzzch, final zzcf paramzzcf)
  {
    new zzjo.zza()
    {
      public void zza(zzjn paramAnonymouszzjn, boolean paramAnonymousBoolean)
      {
        this.zzpj.zza(paramzzcf, new String[] { "jsf" });
        this.zzpj.zzdv();
        paramAnonymouszzjn.zza("AFMA_buildAdURL", paramString);
      }
    };
  }
  
  private static void zza(String paramString1, Map<String, List<String>> paramMap, String paramString2, int paramInt)
  {
    if (zzb.zzQ(2))
    {
      zzb.v("Http Response: {\n  URL:\n    " + paramString1 + "\n  Headers:");
      if (paramMap != null)
      {
        Iterator localIterator1 = paramMap.keySet().iterator();
        while (localIterator1.hasNext())
        {
          String str1 = (String)localIterator1.next();
          zzb.v("    " + str1 + ":");
          Iterator localIterator2 = ((List)paramMap.get(str1)).iterator();
          while (localIterator2.hasNext())
          {
            String str2 = (String)localIterator2.next();
            zzb.v("      " + str2);
          }
        }
      }
      zzb.v("  Body:");
      if (paramString2 != null) {
        for (int i = 0; i < Math.min(paramString2.length(), 100000); i += 1000) {
          zzb.v(paramString2.substring(i, Math.min(paramString2.length(), i + 1000)));
        }
      }
      zzb.v("    null");
      zzb.v("  Response Code:\n    " + paramInt + "\n}");
    }
  }
  
  public void zza(final AdRequestInfoParcel paramAdRequestInfoParcel, final zzk paramzzk)
  {
    zzp.zzbA().zzb(this.mContext, paramAdRequestInfoParcel.zzqR);
    zzio.zza(new Runnable()
    {
      public void run()
      {
        try
        {
          AdResponseParcel localAdResponseParcel2 = zzhc.this.zzd(paramAdRequestInfoParcel);
          localAdResponseParcel1 = localAdResponseParcel2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            try
            {
              paramzzk.zzb(localAdResponseParcel1);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              AdResponseParcel localAdResponseParcel1;
              zzb.zzd("Fail to forward ad response.", localRemoteException);
            }
            localException = localException;
            zzp.zzbA().zzb(localException, true);
            zzb.zzd("Could not fetch ad response due to an Exception.", localException);
            localAdResponseParcel1 = null;
          }
        }
        if (localAdResponseParcel1 == null) {
          localAdResponseParcel1 = new AdResponseParcel(0);
        }
      }
    });
  }
  
  public AdResponseParcel zzd(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    return zza(this.mContext, this.zzrO, this.zzHH, this.zzHG, paramAdRequestInfoParcel);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzhc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */