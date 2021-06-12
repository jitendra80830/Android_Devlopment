package com.example.demolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CustomListViewActivity extends AppCompatActivity {

    ListView listView;
    String[] title  = {"Rahul","Ram","Jitendra","Rakesh","Akash","Ramesh","Rajesh","Ganesh"};
    String[] desc  = {"Student","Actor","Student","Doctor","Businessman","Developer","Developer 1","Doctor"};

    int[] imageList = {R.drawable.heart,R.drawable.clipart,R.drawable.linkedin,R.drawable.wifi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);

        CustomAdapter arrayAdapter = new CustomAdapter();

        listView = findViewById(R.id.ListView);
        listView.setAdapter(arrayAdapter);
    }
    public class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.custom_row_layout,null);

            TextView txtTitle = convertView.findViewById(R.id.textView);
            txtTitle.setText(title[position]);

            TextView txtDesc = convertView.findViewById(R.id.textView2);
            txtDesc.setText(desc[position]);

            ImageView imageView = convertView.findViewById(R.id.imageView);
            imageView.setImageResource(imageList[position % imageList.length]);

            return convertView;
        }
    }
}