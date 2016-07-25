
package com.postnov.android.translate.data.source.translate.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Response {

    @SerializedName("def")
    @Expose
    private List<Def> def = new ArrayList<>();

    public List<Def> getDef() {
        return def;
    }

    public void setDef(List<Def> def) {
        this.def = def;
    }

    private static class Def {

        @SerializedName("text")
        @Expose
        private String text;

        @SerializedName("tr")
        @Expose
        private List<Translate> tr = new ArrayList<>();

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public List<Translate> getTr() {
            return tr;
        }

        public void setTr(List<Translate> tr) {
            this.tr = tr;
        }
    }

    private static class Translate {

        @SerializedName("text")
        @Expose
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
