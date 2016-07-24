
package com.postnov.android.translate.data.entity;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("def")
    @Expose
    private List<Def> def = new ArrayList<>();


    /**
     * 
     * @return
     *     The def
     */
    public List<Def> getDef() {
        return def;
    }

    /**
     * 
     * @param def
     *     The def
     */
    public void setDef(List<Def> def) {
        this.def = def;
    }

}
