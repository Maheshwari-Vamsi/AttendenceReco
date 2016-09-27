package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.internal.client.zzz;

public final class PublisherAdView
  extends ViewGroup
{
  private final zzz zzoy;
  
  public PublisherAdView(Context paramContext)
  {
    super(paramContext);
    this.zzoy = new zzz(this);
  }
  
  public PublisherAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.zzoy = new zzz(this, paramAttributeSet, true);
  }
  
  public PublisherAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.zzoy = new zzz(this, paramAttributeSet, true);
  }
  
  public void destroy()
  {
    this.zzoy.destroy();
  }
  
  public AdListener getAdListener()
  {
    return this.zzoy.getAdListener();
  }
  
  public AdSize getAdSize()
  {
    return this.zzoy.getAdSize();
  }
  
  public AdSize[] getAdSizes()
  {
    return this.zzoy.getAdSizes();
  }
  
  public String getAdUnitId()
  {
    return this.zzoy.getAdUnitId();
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.zzoy.getAppEventListener();
  }
  
  public String getMediationAdapterClassName()
  {
    return this.zzoy.getMediationAdapterClassName();
  }
  
  public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return this.zzoy.getOnCustomRenderedAdLoadedListener();
  }
  
  public boolean isLoading()
  {
    return this.zzoy.isLoading();
  }
  
  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    this.zzoy.zza(paramPublisherAdRequest.zzaG());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      int i = localView.getMeasuredWidth();
      int j = localView.getMeasuredHeight();
      int k = (paramInt3 - paramInt1 - i) / 2;
      int m = (paramInt4 - paramInt2 - j) / 2;
      localView.layout(k, m, i + k, j + m);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = getChildAt(0);
    int j;
    int i;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      measureChild(localView, paramInt1, paramInt2);
      j = localView.getMeasuredWidth();
      i = localView.getMeasuredHeight();
    }
    for (;;)
    {
      int k = Math.max(j, getSuggestedMinimumWidth());
      int m = Math.max(i, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSize(k, paramInt1), View.resolveSize(m, paramInt2));
      return;
      AdSize localAdSize = getAdSize();
      if (localAdSize != null)
      {
        Context localContext = getContext();
        j = localAdSize.getWidthInPixels(localContext);
        i = localAdSize.getHeightInPixels(localContext);
      }
      else
      {
        i = 0;
        j = 0;
      }
    }
  }
  
  public void pause()
  {
    this.zzoy.pause();
  }
  
  public void recordManualImpression()
  {
    this.zzoy.recordManualImpression();
  }
  
  public void resume()
  {
    this.zzoy.resume();
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.zzoy.setAdListener(paramAdListener);
  }
  
  public void setAdSizes(AdSize... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 1)) {
      throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
    }
    this.zzoy.zza(paramVarArgs);
  }
  
  public void setAdUnitId(String paramString)
  {
    this.zzoy.setAdUnitId(paramString);
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    this.zzoy.setAppEventListener(paramAppEventListener);
  }
  
  public void setCorrelator(Correlator paramCorrelator)
  {
    this.zzoy.setCorrelator(paramCorrelator);
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    this.zzoy.setManualImpressionsEnabled(paramBoolean);
  }
  
  public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    this.zzoy.setOnCustomRenderedAdLoadedListener(paramOnCustomRenderedAdLoadedListener);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\doubleclick\PublisherAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */