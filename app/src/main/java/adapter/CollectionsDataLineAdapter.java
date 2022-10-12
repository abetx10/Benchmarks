package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.benchmarks.R;
import java.util.ArrayList;

public class CollectionsDataLineAdapter extends RecyclerView.Adapter<CollectionsDataLineAdapter.CollectionsViewHolder> {
    ArrayList<TimeData> timeDataArrayList;
    Context context;

    public CollectionsDataLineAdapter(Context context, ArrayList<TimeData> timeDataArrayList) {
        this.context = context;
        this.timeDataArrayList = timeDataArrayList;
    }

    @NonNull
    @Override
    public CollectionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.data_line_item, parent, false);
        return new CollectionsViewHolder(view);
    }

//    @Override
//    public void onBindViewHolder(@NonNull CollectionsViewHolder holder, int position) {
//        TimeData timeData = timeDataArrayList.get(position);
//        holder.titleTv.setText(timeData.title);
//        holder.arrayListItemTv.setText(timeData.timeArrayList);
//    }

    @Override
    public void onBindViewHolder(@NonNull CollectionsViewHolder holder, int position) {
        TimeData timeData = timeDataArrayList.get(position);
        holder.titleTv.setText(timeData.title);
//        if(timeData.timeArrayList.equals("0")){
//            holder.arrayListItemTv.setText("N/A");
//        } else {
//            holder.arrayListItemTv.setText(timeData.timeArrayList);
//        }

        if(timeData.state.equals("ready")) {
            holder.item1Pb.setVisibility(View.GONE);
            holder.arrayListItemTv.setVisibility(View.VISIBLE);
            if(timeData.timeArrayList.equals("0")) {
                holder.arrayListItemTv.setText("N/A");
            } else {
                holder.arrayListItemTv.setText(timeData.timeArrayList);
            }
        } else if(timeData.state.equals("progress")){
            holder.arrayListItemTv.setVisibility(View.GONE);
            holder.item1Pb.setVisibility(View.VISIBLE);
        }

//        if (timeData.state.equals("progress")) {
//            holder.arrayListItemTv.setVisibility(View.GONE);
//            holder.item1Pb.setVisibility(View.VISIBLE);
//        }
    }

    @Override
    public int getItemCount() {
        return timeDataArrayList.size();
    }

    public static class CollectionsViewHolder extends RecyclerView.ViewHolder{
        TextView titleTv;
        TextView arrayListItemTv;
        ProgressBar item1Pb;

        public CollectionsViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.tv_title);
            arrayListItemTv = itemView.findViewById(R.id.tv_item_Array);
            item1Pb = itemView.findViewById(R.id.pb_item1);
        }
    }
}
