package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.BoolPointer;
import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.ShortPointer;
import com.googlecode.javacpp.annotation.Adapter;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Index;
import com.googlecode.javacpp.annotation.MemberGetter;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoOffset;
import com.googlecode.javacpp.annotation.Properties;
import com.googlecode.javacpp.annotation.StdVector;

@Properties({@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/ml/ml.hpp>", "opencv_adapters.h"}, includepath={"/usr/local/include:/opt/local/include/"}, link={"opencv_ml@.2.4", "opencv_core@.2.4"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @com.googlecode.javacpp.annotation.Platform(includepath={"C:/opencv/build/include/"}, link={"opencv_ml245", "opencv_core245"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x86/vc10/lib/"}, preloadpath={"C:/opencv/build/x86/vc10/bin/"}, value={"windows-x86"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x64/vc10/lib/"}, preloadpath={"C:/opencv/build/x64/vc10/bin/"}, value={"windows-x86_64"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class opencv_ml
{
  public static final int CV_COL_SAMPLE = 0;
  public static final int CV_COUNT = 0;
  public static final double CV_LOG2PI = 1.8378770664093456D;
  public static final int CV_PORTION = 1;
  public static final int CV_ROW_SAMPLE = 1;
  public static final int CV_TEST_ERROR = 1;
  public static final int CV_TRAIN_ERROR = 0;
  public static final int CV_TS_CONCENTRIC_SPHERES = 0;
  public static final String CV_TYPE_NAME_ML_ANN_MLP = "opencv-ml-ann-mlp";
  public static final String CV_TYPE_NAME_ML_BOOSTING = "opencv-ml-boost-tree";
  public static final String CV_TYPE_NAME_ML_CNN = "opencv-ml-cnn";
  public static final String CV_TYPE_NAME_ML_EM = "opencv-ml-em";
  public static final String CV_TYPE_NAME_ML_ERTREES = "opencv-ml-extremely-randomized-trees";
  public static final String CV_TYPE_NAME_ML_GBT = "opencv-ml-gradient-boosting-trees";
  public static final String CV_TYPE_NAME_ML_KNN = "opencv-ml-knn";
  public static final String CV_TYPE_NAME_ML_NBAYES = "opencv-ml-bayesian";
  public static final String CV_TYPE_NAME_ML_RTREES = "opencv-ml-random-trees";
  public static final String CV_TYPE_NAME_ML_SVM = "opencv-ml-svm";
  public static final String CV_TYPE_NAME_ML_TREE = "opencv-ml-tree";
  public static final int CV_VAR_CATEGORICAL = 1;
  public static final int CV_VAR_NUMERICAL;
  public static final int CV_VAR_ORDERED;
  
  static
  {
    Loader.load(opencv_core.class);
    if (Loader.load() != null) {
      initModule_ml();
    }
  }
  
  public static native int CV_DTREE_CAT_DIR(int paramInt, int[] paramArrayOfInt);
  
  public static int CV_IS_ROW_SAMPLE(int paramInt)
  {
    return paramInt & 0x1;
  }
  
  public static native void cvCreateTestSet(int paramInt1, opencv_core.CvMatArray paramCvMatArray1, int paramInt2, int paramInt3, opencv_core.CvMatArray paramCvMatArray2, int paramInt4, Pointer paramPointer);
  
  public static native void cvRandGaussMixture(opencv_core.CvMatArray paramCvMatArray1, opencv_core.CvMatArray paramCvMatArray2, float[] paramArrayOfFloat, int paramInt, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
  
  public static native void cvRandMVNormal(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvRNG paramCvRNG);
  
  @Cast({"bool"})
  @Namespace("cv")
  public static native boolean initModule_ml();
  
  public static class CvANN_MLP
    extends CvStatModel
  {
    public static final int GAUSSIAN = 2;
    public static final int IDENTITY = 0;
    public static final int NO_INPUT_SCALE = 2;
    public static final int NO_OUTPUT_SCALE = 4;
    public static final int SIGMOID_SYM = 1;
    public static final int UPDATE_WEIGHTS = 1;
    
    static
    {
      Loader.load();
    }
    
    public CvANN_MLP()
    {
      allocate();
    }
    
    public CvANN_MLP(Pointer paramPointer)
    {
      super();
    }
    
    public CvANN_MLP(opencv_core.CvMat paramCvMat, int paramInt, double paramDouble1, double paramDouble2)
    {
      allocate(paramCvMat, paramInt, paramDouble1, paramDouble2);
    }
    
    private native void allocate();
    
    private native void allocate(opencv_core.CvMat paramCvMat, int paramInt, double paramDouble1, double paramDouble2);
    
    public native void calc_activ_func_deriv(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, double[] paramArrayOfDouble);
    
    public native void create(opencv_core.CvMat paramCvMat, int paramInt, double paramDouble1, double paramDouble2);
    
    public native int get_layer_count();
    
    @Const
    public native opencv_core.CvMat get_layer_sizes();
    
    public native DoublePointer get_weights(int paramInt);
    
    public native float predict(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
    
    public native int train(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, @ByVal opencv_ml.CvANN_MLP_TrainParams paramCvANN_MLP_TrainParams, int paramInt);
  }
  
  @NoOffset
  public static class CvANN_MLP_TrainParams
    extends Pointer
  {
    public static final int BACKPROP = 0;
    public static final int RPROP = 1;
    
    static
    {
      Loader.load();
    }
    
    public CvANN_MLP_TrainParams()
    {
      allocate();
    }
    
    public CvANN_MLP_TrainParams(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvANN_MLP_TrainParams(Pointer paramPointer)
    {
      super();
    }
    
    public CvANN_MLP_TrainParams(opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt, double paramDouble1, double paramDouble2)
    {
      allocate(paramCvTermCriteria, paramInt, paramDouble1, paramDouble2);
    }
    
    private native void allocate();
    
    private native void allocate(@ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt, double paramDouble1, double paramDouble2);
    
    private native void allocateArray(int paramInt);
    
    public native double bp_dw_scale();
    
    public native CvANN_MLP_TrainParams bp_dw_scale(double paramDouble);
    
    public native double bp_moment_scale();
    
    public native CvANN_MLP_TrainParams bp_moment_scale(double paramDouble);
    
    public CvANN_MLP_TrainParams position(int paramInt)
    {
      return (CvANN_MLP_TrainParams)super.position(paramInt);
    }
    
    public native double rp_dw0();
    
    public native CvANN_MLP_TrainParams rp_dw0(double paramDouble);
    
    public native double rp_dw_max();
    
    public native CvANN_MLP_TrainParams rp_dw_max(double paramDouble);
    
    public native double rp_dw_min();
    
    public native CvANN_MLP_TrainParams rp_dw_min(double paramDouble);
    
    public native double rp_dw_minus();
    
    public native CvANN_MLP_TrainParams rp_dw_minus(double paramDouble);
    
    public native double rp_dw_plus();
    
    public native CvANN_MLP_TrainParams rp_dw_plus(double paramDouble);
    
    @ByRef
    public native opencv_core.CvTermCriteria term_crit();
    
    public native CvANN_MLP_TrainParams term_crit(opencv_core.CvTermCriteria paramCvTermCriteria);
    
    public native int train_method();
    
    public native CvANN_MLP_TrainParams train_method(int paramInt);
  }
  
  public static class CvBoost
    extends CvStatModel
  {
    public static final int DEFAULT = 0;
    public static final int DISCRETE = 0;
    public static final int GENTLE = 3;
    public static final int GINI = 1;
    public static final int LOGIT = 2;
    public static final int MISCLASS = 3;
    public static final int REAL = 1;
    public static final int SQERR = 4;
    
    static
    {
      Loader.load();
    }
    
    public CvBoost()
    {
      allocate();
    }
    
    public CvBoost(Pointer paramPointer)
    {
      super();
    }
    
    public CvBoost(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByVal opencv_ml.CvBoostParams paramCvBoostParams)
    {
      allocate(paramCvMat1, paramInt, paramCvMat2, paramCvMat3, paramCvMat4, paramCvMat5, paramCvMat6, paramCvBoostParams);
    }
    
    private native void allocate();
    
    private native void allocate(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByVal opencv_ml.CvBoostParams paramCvBoostParams);
    
    public native float calc_error(CvMLData paramCvMLData, int paramInt, @StdVector FloatPointer paramFloatPointer);
    
    @Const
    public native opencv_core.CvMat get_active_vars(boolean paramBoolean);
    
    @Const
    public native opencv_ml.CvDTreeTrainData get_data();
    
    @ByRef
    @Const
    public native opencv_ml.CvBoostParams get_params();
    
    public native opencv_core.CvMat get_subtree_weights();
    
    public native opencv_core.CvSeq get_weak_predictors();
    
    public native opencv_core.CvMat get_weak_response();
    
    public native opencv_core.CvMat get_weights();
    
    public native float predict(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @ByVal opencv_core.CvSlice paramCvSlice, boolean paramBoolean1, boolean paramBoolean2);
    
    public native void prune(@ByVal opencv_core.CvSlice paramCvSlice);
    
    public native boolean train(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByVal opencv_ml.CvBoostParams paramCvBoostParams, boolean paramBoolean);
    
    public native boolean train(CvMLData paramCvMLData, @ByVal opencv_ml.CvBoostParams paramCvBoostParams, boolean paramBoolean);
  }
  
  @NoOffset
  public static class CvBoostParams
    extends CvDTreeParams
  {
    static
    {
      Loader.load();
    }
    
    public CvBoostParams()
    {
      allocate();
    }
    
    public CvBoostParams(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvBoostParams(int paramInt1, int paramInt2, double paramDouble, int paramInt3, boolean paramBoolean, float[] paramArrayOfFloat)
    {
      allocate(paramInt1, paramInt2, paramDouble, paramInt3, paramBoolean, paramArrayOfFloat);
    }
    
    public CvBoostParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, double paramDouble, int paramInt3, boolean paramBoolean, float[] paramArrayOfFloat);
    
    private native void allocateArray(int paramInt);
    
    public native int boost_type();
    
    public native CvBoostParams boost_type(int paramInt);
    
    public CvBoostParams position(int paramInt)
    {
      return (CvBoostParams)super.position(paramInt);
    }
    
    public native int split_criteria();
    
    public native CvBoostParams split_criteria(int paramInt);
    
    public native int weak_count();
    
    public native CvBoostParams weak_count(int paramInt);
    
    public native double weight_trim_rate();
    
    public native CvBoostParams weight_trim_rate(double paramDouble);
  }
  
  public static class CvBoostTree
    extends CvDTree
  {
    static
    {
      Loader.load();
    }
    
    public CvBoostTree()
    {
      allocate();
    }
    
    public CvBoostTree(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void read(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode, CvBoost paramCvBoost, CvDTreeTrainData paramCvDTreeTrainData);
    
    public native void scale(double paramDouble);
    
    public native boolean train(CvDTreeTrainData paramCvDTreeTrainData, opencv_core.CvMat paramCvMat, CvBoost paramCvBoost);
  }
  
  @NoOffset
  public static class CvDTree
    extends CvStatModel
  {
    static
    {
      Loader.load();
    }
    
    public CvDTree()
    {
      allocate();
    }
    
    public CvDTree(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native float calc_error(CvMLData paramCvMLData, int paramInt, @StdVector FloatPointer paramFloatPointer);
    
    public native CvDTreeTrainData get_data();
    
    public native int get_pruned_tree_idx();
    
    @Const
    public native opencv_ml.CvDTreeNode get_root();
    
    @Const
    public native opencv_core.CvMat get_var_importance();
    
    public native CvDTreeNode predict(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, boolean paramBoolean);
    
    public native int pruned_tree_idx();
    
    public native CvDTree pruned_tree_idx(int paramInt);
    
    public native void read(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode, CvDTreeTrainData paramCvDTreeTrainData);
    
    public native boolean train(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByVal opencv_ml.CvDTreeParams paramCvDTreeParams);
    
    public native boolean train(CvDTreeTrainData paramCvDTreeTrainData, opencv_core.CvMat paramCvMat);
    
    public native boolean train(CvMLData paramCvMLData, @ByVal opencv_ml.CvDTreeParams paramCvDTreeParams);
    
    public native void write(opencv_core.CvFileStorage paramCvFileStorage);
  }
  
  public static class CvDTreeNode
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvDTreeNode()
    {
      allocate();
    }
    
    public CvDTreeNode(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvDTreeNode(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int Tn();
    
    public native CvDTreeNode Tn(int paramInt);
    
    public native double alpha();
    
    public native CvDTreeNode alpha(double paramDouble);
    
    public native int buf_idx();
    
    public native CvDTreeNode buf_idx(int paramInt);
    
    public native int class_idx();
    
    public native CvDTreeNode class_idx(int paramInt);
    
    public native int complexity();
    
    public native CvDTreeNode complexity(int paramInt);
    
    public native IntPointer cv_Tn();
    
    public native CvDTreeNode cv_Tn(IntPointer paramIntPointer);
    
    public native DoublePointer cv_node_error();
    
    public native CvDTreeNode cv_node_error(DoublePointer paramDoublePointer);
    
    public native DoublePointer cv_node_risk();
    
    public native CvDTreeNode cv_node_risk(DoublePointer paramDoublePointer);
    
    public native int depth();
    
    public native CvDTreeNode depth(int paramInt);
    
    public native int get_num_valid(int paramInt);
    
    public native CvDTreeNode left();
    
    public native CvDTreeNode left(CvDTreeNode paramCvDTreeNode);
    
    public native double maxlr();
    
    public native CvDTreeNode maxlr(double paramDouble);
    
    public native double node_risk();
    
    public native CvDTreeNode node_risk(double paramDouble);
    
    public native IntPointer num_valid();
    
    public native CvDTreeNode num_valid(IntPointer paramIntPointer);
    
    public native int offset();
    
    public native CvDTreeNode offset(int paramInt);
    
    public native CvDTreeNode parent();
    
    public native CvDTreeNode parent(CvDTreeNode paramCvDTreeNode);
    
    public CvDTreeNode position(int paramInt)
    {
      return (CvDTreeNode)super.position(paramInt);
    }
    
    public native CvDTreeNode right();
    
    public native CvDTreeNode right(CvDTreeNode paramCvDTreeNode);
    
    public native int sample_count();
    
    public native CvDTreeNode sample_count(int paramInt);
    
    public native void set_num_valid(int paramInt1, int paramInt2);
    
    public native CvDTreeNode split(CvDTreeSplit paramCvDTreeSplit);
    
    public native CvDTreeSplit split();
    
    public native double tree_error();
    
    public native CvDTreeNode tree_error(double paramDouble);
    
    public native double tree_risk();
    
    public native CvDTreeNode tree_risk(double paramDouble);
    
    public native double value();
    
    public native CvDTreeNode value(double paramDouble);
  }
  
  @NoOffset
  public static class CvDTreeParams
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvDTreeParams()
    {
      allocate();
    }
    
    public CvDTreeParams(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvDTreeParams(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean1, int paramInt3, int paramInt4, boolean paramBoolean2, boolean paramBoolean3, float[] paramArrayOfFloat)
    {
      allocate(paramInt1, paramInt2, paramFloat, paramBoolean1, paramInt3, paramInt4, paramBoolean2, paramBoolean3, paramArrayOfFloat);
    }
    
    public CvDTreeParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean1, int paramInt3, int paramInt4, boolean paramBoolean2, boolean paramBoolean3, float[] paramArrayOfFloat);
    
    private native void allocateArray(int paramInt);
    
    public native int cv_folds();
    
    public native CvDTreeParams cv_folds(int paramInt);
    
    public native int max_categories();
    
    public native CvDTreeParams max_categories(int paramInt);
    
    public native int max_depth();
    
    public native CvDTreeParams max_depth(int paramInt);
    
    public native int min_sample_count();
    
    public native CvDTreeParams min_sample_count(int paramInt);
    
    public CvDTreeParams position(int paramInt)
    {
      return (CvDTreeParams)super.position(paramInt);
    }
    
    @Const
    public native FloatPointer priors();
    
    public native CvDTreeParams priors(FloatPointer paramFloatPointer);
    
    public native float regression_accuracy();
    
    public native CvDTreeParams regression_accuracy(float paramFloat);
    
    public native CvDTreeParams truncate_pruned_tree(boolean paramBoolean);
    
    public native boolean truncate_pruned_tree();
    
    public native CvDTreeParams use_1se_rule(boolean paramBoolean);
    
    public native boolean use_1se_rule();
    
    public native CvDTreeParams use_surrogates(boolean paramBoolean);
    
    public native boolean use_surrogates();
  }
  
  public static class CvDTreeSplit
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvDTreeSplit()
    {
      allocate();
    }
    
    public CvDTreeSplit(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvDTreeSplit(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int condensed_idx();
    
    public native CvDTreeSplit condensed_idx(int paramInt);
    
    public native int inversed();
    
    public native CvDTreeSplit inversed(int paramInt);
    
    public native CvDTreeSplit next();
    
    public native CvDTreeSplit next(CvDTreeSplit paramCvDTreeSplit);
    
    @Name({"ord.c"})
    public native float ord_c();
    
    public native CvDTreeSplit ord_c(float paramFloat);
    
    @Name({"ord.split_point"})
    public native int ord_split_point();
    
    public native CvDTreeSplit ord_split_point(int paramInt);
    
    public CvDTreeSplit position(int paramInt)
    {
      return (CvDTreeSplit)super.position(paramInt);
    }
    
    public native float quality();
    
    public native CvDTreeSplit quality(float paramFloat);
    
    public native int subset(int paramInt);
    
    public native CvDTreeSplit subset(int paramInt1, int paramInt2);
    
    public native int var_idx();
    
    public native CvDTreeSplit var_idx(int paramInt);
  }
  
  @NoOffset
  public static class CvDTreeTrainData
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvDTreeTrainData()
    {
      allocate();
    }
    
    public CvDTreeTrainData(Pointer paramPointer)
    {
      super();
    }
    
    public CvDTreeTrainData(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, CvDTreeParams paramCvDTreeParams, boolean paramBoolean1, boolean paramBoolean2)
    {
      allocate(paramCvMat1, paramInt, paramCvMat2, paramCvMat3, paramCvMat4, paramCvMat5, paramCvMat6, paramCvDTreeParams, paramBoolean1, paramBoolean2);
    }
    
    private native void allocate();
    
    private native void allocate(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByRef opencv_ml.CvDTreeParams paramCvDTreeParams, boolean paramBoolean1, boolean paramBoolean2);
    
    public native opencv_core.CvMat buf();
    
    public native CvDTreeTrainData buf(opencv_core.CvMat paramCvMat);
    
    public native int buf_count();
    
    public native CvDTreeTrainData buf_count(int paramInt);
    
    public native int buf_size();
    
    public native CvDTreeTrainData buf_size(int paramInt);
    
    public native opencv_core.CvMat cat_count();
    
    public native CvDTreeTrainData cat_count(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat cat_map();
    
    public native CvDTreeTrainData cat_map(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat cat_ofs();
    
    public native CvDTreeTrainData cat_ofs(opencv_core.CvMat paramCvMat);
    
    public native int cat_var_count();
    
    public native CvDTreeTrainData cat_var_count(int paramInt);
    
    public native void clear();
    
    public native opencv_core.CvMat counts();
    
    public native CvDTreeTrainData counts(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvSet cv_heap();
    
    public native CvDTreeTrainData cv_heap(opencv_core.CvSet paramCvSet);
    
    public native CvDTreeNode data_root();
    
    public native CvDTreeTrainData data_root(CvDTreeNode paramCvDTreeNode);
    
    public native opencv_core.CvMat direction();
    
    public native CvDTreeTrainData direction(opencv_core.CvMat paramCvMat);
    
    public native void do_responses_copy();
    
    public native void free_node(CvDTreeNode paramCvDTreeNode);
    
    public native void free_node_data(CvDTreeNode paramCvDTreeNode);
    
    public native void free_train_data();
    
    @Const
    public native IntPointer get_cat_var_data(CvDTreeNode paramCvDTreeNode, int paramInt, int[] paramArrayOfInt);
    
    public native int get_child_buf_idx(CvDTreeNode paramCvDTreeNode);
    
    @Const
    public native IntPointer get_class_labels(CvDTreeNode paramCvDTreeNode, int[] paramArrayOfInt);
    
    @Const
    public native IntPointer get_cv_labels(CvDTreeNode paramCvDTreeNode, int[] paramArrayOfInt);
    
    public native long get_length_subbuf();
    
    public native int get_num_classes();
    
    @Const
    public native FloatPointer get_ord_responses(CvDTreeNode paramCvDTreeNode, float[] paramArrayOfFloat, int[] paramArrayOfInt);
    
    public native void get_ord_var_data(CvDTreeNode paramCvDTreeNode, int paramInt, float[] paramArrayOfFloat, int[] paramArrayOfInt1, @Cast({"const float**"}) PointerPointer paramPointerPointer1, @Cast({"const int**"}) PointerPointer paramPointerPointer2, int[] paramArrayOfInt2);
    
    @Const
    public native IntPointer get_sample_indices(CvDTreeNode paramCvDTreeNode, int[] paramArrayOfInt);
    
    public native int get_var_type(int paramInt);
    
    public native void get_vectors(opencv_core.CvMat paramCvMat, float[] paramArrayOfFloat1, @Cast({"uchar*"}) byte[] paramArrayOfByte, float[] paramArrayOfFloat2, boolean paramBoolean);
    
    public native int get_work_var_count();
    
    public native CvDTreeTrainData have_labels(boolean paramBoolean);
    
    public native boolean have_labels();
    
    public native CvDTreeTrainData have_priors(boolean paramBoolean);
    
    public native boolean have_priors();
    
    public native int is_buf_16u();
    
    public native CvDTreeTrainData is_buf_16u(int paramInt);
    
    public native CvDTreeTrainData is_classifier(boolean paramBoolean);
    
    public native boolean is_classifier();
    
    public native int max_c_count();
    
    public native CvDTreeTrainData max_c_count(int paramInt);
    
    public native CvDTreeNode new_node(CvDTreeNode paramCvDTreeNode, int paramInt1, int paramInt2, int paramInt3);
    
    public native CvDTreeSplit new_split_cat(int paramInt, float paramFloat);
    
    public native CvDTreeSplit new_split_ord(int paramInt1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2);
    
    public native opencv_core.CvSet node_heap();
    
    public native CvDTreeTrainData node_heap(opencv_core.CvSet paramCvSet);
    
    public native opencv_core.CvSet nv_heap();
    
    public native CvDTreeTrainData nv_heap(opencv_core.CvSet paramCvSet);
    
    public native int ord_var_count();
    
    public native CvDTreeTrainData ord_var_count(int paramInt);
    
    @ByRef
    public native opencv_ml.CvDTreeParams params();
    
    public native CvDTreeTrainData params(CvDTreeParams paramCvDTreeParams);
    
    public native opencv_core.CvMat priors();
    
    public native CvDTreeTrainData priors(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat priors_mult();
    
    public native CvDTreeTrainData priors_mult(opencv_core.CvMat paramCvMat);
    
    public native void read_params(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    @Const
    public native opencv_core.CvMat responses();
    
    public native CvDTreeTrainData responses(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat responses_copy();
    
    public native CvDTreeTrainData responses_copy(opencv_core.CvMat paramCvMat);
    
    @Adapter("RNGAdapter")
    @Const
    public native opencv_core.CvRNG rng();
    
    public native CvDTreeTrainData rng(opencv_core.CvRNG paramCvRNG);
    
    public native int sample_count();
    
    public native CvDTreeTrainData sample_count(int paramInt);
    
    public native void set_data(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByRef opencv_ml.CvDTreeParams paramCvDTreeParams, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
    
    public native boolean set_params(@ByRef opencv_ml.CvDTreeParams paramCvDTreeParams);
    
    public native CvDTreeTrainData shared(boolean paramBoolean);
    
    public native boolean shared();
    
    public native opencv_core.CvMat split_buf();
    
    public native CvDTreeTrainData split_buf(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvSet split_heap();
    
    public native CvDTreeTrainData split_heap(opencv_core.CvSet paramCvSet);
    
    public native CvDTreeNode subsample_data(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMemStorage temp_storage();
    
    public native CvDTreeTrainData temp_storage(opencv_core.CvMemStorage paramCvMemStorage);
    
    public native int tflag();
    
    public native CvDTreeTrainData tflag(int paramInt);
    
    @Const
    public native opencv_core.CvMat train_data();
    
    public native CvDTreeTrainData train_data(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMemStorage tree_storage();
    
    public native CvDTreeTrainData tree_storage(opencv_core.CvMemStorage paramCvMemStorage);
    
    public native int var_all();
    
    public native CvDTreeTrainData var_all(int paramInt);
    
    public native int var_count();
    
    public native CvDTreeTrainData var_count(int paramInt);
    
    public native opencv_core.CvMat var_idx();
    
    public native CvDTreeTrainData var_idx(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat var_type();
    
    public native CvDTreeTrainData var_type(opencv_core.CvMat paramCvMat);
    
    public native int work_var_count();
    
    public native CvDTreeTrainData work_var_count(int paramInt);
    
    public native void write_params(opencv_core.CvFileStorage paramCvFileStorage);
  }
  
  @NoOffset
  public static class CvERTreeTrainData
    extends CvDTreeTrainData
  {
    static
    {
      Loader.load();
    }
    
    public CvERTreeTrainData()
    {
      allocate();
    }
    
    public CvERTreeTrainData(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    @Const
    public native opencv_core.CvMat missing_mask();
    
    public native CvERTreeTrainData missing_mask(opencv_core.CvMat paramCvMat);
  }
  
  public static class CvERTrees
    extends CvRTrees
  {
    static
    {
      Loader.load();
    }
    
    public CvERTrees()
    {
      allocate();
    }
    
    public CvERTrees(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  public static class CvForestERTree
    extends CvForestTree
  {
    static
    {
      Loader.load();
    }
    
    public CvForestERTree()
    {
      allocate();
    }
    
    public CvForestERTree(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
  }
  
  public static class CvForestTree
    extends CvDTree
  {
    static
    {
      Loader.load();
    }
    
    public CvForestTree()
    {
      allocate();
    }
    
    public CvForestTree(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native int get_var_count();
    
    public native void read(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode, CvRTrees paramCvRTrees, CvDTreeTrainData paramCvDTreeTrainData);
    
    public native boolean train(CvDTreeTrainData paramCvDTreeTrainData, opencv_core.CvMat paramCvMat, CvRTrees paramCvRTrees);
  }
  
  public static class CvGBTrees
    extends CvStatModel
  {
    public static final int ABSOLUTE_LOSS = 1;
    public static final int DEVIANCE_LOSS = 4;
    public static final int HUBER_LOSS = 3;
    public static final int SQUARED_LOSS;
    
    static
    {
      Loader.load();
    }
    
    public CvGBTrees()
    {
      allocate();
    }
    
    public CvGBTrees(Pointer paramPointer)
    {
      super();
    }
    
    public CvGBTrees(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByVal opencv_ml.CvGBTreesParams paramCvGBTreesParams)
    {
      allocate(paramCvMat1, paramInt, paramCvMat2, paramCvMat3, paramCvMat4, paramCvMat5, paramCvMat6, paramCvGBTreesParams);
    }
    
    private native void allocate();
    
    private native void allocate(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByVal opencv_ml.CvGBTreesParams paramCvGBTreesParams);
    
    public native float calc_error(CvMLData paramCvMLData, int paramInt, @StdVector FloatPointer paramFloatPointer);
    
    public native float predict(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @ByVal opencv_core.CvSlice paramCvSlice, int paramInt);
    
    public native float predict_serial(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @ByVal opencv_core.CvSlice paramCvSlice, int paramInt);
    
    public native boolean train(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByVal opencv_ml.CvGBTreesParams paramCvGBTreesParams, boolean paramBoolean);
    
    public native boolean train(CvMLData paramCvMLData, @ByVal opencv_ml.CvGBTreesParams paramCvGBTreesParams, boolean paramBoolean);
  }
  
  @NoOffset
  public static class CvGBTreesParams
    extends CvDTreeParams
  {
    static
    {
      Loader.load();
    }
    
    public CvGBTreesParams()
    {
      allocate();
    }
    
    public CvGBTreesParams(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvGBTreesParams(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, boolean paramBoolean)
    {
      allocate(paramInt1, paramInt2, paramFloat1, paramFloat2, paramInt3, paramBoolean);
    }
    
    public CvGBTreesParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, boolean paramBoolean);
    
    private native void allocateArray(int paramInt);
    
    public native int loss_function_type();
    
    public native CvGBTreesParams loss_function_type(int paramInt);
    
    public CvGBTreesParams position(int paramInt)
    {
      return (CvGBTreesParams)super.position(paramInt);
    }
    
    public native float shrinkage();
    
    public native CvGBTreesParams shrinkage(float paramFloat);
    
    public native float subsample_portion();
    
    public native CvGBTreesParams subsample_portion(float paramFloat);
    
    public native int weak_count();
    
    public native CvGBTreesParams weak_count(int paramInt);
  }
  
  public static class CvKNearest
    extends CvStatModel
  {
    static
    {
      Loader.load();
    }
    
    public CvKNearest()
    {
      allocate();
    }
    
    public CvKNearest(Pointer paramPointer)
    {
      super();
    }
    
    public CvKNearest(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, boolean paramBoolean, int paramInt)
    {
      allocate(paramCvMat1, paramCvMat2, paramCvMat3, paramBoolean, paramInt);
    }
    
    private native void allocate();
    
    private native void allocate(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, boolean paramBoolean, int paramInt);
    
    public native float find_nearest(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, @Cast({"const float**"}) PointerPointer paramPointerPointer, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4);
    
    public native void find_neighbors_direct(opencv_core.CvMat paramCvMat, int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat1, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat2);
    
    public native int get_max_k();
    
    public native int get_sample_count();
    
    public native int get_var_count();
    
    public native boolean is_regression();
    
    public native boolean train(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, boolean paramBoolean1, int paramInt, boolean paramBoolean2);
    
    public native float write_results(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.Cv32suf paramCv32suf);
  }
  
  public static class CvMLData
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvMLData()
    {
      allocate();
    }
    
    public CvMLData(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvMLData(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native void change_var_idx(int paramInt, boolean paramBoolean);
    
    public native void change_var_type(int paramInt1, int paramInt2);
    
    @ByRef
    @Const
    public native opencv_ml.StringIntMap get_class_labels_map();
    
    public native byte get_delimiter();
    
    public native byte get_miss_ch();
    
    @Const
    public native opencv_core.CvMat get_missing();
    
    public native int get_response_idx();
    
    @Const
    public native opencv_core.CvMat get_responses();
    
    @Const
    public native opencv_core.CvMat get_test_sample_idx();
    
    @Const
    public native opencv_core.CvMat get_train_sample_idx();
    
    @Const
    public native opencv_core.CvMat get_values();
    
    @Const
    public native opencv_core.CvMat get_var_idx();
    
    public native int get_var_type(int paramInt);
    
    @Const
    public native opencv_core.CvMat get_var_types();
    
    public native void mix_train_and_test_idx();
    
    public CvMLData position(int paramInt)
    {
      return (CvMLData)super.position(paramInt);
    }
    
    public native int read_csv(String paramString);
    
    public native void set_delimiter(byte paramByte);
    
    public native void set_miss_ch(byte paramByte);
    
    public native void set_response_idx(int paramInt);
    
    public native void set_train_test_split(CvTrainTestSplit paramCvTrainTestSplit);
    
    public native void set_var_types(String paramString);
  }
  
  public static class CvNormalBayesClassifier
    extends CvStatModel
  {
    static
    {
      Loader.load();
    }
    
    public CvNormalBayesClassifier()
    {
      allocate();
    }
    
    public CvNormalBayesClassifier(Pointer paramPointer)
    {
      super();
    }
    
    public CvNormalBayesClassifier(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4)
    {
      allocate(paramCvMat1, paramCvMat2, paramCvMat3, paramCvMat4);
    }
    
    private native void allocate();
    
    private native void allocate(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4);
    
    public native float predict(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
    
    public native boolean train(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, boolean paramBoolean);
  }
  
  public static class CvPair16u32s
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvPair16u32s()
    {
      allocate();
    }
    
    public CvPair16u32s(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvPair16u32s(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native IntPointer i();
    
    public native CvPair16u32s i(IntPointer paramIntPointer);
    
    public CvPair16u32s position(int paramInt)
    {
      return (CvPair16u32s)super.position(paramInt);
    }
    
    @Cast({"unsigned short*"})
    public native ShortPointer u();
    
    public native CvPair16u32s u(ShortPointer paramShortPointer);
  }
  
  @NoOffset
  public static class CvParamGrid
    extends Pointer
  {
    public static final int SVM_C = 0;
    public static final int SVM_COEF = 4;
    public static final int SVM_DEGREE = 5;
    public static final int SVM_GAMMA = 1;
    public static final int SVM_NU = 3;
    public static final int SVM_P = 2;
    
    static
    {
      Loader.load();
    }
    
    public CvParamGrid()
    {
      allocate();
    }
    
    public CvParamGrid(double paramDouble1, double paramDouble2, double paramDouble3)
    {
      allocate(paramDouble1, paramDouble2, paramDouble3);
    }
    
    public CvParamGrid(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvParamGrid(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(double paramDouble1, double paramDouble2, double paramDouble3);
    
    private native void allocateArray(int paramInt);
    
    public native boolean check();
    
    public native double max_val();
    
    public native CvParamGrid max_val(double paramDouble);
    
    public native double min_val();
    
    public native CvParamGrid min_val(double paramDouble);
    
    public CvParamGrid position(int paramInt)
    {
      return (CvParamGrid)super.position(paramInt);
    }
    
    public native double step();
    
    public native CvParamGrid step(double paramDouble);
  }
  
  @NoOffset
  public static class CvRTParams
    extends CvDTreeParams
  {
    static
    {
      Loader.load();
    }
    
    public CvRTParams()
    {
      allocate();
    }
    
    public CvRTParams(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvRTParams(int paramInt1, int paramInt2, float paramFloat1, boolean paramBoolean1, int paramInt3, float[] paramArrayOfFloat, boolean paramBoolean2, int paramInt4, int paramInt5, float paramFloat2, int paramInt6)
    {
      allocate(paramInt1, paramInt2, paramFloat1, paramBoolean1, paramInt3, paramArrayOfFloat, paramBoolean2, paramInt4, paramInt5, paramFloat2, paramInt6);
    }
    
    public CvRTParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, float paramFloat1, boolean paramBoolean1, int paramInt3, float[] paramArrayOfFloat, boolean paramBoolean2, int paramInt4, int paramInt5, float paramFloat2, int paramInt6);
    
    private native void allocateArray(int paramInt);
    
    public native CvRTParams calc_var_importance(boolean paramBoolean);
    
    public native boolean calc_var_importance();
    
    public native int nactive_vars();
    
    public native CvRTParams nactive_vars(int paramInt);
    
    public CvRTParams position(int paramInt)
    {
      return (CvRTParams)super.position(paramInt);
    }
    
    @ByRef
    public native opencv_core.CvTermCriteria term_crit();
    
    public native CvRTParams term_crit(opencv_core.CvTermCriteria paramCvTermCriteria);
  }
  
  public static class CvRTrees
    extends CvStatModel
  {
    static
    {
      Loader.load();
    }
    
    public CvRTrees()
    {
      allocate();
    }
    
    public CvRTrees(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native float calc_error(CvMLData paramCvMLData, int paramInt, @StdVector FloatPointer paramFloatPointer);
    
    public native opencv_core.CvMat get_active_var_mask();
    
    public native float get_proximity(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4);
    
    public native opencv_core.CvRNG get_rng();
    
    public native float get_train_error();
    
    public native CvForestTree get_tree(int paramInt);
    
    public native int get_tree_count();
    
    @Const
    public native opencv_core.CvMat get_var_importance();
    
    public native float predict(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
    
    public native float predict_prob(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
    
    public native boolean train(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByVal opencv_ml.CvRTParams paramCvRTParams);
    
    public native boolean train(CvMLData paramCvMLData, @ByVal opencv_ml.CvRTParams paramCvRTParams);
  }
  
  public static class CvSVM
    extends CvStatModel
  {
    public static final int C = 0;
    public static final int COEF = 4;
    public static final int C_SVC = 100;
    public static final int DEGREE = 5;
    public static final int EPS_SVR = 103;
    public static final int GAMMA = 1;
    public static final int LINEAR = 0;
    public static final int NU = 3;
    public static final int NU_SVC = 101;
    public static final int NU_SVR = 104;
    public static final int ONE_CLASS = 102;
    public static final int P = 2;
    public static final int POLY = 1;
    public static final int RBF = 2;
    public static final int SIGMOID = 3;
    
    static
    {
      Loader.load();
    }
    
    public CvSVM()
    {
      allocate();
    }
    
    public CvSVM(Pointer paramPointer)
    {
      super();
    }
    
    public CvSVM(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, @ByVal opencv_ml.CvSVMParams paramCvSVMParams)
    {
      allocate(paramCvMat1, paramCvMat2, paramCvMat3, paramCvMat4, paramCvSVMParams);
    }
    
    private native void allocate();
    
    private native void allocate(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, @ByVal opencv_ml.CvSVMParams paramCvSVMParams);
    
    @ByVal
    public static native opencv_ml.CvParamGrid get_default_grid(int paramInt);
    
    @ByVal
    public native opencv_ml.CvSVMParams get_params();
    
    @Const
    public native FloatPointer get_support_vector(int paramInt);
    
    public native int get_support_vector_count();
    
    public native int get_var_count();
    
    public native float predict(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
    
    public native float predict(opencv_core.CvMat paramCvMat, boolean paramBoolean);
    
    public native boolean train(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, @ByVal opencv_ml.CvSVMParams paramCvSVMParams);
    
    public native boolean train_auto(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, @ByVal opencv_ml.CvSVMParams paramCvSVMParams, int paramInt, @ByVal opencv_ml.CvParamGrid paramCvParamGrid1, @ByVal opencv_ml.CvParamGrid paramCvParamGrid2, @ByVal opencv_ml.CvParamGrid paramCvParamGrid3, @ByVal opencv_ml.CvParamGrid paramCvParamGrid4, @ByVal opencv_ml.CvParamGrid paramCvParamGrid5, @ByVal opencv_ml.CvParamGrid paramCvParamGrid6, boolean paramBoolean);
  }
  
  public static class CvSVMDecisionFunc
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvSVMDecisionFunc()
    {
      allocate();
    }
    
    public CvSVMDecisionFunc(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvSVMDecisionFunc(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native DoublePointer alpha();
    
    public native CvSVMDecisionFunc alpha(DoublePointer paramDoublePointer);
    
    public CvSVMDecisionFunc position(int paramInt)
    {
      return (CvSVMDecisionFunc)super.position(paramInt);
    }
    
    public native double rho();
    
    public native CvSVMDecisionFunc rho(double paramDouble);
    
    public native int sv_count();
    
    public native CvSVMDecisionFunc sv_count(int paramInt);
    
    public native IntPointer sv_index();
    
    public native CvSVMDecisionFunc sv_index(IntPointer paramIntPointer);
  }
  
  @NoOffset
  public static class CvSVMKernel
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvSVMKernel()
    {
      allocate();
    }
    
    public CvSVMKernel(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvSVMKernel(Pointer paramPointer)
    {
      super();
    }
    
    public CvSVMKernel(CvSVMParams paramCvSVMParams, Calc paramCalc)
    {
      allocate(paramCvSVMParams, paramCalc);
    }
    
    private native void allocate();
    
    private native void allocate(CvSVMParams paramCvSVMParams, Calc paramCalc);
    
    private native void allocateArray(int paramInt);
    
    @ByRef
    @MemberGetter
    public static native Calc calc_linear();
    
    @ByRef
    @MemberGetter
    public static native Calc calc_poly();
    
    @ByRef
    @MemberGetter
    public static native Calc calc_rbf();
    
    @ByRef
    @MemberGetter
    public static native Calc calc_sigmoid();
    
    public native void calc(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
    
    public native Calc calc_func();
    
    public native CvSVMKernel calc_func(Calc paramCalc);
    
    public native void calc_linear(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
    
    public native void calc_non_rbf_base(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, double paramDouble1, double paramDouble2);
    
    public native void calc_poly(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
    
    public native void calc_rbf(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
    
    public native void calc_sigmoid(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
    
    public native void clear();
    
    public native CvSVMKernel params(CvSVMParams paramCvSVMParams);
    
    @Const
    public native opencv_ml.CvSVMParams params();
    
    public CvSVMKernel position(int paramInt)
    {
      return (CvSVMKernel)super.position(paramInt);
    }
    
    @Namespace("CvSVMKernel")
    public static class Calc
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      public Calc(Pointer paramPointer)
      {
        super();
      }
      
      public native void call(CvSVMKernel paramCvSVMKernel, int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, @Const FloatPointer paramFloatPointer1, FloatPointer paramFloatPointer2);
    }
  }
  
  public static class CvSVMKernelRow
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvSVMKernelRow()
    {
      allocate();
    }
    
    public CvSVMKernelRow(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvSVMKernelRow(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native FloatPointer data();
    
    public native CvSVMKernelRow data(FloatPointer paramFloatPointer);
    
    public native CvSVMKernelRow next();
    
    public native CvSVMKernelRow next(CvSVMKernelRow paramCvSVMKernelRow);
    
    public CvSVMKernelRow position(int paramInt)
    {
      return (CvSVMKernelRow)super.position(paramInt);
    }
    
    public native CvSVMKernelRow prev();
    
    public native CvSVMKernelRow prev(CvSVMKernelRow paramCvSVMKernelRow);
  }
  
  @NoOffset
  public static class CvSVMParams
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvSVMParams()
    {
      allocate();
    }
    
    public CvSVMParams(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvSVMParams(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, opencv_core.CvMat paramCvMat, opencv_core.CvTermCriteria paramCvTermCriteria)
    {
      allocate(paramInt1, paramInt2, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramCvMat, paramCvTermCriteria);
    }
    
    public CvSVMParams(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, opencv_core.CvMat paramCvMat, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria);
    
    private native void allocateArray(int paramInt);
    
    public native double C();
    
    public native CvSVMParams C(double paramDouble);
    
    public native opencv_core.CvMat class_weights();
    
    public native CvSVMParams class_weights(opencv_core.CvMat paramCvMat);
    
    public native double coef0();
    
    public native CvSVMParams coef0(double paramDouble);
    
    public native double degree();
    
    public native CvSVMParams degree(double paramDouble);
    
    public native double gamma();
    
    public native CvSVMParams gamma(double paramDouble);
    
    public native int kernel_type();
    
    public native CvSVMParams kernel_type(int paramInt);
    
    public native double nu();
    
    public native CvSVMParams nu(double paramDouble);
    
    public native double p();
    
    public native CvSVMParams p(double paramDouble);
    
    public CvSVMParams position(int paramInt)
    {
      return (CvSVMParams)super.position(paramInt);
    }
    
    public native int svm_type();
    
    public native CvSVMParams svm_type(int paramInt);
    
    @ByRef
    public native opencv_core.CvTermCriteria term_crit();
    
    public native CvSVMParams term_crit(opencv_core.CvTermCriteria paramCvTermCriteria);
  }
  
  public static class CvSVMSolutionInfo
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvSVMSolutionInfo()
    {
      allocate();
    }
    
    public CvSVMSolutionInfo(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvSVMSolutionInfo(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native double obj();
    
    public native CvSVMSolutionInfo obj(double paramDouble);
    
    public CvSVMSolutionInfo position(int paramInt)
    {
      return (CvSVMSolutionInfo)super.position(paramInt);
    }
    
    public native double r();
    
    public native CvSVMSolutionInfo r(double paramDouble);
    
    public native double rho();
    
    public native CvSVMSolutionInfo rho(double paramDouble);
    
    public native double upper_bound_n();
    
    public native CvSVMSolutionInfo upper_bound_n(double paramDouble);
    
    public native double upper_bound_p();
    
    public native CvSVMSolutionInfo upper_bound_p(double paramDouble);
  }
  
  @NoOffset
  public static class CvSVMSolver
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvSVMSolver()
    {
      allocate();
    }
    
    public CvSVMSolver(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, byte[] paramArrayOfByte, int paramInt3, double[] paramArrayOfDouble, double paramDouble1, double paramDouble2, opencv_core.CvMemStorage paramCvMemStorage, CvSVMKernel paramCvSVMKernel, GetRow paramGetRow, SelectWorkingSet paramSelectWorkingSet, CalcRho paramCalcRho)
    {
      allocate(paramInt1, paramInt2, paramPointerPointer, paramArrayOfByte, paramInt3, paramArrayOfDouble, paramDouble1, paramDouble2, paramCvMemStorage, paramCvSVMKernel, paramGetRow, paramSelectWorkingSet, paramCalcRho);
    }
    
    public CvSVMSolver(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, byte[] paramArrayOfByte, int paramInt3, double[] paramArrayOfDouble, double paramDouble1, double paramDouble2, opencv_core.CvMemStorage paramCvMemStorage, CvSVMKernel paramCvSVMKernel, GetRow paramGetRow, SelectWorkingSet paramSelectWorkingSet, CalcRho paramCalcRho);
    
    @ByRef
    @MemberGetter
    public static native CalcRho calc_rho();
    
    @ByRef
    @MemberGetter
    public static native CalcRho calc_rho_nu_svm();
    
    @ByRef
    @MemberGetter
    public static native GetRow get_row_one_class();
    
    @ByRef
    @MemberGetter
    public static native GetRow get_row_svc();
    
    @ByRef
    @MemberGetter
    public static native GetRow get_row_svr();
    
    @ByRef
    @MemberGetter
    public static native SelectWorkingSet select_working_set();
    
    @ByRef
    @MemberGetter
    public static native SelectWorkingSet select_working_set_nu_svm();
    
    public native double C(int paramInt);
    
    public native CvSVMSolver C(int paramInt, double paramDouble);
    
    public native DoublePointer G();
    
    public native CvSVMSolver G(DoublePointer paramDoublePointer);
    
    public native DoublePointer alpha();
    
    public native CvSVMSolver alpha(DoublePointer paramDoublePointer);
    
    public native int alpha_count();
    
    public native CvSVMSolver alpha_count(int paramInt);
    
    public native BytePointer alpha_status();
    
    public native CvSVMSolver alpha_status(BytePointer paramBytePointer);
    
    public native DoublePointer b();
    
    public native CvSVMSolver b(DoublePointer paramDoublePointer);
    
    public native FloatPointer buf(int paramInt);
    
    public native CvSVMSolver buf(int paramInt, FloatPointer paramFloatPointer);
    
    public native int cache_line_size();
    
    public native CvSVMSolver cache_line_size(int paramInt);
    
    public native int cache_size();
    
    public native CvSVMSolver cache_size(int paramInt);
    
    public native void calc_rho(@ByRef double[] paramArrayOfDouble1, @ByRef double[] paramArrayOfDouble2);
    
    public native CalcRho calc_rho_func();
    
    public native CvSVMSolver calc_rho_func(CalcRho paramCalcRho);
    
    public native void calc_rho_nu_svm(@ByRef double[] paramArrayOfDouble1, @ByRef double[] paramArrayOfDouble2);
    
    public native void clear();
    
    public native boolean create(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, byte[] paramArrayOfByte, int paramInt3, double[] paramArrayOfDouble, double paramDouble1, double paramDouble2, opencv_core.CvMemStorage paramCvMemStorage, CvSVMKernel paramCvSVMKernel, GetRow paramGetRow, SelectWorkingSet paramSelectWorkingSet, CalcRho paramCalcRho);
    
    public native double eps();
    
    public native CvSVMSolver eps(double paramDouble);
    
    public native FloatPointer get_row(int paramInt, float[] paramArrayOfFloat);
    
    public native FloatPointer get_row_base(int paramInt, BoolPointer paramBoolPointer);
    
    public native GetRow get_row_func();
    
    public native CvSVMSolver get_row_func(GetRow paramGetRow);
    
    public native FloatPointer get_row_one_class(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, boolean paramBoolean);
    
    public native FloatPointer get_row_svc(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, boolean paramBoolean);
    
    public native FloatPointer get_row_svr(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, boolean paramBoolean);
    
    public native CvSVMKernel kernel();
    
    public native CvSVMSolver kernel(CvSVMKernel paramCvSVMKernel);
    
    @ByRef
    public native opencv_ml.CvSVMKernelRow lru_list();
    
    public native CvSVMSolver lru_list(CvSVMKernelRow paramCvSVMKernelRow);
    
    public native int max_iter();
    
    public native CvSVMSolver max_iter(int paramInt);
    
    @Const
    public native opencv_ml.CvSVMParams params();
    
    public native CvSVMSolver params(CvSVMParams paramCvSVMParams);
    
    public native CvSVMKernelRow rows();
    
    public native CvSVMSolver rows(CvSVMKernelRow paramCvSVMKernelRow);
    
    public native int sample_count();
    
    public native CvSVMSolver sample_count(int paramInt);
    
    @Cast({"const float**"})
    public native PointerPointer samples();
    
    public native CvSVMSolver samples(PointerPointer paramPointerPointer);
    
    public native boolean select_working_set(@ByRef int[] paramArrayOfInt1, @ByRef int[] paramArrayOfInt2);
    
    public native SelectWorkingSet select_working_set_func();
    
    public native CvSVMSolver select_working_set_func(SelectWorkingSet paramSelectWorkingSet);
    
    public native boolean select_working_set_nu_svm(@ByRef int[] paramArrayOfInt1, @ByRef int[] paramArrayOfInt2);
    
    public native boolean solve_c_svc(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, opencv_core.CvMemStorage paramCvMemStorage, CvSVMKernel paramCvSVMKernel, double[] paramArrayOfDouble, @ByRef opencv_ml.CvSVMSolutionInfo paramCvSVMSolutionInfo);
    
    public native boolean solve_eps_svr(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat, opencv_core.CvMemStorage paramCvMemStorage, CvSVMKernel paramCvSVMKernel, double[] paramArrayOfDouble, @ByRef opencv_ml.CvSVMSolutionInfo paramCvSVMSolutionInfo);
    
    public native boolean solve_generic(@ByRef opencv_ml.CvSVMSolutionInfo paramCvSVMSolutionInfo);
    
    public native boolean solve_nu_svc(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, byte[] paramArrayOfByte, opencv_core.CvMemStorage paramCvMemStorage, CvSVMKernel paramCvSVMKernel, double[] paramArrayOfDouble, @ByRef opencv_ml.CvSVMSolutionInfo paramCvSVMSolutionInfo);
    
    public native boolean solve_nu_svr(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat, opencv_core.CvMemStorage paramCvMemStorage, CvSVMKernel paramCvSVMKernel, double[] paramArrayOfDouble, @ByRef opencv_ml.CvSVMSolutionInfo paramCvSVMSolutionInfo);
    
    public native boolean solve_one_class(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, opencv_core.CvMemStorage paramCvMemStorage, CvSVMKernel paramCvSVMKernel, double[] paramArrayOfDouble, @ByRef opencv_ml.CvSVMSolutionInfo paramCvSVMSolutionInfo);
    
    public native opencv_core.CvMemStorage storage();
    
    public native CvSVMSolver storage(opencv_core.CvMemStorage paramCvMemStorage);
    
    public native int var_count();
    
    public native CvSVMSolver var_count(int paramInt);
    
    public native BytePointer y();
    
    public native CvSVMSolver y(BytePointer paramBytePointer);
    
    @Namespace("CvSVMSolver")
    public static class CalcRho
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      public CalcRho(Pointer paramPointer)
      {
        super();
      }
      
      public native void call(CvSVMSolver paramCvSVMSolver, @ByRef DoublePointer paramDoublePointer1, @ByRef DoublePointer paramDoublePointer2);
    }
    
    @Namespace("CvSVMSolver")
    public static class GetRow
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      public GetRow(Pointer paramPointer)
      {
        super();
      }
      
      public native FloatPointer call(CvSVMSolver paramCvSVMSolver, int paramInt, FloatPointer paramFloatPointer1, FloatPointer paramFloatPointer2, @Cast({"bool"}) boolean paramBoolean);
    }
    
    @Namespace("CvSVMSolver")
    public static class SelectWorkingSet
      extends FunctionPointer
    {
      static
      {
        Loader.load();
      }
      
      public SelectWorkingSet(Pointer paramPointer)
      {
        super();
      }
      
      @Cast({"bool"})
      public native boolean call(CvSVMSolver paramCvSVMSolver, @ByRef IntPointer paramIntPointer1, @ByRef IntPointer paramIntPointer2);
    }
  }
  
  public static class CvStatModel
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvStatModel()
    {
      allocate();
    }
    
    public CvStatModel(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void clear();
    
    public native void load(String paramString1, String paramString2);
    
    public native void read(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
    
    public native void save(String paramString1, String paramString2);
    
    public native void write(opencv_core.CvFileStorage paramCvFileStorage, String paramString);
  }
  
  @NoOffset
  public static class CvTrainTestSplit
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvTrainTestSplit()
    {
      allocate();
    }
    
    public CvTrainTestSplit(float paramFloat, boolean paramBoolean)
    {
      allocate(paramFloat, paramBoolean);
    }
    
    public CvTrainTestSplit(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvTrainTestSplit(int paramInt, boolean paramBoolean)
    {
      allocate(paramInt, paramBoolean);
    }
    
    public CvTrainTestSplit(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(float paramFloat, boolean paramBoolean);
    
    private native void allocate(int paramInt, boolean paramBoolean);
    
    private native void allocateArray(int paramInt);
    
    public native CvTrainTestSplit mix(boolean paramBoolean);
    
    public native boolean mix();
    
    public CvTrainTestSplit position(int paramInt)
    {
      return (CvTrainTestSplit)super.position(paramInt);
    }
    
    @Name({"train_sample_part.count"})
    public native int train_sample_part_count();
    
    public native CvTrainTestSplit train_sample_part_count(int paramInt);
    
    public native int train_sample_part_mode();
    
    public native CvTrainTestSplit train_sample_part_mode(int paramInt);
    
    @Name({"train_sample_part.portion"})
    public native float train_sample_part_portion();
    
    public native CvTrainTestSplit train_sample_part_portion(float paramFloat);
  }
  
  public static class CvVectors
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public CvVectors()
    {
      allocate();
    }
    
    public CvVectors(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public CvVectors(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int count();
    
    public native CvVectors count(int paramInt);
    
    @Cast({"double**"})
    @Name({"data.db"})
    public native PointerPointer data_db();
    
    public native CvVectors data_db(PointerPointer paramPointerPointer);
    
    @Cast({"float**"})
    @Name({"data.fl"})
    public native PointerPointer data_fl();
    
    public native CvVectors data_fl(PointerPointer paramPointerPointer);
    
    @Cast({"uchar**"})
    @Name({"data.ptr"})
    public native PointerPointer data_ptr();
    
    public native CvVectors data_ptr(PointerPointer paramPointerPointer);
    
    public native int dims();
    
    public native CvVectors dims(int paramInt);
    
    public native CvVectors next();
    
    public native CvVectors next(CvVectors paramCvVectors);
    
    public CvVectors position(int paramInt)
    {
      return (CvVectors)super.position(paramInt);
    }
    
    public native int type();
    
    public native CvVectors type(int paramInt);
  }
  
  @Namespace("cv")
  public static class EM
    extends opencv_core.Algorithm
  {
    public static final int COV_MAT_DEFAULT = 1;
    public static final int COV_MAT_DIAGONAL = 1;
    public static final int COV_MAT_GENERIC = 2;
    public static final int COV_MAT_SPHERICAL = 0;
    public static final int DEFAULT_MAX_ITERS = 100;
    public static final int DEFAULT_NCLUSTERS = 5;
    public static final int START_AUTO_STEP = 0;
    public static final int START_E_STEP = 1;
    public static final int START_M_STEP = 2;
    
    static
    {
      Loader.load();
    }
    
    public EM()
    {
      allocate();
    }
    
    public EM(int paramInt1, int paramInt2, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria)
    {
      allocate(paramInt1, paramInt2, paramCvTermCriteria);
    }
    
    public EM(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria);
    
    public native void clear();
    
    @Cast({"bool"})
    public native boolean isTrained();
    
    @ByVal
    public native opencv_core.CvScalar predict(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @opencv_core.OutputArray opencv_core.CvMat paramCvMat);
    
    @Cast({"bool"})
    public native boolean train(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @opencv_core.OutputArray opencv_core.CvMat paramCvMat1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2, @opencv_core.OutputArray opencv_core.CvMat paramCvMat3);
    
    @Cast({"bool"})
    public native boolean trainE(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, @opencv_core.InputArray opencv_core.CvArr paramCvArr4, @opencv_core.OutputArray opencv_core.CvMat paramCvMat1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2, @opencv_core.OutputArray opencv_core.CvMat paramCvMat3);
    
    @Cast({"bool"})
    public native boolean trainM(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.OutputArray opencv_core.CvMat paramCvMat1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2, @opencv_core.OutputArray opencv_core.CvMat paramCvMat3);
  }
  
  @Name({"std::map<std::string, int>"})
  public static class StringIntMap
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public StringIntMap()
    {
      allocate();
    }
    
    public StringIntMap(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    @Index
    public native int get(String paramString);
    
    public native StringIntMap put(String paramString, int paramInt);
    
    public native long size();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\opencv_ml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */