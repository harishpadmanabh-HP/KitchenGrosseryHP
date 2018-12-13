package com.example.lenovo.kitchengrossery;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recy_srp;

    int [] pic={R.drawable.chilli,R.drawable.ic_launcher_foreground,R.drawable.chilli,R.drawable.chilli};

    ArrayList<String> arrl;

    Vertadapt vadapt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recy_srp=(RecyclerView)findViewById(R.id.recyclerview);

        arrl=new ArrayList<>();
        arrl.add("Chilli ");
        arrl.add("Nuts");
        arrl.add("Cashew");
        arrl.add("Flour");
        vadapt=new Vertadapt(arrl);

        LinearLayoutManager lm=new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL,false);
        recy_srp.setHasFixedSize(true);

        recy_srp.setAdapter(vadapt);
        recy_srp.setLayoutManager(lm);
    }

    class Vertadapt extends RecyclerView.Adapter<Vertadapt.vh>
    {
        ArrayList<String> ar;

        Vertadapt(ArrayList<String> ar)
        {
            this.ar=arrl;
        }
        @NonNull
        @Override
        public vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
        {
            View VV= LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.listitem,viewGroup,false);
            return new vh(VV);
        }
        @Override
        public void onBindViewHolder(@NonNull vh vh, int i)
        {
            vh.im.setImageResource(pic[i]);
            vh.tv.setText(arrl.get(i));

        }

        @Override
        public int getItemCount() {
            return arrl.size();
        }
        class vh extends RecyclerView.ViewHolder
        {
            ImageView im;
            TextView tv;


            public vh(@NonNull View itemView)
            {
                super(itemView);

                im=itemView.findViewById(R.id.imageViewinlist);
                tv=itemView.findViewById(R.id.textViewinlist);
            }
        }
    }

}
