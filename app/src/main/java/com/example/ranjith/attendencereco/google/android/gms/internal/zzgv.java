package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.formats.zzh.zza;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzgv
  implements Callable<zzie>
{
  private static final long zzFC = TimeUnit.SECONDS.toMillis(60L);
  private final Context mContext;
  private final zziu zzFD;
  private final zzn zzFE;
  private final zzbc zzFF;
  private boolean zzFG;
  private List<String> zzFH;
  private JSONObject zzFI;
  private final zzie.zza zzFc;
  private int zzFt;
  private final Object zzpK = new Object();
  private final zzan zzxV;
  
  public zzgv(Context paramContext, zzn paramzzn, zzbc paramzzbc, zziu paramzziu, zzan paramzzan, zzie.zza paramzza)
  {
    this.mContext = paramContext;
    this.zzFE = paramzzn;
    this.zzFD = paramzziu;
    this.zzFF = paramzzbc;
    this.zzFc = paramzza;
    this.zzxV = paramzzan;
    this.zzFG = false;
    this.zzFt = -2;
    this.zzFH = null;
  }
  
  private zzh.zza zza(zzbb paramzzbb, zza paramzza, JSONObject paramJSONObject)
    throws ExecutionException, InterruptedException, JSONException
  {
    if (zzga()) {
      return null;
    }
    JSONObject localJSONObject = paramJSONObject.getJSONObject("tracking_urls_and_actions");
    String[] arrayOfString = zzc(localJSONObject, "impression_tracking_urls");
    if (arrayOfString == null) {}
    zzh.zza localzza;
    for (List localList = null;; localList = Arrays.asList(arrayOfString))
    {
      this.zzFH = localList;
      this.zzFI = localJSONObject.optJSONObject("active_view");
      localzza = paramzza.zza(this, paramJSONObject);
      if (localzza != null) {
        break;
      }
      zzb.e("Failed to retrieve ad assets.");
      return null;
    }
    localzza.zzb(new zzh(this.mContext, this.zzFE, paramzzbb, this.zzxV, paramJSONObject, localzza, this.zzFc.zzJK.zzqR));
    return localzza;
  }
  
  private zzie zza(zzh.zza paramzza)
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        int i = this.zzFt;
        if ((paramzza == null) && (this.zzFt == -2)) {
          i = 0;
        }
        if (i != -2)
        {
          localzza = null;
          return new zzie(this.zzFc.zzJK.zzGq, null, this.zzFc.zzJL.zzAQ, i, this.zzFc.zzJL.zzAR, this.zzFH, this.zzFc.zzJL.orientation, this.zzFc.zzJL.zzAU, this.zzFc.zzJK.zzGt, false, null, null, null, null, null, 0L, this.zzFc.zzqV, this.zzFc.zzJL.zzGM, this.zzFc.zzJH, this.zzFc.zzJI, this.zzFc.zzJL.zzGS, this.zzFI, localzza);
        }
      }
      zzh.zza localzza = paramzza;
    }
  }
  
  private zzje<zzc> zza(JSONObject paramJSONObject, final boolean paramBoolean1, boolean paramBoolean2)
    throws JSONException
  {
    if (paramBoolean1) {}
    final double d;
    for (String str = paramJSONObject.getString("url");; str = paramJSONObject.optString("url"))
    {
      d = paramJSONObject.optDouble("scale", 1.0D);
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      zza(0, paramBoolean1);
      return new zzjc(null);
    }
    if (paramBoolean2) {
      return new zzjc(new zzc(null, Uri.parse(str), d));
    }
    this.zzFD.zza(str, new zziu.zza()
    {
      public zzc zzg(InputStream paramAnonymousInputStream)
      {
        try
        {
          byte[] arrayOfByte2 = zznt.zzk(paramAnonymousInputStream);
          arrayOfByte1 = arrayOfByte2;
        }
        catch (IOException localIOException)
        {
          byte[] arrayOfByte1;
          for (;;)
          {
            arrayOfByte1 = null;
          }
          Bitmap localBitmap = BitmapFactory.decodeByteArray(arrayOfByte1, 0, arrayOfByte1.length);
          if (localBitmap != null) {
            break label61;
          }
          zzgv.this.zza(2, paramBoolean1);
          return null;
          label61:
          localBitmap.setDensity((int)(160.0D * d));
          return new zzc(new BitmapDrawable(Resources.getSystem(), localBitmap), Uri.parse(this.zzCr), d);
        }
        if (arrayOfByte1 == null)
        {
          zzgv.this.zza(2, paramBoolean1);
          return null;
        }
      }
      
      public zzc zzgb()
      {
        zzgv.this.zza(2, paramBoolean1);
        return null;
      }
    });
  }
  
  private void zza(zzh.zza paramzza, zzbb paramzzbb)
  {
    if (!(paramzza instanceof zzf)) {
      return;
    }
    final zzf localzzf = (zzf)paramzza;
    zzb localzzb = new zzb();
    zzdl local3 = new zzdl()
    {
      public void zza(zzjn paramAnonymouszzjn, Map<String, String> paramAnonymousMap)
      {
        String str = (String)paramAnonymousMap.get("asset");
        zzgv.zza(zzgv.this, localzzf, str);
      }
    };
    localzzb.zzFY = local3;
    paramzzbb.zza("/nativeAdCustomClick", local3);
  }
  
  private Integer zzb(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject(paramString);
      Integer localInteger = Integer.valueOf(Color.rgb(localJSONObject.getInt("r"), localJSONObject.getInt("g"), localJSONObject.getInt("b")));
      return localInteger;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  private JSONObject zzb(final zzbb paramzzbb)
    throws TimeoutException, JSONException
  {
    if (zzga()) {
      return null;
    }
    final zzjb localzzjb = new zzjb();
    final zzb localzzb = new zzb();
    zzdl local1 = new zzdl()
    {
      public void zza(zzjn paramAnonymouszzjn, Map<String, String> paramAnonymousMap)
      {
        paramzzbb.zzb("/nativeAdPreProcess", localzzb.zzFY);
        try
        {
          String str = (String)paramAnonymousMap.get("success");
          if (!TextUtils.isEmpty(str))
          {
            localzzjb.zzf(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          zzb.zzb("Malformed native JSON response.", localJSONException);
          zzgv.this.zzF(0);
          zzx.zza(zzgv.this.zzga(), "Unable to set the ad state error!");
          localzzjb.zzf(null);
        }
      }
    };
    localzzb.zzFY = local1;
    paramzzbb.zza("/nativeAdPreProcess", local1);
    paramzzbb.zza("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.zzFc.zzJL.body));
    return (JSONObject)localzzjb.get(zzFC, TimeUnit.MILLISECONDS);
  }
  
  private void zzb(zzcv paramzzcv, String paramString)
  {
    try
    {
      zzcz localzzcz = this.zzFE.zzr(paramzzcv.getCustomTemplateId());
      if (localzzcz != null) {
        localzzcz.zza(paramzzcv, paramString);
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Failed to call onCustomClick for asset " + paramString + ".", localRemoteException);
    }
  }
  
  private String[] zzc(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    if (localJSONArray == null) {
      return null;
    }
    String[] arrayOfString = new String[localJSONArray.length()];
    for (int i = 0; i < localJSONArray.length(); i++) {
      arrayOfString[i] = localJSONArray.getString(i);
    }
    return arrayOfString;
  }
  
  private static List<Drawable> zzf(List<zzc> paramList)
    throws RemoteException
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Drawable)zze.zzp(((zzc)localIterator.next()).zzdC()));
    }
    return localArrayList;
  }
  
  private zzbb zzfZ()
    throws CancellationException, ExecutionException, InterruptedException, TimeoutException
  {
    if (zzga()) {
      return null;
    }
    String str1 = (String)zzbz.zzwh.get();
    if (this.zzFc.zzJL.zzDE.indexOf("https") == 0) {}
    for (String str2 = "https:";; str2 = "http:")
    {
      String str3 = str2 + str1;
      zzbb localzzbb = (zzbb)this.zzFF.zza(this.mContext, this.zzFc.zzJK.zzqR, str3, this.zzxV).get(zzFC, TimeUnit.MILLISECONDS);
      localzzbb.zza(this.zzFE, this.zzFE, this.zzFE, this.zzFE, false, null, null, null, null);
      return localzzbb;
    }
  }
  
  public void zzF(int paramInt)
  {
    synchronized (this.zzpK)
    {
      this.zzFG = true;
      this.zzFt = paramInt;
      return;
    }
  }
  
  public zzje<zzc> zza(JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws JSONException
  {
    if (paramBoolean1) {}
    for (JSONObject localJSONObject = paramJSONObject.getJSONObject(paramString);; localJSONObject = paramJSONObject.optJSONObject(paramString))
    {
      if (localJSONObject == null) {
        localJSONObject = new JSONObject();
      }
      return zza(localJSONObject, paramBoolean1, paramBoolean2);
    }
  }
  
  public List<zzje<zzc>> zza(JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    throws JSONException
  {
    if (paramBoolean1) {}
    ArrayList localArrayList;
    for (JSONArray localJSONArray = paramJSONObject.getJSONArray(paramString);; localJSONArray = paramJSONObject.optJSONArray(paramString))
    {
      localArrayList = new ArrayList();
      if ((localJSONArray != null) && (localJSONArray.length() != 0)) {
        break;
      }
      zza(0, paramBoolean1);
      return localArrayList;
    }
    if (paramBoolean3) {}
    for (int i = localJSONArray.length();; i = 1) {
      for (int j = 0; j < i; j++)
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(j);
        if (localJSONObject == null) {
          localJSONObject = new JSONObject();
        }
        localArrayList.add(zza(localJSONObject, paramBoolean1, paramBoolean2));
      }
    }
    return localArrayList;
  }
  
  public Future<zzc> zza(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject(paramString);
    boolean bool = localJSONObject.optBoolean("require", true);
    if (localJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    return zza(localJSONObject, bool, paramBoolean);
  }
  
  public void zza(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      zzF(paramInt);
    }
  }
  
  protected zza zzd(JSONObject paramJSONObject)
    throws JSONException, TimeoutException
  {
    if (zzga()) {
      return null;
    }
    String str1 = paramJSONObject.getString("template_id");
    boolean bool1;
    if (this.zzFc.zzJK.zzrj != null)
    {
      bool1 = this.zzFc.zzJK.zzrj.zzyc;
      if (this.zzFc.zzJK.zzrj == null) {
        break label98;
      }
    }
    label98:
    for (boolean bool2 = this.zzFc.zzJK.zzrj.zzye;; bool2 = false)
    {
      if (!"2".equals(str1)) {
        break label104;
      }
      return new zzgw(bool1, bool2);
      bool1 = false;
      break;
    }
    label104:
    if ("1".equals(str1)) {
      return new zzgx(bool1, bool2);
    }
    if ("3".equals(str1))
    {
      final String str2 = paramJSONObject.getString("custom_template_id");
      final zzjb localzzjb = new zzjb();
      zzip.zzKO.post(new Runnable()
      {
        public void run()
        {
          localzzjb.zzf(zzgv.zza(zzgv.this).zzbq().get(str2));
        }
      });
      if (localzzjb.get(zzFC, TimeUnit.MILLISECONDS) != null) {
        return new zzgy(bool1);
      }
      zzb.e("No handler for custom template: " + paramJSONObject.getString("custom_template_id"));
    }
    for (;;)
    {
      return null;
      zzF(0);
    }
  }
  
  public zzje<zza> zze(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("attribution");
    if (localJSONObject == null) {
      return new zzjc(null);
    }
    final String str = localJSONObject.optString("text");
    final int i = localJSONObject.optInt("text_size", -1);
    final Integer localInteger1 = zzb(localJSONObject, "text_color");
    final Integer localInteger2 = zzb(localJSONObject, "bg_color");
    final int j = localJSONObject.optInt("animation_ms", 1000);
    final int k = localJSONObject.optInt("presentation_ms", 4000);
    Object localObject = new ArrayList();
    if (localJSONObject.optJSONArray("images") != null) {
      localObject = zza(localJSONObject, "images", false, false, true);
    }
    for (;;)
    {
      zzjd.zza(zzjd.zzj((List)localObject), new zzjd.zza()
      {
        public zza zzh(List<zzc> paramAnonymousList)
        {
          if (paramAnonymousList != null) {
            for (;;)
            {
              try
              {
                if (paramAnonymousList.isEmpty()) {
                  break;
                }
                String str = str;
                List localList = zzgv.zzg(paramAnonymousList);
                Integer localInteger1 = localInteger2;
                Integer localInteger2 = localInteger1;
                if (i > 0)
                {
                  localInteger3 = Integer.valueOf(i);
                  localzza = new zza(str, localList, localInteger1, localInteger2, localInteger3, k + j);
                }
              }
              catch (RemoteException localRemoteException)
              {
                zzb.zzb("Could not get attribution icon", localRemoteException);
                return null;
              }
              Integer localInteger3 = null;
            }
          }
          zza localzza = null;
          return localzza;
        }
      });
      ((List)localObject).add(zza(localJSONObject, "image", false, false));
    }
  }
  
  public zzie zzfY()
  {
    try
    {
      zzbb localzzbb = zzfZ();
      JSONObject localJSONObject = zzb(localzzbb);
      zzh.zza localzza = zza(localzzbb, zzd(localJSONObject), localJSONObject);
      zza(localzza, localzzbb);
      zzie localzzie = zza(localzza);
      return localzzie;
    }
    catch (JSONException localJSONException)
    {
      zzb.zzd("Malformed native JSON response.", localJSONException);
      if (!this.zzFG) {
        zzF(0);
      }
      return zza(null);
    }
    catch (TimeoutException localTimeoutException)
    {
      for (;;)
      {
        zzb.zzd("Timeout when loading native ad.", localTimeoutException);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;) {}
    }
    catch (CancellationException localCancellationException)
    {
      for (;;) {}
    }
  }
  
  public boolean zzga()
  {
    synchronized (this.zzpK)
    {
      boolean bool = this.zzFG;
      return bool;
    }
  }
  
  public static abstract interface zza<T extends zzh.zza>
  {
    public abstract T zza(zzgv paramzzgv, JSONObject paramJSONObject)
      throws JSONException, InterruptedException, ExecutionException;
  }
  
  class zzb
  {
    public zzdl zzFY;
    
    zzb() {}
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzgv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */