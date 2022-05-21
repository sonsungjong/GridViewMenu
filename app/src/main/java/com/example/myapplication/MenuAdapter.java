package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String[] numberWord;
    private int[] numberImage;
    private int[] numberPrice;
    private int[] numberCount;
    public MenuAdapter(Context c, String[] numberWord, int[] numberImage, int[] numberPrice, int[] numberCount){
        context = c;
        this.numberWord = numberWord;
        this.numberImage = numberImage;
        this.numberPrice = numberPrice;
        this.numberCount = numberCount;
    }

    @Override
    public int getCount() {
        return numberWord.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view == null){
            view = inflater.inflate(R.layout.row_item, null);
        }

        ImageView menu_photo = view.findViewById(R.id.menu_photo);
        TextView menu_name = view.findViewById(R.id.menu_name);
        TextView menu_price = view.findViewById(R.id.menu_price);
        Button menu_plus = view.findViewById(R.id.menu_plus);
        Button menu_minus = view.findViewById(R.id.menu_minus);
        TextView menu_count = view.findViewById(R.id.menu_count);

        menu_photo.setImageResource(numberImage[i]);
        menu_name.setText(numberWord[i]);
        menu_price.setText("가격 : "+numberPrice[i]+"원");
        menu_count.setText(""+numberCount[i]);

        menu_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberCount[i] < 10) {
                    numberCount[i]++;
                    menu_count.setText("" + numberCount[i]);
                    MenuActivity.total_price += numberPrice[i];
                    MenuActivity.menu_total.setText("총 가격 : "+MenuActivity.total_price+"원");
                }
            }
        });

        menu_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberCount[i] > 0) {
                    numberCount[i]--;
                    menu_count.setText("" + numberCount[i]);
                    MenuActivity.total_price -= numberPrice[i];
                    MenuActivity.menu_total.setText("총 가격 : "+MenuActivity.total_price+"원");
                }
            }
        });

        return view;
    }
}
