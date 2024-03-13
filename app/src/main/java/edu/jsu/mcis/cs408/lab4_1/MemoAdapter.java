package edu.jsu.mcis.cs408.lab4_1;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.jsu.mcis.cs408.lab4_1.databinding.MemoItemBinding;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.MemoViewHolder> {

    private Cursor cursor;

    public void swapCursor(Cursor newCursor) {
        if (cursor != null) {
            cursor.close();
        }
        cursor = newCursor;
        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public MemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MemoItemBinding binding = MemoItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MemoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MemoViewHolder holder, int position) {
        if (cursor != null && cursor.moveToPosition(position)) {
            int columnIndex = cursor.getColumnIndex(MemoContract.MemoEntry.COLUMN_TEXT);
            if (columnIndex != -1) {
                String memoText = cursor.getString(columnIndex);
                holder.bind(memoText);
            } else {
                holder.bind("Memo not found");
            }
        }
    }

    @Override
    public int getItemCount() {
        return cursor == null ? 0 : cursor.getCount();
    }

    static class MemoViewHolder extends RecyclerView.ViewHolder {
        private final MemoItemBinding binding;

        MemoViewHolder(MemoItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(String memoText) {
            binding.textViewMemo.setText(memoText);
        }
    }
}


