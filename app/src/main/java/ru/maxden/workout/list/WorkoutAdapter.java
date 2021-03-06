package ru.maxden.workout.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ru.maxden.workout.Model.Workout;
import ru.maxden.workout.Model.WorkoutList;
import ru.maxden.workout.R;
import ru.maxden.workout.interfaces.OnListItemClickListener;


/**
 * Created by maksim_de on 08.11.2018.
 */

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutViewHolder> {
    private List<Workout> workoutList = WorkoutList.getInstance().getWorkouts();
    private OnListItemClickListener itemClickListener;

    public WorkoutAdapter(OnListItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.list_item,
                viewGroup,
                false
        );
        return new WorkoutViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder workoutViewHolder, int index) {
        workoutViewHolder.bindView(workoutList.get(index), index, itemClickListener);
    }

    @Override
    public int getItemCount() {
        return workoutList != null ? workoutList.size() : 0;
    }

    public void addWorkout(Workout workout) {
        this.workoutList.add(workout);
    }
}