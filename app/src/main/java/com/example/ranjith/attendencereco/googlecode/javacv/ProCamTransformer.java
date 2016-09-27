package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.cvkernels;
import com.googlecode.javacv.cpp.cvkernels.KernelData;
import com.googlecode.javacv.cpp.opencv_calib3d;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_core.IplROI;
import com.googlecode.javacv.cpp.opencv_imgproc;

public class ProCamTransformer
  implements ImageTransformer
{
  protected opencv_core.CvMat[] H1 = null;
  protected opencv_core.CvMat[] H2 = null;
  protected opencv_core.CvMat[] X = null;
  protected CameraDevice camera = null;
  protected opencv_core.CvScalar fillColor = opencv_core.cvScalar(0.0D, 0.0D, 0.0D, 1.0D);
  protected opencv_core.CvMat frontoParallelH = null;
  protected opencv_core.CvMat invCameraMatrix = null;
  protected opencv_core.CvMat invFrontoParallelH = null;
  protected cvkernels.KernelData kernelData = null;
  protected ProjectorDevice projector = null;
  protected opencv_core.IplImage[] projectorImage = null;
  protected ProjectiveColorTransformer projectorTransformer = null;
  protected opencv_core.CvRect roi = new opencv_core.CvRect();
  protected opencv_core.IplImage[] surfaceImage = null;
  protected ProjectiveColorTransformer surfaceTransformer = null;
  
  static
  {
    if (!ProCamTransformer.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ProCamTransformer(double[] paramArrayOfDouble, CameraDevice paramCameraDevice, ProjectorDevice paramProjectorDevice)
  {
    this(paramArrayOfDouble, paramCameraDevice, paramProjectorDevice, null);
  }
  
  public ProCamTransformer(double[] paramArrayOfDouble, CameraDevice paramCameraDevice, ProjectorDevice paramProjectorDevice, opencv_core.CvMat paramCvMat)
  {
    this.camera = paramCameraDevice;
    this.projector = paramProjectorDevice;
    if (paramArrayOfDouble != null) {
      this.surfaceTransformer = new ProjectiveColorTransformer(paramCameraDevice.cameraMatrix, paramCameraDevice.cameraMatrix, null, null, paramCvMat, paramArrayOfDouble, null, null, 3, 0);
    }
    double[] arrayOfDouble1 = new double[6];
    arrayOfDouble1[0] = 0.0D;
    arrayOfDouble1[1] = 0.0D;
    arrayOfDouble1[2] = (paramCameraDevice.imageWidth / 2);
    arrayOfDouble1[3] = paramCameraDevice.imageHeight;
    arrayOfDouble1[4] = paramCameraDevice.imageWidth;
    arrayOfDouble1[5] = 0.0D;
    double[] arrayOfDouble2 = new double[6];
    arrayOfDouble2[0] = 0.0D;
    arrayOfDouble2[1] = 0.0D;
    arrayOfDouble2[2] = (paramProjectorDevice.imageWidth / 2);
    arrayOfDouble2[3] = paramProjectorDevice.imageHeight;
    arrayOfDouble2[4] = paramProjectorDevice.imageWidth;
    arrayOfDouble2[5] = 0.0D;
    if (paramCvMat != null)
    {
      this.invCameraMatrix = opencv_core.CvMat.create(3, 3);
      opencv_core.cvInvert(paramCameraDevice.cameraMatrix, this.invCameraMatrix);
      JavaCV.perspectiveTransform(arrayOfDouble2, arrayOfDouble1, this.invCameraMatrix, paramProjectorDevice.cameraMatrix, paramProjectorDevice.R, paramProjectorDevice.T, paramCvMat, true);
    }
    this.projectorTransformer = new ProjectiveColorTransformer(paramCameraDevice.cameraMatrix, paramProjectorDevice.cameraMatrix, paramProjectorDevice.R, paramProjectorDevice.T, null, arrayOfDouble1, arrayOfDouble2, paramProjectorDevice.colorMixingMatrix, 1, 3);
    if ((paramArrayOfDouble != null) && (paramCvMat != null))
    {
      this.frontoParallelH = paramCameraDevice.getFrontoParallelH(paramArrayOfDouble, paramCvMat, opencv_core.CvMat.create(3, 3));
      this.invFrontoParallelH = this.frontoParallelH.clone();
      opencv_core.cvInvert(this.frontoParallelH, this.invFrontoParallelH);
    }
  }
  
  public Parameters createParameters()
  {
    return new Parameters();
  }
  
  public opencv_core.CvScalar getFillColor()
  {
    return this.fillColor;
  }
  
  public int getNumBiases()
  {
    return this.projectorTransformer.getNumBiases();
  }
  
  public int getNumGains()
  {
    return this.projectorTransformer.getNumGains();
  }
  
  public opencv_core.IplImage getProjectorImage(int paramInt)
  {
    return this.projectorImage[paramInt];
  }
  
  public ProjectiveColorTransformer getProjectorTransformer()
  {
    return this.projectorTransformer;
  }
  
  public opencv_core.IplImage getSurfaceImage(int paramInt)
  {
    return this.surfaceImage[paramInt];
  }
  
  public ProjectiveColorTransformer getSurfaceTransformer()
  {
    return this.surfaceTransformer;
  }
  
  protected void prepareTransforms(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, int paramInt, Parameters paramParameters)
  {
    ProjectiveColorTransformer.Parameters localParameters1 = paramParameters.getSurfaceParameters();
    ProjectiveColorTransformer.Parameters localParameters2 = paramParameters.getProjectorParameters();
    if (this.surfaceTransformer != null) {
      opencv_core.cvInvert(localParameters1.getH(), paramCvMat1);
    }
    opencv_core.cvInvert(localParameters2.getH(), paramCvMat2);
    if (paramInt > 0)
    {
      int i = 1 << paramInt;
      if (this.surfaceTransformer != null)
      {
        paramCvMat1.put(2, paramCvMat1.get(2) / i);
        paramCvMat1.put(5, paramCvMat1.get(5) / i);
        paramCvMat1.put(6, paramCvMat1.get(6) * i);
        paramCvMat1.put(7, paramCvMat1.get(7) * i);
      }
      paramCvMat2.put(2, paramCvMat2.get(2) / i);
      paramCvMat2.put(5, paramCvMat2.get(5) / i);
      paramCvMat2.put(6, paramCvMat2.get(6) * i);
      paramCvMat2.put(7, paramCvMat2.get(7) * i);
    }
    double[] arrayOfDouble1 = this.projector.colorMixingMatrix.get();
    double[] arrayOfDouble2 = localParameters2.getColorParameters();
    double d = arrayOfDouble2[0];
    double[] arrayOfDouble3 = new double[16];
    arrayOfDouble3[0] = (d * arrayOfDouble1[0]);
    arrayOfDouble3[1] = (d * arrayOfDouble1[1]);
    arrayOfDouble3[2] = (d * arrayOfDouble1[2]);
    arrayOfDouble3[3] = arrayOfDouble2[1];
    arrayOfDouble3[4] = (d * arrayOfDouble1[3]);
    arrayOfDouble3[5] = (d * arrayOfDouble1[4]);
    arrayOfDouble3[6] = (d * arrayOfDouble1[5]);
    arrayOfDouble3[7] = arrayOfDouble2[2];
    arrayOfDouble3[8] = (d * arrayOfDouble1[6]);
    arrayOfDouble3[9] = (d * arrayOfDouble1[7]);
    arrayOfDouble3[10] = (d * arrayOfDouble1[8]);
    arrayOfDouble3[11] = arrayOfDouble2[3];
    arrayOfDouble3[12] = 0.0D;
    arrayOfDouble3[13] = 0.0D;
    arrayOfDouble3[14] = 0.0D;
    arrayOfDouble3[15] = 1.0D;
    paramCvMat3.put(arrayOfDouble3);
  }
  
  public void setFillColor(opencv_core.CvScalar paramCvScalar)
  {
    this.fillColor = paramCvScalar;
  }
  
  public void setProjectorImage(opencv_core.IplImage paramIplImage, int paramInt1, int paramInt2)
  {
    setProjectorImage(paramIplImage, paramInt1, paramInt2, true);
  }
  
  public void setProjectorImage(opencv_core.IplImage paramIplImage, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.projectorImage == null) || (this.projectorImage.length != paramInt2 + 1)) {
      this.projectorImage = new opencv_core.IplImage[paramInt2 + 1];
    }
    int i;
    if ((paramIplImage.depth() == 32) || (!paramBoolean))
    {
      this.projectorImage[paramInt1] = paramIplImage;
      i = paramInt1 + 1;
      label54:
      if (i > paramInt2) {
        return;
      }
      int j = this.projectorImage[(i - 1)].width() / 2;
      int k = this.projectorImage[(i - 1)].height() / 2;
      int m = this.projectorImage[(i - 1)].depth();
      int n = this.projectorImage[(i - 1)].nChannels();
      int i1 = this.projectorImage[(i - 1)].origin();
      if (this.projectorImage[i] == null) {
        this.projectorImage[i] = opencv_core.IplImage.create(j, k, m, n, i1);
      }
      opencv_core.IplROI localIplROI1 = this.projectorImage[(i - 1)].roi();
      if (localIplROI1 == null) {
        break label526;
      }
      this.roi.x(localIplROI1.xOffset() / 2);
      this.roi.width(localIplROI1.width() / 2);
      this.roi.y(localIplROI1.yOffset() / 2);
      this.roi.height(localIplROI1.height() / 2);
      opencv_core.cvSetImageROI(this.projectorImage[i], this.roi);
    }
    for (;;)
    {
      opencv_imgproc.cvPyrDown(this.projectorImage[(i - 1)], this.projectorImage[i], 7);
      opencv_core.cvResetImageROI(this.projectorImage[(i - 1)]);
      i++;
      break label54;
      if (this.projectorImage[paramInt1] == null) {
        this.projectorImage[paramInt1] = opencv_core.IplImage.create(paramIplImage.width(), paramIplImage.height(), 32, paramIplImage.nChannels(), paramIplImage.origin());
      }
      opencv_core.IplROI localIplROI2 = paramIplImage.roi();
      if (localIplROI2 != null)
      {
        int i2 = 1 << paramInt2 + 1;
        this.roi.x(Math.max(0, i2 * (int)Math.floor(localIplROI2.xOffset() / i2)));
        this.roi.y(Math.max(0, i2 * (int)Math.floor(localIplROI2.yOffset() / i2)));
        this.roi.width(Math.min(paramIplImage.width(), i2 * (int)Math.ceil(localIplROI2.width() / i2)));
        this.roi.height(Math.min(paramIplImage.height(), i2 * (int)Math.ceil(localIplROI2.height() / i2)));
        opencv_core.cvSetImageROI(paramIplImage, this.roi);
        opencv_core.cvSetImageROI(this.projectorImage[paramInt1], this.roi);
      }
      for (;;)
      {
        opencv_core.cvConvertScale(paramIplImage, this.projectorImage[paramInt1], 0.00392156862745098D, 0.0D);
        break;
        opencv_core.cvResetImageROI(paramIplImage);
        opencv_core.cvResetImageROI(this.projectorImage[paramInt1]);
      }
      label526:
      opencv_core.cvResetImageROI(this.projectorImage[i]);
    }
  }
  
  public void setSurfaceImage(opencv_core.IplImage paramIplImage, int paramInt)
  {
    if ((this.surfaceImage == null) || (this.surfaceImage.length != paramInt)) {
      this.surfaceImage = new opencv_core.IplImage[paramInt];
    }
    this.surfaceImage[0] = paramIplImage;
    opencv_core.cvResetImageROI(paramIplImage);
    int i = 1;
    if (i < paramInt)
    {
      int j = this.surfaceImage[(i - 1)].width() / 2;
      int k = this.surfaceImage[(i - 1)].height() / 2;
      int m = this.surfaceImage[(i - 1)].depth();
      int n = this.surfaceImage[(i - 1)].nChannels();
      int i1 = this.surfaceImage[(i - 1)].origin();
      if (this.surfaceImage[i] == null) {
        this.surfaceImage[i] = opencv_core.IplImage.create(j, k, m, n, i1);
      }
      for (;;)
      {
        opencv_imgproc.cvPyrDown(this.surfaceImage[(i - 1)], this.surfaceImage[i], 7);
        i++;
        break;
        opencv_core.cvResetImageROI(this.surfaceImage[i]);
      }
    }
  }
  
  public void transform(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, ImageTransformer.Parameters paramParameters, boolean paramBoolean)
  {
    if (this.surfaceTransformer != null) {
      this.surfaceTransformer.transform(paramCvMat1, paramCvMat2, ((Parameters)paramParameters).surfaceParameters, paramBoolean);
    }
    while (paramCvMat2 == paramCvMat1) {
      return;
    }
    paramCvMat2.put(paramCvMat1);
  }
  
  public void transform(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.CvRect paramCvRect, int paramInt, ImageTransformer.Parameters paramParameters, boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new UnsupportedOperationException("Inverse transform not supported.");
    }
    Parameters localParameters = (Parameters)paramParameters;
    ProjectiveColorTransformer.Parameters localParameters1 = localParameters.getSurfaceParameters();
    ProjectiveColorTransformer.Parameters localParameters2 = localParameters.getProjectorParameters();
    if ((localParameters.tempImage == null) || (localParameters.tempImage.length <= paramInt)) {
      Parameters.access$002(localParameters, new opencv_core.IplImage[paramInt + 1]);
    }
    localParameters.tempImage[paramInt] = opencv_core.IplImage.createIfNotCompatible(localParameters.tempImage[paramInt], paramIplImage2);
    if (paramCvRect == null) {
      opencv_core.cvResetImageROI(localParameters.tempImage[paramInt]);
    }
    for (;;)
    {
      if (this.surfaceTransformer != null) {
        this.surfaceTransformer.transform(paramIplImage1, localParameters.tempImage[paramInt], paramCvRect, paramInt, localParameters1, false);
      }
      this.projectorTransformer.transform(this.projectorImage[paramInt], paramIplImage2, paramCvRect, paramInt, localParameters2, false);
      if (this.surfaceTransformer == null) {
        break;
      }
      opencv_core.cvMul(paramIplImage2, localParameters.tempImage[paramInt], paramIplImage2, 1.0D / paramIplImage2.highValue());
      return;
      opencv_core.cvSetImageROI(localParameters.tempImage[paramInt], paramCvRect);
    }
    opencv_core.cvCopy(localParameters.tempImage[paramInt], paramIplImage2);
  }
  
  public void transform(ImageTransformer.Data[] paramArrayOfData, opencv_core.CvRect paramCvRect, ImageTransformer.Parameters[] paramArrayOfParameters, boolean[] paramArrayOfBoolean)
  {
    assert (paramArrayOfData.length == paramArrayOfParameters.length);
    if ((this.kernelData == null) || (this.kernelData.capacity() < paramArrayOfData.length)) {
      this.kernelData = new cvkernels.KernelData(paramArrayOfData.length);
    }
    if (((this.H1 == null) || (this.H1.length < paramArrayOfData.length)) && (this.surfaceTransformer != null))
    {
      this.H1 = new opencv_core.CvMat[paramArrayOfData.length];
      for (int i1 = 0; i1 < this.H1.length; i1++) {
        this.H1[i1] = opencv_core.CvMat.create(3, 3);
      }
    }
    if ((this.H2 == null) || (this.H2.length < paramArrayOfData.length))
    {
      this.H2 = new opencv_core.CvMat[paramArrayOfData.length];
      for (int i = 0; i < this.H2.length; i++) {
        this.H2[i] = opencv_core.CvMat.create(3, 3);
      }
    }
    if ((this.X == null) || (this.X.length < paramArrayOfData.length))
    {
      this.X = new opencv_core.CvMat[paramArrayOfData.length];
      for (int j = 0; j < this.X.length; j++) {
        this.X[j] = opencv_core.CvMat.create(4, 4);
      }
    }
    int k = 0;
    if (k < paramArrayOfData.length)
    {
      this.kernelData.position(k);
      this.kernelData.srcImg(this.projectorImage[paramArrayOfData[k].pyramidLevel]);
      cvkernels.KernelData localKernelData1 = this.kernelData;
      if (this.surfaceTransformer == null) {}
      for (opencv_core.IplImage localIplImage = null;; localIplImage = paramArrayOfData[k].srcImg)
      {
        localKernelData1.srcImg2(localIplImage);
        this.kernelData.subImg(paramArrayOfData[k].subImg);
        this.kernelData.srcDotImg(paramArrayOfData[k].srcDotImg);
        this.kernelData.mask(paramArrayOfData[k].mask);
        this.kernelData.zeroThreshold(paramArrayOfData[k].zeroThreshold);
        this.kernelData.outlierThreshold(paramArrayOfData[k].outlierThreshold);
        if ((paramArrayOfBoolean == null) || (paramArrayOfBoolean[k] == 0)) {
          break;
        }
        throw new UnsupportedOperationException("Inverse transform not supported.");
      }
      opencv_core.CvMat localCvMat1;
      label416:
      cvkernels.KernelData localKernelData2;
      if (this.surfaceTransformer == null)
      {
        localCvMat1 = null;
        prepareTransforms(localCvMat1, this.H2[k], this.X[k], paramArrayOfData[k].pyramidLevel, (Parameters)paramArrayOfParameters[k]);
        this.kernelData.H1(this.H2[k]);
        localKernelData2 = this.kernelData;
        if (this.surfaceTransformer != null) {
          break label567;
        }
      }
      label567:
      for (opencv_core.CvMat localCvMat2 = null;; localCvMat2 = this.H1[k])
      {
        localKernelData2.H2(localCvMat2);
        this.kernelData.X(this.X[k]);
        this.kernelData.transImg(paramArrayOfData[k].transImg);
        this.kernelData.dstImg(paramArrayOfData[k].dstImg);
        this.kernelData.dstDstDot(paramArrayOfData[k].dstDstDot);
        k++;
        break;
        localCvMat1 = this.H1[k];
        break label416;
      }
    }
    int m = this.kernelData.capacity();
    this.kernelData.capacity(paramArrayOfData.length);
    cvkernels.multiWarpColorTransform(this.kernelData, paramCvRect, getFillColor());
    this.kernelData.capacity(m);
    for (int n = 0; n < paramArrayOfData.length; n++)
    {
      this.kernelData.position(n);
      paramArrayOfData[n].dstCount = this.kernelData.dstCount();
      paramArrayOfData[n].dstCountZero = this.kernelData.dstCountZero();
      paramArrayOfData[n].dstCountOutlier = this.kernelData.dstCountOutlier();
      paramArrayOfData[n].srcDstDot = this.kernelData.srcDstDot();
    }
  }
  
  public class Parameters
    implements ImageTransformer.Parameters
  {
    private opencv_core.CvMat H = opencv_core.CvMat.create(3, 3);
    private opencv_core.CvMat R = opencv_core.CvMat.create(3, 3);
    private opencv_core.CvMat n = opencv_core.CvMat.create(3, 1);
    private ProjectiveColorTransformer.Parameters projectorParameters = null;
    private ProjectiveColorTransformer.Parameters surfaceParameters = null;
    private opencv_core.CvMat t = opencv_core.CvMat.create(3, 1);
    private opencv_core.IplImage[] tempImage = null;
    
    protected Parameters()
    {
      reset(false);
    }
    
    protected Parameters(ProjectiveColorTransformer.Parameters paramParameters1, ProjectiveColorTransformer.Parameters paramParameters2)
    {
      reset(paramParameters1, paramParameters2);
    }
    
    private int getSizeForProjector()
    {
      return this.projectorParameters.size();
    }
    
    private int getSizeForSurface()
    {
      if (ProCamTransformer.this.surfaceTransformer == null) {
        return 0;
      }
      return this.surfaceParameters.size() - ProCamTransformer.this.surfaceTransformer.getNumGains() - ProCamTransformer.this.surfaceTransformer.getNumBiases();
    }
    
    private double[] getSubspaceInternal()
    {
      if (ProCamTransformer.this.frontoParallelH == null) {
        return null;
      }
      opencv_core.cvMatMul(ProCamTransformer.this.surfaceTransformer.getK1(), ProCamTransformer.this.frontoParallelH, this.H);
      opencv_core.cvMatMul(this.surfaceParameters.getH(), this.H, this.H);
      opencv_core.cvMatMul(ProCamTransformer.this.surfaceTransformer.getInvK2(), this.H, this.H);
      JavaCV.HtoRt(this.H, this.R, this.t);
      opencv_calib3d.cvRodrigues2(this.R, this.n, null);
      double[] arrayOfDouble = new double[6];
      arrayOfDouble[0] = this.n.get(0);
      arrayOfDouble[1] = this.n.get(1);
      arrayOfDouble[2] = this.n.get(2);
      arrayOfDouble[3] = this.t.get(0);
      arrayOfDouble[4] = this.t.get(1);
      arrayOfDouble[5] = this.t.get(2);
      return arrayOfDouble;
    }
    
    private double[] setSubspaceInternal(double... paramVarArgs)
    {
      if (ProCamTransformer.this.invFrontoParallelH == null) {
        return null;
      }
      double[] arrayOfDouble1 = new double[11];
      opencv_core.CvMat localCvMat1 = this.t;
      double[] arrayOfDouble2 = new double[3];
      arrayOfDouble2[0] = paramVarArgs[0];
      arrayOfDouble2[1] = paramVarArgs[1];
      arrayOfDouble2[2] = paramVarArgs[2];
      localCvMat1.put(arrayOfDouble2);
      opencv_calib3d.cvRodrigues2(this.t, this.R, null);
      opencv_core.CvMat localCvMat2 = this.t;
      double[] arrayOfDouble3 = new double[3];
      arrayOfDouble3[0] = paramVarArgs[3];
      arrayOfDouble3[1] = paramVarArgs[4];
      arrayOfDouble3[2] = paramVarArgs[5];
      localCvMat2.put(arrayOfDouble3);
      opencv_core.CvMat localCvMat3 = this.H;
      double[] arrayOfDouble4 = new double[9];
      arrayOfDouble4[0] = this.R.get(0);
      arrayOfDouble4[1] = this.R.get(1);
      arrayOfDouble4[2] = this.t.get(0);
      arrayOfDouble4[3] = this.R.get(3);
      arrayOfDouble4[4] = this.R.get(4);
      arrayOfDouble4[5] = this.t.get(1);
      arrayOfDouble4[6] = this.R.get(6);
      arrayOfDouble4[7] = this.R.get(7);
      arrayOfDouble4[8] = this.t.get(2);
      localCvMat3.put(arrayOfDouble4);
      opencv_core.cvMatMul(this.H, ProCamTransformer.this.invFrontoParallelH, this.H);
      opencv_core.cvMatMul(ProCamTransformer.this.surfaceTransformer.getK2(), this.H, this.H);
      opencv_core.cvMatMul(this.H, ProCamTransformer.this.surfaceTransformer.getInvK1(), this.H);
      opencv_core.cvGEMM(this.R, this.t, 1.0D, null, 0.0D, this.t, 1);
      double d = 1.0D / this.t.get(2);
      this.n.put(new double[] { 0.0D, 0.0D, 1.0D });
      opencv_core.cvGEMM(this.R, this.n, d, null, 0.0D, this.n, 0);
      JavaCV.perspectiveTransform(ProCamTransformer.this.projectorTransformer.getReferencePoints2(), arrayOfDouble1, ProCamTransformer.this.projectorTransformer.getInvK1(), ProCamTransformer.this.projectorTransformer.getK2(), ProCamTransformer.this.projectorTransformer.getR(), ProCamTransformer.this.projectorTransformer.getT(), this.n, true);
      arrayOfDouble1[8] = arrayOfDouble1[0];
      arrayOfDouble1[9] = arrayOfDouble1[2];
      arrayOfDouble1[10] = arrayOfDouble1[4];
      JavaCV.perspectiveTransform(ProCamTransformer.this.surfaceTransformer.getReferencePoints1(), arrayOfDouble1, this.H);
      return arrayOfDouble1;
    }
    
    public Parameters clone()
    {
      Parameters localParameters = new Parameters(ProCamTransformer.this);
      if (this.surfaceParameters == null) {}
      for (ProjectiveColorTransformer.Parameters localParameters1 = null;; localParameters1 = this.surfaceParameters.clone())
      {
        localParameters.surfaceParameters = localParameters1;
        localParameters.projectorParameters = this.projectorParameters.clone();
        return localParameters;
      }
    }
    
    public void compose(ImageTransformer.Parameters paramParameters1, boolean paramBoolean1, ImageTransformer.Parameters paramParameters2, boolean paramBoolean2)
    {
      throw new UnsupportedOperationException("Compose operation not supported.");
    }
    
    public double get(int paramInt)
    {
      if (paramInt < getSizeForSurface()) {
        return this.surfaceParameters.get(paramInt);
      }
      return this.projectorParameters.get(paramInt - getSizeForSurface());
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
      if (ProCamTransformer.this.surfaceTransformer == null) {}
      for (double d = 0.0D;; d = this.surfaceParameters.getConstraintError())
      {
        this.projectorParameters.update();
        return d;
      }
    }
    
    public opencv_core.CvMat getN()
    {
      double[] arrayOfDouble1 = ProCamTransformer.this.projectorTransformer.getReferencePoints2();
      double[] arrayOfDouble2 = (double[])ProCamTransformer.this.projectorTransformer.getReferencePoints1().clone();
      arrayOfDouble2[0] = this.projectorParameters.get(0);
      arrayOfDouble2[2] = this.projectorParameters.get(1);
      arrayOfDouble2[4] = this.projectorParameters.get(2);
      opencv_core.cvTranspose(ProCamTransformer.this.projectorTransformer.getR(), this.R);
      opencv_core.cvGEMM(this.R, ProCamTransformer.this.projectorTransformer.getT(), -1.0D, null, 0.0D, this.t, 0);
      JavaCV.getPlaneParameters(arrayOfDouble1, arrayOfDouble2, ProCamTransformer.this.projectorTransformer.getInvK2(), ProCamTransformer.this.projectorTransformer.getK1(), this.R, this.t, this.n);
      double d = 1.0D + opencv_core.cvDotProduct(this.n, ProCamTransformer.this.projectorTransformer.getT());
      opencv_core.cvGEMM(this.R, this.n, 1.0D / d, null, 0.0D, this.n, 0);
      return this.n;
    }
    
    public opencv_core.CvMat getN0()
    {
      this.n = getN();
      if (ProCamTransformer.this.surfaceTransformer == null) {
        return this.n;
      }
      ProCamTransformer.this.camera.getFrontoParallelH(this.surfaceParameters.get(), this.n, this.R);
      opencv_core.cvInvert(this.surfaceParameters.getH(), this.H);
      opencv_core.cvMatMul(this.H, ProCamTransformer.this.surfaceTransformer.getK2(), this.H);
      opencv_core.cvMatMul(this.H, this.R, this.H);
      opencv_core.cvMatMul(ProCamTransformer.this.surfaceTransformer.getInvK1(), this.H, this.H);
      JavaCV.HtoRt(this.H, this.R, this.t);
      opencv_core.cvGEMM(this.R, this.t, 1.0D, null, 0.0D, this.t, 1);
      double d = 1.0D / this.t.get(2);
      this.n.put(new double[] { 0.0D, 0.0D, 1.0D });
      opencv_core.cvGEMM(this.R, this.n, d, null, 0.0D, this.n, 0);
      return this.n;
    }
    
    public ProjectiveColorTransformer.Parameters getProjectorParameters()
    {
      return this.projectorParameters;
    }
    
    public double[] getSubspace()
    {
      return getSubspaceInternal();
    }
    
    public ProjectiveColorTransformer.Parameters getSurfaceParameters()
    {
      return this.surfaceParameters;
    }
    
    public boolean preoptimize()
    {
      double[] arrayOfDouble = setSubspaceInternal(getSubspaceInternal());
      if (arrayOfDouble != null)
      {
        set(8, arrayOfDouble[8]);
        set(9, arrayOfDouble[9]);
        set(10, arrayOfDouble[10]);
        return true;
      }
      return false;
    }
    
    public void reset(ProjectiveColorTransformer.Parameters paramParameters1, ProjectiveColorTransformer.Parameters paramParameters2)
    {
      if ((paramParameters1 == null) && (ProCamTransformer.this.surfaceTransformer != null)) {
        paramParameters1 = ProCamTransformer.this.surfaceTransformer.createParameters();
      }
      if (paramParameters2 == null) {
        paramParameters2 = ProCamTransformer.this.projectorTransformer.createParameters();
      }
      this.surfaceParameters = paramParameters1;
      this.projectorParameters = paramParameters2;
      setSubspace(getSubspace());
    }
    
    public void reset(boolean paramBoolean)
    {
      reset(null, null);
    }
    
    public void set(int paramInt, double paramDouble)
    {
      if (paramInt < getSizeForSurface())
      {
        this.surfaceParameters.set(paramInt, paramDouble);
        return;
      }
      this.projectorParameters.set(paramInt - getSizeForSurface(), paramDouble);
    }
    
    public void set(ImageTransformer.Parameters paramParameters)
    {
      Parameters localParameters = (Parameters)paramParameters;
      if (ProCamTransformer.this.surfaceTransformer != null)
      {
        this.surfaceParameters.set(localParameters.getSurfaceParameters());
        this.surfaceParameters.resetColor(false);
      }
      this.projectorParameters.set(localParameters.getProjectorParameters());
    }
    
    public void set(double... paramVarArgs)
    {
      for (int i = 0; i < paramVarArgs.length; i++) {
        set(i, paramVarArgs[i]);
      }
    }
    
    public void setSubspace(double... paramVarArgs)
    {
      double[] arrayOfDouble = setSubspaceInternal(paramVarArgs);
      if (arrayOfDouble != null) {
        set(arrayOfDouble);
      }
    }
    
    public int size()
    {
      return getSizeForSurface() + getSizeForProjector();
    }
    
    public String toString()
    {
      if (this.surfaceParameters != null) {
        return this.surfaceParameters.toString() + this.projectorParameters.toString();
      }
      return this.projectorParameters.toString();
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\ProCamTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */