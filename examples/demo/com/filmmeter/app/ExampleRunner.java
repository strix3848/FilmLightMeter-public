package com.filmmeter.app;

/** New documentation-only caller of the two genuine app excerpts; not an Android app. */
public final class ExampleRunner {
  private static int checks;
  private static void check(boolean condition,String description){
    if(!condition)throw new AssertionError(description);
    checks++;
  }
  public static void main(String[] args){
    IsoEiSettings sensitivity=new IsoEiSettings(100,100,false);
    check(sensitivity.ei==100&&!sensitivity.overridden,"EI follows ISO");
    sensitivity.setEi(50);
    check(sensitivity.iso==100&&sensitivity.ei==50&&sensitivity.overridden,"Explicit EI");
    System.out.println("Selection example: ISO"+sensitivity.iso+"/EI"+sensitivity.ei);
    sensitivity.setIso(400);
    check(sensitivity.ei==400&&!sensitivity.overridden,"ISO change resets EI");
    sensitivity.setEi(800);sensitivity.setEi(null);
    check(sensitivity.ei==400&&!sensitivity.overridden,"Cleared EI follows ISO");

    int selected=(1<<0)|(1<<4)|(1<<6);
    int frame=FrameFormats.next(0,selected);check(frame==4,"First selected frame");
    frame=FrameFormats.next(frame,selected);check(frame==6,"Next selected frame");
    frame=FrameFormats.next(frame,selected);check(frame==0,"Frame wraparound");
    check(FrameFormats.next(6,1<<6)==6,"Single selected frame");
    System.out.println("Frame cycle example: 35mm -> 6x8 -> 4x5 -> 35mm");
    System.out.println("Example checks passed: "+checks);
    System.out.println("No Android app, metering implementation or APK is built.");
  }
}
