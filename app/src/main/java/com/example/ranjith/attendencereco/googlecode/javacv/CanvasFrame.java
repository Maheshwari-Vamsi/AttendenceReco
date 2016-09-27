package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_ProfileRGB;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import javax.swing.JFrame;
import javax.swing.JRootPane;

public class CanvasFrame
  extends JFrame
{
  public static final long DEFAULT_LATENCY = 200L;
  public static CanvasFrame global = null;
  private BufferedImage buffer = null;
  protected Canvas canvas = null;
  private Color color = null;
  private Image image = null;
  protected double initialScale = 1.0D;
  protected double inverseGamma = 1.0D;
  private KeyEvent keyEvent = null;
  private KeyEventDispatcher keyEventDispatch = new KeyEventDispatcher()
  {
    public boolean dispatchKeyEvent(KeyEvent paramAnonymousKeyEvent)
    {
      if (paramAnonymousKeyEvent.getID() == 401) {
        synchronized (CanvasFrame.this)
        {
          CanvasFrame.access$402(CanvasFrame.this, paramAnonymousKeyEvent);
          CanvasFrame.this.notify();
        }
      }
      return false;
    }
  };
  private long latency = 200L;
  protected boolean needInitialResize = false;
  
  public CanvasFrame(String paramString)
  {
    this(paramString, 0.0D);
  }
  
  public CanvasFrame(String paramString, double paramDouble)
  {
    super(paramString);
    init(false, null, paramDouble);
  }
  
  public CanvasFrame(String paramString, int paramInt, DisplayMode paramDisplayMode)
    throws Exception
  {
    this(paramString, paramInt, paramDisplayMode, 0.0D);
  }
  
  public CanvasFrame(String paramString, int paramInt, DisplayMode paramDisplayMode, double paramDouble)
    throws Exception
  {
    super(paramString, getScreenDevice(paramInt).getDefaultConfiguration());
    init(true, paramDisplayMode, paramDouble);
  }
  
  public CanvasFrame(String paramString, GraphicsConfiguration paramGraphicsConfiguration)
  {
    this(paramString, paramGraphicsConfiguration, 0.0D);
  }
  
  public CanvasFrame(String paramString, GraphicsConfiguration paramGraphicsConfiguration, double paramDouble)
  {
    super(paramString, paramGraphicsConfiguration);
    init(false, null, paramDouble);
  }
  
  public static double getDefaultGamma()
  {
    return getGamma(getDefaultScreenDevice());
  }
  
  public static GraphicsDevice getDefaultScreenDevice()
  {
    return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
  }
  
  public static DisplayMode getDisplayMode(int paramInt)
  {
    GraphicsDevice[] arrayOfGraphicsDevice = getScreenDevices();
    if ((paramInt >= 0) && (paramInt < arrayOfGraphicsDevice.length)) {
      return arrayOfGraphicsDevice[paramInt].getDisplayMode();
    }
    return null;
  }
  
  public static double getGamma(int paramInt)
  {
    GraphicsDevice[] arrayOfGraphicsDevice = getScreenDevices();
    if ((paramInt >= 0) && (paramInt < arrayOfGraphicsDevice.length)) {
      return getGamma(arrayOfGraphicsDevice[paramInt]);
    }
    return 0.0D;
  }
  
  public static double getGamma(GraphicsDevice paramGraphicsDevice)
  {
    ColorSpace localColorSpace = paramGraphicsDevice.getDefaultConfiguration().getColorModel().getColorSpace();
    if (localColorSpace.isCS_sRGB()) {
      return 2.2D;
    }
    try
    {
      float f = ((ICC_ProfileRGB)((ICC_ColorSpace)localColorSpace).getProfile()).getGamma(0);
      return f;
    }
    catch (RuntimeException localRuntimeException) {}
    return 0.0D;
  }
  
  public static String[] getScreenDescriptions()
  {
    GraphicsDevice[] arrayOfGraphicsDevice = getScreenDevices();
    String[] arrayOfString = new String[arrayOfGraphicsDevice.length];
    for (int i = 0; i < arrayOfGraphicsDevice.length; i++) {
      arrayOfString[i] = arrayOfGraphicsDevice[i].getIDstring();
    }
    return arrayOfString;
  }
  
  public static GraphicsDevice getScreenDevice(int paramInt)
    throws Exception
  {
    GraphicsDevice[] arrayOfGraphicsDevice = getScreenDevices();
    if (paramInt >= arrayOfGraphicsDevice.length) {
      throw new Exception("CanvasFrame Error: Screen number " + paramInt + " not found. " + "There are only " + arrayOfGraphicsDevice.length + " screens.");
    }
    return arrayOfGraphicsDevice[paramInt];
  }
  
  public static GraphicsDevice[] getScreenDevices()
  {
    return GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
  }
  
  private void init(final boolean paramBoolean, final DisplayMode paramDisplayMode, final double paramDouble)
  {
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(CanvasFrame.this.keyEventDispatch);
        GraphicsDevice localGraphicsDevice = CanvasFrame.this.getGraphicsConfiguration().getDevice();
        DisplayMode localDisplayMode1 = localGraphicsDevice.getDisplayMode();
        DisplayMode localDisplayMode2 = paramDisplayMode;
        DisplayMode localDisplayMode3 = null;
        int i;
        int j;
        int k;
        int m;
        if (localDisplayMode2 != null)
        {
          localDisplayMode3 = null;
          if (localDisplayMode1 != null)
          {
            i = paramDisplayMode.getWidth();
            j = paramDisplayMode.getHeight();
            k = paramDisplayMode.getBitDepth();
            m = paramDisplayMode.getRefreshRate();
            if (i <= 0) {
              break label249;
            }
            if (j <= 0) {
              break label258;
            }
            label94:
            if (k <= 0) {
              break label267;
            }
            label99:
            if (m <= 0) {
              break label276;
            }
            label104:
            localDisplayMode3 = new DisplayMode(i, j, k, m);
          }
        }
        label163:
        double d1;
        label198:
        CanvasFrame localCanvasFrame;
        if (paramBoolean)
        {
          CanvasFrame.this.setUndecorated(true);
          CanvasFrame.this.getRootPane().setWindowDecorationStyle(0);
          CanvasFrame.this.setResizable(false);
          localGraphicsDevice.setFullScreenWindow(CanvasFrame.this);
          if ((localDisplayMode3 != null) && (!localDisplayMode3.equals(localDisplayMode1))) {
            localGraphicsDevice.setDisplayMode(localDisplayMode3);
          }
          if (paramDouble != 0.0D) {
            break label296;
          }
          d1 = CanvasFrame.getGamma(localGraphicsDevice);
          localCanvasFrame = CanvasFrame.this;
          if (d1 != 0.0D) {
            break label305;
          }
        }
        label249:
        label258:
        label267:
        label276:
        label296:
        label305:
        for (double d2 = 1.0D;; d2 = 1.0D / d1)
        {
          localCanvasFrame.inverseGamma = d2;
          CanvasFrame.this.setVisible(true);
          CanvasFrame.this.initCanvas(paramBoolean, paramDisplayMode, paramDouble);
          return;
          i = localDisplayMode1.getWidth();
          break;
          j = localDisplayMode1.getHeight();
          break label94;
          k = localDisplayMode1.getBitDepth();
          break label99;
          m = localDisplayMode1.getRefreshRate();
          break label104;
          CanvasFrame.this.setLocationByPlatform(true);
          break label163;
          d1 = paramDouble;
          break label198;
        }
      }
    };
    if (EventQueue.isDispatchThread())
    {
      local1.run();
      return;
    }
    try
    {
      EventQueue.invokeAndWait(local1);
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void tile(CanvasFrame[] paramArrayOfCanvasFrame)
  {
    final ComponentAdapter local1MovedListener = new ComponentAdapter()
    {
      boolean moved = false;
      
      public void componentMoved(ComponentEvent paramAnonymousComponentEvent)
      {
        this.moved = true;
        synchronized (paramAnonymousComponentEvent.getComponent())
        {
          ???.notify();
          return;
        }
      }
    };
    int i = (int)Math.round(Math.sqrt(paramArrayOfCanvasFrame.length));
    if (i * i < paramArrayOfCanvasFrame.length) {
      i++;
    }
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    if (n < paramArrayOfCanvasFrame.length)
    {
      final int i1 = n;
      final int i2 = j;
      final int i3 = k;
      for (;;)
      {
        try
        {
          local1MovedListener.moved = false;
          EventQueue.invokeLater(new Runnable()
          {
            public void run()
            {
              this.val$frames[i1].addComponentListener(local1MovedListener);
              this.val$frames[i1].setLocation(i2, i3);
            }
          });
          int i4 = 0;
          if ((!local1MovedListener.moved) && (i4 < 5)) {
            synchronized (paramArrayOfCanvasFrame[i1])
            {
              paramArrayOfCanvasFrame[i1].wait(100L);
              i4++;
            }
          }
        }
        catch (Exception localException)
        {
          j = paramArrayOfCanvasFrame[n].getX() + paramArrayOfCanvasFrame[n].getWidth();
          m = Math.max(m, paramArrayOfCanvasFrame[n].getY() + paramArrayOfCanvasFrame[n].getHeight());
          if ((n + 1) % i == 0)
          {
            j = 0;
            k = m;
          }
          n++;
        }
        EventQueue.invokeLater(new Runnable()
        {
          public void run()
          {
            this.val$frames[i1].removeComponentListener(local1MovedListener);
          }
        });
      }
    }
  }
  
  public Graphics2D createGraphics()
  {
    if ((this.buffer == null) || (this.buffer.getWidth() != this.canvas.getWidth()) || (this.buffer.getHeight() != this.canvas.getHeight()))
    {
      BufferedImage localBufferedImage = this.canvas.getGraphicsConfiguration().createCompatibleImage(this.canvas.getWidth(), this.canvas.getHeight(), 3);
      if (this.buffer != null)
      {
        Graphics localGraphics = localBufferedImage.getGraphics();
        localGraphics.drawImage(this.buffer, 0, 0, null);
        localGraphics.dispose();
      }
      this.buffer = localBufferedImage;
    }
    return this.buffer.createGraphics();
  }
  
  public Canvas getCanvas()
  {
    return this.canvas;
  }
  
  public double getCanvasScale()
  {
    return this.initialScale;
  }
  
  public Dimension getCanvasSize()
  {
    return this.canvas.getSize();
  }
  
  public long getLatency()
  {
    return this.latency;
  }
  
  protected void initCanvas(boolean paramBoolean, DisplayMode paramDisplayMode, double paramDouble)
  {
    this.canvas = new Canvas()
    {
      public void paint(Graphics paramAnonymousGraphics)
      {
        try
        {
          BufferStrategy localBufferStrategy = CanvasFrame.this.canvas.getBufferStrategy();
          boolean bool;
          do
          {
            do
            {
              Graphics localGraphics = localBufferStrategy.getDrawGraphics();
              if (CanvasFrame.this.color != null)
              {
                localGraphics.setColor(CanvasFrame.this.color);
                localGraphics.fillRect(0, 0, getWidth(), getHeight());
              }
              if (CanvasFrame.this.image != null) {
                localGraphics.drawImage(CanvasFrame.this.image, 0, 0, getWidth(), getHeight(), null);
              }
              if (CanvasFrame.this.buffer != null) {
                localGraphics.drawImage(CanvasFrame.this.buffer, 0, 0, getWidth(), getHeight(), null);
              }
              localGraphics.dispose();
            } while (localBufferStrategy.contentsRestored());
            localBufferStrategy.show();
            bool = localBufferStrategy.contentsLost();
          } while (bool);
          return;
        }
        catch (IllegalStateException localIllegalStateException) {}catch (NullPointerException localNullPointerException) {}
      }
      
      public void update(Graphics paramAnonymousGraphics)
      {
        paint(paramAnonymousGraphics);
      }
    };
    if (paramBoolean) {
      this.canvas.setSize(getSize());
    }
    for (this.needInitialResize = false;; this.needInitialResize = true)
    {
      getContentPane().add(this.canvas);
      this.canvas.setVisible(true);
      this.canvas.createBufferStrategy(2);
      return;
    }
  }
  
  public void releaseGraphics(Graphics2D paramGraphics2D)
  {
    paramGraphics2D.dispose();
    this.canvas.paint(null);
  }
  
  public void setCanvasScale(double paramDouble)
  {
    this.initialScale = paramDouble;
    this.needInitialResize = true;
  }
  
  public void setCanvasSize(final int paramInt1, final int paramInt2)
  {
    Dimension localDimension = getCanvasSize();
    if ((localDimension.width == paramInt1) && (localDimension.height == paramInt2)) {
      return;
    }
    Runnable local4 = new Runnable()
    {
      public void run()
      {
        CanvasFrame.this.setExtendedState(0);
        CanvasFrame.this.canvas.setSize(paramInt1, paramInt2);
        CanvasFrame.this.pack();
        CanvasFrame.this.canvas.setSize(1 + paramInt1, 1 + paramInt2);
        CanvasFrame.this.canvas.setSize(paramInt1, paramInt2);
        CanvasFrame.this.needInitialResize = false;
      }
    };
    if (EventQueue.isDispatchThread())
    {
      local4.run();
      return;
    }
    try
    {
      EventQueue.invokeAndWait(local4);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setLatency(long paramLong)
  {
    this.latency = paramLong;
  }
  
  public void showColor(opencv_core.CvScalar paramCvScalar)
  {
    showColor(new Color((int)paramCvScalar.red(), (int)paramCvScalar.green(), (int)paramCvScalar.blue()));
  }
  
  public void showColor(Color paramColor)
  {
    this.color = paramColor;
    this.image = null;
    this.canvas.paint(null);
  }
  
  public void showImage(opencv_core.IplImage paramIplImage)
  {
    showImage(paramIplImage, false);
  }
  
  public void showImage(opencv_core.IplImage paramIplImage, boolean paramBoolean)
  {
    if (paramIplImage.getBufferedImageType() == 0) {}
    for (double d = 1.0D;; d = this.inverseGamma)
    {
      showImage(paramIplImage.getBufferedImage(d, paramBoolean));
      return;
    }
  }
  
  public void showImage(Image paramImage)
  {
    if (paramImage == null) {
      return;
    }
    if ((isResizable()) && (this.needInitialResize)) {
      setCanvasSize((int)Math.round(paramImage.getWidth(null) * this.initialScale), (int)Math.round(paramImage.getHeight(null) * this.initialScale));
    }
    this.color = null;
    this.image = paramImage;
    this.canvas.paint(null);
  }
  
  public KeyEvent waitKey()
    throws InterruptedException
  {
    return waitKey(0);
  }
  
  public KeyEvent waitKey(int paramInt)
    throws InterruptedException
  {
    if (paramInt >= 0) {}
    try
    {
      this.keyEvent = null;
      wait(paramInt);
      KeyEvent localKeyEvent = this.keyEvent;
      this.keyEvent = null;
      return localKeyEvent;
    }
    finally {}
  }
  
  public void waitLatency()
    throws InterruptedException
  {
    Thread.sleep(getLatency());
  }
  
  public static class Exception
    extends Exception
  {
    public Exception(String paramString)
    {
      super();
    }
    
    public Exception(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\CanvasFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */