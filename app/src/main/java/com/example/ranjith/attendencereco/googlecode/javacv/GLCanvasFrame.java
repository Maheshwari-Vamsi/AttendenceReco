package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_highgui;
import com.jogamp.opencl.CLMemory.Mem;
import com.jogamp.opencl.gl.CLGLImage2d;
import com.jogamp.opengl.util.Gamma;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.DisplayMode;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferDouble;
import java.awt.image.DataBufferFloat;
import java.awt.image.DataBufferInt;
import java.awt.image.DataBufferShort;
import java.awt.image.DataBufferUShort;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilitiesImmutable;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;

public class GLCanvasFrame
  extends CanvasFrame
{
  private static GLCanvasFrame canvasFrame;
  private Buffer buffer = null;
  private Color color = null;
  private GLEventListener eventListener = new GLEventListener()
  {
    static
    {
      if (!GLCanvasFrame.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    public void display(GLAutoDrawable paramAnonymousGLAutoDrawable)
    {
      GL2 localGL2 = paramAnonymousGLAutoDrawable.getGL().getGL2();
      if (GLCanvasFrame.this.color != null)
      {
        localGL2.glClearColor(GLCanvasFrame.this.color.getRed() / 255.0F, GLCanvasFrame.this.color.getGreen() / 255.0F, GLCanvasFrame.this.color.getBlue() / 255.0F, 1.0F);
        localGL2.glClear(16384);
      }
      do
      {
        return;
        if (GLCanvasFrame.this.buffer != null)
        {
          if ((GLCanvasFrame.this.isResizable()) && (GLCanvasFrame.this.needInitialResize))
          {
            int k = (int)Math.round(GLCanvasFrame.this.width * GLCanvasFrame.this.initialScale);
            int m = (int)Math.round(GLCanvasFrame.this.height * GLCanvasFrame.this.initialScale);
            GLCanvasFrame.this.setCanvasSize(k, m);
          }
          localGL2.glWindowPos2i(0, GLCanvasFrame.this.canvas.getHeight());
          localGL2.glPixelZoom(GLCanvasFrame.this.canvas.getWidth() / GLCanvasFrame.this.width, -GLCanvasFrame.this.canvas.getHeight() / GLCanvasFrame.this.height);
          localGL2.glDrawPixels(GLCanvasFrame.this.width, GLCanvasFrame.this.height, GLCanvasFrame.this.format, GLCanvasFrame.this.type, GLCanvasFrame.this.buffer);
          return;
        }
      } while (GLCanvasFrame.this.renderBuffer <= 0);
      localGL2.glBindRenderbuffer(36161, GLCanvasFrame.this.renderBuffer);
      localGL2.glGetRenderbufferParameteriv(36161, 36162, GLCanvasFrame.this.params, 0);
      localGL2.glGetRenderbufferParameteriv(36161, 36163, GLCanvasFrame.this.params, 1);
      if ((GLCanvasFrame.this.isResizable()) && (GLCanvasFrame.this.needInitialResize))
      {
        int i = (int)Math.round(GLCanvasFrame.this.params[0] * GLCanvasFrame.this.initialScale);
        int j = (int)Math.round(GLCanvasFrame.this.params[1] * GLCanvasFrame.this.initialScale);
        GLCanvasFrame.this.setCanvasSize(i, j);
      }
      localGL2.glBindFramebuffer(36008, GLCanvasFrame.this.frameBuffer);
      localGL2.glFramebufferRenderbuffer(36008, 36064, 36161, GLCanvasFrame.this.renderBuffer);
      assert (localGL2.glCheckFramebufferStatus(36008) == 36053);
      localGL2.glBlitFramebuffer(0, 0, GLCanvasFrame.this.params[0], GLCanvasFrame.this.params[1], 0, GLCanvasFrame.this.canvas.getHeight(), GLCanvasFrame.this.canvas.getWidth(), 0, 16384, 9729);
    }
    
    public void dispose(GLAutoDrawable paramAnonymousGLAutoDrawable)
    {
      GL2 localGL2 = paramAnonymousGLAutoDrawable.getGL().getGL2();
      GLCanvasFrame.this.params[0] = GLCanvasFrame.this.frameBuffer;
      localGL2.glDeleteFramebuffers(1, GLCanvasFrame.this.params, 0);
      if (GLCanvasFrame.this.inverseGamma != 1.0D) {
        Gamma.resetDisplayGamma(localGL2);
      }
    }
    
    public void init(GLAutoDrawable paramAnonymousGLAutoDrawable)
    {
      GL2 localGL2 = paramAnonymousGLAutoDrawable.getGL().getGL2();
      localGL2.setSwapInterval(1);
      if (GLCanvasFrame.this.inverseGamma != 1.0D) {
        Gamma.setDisplayGamma(localGL2, (float)GLCanvasFrame.this.inverseGamma, 0.0F, 1.0F);
      }
      localGL2.glGenFramebuffers(1, GLCanvasFrame.this.params, 0);
      GLCanvasFrame.access$202(GLCanvasFrame.this, GLCanvasFrame.this.params[0]);
    }
    
    public void reshape(GLAutoDrawable paramAnonymousGLAutoDrawable, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4) {}
  };
  private int format;
  private int frameBuffer = 0;
  private int height;
  private int[] params = new int[2];
  private int renderBuffer = 0;
  private int type;
  private int width;
  
  static
  {
    if (!GLCanvasFrame.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public GLCanvasFrame(String paramString)
  {
    this(paramString, 0.0D);
  }
  
  public GLCanvasFrame(String paramString, double paramDouble)
  {
    super(paramString, paramDouble);
    init(false, null, null);
  }
  
  public GLCanvasFrame(String paramString, int paramInt, DisplayMode paramDisplayMode)
    throws CanvasFrame.Exception
  {
    this(paramString, paramInt, paramDisplayMode, 0.0D);
  }
  
  public GLCanvasFrame(String paramString, int paramInt, DisplayMode paramDisplayMode, double paramDouble)
    throws CanvasFrame.Exception
  {
    super(paramString, paramInt, paramDisplayMode, paramDouble);
    init(true, null, null);
  }
  
  public GLCanvasFrame(String paramString, int paramInt, DisplayMode paramDisplayMode, GLCapabilitiesImmutable paramGLCapabilitiesImmutable, GLContext paramGLContext)
    throws CanvasFrame.Exception
  {
    this(paramString, paramInt, paramDisplayMode, paramGLCapabilitiesImmutable, paramGLContext, 0.0D);
  }
  
  public GLCanvasFrame(String paramString, int paramInt, DisplayMode paramDisplayMode, GLCapabilitiesImmutable paramGLCapabilitiesImmutable, GLContext paramGLContext, double paramDouble)
    throws CanvasFrame.Exception
  {
    super(paramString, paramInt, paramDisplayMode, paramDouble);
    init(true, paramGLCapabilitiesImmutable, paramGLContext);
  }
  
  public GLCanvasFrame(String paramString, GraphicsConfiguration paramGraphicsConfiguration, GLCapabilitiesImmutable paramGLCapabilitiesImmutable, GLContext paramGLContext)
  {
    this(paramString, paramGraphicsConfiguration, paramGLCapabilitiesImmutable, paramGLContext, 0.0D);
  }
  
  public GLCanvasFrame(String paramString, GraphicsConfiguration paramGraphicsConfiguration, GLCapabilitiesImmutable paramGLCapabilitiesImmutable, GLContext paramGLContext, double paramDouble)
  {
    super(paramString, paramGraphicsConfiguration, paramDouble);
    init(false, paramGLCapabilitiesImmutable, paramGLContext);
  }
  
  private void init(final boolean paramBoolean, final GLCapabilitiesImmutable paramGLCapabilitiesImmutable, final GLContext paramGLContext)
  {
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        String str = System.setProperty("sun.awt.noerasebackground", "true");
        GLCanvasFrame.this.canvas = new GLCanvas(paramGLCapabilitiesImmutable, paramGLContext);
        ((GLCanvas)GLCanvasFrame.this.canvas).addGLEventListener(GLCanvasFrame.this.eventListener);
        if (paramBoolean) {
          GLCanvasFrame.this.canvas.setSize(GLCanvasFrame.this.getSize());
        }
        for (GLCanvasFrame.this.needInitialResize = false;; GLCanvasFrame.this.needInitialResize = true)
        {
          GLCanvasFrame.this.getContentPane().add(GLCanvasFrame.this.canvas);
          GLCanvasFrame.this.canvas.setVisible(true);
          if (str == null) {
            break;
          }
          System.setProperty("sun.awt.noerasebackground", str);
          return;
          GLCanvasFrame.this.canvas.setSize(1, 1);
        }
        System.clearProperty("sun.awt.noerasebackground");
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
    catch (java.lang.Exception localException) {}
  }
  
  public static void main(String[] paramArrayOfString)
    throws java.lang.Exception
  {
    EventQueue.invokeAndWait(new Runnable()
    {
      public void run()
      {
        try
        {
          GLCanvasFrame.access$1002(new GLCanvasFrame("Some Title"));
          GLCanvasFrame.canvasFrame.setDefaultCloseOperation(3);
          GLCanvasFrame.canvasFrame.showColor(Color.BLUE);
          return;
        }
        catch (java.lang.Exception localException)
        {
          localException.printStackTrace();
        }
      }
    });
    JavaCVCL localJavaCVCL = new JavaCVCL(canvasFrame.getGLCanvas().getContext());
    opencv_core.IplImage localIplImage = opencv_highgui.cvLoadImageBGRA("/usr/share/opencv/samples/c/lena.jpg");
    CLGLImage2d localCLGLImage2d = localJavaCVCL.createCLGLImageFrom(localIplImage, new CLMemory.Mem[0]);
    localJavaCVCL.acquireGLObject(localCLGLImage2d);
    localJavaCVCL.writeImage(localCLGLImage2d, localIplImage, true);
    localJavaCVCL.releaseGLObject(localCLGLImage2d);
    canvasFrame.setCanvasScale(0.5D);
    for (int i = 0; i < 1000; i++)
    {
      canvasFrame.showImage(localCLGLImage2d.getGLObjectID());
      Thread.sleep(10L);
      canvasFrame.showColor(Color.RED);
      Thread.sleep(10L);
    }
    canvasFrame.waitKey();
    localJavaCVCL.release();
    System.exit(0);
  }
  
  public GLCanvas getGLCanvas()
  {
    return (GLCanvas)this.canvas;
  }
  
  protected void initCanvas(boolean paramBoolean, DisplayMode paramDisplayMode, double paramDouble) {}
  
  public void showColor(Color paramColor)
  {
    this.color = paramColor;
    this.buffer = null;
    getGLCanvas().display();
  }
  
  public void showImage(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    this.color = null;
    this.buffer = null;
    this.renderBuffer = paramInt;
    getGLCanvas().display();
  }
  
  public void showImage(opencv_core.IplImage paramIplImage)
  {
    showImage(paramIplImage, false);
  }
  
  public void showImage(opencv_core.IplImage paramIplImage, boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new RuntimeException("GLCanvasFrame does not support channel flipping.");
    }
    if (paramIplImage == null) {
      return;
    }
    this.color = null;
    this.width = paramIplImage.width();
    this.height = paramIplImage.height();
    this.buffer = paramIplImage.getByteBuffer();
    switch (paramIplImage.depth())
    {
    default: 
      if (!$assertionsDisabled) {
        throw new AssertionError();
      }
      break;
    case -2147483640: 
      this.type = 5120;
    }
    for (;;)
    {
      switch (paramIplImage.nChannels())
      {
      default: 
        if ($assertionsDisabled) {
          break label257;
        }
        throw new AssertionError();
        this.type = 5121;
        continue;
        this.type = 5122;
        continue;
        this.type = 5123;
        continue;
        this.type = 5124;
        continue;
        this.type = 5126;
        continue;
        this.type = 5130;
      }
    }
    this.format = 6409;
    for (;;)
    {
      label257:
      getGLCanvas().display();
      return;
      this.format = 33319;
      continue;
      this.format = 6407;
      continue;
      this.format = 6408;
    }
  }
  
  public void showImage(Image paramImage)
  {
    if (!(paramImage instanceof BufferedImage)) {
      throw new RuntimeException("GLCanvasFrame does not support " + paramImage + ", BufferedImage required.");
    }
    showImage((BufferedImage)paramImage);
  }
  
  public void showImage(BufferedImage paramBufferedImage)
  {
    if (paramBufferedImage == null) {
      return;
    }
    this.color = null;
    this.width = paramBufferedImage.getWidth();
    this.height = paramBufferedImage.getHeight();
    DataBuffer localDataBuffer = paramBufferedImage.getRaster().getDataBuffer();
    if ((localDataBuffer instanceof DataBufferByte))
    {
      this.buffer = ByteBuffer.wrap(((DataBufferByte)localDataBuffer).getData());
      this.type = 5121;
    }
    label269:
    do
    {
      for (;;)
      {
        switch (paramBufferedImage.getSampleModel().getNumBands())
        {
        default: 
          if ($assertionsDisabled) {
            break label290;
          }
          throw new AssertionError();
          if ((localDataBuffer instanceof DataBufferDouble))
          {
            this.buffer = DoubleBuffer.wrap(((DataBufferDouble)localDataBuffer).getData());
            this.type = 5130;
          }
          else if ((localDataBuffer instanceof DataBufferFloat))
          {
            this.buffer = FloatBuffer.wrap(((DataBufferFloat)localDataBuffer).getData());
            this.type = 5126;
          }
          else if ((localDataBuffer instanceof DataBufferInt))
          {
            this.buffer = IntBuffer.wrap(((DataBufferInt)localDataBuffer).getData());
            this.type = 5124;
          }
          else if ((localDataBuffer instanceof DataBufferShort))
          {
            this.buffer = ShortBuffer.wrap(((DataBufferShort)localDataBuffer).getData());
            this.type = 5122;
          }
          else
          {
            if (!(localDataBuffer instanceof DataBufferUShort)) {
              break label269;
            }
            this.buffer = ShortBuffer.wrap(((DataBufferUShort)localDataBuffer).getData());
            this.type = 5123;
          }
          break;
        }
      }
    } while ($assertionsDisabled);
    throw new AssertionError();
    this.format = 6409;
    for (;;)
    {
      label290:
      getGLCanvas().display();
      return;
      this.format = 33319;
      continue;
      this.format = 6407;
      continue;
      this.format = 6408;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\GLCanvasFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */