package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zziq;
import java.util.Iterator;
import java.util.List;

@zzha
class zzb
  extends RelativeLayout
{
  private static final float[] zzxt = { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F };
  private final RelativeLayout zzxu;
  private AnimationDrawable zzxv;
  
  public zzb(Context paramContext, zza paramzza)
  {
    super(paramContext);
    zzx.zzy(paramzza);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(10);
    localLayoutParams1.addRule(11);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(zzxt, null, null));
    localShapeDrawable.getPaint().setColor(paramzza.getBackgroundColor());
    this.zzxu = new RelativeLayout(paramContext);
    this.zzxu.setLayoutParams(localLayoutParams1);
    zzp.zzbz().zza(this.zzxu, localShapeDrawable);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    if (!TextUtils.isEmpty(paramzza.getText()))
    {
      RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
      TextView localTextView = new TextView(paramContext);
      localTextView.setLayoutParams(localLayoutParams3);
      localTextView.setId(1195835393);
      localTextView.setTypeface(Typeface.DEFAULT);
      localTextView.setText(paramzza.getText());
      localTextView.setTextColor(paramzza.getTextColor());
      localTextView.setTextSize(paramzza.getTextSize());
      localTextView.setPadding(zzl.zzcN().zzb(paramContext, 4), 0, zzl.zzcN().zzb(paramContext, 4), 0);
      this.zzxu.addView(localTextView);
      localLayoutParams2.addRule(1, localTextView.getId());
    }
    ImageView localImageView = new ImageView(paramContext);
    localImageView.setLayoutParams(localLayoutParams2);
    localImageView.setId(1195835394);
    List localList = paramzza.zzdz();
    if (localList.size() > 1)
    {
      this.zzxv = new AnimationDrawable();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Drawable localDrawable = (Drawable)localIterator.next();
        this.zzxv.addFrame(localDrawable, paramzza.zzdA());
      }
      zzp.zzbz().zza(localImageView, this.zzxv);
    }
    for (;;)
    {
      this.zzxu.addView(localImageView);
      addView(this.zzxu);
      return;
      if (localList.size() == 1) {
        localImageView.setImageDrawable((Drawable)localList.get(0));
      }
    }
  }
  
  public void onAttachedToWindow()
  {
    if (this.zzxv != null) {
      this.zzxv.start();
    }
    super.onAttachedToWindow();
  }
  
  public ViewGroup zzdB()
  {
    return this.zzxu;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\formats\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */