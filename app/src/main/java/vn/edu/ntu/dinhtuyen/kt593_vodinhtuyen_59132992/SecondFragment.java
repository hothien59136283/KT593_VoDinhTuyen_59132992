package vn.edu.ntu.dinhtuyen.kt593_vodinhtuyen_59132992;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.ntu.dinhtuyen.controller.ISinhVienController;
import vn.edu.ntu.dinhtuyen.model.SinhVien;

public class SecondFragment extends Fragment {

    RecyclerView rvListMH;
    NavController navController;
    List<SinhVien> sinhViens;
    SinhVienAdapter adapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        Context context = getActivity();
        rvListMH = view.findViewById(R.id.rvListMH);
        rvListMH.setLayoutManager(new LinearLayoutManager(context));
        ISinhVienController controller = (ISinhVienController) getActivity().getApplication();
        sinhViens = controller.getAll();
        adapter = new SinhVienAdapter(sinhViens);
        rvListMH.setAdapter(adapter);
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = NavHostFragment.findNavController(SecondFragment.this);
        ((MainActivity) getActivity()).navController = navController;
    }

    private class SinhVienViewHolder extends RecyclerView.ViewHolder {

        TextView txtHoTen, txtThongTin, txtGioHoc, txtGio;

        public SinhVienViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHoTen = this.itemView.findViewById(R.id.txtHoTen);
            txtThongTin = this.itemView.findViewById(R.id.txtThongTin);
            txtGioHoc = this.itemView.findViewById(R.id.txtGioHoc);
            txtGio = this.itemView.findViewById(R.id.txtGio);
        }

        public void bind(SinhVien sinhVien) {
            txtHoTen.setText("Tên: " + sinhVien.getHoTen());
            txtThongTin.setText("Ngày sinh: " + sinhVien.getNgaySinh() + "  Số điện thoại: " + sinhVien.getSdt());
            txtGioHoc.setText("Giờ học: " + sinhVien.getGioHoc());
            txtGio.setText("Giờ: " + sinhVien.getGio());

        }
    }

    private class SinhVienAdapter extends RecyclerView.Adapter<SinhVienViewHolder> {

        List<SinhVien> sinhViens;

        public SinhVienAdapter(List<SinhVien> sinhViens) {
            this.sinhViens = sinhViens;
        }

        @NonNull
        @Override
        public SinhVienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.sinhvien_item, parent, false);
            return new SinhVienViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SinhVienViewHolder holder, int position) {
            holder.bind(sinhViens.get(position));
        }

        @Override
        public int getItemCount() {
            return sinhViens.size();
        }
    }
}
