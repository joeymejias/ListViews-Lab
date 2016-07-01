package ly.generalassemb.drewmahrt.bookshelf;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BaseAdapter mBookAdapter;

    //TODO: Define your ListView
    ListView listView;

    //TODO: Define your Book List
    ArrayList<Book> mBookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Use helper method to add books to the list
        mBookList = (ArrayList<Book>) generateBooks();

        //TODO: Instantiate BaseAdapter
        //Below is a partially complete example for one Adapter
        mBookAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mBookList.size();
            }

            @Override
            public Object getItem(int position) {
                return mBookList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //TODO: Update the view
                View view = convertView;
                if (view == null) {
                    LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(android.R.layout.simple_list_item_2,null);
                }

                TextView textView1 = (TextView) view.findViewById(android.R.id.text1);
                textView1.setText(mBookList.get(position).getAuthor());
                TextView textView2 = (TextView) view.findViewById(android.R.id.text2);
                textView2.setText(mBookList.get(position).getTitle());

                mBookList.get(5).getDetails();

                return view;
            }
        };

        //TODO: Set the ListView's adapter
        listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(mBookAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                TextView textView1 = (TextView) view.findViewById(android.R.id.text1);
//                TextView textView2 = (TextView) view.findViewById(android.R.id.text2);
//
//                ColorStateList red = getResources().getColorStateList(android.R.color.holo_red_dark);
//
//                if (!textView1.getTextColors().equals(red) && !textView2.getTextColors().equals(red)){
//                    textView1.setTextColor(getResources().getColorStateList(android.R.color.holo_red_dark));
//                    textView2.setTextColor(getResources().getColorStateList(android.R.color.holo_red_dark));
//                } else {
//                    textView1.setTextColor(getResources().getColorStateList(android.R.color.black));
//                    textView2.setTextColor(getResources().getColorStateList(android.R.color.black));
//                }
                Intent intent = new Intent(MainActivity.this,BookDetails.class);
                intent.putExtra("bookDetails",mBookList.get(position).getDetails());
                startActivity(intent);
            }
        });


    }

    //Method to generate a list of Books
    private List<Book> generateBooks(){
        List<Book> books = new ArrayList<>();

        books.add(new Book("Apples Book","Brad", "Apples Book by Brad details"));
        books.add(new Book("Cats Book","Ryan", "Cats Book by Ryan details"));
        books.add(new Book("Eagles Book","Kate", "Eagles Book by Kate details"));
        books.add(new Book("Strawberries Cathy","Brad", "Strawberries by Brad details"));
        books.add(new Book("Dogs Book","Tom", "Dogs Book by Tom details"));
        books.add(new Book("Ants Book","Zane", "Ants Book by Zane details"));

        return books;
    }
}
