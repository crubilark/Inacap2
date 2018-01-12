package com.example.clrubilarc.inacap2.modelo;

import com.example.clrubilarc.inacap2.R;

import java.util.ArrayList;

/**
 * Created by clrubilarc on 09-01-18.
 */

public class Tea {
    private String title;
    private int resourceImage;

    public Tea(String title, int resourceImage) {
        this.title = title;
        this.resourceImage = resourceImage;
    }

    public Tea() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public static ArrayList<Tea> teaList(){
        ArrayList<Tea> list = new ArrayList<>();
        list.add(new Tea("Black Tea", R.drawable.black_tea));
        list.add(new Tea("chamomile Tea", R.drawable.chamomile_tea));
        list.add(new Tea("Green Tea", R.drawable.green_tea));
        list.add(new Tea("Oolong Tea", R.drawable.oolong_tea));
       return list;

    }

    public static int getImageDrawable(String title){
        for (Tea tea: teaList()){
            if (tea.title.equals(title)){
                return tea.getResourceImage();
            }
        }
        return 0;
    }
}


