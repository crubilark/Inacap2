package com.example.clrubilarc.inacap2;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.clrubilarc.inacap2.modelo.AdapterTea;
import com.example.clrubilarc.inacap2.modelo.Comment;
import com.example.clrubilarc.inacap2.modelo.Tea;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.client.HttpClient;

public class CommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        getComentarios();
    }


    public void insertComentarios(String name,String comment){
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://rapidfresh.todojava.net/index.php/insertComments";
        RequestParams params = new RequestParams();
        params.put("name",name);
        params.put("comment",comment);

        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode== 200){ //peticion ok
                    String response = new String(responseBody);
                    Log.i("INFO",response);
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }


    public void getComentarios(){
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://rapidfresh.todojava.net/index.php/comments";

        client.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode== 200){ //peticion ok
                    String response = new String(responseBody);
                    Log.i("INFO",response);
                    procesaCommentjson(response);
            }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void procesaCommentjson(String response){
        ArrayList<Comment> list = new ArrayList<>();
        try{
            JSONArray json = new JSONArray(response);


            for(int i=0;i < json.length();i++){
                String name = json.getJSONObject(i).getString("name");
                String comment = json.getJSONObject(i).getString("comment");
                list.add(new Comment(name,comment));

            }
            //tarea realizar un RecyclearView




        }catch (Exception e){
            e.printStackTrace();
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.commentRecyclear);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(new AdapterComment(list,R.layout.item_comment,this));
    }

    public void addComment(View view) {
        TextInputEditText txtName = (TextInputEditText) findViewById(R.id.txtCommentName);
        TextInputEditText txtComment = (TextInputEditText) findViewById(R.id.txtComment);

        if(txtName.getText().toString().isEmpty() ||  txtComment.getText().toString().isEmpty()){
            Toast.makeText(this,"nombre y comentario requerido", Toast.LENGTH_SHORT).show();
        }else{
            insertComentarios(txtName.getText().toString(),txtComment.getText().toString());
            Toast.makeText(this,"comentario creado", Toast.LENGTH_SHORT).show();
            txtName.setText("");
            txtComment.setText("");
        }





    }


}
