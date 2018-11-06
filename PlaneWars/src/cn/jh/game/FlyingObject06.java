package cn.jh.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class FlyingObject06 {
    protected  int width;/*宽*/
    protected  int height;/*高*/
    protected  int x;/*横坐标*/
    protected  int y;/*纵坐标*/
    public static final int LIFE = 0;
    public  static  final  int DEAD=1;
    public static  final  int REMOVE=2;
    protected  int state=LIFE;
    //飞行物先走一步
    public  abstract  void step();
    //检查是否出界
    public abstract  boolean outOfBounds();
    public  abstract BufferedImage getImage();

    //获取图片
    public static BufferedImage LoadImage(String filname) {
        try {
            BufferedImage img= ImageIO.read(FlyingObject06.class.getResource(filname));
            return  img;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public  void paint(Graphics graphics){
      graphics.drawImage(getImage(),x,y,null);
    }
    public boolean isLife(){
        return this.state==LIFE;
    }
    public boolean isDead(){
        return  this.state==DEAD;
    }
    public  boolean isRemove(){
        return  this.state==REMOVE;
    }
    public  void goDead(){
        this.state=DEAD;
    }

    public boolean hit(FlyingObject06 other) {/*左右剩余宽度，上下剩余长度*/
        int x1=this.x-other.width;
        int x2=this.x+this.width;
        int y1=this.y-this.height;
        int y2=this.y+this.height;
        int x=other.x;
        int y=other.y;
        return  x>x2&&x<=x2&&y>=y1&&y<=y2;
    }
}
