package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzdm
  implements zzdl
{
  private final Context mContext;
  private final VersionInfoParcel zzpI;
  
  public zzdm(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    this.mContext = paramContext;
    this.zzpI = paramVersionInfoParcel;
  }
  
  /* Error */
  public JSONObject zzV(String paramString)
  {
    // Byte code:
    //   0: new 28	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 31	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: new 28	org/json/JSONObject
    //   12: dup
    //   13: invokespecial 32	org/json/JSONObject:<init>	()V
    //   16: astore_3
    //   17: ldc 34
    //   19: astore 4
    //   21: aload_2
    //   22: ldc 36
    //   24: invokevirtual 40	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 4
    //   29: aload_0
    //   30: aload_0
    //   31: aload_2
    //   32: invokevirtual 44	com/google/android/gms/internal/zzdm:zzb	(Lorg/json/JSONObject;)Lcom/google/android/gms/internal/zzdm$zzb;
    //   35: invokevirtual 48	com/google/android/gms/internal/zzdm:zza	(Lcom/google/android/gms/internal/zzdm$zzb;)Lcom/google/android/gms/internal/zzdm$zzc;
    //   38: astore 10
    //   40: aload 10
    //   42: invokevirtual 54	com/google/android/gms/internal/zzdm$zzc:isSuccess	()Z
    //   45: ifeq +64 -> 109
    //   48: aload_3
    //   49: ldc 56
    //   51: aload_0
    //   52: aload 10
    //   54: invokevirtual 60	com/google/android/gms/internal/zzdm$zzc:zzdR	()Lcom/google/android/gms/internal/zzdm$zzd;
    //   57: invokevirtual 63	com/google/android/gms/internal/zzdm:zza	(Lcom/google/android/gms/internal/zzdm$zzd;)Lorg/json/JSONObject;
    //   60: invokevirtual 67	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   63: pop
    //   64: aload_3
    //   65: ldc 69
    //   67: iconst_1
    //   68: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   71: pop
    //   72: aload_3
    //   73: areturn
    //   74: astore 16
    //   76: ldc 74
    //   78: invokestatic 79	com/google/android/gms/ads/internal/util/client/zzb:e	(Ljava/lang/String;)V
    //   81: new 28	org/json/JSONObject
    //   84: dup
    //   85: invokespecial 32	org/json/JSONObject:<init>	()V
    //   88: ldc 69
    //   90: iconst_0
    //   91: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   94: astore 18
    //   96: aload 18
    //   98: areturn
    //   99: astore 17
    //   101: new 28	org/json/JSONObject
    //   104: dup
    //   105: invokespecial 32	org/json/JSONObject:<init>	()V
    //   108: areturn
    //   109: aload_3
    //   110: ldc 56
    //   112: new 28	org/json/JSONObject
    //   115: dup
    //   116: invokespecial 32	org/json/JSONObject:<init>	()V
    //   119: ldc 36
    //   121: aload 4
    //   123: invokevirtual 67	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   126: invokevirtual 67	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   129: pop
    //   130: aload_3
    //   131: ldc 69
    //   133: iconst_0
    //   134: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   137: pop
    //   138: aload_3
    //   139: ldc 81
    //   141: aload 10
    //   143: invokevirtual 85	com/google/android/gms/internal/zzdm$zzc:getReason	()Ljava/lang/String;
    //   146: invokevirtual 67	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   149: pop
    //   150: aload_3
    //   151: areturn
    //   152: astore 5
    //   154: aload_3
    //   155: ldc 56
    //   157: new 28	org/json/JSONObject
    //   160: dup
    //   161: invokespecial 32	org/json/JSONObject:<init>	()V
    //   164: ldc 36
    //   166: aload 4
    //   168: invokevirtual 67	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   171: invokevirtual 67	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   174: pop
    //   175: aload_3
    //   176: ldc 69
    //   178: iconst_0
    //   179: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   182: pop
    //   183: aload_3
    //   184: ldc 81
    //   186: aload 5
    //   188: invokevirtual 88	java/lang/Exception:toString	()Ljava/lang/String;
    //   191: invokevirtual 67	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   194: pop
    //   195: aload_3
    //   196: areturn
    //   197: astore 6
    //   199: aload_3
    //   200: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	zzdm
    //   0	201	1	paramString	String
    //   8	24	2	localJSONObject1	JSONObject
    //   16	184	3	localJSONObject2	JSONObject
    //   19	148	4	str	String
    //   152	35	5	localException	Exception
    //   197	1	6	localJSONException1	JSONException
    //   38	104	10	localzzc	zzc
    //   74	1	16	localJSONException2	JSONException
    //   99	1	17	localJSONException3	JSONException
    //   94	3	18	localJSONObject3	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	9	74	org/json/JSONException
    //   81	96	99	org/json/JSONException
    //   21	72	152	java/lang/Exception
    //   109	150	152	java/lang/Exception
    //   154	195	197	org/json/JSONException
  }
  
  protected zzc zza(zzb paramzzb)
  {
    HttpURLConnection localHttpURLConnection;
    try
    {
      localHttpURLConnection = (HttpURLConnection)paramzzb.zzdO().openConnection();
      zzp.zzbx().zza(this.mContext, this.zzpI.afmaVersion, false, localHttpURLConnection);
      Iterator localIterator1 = paramzzb.zzdP().iterator();
      while (localIterator1.hasNext())
      {
        zza localzza = (zza)localIterator1.next();
        localHttpURLConnection.addRequestProperty(localzza.getKey(), localzza.getValue());
      }
      if (TextUtils.isEmpty(paramzzb.zzdQ())) {
        break label150;
      }
    }
    catch (Exception localException)
    {
      return new zzc(false, null, localException.toString());
    }
    localHttpURLConnection.setDoOutput(true);
    byte[] arrayOfByte = paramzzb.zzdQ().getBytes();
    localHttpURLConnection.setFixedLengthStreamingMode(arrayOfByte.length);
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localHttpURLConnection.getOutputStream());
    localBufferedOutputStream.write(arrayOfByte);
    localBufferedOutputStream.close();
    label150:
    ArrayList localArrayList = new ArrayList();
    if (localHttpURLConnection.getHeaderFields() != null)
    {
      Iterator localIterator2 = localHttpURLConnection.getHeaderFields().entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator2.next();
        Iterator localIterator3 = ((List)localEntry.getValue()).iterator();
        while (localIterator3.hasNext())
        {
          String str = (String)localIterator3.next();
          localArrayList.add(new zza((String)localEntry.getKey(), str));
        }
      }
    }
    zzc localzzc = new zzc(true, new zzd(paramzzb.zzdN(), localHttpURLConnection.getResponseCode(), localArrayList, zzp.zzbx().zza(new InputStreamReader(localHttpURLConnection.getInputStream()))), null);
    return localzzc;
  }
  
  protected JSONObject zza(zzd paramzzd)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("http_request_id", paramzzd.zzdN());
      if (paramzzd.getBody() != null) {
        localJSONObject.put("body", paramzzd.getBody());
      }
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramzzd.zzdS().iterator();
      while (localIterator.hasNext())
      {
        zza localzza = (zza)localIterator.next();
        localJSONArray.put(new JSONObject().put("key", localzza.getKey()).put("value", localzza.getValue()));
      }
      localJSONObject.put("headers", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      zzb.zzb("Error constructing JSON for http response.", localJSONException);
      return localJSONObject;
    }
    localJSONObject.put("response_code", paramzzd.getResponseCode());
    return localJSONObject;
  }
  
  public void zza(final zzjn paramzzjn, final Map<String, String> paramMap)
  {
    zzio.zza(new Runnable()
    {
      public void run()
      {
        zzb.zzaF("Received Http request.");
        String str = (String)paramMap.get("http_request");
        final JSONObject localJSONObject = zzdm.this.zzV(str);
        if (localJSONObject == null)
        {
          zzb.e("Response should not be null.");
          return;
        }
        zzip.zzKO.post(new Runnable()
        {
          public void run()
          {
            zzdm.1.this.zzyM.zzb("fetchHttpRequestCompleted", localJSONObject);
            zzb.zzaF("Dispatched http response.");
          }
        });
      }
    });
  }
  
  protected zzb zzb(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("http_request_id");
    String str2 = paramJSONObject.optString("url");
    String str3 = paramJSONObject.optString("post_body", null);
    URL localURL;
    ArrayList localArrayList;
    try
    {
      localURL = new URL(str2);
      localArrayList = new ArrayList();
      JSONArray localJSONArray = paramJSONObject.optJSONArray("headers");
      if (localJSONArray == null) {
        localJSONArray = new JSONArray();
      }
      for (int i = 0;; i++)
      {
        if (i >= localJSONArray.length()) {
          break label148;
        }
        localJSONObject = localJSONArray.optJSONObject(i);
        if (localJSONObject != null) {
          break;
        }
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        zzb.zzb("Error constructing http request.", localMalformedURLException);
        localURL = null;
        continue;
        localArrayList.add(new zza(localJSONObject.optString("key"), localJSONObject.optString("value")));
      }
    }
    label148:
    return new zzb(str1, localURL, localArrayList, str3);
  }
  
  @zzha
  static class zza
  {
    private final String mValue;
    private final String zzuX;
    
    public zza(String paramString1, String paramString2)
    {
      this.zzuX = paramString1;
      this.mValue = paramString2;
    }
    
    public String getKey()
    {
      return this.zzuX;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
  }
  
  @zzha
  static class zzb
  {
    private final String zzyQ;
    private final URL zzyR;
    private final ArrayList<zzdm.zza> zzyS;
    private final String zzyT;
    
    public zzb(String paramString1, URL paramURL, ArrayList<zzdm.zza> paramArrayList, String paramString2)
    {
      this.zzyQ = paramString1;
      this.zzyR = paramURL;
      if (paramArrayList == null) {}
      for (this.zzyS = new ArrayList();; this.zzyS = paramArrayList)
      {
        this.zzyT = paramString2;
        return;
      }
    }
    
    public String zzdN()
    {
      return this.zzyQ;
    }
    
    public URL zzdO()
    {
      return this.zzyR;
    }
    
    public ArrayList<zzdm.zza> zzdP()
    {
      return this.zzyS;
    }
    
    public String zzdQ()
    {
      return this.zzyT;
    }
  }
  
  @zzha
  class zzc
  {
    private final zzdm.zzd zzyU;
    private final boolean zzyV;
    private final String zzyW;
    
    public zzc(boolean paramBoolean, zzdm.zzd paramzzd, String paramString)
    {
      this.zzyV = paramBoolean;
      this.zzyU = paramzzd;
      this.zzyW = paramString;
    }
    
    public String getReason()
    {
      return this.zzyW;
    }
    
    public boolean isSuccess()
    {
      return this.zzyV;
    }
    
    public zzdm.zzd zzdR()
    {
      return this.zzyU;
    }
  }
  
  @zzha
  static class zzd
  {
    private final String zzxA;
    private final String zzyQ;
    private final int zzyX;
    private final List<zzdm.zza> zzyY;
    
    public zzd(String paramString1, int paramInt, List<zzdm.zza> paramList, String paramString2)
    {
      this.zzyQ = paramString1;
      this.zzyX = paramInt;
      if (paramList == null) {}
      for (this.zzyY = new ArrayList();; this.zzyY = paramList)
      {
        this.zzxA = paramString2;
        return;
      }
    }
    
    public String getBody()
    {
      return this.zzxA;
    }
    
    public int getResponseCode()
    {
      return this.zzyX;
    }
    
    public String zzdN()
    {
      return this.zzyQ;
    }
    
    public Iterable<zzdm.zza> zzdS()
    {
      return this.zzyY;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzdm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */