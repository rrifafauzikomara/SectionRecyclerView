package rifafauzi6.id.sectionrecyclerview.model;

import com.google.gson.annotations.SerializedName;

public class Question {

    @SerializedName("kd_pertanyaan")
    private String kd_pertanyaan;

    @SerializedName("kd_kuesioner")
    private String kd_kuesioner;

    @SerializedName("no")
    private String no;

    @SerializedName("nm_kuesioner")
    private String pertanyaan;

    public String getKd_pertanyaan() {
        return kd_pertanyaan;
    }

    public void setKd_pertanyaan(String kd_pertanyaan) {
        this.kd_pertanyaan = kd_pertanyaan;
    }

    public String getKd_kuesioner() {
        return kd_kuesioner;
    }

    public void setKd_kuesioner(String kd_kuesioner) {
        this.kd_kuesioner = kd_kuesioner;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

}
