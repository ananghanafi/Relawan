package com.tetracreasoft.relawan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

public class InputActivity extends AppCompatActivity {
    DatabaseReference namaCaleg;
    EditText nama, kabupaten, kecamatan, desa, tps, caleg, suara, sah, tidaksah, jmlPemilih;
    String time;
    Button kirim;
    String str_nama, str_kabupaten, str_kecamatan, str_desa, str_tps, str_suara, str_suaraSah, str_suaraTdkSah,
            str_jmlPemilih, str_caleg, str_id, str_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        nama = (EditText) findViewById(R.id.nama);
        kabupaten = (EditText) findViewById(R.id.kabupaten);
        kecamatan = (EditText) findViewById(R.id.kecamatan);
        desa = (EditText) findViewById(R.id.desa);
        tps = (EditText) findViewById(R.id.tps);
        suara = (EditText) findViewById(R.id.suaraSaya);
        sah = (EditText) findViewById(R.id.suaraSah);
        tidaksah = (EditText) findViewById(R.id.suaratdksah);
        jmlPemilih = (EditText) findViewById(R.id.jmlpilih);
        namaCaleg = FirebaseDatabase.getInstance().getReference("namaCalegCoba");
        kirim = (Button) findViewById(R.id.btKirim);
        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDatabase();
            }
        });


    }

    public void saveDatabase() {
        //Tidak Boleh Kosong
        str_nama = nama.getText().toString();
        str_kabupaten = kabupaten.getText().toString();
        str_kecamatan = kecamatan.getText().toString();
        str_desa = desa.getText().toString();
        str_tps = tps.getText().toString();
        str_suara = suara.getText().toString();
        str_suaraSah = sah.getText().toString();
        str_suaraTdkSah = tidaksah.getText().toString();
        str_jmlPemilih = jmlPemilih.getText().toString();
        str_caleg = "Nama Caleg";
        //  String str_id = pemesanan.push().getKey();
        time = String.valueOf(ServerValue.TIMESTAMP);
        str_time = time;
        if (str_nama.isEmpty()) {
            nama.setError("Nama harus diisi");
            nama.requestFocus();
            return;
        } else if (str_kabupaten.isEmpty()) {
            kabupaten.setError("Kabupaten harus diisi");
            kabupaten.requestFocus();
            return;
        } else if (str_kecamatan.isEmpty()) {
            kecamatan.setError("Kecamatan harus diisi");
            kecamatan.requestFocus();
            return;
        } else if (str_desa.isEmpty()) {
            desa.setError("Desa harus diisi");
            desa.requestFocus();
            return;
        } else if (str_suara.isEmpty()) {
            suara.setError("Suara harus diisi");
            suara.requestFocus();
            return;
        } else if (str_suaraSah.isEmpty()) {
            sah.setError("Suara Sah harus diisi");
            sah.requestFocus();
            return;
        } else if (str_suaraTdkSah.isEmpty()) {
            tidaksah.setError("Suara tidak sah harus diisi");
            tidaksah.requestFocus();
            return;
        } else if (str_tps.isEmpty()) {
            tps.setError("TPS harus diisi");
            tps.requestFocus();
            return;
        } else if (str_jmlPemilih.isEmpty()) {
            jmlPemilih.setError("Jumlah Pemilih harus diisi");
            jmlPemilih.requestFocus();
            return;
        } else {
            AlertDialog.Builder alBuilder = new AlertDialog.Builder(InputActivity.this);
            alBuilder.setTitle("Konfirmasi Data");
            alBuilder.setMessage("Saya " + str_nama +
                    " dengan ini mengirimkan data suara caleg " + str_caleg + " sebanyak " + str_suara + " dengan jumlah pemilih sebanyak " +
                    "" + str_jmlPemilih + " suara sah " + str_suaraSah + " suara tidak sah " + str_suaraTdkSah +
                    " di masukkan dengan suara dengan yang sebenar-benarnya ").setCancelable(false)
                    .setPositiveButton("Ya, Kirim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            System.out.println("Pilihan Ya");
                            str_id = namaCaleg.push().getKey();
                            AmbilData input = new AmbilData(str_id, str_caleg, str_nama, str_kabupaten, str_kecamatan, str_desa,
                                    str_suara, str_suaraSah, str_suaraTdkSah, str_time, str_tps, str_jmlPemilih);
                            namaCaleg.child(str_id).setValue(input);
                            Toast.makeText(InputActivity.this, "Terkirim", Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("Tidak, Kirim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.cancel();
                }
            });
            AlertDialog alertDialog = alBuilder.create();
            alertDialog.show();
        }
    }
}