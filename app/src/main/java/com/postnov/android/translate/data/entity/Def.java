
package com.postnov.android.translate.data.entity;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Def {

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("tr")
    @Expose
    private List<Translate> tr = new ArrayList<>();

    /**
     * 
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 
     * @return
     *     The tr
     */
    public List<Translate> getTr() {
        return tr;
    }

    /**
     * 
     * @param tr
     *     The tr
     */
    public void setTr(List<Translate> tr) {
        this.tr = tr;
    }

}
