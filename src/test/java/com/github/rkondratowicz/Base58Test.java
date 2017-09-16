package com.github.rkondratowicz;

import io.vavr.collection.List;
import org.junit.Test;

import static io.vavr.API.Tuple;
import static org.assertj.core.api.Assertions.assertThat;

public class Base58Test {

    @Test
    public void should_encode_and_decode() {
        List.of(
            Tuple(0L, "1"),
            Tuple(123456789L, "bUKpk")
        ).forEach(t -> {
            assertThat(Base58.encode(t._1)).as("encoding %d", t._1).isEqualTo(t._2);
            assertThat(Base58.decode(t._2)).as("decoding %s", t._2).isEqualTo(t._1);
        });
    }
}
