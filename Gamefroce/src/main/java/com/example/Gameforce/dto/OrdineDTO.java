package com.example.Gameforce.dto;

import java.sql.Timestamp;

public class OrdineDTO extends AuditableDTO{

    private int codiceOrdine;
    private Timestamp dataOrdine;

    public int getCodiceOrdine() {
        return codiceOrdine;
    }

    public void setCodiceOrdine(int codiceOrdine) {
        this.codiceOrdine = codiceOrdine;
    }

    public Timestamp getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(Timestamp dataOrdine) {
        this.dataOrdine = dataOrdine;
    }
}
