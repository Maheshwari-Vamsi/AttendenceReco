package com.purplebrain.adbuddiz.sdk.i;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.i.a.a;
import com.purplebrain.adbuddiz.sdk.i.a.k;
import java.util.Stack;

@SuppressLint({"NewApi"})
public class j
{
  public static void a(Context paramContext)
  {
    Runnable local1;
    if (Build.VERSION.SDK_INT >= 19)
    {
      local1 = new Runnable()
      {
        public final void run()
        {
          try
          {
            Context localContext = this.a;
            boolean bool = j.e(this.a);
            SharedPreferences.Editor localEditor = localContext.getSharedPreferences("ABZ-prefs", 0).edit();
            localEditor.putBoolean("im", bool);
            localEditor.commit();
            return;
          }
          catch (Throwable localThrowable)
          {
            l.a("ABDisplayHelper.updateImmersiveModeFlag", null, localThrowable);
            o.a("ABDisplayHelper.updateImmersiveModeFlag", localThrowable);
          }
        }
      };
      if (!Looper.getMainLooper().equals(Looper.myLooper())) {
        new Handler(Looper.getMainLooper()).post(local1);
      }
    }
    else
    {
      return;
    }
    local1.run();
  }
  
  public static boolean b(Context paramContext)
  {
    if (!(paramContext instanceof Activity)) {
      return true;
    }
    return (0x400 & ((Activity)AdBuddiz.getContext()).getWindow().getAttributes().flags) != 0;
  }
  
  /* Error */
  public static boolean c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 54
    //   4: ifne +5 -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: invokestatic 60	com/purplebrain/adbuddiz/sdk/AdBuddiz:getContext	()Landroid/content/Context;
    //   12: checkcast 54	android/app/Activity
    //   15: invokevirtual 64	android/app/Activity:getWindow	()Landroid/view/Window;
    //   18: astore_1
    //   19: getstatic 19	android/os/Build$VERSION:SDK_INT	I
    //   22: bipush 11
    //   24: if_icmplt +24 -> 48
    //   27: aload_1
    //   28: iconst_1
    //   29: invokevirtual 82	android/view/Window:hasFeature	(I)Z
    //   32: ifne +12 -> 44
    //   35: aload_1
    //   36: bipush 8
    //   38: invokevirtual 82	android/view/Window:hasFeature	(I)Z
    //   41: ifeq +5 -> 46
    //   44: iconst_1
    //   45: ireturn
    //   46: iconst_0
    //   47: ireturn
    //   48: aload_1
    //   49: invokevirtual 86	java/lang/Object:getClass	()Ljava/lang/Class;
    //   52: invokevirtual 91	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   55: ldc 93
    //   57: iconst_0
    //   58: anewarray 88	java/lang/Class
    //   61: invokevirtual 97	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   64: astore 4
    //   66: aload 4
    //   68: iconst_1
    //   69: invokevirtual 103	java/lang/reflect/Method:setAccessible	(Z)V
    //   72: aload 4
    //   74: aload_1
    //   75: iconst_0
    //   76: anewarray 4	java/lang/Object
    //   79: invokevirtual 107	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 109	java/lang/Integer
    //   85: invokevirtual 113	java/lang/Integer:intValue	()I
    //   88: istore 5
    //   90: iload 5
    //   92: istore_3
    //   93: aload 4
    //   95: iconst_0
    //   96: invokevirtual 103	java/lang/reflect/Method:setAccessible	(Z)V
    //   99: iload_3
    //   100: iconst_2
    //   101: iand
    //   102: ifeq +5 -> 107
    //   105: iconst_1
    //   106: ireturn
    //   107: iconst_0
    //   108: ireturn
    //   109: astore_2
    //   110: iconst_0
    //   111: istore_3
    //   112: goto -13 -> 99
    //   115: astore 6
    //   117: goto -18 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   18	57	1	localWindow	Window
    //   109	1	2	localException1	Exception
    //   92	20	3	i	int
    //   64	30	4	localMethod	java.lang.reflect.Method
    //   88	3	5	j	int
    //   115	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   48	90	109	java/lang/Exception
    //   93	99	115	java/lang/Exception
  }
  
  public static int d(Context paramContext)
  {
    Stack localStack;
    int i;
    if (((paramContext instanceof Activity)) && (Build.VERSION.SDK_INT >= 11))
    {
      localStack = new Stack();
      localStack.add(((Activity)AdBuddiz.getContext()).getWindow().getDecorView());
      i = 0;
    }
    while ((!localStack.isEmpty()) && (i == 0))
    {
      View localView = (View)localStack.pop();
      int j = localView.getSystemUiVisibility();
      if ((j == 0) && ((localView instanceof ViewGroup)))
      {
        ViewGroup localViewGroup = (ViewGroup)localView;
        for (int k = 0; k < localViewGroup.getChildCount(); k++) {
          localStack.add(localViewGroup.getChildAt(k));
        }
      }
      i = j;
      continue;
      i = 0;
    }
    return i;
  }
  
  @SuppressLint({"InlinedApi"})
  public static boolean e(Context paramContext)
  {
    try
    {
      int i = d(paramContext);
      int j = i & 0x800;
      boolean bool = false;
      if (j != 0) {
        bool = true;
      }
      return bool;
    }
    catch (RuntimeException localRuntimeException) {}
    return paramContext.getSharedPreferences("ABZ-prefs", 0).getBoolean("im", false);
  }
  
  public static Integer f(Context paramContext)
  {
    if (!(paramContext instanceof Activity)) {}
    while (Build.VERSION.SDK_INT < 21) {
      return null;
    }
    return Integer.valueOf(((Activity)paramContext).getWindow().getStatusBarColor());
  }
  
  public static Integer g(Context paramContext)
  {
    if (!(paramContext instanceof Activity)) {}
    while (Build.VERSION.SDK_INT < 21) {
      return null;
    }
    return Integer.valueOf(((Activity)paramContext).getWindow().getNavigationBarColor());
  }
  
  public static Point h(Context paramContext)
  {
    RectF localRectF = new RectF(1.0F, 1.0F, 1.0F, 1.0F);
    Point localPoint1 = new Point();
    if ((Build.VERSION.SDK_INT >= 19) && (e(paramContext))) {
      ((DisplayManager)AdBuddiz.getContext().getSystemService("display")).getDisplay(0).getRealSize(localPoint1);
    }
    for (Point localPoint2 = localPoint1;; localPoint2 = localPoint1)
    {
      Rect localRect = a.a(paramContext, localRectF);
      int i = k.a(paramContext, 8);
      int j = k.a(paramContext, 13);
      int k = k.a(paramContext, 25);
      localPoint2.x -= i + (localRect.right + localRect.left);
      localPoint2.y -= k + (j + (i + (localRect.top + localRect.bottom)));
      return localPoint2;
      DisplayMetrics localDisplayMetrics = AdBuddiz.getContext().getResources().getDisplayMetrics();
      localPoint1.x = localDisplayMetrics.widthPixels;
      localPoint1.y = localDisplayMetrics.heightPixels;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */