package com.purplebrain.adbuddiz.sdk.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.widget.RelativeLayout;
import com.purplebrain.adbuddiz.sdk.i.a.k;
import com.purplebrain.adbuddiz.sdk.i.l;
import com.purplebrain.adbuddiz.sdk.i.o;

@SuppressLint({"NewApi"})
public final class b
  extends RelativeLayout
{
  public Paint a = null;
  int b;
  int c;
  Bitmap d = null;
  boolean e = true;
  public boolean f = true;
  private int g;
  
  public b(Context paramContext)
  {
    super(paramContext);
    setClickable(true);
    this.g = k.a(getContext(), 15);
    this.a = new Paint();
    this.a.setColor(-16777216);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.f)
    {
      a locala = (a)getChildAt(0);
      Path localPath = new Path();
      Rect localRect = new Rect();
      locala.a(localRect);
      RectF localRectF = new RectF();
      localRectF.left = localRect.left;
      localRectF.top = localRect.top;
      localRectF.right = localRect.right;
      localRectF.bottom = localRect.bottom;
      float[] arrayOfFloat = new float[8];
      arrayOfFloat[0] = this.g;
      arrayOfFloat[1] = this.g;
      arrayOfFloat[2] = this.g;
      arrayOfFloat[3] = this.g;
      arrayOfFloat[4] = this.g;
      arrayOfFloat[5] = this.g;
      arrayOfFloat[6] = this.g;
      arrayOfFloat[7] = this.g;
      localPath.addRoundRect(localRectF, arrayOfFloat, Path.Direction.CCW);
      paramCanvas.clipPath(localPath, Region.Op.DIFFERENCE);
    }
    paramCanvas.drawColor(this.a.getColor());
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    for (;;)
    {
      try
      {
        paramCanvas.save();
        if (!this.f)
        {
          paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.a);
          paramCanvas.restore();
          super.dispatchDraw(paramCanvas);
          return;
        }
        if ((Build.VERSION.SDK_INT >= 18) && (paramCanvas.isHardwareAccelerated()))
        {
          a(paramCanvas);
          continue;
        }
        i = getMeasuredWidth();
      }
      catch (Throwable localThrowable)
      {
        l.a("ABInterstitialParentLayout.dispatchDraw", null, localThrowable);
        o.a("ABInterstitialParentLayout.dispatchDraw()", localThrowable);
        return;
      }
      int i;
      int j = getMeasuredHeight();
      if (this.d != null)
      {
        if ((i != this.b) || (j != this.c))
        {
          this.d.recycle();
          this.d = null;
        }
        if (!this.e) {}
      }
      else if ((this.e) || (this.d == null))
      {
        if (this.d == null)
        {
          this.b = i;
          this.c = j;
          this.d = Bitmap.createBitmap(i, j, Bitmap.Config.ALPHA_8);
        }
        a(new Canvas(this.d));
        this.e = false;
      }
      paramCanvas.drawBitmap(this.d, 0.0F, 0.0F, this.a);
      this.e = false;
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.d != null) {
      this.e = true;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */