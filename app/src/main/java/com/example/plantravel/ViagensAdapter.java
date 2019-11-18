package com.example.plantravel;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViagensAdapter extends RecyclerView.Adapter<ViagensAdapter.MyViewHolder> {
    private String[] mDataset;
    private List<Viagens> dados;
    private Object Viagens;


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tview;
        public MyViewHolder(TextView v) {
            super(v);
            tview = v;
        }
    }
    // Construtor
    public ViagensAdapter(String[] myDataset){
        mDataset = myDataset;
    }

    //Novas views
    @Override
    public ViagensAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_new_travel,parent, false);
        MyViewHolder viewh= new MyViewHolder(v);
        return viewh;
    }

    //Modificar info da view
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        holder.tview.setText(List<Viagens>);
    }

    @Override
    public int getItemCount(){
        return mDataset.length;
    }


}
