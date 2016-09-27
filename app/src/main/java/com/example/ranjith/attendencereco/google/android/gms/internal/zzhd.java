package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public final class zzhd
{
  private static final SimpleDateFormat zzHU = new SimpleDateFormat("yyyyMMdd", Locale.US);
  
  private static String zzL(int paramInt)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(0xFFFFFF & paramInt);
    return String.format(localLocale, "#%06x", arrayOfObject);
  }
  
  public static AdResponseParcel zza(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, String paramString)
  {
    JSONObject localJSONObject;
    String str1;
    String str3;
    boolean bool1;
    String str4;
    long l1;
    String str5;
    long l2;
    label100:
    int i;
    String str8;
    AdResponseParcel localAdResponseParcel3;
    label247:
    Object localObject1;
    label285:
    int n;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        str1 = localJSONObject.optString("ad_base_url", null);
        String str2 = localJSONObject.optString("ad_url", null);
        str3 = localJSONObject.optString("ad_size", null);
        if ((paramAdRequestInfoParcel == null) || (paramAdRequestInfoParcel.zzGw == 0)) {
          break label862;
        }
        bool1 = true;
        String str6;
        if (bool1)
        {
          str4 = localJSONObject.optString("ad_json", null);
          l1 = -1L;
          str5 = localJSONObject.optString("debug_dialog", null);
          if (!localJSONObject.has("interstitial_timeout")) {
            break label868;
          }
          l2 = (1000.0D * localJSONObject.getDouble("interstitial_timeout"));
          str6 = localJSONObject.optString("orientation", null);
          i = -1;
          if ("portrait".equals(str6))
          {
            i = zzp.zzbz().zzhe();
            if (TextUtils.isEmpty(str4)) {
              continue;
            }
            if (!TextUtils.isEmpty(str1)) {
              break label852;
            }
            zzb.zzaH("Could not parse the mediation config: Missing required ad_base_url field");
            return new AdResponseParcel(0);
          }
        }
        else
        {
          str4 = localJSONObject.optString("ad_html", null);
          continue;
        }
        if (!"landscape".equals(str6)) {
          continue;
        }
        i = zzp.zzbz().zzhd();
        continue;
        if (!TextUtils.isEmpty(str2))
        {
          AdResponseParcel localAdResponseParcel2 = zzhc.zza(paramAdRequestInfoParcel, paramContext, paramAdRequestInfoParcel.zzqR.afmaVersion, str2, null, null, null, null, null);
          str1 = localAdResponseParcel2.zzDE;
          str8 = localAdResponseParcel2.body;
          l1 = localAdResponseParcel2.zzGR;
          localAdResponseParcel3 = localAdResponseParcel2;
          JSONArray localJSONArray1 = localJSONObject.optJSONArray("click_urls");
          if (localAdResponseParcel3 != null) {
            break label424;
          }
          localObject1 = null;
          if (localJSONArray1 == null) {
            break;
          }
          if (localObject1 != null) {
            break label876;
          }
          localObject1 = new LinkedList();
          break label876;
          if (n >= localJSONArray1.length()) {
            break label882;
          }
          ((List)localObject1).add(localJSONArray1.getString(n));
          n++;
          continue;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("Could not parse the mediation config: Missing required ");
        if (bool1)
        {
          str7 = "ad_json";
          zzb.zzaH(str7 + " or " + "ad_url" + " field.");
          AdResponseParcel localAdResponseParcel1 = new AdResponseParcel(0);
          return localAdResponseParcel1;
        }
      }
      catch (JSONException localJSONException)
      {
        zzb.zzaH("Could not parse the mediation config: " + localJSONException.getMessage());
        return new AdResponseParcel(0);
      }
      String str7 = "ad_html";
      continue;
      label424:
      localObject1 = localAdResponseParcel3.zzAQ;
    }
    label434:
    JSONArray localJSONArray2 = localJSONObject.optJSONArray("impression_urls");
    Object localObject3;
    if (localAdResponseParcel3 == null) {
      localObject3 = null;
    }
    label472:
    int m;
    label513:
    Object localObject5;
    label551:
    int k;
    while (localJSONArray2 != null)
    {
      if (localObject3 != null) {
        break label889;
      }
      localObject3 = new LinkedList();
      break label889;
      while (m < localJSONArray2.length())
      {
        ((List)localObject3).add(localJSONArray2.getString(m));
        m++;
      }
      localObject3 = localAdResponseParcel3.zzAR;
      continue;
      JSONArray localJSONArray3 = localJSONObject.optJSONArray("manual_impression_urls");
      if (localAdResponseParcel3 == null) {}
      for (localObject5 = null; localJSONArray3 != null; localObject5 = localAdResponseParcel3.zzGP)
      {
        if (localObject5 != null) {
          break label902;
        }
        localObject5 = new LinkedList();
        break label902;
        while (k < localJSONArray3.length())
        {
          ((List)localObject5).add(localJSONArray3.getString(k));
          k++;
        }
      }
    }
    for (;;)
    {
      if (localAdResponseParcel3 != null)
      {
        if (localAdResponseParcel3.orientation != -1) {
          i = localAdResponseParcel3.orientation;
        }
        if (localAdResponseParcel3.zzGM <= 0L) {}
      }
      for (long l3 = localAdResponseParcel3.zzGM;; l3 = l2)
      {
        String str9 = localJSONObject.optString("active_view");
        boolean bool2 = localJSONObject.optBoolean("ad_is_javascript", false);
        String str10 = null;
        if (bool2) {
          str10 = localJSONObject.optString("ad_passback_url", null);
        }
        boolean bool3 = localJSONObject.optBoolean("mediation", false);
        boolean bool4 = localJSONObject.optBoolean("custom_render_allowed", false);
        boolean bool5 = localJSONObject.optBoolean("content_url_opted_out", true);
        boolean bool6 = localJSONObject.optBoolean("prefetch", false);
        int j = localJSONObject.optInt("oauth2_token_status", 0);
        long l4 = localJSONObject.optLong("refresh_interval_milliseconds", -1L);
        long l5 = localJSONObject.optLong("mediation_config_cache_time_milliseconds", -1L);
        String str11 = localJSONObject.optString("gws_query_id", "");
        boolean bool7 = "height".equals(localJSONObject.optString("fluid", ""));
        AdResponseParcel localAdResponseParcel4 = new AdResponseParcel(paramAdRequestInfoParcel, str1, str8, (List)localObject2, (List)localObject4, l3, bool3, l5, (List)localObject6, l4, i, str3, l1, str5, bool2, str10, str9, bool4, bool1, paramAdRequestInfoParcel.zzGy, bool5, bool6, j, str11, bool7);
        return localAdResponseParcel4;
      }
      Object localObject6 = localObject5;
      continue;
      Object localObject4 = localObject3;
      break label513;
      Object localObject2 = localObject1;
      break label434;
      label852:
      str8 = str4;
      localAdResponseParcel3 = null;
      break label247;
      label862:
      bool1 = false;
      break;
      label868:
      l2 = -1L;
      break label100;
      label876:
      n = 0;
      break label285;
      label882:
      localObject2 = localObject1;
      break label434;
      label889:
      m = 0;
      break label472;
      localObject4 = localObject3;
      break label513;
      label902:
      k = 0;
      break label551;
      localObject6 = localObject5;
    }
  }
  
  /* Error */
  public static JSONObject zza(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zzhi paramzzhi, zzhm.zza paramzza, Location paramLocation, zzbs paramzzbs, String paramString1, String paramString2, List<String> paramList, Bundle paramBundle)
  {
    // Byte code:
    //   0: new 272	java/util/HashMap
    //   3: dup
    //   4: invokespecial 273	java/util/HashMap:<init>	()V
    //   7: astore 10
    //   9: aload 8
    //   11: invokeinterface 276 1 0
    //   16: ifle +20 -> 36
    //   19: aload 10
    //   21: ldc_w 278
    //   24: ldc_w 280
    //   27: aload 8
    //   29: invokestatic 284	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   32: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: aload_1
    //   37: getfield 292	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGp	Landroid/os/Bundle;
    //   40: ifnull +16 -> 56
    //   43: aload 10
    //   45: ldc_w 294
    //   48: aload_1
    //   49: getfield 292	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGp	Landroid/os/Bundle;
    //   52: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: aload 10
    //   58: aload_1
    //   59: getfield 298	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGq	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   62: invokestatic 301	com/google/android/gms/internal/zzhd:zza	(Ljava/util/HashMap;Lcom/google/android/gms/ads/internal/client/AdRequestParcel;)V
    //   65: aload 10
    //   67: ldc_w 302
    //   70: aload_1
    //   71: getfield 306	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqV	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   74: getfield 311	com/google/android/gms/ads/internal/client/AdSizeParcel:zztV	Ljava/lang/String;
    //   77: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   80: pop
    //   81: aload_1
    //   82: getfield 306	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqV	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   85: getfield 314	com/google/android/gms/ads/internal/client/AdSizeParcel:width	I
    //   88: iconst_m1
    //   89: if_icmpne +15 -> 104
    //   92: aload 10
    //   94: ldc_w 316
    //   97: ldc_w 318
    //   100: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   103: pop
    //   104: aload_1
    //   105: getfield 306	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqV	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   108: getfield 320	com/google/android/gms/ads/internal/client/AdSizeParcel:height	I
    //   111: bipush -2
    //   113: if_icmpne +15 -> 128
    //   116: aload 10
    //   118: ldc_w 322
    //   121: ldc_w 324
    //   124: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: pop
    //   128: aload_1
    //   129: getfield 306	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqV	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   132: getfield 327	com/google/android/gms/ads/internal/client/AdSizeParcel:zztZ	Z
    //   135: ifeq +15 -> 150
    //   138: aload 10
    //   140: ldc_w 262
    //   143: ldc_w 260
    //   146: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   149: pop
    //   150: aload_1
    //   151: getfield 306	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqV	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   154: getfield 331	com/google/android/gms/ads/internal/client/AdSizeParcel:zztX	[Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   157: ifnull +169 -> 326
    //   160: new 180	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   167: astore 13
    //   169: aload_1
    //   170: getfield 306	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqV	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   173: getfield 331	com/google/android/gms/ads/internal/client/AdSizeParcel:zztX	[Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   176: astore 14
    //   178: aload 14
    //   180: arraylength
    //   181: istore 15
    //   183: iconst_0
    //   184: istore 16
    //   186: iload 16
    //   188: iload 15
    //   190: if_icmpge +125 -> 315
    //   193: aload 14
    //   195: iload 16
    //   197: aaload
    //   198: astore 17
    //   200: aload 13
    //   202: invokevirtual 332	java/lang/StringBuilder:length	()I
    //   205: ifeq +12 -> 217
    //   208: aload 13
    //   210: ldc_w 334
    //   213: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 17
    //   219: getfield 314	com/google/android/gms/ads/internal/client/AdSizeParcel:width	I
    //   222: iconst_m1
    //   223: if_icmpne +72 -> 295
    //   226: aload 17
    //   228: getfield 337	com/google/android/gms/ads/internal/client/AdSizeParcel:widthPixels	I
    //   231: i2f
    //   232: aload_2
    //   233: getfield 343	com/google/android/gms/internal/zzhi:zzGC	F
    //   236: fdiv
    //   237: f2i
    //   238: istore 18
    //   240: aload 13
    //   242: iload 18
    //   244: invokevirtual 346	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 13
    //   250: ldc_w 348
    //   253: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 17
    //   259: getfield 320	com/google/android/gms/ads/internal/client/AdSizeParcel:height	I
    //   262: bipush -2
    //   264: if_icmpne +41 -> 305
    //   267: aload 17
    //   269: getfield 351	com/google/android/gms/ads/internal/client/AdSizeParcel:heightPixels	I
    //   272: i2f
    //   273: aload_2
    //   274: getfield 343	com/google/android/gms/internal/zzhi:zzGC	F
    //   277: fdiv
    //   278: f2i
    //   279: istore 21
    //   281: aload 13
    //   283: iload 21
    //   285: invokevirtual 346	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: iinc 16 1
    //   292: goto -106 -> 186
    //   295: aload 17
    //   297: getfield 314	com/google/android/gms/ads/internal/client/AdSizeParcel:width	I
    //   300: istore 18
    //   302: goto -62 -> 240
    //   305: aload 17
    //   307: getfield 320	com/google/android/gms/ads/internal/client/AdSizeParcel:height	I
    //   310: istore 21
    //   312: goto -31 -> 281
    //   315: aload 10
    //   317: ldc_w 353
    //   320: aload 13
    //   322: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   325: pop
    //   326: aload_1
    //   327: getfield 67	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGw	I
    //   330: ifeq +83 -> 413
    //   333: aload 10
    //   335: ldc_w 355
    //   338: aload_1
    //   339: getfield 67	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGw	I
    //   342: invokestatic 34	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   345: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   348: pop
    //   349: aload_1
    //   350: getfield 306	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqV	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   353: getfield 358	com/google/android/gms/ads/internal/client/AdSizeParcel:zzua	Z
    //   356: ifne +57 -> 413
    //   359: aload 10
    //   361: ldc_w 360
    //   364: aload_1
    //   365: getfield 363	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzrl	Ljava/util/List;
    //   368: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   371: pop
    //   372: aload 10
    //   374: ldc_w 365
    //   377: aload_1
    //   378: getfield 369	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzrj	Lcom/google/android/gms/ads/internal/formats/NativeAdOptionsParcel;
    //   381: invokestatic 373	com/google/android/gms/internal/zzhd:zzc	(Lcom/google/android/gms/ads/internal/formats/NativeAdOptionsParcel;)Ljava/lang/String;
    //   384: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   387: pop
    //   388: aload_1
    //   389: getfield 376	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGH	Ljava/util/List;
    //   392: invokeinterface 379 1 0
    //   397: ifne +16 -> 413
    //   400: aload 10
    //   402: ldc_w 381
    //   405: aload_1
    //   406: getfield 376	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGH	Ljava/util/List;
    //   409: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   412: pop
    //   413: aload 10
    //   415: ldc_w 383
    //   418: aload_1
    //   419: getfield 386	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqP	Ljava/lang/String;
    //   422: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   425: pop
    //   426: aload 10
    //   428: ldc_w 388
    //   431: aload_1
    //   432: getfield 392	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   435: getfield 397	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   438: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   441: pop
    //   442: aload_1
    //   443: getfield 401	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGr	Landroid/content/pm/PackageInfo;
    //   446: ifnull +22 -> 468
    //   449: aload 10
    //   451: ldc_w 403
    //   454: aload_1
    //   455: getfield 401	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGr	Landroid/content/pm/PackageInfo;
    //   458: getfield 408	android/content/pm/PackageInfo:versionCode	I
    //   461: invokestatic 34	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   464: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   467: pop
    //   468: aload 10
    //   470: ldc_w 410
    //   473: aload 7
    //   475: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   478: pop
    //   479: aload 10
    //   481: ldc_w 412
    //   484: aload_1
    //   485: getfield 415	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGt	Ljava/lang/String;
    //   488: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   491: pop
    //   492: aload 10
    //   494: ldc_w 417
    //   497: aload_1
    //   498: getfield 420	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGu	Ljava/lang/String;
    //   501: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   504: pop
    //   505: aload 10
    //   507: ldc_w 422
    //   510: aload_1
    //   511: getfield 134	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqR	Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;
    //   514: getfield 140	com/google/android/gms/ads/internal/util/client/VersionInfoParcel:afmaVersion	Ljava/lang/String;
    //   517: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   520: pop
    //   521: aload 10
    //   523: aload_2
    //   524: aload_3
    //   525: invokestatic 425	com/google/android/gms/internal/zzhd:zza	(Ljava/util/HashMap;Lcom/google/android/gms/internal/zzhi;Lcom/google/android/gms/internal/zzhm$zza;)V
    //   528: aload 10
    //   530: ldc_w 427
    //   533: getstatic 432	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   536: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   539: pop
    //   540: aload 10
    //   542: ldc_w 434
    //   545: getstatic 437	android/os/Build:MODEL	Ljava/lang/String;
    //   548: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   551: pop
    //   552: aload_1
    //   553: getfield 298	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGq	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   556: getfield 440	com/google/android/gms/ads/internal/client/AdRequestParcel:versionCode	I
    //   559: iconst_2
    //   560: if_icmplt +25 -> 585
    //   563: aload_1
    //   564: getfield 298	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGq	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   567: getfield 444	com/google/android/gms/ads/internal/client/AdRequestParcel:zzty	Landroid/location/Location;
    //   570: ifnull +15 -> 585
    //   573: aload 10
    //   575: aload_1
    //   576: getfield 298	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGq	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   579: getfield 444	com/google/android/gms/ads/internal/client/AdRequestParcel:zzty	Landroid/location/Location;
    //   582: invokestatic 447	com/google/android/gms/internal/zzhd:zza	(Ljava/util/HashMap;Landroid/location/Location;)V
    //   585: aload_1
    //   586: getfield 448	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   589: iconst_2
    //   590: if_icmplt +16 -> 606
    //   593: aload 10
    //   595: ldc_w 450
    //   598: aload_1
    //   599: getfield 453	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGv	Landroid/os/Bundle;
    //   602: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   605: pop
    //   606: aload_1
    //   607: getfield 448	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   610: iconst_4
    //   611: if_icmplt +26 -> 637
    //   614: aload_1
    //   615: getfield 266	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGy	Z
    //   618: ifeq +19 -> 637
    //   621: aload 10
    //   623: ldc_w 455
    //   626: aload_1
    //   627: getfield 266	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGy	Z
    //   630: invokestatic 460	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   633: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   636: pop
    //   637: aload 9
    //   639: ifnull +14 -> 653
    //   642: aload 10
    //   644: ldc_w 462
    //   647: aload 9
    //   649: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   652: pop
    //   653: aload_1
    //   654: getfield 448	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   657: iconst_5
    //   658: if_icmplt +257 -> 915
    //   661: aload 10
    //   663: ldc_w 464
    //   666: aload_1
    //   667: getfield 465	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGC	F
    //   670: invokestatic 470	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   673: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   676: pop
    //   677: aload 10
    //   679: ldc_w 472
    //   682: aload_1
    //   683: getfield 475	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGB	I
    //   686: invokestatic 34	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   689: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   692: pop
    //   693: aload 10
    //   695: ldc_w 477
    //   698: aload_1
    //   699: getfield 480	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGA	I
    //   702: invokestatic 34	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   705: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   708: pop
    //   709: aload_1
    //   710: getfield 448	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   713: bipush 6
    //   715: if_icmplt +53 -> 768
    //   718: aload_1
    //   719: getfield 483	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGD	Ljava/lang/String;
    //   722: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   725: istore 41
    //   727: iload 41
    //   729: ifne +23 -> 752
    //   732: aload 10
    //   734: ldc_w 485
    //   737: new 48	org/json/JSONObject
    //   740: dup
    //   741: aload_1
    //   742: getfield 483	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGD	Ljava/lang/String;
    //   745: invokespecial 51	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   748: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   751: pop
    //   752: aload 10
    //   754: ldc_w 487
    //   757: aload_1
    //   758: getfield 490	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGE	J
    //   761: invokestatic 495	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   764: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   767: pop
    //   768: aload_1
    //   769: getfield 448	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   772: bipush 7
    //   774: if_icmplt +16 -> 790
    //   777: aload 10
    //   779: ldc_w 497
    //   782: aload_1
    //   783: getfield 500	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGF	Ljava/lang/String;
    //   786: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   789: pop
    //   790: aload_1
    //   791: getfield 448	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   794: bipush 11
    //   796: if_icmplt +26 -> 822
    //   799: aload_1
    //   800: getfield 504	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGJ	Lcom/google/android/gms/ads/internal/request/CapabilityParcel;
    //   803: ifnull +19 -> 822
    //   806: aload 10
    //   808: ldc_w 506
    //   811: aload_1
    //   812: getfield 504	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGJ	Lcom/google/android/gms/ads/internal/request/CapabilityParcel;
    //   815: invokevirtual 512	com/google/android/gms/ads/internal/request/CapabilityParcel:toBundle	()Landroid/os/Bundle;
    //   818: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   821: pop
    //   822: aload 10
    //   824: aload 6
    //   826: invokestatic 515	com/google/android/gms/internal/zzhd:zza	(Ljava/util/HashMap;Ljava/lang/String;)V
    //   829: aload_1
    //   830: getfield 448	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   833: bipush 12
    //   835: if_icmplt +26 -> 861
    //   838: aload_1
    //   839: getfield 518	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGK	Ljava/lang/String;
    //   842: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   845: ifne +16 -> 861
    //   848: aload 10
    //   850: ldc_w 520
    //   853: aload_1
    //   854: getfield 518	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGK	Ljava/lang/String;
    //   857: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   860: pop
    //   861: iconst_2
    //   862: invokestatic 524	com/google/android/gms/ads/internal/util/client/zzb:zzQ	(I)Z
    //   865: ifeq +41 -> 906
    //   868: invokestatic 528	com/google/android/gms/ads/internal/zzp:zzbx	()Lcom/google/android/gms/internal/zzip;
    //   871: aload 10
    //   873: invokevirtual 534	com/google/android/gms/internal/zzip:zzz	(Ljava/util/Map;)Lorg/json/JSONObject;
    //   876: iconst_2
    //   877: invokevirtual 536	org/json/JSONObject:toString	(I)Ljava/lang/String;
    //   880: astore 37
    //   882: new 180	java/lang/StringBuilder
    //   885: dup
    //   886: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   889: ldc_w 538
    //   892: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: aload 37
    //   897: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: invokestatic 541	com/google/android/gms/ads/internal/util/client/zzb:v	(Ljava/lang/String;)V
    //   906: invokestatic 528	com/google/android/gms/ads/internal/zzp:zzbx	()Lcom/google/android/gms/internal/zzip;
    //   909: aload 10
    //   911: invokevirtual 534	com/google/android/gms/internal/zzip:zzz	(Ljava/util/Map;)Lorg/json/JSONObject;
    //   914: areturn
    //   915: aload 10
    //   917: ldc_w 464
    //   920: aload_2
    //   921: getfield 343	com/google/android/gms/internal/zzhi:zzGC	F
    //   924: invokestatic 470	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   927: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   930: pop
    //   931: aload 10
    //   933: ldc_w 472
    //   936: aload_2
    //   937: getfield 542	com/google/android/gms/internal/zzhi:zzGB	I
    //   940: invokestatic 34	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   943: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   946: pop
    //   947: aload 10
    //   949: ldc_w 477
    //   952: aload_2
    //   953: getfield 543	com/google/android/gms/internal/zzhi:zzGA	I
    //   956: invokestatic 34	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   959: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   962: pop
    //   963: goto -254 -> 709
    //   966: astore 11
    //   968: new 180	java/lang/StringBuilder
    //   971: dup
    //   972: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   975: ldc_w 545
    //   978: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: aload 11
    //   983: invokevirtual 200	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   986: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   992: invokestatic 118	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   995: aconst_null
    //   996: areturn
    //   997: astore 43
    //   999: ldc_w 547
    //   1002: aload 43
    //   1004: invokestatic 551	com/google/android/gms/ads/internal/util/client/zzb:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1007: goto -255 -> 752
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1010	0	paramContext	Context
    //   0	1010	1	paramAdRequestInfoParcel	AdRequestInfoParcel
    //   0	1010	2	paramzzhi	zzhi
    //   0	1010	3	paramzza	zzhm.zza
    //   0	1010	4	paramLocation	Location
    //   0	1010	5	paramzzbs	zzbs
    //   0	1010	6	paramString1	String
    //   0	1010	7	paramString2	String
    //   0	1010	8	paramList	List<String>
    //   0	1010	9	paramBundle	Bundle
    //   7	941	10	localHashMap	HashMap
    //   966	16	11	localJSONException1	JSONException
    //   167	154	13	localStringBuilder	StringBuilder
    //   176	18	14	arrayOfAdSizeParcel	com.google.android.gms.ads.internal.client.AdSizeParcel[]
    //   181	10	15	i	int
    //   184	106	16	j	int
    //   198	108	17	localAdSizeParcel	com.google.android.gms.ads.internal.client.AdSizeParcel
    //   238	63	18	k	int
    //   279	32	21	m	int
    //   880	16	37	str	String
    //   725	3	41	bool	boolean
    //   997	6	43	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   0	36	966	org/json/JSONException
    //   36	56	966	org/json/JSONException
    //   56	104	966	org/json/JSONException
    //   104	128	966	org/json/JSONException
    //   128	150	966	org/json/JSONException
    //   150	183	966	org/json/JSONException
    //   193	217	966	org/json/JSONException
    //   217	240	966	org/json/JSONException
    //   240	281	966	org/json/JSONException
    //   281	289	966	org/json/JSONException
    //   295	302	966	org/json/JSONException
    //   305	312	966	org/json/JSONException
    //   315	326	966	org/json/JSONException
    //   326	413	966	org/json/JSONException
    //   413	468	966	org/json/JSONException
    //   468	585	966	org/json/JSONException
    //   585	606	966	org/json/JSONException
    //   606	637	966	org/json/JSONException
    //   642	653	966	org/json/JSONException
    //   653	709	966	org/json/JSONException
    //   709	727	966	org/json/JSONException
    //   752	768	966	org/json/JSONException
    //   768	790	966	org/json/JSONException
    //   790	822	966	org/json/JSONException
    //   822	861	966	org/json/JSONException
    //   861	906	966	org/json/JSONException
    //   906	915	966	org/json/JSONException
    //   915	963	966	org/json/JSONException
    //   999	1007	966	org/json/JSONException
    //   732	752	997	org/json/JSONException
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, Location paramLocation)
  {
    HashMap localHashMap = new HashMap();
    Float localFloat = Float.valueOf(1000.0F * paramLocation.getAccuracy());
    Long localLong1 = Long.valueOf(1000L * paramLocation.getTime());
    Long localLong2 = Long.valueOf((1.0E7D * paramLocation.getLatitude()));
    Long localLong3 = Long.valueOf((1.0E7D * paramLocation.getLongitude()));
    localHashMap.put("radius", localFloat);
    localHashMap.put("lat", localLong2);
    localHashMap.put("long", localLong3);
    localHashMap.put("time", localLong1);
    paramHashMap.put("uule", localHashMap);
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, AdRequestParcel paramAdRequestParcel)
  {
    String str = zzik.zzgW();
    if (str != null) {
      paramHashMap.put("abf", str);
    }
    if (paramAdRequestParcel.zztq != -1L) {
      paramHashMap.put("cust_age", zzHU.format(new Date(paramAdRequestParcel.zztq)));
    }
    if (paramAdRequestParcel.extras != null) {
      paramHashMap.put("extras", paramAdRequestParcel.extras);
    }
    if (paramAdRequestParcel.zztr != -1) {
      paramHashMap.put("cust_gender", Integer.valueOf(paramAdRequestParcel.zztr));
    }
    if (paramAdRequestParcel.zzts != null) {
      paramHashMap.put("kw", paramAdRequestParcel.zzts);
    }
    if (paramAdRequestParcel.zztu != -1) {
      paramHashMap.put("tag_for_child_directed_treatment", Integer.valueOf(paramAdRequestParcel.zztu));
    }
    if (paramAdRequestParcel.zztt) {
      paramHashMap.put("adtest", "on");
    }
    if (paramAdRequestParcel.versionCode >= 2)
    {
      if (paramAdRequestParcel.zztv) {
        paramHashMap.put("d_imp_hdr", Integer.valueOf(1));
      }
      if (!TextUtils.isEmpty(paramAdRequestParcel.zztw)) {
        paramHashMap.put("ppid", paramAdRequestParcel.zztw);
      }
      if (paramAdRequestParcel.zztx != null) {
        zza(paramHashMap, paramAdRequestParcel.zztx);
      }
    }
    if ((paramAdRequestParcel.versionCode >= 3) && (paramAdRequestParcel.zztz != null)) {
      paramHashMap.put("url", paramAdRequestParcel.zztz);
    }
    if (paramAdRequestParcel.versionCode >= 5)
    {
      if (paramAdRequestParcel.zztB != null) {
        paramHashMap.put("custom_targeting", paramAdRequestParcel.zztB);
      }
      if (paramAdRequestParcel.zztC != null) {
        paramHashMap.put("category_exclusions", paramAdRequestParcel.zztC);
      }
      if (paramAdRequestParcel.zztD != null) {
        paramHashMap.put("request_agent", paramAdRequestParcel.zztD);
      }
    }
    if ((paramAdRequestParcel.versionCode >= 6) && (paramAdRequestParcel.zztE != null)) {
      paramHashMap.put("request_pkg", paramAdRequestParcel.zztE);
    }
    if (paramAdRequestParcel.versionCode >= 7) {
      paramHashMap.put("is_designed_for_families", Boolean.valueOf(paramAdRequestParcel.zztF));
    }
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, SearchAdRequestParcel paramSearchAdRequestParcel)
  {
    if (Color.alpha(paramSearchAdRequestParcel.zzuI) != 0) {
      paramHashMap.put("acolor", zzL(paramSearchAdRequestParcel.zzuI));
    }
    if (Color.alpha(paramSearchAdRequestParcel.backgroundColor) != 0) {
      paramHashMap.put("bgcolor", zzL(paramSearchAdRequestParcel.backgroundColor));
    }
    if ((Color.alpha(paramSearchAdRequestParcel.zzuJ) != 0) && (Color.alpha(paramSearchAdRequestParcel.zzuK) != 0))
    {
      paramHashMap.put("gradientto", zzL(paramSearchAdRequestParcel.zzuJ));
      paramHashMap.put("gradientfrom", zzL(paramSearchAdRequestParcel.zzuK));
    }
    if (Color.alpha(paramSearchAdRequestParcel.zzuL) != 0) {
      paramHashMap.put("bcolor", zzL(paramSearchAdRequestParcel.zzuL));
    }
    paramHashMap.put("bthick", Integer.toString(paramSearchAdRequestParcel.zzuM));
    Object localObject1;
    Object localObject2;
    switch (paramSearchAdRequestParcel.zzuN)
    {
    default: 
      localObject1 = null;
      if (localObject1 != null) {
        paramHashMap.put("btype", localObject1);
      }
      int i = paramSearchAdRequestParcel.zzuO;
      localObject2 = null;
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      if (localObject2 != null) {
        paramHashMap.put("callbuttoncolor", localObject2);
      }
      if (paramSearchAdRequestParcel.zzuP != null) {
        paramHashMap.put("channel", paramSearchAdRequestParcel.zzuP);
      }
      if (Color.alpha(paramSearchAdRequestParcel.zzuQ) != 0) {
        paramHashMap.put("dcolor", zzL(paramSearchAdRequestParcel.zzuQ));
      }
      if (paramSearchAdRequestParcel.zzuR != null) {
        paramHashMap.put("font", paramSearchAdRequestParcel.zzuR);
      }
      if (Color.alpha(paramSearchAdRequestParcel.zzuS) != 0) {
        paramHashMap.put("hcolor", zzL(paramSearchAdRequestParcel.zzuS));
      }
      paramHashMap.put("headersize", Integer.toString(paramSearchAdRequestParcel.zzuT));
      if (paramSearchAdRequestParcel.zzuU != null) {
        paramHashMap.put("q", paramSearchAdRequestParcel.zzuU);
      }
      return;
      localObject1 = "none";
      break;
      localObject1 = "dashed";
      break;
      localObject1 = "dotted";
      break;
      localObject1 = "solid";
      break;
      localObject2 = "dark";
      continue;
      localObject2 = "light";
      continue;
      localObject2 = "medium";
    }
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, zzhi paramzzhi, zzhm.zza paramzza)
  {
    paramHashMap.put("am", Integer.valueOf(paramzzhi.zzIA));
    paramHashMap.put("cog", zzy(paramzzhi.zzIB));
    paramHashMap.put("coh", zzy(paramzzhi.zzIC));
    if (!TextUtils.isEmpty(paramzzhi.zzID)) {
      paramHashMap.put("carrier", paramzzhi.zzID);
    }
    paramHashMap.put("gl", paramzzhi.zzIE);
    if (paramzzhi.zzIF) {
      paramHashMap.put("simulator", Integer.valueOf(1));
    }
    if (paramzzhi.zzIG) {
      paramHashMap.put("is_sidewinder", Integer.valueOf(1));
    }
    paramHashMap.put("ma", zzy(paramzzhi.zzIH));
    paramHashMap.put("sp", zzy(paramzzhi.zzII));
    paramHashMap.put("hl", paramzzhi.zzIJ);
    if (!TextUtils.isEmpty(paramzzhi.zzIK)) {
      paramHashMap.put("mv", paramzzhi.zzIK);
    }
    paramHashMap.put("muv", Integer.valueOf(paramzzhi.zzIL));
    if (paramzzhi.zzIM != -2) {
      paramHashMap.put("cnt", Integer.valueOf(paramzzhi.zzIM));
    }
    paramHashMap.put("gnt", Integer.valueOf(paramzzhi.zzIN));
    paramHashMap.put("pt", Integer.valueOf(paramzzhi.zzIO));
    paramHashMap.put("rm", Integer.valueOf(paramzzhi.zzIP));
    paramHashMap.put("riv", Integer.valueOf(paramzzhi.zzIQ));
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("build", paramzzhi.zzIV);
    Bundle localBundle2 = new Bundle();
    localBundle2.putBoolean("is_charging", paramzzhi.zzIS);
    localBundle2.putDouble("battery_level", paramzzhi.zzIR);
    localBundle1.putBundle("battery", localBundle2);
    Bundle localBundle3 = new Bundle();
    localBundle3.putInt("active_network_state", paramzzhi.zzIU);
    localBundle3.putBoolean("active_network_metered", paramzzhi.zzIT);
    if (paramzza != null)
    {
      Bundle localBundle4 = new Bundle();
      localBundle4.putInt("predicted_latency_micros", paramzza.zzJa);
      localBundle4.putLong("predicted_down_throughput_bps", paramzza.zzJb);
      localBundle4.putLong("predicted_up_throughput_bps", paramzza.zzJc);
      localBundle3.putBundle("predictions", localBundle4);
    }
    localBundle1.putBundle("network", localBundle3);
    paramHashMap.put("device", localBundle1);
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, String paramString)
  {
    if (paramString != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("token", paramString);
      paramHashMap.put("pan", localHashMap);
    }
  }
  
  private static String zzc(NativeAdOptionsParcel paramNativeAdOptionsParcel)
  {
    if (paramNativeAdOptionsParcel != null) {}
    for (int i = paramNativeAdOptionsParcel.zzyd;; i = 0) {
      switch (i)
      {
      default: 
        return "any";
      }
    }
    return "portrait";
    return "landscape";
  }
  
  private static Integer zzy(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return Integer.valueOf(i);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzhd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */