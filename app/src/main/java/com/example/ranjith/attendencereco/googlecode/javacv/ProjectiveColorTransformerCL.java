package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.jogamp.opencl.CLBuffer;
import com.jogamp.opencl.CLContext;
import com.jogamp.opencl.CLEventList;
import com.jogamp.opencl.CLImage2d;
import com.jogamp.opencl.CLKernel;
import com.jogamp.opencl.CLMemory.Mem;
import java.nio.Buffer;
import java.nio.FloatBuffer;

public class ProjectiveColorTransformerCL
  extends ProjectiveColorTransformer
  implements ImageTransformerCL
{
  protected final CLBuffer<FloatBuffer> HBuffer;
  protected final CLBuffer<FloatBuffer> XBuffer;
  protected final JavaCVCL context;
  private CLKernel dotKernel;
  private CLKernel oneKernel;
  private CLKernel reduceKernel;
  private CLKernel subKernel;
  
  static
  {
    if (!ProjectiveColorTransformerCL.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ProjectiveColorTransformerCL(JavaCVCL paramJavaCVCL, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, opencv_core.CvMat paramCvMat6, int paramInt1, int paramInt2)
  {
    super(paramCvMat1, paramCvMat2, paramCvMat3, paramCvMat4, paramCvMat5, paramArrayOfDouble1, paramArrayOfDouble2, paramCvMat6, paramInt1, paramInt2);
    int i = createParameters().size();
    this.context = paramJavaCVCL;
    CLContext localCLContext1 = paramJavaCVCL.getCLContext();
    int j = i * 9;
    CLMemory.Mem[] arrayOfMem1 = new CLMemory.Mem[1];
    arrayOfMem1[0] = CLMemory.Mem.READ_ONLY;
    this.HBuffer = localCLContext1.createFloatBuffer(j, arrayOfMem1);
    CLContext localCLContext2 = paramJavaCVCL.getCLContext();
    int k = i * 16;
    CLMemory.Mem[] arrayOfMem2 = new CLMemory.Mem[1];
    arrayOfMem2[0] = CLMemory.Mem.READ_ONLY;
    this.XBuffer = localCLContext2.createFloatBuffer(k, arrayOfMem2);
    if (getClass() == ProjectiveColorTransformerCL.class)
    {
      CLKernel[] arrayOfCLKernel = paramJavaCVCL.buildKernels("-cl-fast-relaxed-math -cl-mad-enable -DDOT_SIZE=" + i, "ImageTransformer.cl:ProjectiveColorTransformer.cl", new String[] { "transformOne", "transformSub", "transformDot", "reduceOutputData" });
      this.oneKernel = arrayOfCLKernel[0];
      this.subKernel = arrayOfCLKernel[1];
      this.dotKernel = arrayOfCLKernel[2];
      this.reduceKernel = arrayOfCLKernel[3];
    }
  }
  
  public JavaCVCL getContext()
  {
    return this.context;
  }
  
  protected void prepareColorTransforms(CLBuffer paramCLBuffer, int paramInt, ImageTransformer.Parameters[] paramArrayOfParameters, boolean[] paramArrayOfBoolean)
  {
    FloatBuffer localFloatBuffer = (FloatBuffer)paramCLBuffer.getBuffer().rewind();
    opencv_core.CvMat localCvMat = (opencv_core.CvMat)X24x4.get();
    for (int i = 0; i < paramArrayOfParameters.length; i++)
    {
      ProjectiveColorTransformer.Parameters localParameters = (ProjectiveColorTransformer.Parameters)paramArrayOfParameters[i];
      if (paramArrayOfBoolean == null) {}
      int j;
      for (boolean bool = false;; j = paramArrayOfBoolean[i])
      {
        prepareColorTransform(localCvMat, paramInt, localParameters, bool);
        for (int k = 0; k < 16; k++) {
          localFloatBuffer.put((float)localCvMat.get(k));
        }
      }
    }
    localFloatBuffer.rewind();
  }
  
  protected void prepareHomographies(CLBuffer paramCLBuffer, int paramInt, ImageTransformer.Parameters[] paramArrayOfParameters, boolean[] paramArrayOfBoolean)
  {
    FloatBuffer localFloatBuffer = (FloatBuffer)paramCLBuffer.getBuffer().rewind();
    opencv_core.CvMat localCvMat = (opencv_core.CvMat)H3x3.get();
    for (int i = 0; i < paramArrayOfParameters.length; i++)
    {
      ProjectiveColorTransformer.Parameters localParameters = (ProjectiveColorTransformer.Parameters)paramArrayOfParameters[i];
      if (paramArrayOfBoolean == null) {}
      int j;
      for (boolean bool = false;; j = paramArrayOfBoolean[i])
      {
        prepareHomography(localCvMat, paramInt, localParameters, bool);
        for (int k = 0; k < 9; k++) {
          localFloatBuffer.put((float)localCvMat.get(k));
        }
      }
    }
    localFloatBuffer.rewind();
  }
  
  public void transform(CLImage2d paramCLImage2d1, CLImage2d paramCLImage2d2, CLImage2d paramCLImage2d3, CLImage2d paramCLImage2d4, CLImage2d paramCLImage2d5, CLImage2d paramCLImage2d6, ImageTransformer.Parameters[] paramArrayOfParameters, boolean[] paramArrayOfBoolean, ImageTransformerCL.InputData paramInputData, ImageTransformerCL.OutputData paramOutputData)
  {
    prepareHomographies(this.HBuffer, paramInputData.pyramidLevel, paramArrayOfParameters, paramArrayOfBoolean);
    prepareColorTransforms(this.XBuffer, paramInputData.pyramidLevel, paramArrayOfParameters, paramArrayOfBoolean);
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
    for (;;)
    {
      k = JavaCVCL.alignCeil(paramInputData.roiWidth, j);
      m = k / j;
      localCLBuffer1 = paramInputData.getBuffer(this.context);
      localCLBuffer2 = paramOutputData.getBuffer(this.context, i, m);
      localCLEventList = new CLEventList(1);
      this.context.writeBuffer(this.HBuffer, false);
      this.context.writeBuffer(this.XBuffer, false);
      if (paramInputData.autoWrite) {
        paramInputData.writeBuffer(this.context);
      }
      if (paramCLImage2d2 != null) {
        break label357;
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
    CLKernel localCLKernel2 = this.oneKernel.putArg(paramCLImage2d1);
    CLKernel localCLKernel1;
    if (paramCLImage2d5 == null) {
      localCLKernel1 = localCLKernel2.putArg(paramCLImage2d4).putArg(paramCLImage2d6).putArg(this.HBuffer).putArg(this.XBuffer).putArg(localCLBuffer1).putArg(localCLBuffer2).rewind();
    }
    for (;;)
    {
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
      label357:
      if (paramCLImage2d3 == null)
      {
        assert (paramArrayOfParameters.length == 1);
        localCLKernel1 = this.subKernel.putArg(paramCLImage2d1).putArg(paramCLImage2d2).putArg(paramCLImage2d4).putArg(paramCLImage2d5).putArg(paramCLImage2d6).putArg(this.HBuffer).putArg(this.XBuffer).putArg(localCLBuffer1).putArg(localCLBuffer2).rewind();
      }
      else
      {
        assert (paramArrayOfParameters.length == i);
        localCLKernel1 = this.dotKernel.putArg(paramCLImage2d1).putArg(paramCLImage2d2).putArg(paramCLImage2d3).putArg(paramCLImage2d6).putArg(this.HBuffer).putArg(this.XBuffer).putArg(localCLBuffer1).putArg(localCLBuffer2).rewind();
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\ProjectiveColorTransformerCL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */