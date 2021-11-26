package com.example.project_11_1_gridlayout1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 고양이 포스터");

        final GridView gv1 = (GridView) findViewById(R.id.gv1);
        MyGridAdapter gad = new MyGridAdapter(this);
        gv1.setAdapter(gad);
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;
        public MyGridAdapter(Context c) {
            context = c;
        }
        public int getCount() {
            return posterID.length;
        }
        public Object getItem(int arg0) {

            return null;
        }
        public long getItemId(int arg0) {

            return 0;
        }

        Integer[] posterID = {
                R.drawable.iv1, R.drawable.iv2, R.drawable.iv3,R.drawable.iv4,
                R.drawable.iv5, R.drawable.iv6,R.drawable.iv7, R.drawable.iv8,
                R.drawable.iv9,R.drawable.iv10,
        };

        String[] posID = {
                "고양이1", "고양이2","고양이3","고양이4",
                "고양이5","고양이6","고양이7","고양이8",
                "고양이9","성냥팔이소녀",
        };

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imv = new ImageView(context);
            imv.setLayoutParams(new GridView.LayoutParams(200,300));
            imv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imv.setPadding(5,5,5,5);

            imv.setImageResource(posterID[position]);

            final int pos = position;
            imv.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(MainActivity.this,
                            R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivP = (ImageView) dialogView.findViewById(R.id.ivP);
                    ivP.setImageResource(posterID[pos]);
                    dlg.setTitle(posID[pos]);
                    dlg.setIcon(R.drawable.icon);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return imv;
        }
    }
}