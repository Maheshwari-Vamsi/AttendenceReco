package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzdl;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzjo.zza;
import com.google.android.gms.internal.zzjp;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzh
{
  private final Context mContext;
  private final VersionInfoParcel zzpI;
  private final Object zzpK = new Object();
  private zzjn zzps;
  private final zzn zzxP;
  private final JSONObject zzxS;
  private final zzbb zzxT;
  private final zza zzxU;
  private final zzan zzxV;
  private boolean zzxW;
  private String zzxX;
  private WeakReference<View> zzxY = null;
  
  public zzh(Context paramContext, zzn paramzzn, zzbb paramzzbb, zzan paramzzan, JSONObject paramJSONObject, zza paramzza, VersionInfoParcel paramVersionInfoParcel)
  {
    this.mContext = paramContext;
    this.zzxP = paramzzn;
    this.zzxT = paramzzbb;
    this.zzxV = paramzzan;
    this.zzxS = paramJSONObject;
    this.zzxU = paramzza;
    this.zzpI = paramVersionInfoParcel;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public void recordImpression()
  {
    zzx.zzcx("recordImpression must be called on the main UI thread.");
    zzn(true);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ad", this.zzxS);
      this.zzxT.zza("google.afma.nativeAds.handleImpressionPing", localJSONObject);
      this.zzxP.zza(this);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzb("Unable to create impression JSON.", localJSONException);
      }
    }
  }
  
  public zzb zza(View.OnClickListener paramOnClickListener)
  {
    zza localzza = this.zzxU.zzdG();
    if (localzza == null) {
      return null;
    }
    zzb localzzb = new zzb(this.mContext, localzza);
    localzzb.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localzzb.zzdB().setOnClickListener(paramOnClickListener);
    localzzb.zzdB().setContentDescription("Ad attribution icon");
    return localzzb;
  }
  
  public void zza(View paramView, Map<String, WeakReference<View>> paramMap, JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONObject paramJSONObject3)
  {
    zzx.zzcx("performClick must be called on the main UI thread.");
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramView.equals((View)((WeakReference)localEntry.getValue()).get())) {
        zza((String)localEntry.getKey(), paramJSONObject1, paramJSONObject2, paramJSONObject3);
      }
    }
  }
  
  public void zza(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONObject paramJSONObject3)
  {
    zzx.zzcx("performClick must be called on the main UI thread.");
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("asset", paramString);
      localJSONObject1.put("template", this.zzxU.zzdF());
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("ad", this.zzxS);
      localJSONObject2.put("click", localJSONObject1);
      if (this.zzxP.zzr(this.zzxU.getCustomTemplateId()) != null) {}
      for (boolean bool = true;; bool = false)
      {
        localJSONObject2.put("has_custom_click_handler", bool);
        if (paramJSONObject1 != null) {
          localJSONObject2.put("view_rectangles", paramJSONObject1);
        }
        if (paramJSONObject2 != null) {
          localJSONObject2.put("click_point", paramJSONObject2);
        }
        if (paramJSONObject3 != null) {
          localJSONObject2.put("native_view_rectangle", paramJSONObject3);
        }
        this.zzxT.zza("google.afma.nativeAds.handleClickGmsg", localJSONObject2);
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzb("Unable to create click JSON.", localJSONException);
    }
  }
  
  public void zzb(MotionEvent paramMotionEvent)
  {
    this.zzxV.zza(paramMotionEvent);
  }
  
  public zzjn zzdK()
  {
    this.zzps = zzdM();
    this.zzps.getView().setVisibility(8);
    this.zzxT.zza("/loadHtml", new zzdl()
    {
      public void zza(zzjn paramAnonymouszzjn, final Map<String, String> paramAnonymousMap)
      {
        zzh.zzf(zzh.this).zzhC().zza(new zzjo.zza()
        {
          public void zza(zzjn paramAnonymous2zzjn, boolean paramAnonymous2Boolean)
          {
            zzh.zza(zzh.this, (String)paramAnonymousMap.get("id"));
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("messageType", "htmlLoaded");
              localJSONObject.put("id", zzh.zzd(zzh.this));
              zzh.zze(zzh.this).zzb("sendMessageToNativeJs", localJSONObject);
              return;
            }
            catch (JSONException localJSONException)
            {
              com.google.android.gms.ads.internal.util.client.zzb.zzb("Unable to dispatch sendMessageToNativeJsevent", localJSONException);
            }
          }
        });
        String str1 = (String)paramAnonymousMap.get("overlayHtml");
        String str2 = (String)paramAnonymousMap.get("baseUrl");
        if (TextUtils.isEmpty(str2))
        {
          zzh.zzf(zzh.this).loadData(str1, "text/html", "UTF-8");
          return;
        }
        zzh.zzf(zzh.this).loadDataWithBaseURL(str2, str1, "text/html", "UTF-8", null);
      }
    });
    this.zzxT.zza("/showOverlay", new zzdl()
    {
      public void zza(zzjn paramAnonymouszzjn, Map<String, String> paramAnonymousMap)
      {
        zzh.zzf(zzh.this).getView().setVisibility(0);
      }
    });
    this.zzxT.zza("/hideOverlay", new zzdl()
    {
      public void zza(zzjn paramAnonymouszzjn, Map<String, String> paramAnonymousMap)
      {
        zzh.zzf(zzh.this).getView().setVisibility(8);
      }
    });
    this.zzps.zzhC().zza("/hideOverlay", new zzdl()
    {
      public void zza(zzjn paramAnonymouszzjn, Map<String, String> paramAnonymousMap)
      {
        zzh.zzf(zzh.this).getView().setVisibility(8);
      }
    });
    this.zzps.zzhC().zza("/sendMessageToSdk", new zzdl()
    {
      public void zza(zzjn paramAnonymouszzjn, Map<String, String> paramAnonymousMap)
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          Iterator localIterator = paramAnonymousMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject.put(str, paramAnonymousMap.get(str));
          }
          localJSONObject.put("id", zzh.zzd(zzh.this));
        }
        catch (JSONException localJSONException)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzb("Unable to dispatch sendMessageToNativeJs event", localJSONException);
          return;
        }
        zzh.zze(zzh.this).zzb("sendMessageToNativeJs", localJSONObject);
      }
    });
    return this.zzps;
  }
  
  public View zzdL()
  {
    if (this.zzxY != null) {
      return (View)this.zzxY.get();
    }
    return null;
  }
  
  zzjn zzdM()
  {
    return zzp.zzby().zza(this.mContext, AdSizeParcel.zzt(this.mContext), false, false, this.zzxV, this.zzpI);
  }
  
  public void zzh(View paramView) {}
  
  public void zzi(View paramView)
  {
    synchronized (this.zzpK)
    {
      if (this.zzxW) {
        return;
      }
      if (!paramView.isShown()) {
        return;
      }
    }
    if (!paramView.getGlobalVisibleRect(new Rect(), null)) {
      return;
    }
    recordImpression();
  }
  
  public void zzj(View paramView)
  {
    this.zzxY = new WeakReference(paramView);
  }
  
  protected void zzn(boolean paramBoolean)
  {
    this.zzxW = paramBoolean;
  }
  
  public static abstract interface zza
  {
    public abstract String getCustomTemplateId();
    
    public abstract void zzb(zzh paramzzh);
    
    public abstract String zzdF();
    
    public abstract zza zzdG();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\formats\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */