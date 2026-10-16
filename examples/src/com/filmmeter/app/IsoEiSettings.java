package com.filmmeter.app;

final class IsoEiSettings {
  int iso,ei;boolean overridden;
  IsoEiSettings(int iso,int savedEi,boolean overridden){
    this.iso=iso;this.overridden=overridden&&savedEi>0&&savedEi!=iso;
    ei=this.overridden?savedEi:iso;
  }
  void setIso(int value){
    if(value<=0)throw new IllegalArgumentException();
    if(value!=iso){iso=value;ei=value;overridden=false;}
  }
  void setEi(Integer value){
    if(value!=null&&value<=0)throw new IllegalArgumentException();
    ei=value==null?iso:value;overridden=ei!=iso;
  }
}
