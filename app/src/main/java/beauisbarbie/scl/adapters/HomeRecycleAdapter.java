package beauisbarbie.scl.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import beauisbarbie.scl.R;
import beauisbarbie.scl.RegisterActivity;
import beauisbarbie.scl.StartActivity;
import beauisbarbie.scl.ViewHomeActivity;
import beauisbarbie.scl.interfaces.HomeItemClick;

/**
 * Created by beauisbarbie on 21/3/2018 AD.
 */
class HomeRecycleviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

    public TextView tex_description;


    private HomeItemClick homeItemClick;

    public HomeRecycleviewHolder(View itemView) {
        super(itemView);
        tex_description = (TextView)itemView.findViewById(R.id.textDescription);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setHomeItemClick (HomeItemClick homeItemClick){

        this.homeItemClick = homeItemClick;

    }

    @Override
    public void onClick(View v) {
        homeItemClick.onClick(v,getAdapterPosition(),false);

    }

    @Override
    public boolean onLongClick(View v) {
        homeItemClick.onClick(v,getAdapterPosition(),true);
        return true;
    }
}
public class HomeRecycleAdapter extends RecyclerView.Adapter<HomeRecycleviewHolder> {

    private List<String> listData = new ArrayList<>();
    private Context context;

    public HomeRecycleAdapter(List<String> listData, Context context){
        this.listData = listData;
        this.context = context;
    }

    @Override
    public HomeRecycleviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item_recycleview,parent,false);

        return new HomeRecycleviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HomeRecycleviewHolder holder, int position) {


        holder.tex_description.setText(listData.get(position));

        holder.setHomeItemClick(new HomeItemClick() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick)
                    Toast.makeText(context, "Long click: "+listData.get(position), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context, " "+listData.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {

        return listData.size();
    }
}
