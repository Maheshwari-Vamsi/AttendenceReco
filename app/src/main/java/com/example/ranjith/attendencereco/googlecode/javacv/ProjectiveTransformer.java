package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.cvkernels;
import com.googlecode.javacv.cpp.cvkernels.KernelData;
import com.googlecode.javacv.cpp.opencv_calib3d;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_imgproc;

public class ProjectiveTransformer
  implements ImageTransformer
{
  protected static ThreadLocal<opencv_core.CvMat> H3x3;
  protected static ThreadLocal<opencv_core.CvMat> pts4x1;
  protected opencv_core.CvMat[] H = null;
  protected opencv_core.CvMat K1 = null;
  protected opencv_core.CvMat K2 = null;
  protected opencv_core.CvMat R = null;
  protected opencv_core.CvScalar fillColor = opencv_core.cvScalar(0.0D, 0.0D, 0.0D, 1.0D);
  protected opencv_core.CvMat invK1 = null;
  protected opencv_core.CvMat invK2 = null;
  protected cvkernels.KernelData kernelData = null;
  protected opencv_core.CvMat n = null;
  protected double[] referencePoints1 = null;
  protected double[] referencePoints2 = null;
  protected opencv_core.CvMat t = null;
  
  static
  {
    if (!ProjectiveTransformer.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      H3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      pts4x1 = opencv_core.CvMat.createThreadLocal(4, 1, 6, 2);
      return;
    }
  }
  
  public ProjectiveTransformer()
  {
    this(null, null, null, null, null, new double[0], null);
  }
  
  public ProjectiveTransformer(ProjectiveDevice paramProjectiveDevice1, ProjectiveDevice paramProjectiveDevice2, opencv_core.CvMat paramCvMat, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    this(paramProjectiveDevice1.cameraMatrix, paramProjectiveDevice2.cameraMatrix, paramProjectiveDevice2.R, paramProjectiveDevice2.T, paramCvMat, paramArrayOfDouble1, paramArrayOfDouble2);
  }
  
  public ProjectiveTransformer(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    opencv_core.CvMat localCvMat1;
    opencv_core.CvMat localCvMat2;
    label90:
    opencv_core.CvMat localCvMat3;
    label103:
    opencv_core.CvMat localCvMat4;
    label116:
    opencv_core.CvMat localCvMat5;
    label155:
    opencv_core.CvMat localCvMat6;
    label169:
    opencv_core.CvMat localCvMat7;
    label183:
    double[] arrayOfDouble1;
    if (paramCvMat1 == null)
    {
      localCvMat1 = null;
      this.K1 = localCvMat1;
      if (paramCvMat2 != null) {
        break label227;
      }
      localCvMat2 = null;
      this.K2 = localCvMat2;
      if (paramCvMat1 != null) {
        break label236;
      }
      localCvMat3 = null;
      this.invK1 = localCvMat3;
      if (paramCvMat2 != null) {
        break label245;
      }
      localCvMat4 = null;
      this.invK2 = localCvMat4;
      if (paramCvMat1 != null) {
        opencv_core.cvInvert(paramCvMat1, this.invK1);
      }
      if (paramCvMat2 != null) {
        opencv_core.cvInvert(paramCvMat2, this.invK2);
      }
      if (paramCvMat3 != null) {
        break label254;
      }
      localCvMat5 = null;
      this.R = localCvMat5;
      if (paramCvMat4 != null) {
        break label263;
      }
      localCvMat6 = null;
      this.t = localCvMat6;
      if (paramCvMat5 != null) {
        break label273;
      }
      localCvMat7 = null;
      this.n = localCvMat7;
      if (paramArrayOfDouble1 != null) {
        break label283;
      }
      arrayOfDouble1 = null;
      label197:
      this.referencePoints1 = arrayOfDouble1;
      if (paramArrayOfDouble2 != null) {
        break label296;
      }
    }
    label227:
    label236:
    label245:
    label254:
    label263:
    label273:
    label283:
    label296:
    for (double[] arrayOfDouble2 = null;; arrayOfDouble2 = (double[])paramArrayOfDouble2.clone())
    {
      this.referencePoints2 = arrayOfDouble2;
      return;
      localCvMat1 = paramCvMat1.clone();
      break;
      localCvMat2 = paramCvMat2.clone();
      break label90;
      localCvMat3 = paramCvMat1.clone();
      break label103;
      localCvMat4 = paramCvMat2.clone();
      break label116;
      localCvMat5 = paramCvMat3.clone();
      break label155;
      localCvMat6 = paramCvMat4.clone();
      break label169;
      localCvMat7 = paramCvMat5.clone();
      break label183;
      arrayOfDouble1 = (double[])paramArrayOfDouble1.clone();
      break label197;
    }
  }
  
  public ProjectiveTransformer(double[] paramArrayOfDouble)
  {
    this(null, null, null, null, null, paramArrayOfDouble, null);
  }
  
  public Parameters createParameters()
  {
    return new Parameters();
  }
  
  public opencv_core.CvScalar getFillColor()
  {
    return this.fillColor;
  }
  
  public opencv_core.CvMat getInvK1()
  {
    return this.invK1;
  }
  
  public opencv_core.CvMat getInvK2()
  {
    return this.invK2;
  }
  
  public opencv_core.CvMat getK1()
  {
    return this.K1;
  }
  
  public opencv_core.CvMat getK2()
  {
    return this.K2;
  }
  
  public opencv_core.CvMat getN()
  {
    return this.n;
  }
  
  public opencv_core.CvMat getR()
  {
    return this.R;
  }
  
  public double[] getReferencePoints1()
  {
    return this.referencePoints1;
  }
  
  public double[] getReferencePoints2()
  {
    return this.referencePoints2;
  }
  
  public opencv_core.CvMat getT()
  {
    return this.t;
  }
  
  protected void prepareHomography(opencv_core.CvMat paramCvMat, int paramInt, Parameters paramParameters, boolean paramBoolean)
  {
    if ((this.K2 != null) && (this.invK1 != null) && (this.R != null) && (this.t != null) && (paramParameters.fakeIdentity)) {
      opencv_core.cvSetIdentity(paramCvMat);
    }
    for (;;)
    {
      return;
      if (paramBoolean) {
        paramCvMat.put(paramParameters.getH());
      }
      while (paramInt > 0)
      {
        int i = 1 << paramInt;
        paramCvMat.put(2, paramCvMat.get(2) / i);
        paramCvMat.put(5, paramCvMat.get(5) / i);
        paramCvMat.put(6, paramCvMat.get(6) * i);
        paramCvMat.put(7, paramCvMat.get(7) * i);
        return;
        opencv_core.cvInvert(paramParameters.getH(), paramCvMat);
      }
    }
  }
  
  public void setFillColor(opencv_core.CvScalar paramCvScalar)
  {
    this.fillColor = paramCvScalar;
  }
  
  public void transform(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, ImageTransformer.Parameters paramParameters, boolean paramBoolean)
  {
    Parameters localParameters = (Parameters)paramParameters;
    opencv_core.CvMat localCvMat;
    if (paramBoolean)
    {
      localCvMat = (opencv_core.CvMat)H3x3.get();
      opencv_core.cvInvert(localParameters.getH(), localCvMat);
    }
    for (;;)
    {
      opencv_core.cvPerspectiveTransform(paramCvMat1, paramCvMat2, localCvMat);
      return;
      localCvMat = localParameters.getH();
    }
  }
  
  public void transform(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.CvRect paramCvRect, int paramInt, ImageTransformer.Parameters paramParameters, boolean paramBoolean)
  {
    Parameters localParameters = (Parameters)paramParameters;
    if ((this.K2 != null) && (this.invK1 != null) && (this.R != null) && (this.t != null) && (localParameters.fakeIdentity))
    {
      if (paramIplImage1 != paramIplImage2) {
        opencv_core.cvCopy(paramIplImage1, paramIplImage2);
      }
      return;
    }
    opencv_core.CvMat localCvMat = (opencv_core.CvMat)H3x3.get();
    prepareHomography(localCvMat, paramInt, localParameters, true);
    int j;
    int k;
    if ((paramCvRect != null) && ((paramCvRect.x() != 0) || (paramCvRect.y() != 0)))
    {
      j = paramCvRect.x();
      k = paramCvRect.y();
      if (paramBoolean)
      {
        localCvMat.put(2, localCvMat.get(0) * j + localCvMat.get(1) * k + localCvMat.get(2));
        localCvMat.put(5, localCvMat.get(3) * j + localCvMat.get(4) * k + localCvMat.get(5));
        localCvMat.put(8, localCvMat.get(6) * j + localCvMat.get(7) * k + localCvMat.get(8));
      }
    }
    else
    {
      paramIplImage2.origin(paramIplImage1.origin());
      if (paramCvRect != null) {
        break label416;
      }
      opencv_core.cvResetImageROI(paramIplImage2);
      label237:
      if (!paramBoolean) {
        break label424;
      }
    }
    label416:
    label424:
    for (int i = 16;; i = 0)
    {
      opencv_imgproc.cvWarpPerspective(paramIplImage1, paramIplImage2, localCvMat, i | 0x9, getFillColor());
      return;
      localCvMat.put(0, localCvMat.get(0) - j * localCvMat.get(6));
      localCvMat.put(1, localCvMat.get(1) - j * localCvMat.get(7));
      localCvMat.put(2, localCvMat.get(2) - j * localCvMat.get(8));
      localCvMat.put(3, localCvMat.get(3) - k * localCvMat.get(6));
      localCvMat.put(4, localCvMat.get(4) - k * localCvMat.get(7));
      localCvMat.put(5, localCvMat.get(5) - k * localCvMat.get(8));
      break;
      opencv_core.cvSetImageROI(paramIplImage2, paramCvRect);
      break label237;
    }
  }
  
  public void transform(ImageTransformer.Data[] paramArrayOfData, opencv_core.CvRect paramCvRect, ImageTransformer.Parameters[] paramArrayOfParameters, boolean[] paramArrayOfBoolean)
  {
    assert (paramArrayOfData.length == paramArrayOfParameters.length);
    if ((this.kernelData == null) || (this.kernelData.capacity() < paramArrayOfData.length)) {
      this.kernelData = new cvkernels.KernelData(paramArrayOfData.length);
    }
    if ((this.H == null) || (this.H.length < paramArrayOfData.length))
    {
      this.H = new opencv_core.CvMat[paramArrayOfData.length];
      for (int i = 0; i < this.H.length; i++) {
        this.H[i] = opencv_core.CvMat.create(3, 3);
      }
    }
    int j = 0;
    if (j < paramArrayOfData.length)
    {
      this.kernelData.position(j);
      this.kernelData.srcImg(paramArrayOfData[j].srcImg);
      this.kernelData.srcImg2(null);
      this.kernelData.subImg(paramArrayOfData[j].subImg);
      this.kernelData.srcDotImg(paramArrayOfData[j].srcDotImg);
      this.kernelData.mask(paramArrayOfData[j].mask);
      this.kernelData.zeroThreshold(paramArrayOfData[j].zeroThreshold);
      this.kernelData.outlierThreshold(paramArrayOfData[j].outlierThreshold);
      opencv_core.CvMat localCvMat = this.H[j];
      int i1 = paramArrayOfData[j].pyramidLevel;
      Parameters localParameters = (Parameters)paramArrayOfParameters[j];
      if (paramArrayOfBoolean == null) {}
      int i2;
      for (boolean bool = false;; i2 = paramArrayOfBoolean[j])
      {
        prepareHomography(localCvMat, i1, localParameters, bool);
        this.kernelData.H1(this.H[j]);
        this.kernelData.H2(null);
        this.kernelData.X(null);
        this.kernelData.transImg(paramArrayOfData[j].transImg);
        this.kernelData.dstImg(paramArrayOfData[j].dstImg);
        this.kernelData.dstDstDot(paramArrayOfData[j].dstDstDot);
        j++;
        break;
      }
    }
    int k = this.kernelData.capacity();
    this.kernelData.capacity(paramArrayOfData.length);
    cvkernels.multiWarpColorTransform(this.kernelData, paramCvRect, getFillColor());
    this.kernelData.capacity(k);
    for (int m = 0; m < paramArrayOfData.length; m++)
    {
      this.kernelData.position(m);
      paramArrayOfData[m].dstCount = this.kernelData.dstCount();
      paramArrayOfData[m].dstCountZero = this.kernelData.dstCountZero();
      paramArrayOfData[m].dstCountOutlier = this.kernelData.dstCountOutlier();
      paramArrayOfData[m].srcDstDot = this.kernelData.srcDstDot();
    }
  }
  
  public class Parameters
    implements ImageTransformer.Parameters
  {
    private opencv_core.CvMat H = opencv_core.CvMat.create(3, 3);
    private opencv_core.CvMat R2 = null;
    private double constraintError = 0.0D;
    protected boolean fakeIdentity = false;
    private opencv_core.CvMat n2 = null;
    protected double[] projectiveParameters = null;
    private opencv_core.CvMat t2 = null;
    private boolean updateNeeded = true;
    
    protected Parameters()
    {
      reset(false);
    }
    
    public Parameters clone()
    {
      Parameters localParameters = new Parameters(ProjectiveTransformer.this);
      localParameters.set(this);
      return localParameters;
    }
    
    public void compose(ImageTransformer.Parameters paramParameters1, boolean paramBoolean1, ImageTransformer.Parameters paramParameters2, boolean paramBoolean2)
    {
      Parameters localParameters1 = (Parameters)paramParameters1;
      Parameters localParameters2 = (Parameters)paramParameters2;
      if ((ProjectiveTransformer.this.K2 != null) && (ProjectiveTransformer.this.invK1 != null) && (ProjectiveTransformer.this.R != null) && (ProjectiveTransformer.this.t != null) && (localParameters1.fakeIdentity)) {
        return;
      }
      compose(localParameters1.getH(), paramBoolean1, localParameters2.getH(), paramBoolean2);
    }
    
    public void compose(opencv_core.CvMat paramCvMat1, boolean paramBoolean1, opencv_core.CvMat paramCvMat2, boolean paramBoolean2)
    {
      if ((paramBoolean1) && (paramBoolean2))
      {
        opencv_core.cvMatMul(paramCvMat2, paramCvMat1, this.H);
        opencv_core.cvInvert(this.H, this.H);
      }
      for (;;)
      {
        set(this.H, false);
        return;
        if (paramBoolean1)
        {
          opencv_core.cvInvert(paramCvMat1, this.H);
          opencv_core.cvMatMul(this.H, paramCvMat2, this.H);
        }
        else if (paramBoolean2)
        {
          opencv_core.cvInvert(paramCvMat2, this.H);
          opencv_core.cvMatMul(paramCvMat1, this.H, this.H);
        }
        else
        {
          opencv_core.cvMatMul(paramCvMat1, paramCvMat2, this.H);
        }
      }
    }
    
    public double get(int paramInt)
    {
      return this.projectiveParameters[paramInt];
    }
    
    public double[] get()
    {
      double[] arrayOfDouble = new double[size()];
      for (int i = 0; i < arrayOfDouble.length; i++) {
        arrayOfDouble[i] = get(i);
      }
      return arrayOfDouble;
    }
    
    public double getConstraintError()
    {
      update();
      return this.constraintError;
    }
    
    public opencv_core.CvMat getH()
    {
      update();
      return this.H;
    }
    
    public opencv_core.CvMat getN()
    {
      update();
      return this.n2;
    }
    
    public opencv_core.CvMat getR()
    {
      update();
      return this.R2;
    }
    
    public double[] getSubspace()
    {
      return null;
    }
    
    public opencv_core.CvMat getT()
    {
      update();
      return this.t2;
    }
    
    public boolean isUpdateNeeded()
    {
      return this.updateNeeded;
    }
    
    public boolean preoptimize()
    {
      return false;
    }
    
    public void reset(boolean paramBoolean)
    {
      setUpdateNeeded(true);
      if ((ProjectiveTransformer.this.referencePoints1 != null) && ((ProjectiveTransformer.this.referencePoints1.length == 0) || (ProjectiveTransformer.this.referencePoints1.length == 8))) {
        if (ProjectiveTransformer.this.referencePoints1.length == 0) {
          this.projectiveParameters = new double[] { 1.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D, 0.0D };
        }
      }
      while ((ProjectiveTransformer.this.K2 == null) || (ProjectiveTransformer.this.invK1 == null))
      {
        return;
        this.projectiveParameters = ((double[])ProjectiveTransformer.this.referencePoints1.clone());
        return;
      }
      if ((ProjectiveTransformer.this.R != null) && (ProjectiveTransformer.this.t != null))
      {
        double[] arrayOfDouble = new double[3];
        arrayOfDouble[0] = ProjectiveTransformer.this.referencePoints1[0];
        arrayOfDouble[1] = ProjectiveTransformer.this.referencePoints1[2];
        arrayOfDouble[2] = ProjectiveTransformer.this.referencePoints1[4];
        this.projectiveParameters = arrayOfDouble;
        return;
      }
      if (ProjectiveTransformer.this.n != null)
      {
        this.projectiveParameters = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
        return;
      }
      this.projectiveParameters = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
    }
    
    public void set(int paramInt, double paramDouble)
    {
      if (this.projectiveParameters[paramInt] != paramDouble)
      {
        this.projectiveParameters[paramInt] = paramDouble;
        setUpdateNeeded(true);
      }
    }
    
    public void set(ImageTransformer.Parameters paramParameters)
    {
      set(paramParameters.get());
      this.fakeIdentity = ((Parameters)paramParameters).fakeIdentity;
    }
    
    public void set(opencv_core.CvMat paramCvMat, boolean paramBoolean)
    {
      if ((this.projectiveParameters.length == 8) && (ProjectiveTransformer.this.referencePoints1 != null))
      {
        if (paramBoolean) {
          opencv_core.cvInvert(paramCvMat, this.H);
        }
        while (ProjectiveTransformer.this.referencePoints1.length == 0)
        {
          for (int i = 0; i < 8; i++) {
            this.projectiveParameters[i] = (this.H.get(i) / this.H.get(8));
          }
          if (paramCvMat != this.H) {
            opencv_core.cvCopy(paramCvMat, this.H);
          }
        }
        opencv_core.CvMat localCvMat = ((opencv_core.CvMat)ProjectiveTransformer.pts4x1.get()).put(ProjectiveTransformer.this.referencePoints1);
        opencv_core.cvPerspectiveTransform(localCvMat, localCvMat, this.H);
        localCvMat.get(this.projectiveParameters);
        setUpdateNeeded(true);
        return;
      }
      throw new UnsupportedOperationException("Set homography operation not supported.");
    }
    
    public void set(double... paramVarArgs)
    {
      for (int i = 0; i < paramVarArgs.length; i++) {
        set(i, paramVarArgs[i]);
      }
    }
    
    public void setSubspace(double... paramVarArgs) {}
    
    public void setUpdateNeeded(boolean paramBoolean)
    {
      this.updateNeeded = paramBoolean;
    }
    
    public int size()
    {
      return this.projectiveParameters.length;
    }
    
    public String toString()
    {
      String str = "[";
      double[] arrayOfDouble = get();
      for (int i = 0; i < arrayOfDouble.length; i++)
      {
        str = str + (float)arrayOfDouble[i];
        if (i < -1 + arrayOfDouble.length) {
          str = str + ", ";
        }
      }
      return str + "]";
    }
    
    protected void update()
    {
      if (!isUpdateNeeded()) {
        return;
      }
      if ((ProjectiveTransformer.this.referencePoints1 != null) && ((ProjectiveTransformer.this.referencePoints1.length == 0) || (ProjectiveTransformer.this.referencePoints1.length == 8))) {
        if (ProjectiveTransformer.this.referencePoints1.length == 0)
        {
          this.H.put(0, this.projectiveParameters, 0, 8);
          this.H.put(8, 1.0D);
        }
      }
      for (;;)
      {
        setUpdateNeeded(false);
        return;
        JavaCV.getPerspectiveTransform(ProjectiveTransformer.this.referencePoints1, this.projectiveParameters, this.H);
        continue;
        if ((ProjectiveTransformer.this.K2 != null) && (ProjectiveTransformer.this.invK1 != null))
        {
          if ((ProjectiveTransformer.this.R == null) || (ProjectiveTransformer.this.t == null)) {
            break;
          }
          double[] arrayOfDouble1 = ProjectiveTransformer.this.referencePoints2;
          double[] arrayOfDouble2 = new double[6];
          arrayOfDouble2[0] = this.projectiveParameters[0];
          arrayOfDouble2[1] = ProjectiveTransformer.this.referencePoints1[1];
          arrayOfDouble2[2] = this.projectiveParameters[1];
          arrayOfDouble2[3] = ProjectiveTransformer.this.referencePoints1[3];
          arrayOfDouble2[4] = this.projectiveParameters[2];
          arrayOfDouble2[5] = ProjectiveTransformer.this.referencePoints1[5];
          if (this.R2 == null) {
            this.R2 = opencv_core.CvMat.create(3, 3);
          }
          if (this.t2 == null) {
            this.t2 = opencv_core.CvMat.create(3, 1);
          }
          opencv_core.cvTranspose(ProjectiveTransformer.this.R, this.R2);
          opencv_core.cvGEMM(this.R2, ProjectiveTransformer.this.t, -1.0D, null, 0.0D, this.t2, 0);
          JavaCV.getPerspectiveTransform(arrayOfDouble1, arrayOfDouble2, ProjectiveTransformer.this.invK2, ProjectiveTransformer.this.K1, this.R2, this.t2, this.H);
        }
      }
      if (ProjectiveTransformer.this.n != null) {
        this.n2 = ProjectiveTransformer.this.n;
      }
      for (;;)
      {
        if (this.R2 == null) {
          this.R2 = opencv_core.CvMat.create(3, 3);
        }
        if (this.t2 == null) {
          this.t2 = opencv_core.CvMat.create(3, 1);
        }
        this.t2.put(0, this.projectiveParameters, 0, 3);
        opencv_calib3d.cvRodrigues2(this.t2, this.R2, null);
        this.t2.put(0, this.projectiveParameters, 3, 3);
        opencv_core.cvGEMM(this.t2, this.n2, -1.0D, this.R2, 1.0D, this.H, 2);
        break;
        if (this.n2 == null) {
          this.n2 = opencv_core.CvMat.create(3, 1);
        }
        this.n2.put(0, this.projectiveParameters, 8, 3);
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\ProjectiveTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */