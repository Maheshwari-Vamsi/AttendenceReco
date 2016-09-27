package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
class zzjr
  extends WebView
  implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzjn
{
  private AdSizeParcel zzBh;
  private int zzCC = -1;
  private int zzCD = -1;
  private int zzCF = -1;
  private int zzCG = -1;
  private String zzDX = "";
  private Boolean zzKh;
  private boolean zzMA;
  private boolean zzMB;
  private boolean zzMC;
  private int zzMD;
  private boolean zzME = true;
  private zzcf zzMF;
  private zzcf zzMG;
  private zzcf zzMH;
  private zzcg zzMI;
  private com.google.android.gms.ads.internal.overlay.zzd zzMJ;
  private Map<String, zzdw> zzMK;
  private final zza zzMw;
  private zzjo zzMx;
  private com.google.android.gms.ads.internal.overlay.zzd zzMy;
  private boolean zzMz;
  private final VersionInfoParcel zzpI;
  private final Object zzpK = new Object();
  private final com.google.android.gms.ads.internal.zzd zzpc;
  private final WindowManager zzrR;
  private zzja zzrz;
  private final zzan zzxV;
  
  protected zzjr(zza paramzza, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, zzan paramzzan, VersionInfoParcel paramVersionInfoParcel, zzch paramzzch, com.google.android.gms.ads.internal.zzd paramzzd)
  {
    super(paramzza);
    this.zzMw = paramzza;
    this.zzBh = paramAdSizeParcel;
    this.zzMB = paramBoolean1;
    this.zzMD = -1;
    this.zzxV = paramzzan;
    this.zzpI = paramVersionInfoParcel;
    this.zzpc = paramzzd;
    this.zzrR = ((WindowManager)getContext().getSystemService("window"));
    setBackgroundColor(0);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setAllowFileAccess(false);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setSavePassword(false);
    localWebSettings.setSupportMultipleWindows(true);
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    if (Build.VERSION.SDK_INT >= 21) {
      localWebSettings.setMixedContentMode(0);
    }
    zzp.zzbx().zza(paramzza, paramVersionInfoParcel.afmaVersion, localWebSettings);
    zzp.zzbz().zza(getContext(), localWebSettings);
    setDownloadListener(this);
    zzhY();
    if (zznx.zzrS()) {
      addJavascriptInterface(new zzjs(this), "googleAdsJsInterface");
    }
    this.zzrz = new zzja(this.zzMw.zzhx(), this, null);
    zzd(paramzzch);
  }
  
  static zzjr zzb(Context paramContext, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, zzan paramzzan, VersionInfoParcel paramVersionInfoParcel, zzch paramzzch, com.google.android.gms.ads.internal.zzd paramzzd)
  {
    return new zzjr(new zza(paramContext), paramAdSizeParcel, paramBoolean1, paramBoolean2, paramzzan, paramVersionInfoParcel, paramzzch, paramzzd);
  }
  
  private void zzd(zzch paramzzch)
  {
    zzic();
    this.zzMI = new zzcg(new zzch(true, "make_wv", this.zzBh.zztV));
    this.zzMI.zzdt().zzc(paramzzch);
    this.zzMG = zzcd.zzb(this.zzMI.zzdt());
    this.zzMI.zza("native:view_create", this.zzMG);
    this.zzMH = null;
    this.zzMF = null;
  }
  
  private void zzhW()
  {
    synchronized (this.zzpK)
    {
      this.zzKh = zzp.zzbA().zzgQ();
      Boolean localBoolean = this.zzKh;
      if (localBoolean == null) {}
      try
      {
        evaluateJavascript("(function(){})()", null);
        zzb(Boolean.valueOf(true));
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          zzb(Boolean.valueOf(false));
        }
      }
    }
  }
  
  private void zzhX()
  {
    zzcd.zza(this.zzMI.zzdt(), this.zzMF, new String[] { "aeh" });
  }
  
  private void zzhY()
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if ((this.zzMB) || (this.zzBh.zztW))
        {
          if (Build.VERSION.SDK_INT < 14)
          {
            zzb.zzaF("Disabling hardware acceleration on an overlay.");
            zzhZ();
            return;
          }
          zzb.zzaF("Enabling hardware acceleration on an overlay.");
          zzia();
        }
      }
      if (Build.VERSION.SDK_INT < 18)
      {
        zzb.zzaF("Disabling hardware acceleration on an AdView.");
        zzhZ();
      }
      else
      {
        zzb.zzaF("Enabling hardware acceleration on an AdView.");
        zzia();
      }
    }
  }
  
  private void zzhZ()
  {
    synchronized (this.zzpK)
    {
      if (!this.zzMC) {
        zzp.zzbz().zzn(this);
      }
      this.zzMC = true;
      return;
    }
  }
  
  private void zzia()
  {
    synchronized (this.zzpK)
    {
      if (this.zzMC) {
        zzp.zzbz().zzm(this);
      }
      this.zzMC = false;
      return;
    }
  }
  
  private void zzib()
  {
    synchronized (this.zzpK)
    {
      if (this.zzMK != null)
      {
        Iterator localIterator = this.zzMK.values().iterator();
        if (localIterator.hasNext()) {
          ((zzdw)localIterator.next()).release();
        }
      }
    }
  }
  
  private void zzic()
  {
    if (this.zzMI == null) {}
    zzch localzzch;
    do
    {
      return;
      localzzch = this.zzMI.zzdt();
    } while ((localzzch == null) || (zzp.zzbA().zzgM() == null));
    zzp.zzbA().zzgM().zza(localzzch);
  }
  
  public void destroy()
  {
    synchronized (this.zzpK)
    {
      zzic();
      this.zzrz.zzhn();
      if (this.zzMy != null)
      {
        this.zzMy.close();
        this.zzMy.onDestroy();
        this.zzMy = null;
      }
      this.zzMx.reset();
      if (this.zzMA) {
        return;
      }
      zzp.zzbL().zza(this);
      zzib();
      this.zzMA = true;
      zzb.v("Initiating WebView self destruct sequence in 3...");
      this.zzMx.zzhQ();
      return;
    }
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    synchronized (this.zzpK)
    {
      if (isDestroyed())
      {
        zzb.zzaH("The webview is destroyed. Ignoring action.");
        if (paramValueCallback != null) {
          paramValueCallback.onReceiveValue(null);
        }
        return;
      }
      super.evaluateJavascript(paramString, paramValueCallback);
      return;
    }
  }
  
  public String getRequestId()
  {
    synchronized (this.zzpK)
    {
      String str = this.zzDX;
      return str;
    }
  }
  
  public int getRequestedOrientation()
  {
    synchronized (this.zzpK)
    {
      int i = this.zzMD;
      return i;
    }
  }
  
  public View getView()
  {
    return this;
  }
  
  public WebView getWebView()
  {
    return this;
  }
  
  public boolean isDestroyed()
  {
    synchronized (this.zzpK)
    {
      boolean bool = this.zzMA;
      return bool;
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    synchronized (this.zzpK)
    {
      if (!isDestroyed())
      {
        super.loadData(paramString1, paramString2, paramString3);
        return;
      }
      zzb.zzaH("The webview is destroyed. Ignoring action.");
    }
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    synchronized (this.zzpK)
    {
      if (!isDestroyed())
      {
        super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
        return;
      }
      zzb.zzaH("The webview is destroyed. Ignoring action.");
    }
  }
  
  public void loadUrl(String paramString)
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        boolean bool = isDestroyed();
        if (!bool) {
          try
          {
            super.loadUrl(paramString);
            return;
          }
          catch (Throwable localThrowable)
          {
            zzb.zzaH("Could not call loadUrl. " + localThrowable);
            continue;
          }
        }
      }
      zzb.zzaH("The webview is destroyed. Ignoring action.");
    }
  }
  
  protected void onAttachedToWindow()
  {
    synchronized (this.zzpK)
    {
      super.onAttachedToWindow();
      if (!isDestroyed()) {
        this.zzrz.onAttachedToWindow();
      }
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    synchronized (this.zzpK)
    {
      if (!isDestroyed()) {
        this.zzrz.onDetachedFromWindow();
      }
      super.onDetachedFromWindow();
      return;
    }
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setDataAndType(Uri.parse(paramString1), paramString4);
      zzp.zzbx().zzb(getContext(), localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      zzb.zzaF("Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (isDestroyed()) {}
    while ((Build.VERSION.SDK_INT == 21) && (paramCanvas.isHardwareAccelerated()) && (!isAttachedToWindow())) {
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onGlobalLayout()
  {
    boolean bool = zzhV();
    com.google.android.gms.ads.internal.overlay.zzd localzzd = zzhA();
    if ((localzzd != null) && (bool)) {
      localzzd.zzff();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = Integer.MAX_VALUE;
    synchronized (this.zzpK)
    {
      if (isDestroyed())
      {
        setMeasuredDimension(0, 0);
        return;
      }
      if ((isInEditMode()) || (this.zzMB) || (this.zzBh.zztY) || (this.zzBh.zztZ))
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
    }
    if (this.zzBh.zztW)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      this.zzrR.getDefaultDisplay().getMetrics(localDisplayMetrics);
      setMeasuredDimension(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
      return;
    }
    int j = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int n = View.MeasureSpec.getSize(paramInt2);
    if (j != Integer.MIN_VALUE) {
      if (j == 1073741824) {
        break label372;
      }
    }
    for (;;)
    {
      if ((this.zzBh.widthPixels > i1) || (this.zzBh.heightPixels > i))
      {
        float f = this.zzMw.getResources().getDisplayMetrics().density;
        zzb.zzaH("Not enough space to show ad. Needs " + (int)(this.zzBh.widthPixels / f) + "x" + (int)(this.zzBh.heightPixels / f) + " dp, but only has " + (int)(k / f) + "x" + (int)(n / f) + " dp.");
        if (getVisibility() != 8) {
          setVisibility(4);
        }
        setMeasuredDimension(0, 0);
      }
      for (;;)
      {
        return;
        if (getVisibility() != 8) {
          setVisibility(0);
        }
        setMeasuredDimension(this.zzBh.widthPixels, this.zzBh.heightPixels);
      }
      int i1 = i;
      break label376;
      label372:
      i1 = k;
      label376:
      if ((m == Integer.MIN_VALUE) || (m == 1073741824)) {
        i = n;
      }
    }
  }
  
  public void onPause()
  {
    if (isDestroyed()) {}
    for (;;)
    {
      return;
      try
      {
        if (zznx.zzrN())
        {
          super.onPause();
          return;
        }
      }
      catch (Exception localException)
      {
        zzb.zzb("Could not pause webview.", localException);
      }
    }
  }
  
  public void onResume()
  {
    if (isDestroyed()) {}
    for (;;)
    {
      return;
      try
      {
        if (zznx.zzrN())
        {
          super.onResume();
          return;
        }
      }
      catch (Exception localException)
      {
        zzb.zzb("Could not resume webview.", localException);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.zzxV != null) {
      this.zzxV.zza(paramMotionEvent);
    }
    if (isDestroyed()) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setContext(Context paramContext)
  {
    this.zzMw.setBaseContext(paramContext);
    this.zzrz.zzk(this.zzMw.zzhx());
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    synchronized (this.zzpK)
    {
      this.zzMD = paramInt;
      if (this.zzMy != null) {
        this.zzMy.setRequestedOrientation(this.zzMD);
      }
      return;
    }
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    super.setWebViewClient(paramWebViewClient);
    if ((paramWebViewClient instanceof zzjo)) {
      this.zzMx = ((zzjo)paramWebViewClient);
    }
  }
  
  public void stopLoading()
  {
    if (isDestroyed()) {
      return;
    }
    try
    {
      super.stopLoading();
      return;
    }
    catch (Exception localException)
    {
      zzb.zzb("Could not stop loading webview.", localException);
    }
  }
  
  public void zzD(boolean paramBoolean)
  {
    synchronized (this.zzpK)
    {
      this.zzMB = paramBoolean;
      zzhY();
      return;
    }
  }
  
  public void zzE(boolean paramBoolean)
  {
    synchronized (this.zzpK)
    {
      if (this.zzMy != null)
      {
        this.zzMy.zza(this.zzMx.zzcb(), paramBoolean);
        return;
      }
      this.zzMz = paramBoolean;
    }
  }
  
  public void zzF(boolean paramBoolean)
  {
    synchronized (this.zzpK)
    {
      this.zzME = paramBoolean;
      return;
    }
  }
  
  public void zza(Context paramContext, AdSizeParcel paramAdSizeParcel, zzch paramzzch)
  {
    synchronized (this.zzpK)
    {
      this.zzrz.zzhn();
      setContext(paramContext);
      this.zzMy = null;
      this.zzBh = paramAdSizeParcel;
      this.zzMB = false;
      this.zzMz = false;
      this.zzDX = "";
      this.zzMD = -1;
      zzp.zzbz().zzg(this);
      loadUrl("about:blank");
      this.zzMx.reset();
      setOnTouchListener(null);
      setOnClickListener(null);
      this.zzME = true;
      zzd(paramzzch);
      return;
    }
  }
  
  public void zza(AdSizeParcel paramAdSizeParcel)
  {
    synchronized (this.zzpK)
    {
      this.zzBh = paramAdSizeParcel;
      requestLayout();
      return;
    }
  }
  
  public void zza(zzaz paramzzaz, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("isVisible", str);
      zzb("onAdVisibilityChanged", localHashMap);
      return;
    }
  }
  
  protected void zza(String paramString, ValueCallback<String> paramValueCallback)
  {
    synchronized (this.zzpK)
    {
      if (!isDestroyed()) {
        evaluateJavascript(paramString, paramValueCallback);
      }
      do
      {
        return;
        zzb.zzaH("The webview is destroyed. Ignoring action.");
      } while (paramValueCallback == null);
      paramValueCallback.onReceiveValue(null);
    }
  }
  
  public void zza(String paramString1, String paramString2)
  {
    zzaM(paramString1 + "(" + paramString2 + ");");
  }
  
  public void zza(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    zza(paramString, paramJSONObject.toString());
  }
  
  public void zzaI(String paramString)
  {
    synchronized (this.zzpK)
    {
      try
      {
        super.loadUrl(paramString);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          zzb.zzaH("Could not call loadUrl. " + localThrowable);
        }
      }
    }
  }
  
  public void zzaJ(String paramString)
  {
    Object localObject1 = this.zzpK;
    if (paramString == null) {
      paramString = "";
    }
    try
    {
      this.zzDX = paramString;
      return;
    }
    finally {}
  }
  
  protected void zzaL(String paramString)
  {
    synchronized (this.zzpK)
    {
      if (!isDestroyed())
      {
        loadUrl(paramString);
        return;
      }
      zzb.zzaH("The webview is destroyed. Ignoring action.");
    }
  }
  
  protected void zzaM(String paramString)
  {
    if (zznx.zzrU())
    {
      if (zzgQ() == null) {
        zzhW();
      }
      if (zzgQ().booleanValue())
      {
        zza(paramString, null);
        return;
      }
      zzaL("javascript:" + paramString);
      return;
    }
    zzaL("javascript:" + paramString);
  }
  
  public AdSizeParcel zzaP()
  {
    synchronized (this.zzpK)
    {
      AdSizeParcel localAdSizeParcel = this.zzBh;
      return localAdSizeParcel;
    }
  }
  
  public void zzb(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    synchronized (this.zzpK)
    {
      this.zzMy = paramzzd;
      return;
    }
  }
  
  void zzb(Boolean paramBoolean)
  {
    this.zzKh = paramBoolean;
    zzp.zzbA().zzb(paramBoolean);
  }
  
  public void zzb(String paramString, Map<String, ?> paramMap)
  {
    try
    {
      JSONObject localJSONObject = zzp.zzbx().zzz(paramMap);
      zzb(paramString, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzb.zzaH("Could not convert parameters to JSON.");
    }
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    String str = paramJSONObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AFMA_ReceiveMessage('");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    localStringBuilder.append(",");
    localStringBuilder.append(str);
    localStringBuilder.append(");");
    zzb.v("Dispatching AFMA event: " + localStringBuilder.toString());
    zzaM(localStringBuilder.toString());
  }
  
  public void zzc(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    synchronized (this.zzpK)
    {
      this.zzMJ = paramzzd;
      return;
    }
  }
  
  public void zzfg()
  {
    if (this.zzMF == null)
    {
      zzcd.zza(this.zzMI.zzdt(), this.zzMH, new String[] { "aes" });
      this.zzMF = zzcd.zzb(this.zzMI.zzdt());
      this.zzMI.zza("native:view_show", this.zzMF);
    }
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.zzpI.afmaVersion);
    zzb("onshow", localHashMap);
  }
  
  Boolean zzgQ()
  {
    synchronized (this.zzpK)
    {
      Boolean localBoolean = this.zzKh;
      return localBoolean;
    }
  }
  
  public com.google.android.gms.ads.internal.overlay.zzd zzhA()
  {
    synchronized (this.zzpK)
    {
      com.google.android.gms.ads.internal.overlay.zzd localzzd = this.zzMy;
      return localzzd;
    }
  }
  
  public com.google.android.gms.ads.internal.overlay.zzd zzhB()
  {
    synchronized (this.zzpK)
    {
      com.google.android.gms.ads.internal.overlay.zzd localzzd = this.zzMJ;
      return localzzd;
    }
  }
  
  public zzjo zzhC()
  {
    return this.zzMx;
  }
  
  public boolean zzhD()
  {
    return this.zzMz;
  }
  
  public zzan zzhE()
  {
    return this.zzxV;
  }
  
  public VersionInfoParcel zzhF()
  {
    return this.zzpI;
  }
  
  public boolean zzhG()
  {
    synchronized (this.zzpK)
    {
      boolean bool = this.zzMB;
      return bool;
    }
  }
  
  public void zzhH()
  {
    synchronized (this.zzpK)
    {
      zzb.v("Destroying WebView!");
      zzip.zzKO.post(new Runnable()
      {
        public void run()
        {
          zzjr.zza(zzjr.this);
        }
      });
      return;
    }
  }
  
  public boolean zzhI()
  {
    synchronized (this.zzpK)
    {
      zzcd.zza(this.zzMI.zzdt(), this.zzMF, new String[] { "aebb" });
      boolean bool = this.zzME;
      return bool;
    }
  }
  
  public zzjm zzhJ()
  {
    return null;
  }
  
  public zzcf zzhK()
  {
    return this.zzMH;
  }
  
  public zzcg zzhL()
  {
    return this.zzMI;
  }
  
  public void zzhM()
  {
    this.zzrz.zzhm();
  }
  
  public void zzhN()
  {
    if (this.zzMH == null)
    {
      this.zzMH = zzcd.zzb(this.zzMI.zzdt());
      this.zzMI.zza("native:view_load", this.zzMH);
    }
  }
  
  public boolean zzhV()
  {
    if (!zzhC().zzcb()) {
      return false;
    }
    DisplayMetrics localDisplayMetrics = zzp.zzbx().zza(this.zzrR);
    int i = zzl.zzcN().zzb(localDisplayMetrics, localDisplayMetrics.widthPixels);
    int j = zzl.zzcN().zzb(localDisplayMetrics, localDisplayMetrics.heightPixels);
    Activity localActivity = zzhx();
    int k;
    int m;
    if ((localActivity == null) || (localActivity.getWindow() == null))
    {
      k = j;
      m = i;
      label72:
      if ((this.zzCC == i) && (this.zzCD == j) && (this.zzCF == m) && (this.zzCG == k)) {
        break label220;
      }
      if ((this.zzCC == i) && (this.zzCD == j)) {
        break label222;
      }
    }
    label220:
    label222:
    for (boolean bool = true;; bool = false)
    {
      this.zzCC = i;
      this.zzCD = j;
      this.zzCF = m;
      this.zzCG = k;
      new zzfr(this).zza(i, j, m, k, localDisplayMetrics.density, this.zzrR.getDefaultDisplay().getRotation());
      return bool;
      int[] arrayOfInt = zzp.zzbx().zzg(localActivity);
      m = zzl.zzcN().zzb(localDisplayMetrics, arrayOfInt[0]);
      k = zzl.zzcN().zzb(localDisplayMetrics, arrayOfInt[1]);
      break label72;
      break;
    }
  }
  
  public void zzhw()
  {
    zzhX();
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.zzpI.afmaVersion);
    zzb("onhide", localHashMap);
  }
  
  public Activity zzhx()
  {
    return this.zzMw.zzhx();
  }
  
  public Context zzhy()
  {
    return this.zzMw.zzhy();
  }
  
  public com.google.android.gms.ads.internal.zzd zzhz()
  {
    return this.zzpc;
  }
  
  public void zzy(int paramInt)
  {
    zzhX();
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("closetype", String.valueOf(paramInt));
    localHashMap.put("version", this.zzpI.afmaVersion);
    zzb("onhide", localHashMap);
  }
  
  @zzha
  public static class zza
    extends MutableContextWrapper
  {
    private Activity zzLy;
    private Context zzMM;
    private Context zzrI;
    
    public zza(Context paramContext)
    {
      super();
      setBaseContext(paramContext);
    }
    
    public Object getSystemService(String paramString)
    {
      return this.zzMM.getSystemService(paramString);
    }
    
    public void setBaseContext(Context paramContext)
    {
      this.zzrI = paramContext.getApplicationContext();
      if ((paramContext instanceof Activity)) {}
      for (Activity localActivity = (Activity)paramContext;; localActivity = null)
      {
        this.zzLy = localActivity;
        this.zzMM = paramContext;
        super.setBaseContext(this.zzrI);
        return;
      }
    }
    
    public void startActivity(Intent paramIntent)
    {
      if ((this.zzLy != null) && (!zznx.isAtLeastL()))
      {
        this.zzLy.startActivity(paramIntent);
        return;
      }
      paramIntent.setFlags(268435456);
      this.zzrI.startActivity(paramIntent);
    }
    
    public Activity zzhx()
    {
      return this.zzLy;
    }
    
    public Context zzhy()
    {
      return this.zzMM;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzjr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */