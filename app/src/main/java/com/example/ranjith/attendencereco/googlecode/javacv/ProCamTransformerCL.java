package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.jogamp.common.os.Platform;
import com.jogamp.opencl.CLBuffer;
import com.jogamp.opencl.CLContext;
import com.jogamp.opencl.CLEventList;
import com.jogamp.opencl.CLImage2d;
import com.jogamp.opencl.CLImageFormat;
import com.jogamp.opencl.CLImageFormat.ChannelOrder;
import com.jogamp.opencl.CLImageFormat.ChannelType;
import com.jogamp.opencl.CLKernel;
import com.jogamp.opencl.CLMemory.Mem;
import java.nio.Buffer;
import java.nio.FloatBuffer;

public class ProCamTransformerCL
  extends ProCamTransformer
  implements ImageTransformerCL
{
  private static final ThreadLocal<opencv_core.CvMat> H13x3;
  private static final ThreadLocal<opencv_core.CvMat> H23x3;
  private static final ThreadLocal<opencv_core.CvMat> X4x4;
  protected final CLBuffer<FloatBuffer> H1Buffer;
  protected final CLBuffer<FloatBuffer> H2Buffer;
  protected final CLBuffer<FloatBuffer> XBuffer;
  protected final JavaCVCL context;
  private CLKernel dotKernel;
  protected final int nullSize;
  private CLKernel oneKernel;
  protected CLImage2d[] projectorImageCL = null;
  private CLKernel reduceKernel;
  private CLKernel subKernel;
  protected CLImage2d[] surfaceImageCL = null;
  
  static
  {
    if (!ProCamTransformerCL.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      H13x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      H23x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      X4x4 = opencv_core.CvMat.createThreadLocal(4, 4);
      return;
    }
  }
  
  public ProCamTransformerCL(JavaCVCL paramJavaCVCL, double[] paramArrayOfDouble, CameraDevice paramCameraDevice, ProjectorDevice paramProjectorDevice)
  {
    this(paramJavaCVCL, paramArrayOfDouble, paramCameraDevice, paramProjectorDevice, null);
  }
  
  public ProCamTransformerCL(JavaCVCL paramJavaCVCL, double[] paramArrayOfDouble, CameraDevice paramCameraDevice, ProjectorDevice paramProjectorDevice, opencv_core.CvMat paramCvMat)
  {
    super(paramArrayOfDouble, paramCameraDevice, paramProjectorDevice, paramCvMat);
    int i = createParameters().size();
    this.context = paramJavaCVCL;
    int j;
    if (Platform.is32Bit())
    {
      j = 4;
      this.nullSize = j;
      if (this.surfaceTransformer != null) {
        break label244;
      }
    }
    label244:
    CLContext localCLContext1;
    int k;
    CLMemory.Mem[] arrayOfMem1;
    for (CLBuffer localCLBuffer = null;; localCLBuffer = localCLContext1.createFloatBuffer(k, arrayOfMem1))
    {
      this.H1Buffer = localCLBuffer;
      CLContext localCLContext2 = paramJavaCVCL.getCLContext();
      int m = i * 9;
      CLMemory.Mem[] arrayOfMem2 = new CLMemory.Mem[1];
      arrayOfMem2[0] = CLMemory.Mem.READ_ONLY;
      this.H2Buffer = localCLContext2.createFloatBuffer(m, arrayOfMem2);
      CLContext localCLContext3 = paramJavaCVCL.getCLContext();
      int n = i * 16;
      CLMemory.Mem[] arrayOfMem3 = new CLMemory.Mem[1];
      arrayOfMem3[0] = CLMemory.Mem.READ_ONLY;
      this.XBuffer = localCLContext3.createFloatBuffer(n, arrayOfMem3);
      if (getClass() == ProCamTransformerCL.class)
      {
        CLKernel[] arrayOfCLKernel = paramJavaCVCL.buildKernels("-cl-fast-relaxed-math -cl-mad-enable -cl-nv-maxrregcount=32 -DDOT_SIZE=" + i, "ImageTransformer.cl:ProCamTransformer.cl", new String[] { "transformOne", "transformSub", "transformDot", "reduceOutputData" });
        this.oneKernel = arrayOfCLKernel[0];
        this.subKernel = arrayOfCLKernel[1];
        this.dotKernel = arrayOfCLKernel[2];
        this.reduceKernel = arrayOfCLKernel[3];
      }
      return;
      j = 8;
      break;
      localCLContext1 = paramJavaCVCL.getCLContext();
      k = i * 9;
      arrayOfMem1 = new CLMemory.Mem[1];
      arrayOfMem1[0] = CLMemory.Mem.READ_ONLY;
    }
  }
  
  public JavaCVCL getContext()
  {
    return this.context;
  }
  
  public CLImage2d getProjectorImageCL(int paramInt)
  {
    return this.projectorImageCL[paramInt];
  }
  
  public ProjectiveColorTransformerCL getProjectorTransformerCL()
  {
    return (ProjectiveColorTransformerCL)this.projectorTransformer;
  }
  
  public CLImage2d getSurfaceImageCL(int paramInt)
  {
    return this.surfaceImageCL[paramInt];
  }
  
  public ProjectiveColorTransformerCL getSurfaceTransformerCL()
  {
    return (ProjectiveColorTransformerCL)this.surfaceTransformer;
  }
  
  protected void prepareTransforms(CLBuffer paramCLBuffer1, CLBuffer paramCLBuffer2, CLBuffer paramCLBuffer3, int paramInt, ImageTransformer.Parameters[] paramArrayOfParameters)
  {
    FloatBuffer localFloatBuffer1;
    FloatBuffer localFloatBuffer2;
    FloatBuffer localFloatBuffer3;
    opencv_core.CvMat localCvMat1;
    opencv_core.CvMat localCvMat2;
    opencv_core.CvMat localCvMat3;
    if (this.surfaceTransformer == null)
    {
      localFloatBuffer1 = null;
      localFloatBuffer2 = (FloatBuffer)paramCLBuffer2.getBuffer().rewind();
      localFloatBuffer3 = (FloatBuffer)paramCLBuffer3.getBuffer().rewind();
      localCvMat1 = (opencv_core.CvMat)H13x3.get();
      localCvMat2 = (opencv_core.CvMat)H23x3.get();
      localCvMat3 = (opencv_core.CvMat)X4x4.get();
    }
    for (int i = 0;; i++)
    {
      if (i >= paramArrayOfParameters.length) {
        break label217;
      }
      if (this.surfaceTransformer == null) {}
      for (opencv_core.CvMat localCvMat4 = null;; localCvMat4 = localCvMat1)
      {
        prepareTransforms(localCvMat4, localCvMat2, localCvMat3, paramInt, (ProCamTransformer.Parameters)paramArrayOfParameters[i]);
        for (int j = 0; j < 9; j++)
        {
          if (this.surfaceTransformer != null) {
            localFloatBuffer1.put((float)localCvMat1.get(j));
          }
          localFloatBuffer2.put((float)localCvMat2.get(j));
        }
        localFloatBuffer1 = (FloatBuffer)paramCLBuffer1.getBuffer().rewind();
        break;
      }
      for (int k = 0; k < 16; k++) {
        localFloatBuffer3.put((float)localCvMat3.get(k));
      }
    }
    label217:
    if (this.surfaceTransformer != null) {
      localFloatBuffer1.rewind();
    }
    localFloatBuffer2.rewind();
    localFloatBuffer3.rewind();
  }
  
  public void setProjectorImageCL(CLImage2d paramCLImage2d, int paramInt1, int paramInt2)
  {
    if ((this.projectorImageCL == null) || (this.projectorImageCL.length != paramInt2 + 1)) {
      this.projectorImageCL = new CLImage2d[paramInt2 + 1];
    }
    this.projectorImageCL[paramInt1] = paramCLImage2d;
    for (int i = paramInt1 + 1; i <= paramInt2; i++)
    {
      if (this.projectorImageCL[i] == null)
      {
        int j = this.projectorImageCL[(i - 1)].width / 2;
        int k = this.projectorImageCL[(i - 1)].height / 2;
        CLImageFormat localCLImageFormat = new CLImageFormat(CLImageFormat.ChannelOrder.RGBA, CLImageFormat.ChannelType.FLOAT);
        this.projectorImageCL[i] = this.context.getCLContext().createImage2d(j, k, localCLImageFormat, new CLMemory.Mem[0]);
      }
      this.context.pyrDown(this.projectorImageCL[(i - 1)], this.projectorImageCL[i]);
    }
  }
  
  public void setSurfaceImageCL(CLImage2d paramCLImage2d, int paramInt)
  {
    if ((this.surfaceImageCL == null) || (this.surfaceImageCL.length != paramInt)) {
      this.surfaceImageCL = new CLImage2d[paramInt];
    }
    this.surfaceImageCL[0] = paramCLImage2d;
    for (int i = 1; i < paramInt; i++)
    {
      if (this.surfaceImageCL[i] == null)
      {
        int j = this.surfaceImageCL[(i - 1)].width / 2;
        int k = this.surfaceImageCL[(i - 1)].height / 2;
        CLImageFormat localCLImageFormat = new CLImageFormat(CLImageFormat.ChannelOrder.RGBA, CLImageFormat.ChannelType.FLOAT);
        this.surfaceImageCL[i] = this.context.getCLContext().createImage2d(j, k, localCLImageFormat, new CLMemory.Mem[0]);
      }
      this.context.pyrDown(this.surfaceImageCL[(i - 1)], this.surfaceImageCL[i]);
    }
  }
  
  public void transform(CLImage2d paramCLImage2d1, CLImage2d paramCLImage2d2, CLImage2d paramCLImage2d3, CLImage2d paramCLImage2d4, CLImage2d paramCLImage2d5, CLImage2d paramCLImage2d6, ImageTransformer.Parameters[] paramArrayOfParameters, boolean[] paramArrayOfBoolean, ImageTransformerCL.InputData paramInputData, ImageTransformerCL.OutputData paramOutputData)
  {
    if (paramArrayOfBoolean != null) {
      for (int n = 0;; n++)
      {
        int i1 = paramArrayOfBoolean.length;
        if (n >= i1) {
          break;
        }
        if (paramArrayOfBoolean[n] != 0) {
          throw new UnsupportedOperationException("Inverse transform not supported.");
        }
      }
    }
    prepareTransforms(this.H1Buffer, this.H2Buffer, this.XBuffer, paramInputData.pyramidLevel, paramArrayOfParameters);
    int i = paramArrayOfParameters[0].size();
    int j;
    if (paramArrayOfParameters.length > 1) {
      j = paramArrayOfParameters.length;
    }
    int k;
    int m;
    CLBuffer localCLBuffer1;
    CLBuffer localCLBuffer2;
    CLEventList localCLEventList;
    CLImage2d localCLImage2d;
    for (;;)
    {
      k = JavaCVCL.alignCeil(paramInputData.roiWidth, j);
      m = k / j;
      localCLBuffer1 = paramInputData.getBuffer(this.context);
      localCLBuffer2 = paramOutputData.getBuffer(this.context, i, m);
      localCLEventList = new CLEventList(1);
      if (this.surfaceTransformer != null) {
        this.context.writeBuffer(this.H1Buffer, false);
      }
      this.context.writeBuffer(this.H2Buffer, false);
      this.context.writeBuffer(this.XBuffer, false);
      if (paramInputData.autoWrite) {
        paramInputData.writeBuffer(this.context);
      }
      localCLImage2d = this.projectorImageCL[paramInputData.pyramidLevel];
      if (paramCLImage2d2 != null) {
        break label446;
      }
      if (($assertionsDisabled) || (paramArrayOfParameters.length == 1)) {
        break;
      }
      throw new AssertionError();
      if (paramInputData.roiWidth > 32) {
        j = 64;
      } else {
        j = 32;
      }
    }
    CLKernel localCLKernel2 = this.oneKernel.putArg(localCLImage2d).putArg(paramCLImage2d1);
    CLKernel localCLKernel1;
    if (paramCLImage2d5 == null)
    {
      localCLKernel1 = localCLKernel2.putArg(paramCLImage2d4).putArg(paramCLImage2d6).putArg(this.H2Buffer);
      label308:
      if (this.H1Buffer == null) {
        break label575;
      }
      localCLKernel1.putArg(this.H1Buffer);
    }
    for (;;)
    {
      localCLKernel1.putArg(this.XBuffer).putArg(localCLBuffer1).putArg(localCLBuffer2).rewind();
      this.context.executeKernel(localCLKernel1, paramInputData.roiX, 0L, 0L, k, 1L, paramArrayOfParameters.length, j, 1L, paramArrayOfParameters.length, localCLEventList);
      if (m > 1)
      {
        this.reduceKernel.putArg(localCLBuffer2).rewind();
        this.context.executeKernel(this.reduceKernel, 0L, m, m);
      }
      if (paramOutputData.autoRead) {
        paramOutputData.readBuffer(this.context);
      }
      return;
      paramCLImage2d4 = paramCLImage2d5;
      break;
      label446:
      if (paramCLImage2d3 == null)
      {
        assert (paramArrayOfParameters.length == 1);
        localCLKernel1 = this.subKernel.putArg(localCLImage2d).putArg(paramCLImage2d1).putArg(paramCLImage2d2).putArg(paramCLImage2d4).putArg(paramCLImage2d5).putArg(paramCLImage2d6).putArg(this.H2Buffer);
        break label308;
      }
      assert (paramArrayOfParameters.length == i);
      localCLKernel1 = this.dotKernel.putArg(localCLImage2d).putArg(paramCLImage2d1).putArg(paramCLImage2d2).putArg(paramCLImage2d3).putArg(paramCLImage2d6).putArg(this.H2Buffer);
      break label308;
      label575:
      localCLKernel1.putNullArg(this.nullSize);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\ProCamTransformerCL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */