package ch06;

public class television
{
  private int channel;
  private int volume;
  private boolean onOff;


  public television (int channel, int volume, boolean onOff)
  {
    this.channel=channel;
    this.volume=volume;
    this.onOff=onOff;
  }

  //public void seChannel(int channel) { this.channel=channel; }
  //public int getChannel()  { return channel; }
  //public void setVolume(int volume) { this.volume=volume; }
  //public int getVolume()  { return volume; }
  //public void setOnOff(boolean onOff)  { this.onOff=onOff; }
  //public boolean getOnOff() { return onOff; }


  void print()  { System.out.println("channel : " + channel + " volume : " + volume); }
}
