package ca.newfactory.havework.DashboardFragmentFolder;


import android.graphics.Work;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ca.newfactory.havework.R;

public class DashboardFragment_Adapter__Work  extends RecyclerView.Adapter<DashboardFragment_Adapter__Work.WorkViewHolder> {

    private final List<DashboardFragment__Work> works;
    private final Listener onWorkClickListener;

    public DashboardFragment_Adapter__Work(List<DashboardFragment__Work> work, Listener onWorkClickListener) {
        this.works = work;
        this.onWorkClickListener = onWorkClickListener;
    }

    @NonNull
    @Override
    public WorkViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_dashboard_work_item, viewGroup, false);
        view.setOnClickListener(v -> onWorkClickListener.onWorkClick((DashboardFragment__Work) v.getTag()));
        return new WorkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkViewHolder viewHolder, final int i) {
        DashboardFragment__Work movie = works.get(i);
        viewHolder.bind(work);
        viewHolder.itemView.setTag(movie);
    }

    @Override
    public int getItemCount() {
        return works.size();
    }

    static final class WorkViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameTextView;
        private final TextView descriptionTextView;
        private final ImageView imageImageView;

        private WorkViewHolder (@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.movie_item__tv_name);
            descriptionTextView = itemView.findViewById(R.id.movie_item__tv_description);
            posterImageView = itemView.findViewById(R.id.movie_item__iv_poster);
        }

        private void bind(@NonNull DashboardFragment__Work work) {
            nameTextView.setText(DashboardFragment__Work.name);
            descriptionTextView.setText(DashboardFragment__Work.description);
            imageImageView.setImageResource(DashboardFragment__Work.image);
        }

    }

    interface Listener {

        void onWorkClick(DashboardFragment__Work work);

    }

}