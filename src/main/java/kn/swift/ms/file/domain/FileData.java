package kn.swift.ms.file.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Minal.Fulzele on 17/08/2017.
 */
public class FileData implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
