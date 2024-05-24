package server.model;

import java.util.Objects;

public class DragonHead {
    private Long toothCount; //Поле может быть null

    public DragonHead(Long toothCount) {
        this.toothCount = toothCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DragonHead that = (DragonHead) o;
        return Objects.equals(toothCount, that.toothCount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(toothCount);
    }

    @Override
    public String toString() {
        return "DragonHead{" +
                "toothCount=" + toothCount +
                '}';
    }
}
