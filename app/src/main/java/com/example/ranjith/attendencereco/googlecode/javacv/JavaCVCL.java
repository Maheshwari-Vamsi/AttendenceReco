package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.CvSize;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_core.IplROI;
import com.googlecode.javacv.cpp.opencv_highgui;
import com.googlecode.javacv.cpp.opencv_imgproc;
import com.jogamp.opencl.CLBuffer;
import com.jogamp.opencl.CLCommandQueue;
import com.jogamp.opencl.CLContext;
import com.jogamp.opencl.CLDevice;
import com.jogamp.opencl.CLEventList;
import com.jogamp.opencl.CLImage2d;
import com.jogamp.opencl.CLImageFormat;
import com.jogamp.opencl.CLImageFormat.ChannelOrder;
import com.jogamp.opencl.CLImageFormat.ChannelType;
import com.jogamp.opencl.CLKernel;
import com.jogamp.opencl.CLMemory.Map;
import com.jogamp.opencl.CLMemory.Mem;
import com.jogamp.opencl.CLObject;
import com.jogamp.opencl.CLPlatform;
import com.jogamp.opencl.CLProgram;
import com.jogamp.opencl.gl.CLGLContext;
import com.jogamp.opencl.gl.CLGLImage2d;
import com.jogamp.opencl.gl.CLGLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.SequenceInputStream;
import java.nio.ByteBuffer;
import java.util.Vector;
import java.util.logging.Logger;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLCapabilitiesImmutable;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLDrawableFactory;
import javax.media.opengl.GLException;
import javax.media.opengl.GLPbuffer;
import javax.media.opengl.GLProfile;
import javax.media.opengl.glu.GLU;

public class JavaCVCL
{
  public static final String fastCompilerOptions = "-cl-fast-relaxed-math -cl-mad-enable";
  private static final Logger logger;
  private final CLCommandQueue commandQueue;
  private final CLContext context;
  private final GLU glu;
  private final GLPbuffer pbuffer;
  private final CLKernel pyrDownKernel;
  private final CLKernel remapBayerKernel;
  private final CLKernel remapKernel;
  
  static
  {
    if (!JavaCVCL.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      logger = Logger.getLogger(JavaCVCL.class.getName());
      return;
    }
  }
  
  public JavaCVCL()
  {
    this(false);
  }
  
  public JavaCVCL(CLContext paramCLContext)
  {
    this(paramCLContext, paramCLContext.getDevices()[0]);
  }
  
  public JavaCVCL(CLContext paramCLContext, CLDevice paramCLDevice)
  {
    this.pbuffer = null;
    this.context = paramCLContext;
    boolean bool = paramCLContext instanceof CLGLContext;
    GLU localGLU = null;
    if (bool) {
      localGLU = new GLU();
    }
    this.glu = localGLU;
    this.commandQueue = paramCLDevice.createCommandQueue();
    CLKernel[] arrayOfCLKernel = buildKernels("-cl-fast-relaxed-math -cl-mad-enable", "JavaCV.cl", new String[] { "pyrDown", "remap", "remapBayer" });
    this.pyrDownKernel = arrayOfCLKernel[0];
    this.remapKernel = arrayOfCLKernel[1];
    this.remapBayerKernel = arrayOfCLKernel[2];
  }
  
  public JavaCVCL(GLCapabilitiesImmutable paramGLCapabilitiesImmutable, GLContext paramGLContext, CLDevice paramCLDevice)
  {
    GLPbuffer localGLPbuffer = null;
    GLDrawableFactory localGLDrawableFactory;
    if (paramGLCapabilitiesImmutable != null)
    {
      localGLDrawableFactory = GLDrawableFactory.getFactory(paramGLCapabilitiesImmutable.getGLProfile());
      if (!localGLDrawableFactory.canCreateGLPbuffer(null)) {
        break label245;
      }
    }
    for (;;)
    {
      int j;
      try
      {
        localGLPbuffer = localGLDrawableFactory.createGLPbuffer(null, paramGLCapabilitiesImmutable, null, 32, 32, paramGLContext);
        localGLPbuffer.createContext(paramGLContext).makeCurrent();
        this.pbuffer = localGLPbuffer;
        GLContext localGLContext = GLContext.getCurrent();
        if ((paramCLDevice == null) && (localGLContext != null))
        {
          CLDevice[] arrayOfCLDevice = CLPlatform.getDefault().listCLDevices();
          int i = arrayOfCLDevice.length;
          j = 0;
          if (j < i)
          {
            CLDevice localCLDevice = arrayOfCLDevice[j];
            if (!localCLDevice.isGLMemorySharingSupported()) {
              break label259;
            }
            paramCLDevice = localCLDevice;
          }
        }
        if ((localGLContext == null) || (paramCLDevice == null)) {
          break label265;
        }
        this.context = CLGLContext.create(localGLContext, new CLDevice[] { paramCLDevice });
        this.glu = GLU.createGLU();
        this.commandQueue = paramCLDevice.createCommandQueue();
        CLKernel[] arrayOfCLKernel = buildKernels("-cl-fast-relaxed-math -cl-mad-enable", "JavaCV.cl", new String[] { "pyrDown", "remap", "remapBayer" });
        this.pyrDownKernel = arrayOfCLKernel[0];
        this.remapKernel = arrayOfCLKernel[1];
        this.remapBayerKernel = arrayOfCLKernel[2];
        return;
      }
      catch (GLException localGLException)
      {
        logger.warning("Could not create PBuffer: " + localGLException);
        continue;
      }
      label245:
      logger.warning("OpenGL implementation does not support PBuffers.");
      localGLPbuffer = null;
      continue;
      label259:
      j++;
      continue;
      label265:
      if (paramCLDevice != null)
      {
        this.context = CLContext.create(new CLDevice[] { paramCLDevice });
        this.glu = null;
      }
      else
      {
        this.context = CLContext.create();
        paramCLDevice = this.context.getDevices()[0];
        this.glu = null;
      }
    }
  }
  
  public JavaCVCL(GLContext paramGLContext) {}
  
  public JavaCVCL(boolean paramBoolean) {}
  
  public static int alignCeil(int paramInt1, int paramInt2)
  {
    return paramInt2 * ((-1 + (paramInt1 + paramInt2)) / paramInt2);
  }
  
  public static int alignFloor(int paramInt1, int paramInt2)
  {
    return paramInt2 * (paramInt1 / paramInt2);
  }
  
  public static GLCapabilities getDefaultGLCapabilities(GLProfile paramGLProfile)
  {
    if (paramGLProfile != null) {}
    for (;;)
    {
      GLCapabilities localGLCapabilities = new GLCapabilities(paramGLProfile);
      localGLCapabilities.setDoubleBuffered(false);
      return localGLCapabilities;
      paramGLProfile = GLProfile.getDefault();
    }
  }
  
  public static void main(String[] paramArrayOfString)
  {
    JavaCVCL localJavaCVCL = new JavaCVCL();
    for (CLImageFormat localCLImageFormat : localJavaCVCL.getCLContext().getSupportedImage2dFormats(new CLMemory.Mem[0])) {
      System.out.println(localCLImageFormat);
    }
    CameraDevice localCameraDevice = new CameraDevice("Camera");
    localCameraDevice.imageWidth = 1280;
    localCameraDevice.imageHeight = 960;
    localCameraDevice.cameraMatrix = opencv_core.CvMat.create(3, 3);
    double d = 2.5D * localCameraDevice.imageWidth;
    opencv_core.CvMat localCvMat = localCameraDevice.cameraMatrix;
    double[] arrayOfDouble = new double[9];
    arrayOfDouble[0] = d;
    arrayOfDouble[1] = 0.0D;
    arrayOfDouble[2] = (localCameraDevice.imageWidth / 2);
    arrayOfDouble[3] = 0.0D;
    arrayOfDouble[4] = d;
    arrayOfDouble[5] = (localCameraDevice.imageHeight / 2);
    arrayOfDouble[6] = 0.0D;
    arrayOfDouble[7] = 0.0D;
    arrayOfDouble[8] = 1.0D;
    localCvMat.put(arrayOfDouble);
    localCameraDevice.R = opencv_core.CvMat.create(3, 3);
    opencv_core.cvSetIdentity(localCameraDevice.R);
    localCameraDevice.T = opencv_core.CvMat.create(3, 1);
    opencv_core.cvSetZero(localCameraDevice.T);
    localCameraDevice.distortionCoeffs = opencv_core.CvMat.create(1, 4);
    opencv_core.cvSetZero(localCameraDevice.distortionCoeffs);
    localCameraDevice.distortionCoeffs.put(new double[] { 0.2D });
    localCameraDevice.colorMixingMatrix = opencv_core.CvMat.create(3, 3);
    opencv_core.cvSetIdentity(localCameraDevice.colorMixingMatrix);
    opencv_core.IplImage localIplImage1 = opencv_highgui.cvLoadImageRGBA(paramArrayOfString[0]);
    opencv_core.IplImage localIplImage2 = opencv_core.IplImage.create(localIplImage1.width() / 2, localIplImage1.height() / 2, 8, 4);
    localCameraDevice.setFixedPointMaps(false);
    localCameraDevice.setMapsPyramidLevel(1);
    opencv_core.IplImage localIplImage3 = localCameraDevice.getUndistortMap1();
    opencv_core.IplImage localIplImage4 = localCameraDevice.getUndistortMap2();
    long l = System.nanoTime();
    opencv_imgproc.cvRemap(localIplImage1, localIplImage2, localIplImage3, localIplImage4, 9, opencv_core.CvScalar.ZERO);
    System.out.println("cvRemap: " + (System.nanoTime() - l) / 1000000.0D);
    opencv_highgui.cvSaveImage("/tmp/opencv.png", localIplImage2);
    CLImage2d localCLImage2d1 = localJavaCVCL.createCLImageFrom(localIplImage1, new CLMemory.Mem[0]);
    CLImage2d localCLImage2d2 = localJavaCVCL.createCLImageFrom(localIplImage2, new CLMemory.Mem[0]);
    CLImage2d localCLImage2d3 = localJavaCVCL.createCLImageFrom(localIplImage3, new CLMemory.Mem[0]);
    CLImage2d localCLImage2d4 = localJavaCVCL.createCLImageFrom(localIplImage4, new CLMemory.Mem[0]);
    localJavaCVCL.writeImage(localCLImage2d1, localIplImage1, false);
    localJavaCVCL.writeImage(localCLImage2d3, localIplImage3, false);
    localJavaCVCL.writeImage(localCLImage2d4, localIplImage4, false);
    localJavaCVCL.remap(localCLImage2d1, localCLImage2d2, localCLImage2d3, localCLImage2d4);
    localJavaCVCL.readImage(localCLImage2d2, localIplImage2, true);
    opencv_highgui.cvSaveImage("/tmp/javacvcl.png", localIplImage2);
    localJavaCVCL.release();
    System.exit(0);
  }
  
  public void acquireGLObject(CLObject paramCLObject)
  {
    if ((paramCLObject instanceof CLGLObject)) {
      this.commandQueue.putAcquireGLObject((CLGLObject)paramCLObject);
    }
  }
  
  public CLKernel buildKernel(String paramString1, String paramString2)
  {
    return buildKernels("-cl-fast-relaxed-math -cl-mad-enable", Loader.getCallerClass(2), paramString1, new String[] { paramString2 })[0];
  }
  
  public CLKernel buildKernel(String paramString1, String paramString2, String paramString3)
  {
    return buildKernels(paramString1, Loader.getCallerClass(2), paramString2, new String[] { paramString3 })[0];
  }
  
  public CLKernel[] buildKernels(String paramString1, Class paramClass, String paramString2, String... paramVarArgs)
  {
    CLProgram localCLProgram;
    for (;;)
    {
      String[] arrayOfString;
      try
      {
        arrayOfString = paramString2.split(":");
        if (arrayOfString.length == 1)
        {
          localObject = paramClass.getResourceAsStream(arrayOfString[0]);
          localCLProgram = this.context.createProgram((InputStream)localObject);
          localCLProgram.build(paramString1);
          if (($assertionsDisabled) || (localCLProgram.isExecutable())) {
            break;
          }
          throw new AssertionError();
        }
      }
      catch (IOException localIOException)
      {
        throw ((Error)new LinkageError(localIOException.toString()).initCause(localIOException));
      }
      Vector localVector = new Vector(arrayOfString.length);
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++) {
        localVector.addElement(paramClass.getResourceAsStream(arrayOfString[j]));
      }
      Object localObject = new SequenceInputStream(localVector.elements());
    }
    CLKernel[] arrayOfCLKernel = new CLKernel[paramVarArgs.length];
    for (int k = 0; k < paramVarArgs.length; k++) {
      arrayOfCLKernel[k] = localCLProgram.createCLKernel(paramVarArgs[k]);
    }
    return arrayOfCLKernel;
  }
  
  public CLKernel[] buildKernels(String paramString1, String paramString2, String... paramVarArgs)
  {
    return buildKernels(paramString1, Loader.getCallerClass(2), paramString2, paramVarArgs);
  }
  
  public CLGLImage2d createCLGLImageFrom(opencv_core.IplImage paramIplImage, CLMemory.Mem... paramVarArgs)
  {
    GL2 localGL2 = getGL2();
    if (localGL2 == null) {
      return null;
    }
    int i = paramIplImage.width();
    int j = paramIplImage.height();
    int k = paramIplImage.widthStep();
    int m;
    int n;
    switch (paramIplImage.nChannels())
    {
    default: 
      boolean bool5 = $assertionsDisabled;
      m = 0;
      n = 0;
      if (!bool5) {
        throw new AssertionError();
      }
      break;
    case 1: 
      switch (paramIplImage.depth())
      {
      default: 
        boolean bool4 = $assertionsDisabled;
        m = 0;
        n = 0;
        if (!bool4) {
          throw new AssertionError();
        }
        break;
      case -2147483640: 
        m = 36885;
        n = 1;
      }
      break;
    }
    for (;;)
    {
      if (i != k / n) {
        i = k / n;
      }
      int[] arrayOfInt = new int[1];
      localGL2.glGenRenderbuffers(1, arrayOfInt, 0);
      localGL2.glBindRenderbuffer(36161, arrayOfInt[0]);
      localGL2.glRenderbufferStorage(36161, m, i, j);
      return getCLGLContext().createFromGLRenderbuffer(arrayOfInt[0], paramVarArgs);
      m = 32832;
      n = 1;
      continue;
      m = 36889;
      n = 2;
      continue;
      m = 32834;
      n = 2;
      continue;
      m = 36230;
      n = 4;
      continue;
      m = 34840;
      n = 4;
      continue;
      switch (paramIplImage.depth())
      {
      default: 
        boolean bool3 = $assertionsDisabled;
        m = 0;
        n = 0;
        if (!bool3) {
          throw new AssertionError();
        }
        break;
      case -2147483640: 
        m = 36757;
        n = 2;
        break;
      case 8: 
        m = 33323;
        n = 2;
        break;
      case -2147483632: 
        m = 36761;
        n = 4;
        break;
      case 16: 
        m = 33324;
        n = 4;
        break;
      case -2147483616: 
        m = 33339;
        n = 8;
        break;
      case 32: 
        m = 33328;
        n = 8;
        continue;
        switch (paramIplImage.depth())
        {
        default: 
          boolean bool2 = $assertionsDisabled;
          m = 0;
          n = 0;
          if (!bool2) {
            throw new AssertionError();
          }
          break;
        case -2147483640: 
          m = 36758;
          n = 3;
          break;
        case 8: 
          m = 32849;
          n = 3;
          break;
        case -2147483632: 
          m = 36762;
          n = 6;
          break;
        case 16: 
          m = 32852;
          n = 6;
          break;
        case -2147483616: 
          m = 36227;
          n = 12;
          break;
        case 32: 
          m = 34837;
          n = 12;
          continue;
          switch (paramIplImage.depth())
          {
          default: 
            boolean bool1 = $assertionsDisabled;
            m = 0;
            n = 0;
            if (!bool1) {
              throw new AssertionError();
            }
            break;
          case -2147483640: 
            m = 36759;
            n = 4;
            break;
          case 8: 
            m = 32856;
            n = 4;
            break;
          case -2147483632: 
            m = 36763;
            n = 8;
            break;
          case 16: 
            m = 32859;
            n = 8;
            break;
          case -2147483616: 
            m = 36226;
            n = 16;
            break;
          case 32: 
            m = 34836;
            n = 16;
          }
          break;
        }
        break;
      }
    }
  }
  
  public CLImage2d createCLImageFrom(opencv_core.IplImage paramIplImage, CLMemory.Mem... paramVarArgs)
  {
    int i = paramIplImage.width();
    int j = paramIplImage.height();
    int k = paramIplImage.widthStep();
    ByteBuffer localByteBuffer = paramIplImage.getByteBuffer();
    int m;
    CLImageFormat.ChannelType localChannelType;
    switch (paramIplImage.depth())
    {
    default: 
      boolean bool2 = $assertionsDisabled;
      m = 0;
      localChannelType = null;
      if (!bool2) {
        throw new AssertionError();
      }
      break;
    case -2147483640: 
      localChannelType = CLImageFormat.ChannelType.SNORM_INT8;
      m = 1;
    }
    for (;;)
    {
      switch (paramIplImage.nChannels())
      {
      default: 
        boolean bool1 = $assertionsDisabled;
        localChannelOrder = null;
        if (bool1) {
          break label233;
        }
        throw new AssertionError();
        localChannelType = CLImageFormat.ChannelType.UNORM_INT8;
        m = 1;
        continue;
        localChannelType = CLImageFormat.ChannelType.SNORM_INT16;
        m = 2;
        continue;
        localChannelType = CLImageFormat.ChannelType.UNORM_INT16;
        m = 2;
        continue;
        localChannelType = CLImageFormat.ChannelType.SIGNED_INT32;
        m = 4;
        continue;
        localChannelType = CLImageFormat.ChannelType.FLOAT;
        m = 4;
      }
    }
    CLImageFormat.ChannelOrder localChannelOrder = CLImageFormat.ChannelOrder.LUMINANCE;
    for (;;)
    {
      label233:
      if (i != k / m) {
        i = k / m;
      }
      CLImageFormat localCLImageFormat = new CLImageFormat(localChannelOrder, localChannelType);
      return this.context.createImage2d(localByteBuffer, i, j, localCLImageFormat, paramVarArgs);
      localChannelOrder = CLImageFormat.ChannelOrder.RG;
      m *= 2;
      continue;
      localChannelOrder = CLImageFormat.ChannelOrder.RGB;
      m *= 3;
      continue;
      localChannelOrder = CLImageFormat.ChannelOrder.RGBA;
      m *= 4;
    }
  }
  
  public opencv_core.IplImage createIplImageFrom(CLImage2d paramCLImage2d)
  {
    int i = paramCLImage2d.width;
    int j = paramCLImage2d.height;
    CLImageFormat localCLImageFormat = paramCLImage2d.getFormat();
    CLImageFormat.ChannelOrder localChannelOrder = localCLImageFormat.getImageChannelOrder();
    CLImageFormat.ChannelType localChannelType = localCLImageFormat.getImageChannelDataType();
    int k;
    switch (1.$SwitchMap$com$jogamp$opencl$CLImageFormat$ChannelOrder[localChannelOrder.ordinal()])
    {
    default: 
      boolean bool2 = $assertionsDisabled;
      k = 0;
      if (!bool2) {
        throw new AssertionError();
      }
      break;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      k = 1;
    }
    for (;;)
    {
      switch (localChannelType)
      {
      default: 
        boolean bool1 = $assertionsDisabled;
        m = 0;
        if (bool1) {
          break label240;
        }
        throw new AssertionError();
        k = 2;
        continue;
        k = 3;
        continue;
        k = 4;
      }
    }
    int m = -2147483640;
    for (;;)
    {
      label240:
      return opencv_core.IplImage.create(i, j, m, k);
      m = 8;
      continue;
      m = -2147483632;
      continue;
      m = 16;
      continue;
      m = -2147483616;
      continue;
      m = 32;
    }
  }
  
  public CLBuffer createPinnedBuffer(int paramInt)
  {
    CLContext localCLContext = this.context;
    CLMemory.Mem[] arrayOfMem = new CLMemory.Mem[1];
    arrayOfMem[0] = CLMemory.Mem.ALLOCATE_BUFFER;
    CLBuffer localCLBuffer = localCLContext.createBuffer(paramInt, arrayOfMem);
    localCLBuffer.use(this.commandQueue.putMapBuffer(localCLBuffer, CLMemory.Map.READ_WRITE, true));
    return localCLBuffer;
  }
  
  public opencv_core.IplImage createPinnedIplImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new PinnedIplImage(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void executeKernel(CLKernel paramCLKernel, long paramLong1, long paramLong2, long paramLong3)
  {
    this.commandQueue.put1DRangeKernel(paramCLKernel, paramLong1, paramLong2, paramLong3);
  }
  
  public void executeKernel(CLKernel paramCLKernel, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    this.commandQueue.put2DRangeKernel(paramCLKernel, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6);
  }
  
  public void executeKernel(CLKernel paramCLKernel, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9)
  {
    this.commandQueue.put3DRangeKernel(paramCLKernel, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramLong8, paramLong9);
  }
  
  public void executeKernel(CLKernel paramCLKernel, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, CLEventList paramCLEventList)
  {
    this.commandQueue.put3DRangeKernel(paramCLKernel, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramLong8, paramLong9, paramCLEventList);
  }
  
  public void executeKernel(CLKernel paramCLKernel, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, CLEventList paramCLEventList1, CLEventList paramCLEventList2)
  {
    this.commandQueue.put3DRangeKernel(paramCLKernel, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramLong8, paramLong9, paramCLEventList1, paramCLEventList2);
  }
  
  public void executeKernel(CLKernel paramCLKernel, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, CLEventList paramCLEventList)
  {
    this.commandQueue.put2DRangeKernel(paramCLKernel, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramCLEventList);
  }
  
  public void executeKernel(CLKernel paramCLKernel, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, CLEventList paramCLEventList1, CLEventList paramCLEventList2)
  {
    this.commandQueue.put2DRangeKernel(paramCLKernel, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramCLEventList1, paramCLEventList2);
  }
  
  public void executeKernel(CLKernel paramCLKernel, long paramLong1, long paramLong2, long paramLong3, CLEventList paramCLEventList)
  {
    this.commandQueue.put1DRangeKernel(paramCLKernel, paramLong1, paramLong2, paramLong3, paramCLEventList);
  }
  
  public void executeKernel(CLKernel paramCLKernel, long paramLong1, long paramLong2, long paramLong3, CLEventList paramCLEventList1, CLEventList paramCLEventList2)
  {
    this.commandQueue.put1DRangeKernel(paramCLKernel, paramLong1, paramLong2, paramLong3, paramCLEventList1, paramCLEventList2);
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    release();
  }
  
  public void finish()
  {
    this.commandQueue.finish();
  }
  
  public void flush()
  {
    this.commandQueue.flush();
  }
  
  public CLCommandQueue getCLCommandQueue()
  {
    return this.commandQueue;
  }
  
  public CLContext getCLContext()
  {
    return this.context;
  }
  
  public CLGLContext getCLGLContext()
  {
    if ((this.context instanceof CLGLContext)) {
      return (CLGLContext)this.context;
    }
    return null;
  }
  
  public GL getGL()
  {
    GLContext localGLContext = getGLContext();
    if (localGLContext != null) {
      return localGLContext.getGL();
    }
    return null;
  }
  
  public GL2 getGL2()
  {
    GL localGL = getGL();
    if (localGL != null) {
      return localGL.getGL2();
    }
    return null;
  }
  
  public GLContext getGLContext()
  {
    if ((this.context instanceof CLGLContext)) {
      return ((CLGLContext)this.context).getGLContext();
    }
    return null;
  }
  
  public GLU getGLU()
  {
    return this.glu;
  }
  
  public void pyrDown(CLImage2d paramCLImage2d1, CLImage2d paramCLImage2d2)
  {
    this.pyrDownKernel.putArg(paramCLImage2d1).putArg(paramCLImage2d2).rewind();
    executeKernel(this.pyrDownKernel, 0L, 0L, alignCeil(paramCLImage2d2.width, 2), alignCeil(paramCLImage2d2.height, 64), 2L, 64L, null);
  }
  
  public void readBuffer(CLBuffer<?> paramCLBuffer, boolean paramBoolean)
  {
    this.commandQueue.putReadBuffer(paramCLBuffer, paramBoolean);
  }
  
  public opencv_core.IplImage readImage(CLImage2d paramCLImage2d, opencv_core.IplImage paramIplImage, boolean paramBoolean)
  {
    if (paramIplImage == null) {
      paramIplImage = createIplImageFrom(paramCLImage2d);
    }
    int i = paramCLImage2d.width;
    int j = paramCLImage2d.height;
    int k = paramIplImage.widthStep();
    ByteBuffer localByteBuffer = paramIplImage.getByteBuffer();
    opencv_core.IplROI localIplROI = paramIplImage.roi();
    int m = 0;
    int n = 0;
    if (localIplROI != null)
    {
      m = localIplROI.xOffset();
      n = localIplROI.yOffset();
      i = localIplROI.width();
      j = localIplROI.height();
      int i1 = paramIplImage.nChannels() * ((0x7FFFFFFF & paramIplImage.depth()) / 8);
      localByteBuffer = paramIplImage.getByteBuffer(n * k + m * i1);
    }
    paramCLImage2d.use(localByteBuffer);
    this.commandQueue.putReadImage(paramCLImage2d, k, m, n, i, j, paramBoolean);
    return paramIplImage;
  }
  
  public void release()
  {
    if (!this.context.isReleased())
    {
      this.context.release();
      if (this.pbuffer != null)
      {
        this.pbuffer.getContext().makeCurrent();
        this.pbuffer.getContext().release();
        this.pbuffer.getContext().destroy();
        this.pbuffer.destroy();
      }
    }
  }
  
  public void releaseCLGLImage(CLGLImage2d paramCLGLImage2d)
  {
    paramCLGLImage2d.release();
    GL2 localGL2 = getGL2();
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = paramCLGLImage2d.getGLObjectID();
    localGL2.glDeleteRenderbuffers(1, arrayOfInt, 0);
  }
  
  public void releaseGLObject(CLObject paramCLObject)
  {
    if ((paramCLObject instanceof CLGLObject)) {
      this.commandQueue.putReleaseGLObject((CLGLObject)paramCLObject);
    }
  }
  
  public void remap(CLImage2d paramCLImage2d1, CLImage2d paramCLImage2d2, CLImage2d paramCLImage2d3, CLImage2d paramCLImage2d4)
  {
    remap(paramCLImage2d1, paramCLImage2d2, paramCLImage2d3, paramCLImage2d4, -1L);
  }
  
  public void remap(CLImage2d paramCLImage2d1, CLImage2d paramCLImage2d2, CLImage2d paramCLImage2d3, CLImage2d paramCLImage2d4, long paramLong)
  {
    if (paramLong != -1L) {}
    for (CLKernel localCLKernel = this.remapBayerKernel.putArg(paramCLImage2d1).putArg(paramCLImage2d2).putArg(paramCLImage2d3).putArg(paramCLImage2d4).putArg(paramLong).rewind();; localCLKernel = this.remapKernel.putArg(paramCLImage2d1).putArg(paramCLImage2d2).putArg(paramCLImage2d3).putArg(paramCLImage2d4).rewind())
    {
      executeKernel(localCLKernel, 0L, 0L, alignCeil(paramCLImage2d2.width, 2), alignCeil(paramCLImage2d2.height, 64), 2L, 64L, null);
      return;
    }
  }
  
  public void writeBuffer(CLBuffer<?> paramCLBuffer, boolean paramBoolean)
  {
    this.commandQueue.putWriteBuffer(paramCLBuffer, paramBoolean);
  }
  
  public CLImage2d writeImage(CLImage2d paramCLImage2d, opencv_core.IplImage paramIplImage, boolean paramBoolean)
  {
    if (paramCLImage2d == null) {
      paramCLImage2d = createCLImageFrom(paramIplImage, new CLMemory.Mem[0]);
    }
    int i = paramIplImage.width();
    int j = paramIplImage.height();
    int k = paramIplImage.widthStep();
    ByteBuffer localByteBuffer = paramIplImage.getByteBuffer();
    opencv_core.IplROI localIplROI = paramIplImage.roi();
    int m = 0;
    int n = 0;
    if (localIplROI != null)
    {
      m = localIplROI.xOffset();
      n = localIplROI.yOffset();
      i = localIplROI.width();
      j = localIplROI.height();
      int i1 = paramIplImage.nChannels() * ((0x7FFFFFFF & paramIplImage.depth()) / 8);
      localByteBuffer = paramIplImage.getByteBuffer(n * k + m * i1);
    }
    paramCLImage2d.use(localByteBuffer);
    this.commandQueue.putWriteImage(paramCLImage2d, k, m, n, i, j, paramBoolean);
    return paramCLImage2d;
  }
  
  class PinnedIplImage
    extends opencv_core.IplImage
  {
    final CLBuffer pinnedBuffer = JavaCVCL.this.createPinnedBuffer(imageSize());
    
    PinnedIplImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super();
      imageData(getByteBuffer());
    }
    
    public ByteBuffer getByteBuffer()
    {
      return (ByteBuffer)this.pinnedBuffer.getBuffer();
    }
    
    public CLBuffer getCLBuffer()
    {
      return this.pinnedBuffer;
    }
    
    public void release()
    {
      JavaCVCL.this.commandQueue.putUnmapMemory(this.pinnedBuffer, getByteBuffer());
      this.pinnedBuffer.release();
      opencv_core.cvReleaseImageHeader(this);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\JavaCVCL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */