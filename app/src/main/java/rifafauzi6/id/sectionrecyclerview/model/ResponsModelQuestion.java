package rifafauzi6.id.sectionrecyclerview.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsModelQuestion {

    @SerializedName("kode")
    private String kode;

    @SerializedName("pesan")
    private String pesan;

    @SerializedName("result")
    private List<Question> result;

    public String getKode() {
        return kode;
    }

    public List<Question> getResult() {
        return result;
    }

}