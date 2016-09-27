package com.google.android.gms.ads.internal.formats;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcp.zza;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzjn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzj
  extends zzcp.zza
  implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private FrameLayout zzoF;
  private final Object zzpK = new Object();
  private zzh zzxH;
  private final FrameLayout zzyf;
  private Map<String, WeakReference<View>> zzyg = new HashMap();
  private zzb zzyh;
  boolean zzyi = false;
  int zzyj;
  int zzyk;
  
  public zzj(FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2)
  {
    this.zzyf = paramFrameLayout1;
    this.zzoF = paramFrameLayout2;
    zzji.zza(this.zzyf, this);
    zzji.zza(this.zzyf, this);
    this.zzyf.setOnTouchListener(this);
  }
  
  public void destroy()
  {
    this.zzoF.removeAllViews();
    this.zzoF = null;
    this.zzyg = null;
    this.zzyh = null;
    this.zzxH = null;
  }
  
  int getMeasuredHeight()
  {
    return this.zzyf.getMeasuredHeight();
  }
  
  int getMeasuredWidth()
  {
    return this.zzyf.getMeasuredWidth();
  }
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject1;
    synchronized (this.zzpK)
    {
      if (this.zzxH == null) {
        return;
      }
      localJSONObject1 = new JSONObject();
      Iterator localIterator = this.zzyg.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          View localView = (View)((WeakReference)localEntry.getValue()).get();
          Point localPoint = zzk(localView);
          JSONObject localJSONObject4 = new JSONObject();
          try
          {
            localJSONObject4.put("width", zzq(localView.getWidth()));
            localJSONObject4.put("height", zzq(localView.getHeight()));
            localJSONObject4.put("x", zzq(localPoint.x));
            localJSONObject4.put("y", zzq(localPoint.y));
            localJSONObject1.put((String)localEntry.getKey(), localJSONObject4);
          }
          catch (JSONException localJSONException3)
          {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Unable to get view rectangle for view " + (String)localEntry.getKey());
          }
        }
      }
    }
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("x", zzq(this.zzyj));
      localJSONObject2.put("y", zzq(this.zzyk));
      localJSONObject3 = new JSONObject();
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        localJSONObject3.put("width", zzq(getMeasuredWidth()));
        localJSONObject3.put("height", zzq(getMeasuredHeight()));
        if ((this.zzyh != null) && (this.zzyh.zzdB().equals(paramView)))
        {
          this.zzxH.zza("1007", localJSONObject1, localJSONObject2, localJSONObject3);
          return;
          localJSONException1 = localJSONException1;
          com.google.android.gms.ads.internal.util.client.zzb.zzaH("Unable to get click location");
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          JSONObject localJSONObject3;
          com.google.android.gms.ads.internal.util.client.zzb.zzaH("Unable to get native ad view bounding box");
          continue;
          this.zzxH.zza(paramView, this.zzyg, localJSONObject1, localJSONObject2, localJSONObject3);
        }
      }
    }
  }
  
  public void onGlobalLayout()
  {
    synchronized (this.zzpK)
    {
      if (this.zzyi)
      {
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if ((i != 0) && (j != 0))
        {
          this.zzoF.setLayoutParams(new FrameLayout.LayoutParams(i, j));
          this.zzyi = false;
        }
      }
      if (this.zzxH != null) {
        this.zzxH.zzi(this.zzyf);
      }
      return;
    }
  }
  
  public void onScrollChanged()
  {
    synchronized (this.zzpK)
    {
      if (this.zzxH != null) {
        this.zzxH.zzi(this.zzyf);
      }
      return;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    synchronized (this.zzpK)
    {
      if (this.zzxH == null) {
        return false;
      }
      Point localPoint = zzc(paramMotionEvent);
      this.zzyj = localPoint.x;
      this.zzyk = localPoint.y;
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      localMotionEvent.setLocation(localPoint.x, localPoint.y);
      this.zzxH.zzb(localMotionEvent);
      localMotionEvent.recycle();
      return false;
    }
  }
  
  public zzd zzU(String paramString)
  {
    synchronized (this.zzpK)
    {
      WeakReference localWeakReference = (WeakReference)this.zzyg.get(paramString);
      if (localWeakReference == null)
      {
        localObject3 = null;
        zzd localzzd = zze.zzB(localObject3);
        return localzzd;
      }
      Object localObject3 = (View)localWeakReference.get();
    }
  }
  
  public void zza(String paramString, zzd paramzzd)
  {
    View localView = (View)zze.zzp(paramzzd);
    localObject1 = this.zzpK;
    if (localView == null) {}
    for (;;)
    {
      try
      {
        this.zzyg.remove(paramString);
        return;
      }
      finally {}
      this.zzyg.put(paramString, new WeakReference(localView));
      localView.setOnTouchListener(this);
      localView.setOnClickListener(this);
    }
  }
  
  public void zzb(zzd paramzzd)
  {
    synchronized (this.zzpK)
    {
      this.zzyi = true;
      zzj(null);
      final zzh localzzh = (zzh)zze.zzp(paramzzd);
      if (((this.zzxH instanceof zzg)) && (((zzg)this.zzxH).zzdI())) {
        ((zzg)this.zzxH).zzc(localzzh);
      }
      do
      {
        this.zzoF.removeAllViews();
        this.zzyh = zzg(localzzh);
        if (this.zzyh != null)
        {
          this.zzyg.put("1007", new WeakReference(this.zzyh.zzdB()));
          this.zzoF.addView(this.zzyh);
        }
        zzip.zzKO.post(new Runnable()
        {
          public void run()
          {
            zzjn localzzjn = localzzh.zzdK();
            if (localzzjn != null) {
              zzj.zza(zzj.this).addView(localzzjn.getView());
            }
          }
        });
        localzzh.zzh(this.zzyf);
        zzj(this.zzyf);
        return;
        this.zzxH = localzzh;
      } while (!(this.zzxH instanceof zzg));
      ((zzg)this.zzxH).zzc(null);
    }
  }
  
  Point zzc(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    this.zzyf.getLocationOnScreen(arrayOfInt);
    float f1 = paramMotionEvent.getRawX() - arrayOfInt[0];
    float f2 = paramMotionEvent.getRawY() - arrayOfInt[1];
    return new Point((int)f1, (int)f2);
  }
  
  zzb zzg(zzh paramzzh)
  {
    return paramzzh.zza(this);
  }
  
  void zzj(View paramView)
  {
    if (this.zzxH != null) {
      if (!(this.zzxH instanceof zzg)) {
        break label38;
      }
    }
    label38:
    for (zzh localzzh = ((zzg)this.zzxH).zzdJ();; localzzh = this.zzxH)
    {
      if (localzzh != null) {
        localzzh.zzj(paramView);
      }
      return;
    }
  }
  
  Point zzk(View paramView)
  {
    if ((this.zzyh != null) && (this.zzyh.zzdB().equals(paramView)))
    {
      Point localPoint2 = new Point();
      this.zzyf.getGlobalVisibleRect(new Rect(), localPoint2);
      Point localPoint3 = new Point();
      paramView.getGlobalVisibleRect(new Rect(), localPoint3);
      return new Point(localPoint3.x - localPoint2.x, localPoint3.y - localPoint2.y);
    }
    Point localPoint1 = new Point();
    paramView.getGlobalVisibleRect(new Rect(), localPoint1);
    return localPoint1;
  }
  
  int zzq(int paramInt)
  {
    return zzl.zzcN().zzc(this.zzxH.getContext(), paramInt);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\formats\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */