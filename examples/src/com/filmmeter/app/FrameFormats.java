package com.filmmeter.app;

final class FrameFormats {
  // Keep the original indices: saved body profiles refer to these IDs.
  static final String[] LABELS={"35mm","6×6","6×7","HALF","6×8","6×9","4×5"};
  static final float[] RATIOS={1.5f,1f,1.2f,.75f,8f/6,9f/6,5f/4};
  static final int DEFAULT_VISIBLE=15;
  private FrameFormats() {}
  static int validIndex(int index){return index>=0&&index<LABELS.length?index:0;}
  static int validMask(int mask){int valid=mask&((1<<LABELS.length)-1);return valid==0?1:valid;}
  static int next(int current,int mask){
    mask=validMask(mask);current=validIndex(current);
    for(int step=1;step<=LABELS.length;step++){
      int candidate=(current+step)%LABELS.length;
      if((mask&(1<<candidate))!=0)return candidate;
    }
    return current;
  }
  static int visibleOrNext(int current,int mask){
    current=validIndex(current);return (validMask(mask)&(1<<current))!=0?current:next(current,mask);
  }
}
