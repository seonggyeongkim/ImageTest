package kr.hs.emirim.sbb9918.imagetest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
     MyImage mImg;//myimage형인 변수 선언

     static final int ORIGINAL=0;
     static final int ROTATE=1; //변형 되는 값에 대한 상수
     static final int TRANSLATE=2;
     static final int SCALE=3;
     static final int SKEW=4;
     int choose=ORIGINAL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linear1=(LinearLayout)findViewById(R.id.linear1); //id를 가져 온다!
        mImg=new MyImage(getApplicationContext()); //화면 (문맥) 객체 생성
        linear1.addView(mImg); //MyImage추가!
    }

    public void tranceformImage(View v){//매개 변수는 반드시 view로 한다! (버튼이 클릭 되면 호출 된다!)

        switch (v.getId()){ //v.getId()가 클릭된 버튼의 배열을 가져다 준다!
            case R.id.but_rotate:
                choose=ROTATE;//상수 필드를 만들어 값 전달
                break;
            case R.id.but_translate:
                choose=TRANSLATE;
                break;
            case R.id.but_scale:
                choose=SCALE;
                break;
            case R.id.but_skew:
                choose=SKEW;
                break;
        }

        mImg.setChoose(choose);//MyImage.java에 choose값을 보내서 값 설정!
        //값에 따라 이미지 변경!

        mImg.invalidate(); //ondraw() 다시 호출하는 방법! (변경된 것으로 다시 이미지를 변경한다!)
    }



}
