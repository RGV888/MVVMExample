package com.example.mvvmexample.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmexample.Models.Hit;
import com.example.mvvmexample.R;

import java.util.List;

public class StoryListAdapter extends RecyclerView.Adapter<StoryListAdapter.StoryViewHolder> {

    private List<Hit> storyList;
    private Context context;
    public StoryListAdapter(Context context,List<Hit> storyList){
        this.context=context;
        this.storyList=storyList;
    }

//    public void updateList(List<Hit> storyList){
//        this.storyList=storyList;
//        notifyDataSetChanged();
//    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.story_list_item,parent,false);

        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        Hit hit=storyList.get(position);

        try {
            holder.title.setText(hit.getTitle());
        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            holder.createdDate.setText(hit.getCreated_at());
        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return storyList==null?0:storyList.size();
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder{

        private TextView title,createdDate;
        private Switch counterSwitch;
        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            createdDate=itemView.findViewById(R.id.createdDate);
            counterSwitch=itemView.findViewById(R.id.counterSwitch);
        }
    }
}
