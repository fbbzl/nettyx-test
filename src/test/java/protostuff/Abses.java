package protostuff;

import io.protostuff.Tag;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Abses<T> {
    @Tag(1)
    T       fffff;
    @Tag(2)
    T age;
    @Tag(3)
    long    age1;
    @Tag(4)
    String  name1;
    @Tag(5)
    byte    age11;
    @Tag(6)
    long    name11;
    @Tag(7)
    int     age191;
    @Tag(8)
    long    name119;
    @Tag(9)
    int     age1291;
    @Tag(10)
    char    name19;
    @Tag(11)
    byte    age12;
    @Tag(12)
    long    name12;
    @Tag(13)
    boolean age123;
    @Tag(14)
    int     name132;
    @Tag(15)
    byte    name2132;
    @Tag(16)
    int     namfe132;
    @Tag(17)
    String  na4me132;


    @Data
    public static class XX {
        @Tag(1)
        String na4me132;
    }
}