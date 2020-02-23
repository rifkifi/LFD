package com.rifkifi.lfd.models;

public class Praktikan {
    private int noBP;
    private String password;
    private String nama;
    private String tanggalLahir;
    private String tempatLahir;
    private String imgUrl;
    private String kodeKelas;
    private String kodeKelompok;
    private String kodeJurusan;

    public Praktikan(int noBP, String password, String nama, String tanggalLahir, String tempatLahir, String imgUrl, String kodeKelas, String kodeKelompok, String kodeJurusan) {
        this.noBP = noBP;
        this.password = password;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.tempatLahir = tempatLahir;
        this.imgUrl = imgUrl;
        this.kodeKelas = kodeKelas;
        this.kodeKelompok = kodeKelompok;
        this.kodeJurusan = kodeJurusan;
    }

    public int getNoBP() {
        return noBP;
    }

    public String getNama() {
        return nama;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getKodeKelas() {
        return kodeKelas;
    }

    public String getKodeKelompok() {
        return kodeKelompok;
    }

    public String getKodeJurusan() {
        return kodeJurusan;
    }
}
