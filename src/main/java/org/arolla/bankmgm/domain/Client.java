package org.arolla.bankmgm.domain;

import java.time.OffsetDateTime;
import java.util.Date;

/**
 * Created by aminebechraoui, on 12/01/2021, in org.arolla.bankmgm
 */
public class Client {
    private String name;
    private String lastName;
    private OffsetDateTime birthDate;

    public Client(String name, String lastName, OffsetDateTime birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public OffsetDateTime getBirthDate() {
        return birthDate;
    }
}
