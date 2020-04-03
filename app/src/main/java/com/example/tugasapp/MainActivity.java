package com.example.tugasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextInputEditText namaDpn, namaBlkg, tempatLhr, tglLahir, alamat, telfon, email ,pass1, pass2;
    RadioGroup rgSex, rgAgama;
    RadioButton sexL, sexP;
    RadioButton agama1, agama2, agama3, agama4, agama5, agama6, agama7;
    TextView hasil;
    String namaDe, namaBe, TLahir, tglLahirr, alamaat, sexx, agamaa, notelfon, emaiil;
    Calendar myCalendar;
    Button daftar, kembali, keluar, oke;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCalendar = Calendar.getInstance();

        namaDpn = (TextInputEditText ) findViewById(R.id.editFN);
        namaBlkg = (TextInputEditText ) findViewById(R.id.editLN);
        tempatLhr = (TextInputEditText ) findViewById(R.id.editTL);
        tglLahir = (TextInputEditText ) findViewById(R.id.editTTL);
        alamat = (TextInputEditText ) findViewById(R.id.editAlamat);
        sexL = (RadioButton) findViewById(R.id.radioMale);
        sexP = (RadioButton) findViewById(R.id.radioFemale);
        agama1  = (RadioButton) findViewById(R.id.islam);
        agama2 = (RadioButton) findViewById(R.id.kristen);
        agama3  = (RadioButton) findViewById(R.id.kat);
        agama4 = (RadioButton) findViewById(R.id.hin);
        agama5  = (RadioButton) findViewById(R.id.bd);
        agama6 = (RadioButton) findViewById(R.id.kong);
        agama7  = (RadioButton) findViewById(R.id.aliran);
        telfon = (TextInputEditText ) findViewById(R.id.editTelp);
        email = (TextInputEditText ) findViewById(R.id.editEmail);
//        pass1 = (TextInputEditText) findViewById(R.id.editPass);
//        pass2 = (TextInputEditText ) findViewById(R.id.editPass2);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int  dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        tglLahir.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    new DatePickerDialog(MainActivity.this, date,
                            myCalendar.get(Calendar.YEAR),
                            myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
                return true;
            }
        });

        daftar = (Button) findViewById(R.id.daftar_btn);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil  = (TextView) findViewById(R.id.txt_hasil);

                namaDe = namaDpn.getText().toString();
                namaBe = namaBlkg.getText().toString();
                TLahir = tempatLhr.getText().toString();
                tglLahirr = tglLahir.getText().toString();
                alamaat = alamat.getText().toString();
//                sexx = sexP.getText().toString();
//                agamaa = agama1.getText().toString();
                notelfon = telfon.getText().toString();
                emaiil = email.getText().toString();

//                hasil.setText(namaDe+namaBe+TLahir+tglLahirr+alamaat+notelfon+emaiil);
                showDialog2();

            }
        });
    }

    private void updateLabel(){
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        // edittext.setText(sdf.format(myCalendar.getTime()));
        tglLahir.setText(sdf.format(myCalendar.getTime()));
    }

//    private void showDialog(){
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
//                this);
//
//        // set title dialog
//        alertDialogBuilder.setTitle("Konfirmasi");
//
//        // set pesan dari dialog
//        alertDialogBuilder
//                .setMessage("Apakah Data yang anda masukkan sudah benar ?")
//                .setIcon(R.mipmap.ic_launcher)
//                .setCancelable(false)
//                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog,int id) {
//                        showDialog2();
//                    }
//                })
//                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                });
//
//        // membuat alert dialog dari builder
//        AlertDialog alertDialog = alertDialogBuilder.create();
//
//        // menampilkan alert dialog
//        alertDialog.show();
//    }
//
    private void showDialog2(){

        dialog = new AlertDialog.Builder(MainActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.hasil, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Detail Pendaftaran");

        hasil  = (TextView) findViewById(R.id.txt_hasil);

        hasil.setText(namaDe+namaBe+TLahir+tglLahirr+alamaat+notelfon+emaiil);

        oke = (Button) findViewById(R.id.oke_btn);
        oke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });

        keluar = (Button) findViewById(R.id.keluar_btn);
        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}
