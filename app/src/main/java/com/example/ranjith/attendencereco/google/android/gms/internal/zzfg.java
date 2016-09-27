package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzha
public class zzfg
  extends zzfb.zza
{
  private final NativeContentAdMapper zzBN;
  
  public zzfg(NativeContentAdMapper paramNativeContentAdMapper)
  {
    this.zzBN = paramNativeContentAdMapper;
  }
  
  public String getAdvertiser()
  {
    return this.zzBN.getAdvertiser();
  }
  
  public String getBody()
  {
    return this.zzBN.getBody();
  }
  
  public String getCallToAction()
  {
    return this.zzBN.getCallToAction();
  }
  
  public Bundle getExtras()
  {
    return this.zzBN.getExtras();
  }
  
  public String getHeadline()
  {
    return this.zzBN.getHeadline();
  }
  
  public List getImages()
  {
    List localList = this.zzBN.getImages();
    if (localList != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        NativeAd.Image localImage = (NativeAd.Image)localIterator.next();
        localArrayList.add(new zzc(localImage.getDrawable(), localImage.getUri(), localImage.getScale()));
      }
      return localArrayList;
    }
    return null;
  }
  
  public boolean getOverrideClickHandling()
  {
    return this.zzBN.getOverrideClickHandling();
  }
  
  public boolean getOverrideImpressionRecording()
  {
    return this.zzBN.getOverrideImpressionRecording();
  }
  
  public void recordImpression()
  {
    this.zzBN.recordImpression();
  }
  
  public void zzc(zzd paramzzd)
  {
    this.zzBN.handleClick((View)zze.zzp(paramzzd));
  }
  
  public void zzd(zzd paramzzd)
  {
    this.zzBN.trackView((View)zze.zzp(paramzzd));
  }
  
  public zzcn zzdH()
  {
    NativeAd.Image localImage = this.zzBN.getLogo();
    if (localImage != null) {
      return new zzc(localImage.getDrawable(), localImage.getUri(), localImage.getScale());
    }
    return null;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */