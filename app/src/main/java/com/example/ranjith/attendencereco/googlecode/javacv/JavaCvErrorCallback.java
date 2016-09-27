package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvErrorCallback;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JavaCvErrorCallback
  extends opencv_core.CvErrorCallback
{
  private long lastErrorTime = 0L;
  private Component parent;
  private int rc;
  private boolean showDialog;
  
  public JavaCvErrorCallback()
  {
    this(false);
  }
  
  public JavaCvErrorCallback(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public JavaCvErrorCallback(boolean paramBoolean, Component paramComponent)
  {
    this(paramBoolean, paramComponent, 0);
  }
  
  public JavaCvErrorCallback(boolean paramBoolean, Component paramComponent, int paramInt)
  {
    this.parent = paramComponent;
    this.showDialog = paramBoolean;
    this.rc = paramInt;
  }
  
  public int call(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, Pointer paramPointer)
  {
    final String str = opencv_core.cvErrorStr(paramInt1) + " (" + paramString2 + ")\nin function " + paramString1 + ", " + paramString3 + "(" + paramInt2 + ")";
    Logger.getLogger(JavaCvErrorCallback.class.getName()).log(Level.SEVERE, "OpenCV Error: " + str, new Exception("Strack trace"));
    if (this.showDialog)
    {
      if (System.currentTimeMillis() - this.lastErrorTime > 1000L) {
        EventQueue.invokeLater(new Runnable()
        {
          public void run()
          {
            JOptionPane.showMessageDialog(JavaCvErrorCallback.this.parent, str, "OpenCV Error", 0);
          }
        });
      }
      this.lastErrorTime = System.currentTimeMillis();
    }
    return this.rc;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\JavaCvErrorCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */