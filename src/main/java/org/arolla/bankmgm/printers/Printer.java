package org.arolla.bankmgm.printers;

/**
 * Created by aminebechraoui, on 13/01/2021, in org.arolla.bankmgm.printers
 */
public interface Printer<T> {
    static final String PRINTING_PATTERN = "%s      \t#            %s            #      %s";

    void print(T toPrint);
}
