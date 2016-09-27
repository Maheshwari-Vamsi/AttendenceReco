package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.jogamp.opencl.CLImage2d;
import com.jogamp.opencl.CLImageFormat;
import com.jogamp.opencl.CLImageFormat.ChannelOrder;
import com.jogamp.opencl.CLImageFormat.ChannelType;
import com.jogamp.opencl.CLMemory.Mem;
import com.jogamp.opencl.gl.CLGLContext;
import com.jogamp.opencl.gl.CLGLImage2d;
import java.io.PrintStream;
import java.nio.FloatBuffer;
import java.util.Arrays;
import javax.media.opengl.GL2;
import javax.media.opengl.GLContext;
import javax.media.opengl.glu.GLU;

public class GNImageAlignerCL
  extends GNImageAligner
  implements ImageAlignerCL
{
  private final JavaCVCL context;
  private CLImage2d[] imagesCL = new CLImage2d[5];
  private ImageTransformerCL.InputData inputData;
  private CLGLImage2d[] maskCL;
  private int[] maskfb;
  private int[] maskrb;
  private ImageTransformerCL.OutputData outputData;
  private CLImage2d[] residualCL;
  private CLImage2d[] targetCL;
  private CLImage2d[] templateCL;
  private boolean[] templateChanged;
  private CLImage2d[] transformedCL;
  
  static
  {
    if (!GNImageAlignerCL.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public GNImageAlignerCL(ImageTransformerCL paramImageTransformerCL, ImageTransformer.Parameters paramParameters, CLImage2d paramCLImage2d1, double[] paramArrayOfDouble, CLImage2d paramCLImage2d2)
  {
    this(paramImageTransformerCL, paramParameters, paramCLImage2d1, paramArrayOfDouble, paramCLImage2d2, new GNImageAligner.Settings());
  }
  
  public GNImageAlignerCL(ImageTransformerCL paramImageTransformerCL, ImageTransformer.Parameters paramParameters, CLImage2d paramCLImage2d1, double[] paramArrayOfDouble, CLImage2d paramCLImage2d2, GNImageAligner.Settings paramSettings)
  {
    super(paramImageTransformerCL, paramParameters);
    setSettings(paramSettings);
    this.context = paramImageTransformerCL.getContext();
    int i = paramSettings.pyramidLevelMin;
    int j = paramSettings.pyramidLevelMax;
    this.template = new opencv_core.IplImage[j + 1];
    this.target = new opencv_core.IplImage[j + 1];
    this.transformed = new opencv_core.IplImage[j + 1];
    this.residual = new opencv_core.IplImage[j + 1];
    this.mask = new opencv_core.IplImage[j + 1];
    this.templateCL = new CLImage2d[j + 1];
    this.targetCL = new CLImage2d[j + 1];
    this.transformedCL = new CLImage2d[j + 1];
    this.residualCL = new CLImage2d[j + 1];
    this.maskCL = new CLGLImage2d[j + 1];
    this.maskrb = new int[j + 1];
    this.maskfb = new int[j + 1];
    int k;
    int m;
    label194:
    CLGLContext localCLGLContext;
    GL2 localGL2;
    CLImageFormat localCLImageFormat;
    if (paramCLImage2d1 != null)
    {
      k = paramCLImage2d1.width;
      if (paramCLImage2d1 == null) {
        break label475;
      }
      m = paramCLImage2d1.height;
      localCLGLContext = this.context.getCLGLContext();
      localGL2 = this.context.getGL2();
      localGL2.glGenRenderbuffers(j + 1, this.maskrb, 0);
      localGL2.glGenFramebuffers(j + 1, this.maskfb, 0);
      localCLImageFormat = new CLImageFormat(CLImageFormat.ChannelOrder.RGBA, CLImageFormat.ChannelType.FLOAT);
    }
    for (int n = i;; n++)
    {
      if (n > j) {
        break label628;
      }
      CLImage2d[] arrayOfCLImage2d1 = this.templateCL;
      CLImage2d localCLImage2d1;
      label290:
      CLImage2d[] arrayOfCLImage2d2;
      if ((n == i) && (paramCLImage2d1 != null))
      {
        localCLImage2d1 = paramCLImage2d1;
        arrayOfCLImage2d1[n] = localCLImage2d1;
        arrayOfCLImage2d2 = this.targetCL;
        if ((n != i) || (paramCLImage2d2 == null)) {
          break label505;
        }
      }
      label475:
      label505:
      for (CLImage2d localCLImage2d2 = paramCLImage2d2;; localCLImage2d2 = localCLGLContext.createImage2d(k, m, localCLImageFormat, new CLMemory.Mem[0]))
      {
        arrayOfCLImage2d2[n] = localCLImage2d2;
        this.transformedCL[n] = localCLGLContext.createImage2d(k, m, localCLImageFormat, new CLMemory.Mem[0]);
        this.residualCL[n] = localCLGLContext.createImage2d(k, m, localCLImageFormat, new CLMemory.Mem[0]);
        localGL2.glBindRenderbuffer(36161, this.maskrb[n]);
        localGL2.glBindFramebuffer(36160, this.maskfb[n]);
        localGL2.glRenderbufferStorage(36161, 32832, k, m);
        localGL2.glFramebufferRenderbuffer(36160, 36064, 36161, this.maskrb[n]);
        if (($assertionsDisabled) || (localGL2.glCheckFramebufferStatus(36160) == 36053)) {
          break label525;
        }
        throw new AssertionError();
        k = paramCLImage2d2.width;
        break;
        m = paramCLImage2d2.height;
        break label194;
        localCLImage2d1 = localCLGLContext.createImage2d(k, m, localCLImageFormat, new CLMemory.Mem[0]);
        break label290;
      }
      label525:
      this.maskCL[n] = localCLGLContext.createFromGLRenderbuffer(this.maskrb[n], new CLMemory.Mem[0]);
      System.out.println(this.maskCL[n] + " " + this.maskCL[n].getElementSize() + " " + this.maskCL[n].getFormat());
      k /= 2;
      m /= 2;
    }
    label628:
    this.inputData = new ImageTransformerCL.InputData();
    this.outputData = new ImageTransformerCL.OutputData(false);
    this.templateChanged = new boolean[j + 1];
    Arrays.fill(this.templateChanged, true);
    setConstrained(paramSettings.constrained);
    setTemplateImageCL(paramCLImage2d1, paramArrayOfDouble);
    setTargetImageCL(paramCLImage2d2);
  }
  
  protected void doHessianGradient(double[] paramArrayOfDouble)
  {
    final double d1 = this.parameters.getConstraintError();
    final double d2 = this.settings.stepSize;
    opencv_core.cvSetZero(this.gradient);
    opencv_core.cvSetZero(this.hessian);
    Parallel.loop(0, this.n, new Parallel.Looper()
    {
      public void loop(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        for (int i = paramAnonymousInt1; i < paramAnonymousInt2; i++)
        {
          GNImageAlignerCL.this.tempParameters[i].set(GNImageAlignerCL.this.parameters);
          GNImageAlignerCL.this.tempParameters[i].set(i, GNImageAlignerCL.this.tempParameters[i].get(i) + d2);
          d1[i] = (GNImageAlignerCL.this.tempParameters[i].get(i) - GNImageAlignerCL.this.parameters.get(i));
          GNImageAlignerCL.this.constraintGrad[i] = (GNImageAlignerCL.this.tempParameters[i].getConstraintError() - this.val$constraintError);
        }
      }
    });
    this.inputData.zeroThreshold = this.settings.thresholdsZero[Math.min(-1 + this.settings.thresholdsZero.length, this.pyramidLevel)];
    this.inputData.outlierThreshold = this.settings.thresholdsOutlier[Math.min(-1 + this.settings.thresholdsOutlier.length, this.pyramidLevel)];
    if (this.settings.thresholdsMulRMSE)
    {
      ImageTransformerCL.InputData localInputData1 = this.inputData;
      localInputData1.zeroThreshold *= this.RMSE;
      ImageTransformerCL.InputData localInputData2 = this.inputData;
      localInputData2.outlierThreshold *= this.RMSE;
    }
    this.inputData.pyramidLevel = this.pyramidLevel;
    this.context.acquireGLObject(this.maskCL[this.pyramidLevel]);
    ((ImageTransformerCL)this.transformer).transform(this.templateCL[this.pyramidLevel], this.transformedCL[this.pyramidLevel], this.residualCL[this.pyramidLevel], null, null, this.maskCL[this.pyramidLevel], this.tempParameters, null, this.inputData, this.outputData);
    this.context.releaseGLObject(this.maskCL[this.pyramidLevel]);
    doRegularization(this.updateScale);
    this.outputData.readBuffer(this.context);
    for (int i = 0;; i++)
    {
      int j = this.n;
      if (i >= j) {
        break;
      }
      opencv_core.CvMat localCvMat1 = this.gradient;
      double d3 = this.gradient.get(i) - this.outputData.srcDstDot.get(i);
      localCvMat1.put(i, d3);
      for (int k = 0;; k++)
      {
        int m = this.n;
        if (k >= m) {
          break;
        }
        opencv_core.CvMat localCvMat2 = this.hessian;
        double d4 = this.hessian.get(i, k) + this.outputData.dstDstDot.get(k + i * this.n);
        localCvMat2.put(i, k, d4);
      }
    }
  }
  
  protected void doResidual()
  {
    this.parameters.getConstraintError();
    this.inputData.zeroThreshold = this.settings.thresholdsZero[Math.min(-1 + this.settings.thresholdsZero.length, this.pyramidLevel)];
    this.inputData.outlierThreshold = this.settings.thresholdsOutlier[Math.min(-1 + this.settings.thresholdsOutlier.length, this.pyramidLevel)];
    if (this.settings.thresholdsMulRMSE)
    {
      ImageTransformerCL.InputData localInputData1 = this.inputData;
      localInputData1.zeroThreshold *= this.RMSE;
      ImageTransformerCL.InputData localInputData2 = this.inputData;
      localInputData2.outlierThreshold *= this.RMSE;
    }
    this.inputData.pyramidLevel = this.pyramidLevel;
    this.context.acquireGLObject(this.maskCL[this.pyramidLevel]);
    ((ImageTransformerCL)this.transformer).transform(this.templateCL[this.pyramidLevel], this.targetCL[this.pyramidLevel], null, this.transformedCL[this.pyramidLevel], this.residualCL[this.pyramidLevel], this.maskCL[this.pyramidLevel], this.parametersArray, null, this.inputData, this.outputData);
    this.context.releaseGLObject(this.maskCL[this.pyramidLevel]);
    this.outputData.readBuffer(this.context);
    double d1 = this.outputData.dstDstDot.get(0);
    int i = this.outputData.dstCount;
    if (i < this.n) {}
    for (double d2 = NaN.0D;; d2 = Math.sqrt(d1 / i))
    {
      this.RMSE = d2;
      this.residualUpdateNeeded = false;
      return;
    }
  }
  
  protected void doRoi()
  {
    this.transformer.transform(this.srcRoiPts, this.dstRoiPts, this.parameters, false);
    double[] arrayOfDouble = this.dstRoiPts.get();
    for (int i = 0; i < arrayOfDouble.length; i++) {
      arrayOfDouble[i] /= (1 << this.pyramidLevel);
    }
    this.roi.x(0).y(0).width(this.maskCL[this.pyramidLevel].width).height(this.maskCL[this.pyramidLevel].height);
    JavaCV.boundingRect(arrayOfDouble, this.roi, 3, 3, 16, 1);
    this.inputData.roiX = this.roi.x();
    this.inputData.roiY = this.roi.y();
    this.inputData.roiWidth = this.roi.width();
    this.inputData.roiHeight = this.roi.height();
    GL2 localGL2 = this.context.getGL2();
    localGL2.glBindFramebuffer(36160, this.maskfb[this.pyramidLevel]);
    localGL2.glMatrixMode(5889);
    localGL2.glLoadIdentity();
    this.context.getGLU().gluOrtho2D(0.0F, this.maskCL[this.pyramidLevel].width, 0.0F, this.maskCL[this.pyramidLevel].height);
    localGL2.glMatrixMode(5888);
    localGL2.glLoadIdentity();
    localGL2.glViewport(0, 0, this.maskCL[this.pyramidLevel].width, this.maskCL[this.pyramidLevel].height);
    localGL2.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    localGL2.glClear(16384);
    localGL2.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    localGL2.glBegin(9);
    localGL2.glVertex2d(arrayOfDouble[0], arrayOfDouble[1]);
    localGL2.glVertex2d(1.0D + arrayOfDouble[2], arrayOfDouble[3]);
    localGL2.glVertex2d(1.0D + arrayOfDouble[4], 1.0D + arrayOfDouble[5]);
    localGL2.glVertex2d(arrayOfDouble[6], 1.0D + arrayOfDouble[7]);
    localGL2.glEnd();
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    release();
  }
  
  public opencv_core.IplImage[] getImages()
  {
    return getImages(true);
  }
  
  public opencv_core.IplImage[] getImages(boolean paramBoolean)
  {
    this.images[0] = getTemplateImage(false);
    this.images[1] = getTargetImage(false);
    this.images[2] = getTransformedImage(false);
    this.images[3] = getResidualImage(false);
    this.images[4] = getMaskImage(paramBoolean);
    return this.images;
  }
  
  public CLImage2d[] getImagesCL()
  {
    this.imagesCL[0] = this.templateCL[this.pyramidLevel];
    this.imagesCL[1] = this.targetCL[this.pyramidLevel];
    this.imagesCL[2] = this.transformedCL[this.pyramidLevel];
    this.imagesCL[3] = this.residualCL[this.pyramidLevel];
    this.imagesCL[4] = this.maskCL[this.pyramidLevel];
    return this.imagesCL;
  }
  
  public opencv_core.IplImage getMaskImage()
  {
    return getMaskImage(true);
  }
  
  public opencv_core.IplImage getMaskImage(boolean paramBoolean)
  {
    this.context.acquireGLObject(this.maskCL[this.pyramidLevel]);
    this.mask[this.pyramidLevel] = this.context.readImage(getMaskImageCL(), this.mask[this.pyramidLevel], paramBoolean);
    this.context.releaseGLObject(this.maskCL[this.pyramidLevel]);
    return this.mask[this.pyramidLevel];
  }
  
  public CLImage2d getMaskImageCL()
  {
    return this.maskCL[this.pyramidLevel];
  }
  
  public int getOutlierCount()
  {
    return this.outputData.dstCountOutlier;
  }
  
  public int getPixelCount()
  {
    if (this.residualUpdateNeeded)
    {
      doRoi();
      doResidual();
    }
    return this.outputData.dstCount;
  }
  
  public double getRMSE()
  {
    if (this.residualUpdateNeeded)
    {
      doRoi();
      doResidual();
    }
    return this.RMSE;
  }
  
  public opencv_core.IplImage getResidualImage()
  {
    return getResidualImage(true);
  }
  
  public opencv_core.IplImage getResidualImage(boolean paramBoolean)
  {
    opencv_core.IplImage[] arrayOfIplImage = this.residual;
    int i = this.pyramidLevel;
    opencv_core.IplImage localIplImage = this.context.readImage(getResidualImageCL(), this.residual[this.pyramidLevel], paramBoolean);
    arrayOfIplImage[i] = localIplImage;
    return localIplImage;
  }
  
  public CLImage2d getResidualImageCL()
  {
    if (this.residualUpdateNeeded)
    {
      doRoi();
      doResidual();
    }
    return this.residualCL[this.pyramidLevel];
  }
  
  public opencv_core.CvRect getRoi()
  {
    if (this.residualUpdateNeeded) {
      doRoi();
    }
    return this.roi.x(this.inputData.roiX).y(this.inputData.roiY).width(this.inputData.roiWidth).height(this.inputData.roiHeight);
  }
  
  public opencv_core.IplImage getTargetImage()
  {
    return getTargetImage(true);
  }
  
  public opencv_core.IplImage getTargetImage(boolean paramBoolean)
  {
    opencv_core.IplImage[] arrayOfIplImage = this.target;
    int i = this.pyramidLevel;
    opencv_core.IplImage localIplImage = this.context.readImage(getTargetImageCL(), this.target[this.pyramidLevel], paramBoolean);
    arrayOfIplImage[i] = localIplImage;
    return localIplImage;
  }
  
  public CLImage2d getTargetImageCL()
  {
    return this.targetCL[this.pyramidLevel];
  }
  
  public opencv_core.IplImage getTemplateImage()
  {
    return getTemplateImage(true);
  }
  
  public opencv_core.IplImage getTemplateImage(boolean paramBoolean)
  {
    if (this.templateChanged[this.pyramidLevel] != 0)
    {
      this.templateChanged[this.pyramidLevel] = false;
      opencv_core.IplImage[] arrayOfIplImage = this.template;
      int i = this.pyramidLevel;
      opencv_core.IplImage localIplImage = this.context.readImage(getTemplateImageCL(), this.template[this.pyramidLevel], paramBoolean);
      arrayOfIplImage[i] = localIplImage;
      return localIplImage;
    }
    return this.template[this.pyramidLevel];
  }
  
  public CLImage2d getTemplateImageCL()
  {
    return this.templateCL[this.pyramidLevel];
  }
  
  public opencv_core.IplImage getTransformedImage()
  {
    return getTransformedImage(true);
  }
  
  public opencv_core.IplImage getTransformedImage(boolean paramBoolean)
  {
    opencv_core.IplImage[] arrayOfIplImage = this.transformed;
    int i = this.pyramidLevel;
    opencv_core.IplImage localIplImage = this.context.readImage(getTransformedImageCL(), this.transformed[this.pyramidLevel], paramBoolean);
    arrayOfIplImage[i] = localIplImage;
    return localIplImage;
  }
  
  public CLImage2d getTransformedImageCL()
  {
    if (this.residualUpdateNeeded)
    {
      doRoi();
      doResidual();
    }
    return this.transformedCL[this.pyramidLevel];
  }
  
  public void release()
  {
    int i = this.settings.pyramidLevelMin;
    int j = this.settings.pyramidLevelMax;
    if ((this.templateCL != null) && (this.targetCL != null) && (this.transformedCL != null) && (this.residualCL != null) && (this.maskCL != null))
    {
      for (int k = i; k <= j; k++)
      {
        if (k > i) {
          this.templateCL[k].release();
        }
        if (k > i) {
          this.targetCL[k].release();
        }
        this.transformedCL[k].release();
        this.residualCL[k].release();
        this.maskCL[k].release();
      }
      this.maskCL = null;
      this.residualCL = null;
      this.transformedCL = null;
      this.targetCL = null;
      this.templateCL = null;
    }
    this.context.getGLContext().makeCurrent();
    GL2 localGL2 = this.context.getGL2();
    if (this.maskfb != null)
    {
      localGL2.glDeleteFramebuffers(j + 1, this.maskfb, 0);
      this.maskfb = null;
    }
    if (this.maskrb != null)
    {
      localGL2.glDeleteRenderbuffers(j + 1, this.maskrb, 0);
      this.maskrb = null;
    }
  }
  
  public void setTargetImage(opencv_core.IplImage paramIplImage)
  {
    this.context.writeImage(this.targetCL[this.settings.pyramidLevelMin], paramIplImage, false);
    setTargetImageCL(this.targetCL[this.settings.pyramidLevelMin]);
  }
  
  public void setTargetImageCL(CLImage2d paramCLImage2d)
  {
    int i = this.settings.pyramidLevelMin;
    int j = this.settings.pyramidLevelMax;
    this.targetCL[i] = paramCLImage2d;
    for (int k = i + 1; k <= j; k++) {
      this.context.pyrDown(this.targetCL[(k - 1)], this.targetCL[k]);
    }
    setPyramidLevel(j);
  }
  
  public void setTemplateImage(opencv_core.IplImage paramIplImage, double[] paramArrayOfDouble)
  {
    this.context.writeImage(this.templateCL[this.settings.pyramidLevelMin], paramIplImage, false);
    setTemplateImageCL(this.templateCL[this.settings.pyramidLevelMin], paramArrayOfDouble);
  }
  
  public void setTemplateImageCL(CLImage2d paramCLImage2d, double[] paramArrayOfDouble)
  {
    int i = this.settings.pyramidLevelMin;
    int j = this.settings.pyramidLevelMax;
    if ((paramArrayOfDouble == null) && (paramCLImage2d != null))
    {
      int m = paramCLImage2d.width << i;
      int n = paramCLImage2d.height << i;
      opencv_core.CvMat localCvMat = this.srcRoiPts;
      double[] arrayOfDouble = new double[8];
      arrayOfDouble[0] = 0.0D;
      arrayOfDouble[1] = 0.0D;
      arrayOfDouble[2] = m;
      arrayOfDouble[3] = 0.0D;
      arrayOfDouble[4] = m;
      arrayOfDouble[5] = n;
      arrayOfDouble[6] = 0.0D;
      arrayOfDouble[7] = n;
      localCvMat.put(arrayOfDouble);
    }
    while (paramCLImage2d == null)
    {
      return;
      this.srcRoiPts.put(paramArrayOfDouble);
    }
    this.templateCL[i] = paramCLImage2d;
    for (int k = i + 1; k <= j; k++) {
      this.context.pyrDown(this.templateCL[(k - 1)], this.templateCL[k]);
    }
    setPyramidLevel(j);
    Arrays.fill(this.templateChanged, true);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\GNImageAlignerCL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */