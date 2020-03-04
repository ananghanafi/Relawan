package com.tetracreasoft.relawan;

/**
 * Created by AnangHanafi on 02/11/2018.
 */

public class AmbilData {
    String id;
    String caleg;
    String nama;
    String kabupaten;
    String kecamatan;
    String desa;
    String suara;
    String sah;
    String tidaksah;
    String time;
    String tps;
    String jmlPemilih;

    public AmbilData(String id, String caleg, String nama, String kabupaten, String kecamatan, String desa, String suara, String sah, String tidaksah, String time,
                     String tps, String jmlPemilih) {
        this.id = id;
        this.caleg = caleg;
        this.nama = nama;
        this.kabupaten = kabupaten;
        this.kecamatan = kecamatan;
        this.desa = desa;
        this.suara = suara;
        this.sah = sah;
        this.tidaksah = tidaksah;
        this.time = time;
        this.tps = tps;
        this.jmlPemilih = jmlPemilih;
    }

    public String getJmlPemilih() {
        return jmlPemilih;
    }

    public void setJmlPemilih(String jmlPemilih) {
        this.jmlPemilih = jmlPemilih;
    }


    public String getSuara() {
        return suara;
    }

    public void setSuara(String suara) {
        this.suara = suara;
    }

    public String getSah() {
        return sah;
    }

    public void setSah(String sah) {
        this.sah = sah;
    }

    public String getTidaksah() {
        return tidaksah;
    }

    public void setTidaksah(String tidaksah) {
        this.tidaksah = tidaksah;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaleg() {
        return caleg;
    }

    public void setCaleg(String caleg) {
        this.caleg = caleg;
    }

    public String getTime() {
        return time;
    }


    public void setTime(String time) {
        this.time = time;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getDesa() {
        return desa;
    }

    public void setDesa(String desa) {
        this.desa = desa;
    }

    public String getTps() {
        return tps;
    }

    public void setTps(String tps) {
        this.tps = tps;
    }


}
