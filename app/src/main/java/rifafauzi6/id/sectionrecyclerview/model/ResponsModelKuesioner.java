package rifafauzi6.id.sectionrecyclerview.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsModelKuesioner {

    @SerializedName("kode")
    private String kode;

    @SerializedName("pesan")
    private String pesan;

    @SerializedName("result")
    private List<Kuesioner> result;

    public String getKode() {
        return kode;
    }

    public String getPesan() {
        return pesan;
    }
}
