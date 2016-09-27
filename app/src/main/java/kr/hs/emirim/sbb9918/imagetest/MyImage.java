package kr.hs.emirim.sbb9918.imagetest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by appcreate35 on 2016. 9. 26..
 */

public class MyImage extends View{
    int choose=MainActivity.ORIGINAL;//이미지 변경을 위한 변수 선언! 처음을 오리지널로 초기화!
    Bitmap picture; //전역 변수로 선언하여 onDraw에서 picture 사용을 가능하게 함!

    MyImage(Context context){//문맥 설정 (현재 위치 : this)
        super(context);//view를 상속 받아서 사용 (view에는 default 생성자가 존재하지 않으므로 사용 하야함!
        picture= BitmapFactory.decodeResource(getResources(),R.drawable.sizuku); //sizuku라는 이미지 파일을 bitmap파일로 변환하여 반환하는 역활 입니다!
    }

    public void setChoose(int choose) { //chooes의 값을 MainActivity에서 받아서 초기화!
        this.choose = choose;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);//view클래스에 ondraw 오버라이딩

        float cx=getWidth()/0.2f; //view의 정 중앙 좌표!
        float cy=getWidth()/0.2f;
        float x=(getWidth()-picture.getWidth())*0.5f; //draw bitmap이 float형 이여서 float형이 좋음!
        float y=(getHeight()-picture.getHeight())*0.5f;  //정 중앙에 위치 하도록 함!

        switch (choose){
            case MainActivity.ROTATE:
                canvas.rotate(45,cx,cy);//회전
                break;
            case MainActivity.TRANSLATE:
                canvas.translate(-150,200); //이동
                break;
            case MainActivity.SCALE:
                canvas.scale(0.2f,0.3f,cx,cy); //크기 변경 0.2배
                break;
            case MainActivity.SKEW:
                canvas.skew(0.4f,0.4f); //비틀기 세로 축을 기준으로!
                break;
        }

        canvas.drawBitmap(picture,x,y,null);
       // picture.recycle();//system resource 반환!
    }
}
