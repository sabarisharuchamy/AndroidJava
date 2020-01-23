package com.appin.javaexamples;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.myViewHolder> {
    Context context;
    List<String> mData;
    int index = -1;
    private SparseBooleanArray selectedItems = new SparseBooleanArray();
    public JsonExtractAdapter jsonExtractAdapter;
    public MyRecyclerAdapter(Context context, List<String> data) {
        this.context = context;
        this.mData = data;
    }

    @Override
    public MyRecyclerAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRecyclerAdapter.myViewHolder holder, final int position) {
        holder.country.setText(mData.get(position));
        holder.relativeLayout.setOnClickListener(holder);
        //Code for single item selection and color change
        /*holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = position;
                notifyDataSetChanged();
            }
        });

        if(index==position){
            holder.relativeLayout.setBackgroundColor(Color.parseColor("#FF4081"));
            holder.country.setTextColor(Color.parseColor("#FFFFFF"));
        }else{
            holder.relativeLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.country.setTextColor(Color.parseColor("#000000"));
        }*/

        String strJson="{ \"Employee\" :[{\"id\":\"101\",\"name\":\"Sonoo Jaiswal\",\"salary\":\"50000\"},{\"id\":\"102\",\"name\":\"Vimal Jaiswal\",\"salary\":\"60000\"}] }";

        String data = "";
        try {
            // Create the root JSONObject from the JSON string.
            JSONObject  jsonRootObject = new JSONObject(strJson);

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.optJSONArray("Employee");

            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id = Integer.parseInt(jsonObject.optString("id").toString());
                String name = jsonObject.optString("name").toString();
                float salary = Float.parseFloat(jsonObject.optString("salary").toString());

                data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n ";
                jsonExtractAdapter = new JsonArrayFromAdapter();
                jsonExtractAdapter.dispJson(data);
            }
        } catch (JSONException e) {e.printStackTrace();}
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        RelativeLayout relativeLayout;
        TextView country;

        public myViewHolder(View itemView) {
            super(itemView);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
            country = (TextView) itemView.findViewById(R.id.country);
        }

        @Override
        public void onClick(View view) {
            if (selectedItems.get(getAdapterPosition(), false)) {
                selectedItems.delete(getAdapterPosition());
                view.setSelected(false);
            }
            else {
                selectedItems.put(getAdapterPosition(), true);
                view.setSelected(true);
            }
        }
    }

}
