package com.purplebrain.adbuddiz.sdk.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.purplebrain.adbuddiz.sdk.i.a.k;
import com.purplebrain.adbuddiz.sdk.i.l;
import com.purplebrain.adbuddiz.sdk.i.o;

@SuppressLint({"NewApi"})
public final class a
  extends ViewGroup
{
  private int A;
  private Rect B = new Rect();
  private RectF C = new RectF();
  private int D;
  private int E;
  private int F;
  private boolean G;
  private Rect H = new Rect();
  private boolean I = false;
  public Drawable a = null;
  public Drawable b = null;
  public boolean c;
  public int d;
  public Paint e;
  public Double f;
  public a g = null;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private Drawable n = null;
  private Drawable o = null;
  private Drawable p = null;
  private int q;
  private String r = null;
  private TextPaint s = null;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private Integer z;
  
  public a(Context paramContext)
  {
    super(paramContext);
    setClipToPadding(false);
    setDrawingCacheEnabled(true);
    setClickable(true);
    this.f = null;
    this.G = false;
    this.i = k.a(getContext(), 2);
    this.h = -1;
    this.k = k.a(getContext(), 3);
    this.j = -16777216;
    this.l = k.a(getContext(), 15);
    this.m = k.a(getContext(), 12);
    GradientDrawable localGradientDrawable1 = b();
    localGradientDrawable1.setStroke(this.k + this.i, this.j);
    this.n = localGradientDrawable1;
    GradientDrawable localGradientDrawable2 = b();
    localGradientDrawable2.setStroke(this.i, this.h);
    this.o = localGradientDrawable2;
    this.A = k.a(getContext(), 45);
    this.t = k.a(getContext(), -18);
    this.u = k.a(getContext(), -2);
    this.w = k.a(getContext(), 5.3333335F);
    this.x = k.a(getContext(), 4.6666665F);
    this.v = k.a(getContext(), 8.0F);
    this.y = k.a(getContext(), 8.0F);
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setColor(-1);
    localTextPaint.setTypeface(Typeface.DEFAULT);
    localTextPaint.setTextAlign(Paint.Align.CENTER);
    this.s = localTextPaint;
    this.q = ((int)TypedValue.applyDimension(2, 16.0F, getContext().getResources().getDisplayMetrics()));
    this.c = true;
    this.d = 0;
    this.e = a();
  }
  
  private void a(Canvas paramCanvas, String paramString)
  {
    int i1 = this.b.getBounds().width() - this.w - this.v;
    int i2 = this.b.getBounds().height() - this.x - this.y;
    this.b.draw(paramCanvas);
    Rect localRect = new Rect();
    a(paramString, this.s, this.q, i1, i2);
    float f1 = (this.s.descent() - this.s.ascent()) / 2.0F - this.s.descent();
    this.s.getTextBounds(paramString, 0, paramString.length(), localRect);
    paramCanvas.translate(this.w + i1 / 2, f1 + (this.x + i2 / 2));
    paramCanvas.drawText(paramString, 0.0F, 0.0F, this.s);
  }
  
  private void a(String paramString, TextPaint paramTextPaint, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.r != null) && (this.r.length() == paramString.length())) {
      return;
    }
    this.r = "9";
    for (int i1 = 1; i1 < paramString.length(); i1++) {
      this.r += "9";
    }
    Rect localRect = new Rect();
    do
    {
      paramTextPaint.setTextSize(paramInt1);
      paramTextPaint.getTextBounds(this.r, 0, this.r.length(), localRect);
      paramInt1--;
      if (paramInt1 <= 0) {
        break;
      }
    } while ((localRect.width() > paramInt2) || (localRect.height() > paramInt3));
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = 0xFF & paramMotionEvent.getAction();
    double d1;
    if ((i1 == 1) || (i1 == 0))
    {
      d1 = Math.sqrt(Math.pow(paramMotionEvent.getX() - i(), 2.0D) + Math.pow(paramMotionEvent.getY() - j(), 2.0D));
      if (i1 != 0) {
        break label85;
      }
      if (d1 < this.A)
      {
        this.I = true;
        return true;
      }
      this.I = false;
    }
    for (;;)
    {
      return false;
      label85:
      if (i1 == 1)
      {
        if ((this.I) && (d1 < this.A))
        {
          if (!this.c) {
            break;
          }
          playSoundEffect(0);
          if (this.g == null) {
            break;
          }
          this.g.a();
          return true;
        }
        this.I = false;
      }
    }
  }
  
  private GradientDrawable b()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setGradientType(0);
    localGradientDrawable.setColor(0);
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = this.l;
    arrayOfFloat[1] = this.l;
    arrayOfFloat[2] = this.l;
    arrayOfFloat[3] = this.l;
    arrayOfFloat[4] = this.l;
    arrayOfFloat[5] = this.l;
    arrayOfFloat[6] = this.l;
    arrayOfFloat[7] = this.l;
    localGradientDrawable.setCornerRadii(arrayOfFloat);
    return localGradientDrawable;
  }
  
  private Path c()
  {
    View localView = getChildAt(0);
    Path localPath = new Path();
    RectF localRectF = new RectF();
    localRectF.left = (f() + d() / 2);
    localRectF.top = (e() + h());
    localRectF.right = (localRectF.left + localView.getMeasuredWidth());
    localRectF.bottom = (localRectF.top + localView.getMeasuredHeight());
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = this.m;
    arrayOfFloat[1] = this.m;
    arrayOfFloat[2] = this.m;
    arrayOfFloat[3] = this.m;
    arrayOfFloat[4] = this.m;
    arrayOfFloat[5] = this.m;
    arrayOfFloat[6] = this.m;
    arrayOfFloat[7] = this.m;
    localPath.addRoundRect(localRectF, arrayOfFloat, Path.Direction.CW);
    return localPath;
  }
  
  private int d()
  {
    return 2 * (this.k + this.i);
  }
  
  private int e()
  {
    return getPaddingTop() + this.D;
  }
  
  private int f()
  {
    return getPaddingLeft() + this.F;
  }
  
  private int g()
  {
    int i1;
    if (this.a != null)
    {
      i1 = this.a.getBounds().height() / 2 + this.u;
      if (i1 >= 0) {}
    }
    else
    {
      return 0;
    }
    return i1;
  }
  
  private int h()
  {
    return d() / 2 + g();
  }
  
  private int i()
  {
    return f() + d() / 2 + getChildAt(0).getMeasuredWidth() + this.t;
  }
  
  private int j()
  {
    return e() + h() + this.u;
  }
  
  public final Paint a()
  {
    if (this.d == 0) {
      return null;
    }
    Paint localPaint = new Paint();
    localPaint.setColor(this.d);
    return localPaint;
  }
  
  public final void a(Rect paramRect)
  {
    View localView = getChildAt(0);
    paramRect.left = f();
    paramRect.top = (e() + g());
    paramRect.right = (paramRect.left + localView.getMeasuredWidth() + d());
    paramRect.bottom = (paramRect.top + localView.getMeasuredHeight() + d());
  }
  
  public final void a(RectF paramRectF, int paramInt1, int paramInt2, Rect paramRect, boolean paramBoolean)
  {
    double d1 = paramInt1 - paramRect.width();
    double d2 = paramInt2 - paramRect.height();
    if ((!paramBoolean) && (this.f != null))
    {
      if (d1 / this.f.doubleValue() < d2) {
        d2 = Math.floor(d1 / this.f.doubleValue());
      }
      if (d2 * this.f.doubleValue() < d1) {
        d1 = Math.floor(d2 * this.f.doubleValue());
      }
    }
    paramRectF.left = 0.0F;
    paramRectF.top = 0.0F;
    paramRectF.right = ((float)d1);
    paramRectF.bottom = ((float)d2);
  }
  
  public final void a(Double paramDouble)
  {
    if (this.f != paramDouble)
    {
      this.f = paramDouble;
      requestLayout();
      invalidate();
    }
  }
  
  public final void a(Integer paramInteger)
  {
    this.z = paramInteger;
    if (!this.c) {
      invalidate();
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.c != paramBoolean)
    {
      this.c = paramBoolean;
      invalidate();
    }
  }
  
  public final void b(Rect paramRect)
  {
    int i1 = getPaddingLeft() + getPaddingRight() + d() / 2;
    int i2 = d() / 2;
    if (this.a != null)
    {
      i3 = this.a.getBounds().width() / 2 + this.t;
      if (i3 >= 0) {}
    }
    for (int i3 = 0;; i3 = 0)
    {
      int i4 = i1 + (i3 + i2);
      int i5 = getPaddingTop() + getPaddingBottom() + h() + d() / 2;
      paramRect.left = 0;
      paramRect.top = 0;
      paramRect.right = i4;
      paramRect.bottom = i5;
      return;
    }
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    for (;;)
    {
      try
      {
        if (getChildCount() <= 0) {
          break;
        }
        paramCanvas.save();
        if ((Build.VERSION.SDK_INT >= 18) && (paramCanvas.isHardwareAccelerated())) {
          paramCanvas.clipPath(c());
        }
        if (this.e != null) {
          paramCanvas.drawPath(c(), this.e);
        }
        super.dispatchDraw(paramCanvas);
        paramCanvas.restore();
        a(this.H);
        paramCanvas.save();
        paramCanvas.translate(this.H.left, this.H.top);
        this.n.setBounds(0, 0, this.H.width(), this.H.height());
        this.n.draw(paramCanvas);
        this.o.setBounds(0, 0, this.H.width(), this.H.height());
        this.o.draw(paramCanvas);
        paramCanvas.translate(this.i, this.i);
        paramCanvas.restore();
        if (this.b != null)
        {
          paramCanvas.save();
          paramCanvas.translate(i() - this.b.getBounds().width() / 2, j() - this.b.getBounds().height() / 2);
          if (!this.c) {
            break label336;
          }
          if (this.a != null)
          {
            this.a.draw(paramCanvas);
            paramCanvas.restore();
          }
        }
        else
        {
          if (!this.G) {
            break;
          }
          Paint localPaint = new Paint();
          localPaint.setColor(-65536);
          localPaint.setAlpha(127);
          paramCanvas.drawCircle(i(), j(), this.A, localPaint);
          return;
        }
        a(paramCanvas, "X");
        continue;
        if (this.z == null) {
          break label357;
        }
      }
      catch (Throwable localThrowable)
      {
        l.a("ABInterstitialAdLayout.dispatchDraw", null, localThrowable);
        o.a("ABInterstitialLayout.dispatchDraw()", localThrowable);
        return;
      }
      label336:
      if (this.z.equals(Integer.valueOf(0))) {
        label357:
        if (this.p != null) {
          this.p.draw(paramCanvas);
        } else {
          a(paramCanvas, "…");
        }
      } else {
        a(paramCanvas, Integer.toString(this.z.intValue()));
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = a(paramMotionEvent);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      l.a("ABIntersitialAdLayout.onInterceptTouchEvent", null, localThrowable);
      o.a("ABInterstitialLayout.onInterceptTouchEvent()", localThrowable);
    }
    return false;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      if (getChildCount() != 0)
      {
        int i1 = paramInt1 + (f() + d() / 2);
        int i2 = paramInt2 + (e() + h());
        View localView = getChildAt(0);
        localView.layout(i1, i2, i1 + localView.getMeasuredWidth(), i2 + localView.getMeasuredHeight());
        for (int i3 = 1; i3 < getChildCount(); i3++) {
          getChildAt(i3).layout(i1, i2 + localView.getMeasuredHeight() - getChildAt(i3).getMeasuredHeight(), i1 + localView.getMeasuredWidth(), i2 + localView.getMeasuredHeight());
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      o.a("ABInterstitialLayout.onLayout()", localThrowable);
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        int i1 = View.MeasureSpec.getSize(paramInt1);
        int i2 = View.MeasureSpec.getMode(paramInt1);
        int i3 = View.MeasureSpec.getSize(paramInt2);
        int i4 = View.MeasureSpec.getMode(paramInt2);
        b(this.B);
        a(this.C, i1, i3, this.B, false);
        i5 = this.B.width();
        i6 = this.B.height();
        double d1 = this.C.width();
        double d2 = this.C.height();
        if (getChildCount() != 0)
        {
          View localView = getChildAt(0);
          localView.measure(View.MeasureSpec.makeMeasureSpec((int)d1, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec((int)d2, Integer.MIN_VALUE));
          double d3 = Math.min(d1 / localView.getMeasuredWidth(), d2 / localView.getMeasuredHeight());
          if (localView.getMeasuredWidth() != 0)
          {
            paramInt1 = View.MeasureSpec.makeMeasureSpec((int)Math.floor(d3 * localView.getMeasuredWidth()), 1073741824);
            if (localView.getMeasuredHeight() != 0)
            {
              paramInt2 = View.MeasureSpec.makeMeasureSpec((int)Math.floor(d3 * localView.getMeasuredHeight()), 1073741824);
              localView.measure(paramInt1, paramInt2);
              int i7 = 1;
              if (i7 >= getChildCount()) {
                continue;
              }
              int i8 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 1073741824);
              int i9 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), Integer.MIN_VALUE);
              getChildAt(i7).measure(i8, i9);
              i7++;
              continue;
            }
          }
          else
          {
            paramInt1 = View.MeasureSpec.makeMeasureSpec((int)Math.floor(d1 * d3), 1073741824);
            continue;
          }
          paramInt2 = View.MeasureSpec.makeMeasureSpec((int)Math.floor(d2 * d3), 1073741824);
          continue;
          if (i4 != 1073741824) {
            continue;
          }
          paramInt2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
          this.D = ((i3 - localView.getMeasuredHeight() - i6) / 2);
          if (i2 != 1073741824) {
            continue;
          }
          paramInt1 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);
          this.E = ((i1 - localView.getMeasuredWidth() - i5) / 2);
          this.F = this.E;
        }
      }
      catch (Throwable localThrowable)
      {
        int i5;
        int i6;
        l.a("ABInterstitialAdLayout.onMeasure", null, localThrowable);
        o.a("ABInterstitialLayout.onMeasure()", localThrowable);
        continue;
        paramInt1 = View.MeasureSpec.makeMeasureSpec(i5 + View.MeasureSpec.getSize(paramInt1), 1073741824);
        this.E = 0;
        this.F = 0;
        continue;
      }
      super.onMeasure(paramInt1, paramInt2);
      return;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i6 + View.MeasureSpec.getSize(paramInt2), 1073741824);
      this.D = 0;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = a(paramMotionEvent);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      l.a("ABInterstitialAdLayout.onTouchEvent", null, localThrowable);
      o.a("ABIntersitialAdLayout.onTouchEvent()", localThrowable);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */