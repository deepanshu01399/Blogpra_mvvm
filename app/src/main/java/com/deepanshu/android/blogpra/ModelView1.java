package com.deepanshu.android.blogpra;

import android.widget.Button;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import static android.webkit.WebSettings.PluginState.ON;

public class ModelView1 extends ViewModel {
    String authorName;
    String whn,ON,des,imgUrl;
    public MutableLiveData<ArrayList<Blog>> Blogs;
    final ArrayList<Blog> arrablog = new ArrayList<>();

    public MutableLiveData<ArrayList<Blog>> getBlogs() {
        if (Blogs == null) {
            Blogs = new MutableLiveData<>();
            init();
        }
        return Blogs;

    }

    private void init() {
        showBlog();
        Blogs.setValue(arrablog);
    }

        public ArrayList<Blog> showBlog () {
             authorName = "Dr.Reatha Padmore ";
            whn= "1 day";
            ON = "Transform global health";
            des = "World Sight Day, held on the second Thursday of October every year," +
                    " aims to focus global attention on vision impairment and blindness. There is a different theme every year, with many of" +
                    " those who mark the Day taking the opportunity to both celebrate achievements to date and advocate for increasing attention" +
                    " towards eye care. Globally,the International Agency for the Prevention of Blindness has a leadership role in preparing the annual World Sight Day.";
             imgUrl = "https://www.sciencealert.com/images/2018-03/processed/HPVVirus_web_600.jpg";

            String authorName1 = "Dr Vachel luces ";
            String whn1 = "2 day";
            String ON1 = "Transform global health";
            String des1 = "Breast cancer is one of the most common kinds of cancer in women." +
                    " About 1 in 8 women born today in the United States will get breast cancer at some point.\n" +
                    "The good news is that most women can survive breast cancer if it’s found and treated early." +
                    " A mammogram – the screening test for breast cancer –" +
                    " can help find breast cancer early when it’s easier to treat.\n" +
                    "National Breast Cancer Awareness Month is a chance to raise awareness about the importance of finding breast cancer early. ";
            String imgUrl1 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9BWboOI5PSjUpKrwgQ_EEUZnb_yNjix-lpRl3KOH19ONyy3MB";

            arrablog.add(new Blog("World Global health", whn + " ago by ", authorName + " via ", ON + "", des + "", imgUrl + ""));
            arrablog.add(new Blog("Breast Cancer Awareness month ", whn1 + " ago by ", authorName1 + " via ", ON1 + "", des1 + "", imgUrl1 + ""));
            arrablog.add(new Blog("World Global health", whn + " ago by ", authorName + " via ", ON + "", des + "", imgUrl + ""));
            arrablog.add(new Blog("Breast Cancer Awareness month ", whn1 + " ago by ", authorName1 + " via ", ON1 + "", des1 + "", imgUrl1 + ""));
            arrablog.add(new Blog("World Global health", whn + " ago by ", authorName + " via ", ON + "", des + "", imgUrl + ""));
            arrablog.add(new Blog("Breast Cancer Awareness month ", whn1 + " ago by ", authorName1 + " via ", ON1 + "", des1 + "", imgUrl1 + ""));
            arrablog.add(new Blog("World Global health", whn + " ago by ", authorName + " via ", ON + "", des + "", imgUrl + ""));
            arrablog.add(new Blog("Breast Cancer Awareness month ", whn1 + " ago by ", authorName1 + " via ", ON1 + "", des1 + "", imgUrl1 + ""));
            arrablog.add(new Blog("World Global health", whn + " ago by ", authorName + " via ", ON + "", des + "", imgUrl + ""));
            arrablog.add(new Blog("Breast Cancer Awareness month ", whn1 + " ago by ", authorName1 + " via ", ON1 + "", des1 + "", imgUrl1 + ""));
            arrablog.add(new Blog("World Global health", whn + " ago by ", authorName + " via ", ON + "", des + "", imgUrl + ""));
            arrablog.add(new Blog("Breast Cancer Awareness month ", whn1 + " ago by ", authorName1 + " via ", ON1 + "", des1 + "", imgUrl1 + ""));
            arrablog.add(new Blog("World Global health", whn + " ago by ", authorName + " via ", ON + "", des + "", imgUrl + ""));
            arrablog.add(new Blog("Breast Cancer Awareness month ", whn1 + " ago by ", authorName1 + " via ", ON1 + "", des1 + "", imgUrl1 + ""));

            return arrablog;
        }
    public ArrayList<Blog> BLOGLIst () {
        String authorName1 = "Dr Vachel luces ";
        String whn1 = "2 day";
        String ON1 = "Transform global health";
        String des1 = "Breast cancer is one of the most common kinds of cancer in women." +
                " About 1 in 8 women born today in the United States will get breast cancer at some point.\n" +
                "The good news is that most women can survive breast cancer if it’s found and treated early." +
                " A mammogram – the screening test for breast cancer –" +
                " can help find breast cancer early when it’s easier to treat.\n" +
                "National Breast Cancer Awareness Month is a chance to raise awareness about the importance of finding breast cancer early. ";
        String imgUrl1 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9BWboOI5PSjUpKrwgQ_EEUZnb_yNjix-lpRl3KOH19ONyy3MB";

        arrablog.add(new Blog("Breast Cancer Awareness month ", whn1 + " ago by ", authorName1 + " via ", ON1 + "", des1 + "", imgUrl1 + ""));
        return arrablog;
    }
    public void addBlog() {
        if(Blogs.getValue()!=null)
        Blogs.setValue(BLOGLIst());
    }
}
