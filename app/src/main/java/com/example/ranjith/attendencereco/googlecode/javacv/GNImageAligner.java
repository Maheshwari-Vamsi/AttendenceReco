package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvPoint;
import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_core.IplROI;
import com.googlecode.javacv.cpp.opencv_imgproc;
import java.lang.reflect.Array;
import java.nio.DoubleBuffer;
import java.util.Arrays;

public class GNImageAligner
  implements ImageAligner
{
  protected double RMSE;
  protected double[] constraintGrad;
  protected opencv_core.CvMat dstRoiPts;
  protected opencv_core.CvPoint dstRoiPtsArray;
  protected opencv_core.CvMat gradient;
  protected opencv_core.CvMat hessian;
  protected ImageTransformer.Data[] hessianGradientTransformerData;
  protected opencv_core.IplImage[] images = new opencv_core.IplImage[5];
  protected int lastLinePosition = 0;
  protected opencv_core.IplImage[] mask;
  protected final int n;
  protected ImageTransformer.Parameters parameters;
  protected ImageTransformer.Parameters[] parametersArray;
  protected opencv_core.CvMat prior;
  protected ImageTransformer.Parameters priorParameters;
  protected int pyramidLevel;
  protected opencv_core.IplImage[] residual;
  protected ImageTransformer.Data[] residualTransformerData;
  protected boolean residualUpdateNeeded = true;
  protected opencv_core.CvRect roi;
  protected Settings settings;
  protected opencv_core.CvMat srcRoiPts;
  protected boolean[] subspaceCorrelated;
  protected double[][] subspaceJacobian;
  protected double[] subspaceParameters;
  protected double[] subspaceResidual;
  protected opencv_core.IplImage[] target;
  protected ImageTransformer.Parameters[] tempParameters;
  protected double[][] tempSubspaceParameters;
  protected opencv_core.IplImage[] template;
  protected opencv_core.CvRect temproi;
  protected opencv_core.IplImage[] transformed;
  protected ImageTransformer transformer;
  protected int trials = 0;
  protected opencv_core.CvMat update;
  protected double[] updateScale;
  
  protected GNImageAligner(ImageTransformer paramImageTransformer, ImageTransformer.Parameters paramParameters)
  {
    this.n = paramParameters.size();
    this.srcRoiPts = opencv_core.CvMat.create(4, 1, 6, 2);
    this.dstRoiPts = opencv_core.CvMat.create(4, 1, 6, 2);
    this.dstRoiPtsArray = new opencv_core.CvPoint(4);
    this.roi = new opencv_core.CvRect();
    this.temproi = new opencv_core.CvRect();
    this.transformer = paramImageTransformer;
    this.parameters = paramParameters.clone();
    ImageTransformer.Parameters[] arrayOfParameters = new ImageTransformer.Parameters[1];
    arrayOfParameters[0] = this.parameters;
    this.parametersArray = arrayOfParameters;
    this.tempParameters = new ImageTransformer.Parameters[this.n];
    for (int i = 0; i < this.tempParameters.length; i++) {
      this.tempParameters[i] = paramParameters.clone();
    }
    this.subspaceParameters = this.parameters.getSubspace();
    if (this.subspaceParameters != null)
    {
      this.tempSubspaceParameters = new double[Parallel.getNumThreads()][];
      for (int j = 0; j < this.tempSubspaceParameters.length; j++) {
        this.tempSubspaceParameters[j] = ((double[])this.subspaceParameters.clone());
      }
    }
  }
  
  public GNImageAligner(ImageTransformer paramImageTransformer, ImageTransformer.Parameters paramParameters, opencv_core.IplImage paramIplImage1, double[] paramArrayOfDouble, opencv_core.IplImage paramIplImage2)
  {
    this(paramImageTransformer, paramParameters, paramIplImage1, paramArrayOfDouble, paramIplImage2, new Settings());
  }
  
  public GNImageAligner(ImageTransformer paramImageTransformer, ImageTransformer.Parameters paramParameters, opencv_core.IplImage paramIplImage1, double[] paramArrayOfDouble, opencv_core.IplImage paramIplImage2, Settings paramSettings)
  {
    this(paramImageTransformer, paramParameters);
    setSettings(paramSettings);
    int i = paramSettings.pyramidLevelMin;
    int j = paramSettings.pyramidLevelMax;
    this.template = new opencv_core.IplImage[j + 1];
    this.target = new opencv_core.IplImage[j + 1];
    this.transformed = new opencv_core.IplImage[j + 1];
    this.residual = new opencv_core.IplImage[j + 1];
    this.mask = new opencv_core.IplImage[j + 1];
    int k;
    int m;
    label101:
    int i1;
    label111:
    int i2;
    label121:
    int i3;
    if (paramIplImage1 != null)
    {
      k = paramIplImage1.width();
      if (paramIplImage1 == null) {
        break label278;
      }
      m = paramIplImage1.height();
      if (paramIplImage1 == null) {
        break label288;
      }
      i1 = paramIplImage1.nChannels();
      if (paramIplImage1 == null) {
        break label298;
      }
      i2 = paramIplImage1.origin();
      i3 = i;
      label125:
      if (i3 > j) {
        break label354;
      }
      if ((i3 != i) || (paramIplImage1 == null) || (paramIplImage1.depth() != 32)) {
        break label308;
      }
      this.template[i3] = paramIplImage1;
      label160:
      if ((i3 != i) || (paramIplImage2 == null) || (paramIplImage2.depth() != 32)) {
        break label331;
      }
      this.target[i3] = paramIplImage2;
    }
    for (;;)
    {
      this.transformed[i3] = opencv_core.IplImage.create(k, m, 32, i1, i2);
      this.residual[i3] = opencv_core.IplImage.create(k, m, 32, i1, i2);
      this.mask[i3] = opencv_core.IplImage.create(k, m, 8, 1, i2);
      k /= 2;
      m /= 2;
      i3++;
      break label125;
      k = paramIplImage2.width();
      break;
      label278:
      m = paramIplImage2.height();
      break label101;
      label288:
      i1 = paramIplImage2.nChannels();
      break label111;
      label298:
      i2 = paramIplImage2.origin();
      break label121;
      label308:
      this.template[i3] = opencv_core.IplImage.create(k, m, 32, i1, i2);
      break label160;
      label331:
      this.target[i3] = opencv_core.IplImage.create(k, m, 32, i1, i2);
    }
    label354:
    this.hessianGradientTransformerData = new ImageTransformer.Data[this.n];
    for (int i4 = 0;; i4++)
    {
      int i5 = this.n;
      if (i4 >= i5) {
        break;
      }
      this.hessianGradientTransformerData[i4] = new ImageTransformer.Data(this.template[this.pyramidLevel], this.transformed[this.pyramidLevel], this.residual[this.pyramidLevel], this.mask[this.pyramidLevel], 0.0D, 0.0D, this.pyramidLevel, null, null, this.n);
    }
    ImageTransformer.Data[] arrayOfData = new ImageTransformer.Data[1];
    arrayOfData[0] = new ImageTransformer.Data(this.template[this.pyramidLevel], this.target[this.pyramidLevel], null, this.mask[this.pyramidLevel], 0.0D, 0.0D, this.pyramidLevel, this.transformed[this.pyramidLevel], this.residual[this.pyramidLevel], 1);
    this.residualTransformerData = arrayOfData;
    setConstrained(paramSettings.constrained);
    setTemplateImage(paramIplImage1, paramArrayOfDouble);
    setTargetImage(paramIplImage2);
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
          GNImageAligner.this.tempParameters[i].set(GNImageAligner.this.parameters);
          GNImageAligner.this.tempParameters[i].set(i, GNImageAligner.this.tempParameters[i].get(i) + d2);
          d1[i] = (GNImageAligner.this.tempParameters[i].get(i) - GNImageAligner.this.parameters.get(i));
          GNImageAligner.this.constraintGrad[i] = (GNImageAligner.this.tempParameters[i].getConstraintError() - this.val$constraintError);
        }
      }
    });
    for (int i = 0; i < this.n; i++)
    {
      ImageTransformer.Data localData2 = this.hessianGradientTransformerData[i];
      localData2.srcImg = this.template[this.pyramidLevel];
      localData2.subImg = this.transformed[this.pyramidLevel];
      localData2.srcDotImg = this.residual[this.pyramidLevel];
      localData2.transImg = null;
      localData2.dstImg = null;
      localData2.mask = this.mask[this.pyramidLevel];
      localData2.zeroThreshold = this.settings.thresholdsZero[Math.min(-1 + this.settings.thresholdsZero.length, this.pyramidLevel)];
      localData2.outlierThreshold = this.settings.thresholdsOutlier[Math.min(-1 + this.settings.thresholdsOutlier.length, this.pyramidLevel)];
      if (this.settings.thresholdsMulRMSE)
      {
        localData2.zeroThreshold *= this.RMSE;
        localData2.outlierThreshold *= this.RMSE;
      }
      localData2.pyramidLevel = this.pyramidLevel;
    }
    this.transformer.transform(this.hessianGradientTransformerData, this.roi, this.tempParameters, null);
    for (int j = 0; j < this.n; j++)
    {
      ImageTransformer.Data localData1 = this.hessianGradientTransformerData[j];
      this.gradient.put(j, this.gradient.get(j) - localData1.srcDstDot);
      for (int k = 0; k < this.n; k++) {
        this.hessian.put(j, k, this.hessian.get(j, k) + localData1.dstDstDot.get(k));
      }
    }
    doRegularization(this.updateScale);
  }
  
  protected void doRegularization(final double[] paramArrayOfDouble)
  {
    double d1 = this.parameters.getConstraintError();
    final double d2 = this.settings.stepSize;
    if (((this.settings.gammaTgamma != null) || (this.settings.alphaTikhonov != 0.0D)) && (this.prior != null) && (this.priorParameters != null))
    {
      for (int i13 = 0;; i13++)
      {
        int i14 = this.n;
        if (i13 >= i14) {
          break;
        }
        opencv_core.CvMat localCvMat4 = this.prior;
        double d11 = this.parameters.get(i13) - this.priorParameters.get(i13);
        localCvMat4.put(i13, d11);
      }
      opencv_core.cvMatMul(this.hessian, this.prior, this.prior);
      for (int i15 = 0;; i15++)
      {
        int i16 = this.n;
        if (i15 >= i16) {
          break;
        }
        opencv_core.CvMat localCvMat3 = this.gradient;
        double d10 = this.gradient.get(i15) + this.prior.get(i15);
        localCvMat3.put(i15, d10);
      }
    }
    if (this.settings.constrained)
    {
      double d8 = 0.0D;
      double[] arrayOfDouble = this.constraintGrad;
      int i8 = arrayOfDouble.length;
      for (int i9 = 0; i9 < i8; i9++) {
        d8 += arrayOfDouble[i9];
      }
      paramArrayOfDouble[this.n] = (d8 * this.n);
      for (int i10 = 0;; i10++)
      {
        int i11 = this.n;
        if (i10 >= i11) {
          break;
        }
        double d9 = this.constraintGrad[i10] * paramArrayOfDouble[this.n];
        opencv_core.CvMat localCvMat2 = this.hessian;
        int i12 = this.n;
        localCvMat2.put(i10, i12, d9);
        this.hessian.put(this.n, i10, d9);
      }
      this.gradient.put(this.n, -d1 * paramArrayOfDouble[this.n]);
    }
    if ((this.subspaceParameters != null) && (this.subspaceParameters.length > 0) && (this.settings.alphaSubspace != 0.0D))
    {
      final int i4 = this.subspaceParameters.length;
      Arrays.fill(this.subspaceCorrelated, false);
      this.tempParameters[0].set(this.parameters);
      this.tempParameters[0].setSubspace(this.subspaceParameters);
      Parallel.loop(0, i4 + this.n, this.tempSubspaceParameters.length, new Parallel.Looper()
      {
        public void loop(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          int i = paramAnonymousInt1;
          while (i < paramAnonymousInt2) {
            if (i < GNImageAligner.this.n)
            {
              Arrays.fill(GNImageAligner.this.subspaceJacobian[i], 0.0D);
              GNImageAligner.this.subspaceJacobian[i][i] = paramArrayOfDouble[i];
              i++;
            }
            else
            {
              System.arraycopy(GNImageAligner.this.subspaceParameters, 0, GNImageAligner.this.tempSubspaceParameters[paramAnonymousInt3], 0, i4);
              double[] arrayOfDouble = GNImageAligner.this.tempSubspaceParameters[paramAnonymousInt3];
              int j = i - GNImageAligner.this.n;
              arrayOfDouble[j] += d2;
              GNImageAligner.this.tempParameters[(1 + (i - GNImageAligner.this.n))].set(GNImageAligner.this.parameters);
              GNImageAligner.this.tempParameters[(1 + (i - GNImageAligner.this.n))].setSubspace(GNImageAligner.this.tempSubspaceParameters[paramAnonymousInt3]);
              paramArrayOfDouble[i] = (GNImageAligner.this.tempSubspaceParameters[paramAnonymousInt3][(i - GNImageAligner.this.n)] - GNImageAligner.this.subspaceParameters[(i - GNImageAligner.this.n)]);
              int k = 0;
              label239:
              boolean[] arrayOfBoolean;
              int m;
              if (k < GNImageAligner.this.n)
              {
                GNImageAligner.this.subspaceJacobian[i][k] = (GNImageAligner.this.tempParameters[0].get(k) - GNImageAligner.this.tempParameters[(1 + (i - GNImageAligner.this.n))].get(k));
                arrayOfBoolean = GNImageAligner.this.subspaceCorrelated;
                m = arrayOfBoolean[k];
                if (GNImageAligner.this.subspaceJacobian[i][k] == 0.0D) {
                  break label361;
                }
              }
              label361:
              for (int n = 1;; n = 0)
              {
                arrayOfBoolean[k] = (n | m);
                k++;
                break label239;
                break;
              }
            }
          }
        }
      });
      int i5 = 0;
      for (int i6 = 0;; i6++)
      {
        int i7 = this.n;
        if (i6 >= i7) {
          break;
        }
        this.subspaceResidual[i6] = (this.parameters.get(i6) - this.tempParameters[0].get(i6));
        if (this.subspaceCorrelated[i6] != 0) {
          i5++;
        }
      }
      final double d7 = this.settings.alphaSubspace * this.settings.alphaSubspace * this.RMSE * this.RMSE / i5;
      Parallel.loop(0, i4 + this.n, new Parallel.Looper()
      {
        public void loop(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          int i = paramAnonymousInt1;
          if (i < paramAnonymousInt2)
          {
            if ((i < GNImageAligner.this.n) && (GNImageAligner.this.subspaceCorrelated[i] == 0)) {}
            for (;;)
            {
              i++;
              break;
              int j = i;
              if (j < GNImageAligner.this.n + i4)
              {
                if ((j < GNImageAligner.this.n) && (GNImageAligner.this.subspaceCorrelated[j] == 0)) {}
                for (;;)
                {
                  j++;
                  break;
                  double d3 = 0.0D;
                  for (int m = 0; m < GNImageAligner.this.n; m++) {
                    d3 += GNImageAligner.this.subspaceJacobian[i][m] * GNImageAligner.this.subspaceJacobian[j][m];
                  }
                  double d4 = GNImageAligner.this.hessian.get(i, j) + d3 * d7;
                  GNImageAligner.this.hessian.put(i, j, d4);
                  GNImageAligner.this.hessian.put(j, i, d4);
                }
              }
              double d1 = 0.0D;
              for (int k = 0; k < GNImageAligner.this.n; k++) {
                d1 -= GNImageAligner.this.subspaceJacobian[i][k] * GNImageAligner.this.subspaceResidual[k];
              }
              double d2 = GNImageAligner.this.gradient.get(i) + d1 * d7;
              GNImageAligner.this.gradient.put(i, d2);
            }
          }
        }
      });
    }
    int i = this.hessian.rows();
    int j = this.hessian.cols();
    for (int k = 0; k < i; k++) {
      for (int m = 0; m < j; m++)
      {
        double d3 = this.hessian.get(k, m);
        double d4 = 0.0D;
        if (this.settings.gammaTgamma != null)
        {
          int i2 = this.settings.gammaTgamma.rows();
          if (k < i2)
          {
            int i3 = this.settings.gammaTgamma.cols();
            if (m < i3) {
              d4 = this.settings.gammaTgamma.get(k, m);
            }
          }
        }
        double d5 = 0.0D;
        if (k == m)
        {
          int i1 = this.n;
          if (k < i1) {
            d5 = this.settings.alphaTikhonov * this.settings.alphaTikhonov;
          }
        }
        opencv_core.CvMat localCvMat1 = this.hessian;
        double d6 = d5 + (d3 + d4);
        localCvMat1.put(k, m, d6);
      }
    }
  }
  
  protected void doResidual()
  {
    this.parameters.getConstraintError();
    ImageTransformer.Data localData = this.residualTransformerData[0];
    localData.srcImg = this.template[this.pyramidLevel];
    localData.subImg = this.target[this.pyramidLevel];
    localData.srcDotImg = null;
    localData.transImg = this.transformed[this.pyramidLevel];
    localData.dstImg = this.residual[this.pyramidLevel];
    localData.mask = this.mask[this.pyramidLevel];
    localData.zeroThreshold = this.settings.thresholdsZero[Math.min(-1 + this.settings.thresholdsZero.length, this.pyramidLevel)];
    localData.outlierThreshold = this.settings.thresholdsOutlier[Math.min(-1 + this.settings.thresholdsOutlier.length, this.pyramidLevel)];
    if (this.settings.thresholdsMulRMSE)
    {
      localData.zeroThreshold *= this.RMSE;
      localData.outlierThreshold *= this.RMSE;
    }
    localData.pyramidLevel = this.pyramidLevel;
    this.transformer.transform(this.residualTransformerData, this.roi, this.parametersArray, null);
    double d1 = this.residualTransformerData[0].dstDstDot.get(0);
    int i = this.residualTransformerData[0].dstCount;
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
    this.roi.x(0).y(0).width(this.mask[this.pyramidLevel].width()).height(this.mask[this.pyramidLevel].height());
    JavaCV.boundingRect(arrayOfDouble, this.roi, 3, 3, 16, 1);
    opencv_core.cvSetZero(this.mask[this.pyramidLevel]);
    this.dstRoiPtsArray.put((byte)16, arrayOfDouble);
    opencv_core.cvFillConvexPoly(this.mask[this.pyramidLevel], this.dstRoiPtsArray, 4, opencv_core.CvScalar.WHITE, 8, 16);
  }
  
  public opencv_core.IplImage[] getImages()
  {
    this.images[0] = getTemplateImage();
    this.images[1] = getTargetImage();
    this.images[2] = getTransformedImage();
    this.images[3] = getResidualImage();
    this.images[4] = getMaskImage();
    return this.images;
  }
  
  public int getLastLinePosition()
  {
    return this.lastLinePosition;
  }
  
  public opencv_core.IplImage getMaskImage()
  {
    return this.mask[this.pyramidLevel];
  }
  
  public int getOutlierCount()
  {
    return this.hessianGradientTransformerData[0].dstCountOutlier;
  }
  
  public ImageTransformer.Parameters getParameters()
  {
    return this.parameters;
  }
  
  public int getPixelCount()
  {
    if (this.residualUpdateNeeded)
    {
      doRoi();
      doResidual();
    }
    return this.residualTransformerData[0].dstCount;
  }
  
  public ImageTransformer.Parameters getPriorParameters()
  {
    return this.priorParameters;
  }
  
  public int getPyramidLevel()
  {
    return this.pyramidLevel;
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
    if (this.residualUpdateNeeded)
    {
      doRoi();
      doResidual();
    }
    return this.residual[this.pyramidLevel];
  }
  
  public opencv_core.CvRect getRoi()
  {
    if (this.residualUpdateNeeded) {
      doRoi();
    }
    return this.roi;
  }
  
  public Settings getSettings()
  {
    return this.settings;
  }
  
  public opencv_core.IplImage getTargetImage()
  {
    return this.target[this.pyramidLevel];
  }
  
  public opencv_core.IplImage getTemplateImage()
  {
    return this.template[this.pyramidLevel];
  }
  
  public opencv_core.IplImage getTransformedImage()
  {
    if (this.residualUpdateNeeded)
    {
      doRoi();
      doResidual();
    }
    return this.transformed[this.pyramidLevel];
  }
  
  public double[] getTransformedRoiPts()
  {
    if (this.residualUpdateNeeded)
    {
      doRoi();
      doResidual();
    }
    return this.dstRoiPts.get();
  }
  
  public boolean isConstrained()
  {
    return this.settings.constrained;
  }
  
  public boolean iterate(double[] paramArrayOfDouble)
  {
    boolean bool = false;
    double d1 = getRMSE();
    double[] arrayOfDouble1 = this.parameters.get();
    double[] arrayOfDouble2;
    double[] arrayOfDouble3;
    if (this.subspaceParameters == null)
    {
      arrayOfDouble2 = null;
      if ((this.trials == 0) && (this.parameters.preoptimize()))
      {
        setParameters(this.parameters);
        doResidual();
      }
      arrayOfDouble3 = this.parameters.get();
      if (this.subspaceParameters != null) {
        break label193;
      }
    }
    label193:
    for (double[] arrayOfDouble4 = null;; arrayOfDouble4 = (double[])this.subspaceParameters.clone())
    {
      doHessianGradient(this.updateScale);
      this.lastLinePosition = 0;
      opencv_core.cvSolve(this.hessian, this.gradient, this.update, 1);
      for (int i = 0; i < this.n; i++) {
        this.parameters.set(i, this.parameters.get(i) + this.settings.lineSearch[0] * this.update.get(i) * this.updateScale[i]);
      }
      arrayOfDouble2 = (double[])this.subspaceParameters.clone();
      break;
    }
    for (int j = this.n; j < this.update.length(); j++)
    {
      double[] arrayOfDouble6 = this.subspaceParameters;
      int i6 = j - this.n;
      arrayOfDouble6[i6] += this.settings.lineSearch[0] * this.update.get(j) * this.updateScale[j];
    }
    this.residualUpdateNeeded = true;
    for (int k = 1; (k < this.settings.lineSearch.length) && (getRMSE() > d1); k++)
    {
      this.RMSE = d1;
      this.parameters.set(arrayOfDouble3);
      if (this.subspaceParameters != null) {
        System.arraycopy(arrayOfDouble4, 0, this.subspaceParameters, 0, this.subspaceParameters.length);
      }
      this.lastLinePosition = k;
      for (int i3 = 0; i3 < this.n; i3++) {
        this.parameters.set(i3, this.parameters.get(i3) + this.settings.lineSearch[k] * this.update.get(i3) * this.updateScale[i3]);
      }
      for (int i4 = this.n; i4 < this.update.length(); i4++)
      {
        double[] arrayOfDouble5 = this.subspaceParameters;
        int i5 = i4 - this.n;
        arrayOfDouble5[i5] += this.settings.lineSearch[k] * this.update.get(i4) * this.updateScale[i4];
      }
      this.residualUpdateNeeded = true;
    }
    double d2 = 0.0D;
    if (paramArrayOfDouble != null)
    {
      for (int i2 = 0; (i2 < paramArrayOfDouble.length) && (i2 < this.updateScale.length); i2++) {
        paramArrayOfDouble[i2] = (this.settings.lineSearch[this.lastLinePosition] * this.update.get(i2) * this.updateScale[i2]);
      }
      d2 = JavaCV.norm(Arrays.copyOf(paramArrayOfDouble, this.n));
    }
    if ((getRMSE() > d1) || (d2 > this.settings.deltaMax) || (Double.isNaN(this.RMSE)) || (Double.isInfinite(this.RMSE))) {}
    for (int m = 1;; m = 0)
    {
      if (m != 0)
      {
        this.RMSE = d1;
        this.parameters.set(arrayOfDouble1);
        if (this.subspaceParameters != null) {
          System.arraycopy(arrayOfDouble2, 0, this.subspaceParameters, 0, this.subspaceParameters.length);
        }
        this.residualUpdateNeeded = true;
      }
      if ((m == 0) || (d2 <= this.settings.deltaMin)) {
        break;
      }
      int i1 = 1 + this.trials;
      this.trials = i1;
      if (i1 >= 2) {
        break;
      }
      return false;
    }
    if ((m != 0) || (d2 < this.settings.deltaMin))
    {
      this.trials = 0;
      if (this.pyramidLevel > this.settings.pyramidLevelMin) {
        setPyramidLevel(-1 + this.pyramidLevel);
      }
    }
    for (;;)
    {
      return bool;
      bool = true;
      continue;
      this.trials = 0;
      bool = false;
    }
  }
  
  public void setConstrained(boolean paramBoolean)
  {
    if ((this.settings.constrained == paramBoolean) && (this.hessian != null) && (this.gradient != null) && (this.update != null)) {
      return;
    }
    this.settings.constrained = paramBoolean;
    if (paramBoolean) {}
    for (int i = 1 + this.n;; i = this.n)
    {
      if ((this.subspaceParameters != null) && (this.settings.alphaSubspace != 0.0D)) {
        i += this.subspaceParameters.length;
      }
      this.hessian = opencv_core.CvMat.create(i, i);
      this.gradient = opencv_core.CvMat.create(i, 1);
      this.update = opencv_core.CvMat.create(i, 1);
      this.updateScale = new double[i];
      this.prior = opencv_core.CvMat.create(this.n, 1);
      this.constraintGrad = new double[this.n];
      this.subspaceResidual = new double[this.n];
      int[] arrayOfInt = { i, this.n };
      this.subspaceJacobian = ((double[][])Array.newInstance(Double.TYPE, arrayOfInt));
      this.subspaceCorrelated = new boolean[this.n];
      return;
    }
  }
  
  public void setParameters(ImageTransformer.Parameters paramParameters)
  {
    this.parameters.set(paramParameters);
    this.subspaceParameters = paramParameters.getSubspace();
    if ((this.subspaceParameters != null) && (this.settings.alphaSubspace != 0.0D)) {
      for (int i = 0; i < this.tempSubspaceParameters.length; i++) {
        this.tempSubspaceParameters[i] = ((double[])this.subspaceParameters.clone());
      }
    }
    this.residualUpdateNeeded = true;
  }
  
  public void setPriorParameters(ImageTransformer.Parameters paramParameters)
  {
    this.priorParameters.set(paramParameters);
  }
  
  public void setPyramidLevel(int paramInt)
  {
    this.pyramidLevel = paramInt;
    this.residualUpdateNeeded = true;
    this.trials = 0;
  }
  
  public void setSettings(ImageAligner.Settings paramSettings)
  {
    this.settings = ((Settings)paramSettings);
  }
  
  public void setTargetImage(opencv_core.IplImage paramIplImage)
  {
    int i = this.settings.pyramidLevelMin;
    int j = this.settings.pyramidLevelMax;
    if (paramIplImage == null) {
      return;
    }
    if (paramIplImage.depth() == 32) {
      this.target[i] = paramIplImage;
    }
    int k;
    if (this.settings.displacementMax > 0.0D)
    {
      this.transformer.transform(this.srcRoiPts, this.dstRoiPts, this.parameters, false);
      double[] arrayOfDouble = this.dstRoiPts.get();
      for (int m = 0; m < arrayOfDouble.length; m++) {
        arrayOfDouble[m] /= (1 << i);
      }
      int i1 = this.target[i].width();
      int i2 = this.target[i].height();
      this.temproi.x(0).y(0).width(i1).height(i2);
      int i3 = (int)Math.round(this.settings.displacementMax * i1);
      int i4 = (int)Math.round(this.settings.displacementMax * i2);
      int i5 = 1 << j + 1;
      JavaCV.boundingRect(arrayOfDouble, this.temproi, i3 + 3, i4 + 3, i5, i5);
      opencv_core.cvSetImageROI(paramIplImage, this.temproi);
      opencv_core.cvSetImageROI(this.target[i], this.temproi);
      if (paramIplImage.depth() != 32)
      {
        opencv_core.cvConvertScale(paramIplImage, this.target[i], 1.0D / paramIplImage.highValue(), 0.0D);
        opencv_core.cvResetImageROI(paramIplImage);
      }
      k = i + 1;
      label276:
      if (k > j) {
        break label431;
      }
      opencv_core.IplROI localIplROI = this.target[(k - 1)].roi();
      if (localIplROI == null) {
        break label418;
      }
      this.temproi.x(localIplROI.xOffset() / 2);
      this.temproi.width(localIplROI.width() / 2);
      this.temproi.y(localIplROI.yOffset() / 2);
      this.temproi.height(localIplROI.height() / 2);
      opencv_core.cvSetImageROI(this.target[k], this.temproi);
    }
    for (;;)
    {
      opencv_imgproc.cvPyrDown(this.target[(k - 1)], this.target[k], 7);
      k++;
      break label276;
      opencv_core.cvResetImageROI(paramIplImage);
      opencv_core.cvResetImageROI(this.target[i]);
      break;
      label418:
      opencv_core.cvResetImageROI(this.target[k]);
    }
    label431:
    setPyramidLevel(j);
  }
  
  public void setTemplateImage(opencv_core.IplImage paramIplImage, double[] paramArrayOfDouble)
  {
    int i = this.settings.pyramidLevelMin;
    int j = this.settings.pyramidLevelMax;
    if ((paramArrayOfDouble == null) && (paramIplImage != null))
    {
      int m = paramIplImage.width() << i;
      int i1 = paramIplImage.height() << i;
      opencv_core.CvMat localCvMat = this.srcRoiPts;
      double[] arrayOfDouble = new double[8];
      arrayOfDouble[0] = 0.0D;
      arrayOfDouble[1] = 0.0D;
      arrayOfDouble[2] = m;
      arrayOfDouble[3] = 0.0D;
      arrayOfDouble[4] = m;
      arrayOfDouble[5] = i1;
      arrayOfDouble[6] = 0.0D;
      arrayOfDouble[7] = i1;
      localCvMat.put(arrayOfDouble);
    }
    while (paramIplImage == null)
    {
      return;
      if (paramArrayOfDouble != null) {
        this.srcRoiPts.put(paramArrayOfDouble);
      }
    }
    if (paramIplImage.depth() == 32) {
      this.template[i] = paramIplImage;
    }
    for (;;)
    {
      for (int k = i + 1; k <= j; k++) {
        opencv_imgproc.cvPyrDown(this.template[(k - 1)], this.template[k], 7);
      }
      opencv_core.cvConvertScale(paramIplImage, this.template[i], 1.0D / paramIplImage.highValue(), 0.0D);
    }
    setPyramidLevel(j);
  }
  
  public static class Settings
    extends ImageAligner.Settings
    implements Cloneable
  {
    double alphaSubspace = 0.1D;
    double alphaTikhonov = 0.0D;
    boolean constrained = false;
    double deltaMax = 300.0D;
    double deltaMin = 10.0D;
    double displacementMax = 0.2D;
    opencv_core.CvMat gammaTgamma = null;
    double[] lineSearch = { 1.0D, 0.25D };
    double stepSize = 0.1D;
    
    public Settings() {}
    
    public Settings(Settings paramSettings)
    {
      super();
      this.stepSize = paramSettings.stepSize;
      this.lineSearch = paramSettings.lineSearch;
      this.deltaMin = paramSettings.deltaMin;
      this.deltaMax = paramSettings.deltaMax;
      this.displacementMax = paramSettings.displacementMax;
      this.alphaSubspace = paramSettings.alphaSubspace;
      this.alphaTikhonov = paramSettings.alphaTikhonov;
      this.gammaTgamma = paramSettings.gammaTgamma;
      this.constrained = paramSettings.constrained;
    }
    
    public Settings clone()
    {
      return new Settings(this);
    }
    
    public double getAlphaSubspace()
    {
      return this.alphaSubspace;
    }
    
    public double getAlphaTikhonov()
    {
      return this.alphaTikhonov;
    }
    
    public double getDeltaMax()
    {
      return this.deltaMax;
    }
    
    public double getDeltaMin()
    {
      return this.deltaMin;
    }
    
    public double getDisplacementMax()
    {
      return this.displacementMax;
    }
    
    public opencv_core.CvMat getGammaTgamma()
    {
      return this.gammaTgamma;
    }
    
    public double[] getLineSearch()
    {
      return this.lineSearch;
    }
    
    public double getStepSize()
    {
      return this.stepSize;
    }
    
    public void setAlphaSubspace(double paramDouble)
    {
      this.alphaSubspace = paramDouble;
    }
    
    public void setAlphaTikhonov(double paramDouble)
    {
      this.alphaTikhonov = paramDouble;
    }
    
    public void setDeltaMax(double paramDouble)
    {
      this.deltaMax = paramDouble;
    }
    
    public void setDeltaMin(double paramDouble)
    {
      this.deltaMin = paramDouble;
    }
    
    public void setDisplacementMax(double paramDouble)
    {
      this.displacementMax = paramDouble;
    }
    
    public void setGammaTgamma(opencv_core.CvMat paramCvMat)
    {
      this.gammaTgamma = paramCvMat;
    }
    
    public void setLineSearch(double[] paramArrayOfDouble)
    {
      this.lineSearch = paramArrayOfDouble;
    }
    
    public void setStepSize(double paramDouble)
    {
      this.stepSize = paramDouble;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\GNImageAligner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */