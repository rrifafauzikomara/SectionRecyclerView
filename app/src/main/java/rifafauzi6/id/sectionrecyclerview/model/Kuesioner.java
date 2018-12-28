package rifafauzi6.id.sectionrecyclerview.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kuesioner {

    @SerializedName("npm")
    @Expose
    private String npm;

    @SerializedName("nik")
    @Expose
    private String nik;

    @SerializedName("kd_matkul")
    @Expose
    private String kd_matkul;

    @SerializedName("kd_kuesioner")
    @Expose
    private String kd_kuesioner;

    @SerializedName("variabel")
    @Expose
    private String variabel;

    @SerializedName("created_by")
    @Expose
    private String created_by;

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getKd_matkul() {
        return kd_matkul;
    }

    public void setKd_matkul(String kd_matkul) {
        this.kd_matkul = kd_matkul;
    }

    public String getKd_kuesioner() {
        return kd_kuesioner;
    }

    public void setKd_kuesioner(String kd_kuesioner) {
        this.kd_kuesioner = kd_kuesioner;
    }

    public String getVariabel() {
        return variabel;
    }

    public void setVariabel(String variabel) {
        this.variabel = variabel;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
