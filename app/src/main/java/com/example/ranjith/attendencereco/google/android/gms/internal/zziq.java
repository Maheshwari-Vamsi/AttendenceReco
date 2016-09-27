package com.google.android.gms.internal;

import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.io.File;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;

@zzha
public class zziq
{
  public static zziq zzP(int paramInt)
  {
    if (paramInt >= 19) {
      return new zzg();
    }
    if (paramInt >= 18) {
      return new zze();
    }
    if (paramInt >= 17) {
      return new zzd();
    }
    if (paramInt >= 16) {
      return new zzf();
    }
    if (paramInt >= 14) {
      return new zzc();
    }
    if (paramInt >= 11) {
      return new zzb();
    }
    if (paramInt >= 9) {
      return new zza();
    }
    return new zziq();
  }
  
  public String getDefaultUserAgent(Context paramContext)
  {
    return "";
  }
  
  public boolean isAttachedToWindow(View paramView)
  {
    return (paramView.getWindowToken() != null) || (paramView.getWindowVisibility() != 8);
  }
  
  public Drawable zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
  {
    return new BitmapDrawable(paramContext.getResources(), paramBitmap);
  }
  
  public String zza(SslError paramSslError)
  {
    return "";
  }
  
  public void zza(View paramView, Drawable paramDrawable)
  {
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  public void zza(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramViewTreeObserver.removeGlobalOnLayoutListener(paramOnGlobalLayoutListener);
  }
  
  public boolean zza(DownloadManager.Request paramRequest)
  {
    return false;
  }
  
  public boolean zza(Context paramContext, WebSettings paramWebSettings)
  {
    return false;
  }
  
  public boolean zza(Window paramWindow)
  {
    return false;
  }
  
  public zzjo zzb(zzjn paramzzjn, boolean paramBoolean)
  {
    return new zzjo(paramzzjn, paramBoolean);
  }
  
  public void zzb(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    Window localWindow = paramActivity.getWindow();
    if ((localWindow != null) && (localWindow.getDecorView() != null) && (localWindow.getDecorView().getViewTreeObserver() != null)) {
      zza(localWindow.getDecorView().getViewTreeObserver(), paramOnGlobalLayoutListener);
    }
  }
  
  public Set<String> zzf(Uri paramUri)
  {
    if (paramUri.isOpaque()) {
      return Collections.emptySet();
    }
    String str = paramUri.getEncodedQuery();
    if (str == null) {
      return Collections.emptySet();
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    int i = 0;
    do
    {
      int j = str.indexOf('&', i);
      if (j == -1) {
        j = str.length();
      }
      int k = str.indexOf('=', i);
      if ((k > j) || (k == -1)) {
        k = j;
      }
      localLinkedHashSet.add(Uri.decode(str.substring(i, k)));
      i = j + 1;
    } while (i < str.length());
    return Collections.unmodifiableSet(localLinkedHashSet);
  }
  
  public boolean zzf(zzjn paramzzjn)
  {
    if (paramzzjn == null) {
      return false;
    }
    paramzzjn.onPause();
    return true;
  }
  
  public boolean zzg(zzjn paramzzjn)
  {
    if (paramzzjn == null) {
      return false;
    }
    paramzzjn.onResume();
    return true;
  }
  
  public WebChromeClient zzh(zzjn paramzzjn)
  {
    return null;
  }
  
  public int zzhd()
  {
    return 0;
  }
  
  public int zzhe()
  {
    return 1;
  }
  
  public int zzhf()
  {
    return 5;
  }
  
  public ViewGroup.LayoutParams zzhg()
  {
    return new ViewGroup.LayoutParams(-2, -2);
  }
  
  public boolean zzm(View paramView)
  {
    return false;
  }
  
  public boolean zzn(View paramView)
  {
    return false;
  }
  
  public static class zza
    extends zziq
  {
    public zza()
    {
      super();
    }
    
    public boolean zza(DownloadManager.Request paramRequest)
    {
      paramRequest.setShowRunningNotification(true);
      return true;
    }
    
    public int zzhd()
    {
      return 6;
    }
    
    public int zzhe()
    {
      return 7;
    }
  }
  
  public static class zzb
    extends zziq.zza
  {
    public boolean zza(DownloadManager.Request paramRequest)
    {
      paramRequest.allowScanningByMediaScanner();
      paramRequest.setNotificationVisibility(1);
      return true;
    }
    
    public boolean zza(final Context paramContext, WebSettings paramWebSettings)
    {
      super.zza(paramContext, paramWebSettings);
      if ((File)zziz.zzb(new Callable()
      {
        public File zzhh()
        {
          return paramContext.getCacheDir();
        }
      }) != null)
      {
        paramWebSettings.setAppCachePath(paramContext.getCacheDir().getAbsolutePath());
        paramWebSettings.setAppCacheMaxSize(0L);
        paramWebSettings.setAppCacheEnabled(true);
      }
      paramWebSettings.setDatabasePath(paramContext.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
      paramWebSettings.setDatabaseEnabled(true);
      paramWebSettings.setDomStorageEnabled(true);
      paramWebSettings.setDisplayZoomControls(false);
      paramWebSettings.setBuiltInZoomControls(true);
      paramWebSettings.setSupportZoom(true);
      paramWebSettings.setAllowContentAccess(false);
      return true;
    }
    
    public boolean zza(Window paramWindow)
    {
      paramWindow.setFlags(16777216, 16777216);
      return true;
    }
    
    public zzjo zzb(zzjn paramzzjn, boolean paramBoolean)
    {
      return new zzju(paramzzjn, paramBoolean);
    }
    
    public Set<String> zzf(Uri paramUri)
    {
      return paramUri.getQueryParameterNames();
    }
    
    public WebChromeClient zzh(zzjn paramzzjn)
    {
      return new zzjt(paramzzjn);
    }
    
    public boolean zzm(View paramView)
    {
      paramView.setLayerType(0, null);
      return true;
    }
    
    public boolean zzn(View paramView)
    {
      paramView.setLayerType(1, null);
      return true;
    }
  }
  
  public static class zzc
    extends zziq.zzb
  {
    public String zza(SslError paramSslError)
    {
      return paramSslError.getUrl();
    }
    
    public WebChromeClient zzh(zzjn paramzzjn)
    {
      return new zzjv(paramzzjn);
    }
  }
  
  public static class zzd
    extends zziq.zzf
  {
    public String getDefaultUserAgent(Context paramContext)
    {
      return WebSettings.getDefaultUserAgent(paramContext);
    }
    
    public Drawable zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
    {
      if ((!paramBoolean) || (paramFloat <= 0.0F) || (paramFloat > 25.0F)) {
        return new BitmapDrawable(paramContext.getResources(), paramBitmap);
      }
      try
      {
        Bitmap localBitmap1 = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight(), false);
        Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1);
        RenderScript localRenderScript = RenderScript.create(paramContext);
        ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create(localRenderScript, Element.U8_4(localRenderScript));
        Allocation localAllocation1 = Allocation.createFromBitmap(localRenderScript, localBitmap1);
        Allocation localAllocation2 = Allocation.createFromBitmap(localRenderScript, localBitmap2);
        localScriptIntrinsicBlur.setRadius(paramFloat);
        localScriptIntrinsicBlur.setInput(localAllocation1);
        localScriptIntrinsicBlur.forEach(localAllocation2);
        localAllocation2.copyTo(localBitmap2);
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramContext.getResources(), localBitmap2);
        return localBitmapDrawable;
      }
      catch (RuntimeException localRuntimeException) {}
      return new BitmapDrawable(paramContext.getResources(), paramBitmap);
    }
    
    public boolean zza(Context paramContext, WebSettings paramWebSettings)
    {
      super.zza(paramContext, paramWebSettings);
      paramWebSettings.setMediaPlaybackRequiresUserGesture(false);
      return true;
    }
  }
  
  public static class zze
    extends zziq.zzd
  {
    public boolean isAttachedToWindow(View paramView)
    {
      return (super.isAttachedToWindow(paramView)) || (paramView.getWindowId() != null);
    }
    
    public int zzhf()
    {
      return 14;
    }
  }
  
  public static class zzf
    extends zziq.zzc
  {
    public void zza(View paramView, Drawable paramDrawable)
    {
      paramView.setBackground(paramDrawable);
    }
    
    public void zza(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
    {
      paramViewTreeObserver.removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
    }
    
    public boolean zza(Context paramContext, WebSettings paramWebSettings)
    {
      super.zza(paramContext, paramWebSettings);
      paramWebSettings.setAllowFileAccessFromFileURLs(false);
      paramWebSettings.setAllowUniversalAccessFromFileURLs(false);
      return true;
    }
    
    public void zzb(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
    {
      Window localWindow = paramActivity.getWindow();
      if ((localWindow != null) && (localWindow.getDecorView() != null) && (localWindow.getDecorView().getViewTreeObserver() != null)) {
        zza(localWindow.getDecorView().getViewTreeObserver(), paramOnGlobalLayoutListener);
      }
    }
  }
  
  public static class zzg
    extends zziq.zze
  {
    public boolean isAttachedToWindow(View paramView)
    {
      return paramView.isAttachedToWindow();
    }
    
    public ViewGroup.LayoutParams zzhg()
    {
      return new ViewGroup.LayoutParams(-1, -1);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zziq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */