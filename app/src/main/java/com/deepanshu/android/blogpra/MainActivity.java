package com.deepanshu.android.blogpra;

import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @VisibleForTesting
    protected static final String ROW_TEXT = "ROW_TEXT";
    private RecyclerView recyclerView;
    private ModelView1 modelView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*final ArrayList<Blog> arrablog=new ArrayList<>();

        final String authorName="Dr.Reatha Padmore ";
        final String whn="1 day";
        final String ON="Transform global health";
        final String des="World Sight Day, held on the second Thursday of October every year," +
                " aims to focus global attention on vision impairment and blindness. There is a different theme every year, with many of" +
                " those who mark the Day taking the opportunity to both celebrate achievements to date and advocate for increasing attention" +
                " towards eye care. Globally,the International Agency for the Prevention of Blindness has a leadership role in preparing the annual World Sight Day.";
        final String imgUrl="https://www.sciencealert.com/images/2018-03/processed/HPVVirus_web_600.jpg";

        String authorName1="Dr Vachel luces ";
        String whn1="2 day";
        String ON1="Transform global health";
        String des1="Breast cancer is one of the most common kinds of cancer in women." +
                " About 1 in 8 women born today in the United States will get breast cancer at some point.\n" +
                "The good news is that most women can survive breast cancer if it’s found and treated early." +
                " A mammogram – the screening test for breast cancer –" +
                " can help find breast cancer early when it’s easier to treat.\n" +
                "National Breast Cancer Awareness Month is a chance to raise awareness about the importance of finding breast cancer early. ";
        String imgUrl1="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9BWboOI5PSjUpKrwgQ_EEUZnb_yNjix-lpRl3KOH19ONyy3MB";

        arrablog.add(new Blog("World Global health",whn+" ago by ",authorName+" via ",ON+"",des+"",imgUrl+""));
        arrablog.add(new Blog("Breast Cancer Awareness month ",whn1+" ago by ",authorName1+" via ",ON1+"",des1+"",imgUrl1+""));
        arrablog.add(new Blog("World Global health",whn+" ago by ",authorName+" via ",ON+"",des+"",imgUrl+""));
        arrablog.add(new Blog("Breast Cancer Awareness month ",whn1+" ago by ",authorName1+" via ",ON1+"",des1+"",imgUrl1+""));
        arrablog.add(new Blog("World Global health",whn+" ago by ",authorName+" via ",ON+"",des+"",imgUrl+""));
        arrablog.add(new Blog("Breast Cancer Awareness month ",whn1+" ago by ",authorName1+" via ",ON1+"",des1+"",imgUrl1+""));
        arrablog.add(new Blog("World Global health",whn+" ago by ",authorName+" via ",ON+"",des+"",imgUrl+""));
        arrablog.add(new Blog("Breast Cancer Awareness month ",whn1+" ago by ",authorName1+" via ",ON1+"",des1+"",imgUrl1+""));
        arrablog.add(new Blog("World Global health",whn+" ago by ",authorName+" via ",ON+"",des+"",imgUrl+""));
        arrablog.add(new Blog("Breast Cancer Awareness month ",whn1+" ago by ",authorName1+" via ",ON1+"",des1+"",imgUrl1+""));
        arrablog.add(new Blog("World Global health",whn+" ago by ",authorName+" via ",ON+"",des+"",imgUrl+""));
        arrablog.add(new Blog("Breast Cancer Awareness month ",whn1+" ago by ",authorName1+" via ",ON1+"",des1+"",imgUrl1+""));
        arrablog.add(new Blog("World Global health",whn+" ago by ",authorName+" via ",ON+"",des+"",imgUrl+""));
        arrablog.add(new Blog("Breast Cancer Awareness month ",whn1+" ago by ",authorName1+" via ",ON1+"",des1+"",imgUrl1+""));
*/
        recyclerView=findViewById(R.id.my_recycler_view);
        FloatingActionButton floatingActionButton=findViewById(R.id.fab);

        modelView1=ViewModelProviders.of(this).get(ModelView1.class);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modelView1.addBlog();
                Toast.makeText(MainActivity.this,"fab clicked",Toast.LENGTH_LONG).show();
                recyclerView.smoothScrollToPosition(modelView1.getBlogs().getValue().size()-1);
            }
        });

        modelView1.getBlogs().observe(this, new Observer<ArrayList<Blog>>() {
            @Override
            public void onChanged(ArrayList<Blog> blogs) {
                RecyclerViewAdapter adapter=new RecyclerViewAdapter(blogs,MainActivity.this);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        });



    }
}
