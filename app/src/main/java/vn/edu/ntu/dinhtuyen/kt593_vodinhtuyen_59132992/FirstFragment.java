package vn.edu.ntu.dinhtuyen.kt593_vodinhtuyen_59132992;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Calendar;

import vn.edu.ntu.dinhtuyen.controller.ISinhVienController;
import vn.edu.ntu.dinhtuyen.model.SinhVien;

import static java.util.Calendar.HOUR_OF_DAY;

public class FirstFragment extends Fragment {


    TextView textView;
    EditText edtten;
    TextView textView2;
    EditText edtngay;
    ImageView imageView2;
    EditText edtgio;
    ImageView imageView3;
    TextView textView4;
    EditText edtsdt;
    TextView textView5;
    EditText edtdiachi;
    TextView textView6;
    RadioButton rdbSang;
    RadioButton rdgChieu;
    RadioButton rdgToi;
    RadioGroup rdgGiohoc;
    TextView textView7;
    Spinner snpKhoahoc;
    Button btnDangky;
    NavController navController;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        addViews(view);

        // set spinner
        snpKhoahoc = view.findViewById(R.id.snpKhoahoc);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        snpKhoahoc.setAdapter(adapter);
        return view;
    }

    private void addViews(View view) {
        textView = view.findViewById(R.id.textView);
        edtten = view.findViewById(R.id.edtten);
        textView2 = view.findViewById(R.id.textView2);
        edtngay = view.findViewById(R.id.edtngay);
        imageView2 = view.findViewById(R.id.imageView2);
        edtgio = view.findViewById(R.id.edtgio);
        imageView3 = view.findViewById(R.id.imageView3);
        textView4 = view.findViewById(R.id.textView4);
        edtsdt = view.findViewById(R.id.edtsdt);
        textView5 = view.findViewById(R.id.textView5);
        edtdiachi = view.findViewById(R.id.edtdiachi);
        textView6 = view.findViewById(R.id.textView6);
        rdbSang = view.findViewById(R.id.rdbSang);
        rdgChieu = view.findViewById(R.id.rdgChieu);
        rdgToi = view.findViewById(R.id.rdgToi);
        rdgGiohoc = view.findViewById(R.id.rdgGiohoc);
        textView7 = view.findViewById(R.id.textView7);
        snpKhoahoc = view.findViewById(R.id.snpKhoahoc);
        btnDangky = view.findViewById(R.id.btnDangky);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(dayOfMonth)
                                .append("/")
                                .append(++month)
                                .append("/")
                                .append(year);
                        edtngay.setText(builder.toString());
                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        listener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();

                TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(hourOfDay)
                                .append(":")
                                .append(minute);
                        edtgio.setText(builder.toString());
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),time, calendar.get(HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
                timePickerDialog.show();
            }
        });
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themMonHoc();
                navController.navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        //nếu có 2 nút (Thêm, danh sách) thì giữ lại đoạn dưới
        /*btnDanhSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });*/

        navController = NavHostFragment.findNavController(this);
        ((MainActivity) getActivity()).navController = navController;
    }

    private void themMonHoc() {
        SinhVien sinhVien = new SinhVien();
        sinhVien.setHoTen(edtten.getText().toString());
        sinhVien.setNgaySinh(edtngay.getText().toString());
        sinhVien.setSdt(edtsdt.getText().toString());
        sinhVien.setDiaChi(edtdiachi.getText().toString());
        sinhVien.setGio(edtgio.getText().toString());

         //lấy giá trị trong spinner lưu vào model
        sinhVien.setKhoaHoc(snpKhoahoc.getSelectedItem().toString());

        // lấy giá trị từ radio button lưu vào model
        if (rdbSang.isChecked()) {
            sinhVien.setGioHoc("Sáng");
        } else if (rdgChieu.isChecked()) {
            sinhVien.setGioHoc("Chiều");
        } else {
            sinhVien.setGioHoc("Tối");
        }
        ISinhVienController controller = (ISinhVienController) getActivity().getApplication();
        controller.addToList(sinhVien);
    }

}
